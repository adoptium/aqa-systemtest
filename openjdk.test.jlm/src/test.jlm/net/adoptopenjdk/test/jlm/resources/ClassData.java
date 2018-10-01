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
 * This java source file contains the ClassData class, used
 * to retrieve information provided by the ClassLoading and 
 * Compilation MXBeans.
 */
package net.adoptopenjdk.test.jlm.resources;

import java.io.IOException;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.UndeclaredThrowableException;
import java.rmi.ConnectException;
import java.rmi.UnmarshalException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

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

public class ClassData extends VMData {
	public ClassData(String logFile) {
		super(logFile, null, true);
	}

	public ClassData(ServerConnector profiler, String logFile) {
		super(logFile, profiler, false);
	}

	/**
	 * This method writes the data retrieved from the ClassLoading and
	 * Compilation MXBeans to the ClassData's log using the MXBeans directly or
	 * through a proxy.
	 * 
	 * @param clb
	 *            The ClassLoading MXBean used to retrieve information about
	 *            loaded classes.
	 * @param cb
	 *            The Compilation MXBean used to retrieve compilation
	 *            information.
	 * @param rb
	 *            The Runtime MXBean used to retrieve general information about
	 *            the runtime used.
	 * @param append
	 *            If the append value is true the data is appended to the log,
	 *            otherwise the log is overwritten.
	 */
	public void writeData(ClassLoadingMXBean clb, CompilationMXBean cb, RuntimeMXBean rb, boolean append)
			throws UndeclaredThrowableException {
		if ((clb == null)) {
			Assert.fail("ClassLoadingMXBean is null");
		}

		openLogFile(append);
		DecimalFormat df = new DecimalFormat("#0.00"); // Print out all times to 2 d.p.

		try {
			// Record the time and whether the verbose output is enabled
			out.println("Class Loading and Compilation Information Retrieved at "
					+ DateFormat.getDateTimeInstance().format(new Date()));
			out.println("");

			// Get stats for the class loader, check the values and write them to a file
			int load_cls_cnt = clb.getLoadedClassCount();
			long unload_cls_cnt = clb.getUnloadedClassCount();
			long total_cls_cnt = clb.getTotalLoadedClassCount();

			// Check the class counts are valid
			checkClassCounts("proxy", load_cls_cnt, unload_cls_cnt, total_cls_cnt);

			// Print the results to the log
			out.println("CLASS LOADING STATS");
			out.println("  Current Loaded Class Count:  " + load_cls_cnt);
			out.println("  Total Unloaded Class Count:  " + unload_cls_cnt);
			out.println("  Total Loaded Class Count:    " + total_cls_cnt);
			out.print("  Verbose output enabled:      ");

			if (clb.isVerbose()) {
				out.println("Yes");
			} else {
				out.println("No");
			}
			out.println("");
			out.println("");

			// If there is a compiler get the info
			Map<String, String> props = rb.getSystemProperties();
			String sys_comp = props.get("java.compiler");

			if ((sys_comp != null) && (!(sys_comp.equals("")))) {
				// Get the info for the compiler and write to file
				out.println("COMPILER INFORMATION");

				String mxbean_comp = cb.getName();

				// Check if the compiler matches the compiler specified in the system properties
				checkCompiler("proxy", sys_comp, mxbean_comp);
				out.println("  Just-in-time (JIT) compiler: " + mxbean_comp);

				if (cb.isCompilationTimeMonitoringSupported()) {
					out.println("  Total Compilation Time:      " + df.format(cb.getTotalCompilationTime() * 1e-3)
					+ " seconds"); // Convert milliseconds to seconds
				}
				out.println("");
				out.println("");
			}
			closeLogFile();
		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
		}
	}

