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
 * This java source file contains the ThreadData class, used
 * to retrieve information provided by the ThreadMXBean. 
 */
package net.adoptopenjdk.test.jlm.resources;

import java.io.*;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.lang.management.LockInfo;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Array;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Date;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.DecimalFormat;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.RuntimeMBeanException;
import javax.management.openmbean.CompositeData;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.remote.ServerConnector;
import net.adoptopenjdk.test.jlm.resources.Message;
import net.adoptopenjdk.test.jlm.resources.VMData;

public class ThreadData extends VMData {

	public ThreadData(String logFile) {
		super(logFile, null, true);
	}

	public ThreadData(ServerConnector profiler, String logFile) {
		super(logFile, profiler, false);
	}

	private void writeOutStackTrace(Exception e) {
		if (out != null) {
			e.printStackTrace(out);
		}
		if (consoleOutput) {
			e.printStackTrace();
		}
	}

	public void writeData(ThreadMXBean tb, int stackDepth, boolean append) throws UndeclaredThrowableException {

		if ((tb == null) || (stackDepth < 0)) {
			Assert.fail("ThreadMXBean is null or stackDepth is below 0");
		}

		// Find out whether optional functionality is supported; if so, find out 
		// if it has been enabled. Then set the relevant flag.*/

		// Boolean flags used to store the supported and enabled states of various functions
		boolean supported, enabled, tcmEnabled;
		openLogFile(append);

		// Print out all times to 2 d.p.
		DecimalFormat df = new DecimalFormat("#0.00");

		if (supported = tb.isThreadContentionMonitoringSupported()) {
			tcmEnabled = tb.isThreadContentionMonitoringEnabled();
		} else {
			tcmEnabled = false;
		}
		
		Report.printlnIndent("Thread Contention Monitoring is "
				+ ((supported) ? "supported and " + ((tcmEnabled) ? "" : "not ") + "enabled" : "not supported"));

		try {
			// Record the time and whether the verbose output is enabled
			Report.printlnIndent(
					"Thread Information Retrieved at " + DateFormat.getDateTimeInstance().format(new Date()));
			Report.println();

			int daemon_cnt = tb.getDaemonThreadCount();
			int thd_cnt = tb.getThreadCount();

			int peak_cnt = tb.getPeakThreadCount();
			long start_cnt = tb.getTotalStartedThreadCount();

			// Check the thread stats are reasonable
			checkThreadStats("proxy", thd_cnt, start_cnt, peak_cnt, daemon_cnt);

			// Get Stats for the VMs Memory and write to file
			Report.printlnIndent("THREAD STATS");
			Report.incrementIndentation();
			Report.printlnIndent("Current Thread Count:      " + thd_cnt);
			Report.printlnIndent("Started Thread Count:      " + start_cnt);
			Report.printlnIndent("Peak Thread Count:         " + peak_cnt);
			Report.printlnIndent("Daemon Thread Count:       " + daemon_cnt);
			Report.decrementIndentation();

			Report.println();
			Report.println();

			// Get the info for the threads and write to file
			Report.printlnIndent("ALL THREAD INFORMATION");
			Report.incrementIndentation();

			// Check if monitor and synchronizer monitoring is supported.
			boolean monitorSupported = tb.isObjectMonitorUsageSupported();
			boolean synchSupported = tb.isSynchronizerUsageSupported();

			Report.printlnIndent("Object Monitor Usage is " + ((monitorSupported) ? "supported" : "not supported"));
			Report.printlnIndent("Synchronizer Usage is " + ((synchSupported) ? "supported" : "not supported"));

			ThreadInfo[] threadDataset = null;
			ThreadInfo[] lockThdDataset = null;
			ThreadInfo[] dumpThdDataset = null;

			try {
				dumpThdDataset = tb.dumpAllThreads(monitorSupported, synchSupported); 
				long[] thdIds = tb.getAllThreadIds();

				// Get the thread info for all the threads. Does not obtain lock
				// information if stackDepth is supplied.
				if (stackDepth > 0) {
					threadDataset = tb.getThreadInfo(thdIds, stackDepth);
				} else {
					threadDataset = tb.getThreadInfo(thdIds);
				}

				lockThdDataset = tb.getThreadInfo(thdIds, monitorSupported, synchSupported);
				Report.printlnIndent("ThreadMXBean.dumpAllThreads(boolean,boolean) is supported");
				Report.incrementIndentation();

				Report.printlnIndent(
						"ThreadMXBean.dumpAllThreads(boolean,boolean) and ThreadMXBean.getThreadInfo(ThreadMXBean.getAllThreads(long[]"
								+ (stackDepth > 0 ? ", int)\n " : ")\n ") + "return "
								+ (dumpThdDataset.length == threadDataset.length ? "the same " : "a different")
								+ " number of ThreadInfo objects ");
				Report.printlnIndent(
						"ThreadMXBean.dumpAllThreads(boolean,boolean) and ThreadMXBean.getThreadInfo(ThreadMXBean.getAllThreads(long[], boolean, boolean)\n "
								+ "return "
								+ (dumpThdDataset.length == threadDataset.length ? "the same " : "a different")
								+ " number of ThreadInfo objects ");
				Report.printlnIndent("Using information from ThreadMXBean.dumpAllThreads()");
				Report.decrementIndentation();
			} catch (Exception e) {
				//If the exception was caused by a Connect or Unmarshal Exception,
				// Pass it on for logic in the calling class to handle. 
				Class<UndeclaredThrowableException> undeclared = UndeclaredThrowableException.class;
				if (undeclared.isInstance(e)) {
					Throwable cause = e.getCause();
					Class<ConnectException> connectExcept = ConnectException.class;
					Class<UnmarshalException> unmarshalExcept = UnmarshalException.class;

					if (connectExcept.isInstance(cause) || unmarshalExcept.isInstance(cause)) {
						throw (UndeclaredThrowableException)e;
					}
				}

				Report.printlnIndent("ThreadMXBean.dumpAllThreads(boolean,boolean) does not appear to be supported: \""
						+ e.toString() + "\" exception thrown and caught");
				Report.incrementIndentation();
				Report.printlnIndent("Cause: \"" + e.getCause() + "\"");
				writeOutStackTrace(e);
				Report.printlnIndent("Using information from ThreadMXBean.getThreadInfo(ThreadMXBean.getAllThreads())");
				Report.decrementIndentation();
			}

			Report.println();

			if (supported = tb.isThreadCpuTimeSupported()) {
				enabled = tb.isThreadCpuTimeEnabled();
			} else {
				enabled = false;
			}
			
			Report.printlnIndent("Thread CPU Time is "
					+ ((supported) ? "supported and " + ((enabled) ? "" : "not ") + "enabled" : "not supported"));
			Report.println();

			if ((threadDataset == null) || (threadDataset.length <= 0)) {
				Report.printlnEmptyReturnMsg(
						"ThreadMXBean.getThreadInfo(long[] " + (stackDepth > 0 ? ", int)\n " : ")\n "), lockThdDataset);
			} else {
				Report.incrementIndentation();
				for (ThreadInfo threadData : threadDataset) {
					// The thread IDs returned by getAllThreadIds may include
					// terminated threads - and therefore the array of
					// ThreadInfo objects could contain a null. Therefore we
					// need to check for nulls before using the ThreadInfo object.
					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, stackDepth, false);
						if (enabled) {
							Report.incrementIndentation();
							long cpuTime = (long)(tb.getThreadCpuTime(threadData.getThreadId()));
							long uTime = (long)(tb.getThreadUserTime(threadData.getThreadId()));

							if (cpuTime == -1) {
								Report.printlnIndent("CPU Time:                  -1 seconds");
							} else {
								Report.printlnIndent(
										"CPU Time:                  " + df.format(cpuTime * 1e-9) + " seconds");
							}
							
							if (uTime == -1) {
								Report.printlnIndent(
										"User Time:                 " + df.format(uTime * 1e-9) + " seconds");
							} else {
								Report.printlnIndent("User Time:                 -1 seconds");
							}

							Report.decrementIndentation();
						}
					} else {
						// Print out a warning message 
						Report.printlnIndent(
								"*** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.printlnIndent(
								"*** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}
					
					Report.println();
					Report.println();
				}
				
				Report.decrementIndentation();
			}
			
			Report.println();

			long[] thdIds = tb.getAllThreadIds();

			lockThdDataset = tb.getThreadInfo(thdIds, monitorSupported, synchSupported);

			if ((lockThdDataset == null) || (lockThdDataset.length <= 0)) {
				Report.printlnEmptyReturnMsg("ThreadMXBean.getThreadInfo(long[], boolean, boolean)", lockThdDataset);
			} else {
				Report.incrementIndentation();
				for (ThreadInfo threadData : lockThdDataset) {
					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, 0, true);
						if (enabled) {
							Report.printlnIndent("CPU Time:                  "
									+ df.format(tb.getThreadCpuTime(threadData.getThreadId()) * 1e-9) + " seconds");
							Report.printlnIndent("User Time:                 "
									+ df.format(tb.getThreadUserTime(threadData.getThreadId()) * 1e-9) + " seconds");
						}
					} else {
						// Print out a warning message 
						Report.printlnIndent(
								"*** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.printlnIndent(
								"*** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}
					
					Report.println();
					Report.println();
				}
				
				Report.decrementIndentation();
			}
			
			Report.println();

			// Write data to the file on the deadlocked threads...
			Report.printlnIndent("MONITOR DEADLOCK THREAD INFORMATION");
			Report.incrementIndentation();
			Report.println();

			long[] deadlockedThreads = tb.findMonitorDeadlockedThreads();

			// Get the thread info for all the deadlocked threads.
			if ((deadlockedThreads == null) || (deadlockedThreads.length <= 0)) {
				if (deadlockedThreads == null) {
					Report.printlnEmptyReturnMsg("ThreadMXBean.findMonitorDeadlockedThreads()", null);
				} else {
					Report.printlnEmptyReturnMsg("ThreadMXBean.findMonitorDeadlockedThreads()",
							new Long[deadlockedThreads.length]);
				}
			} else {
				lockThdDataset = tb.getThreadInfo(deadlockedThreads, monitorSupported, synchSupported);

				if ((lockThdDataset == null) || (lockThdDataset.length <= 0)) {
					Report.printlnEmptyReturnMsg("ThreadMXBean.getThreadInfo(deadlockedThreads)", threadDataset);
				} else {
					for (ThreadInfo threadData : lockThdDataset) {
						writeThreadInfo(threadData, tcmEnabled, df, 0, true);
						Report.println();
					}
				}
			}
			
			Report.decrementIndentation();
			Report.println();

			Report.printlnIndent("DEADLOCK THREAD INFORMATION");
			Report.incrementIndentation();
			Report.println();

			deadlockedThreads = tb.findDeadlockedThreads();

			// Get the thread info for all the deadlocked threads.
			if (deadlockedThreads != null) {

				lockThdDataset = tb.getThreadInfo(deadlockedThreads, monitorSupported, synchSupported);
				for (ThreadInfo threadData : lockThdDataset) {
					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, 0, true);
						Report.println();
					} else { // Print out a warning message  
						Report.println(
								"  *** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.println(
								"  *** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}
				}
			} else {
				Report.printlnIndent("Currently no deadlocked threads.");
			}

			Report.decrementIndentation();
			Report.println();
		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
		} catch (SecurityException se) {
			Message.logOut("Insufficient privileges to access OS info");
			se.printStackTrace();
		} finally {
			Report.failureSummary();
			closeLogFile();
		}
	}

