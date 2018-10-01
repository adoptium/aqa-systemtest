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
 * This java source file contains the ThreadMonitor class, 
 * this class create a profile of the thread count, and    
 * retrieves thread related information regularly from a remote VM.
 */
package net.adoptopenjdk.test.jlm.remote;

import java.util.logging.*;
import java.lang.management.*;
import javax.management.*;

import net.adoptopenjdk.test.jlm.resources.*;

import java.io.*;
import java.text.DecimalFormat;

import java.lang.reflect.UndeclaredThrowableException; 
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;

public class ThreadMonitor extends ServerConnector{
	private PrintWriter     csv;
	private EnvironmentData envData;
	private ThreadData  threadData;

	private ThreadMonitor(boolean useProxy, String logFile, 
			String csvFile, String hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.threadData  = new ThreadData(this, logFile);
		createCSVFile(csvFile);
	}

	private ThreadMonitor(boolean useProxy, String logFile, 
			String csvFile, String user, String pw, String 
			hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, user, pw, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.threadData  = new ThreadData(this, logFile);
		createCSVFile(csvFile);
	}

	private static void usage() {
		TestArgs.usageProfiler("ThreadMonitor");
		System.exit(0);
	}

	public static void main (String[] args) {
		ThreadMonitor profiler=null;
		if (TestArgs.parseArgs(args)) {
			if (TestArgs.isUseAuthorisation()) {
				profiler = new ThreadMonitor(TestArgs.isUseProxy(),
						TestArgs.getLogPathname(), TestArgs.getCSVPathname(),
						TestArgs.getUsername(), TestArgs.getPassword(),
						TestArgs.getHost(), TestArgs.getPort());
			}
			else {
				profiler = new ThreadMonitor(TestArgs.isUseProxy(),
						TestArgs.getLogPathname(), TestArgs.getCSVPathname(),
						TestArgs.getHost(), TestArgs.getPort());
			}
		}
		else {
			usage();
		}

		// Collect Stats differently depending on whether 'proxy' or 'server' has been chosen
		assert profiler != null;
		if (TestArgs.isUseProxy()) {
			profiler.getStatsViaProxy();
		}
		else {
			profiler.getStatsViaServer();
		} 
	}

