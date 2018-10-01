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
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

public class CpMpTest implements StfPluginInterface {
	
	/**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from CpMpTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=CpMpTest -test-args="variant=<enum_value_of_test>" 
	 * */
	public enum Variant { 
		CpMp,
		Mp
	};
	
	public void help(HelpTextGenerator help) {
		help.outputSection("Classpath & Modulepath test");
		help.outputText("This test invokes a Module test that "
				+ "accesses public types on both classpath and modulepath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		DirectoryRef comDir = test.env().findTestDirectory("openjdk.test.modularity/bin/common");

		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		
		switch (variant) {
			case CpMp : 
				test.doRunForegroundProcess("Run TestCpMp test", "CpMp", 
					ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJavaProcessDefinition()
					.addModuleAddReads("com.test=ALL-UNNAMED")
					.addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
					.addModuleToModulepath("openjdk.test.modularity/bin/tests")
					.addRootModule("com.test")
					.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
					.addDirectoryToClasspath(comDir)
					.runClass(org.junit.runner.JUnitCore.class)
					.addArg("net.adoptopenjdk.test.modularity.junit.TestCpMp"));
				break;
				
			case Mp : 
				test.doRunForegroundProcess("Run TestMp test", "Mp", 
					ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJavaProcessDefinition()
					.addModuleAddReads("com.test=ALL-UNNAMED,com.hi")
					.addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
					.addModuleToModulepath("openjdk.test.modularity/bin/tests")
					.addRootModule("com.test,com.hi")
					.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
					.addProjectToClasspath("openjdk.test.modularity")
					.addDirectoryToClasspath(comDir)
					.runClass(org.junit.runner.JUnitCore.class)
					.addArg("net.adoptopenjdk.test.modularity.junit.TestMp"));
				break;
		}
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