	/**
	 * 
	 * This method is used to write thread data using MBeanServerConnection.
	 * 
	 * @param mbs
	 *            MBean Server connection.
	 * @param tb
	 *            <code>ObjectName</code> of the thread MXBean from the
	 *            <code>ManagementFactory</code>.
	 * @param stackDepth
	 *            Maximum depth to reproduce in the output.
	 * @param append
	 *            Flag to indicate whether to append or start output file
	 *            afresh.
	 * @throws <code>ConnectException</code>
	 * @throws <code>UnmarshalException</code>
	 * @throws <code>OutOfRangeException</code>
	 * @throws <code>InvalidValueException</code>
	 */
	public void writeData(MBeanServerConnection mbs, ObjectName tb, int stackDepth, boolean append)
			throws ConnectException, UnmarshalException {
		if ((mbs == null) || (tb == null) || (stackDepth < 0)) {
			Assert.fail("MBeanServerConnection or ObjectName is null or stackDepth is below 0");
		}

		// Find out whether optional functionality is supported; if so, find out
		// if it has been enabled. Then set the relevant flag.*/
		boolean supported, enabled, tcmEnabled; 
		DecimalFormat df = new DecimalFormat("#0.00"); // Print out all times to 2 d.p.
		openLogFile(append);

		try {
			supported = ((Boolean)mbs.getAttribute(tb, "ThreadContentionMonitoringSupported")).booleanValue();
			if (supported) {
				tcmEnabled = ((Boolean)mbs.getAttribute(tb, "ThreadContentionMonitoringEnabled")).booleanValue();
			} else {
				tcmEnabled = false;
			}

			// Record the time and whether the verbose output is enabled
			Report.printlnIndent(
					"Thread Information Retrieved at " + DateFormat.getDateTimeInstance().format(new Date()));
			Report.println();

			int thd_cnt = ((Integer)mbs.getAttribute(tb, "ThreadCount")).intValue();
			int peak_cnt = ((Integer)mbs.getAttribute(tb, "PeakThreadCount")).intValue();
			long start_cnt = ((Long)mbs.getAttribute(tb, "TotalStartedThreadCount")).longValue();
			int daemon_cnt = ((Integer)mbs.getAttribute(tb, "DaemonThreadCount")).intValue();

			// Check the return thread stats are reasonable
			checkThreadStats("server connection", thd_cnt, start_cnt, peak_cnt, daemon_cnt);

			// Get Stats for the VMs Memory and write to file
			Report.printlnIndent("THREAD STATS");
			Report.incrementIndentation();
			Report.printlnIndent("Current Thread Count:      " + thd_cnt);
			Report.printlnIndent("Started Thread Count:      " + start_cnt);
			Report.printlnIndent("Peak Thread Count:         " + peak_cnt);
			Report.printlnIndent("Daemon Thread Count:       " + daemon_cnt);
			Report.decrementIndentation();
			Report.println();
			Report.println();

			// Get the info for the threads and write to file
			Report.printlnIndent("ALL THREAD INFORMATION");
			Report.incrementIndentation();

			writeMBeanInfo(mbs, tb);

			supported = ((Boolean)mbs.getAttribute(tb, "ThreadCpuTimeSupported")).booleanValue();

			if (supported) {
				enabled = ((Boolean)mbs.getAttribute(tb, "ThreadCpuTimeEnabled")).booleanValue();
			} else {
				enabled = false;
			}

			Report.println();

			// Check if monitor and synchronizer monitoring is supported.
			boolean monitorSupported = ((Boolean)mbs.getAttribute(tb, "ObjectMonitorUsageSupported")).booleanValue();
			boolean synchSupported = ((Boolean)mbs.getAttribute(tb, "SynchronizerUsageSupported")).booleanValue();

			Report.printlnIndent("Object Monitor Usage is " + ((monitorSupported) ? "supported" : "not supported"));

			Report.printlnIndent("Synchronizer Usage is " + ((synchSupported) ? "supported" : "not supported"));

			CompositeData[] threadDataset = null;
			CompositeData[] lockThdDataset = null;
			CompositeData[] dumpThdDataset = null;

			dumpThdDataset = (CompositeData[])invokeMBeanOperation(mbs, tb, "dumpAllThreads", 
					new Object[] { monitorSupported, synchSupported });

			if ((dumpThdDataset == null) || (dumpThdDataset.length <= 0)) {
				Report.printlnEmptyReturnMsg("dumpAllThreads", dumpThdDataset);
			} else {
				for (CompositeData threadCD : dumpThdDataset) {
					ThreadInfo threadData = ThreadInfo.from(threadCD);
					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, 0, true);
						long threadId = threadData.getThreadId();
						if (enabled) {
							Report.incrementIndentation();

							long uTime = ((Long)(mbs.invoke(tb, "getThreadUserTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							long cpuTime = ((Long)(mbs.invoke(tb, "getThreadCpuTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							if (cpuTime == -1) {
								Report.printlnIndent("  CPU Time:                  -1 seconds");
							} else {
								Report.printlnIndent(
										"  CPU Time:                  " + df.format(cpuTime * 1e-9) + " seconds");
							}
							if (uTime == -1) {
								Report.printlnIndent("  User Time:                 -1 seconds");
							} else {
								Report.printlnIndent(
										"  User Time:                 " + df.format(uTime * 1e-9) + " seconds");
							}
							Report.decrementIndentation();
						}
						
						if (stackDepth > 0) {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo",
									new Object[] { threadId, stackDepth }, new String[] { "long", "int" }));
						} else {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo", new Object[] { threadId },
									new String[] { "long" }));
						}
						
						ThreadInfo threadInfo = ThreadInfo.from(threadCD);

						if (threadInfo != null) {
							writeThreadInfo(threadInfo, tcmEnabled, df, stackDepth, false);
						}
						Report.println();
					} else { 
						// Print out a warning message - getting one or two  nulls is ok, lots is worrying
						Report.printlnIndent(
								"*** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.printlnIndent(
								"*** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}

					Report.println();
					Report.println();
				}
			}

			long[] thdIds = (long[])mbs.getAttribute(tb, "AllThreadIds");

			/* get the thread info for all the threads. Does not obtain lock 
			 * information if stackDepth is supplied*/
			for (int thdIndex = 0; thdIndex < thdIds.length; thdIndex++) {
				if (thdIds[thdIndex] <= 0) {
					Message.logErr("Illegal Thread ID found: " + thdIds[thdIndex]);
					Message.logErr("List of all Thread IDs: " + Arrays.toString(thdIds));
					throw new IllegalArgumentException(
							"Thread Found with id not greater than zero : '" + thdIds[thdIndex] + "'");
				}
			}

			if (stackDepth > 0) {
				threadDataset = (CompositeData[])(mbs.invoke(tb, "getThreadInfo", new Object[] { thdIds, stackDepth },
						new String[] { "[J", "int" }));
			} else {
				threadDataset = (CompositeData[])(mbs.invoke(tb, "getThreadInfo", new Object[] { thdIds },
						new String[] { "[J" }));
			}

			if ((threadDataset == null) || (threadDataset.length <= 0)) {
				Report.printlnEmptyReturnMsg("getThreadInfo", threadDataset);
			} else {
				for (CompositeData threadCD : threadDataset) {
					ThreadInfo threadData = ThreadInfo.from(threadCD);

					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, stackDepth, false);

						long threadId = threadData.getThreadId();
						if (enabled) {

							long uTime = ((Long)(mbs.invoke(tb, "getThreadUserTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							long cpuTime = ((Long)(mbs.invoke(tb, "getThreadCpuTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							if (cpuTime == -1) {
								Report.printlnIndent("  CPU Time:                  -1 seconds");
							} else {
								Report.printlnIndent(
										"  CPU Time:                  " + df.format(cpuTime * 1e-9) + " seconds");
							}
							if (uTime == -1) {
								Report.printlnIndent("  User Time:                 -1 seconds");
							} else {
								Report.printlnIndent(
										"  User Time:                 " + df.format(uTime * 1e-9) + " seconds");
							}
						}
						if (stackDepth > 0) {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo",
									new Object[] { threadId, stackDepth }, new String[] { "long", "int" }));
						} else {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo", new Object[] { threadId },
									new String[] { "long" }));
						}
						ThreadInfo threadInfo = ThreadInfo.from(threadCD);

						if (threadInfo != null) {
							writeThreadInfo(threadInfo, tcmEnabled, df, stackDepth, false);
						}
						Report.println();
					} else {
						// Print out a warning message - getting one or two nulls is ok, lots is worrying
						Report.printlnIndent(
								"*** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.printlnIndent(
								"*** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}

					Report.println();
					Report.println();
				}
			}

