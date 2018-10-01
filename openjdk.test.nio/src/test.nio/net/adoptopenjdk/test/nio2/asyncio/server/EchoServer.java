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

package net.adoptopenjdk.test.nio2.asyncio.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.spi.AsynchronousChannelProvider;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;

import net.adoptopenjdk.test.nio2.util.ConnectionState;
import net.adoptopenjdk.test.nio2.util.ConnectionStateClient;
import net.adoptopenjdk.test.nio2.util.ReceivingMessage;
import net.adoptopenjdk.test.nio2.util.SendingMessage;
import net.adoptopenjdk.test.nio2.util.ConnectionState.ReceivingState;

public class EchoServer extends AServer{

	private InetSocketAddress socketAddress = null;

	private AsynchronousServerSocketChannel asyncServerChannel = null;
	
	public static String id = "net.adoptopenjdk.nio2.async.server.EchoServer";

	public EchoServer() {
		this(null);
	}

	public EchoServer(Integer port) {
		super(id);
		setHeartbeatPeriod(1000);
		this.port = port;
	}

	@Override
	public void shutdown() {
		shuttingdown = true;
		try {
			asyncServerChannel.close();
		} catch (IOException e) {
			System.err.println("Exception shutting down the server channel");
			e.printStackTrace();
		}
	}

	@Override
	public void startup() {
		this.setDaemon(true);
		this.setupLog();
		this.start();
	}

