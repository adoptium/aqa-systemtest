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

import java.io.File;
import java.io.*;
import org.junit.*;
import org.junit.runner.*;

/**
 * 
 * User Story
 * ----------
 * 1) As a Java product developer I can create a custom java runtime image with the required 
 *    modules (modules - in either .jmod or modular jar format), resources and libraries.
 * 2) As a Java product developer I can create a custom java runtime image with application 
 *    module on modulepath, some of the system modules from the JRE using --limit-modules or --add-modules 
 *    (modules - in either .jmod or modular jar format). 
 * 
 * Use cases
 * ---------
 * 1) Custom java runtime image with the required modules (modules - in either .jmod or modular 
 *    jar format), resources and libraries:
 * 		1.1) Create custom image with modules as modular jars
 *		1.2) Create custom image with modules as jmods
 *		1.3) Create custom image with modules as exploded directories
 *		1.4) Create custom image with modules as modular jars and has a dependency on a type from modulepath
 * 2) Custom java runtime image with --add-modules and --limit-modules:
 *		2.1) Create custom image with only application module in both --add-modules and --limit-modules
 *		2.2) Create custom image with only application module in --add-modules and set --limit-modules to 
 *			 the dependency of application module and a module from SDK
 *		2.3) Create custom image with only application module in --add-modules and set --limit-modules to java.base
 *		2.4) Create custom image with application module and a module from SDK in --add-modules and 
 *			 set --limit-modules to application module
 */

public class JlinkTest implements StfPluginInterface {
	
	private ModuleRef mainModuleMjar;
	private ModuleRef helloModuleMjar;
	private ModuleRef mainModuleJmod;
	private ModuleRef helloModuleJmod;
	private DirectoryRef nativeDir; 
	
	/**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from JlinkTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=JlinkTest -test-args="variant=<enum_value_of_test>" 
	 * */
	public enum Variant { 
		ReqdMod,
		AddMLimitM
	};
	
