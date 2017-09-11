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

package net.adoptopenjdk.test.nio2.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/** 
 *  Class containing information required by the server to process messages
 *   as they come in from clients.
 *   
 *  Incoming byteBuffer (and outgoing) can be set. Smaller buffers than the 
 *   message size will require repeated calls to .read(), and the total message
 *   must be constructed in another buffer that is large enough to contain 
 *   the entire message.
 *   
 *  This class also provides the mechanism to add a message to the outgoing
 *   queue, which will be sent asynchronously when the previous .write() 
 *   method has completed, or at the earliest opportunity if there are no
 *   messages waiting to be sent.
 *   
 *  Received messages are constructed into Message objects, and added to the
 *   ordered Collection and can be retrieved as required.
 */

public abstract class ConnectionState {

	private static long identifier = 0;

	private long thisIdentifier;

	private static final int INCOMING_BUFFER_SIZE = 10; 
	private static final int STRING_BUFFER_SIZE = 1000;

	private ByteBuffer incomingByteBuffer = null;

	private StringBuffer incomingHeaderStringBuffer = null;

	private AsynchronousSocketChannel channel = null;

	
	private ReceivingState receivingState = ReceivingState.AWAITING_HEADER;
	private ReceivingMessage message = null;
	
	private long connectedAt = 0;
	
	protected Logger log = null;
	
	public boolean logMessage(String message) {
		if (log != null) {
			log.logMessage(message);
			return true;
		}
		return false;
	}
	
	// Increment this under the outboundQueueMessages lock
	protected int message_counter = 0;
	
	// Pending messages for the client
	public long getConnectedAt() {
		return connectedAt;
	}

	public void setConnectedNow() {
		
		this.connectedAt = System.currentTimeMillis();
	}

	private Queue<ReceivingMessage> pendingMessages = new LinkedList<ReceivingMessage>();
	
	public boolean hasPendingMessages() {
		synchronized (pendingMessages) {
			return (pendingMessages.size() > 0);
		}
	}
	
	public ReceivingMessage popNextPendingMessage() throws NoSuchElementException {
		synchronized (pendingMessages) {
			if (!hasPendingMessages()) {
				throw new NoSuchElementException("No pending messages");
			} else {
	
				ReceivingMessage next = pendingMessages.poll();
				return next;
				
			}			
		}
	}
	
	public void addPendingMessage(ReceivingMessage message) {
		synchronized (pendingMessages) {
			pendingMessages.add(message);		
		}
	}
	
	public void migrateMessageToPendingQueue() {
		addPendingMessage(message);
		resetMessageAndBuffers();
	}
	
	
	// currently populating message
	public ReceivingMessage getMessage() {
		return message;
	}

	// Create a ByteBuffer for the header
	public ByteBuffer allocateHeaderReceivingBuffer() {
		incomingByteBuffer = ByteBuffer.allocate(INCOMING_BUFFER_SIZE);
		return incomingByteBuffer;
	}
	
	// Create a ByteBuffer large enough to receive the incoming message 
	public ByteBuffer allocateContentsReceivingBuffer() {
		incomingByteBuffer = message.allocateContentsBuffer();
		return incomingByteBuffer;
	}

	public ReceivingState getReceivingState() {
		return receivingState;
	}

	public void setReceivingState(ReceivingState receivingState) {
		switch (receivingState) {
			case COMPLETE:
				// Resets buffers
				migrateMessageToPendingQueue();
				break;
		default:
			break;
		}
		this.receivingState = receivingState;
	}

	protected ConnectionState() {	
		synchronized (ConnectionState.class) {
			thisIdentifier = identifier++;
		}
		
		// Setup a log file
	    String logFileName = 
	        String.format("%s_0x%08x-%d.txt", this.getClass().getSimpleName(),
	                System.identityHashCode(this.getClass()), thisIdentifier);
		
		this.log = new Logger(logFileName);	
		outboundQueueMessages = new LinkedList<ByteBuffer>();		
		resetMessageAndBuffers();	
	}
	
	private void resetMessageAndBuffers() {
		message = new ReceivingMessage();
		allocateHeaderReceivingBuffer();
		newStringBuffer();
	}
	
	private void newStringBuffer() {
		incomingHeaderStringBuffer = new StringBuffer(STRING_BUFFER_SIZE);
	}
	
	// Sensible toString() implementation
	public String toString() {
		return "Client:" + thisIdentifier;// + "-" + stateMessage.toString();

	}

	// Needed for async .accept()
	public ByteBuffer getIncomingByteBuffer() {
		return incomingByteBuffer;
	}

	public void setChannel(AsynchronousSocketChannel channel) {
		this.channel = channel;
		if (log!=null) {
			log.logMessage("Using channel " + channel);
		}
	}

	public AsynchronousSocketChannel getChannel() {
		return channel;
	}

	public StringBuffer getIncomingHeaderStringBuffer() {
		return incomingHeaderStringBuffer;
	}

	protected final List<ByteBuffer> outboundQueueMessages;

