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

import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import java.lang.management.ManagementFactory;

import net.adoptopenjdk.stf.processes.StfProcess;

/*
 * High level Use case: 
 * ~~~~~~~~~~~~~~~~~~~~~
 * "As an application developer, I can create a series of non-boot Layers and load modules 
 * in those layers and make sure that the classes pertaining to those loaded modules get 
 * unloaded when no longer referenced. 
 * 
 * Standard GC policies (gencon, optthruput and optavgpause), SRT(metronome) and Balanced - 
 * all have a different implementations for modules support. Each of these groups must be tested. 
 * 
 * Test case (1) 
 * ~~~~~~~~~~~~~
 * Create 2 layers L1 and L2, load some modules in them in a multi-threaded process, do some work, 
 * and when the work is done, ensure that classes related to L1 and L2 get un-loaded.
 * 
 * Note: This is an IBM-specific test. 
 * */

/**
 * This STF automation plugin drives the Layers tests using for Java 9 Modularity
 */
public class LayersTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws Exception {
		help.outputSection("Layers test for Java 9 Modularity");
		help.outputText("This test verifies class unloading of classes and classloaders "
				+ "pertaining to a non-boot level Layer.");
		
		help.outputArgName("heapsize", "size");
		help.outputArgDesc("This is the value of the heapsize to be used in -Xmx "
				+ " command line option of the jvm subprocess of the test. The default value is 10m."
				+ "If you provide a value for heapsize, please ensure "
				+ "it is a small enough value as a large heapsize is likely to delay "
				+ "gc from taking place. ");
	}

	public void pluginInit(StfCoreExtension test) throws Exception {
	}

	public void setUp(StfCoreExtension test) throws Exception {
	}

	public void execute(StfCoreExtension test) throws Exception {
		//Define the test Java process to be run
        JavaProcessDefinition testProcess = test.createJavaProcessDefinition(); 
		
		testProcess.addJvmOption("-Dmodule.path=" + test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods"));
					
		//Option to force unloading of classes at every global GC
		testProcess.addJvmOptionIfIBMJava("-Xalwaysclassgc");
		
		//Value of heap size will come from command line, e.g. -test-args="heapsize=10m"
		//Use a small heap size (e.g. 10m) to trigger GC easily 
		StfTestArguments properties = test.env().getTestProperties("heapsize=[10m]");
		testProcess.addJvmOption("-Xmx" + properties.get("heapsize"));
				
		//Option to enable tracepoint Trc_MM_cleanUpClassLoadersStart_triggerClassUnload (j9mm.291)
		testProcess.addJvmOptionIfIBMJava("-Xtrace:print=tpnid{j9mm.291}");
		
		testProcess.addModuleAddReads("com.test=ALL-UNNAMED");
		testProcess.addModuleToModulepath("openjdk.test.modularity/bin/common-mods");
		testProcess.addModuleToModulepath("openjdk.test.modularity/bin/tests");
		testProcess.addRootModule("com.test");
		testProcess.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT);
		testProcess.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST);
		testProcess.runClass(org.junit.runner.JUnitCore.class);
		testProcess.addArg("net.adoptopenjdk.test.modularity.junit.TestLayers");
	
		StfProcess ot1 = test.doRunForegroundProcess("Run OpenJ9 Modularity test for Layers", 
				"T1", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), testProcess);
		
		//Check stderr for output produced by JVM trace engine indicating the desired class unloading
		test.doCountFileMatches("Check output", ot1.getStderrFileRef(), 1, "VM_CLASS_UNLOAD.*adoptopenjdk/test/modularity/hello/Hello");
		test.doCountFileMatches("Check output", ot1.getStderrFileRef(), 1, "VM_CLASS_UNLOAD.*adoptopenjdk/test/modularity/helper/pkgOne/HelperClass");
	}

	public void tearDown(StfCoreExtension test) throws Exception {
	}
}
