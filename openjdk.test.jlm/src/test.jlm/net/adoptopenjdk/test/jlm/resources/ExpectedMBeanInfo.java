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
 * This java source file contains the ExpectedMBeanInfo class.
 * It is used to compare dynamically collected information from
 * MBeanInfo to an expected set of information gathered
 * from a reference implementation as described in
 * <code>referenceJavaRevision</code>.
 */
package net.adoptopenjdk.test.jlm.resources;

import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.adoptopenjdk.test.jlm.resources.Message;

import java.util.Arrays;

public final class ExpectedMBeanInfo {
	{ // Static class initialization
		initExpectedMBean();
	}

	/**
	 * The "reference" documentation revision string is in the following format:<br/>
	 *   &nbsp;&nbsp;<code>&lt;imp&gt;&lt;majrelno&gt;.&lt;minrelno&gt;&lt;revcode&gt;(&lt;YYYYMMDD&gt;)</code><br/>
	 * where:<br/>
	 *   &nbsp;&nbsp;<code>imp</code> is the implementor (typically <code>Sun</code>)<br/>
	 *   &nbsp;&nbsp;<code>majrel</code> is the major release number (eg 6)<br/>
	 *   &nbsp;&nbsp;<code>minrel</code> is the minor release number (eg 0)<br/>
	 *   &nbsp;&nbsp;<code>revcode</code> is the revision code (eg <code>b2b87</code> for "Beta 2 b87")<br/>
	 *   &nbsp;&nbsp;<code>YYYYMMDD</code> is the release date for the revision (eg <code>20060609</code>)
	 */
	public static final String referenceJavaRevision = "Sun6.0b2b87(20060609)";

	// These are the categories currently identified for the MBean information items
	private static final String ATTRIBUTE    = "Attribute";
	private static final String CONSTRUCTOR  = "Constructor";
	private static final String NOTIFICATION = "Notification";
	private static final String OPERATION    = "Operation";

	// Static string for output
	private static final String UNEXPECTED_PREFIX = "UNEXPECTED:";

	// Structure to hold the more in-depth information on the MBean contents for
	//   each category
	private static final class ItemCategory {
		// Names of items
		String[] items; 
		
		// Names of items & number of times it appears in reference doc..
		// More than once indicates, at least for "operations", there are more
		// than one signature for a named [Java] method.
		ConcurrentHashMap<String, Integer> checklist;

		ItemCategory(String[] items, ConcurrentHashMap<String, Integer> checklist) {
			this.items     = items;
			this.checklist = checklist;
		}
	}

	// Structure used to hold information on all categories
	private static ConcurrentHashMap<String, ItemCategory> information = null;

	// This information should be gleaned from the API for ThreadMXBean.  However
	// there would appear to be some "missing", so these lists are taken from
	// the results through interrogating a "live" ThreadMXBean.
	private static final String[] constructors  = {};
	private static final String[] attributes    =
		{
				"AllThreadIds",
				"CurrentThreadCpuTime",
				"CurrentThreadCpuTimeSupported",
				"CurrentThreadUserTime",
				"DaemonThreadCount",
				"ObjectMonitorUsageSupported",
				"PeakThreadCount",
				"SynchronizerUsageSupported",
				"ThreadContentionMonitoringEnabled",
				"ThreadContentionMonitoringSupported",
				"ThreadCount",
				"ThreadCpuTimeEnabled",
				"ThreadCpuTimeSupported",
				"TotalStartedThreadCount"
		};
	private static final String[] notifications = {};
	private static final String[] operations    =
		{
				"dumpAllThreads",
				"findDeadlockedThreads",
				"findMonitorDeadlockedThreads",
				"getThreadCpuTime",
				"getThreadInfo",
				"getThreadInfo",
				"getThreadInfo",
				"getThreadInfo",
				"getThreadInfo",
				"getThreadUserTime",
				"resetPeakThreadCount"
		};

	// Either initialize or force re-initialization of everything.
	public static void initExpectedMBean() {
		information = new ConcurrentHashMap<String, ItemCategory>();
		information.putIfAbsent(ATTRIBUTE,
				new ItemCategory(getAttributes(),
						new ConcurrentHashMap<String, Integer>()));
		initChecklist(ATTRIBUTE);
		information.putIfAbsent(CONSTRUCTOR,
				new ItemCategory(constructors,
						new ConcurrentHashMap<String, Integer>()));
		initChecklist(CONSTRUCTOR);
		information.putIfAbsent(NOTIFICATION,
				new ItemCategory(notifications,
						new ConcurrentHashMap<String, Integer>()));
		initChecklist(NOTIFICATION);
		information.putIfAbsent(OPERATION,
				new ItemCategory(operations,
						new ConcurrentHashMap<String, Integer>()));
		initChecklist(OPERATION);
	}

	/**
	 * Load up the static data into our tracking structure.
	 *
	 * @param <code>category</code> Category of item to load.
	 */
	private static void initChecklist(String category) {
		ConcurrentHashMap<String, Integer> checklist = information.get(category).checklist;
		String[] itemList = information.get(category).items;
		Integer tempInt;
		for (String item : itemList) {
			tempInt = checklist.putIfAbsent(item, 1);
			if (tempInt != null) { // JFDI
				checklist.replace(item, tempInt + 1);
			}
		}
	}

