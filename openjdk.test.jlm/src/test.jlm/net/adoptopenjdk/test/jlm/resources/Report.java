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

package  net.adoptopenjdk.test.jlm.resources;

/*
 * This Class is used to output information for reporting for the JLM tests.
 */

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class Report {
	private static final String SUCCESS     = "SUCCESS";
	private static final String INFORMATION = "INFORMATION";
	private static final String FAILURE     = "FAILURE";

	private static boolean reportingStreamsInitialized = false;
	private static boolean localStoreInitialized       = false;

	// Default output streams
	private static Object defaultStdOut = null;
	private static Object defaultStdErr = null;

	private static ConcurrentHashMap<String, Vector<String>> accumulatedMsgLists = null;

	private static boolean lastOutputNewline = true;

	/**
	 * Initialize the output streams for the report.
	 * @param stdOut Output stream to use for "standard" output.
	 * @param stdErr Output stream to use for "standard error" output.
	 */
	public static void initReport(Object stdOut, Object stdErr) {
		Report.initReportingStreams(stdOut, stdErr);
		Report.initLocalStore();
	}

	/**
	 * Initialize the output streams for the report using standard [console]
	 *   error output as the error stream.
	 *   
	 * @param stdOut Output stream to use for "standard" output.
	 */
	public static void initReport(Object stdOut) {
		Report.initReportingStreams(stdOut, null);
		Report.initLocalStore();
	}

	/**
	 * Initialize the output streams for the report using standard [console]
	 *   output for non-error stream and standard [console] error output as the
	 *   error stream.
	 */
	public static void initReport() {
		Report.initReportingStreams(null, null);
		Report.initLocalStore();
	}

	/**
	 * Set the local stream field values according to apparent requirements.
	 * 
	 * @param stdOut Output stream to use for "standard" output.
	 * @param stdErr Output stream to use for "standard error" output.
	 */
	private static void initReportingStreams(Object stdOut, Object stdErr) {
		// Ensure only one initialization .
		if (!Report.reportingStreamsInitialized) {
			if (stdOut == null) {
				Report.defaultStdOut = System.out;
			} else {
				Report.defaultStdOut = stdOut;
			}
			
			if (stdErr == null) {
				Report.defaultStdErr = System.err;
			} else {
				Report.defaultStdErr = stdErr;
			}
			Report.reportingStreamsInitialized = true;
		}
	}

	/**
	 * Set the local store field with default values.
	 */
	private static void initLocalStore() {
		if (!Report.localStoreInitialized) {
			Report.localStoreInitialized = true;
			Report.accumulatedMsgLists = new ConcurrentHashMap<String, Vector<String>>();
			Report.accumulatedMsgLists.put(Report.SUCCESS,     new Vector<String>());
			Report.accumulatedMsgLists.put(Report.INFORMATION, new Vector<String>());
			Report.accumulatedMsgLists.put(Report.FAILURE,     new Vector<String>());
		}
	}

	/**
	 * Flush output stream.
	 * 
	 * @param <code>out</code> Output stream to flush.
	 */
	private static void flush(Object out) {
		if (out instanceof PrintStream) {
			((PrintStream)out).flush();
		} else {
			if (out instanceof PrintWriter) {
				((PrintWriter)out).flush();
			}
		}
		Report.lastOutputNewline = true;
	}

	/**
	 * Flush both output streams.
	 */
	public static void flushAll() {
		Report.flush(Report.defaultStdOut);
		Report.flush(Report.defaultStdErr);
	}

	/**
	 * Un-set the local field values once a report has been completed.
	 */
	private static void resetReportingStreams() { 
		// Only do one initialization , then we're "locked in"
		if (reportingStreamsInitialized) {
			Report.flushAll();
			Report.defaultStdOut = null;
			Report.defaultStdErr = null;
			Report.reportingStreamsInitialized = false;
		}
		Report.localStoreInitialized = false;
	}

	/**
	 * Trigger the termination of reporting.  May be re-started.
	 */
	public static void endReport() {
		Report.resetReportingStreams();
		Report.indentation = 0;
	}

	/**
	 * Unify the indentation for ease of visual perusal of output.
	 */
	private static int indentation = 0;
	
	protected static void incrementIndentation() {
		Report.indentation++;
	}
	
	/**
	 * Unify the indentation for ease of visual perusal of output.
	 */
	protected static void decrementIndentation() {
		assert Report.indentation > 0;
		if (Report.indentation > 0) {
			Report.indentation--;
		}
	}
	
	/**
	 * Retrieve the current indentation.
	 */
	public static String getIndent() {
		String str = new String();
		for (int i = 0; i < Report.indentation; ++i) {
			str += "    ";
		}
		return str;
	}

	/**
	 * Write the indentation  to stdout .
	 */
	protected static void writeIndent() {
		Report.printIndent(Report.getIndent());
	}

	/**
	 * Write the indentation  to stderr .
	 */
	protected static void writeIndentErr() {
		Report.printErr(Report.getIndent());
	}

	/**
	 * Outputs the summary, i.e. the accumulated list of failure strings and clears them.
	 */
	public static void failureSummary() {
		Vector<String> accumulatedFailureMsgList = Report.accumulatedMsgLists.get(FAILURE);
		if (!accumulatedFailureMsgList.isEmpty()) {
			Report.println();
			Report.printlnIndent("********  ACCUMULATED LIST OF FAILURES  ********");
			Report.incrementIndentation();
			for (Iterator<String> failureMsgIterator = accumulatedFailureMsgList.iterator(); 
					failureMsgIterator.hasNext();) {
				Report.printlnIndent((String)failureMsgIterator.next());
			}
			
			Report.decrementIndentation();
			Report.printlnIndent("********************************* END OF LIST **");
			Report.accumulatedMsgLists.replace(FAILURE, new Vector<String>());
		} else {
			Report.printlnIndent("************  NO FAILURES RECORDED  ************");
		}
	}

	/**
	 * Flag to indicate whether reporting has been Initialized and is ready to use.
	 * 
	 * @return Whether or not reporting has been Initialized and is ready to use.
	 */
	public static boolean isInitialized() {
		return Report.reportingStreamsInitialized;
	}

	/**
	 * Output a string to the appropriate stream without an end-of-line.
	 * 
	 * @param str String to output.
	 */
	public static void print(String str) {
		if (Report.defaultStdOut instanceof PrintStream) {
			((PrintStream)Report.defaultStdOut).print(str);
		} else {
			if (Report.defaultStdOut instanceof PrintWriter) {
				((PrintWriter)Report.defaultStdOut).print(str);
			}
		}
		Report.lastOutputNewline = false;
	}

	/**
	 * Output a string to the appropriate stream with indentation 
	 * but without an end-of-line. Skips indentation if the last output 
	 * was NOT terminated in a newline.
	 * 
	 * @param str String to output.
	 */
	public static void printIndent(String str) {
		if (Report.lastOutputNewline) {
			Report.print(Report.getIndent());
		}
		Report.print(str);
	}

	/**
	 * Output an end-of-line to the appropriate stream.
	 */
	public static void println() {
		if (Report.defaultStdOut instanceof PrintStream) {
			((PrintStream)Report.defaultStdOut).println();
		} else {
			if (Report.defaultStdOut instanceof PrintWriter) {
				((PrintWriter)Report.defaultStdOut).println();
			}
		}
		Report.lastOutputNewline = true;
	}

	/**
	 * Output a string to the appropriate stream with indentation and an end-of-line.
	 * 
	 * @param str String to output.
	 */
	public static void printlnIndent(String str) {
		Report.printIndent(str);
		Report.println();
	}

	/**
	 * Output a string to the appropriate stream with an end-of-line.
	 * 
	 * @param str String to output.
	 */
	public static void println(String str) {
		Report.print(str);
		Report.println();
	}

	/**
	 * Output a string to the appropriate error stream without an end-of-line.
	 * 
	 * @param str String to output.
	 */
	public static void printErr(String str) {
		if (Report.defaultStdErr instanceof PrintStream) {
			((PrintStream)Report.defaultStdErr).print(str);
		} else {
			if (Report.defaultStdErr instanceof PrintWriter) {
				((PrintWriter)Report.defaultStdErr).print(str);
			}
		}
	}

	/**
	 * Output an end-of-line to the appropriate error stream.
	 */
	public static void printlnErr() {
		if (Report.defaultStdErr instanceof PrintStream) {
			((PrintStream)Report.defaultStdErr).println();
		} else {
			if (Report.defaultStdErr instanceof PrintWriter) {
				((PrintWriter)Report.defaultStdErr).println();
			}
		}
	}

	/**
	 * Output a string to the appropriate stream with an end-of-line.
	 * @param str String to output.
	 */
	public static void printlnErr(String str) {
		Report.printErr(str);
		Report.printlnErr();
	}

	/**
	 * Output a standardized "eye-catcher" message to the appropriate stream.
	 * @param msgType Type of message (e.g. FAILURE).
	 * @param msg Message to use.
	 */
	private static void printlnEyecatcherMsg(String msgType, String msg) {
		if (accumulatedMsgLists == null) {
			Report.initLocalStore();
		}
		
		Report.accumulatedMsgLists.get(msgType).add(msg);
		
		if (!lastOutputNewline) {
			Report.println();
		}
		
		incrementIndentation();
		Report.printlnIndent("**** " + msgType + " **** " + msg + " **");
		decrementIndentation();
	}

	/**
	 * Output a standardized "eye-catcher" failure message to the appropriate output stream.
	 * @param failureMsg Failure message to use.
	 */
	public static void printlnFailureMsg(String failureMsg) {
		Report.printlnEyecatcherMsg(FAILURE, failureMsg);
	}

	/**
	 * Output a standardized "eye-catcher" information message to the appropriate output stream.
	 * @param infoMsg Information message to use.
	 */
	public static void printlnInformationMsg(String infoMsg) {
		Report.printlnEyecatcherMsg(INFORMATION, infoMsg);
	}

	/**
	 * Output a standardized "eye-catcher" success message to the appropriate output stream.
	 * @param successMsg Success message to use.
	 */
	public static void printlnSuccessMsg(String successMsg) {
		Report.printlnEyecatcherMsg(SUCCESS, successMsg);
	}

	/**
	 * Output a standardized (normal) report message explaining that an returned array is either null or zero (or worse, negative) size.
	 * @param <T> Type of the array.
	 * @param name Name of the method associated with this array.  Typically, this will be the array which has returned it.
	 * @param array The object of investigation/curiosity.
	 */
	public static <T> void printlnEmptyReturnMsg(String name, T[] array) {
		if ((array == null) || (array.length <= 0)) {
			Report.printlnIndent(name +
					" returned " +
					((array == null) ?
							"null" :
								"an array of size " + array.length));
		}
	}

	/**
	 * Output a standardized (normal) stack trace.
	 * @param <E> Type of the exception.
	 */
	public static <E extends Exception> void printStackTrace(E e) {
		if (Report.defaultStdErr instanceof PrintStream) {
			e.printStackTrace((PrintStream)Report.defaultStdErr);
		} else {
			if (Report.defaultStdErr instanceof PrintWriter) {
				e.printStackTrace((PrintWriter)Report.defaultStdErr);
			}
		}
	}
}
