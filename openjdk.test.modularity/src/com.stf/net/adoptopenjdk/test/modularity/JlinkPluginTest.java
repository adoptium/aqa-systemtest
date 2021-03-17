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
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JmodDefinition;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;

import java.util.Properties;

import java.io.File;
import java.io.*;
import org.junit.*;
import org.junit.runner.*;

/**
 * 
 * User story 4) 
 * ~~~~~~~~~~~~~
 * As a Java Product developer I can create a custom java runtime image using various 
 * jlink plugin options.
 * 
 * Use cases:
 * ~~~~~~~~~~~
 * Use case 4.1) Create Custom java runtime image (modules - in either .jmod or modular 
 * jar format or exploded directory ) using  jlink Option: 
 * 		--class-for-name (Plugin Name: class-for-name)
 * 
 * Use case 4.2) Create Custom java runtime image(modules - in either .jmod or modular jar format or exploded directory ) using  jlink Option: --compress=<0|1|2>[:filter=<pattern-list>] (Plugin Name:compress )
 * 		Usecase 4.1.1 Create Runtime image  using jmod format and add plugin ----compress=<0|1|2>[:filter=<pattern-list>] --class-for-name.
 * 		Usecase 4.1.2 Create Runtime image  using modular jar format add plugin  ----compress=<0|1|2>[:filter=<pattern-list>] --class-for-name
 * 		Usecase 4.1.3 Create Runtime image  using exploded directory add plugin  ----compress=<0|1|2>[:filter=<pattern-list>] --class-for-name.
 * 
 * 4.3) Create a custom runtime image(modules in .jar format) using jlink plugin option: --exclude-files
 * 		and ensure given pattern of files do not exist in the created image. 
 * 
 * 4.4) Create a custom runtime image(modules in exploded directory) with jlink plugin option : --strip-native-commands
 * 		and ensure native executable files do not exist in the created image. 
 * 
 * 4.5) Create a custom runtime image(modules in .jmod) with jlink plugin option : release-info
 * 		and ensure a given key,value pair exists in the release info file of the created image. 
 */

public class JlinkPluginTest implements StfPluginInterface {

   ModuleRef mainModuleMjar;
   ModuleRef helloModuleMjar;
   ModuleRef mainModuleJmod;
   ModuleRef helloModuleJmod;
   DirectoryRef jLinkDirCopy;
   DirectoryRef helloDir; 
   DirectoryRef jLinkDir;
   
   /**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from JlinkPluginOptionsTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=JlinkPluginOptionsTest -test-args="variant=<enum_value_of_test>" 
	 * */
	public enum Variant { 
		Compress,
		GenOpt
	};
	
	
   public void help(HelpTextGenerator help) {
      help.outputSection("Custom runtime test for jlink plugin options");
	  help.outputText("This test aims at creating custom runtime "
				+ "images using various plugin options"
				+ " and run the test using the image.");
   }

   public void pluginInit(StfCoreExtension test) throws StfException {
   }
	
   public void setUp(StfCoreExtension test) throws StfException {
      helloDir = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hello");
      jLinkDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink");
	  DirectoryRef confDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink/conf");
	  DirectoryRef nativeDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink/native/bin/" + test.env().getPlatformSimple());
	  
	  /*Creating a modularized jar / jmod out of com.test.jlink.*/ 
		 
      // com.test.jlink has native files which are not required, so 
	  // creating a copy where the unwanted folders are removed.
      jLinkDirCopy = test.doCpDir("Copying com.test.jlink", jLinkDir, 
				test.env().getTmpDir().childDirectory("../com.test.jLinkDirCopy"));
		
      // Removing the native folder from com.test.jlink 
      test.doRm("Removing natives folder from com.test.jLinkDirCopy", 
				jLinkDirCopy.childDirectory("native"));
		
      // Removing the conf folder from com.test.jlink
      test.doRm("Removing conf folder from com.test.jLinkDirCopy", jLinkDirCopy.childDirectory("conf"));

      /* The resulting jars will be written to the result dir 
       * set in the beginning of the run.*/
	  mainModuleMjar = test.doCreateModularJar("Create com.test.jlink jar", "openjdk.test.modularity/bin/tests/com.test.jlink");
	  helloModuleMjar = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
		
	  // Create jmod for main module for testing. This is equivalent to running the command:
	  //	  		 jmod create --class-path <> --config <> --libs <> <jmod-file>
      mainModuleJmod = test.doCreateJmod("Creating jmod of com.test.jlink module",
							new JmodDefinition()
							.doJmodCreate("com.test.jlink.jmod")
							.addDirectoryToClassPath(jLinkDirCopy)
							.addDirectoryToConfigPath(confDir)
							.addDirectoryToLibsPath(nativeDir) );
		
	  // Create jmods for hello module for testing. This is equivalent to running the command:
	  //			jmod create --class-path <> <jmod-file>		
      helloModuleJmod = test.doCreateJmod("Creating jmod for com.hello module",
							new JmodDefinition()
							.doJmodCreate("com.hello.jmod")
							.addDirectoryToClassPath(helloDir));
   }

