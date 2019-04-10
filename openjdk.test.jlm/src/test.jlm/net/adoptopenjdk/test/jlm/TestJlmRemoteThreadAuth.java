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

package net.adoptopenjdk.test.jlm;

import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_OFF;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.environment.DirectoryRef;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.test.jlm.remote.ThreadProfiler;

/**
 * STF automation to drive a java.lang.management system test scenario for thread 
 * related beans where a 'client' JVM monitors a remote 'server' JVM via the server's 
 * platform MBeans with both password file based security and ssl based security enabled. 
 * 
 * The test is divided into two parts. The first part drives the remote thread  
 * test configuration for secure proxy connections. The second part drives the 
 * test configuration for secure server connections.   
 */
public class TestJlmRemoteThreadAuth implements StfPluginInterface {
	
	FileRef keyStoreFile;
	FileRef passwordFile;
	
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("JLM Remote thread test with security");
		help.outputText("These tests exercise java.lang.management APIs with (for thread related beans) "
				+ "MBeans for a remote JVM using secure proxy and server connections");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
		keyStoreFile = test.locateResourceFile("testkeys");
		passwordFile = test.doCp("Copying password file to temp", 
				test.locateResourceFile("jmxremote.password"), test.env().getTmpDir());
		
		// We need to set file permission of jmxremote.password to 600 as this is 
		// required by the password file based JMX remote monitoring mechanism.  
		// Since the password file contains passwords in clear text, for security reasons, 
		// the JMX implementation checks that the file is only readable by the owner and exits 
		// with an error if it is not. 
		test.doChmod("Restricting file permission of jmxremote.passsword to 600", passwordFile, "600");
	}

	public void execute(StfCoreExtension test) throws StfException {
		
		/****************
		 *  Part 1) Drive the test configuration for secure proxy connection 
		 *****************/
		
		// Process definition for the monitored server JVM
		String inventoryFile = "/openjdk.test.load/config/inventories/mix/mini-mix.xml";
		
		LoadTestProcessDefinition serverLoadTestInvocation = test.createLoadTestSpecification()
				.addJvmOption("-Xmx256m")
				.addJvmOption("-Dcom.sun.management.jmxremote.port=1234")
				.addJvmOption("-Dcom.sun.management.jmxremote.ssl.need.client.auth=true")
				.addJvmOption("-Djavax.net.ssl.keyStore=" + keyStoreFile.getSpec())
				.addJvmOption("-Djavax.net.ssl.trustStore=" + keyStoreFile.getSpec())
				.addJvmOption("-Djavax.net.ssl.keyStoreType=JKS")
				.addJvmOption("-Djavax.net.ssl.trustStoreType=JKS")
				.addJvmOption("-Djavax.net.ssl.keyStorePassword=passphrase")
				.addJvmOption("-Djavax.net.ssl.trustStorePassword=passphrase")
				.addJvmOption("-Dcom.sun.management.jmxremote.password.file=" + passwordFile.getSpec())
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.lang")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.util")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.math")  // For mini-mix inventory
				.setTimeLimit("30m")
				.setAbortAtFailureLimit(-1)
				.addSuite("mini-mix")
				.setSuiteNumTests(900000)
				.setSuiteInventory(inventoryFile)
				.setSuiteThreadCount(30)
			   	.setSuiteRandomSelection();
		
		// Process definition for the client JVM that will monitor the server using proxy connection
		DirectoryRef resultsDir = test.env().getResultsDir();
		FileRef logFile	= resultsDir.childFile("sthd_proxy.log");
		FileRef statsFile = resultsDir.childFile("sthd_proxy.csv");
		FileRef dumpFile = resultsDir.childFile("javacore_sthd_proxy.%Y%m%d.%H%M%S.%pid.%seq.txt,filter=java.lang.IllegalArgumentException");
		
		JavaProcessDefinition clientJavaInvocationProxy =  test.createJavaProcessDefinition()
			.addJvmOption("-Xmx256m")
			.addJvmOptionIfIBMJava("-Xdump:java:events=throw,file=" + dumpFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.keyStore=" + keyStoreFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.trustStore=" + keyStoreFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.keyStoreType=JKS")
			.addJvmOption("-Djavax.net.ssl.trustStoreType=JKS")
			.addJvmOption("-Djavax.net.ssl.keyStorePassword=passphrase")
			.addJvmOption("-Djavax.net.ssl.trustStorePassword=passphrase")
			.addJvmOption("-Dcom.sun.management.jmxremote.password.file=" + passwordFile.getSpec())
			.addProjectToClasspath("openjdk.test.jlm")
			.addPrereqJarToClasspath(JarId.JUNIT)
			.runClass(ThreadProfiler.class)
			.addArg("proxy")
			.addArg(logFile.getSpec())
			.addArg(statsFile.getSpec())
			.addArg("auth")
			.addArg("controlRole")
			.addArg("control1")
			.addArg("localhost")
			.addArg("1234");
		
		// Start the background server process
		StfProcess serverProxy = test.doRunBackgroundProcess("Running ThreadProfiler Proxy "
				+ "test Server Process(with security)", "LT1", ECHO_OFF, 
				ExpectedOutcome.neverCompletes(), serverLoadTestInvocation);
		
		// Start the background client process
		StfProcess clientProxy = test.doRunBackgroundProcess("Running Monitoring "
				+ "Client with proxy connection(with security)", 
				"CL1", ECHO_ON,  
				ExpectedOutcome.cleanRun().within("30m"), 
				clientJavaInvocationProxy);
		
		// Wait for the processes to complete
		test.doMonitorProcesses("Wait for the processes to complete", serverProxy, clientProxy);
		test.doKillProcesses("Stop LT1 process", serverProxy);
		
		/****************
		 *  Part 2) Drive the test configuration for secure server connection 
		 *****************/
		
		// Process definition for the client JVM that connects with the server via server-connection
		logFile	= resultsDir.childFile("sthd_server.log");
		statsFile = resultsDir.childFile("sthd_server.csv");
		dumpFile = resultsDir.childFile("javacore_sthd_server.%Y%m%d.%H%M%S.%pid.%seq.txt,filter=java.lang.IllegalArgumentException");
		JavaProcessDefinition clientJavaInvocationS = test.createJavaProcessDefinition()
			.addJvmOption("-Xmx256m")
			.addJvmOptionIfIBMJava("-Xdump:java:events=throw,file=" + dumpFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.keyStore=" + keyStoreFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.trustStore=" + keyStoreFile.getSpec())
			.addJvmOption("-Djavax.net.ssl.keyStoreType=JKS")
			.addJvmOption("-Djavax.net.ssl.trustStoreType=JKS")
			.addJvmOption("-Djavax.net.ssl.keyStorePassword=passphrase")
			.addJvmOption("-Djavax.net.ssl.trustStorePassword=passphrase")
			.addJvmOption("-Dcom.sun.management.jmxremote.password.file=" + passwordFile.getSpec())
			.addProjectToClasspath("openjdk.test.jlm")
			.addPrereqJarToClasspath(JarId.JUNIT)
			.runClass(ThreadProfiler.class)
			.addArg("server")
			.addArg(logFile.getSpec())
			.addArg(statsFile.getSpec())
			.addArg("auth")
			.addArg("controlRole")
			.addArg("control1")
			.addArg("localhost")
			.addArg("1234");

		// Start the server process
		StfProcess serverS= test.doRunBackgroundProcess("Running ThreadProfiler Server test Server Process(with security)", "LT2", ECHO_OFF, 
				ExpectedOutcome.neverCompletes(), serverLoadTestInvocation);
		
		// Start the background client process
		StfProcess clientS = test.doRunBackgroundProcess("Run the Monitoring Client with server-connection(with security)", 
				"CL2", ECHO_ON,  
				ExpectedOutcome.cleanRun().within("30m"), 
				clientJavaInvocationS);
		
		// Wait for background processes to complete
		test.doMonitorProcesses("Wait for processes to complete", serverS, clientS);
		test.doKillProcesses("Stop LT2 process", serverS);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
