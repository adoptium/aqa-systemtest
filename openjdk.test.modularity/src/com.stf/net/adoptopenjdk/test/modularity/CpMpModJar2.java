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
 * This test is a variant of CpMpModJar.
 * It runs java usinfg a modular jar which has a main class. This has been 
 * created with '--main-class=adoptopenjdk.test.modularity.hi.Hi'
 */
public class CpMpModJar2 implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Mixed classpath & modulepath test using modular jars");
		help.outputText("This test invokes a Module test that accesses public types on both classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}
	
	public void execute(StfCoreExtension test) throws StfException {
		// Package com.hi into a modular jar with a main class
	    ModuleRef hiModule = test.doCreateModularJar("Create com.hello jar", 
	    		"openjdk.test.modularity/bin/common-mods/com.hi", Hi.class);
		
		// Build a description of how to run JUnit with the modular jar.
	    // Roughly equivilant to: java --module-path com.hi.jar -m com.hi "everyone"
		JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleToModulepath(hiModule)
		    .addInitialModule("com.hi")
		    .addArg("everyone");
		
		// Run TestCpMp as junit test with modular jars
		String comment = "Run modularity test in Junit";
		StfProcess process = test.doRunForegroundProcess(comment, "CpMp", ECHO_ON, 
				ExpectedOutcome.cleanRun().within("1m"), javaProcessDefinition);
		
		// Make sure that 'hi.class' wrote a single instance of the expected output
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "Hi everyone");
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
