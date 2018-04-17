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
 * This java source file contains the ThreadProfiler class, 
 * this class create a profile of the thread count, and    
 * retrieves thread related information regularly from a remote VM.
 */
package net.adoptopenjdk.test.jlm.remote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DecimalFormat;
import java.util.logging.LogManager;
import java.util.logging.LoggingMXBean;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.resources.EnvironmentData;
import net.adoptopenjdk.test.jlm.resources.Message;
import net.adoptopenjdk.test.jlm.resources.ThreadData;

import java.lang.management.OperatingSystemMXBean;

public class ThreadProfiler extends ServerConnector {
	private PrintWriter csv;
	private EnvironmentData envData;
	private ThreadData threadData;

	private ThreadProfiler(boolean useProxy, String logFile, String csvFile, String hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.threadData = new ThreadData(this, logFile);
		createCSVFile(csvFile);
	}

	private ThreadProfiler(boolean useProxy, String logFile, String csvFile, String user, String pw, String hostName,
			int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, user, pw, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.threadData = new ThreadData(this, logFile);
		createCSVFile(csvFile);
	}

	private static void usage() {
		TestArgs.usageProfiler("ThreadProfiler");
		Assert.fail("Usage error");
	}

	public static void main(String[] args) {
		ThreadProfiler profiler = null;
		if (TestArgs.parseArgs(args)) {
			if (TestArgs.isUseAuthorisation()) {
				profiler = new ThreadProfiler(TestArgs.isUseProxy(), TestArgs.getLogPathname(),
						TestArgs.getCSVPathname(), TestArgs.getUsername(), TestArgs.getPassword(), 
						TestArgs.getHost(), TestArgs.getPort());
			} else {
				profiler = new ThreadProfiler(TestArgs.isUseProxy(), TestArgs.getLogPathname(),
						TestArgs.getCSVPathname(), TestArgs.getHost(), TestArgs.getPort());
			}
		} else {
			usage();
		}

		// Collect Stats differently depending on whether 'proxy' or 'server' has been chosen
		Assert.assertTrue("ThreadProfiler is null", profiler != null);

		if (TestArgs.isUseProxy()) {
			profiler.getStatsViaProxy();
		} else {
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
			Message.logOut("A communication problem occurred when accessing the MBeanServerConnection");
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection");
		}

		try {
			Message.logOut("Starting to write data");
			this.envData.writeData(runtimeBean, osBean, logBean, false);
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the threadData 10 seconds
				if (secondsCnt == 10) {
					System.out.print(".");
					this.threadData.writeData(threadBean, stackDepth, true);
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
			Assert.fail("The sleeping profiler was interrupted");
		} catch (UndeclaredThrowableException ue) {
			// If the exception was caused by a Connect or Unmarshal Exception
			// assume the monitored JVM has finished.
			Throwable cause = ue.getCause();
			Class<ConnectException> connectExcept = ConnectException.class;
			Class<UnmarshalException> unmarshalExcept = UnmarshalException.class;

			if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
				this.closeCSVFile();
				Message.logOut("Exiting as JVM we are connected to has finished");
				Assert.fail("Exiting as JVM we are connected to has finished");
			} else {
				Message.logOut(ue.getMessage());
				ue.printStackTrace();
				Assert.fail(ue.getMessage());
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
			Assert.fail("Problem with creating the ObjectName for a MXBean");
		}

		// The first time we write to the file, 'append' needs to be false -
		// from the second time onwards, it needs to be true.
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
		// monitored JVM has finished.
		} catch (ConnectException ce) {
			this.closeCSVFile();
			Message.logOut("Exiting as JVM we are connected to has finished");
			Assert.fail("Exiting as JVM we are connected to has finished");
		} catch (UnmarshalException ue) {
			this.closeCSVFile();
			Message.logOut("Exiting as JVM we are connected to has finished");
			Assert.fail("Exiting as JVM we are connected to has finished");
		} catch (InterruptedException ie) {
			Message.logOut("The sleeping profiler was interrupted");
			ie.printStackTrace();
			Assert.fail("The sleeping profiler was interrupted");
		} finally {
			this.closeCSVFile();
		}
	}

	private void createCSVFile(String csvFile) {
		try {
			// Open the cvs file
			this.csv = new PrintWriter(new FileWriter(new File(csvFile), false));
			// Write headings to file
			this.csv.println("Time (seconds),Thread count");
		} catch (IOException ie) {
			Message.logOut("Unable to write to file " + csvFile);
			ie.printStackTrace();
			Assert.fail("Unable to write to file " + csvFile);
		}
	}

	private void recordThreadStats(RuntimeMXBean rb, ThreadMXBean tb) {
		DecimalFormat df = new DecimalFormat("#0.00"); // Print out time stamp to 2 d.p.
		// Write thread count to file
		this.csv.println(df.format(rb.getUptime() / 1000) + "," + tb.getThreadCount());
	}

	private void recordThreadStats(ObjectName rb, ObjectName tb) {
		DecimalFormat df = new DecimalFormat("#0.00"); // Print out time stamp to 2 d.p.
		try {
			int threadCount = (Integer)this.mbs.getAttribute(tb, "ThreadCount");
			long upTime = (Long)this.mbs.getAttribute(rb, "Uptime");

			// Write thread count to file
			this.csv.println(df.format(upTime / 1000) + "," + threadCount);
		} catch (ConnectException ce) {
			Message.logOut(ce.getMessage());
			ce.printStackTrace();
			Assert.fail(ce.getMessage());
		} catch (UnmarshalException ue) {
			Message.logOut(ue.getMessage());
			ue.printStackTrace();
			Assert.fail(ue.getMessage());
		} catch (IOException ie) {
			Message.logOut("Problem with the MBean access");
			ie.printStackTrace();
			Assert.fail("Problem with the MBean access");
		} catch (MBeanException mbe) {
			Message.logOut("Problem with the MBean access");
			mbe.printStackTrace();
			Assert.fail("Problem with the MBean access");
		} catch (AttributeNotFoundException ae) {
			Message.logOut("Attribute does not exist on the MBean");
			ae.printStackTrace();
			Assert.fail("Attribute does not exist on the MBean");
		} catch (InstanceNotFoundException ie) {
			Message.logOut("MBean Instance not found");
			ie.printStackTrace();
			Assert.fail("MBean Instance not found");
		} catch (ReflectionException re) {
			Message.logOut("Problem with the reflection of the MBean");
			re.printStackTrace();
			Assert.fail("Problem with the reflection of the MBean");
		}
	}

	private void closeCSVFile() {
		this.csv.close();
	}
}
