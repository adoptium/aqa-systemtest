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

package net.adoptopenjdk.test.jlm.remote;

import net.adoptopenjdk.test.jlm.resources.Message;

/*
 * This class provides a unified argument handling for all the 
 * JLM remote tests.
 */
public class TestArgs {
	private static boolean fullyInitialised = false;
	protected static final String DEFAULT_USERNAME             = "user";
	protected static final String DEFAULT_PASSWORD             = "password";
	protected static final int    DEFAULT_USAGE_THRESHOLD      = 20000;
	protected static final int    DEFAULT_COLLECTION_THRESHOLD = 1000;
	protected static final String DEFAULT_HOST                 = "localhost"; 
	protected static final int    DEFAULT_PORT                 = 1234;

	private   static final int    MIN_AUTHORISATION_ARGUMENTS = 0;
	private   static final int    MAX_AUTHORISATION_ARGUMENTS = 2;

	private static boolean profiler           = true;
	private static String  problemMsg         = null;

	private static boolean useProxy             = false;
	private static String  logPathname          = null;
	private static String  csvPathname          = null;
	private static boolean useAuthorisation     = false;
	private static String  username            = DEFAULT_USERNAME;
	private static String  password            = DEFAULT_PASSWORD;
	private static int     usageThreshold      = DEFAULT_USAGE_THRESHOLD;
	private static int     collectionThreshold = DEFAULT_COLLECTION_THRESHOLD;
	private static String  host                = DEFAULT_HOST;
	private static int     port                = DEFAULT_PORT;

	private static synchronized final void setIsNotifier() {
		TestArgs.profiler = false;
	}
	
	public static final boolean isProfiler() {
		return TestArgs.profiler;
	}
	
	public static final boolean isNotifier() {
		return !TestArgs.isProfiler();
	}

	// Problem message string
	private static synchronized final void setProblemMsg(String problemMsg) {
		TestArgs.problemMsg = problemMsg;
	}
	
	public static final String getProblemMsg() {
		return TestArgs.problemMsg;
	}

	// Proxy/Server - profiler(0)
	private static synchronized final void setUseProxy(boolean useProxy) {
		TestArgs.useProxy = useProxy;
	}
	
	public static final boolean isUseProxy() {
		assert fullyInitialised;
		return TestArgs.useProxy;
	}
	
	public static final boolean useProxy() {
		return TestArgs.isUseProxy();
	}
	
	public static final boolean isUseServer() {
		return !TestArgs.isUseProxy();
	}
	
	public static final boolean useServer() {
		return TestArgs.isUseServer();
	}
	
	private static String getUseProxyArg(String[] args) {
		return args[ 0 ];
	}

	// Log file pathname - profiler(1) and notifier(0)
	private static synchronized final void setLogPathname(String logPathname) {
		TestArgs.logPathname = logPathname;
	}
	
	public static final String getLogPathname() {
		assert fullyInitialised;
		return TestArgs.logPathname;
	}
	
	private static String getLogPathnameArg(String[] args) {
		return args[ (isProfiler() ? 1 : 0) ];
	}

	// CSV file pathname - profiler(2)
	private static synchronized final void setCSVPathname(String csvPathname) {
		TestArgs.csvPathname = csvPathname;
	}
	
	public static final String getCSVPathname() {
		assert fullyInitialised;
		return TestArgs.csvPathname;
	}
	
	private static String getCVSPathnameArg(String[] args) {
		return args[ 2 ];
	}

	// auth/anon - profiler(3) and notifier(1)
	private static synchronized final void setUseAuthorisation(boolean useAuthorisation) {
		TestArgs.useAuthorisation = useAuthorisation;
	}
	
	public static final boolean isUseAuthorisation() {
		assert fullyInitialised;
		return TestArgs.useAuthorisation;
	}
	
	private static String getUseAuthorisationArg(String[] args) {
		int argIndex = (isProfiler() ? 3 : 1);
		return args[ argIndex ];
	}

	// Username (optional: if using authorization) - profiler(4) and notifier(2)
	private static synchronized final void setUsername(String username) {
		TestArgs.username = username;
	}
	
	public static final String getUsername() {
		assert fullyInitialised;
		return TestArgs.username;
	}
	
	private static String getUsernameArg(String[] args) {
		int argIndex = (isProfiler() ? 4 : 2);
		return args[ argIndex ];
	}

	// Password (optional: if using authorization) - profiler(5) and notifier(3)
	private static synchronized final void setPassword(String password) {
		TestArgs.password = password;
	}
	
