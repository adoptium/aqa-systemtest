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

/*
 * This java source file contains the ServerConnector class, 
 * this class is the superclass for ClassProfiler, ThreadProfiler,
 * MemoryProfiler and the MemoryNotifier. It contains all the 
 * common instance variables and methods needed to connect to a 
 * remote, secure VM.
 */
package net.adoptopenjdk.test.jlm.remote;

import java.lang.management.*;
import javax.management.remote.*;

import net.adoptopenjdk.test.jlm.resources.Message;

import javax.management.*;

import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.text.DateFormat;

import java.net.MalformedURLException;

public abstract class ServerConnector {
	protected boolean useProxy;
	protected boolean ibm;
	protected MBeanServerConnection mbs;
	private final String serverURL1 = "service:jmx:rmi:///jndi/rmi://";
	private String hostName = TestArgs.DEFAULT_HOST;
	private int portNumber = TestArgs.DEFAULT_PORT;
	private final String serverURL2 = "/jmxrmi";
	protected boolean secure;
	protected String user;
	protected String pw;

	protected ServerConnector (boolean useProxy) {  
		this.secure = false;
		this.useProxy=useProxy;
		this.getServerConnection();
	}

	protected ServerConnector (boolean useProxy, String hostName, int portNumber) {  
		this.secure = false;
		this.useProxy=useProxy;
		this.hostName=hostName;
		this.portNumber=portNumber;
		this.getServerConnection();
	}

	protected ServerConnector (boolean useProxy, String user, String pw) {       
		this.secure = true;
		this.user = user;
		this.pw = pw;
		this.useProxy = useProxy;
		this.getSecureServerConnection(user, pw);
	}

	protected ServerConnector (boolean useProxy, String user, 
			String pw, String hostName, int portNumber) {       
		this.secure = true;
		this.user = user;
		this.pw = pw;
		this.useProxy = useProxy;
		this.hostName=hostName;
		this.portNumber=portNumber;
		this.getSecureServerConnection(user, pw);
	}

	// Access function for boolean useProxy 
	public boolean getUseProxy() { 
		return this.useProxy;
	}

	private String buildServerURL() {
		String builtServerURL = this.serverURL1+
				this.hostName+":"+this.portNumber+
				this.serverURL2;
		Message.logOut( "ServerURL=" + builtServerURL );
		return builtServerURL;
	}

	private void getServerConnection() {   
		JMXConnector connector = null;
		JMXServiceURL address = null;

		try {
			address = new JMXServiceURL(this.buildServerURL());
		} catch (MalformedURLException mue) {
			Message.logOut("One part of the JMXServiceURL is syntactically incorrect, " +
					"or host is null and it is not possible to find the local host name, " + 
					"or port is negative");
			mue.printStackTrace();
		}

		boolean connected = false;
		int attempts = 0;
		while (connected == false && attempts < 30) {        
			try {
				Message.logOut("Trying to connect using JMXConnectorFactory");
				connector = JMXConnectorFactory.connect(address);
				connected = true;
			} catch (IOException ie) {
				// If we didn't connect, keep trying - the JVM being monitored might not be 
				// ready to accept connections yet.
				try {           	  
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					Message.logOut("The sleeping profiler was interrupted");
					e.printStackTrace();
				}

				Message.logOut("Monitored VM not ready at " + 
						DateFormat.getDateTimeInstance().format(new Date()) +
						" (attempt " + attempts + ").");
				Message.logOut("Wait 10 secs and trying again...");	

				attempts++;           	
				connected = false;

				if (attempts == 30) {
					Message.logOut("Failed to connect to Monitored VM after "
							+ "30 attempts - giving up.  IOException received is below:");	 
					ie.printStackTrace();        	  	  
				}
			} 
		}

		if (connected) {
			Message.logOut("Connection established!");
			try {   
				this.mbs = connector.getMBeanServerConnection();
				// Find out if we're running on an IBM JVM
				setIfIBM();
			} catch (IOException ie) {
				Message.logOut("Problem setting IBM extensions flag");
				ie.printStackTrace();
			} 
		}
	}

	private void getSecureServerConnection(String user, String pw) {
		// Define a JMX connector and connect to it securely using credentials
		JMXConnector connector = null;
		JMXServiceURL address = null;
		Map<String, String[]> props = null;
		try {
			address = new JMXServiceURL(this.buildServerURL());
		} catch (MalformedURLException mue) {
			Message.logOut("One part of the JMXServiceURL is syntactically incorrect, " +
					"or host is null and it is not possible to find the local host name, " + 
					"or port is negative");
			mue.printStackTrace();
		} 

		props = new HashMap<String, String[]>();
		String[] credentials = new String[] { user, pw };
		props.put("jmx.remote.credentials", credentials);             

		// If we didn't connect keep try - the jvm being monitored might not be 
		// ready to accept connections yet 
		boolean connected = false;
		int attempts = 0;
		while (connected == false && attempts < 30) {        
			try {    
				connector = JMXConnectorFactory.connect(address, props);
				connected = true;
			} catch (IOException ie) {
				try {           	  
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					Message.logOut("The sleeping profiler was interrupted");
					e.printStackTrace();
				}

				Message.logOut("Monitored VM not ready at " + DateFormat.getDateTimeInstance().format(new Date()) +" (attempt " + attempts + ").");
				Message.logOut("Wait 5 secs and trying again...");	

				attempts++;           	
				connected = false;

				if (attempts == 30) {
					Message.logOut("Failed to connect to Monitored VM after 30 attempts - giving up.  Connection Exception received is below:");	 
					ie.printStackTrace();        	  	  
				}
			} 
		}

		try {
			// Find out if we're running on an IBM JVM
			if (connected == true) {	
				Message.logOut("Connection established!");
				this.mbs = connector.getMBeanServerConnection();
				setIfIBM();
			}
		} catch (IOException ie) {
			Message.logOut("Problem setting IBM extensions flag");
			ie.printStackTrace();
		}

	}

	// If we are running on an IBM JVM, we will want to renew our connection to make use 
	// of the IBM-specific functionality
	public MBeanServerConnection getNewConnection() {
		if (secure) {
			if (mbs == null) {
				getSecureServerConnection(user,pw);
			}
			return mbs;
		} else {
			if (mbs == null) {
				getServerConnection();
			}
			return mbs;
		}
	}

	private void setIfIBM() throws IOException {
		// Find out from the Runtime bean if we are running on an IBM JVM
		RuntimeMXBean runtimeBean = ManagementFactory.newPlatformMXBeanProxy(mbs, 
				ManagementFactory.RUNTIME_MXBEAN_NAME,
				RuntimeMXBean.class);
		String vendor = runtimeBean.getVmVendor();
		
		if (vendor.contains("OpenJ9")) {
			ibm = true;
		} else {
			ibm = false;
		}
	}

	public boolean isIbm () {
		return ibm;
	}
}
