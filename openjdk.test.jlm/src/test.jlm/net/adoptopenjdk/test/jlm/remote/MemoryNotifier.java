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

/*
 * This java source file contains the MemoryNotifier class, 
 * this class records when the thresholds are exceeded.
 */
package net.adoptopenjdk.test.jlm.remote;

import java.lang.management.*;
import javax.management.*;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.resources.*;

import java.io.*;

import java.util.Set;

import java.lang.reflect.UndeclaredThrowableException; 
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;

public class MemoryNotifier extends ServerConnector {

	private String              logFile;
	private Integer             usageThreshold;
	private Integer             collectThreshold;
	private MemoryMXBean        memoryBean;
	private NotificationEmitter emitter;
	private MemoryListener      listener;

	private MemoryNotifier(boolean useProxy, String logFile, 
			Integer usageThreshold, Integer collectThreshold, 
			String host, int port) {
		// Create the Data resources needed to collect the stats.
		super( useProxy, host, port );
		this.usageThreshold = usageThreshold;
		this.collectThreshold = collectThreshold;
		this.logFile = logFile;
		this.setServerThresholds();
	}

	private MemoryNotifier(boolean useProxy, String logFile, String user, 
			String pw, Integer usageThreshold, Integer collectThreshold, 
			String host, int port) {
		// Create the Data resources needed to collect the stats.
		super( useProxy, user, pw, host, port );
		this.usageThreshold = usageThreshold;
		this.collectThreshold = collectThreshold;
		this.logFile = logFile;
		this.setServerThresholds();
	}

	private static void usage() {
		TestArgs.usageNotifier( "MemoryNotifier" );
		Assert.fail("Wrong input parameter provided");
	}

	public static void main (String[] args) {
		MemoryNotifier notifier = null;
		if (TestArgs.parseArgsWithThresholds( args)) {
			if ( TestArgs.isUseAuthorisation() ) {
				notifier = new MemoryNotifier( true,
						TestArgs.getLogPathname(),
						TestArgs.getUsername(), TestArgs.getPassword(),
						TestArgs.getUsageThreshold(), 
						TestArgs.getCollectionThreshold(),
						TestArgs.getHost(), TestArgs.getPort() );
			}
			else {
				notifier = new MemoryNotifier( true,
						TestArgs.getLogPathname(),
						TestArgs.getUsageThreshold(), 
						TestArgs.getCollectionThreshold(),
						TestArgs.getHost(), TestArgs.getPort() );
			}
		}
		else {
			usage();
		}

		Assert.assertTrue("Notifier is null", notifier != null);

		// Initialize the Notifier
		// Note: we only do proxy connection for this test. 
		notifier.initNotifier();
	}

	private void setServerThresholds() {
		try {
			Set<?> memPoolNames  = this.mbs.queryNames(new ObjectName(
					ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*"), null);

			File log = new File(this.logFile);
			PrintWriter out = new PrintWriter(new FileWriter(log, false));

			// Get a MXBean Proxy for each of the names returned, use the proxy to access the MXBeans
			for (Object memPoolName : memPoolNames) {
				ObjectName memPool = (ObjectName) memPoolName;

				MemoryPoolMXBean memPoolBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, memPool.toString(),
						MemoryPoolMXBean.class);
				if (memPoolBean.getType() == MemoryType.HEAP) {
					out.println("MEMORY POOL: " + memPoolBean.getName());
					if (memPoolBean.isCollectionUsageThresholdSupported()) {
						memPoolBean.setCollectionUsageThreshold(this.collectThreshold);
						out.println("  Collection threshold set to " + memPoolBean.getCollectionUsageThreshold());
					} else {
						out.println("  Collection threshold not supported.");
					}

					if (memPoolBean.isUsageThresholdSupported()) {
						memPoolBean.setUsageThreshold(this.usageThreshold);
						out.println("  Usage threshold set to " + memPoolBean.getUsageThreshold());
					} else {
						out.println("  Usage threshold not supported.");
					}

					out.println();
				}
			}
			out.close();
		} catch (IOException ioe) {
			Message.logOut("A communication problem occurred when accessing the MBeanServerConnection, ");
			Message.logOut("or there was a problem writing to the log file");
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection, "
					+ "or there was a problem writing to the log file");
		} catch (MalformedObjectNameException mone) {
			Message.logOut("Problem with creating the ObjectName for a MXBean");
			mone.printStackTrace();
			Assert.fail("Problem with creating the ObjectName for a MXBean");
		}
	}

	private void initNotifier() {
		try {	
			this.memoryBean = ManagementFactory.newPlatformMXBeanProxy(
					this.mbs, ManagementFactory.MEMORY_MXBEAN_NAME,
					MemoryMXBean.class);
		} catch (IOException ioe) {
			Message.logOut("A communication problem occurred when accessing the MBeanServerConnection");
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection");
		}

		// Define the emitter, listener and add the listener
		this.emitter = (NotificationEmitter) this.memoryBean;
		this.listener = new MemoryListener(logFile, this.mbs, this);
		this.emitter.addNotificationListener(this.listener, null, null);

		try {
			for (int writesCnt = 0; writesCnt < 120; ++writesCnt) {
				Thread.sleep(1000); 
				// Use the isVerbose call to ping the proxy to ensure it still exists
				this.memoryBean.isVerbose();
			}
			Message.logOut("MemoryNotifier is Done.");
		} catch (InterruptedException ie) {
			Message.logOut("The sleeping profiler was interrupted");
			ie.printStackTrace();
			Assert.fail("The sleeping profiler was interrupted");
		} catch (UndeclaredThrowableException ue) {
			// If the exception was caused by a Connect or Unmarshal Exception, assume the 
			// monitored JVM has finished.
			Throwable cause = ue.getCause();
			Class<ConnectException>     connectExcept = ConnectException.class;
			Class<UnmarshalException>     unmarshalExcept = UnmarshalException.class;

			if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
				Assert.fail("Problem connecting to the JVM to be monitored");
			} else { 
				ue.printStackTrace();
				Assert.fail(ue.getMessage());
			}
		}
	}
}
