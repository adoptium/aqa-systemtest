/*******************************************************************************
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.stf.hcrAgent;

import net.adoptopenjdk.loadTest.InventoryData;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.StfConstants;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.extensions.interfaces.StfExtension;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.JavaVersion;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

public class HCRLateAttachWorkload implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("HCRMiniMixLoadTest");
		help.outputText("The HCRMiniMixLoadTest runs a mixture of different unit tests repeatedly. "
				+ "Shortly after that process starts, we launch another one to late-attach a java "
				+ "agent to the first process. This agent makes rapid, repeated changes to the "
				+ "java.lang.String class in the form of new method calls added into existing "
				+ "methods. These changes should not cause any change in behaviour, barring defects.");
	}

	public void pluginInit(StfCoreExtension stf) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {		
		//On zos, we need to enable the attach api manually. 
		//Option is IBM-specific, but currently only IBM Java runs on z/OS.
		//When we get a non-IBM Java running on z/OS, we may need to find an equivalent option.
		String zosOnlyOption = "";
		if (test.env().getPlatform().startsWith("zos") && test.env().primaryJvm().isIBMJvm()) {
			zosOnlyOption = "-Dcom.ibm.tools.attach.enable=yes";
		}
		
		// Specify the Process definition for the workload processes.
		FileRef asmJar = test.env().findPrereqFile("/asm-7.3/asm-7.3.jar");
		// Temporarily switched from using mini-mix to avoid test failures not related to HCR.
		//String inventoryFile = "/openjdk.test.load/config/inventories/mix/mini-mix.xml";
		String inventoryFile = "/openjdk.test.load/config/inventories/util/util.xml";
		LoadTestProcessDefinition loadTestSpecification = test.createLoadTestSpecification()
				.addJvmOption(zosOnlyOption)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addJarToClasspath(asmJar)
				.addProjectToClasspath("openjdk.test.lang")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.util")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.math")  // For mini-mix inventory
				.setTimeLimit("5m")
				.addSuite("mini-mix")
				.setSuiteInventory(inventoryFile)
				.setSuiteThreadCount(3)
				.setSuiteSequentialSelection();

		//Step 1: Run the background test.
		StfProcess miniMixProcess = test.doRunBackgroundProcess("Run MiniMix load test", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("10m"), 
				loadTestSpecification);
		
		
		//Step 2: Attach the agent.
		
		FileRef agentJar = test.env().findTestDirectory("openjdk.test.debugging/bin").childFile("StringModifierAgent.jar");
		FileRef toolsJar = test.env().getJavaHome().childFile("/lib/tools.jar");
		
		//Allows the user to send options to the agent exclusively. See the agent README file for details.
		String agentOptions = "";
		if (System.getenv("net.adoptopenjdk.test.hcrAgent.agent.StringModifierAgent.options") == null) {
			agentOptions = "duration=240";
		}
		
		JavaProcessDefinition testProcess2 = test.createJavaProcessDefinition() 
				.addJarToClasspath(agentJar)
				.addJarToClasspath(toolsJar)
				.runClass("net.adoptopenjdk.test.hcrAgent.agent.Attacher")
				.addPerlProcessData(miniMixProcess,StfConstants.PERL_PROCESS_PID)
				.addArg(agentJar.toString())
				.addArg(agentOptions);
		
		StfProcess agentProcess = test.doRunBackgroundProcess("Run StringModifierAgent", "AG", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("10m"), 
				testProcess2);

		test.doMonitorProcesses("Wait for Agent to complete, followed by the MiniMix test seconds later.",miniMixProcess,agentProcess);
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
}