   public void execute(StfCoreExtension test) throws Exception {
      DirectoryRef regularImage = null;
	  DirectoryRef runtimeImageCompressed = null; 
	  String[] expectedModules = null;
	  DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
	  StfTestArguments testArgs = test.env().getTestProperties("variant");
	  Variant variant = testArgs.decodeEnum("variant", Variant.class);
	  
	  switch (variant) {
	     case Compress :
	        /********  
	         * Use case 4.2 Create Custom java runtime image(modules - in either .jmod or modular 
	         * jar format or exploded directory ) using  jlink Option: --compress=<0|1|2>
	         ********/
				
		    // Create a regular runtime image using jlink without compress option first. 
		    regularImage = test.doRunJlink("Create runtime image", 
						new JlinkDefinition()
							.addDirectoryToModulePath(jmodsDir)
							.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
							.addModuleToAddmods(mainModuleMjar)
							.setOutput("CRI1"));
			
		    // Run the tests for each compression level: 
		    //         Level 0: constant string sharing
		    //         Level 1: ZIP 
		    //         Level 2: both
		    for (int i = 0 ; i < 3; i++) { 
			   // 4.2.1) Compress option test using jmods modules
			   runCompressOptionTest(test, regularImage, jmodsDir, "Jmod", "CR_CompressedLevel" + i + "_Jmod", 
					   "jd" + (i+1), helloModuleJmod, mainModuleJmod, null, null, i);
	
			   // 4.2.2) Compress option test using modular jar modules 
			   runCompressOptionTest(test, regularImage, jmodsDir, "Jar", "CR_CompressedLevel" + i + "_Jar", 
					   "jr" + (i+1), helloModuleMjar, mainModuleMjar, null, null, i);
	
			   // 4.2.3) Compress option test using exploded directory modules 
			   runCompressOptionTest(test, regularImage, jmodsDir, "Exploded Directory", "CR_CompressedLevel" + i + "_ExpDir", 
			 		   "xd" + (i+1), null, null, helloDir, jLinkDir, i);
		    } 
		  
		    // Delete the runtime image if the test passes  
		    test.doRm("Removing the image directory after test finished successfully..", regularImage);
	    
		 break;
	    
	     case GenOpt : 
	        		  
		    /********
		     * Usecase 4.3) Create a custom runtime image(modules in .jar format) using jlink plugin option: --exclude-files
		     * and ensure given pattern of files do not exist in the created image. 
		     */
		    DirectoryRef runtimeImageWithExcludeFiles = 
				  test.doRunJlink("Create runtime image using --exclude-files jlink option", 
					new JlinkDefinition()
						.addDirectoryToModulePath(jmodsDir)
						.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
						.addModuleToAddmods(mainModuleMjar)
						.setOutput("CR_ExclueFiles_Test")
						.addToExcludeFiles("**.policy*"));
		  
		    FileRef policyFileToCheck = runtimeImageWithExcludeFiles.childDirectory("conf/security").childFile("java.policy");
		  
		    test.doValidateFileAbsent("Check if --exclude-files removed the given files "
			  		+ "from created image", policyFileToCheck);
		  
		    // Delete the runtime image if the test passes
		    test.doRm("Removing the runtime image after test completion..", runtimeImageWithExcludeFiles); 
		  
		    /**********
		     * Usecase 4.4) Create a custom runtime image(modules in exploded directory) with jlink 
		     * plugin option : --strip-native-commands, and ensure native executable files do not exist 
		     * in the created image. 
		     */
		    ModuleRef mModule = new ModuleRef("com.test.jlink", null);
		    DirectoryRef runtimeImageWithoutNativeCommands = 
				  test.doRunJlink("Create runtime image using --strip-native-commands jlink option", 
					new JlinkDefinition()
						.addDirectoryToModulePath(jmodsDir)
						.addDirectoryToModulePath(helloDir, jLinkDirCopy)
						.addModuleToAddmods(mModule)
						.setOutput("CR_StripNativeCommand_Test")
						.enableStripNativeCommands());
		  
		    FileRef javaExecFileName = null; 
		  
		    if (test.env().getPlatform().contains("win_x86")) {
		       javaExecFileName = runtimeImageWithoutNativeCommands.childDirectory("bin").childFile("java.exe");
		    } else {
			   javaExecFileName = runtimeImageWithoutNativeCommands.childDirectory("bin").childFile("java");
		    }
		  
		    test.doValidateFileAbsent("Check if --strip-native-commands removed java executable "
		  		+ "from created image", javaExecFileName);
	
		    // Delete the runtime image if the test passes
		    test.doRm("Removing the runtime image after test completion..", runtimeImageWithoutNativeCommands); 
		  
		    /*****
		     * Usecase 4.5) Create a custom runtime image(modules in .jmod) with jlink plugin option: --release-info
		     * 	and ensure a given key,value pair exists in the release info file of the created image. 
		     */
		    DirectoryRef runtimeImageWithReleaseInfo = 
				  test.doRunJlink("Create runtime image using --releae-info jlink option", 
				  new JlinkDefinition()
						.addDirectoryToModulePath(jmodsDir)
						.addModuleToModulePath(mainModuleJmod, helloModuleJmod)
						.addModuleToAddmods(mainModuleJmod)
						.setOutput("CR_ReleaseInfo_Test")
						.addReleaseInfoProperty("UseYour", "Illusion"));	
		  
		    // Run junit test to ensure the given key,value pair exists in the 'release' file of the created image 
		    String jlinkReleaseInfoTest = "adoptopenjdk.test.modularity.jlink.JlinkPluginTestReleaseInfo"; 
		    test.doRunForegroundProcess("Running " + jlinkReleaseInfoTest, "T46", ECHO_ON, 
		   			ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
							.addJvmOption("-Drelease.info.file="+ runtimeImageWithReleaseInfo.childFile("release").getSpec())
							.addModuleAddReads("com.test.jlink=ALL-UNNAMED")
							.addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test.jlink")
					 		.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg(jlinkReleaseInfoTest));
		  
		    // Delete the runtime image if the test passes
	   	    test.doRm("Removing the runtime image after test completion..", runtimeImageWithReleaseInfo);
	   	 
	   	 break;
	  }
   }
	
