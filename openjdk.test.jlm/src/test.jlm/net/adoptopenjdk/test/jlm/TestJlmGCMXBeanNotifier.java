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
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;


/**
 * STF automation to drive a java.lang.management system test scenario for Garbage collector bean 
 * and its notification where a 'client' JVM monitors a remote 'server' JVM via the server's platform 
 * MBeans with auth and ssl security disabled. 
 * 
 * The test is divided into two parts. The first part tests methods from classes 
 * com.sun.management.GarbageCollectionNotificationInfo and com.sun.management.GCInfo.
 * The second part tests methods from com.sun.management.GarbageCollectorMXBean interface.
 */
public class TestJlmGCMXBeanNotifier implements StfPluginInterface {
	
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("JLM Remote GarbageCollectionNotification and GCMXBean tests");
		help.outputText("These tests exercise APIs from com.sun.management.GarbageCollectionNotificationInfo, com.sun.management.GCInfo and com.sun.management.GarbageCollectorMXBean");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		
		/****************
		 *  Part 1) Test com.sun.management.GarbageCollectionNotificationInfo and com.sun.management.GCInfo classes
		 *****************/
		
		// Process definition for the monitored server JVM 
		String inventoryFile = "/test.load/config/inventories/mix/mini-mix.xml";
		LoadTestProcessDefinition serverJavaInvocation = test.createLoadTestSpecification()
			.addJvmOption("-Dcom.sun.management.jmxremote.port=1234")
			.addJvmOption("-Dcom.sun.management.jmxremote.authenticate=false")
			.addJvmOption("-Dcom.sun.management.jmxremote.ssl=false")
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
			.addProjectToClasspath("test.lang")  // For mini-mix inventory
			.addProjectToClasspath("test.daa")   // For mini-mix inventory
			.addProjectToClasspath("test.util")  // For mini-mix inventory
			.addProjectToClasspath("test.math")  // For mini-mix inventory
			.setTimeLimit("30m")
			.setAbortAtFailureLimit(-1)
			.addSuite("mini-mix")
			.setSuiteInventory(inventoryFile)
			.setSuiteThreadCount(3)
		   	.setSuiteRandomSelection();
		
		// Process definition for the monitoring client JVM that connects with the server JVM 	
		DirectoryRef resultsDir = test.env().getResultsDir();
		FileRef logFile	= resultsDir.childFile("GCNotifierTest.log");
				
		JavaProcessDefinition client1JavaInvocation = test.createJavaProcessDefinition()
			.addProjectToClasspath("openjdk.test.jlm")
			.addPrereqJarToClasspath(JarId.JUNIT)
			.runClass("com.ibm.runtimes.test.remote.GarbageCollectionNotificationTest") //
			.addArg(logFile.getSpec());

		// Start the background server process 
		StfProcess server1 = test.doRunBackgroundProcess("Running GarbageCollectionNotification Test Server Process", "LT1", ECHO_OFF, 
				ExpectedOutcome.neverCompletes(), serverJavaInvocation);
		
		// Start the background client process 
		StfProcess client1 = test.doRunBackgroundProcess("Running the monitoring Client", 
				"CL1", ECHO_ON,  
				ExpectedOutcome.cleanRun().within("60m"), 
				client1JavaInvocation);
		
		// Wait for the processes to complete
		test.doMonitorProcesses("Wait for processes to complete", server1, client1);
		test.doKillProcesses("Stop LT1 process", server1);
	
		
		/****************
		 *  Part 2) Test com.sun.management.GarbageCollectorMXBean interface
		 *****************/		
		
		// Process definition for the monitoring client JVM that connects with the server			
        JavaProcessDefinition client2JavaInvocation =  test.createJavaProcessDefinition()
		    .addProjectToClasspath("openjdk.test.jlm")
			.addPrereqJarToClasspath(JarId.JUNIT)
			.runClass("com.ibm.runtimes.test.remote.GCMXBeanTest");
		
		// Start the background server process
		StfProcess server2 = test.doRunBackgroundProcess("Running GCMXBean test Server Process", "LT2", ECHO_OFF, 
				ExpectedOutcome.neverCompletes(), serverJavaInvocation);
		
		// Start the background client process
		StfProcess client2 = test.doRunBackgroundProcess("Running the Monitoring Client", 
				"CL2", ECHO_ON,
				ExpectedOutcome.cleanRun().within("60m"), 
				client2JavaInvocation);
		
		// Wait for processes to complete
		test.doMonitorProcesses("Wait for processes to complete", server2,client2);
		test.doKillProcesses("Stop LT2 process", server2);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
