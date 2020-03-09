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
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.loadTest.InventoryData;

public class MixedLoadTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("MixedLoadTest runs workloads of math,mauve,nio,lang,concurrent unit tests");
		help.outputText("");
	}

	public void pluginInit(StfCoreExtension stf) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		
		FileRef mauveJar = test.env().findPrereqFile("mauve/mauve.jar");
		FileRef fileSystemJar = test.env().findTestFile("openjdk.test.nio/bin/lib/filesystem.jar");

		if (!mauveJar.asJavaFile().exists()) {
			throw new StfException("Application jar file does not exist: " + mauveJar.getSpec());
		}
		
		if (!fileSystemJar.asJavaFile().exists()) {
			throw new StfException("The filesystem.jar does not exist: " + fileSystemJar.getSpec());
		}
		
		String timeout = "3h";
		
		String inventoryFile = "/openjdk.test.load/config/inventories/mix/mix-more.xml";
		int totalTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();

		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.math")
				.addProjectToClasspath("openjdk.test.lang")
				.addProjectToClasspath("openjdk.test.nio")
				.addProjectToClasspath("openjdk.test.concurrent")
				.addJarToClasspath(mauveJar)
				.addJarToClasspath(fileSystemJar)
				.setAbortIfOutOfMemory(false)
				.addSuite("mix")
				.setSuiteThreadCount(cpuCount - 2, 10)	
				.setSuiteNumTests(totalTests * 200) // Leave 1 cpu for the JIT. i for GC and set min 20			
				.setSuiteInventory(inventoryFile) 			// Point at the file which lists the tests
				.setSuiteRandomSelection();		  			// Randomly pick the next test each time
				
		test.doRunForegroundProcess("Run mixed unit tests", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within(timeout), 
				loadTestInvocation);		
			
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
}