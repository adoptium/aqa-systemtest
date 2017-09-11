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
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import net.adoptopenjdk.test.nio2.asyncio.RunFuture;
import net.adoptopenjdk.test.nio2.util.AssertionFailedException;
import net.adoptopenjdk.test.nio2.util.AsyncTestState;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.Logger;
import net.adoptopenjdk.test.nio2.util.SendingMessage;
import net.adoptopenjdk.test.nio2.util.Message.MessageTypes;
import net.adoptopenjdk.test.nio2.util.ServerFactory.ServerType;

public class MultipleReadWriteAsyncTest extends AClient {

	public static String id = "net.adoptopenjdk.nio2.asyncio.client.MultipleReadWriteAsyncTest";
	
	//To remove the chance of two MultipleReadWriteAsyncTests being executed in tandem.
	private static final AtomicBoolean otherTestInstances = new AtomicBoolean(false); 
	private static final Object otherTestInstancesLock = new Object();

	public static final int ITERATIONS = 50;
	
	private final long MINIMUM_TEST_TIME = 5000;

	// Use ECHO type server
	public MultipleReadWriteAsyncTest() {
		super(ServerType.ECHO);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		assertNotNull("Client channel group was null",clientChannelGroup);
		HangNotifier.ping();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		HangNotifier.ping();
	}
	
	// Set the timeout allowed for this particular test
	@Override
	protected long getTimeout() {
		//modified from 5*60*1000 to avoid timeout exceptions in stress.
		return 5*60*2000;
	}

	// Run singly for test and/or debugging purposes
	public void testHandlerReadWriteSingle() throws Exception{
		long start = System.currentTimeMillis();
		runHandlerReadWriteMultiple(1);
		long duration = System.currentTimeMillis() - start;
		if (duration < MINIMUM_TEST_TIME) {
			try {
				Thread.sleep(MINIMUM_TEST_TIME - duration);
			} catch (InterruptedException e) {
				// Ignore
			}
		}
	}

	// Run the default number of times
	public void testHandlerReadWriteMultiple() throws Exception {
		long start = System.currentTimeMillis();
		runHandlerReadWriteMultiple(ITERATIONS);
		long duration = System.currentTimeMillis() - start;
		if (duration < MINIMUM_TEST_TIME) {
			try {
				Thread.sleep(MINIMUM_TEST_TIME - duration);
			} catch (InterruptedException e) {
				// Ignore
			}
		}
	}

	private static int identifier = 0;
	
	private static AsynchronousChannelGroup clientChannelGroup = null;
	
	static {
		try {
			clientChannelGroup = AsynchronousChannelProvider.provider().openAsynchronousChannelGroup(48, Executors.defaultThreadFactory());
			System.out.println("MultipleReadWriteAsyncTest is using the following ChannelGroup: " + clientChannelGroup);
		} catch (IOException e) {
			System.err.println("Error creating the client ChannelGroup");
			e.printStackTrace();
		}
	}
		
	// Actual test code
	public void runHandlerReadWriteMultiple(int iterations) throws Exception {
		//Multiple instances of this test running concurrently can cause trouble, so abort if needed.
		synchronized(otherTestInstancesLock){
			if(otherTestInstances.get()){
				return;
			}
			otherTestInstances.set(true);
		}
		
		int thisIdentifier;
		synchronized (MultipleReadWriteFutureTest.class) {
			thisIdentifier = identifier++;
		}
		
		Logger log = new Logger("MultipleReadWriteAsyncTest-" + thisIdentifier + ".txt");

		// Check that we have a valid server (cannot continue without it)
		assertNotNull("Unable to get server address, aborting test",serverAddress);

		// Setup the async client socket
		AsynchronousSocketChannel serverConnectionChannel = null;

		serverConnectionChannel = AsynchronousSocketChannel.open(clientChannelGroup);
		
		// Ensure we have have returned an open connection
		if (serverConnectionChannel == null) {
			throw new AssertionFailedException("Supposedly opened channel was null");
		}

		serverConnectionChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

		// To get a bit of variety in the socket sending buffer, set it to the length of the message.
		// This will pretty much always require 2 writes, except for small buffers (less than 16bit)
		serverConnectionChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1<<16);

		if (serverConnectionChannel.isOpen() == false) {
			throw new AssertionFailedException("Channel is not open");
		}
		
		// Try to set an option to keep this channel alive.
		try{
			serverConnectionChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
		}catch(IOException e){
			assertTrue("IO Exception thrown.",false);
		}
		
		// Blocking connect (and keep trying until the task finishes, one way or another).
		boolean writeClientAsyncSuccessBool = false;
		while(!writeClientAsyncSuccessBool){
			Future<Void> future = serverConnectionChannel.connect(serverAddress);
			try{
				RunFuture.get(future);
				writeClientAsyncSuccessBool = true;
			}catch(TimeoutException e){
				future.cancel(true);
			}
		}

		// Ensure we are connected...
		if (serverConnectionChannel.getRemoteAddress() == null) {
			// Close the channels, as we are going to fail this test
			cleanUpChannel(serverConnectionChannel);
			throw new AssertionFailedException("Remote address was returned as null");
		}

