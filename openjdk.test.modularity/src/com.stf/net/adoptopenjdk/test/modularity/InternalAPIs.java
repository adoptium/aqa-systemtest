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
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

public class InternalAPIs implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("JDK Internal APIs test");
		help.outputText("This test verifies if the critical internal APIs as "
				+ "defined in JEP 220 are accessible to the code on classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String testClass = "net.adoptopenjdk.test.modularity.junit.TestJDKInternalAPIs";
		DirectoryRef testsDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test");
		
		// Refer to Usecase1 TestJDKInternalAPIs.java for details.		
		JavaProcessDefinition junitProcessDefinition = test.createJavaProcessDefinition()
			.addDirectoryToClasspath(testsDir)
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
		    .runClass(org.junit.runner.JUnitCore.class)
			.addArg(testClass);
						
	    // Run TestJDKInternalAPIs as junit test
		test.doRunForegroundProcess("Run critical internal APIs test by accessing "
				+ "the critical exported APIs from an unnamed module or classpath", 
				"T1", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 
		
		// Refer to Usecase2 in TestJDKInternalAPIs.java for details.		
		junitProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleAddReads("com.test=ALL-UNNAMED")
		    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
		    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
		    .addRootModule("com.test")
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
		    .runClass(org.junit.runner.JUnitCore.class)
		    .addArg(testClass);
		
		// Run TestJDKInternalAPIs as junit test
		test.doRunForegroundProcess("Run critical internal APIs test by accessing the "
				+ "critical exported APIs from a module", 
				"T2", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 				
	
		// Refer to Usecase3 in TestJDKInternalAPIs.java for details.
		ModuleRef testsModule  = test.doCreateModularJar("Create tests jar", "openjdk.test.modularity/bin/tests/com.test");
		 	junitProcessDefinition = test.createJavaProcessDefinition()
				.addModuleAddReads("com.test=ALL-UNNAMED")
				.addModuleToModulepath(testsModule)
			    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
			    .addRootModule("com.test")
			    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
			    .runClass(org.junit.runner.JUnitCore.class)
			    .addArg(testClass);
			
		 // Run TestJDKInternalAPIs as junit test
		 test.doRunForegroundProcess("Run critical internal APIs test by accessing "
		 		+ "the critical exported APIs from a modular jar", 
		 		"T3", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 
		
		 // Refer to Usecase4 in TestJDKInternalAPIs.java for details.
		 FileRef testJar = test.doCreateProjectJar("create comTest.jar", "openjdk.test.modularity/bin/tests/com.test", "net");
		 junitProcessDefinition = test.createJavaProcessDefinition()
				.addJarToModulepath(testJar)
			    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
			    .addRootModule("com.test")				   
			    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.runClass(org.junit.runner.JUnitCore.class)
				.addArg(testClass);
				
		// Run TestJDKInternalAPIs as junit test
		test.doRunForegroundProcess("Run critical internal APIs test by "
				+ "accessing the critical exported APIs from an "
				+ "automatic module", 
				"T4", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
