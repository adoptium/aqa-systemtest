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
import net.adoptopenjdk.stf.codeGeneration.Stage;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.JavaVersion;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

public class MauveMultiThrdLoad extends TimeBasedLoadTest {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("MauveMultiThrdLoad");
		help.outputText("The MauveMultiThrdLoad runs a subset of tests from the GNU mauve project. "
				+ "All tests are thread safe.");
	}

	public void execute(StfCoreExtension test) throws StfException {

		FileRef mauveJar = test.env().findPrereqFile("mauve/mauve.jar");

		if (!mauveJar.asJavaFile().exists()) {
			throw new StfException("Application jar file does not exist: " + mauveJar.getSpec());
		}
		
		JavaVersion jvm = test.env().primaryJvm();

		String inventoryFile = "/openjdk.test.load/config/inventories/mauve/mauve_multiThread.xml";
		
		int numMauveTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();

		/*
		 * Three Mauve tests require these add-opens options to run because modularity Java (9+) 
		 * denies them the JCL module/package access they need to run to completion.
		 */
		String[] modularityOptions = null;
		if (jvm.getJavaVersion() >= 9) { 
			modularityOptions = new String[] {
				"--add-opens=java.base/java.util=ALL-UNNAMED",
				"--add-opens=java.base/java.lang=ALL-UNNAMED",
				"--add-opens=java.base/java.io=ALL-UNNAMED"
			}; 
		}
		
		int multiplier = 1000; 
		
		// If special JIT modes are used, the test runs much slower, so we need to use a reduced amount of load
		if (test.isJavaArgPresent(Stage.EXECUTE, "-Xjit:count=0") || 
				test.isJavaArgPresent(Stage.EXECUTE, "-Xjit:count=0,optlevel=warm,gcOnResolve,rtResolve") ||
				test.isJavaArgPresent(Stage.EXECUTE, "-Xjit:enableOSR,enableOSROnGuardFailure,count=1,disableAsyncCompilation")) {
				multiplier = 250;
		}

		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addJvmOption(modularityOptions)
				.addJarToClasspath(mauveJar); 
		
		if (isTimeBasedLoadTest) { 
			loadTestInvocation = loadTestInvocation.setTimeLimit(timeLimit);	// If it's a time based test, stop execution after given time duration
		}
		
		loadTestInvocation = loadTestInvocation.addSuite("mauve")
				.setSuiteInventory(inventoryFile)
				.setSuiteThreadCount(cpuCount - 1, 3); // Leave 1 cpu for the JIT and one for GC, but min 2
		
		if (!isTimeBasedLoadTest) { 
			loadTestInvocation = loadTestInvocation.setSuiteNumTests(numMauveTests * multiplier);
		}
		
		loadTestInvocation = loadTestInvocation.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run Mauve load test", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within(finalTimeout), 
				loadTestInvocation);
	}
}
