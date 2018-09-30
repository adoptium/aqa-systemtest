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
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import java.lang.management.ManagementFactory;

import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;
import net.adoptopenjdk.stf.util.StfDuration;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;

/*
 * Implement a Stress test for Layers using a custom runtime image.
 * See TestStressLayers.java for details on test case description. 
 **/
public class CLStressWithLayersCRI implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws Exception {
		help.outputSection("Class loading stress test with Layers on a custom runtime image"
				+ "for Java 9 Modularity");
		help.outputText("This test stresses class-loading of classes "
				+ "pertaining to non-boot modules as well as "
				+ "modules from jimage (e.g. platform classes) "
				+ "using multiple Layers and threads.");
		
		help.outputArgName("threadcount", "count");
		help.outputArgDesc("This is the number of thread to be used in the "
				+ "class unloading test. Default value is 50.");
	}

	public void pluginInit(StfCoreExtension test) throws Exception {
	}

	public void setUp(StfCoreExtension test) throws Exception {
	}

	public void execute(StfCoreExtension test) throws Exception {
		// Create the custom runtime image using jlink first
		DirectoryRef runtimeImage = getRuntimeImage(test);
		
		// Define the test Java process to be run
        JavaProcessDefinition testProcess = test.createJavaProcessDefinition(); 
        testProcess.addRunImage(runtimeImage) ; 
		
		testProcess.addJvmOption("-Dmodule.path=" + test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods"));
		
		// Value of thread count will come from command line, e.g. -test-args="threadcount=100"
		// Default threadcount is set to 50
		StfTestArguments properties = test.env().getTestProperties("threadcount=[50]");
		int threadCount = Integer.parseInt(properties.get("threadcount")); 
		testProcess.addJvmOption("-Dthread.count=" + threadCount);
		
		testProcess.addModuleAddReads("com.test=ALL-UNNAMED");
		testProcess.addModuleToModulepath("openjdk.test.modularity/bin/common-mods");
		testProcess.addModuleToModulepath("openjdk.test.modularity/bin/tests");
		testProcess.addRootModule("com.test");
		testProcess.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT);
		testProcess.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST);
		testProcess.runClass(org.junit.runner.JUnitCore.class);
		testProcess.addArg("net.adoptopenjdk.test.modularity.junit.TestStressLayers");
	
		StfProcess ot1 = test.doRunForegroundProcess("Run Java9 Modularity stress test for Layers", 
				"T1", ECHO_ON, ExpectedOutcome.cleanRun().within("2m"), testProcess);
	}

	public void tearDown(StfCoreExtension test) throws Exception {
	}
	
	private DirectoryRef getRuntimeImage(StfCoreExtension test) throws Exception {
		ModuleRef helloModule = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
	    ModuleRef holaModule   = test.doCreateModularJar("Create com.hola jar", "openjdk.test.modularity/bin/common-mods/com.hola");
	    ModuleRef helperModule   = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.helper");
	    ModuleRef discreetModule  = test.doCreateModularJar("Create com.discreet jar", "openjdk.test.modularity/bin/common-mods/com.discreet");
		ModuleRef testModule  = test.doCreateModularJar("Create tests jar", "openjdk.test.modularity/bin/tests/com.test");
		DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
		
		DirectoryRef runtimeImage = test.doRunJlink("Create runtime image for "
				+ "class-loading layers stress test", 
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
		
		return runtimeImage; 
	}
}
