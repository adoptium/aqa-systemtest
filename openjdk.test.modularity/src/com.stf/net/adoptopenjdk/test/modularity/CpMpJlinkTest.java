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
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition.VmType;
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
 * This test builds and runs a custom runtime image.
 * It demonstrates:
 *   - Creating a module using jar.
 *   - Running jlink to create a runtime image.
 *   - Running the custom image, with .addRunImage() method.
 *   - Checking that the output from the custom JVM was as expected.
 */
public class CpMpJlinkTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Build and run runtime image");
		help.outputText("This test creates a module, packages into a runtime image with jlink and finally executes it.");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
		
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		// Package com.hi into a modular jar.
		// Runs a jar command such as:
		//   jar --create --file $results/modules/1.com.hi.jar -C $workspace/test.modularity/bin/common-mods/com.hi 
	    ModuleRef hiModule = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hi");

	    // Create 2 property files, so that their properties can be added to the jlink'd image
	    FileRef propertiesFile1 = test.env().getTmpDir().childFile("properties1.txt");
   	    test.doWriteFile("Create property file 1", propertiesFile1,
	    	    	  "a=aardvark\n"
   	    			+ "b=badger");
	    FileRef propertiesFile2 = test.env().getTmpDir().childFile("properties2.txt");
	    test.doWriteFile("Create property file 2", propertiesFile2,
	    			  "c=camel\n"
	    			+ "d=donkey\n"
	    			+ "e=elephant");
	    
	    DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
	    
	    // Create a runtime image using jlink
	    // Effectivly runs something like:
	    //   jlink --module-path $jdk-9/jmods:$results/modules --add-modules com.hi --output  $results/tmp/2.HiJVM
	    DirectoryRef runtimeImage = test.doRunJlink("Create runtime image for com.hi", 
	    		new JlinkDefinition()
                    .addDirectoryToModulePath(jmodsDir)		 // Make sure java.base, etc, are available
	    			.addModuleToModulePath(hiModule)
	    			.addModuleToAddmods(hiModule)
	    			.setOutput("HiJVM")						 // This is last of standard options. Now add a bunch of optional ones, but just to test the JlinkDefinition class.
	    			.setCompress(2, "*Exception.class,*Error.class,^/java.base/java/lang/*")
	    			.enableClassForName()                    // Turn on Class.forName optimisation
	    			.addToExcludeFiles("/bin/keytool")
	    			.addToExcludeResources("**.idl")         // Don't ship with idl files
	    			.addToOrderResources("**/module-info.class")
	    	    	.addToOrderResources("@classlist")
	    	    	.addToOrderResources("/java.base/java/lang/**")
	    	    	.setReleaseInfoFile(propertiesFile1.getSpec())
	    			.setReleaseInfoFile(propertiesFile2.getSpec())
	    			.addReleaseInfoProperty("f", "frog")
	    			.addReleaseInfoProperty("g", "goat")
	    			.deleteReleaseInfoProperty("d")
	    			.deleteReleaseInfoProperty("f")
	    			.enableStripDebug()
	    			.setVm(VmType.ALL));
	    
	    // Build a description of how to run using the new runtime image.
	    // Roughly equivilant to: 
	    //   $runtime-image/bin/java adoptopenjdk.test.modularity.hi.Hi everyone
		JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition()
			.addRunImage(runtimeImage)  // Use this image instead of $JAVA_HOME/bin/java
			.runClass(Hi.class)			// Run the class from the hiModule
		    .addArg("everyone");		// Single argument for it to echo

		// Now run Hi.main. This uses the custom built jlink image from the previous step
		String comment = "Excute module class in the runtime image";
		StfProcess process = test.doRunForegroundProcess(comment, "CpMp", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), javaProcessDefinition);
		
		// Make sure that Hi.main produced the expected output
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "Hi everyone");
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
