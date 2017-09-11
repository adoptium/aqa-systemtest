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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

import net.adoptopenjdk.test.nio2.asyncio.RunFuture;
import net.adoptopenjdk.test.nio2.util.AssertionFailedException;
import net.adoptopenjdk.test.nio2.util.HangNotifier;
import net.adoptopenjdk.test.nio2.util.Logger;
import net.adoptopenjdk.test.nio2.util.RandomByteArrays;
import net.adoptopenjdk.test.nio2.util.SendingMessage;
import net.adoptopenjdk.test.nio2.util.Message.MessageTypes;
import net.adoptopenjdk.test.nio2.util.ServerFactory.ServerType;

public class MultipleReadWriteFutureTest extends AClient {

	public static String id = "net.adoptopenjdk.nio2.asyncio.client.FutureSequentialReadWriteMultiple";

	public static final int ITERATIONS = 50;
	
	//To remove the chance of two MultipleReadWriteFutureTests being executed in tandem.
	private static final AtomicBoolean otherTestInstances = new AtomicBoolean(false); 
	private static final Object otherTestInstancesLock = new Object();

	private final long MINIMUM_TEST_TIME = 5000;
	
	// Use ECHO type server
	public MultipleReadWriteFutureTest() {
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
		//Modified from 5*60*1000 to avoid timeout errors in stress.
		return 5*60*4000;
	}

	// Run singly for test and/or debugging purposes
	public void testFutureSequentialReadWriteSingle() throws Exception{
		long start = System.currentTimeMillis();
		runFutureSequentialReadWriteMultiple(1);
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
	public void testFutureSequentialReadWriteMultiple() throws Exception {
		long start = System.currentTimeMillis();
		runFutureSequentialReadWriteMultiple(ITERATIONS);
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
			System.out.println("MultipleReadWriteFutureTest is using the following ChannelGroup: " + clientChannelGroup);
		} catch (IOException e) {
			System.err.println("Error creating the client ChannelGroup");
			e.printStackTrace();
		}
	}
	
	// Actual test code
	public void runFutureSequentialReadWriteMultiple(int iterations) throws Exception {

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
		
		Logger log = new Logger("MultipleReadWriteFutureTest-" + thisIdentifier + ".txt");
		
		// Check that we have a valid server (cannot continue without it)
		assertNotNull("Unable to get server address, aborting test",serverAddress);

		// Setup the async client socket
		AsynchronousSocketChannel serverConnectionChannel = null;
		
		serverConnectionChannel = AsynchronousSocketChannel.open(clientChannelGroup);
		serverConnectionChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);

		// To get a bit of variety in the socket sending buffer, set it to the length of the message.
		// This will pretty much always require 2 writes, except for small buffers (less than 16bit)
		serverConnectionChannel.setOption(StandardSocketOptions.SO_SNDBUF, 1<<16);

		if (serverConnectionChannel.isOpen() == false) {
			throw new AssertionFailedException("Channel is not open");
		}

		//Try to set an option to keep this channel alive.
		try{
			serverConnectionChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
		}catch(IOException e){
			assertTrue("IO Exception thrown.",false);
		}
		
		// Blocking connect (and keep trying until the task finishes, one way or another).
		boolean futureWriteSuccessBool = false;
		while(!futureWriteSuccessBool){
			Future<Void> future = serverConnectionChannel.connect(serverAddress);
			try{
				RunFuture.get(future);
				futureWriteSuccessBool = true;
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
				if (loopCounter < RandomByteArrays.MAX) {
					message.setRandomMessage(1<<loopCounter);
				} else {
					message.setRandomMessage();
				}
				message.setMessageType(MessageTypes.ECHO);

				// Send it, blocking until completion. It will send in chunks
				ByteBuffer outgoingBuffer = message.getByteBuffer();

				int write_counter = 0;
				log.logMessage("Iteration (" + loopCounter + ") writing message " + outgoingBuffer);
				log.logMessage("ID:" + message.getHeaderValue("ID"));
				try {
					do {
						Future<Integer> writeFuture = serverConnectionChannel.write(outgoingBuffer);
						RunFuture.get(writeFuture);
						write_counter++;
					} while (outgoingBuffer.hasRemaining());
					log.logMessage("Write complete " + outgoingBuffer);
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					if (e.getMessage() != null) {
						pw.println(e.getMessage());
					}
					pw.println("Exception thrown during runFutureSequentialReadWriteMultiple, iteration " + loopCounter + ", write " + write_counter);
					pw.println("outgoing buffer: " + outgoingBuffer);
					pw.println("ServerConnectionChannel: " + serverConnectionChannel);
					
					Exception e2 = new Exception(sw.toString(), e);
					e2.setStackTrace(new StackTraceElement[0]);
					throw e2;
				}

				// Create a ByteBuffer to store the incoming data, big enough to fit it in
				// Randomly use one or other of the ByteBuffer types for a bit of variety. 
				ByteBuffer incomingBuffer = null;
				if (random.nextBoolean()) {
					incomingBuffer = ByteBuffer.allocate(message.getByteBuffer().capacity());
				} else {
					incomingBuffer = ByteBuffer.allocateDirect(message.getByteBuffer().capacity());
				}

				// Read the channel until the expected amount of data is returned
				int read_counter = 0;
				log.logMessage("Iteration (" + loopCounter + ") reading message " + incomingBuffer);
				try {
					while (incomingBuffer.hasRemaining()) {
						// Keep trying until the task finishes, one way or another.
						boolean futureReadSuccessBool = false;
						while(!futureReadSuccessBool){
							Future<Integer> readFuture = serverConnectionChannel.read(incomingBuffer);
							try{
								RunFuture.get(readFuture);
								futureReadSuccessBool = true;
							}catch(TimeoutException e){
								readFuture.cancel(true);
							}
						}				
						read_counter++;
					}
					log.logMessage("Read complete " + incomingBuffer);
				} catch (Exception e) {
					log.logMessage("Exception during read");
					// Experimental debugging output
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					if (e.getMessage() != null) {
						pw.println(e.getMessage());
					}
					pw.println("Exception thrown during runFutureSequentialReadWriteMultiple, iteration " + loopCounter + ", read " + read_counter);
					pw.println("Incoming buffer: " + incomingBuffer);
					pw.println("ServerConnectionChannel: " + serverConnectionChannel);
					
					Exception e2 = new Exception(sw.toString(), e);
					e2.setStackTrace(new StackTraceElement[0]);
					throw e2;
					
				}

				assertEquals(incomingBuffer.position(), outgoingBuffer.position());

				int finalPosition = incomingBuffer.position();

				// Reset both to the beginning
				outgoingBuffer.position(0);
				incomingBuffer.position(0);

				int position = 0;
				for (position = 0; position < finalPosition; position++) {

					byte outgoingByte = outgoingBuffer.get();
					byte incomingByte = incomingBuffer.get();

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

		// We can't hammer the server continuously, or we'll run out of resource.
		// Sleep before the test claims completion
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
