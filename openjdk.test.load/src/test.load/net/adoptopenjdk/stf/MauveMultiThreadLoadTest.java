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
import net.adoptopenjdk.stf.codeGeneration.Stage;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.JavaVersion;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

public class MauveMultiThreadLoadTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("MauveMultiThreadLoadTest");
		help.outputText("The MauveMultiThreadLoadTest runs a subset of tests from the GNU mauve project. "
				+ "All tests are thread safe.");
	}

	public void pluginInit(StfCoreExtension stf) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {

		FileRef mauveJar = test.env().findPrereqFile("mauve/mauve.jar");

		if (!mauveJar.asJavaFile().exists()) {
			throw new StfException("Application jar file does not exist: " + mauveJar.getSpec());
		}
		
		JavaVersion jvm = test.env().primaryJvm();

		String inventoryFile = "/openjdk.test.load/config/inventories/mauve/mauve_multiThread.xml";
		
		/* We temporarily run a special load for osx for openj9 jdk8 that 
		 * constitute a set of tests that do not hang. 
		 * Ref: https://github.com/eclipse/openj9/issues/7050
		 */
		if (jvm.isIBMJvm() 
			&& jvm.getJavaVersion() == 8
			&& test.env().getOsgiOperatingSystemName().equals("macosx")) {
			inventoryFile = "/openjdk.test.load/config/inventories/mauve/mauve_multiThread_osx_openj9_jdk8.xml";
		}
		
		/* Temporarily exclude DecimalFormat.setGroupingSize from openj9 jdk14 
			Ref: https://github.com/eclipse/openj9/issues/8086
		 */
		if (jvm.isIBMJvm() 
			&& jvm.getJavaVersion() == 14) {
			inventoryFile = "/openjdk.test.load/config/inventories/mauve/mauve_multiThread_openj9_jdk14.xml";
		}
		
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
				.addJarToClasspath(mauveJar)
				.addSuite("mauve")
				.setSuiteInventory(inventoryFile)
				.setSuiteThreadCount(cpuCount - 1, 3)   // Leave 1 cpu for the JIT and one for GC, but min 2
				.setSuiteNumTests(numMauveTests * multiplier) // Run each test about 1000 times
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run Mauve load test", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("2h"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
}
