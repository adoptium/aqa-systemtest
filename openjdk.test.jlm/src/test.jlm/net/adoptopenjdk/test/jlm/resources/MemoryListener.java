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
 * This java source file contains the MemoryListener class, a
 * basic listener for receiving MemoryNotificationInfo.
 */
package net.adoptopenjdk.test.jlm.resources;

import net.adoptopenjdk.test.jlm.remote.*;
import net.adoptopenjdk.test.jlm.resources.EnvironmentData;
import net.adoptopenjdk.test.jlm.resources.Message;
import net.adoptopenjdk.test.jlm.resources.MemoryData;

import java.util.logging.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

import org.junit.Assert;

import java.util.Date;
import java.text.DateFormat;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

import java.rmi.ConnectException;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.UnmarshalException;

public class MemoryListener implements javax.management.NotificationListener {
	String logFile;
	boolean append;
	int usageNotif;
	int collectNotif;
	MBeanServerConnection mbs;
	ServerConnector parent;

	public MemoryListener(String logFile, MBeanServerConnection mbs, ServerConnector parent) {
		this.logFile = logFile;
		this.append = true;
		this.mbs = mbs;
		this.parent = parent;
		PrintWriter out = null;

		try {
			File log = new File(logFile);
			out = new PrintWriter(new FileWriter(log, this.append));
		} catch (IOException ie) {
			Message.logOut("Unable to write to file " + logFile);
			ie.printStackTrace();
			Assert.fail("Unable to write to file " + logFile);
		}

		out.println("Memory Notification Listener started at " + DateFormat.getDateTimeInstance().format(new Date()));
		out.println("");
		out.println("");
		out.close();
	}