			thdIds = (long[])mbs.getAttribute(tb, "AllThreadIds");
			lockThdDataset = (CompositeData[])(mbs.invoke(tb, "getThreadInfo",
					new Object[] { thdIds, monitorSupported, synchSupported },
					new String[] { "[J", "boolean", "boolean" }));

			if ((lockThdDataset == null) || (lockThdDataset.length <= 0)) {
				Report.printlnEmptyReturnMsg("getThreadInfo", lockThdDataset);
			} else {
				for (CompositeData threadCD : lockThdDataset) {
					ThreadInfo threadData = ThreadInfo.from(threadCD);

					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, 0, true);

						long threadId = threadData.getThreadId();
						if (enabled) {

							long uTime = ((Long)(mbs.invoke(tb, "getThreadUserTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							long cpuTime = ((Long)(mbs.invoke(tb, "getThreadCpuTime", new Object[] { threadId },
									new String[] { "long" }))).longValue();

							if (cpuTime == -1) {
								Report.printlnIndent("  CPU Time:                  -1 seconds");
							} else {
								Report.printlnIndent(
										"  CPU Time:                  " + df.format(cpuTime * 1e-9) + " seconds");
							}
							if (uTime == -1) {
								Report.printlnIndent("  User Time:                 -1 seconds");
							} else {
								Report.printlnIndent(
										"  User Time:                 " + df.format(uTime * 1e-9) + " seconds");
							}
						}
						if (stackDepth > 0) {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo",
									new Object[] { threadId, stackDepth }, new String[] { "long", "int" }));
						} else {
							threadCD = (CompositeData)(mbs.invoke(tb, "getThreadInfo", new Object[] { threadId },
									new String[] { "long" }));
						}

						ThreadInfo threadInfo = ThreadInfo.from(threadCD);

						if (threadInfo != null) {
							writeThreadInfo(threadInfo, tcmEnabled, df, stackDepth, false);
						}
						Report.println();
					} else { 
						// Print out a warning message - getting one or two nulls is ok, lots is worrying
						Report.printlnIndent(
								"*** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.printlnIndent(
								"*** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}

					Report.println();
					Report.println();
				}
			}

			Report.decrementIndentation();
			Report.println();

			// write data to the file on the deadlocked threads...
			Report.printlnIndent("DEADLOCK THREAD INFORMATION");
			Report.incrementIndentation();
			Report.println();

			long[] deadlockedThreads = (long[])mbs.invoke(tb, "findMonitorDeadlockedThreads", new Object[] {},
					new String[] {});

			// Get the thread info for all the deadlocked threads.
			if (deadlockedThreads != null) {
				if (stackDepth > 0) {
					threadDataset = (CompositeData[])(mbs.invoke(tb, "getThreadInfo",
							new Object[] { deadlockedThreads, stackDepth }, new String[] { "[J", "int" }));
				} else {
					threadDataset = (CompositeData[])(mbs.invoke(tb, "getThreadInfo",
							new Object[] { deadlockedThreads }, new String[] { "[J" }));
				}

				for (CompositeData threadCD : threadDataset) {
					ThreadInfo threadData = ThreadInfo.from(threadCD);

					if (threadData != null) {
						writeThreadInfo(threadData, tcmEnabled, df, stackDepth, false);
						Report.println();
					} else { 
						//print out a warning message - getting one or two nulls is ok, lots is worrying
						Report.println(
								"  *** WARNING: one of the thread IDs does not have a related ThreadInfo object. ***");
						Report.println(
								"  *** This isn't necessarily a problem (the thread may have terminated recently) but many occurrences would be suspicious. ***");
					}
				}
			} else {
				Report.printlnIndent("Currently no deadlocked threads.");
			}
			
			Report.decrementIndentation();
			Report.println();

		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
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
		} catch (ConnectException ce) {
			Message.logOut(ce.getMessage());
			ce.printStackTrace();
			Assert.fail(ce.getMessage());
		} catch (UnmarshalException ue) {
			Message.logOut(ue.getMessage());
			ue.printStackTrace();
			Assert.fail(ue.getMessage());
		} catch (IOException ie) {
			Message.logOut("IO Problem during reflection of the MBean");
			ie.printStackTrace();
			Assert.fail("IO Problem during reflection of the MBean");
		} finally {
			Report.failureSummary();
			closeLogFile();
		}
	}

	/**
	 * This method uses MBean "reflection" to find the signature for the given
	 * "operation" (AKA "method" for Java). Output may be requested for the
	 * documentation of the requested operation by providing a PrinterWriter
	 * object. No work is done if no output is requested (i.e. null value for
	 * <code>output</code>).
	 * 
	 * @param mbsc
	 *            MBeanServerConnection
	 * @param objectName
	 *            MBean ObjectName
	 * @throws InstanceNotFoundException
	 * @throws ReflectionException
	 * @throws IOException
	 * @throws MBeanException
	 */
	public void writeMBeanInfo(MBeanServerConnection mbsc, ObjectName objectName)
			throws InstanceNotFoundException, ReflectionException, IOException, MBeanException {

		ExpectedMBeanInfo.initExpectedMBean();

		try { // Obtain the MBeanInfo object about our MBean and delve inside
			MBeanInfo mbi = mbsc.getMBeanInfo(objectName);
			Report.printlnIndent(
					"Class name \"" + mbi.getClassName() + "\": description \'" + mbi.getDescription() + "\'");
			Report.incrementIndentation();

			Report.printIndent("Constructors:  ");
			MBeanConstructorInfo[] mbcia = mbi.getConstructors();
			
			if ((mbcia == null) || (mbcia.length <= 0)) {
				Report.printlnEmptyReturnMsg("MBeanInfo.getConstructors()", mbcia);
			} else {
				Report.incrementIndentation();
				Report.println();
				for (MBeanConstructorInfo mbci : mbcia) {
					Report.printlnIndent(mbci.getName() + ": " + mbci.getDescription());
					Report.printlnIndent("  " + mbci.toString());
					Report.incrementIndentation();
					Report.printIndent("Parameters:  ");
					MBeanParameterInfo[] mbpia = mbci.getSignature();
					Object[] arguments = null;
					if ((mbpia == null) || (mbpia.length <= 0)) {
						Report.printlnEmptyReturnMsg("MBeanConstructorInfo.getSignature()", mbpia);
						Report.println("");
					} else {
						Report.incrementIndentation();
						arguments = new Object[mbpia.length];
						Report.println();
						
						for (MBeanParameterInfo mbpi : mbpia) {
							Report.printlnIndent("Type: \"" + mbpi.getType() + "\"; " + "Name: \"" + mbpi.getName()
							+ "\"; " + "Description: \"" + mbpi.getDescription() + "\"");
							Report.printlnIndent("  " + mbpi.toString());
						}
						Report.decrementIndentation();
					}
					Report.decrementIndentation();
					invokeMBeanOperation(mbsc, objectName, mbci.getName(), arguments);
					ExpectedMBeanInfo.checkOffConstructor(mbci.getName());
				} // End of "if(empty mbpia) ... else ..."
				Report.decrementIndentation();
			} // End of "if(empty mbcia) ... else ..."

			Report.printIndent("Attributes:  ");
			MBeanAttributeInfo[] mbaia = mbi.getAttributes();
			
			if ((mbaia == null) || (mbaia.length <= 0)) {
				Report.printlnEmptyReturnMsg("MBeanInfo.getAttributes()", mbaia);
			} else {
				Report.incrementIndentation();
				Report.println();
				for (MBeanAttributeInfo mbai : mbaia) {
					Report.printlnIndent("Type: \"" + mbai.getType() + "\"; Name: \"" + mbai.getName()
					+ "\"; Description:\"" + mbai.getDescription() + "\"");
					Report.printlnIndent("  " + mbai.toString());
					ExpectedMBeanInfo.checkOffAttribute(mbai.getName());
				}
				Report.decrementIndentation();
			}

			Report.printIndent("Notifications:  ");
			MBeanNotificationInfo[] mbnia = mbi.getNotifications();
			
			if ((mbnia == null) || (mbnia.length <= 0)) {
				Report.printlnEmptyReturnMsg("MBeanInfo.getNotifications()", mbnia);
			} else {
				Report.incrementIndentation();
				Report.println();
				for (MBeanNotificationInfo mbni : mbnia) {
					Report.printlnIndent(
							"Name: \"" + mbni.getName() + "\"; Description: \"" + mbni.getDescription() + "\"");
					Report.printlnIndent("  " + mbni.toString());
					Report.printIndent("Notify Types:");
					String[] mbnta = mbni.getNotifTypes();
					if ((mbnta == null) || (mbnta.length <= 0)) {
						Report.printlnEmptyReturnMsg("MBeanNotificationInfo.getNotifTypes()", mbnta);
					} else {
						Report.incrementIndentation();
						Report.println();
						for (String mbnt : mbnta) {
							Report.printlnIndent("\"" + mbnt.toString() + "\"");
						}
						Report.decrementIndentation();
					}
					ExpectedMBeanInfo.checkOffNotification(mbni.getName());
				}
				Report.decrementIndentation();
			}

			Report.printIndent("Operations:  ");
			MBeanOperationInfo[] mboia = mbi.getOperations();
			if ((mboia == null) || (mboia.length <= 0)) {
				Report.printlnEmptyReturnMsg("MBeanInfo.getOperations()", mboia);
			} else {
				Report.println();
				for (MBeanOperationInfo mboi : mboia) {
					Report.incrementIndentation();
					MBeanParameterInfo[] mbpia = mboi.getSignature();
					if ((mbpia == null) || (mbpia.length <= 0)) {
						Report.printlnIndent(mboi.getName() + "():  ");
						Report.incrementIndentation();
						Report.printlnEmptyReturnMsg("MBeanOperationInfo.getSignature()", mbpia);
						Report.println("");
						Report.decrementIndentation();
					}
					if ((mbpia != null) && (mbpia.length >= 0)) {
						// Empty arrays simply indicate no arguments!
						Object[] arguments = new Object[mbpia.length];
						String outStr = mboi.getName() + "(";
						Report.printIndent(outStr);
						String padding = null;
						if (mbpia.length > 1) {
							padding = new String(outStr).replaceAll(".", " ");
						}
						for (int i = 0; i < mbpia.length; ++i) {
							if (i > 0) {
								Report.println(",");
								Report.printIndent(padding);
							}
							Report.print(mbpia[i].getDescriptor().toString() + " \"" + mbpia[i].getType() + "\" "
									+ mbpia[i].getDescription());
							arguments[i] = makeUpHoaxArg(mbpia[i]);
						}
						Report.println(")");
						Report.incrementIndentation();
						Report.printlnIndent("returns \"" + mboi.getReturnType() + "\"");
						Report.decrementIndentation();
						invokeMBeanOperation(mbsc, objectName, mboi.getName(), arguments);
					}
					ExpectedMBeanInfo.checkOffOperation(mboi.getName());
					Report.decrementIndentation();
				} // end of "for ( MBeanOperationInfo mboi : mboia )"
				Report.decrementIndentation();
			} // end of "if ( mboia empty ) else"
			Report.decrementIndentation();
		} catch (IntrospectionException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} finally {
			Report.decrementIndentation();
		}
		ExpectedMBeanInfo.writeOutChecklistReport(); // ... and count them "in" again
		Report.failureSummary();
	} // end of method

	/**
	 * Fabricates an argument based on the information given in
	 * <code>MBeanParameterInfo</code>
	 * 
	 * @param mbpi
	 *            Object holding the description of the argument to fabricate.
	 * @return An appropriate argument or <code>null</code> is anything goes
	 *         wrong.
	 */
	private Object makeUpHoaxArg(MBeanParameterInfo mbpi) {
		String argType = mbpi.getType();
		if (argType.equals("boolean")) {
			return new Boolean(true);
		}
		if (argType.equals("byte")) {
			return new Byte(" ");
		}
		if (argType.equals("char")) {
			return new Character(' ');
		}
		if (argType.equals("double")) {
			return new Double(0.0);
		}
		if (argType.equals("float")) {
			return new Float(0.0);
		}
		if (argType.equals("int")) {
			return new Integer(1);
		}
		if (argType.equals("long")) {
			return new Long(Thread.currentThread().getId());
		}
		if (argType.equals("short")) {
			return new Short("0");
		}
		if (argType.equals("void")) {
			return new Object();
		}
		// Anything else must be a non-"native" type
		Object retVal = null;
		try {
			Class<?> mbpiClass = Class.forName(mbpi.getType());
			if (mbpiClass.isArray()) {
				retVal = Array.newInstance(mbpiClass, 1);
			} else {
				retVal = mbpiClass.newInstance();
			}
		} catch (ClassNotFoundException cnfe) {
			String message = "Class not found exception in " + mbpi.toString() + " for \"" + mbpi.getType() + "\"";
			Report.printlnFailureMsg(message);
			cnfe.printStackTrace();
			Assert.fail(message);
		} catch (InstantiationException ie) {
			String message = "Instantiation exception from " + mbpi.toString() + " for \"" + mbpi.getType() + "\"";
			Report.printlnFailureMsg(message);
			ie.printStackTrace();
			Assert.fail(message);
		} catch (IllegalAccessException iae) {
			String message = "Illegal access exception from " + mbpi.toString() + " for \"" + mbpi.getType() + "\"";
			Report.printlnFailureMsg(message);
			iae.printStackTrace();
			Assert.fail(message);
		}
		return retVal;
	}

	/**
	 * This method uses MBean "reflection" to find the signature for the given
	 * "operation" (AKA "method" for Java) and invokes that operation. Any
	 * returned value is returned under the guise of an Object, and is likely to
	 * be either a simple datatype or a CompositeData mapping - whichever it is
	 * should be cast by the calling method.
	 * 
	 * @param mbsc
	 *            MBeanServerConnection
	 * @param objectName
	 *            MBean ObjectName
	 * @param operationName
	 *            MBean "operation" (method for Java) to find and call
	 * @param arguments
	 *            Array of objects holding arguments for the invocation
	 * @return Returned Object from the invocation or null if operation not
	 *         found
	 * @throws InstanceNotFoundException
	 * @throws ReflectionException
	 * @throws IOException
	 * @throws MBeanException
	 */
	public Object invokeMBeanOperation(MBeanServerConnection mbsc, ObjectName objectName, String operationName,
			Object[] arguments) throws InstanceNotFoundException, ReflectionException, IOException, MBeanException {
		Object returnedResult = null;
		boolean available = false;

		String[] methodSignature = null;

		Report.printlnIndent("Attempting to execute MBean operation called \"" + operationName + "\"");
		try {
			MBeanInfo mbi = mbsc.getMBeanInfo(objectName);
			if (mbi == null) {
				Report.printlnFailureMsg(
						"MBeanServerConnection.getMBeanInfo(objectName) returned null on " + operationName);
				Assert.fail("MBeanServerConnection.getMBeanInfo(objectName) returned null on " + operationName);
			} else {
				MBeanOperationInfo[] mboia = mbi.getOperations();
				if (mboia == null) {
					Report.printlnFailureMsg("MBeanInfo.getOperations() returned null on " + operationName);
					Assert.fail("MBeanInfo.getOperations() returned null on " + operationName);
				} else {
					for (MBeanOperationInfo mboi : mboia) {
						MBeanParameterInfo[] mbpia = mboi.getSignature();
						if (mbpia == null) {
							Report.printlnFailureMsg(
									"MBeanOperationInfo.getSignature() returned null on " + operationName);
							Assert.fail("MBeanOperationInfo.getSignature() returned null on " + operationName);
							Report.println("");
						} else {
							if (mboi.getName().compareTo(operationName) == 0) {
								methodSignature = new String[mbpia.length];
								for (int i = 0; i < mbpia.length; ++i) {
									methodSignature[i] = mbpia[i].getType();
								}
								Report.printlnSuccessMsg("MBean operation " + operationName + " is available");
								available = true;
								break; 
							}
						}
					}

					boolean supported = true;

					try {
						//Some operations may not be supported check first...
						if (methodSignature != null && (operationName.equals("getCurrentThreadCpuTime")
								|| operationName.equals("getCurrentThreadUserTime"))) {
							supported = ((Boolean)mbsc.getAttribute(objectName, "CurrentThreadCpuTimeSupported"))
									.booleanValue();
						} else if (methodSignature != null && (operationName.equals("getThreadCpuTime")
								|| operationName.equals("getThreadUserTime"))) {
							supported = ((Boolean)mbsc.getAttribute(objectName, "ThreadCpuTimeSupported"))
									.booleanValue();
						} else if (methodSignature != null && operationName.equals("setThreadCpuTimeEnabled")) {
							boolean currentThdSupported = ((Boolean)mbsc.getAttribute(objectName,
									"CurrentThreadCpuTimeSupported")).booleanValue();
							boolean thdSupported = ((Boolean)mbsc.getAttribute(objectName, "ThreadCpuTimeSupported"))
									.booleanValue();
							if (currentThdSupported == false || thdSupported == false) {
								supported = false;
							}
						} else if (methodSignature != null
								&& operationName.equals("setThreadContentionMonitoringEnabled")) {
							supported = ((Boolean)mbsc.getAttribute(objectName, "ThreadContentionMonitoringSupported"))
									.booleanValue();
						} else if (methodSignature != null && operationName.equals("findDeadlockedThreads")) {
							supported = ((Boolean)mbsc.getAttribute(objectName, "SynchronizerUsageSupported"))
									.booleanValue();
						}
					} catch (AttributeNotFoundException ie) {
						Report.flushAll();
						ie.printStackTrace();
						Assert.fail(ie.getMessage());
					}

					// GetThreadInfo guess value are not valid so don't try
					if (methodSignature != null && !operationName.equals("getThreadInfo")
							&& !operationName.equals("getNativeThreadIds") //This requires "monitor" permission - which is not configured 
							&& supported == true) {
						Report.printlnSuccessMsg("Attempting to invoke MBean operation " + operationName);
						returnedResult = mbsc.invoke(objectName, operationName, arguments, methodSignature);
						Report.printlnSuccessMsg(
								"MBean operation " + operationName + " invoked successfully.  Returned result is "
										+ ((returnedResult == null) ? "" : "not ") + "null");
					}
				}
			}
			if (!available) {
				Report.printlnFailureMsg("MBean operation \"" + operationName + "\" is NOT supported");
			}
		} catch (IntrospectionException ie) {
			Report.flushAll();
			ie.printStackTrace();
			Assert.fail(ie.getMessage());
		} catch (ReflectionException re) {
			Report.flushAll();
			if (re.getCause() instanceof NoSuchMethodException) {
				Report.printlnFailureMsg("Invocation failed: NoSuchMethodException on " + operationName);
			}
			re.printStackTrace();
			Assert.fail(re.getMessage());
		} catch (RuntimeMBeanException rmbe) {
			Report.flushAll();
			if (rmbe.getCause() instanceof IllegalArgumentException) {
				Report.printlnInformationMsg(
						"Invocation failed: IllegalArgumentException (probably guessed arguments badly)");
			}
			rmbe.printStackTrace();
			Assert.fail(rmbe.getMessage());
		} finally {
			Report.printlnIndent("Attempt to execute MBean operation called \"" + operationName + " complete\"");
		}

		Report.printlnIndent("");
		return returnedResult;
	}

	// ThreadInfo contains a toString method, but we want to test the get...() methods too
	private void writeThreadInfo(ThreadInfo thread, boolean tcmEnabled, DecimalFormat df, int stackDepth,
			boolean checkLocks) {
		Report.incrementIndentation();

		// Write a combination of thread name and id as the unique identifier 
		// for the thread. 
		writeThreadIdentifier(thread.getThreadName() + " (" + thread.getThreadId() + ")");
		Report.println();

		// Store the thread's general data including its stacktrace
		String state = thread.getThreadState().toString();
		checkThreadState(state);
		Report.printlnIndent("Thread State:              " + state);

		Report.printIndent("Thread Suspended:          ");
		if (thread.isSuspended()) {
			Report.printlnIndent("Yes");
		} else {
			Report.printlnIndent("No");
		}

		Report.printIndent("Thread in native code:     ");
		if (thread.isInNative()) {
			Report.printlnIndent("Yes");
		} else {
			Report.printlnIndent("No");
		}

		Report.println();

		Report.printlnIndent("# monitor blocks occurred: " + thread.getBlockedCount());
		Report.printlnIndent("# waits for notification:  " + thread.getWaitedCount());

		if (tcmEnabled) {
			Report.printlnIndent(
					"Total time spent blocked:  " + df.format(thread.getBlockedTime() * 1e-3) + " seconds");
			Report.printlnIndent("Total time spent waiting:  " + df.format(thread.getWaitedTime() * 1e-3) + " seconds");
		}

		// Attempt to identify what, if anything, is blocking the thread
		String lockName = thread.getLockName(); 

		Report.printIndent("Currently blocked by:      ");
		if (lockName != null) {
			Report.println(lockName);

			if (tcmEnabled) {
				Report.printlnIndent("                           Owned by - " + thread.getLockOwnerName() + " ("
						+ thread.getLockOwnerId() + ")");
			} // if not enabled, we can't get this information, so print nothing

		} else {
			Report.printlnIndent("Thread not currently blocked");
		}

		Report.println();

		StackTraceElement[] stackTrace = thread.getStackTrace();

		// We may not have requested a stack trace when we got the ThreadInfo,
		// in which case we will be returned a zero-length array
		if ((stackTrace != null) && (stackTrace.length > 0)) {
			Report.printIndent("Stack trace:               ");

			if (stackDepth <= 0) {
				stackDepth = stackTrace.length;
			}

			for (StackTraceElement element : stackTrace) {
				Report.printlnIndent(element.toString());
				if (--stackDepth <= 0)
					break;
				Report.printIndent("                           ");
			}

			Report.println();
		}

		if (checkLocks == true) {
			// And now, check the locks etc. ...
			VMData.writeBanner("Lock Information", out, 0, 2);
			Report.incrementIndentation();

			// GetLockInfo
			Report.printIndent("Thread is ");
			Report.incrementIndentation();
			LockInfo lockInfo = thread.getLockInfo();
			if (lockInfo == null) { // No lock
				Report.println("not locked");
			} else {  
				Report.println("locked:          " + lockInfo.toString());
				Report.printlnIndent("Class name: \"" + lockInfo.getClassName() + "\"; Identity hash code: \""
						+ lockInfo.getIdentityHashCode() + "\"");
				Report.println("");

				if (lockInfo.toString().compareTo(lockName) != 0) {
					Report.printlnFailureMsg("Blocker and lock name/codes do not match");
				}
			}
			Report.decrementIndentation();

			// GetLockedSynchronizers
			Report.printIndent("Locked synchronizers:      ");

			Report.incrementIndentation();
			LockInfo[] lockedSynchronizers = thread.getLockedSynchronizers();
			if (lockedSynchronizers == null) {
				Assert.fail("ThreadInfo's getLockedSynchronizers() method returned null instead of an empty array");
			}

			if ((lockedSynchronizers == null) || (lockedSynchronizers.length <= 0)) { 
				// No Monitor locks associated with this thread
				Report.println("none");
			} else {
				Report.printlnIndent("" + lockedSynchronizers.length);
				Report.incrementIndentation();
				for (LockInfo lockedSynchronizer : lockedSynchronizers) {
					if (lockedSynchronizer == null) {
						Assert.fail(
								"The array returned by ThreadInfo's getLockedSynchronizers() method contained null objects");
					} else {
						Report.printlnIndent(lockedSynchronizer.toString());
						Report.printlnIndent("Class name: \"" + lockedSynchronizer.getClassName()
						+ "\"; Identity hash code: \"" + lockedSynchronizer.getIdentityHashCode() + "\"");
						Report.println("");

					}
				}
				Report.decrementIndentation();
			}
			Report.decrementIndentation();

			// GetLockedMonitors
			Report.printIndent("Monitor locks:             ");
			Report.incrementIndentation();
			MonitorInfo[] lockedMonitors = thread.getLockedMonitors();

			if (lockedMonitors == null) {
				Assert.fail("ThreadInfo's getLockedMonitors() method returned null instead of an empty array");
			}

			if ((lockedMonitors == null)
					|| (lockedMonitors.length <= 0)) { 
				// No Monitor locks associated with this thread
				Report.println("none");
			} else {
				Report.printlnIndent("" + lockedMonitors.length);
				for (MonitorInfo lockedMonitor : lockedMonitors) {
					if (lockedMonitor == null) {
						Assert.fail(
								"The array returned by ThreadInfo's getLockedMonitors() method contained null objects");
					} else {
						StackTraceElement lockedSFrame = lockedMonitor.getLockedStackFrame();
						String stackFrame = "Unknown";
						if (lockedSFrame != null) {
							stackFrame = lockedSFrame.toString();
						}
						Report.printlnIndent(lockedMonitor.toString());
						Report.printlnIndent("Class name: \"" + lockedMonitor.getClassName()
						+ "\"; Identity hash code: \"" + lockedMonitor.getIdentityHashCode()
						+ "\"; Locked stack depth: " + lockedMonitor.getLockedStackDepth()
						+ "; LockedStackFrame: \"" + stackFrame + "\"");
						Report.println("");
					}
				}
			}
			Report.decrementIndentation();

			if (lockInfo != null && (lockedMonitors == null && lockedSynchronizers == null)) {
				Assert.fail("Thread's lockInfo exists but now locked Monitors or Synchronizers exist");
			}
		}
		Report.decrementIndentation();
		Report.printlnIndent("");
		Report.decrementIndentation();
	}

	private void writeThreadIdentifier(String threadIdentifier) {
		// Write the thread identifier as a banner ( highlighted with stars)
		VMData.writeBanner("Thread: " + threadIdentifier, out, 0, 2);
	}

	public void checkThreadStats(String connect_type, int current, long start, int peak, int daemon) {
		// Check none of the thread counts are negative, the current count is 
		// not less than the started count, the daemon count is smaller then the current 
		// or started (ever) count, the peak count is greater then the current but not 
		// greater than the started count A.
		Assert.assertTrue("Negative value returned for the Current Thread Count value (" + connect_type + " test)",
				current >= 0);
		Assert.assertTrue("Negative value returned for the Started Thread Count value (" + connect_type + " test)",
				start >= 0);
		Assert.assertTrue("Negative value returned for the Peak Thread Count value (" + connect_type + " test)",
				peak >= 0);
		Assert.assertTrue("Negative value returned for the Daemon Count value (" + connect_type + " test)",
				daemon >= 0);
		Assert.assertTrue("Current Thread Count value returned was greater then the Started Thread Count value ("
				+ connect_type + " test)", current <= start);
		Assert.assertTrue("Daemon Thread Count value returned was greater then the Started Thread Count value ("
				+ connect_type + " test)", daemon <= start);
		Assert.assertTrue("Current Thread Count value returned was greater then the Peak Thread Count value ("
				+ connect_type + " test)", current <= peak);
		Assert.assertTrue("Peak Thread Count value returned was greater then the Started Thread Count value ("
				+ connect_type + " test)", peak <= start);
	}

	public void checkThreadState(String state) {
		// Check the thread state has a valid value
		if (!((state.equals("BLOCKED")) || (state.equals("RUNNABLE")) || (state.equals("WAITING"))
				|| (state.equals("NEW")) || (state.equals("TIMED_WAITING")) || (state.equals("TERMINATED")))) {
			Assert.fail("Invalid Value return for Thread State");
		}
	}
}