	public static final String getPassword() {
		assert fullyInitialised;
		return TestArgs.password;
	}
	
	private static String getPasswordArg(String[] args) {
		int argIndex = (isProfiler() ? 5 : 3);
		return args[ argIndex ];
	}

	// Usage threshold - notifier(2/4)
	private static synchronized final void setUsageThreshold(int usageThreshold) {
		TestArgs.usageThreshold = usageThreshold;
	}
	
	public static final int getUsageThreshold() {
		assert fullyInitialised;
		return TestArgs.usageThreshold;
	}
	
	private static String getUsageThresholdArg(String[] args) {
		int argIndex = 2 +
				(isUseAuthorisation() ? MAX_AUTHORISATION_ARGUMENTS : MIN_AUTHORISATION_ARGUMENTS);
		return args[ argIndex ];
	}

	// Collection threshold - notifier(3/5)
	private static synchronized final void setCollectionThreshold(int collectionThreshold) {
		TestArgs.collectionThreshold = collectionThreshold;
	}
	
	public static final int getCollectionThreshold() {
		assert fullyInitialised;
		return TestArgs.collectionThreshold;
	}
	
	private static String getCollectionThresholdArg(String[] args) {
		int argIndex = 3 +
				(isUseAuthorisation() ? MAX_AUTHORISATION_ARGUMENTS : MIN_AUTHORISATION_ARGUMENTS);
		return args[ argIndex ];
	}

	// Host URL/IP address string (optional) - profiler(4/6) and notifier(4/6)
	private static synchronized final void setHost(String host) {
		TestArgs.host = host;
	}
	
	public static final String getHost() {
		assert fullyInitialised;
		return TestArgs.host;
	}
	
	private static String getHostArg(String[] args) {
		int argIndex = 4 +
				(isUseAuthorisation() ? MAX_AUTHORISATION_ARGUMENTS : MIN_AUTHORISATION_ARGUMENTS);
		return args[ argIndex ];
	}

	// Host port number (optional) - profiler(5/7) and notifier(5/7)
	private static synchronized final void setPort(int port) {
		TestArgs.port = port;
	}
	
	public static final int getPort() {
		assert fullyInitialised;
		return TestArgs.port;
	}
	
	private static String getPortArg(String[] args) {
		int argIndex = 5 +
				(isUseAuthorisation() ? MAX_AUTHORISATION_ARGUMENTS : MIN_AUTHORISATION_ARGUMENTS);
		return args[ argIndex ];
	}

	public static boolean parseArgsWithThresholds(String[] args) {
		setIsNotifier();
		return TestArgs.parseArgs(args);
	}

