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
import net.adoptopenjdk.stf.environment.ModuleRef;
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
import net.adoptopenjdk.stf.processes.StfProcess;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

import adoptopenjdk.test.modularity.hi.Hi;
/**
 * This test is a variant of CpMpModularJarTest2, except that the main class to run
 * is not embedded in the modular jar with '--main-class=adoptopenjdk.test.modularity.hi.Hi'. 
 * It is instead supplied as a main class on the '-m' java argument. eg, '-m com.hi/adoptopenjdk.test.modularity.hi.Hi'
 */
public class CpMpModularJarTest3 implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Mixed classpath & modulepath test using modular jars");
		help.outputText("This test invokes a Module test that accesses public types on both classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		// Package com.hi into a modular jar.
		// Note there is no main class specified
	    ModuleRef hiModule = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hi");
		
		// Build a description of how to run JUnit with the modular jar.
	    // Roughly equivilant to: java --module-path com.hi.jar -m com.hi/adoptopenjdk.test.modularity.hi.Hi "everyone"
		JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleToModulepath(hiModule)
		    .addInitialModule("com.hi", Hi.class)  // Specify class to run
		    .addArg("everyone");
		
		// Run Hi.main()
		String comment = "Run modularity test with module main class";
		StfProcess process = test.doRunForegroundProcess(comment, "CpMp", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), javaProcessDefinition);
		
		// Make sure that a single instance of the expected output was produced
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "Hi everyone");
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
