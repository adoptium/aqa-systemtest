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

import java.util.Arrays;

import net.adoptopenjdk.loadTest.InventoryData;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * This is a test plugin for Math related tests, it runs workloads of BigDecimal 
 * JUnit tests and AutoSIMD tests in random order.
 */
public class MathLoadTest implements StfPluginInterface {
	private enum Workloads {
		//Workload  Multiplier  Timeout  InventoryFile
		math( 		   50, 		 "20h", 	"math.xml"),
		bigDecimal(    50,		 "1h", 		"bigdecimal.xml"),
		autoSimd( 	   4000, 	 "5m", 		"autosimd.xml");
		
		int multiplier;
		String timeout;
		String inventoryFile;
		
		private Workloads(int multiplier, String timeout, String inventoryFile) {
			this.multiplier 	= multiplier;
			this.timeout		= timeout;
			this.inventoryFile 	= inventoryFile;
		}
	}
	
	Workloads workload;
	
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("MathLoadTest test");
		help.outputText("MathLoadTest runs workloads of Math related tests, "
				+ "by default it runs all math tests if no workload is specified.");

		help.outputSection("MathLoadTest test options");
		help.outputArgName("workload", "NAME");
		help.outputArgDesc("This is the name of the workload to run, it supports "
				+ "the following workloads: "
				+ Arrays.toString(Workloads.values()).replace("math", "math(default)"));
	}
	
	public void pluginInit(StfCoreExtension stf) throws StfException {
		// Find out which workload we need to run
		StfTestArguments testArgs = stf.env().getTestProperties("workload=[math]");
		workload = testArgs.decodeEnum("workload", Workloads.class);
	}

	public void execute(StfCoreExtension test) throws StfException {
		String inventoryFile = "/openjdk.test.load/config/inventories/math/" + workload.inventoryFile;
		int numMathTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();
		
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.math")
				.addSuite("math")
				.setSuiteThreadCount(cpuCount - 1, 2)
				.setSuiteNumTests(numMathTests * workload.multiplier)
				.setSuiteInventory(inventoryFile)
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run math load test", "MLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within(workload.timeout), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
	
	public void setUp(StfCoreExtension stf) throws StfException {
	}
}