	public void help(HelpTextGenerator help) {
		help.outputSection("Custom runtime test");
		help.outputText("This test aims at creating custom runtime "
				+ "images and run the test using the image.");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
	
	public void setUp(StfCoreExtension test) throws StfException {
		
		DirectoryRef jLinkDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink");
		DirectoryRef confDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink/conf");
		nativeDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests/com.test.jlink/native/bin/" + test.env().getPlatformSimple());
		DirectoryRef helloDir = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods/com.hello");
		
		/*Creating a modularized jar / jmod out of com.test.jlink.*/ 
		 
		 /*com.test.jlink has native files which are not required, so 
		 * creating a copy where the unwanted folders are removed.*/
		DirectoryRef jLinkDirCopy = test.doCpDir("Copying com.test.jlink", jLinkDir, 
				test.env().getTmpDir().childDirectory("../com.test.jLinkDirCopy"));
		
		/*Removing the native folder from com.test.jlink*/
		test.doRm("Removing natives folder from com.test.jLinkDirCopy", 
				jLinkDirCopy.childDirectory("native"));
		
		/* The resulting jars will be written to the result dir 
		 * set in the beginning of the run.*/
		mainModuleMjar = test.doCreateModularJar("Create com.test.jlink jar", "openjdk.test.modularity/bin/tests/com.test.jlink");
		helloModuleMjar = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
		
		test.doValidateFileExists("Check com.test.jlink modular jar created", mainModuleMjar.getJarFileRef());
		test.doValidateFileExists("Check com.hello modular jar created", helloModuleMjar.getJarFileRef());
		
		/*Removing the conf folder from com.test.jlink*/
		test.doRm("Removing conf folder from com.test.jLinkDirCopy", jLinkDirCopy.childDirectory("conf"));

		/* We need to pass <arch>/*.so as input to --lib in jmod. 
		 * This is required only for non-windows platforms.*/
		
		/*Creating the <arch>/*.so structure*/ 
		if ( ! test.env().getPlatform().contains("win_x86") ) {
			DirectoryRef nativeDirCopy = test.doCpDir("Copying .so from com.test.jlink/native", nativeDir, 
								test.env().getTmpDir().childDirectory("../native/"));
			nativeDir = test.env().getTmpDir().childDirectory("../native/");
		}
		
		/*This is equivalent to running the command:
		  		 jmod create --class-path <> --config <> --libs <> <jmod-file>*/
		mainModuleJmod = test.doCreateJmod("Creating jmod of com.test.jlink module",
							new JmodDefinition()
							.doJmodCreate("com.test.jlink.jmod")
							.addDirectoryToClassPath(jLinkDirCopy)
							.addDirectoryToConfigPath(confDir)
							.addDirectoryToLibsPath(nativeDir) );
		
		/*This is equivalent to running the command:
				jmod create --class-path <> <jmod-file>*/		
		helloModuleJmod = test.doCreateJmod("Creating jmod for com.hello module",
							new JmodDefinition()
							.doJmodCreate("com.hello.jmod")
							.addDirectoryToClassPath(helloDir) );
		
		test.doValidateFileExists("Check com.test.jlink jmod created", mainModuleJmod.getJarFileRef());
		test.doValidateFileExists("Check com.hello jmod created", helloModuleJmod.getJarFileRef());	
	}

	public void execute(StfCoreExtension test) throws Exception {
		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		int javaVersion = test.env().primaryJvm().getJavaVersion();
	    DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
	    
	    // For JDK 16+, jlink error message to report unsupported class file format
	    // prints an additional exception trace, resulting in an error message we are 
	    // looking for in the log to now appear twice (for JDK 16+), instead of once. 
	    int jlinkErrMessageCount = 1; 
	    if (javaVersion > 15 ) {
	    	jlinkErrMessageCount = 2; 
	    }
		
		switch (variant) {
			case ReqdMod :
				/******** 
				 * Usecase 1: As a Java product developer I can create a custom java runtime image 
				 * with the required modules (modules - in either .jmod or modular jar format), 
				 * resources and libraries.
				 ********/
				
				/** 
				 * Testcase 1.1 - Package com.test.jlink and com.hello into a modular jar
				 * Testcase 1.4 - com.test.jlink depends on com.hello and uses a type from com.hello
				 */
			    // Create a runtime image using jlink. 
			    DirectoryRef runtimeImage = test.doRunJlink("Create runtime image", 
												new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
												.addModuleToAddmods(mainModuleMjar)
												.setOutput("CRI1"));
				
				// Run the listmods to check if the desired modules are present
				String[] expectedModules = {"com.hello", "com.test.jlink", "java.base"};
				listModsWithCustomImage(test, runtimeImage, expectedModules);
		
				// Now run the test using custom image
				runTestWithCustomImage(test, runtimeImage,"adoptopenjdk.test.modularity.jlink.PropertyReadTest", "T1");
		
				/**
				 * Testcase 1.2 - Package com.test.jlink and com.hello as jmods
				 */
				 
				// Create a runtime image using jlink
				runtimeImage = test.doRunJlink("Create runtime image", 
												new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleJmod, helloModuleJmod)
												.addModuleToAddmods(mainModuleJmod)
												.setOutput("CRI2"));
		
				// Run the listmods to check if the desired modules are present
				expectedModules = new String[]{"com.hello", "com.test.jlink", "java.base"};
				listModsWithCustomImage(test, runtimeImage, expectedModules);
		
				// Now run the test using custom image
				runTestWithCustomImage(test, runtimeImage,
						"adoptopenjdk.test.modularity.jlink.JniTest", "T2");
				
				/**
				 *  Testcase 1.3 
				 */
				// Create a runtime image using jlink from exploded dirs
				DirectoryRef commonModsDir = test.env().findTestDirectory("openjdk.test.modularity/bin/common-mods");
				DirectoryRef testsDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests");
				ModuleRef mainModule = new ModuleRef("com.test.jlink", null);
				
				// Create a runtime image using jlink
				runtimeImage = test.doRunJlink("Create runtime image", 
												new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addDirectoryToModulePath(commonModsDir, testsDir)
												.addModuleToAddmods(mainModule)
												.setOutput("CRI3"));
				
				// Run the listmods to check if the desired modules are present
				expectedModules = new String[]{"com.hello", "com.test.jlink", "java.base"};
				listModsWithCustomImage(test, runtimeImage, expectedModules);
		
				// Now run the test using custom image
				runTestWithCustomImage(test, runtimeImage,
						"adoptopenjdk.test.modularity.jlink.PropertyReadTest", "T3");
				
			break; 
			
			case AddMLimitM : 
		
				/******** 
				 * Usecase 2: As a Java product developer I can create a custom java runtime 
				 * image with application module on modulepath, some of the system modules 
				 * from the JRE using --limit-modules or --add-modules (modules - in either .jmod or modular jar format)
				********/
				
				/** 
				 * Testcase 2.1
				 */
				runtimeImage = test.doRunJlink("Create runtime image", 
												new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
												.addModuleToAddmods(mainModuleMjar)
												.addModuleToLimitmods(mainModuleMjar)
												.setOutput("CRI4"));
				
				// Run the listmods to check if the desired modules are present
				expectedModules = new String[]{"com.hello", "com.test.jlink"};
				listModsWithCustomImage(test, runtimeImage, expectedModules);
		
				// Now run the test using custom image
				runTestWithCustomImage(test, runtimeImage,
						"adoptopenjdk.test.modularity.jlink.PropertyReadTest", "T4");
				
				/** 
				 * Testcase 2.2
				 */
				ModuleRef javaSql = new ModuleRef("java.sql", null);
				runtimeImage = test.doRunJlink("Create runtime image", 
												new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
												.addModuleToAddmods(mainModuleMjar, javaSql)
												.addModuleToLimitmods(mainModuleMjar)
												.addModuleToLimitmods(helloModuleMjar)
												.addModuleToLimitmods(javaSql)
												.setOutput("CRI5"));
				
				// Run the listmods to check if the desired modules are present
				expectedModules = new String[]{"com.hello", "com.test.jlink", "java.base", "java.sql", "java.logging", "java.xml"};
				listModsWithCustomImage(test, runtimeImage, expectedModules);
		
				// Now run the test using custom image
				runTestWithCustomImage(test, runtimeImage,"adoptopenjdk.test.modularity.jlink.PropertyReadTest", "T5");
		
				/**
				 *  Testcase 2.3
				 */
				ModuleRef javaBase = new ModuleRef("java.base", null);
				JlinkDefinition jlinkDefinition = new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
												.addModuleToAddmods(mainModuleMjar)
												.addModuleToLimitmods(javaBase)
												.setOutput("CRI6");
				
				StfProcess process = test.doRunForegroundProcess("Run jlink command", "JLNK", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("2m"), jlinkDefinition);
				
				test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, 
						"Error: Module com.hello not found, required by com.test.jlink");
				
				/** 
				 * Testcase 2.4
				 */
				jlinkDefinition = new JlinkDefinition()
												.addDirectoryToModulePath(jmodsDir)
												.addModuleToModulePath(mainModuleMjar, helloModuleMjar)
												.addModuleToAddmods(javaSql, mainModuleMjar)
												.addModuleToLimitmods(mainModuleMjar)
												.setOutput("CRI6");
				
				process = test.doRunForegroundProcess("Run jlink command", "JLNK", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("2m"), jlinkDefinition);
				
				test.doCountFileMatches("Check output", process.getStdoutFileRef(), 
						jlinkErrMessageCount, "not found, required by java.sql");	
				
			break;
		}
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
	
