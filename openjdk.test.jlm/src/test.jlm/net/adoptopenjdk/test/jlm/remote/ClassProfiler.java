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
 * This java source file contains the ClassProfiler class. 
 * This class creates a profile of the classes loaded, and    
 * retrieves class related information regularly from a remote VM
 */
package net.adoptopenjdk.test.jlm.remote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.LoggingMXBean;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.resources.ClassData;
import net.adoptopenjdk.test.jlm.resources.EnvironmentData;
import net.adoptopenjdk.test.jlm.resources.Message;

public class ClassProfiler extends ServerConnector {
	private PrintWriter csv;
	private EnvironmentData envData;
	private ClassData classData;

	private ClassProfiler(boolean useProxy, String logFile, String 
			csvFile, String hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.classData = new ClassData(this, logFile);
		createCSVFile(csvFile);
	}

	private ClassProfiler(boolean useProxy, String logFile, String csvFile, 
			String user, String pw, String hostName,
			int portNumber) {
		// Create the Data resources needed to collect the stats.
		super(useProxy, user, pw, hostName, portNumber);
		this.envData = new EnvironmentData(this, logFile);
		this.classData = new ClassData(this, logFile);
		createCSVFile(csvFile);
	}

	private static void usage() {
		TestArgs.usageProfiler("ClassProfiler");
		Assert.fail("Usage error");
	}

	public static void main(String[] args) {
		ClassProfiler profiler = null;
		if (TestArgs.parseArgs(args)) {
			if (TestArgs.isUseAuthorisation()) {
				profiler = new ClassProfiler(TestArgs.isUseProxy(), TestArgs.getLogPathname(),
						TestArgs.getCSVPathname(), TestArgs.getUsername(), TestArgs.getPassword(), TestArgs.getHost(),
						TestArgs.getPort());
			} else {
				profiler = new ClassProfiler(TestArgs.isUseProxy(), TestArgs.getLogPathname(),
						TestArgs.getCSVPathname(), TestArgs.getHost(), TestArgs.getPort());
			}
		} else {
			usage();
		}

		// Collect Stats differently depending on whether 'proxy' or 'server' has been chosen
		Assert.assertTrue("ClassProfiler is null", profiler != null);
		
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
		ClassLoadingMXBean classBean = null;
		CompilationMXBean compBean = null;

		// Get the proxies for the runtime, os, log and class MXBeans
		try {
			runtimeBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.RUNTIME_MXBEAN_NAME,
					RuntimeMXBean.class);

			osBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
					OperatingSystemMXBean.class);

			logBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, LogManager.LOGGING_MXBEAN_NAME,
					LoggingMXBean.class);

			classBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.CLASS_LOADING_MXBEAN_NAME,
					ClassLoadingMXBean.class);

			// Check the compiler is being used and get the compilation MXBean
			Map<String, String> props = runtimeBean.getSystemProperties();
			String sys_comp = props.get("java.compiler");

			if ((sys_comp != null) && (!(sys_comp.equals("")))) {
				compBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.COMPILATION_MXBEAN_NAME,
						CompilationMXBean.class);
			}
		} catch (IOException ioe) {
			Message.logOut("A communication problem occurred when accessing the MBeanServerConnection");
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection");
		}

		try {
			Message.logOut("Starting to write data");
			// Record the environment data in the log
			this.envData.writeData(runtimeBean, osBean, logBean, false);

			// Record the number of class loaded over time in a csv and record
			// the class data in the log every 10 seconds
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the threadData every 10 seconds
				if (secondsCnt == 10) {
					System.out.print(".");
					this.classData.writeData(classBean, compBean, runtimeBean, true);
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordClassStats(runtimeBean, classBean);
				Thread.sleep(1000);
				secondsCnt++;
			}
		} catch (InterruptedException ie) {
			Message.logOut("The sleeping profiler was interrupted");
			ie.printStackTrace();
			Assert.fail("The sleeping profiler was interrupted");
		} catch (UndeclaredThrowableException ue) {
			Throwable cause = ue.getCause();
			Class<ConnectException> connectExcept = ConnectException.class;
			Class<UnmarshalException> unmarshalExcept = UnmarshalException.class;

			if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
				
				// If the exception was caused by a Connect or Unmarshal
				// Exception, assume the monitored JVM has finished. 
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
		ObjectName srvClassName = null;
		ObjectName srvCompName = null;

		try {
			// Set up the ObjectName needed to reference the ThreadMXBean,
			// RuntimeMXBean and OperatingSystemMXBean
			srvRuntimeName = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
			srvOSName = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
			srvLogName = new ObjectName(LogManager.LOGGING_MXBEAN_NAME);
			srvClassName = new ObjectName(ManagementFactory.CLASS_LOADING_MXBEAN_NAME);

			TabularData cd_props = (TabularData)mbs.getAttribute(srvRuntimeName, "SystemProperties");
			String[] key_array = { "java.compiler" };
			CompositeData cd = cd_props.get((Object[])key_array);

			// Check the compiler is in use and get the ObjectName for CompilationMXBean
			if (cd == null) {
				srvCompName = new ObjectName(ManagementFactory.COMPILATION_MXBEAN_NAME);
			} else {
				String sys_comp = (String)cd.get("value");
				if ((sys_comp != null) && (!(sys_comp.equals("")))) {
					srvCompName = new ObjectName(ManagementFactory.COMPILATION_MXBEAN_NAME);
				}
			}
		} catch (MalformedObjectNameException mone) {
			Message.logOut("Problem with creating the ObjectName for a MXBean");
			mone.printStackTrace();
			Assert.fail("Problem with creating the ObjectName for a MXBean");
		} catch (IOException ie) {
			Message.logOut("Problem with server connection");
			ie.printStackTrace();
			Assert.fail("Problem with server connection");
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

		// The first time we write to the file, 'append' needs to be false.
		// From the second time onwards, it needs to be true
		try {
			this.envData.writeData(this.mbs, srvRuntimeName, srvOSName, srvLogName, false);
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the threadData every 10 seconds
				if (secondsCnt == 10) {
					this.classData.writeData(this.mbs, srvClassName, srvCompName, srvRuntimeName, true);
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordClassStats(srvRuntimeName, srvClassName);
				Thread.sleep(1000);
				secondsCnt++;
			}

			// If the exception is a Connect or Unmarshal Exception, assume the
			// monitored JVM has finished 
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
			// write headings to file
			this.csv.println("Time (seconds), Loaded Class Count, Total Loaded Class Count, Unloaded Class Count");
		} catch (IOException ie) {
			Message.logOut("Unable to write to file " + csvFile);
			ie.printStackTrace();
			Assert.fail("Unable to write to file " + csvFile);			
		}
	}

	private void recordClassStats(RuntimeMXBean rb, ClassLoadingMXBean cb) {
		// Print out time in 2 d.p.
		DecimalFormat df = new DecimalFormat("#0.00"); 
		// Write stats to file
		this.csv.println(df.format(rb.getUptime() / 1000) + "," + cb.getLoadedClassCount() + ","
				+ cb.getTotalLoadedClassCount() + "," + cb.getUnloadedClassCount());
	}

	private void recordClassStats(ObjectName rb, ObjectName cb) {
		// Print out time in 2 d.p.
		DecimalFormat df = new DecimalFormat("#0.00");  
		try {
			int classCount = (Integer)this.mbs.getAttribute(cb, "LoadedClassCount");
			long loadedCount = (Long)this.mbs.getAttribute(cb, "TotalLoadedClassCount");
			long unloadedCount = (Long)this.mbs.getAttribute(cb, "UnloadedClassCount");
			long upTime = (Long)this.mbs.getAttribute(rb, "Uptime");

			// Write class data to file
			this.csv.println(df.format(upTime / 1000) + "," + classCount + "," + 
							loadedCount + "," + unloadedCount);
		} catch (ConnectException ce) {
			Message.logOut("Problem with the MBean access");
			ce.printStackTrace();
			Assert.fail("Problem with the MBean access");
		} catch (UnmarshalException ue) {
			Message.logOut("Problem with the MBean access");
			ue.printStackTrace();
			Assert.fail("Problem with the MBean access");
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