	private void getStatsViaProxy() {
		RuntimeMXBean runtimeBean = null;
		OperatingSystemMXBean osBean = null;
		LoggingMXBean logBean = null;
		ThreadMXBean threadBean = null;
		int stackDepth = 8;

		// Get the runtime, os, log and thread MXBeans
		try {
			runtimeBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, 
					ManagementFactory.RUNTIME_MXBEAN_NAME, RuntimeMXBean.class);
			osBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, 
					ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
			logBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, 
					LogManager.LOGGING_MXBEAN_NAME, LoggingMXBean.class);
			threadBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, 
					ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);
		} catch (IOException ioe) {
			Message.logOut("A communication problem occurred when "
					+ "accessing the MBeanServerConnection");
			ioe.printStackTrace();
		}

		try {
			this.envData.writeData (runtimeBean, osBean, logBean, false);
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the threadData 10 seconds 
				if (secondsCnt == 10) {
					Message.logOut("Writing report data ...");
					this.threadData.writeData(threadBean, stackDepth, true);
					Message.logOut(" done.");
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordThreadStats(runtimeBean, threadBean);
				Thread.sleep(1000);
				secondsCnt++;
			}
		} catch (InterruptedException ie) {
			Message.logOut("The sleeping profiler was interrupted");
			ie.printStackTrace();
		} catch (UndeclaredThrowableException ue) {
			// if the exception was caused by a Connect or Unmarshal Exception assume the 
			// monitored JVM has finished.
			Throwable cause = ue.getCause();
			Class<ConnectException> connectExcept = ConnectException.class;
			Class<UnmarshalException> unmarshalExcept = UnmarshalException.class;

			if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
				this.closeCSVFile();
				System.exit(0);
			} else { 
				throw ue;
			}
		} finally {
			this.closeCSVFile();
		}
	}

	private void getStatsViaServer() {
		ObjectName srvRuntimeName = null;
		ObjectName srvOSName = null;
		ObjectName srvLogName = null;
		ObjectName srvThrdName = null;
		int stackDepth = 8;
		try {
			// Set up the ObjectName needed to reference the ThreadMXBean, 
			// RuntimeMXBean and OperatingSystemMXBean
			srvRuntimeName = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
			srvOSName = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
			srvLogName = new ObjectName(LogManager.LOGGING_MXBEAN_NAME);
			srvThrdName = new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME);
		} catch (MalformedObjectNameException mone) {
			Message.logOut("Problem with creating the ObjectName for a MXBean");
			mone.printStackTrace();
		}

		// The first time we write to the file, 'append' needs to be false - from the second time 
		// onwards, it needs to be true
		try {
			this.envData.writeData(this.mbs, srvRuntimeName, srvOSName, srvLogName, false);
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the threadData every 10 seconds
				if (secondsCnt == 10) {
					Message.logOut("Writing report data ...");
					this.threadData.writeData(this.mbs, srvThrdName, stackDepth, true);
					Message.logOut(" done.");
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordThreadStats(srvRuntimeName, srvThrdName);
				Thread.sleep(1000);
				secondsCnt++;
			}
			// If the exception is a Connect or Unmarshal Exception assume the 
			// monitored JVM has finished
		} catch (ConnectException ce) {
			this.closeCSVFile();
			System.exit(0);
		} catch (UnmarshalException ue) {
			this.closeCSVFile();
			System.exit(0);
		} catch (InterruptedException ie) {
			Message.logOut("The sleeping profiler was interrupted");
			ie.printStackTrace();
		} finally {
			this.closeCSVFile();
		}
	}

	private void createCSVFile (String csvFile) {
		try {
			// Open the cvs file
			this.csv = new PrintWriter(new FileWriter(new File(csvFile), false),true);
			// write headings to file
			this.csv.println("Time (seconds),Thread count");
		} catch (IOException ie) {
			Message.logOut("Unable to write to file " + csvFile);
			ie.printStackTrace();
		}
	}

	private void recordThreadStats (RuntimeMXBean rb, ThreadMXBean tb) {
		DecimalFormat df = new DecimalFormat("#0.00"); // print out all times to 2 d.p.
		// Write thread count to file
		this.csv.println(df.format(rb.getUptime() / 1000) + "," + tb.getThreadCount());
	}

	private void recordThreadStats(ObjectName rb, ObjectName tb) throws ConnectException, UnmarshalException {
		DecimalFormat df = new DecimalFormat("#0.00"); // print out all times to 2 d.p.
		try {
			int threadCount = (Integer)this.mbs.getAttribute(tb, "ThreadCount");
			long upTime = (Long)this.mbs.getAttribute(rb, "Uptime");
			// Write thread count to file
			this.csv.println(df.format(upTime / 1000) + "," + threadCount);
		} catch (ConnectException ce) {
			throw ce;
		} catch (UnmarshalException ue) {
			throw ue;
		} catch (IOException ie) {
			Message.logOut("Problem with the MBean access");
			ie.printStackTrace();
		} catch (MBeanException mbe) {
			Message.logOut("Problem with the MBean access");
			mbe.printStackTrace();
		} catch (AttributeNotFoundException ae) {
			Message.logOut("Attribute does not exist on the MBean");
			ae.printStackTrace();
		} catch (InstanceNotFoundException ie) {
			Message.logOut("MBean Instance not found");
			ie.printStackTrace();
		} catch (ReflectionException re) {
			Message.logOut("Problem with the reflection of the MBean");
			re.printStackTrace();
		}
	}

	private void closeCSVFile() {
		this.csv.close();
	}
}