	/**
	 * This method writes the data retrieved from the ClassLoading and
	 * Compilation MXBeans to the ClassData's log using a MBeanServerConnection.
	 * 
	 * @param mbs
	 *            The MBeanServerConnect used to connected to the MBean Server.
	 * @param clb
	 *            The ObjectName associated with the ClassLoading MXBean. It is
	 *            used to retrieve information about loaded classes.
	 * @param cb
	 *            The ObjectName associated with Compilation MXBean. It is used
	 *            to retrieve compilation information.
	 * @param rb,
	 *            The ObjectName associated with the Runtime MXBean. It is used
	 *            to retrieve general information about the runtime used.
	 * @param append
	 *            If the append value is true the data is appended to the log,
	 *            otherwise the log is overwritten.
	 */
	public void writeData(MBeanServerConnection mbs, ObjectName clb, ObjectName cb, ObjectName rb, boolean append) {	
		if ((mbs == null) || (clb == null)) {
			Assert.fail("MBeanServerConnection or ObjectName is null");
		}

		openLogFile(append);
		DecimalFormat df = new DecimalFormat("#0.00"); // Print out all times to 2 d.p.

		try {
			// Record the time and whether the verbose output is enabled
			out.println("Class Loading and Compilation Information Retrieved at "
					+ DateFormat.getDateTimeInstance().format(new Date()));
			out.println("");

			Integer load_cls_cnt = ((Integer)(mbs.getAttribute(clb, "LoadedClassCount")));
			Long unload_cls_cnt = (Long)mbs.getAttribute(clb, "UnloadedClassCount");
			Long total_cls_cnt = (Long)mbs.getAttribute(clb, "TotalLoadedClassCount");

			// Check the class counts are valid
			checkClassCounts("server connection", load_cls_cnt.intValue(), unload_cls_cnt.longValue(),
					total_cls_cnt.longValue());

			// Get stats for the class loaders and write to file
			out.println("CLASS LOADING STATS");
			out.println("  Current Loaded Class Count:  " + load_cls_cnt.toString());
			out.println("  Total Unloaded Class Count:  " + unload_cls_cnt.toString());
			out.println("  Total Loaded Class Count:    " + total_cls_cnt.toString());
			out.print("  Verbose output enabled:      ");

			if (((Boolean)(mbs.getAttribute(clb, "Verbose"))).booleanValue()) {
				out.println("Yes");
			} else {
				out.println("No");
			}
			out.println("");
			out.println("");

			// If there is a compiler get the info
			TabularData cd_props = (TabularData)mbs.getAttribute(rb, "SystemProperties");
			String[] key_array = { "java.compiler" };
			CompositeData cd = cd_props.get((Object[])key_array);
			if (cd == null) {
				out.println("** System property java.compiler information NOT available **");
				out.println();
			} else {
				String sys_comp = (String)cd.get("value");
				if ((sys_comp != null) && (!(sys_comp.equals("")))) {
					// Get the info for the compiler and write to file
					out.println("COMPILER INFORMATION");

					String mxbean_comp = (String)(mbs.getAttribute(cb, "Name"));

					// Check the compiler matches the compiler returned by the system properties
					checkCompiler("server connection", sys_comp, mxbean_comp);
					out.println("  Just-in-time (JIT) compiler: " + mxbean_comp);

					if (((Boolean)(mbs.getAttribute(cb, "CompilationTimeMonitoringSupported"))).booleanValue()) {
						long tct = ((Long)(mbs.getAttribute(cb, "TotalCompilationTime"))).longValue();
						out.println("  Total Compilation Time:      " + df.format(tct * 1e-3) + " seconds"); 
					}
					out.println("");
					out.println("");
				}
			}
			closeLogFile();
		} catch (UnsupportedOperationException uoe) {
			Message.logOut("One of the operations you tried is not supported");
			uoe.printStackTrace();
			Assert.fail("One of the operations you tried is not supported");
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
		}
	}

	/**
	 * This method checks if the number of loaded, unload and total classes are
	 * positive.
	 * 
	 * @param connect_type
	 *            Either proxy or server used to identify the current test in
	 *            the logs.
	 * @param load_cls_cnt
	 *            The number of loaded classes.
	 * @param unload_cls_cnt
	 *            The number of unloaded classes.
	 * @param total_cls_cnt
	 *            The total number of classes.
	 */
	public void checkClassCounts(String connect_type, int load_cls_cnt, long unload_cls_cnt, long total_cls_cnt) {
		// Check the load class, unloaded class and total class counts are not negative
		Assert.assertTrue("Negative value returned for LoadClassCount (" + connect_type + "test)", load_cls_cnt >= 0);
		Assert.assertTrue("Negative value returned for UnLoadClassCount (" + connect_type + "test)",
				unload_cls_cnt >= 0);
		Assert.assertTrue("Negative value returned for TotalClassCount (" + connect_type + "test)", total_cls_cnt >= 0);
	}

	/**
	 * This method checks if the compiler returned by the Compilation MXBean
	 * matches the supplied reference compiler.
	 * 
	 * @param connect_type
	 *            Either proxy or server used to identify the current test in
	 *            the logs.
	 * @param ref_compiler
	 *            The name of the compiler to use as a reference.
	 * @param mxbean_complier
	 *            The name of the compiler retrieved using the Compilation
	 *            MXBean.
	 */
	public void checkCompiler(String connect_type, String ref_compiler, String mxbean_compiler) {
		// Check the compiler matches the reference compiler
		Assert.assertTrue(
				"The Compiler Name return by System Properties (" + ref_compiler + ") and the CompilationMXBean ("
						+ mxbean_compiler + ") are not the same (" + connect_type + "test)",
						ref_compiler.equals(mxbean_compiler));
	}
}