	protected void setupLog() {
		logFile = Paths.get("EchoServer.log");
		try {
			OutputStream os = Files.newOutputStream(logFile, 
					StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			logWriter = new PrintStream(os);
			System.out.println("Echo Server log available at " + logFile);
			logStartTime = System.currentTimeMillis();
			logMessage("EchoServer started at " +  System.currentTimeMillis());
		} catch (IOException e) {
			System.err.println("Unable to create log file");
			e.printStackTrace();
		}
		
	}
	
	protected long logStartTime = 0;
	protected Path logFile = null;
	protected PrintStream logWriter = null;

	public void logMessage(String message) {
		if (logWriter != null) {
			String date = (new Date()).toString();
			long elapsed = (System.currentTimeMillis() - logStartTime);
			
            final long s = (elapsed / 1000) % 60;
            final long m = (elapsed / 1000 / 60) % 60;
            final long h = (elapsed / 1000 / 60 / 60);
			
			String deltaTime = String.format("%02d:%02d:%02d", h,m,s);
			logWriter.println(date + " (start +"+deltaTime + ")\t " + message);	
		}
	}
	public void logMessage() {
		if (logWriter != null) {
			logWriter.println();	
		}
	}

	@Override
	public void runServer() throws Exception {
		// Construct a new channel group to use for the server, so that it doesn't share 
		//  file descriptors and resources with the clients (which will continue to use 
		//  the default channel group)
		AsynchronousChannelGroup serverChannelGroup = AsynchronousChannelProvider.provider().openAsynchronousChannelGroup(64, Executors.defaultThreadFactory());

		logMessage("EchoServer Using channel group - " + serverChannelGroup);
		System.out.println("EchoServer Using channel group - " + serverChannelGroup);
		
			// Using default AsynchronousChannelGroup in .open(), and default backlog in .bind()
			if (port == null) {
				asyncServerChannel = AsynchronousServerSocketChannel.open(serverChannelGroup);
				asyncServerChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
				asyncServerChannel.bind(null);
				port = ((InetSocketAddress)asyncServerChannel.getLocalAddress()).getPort();
				socketAddress = new InetSocketAddress(ipAddress, port);
			} else {
				asyncServerChannel = AsynchronousServerSocketChannel.open(serverChannelGroup);
				asyncServerChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
				asyncServerChannel.bind(new InetSocketAddress(port));
				socketAddress = new InetSocketAddress(ipAddress, port);
			}	

			// Make a copy of the reference so we can use it in the inner class
			final AsynchronousServerSocketChannel fAsyncServerChannel = asyncServerChannel;
			final AServer server = this;

			// Start accepting connections

			// The ClientState object requires a reference to the server that it is used by
			//  so that we can call the other methods such as to increment connected clients etc..
			fAsyncServerChannel.accept(new ConnectionStateClient(server), new CompletionHandler<AsynchronousSocketChannel, ConnectionStateClient>() {
				@Override
				public void completed(AsynchronousSocketChannel channel, ConnectionStateClient state) {
					state.getServer().incrementClientsConnected();
					// Set off the next asynchronous accept operation.
					// (which of course requires the asyncServerChannel variable to be final
					//  to allow us to use it in this inner class)
					fAsyncServerChannel.accept(new ConnectionStateClient(state.getServer()), this);
					state.logMessage(".accept().completed() - " + channel);
					
					// The client should be connected, after all we have (successfully?) completed
					//  the accept method, so lets get the client's address.
					// This is a bit like an 'assertNotNull' statement, but we can't do that here,
					//  so in it's place, we'll print the exception to stderr.
					try {
						channel.getRemoteAddress();
					} catch (IOException e) {
						System.err.println("Connection from client accepted, but unable to get remote address");
						e.printStackTrace();
						// We can't really recover from here, so lets abandon the connection
						try {
							channel.close();
						} catch (IOException ioe) {
							System.err.println("IOException received while closing channel");
							ioe.printStackTrace();
						}
					}
					
					state.getServer().setLastConnectedTimeNow();
					state.setConnectedNow();

					// Service the connection
					//  At this point we do not have any data, merely a connection to the client
					state.setChannel(channel);

					// Add connected client to the collection
					state.getServer().getConnectedClients().add(state);

					// We could clear the buffer, but it's only just been created
					//  but if we wanted to, this is how to do it:
					// state.getIncomingByteBuffer().clear();
					state.logMessage("Initiating initial read");
					channel.read(state.getIncomingByteBuffer(), state, new ServerReadCompletionHandler());
				}

				@Override
				public void failed(Throwable throwable, ConnectionStateClient state) {
					// The .accept() method will drop to here if we close down the server.
					// As there is no way to do this gracefully, we check if this is what we expect
					//  and either allow it, or flag it as a problem
					if (shuttingdown == true) {
						if (throwable instanceof AsynchronousCloseException) {
							// Expected, as we've closed the channel, and the handler way of doing things
							//  doesn't provide a nice way to cancel the operation.
						} else {
							System.err.println("EchoServer.accept() - failed() In shutdown, but received an unexpected Exception");
							throwable.printStackTrace();
						}
					} else {
						String message = "EchoServer.accept() shutdown at " + (new Date()) + ", after client " + state + " See the log for more details";
						StringWriter stringWriter = new StringWriter();
						PrintWriter printWriter = new PrintWriter(stringWriter);
						printWriter.println("--------------------------------------------------------------------");
						printWriter.println(message);
						printWriter.println("If this was at the end of the test, this shutdown could be expected,");
						printWriter.println(" if however it was midway through a test, here is the exception:");
						throwable.printStackTrace(printWriter);
						printWriter.println("--------------------------------------------------------------------");
						System.out.println(message);
						logMessage(stringWriter.toString());
					}
				}
			});
			
		running = true;
		
		// Wait here until the JVM shuts down
		waitForShutdown();
	}
	
	@Override
	protected void heartbeat() {
		// Let them know we are alive
		// Print some stats about the ByteBuffers
		List<BufferPoolMXBean> byteBufferPools = 
			ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);

		String direct = "direct";
		String mapped = "mapped";
		
		for (BufferPoolMXBean bean: byteBufferPools) {
			if (bean.getName().equalsIgnoreCase(direct)) {
				direct += " - " + bean.getMemoryUsed() + "/" + bean.getTotalCapacity();
			}
			if (bean.getName().equalsIgnoreCase(mapped)) {
				mapped += " - " + bean.getMemoryUsed() + "/" + bean.getTotalCapacity();
			}
		}
		
		logMessage(direct + " , " + mapped);
		logMessage("Currently connected clients: " + getConnectedClients().size());
		logMessage("Total bytes received       : " + bytesReceived);
		logMessage("Total clients connected    : " + clientsConnected);
		logMessage("Total clients disconnected : " + clientsDisconnected);
		
		synchronized (connectionsPerSecond) {
			if (!connectionsPerSecond.isEmpty()) {
				logMessage("CPS Max: " + Collections.max(connectionsPerSecond.values()) );
			}
		}
		synchronized (connectionsPerMinute) {
			if (!connectionsPerMinute.isEmpty()) {
				logMessage("CPM Max: " + Collections.max(connectionsPerMinute.values()) );
			}
		}

		logMessage();
	}