		// ... to the right server
		SocketAddress remoteAddress = serverConnectionChannel.getRemoteAddress();
		if (!remoteAddress.equals(serverAddress)) {
			throw new AssertionFailedException("Remote address returned ("+remoteAddress+"), " +
					"did not match who we asked to connect to ("+serverAddress+")");
		}


		for (int loopCounter = 0; loopCounter < iterations; loopCounter++) {
			if ((loopCounter % 100) == 0) {
				System.out.println("Iteration " + loopCounter);
			}
		
			HangNotifier.ping();
			
			try {
				// Create a new random message
				SendingMessage message = new SendingMessage();
				if (loopCounter < 24) {
					message.setRandomMessage(1<<loopCounter);
				} else {
					message.setRandomMessage();
				}
				message.setMessageType(MessageTypes.ECHO);

				// Send it
				ByteBuffer outgoingBuffer = message.getByteBuffer();

				AsyncTestState testState = new AsyncTestState();
				testState.socketChannel = serverConnectionChannel;
				testState.outgoingBuffer = outgoingBuffer;
				testState.log = log;
				
				log.logMessage("Iteration (" + loopCounter + ") writing message " + outgoingBuffer);
				log.logMessage("ID:" + message.getHeaderValue("ID"));

				serverConnectionChannel.write(testState.outgoingBuffer, testState, new CompletionHandler<Integer, AsyncTestState>() {

					@Override
					public void completed(Integer result,
							AsyncTestState testState) {

						// If we haven't sent all of the buffer, send again
						if (testState.outgoingBuffer.hasRemaining()) {
							testState.socketChannel.write(testState.outgoingBuffer, testState, this);
						} else {
							// Else, get ready to read
							testState.log.logMessage("Write complete " + testState.outgoingBuffer);
							testState.incomingBuffer = ByteBuffer.allocate(testState.outgoingBuffer.capacity());
							testState.log.logMessage("Reading message " + testState.incomingBuffer);
							
							try{
								testState.socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
							}catch(IOException e){
								assertTrue("IO Exception thrown.",false);
							}
							
							testState.socketChannel.read(testState.incomingBuffer, testState, new CompletionHandler<Integer, AsyncTestState>() {
								@Override
								public void completed(Integer result,
										AsyncTestState testState) {
									// If we haven't received all the bytes, read again
									if (testState.incomingBuffer.hasRemaining()) {
										testState.socketChannel.read(testState.incomingBuffer, testState, this);
									} else {
										testState.log.logMessage("Read complete " + testState.incomingBuffer);
										testState.complete = true;
									}
								}

								@Override
								public void failed(Throwable exc,
										AsyncTestState testState) {
									
									testState.log.logMessage("Read failed " + testState.incomingBuffer);
									testState.failedAssertions.addException(new AssertionFailedException(exc));
									testState.complete = true;
								}
							});
						}
					}

					@Override
					public void failed(Throwable exc,
							AsyncTestState testState) {
						
						testState.log.logMessage("Write failed " + testState.outgoingBuffer);
						testState.failedAssertions.addException(new AssertionFailedException(exc));
						testState.complete = true;
					}
				});

     			// Wait for the bytes to be read back, and the completion flag to be set
				while (!testState.complete) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// do nothing
					}
					
					if (RunFuture.block){
						continue;
					}

					if (testState.complete == false && hasTimedOut(testState.startedAt)) {
						// Cleanup the channel if it is still open before throwing the Exception
						if (testState.socketChannel.isOpen()) {
							try {
								testState.socketChannel.close();
							} catch (Exception e) {
							}
						}
					}
				}

				// Check that there were no exceptions
				if (testState.failedAssertions.hasExceptions()) {
					throw new Exception("(iteration: "+loopCounter+") - exceptions thrown\n" + testState.failedAssertions.getExceptionMessages());
				}

				assertEquals("Incoming buffer position did not match the outgoing buffer position.",
						outgoingBuffer.position(), testState.incomingBuffer.position());

				int finalPosition = testState.incomingBuffer.position();

				// Reset both to the beginning
				testState.outgoingBuffer.position(0);
				testState.incomingBuffer.position(0);

				int position = 0;
				for (position = 0; position < finalPosition; position++) {

					byte outgoingByte = testState.outgoingBuffer.get();
					byte incomingByte = testState.incomingBuffer.get();

					if (outgoingByte != incomingByte) {
						System.out.print((char)incomingByte + "/" + (char)outgoingByte);
						cleanUpChannel(serverConnectionChannel);
						throw new AssertionFailedException("Outgoing and Incomming buffers differ at location " + position +
								". Expected '" + (int)outgoingByte + "' was '" + (int)incomingByte + "'");
					}
				}
			} catch (Exception e) {
				cleanUpChannel(serverConnectionChannel);
				log.close();
				throw e;
			}
		}

		// Finally close the channel
		serverConnectionChannel.close();

		if (serverConnectionChannel.isOpen() == true) {
			throw new AssertionFailedException("Channel was not closed");
		}

		// We can't hammer the server continuously, or we'll run out of resource, normally ports
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}

		synchronized(otherTestInstancesLock){
			otherTestInstances.set(false);
		}
	}

	private void cleanUpChannel(AsynchronousSocketChannel channel) {
		try {
			if (channel != null) {
				channel.close();
			}
		} catch (Exception e){
			// Ignore
		}
	}
}
