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

package net.adoptopenjdk.test.jlm.local;

import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MonitorInfo;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.util.List;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.LoggingMXBean;
import javax.management.Attribute;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import net.adoptopenjdk.test.jlm.locks.ConditionLock;
import net.adoptopenjdk.test.jlm.locks.DeadLock;
import net.adoptopenjdk.test.jlm.locks.DeepLock;
import net.adoptopenjdk.test.jlm.locks.MonitorDeadLock;
import net.adoptopenjdk.test.jlm.resources.ClassData;
import net.adoptopenjdk.test.jlm.resources.EnvironmentData;
import net.adoptopenjdk.test.jlm.resources.Message;
import net.adoptopenjdk.test.jlm.resources.LockType;
import net.adoptopenjdk.test.jlm.resources.MemoryData;
import net.adoptopenjdk.test.jlm.resources.ThreadData;
import net.adoptopenjdk.test.jlm.resources.VMData;
import org.junit.Assert;

/*
 * This class retrieves information about the local VM
 */
public class VMLogger {

	private String logFile;
	private String compiler = "";
	
	// MBeanServerConnection
    private MBeanServerConnection mbs;
	
	// Proxis
    private RuntimeMXBean         runtimeBean;
    private OperatingSystemMXBean osBean;
    private ClassLoadingMXBean    classBean;
    private CompilationMXBean     compBean;
    private ThreadMXBean          threadBean;
    private MemoryMXBean          memBean;
    private LoggingMXBean         logBean;
    
    private List<MemoryPoolMXBean>        memPoolBeans;
    private List<MemoryManagerMXBean>     memMgrBeans;
    private List<GarbageCollectorMXBean>  gcBeans;    
    
    // Server ObjectNames 
    private ObjectName srvRuntimeName;
    private ObjectName srvOSName;
    private ObjectName srvClassName;
    private ObjectName srvCompName;
    private ObjectName srvThrdName;
    private ObjectName srvMemName;
    private ObjectName srvLogName;

    private Set<?> srvMemMgrNames;
    private Set<?> srvMemPoolNames;
    private Set<?> srvGCNames;
    
    // Data loggers
    private EnvironmentData envData;   
    private ClassData classData;  
    private MemoryData memoryData;      
    private ThreadData threadData; 
    
    public VMLogger(String logFile) {
    	// Store the log file
    	this.logFile = logFile;
    	
    	// Use "default" version of call with empty string
        this.compiler = System.getProperty("java.compiler",""); 
    }
    
    public static void main (String[] args) {
        if (args.length != 1) {
            Message.logOut("Usage: net.adoptopenjdk.test.jlm.local.VMLogger <logFile>");
            Assert.fail("Usage: java net.adoptopenjdk.test.jlm.local.VMLogger <logFile>");
        }

        // Create a VMLogger object to run the test
        VMLogger theLogger = new VMLogger(args[0]);

        // Initialize logger 
        theLogger.initialise();

        // Check GC Count
        theLogger.checkGCCount();
        
        // Write the VM Data to the files using the MXBean Proxies
        theLogger.writeProxyData("VM DATA RETRIEVED USING BEANS DIRECTLY");
        
        // Write the VM Data to the files using the MBeanServerConnection
        theLogger.writeServerData("VM DATA RETRIEVED USING THE MBEAN SERVER");

        // Test the information returned by jlm LockInfo, MonitorInfo is correct.  Added for Java60 
        theLogger.checkLocks();

        // Enable some of the optional functionality and then rewrite the
        // VM Data using the MBeanServerConnection
        theLogger.enableOptionalFunctionality();
        theLogger.writeServerData("VM DATA RETRIEVED USING THE MBEAN SERVER - OPTIONAL FUNCTIONALITY ENABLED");
        
        // Disable the functionality and then rewrite the VM Data through proxies
        theLogger.disableOptionalFunctionality();
        theLogger.writeServerData("VM DATA RETRIEVED USING THE BEANS DIRECTLY - OPTIONAL FUNCTIONALITY DISABLED");
    } 