	public List<ByteBuffer> getOutboundQueueMessages() {
		return outboundQueueMessages;
	}
	
	public int getOutboundQueueMessagesCount() {
		synchronized (outboundQueueMessages) {
			return outboundQueueMessages.size();
		}
	}
	
	private void closeChannel() {		
		try {
			// Close the channel
			channel.close();
			// Close the client state, which will close the log file if open
			close();
		} catch (IOException e) {
		}
		
	}
	
	private boolean shutdownChannel = false;
	
	public synchronized void shutdownChannel() {	
		synchronized (outboundQueueMessages) {
			if (outboundQueueMessages.size() > 0) {
				// We can't shutdown yet, we have some pending write operations
				shutdownChannel = true;
			} else {
				closeChannel();
			}
		}
	}

	// Only allow one thread access to this method at any one time,
	// should be enough synchronization to maintain the 
	// out-bound queue. The CompleteionHandler that gets run in 
	// the relevant thread pool has additional synchronization to 
	// maintain order.
	public synchronized void addToOutboundQueue(ByteBuffer buffer) {
		log.logMessage("Request to send " + buffer);	
		// Get a lock here too, so that we don't get out of sync.
		synchronized (outboundQueueMessages) {
			// If the queue already has something in, there should
			// be a asynchronous process taking the items off the
			// queue one at a time, so add another one one to 
			// enable it to pick this message up
			if (outboundQueueMessages.size() > 0) {
				log.logMessage("Adding to existing queue " + buffer);
				outboundQueueMessages.add(buffer);
			} else {				
				// There is nothing currently in the list, so lets kick off the
				// first asynchronous call to send the message.
				    
				// If there are extra messages added whilst this first one is
				// sending, the completionHandler will pick them up and empty the queue.
				    
				// outboundQueueMessages is a final variable so that we can use
				// it in this inner class, and also synchronize on it.
				
				// Still add to the list, as it will be removed after the successful write
				outboundQueueMessages.add(buffer);
				log.logMessage("Iteration(" +message_counter+ ") Queue empty, sending " + outboundQueueMessages.get(0));
				this.getChannel().write(buffer, this, 
						new CompletionHandler<Integer, ConnectionState>() {

					@Override
					public void completed(Integer arg0, ConnectionState client) {
						
						synchronized (outboundQueueMessages) {
							// If there are still some bytes to send (we can only send in chunks)
							// then don't remove the message just yet
							if (!outboundQueueMessages.get(0).hasRemaining()) {
								log.logMessage("Finished sending " + outboundQueueMessages.get(0));
								outboundQueueMessages.remove(0);
								message_counter++;
							}
							
							// Send either the next chunk of this message, or the next message,
							// depending on whether it was removed.
							getNextMessage(client);
						}						
					}

					@Override
					public void failed(Throwable throwable, ConnectionState client) {
						// This is run in a handler thread, so we can't do any normal
						// termination such as fail() or assert() if we were in a junit
						// test, nor can we really stop anything. So just print the 
						// stack-trace out and let something else catch it
						synchronized (outboundQueueMessages) {
							StringWriter sw = new StringWriter();
							PrintWriter pw = new PrintWriter(sw);
							if (throwable.getMessage() != null) {
								pw.println(throwable.getMessage());
							}
							
							ByteBuffer failedMessage = outboundQueueMessages.get(0);
							pw.println("Failed to send message through channel " + client.channel + " - " + failedMessage);
							int max = Math.min(100, failedMessage.capacity());
							pw.println("Header of the failed message:");
							pw.print(">>>>");
							
							byte previousByte = 0;
							for (int i=0; i<max; i++) {
								byte currentByte = failedMessage.get(i);
								pw.print((char)currentByte);
								if (previousByte == '\n' && currentByte == '\n') {
									break;
								}
								previousByte = currentByte;
							}
							pw.println("<<<<");
							
							Exception e2 = new Exception(sw.toString(), throwable);
							e2.setStackTrace(new StackTraceElement[0]);
							e2.printStackTrace();
							
							log.logMessage(sw.toString());
							outboundQueueMessages.remove(0);
							message_counter++;
							getNextMessage(client);
						}						
					}

					// Synchronized on the outboundQueueMessages list
					// so that we wait if there is something in the process
					// of being added to this list.
					   
					// We need both the size check and the .get() method
					// to be in the synch block
					private void getNextMessage(ConnectionState client) {
						synchronized (outboundQueueMessages) {
							if (outboundQueueMessages.size() > 0) {
								log.logMessage("Iteration(" +message_counter+ ") Sending " + outboundQueueMessages.get(0));
								client.getChannel().write(outboundQueueMessages.get(0), client,this);
							} else {
								// There are no more messages in the queue,
								// so we should shutdown the channel if required
								if (shutdownChannel) {
									client.closeChannel();
								}
							}
						}
					}
				}
				);
			}
		}	
	}
	
	public enum ReceivingState {
		AWAITING_HEADER,
		AWAITING_CONTENTS,
		COMPLETE	
	}
	
	public void close() {
		log.close();
	}
}
