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

package net.adoptopenjdk.stf;

import net.adoptopenjdk.loadTest.InventoryData;
import net.adoptopenjdk.loadTest.TimeBasedLoadTest;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * This is a test plugin for Java.lang related tests, it runs a workload of 
 * invoke tests and project coin tests.
 */
public class LangLoadTest extends TimeBasedLoadTest {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("LangLoadTest runs a workload of Java.lang related tests.");
		help.outputText("");
	}

	public void execute(StfCoreExtension test) throws StfException {
		String inventoryFile = "/openjdk.test.load/config/inventories/lang/lang.xml";
		int numlangTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();
		
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.lang"); 
		
		if (isTimeBasedLoadTest) { 
			loadTestInvocation = loadTestInvocation.setTimeLimit(timeLimit);	// If it's a time based test, stop execution after given time duration
		}
		
		loadTestInvocation = loadTestInvocation.addSuite("lang")
				.setSuiteThreadCount(cpuCount - 1, 2);
		
		if (!isTimeBasedLoadTest) { 
			loadTestInvocation = loadTestInvocation.setSuiteNumTests(numlangTests * 100);
		}
		
		loadTestInvocation = loadTestInvocation.setSuiteInventory(inventoryFile)
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run lang load test", "LLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within(finalTimeout), 
				loadTestInvocation);
	}
}
