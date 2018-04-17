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
 * This java source file contains the MemoryData class, used
 * to retrieve information provided by the Memory, MemoryManager
 * and MemoryPool MXBeans
 */
package net.adoptopenjdk.test.jlm.resources;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

//import java.lang.management.*;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.remote.ServerConnector;

public class MemoryData extends VMData {

	public MemoryData(String logFile) {
		super(logFile, null, true);
	}

	public MemoryData (ServerConnector profiler, String logFile) {
		super(logFile, profiler, false);
	}

	public void writeData(MemoryMXBean mb, List<MemoryManagerMXBean> mmbList, List<MemoryPoolMXBean> mpbList,
			List<GarbageCollectorMXBean> gcbList, boolean append)
					throws UndeclaredThrowableException {
		Assert.assertFalse("MemoryMXBean == null", mb == null);
		Assert.assertFalse("List<MemoryManagerMXBean> == null", mmbList == null);
		Assert.assertFalse("List<MemoryPoolMXBean> == null", mpbList == null);
		Assert.assertFalse("List<GarbageCollectorMXBean> gcbList == null", gcbList == null);

		openLogFile(append);

		try {
			// Record the time and whether the verbose output is enabled
			out.println("Memory Information Retrieved at " + 
					DateFormat.getDateTimeInstance().format(new Date()));

			String state = "disabled";
			
			if (mb.isVerbose()) {
				state = "enabled";
			}
			
			out.println("Verbose output is " + state + " for the memory system"); 
			out.println("");
			out.println("");

			// Get stats for the VM's Memory and write to file
			out.println("MEMORY STATS");

			MemoryUsage heap_usage = mb.getHeapMemoryUsage(); 
			MemoryUsage nonHeap_usage = mb.getNonHeapMemoryUsage();

			// Check memory usage is valid and write the values to the log
			checkMemoryUsage(heap_usage, "Heap", "proxy");
			checkMemoryUsage(nonHeap_usage, "Non-Heap", "proxy");

			// Check the finalization count is reasonable
			int obj_final_cnt = mb.getObjectPendingFinalizationCount();
			checkObjectPendingFinalizationCount("proxy", obj_final_cnt);

			out.println("");
			out.println("");

			// Get the info for the Garbage Collector and write to file
			out.println("GARBAGE COLLECTOR INFORMATION");

			for (GarbageCollectorMXBean gcb : gcbList) {
				String gcName = gcb.getName();
				long gcCount[] = {0,0};
				gcCount[0] = gcb.getCollectionCount();
				long gcTime = gcb.getCollectionTime();
				gcCount[1] = gcb.getCollectionCount();

				checkGCInfo("proxy", gcCount, gcName, gcTime);

				out.print("  Part of Memory System:    ");
				if (gcb.isValid()) {
					out.println("Yes"); 
				}
				else {
					out.println("No"); 
				}

				String[] pools = gcb.getMemoryPoolNames();

				out.print("  Managed Pools:            "); 
				for (String pool : pools ) {             

					out.println(pool);
					out.print("                            ");
				}
				out.println("");
			}

			out.println("");
			out.println("");

			// Get the info for the memory managers and write to file
			out.println("MEMORY MANAGER INFORMATION");

			for (MemoryManagerMXBean mmb : mmbList) {
				out.println("  Memory Manager:           " + mmb.getName());

				out.print("  Part of Memory System:    ");
				if (mmb.isValid()) {
					out.println("Yes"); 
				}
				else {
					out.println("No"); 
				}

				String[] pools = mmb.getMemoryPoolNames();

				out.print("  Managed Pools:            "); 
				for (String pool : pools ) {             

					out.println(pool);
					out.print("                            ");
				}
				out.println("");
			}
			out.println("");

			// Get the info for the memory pools and write to file
			out.println("MEMORY POOLS INFORMATION");

			for (MemoryPoolMXBean mpb : mpbList) {
				out.println("  Memory Pool:              " + mpb.getName());
				out.println("  Memory Type:              " + mpb.getType().toString());

				out.print("  Part of Memory System:    ");
				// MemoryPoolMXBean.get*Usage() function will return null
				// if this memory pool is not valid
				if (mpb.isValid()) {
					out.println("Yes"); 

					MemoryUsage current_usage = mpb.getUsage();
					checkMemoryUsage(current_usage, "Current", "proxy");

					MemoryUsage peak_usage = mpb.getPeakUsage();
					checkMemoryUsage(peak_usage, "Peak", "proxy");

					String poolName = mpb.getName();
					String poolType = mpb.getType().toString();
					checkPeakAndCurrentMemoryUsage(peak_usage, current_usage, poolName, poolType);

				} else {
					out.println("No");
				}

				MemoryUsage coll_usage = mpb.getCollectionUsage();
				if (coll_usage != null) {
					checkMemoryUsage(coll_usage, "Collection", "proxy");
				} else {
					out.println("  Collection Memory Usage:  this VM does not support \n"
							+ "                            the collection memory usage functionality for this pool.");
				}

				String[] managers = mpb.getMemoryManagerNames();

				out.print("  Pool Managers:            "); 
				for (String manager : managers ) {             

					out.println(manager);
					out.print("                            ");
				}
				out.println("");

				if (mpb.isUsageThresholdSupported()) {
					long threshold = mpb.getUsageThreshold();
					checkThreshold("proxy", threshold);

					out.println("  Usage Threshold:          " + threshold + " bytes");

					// Threshold crossing checking is disabled if threshold = 0
					if (threshold > 0) {
						out.println("  Threshold Exceeded Count: " + mpb.getUsageThresholdCount());
						out.print("  Usage Within Threshold:   ");
						if (mpb.isUsageThresholdExceeded()) {
							out.println("No"); 
						}
						else {
							out.println("Yes"); 
						}
					}

					out.println("");
				}

				if (mpb.isCollectionUsageThresholdSupported()) {
					long threshold = mpb.getCollectionUsageThreshold();
					checkThreshold("proxy", threshold);
					out.println("  Collection Threshold:     " + threshold + " bytes");

					// Threshold crossing checking is disabled if threshold = 0
					if (threshold > 0) {
						out.println("  Threshold Exceeded Count: " + mpb.getCollectionUsageThresholdCount());
						out.print("  Usage Within Threshold:   ");
						if (mpb.isCollectionUsageThresholdExceeded()) {
							out.println("No"); 
						}
						else {
							out.println("Yes"); 
						}
					}
					out.println("");
				}
				out.println("");
			}

			out.println("");
			out.println("");

			closeLogFile();
		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
		} catch (SecurityException se) {
			Message.logOut("Insufficient privileges to access OS info");
			se.printStackTrace();
			Assert.fail("Insufficient privileges to access OS info");
		}
	}

