/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.nio2.asyncio.client;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.ServerFactory.ServerType;

/**
 *  This test makes a single connection attempt to the server using the
 *   Future mechanism
 */
public class MultipleConnectFutureTest extends AClient{

	public static String id = "net.adoptopenjdk.nio2.asyncio.client.MultipleConnectFutureTest";
	
	private static final int MAX_CONNECTIONS = 10;
	private int numberOfConnections;
	
	public MultipleConnectFutureTest() {
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
	
	// Concurrent connections are handled by way of running this test multiple times in parallel.
	//  By connecting multiple times we also increase the chance of overlap, and increase the 
	//  contention for handler threads which the server is using,
	public void testMultipleConnectSequential() throws IOException, ExecutionException, InterruptedException, TimeoutException {
		assertNotNull(serverAddress);
		System.out.println("MultipleConnectFutureTest.testMultipleConnectSequential() creating " +
				numberOfConnections + " connections");
		for (int counter = 0; counter < numberOfConnections; counter++) {
			HangNotifier.ping();
			AsynchronousSocketChannel serverConnectionChannel = null;
			try {
				serverConnectionChannel = AsynchronousSocketChannel.open();
				serverConnectionChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
				
				// Ensure we have have returned an open connection
				assertNotNull(serverConnectionChannel);
				assertTrue("Channel is not open on iteration " + counter, serverConnectionChannel.isOpen());
		
				// Blocking connect
				Future<Void> future = serverConnectionChannel.connect(serverAddress);
				future.get(getTimeout(), TimeUnit.MILLISECONDS);
				
				// Ensure we are connected
				assertNotNull("Unable to get remote address on iteration " + counter, serverConnectionChannel.getRemoteAddress());
			} finally {
				if (serverConnectionChannel != null) {
					try {
						serverConnectionChannel.close();
					} catch (ClosedChannelException cce) {
						// That's ok
					} catch (IOException ioe) {
						throw ioe;
					}
					assertFalse("Channel was not closed on iteration " + counter, serverConnectionChannel.isOpen());
				}
			}
			
			// We can't hammer the server continuously, or we'll run out of resource.
			// Sleep before the test claims completion
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	
	// A single connect attempt, for convenience
	public void testSingleConnect() throws IOException, ExecutionException, InterruptedException, TimeoutException {
		AsynchronousSocketChannel serverConnectionChannel = null;
		try {
			assertNotNull(serverAddress);

			serverConnectionChannel = AsynchronousSocketChannel.open();
			serverConnectionChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
			
			// Ensure we have have returned an open connection
			assertNotNull(serverConnectionChannel);
			assertTrue("Channel is not open", serverConnectionChannel.isOpen());
	
			// Blocking connect
			Future<Void> future = serverConnectionChannel.connect(serverAddress);
			future.get(getTimeout(), TimeUnit.MILLISECONDS);
			
			// Ensure we are connected
			assertNotNull("Unable to get remote address", serverConnectionChannel.getRemoteAddress());
			
		} finally {
			if (serverConnectionChannel != null) {
				try {
					serverConnectionChannel.close();
				} catch (ClosedChannelException cce) {
					// That's ok
				}
				assertFalse("Channel was not closed", serverConnectionChannel.isOpen());
			}
		}
	}
}
