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
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * This is a test plugin that runs the DirectMemoryTest test class along side a workload
 * of NIO tests.
 * 
 * The DirectMemoryTest allocates direct memory ByteBuffers and dereferences them.
 */
public class DirectByteBufferLoadTest implements StfPluginInterface {	
	public void help(HelpTextGenerator help) throws StfException {
		String testName = DirectByteBufferLoadTest.class.getSimpleName();
		
		help.outputSection(testName + " test");
		help.outputText(testName + " runs the DirectMemoryTest test class along side a NIO workload.");
		help.outputText("This test is primarily aimed at stressing the Garbage Collector.");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws Exception {
	}

	public void execute(StfCoreExtension test) throws StfException {
		// The NIO workload has a dependency on filesystem.jar
		FileRef filesystemJar = test.env().findTestFile("openjdk.test.nio/bin/lib/filesystem.jar");
		
		String inventory = "/openjdk.test.load/config/inventories/gc/directByteBuffer.xml";
		int numTests = InventoryData.getNumberOfTests(test, inventory);
		int cpuCount = Runtime.getRuntime().availableProcessors();
		
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addJarToClasspath(filesystemJar)
				.addProjectToClasspath("openjdk.test.gc")
				.addProjectToClasspath("openjdk.test.nio")
				.addSuite("DirectByteBuffer")
				.setSuiteThreadCount(cpuCount - 1, 2) 
				.setSuiteNumTests(numTests)
				.setSuiteInventory(inventory)
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run DirectByteBuffer load test", "DBLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("5m"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