	/**
	 * Utility method to check off items from checklist. 
	 * 
	 * @param name Name of checklist.
	 * @param item Name of item to decrement.
	 * @return The new count value of the check list item.
	 */
	public static Integer checkOffChecklistItem(String name, String item) {
		if (information == null) {  
			initExpectedMBean();   
		}

		ConcurrentHashMap<String, Integer> checklist = information.get(name).checklist;
		Integer currentValue = checklist.get(item);
		Integer nextValue = 1;
		if (currentValue == null) {  
			item = UNEXPECTED_PREFIX + item;
			currentValue = checklist.putIfAbsent(item, 1);
			if (currentValue != null) {
				nextValue = currentValue + 1;
			}
		} else {
			nextValue = currentValue - 1;
		}
		
		if (currentValue != null) {
			if (!checklist.replace(item, currentValue, nextValue)) {
				Report.printlnErr("Cannot successfully check off item " +
						item +
						" from " +
						name +
						" checklist! Checklist count is still " +
						currentValue);
			}
		}
		return nextValue;
	}

	public static String[] getAttributes() {
		String version = System.getProperty("java.version");
		if (!version.equals("1.6.0")) {
			String[] amendedAttributes = Arrays.copyOf(attributes, attributes.length + 1);
			amendedAttributes[amendedAttributes.length - 1] = "ObjectName";
			return amendedAttributes;
		} else {
			return attributes;
		}
	}
	
	public static Integer checkOffAttribute(String attribute) {
		return checkOffChecklistItem(ATTRIBUTE, attribute);
	}

	public static String[] getConstructors() {
		return constructors;
	}
	
	public static Integer checkOffConstructor(String constructor) {
		return checkOffChecklistItem(CONSTRUCTOR, constructor);
	}

	public static String[] getNotifications() {
		return notifications;
	}
	
	public static Integer checkOffNotification(String notification) {
		return checkOffChecklistItem(NOTIFICATION, notification);
	}

	public static String[] getOperations() {
		return operations;
	}
	
	public static Integer checkOffOperation(String operation) {
		return checkOffChecklistItem(OPERATION, operation);
	}

	private static boolean writeOutCategoryReport(String category) {
		Map<String, Integer> checklist = null;
		Enumeration<String> itemList = null;
		Integer remainingCount;
		boolean asExpected = true;

		checklist = information.get(category).checklist;
		itemList  = information.get(category).checklist.keys();
		Report.printIndent("Category: " + category + "s");
		if (itemList.hasMoreElements()) {
			Report.incrementIndentation();
			Report.println();
			
			// Now we deal with the unexpected encounters
			for (String item : checklist.keySet()) {
				// Only those with the marked prefix
				if (!item.startsWith(UNEXPECTED_PREFIX)) {
					remainingCount = checklist.get(item);
					if (remainingCount != 0) {
						asExpected = false;
					}
					Report.printlnIndent("  " + item + "  " + remainingCount);
				}
			}
			
			// Now we deal with the unexpected encounters
			for (String item : checklist.keySet()) {
				// Only those with the marked prefix
				if (item.startsWith(UNEXPECTED_PREFIX)) {
					asExpected = false;
					Report.printlnIndent("  " +  item + "  " + checklist.get(item));
					checklist.remove(item); // Tidy up as we go
				}
			}
			Report.decrementIndentation();
		} else {
			Report.println("    [NONE]");
		}

		if (!asExpected) {
			Report.printlnFailureMsg("Unexpected discrepency (see preceding detail) in category " + category);
		}

		return asExpected;
	}

	/** 
	 * Presents a full report on the data currently held in this class about
	 * numbers of "unchecked" and unexpected items. Typically, this would be
	 * called after parsing the contents of an MBeanInfo instance, "checking
	 * off" items on the way through. Unexpected items are prefixed with
	 * the string "UNEXPECTED:". 
	 **/
	public static void writeOutChecklistReport() {
		boolean constructorsOK  = writeOutCategoryReport(CONSTRUCTOR);
		boolean attributesOK    = writeOutCategoryReport(ATTRIBUTE);
		boolean notificationsOK = writeOutCategoryReport(NOTIFICATION);
		boolean operationsOK    = writeOutCategoryReport(OPERATION);

		if (constructorsOK && attributesOK && notificationsOK && operationsOK) {
			Report.printlnSuccessMsg("MBeanInfo as expected");
		}
	}

	/**
	 * This method is is used for writing out data. 
	 * It is only used from the commandline invocation.
	 * 
	 * @param <code>nameStr</code> Name of item category
	 * @param <code>arrayStr</code> Array of expected item name strings
	 */
	private static void writeOutData(String nameStr, String[] arrayStr) {
		Message.logOut("  " + nameStr + ":");
		if(arrayStr.length > 0) {
			for(String str : arrayStr) {
				Message.logOut("    " + str);
			}
		} else {
			Message.logOut("    [NONE]");
		}
	}

    // Application to print expected MBean information to the console as of the
	// reference release indicated by <code>referenceJavaRevision</code>
	// No commandline arguments are required, and any supplied are ignored.
	public static void main(String[] args) { 
		if(args.length > 0) {
			Message.logErr("Arguments not required - any supplied have been ignored.");
		}
		
		Message.logOut("ExpectedMBean: information based on "
				+ "reference implmentation "+referenceJavaRevision);
		writeOutData(CONSTRUCTOR,  constructors);
		writeOutData(ATTRIBUTE,    attributes  );
		writeOutData(NOTIFICATION, notifications);
		writeOutData(OPERATION,    operations  );
	}
}