   public void runCompressOptionTest(StfCoreExtension test, DirectoryRef regularImage, DirectoryRef jmodsDir,
			   String moduleFormatType, String imageName, String subProcessName, 
			   ModuleRef helloModule, ModuleRef mainModule, 
			   DirectoryRef helloModuleDir, DirectoryRef mainModuleDir, 
			   int copressLevel) throws StfException {
		   
	   // Create a runtime image using jlink with the given compress option first. 
	   JlinkDefinition compressedJlinkDef = new JlinkDefinition();
	   compressedJlinkDef.addDirectoryToModulePath(jmodsDir);
	   
	   if (helloModule != null && mainModule != null) {
		   compressedJlinkDef.addModuleToModulePath(helloModule, mainModule);   
		   compressedJlinkDef.addModuleToAddmods(mainModule);
	   } else if (helloModuleDir != null && mainModuleDir != null) {
		   compressedJlinkDef.addDirectoryToModulePath(helloModuleDir, mainModuleDir); 
		   ModuleRef mModule = new ModuleRef("com.test.jlink", null);
		   compressedJlinkDef.addModuleToAddmods(mModule);
	   }
		
	   compressedJlinkDef.setCompress(copressLevel);
	   compressedJlinkDef.setOutput(imageName);
		
	   DirectoryRef runtimeImageCompressed = test.doRunJlink("Create runtime image using modules in "
			   + moduleFormatType + " format", compressedJlinkDef);
			
	   // Prepare test java process definition 
	   String modulePathBefore = regularImage.childDirectory("lib").childFile("modules").getSpec();
	   String modulePathAfter = runtimeImageCompressed.childDirectory("lib").childFile("modules").getSpec();
	   String jvmOptionForModPathBefore = "-Dmodpath.before=" + modulePathBefore; 
	   String jvmOptionForModPathAfter = "-Dmodpath.after=" + modulePathAfter;
	   String testName = "adoptopenjdk.test.modularity.jlink.JlinkPluginTestCompress"; 
	   
	   JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition(); 
	   javaProcessDefinition.addRunImage(runtimeImageCompressed);  // Use this image instead of $JAVA_HOME/bin/java
	   javaProcessDefinition.addJvmOption(jvmOptionForModPathBefore);
	   javaProcessDefinition.addJvmOption(jvmOptionForModPathAfter);
	   javaProcessDefinition.addModuleAddReads("com.test.jlink=ALL-UNNAMED");
	   javaProcessDefinition.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT);
	   javaProcessDefinition.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST);
	   javaProcessDefinition.runClass(org.junit.runner.JUnitCore.class);
	   javaProcessDefinition.addArg(testName);
	
       // Now run the test to validate compression took place
	   test.doRunForegroundProcess("Running " + testName, subProcessName, ECHO_ON, 
					ExpectedOutcome.cleanRun().within("1m"), 
					javaProcessDefinition);
	   
	   // Delete the runtime image if the test passes
	   test.doRm("Removing the compressed runtime image after test completion", runtimeImageCompressed);
   }

   public void tearDown(StfCoreExtension test) throws StfException {
   }
}
