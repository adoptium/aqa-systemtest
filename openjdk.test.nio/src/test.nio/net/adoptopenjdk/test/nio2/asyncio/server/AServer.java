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

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import net.adoptopenjdk.test.nio2.util.ConnectionState;
import net.adoptopenjdk.test.nio2.util.LocalEthernetInterface;

/**
 *  Abstract Server class that sets up and provides the common elements
 *   required to be provided by the servers in this test suite.
 *  Extending this class allows us to use only a small amount of code 
 *   to ensure the correct type of server is available for any given 
 *   test case.
 */
public abstract class AServer extends Thread {
	
	protected volatile boolean running = false;
	protected volatile boolean shuttingdown = false;
	
	private static final int DEFAULT_HEATBEAT_PERIOD = 1000;
	
	protected String ipAddress = null;
	protected Integer port = null;
	
	public static final String id = "net.adoptopenjdk.nio2.asyncio.server.aserver";
	
	public AServer() {
		this(null);
	}
	
	public AServer(String id) {

		setHeartbeatPeriod(DEFAULT_HEATBEAT_PERIOD);
		
		if (id != null) {
			
			String propertyPort = System.getProperty(id + ".port");
			if (propertyPort == null) {
				port = null;
			} else {
				try {
					port = Integer.parseInt(propertyPort);
				} catch (NumberFormatException nfe) {
					System.out.println("Bad format for " + id + ".port : " + propertyPort);
				}
			}
			
			
		}
		
		ipAddress = LocalEthernetInterface.getBestAddress();
		
	}
	
	// Wrapping the run() method so that it doesn't bomb out and no-one knows why
	
	@Override
	public void run() {
		try {
			serverStartTime = System.currentTimeMillis();
			runServer();
		} catch (Exception e) {
			thrownException = e;
			e.printStackTrace();
		}
	}
	
	protected long serverStartTime = 0;
	
	private Exception thrownException = null;
	
	public boolean hasFailed() {
		if (thrownException == null) {
			return false;
		}
		return true;
	}
	
	public Exception getException() {
		return thrownException;
	}
	
	abstract protected void runServer() throws Exception;
	
	protected long bytesReceived = 0;
	protected long bytesSent = 0;
	
	protected long clientsConnected = 0;
	protected long clientsDisconnected = 0;
	
	class ConnectionCounter implements Comparable<ConnectionCounter> {
		public long connected = 1;

		@Override
		public String toString() {
			
			return String.valueOf(connected);
		}

		@Override
		public int compareTo(ConnectionCounter occ) {
			if (this.connected > occ.connected) {
				return 1;
			} else if (this.connected < occ.connected) {
				return -1;
			}
			return 0;
		}
	}
	
	protected HashMap<Long, ConnectionCounter> connectionsPerSecond = new HashMap<Long, ConnectionCounter>();
	protected HashMap<Long, ConnectionCounter> connectionsPerMinute = new HashMap<Long, ConnectionCounter>();
	
	protected void addBytesReceived(long bytes) {
		bytesReceived += bytes;
	}
	protected void addBytesSent(long bytes) {
		bytesSent+= bytes;
	}
	
	protected void incrementClientsConnected() {
		long offset = (System.currentTimeMillis() - serverStartTime)/1000;
		synchronized (connectionsPerSecond) {
			ConnectionCounter counter = connectionsPerSecond.get(offset);
			if (counter != null) {
				counter.connected++;
			} else {
				connectionsPerSecond.put(offset, new ConnectionCounter());
			}
		}

		synchronized (connectionsPerMinute) {
			ConnectionCounter counter = connectionsPerMinute.get(offset/60);
			if (counter != null) {
				counter.connected++;
			} else {
				connectionsPerMinute.put(offset/60, new ConnectionCounter());
			}
		}
		
		clientsConnected++;
	}
	protected void incrementClientsDisconnected() {
		clientsDisconnected++;
	}
	
	protected long getBytesReceived() {
		return bytesReceived;
	}	
	
	// ------------------------------------------------------
	// Heartbeat facility
	// By default you get nothing happening in the heartbeat 
	//  function, but this can be overridden in the 
	//  subclasses. Defaults to every second.
	
	public AServer(String id, int port) {
		this(id);
		this.port = port;
	}


	private int heartbeatPeriod = 10000;
	
	protected void setHeartbeatPeriod(int heartbeatPeriod) {
		this.heartbeatPeriod = heartbeatPeriod;
	}

	protected int getHeartbeatPeriod() {
		return heartbeatPeriod;
	}
	
	protected void heartbeat() {
		// Do nothing be default
	}
	
	protected void waitForShutdown() {
		while (true) {
			try {
				sleep(getHeartbeatPeriod());
				heartbeat();
			} catch (InterruptedException e) {

			}
		}
	}

	private Set<ConnectionState> connectedClients;
	
	{ 
		connectedClients = new HashSet<ConnectionState>();
	}
	
	public Set<ConnectionState> getConnectedClients() {
		return connectedClients;
	}
	
	public int getNumberOfConnectedClients() {
			
		return connectedClients.size();
		
	}
	
	public abstract SocketAddress getServerConnectionDetails();
	
	// ------------------------------------------------------
	// Manage last connected time
	
	public void setLastConnectedTimeNow() {
		lastConnectedClientTime = System.currentTimeMillis();
	}
	
	public long getLastConnectedTime() {
		return lastConnectedClientTime;
	}
	
	private long lastConnectedClientTime = 0;
	 
	// Startup thread in the normal manner
	public abstract void startup();
	
	// Will return false if it is in the process of shutting down
	public boolean isRunning() {
		return running;
	}
	
	// Terminate the server thread (hopefully) cleanly
	public void shutdown() {
		shuttingdown = true;
	}
}

