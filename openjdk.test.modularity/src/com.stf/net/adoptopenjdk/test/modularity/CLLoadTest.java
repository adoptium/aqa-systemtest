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
 
package net.adoptopenjdk.test.modularity;

import net.adoptopenjdk.stf.environment.DirectoryRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/**
 * This STF test defines a load test where we drive the modularity class loading junit 
 * test class in a multi-threaded faschion. 
 */
public class CLLoadTest implements StfPluginInterface {

	public void help(HelpTextGenerator help) {
		help.outputSection("Modularity ClassLoading Load test");
		help.outputText("This test verifies various class loading behaviors with Modularity");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String inventoryFile = "/openjdk.test.load/config/inventories/modularityClassloading/classloading.xml";
		String comHiPath = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hi").getSpec();
		String comHelloPath = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hello").getSpec();
		String comHelperPath = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.helper").getSpec();
		String comDiscreetPath = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.discreet").getSpec();
		String comHolaPath = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hola").getSpec();
    	String testPath = test.env().findTestDirectory("openjdk.test.modularity/bin/tests").getSpec();		
		String modulePath = comHelloPath + System.getProperty("path.separator") +
						    comHelperPath + System.getProperty("path.separator") +
						    comDiscreetPath + System.getProperty("path.separator") +
						    comHolaPath + System.getProperty("path.separator") +
						    testPath;
											
    	LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addJvmOption("-Xbootclasspath/a:" + 
						test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hi").getSpec())
			    .addJvmOption("--add-reads com.test=ALL-UNNAMED")
			    .addJvmOption("--module-path " + modulePath)
			    .addJvmOption("--add-modules com.test")
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.modularity")
				.setAbortIfOutOfMemory(false)
				.addSuite("classloading")
				.setSuiteThinkingTime("1ms", "2s")
				.setSuiteThreadCount(10)			  // Run tests in 10 worker threads
				.setSuiteInventory(inventoryFile)     // Point at the file which lists the tests
				.setSuiteNumTests(500)             
				.setSuiteRandomSelection();		      // Randomly pick the next test each time
		 
		test.doRunForegroundProcess("Run modularity classloading load tests", "LT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("1h"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