	public void writeData (MBeanServerConnection mbs, ObjectName mb, Set<?> mmbList, Set<?> mpbList,  
			Set<?> gcbList, boolean append) throws ConnectException, UnmarshalException {
		Assert.assertFalse("MBeanServerConnection == null", mbs == null);
		Assert.assertFalse("MemoryMXBean == null", mb == null);
		Assert.assertFalse("List<MemoryManagerMXBean> == null", mmbList == null);
		Assert.assertFalse("List<MemoryPoolMXBean> == null", mpbList == null);
		Assert.assertFalse("List<GarbageCollectorMXBean> gcbList == null", gcbList == null);

		openLogFile(append);
		CompositeData cd;

		try {
			// Record the time and whether the verbose output is enabled
			out.println("Memory Information Retrieved at " + DateFormat.getDateTimeInstance().format(new Date()));

			String state = "disabled";
			if (((Boolean)(mbs.getAttribute(mb, "Verbose"))).booleanValue()) {
				state = "enabled";
			}
			out.println("Verbose output is " + state + " for the memory system"); 
			out.println("");
			out.println("");

			// Get Stats for the VMs Memory and write to file
			out.println("MEMORY STATS"); 

			// Get and check the heap memory usage, write values to the log
			cd = (CompositeData)(mbs.getAttribute(mb, "HeapMemoryUsage"));
			MemoryUsage heap_usage = MemoryUsage.from(cd);            

			checkMemoryUsage(heap_usage, "Heap", "server connection");

			cd = (CompositeData)(mbs.getAttribute(mb, "NonHeapMemoryUsage"));
			MemoryUsage nonHeap_usage = MemoryUsage.from(cd);

			checkMemoryUsage(nonHeap_usage, "Non-Heap", "server connection");

			out.println("  Objects Pending");

			// Check the object finalization count is valid
			int obj_final_cnt = ((Integer)(mbs.getAttribute(mb, "ObjectPendingFinalizationCount"))).intValue();
			checkObjectPendingFinalizationCount("server connection", obj_final_cnt);


			out.println("");
			out.println("");

			// Get the info for the Garbage Collector and write to file
			out.println("GARBAGE COLLECTOR INFORMATION");

			for (Object gcbObj : gcbList) {
				ObjectName gcb = (ObjectName) gcbObj;
				String gcName = (String)mbs.getAttribute(gcb, "Name");
				long gcCount[] = {0,0};
				gcCount[0] = ((Long)mbs.getAttribute(gcb, "CollectionCount")).longValue();
				long gcTime = ((Long)mbs.getAttribute(gcb, "CollectionTime")).longValue();
				gcCount[1] = ((Long)mbs.getAttribute(gcb, "CollectionCount")).longValue();
				checkGCInfo("server connection", gcCount, gcName, gcTime);

				out.print("  Part of Memory System:    ");
				if (((Boolean)(mbs.getAttribute(gcb, "Valid"))).booleanValue()) {
					out.println("Yes"); 
				}
				else {
					out.println("No"); 
				}

				String[] pools = (String[])mbs.getAttribute(gcb, "MemoryPoolNames");

				out.print("  Managed Pools:            "); 
				for (String pool : pools ) {             

					out.println(pool);
					out.print("                            ");
				}
				out.println(""); 
			}

			out.println("");

			// Get the info for the memory managers and write to file
			out.println("MEMORY MANAGER INFORMATION");

			for (Object mmbObj : mmbList) {
				ObjectName mmb = (ObjectName) mmbObj;
				out.println("  Memory Manager:           " + (String)mbs.getAttribute(mmb, "Name"));

				out.print("  Part of Memory System:    ");
				if (((Boolean)(mbs.getAttribute(mmb, "Valid"))).booleanValue()) {
					out.println("Yes"); 
				}
				else {
					out.println("No"); 
				}

				String[] pools = (String[])mbs.getAttribute(mmb, "MemoryPoolNames");

				out.print("  Managed Pools:            "); 
				for (String pool : pools ) {             

					out.println(pool);
					out.print("                            ");
				}
				out.println("");
			}
			out.println("");

			// Get the info for the memory managers and write to file
			out.println("MEMORY POOLS INFORMATION");

			for (Object mpbObj : mpbList) {
				ObjectName mpb = (ObjectName) mpbObj;
				out.println("  Memory Pool:              " + (String)mbs.getAttribute(mpb, "Name"));
				out.println("  Memory Type:              " + (String)mbs.getAttribute(mpb, "Type"));

				out.print("  Part of Memory System:    ");
				if (((Boolean)(mbs.getAttribute(mpb, "Valid"))).booleanValue()) {
					out.println("Yes");

					// the following two attributes may return null if the Memory Pool is no longer valid
					MemoryUsage current_usage = null;
					MemoryUsage peak_usage = null;

					cd = (CompositeData)(mbs.getAttribute(mpb, "Usage"));
					if (cd != null) {
						current_usage = MemoryUsage.from(cd);
						checkMemoryUsage(current_usage, "Current", "server connection");
					}

					cd = (CompositeData)(mbs.getAttribute(mpb, "PeakUsage"));
					if (cd != null) {
						peak_usage = MemoryUsage.from(cd);
						checkMemoryUsage(peak_usage, "Peak", "server connection");
					}

					// Get the ObjectName that the MemoryMXBean is registered by
					String poolName = (String)mbs.getAttribute(mpb, "Name");
					String poolType = (String)mbs.getAttribute(mpb, "Type");
					checkPeakAndCurrentMemoryUsage(peak_usage, current_usage, poolName, poolType);
				} else {
					out.println("No"); 
				}

				cd = (CompositeData)(mbs.getAttribute(mpb, "CollectionUsage"));
				// may be null if the Collection Threshold has not been set

				if (cd != null) {
					MemoryUsage coll_usage = MemoryUsage.from(cd);            
					checkMemoryUsage(coll_usage, "Collection", "server connection");
				} else {
					out.println("  Collection Memory Usage:  this VM does not support \n"
							+ "                            the collection memory usage functionality for this pool.");
				}

				String[] managers = (String[])mbs.getAttribute(mpb, "MemoryManagerNames");

				out.print("  Pool Managers:            "); 
				for (String manager : managers ) {             

					out.println(manager);
					out.print("                            ");
				}
				out.println("");

				// Check the usage threshold is valid and write the values to the log
				if (((Boolean)(mbs.getAttribute(mpb, "UsageThresholdSupported"))).booleanValue()) {
					long threshold = ((Long)mbs.getAttribute(mpb, "UsageThreshold")).longValue();
					checkThreshold("server connection", threshold);
					out.println("  Usage Threshold:          " + threshold + " bytes");

					// Threshold crossing checking is disabled if threshold = 0
					if (threshold > 0) {
						out.println("  Threshold Exceeded Count: " + ((Long)mbs.getAttribute(mpb, "UsageThresholdCount")).longValue());
						out.print("  Usage Within Threshold:   ");
						if (((Boolean)(mbs.getAttribute(mpb, "UsageThresholdExceeded"))).booleanValue()) {
							out.println("No"); 
						}
						else {
							out.println("Yes"); 
						}
					}

					out.println("");
				}

				// Check the collection usage is reasonable and write the values to the log
				if (((Boolean)(mbs.getAttribute(mpb, "CollectionUsageThresholdSupported"))).booleanValue()) {
					long threshold = ((Long)mbs.getAttribute(mpb, "CollectionUsageThreshold")).longValue();
					checkThreshold("server connection", threshold);
					out.println("  Collection Threshold:     " + threshold + " bytes");

					// Threshold crossing checking is disabled if threshold = 0
					if (threshold > 0) {
						out.println("  Threshold Exceeded Count: " + ((Long)mbs.getAttribute(mpb, "CollectionUsageThresholdCount")).longValue());
						out.print("  Usage Within Threshold:   ");
						if (((Boolean)(mbs.getAttribute(mpb, "CollectionUsageThresholdExceeded"))).booleanValue()) {
							out.println("No"); 
						}
						else {
							out.println("Yes"); 
						}
					}
					out.println("");
				}
				out.println("");
			}

			out.println("");
			out.println("");

			closeLogFile();

		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
		} catch (UnmarshalException ue) {
			Assert.fail("UnmarshalException: \n" + ue.getMessage());
		} catch (ConnectException ce) {
			Assert.fail("ConnectException: \n" + ce.getMessage());
		} catch (IOException ie) {
			Message.logOut("Problem with server connection");
			ie.printStackTrace();
			Assert.fail("Problem with server connection");
		} catch (SecurityException se) {
			Message.logOut("Insufficient privileges to access OS info");
			se.printStackTrace();
			Assert.fail("Insufficient privileges to access OS info");
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

	private void checkPeakAndCurrentMemoryUsage(MemoryUsage peak_usage, 
			MemoryUsage current_usage, String poolName, String poolType) {
		long peakUsageUsed = peak_usage.getUsed();
		long currentUsageUsed = current_usage.getUsed();

		if (peakUsageUsed < currentUsageUsed) {
			Message.logErr("  Peak usage smaller than current usage here:");
			Message.logErr("  Memory Pool:              " + poolName);
			Message.logErr("  Memory Type:              " + poolType);
			Message.logErr("  Peak Usage:               " + peak_usage.toString());
			Message.logErr("  Current Usage:            " + current_usage.toString());
			Assert.fail("Peak Usage used memory smaller than Current Usage used memory");
		}
	}

	private void checkMemoryUsageElements(String connect_type, String usage_type, 
			long init, long max, long commit, long used) {
		Assert.assertTrue("Invalid value returned for " + usage_type + " Init value (" + connect_type + " test)", init >=  -1);
		Assert.assertTrue("Invalid value returned for " + usage_type + " Used value (" + connect_type + " test)", used >= 0);
		Assert.assertTrue(usage_type + " Max value returned was less then the Commited value (" + connect_type + " test)", max >= commit || max == -1);
		Assert.assertTrue(usage_type + " Commited value returned was less then the Used value (" + connect_type + " test)", commit >= used);
	}

	private void checkObjectPendingFinalizationCount(String connect_type, int obj_final_cnt) {
		// Check the object pending finalization count is not negative
		out.println("  Objects Pending Finalization:  " + obj_final_cnt);
		out.println("");
		Assert.assertTrue("Negative value returned for ObjectPendingFinalCount (" + connect_type + " test)", obj_final_cnt >= 0);
	}

	private void checkThreshold(String connect_type, long threshold) {
		// Check the threshold is not negative
		Assert.assertTrue("Negative value returned for Threshold (" + connect_type + " test)", threshold >= 0);    		
	}

	private void checkMemoryUsage (MemoryUsage memUsage, String usage_type, String connect_type) {
		// Get the elements of a MemoryUsage object and check they are valid
		long init   = memUsage.getInit();
		long used   = memUsage.getUsed();
		long commit = memUsage.getCommitted();
		long max    = memUsage.getMax();

		String formatter = "        ";
		if(usage_type.contains("Non")){
			formatter = "    ";
		} else if (usage_type.contains("Current")) {
			formatter = "     ";
		} else if (usage_type.contains("Peak")) {
			formatter = "        ";
		} else if (usage_type.contains("Collection")) {
			formatter = "  ";
		}
		out.println("  " + usage_type + " Memory Usage:" + formatter + memUsage.toString());

		checkMemoryUsageElements(connect_type, usage_type, init, max, commit, used);
	}

	// This function is used to test the relationship between 
	// approximate accumulated collection time and collection occurrences count.
	// If there is a GC, there must be a GC time, vice versa.
	private void checkGCInfo(String connect_type, long[] gc_cnt, String gc_name, long gc_time) {
		out.println("  Garbage Collector:        " + gc_name);
		out.println("  Total GC occurrences:     " + gc_cnt[0]);
		out.println("  Total time spent in GC:   " + gc_time + " milliseconds");

		Assert.assertTrue("Incorrected value for GC 1st count " + gc_cnt[0], gc_cnt[0] >= -1);
		Assert.assertTrue("Incorrected value for GC 2nd count " + gc_cnt[1], gc_cnt[1] >= -1);
		Assert.assertTrue("Incorrected value for GC time " + gc_time, gc_time >= -1);

		if (gc_cnt[0] > 0 && gc_time < 0) {
			Assert.fail("Incorrect value returned for " + gc_name + "'s approximate accumulated collection time: " + gc_time + " (" + connect_type + " test)");
		}
		if (gc_cnt[1] <= 0 && gc_time > 0) {
			Assert.fail("Incorrect value returned for " + gc_name + "'s approximate accumulated collection time: " + gc_time + ". 0 or -1 expected as no GC occurred (" + connect_type + " test)");
		}
	}
}
