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

import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

import java.util.*;

public class ParallelStreamsLoadTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("ParallelStreamsLoadTest runs junit tests for parallel stream operations");
		help.outputText("");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String inventoryFile = "/openjdk.test.load/config/inventories/lambdasAndStreams/parallelStreams.xml";

		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addJvmOption("-Xmx1024M")                  // Workload test TestParallelStreamOperations requires at least 800Mb heap on openj9 non-compressed refs
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.lambdasAndStreams")
				.setInactivityLimit("60m")                  // The test may take a long time to run with -Xint and appear to be hung to the load test harness. 
				.addSuite("parallelStreams")                // Start args for the first suite
				.setSuiteThreadCount(2)		                // The TestParallelStreamOperations test is self limiting to two instances running concurrently
				.setSuiteInventory(inventoryFile)           // Point at the file which lists the tests
				.setSuiteNumTests(2)                        // Run the TestParallelStreamOperations test once on each of the two threads
				.setSuiteSequentialSelection();

		test.doRunForegroundProcess("Run parallel streams load test", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("60m"),
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
