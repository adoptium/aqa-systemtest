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
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * This is a test plugin for Java NIO API related tests, it runs a workload 
 * combining the nio tests and nio2 tests. 
 * 
 * Java NIO (New IO) is an alternative IO API for Java (from Java 1.4), meaning 
 * alternative to the standard Java IO and Java Networking API's. 
 * Java NIO offers a different way of working with IO than the standard IO API's.
 * 
 * The nio tests were written to test this Java NIO API when it was introduced, 
 * the nio2 tests were later written when the Java NIO API was extended (from Java 
 * 1.7) to cover new functionality, the most significant being asynchronous I/O. 
 * 
 * For further info about the tests see the the test documentation attached to the
 * test.nio project (NioTestsDoc.md and ChatClient.md).
 */
public class NioLoadTest extends TimeBasedLoadTest {	
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("NioLoadTest runs the former JGrinder nio and nio2 tests");
		help.outputText("");
	}

	public void execute(StfCoreExtension test) throws StfException {
		// Specify the filesystem.jar which is required for the FileSystemsTest and ensure it exists
		FileRef fileSystemJar = test.env().findTestFile("openjdk.test.nio/bin/lib/filesystem.jar");
		if (!fileSystemJar.asJavaFile().exists()) {
			throw new StfException("The filesystem.jar does not exist: " + fileSystemJar.getSpec());
		}
		
		String inventoryFile = "/openjdk.test.load/config/inventories/nio/nio.xml";
		int numNioTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();
		
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addJarToClasspath(fileSystemJar)
				.addProjectToClasspath("openjdk.test.nio");
		
		if (isTimeBasedLoadTest) { 
			loadTestInvocation = loadTestInvocation.setTimeLimit(timeLimit);	// If it's a time based test, stop execution after given time duration
		}
		
		loadTestInvocation = loadTestInvocation.setAbortIfOutOfMemory(false)
				.addSuite("nio")
				.setSuiteThreadCount(cpuCount - 2, 2);	// Leave 1 cpu for the JIT, 1 cpu for GC and set min 2
		
		if (!isTimeBasedLoadTest) { // If it's not a time-based run, set number of tests to run
			loadTestInvocation = loadTestInvocation.setSuiteNumTests(numNioTests * 10); 
		}
		
		loadTestInvocation = loadTestInvocation
				.setSuiteInventory(inventoryFile) 	// Point at the file which lists the tests
				.setSuiteRandomSelection(); 		// Randomly pick the next test each time
		
		test.doRunForegroundProcess("Run nio load test", "NLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within(finalTimeout), 
				loadTestInvocation);
	}
}