	private class ServerReadCompletionHandler implements CompletionHandler<Integer, ConnectionStateClient> {
		@Override
		public void completed(Integer readBytes, ConnectionStateClient clientState) {
			// Check for disconnection of the client, indicated by reading from the stream returning -1
			if (readBytes == -1) {
				// Don't initiate another read operation
				clientState.getServer().incrementClientsDisconnected();
				clientState.logMessage("Client disconnected");
				
				// The client has disconnected, remove it from the connected clients list
				clientState.getServer().getConnectedClients().remove(clientState);
				
				// Close the channel to free up the socket and resources
				// This may not be immediate if there are any pending writes
				clientState.shutdownChannel();
			} else {
				addBytesReceived(readBytes);

				// Parse buffer, ready to act on if necessary
				//IncomingMessageParser.getInstance().parseBuffer(readBytes, clientState);
				parseBuffer(readBytes, clientState);
				
				while (clientState.hasPendingMessages()) {
					// Get the next message off the queue
					ReceivingMessage message = clientState.popNextPendingMessage();
					clientState.logMessage("Parsed new message");
					clientState.logMessage("ID:" + message.getHeaderValue("ID"));
					
					switch (message.getMessageType()) {

						case ECHO:
						default:
							// Create a new message to send and add to the outbound queue
							SendingMessage sendingMessage = new SendingMessage(message);
							clientState.addToOutboundQueue(sendingMessage.getByteBuffer());
						break;
					}
				}

				// Initiate another read operation
				ByteBuffer incomingBuffer = clientState.getIncomingByteBuffer();
				clientState.getChannel().read(incomingBuffer, clientState, this);
			}
		}

		@Override
		public void failed(Throwable arg0, ConnectionStateClient clientState) {
			System.err.println("EchoServer.ServerReadCompletionHandler - failed() at " + (new Date()));
			arg0.printStackTrace();	
		}

		public void parseBuffer(Integer readBytes, ConnectionState clientState) {
			// The parser reads the start of the message into a StringBuffer, expecting
			//  it to be encoded as ASCII. Once that has been received, then we can 
			//  parse the header and find out the size of the rest of the message, and
			//  allocate a ByteBuffer accordingly. This will then fill up with the data. 
			int currentPosition = 0;

			// Loop through the entire incoming buffer, generating complete and partial messages
			while (currentPosition < readBytes) {
				// While we do not have two consecutive \n characters, add them to the string buffer, that
				//  is, the header.
				if (clientState.getReceivingState() == ReceivingState.COMPLETE ||
						clientState.getReceivingState() == ReceivingState.AWAITING_HEADER) {
					
					// Switch to reading if we are going searching through this buffer
					ByteBuffer buffer = clientState.getIncomingByteBuffer();
					buffer.flip();
					StringBuffer stringBuffer = clientState.getIncomingHeaderStringBuffer();

					// Copy bytes from the buffer to the header StringBuffer, watching for a double
					//  newline which will indicate that we have all the header data.
					while (currentPosition < readBytes) {
						char character = (char)buffer.get();
						currentPosition++;
						stringBuffer.append(character);
						
						// The header is up to the first occurrence of a \n\n. After this is the contents of the message
						// By parsing the header as we go, we can then create a ByteBuffer of the correct size to receive
						//  the remainder of the message, and stop processing when we receive that many bytes.
						if (stringBuffer.toString().contains("\n\n")) {
							// Parse the header so that we know what the contents length should be.
							clientState.getMessage().parseAndSetHeader(stringBuffer.toString());
							
							// Set our next state
							clientState.setReceivingState(ReceivingState.AWAITING_CONTENTS);
							// Allocate a buffer for the incoming message
							ByteBuffer newContentsBuffer = clientState.allocateContentsReceivingBuffer();
							
							// Copy the remaining data from the incoming buffer, to the contents buffer.
							if (currentPosition < readBytes) {
								while (newContentsBuffer.hasRemaining() && currentPosition < readBytes) {
									newContentsBuffer.put(buffer.get());
									currentPosition++;
								}
							}
						}
					}
				}
 
				// Do some processing on the complete message
				if (clientState.getReceivingState() == ReceivingState.AWAITING_CONTENTS) {
					ReceivingMessage currentMessage = clientState.getMessage();
					if (currentMessage.isContentsComplete()) {
						clientState.setReceivingState(ConnectionState.ReceivingState.COMPLETE);
					}
					
					// We have looked at the entire buffer, and done something as appropriate, so
					//  there is no more parsing to do.
					return;
				} else { 
					// still waiting on the header
					clientState.setReceivingState(ReceivingState.AWAITING_HEADER);
					
					// Flip the buffer to fill it up again
					clientState.allocateHeaderReceivingBuffer();
				}
			} // End of looping through the received buffer
		}
	} // End of ChatServer.ServerReadCompletionHandler class

	@Override
	public SocketAddress getServerConnectionDetails() {
		return socketAddress;
	}
}


