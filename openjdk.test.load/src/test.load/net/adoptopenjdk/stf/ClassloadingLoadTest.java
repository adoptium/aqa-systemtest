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

import java.util.ArrayList;

import net.adoptopenjdk.loadTest.InventoryData;
import net.adoptopenjdk.stf.codeGeneration.Stage;
import net.adoptopenjdk.stf.environment.DirectoryRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * This is a simple test plugin that runs a workload of tests 
 * from the test.classloading project.
 */
public class ClassloadingLoadTest implements StfPluginInterface {
	
	private int testCountMultiplier = 3000; 
	private boolean specialTest = false; 
	
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("ClassloadingLoadTest");
		help.outputText("ClassloadingLoadTest runs a workload of tests "
				+ "from the test.classloading project.");
	}

	public void pluginInit(StfCoreExtension stf) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String jvmOptionsInUse = test.getJavaArgs(test.env().primaryJvm()); 
		
		if (jvmOptionsInUse.contains("-Xjit:count") ||
			jvmOptionsInUse.contains("Xjit:enableOSR")) {
			specialTest = true;
		}
		
		if(specialTest) {
			// If we are running with special JIT modes which are slow, reduce workload 
			testCountMultiplier = 500; 
			
		} 	
		
		String inventoryFile = "/openjdk.test.load/config/inventories/classloading/classloading.xml";
		int totalTests = InventoryData.getNumberOfTests(test, inventoryFile);
		int cpuCount = Runtime.getRuntime().availableProcessors();
		int javaVersion = test.env().primaryJvm().getJavaVersion();
		
		// testRoots will contain all the test roots - we just want to know which is our test root
		ArrayList<DirectoryRef> testRoots = test.env().getTestRoots();
		
		// Find the directory root (from testRoots) which contains the classes to be loaded by the URLClassLoaders within the classloading deadlock test
		// (these are deliberately compiled into a directory which is not on the classpath (called bin_notonclasspath)). 
		// For example, if openjdk-systemtest was cloned into the default location of $HOME/git then this will be set to /home/user/git/openjdk-systemtest
		DirectoryRef notonclasspathDirRoot = DirectoryRef.findDirectoryRoot("openjdk.test.classloading/bin_notonclasspath/url1/net/adoptopenjdk/test/classloading/deadlock/package1/",
													 testRoots);
		String modulesAdd = "";
		if (javaVersion >= 9) {
			modulesAdd = "java.rmi";
			if (javaVersion < 11) {
				modulesAdd += ",java.transaction,java.corba";
			}
		}
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addJvmOption("-Djava.classloading.dir=" + notonclasspathDirRoot)  // Expose the bin_notonclasspath root directory to the deadlock test
				.addJvmOption("-Djava.version.number=" + javaVersion)
				.addModules(modulesAdd)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.classloading")
				.setAbortIfOutOfMemory(false)
				.addSuite("classloading")
				.setSuiteThreadCount(cpuCount - 1, 10)
				.setSuiteInventory(inventoryFile)
				.setSuiteNumTests(totalTests * testCountMultiplier)
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run classloading tests", "CLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("2h"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
}