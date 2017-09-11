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

import java.net.SocketAddress;
import java.util.Random;

import junit.framework.TestCase;
import net.adoptopenjdk.test.nio2.asyncio.server.AServer;
import net.adoptopenjdk.test.nio2.util.ServerFactory;
import net.adoptopenjdk.test.nio2.util.ServerFactory.ServerType;

/**
 *  This is a generic client which handles the obtaining and storing
 *   of the connection details to the server.
 *  The server may be located in the same JVM (INTERNAL) or on another
 *   machine (EXTERNAL), the default being internal, which if a server is
 *   not available, one is started. 
 */

public abstract class AClient extends TestCase{	
	protected SocketAddress serverAddress = null;
	protected String name;	
	protected static Random random;	
	public static final long DEFAULT_TIMEOUT = 60000;
	
	static {
		synchronized (AClient.class) {

			if (random == null) {
				random = new Random();
			}
			
		}
	}
	
	public AClient(ServerType type) {	
		// Save connection details
		if (type != null) {
			serverAddress = useServer(type);
		}	
	}
	
	protected boolean hasTimedOut(long startTime) {
		return (System.currentTimeMillis() > startTime + getTimeout());
	}

	protected SocketAddress useServer(ServerType type) {		
		String propertyLocation = System.getProperty(AServer.id + ".location", "INTERNAL");	
		if (propertyLocation == "EXTERNAL") {
			return null;
		} else {
			if (ServerFactory.useServerInstance(type) != null) {
				return ServerFactory.useServerInstance(type).getServerConnectionDetails();
			} else {
				return null;
			}
		}	
	}
	
	protected long getTimeout() {
		return DEFAULT_TIMEOUT;
	}	
}