	public void listModsWithCustomImage(StfCoreExtension test, DirectoryRef runtimeImage, String[] 
					expectedModules) throws StfException {
		JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition()
			.addRunImage(runtimeImage)  // Use this image instead of $JAVA_HOME/bin/java
			.addArg("--list-modules");
		
		StfProcess process = test.doRunForegroundProcess("Running listmods", "LIST", ECHO_ON, 
				ExpectedOutcome.cleanRun().within("1m"), javaProcessDefinition);
		
		// Look for the presence of expected modules in the stderr
		for (String moduleName : expectedModules) {
			test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, moduleName);
		}
	}
	
	public void runTestWithCustomImage(StfCoreExtension test, DirectoryRef runtimeImage, String 
			testName, String shortName) throws StfException {
		JavaProcessDefinition javaProcessDefinition = test.createJavaProcessDefinition()
			.addRunImage(runtimeImage)  // Use this image instead of $JAVA_HOME/bin/java
			.addJvmOption("-Djava.library.path="+nativeDir.getSpec())
			.addModuleAddReads("com.test.jlink=ALL-UNNAMED")
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
			.runClass(org.junit.runner.JUnitCore.class)
			.addArg(testName);
		
		String comment = "Running " + testName;
		test.doRunForegroundProcess(comment, shortName, ECHO_ON, 
				ExpectedOutcome.cleanRun().within("1m"), 
				javaProcessDefinition);
	}
}
