/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
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
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/**
 * This STF automation plugin drives the class loading tests 
 * for Java 9 Modularity
 */
public class CLTest implements StfPluginInterface {
	
	/**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from CLTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=CLTest -test-args="variant=<enum_value_of_test>" 
	 * */
	enum Variant { 
		CLTest, 
		CLTestUsingResourceFiles 
	};
	
	public void help(HelpTextGenerator help) {
		help.outputSection("ClassLoading test");
		help.outputText("This test verifies various class loading behaviors with Modularity");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		
		switch (variant) {
			case CLTest : 
				test.doRunForegroundProcess("Run Modularity ClassLoading tests", "CLT", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addJvmOption("-Xbootclasspath/a:" + test.env()
							.findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hi").getSpec())
						    .addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods/com.hello")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods/com.helper")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods/com.discreet")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods/com.hola")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestClassLoading")
						);
				break;
				
			case CLTestUsingResourceFiles :
				test.doRunForegroundProcess("Run Modularity ClassLoading tests", "CLT", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
						    .addJvmOption("-Dtest.type=regular")
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestClassLoadingUsingResourceFiles")
						);
				break;
		}
		
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
