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
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JmodDefinition;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;
import net.adoptopenjdk.stf.util.StfDuration;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import org.junit.*;
import org.junit.runner.*;

/*
 * Use case
 * ~~~~~~~~
 * "As a Java Product developer I can create a custom java runtime image (using jlink tool) 
 * using modules from another platform."
 * 
 * Note: 
 * 		This STF plugin only creates a cross-platform jlink custom runtime image given 
 * 		the source and target platform names, target sdk and path to the target folder in 
 * 		which to create the image. The process of actually running tests on these images 
 * 		are carried out using separate steps.  
 * 
 * Assumptions:
 *    1) JAVA_HOME environmental variable of the host machine is pointing to the 'source' sdk.
 *    2) Path to the 'target' sdk is provided in input paramter 'targetVM'.
 *    3) Directory in which images is created will be provided in input parameter 'genDir'. 
 *    4) Source and target platforms are specified via input parameters 'sourcePlatform' and 'targetPlatform'.
 *       The following source-target combinations should essentially be used: 
 *   		      Source               Target 
 *   		      -------              ------
 * 		      a) Aix 64bit     ->  Linux PPC LE 32bit 
 * 		      b) Linux 32bit   ->  Aix 64bit 
 *		      c) Windows 64bit ->  zOS 64bit 
 * 		      d) zOS 64bit     ->  Linux 32bit 
 * 		      e) Windows 64bit ->  Linux x86 64 
 * 		      f) Linux x86 64  ->  Windows 64bit 
 */

public class CreateMultiboxJlinkImage implements StfPluginInterface {
	
	enum SourcePlatform { aix64, linux32, win64, zos64, linux64 }; 
	enum TargetPlatform { linuxppcle32, aix64, zos64, linux32, linux64, win64 };
	
	static final String SUPPORTED_PLATFORM_COMBINATIONS = 
			    "a) Aix 64bit     ->  Linux PPC LE 32bit\n"
			  + "b) Linux 32bit   ->  Aix 64bit\n"
			  + "c) Windows 64bit ->  zOS 64bit\n"
			  + "d) zOS 64bit     ->  Linux 32bit\n"
			  + "e) Windows 64bit ->  Linux x86 64\n"
			  + "f) Linux x86 64  ->  Windows 64bit\n"; 
	
	public void help(HelpTextGenerator help) {
		help.outputSection("STF Plugin to create a jlink image using a given target-java-home"
				+ " and location to put the createad image.");
		
		help.outputArgName("sourcePlatform", "<source_platform>");
		help.outputArgDesc("Source plaform may take one of the following values:"
				+ Arrays.toString(SourcePlatform.values())
				+ "\nFollowing are of source-target combinations supported by multi-box jlink test:\n"
				+ SUPPORTED_PLATFORM_COMBINATIONS);
		
		help.outputArgName("targetPlatform", "<target_platform>");
		help.outputArgDesc("Target plaform may take one of the following values:"
				+ Arrays.toString(TargetPlatform.values())
				+ "\nFollowing are of source-target combinations supported:\n"
				+ SUPPORTED_PLATFORM_COMBINATIONS);
		
		help.outputArgName("targetVM", "<path_to_target_sdk>");
		help.outputArgDesc("This is the path to the target SDK that the "
				+ " multi-box Jlink image creator will use to "
				+ "create the cross-platform image."); 
		
		help.outputArgName("genDir", "<generation_directory>");
		help.outputArgDesc("This is the fully qualified path where the jlink image is to be created.");
	}
	
	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws Exception {
		StfTestArguments testArgs = test.env().getTestProperties("sourcePlatform","targetPlatform","targetVM","genDir");
		SourcePlatform sourcePlatform = testArgs.decodeEnum("sourcePlatform", SourcePlatform.class);
		TargetPlatform targetPlatform = testArgs.decodeEnum("targetPlatform", TargetPlatform.class);
		DirectoryRef targetJmodsDir = testArgs.getAsJvmHomeDirectory("targetVM").childDirectory("jmods");
		String genDir = testArgs.get("genDir");
		
		if ( new File(genDir).isDirectory() == false ) {
			throw new StfException("Invalid generation directory provided in parameter [genDir] : " + genDir);
		} 
		
		String imageDirName = genDir + System.getProperty("file.separator") + sourcePlatform.toString() + "_to_" + targetPlatform.toString(); 
		
		// Creating a modularized jar / jmod out of com.test.jlink.
		ModuleRef mainModuleMjar = test.doCreateModularJar("Create com.test.jlink jar", "openjdk.test.modularity/bin/tests/com.test.jlink");
		ModuleRef helloModuleMjar = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
	
		// Create the cross-platform runtime image using modules of the target 
		// sdk as well as the test modules
	    test.doRunJlink("Create cross-platform jlink image", 
					new JlinkDefinition()
					.addDirectoryToModulePath(targetJmodsDir)
					.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
					.addModuleToAddmods(helloModuleMjar)
					.setOutputDirectory(imageDirName));
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
