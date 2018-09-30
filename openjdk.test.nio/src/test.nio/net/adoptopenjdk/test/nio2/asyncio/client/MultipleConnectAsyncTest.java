/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.nio2.asyncio.client;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.CompletionHandler;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import net.adoptopenjdk.test.nio2.util.AssertionFailedException;
import net.adoptopenjdk.test.nio2.util.AsyncTestState;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.ServerFactory.ServerType;

/**
 *  This test makes a single connection attempt to the server using the
 *   CompletetionHandler mechanism
 */

public class MultipleConnectAsyncTest extends AClient{
	public static String id = "net.adoptopenjdk.nio2.asyncio.client.MultipleConnectAsyncTest";
	private static final int MAX_CONNECTIONS = 10;
	private int numberOfConnections;
	
	public MultipleConnectAsyncTest() {
		super(ServerType.ECHO);	// Sets up ports etc..
		numberOfConnections = random.nextInt(MAX_CONNECTIONS) + 1;
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		HangNotifier.ping();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	@Override
	// Set the timeout allowed for this particular test
	protected long getTimeout() {
		return 5*60*1000;
	}
	
	// These are effectively concurrent connections, as they are asynchronous.
	// It was just as easy to start them all off, and wait for them all to finish,
	//  than do one at a time in a loop, with only a little added complexity.
	public void testMultipleSequentialConnect() throws IOException, InterruptedException, ExecutionException{
		assertNotNull("Server address was null, unable to start test", serverAddress);	
		List<AsyncTestState> testStates = new LinkedList<AsyncTestState>();	
		System.out.println("MultipleConnectAsyncTest.testMultipleSequentialConnect() creating " +
				numberOfConnections + " connections");
		
		for (int counter = 0; counter < numberOfConnections; counter++) {		
			HangNotifier.ping();
			final AsynchronousSocketChannel serverConnectionChannel;
			serverConnectionChannel = AsynchronousSocketChannel.open();
			assertTrue(serverConnectionChannel.isOpen());
			final AsyncTestState testState = new AsyncTestState();
			testState.socketChannel = serverConnectionChannel;
			testStates.add(testState);

			serverConnectionChannel.connect(serverAddress,
					testState, new CompletionHandler<Void, AsyncTestState>() {
				@Override
				public void completed(Void result, AsyncTestState attachment) {
					// Assert channel is open
					if (!serverConnectionChannel.isOpen()) {
						attachment.failedAssertions.addException(
								new AssertionFailedException("Channel was not open after completed connection"));
					}
					
					// Assert we are connected and can get the remote address
					try {
						SocketAddress remoteAddress = serverConnectionChannel.getRemoteAddress();
						if (remoteAddress == null) {
							attachment.failedAssertions.addException(
									new AssertionFailedException("Remote addresse was null"));
						}
					} catch (Exception e) {
						attachment.failedAssertions.addException(
							new AssertionFailedException(e));
					}
					
					// Close the channel, catching any exception as there should not be any
					try {
						serverConnectionChannel.close();
					} catch (IOException e) {
						attachment.failedAssertions.addException(
								new AssertionFailedException(e));
					}
					
					// Assert the channel is closed
					if (serverConnectionChannel.isOpen()) {
						attachment.failedAssertions.addException(
								new AssertionFailedException("Channel was not closed successfully"));
					}
					
					attachment.complete = true;					
				}
	
				@Override
				public void failed(Throwable exc, AsyncTestState attachment) {
					attachment.failedAssertions.addException(
							new AssertionFailedException(exc));
					attachment.complete = true;							
				}				
			});
			
			// We can't hammer the server continuously, or we'll run out of resource.
			// Sleep before the test claims completion
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}		
		}
		
		// Wait for all of the clients to be started
		while (testStates.size() != numberOfConnections) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
		
		boolean stillWaiting = true;
		
		while (stillWaiting) {
			int complete = 0;		
			for (AsyncTestState testState: testStates) {
				if (testState.complete == false && hasTimedOut(testState.startedAt)) {
					// Add the exception to note failure, and set as complete
					testState.failedAssertions.addException(
							new TimeoutException("Test took longer than the specified timeout ("  +getTimeout()+ ") to complete"));
					testState.complete = true;
					
					// Cleanup the channel if it is still open
					try {
						testState.socketChannel.close();
					} catch (ClosedChannelException e) {
						// If it's closed, it's closed.
					} catch (Exception e) {
						// We are, however, bothered about exceptions
						testState.failedAssertions.addException(e);
					}
				}

				// See how many have completed
				if (testState.complete) {
					complete++;
				}
			}
					
			if (complete == numberOfConnections) {
				stillWaiting = false;
			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}
		
		List<String> exceptionMessages = new LinkedList<String>();
		for (AsyncTestState testState: testStates) {
			if (testState.failedAssertions.getNumberOfExceptions() > 0) {
				exceptionMessages.add(testState.failedAssertions.getExceptionMessages());
			}
		}
		
		if (exceptionMessages.size() > 0) {
			fail(exceptionMessages.toString());
		}		
	}
	
	// Test a single connection. This is kept here (rather than incorporating it into the
	// multi section) for ease of readability, so anyone new to it can see what is going on.
	public void testSingleConnect() throws IOException, InterruptedException, ExecutionException{		
		assertNotNull("Server address was null, unable to start test", serverAddress);
		final AsynchronousSocketChannel serverConnectionChannel;
		serverConnectionChannel = AsynchronousSocketChannel.open(); 
		serverConnectionChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
		assertTrue(serverConnectionChannel.isOpen());	
		final AsyncTestState testState = new AsyncTestState();

		serverConnectionChannel.connect(serverAddress,
				testState, new CompletionHandler<Void, AsyncTestState>() {

			@Override
			public void completed(Void result, AsyncTestState attachment) {
				// Connected, now disconnect
				
				// Assert channel is open
				if (!serverConnectionChannel.isOpen()) {
					attachment.failedAssertions.addException(
							new AssertionFailedException("Channel was not open after completed connection"));
				}
				
				// Assert we are connected and can get the remote address
				try {
					SocketAddress remoteAddress = serverConnectionChannel.getRemoteAddress();
					if (remoteAddress == null) {
						attachment.failedAssertions.addException(
								new AssertionFailedException("Remote addresse was null"));
					}
				} catch (Exception e) {
					attachment.failedAssertions.addException(
						new AssertionFailedException(e));
				}
				
				// Close the channel, catching any exception as there should not be any
				try {
					serverConnectionChannel.close();
				} catch (IOException e) {
					attachment.failedAssertions.addException(
							new AssertionFailedException(e));
				}
				
				// Assert the channel is closed
				if (serverConnectionChannel.isOpen()) {
					attachment.failedAssertions.addException(
							new AssertionFailedException("Channel was not closed successfully"));
				}				
				attachment.complete = true;				
			}

			@Override
			public void failed(Throwable exc, AsyncTestState attachment) {
				attachment.failedAssertions.addException(
						new AssertionFailedException(exc));
				attachment.complete = true;							
			}
		});
		
		// Loop whilst we wait for the async code to report back that it has finished
		while (testState.complete == false) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { }
			
			// Check for timeout
			if (hasTimedOut(testState.startedAt)) {				
				// We have failed				
				testState.failedAssertions.addException(
					new TimeoutException("Test took longer than the specified timeout ("  +getTimeout()+ ") to complete"));
				testState.complete = true;
				
				// Cleanup the channel if it is still open
				try {
					testState.socketChannel.close();
				} catch (ClosedChannelException e) {
					// If it's closed, it's closed.
				} catch (Exception e) {
					// We are, however, bothered about exceptions
					testState.failedAssertions.addException(e);
				}
			}			
		}
		
		// We can't 'fail()' in the CompletionHandler as it is in another thread.
		if (testState.failedAssertions.hasExceptions()) {
			fail(testState.failedAssertions.getExceptionMessages());
		}
	}	
}