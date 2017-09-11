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

package net.adoptopenjdk.stf;

import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

public class LambdaLoadTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("LambdaLoadTest runs unit tests for Lambda and Streams");
		help.outputText("");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String inventoryFile = "/openjdk.test.load/config/inventories/lambdasAndStreams/lambda.xml";
		int cpuCount = Runtime.getRuntime().availableProcessors();

		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.lambdasAndStreams")
				.addSuite("lambda")				  			// Start args for the first suite
				.setSuiteThreadCount(cpuCount - 2, 2)		// Leave 1 cpu for the JIT, 1 cpu for GC and set min 2
				.setSuiteInventory(inventoryFile) 			// Point at the file which lists the tests
				.setSuiteNumTests(200)         				// Run this many tests
				.setSuiteRandomSelection();		  			// Randomly pick the next test each time
		
		test.doRunForegroundProcess("Run lambda and stream load test", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("30m"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}