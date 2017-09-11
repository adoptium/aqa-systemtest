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

import java.util.HashMap;

import net.adoptopenjdk.test.nio2.asyncio.server.AServer;
import net.adoptopenjdk.test.nio2.asyncio.server.EchoServer;

public class ServerFactory {
	
	static {
		knownServer = new HashMap<ServerType, AServer>();
	}

	// Factory, no instances.
	private ServerFactory() {
		
	}
	
	private static HashMap<ServerType, AServer> knownServer;
	
	// In 1/10ths of a second 
	public static final int MAX_TIMEOUT = 600;
	
	public static AServer getServerInstance(ServerType type) {
			
		// Synch here so that the .containsKey() call is 
		// consistent
		synchronized (knownServer) {		
			if (knownServer.containsKey(type)) {
				return knownServer.get(type);
			} else {			
				AServer server = type.getNewServerClass();
				System.out.println("Starting up " +  type.getName() + " instance.");
				
				// Might block a short while
				server.startup();
				
				int timeout = 0;
				
				while (!server.isRunning()) {					
					if (server.hasFailed()) {
						server.getException().printStackTrace();
						return null;
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					timeout++;
					if (timeout > MAX_TIMEOUT) {
						// The server hasn't started, we should be worried
						System.err.println("The " + type.getName() + " failed to start in a timely manner");
						throw new RuntimeException(type.getName() + "failed to start in a timely manner");
					}
				}
				
				System.out.println("Completed " +  type.getName() + " startup - available at " + server.getServerConnectionDetails());			
				knownServer.put(type, server);			
				return server;			
			}
		}	
	}
	
	// Just a conveniently name method
	public static AServer useServerInstance(ServerType type) {
		return getServerInstance(type);
	}
	
	public static void shutdownServers() {		
		synchronized (knownServer) {			
			for (AServer server: knownServer.values()) {
				server.shutdown();
			}			
			knownServer.clear();
		}		
	}
	
	public enum ServerType {		
		ECHO ("Asynchronous Echo Server", EchoServer.class);		
		private String name;
		private Class<? extends AServer> clazz;
		
		ServerType(String name, Class<? extends AServer> clazz) {		
			this.name = name;
			this.clazz = clazz;			
		}
		
		public String getName() {
			return name;
		}
		
		public AServer getNewServerClass() {			
			AServer serverClass = null;			
			try {
				serverClass = clazz.newInstance();
				// Expect null pointers later on if the class can't be 
				// instantiated. In any case something has gone badly wrong
			} catch (InstantiationException e) {
				// This is going to cause all sorts of problems
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// This is going to cause all sorts of problems
				e.printStackTrace();
			}			
			return serverClass;			
		}		
	}	
}