	public void handleNotification(Notification notif, Object handback) {
		String notifType = notif.getType();

		// If the notification type is not one of the two supported by java.lang.management then simply return 
		if (notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED) || 
				notifType.equals(MemoryNotificationInfo.MEMORY_COLLECTION_THRESHOLD_EXCEEDED)) {
			// Retrieve the memory notification information
			CompositeData cd = (CompositeData) notif.getUserData();
			MemoryNotificationInfo info = MemoryNotificationInfo.from(cd);
			PrintWriter out = null;

			try {
				File log = new File(logFile);
				out = new PrintWriter(new FileWriter(log, append));
				append = true;
			} catch (IOException ie) {
				Message.logOut("Unable to write to file " + logFile);
				ie.printStackTrace();
				Assert.fail("Unable to write to file " + logFile);
			}

			// Write timestamp and notification information to the log 
			out.println("Notification Trigger:        " + info.getPoolName()); 
			out.println("");
			out.println("Notification Triggered at:   " + DateFormat.getDateTimeInstance().format(new Date()));

			if (notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) {
				out.println("Notification Trigger Type:   Usage");
			} else if (notifType.equals(MemoryNotificationInfo.MEMORY_COLLECTION_THRESHOLD_EXCEEDED)) {
				out.println("Notification Trigger Type:   Collection");
			} else {
				out.println("Notification Trigger Type:   Unknown");
			}
			
			out.println("No Times Threshold Exceeded: " + info.getCount());
			out.println("Pool's Current Usage:        " + info.getUsage());
			out.println("");
			out.println("");

			// Create the environment and memory data objects for use later
			EnvironmentData envData    = new EnvironmentData(logFile);
			MemoryData      memoryData = new MemoryData(this.parent, logFile);

			out.close();

			// If the memory threshold was exceeded list memory pool, memory manager and
			// gc information using a proxy
			if (notifType.equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)) {
				RuntimeMXBean runtimeBean = null;
				OperatingSystemMXBean osBean = null;
				MemoryMXBean memoryBean = null;
				LoggingMXBean logBean = null;
				List<MemoryPoolMXBean> memPoolBeans = new ArrayList<MemoryPoolMXBean>();
				List<MemoryManagerMXBean> memMgrBeans = new ArrayList<MemoryManagerMXBean>();
				List<GarbageCollectorMXBean> gcBeans = new ArrayList<GarbageCollectorMXBean>();

				try {
					runtimeBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.RUNTIME_MXBEAN_NAME,
							RuntimeMXBean.class);
					osBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
							java.lang.management.OperatingSystemMXBean.class);
					memoryBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, ManagementFactory.MEMORY_MXBEAN_NAME,
							MemoryMXBean.class);
					logBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, "java.util.logging:type=Logging",
							LoggingMXBean.class);
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

					// Get a MXBean Proxy for each of the names returned, use the proxy to access the MXBeans
					for (Object gcName : gcNames){
						ObjectName gc = (ObjectName) gcName;
						GarbageCollectorMXBean gcBean = ManagementFactory.newPlatformMXBeanProxy(this.mbs, gc.toString(),
								GarbageCollectorMXBean.class);
						gcBeans.add(gcBean);
					}
				} catch (ConnectException ce) {
					// Connection has gone away as monitored application has finished
					Assert.fail("ConnectException: " + ce.getMessage());
				} catch (UnmarshalException ue) {
					// Connection has gone away as monitored application has finished
					Assert.fail("UnmarshalException: " + ue.getMessage());
				} catch (IOException ioe) {
					Message.logOut("Unable to write to file " + logFile);
					ioe.printStackTrace();
					Assert.fail("Unable to write to file " + logFile);
				} catch (MalformedObjectNameException mone) {
					Message.logOut("Problem with creating the ObjectName for a MXBean");
					mone.printStackTrace();
					Assert.fail("Problem with creating the ObjectName for a MXBean");
				}

				try {               	
					// Write the environment and memory data to the log
					envData.writeData(runtimeBean, osBean, logBean, append);
					memoryData.writeData(memoryBean, memMgrBeans, memPoolBeans, gcBeans, append); 
				} catch ( UndeclaredThrowableException ue) {
					// If the exception was caused by a Connect or Unmarshal Exception assume the 
					// monitored JVM has finished.
					Throwable cause = ue.getCause();
					Class<ConnectException>     connectExcept = ConnectException.class;
					Class<UnmarshalException>     unmarshalExcept = UnmarshalException.class;

					if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
						Assert.fail("ConnectException or UnmarshalException: " + cause.getMessage());
					} else { 
						throw ue;
					}
				} 
			}

			// If the collection threshold was exceeded list memory pool, memory manager and
			// gc information using a server connection
			else {
				ObjectName srvRuntimeName = null;
				ObjectName srvOSName = null;
				ObjectName srvMemName = null;
				ObjectName srvLogName = null;
				Set<?> srvMemMgrNames = null;
				Set<?> srvMemPoolNames = null;
				Set<?> srvGCNames = null;

				// Write the VM Data using MBean Server
				try {
					srvRuntimeName  = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
					srvOSName       = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
					srvMemName      = new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME);
					srvLogName      = new ObjectName("java.util.logging:type=Logging");
					srvMemMgrNames  = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",*"), null);
					srvMemPoolNames = this.mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*"), null);
					srvGCNames      = this.mbs.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);
					envData.writeData(this.mbs, srvRuntimeName, srvOSName, srvLogName, append);
					memoryData.writeData(this.mbs, srvMemName, srvMemMgrNames, srvMemPoolNames, srvGCNames, append);
				} catch ( MalformedObjectNameException me) {
					Message.logOut("Got a MalformedObjectNameException");
					me.printStackTrace();
					Assert.fail("Got a MalformedObjectNameException");
				} catch (ConnectException ce) {
					// Connection has gone away as monitored application has finished
					Assert.fail("ConnectException: " + ce.getMessage());
				} catch (UnmarshalException ue) {
					// Connection has gone away as monitored application has finished
					Assert.fail("UnmarshalException: " + ue.getMessage());
				} catch ( IOException ie ) {
					Message.logOut("Unable to write to file " + logFile);
					ie.printStackTrace();
					Assert.fail("Unable to write to file " + logFile);
				} 
			}

			try {
				File log = new File(logFile);
				out = new PrintWriter(new FileWriter(log, append));
				append = true;
			} catch (IOException ie) {
				Message.logOut("Unable to write to file " + logFile);
				ie.printStackTrace();
				Assert.fail("Unable to write to file " + logFile);
			}

			out.println(""); 
			out.println("**************************************************************************************************************"); 
			out.println(""); 
			out.println(""); 
			out.close();
		}
	}
}