	/**
	 * This is the main processing method for this class which analyzes the
	 *   given arguments fresh from the commandline and returns the success
	 *   status of their perusal.
	 *   
	 * @param args Commandline arguments array as supplied to <code>main</code>
	 * @return <code>true</code> if the arguments were fine or <code>false</code> if any problems were found along the way.
	 */
	public static boolean parseArgs(String[] args) {
		boolean argsOkaySoFar = true;

		// Check the correct number of arguments have been passed and store them
		if ((args.length < (isProfiler() ? 4:2))
				|| (args.length > (isProfiler() ? 8:8))) {
			argsOkaySoFar = false;
			setProblemMsg("Wrong number of arguments");
		} else { // Authorization: either of the strings "auth" or "anon"
			if (getUseAuthorisationArg(args).compareToIgnoreCase("auth") == 0) {
				setUseAuthorisation(true);
			} else {
				if (getUseAuthorisationArg(args).compareToIgnoreCase("anon") == 0) {
					setUseAuthorisation(false);
				} else {
					argsOkaySoFar = false;
					setProblemMsg("Either \"auth\" or \"anon\" must be used");
				}
			}
		}
		
		if (argsOkaySoFar // Slightly more specific length check ...
				&& ((args.length < (isProfiler() ? 4:2) + (isUseAuthorisation() ? 2:0))
						|| (args.length > (isProfiler() ? 6:6) + (isUseAuthorisation() ? 2:0)))) {
			argsOkaySoFar = false;
			setProblemMsg("Wrong number of arguments");
		}
		
		if (argsOkaySoFar && isProfiler()) { 
			// Proxy or server: either of the strings "proxy" or "server"
			if (getUseProxyArg(args).compareToIgnoreCase("proxy") == 0) {
				setUseProxy(true);
			} else {
				if (getUseProxyArg(args).compareToIgnoreCase("server") == 0) {
					setUseProxy(false);
				} else {
					argsOkaySoFar = false;
					setProblemMsg("Either \"proxy\" or \"server\" must be used");
				}
			}
		}
		if (argsOkaySoFar) { 
			// Now we actually store the values we have
			setLogPathname(getLogPathnameArg(args));

			if (isProfiler()) {
				setCSVPathname(getCVSPathnameArg(args));
			}

			if (isUseAuthorisation()) {
				setUsername(getUsernameArg(args));
				setPassword(getPasswordArg(args));
			}

			if (isNotifier()) {
				if (args.length > 2 + (isUseAuthorisation() ? 2:0)) {
					// Threshold(s) are given
					String tempStr = getUsageThresholdArg(args);
					if (tempStr.matches("^[0-9]+$")) {
						// Must be an integer
						setUsageThreshold(new Integer(tempStr).intValue());
						if (args.length > 3 + (isUseAuthorisation() ? 2:0)) {
							tempStr = getCollectionThresholdArg(args);
							if (tempStr.matches("^[0-9]+$")) {	
								// Must be an integer
								setCollectionThreshold(new Integer(tempStr).intValue());
							} else {
								argsOkaySoFar = false;
								setProblemMsg("Collection Threshold (cThr) value must be an integer");
							}
						}
					} else {
						argsOkaySoFar = false;
						setProblemMsg("Usage Threshold (uThr) value must be an integer");
					}
				}
			}
		}
		
		if (argsOkaySoFar) {
			int refLength = (isUseAuthorisation() ? 7:5);
			if (args.length >= refLength) {
				setHost(getHostArg(args));
				if (args.length > refLength) {
					String tempStr = getPortArg(args);
					if (tempStr.matches("^[0-9]+$")) {	// Must be an integer
						setPort(new Integer(tempStr).intValue());
					} else {
						argsOkaySoFar = false;
						setProblemMsg("Port number (port) value must be an integer");
					}
				}
			}
			if (argsOkaySoFar) {
				fullyInitialised = true;
			}
		}

		return argsOkaySoFar;
	}

	// Simply print out (to standard error) the message for the error found.
	// Only one error is unveiled on each run.
	public static void printProblemMsg() {
		String problemMsg = getProblemMsg();
		if (problemMsg != null) {
			Message.logErr("ERROR: " + problemMsg + ".");
		}
	}

	/**
	 * Print out the commandline arguments to the console.
	 * @param <code>appName</code> Class name of the test application.
	 */
	private static void usage(String appName, boolean notifier) {
		printProblemMsg();

		Message.logErr("Usage:");

		System.err.print(" java " + appName + "");
		if (!notifier) {
			System.err.print("<\"proxy\"|\"server\">");
		}
		
		System.err.print("<logFile>");
		
		if (!notifier) {
			System.err.print("<csvFile>");
		}
		
		System.err.print("<\"auth\"|\"anon\"> " +
				"[<username> <password>]");
		
		if (notifier) {
			System.err.print("[<uThr> <cThr>");
		}
		
		System.err.print("[<host> [<port>]]");
		
		if (notifier) {
			System.err.print("]");
		}
		
		Message.logErr();
		Message.logErr("If \"auth\" is used, <username> and <password> are compulsory.");
		Message.logErr("<username> and <password> must be used together.");
		
		if (notifier) {
			System.err.print("uThr cThr");
		}
		
		Message.logErr("Default host is \"" + DEFAULT_HOST + "\".");
		Message.logErr("Default port is " + DEFAULT_PORT + ".");
		
		if (notifier) {
			Message.logErr("uThr and cThr are the usage and collections thresholds respectively.");
			Message.logErr("Default usage threshold is " + DEFAULT_USAGE_THRESHOLD + ".");
			Message.logErr("Default collection threshold is " + DEFAULT_COLLECTION_THRESHOLD + ".");
		}
	}

	public static void usageNotifier(String appName) {
		usage(appName, true);
	}

	public static void usageProfiler(String appName) {
		usage(appName, false);
	}

	public static void main(String[] args) { 
		Message.logErr("This is the runnable helper for a class to manage");
		Message.logErr("commandline arguments for the 'nearby' test applications.");
		Message.logErr("Any and all commandline arguments supplied when producing");
		Message.logErr("this message have been ignored and only helpful output is");
		Message.logErr("produced before this application terminates.");
		Message.logErr("There are two varieties of argument handling: with and");
		Message.logErr("without threshold values (see below).");
		Message.logErr();

		TestArgs.usage("<profile_app>", false);

		Message.logErr();

		TestArgs.usage("<notify_app>", true);
	}
}
