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
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;

import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/**
 * This test is a variant of CpMpTest.
 * 
 * It is basically the same except that its description of how to run the test uses 
 * the Java9 module specific methods of JavaProcessDefinition.
 * The java command which it actually runs should be the same as CpMpTest.
 */
public class CpMpTest3 implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Classpath & Modulepath test");
		help.outputText("This test invokes a Module test that accesses public types on both classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		// Work out where the test classes are.
		DirectoryRef commonCodeBin = test.env().findTestDirectory("openjdk.test.modularity/bin/common");

		// Build a description of how to run JUnit			
		JavaProcessDefinition junitProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleAddReads("com.test=ALL-UNNAMED")
		    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
		    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
		    // Not used by the test, but does verify correct argument generation for '--add-exports' 
		    .addAddExports("java.base", "sun.security.x509", "ALL-UNNAMED") 
		    .addPatchModule("module2", commonCodeBin)
		    .addRootModule("com.test")
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
		    .addDirectoryToClasspath(commonCodeBin)
		    .runClass(org.junit.runner.JUnitCore.class)
		    .addArg("net.adoptopenjdk.test.modularity.junit.TestCpMp");
		
		// Run TestCpMp as junit test
		String comment = "Run modularity test in Junit";
		test.doRunForegroundProcess(comment, "CpMp", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
