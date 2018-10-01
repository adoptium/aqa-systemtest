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
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;


/**
 * This test is a variant of CpMpTest.
 * 
 * It is basically the same except that the module used during the test are loaded 
 * from modular jars. 
 * 
 * The modular jars could be created by the build process, but in this case the 
 * test code creates them by calling StfCoreExtension.doCreateModularJar().
 * Getting the test to create the modular jar has the advantage that the test becomes 
 * self contained, and means that you don't need to know what the build.xml is doing
 * in order to understand this test.
 */
public class CpMpModularJarTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Mixed classpath & modulepath test using modular jars");
		help.outputText("This test invokes a Module test that accesses public types on both classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		// Work out where the test classes are.
		DirectoryRef commonCodeBin = test.env().findTestDirectory("openjdk.test.modularity/bin/common");

		// Create modular jars
	    ModuleRef helloModule    = test.doCreateModularJar("Create com.hello jar",  "openjdk.test.modularity/bin/common-mods/com.hello");
	    ModuleRef helperModule   = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.helper");
	    ModuleRef discreetModule = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.discreet");
	    ModuleRef holaModule     = test.doCreateModularJar("Create com.hola jar",   "openjdk.test.modularity/bin/common-mods/com.hola");
	    ModuleRef testsModule    = test.doCreateModularJar("Create tests jar",      "openjdk.test.modularity/bin/tests/com.test");
		
		// Build a description of how to run JUnit with the modular jars	
		JavaProcessDefinition junitProcessDefinition = test.createJavaProcessDefinition()
			.addModuleAddReads("com.test=ALL-UNNAMED")
			.addModuleToModulepath(helloModule)
		    .addModuleToModulepath(helperModule)
		    .addModuleToModulepath(discreetModule)
		    .addModuleToModulepath(holaModule)
		    .addModuleToModulepath(testsModule)
		    .addRootModule("com.test")
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
		    .addDirectoryToClasspath(commonCodeBin)
		    .runClass(org.junit.runner.JUnitCore.class)
		    .addArg("net.adoptopenjdk.test.modularity.junit.TestCpMp");
		
		// Run TestCpMp as junit test with modular jars
		String comment = "Run modularity test in Junit";
		test.doRunForegroundProcess(comment, "CpMp", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
