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
 * This java source file contains the MemoryProfiler class, 
 * this class create a profile of the heap usage, and    
 * retrieves memory related information regularly from a remote VM.
 */
package net.adoptopenjdk.test.jlm.remote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.LoggingMXBean;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.resources.EnvironmentData;
import net.adoptopenjdk.test.jlm.resources.Message;
import net.adoptopenjdk.test.jlm.resources.MemoryData;

public class MemoryProfiler extends ServerConnector {

	private PrintWriter     csv;
	private EnvironmentData envData;
	private MemoryData      memoryData;

	private MemoryProfiler(boolean useProxy, String logFile, 
			String csvFile, String hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super( useProxy, hostName, portNumber );
		this.envData = new EnvironmentData(this, logFile);
		this.memoryData  = new MemoryData(this, logFile);
		createCSVFile(csvFile);
	}

	private MemoryProfiler(boolean useProxy, String logFile, 
			String csvFile, String user, String pw, 
			String hostName, int portNumber) {
		// Create the Data resources needed to collect the stats.
		super( useProxy, user, pw, hostName, portNumber );
		this.envData = new EnvironmentData(this, logFile);
		this.memoryData  = new MemoryData(this, logFile);
		createCSVFile(csvFile);
	}

	private static void usage() {
		TestArgs.usageProfiler( "MemoryProfiler" );
		Assert.fail("The input arguments is not valid");
	}

	public static void main (String[] args) {
		MemoryProfiler profiler = null;

		if ( TestArgs.parseArgs( args ) ) {
			if ( TestArgs.isUseAuthorisation() ) {
				profiler = new MemoryProfiler( TestArgs.isUseProxy(),
						TestArgs.getLogPathname(), TestArgs.getCSVPathname(),
						TestArgs.getUsername(), TestArgs.getPassword(),
						TestArgs.getHost(), TestArgs.getPort() );
			} else {
				profiler = new MemoryProfiler( TestArgs.isUseProxy(),
						TestArgs.getLogPathname(), TestArgs.getCSVPathname(),
						TestArgs.getHost(), TestArgs.getPort() );
			}
		} else {
			usage();
		}

		Assert.assertTrue("MemoryProfiler is null", profiler != null);

		// Collect Stats differently depending on whether 'proxy' or 'server' has been chosen
		if (TestArgs.isUseProxy()) {
			profiler.getStatsViaProxy();
		}  else {
			profiler.getStatsViaServer();
		} 
	}

