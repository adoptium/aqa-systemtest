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
import net.adoptopenjdk.stf.environment.StfTestArguments;
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

public class AutoModTest implements StfPluginInterface {
	
	/**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from AutomaticModulesTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=AutomaticModulesTest -test-args="variant=<enum_value_of_test>" 
	 * */
	public enum Variant { 
		AutoMod1, 
		AutoMod2,
		Impl1,
		Impl2,
		Impl3
	};
	
	FileRef commonJar;
	FileRef comHolaJar;
	FileRef comHelperJar;
	FileRef comTestJar;
	ModuleRef comHelloModularJar;
	ModuleRef comDiscreetModularJar;
	
	public void help(HelpTextGenerator help) {
		help.outputSection("Automatic Modules test");
		help.outputText("This test verifies if automatic modules "
				+ "are readable from other modules and checks if "
				+ "automatic modules grant implied readability to other modules");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
		// Create the needed jar files. 
		// This exposes their creation instead of hiding it within build.xml.
		// It also allows the test to execute from an Eclipse workspace.
		commonJar    = test.doCreateProjectJar("create common.jar",     "openjdk.test.modularity/bin/common",                 "adoptopenjdk");
		comHolaJar   = test.doCreateProjectJar("create com.hola.jar",   "openjdk.test.modularity/bin/common-mods/com.hola",   "adoptopenjdk");
		comHelperJar = test.doCreateProjectJar("create com.helper.jar", "openjdk.test.modularity/bin/common-mods/com.helper", "adoptopenjdk");
		comTestJar   = test.doCreateProjectJar("create com.test.jar",   "openjdk.test.modularity/bin/tests/com.test",         "net");

		comHelloModularJar    = test.doCreateModularJar("create com.hello.jar",    "openjdk.test.modularity/bin/common-mods/com.hello");
		comDiscreetModularJar = test.doCreateModularJar("create com.discreet.jar", "openjdk.test.modularity/bin/common-mods/com.discreet");
	}
	
	/* 
		User story: As a developer I can use a non-modularized third party library with a modularized 
		application by converting it into an automatic module  
		(To convert the library jar into an automatic module, place it on the module path).
	
		Use case 1:
		Place the third party library jars on modulepath and check if public types in it can 
		be accessed by an explicit module by adding a readability edge to the 
		automatic modules (third party jars).
	
		Use case 2:
		Place one of third party library jar on mp, another on cp and check if the public types 
		can be accessed by an explicit module by adding a readability edge to the 
		automatic module and unnamed module (third party jars)
	*/
	public void execute(StfCoreExtension test) throws StfException {
		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		
		switch (variant) {
			case AutoMod1 : 
				/**
				 * Running com.test.TestAutomaticModules for usecase1. 
				 * Refer to the TestAutomaticModules.java for details.
				 */
				test.doRunForegroundProcess("Run TestAutomaticModules for usecase1" , 
						"T1", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
								 .addModuleAddReads("com.test=junit")
								 .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
								 .addModuleToModulepath("openjdk.test.modularity/bin/tests")
								 .addPrereqJarToModulePath(JavaProcessDefinition.JarId.JUNIT)
								 .addPrereqJarToModulePath(JavaProcessDefinition.JarId.HAMCREST)
								 .addJarToModulepath(commonJar)
								 .addRootModule("com.test,junit,hamcrest.core,common")
								 .addProjectToClasspath("openjdk.test.modularity")
								 .runClass(org.junit.runner.JUnitCore.class)
								 .addArg("net.adoptopenjdk.test.modularity.junit.TestAutomaticModules"));
				break;
				
			case AutoMod2 : 
				/**
				 * Running com.test.TestAutomaticModules for usecase2. 
				 * Refer to the TestAutomaticModules.java for details.
				 */
				test.doRunForegroundProcess("Run TestAutomaticModules for usecase2", 
						"T2", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
								 .addModuleAddReads("com.test=junit")
								 .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
								 .addModuleToModulepath("openjdk.test.modularity/bin/tests")
								 .addPrereqJarToModulePath(JavaProcessDefinition.JarId.JUNIT)
								 .addJarToModulepath(commonJar)
								 .addRootModule("com.test,junit,common")
								 .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
								 .addProjectToClasspath("openjdk.test.modularity")
								 .runClass(org.junit.runner.JUnitCore.class)
								 .addArg("net.adoptopenjdk.test.modularity.junit.TestAutomaticModules"));
				break;
			
			case Impl1: 
				/**
				 * Running com.test.TestImpliedReadaibility for usecase1. 
				 * Refer to the TestImpliedReadaibility.java for details.
				 */
				test.doRunForegroundProcess("Run TestImpliedReadability for usecase 1", 
						"T3", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
							 .addModuleAddReads("com.test=ALL-UNNAMED")
							 .addModuleToModulepath("openjdk.test.modularity/bin/tests")
							 .addModuleToModulepath(comHelloModularJar)
							 .addModuleToModulepath(comDiscreetModularJar)
							 .addJarToModulepath(comHolaJar)
							 .addJarToModulepath(comHelperJar)
							 .addRootModule("com.test,com.hola") 
							 .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							 .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							 .addProjectToClasspath("openjdk.test.modularity")
							 .runClass(org.junit.runner.JUnitCore.class)
							 .addArg("net.adoptopenjdk.test.modularity.junit.TestImpliedReadability"));
				break;
			
			case Impl2: 
				/**
				 * Running com.test.TestImpliedReadaibility for usecase2. 
				 * Refer to the TestImpliedReadaibility.java for details.
				 */
				test.doRunForegroundProcess("Run TestImpliedReadability for usecase 2", 
						"T4", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
						 	.addModuleAddReads("com.test=ALL-UNNAMED")
						 	.addModuleToModulepath("openjdk.test.modularity/bin/tests")
						 	.addModuleToModulepath(comHelloModularJar)
							.addModuleToModulepath(comDiscreetModularJar)
							.addJarToModulepath(comHelperJar)
							.addRootModule("com.test") 
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.addJarToClasspath(comHolaJar)
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestImpliedReadability"));
				break;
			
			case Impl3: 
				/**
				 * Running com.test.TestImpliedReadaibility for usecase3.
				 * Refer to the TestImpliedReadaibility.java for details.
				 */
				test.doRunForegroundProcess("Run com.test.TestImpliedReadability for usecase3", 
						"T5", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addJarToModulepath(comHolaJar)
							.addJarToModulepath(comHelperJar)
							.addModuleToModulepath(comDiscreetModularJar)
							.addJarToModulepath(comTestJar)
							.addRootModule("com.test,com.helper,com.hola")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestImpliedReadability"));
				break;
		}
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}