    public void initialise() {
        // Initialize the logger
        mbs = ManagementFactory.getPlatformMBeanServer();

        // Initialize the proxies
        initialiseProxies();
        
        // Initialize server name objects;
        initialiseServerNames();
    
        // Initialize each of the data loggers
        initialiseDataLoggers();
        
        VMData.writeHeading(logFile, false, "START TESTING");
    }
   
    private void initialiseProxies() {
        runtimeBean  = ManagementFactory.getRuntimeMXBean();
        osBean       = ManagementFactory.getOperatingSystemMXBean();
        classBean    = ManagementFactory.getClassLoadingMXBean();
        
        if (!(compiler.equals("")))
        {	
            compBean  = ManagementFactory.getCompilationMXBean();
        }
        
        threadBean   = ManagementFactory.getThreadMXBean();
        memBean      = ManagementFactory.getMemoryMXBean();
        logBean      = LogManager.getLoggingMXBean();

        memPoolBeans = ManagementFactory.getMemoryPoolMXBeans();
        memMgrBeans  = ManagementFactory.getMemoryManagerMXBeans();
        gcBeans      = ManagementFactory.getGarbageCollectorMXBeans();
    }
    
    // Get the ObjectNames need to access the MXBeans through a MBeanServerConnection
    private void initialiseServerNames() {
        try {
        	srvRuntimeName  = new ObjectName(ManagementFactory.RUNTIME_MXBEAN_NAME);
            srvOSName       = new ObjectName(ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME);
            srvClassName    = new ObjectName(ManagementFactory.CLASS_LOADING_MXBEAN_NAME);

            if (!(compiler.equals(""))) {	
                srvCompName = new ObjectName(ManagementFactory.COMPILATION_MXBEAN_NAME);
            }
                        
            srvThrdName     = new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME);
            srvMemName      = new ObjectName(ManagementFactory.MEMORY_MXBEAN_NAME);
            srvLogName      = new ObjectName("java.util.logging:type=Logging");
            srvMemMgrNames  = mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE + ",*"), null);
            srvMemPoolNames = mbs.queryNames(new ObjectName(ManagementFactory.MEMORY_POOL_MXBEAN_DOMAIN_TYPE + ",*"), null);
            srvGCNames      = mbs.queryNames(new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*"), null);

        } catch ( MalformedObjectNameException me) {
            Message.logOut("Got a MalformedObjectNameException");
            me.printStackTrace();
            Assert.fail("Got a MalformedObjectNameException");
        } catch ( IOException ie ) {
            Message.logOut("Caught an IOException:");
            ie.printStackTrace();
            Assert.fail("Caught an IOException: \n" + ie.getMessage());
        }	
    }
    
    private void initialiseDataLoggers() {
        envData    = new EnvironmentData(logFile);
        classData  = new ClassData(logFile);
        memoryData = new MemoryData(logFile);
        threadData = new ThreadData(logFile);
    }
    
    public void writeProxyData(String msg) {
        VMData.writeHeading(logFile, true, msg); 
        try {
            envData.writeData (runtimeBean, osBean, logBean, true);
            classData.writeData (classBean, compBean, runtimeBean, true);
            memoryData.writeData (memBean, memMgrBeans, memPoolBeans, gcBeans, true);
            threadData.writeData (threadBean, 8, true);
        } catch ( UndeclaredThrowableException ue) {
            Message.logOut("UndeclaredThrowableException when trying to access the Platform MBean Server");
            ue.printStackTrace();
            Assert.fail("UndeclaredThrowableException when trying to access the Platform MBean Server");           
        } 
    }
    
    public void writeServerData(String msg) {
        VMData.writeHeading(logFile, true, msg); 
        try {
            envData.writeData(mbs, srvRuntimeName, srvOSName, srvLogName, true);
            classData.writeData(mbs, srvClassName, srvCompName, srvRuntimeName, true);
            memoryData.writeData(mbs, srvMemName, srvMemMgrNames, srvMemPoolNames, srvGCNames, true);
            threadData.writeData(mbs, srvThrdName, 8, true);
        } catch ( ConnectException ce) {
            Message.logOut("ConnectException when trying to access the Platform MBean Server");
            ce.printStackTrace();
            Assert.fail("ConnectException when trying to access the Platform MBean Server");            
        } catch ( UnmarshalException ue) {
            Message.logOut("UnmarshelException when trying to access the Platform MBean Server");
            ue.printStackTrace();
            Assert.fail("UnmarshelException when trying to access the Platform MBean Server");           
        } 
    }
    
    // Get the GC count, then invoke a GC using the bean, and check that the GC count has gone up
    public void checkGCCount() {
        int totalGCCountBefore = 0;
        int totalGCCountAfter = 0;
        long totalGCTimeBefor = 0;
        long totalGCTimeafter = 0;
        
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            totalGCCountBefore += gcBean.getCollectionCount();
            // in case of accumulation exceed long max
            totalGCTimeBefor += gcBean.getCollectionTime()/2;
        }

        memBean.gc();

        for (GarbageCollectorMXBean gcBean : gcBeans) {
            totalGCCountAfter += gcBean.getCollectionCount();
            // in case of accumulation exceed long max
            totalGCTimeafter += gcBean.getCollectionTime()/2;
        }

        if (totalGCCountAfter < totalGCCountBefore) {
            Message.logErr("ERROR: Invoking a GC via the MemoryMXBean has caused incorrect GC results");
            Message.logErr("GC count before: " + totalGCCountBefore + ", GC count after: " + totalGCCountAfter);
            Message.logErr("GC count before: " + totalGCTimeBefor + ", GC count after: " + totalGCTimeafter);
        }
        else if (totalGCCountAfter == totalGCCountBefore) {
            Message.logOut("GC requested via the MemoryMXBean, but JVM did not invoke one (acceptable behaviour)");         
        }
        else {
            Message.logOut("GC requested via the MemoryMXBean, and JVM invoked one (acceptable behaviour)");
            Message.logOut("GC count before: " + totalGCCountBefore + ", GC count after: " + totalGCCountAfter);
            Message.logOut("GC time before: " + totalGCTimeBefor + ", GC time after: " + totalGCTimeafter);
        }
        
        Assert.assertTrue("GC requested via the MemoryMXBean, totalGCTimeafter " + totalGCTimeafter
                + " should be larger than or equal to " + totalGCTimeBefor + " totalGCTimeBefor ", totalGCTimeafter >= totalGCTimeBefor);
        Assert.assertTrue("GC requested via the MemoryMXBean, totalGCCountAfter " + totalGCCountAfter
                + " should be larger than or equal to " + totalGCCountBefore + " totalGCCountBefore ", totalGCCountAfter >= totalGCCountBefore);   
    }

    // This method checks if the correct lock information is returned under
	// different situations
    public void checkLocks() {
    	// DeadLock Threads	using a lock
        checkDeadLock();	
            
        // DeadLock Threads using Monitors
        checkMonitorDeadLock();	
          
    	// Deeply Lock using ReentrantLock 
    	checkDeepLock();	
        
        // Condition Lock 
        checkConditionLock();
    }

    public void checkDeadLock() {
        // DeadLock Threads		
		DeadLock dl = new DeadLock();
		
		dl.initiateDeadlock();
				
		// DeadLock Threads should be locked but wait to be sure	
		try {
		    Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			Message.logErr("Unexpected Interrupt Signal Received in checkDeadLock()");
			e.printStackTrace();
		}
		
		try {
			// get a list of deadlocked threads
			long[] threadIDs = threadBean.findDeadlockedThreads();

			verifyDeadlockThds(threadIDs, LockType.SYNCHRONIZER, "Deadlock Thread 1", "Deadlock Thread 2");
			
			threadIDs =
                (long []) mbs.invoke(srvThrdName, "findDeadlockedThreads", new Object[] {}, new String[] {} );

			verifyDeadlockThds(threadIDs, LockType.SYNCHRONIZER, "Deadlock Thread 1", "Deadlock Thread 2");

			// get a list of monitored deadlocked threads 
			threadIDs = threadBean.findMonitorDeadlockedThreads();

			if (threadIDs != null) {
				ThreadInfo[] deadlockedThds = threadBean.getThreadInfo(threadIDs);
				if (deadlockedThds.length != 0)
				{				
					dl.releaseDeadlock();
					Assert.fail("Unexpected Deadlocked Threads Detected (expected 0, detected " + deadlockedThds.length);
				}
			}
		
        } catch (InstanceNotFoundException ie) {
            Message.logOut("MBean Instance not found");
            ie.printStackTrace();

        } catch (MBeanException mbe) {
            Message.logOut("Problem with the MBean access");
            mbe.printStackTrace();

        } catch (ReflectionException re) {
            Message.logOut("Problem with the reflection of the MBean");
            re.printStackTrace();

        } catch (IOException ie) {
            Message.logOut("IO Problem during reflection of the MBean");
            ie.printStackTrace();
		} finally {
			dl.releaseDeadlock();			
		}
    }

    public void checkMonitorDeadLock() {
        // DeadLock Threads using Monitors		
    	MonitorDeadLock ml = new MonitorDeadLock();
    	
    	ml.initiateDeadlock();
    					
    	// MonitorDeadLock Threads should be locked
    	try {
    	    Thread.sleep(5000);
    	}
    	catch (InterruptedException e) {
    		Message.logErr("Unexpected Interrupt Signal Received in checkMonitorDeadLock()");
    		e.printStackTrace();
    	}
    	
		// Get a list of deadlocked threads
		long[] threadIDs = threadBean.findDeadlockedThreads();
		
		verifyDeadlockThds(threadIDs, LockType.MONITOR, "Monitor Deadlock Thread 1", "Monitor Deadlock Thread 2");
		
		// Get a list of monitored deadlocked threads 
		threadIDs = threadBean.findMonitorDeadlockedThreads();
		verifyDeadlockThds(threadIDs, LockType.MONITOR, "Monitor Deadlock Thread 1", "Monitor Deadlock Thread 2");
		
    }

    public void checkDeepLock() {
        DeepLock d1 = new DeepLock(5);
        
        d1.initiateDeeplock();
		
		// The main thread should be deeply locked but wait to be sure
		try {
		    Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			Message.logErr("Unexpected Interrupt Signal Received in checkDeepLock()");
			e.printStackTrace();
		}
		
		try {
			// get a list of deadlocked threads
			long[] threadIDs = threadBean.findDeadlockedThreads();

			if (threadIDs == null) {
				Assert.fail("Unexpected deadlock found using proxy" );				
			}
			
			threadIDs =
                (long []) mbs.invoke(srvThrdName, "findDeadlockedThreads", new Object[] {}, new String[] {} );

			if (threadIDs == null) {
				Assert.fail("Unexpected deadlock found using server" );				
			}
			
			ThreadInfo[] liveThds = threadBean.dumpAllThreads(false, true);
			
			for(ThreadInfo thd: liveThds ) {
				String thdName = thd.getThreadName();
				if (thdName.equals("main")) {
					LockInfo[] lockList = null;
					lockList = thd.getLockedSynchronizers();

					if (lockList.length != 1) {
						Assert.fail("Reported Number of Locks Owned by " + thdName + " is Incorrect (expected = 1, reported = " + lockList.length + ")");
					}
					
					String className = lockList[0].getClassName();
					
					if (!className.equals("java.util.concurrent.locks.ReentrantLock$NonfairSync")) {
						Assert.fail("Lock is a " + className + " not expected ReentrantLock");					
					}
					
					LockInfo blockingLock = thd.getLockInfo();

					if (blockingLock != null) {
						Assert.fail("Unexpected Blocking Lock was returned by getLockInfo() for " + thdName);
					}
				}
			}
		} catch (InstanceNotFoundException ie) {
            Message.logOut("MBean Instance not found");
            ie.printStackTrace();
		} catch (MBeanException mbe) {
            Message.logOut("Problem with the MBean access");
            mbe.printStackTrace();
		} catch (ReflectionException re) {
            Message.logOut("Problem with the reflection of the MBean");
            re.printStackTrace();
		} catch (IOException ie) {
            Message.logOut("IO Problem during reflection of the MBean");
            ie.printStackTrace();
		} finally {
	        d1.releaseLocks();
		}		    	    
    }

    public void checkConditionLock() {
    	ConditionLock c1 = new ConditionLock();
        
        c1.initiateWait();
		
		// The main thread should be deeply locked but wait to be sure
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
			Message.logErr("Unexpected Interrupt Signal Received in checkDeepLock()");
			e.printStackTrace();
		}
		
		try {
			// get a list of deadlocked threads
			long[] threadIDs = threadBean.findDeadlockedThreads();

			if (threadIDs == null) {
				Assert.fail("Unexpected deadlock found using proxy" );				
			}
			
			threadIDs =
                (long []) mbs.invoke(srvThrdName, "findDeadlockedThreads", new Object[] {}, new String[] {} );

			if (threadIDs == null) {
				Assert.fail("Unexpected deadlock found using server" );				
			}
			
			ThreadInfo[] liveThds = threadBean.dumpAllThreads(false, true);
			
			for(ThreadInfo thd: liveThds) {
				String thdName = thd.getThreadName();
				if (thdName.equals("Condition Lock Thread")) {
					LockInfo[] lockList = null;
					lockList = thd.getLockedSynchronizers();

					if (lockList.length != 0) {
						Assert.fail("Reported Number of Locks Owned by " + thdName + " is Incorrect (expected = 1, reported = " + lockList.length + ")");
					}
					
					LockInfo blockingLock = thd.getLockInfo();

					if (blockingLock == null) {
						Assert.fail("Expected Blocking Lock was not returned by getLockName() for " + thdName);
					}
				}
			}
        } catch (InstanceNotFoundException ie) {
            Message.logOut("MBean Instance not found");
            ie.printStackTrace();
        } catch (MBeanException mbe) {
            Message.logOut("Problem with the MBean access");
            mbe.printStackTrace();
        } catch (ReflectionException re) {
            Message.logOut("Problem with the reflection of the MBean");
            re.printStackTrace();
        } catch (IOException ie) {
            Message.logOut("IO Problem during reflection of the MBean");
            ie.printStackTrace();
		} finally {
	        c1.sendSignal();
		}

		try {
			ThreadInfo[] liveThds = threadBean.dumpAllThreads(false, true);			
			for(ThreadInfo thd: liveThds ) {
				String thdName = thd.getThreadName();
				if (thdName.equals("main")) {
					LockInfo[] lockList = null;
					lockList = thd.getLockedSynchronizers();

					if (lockList.length != 1) {
						Assert.fail("Reported Number of Locks Owned by " + thdName + " is Incorrect (expected = 1, reported = " + lockList.length + ")");
					}
					
					String className = lockList[0].getClassName();
					
					if (!className.equals("java.util.concurrent.locks.ReentrantLock$NonfairSync")) {
						Assert.fail("Lock is a " + className + " not expected ReentrantLock");					
					}
					
					LockInfo blockingLock = thd.getLockInfo();

					if (blockingLock != null) {
						Assert.fail("Unexpected Blocking Lock was returned by getLockName() for " + thdName);
					}
				}
			}
		} finally {
			c1.releaseLock();
		} 			
    }

    public void verifyDeadlockThds(long[] threadIDs, LockType lockType, 
    		                       String firstThdName, String secondThdName) {
		if (threadIDs != null) {
			ThreadInfo[] deadlockedThds = threadBean.getThreadInfo(threadIDs, true, true);
			if (deadlockedThds.length != 2) {				
				Assert.fail("Unexpected " + lockType + " Deadlocked Threads Detected (expected 2, detected " + deadlockedThds.length);
			}
			
			for(ThreadInfo thd: deadlockedThds ) {
				String thdName = thd.getThreadName();
				
				if (!thdName.equals(firstThdName) && !thdName.equals(secondThdName)) {
					Assert.fail("Reported Deadlocked Threads are Incorrect");
				}
				
				LockInfo[] lockList = null;
				
				if (lockType == LockType.SYNCHRONIZER) {
					lockList = thd.getLockedSynchronizers();
				} else if (lockType == LockType.MONITOR) {
					lockList = thd.getLockedMonitors();						
				}
				
				if (lockList.length != 1) {
					Assert.fail("Reported Number of Locks Owned by " + thdName + " is Incorrect (expected = 1, reported = " + lockList.length + ")");
				}
				
				String className = lockList[0].getClassName();
				
				if (lockType == LockType.SYNCHRONIZER) {
					if (!className.equals("java.util.concurrent.locks.ReentrantLock$NonfairSync")) {
						Assert.fail("Lock is a " + className + " not expected ReentrantLock");					
					}
				}
				else if (lockType == LockType.MONITOR) {
					if (!className.equals("java.lang.Object")) {
						Assert.fail("Lock is a " + className + " not expected Object");					
					}
					
					int depth = ((MonitorInfo) lockList[0]).getLockedStackDepth();
					if (depth != 0) {
						Assert.fail("Monitor depth was " + depth + ". Expected depth is 0");
					}
				}
				
				LockInfo blockingLock = thd.getLockInfo();

				if (blockingLock == null) {
					Assert.fail("Expected Blocking Lock was not returned by getLockInfo() for " + thdName);
				}
				
				String lockName = thd.getLockName();
				
				if (lockName == null) {
					Assert.fail("Expected Blocking Lock was not returned by getLockName() for " + thdName);
				}

				if (!lockName.equals(blockingLock.toString())) {
					Assert.fail("Different Blocking Locks returned by getLockInfo() (lock = " + blockingLock.toString() + ") and getLockName() (lock = " + lockName + ")" );
				}
			}

			deadlockedThds = threadBean.getThreadInfo(threadIDs);

			for(ThreadInfo thd: deadlockedThds ) {
				String thdName = thd.getThreadName();
				
				LockInfo[] lockList = null;
				
				if (lockType == LockType.SYNCHRONIZER) {
					lockList = thd.getLockedSynchronizers();
				}
				else if (lockType == LockType.MONITOR) {
					lockList = thd.getLockedMonitors();					
				}
				
				if (lockList.length != 0) {
					Assert.fail("Lock information provided for " + thdName + " when LockInfo was not requested");
				}				
			}		
		}
		else {
			Assert.fail("List of DeadLocked Threads was null");
		}
    }
  
    // Turn on the optional functionality, reset thresholds etc - using the beans directly
    public void enableOptionalFunctionality()  {
        try {
            // ClassLoadingMXBean operations
            classBean.setVerbose(true);

            // MemoryMXBean operations
            memBean.setVerbose(true);

            // MemoryPoolMXBean operations
            for (MemoryPoolMXBean memPoolBean: memPoolBeans) {
                memPoolBean.resetPeakUsage();

                if (memPoolBean.isCollectionUsageThresholdSupported()) {
                    memPoolBean.setCollectionUsageThreshold(10000);
                }

                if (memPoolBean.isUsageThresholdSupported()) {
                    memPoolBean.setUsageThreshold(200000);
                }            
            }

            // ThreadMXBean operations
            threadBean.resetPeakThreadCount();

            if (threadBean.isThreadContentionMonitoringSupported()) {
                threadBean.setThreadContentionMonitoringEnabled(true);
            }

            if (threadBean.isThreadCpuTimeSupported()) {
                threadBean.setThreadCpuTimeEnabled(true);
            }
            
            // LoggingMXBean operations
            List<String> loggers = logBean.getLoggerNames();
            
            String[] levels = {"SEVERE", "WARNING", "INFO", "CONFIG", "FINE", "FINER", "FINEST"};
            int i = 0;
            
            for( String logger : loggers) {               	
                if (i > 6) {
                	i = i - 7;
                }
                
                // There's a chance the logger no longer exists
                String parent = logBean.getParentLoggerName(logger);
                if (parent != null) {
                	logBean.setLoggerLevel(logger, levels[i]);
                }
                
                i++;                
            }
            
        } catch (UnsupportedOperationException uoe) {
            Message.logOut("One of the operations you tried is not supported");
            uoe.printStackTrace();
        }
    }

    public void disableOptionalFunctionality() {
        try {
            // ClassLoadingMXBean operations
            mbs.setAttribute(srvClassName, new Attribute("Verbose", new Boolean(false)));

            // MemoryMXBean operations
            mbs.setAttribute(srvMemName, new Attribute("Verbose", new Boolean(false)));

            // MemoryPoolMXBean operations
            for (Object srvMemPoolObj: srvMemPoolNames) {
                ObjectName srvMemPoolName = (ObjectName) srvMemPoolObj;

                mbs.invoke(srvMemPoolName, "resetPeakUsage", new Object[] { }, new String[] { });

                if (((Boolean)(mbs.getAttribute(srvMemPoolName, "CollectionUsageThresholdSupported"))).booleanValue()) {
                    mbs.setAttribute(srvMemPoolName, new Attribute("CollectionUsageThreshold", new Long(0)));            }

                if (((Boolean)(mbs.getAttribute(srvMemPoolName, "UsageThresholdSupported"))).booleanValue()) {
                    mbs.setAttribute(srvMemPoolName, new Attribute("UsageThreshold", new Long(0)));
                }            
            }

            // ThreadMXBean operations
            mbs.invoke(srvThrdName, "resetPeakThreadCount", new Object[] { }, new String[] { });

            if (((Boolean)(mbs.getAttribute(srvThrdName, "ThreadContentionMonitoringSupported"))).booleanValue()) {
                mbs.setAttribute(srvThrdName, new Attribute("ThreadContentionMonitoringEnabled", new Boolean(false))); 
            }


            if (((Boolean)(mbs.getAttribute(srvThrdName, "ThreadCpuTimeSupported"))).booleanValue()) {
                mbs.setAttribute(srvThrdName, new Attribute("ThreadCpuTimeEnabled", new Boolean(false)));           
            }

            // LoggingMXBean operations
            String[] loggers = (String[]) mbs.getAttribute(srvLogName, "LoggerNames"); 
            
            String[] levels = {"FINEST", "FINER", "FINE", "CONFIG", "INFO", "WARNING", "SEVERE"};
            int i = 0;
            
            for( String logger : loggers) {               	
                if (i > 6) {
                	i = i - 7;
                }
                
                // LoggingMXBean operations
                logBean.setLoggerLevel(logger, levels[i]);
                mbs.invoke(srvLogName, "setLoggerLevel", new Object[] {logger, levels[i]}, new String[] {"java.lang.String", "java.lang.String"});
                
                i++;                
            }
       } catch (UnsupportedOperationException uoe) {
            Message.logOut("One of the operations you tried is not supported");
            uoe.printStackTrace();
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
        } catch (InvalidAttributeValueException iave) {
            Message.logOut("Problem with the value you attempted to set an attribute to");
            iave.printStackTrace();
        } catch (IOException ioe) {
            Message.logOut("A communication problem occurred when talking to the MBean server");
            ioe.printStackTrace();
        }
    }
}
