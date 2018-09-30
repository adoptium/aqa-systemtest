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
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;

import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.SystemProcessDefinition;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/**
 * STF test plugin to drive Class Loading tests for Java 9 Modularity
 * using a custom runtime image. 
 *
 */
public class CLTestImage implements StfPluginInterface {
	
	enum Variant { CLTest, CLTestUsingResourceFiles };
	
	public void help(HelpTextGenerator help) {
		help.outputSection("ClassLoading test using a custom runtime image");
		help.outputText("This test verifies various class loading behaviors with modules"
				+ "using a Custom Runtime Image craeted on the fly.");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
	    DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
	    
		ModuleRef helloModule     = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
	    ModuleRef holaModule      = test.doCreateModularJar("Create com.hola jar", "openjdk.test.modularity/bin/common-mods/com.hola");
	    ModuleRef helperModule    = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.helper");
	    ModuleRef discreetModule  = test.doCreateModularJar("Create com.discreet jar", "openjdk.test.modularity/bin/common-mods/com.discreet");
		ModuleRef testModule      = test.doCreateModularJar("Create tests jar", "openjdk.test.modularity/bin/tests/com.test");

		DirectoryRef runtimeImage = test.doRunJlink("Create runtime image for "
				+ "Class Loading test", 
	    		new JlinkDefinition()
	    			.addDirectoryToModulePath(jmodsDir)
		    		.addModuleToModulePath(helloModule)
	    			.addModuleToAddmods(helloModule)
	    			.addModuleToModulePath(holaModule)
	    			.addModuleToAddmods(holaModule)
	    			.addModuleToModulePath(testModule)
	    			.addModuleToAddmods(testModule)
	    			.addModuleToModulePath(helperModule)
	    			.addModuleToAddmods(helperModule)
	    			.addModuleToModulePath(discreetModule)
	    			.addModuleToAddmods(discreetModule)
		    		.setOutput("CLJVM"));
		
		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		switch (variant) {
			case CLTest : 
				test.doRunForegroundProcess("Run Modularity ClassLoading tests using a "
						+ "Custom Runtime Image", "CLI", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
						.addRunImage(runtimeImage)  
						.addJvmOption("-Dtest.type=customruntime")
						.addJvmOption("-Xbootclasspath/a:" + 
								test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hi").getSpec())
						.addModuleAddReads("com.test=ALL-UNNAMED")
						.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
						.runClass(org.junit.runner.JUnitCore.class)
						.addArg("net.adoptopenjdk.test.modularity.junit.TestClassLoading")
					);
			break;
			case CLTestUsingResourceFiles :
				test.doRunForegroundProcess("Run Modularity ClassLoading tests using a "
						+ "Custom Runtime Image", "CLI", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
						.addRunImage(runtimeImage)  
						.addJvmOption("-Dtest.type=customruntime")
						.addModuleAddReads("com.test=ALL-UNNAMED")
						.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
						.runClass(org.junit.runner.JUnitCore.class)
						.addArg("net.adoptopenjdk.test.modularity.junit.TestClassLoadingUsingResourceFiles")
					);
		}
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