	private void getStatsViaProxy() {
		RuntimeMXBean runtimeBean = null;
		OperatingSystemMXBean osBean = null;
		LoggingMXBean logBean = null;
		MemoryMXBean memoryBean = null;
		List<MemoryPoolMXBean> memPoolBeans = new ArrayList<MemoryPoolMXBean>();
		List<MemoryManagerMXBean> memMgrBeans = new ArrayList<MemoryManagerMXBean>();
		List<GarbageCollectorMXBean> gcBeans = new ArrayList<GarbageCollectorMXBean>();

		// Get the proxies for the runtime, os, log, memory MXBeans
		try {
			runtimeBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.RUNTIME_MXBEAN_NAME,
					RuntimeMXBean.class);
			osBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
					OperatingSystemMXBean.class);
			logBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, LogManager.LOGGING_MXBEAN_NAME,
					LoggingMXBean.class);
			memoryBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.MEMORY_MXBEAN_NAME,
					MemoryMXBean.class);

			Set<?> memPoolNames  = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*"), null);

			// Get a MXBean Proxy for each of the names returned, use the proxy to access the MXBeanS
			for (Object memPoolName : memPoolNames){
				ObjectName memPool = (ObjectName) memPoolName;
				MemoryPoolMXBean memPoolBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, memPool.toString(),
						MemoryPoolMXBean.class);
				memPoolBeans.add(memPoolBean);
			}

			Set<?> memMgrNames  = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",*"), null);

			// Get a MXBean Proxy for each of the names returned, use the proxy to access the MXBeanS
			for (Object memMgrName : memMgrNames){
				ObjectName memMgr = (ObjectName) memMgrName;
				MemoryManagerMXBean memMgrBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, memMgr.toString(),
						MemoryManagerMXBean.class);
				memMgrBeans.add(memMgrBean);
			}

			Set<?> gcNames  = this.mbs.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);

			// Get a MXBean Proxy for each of the names returned, use the proxy to access the MXBeanS
			for (Object gcName : gcNames){
				ObjectName gc = (ObjectName) gcName;
				GarbageCollectorMXBean gcBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, gc.toString(),
						GarbageCollectorMXBean.class);
				gcBeans.add(gcBean);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection");
		} catch (MalformedObjectNameException mone) {
			mone.printStackTrace();
			Assert.fail("Problem with creating the ObjectName for a MXBean");
		}

		try {
			Message.logOut("Starting to write data");
			this.envData.writeData (runtimeBean, osBean, logBean, false);

			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the methodData every 10 seconds
				if (secondsCnt == 10) {
					System.out.print(".");
					this.memoryData.writeData(memoryBean, memMgrBeans, memPoolBeans, gcBeans, true);
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordMemoryStats(runtimeBean, memoryBean, writesCnt);
				Thread.sleep(1000);
				secondsCnt++;
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			Assert.fail("The sleeping profiler was interrupted");
		} catch (UndeclaredThrowableException ue) {
			// If the exception was caused by a Connect or Unmarshal Exception, assume the 
			// monitored JVM has finished.
			Throwable cause = ue.getCause();
			Class<ConnectException>     connectExcept = ConnectException.class;
			Class<UnmarshalException>     unmarshalExcept = UnmarshalException.class;

			if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
				this.closeCSVFile();
				Message.logOut("Exiting as JVM we are connected to has finished");
			}
			else { 
				Message.logOut("Rethrowing UndeclaredThrowableException");
			}
			Assert.fail();
		} finally {
			this.closeCSVFile();
		}
	}

	private void getStatsViaServer() {
		ObjectName srvRuntimeName = null;
		ObjectName srvOSName = null;
		ObjectName srvLogName = null;
		ObjectName srvMemName = null;

		Set<?> srvMemMgrNames = null;
		Set<?> srvMemPoolNames = null;
		Set<?> srvGCNames = null;

		try {
			// Create the ObjectNames required for memory and environment data
			srvRuntimeName = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
			srvOSName = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
			srvLogName = new ObjectName(LogManager.LOGGING_MXBEAN_NAME);
			srvMemName = new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME);
			srvMemMgrNames  = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",*"), null);
			srvMemPoolNames = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*"), null);
			srvGCNames      = this.mbs.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			Assert.fail("A communication problem occurred when accessing the MBeanServerConnection");
		} catch (MalformedObjectNameException mone) {
			mone.printStackTrace();
			Assert.fail("Problem with creating the ObjectName for a MXBean");
		}

		// The first time we write to the file, 'append' needs to be false .
		// From the second time onwards, it needs to be true
		try {
			Message.logOut("Starting to write data");
			this.envData.writeData(this.mbs, srvRuntimeName, srvOSName, srvLogName, false);
			int secondsCnt = 0;
			int writesCnt = 0;
			while (writesCnt < 30) {
				// Write out the full memory data 10 seconds to the log file
				if (secondsCnt == 10) {
					this.memoryData.writeData(this.mbs, srvMemName, srvMemMgrNames, srvMemPoolNames, srvGCNames, true);
					secondsCnt = 0;
					writesCnt++;
				}
				this.recordMemoryStats(srvRuntimeName, srvMemName, writesCnt);
				Thread.sleep(1000);
				secondsCnt++;
			}
		} catch (ConnectException ce) {
			this.closeCSVFile();
			Assert.fail("Exiting as JVM we are connected to has finished");
		} catch (UnmarshalException ue) {
			this.closeCSVFile();
			Assert.fail("Exiting as JVM we are connected to has finished");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			Assert.fail("The sleeping profiler was interrupted");
		} finally {
			this.closeCSVFile();
		}
	}

	private void createCSVFile(String csvFile) {
		try {
			// Open the cvs file
			this.csv = new PrintWriter(new FileWriter(new File(csvFile), true));

			// Write headings to file
			this.csv.println("Time (seconds),Heap Memory Usage, Memory retrive times");
		} catch (IOException ie) {
			ie.printStackTrace();
			Assert.fail("Unable to write to file " + csvFile);
		}
	}

	private void recordMemoryStats (RuntimeMXBean rb, MemoryMXBean mb, int writeCount) {
		DecimalFormat df = new DecimalFormat("#0.00"); // print out all times to 2 d.p.

		// Write heap usage to file
		this.csv.println( df.format( rb.getUptime() / 1000 ) + "," + 
				(mb.getHeapMemoryUsage()).getUsed() + ", write " + writeCount + " times");
	}

	private void recordMemoryStats(ObjectName rb, ObjectName mb, int writeCount) throws ConnectException, UnmarshalException {
		DecimalFormat df = new DecimalFormat("#0.00"); // print out all times to 2 d.p.
		try {
			CompositeData  cd = (CompositeData) this.mbs.getAttribute(mb, "HeapMemoryUsage"); 
			long memoryUsage = (MemoryUsage.from(cd)).getUsed();
			long upTime = (Long)this.mbs.getAttribute(rb, "Uptime");

			// Write heap usage to file
			this.csv.println( df.format( upTime / 1000 ) + "," + memoryUsage  + 
					", write " + writeCount + " times");
		} catch (ConnectException ce) {
			Assert.fail("ConnectException: \n" + ce.getMessage());
		} catch (UnmarshalException ue) {
			Assert.fail("UnmarshalException: \n" + ue.getMessage());
		} catch (IOException ie) {
			ie.printStackTrace();
			Assert.fail("Problem with the MBean access");
		} catch (MBeanException mbe) {
			mbe.printStackTrace();
			Assert.fail("Problem with the MBean access");
		} catch (AttributeNotFoundException ae) {
			ae.printStackTrace();
			Assert.fail("Attribute does not exist on the MBean");
		} catch (InstanceNotFoundException ie) {
			ie.printStackTrace();
			Assert.fail("MBean Instance not found");
		} catch (ReflectionException re) {
			re.printStackTrace();
			Assert.fail("Problem with the reflection of the MBean");
		}
	}

	// This needs to be called to flush the file, otherwise it will probably result
	// in an empty CSV file (as so little date is usually written (16 bytes, 30 times)
	private void closeCSVFile() {
		this.csv.close(); 
	}
}
