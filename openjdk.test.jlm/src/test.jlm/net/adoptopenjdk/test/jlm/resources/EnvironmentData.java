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
 * This java source file contains the EnvironmentData class, used to retrieve 
 * information provided by the Runtime and OperatingSystem MXBeans
 */
package net.adoptopenjdk.test.jlm.resources;

import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.logging.LoggingMXBean;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import org.junit.Assert;

import net.adoptopenjdk.test.jlm.remote.ServerConnector;

public class EnvironmentData extends VMData {

	public EnvironmentData(String logFile) {
		super(logFile, null, true);
	}

	public EnvironmentData(ServerConnector profiler, String logFile) {
		super(logFile, profiler, false);
	}

	public void writeData (RuntimeMXBean rb, OperatingSystemMXBean osb, LoggingMXBean lb, boolean append) 
			throws UndeclaredThrowableException {

		Assert.assertFalse("RuntimeMXBean == null", rb == null);
		Assert.assertFalse("OperatingSystemMXBean == null", osb == null);

		openLogFile(append);

		try {
			out.println("Information produced at " + DateFormat.getDateTimeInstance().format(new Date()));
			out.println("");
			out.println("");

			// Get OS info and write to file

			// Oracle specific OperatingSystemMXBean API tests: 
			out.println("SYSTEM INFORMATION");
			out.println("  Machine architecture:  " + osb.getArch());
			out.println("  Operating System:      " + osb.getName() + " (" + osb.getVersion() + ")");
			out.println("  Available processors:  " + osb.getAvailableProcessors());

			// Get Runtime info and write to file

			// Oracle specific RuntimeMXBean API tests: 
			out.println("VM INFORMATION");
			out.println("  VM version info:       " + rb.getVmName() + ", " + rb.getVmVendor() + ", " + rb.getVmVersion());
			out.println("  VM specification info: " + rb.getSpecName() + ", " + rb.getSpecVendor() + ", " + rb.getSpecVersion());
			out.println("  VM id:                 " + rb.getName()); 
			out.println("  Management interface:  " + rb.getManagementSpecVersion());
			out.println("");

			out.println("  VM start time:         " + DateFormat.getDateTimeInstance().format(new Date(rb.getStartTime())));
			out.println("  VM uptime:             " + rb.getUptime()/1000.00 + " seconds");
			out.println("");

			// List the java input arguments
			List<String> argsList = rb.getInputArguments();
			String args = "";

			for (String arg : argsList) {
				args = args + arg + " ";
			}

			wrapString("  Program arguments:     ", args);
			out.println("");
			out.println("");

			// List the class and library paths
			out.println("CLASS & LIBRARY PATH INFORMATION");
			wrapString("  Classpath:             ", rb.getClassPath());

			if (rb.isBootClassPathSupported()) {
				wrapString("  Boot Classpath:        ", rb.getBootClassPath()); 
			}

			wrapString("  Library path:          ", rb.getLibraryPath());
			out.println("");
			out.println("");

			// List the system properties
			Map<String,String> props = rb.getSystemProperties();
			Set<String> keyset = props.keySet();
			String[] keys = (String[]) keyset.toArray(new String[keyset.size()]);
			Arrays.sort(keys);

			out.println("SYSTEM PROPERTIES"); 
			
			for (String key : keys) {
				wrapString("  ", key + " = " + props.get(key));
			}
			
			out.println("");
			out.println("");

			// List the loggers
			List<String> loggers = lb.getLoggerNames(); 

			out.println("LOGGER INFORMATION");   
			
			for (String logger : loggers) {
				String parent = lb.getParentLoggerName(logger);
				if (parent == null) {
					out.println("  Logger:                " + logger + " (No longer exists)");             
					out.println("    Parent:              N/A");                
					out.println("    Level:               N/A");
					out.println("");
				} else {
					if (parent.equals("")) {
						parent = "root";
					} 

					String level = lb.getLoggerLevel(logger);
					
					if (level == null) {
						level = "N/A";
					} else {
						if (level.equals("")) {
							level = "PARENT LEVEL";
						}	                
						checkLoggerLevel("proxy", logger, level);
					}
					
					if (logger.equals("")) {
						logger = "root";
					}

					out.println("  Logger:                " + logger);             
					out.println("    Parent:              " + parent);                
					out.println("    Level:               " + level);
					out.println("");
				}
			}
			out.println("");
			out.println("");

			// Close the log
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

	public void writeData (MBeanServerConnection mbs, ObjectName rb, ObjectName osb, ObjectName lb, boolean append) 
			throws ConnectException, UnmarshalException {

		Assert.assertFalse("MBeanServerConnection == null", mbs == null);
		Assert.assertFalse("RuntimeMXBean == null", rb == null);
		Assert.assertFalse("OperatingSystemMXBean == null", osb == null);

		openLogFile(append);

		try {
			out.println("Information produced at " + DateFormat.getDateTimeInstance().format(new Date()));
			out.println("");
			out.println("");

			// Get OS info and write to file

			// Oracle specific OperatingSystemMXBean API tests: 
			out.println("SYSTEM INFORMATION");
			out.println("  Machine architecture:  " + mbs.getAttribute(osb, "Arch"));
			out.println("  Operating System:      " + mbs.getAttribute(osb,"Name") + " (" + mbs.getAttribute(osb, "Version") + ")");
			out.println("  Available processors:  " + mbs.getAttribute(osb, "AvailableProcessors"));
			out.println("  System load average:   " + mbs.getAttribute(osb, "SystemLoadAverage"));

			// Get Runtime info and write to file

			// Oracle specific RuntimeMXBean API tests: 
			out.println("VM INFORMATION");
			out.println("  VM version info:       " + mbs.getAttribute(rb, "VmName") + ", " + mbs.getAttribute(rb, "VmVendor") + ", " 
					+ mbs.getAttribute(rb, "VmVersion"));
			out.println("  VM specification info: " + mbs.getAttribute(rb, "SpecName") + ", " + mbs.getAttribute(rb, "SpecVendor") + ", " 
					+ mbs.getAttribute(rb, "SpecVersion"));
			out.println("  VM id:                 " + mbs.getAttribute(rb, "Name")); 
			out.println("  Management interface:  " + mbs.getAttribute(rb, "ManagementSpecVersion"));
			out.println("");

			long startTime = ((Long)(mbs.getAttribute(rb, "StartTime"))).longValue();
			out.println("  VM start time:         " + DateFormat.getDateTimeInstance().format(new Date(startTime)));

			long uptime = ((Long)(mbs.getAttribute(rb, "Uptime"))).longValue();
			out.println("  VM uptime:             " + uptime/1000.00 + " seconds");
			out.println("");

			// List the java input arguments 
			String[] argsList = (String[])(mbs.getAttribute(rb, "InputArguments"));
			String args = "";

			for (String arg : argsList) {
				args = args + arg + " ";
			}

			wrapString("  Program arguments:     ", args);
			out.println("");
			out.println("");

			// List the class and library paths
			out.println("CLASS & LIBRARY PATH INFORMATION");
			wrapString("  Classpath:             ", (String) mbs.getAttribute(rb, "ClassPath"));

			if (((Boolean)(mbs.getAttribute(rb, "BootClassPathSupported"))).booleanValue()) {
				wrapString("  Boot Classpath:        ",(String) mbs.getAttribute(rb, "BootClassPath")); 
			}

			wrapString("  Library path:          ", (String) mbs.getAttribute(rb,"LibraryPath"));
			out.println("");
			out.println("");

			// List the system properties
			TabularData cd_props = (TabularData) mbs.getAttribute(rb, "SystemProperties");

			Set<?> propset = cd_props.keySet();
			Hashtable <Object, Object> props = new Hashtable <Object, Object>();

			for (Object prop : propset) {
				CompositeData cd = cd_props.get(((List<?>) prop).toArray());
				props.put(cd.get("key"), cd.get("value"));
			} 

			Set <Object> keyset = props.keySet();
			String[] keys = (String[]) keyset.toArray(new String[keyset.size()]);

			Arrays.sort(keys);

			out.println("SYSTEM PROPERTIES");            
			for (String key : keys) {
				wrapString("  ", key + " = " + props.get(key));
			}

			out.println("");  
			out.println("");     

			// List the loggers
			String[] loggers = (String[]) mbs.getAttribute(lb, "LoggerNames"); 
			out.println("LOGGER INFORMATION");            
			for (String logger : loggers) {
				String parent = (String) (mbs.invoke(lb, "getParentLoggerName", 
						new Object[] {logger}, new String[] {"java.lang.String"}));
				if (parent == null) {
					out.println("  Logger:                " + logger + " (No longer exists)");             
					out.println("    Parent:              N/A");                
					out.println("    Level:               N/A");
					out.println("");
				} else {            	
					if (parent.equals("")) {
						parent = "root";
					}

					String level = (String) (mbs.invoke(lb, "getLoggerLevel", new Object[] {logger}, new String[] {"java.lang.String"}));
					if (level == null) {
						level = "N/A";
					} else {
						if (level.equals("")) {
							level = "PARENT LEVEL";
						}    
						checkLoggerLevel("server connection", logger, level);
					}
					
					if (logger.equals("")) {
						logger = "root";
					}

					out.println("  Logger:                " + logger);
					out.println("    Parent:              " + parent);
					out.println("    Level:               " + level);
					out.println("");
				}
			}
			out.println("");
			out.println("");

			// Close the log
			closeLogFile();

		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
		} catch (ConnectException ce) {
			Assert.fail("ConnectException: \n" + ce.getMessage());
		} catch (UnmarshalException ue) {
			Assert.fail("UnmarshalException: \n" + ue.getMessage());
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

	public void checkLoggerLevel(String connect_type, String logger, String level) {
		// Check the logger level has a valid value 
		if(!((level.equals("PARENT LEVEL")) || (level.equals("SEVERE")) || (level.equals("WARNING")) || (level.equals("INFO")) || 
				(level.equals("CONFIG")) || (level.equals("FINE")) || 
				(level.equals("FINER")) ||(level.equals("FINEST")))) {
			Assert.fail("Invalid Value return for " + logger + "'s Logger Level(" + connect_type + "test)");
		}
	}
}
