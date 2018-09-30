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

package net.adoptopenjdk.test.jlm.remote;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.junit.Assert;
import com.sun.management.GarbageCollectionNotificationInfo;
import com.sun.management.GcInfo;
import net.adoptopenjdk.test.jlm.resources.Report;

public class GarbageCollectionNotificationTest {

	static final class GCState  { 
		final GarbageCollectorMXBean gcBean; 
		final boolean assumeGCIsPartiallyConcurrent; 
		final boolean assumeGCIsOldGen; 
		long  totalCollectionCount = 0;
		long  totalCollectionDuration = 0; 
		long  lastCollectionID = 0;

		GCState(GarbageCollectorMXBean gcBean, boolean assumeGCIsPartiallyConcurrent, 
				boolean assumeGCIsOldGen) { 
			this.gcBean = gcBean; 
			this.assumeGCIsPartiallyConcurrent = assumeGCIsPartiallyConcurrent; 
			this.assumeGCIsOldGen = assumeGCIsOldGen; 
		} 
	}

	static final Map<String, GCState> gcStates = new HashMap<>();
	private static final long JVM_START_TIME = ManagementFactory.getRuntimeMXBean().getStartTime();
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static final long ONE_KBYTE = 1024;
	static PrintWriter out = null;

	public static void main(String[] args) {
		if(args.length<1) {
			Assert.fail("Missing input log file name. \n Usage: "
					+ "java GarbageCollectionNotificationTest <log-fie-name> \n "
					+ "e.g java GarbageCollectionNotificationTest gcnotifier.log");		
		}

		String logFile = args[0];
		boolean append = true;

		try {
			// Sleep sometime for Server to start
			Thread.sleep(90000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Open log file for writing GC data
		try {
			File log = new File(logFile);
			out = new PrintWriter(new FileWriter(log, append));
		} catch (IOException ie) {
			System.out.println("Unable to write to file " + logFile);
			ie.printStackTrace();
			Assert.fail("Unable to write to file " + logFile);
		}
		Report.initReport(out); //end of open log file

		try {
			beforeSystemGC();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.gc();

		try {
			// Sleep sometime for GC to happen
			Thread.sleep(90000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		afterSystemGC();

		// Close log file
		Report.endReport();
		out.close();
	}

	public static void beforeSystemGC() throws Exception {
		System.out.println("ServerURL=service:jmx:rmi:///jndi/rmi://localhost:1234/jmxrmi");

		// Form a Server URL
		JMXServiceURL urlForRemoteVM = 
				new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1234/jmxrmi");

		// Connect to remote VM using Server URL
		JMXConnector jmxCon = JMXConnectorFactory.connect(urlForRemoteVM, null);

		System.out.println("Connection established!");

		//Create a proxy to be used to get a GC MXBean instance
		MBeanServerConnection mbeanSerCon = jmxCon.getMBeanServerConnection();

		// Get object names of all MXBeans that are implemented 
		// and belong to GC domain type. These return values are different for 
		// each GC policy e.g this returns object names java.lang:type=GarbageCollector,name=global and 
		// java.lang:type=GarbageCollector,name=scavenge  when "gencon" GC policy is used
		Set<?> srvGCNames = mbeanSerCon.queryNames(new ObjectName(
				ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);

		System.out.println("Starting to write GC data to .log file");

		for (Object srvGCName : srvGCNames) {
			ObjectName gcBeanName = (ObjectName) srvGCName;

			// newPlatformMXBeanProxy returns a proxy for a platform 
			// MXBean interface(here GarbageCollectorMXBean) of a given 
			// MXBean name that forwards its method calls through the 
			// given MBeanServerConnection.
			GarbageCollectorMXBean gcBean = ManagementFactory.newPlatformMXBeanProxy(mbeanSerCon, gcBeanName.toString(), GarbageCollectorMXBean.class);
			
			gcStates.put(gcBean.getName(), new GCState(gcBean, assumeGCIsPartiallyConcurrent(gcBean), assumeGCIsOldGen(gcBean)));

			out.println("gcBeanName: "+gcBean.getName());

			NotificationEmitter emitter = (NotificationEmitter) gcBean;
			
			// New listener
			NotificationListener listener = new NotificationListener() {
				// Record total GC time spent
				long totalGcTimeSpend = 0;

				@Override
				public void handleNotification(Notification notification, Object handback) {
					// Check if notification is of type GARBAGE_COLLECTION_NOTIFICATION
					if(notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
						HandBack handBack = (HandBack) handback;

						// Get GC info
						GarbageCollectionNotificationInfo info =
								GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
						// Output
						// Get a glance of gc
						System.out.println("Emitted GARBAGE_COLLECTION_NOTIFICATION"); 
						StringBuilder gcGlance = new StringBuilder();
						String gcName = info.getGcName();
						GCState gcState = gcStates.get(gcName);
						GcInfo gcInfo = info.getGcInfo();
						long gcId = gcInfo.getId();
						gcGlance.append(info.getGcAction()).append(" (").append(gcName).append(") : - ").append(gcId);
						gcGlance.append(" (").append(info.getGcCause()).append(") ");
						gcGlance.append("start: ")
						.append(dateFormat.format(new Date(JVM_START_TIME + gcInfo.getStartTime())));
						gcGlance.append(", end: ")
						.append(dateFormat.format(new Date(JVM_START_TIME + gcInfo.getEndTime())));

						out.println("gcGlance:\n"+gcGlance.toString());

						Assert.assertTrue("startTime("+gcInfo.getStartTime()+") should be smaller than endTime("+gcInfo.getEndTime()+").", gcInfo.getStartTime() <= gcInfo.getEndTime());
						if (0 != gcState.lastCollectionID) {
							Assert.assertTrue("lastCollectionID+1("+(gcState.lastCollectionID+1)+") should match gcId("+gcId+")", gcId == (gcState.lastCollectionID+1));
						}
						
						gcState.lastCollectionID = gcId;
						gcState.totalCollectionCount += 1;
						gcState.totalCollectionDuration += gcInfo.getDuration();

						// Memory info
						Map<String, MemoryUsage> beforeUsageMap = gcInfo.getMemoryUsageBeforeGc();
						Map<String, MemoryUsage> afterUsageMap = gcInfo.getMemoryUsageAfterGc();
						for (Map.Entry<String, MemoryUsage> entry : afterUsageMap.entrySet()) {
							String name = entry.getKey();
							MemoryUsage afterUsage = entry.getValue();
							MemoryUsage beforeUsage = beforeUsageMap.get(name);

							StringBuilder usage = new StringBuilder();

							usage.append("\t[").append(String.format("%32s", name)).append("] \t");   
							usage.append("init:").append(afterUsage.getInit() / ONE_KBYTE).append("K;\t"); 
							usage.append("used:").append(handBack 
									.handUsage(beforeUsage.getUsed(), afterUsage.getUsed(), beforeUsage.getMax()))
							.append(";\t");
							usage.append("committed: ").append(handBack 
									.handUsage(beforeUsage.getCommitted(), afterUsage.getCommitted(),
											beforeUsage.getMax()));

							out.println("usage:\n"+usage.toString());
						}
						totalGcTimeSpend += gcInfo.getDuration();
						
						// Summary
						long percent = (gcInfo.getEndTime() - totalGcTimeSpend) * 
								1000L / gcInfo.getEndTime();
						StringBuilder summary = new StringBuilder();
						summary.append("duration:").append(gcInfo.getDuration()).append("ms");
						summary.append(", throughput:").append((percent / 10)).append(".").append(percent % 10).append('%'); 
						out.println("summary:\n"+summary.toString());
						out.println("\n");
					}
				}
			};

			// Add the listener
			emitter.addNotificationListener(listener, null, HandBack.getInstance());
		}
	}

	public static void afterSystemGC() {
		int totalCollectionCount = 0;
		out.println("");
		for (Map.Entry<String, GCState> entry : gcStates.entrySet()) {
			StringBuilder gcGlanceAf = new StringBuilder();
			String key = (String)entry.getKey(); 
			GCState val = (GCState)entry.getValue();
			gcGlanceAf.append("GC Name : ").append(key).append(", assumeGCIsOldGen : ").append(val.assumeGCIsOldGen).append(", assumeGCIsPartiallyConcurrent : ").append(val.assumeGCIsPartiallyConcurrent).append(", TotalGCCount : ").append(val.totalCollectionCount).append(", TotalGCDuration(ms) : ").append(val.totalCollectionDuration);
			out.println("gcGlanceAf:\n"+gcGlanceAf.toString());
			System.out.println("Garbage Collection Information:\n"+gcGlanceAf.toString());
			totalCollectionCount += val.totalCollectionCount;
		}
		
		Assert.assertTrue("totalCollectionCount should not be 0", 0 != totalCollectionCount);
	}

	private static class HandBack {
		private HandBack() {}

		private static HandBack instance = new HandBack();

		public static HandBack getInstance() {
			return instance;
		}

		public String handUsage(long before, long after, long max) {
			StringBuilder usage = new StringBuilder();

			if ((max == -1) || (max == 0)) {
				usage.append("").append(before / ONE_KBYTE).append("K -> ").append(after / ONE_KBYTE).append("K)");
				return usage.toString();
			}

			long beforePercent = ((before * 1000L) / max);
			long afterPercent = ((after * 1000L) / max);

			usage.append(beforePercent / 10).append('.').append(beforePercent % 10).append("%(")
			.append(before / ONE_KBYTE).append("K) -> ").append(afterPercent / 10).append('.')
			.append(afterPercent % 10).append("%(").append(after / ONE_KBYTE).append("K)");
			return usage.toString();
		}
	}

	private static boolean assumeGCIsPartiallyConcurrent(GarbageCollectorMXBean gc) { 
		switch (gc.getName()) { 
			// First two are from the serial collector 
			case "Copy": 
			case "MarkSweepCompact": 
			// Parallel collector 
			case "PS MarkSweep": 
			case "PS Scavenge": 
			case "G1 Young Generation": 
				// CMS young generation collector 
			case "ParNew": 
				return false; 
			case "ConcurrentMarkSweep": 
			case "G1 Old Generation": 
				return true; 
				// IBM J9 garbage collectors
			case "scavenge":
			case "partial gc":
			case "global":
			case "global garbage collect":
				return false;
			default: 
				// Assume possibly concurrent if unsure 
				return true; 
		} 
	} 

	private static boolean assumeGCIsOldGen(GarbageCollectorMXBean gc) { 
		switch (gc.getName()) { 
			case "Copy": 
			case "PS Scavenge": 
			case "G1 Young Generation": 
			case "ParNew": 
				return false; 
			case "MarkSweepCompact": 
			case "PS MarkSweep": 
			case "ConcurrentMarkSweep": 
			case "G1 Old Generation": 
				return true; 
			case "scavenge":
			case "partial gc":
				return false;
			case "global":
			case "global garbage collect":
				return true;
			default: 
				return false; 
		} 
	}	 
}
