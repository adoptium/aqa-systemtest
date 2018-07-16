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

import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_OFF;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.DirectoryRef;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.test.modularity.*;

/*
 * User Story
 * ----------
 * As a developer I can run my application from any JRE by overriding a 
 * module using upgrademodulepath (modules - in either modular jar 
 * format or exploded directory). 
 * 
 * Use Cases
 * ---------
 * 1) Using an exploded module folder: 
 * 		1.1) Override an application module
 * 		1.2) Override an upgradable platform module. 
 * 		1.3) Override a non-upgradable platform module(Negative test) 
 * 		1.4) Override an application module using a custom runtime image
 * 		1.5) Override an upgradable platform module using a custom runtime image
 * 		1.6) Override a non-upgradable platform module using a custom runtime image(Negative test)
 * 
 * 2) Repeat above using modularized jar.
 * 		Note: Test (2.3) is specific to jarred tests -
 * 			"Override an upgradable applciation module using a non-modularized jar" 
 * 
 * */

/**
 * This STF automation plugin drives the Override tests using 
 * --upgrade-module-path option for Java 9 Modularity
 */
public class UpgradeModPathTest implements StfPluginInterface {
	
	/**
	 * Each of the values of the following enum corresponds to a particular test.
	 * In order to locally run a test from UpgradeModPathTest suite, provide its corresponding 
	 * enum value in the command line like: 
	 * 		stf.pl -test=UpgradeModPathTest -test-args="variant=<enum_value_of_test>" 
	 * */
	public enum Variant { 
		ExpDirModUpgrade, 
		ExpDirModUpgradeCRImage,
		JarredModUpgrade, 
		JarredModUpgradeCRImage
	};
	
	ModuleRef helloOverrideModule = null;
	ModuleRef txnOverrideModule = null;
	ModuleRef loggingOverrideModule = null;
	
	public void help(HelpTextGenerator help) {
		help.outputSection("Override test with upgrademodulepath");
		help.outputText("This test verifies various module overriding "
				+ "behaviors using --upgrade-module-path option");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
	    DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");
	    
		ModuleRef helloModule = test.doCreateModularJar("Create com.hello jar", "openjdk.test.modularity/bin/common-mods/com.hello");
		ModuleRef holaModule = test.doCreateModularJar("Create com.hola jar",     "openjdk.test.modularity/bin/common-mods/com.hola");
		ModuleRef helperModule = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.helper");
	    ModuleRef discreetModule = test.doCreateModularJar("Create com.discreet jar", "openjdk.test.modularity/bin/common-mods/com.discreet");
		ModuleRef testModule = test.doCreateModularJar("Create tests jar", "openjdk.test.modularity/bin/tests/com.test");
		FileRef javaTransactionNonModJar = test.doCreateProjectJar("create non-modularized java.transaction.jar",   
												"openjdk.test.modularity/bin/common-override/java.transaction", "javax");
		
		DirectoryRef runtimeImage = test.doRunJlink("Create runtime image for "
				+ "upgrademodulepath test", 
	    		new JlinkDefinition()
    				.addDirectoryToModulePath(jmodsDir)		 // Make sure java.base, etc, are available
	    			.addModuleToModulePath(helloModule, holaModule, testModule, helperModule, discreetModule)
	    			.addModuleToAddmods(helloModule, holaModule, testModule, helperModule, discreetModule)
	    			.setOutput("UpJVM"));
		
		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);
		
		switch (variant) {
			/********************************************
			 * 1) The following tests pertain to overriding 
			 * using an exploded module folder 
			 * ******************************/
			case ExpDirModUpgrade : 
				/*1.1) Override an application module*/
				test.doRunForegroundProcess("Override an application module", "OT11", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/com.hello")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule")
						);
				
				/*1.2) Override an upgradable platform module*/
				test.doRunForegroundProcess("Override an upgradable platform module", "OT12", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/java.transaction")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingUpgradablePlatformModule")
						);
				
				/*1.3) (Negative test) Override a non-upgradable platform module */
				StfProcess ot13 = test.doRunForegroundProcess("(Negative test) Override a non-upgradable platform "
						+ "module", "OT13", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/java.logging")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingNonUpgradablePlatformModule")
						);
				
				/*Note: This behavior is slightly different in OpenJDK in that, we get a 
				 * java.lang.module.FindException in stdout in OpenJDK, 
				 * whereas in OpenJ9, we get a java/lang/module/FindException in stderr.
				 * So, to make the test compatible with both OpenJDK and OpenJ9
				 * we must combine both stdout and stderr and look for a common error message string that 
				 * indicates the expected failure*/			
				String combinedFileOT13 = test.env().getResultsDir().getSpec() + System.getProperty("file.separator") + "combinedOT13.txt";
				test.doRunForegroundProcess("Combine stderr and stdout files of process OT13", "CO", 
						ECHO_OFF, ExpectedOutcome.exitValue(0).within("30s"), 
						test.createJavaProcessDefinition()
							.addJvmOption("-Dfile1=" + ot13.getStdoutFileRef())
							.addJvmOption("-Dfile2=" + ot13.getStderrFileRef())
							.addJvmOption("-Dfinal.file=" + combinedFileOT13)
							.addProjectToClasspath("stf.core")
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(TestUtil.class));
				
				test.doCountFileMatches("Check output", 
						test.env().getResultsDir().childFile("combinedOT13.txt"), 1, "FindException: Unable to compute the hash of module java.logging");
				
				
				break;
				
			case ExpDirModUpgradeCRImage : 
				
				/*1.4) Override an application module using a custom runtime image*/
				test.doRunForegroundProcess("Override an application module "
						+ "using a custom runtime image", "OT14", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
						.addRunImage(runtimeImage)  
						.addModuleAddReads("com.test=ALL-UNNAMED")
						.addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/com.hello")
						.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
						.runClass(org.junit.runner.JUnitCore.class)
						.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule")
					);

				/*1.5) Override an upgradable platform module using a custom runtime image*/
				test.doRunForegroundProcess("Override an upgradable platform module "
						+ "using a custom runtime image", "OT15", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addRunImage(runtimeImage) 
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/java.transaction")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingUpgradablePlatformModule")
						);
				
				/*1.6) (Negative test) Override a non-upgradable platform module using a custom runtime image*/ 
				StfProcess ot16 = test.doRunForegroundProcess("(Negative test) Override a non-upgradable platform "
						+ "module using a custom runtime image", "OT16", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
							test.createJavaProcessDefinition()
							.addRunImage(runtimeImage)  
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addModuleToUpgradeModulepath("openjdk.test.modularity/bin/common-override/java.logging")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingNonUpgradablePlatformModule")
						);
				
				/*Note: This behavior is slightly different in OpenJDK in that, we get a 
				 * java.lang.module.FindException in stdout in OpenJDK, 
				 * whereas in OpenJ9, we get a java/lang/module/FindException in stderr.
				 * So, to make the test compatible with both OpenJDK and OpenJ9
				 * we must combine both stdout and stderr and look for a common error message string that 
				 * indicates the expected failure*/			
				String combinedFileOT16 = test.env().getResultsDir().getSpec() + System.getProperty("file.separator") + "combinedOT16.txt";
				test.doRunForegroundProcess("Combine stderr and stdout files of process OT16", "CO", 
						ECHO_OFF, ExpectedOutcome.exitValue(0).within("5m"), 
						test.createJavaProcessDefinition()
							.addJvmOption("-Dfile1=" + ot16.getStdoutFileRef())
							.addJvmOption("-Dfile2=" + ot16.getStderrFileRef())
							.addJvmOption("-Dfinal.file=" + combinedFileOT16)
							.addProjectToClasspath("stf.core")
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(TestUtil.class));
				
				test.doCountFileMatches("Check output", 
						test.env().getResultsDir().childFile("combinedOT16.txt"), 1, "FindException: Unable to compute the hash of module java.logging");
				
				break;

			/********************************************
			 * The following tests pertain to overriding 
			 * using modularized jar 
			 * ******************************/
				
			case JarredModUpgrade :
				
				/*2.1) Override an application module*/
				intializeOverrideModuleJars(test);
				test.doRunForegroundProcess("Override an application module using "
						+ "modularized jar", "OT21", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addFileToUpgradeModulepath(helloOverrideModule.getJarFileRef())
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule")
						);
				
				/*2.2) Override an upgradable platform module*/
				intializeOverrideModuleJars(test);
				test.doRunForegroundProcess("Override an upgradable platform module"
						+ "where the overriding module is in a modularized jar", "OT22", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addFileToUpgradeModulepath(txnOverrideModule.getJarFileRef())
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit."
									+ "TestOverrideUsingUpgradablePlatformModule")
						);
				
				/*2.3) Override an upgradable platform module using a non-modularized jar*/
				test.doRunForegroundProcess("Override an upgradable platform module"
						+ "using a non-modularized jar", "OT23", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addFileToUpgradeModulepath(javaTransactionNonModJar)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit."
									+ "TestOverrideUsingPlatformModuleInRegularJar")
						);
					
				/*2.4) (Negative test) Override a non-upgradable platform module */
				intializeOverrideModuleJars(test);
				StfProcess ot24 = test.doRunForegroundProcess("(Negative test) Override a "
						+ "non-upgradable platform module where the overriding module "
						+ "is in a modularized jar", "OT24", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
							test.createJavaProcessDefinition()
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addModuleToModulepath("openjdk.test.modularity/bin/common-mods")
						    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
						    .addRootModule("com.test")
						    .addFileToUpgradeModulepath(loggingOverrideModule.getJarFileRef())
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit."
									+ "TestOverrideUsingNonUpgradablePlatformModule")
						);
				
				/*Note: This behavior is slightly different in OpenJDK in that, we get a 
				 * java.lang.module.FindException in stdout in OpenJDK, 
				 * whereas in OpenJ9, we get a java/lang/module/FindException in stderr.
				 * So, to make the test compatible with both OpenJDK and OpenJ9
				 * we must combine both stdout and stderr and look for a common error message string that 
				 * indicates the expected failure*/			
				String combinedFileOT24 = test.env().getResultsDir().getSpec() + System.getProperty("file.separator") + "combinedOT24.txt";
				test.doRunForegroundProcess("Combine stderr and stdout files of process OT24", "CO", 
						ECHO_OFF, ExpectedOutcome.exitValue(0).within("30s"), 
						test.createJavaProcessDefinition()
							.addJvmOption("-Dfile1=" + ot24.getStdoutFileRef())
							.addJvmOption("-Dfile2=" + ot24.getStderrFileRef())
							.addJvmOption("-Dfinal.file=" + combinedFileOT24)
							.addProjectToClasspath("stf.core")
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(TestUtil.class));
				
				test.doCountFileMatches("Check output", 
						test.env().getResultsDir().childFile("combinedOT24.txt"), 1, "FindException: Hash of java.logging");
				 
				break;
				
			case JarredModUpgradeCRImage :
				
				/*2.5) Override an application module using a custom runtime image*/
				intializeOverrideModuleJars(test);
				test.doRunForegroundProcess("Override an application module using a "
						+ "custom runtime image where the overriding module is "
						+ "in a modularized jar", "OT25", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
						test.createJavaProcessDefinition()
						.addRunImage(runtimeImage)  
						.addModuleAddReads("com.test=ALL-UNNAMED")
						.addFileToUpgradeModulepath(helloOverrideModule.getJarFileRef())
						.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
					    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
						.runClass(org.junit.runner.JUnitCore.class)
						.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule")
					);

				/*2.6) Override an upgradable platform module using a custom runtime image*/
				intializeOverrideModuleJars(test);
				test.doRunForegroundProcess("Override an upgradable platform module "
						+ "using a custom runtime image "
						+ "where the overriding module is in a modularized jar", "OT26", 
						ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
							test.createJavaProcessDefinition()
							.addRunImage(runtimeImage) 
							.addModuleAddReads("com.test=ALL-UNNAMED")
						    .addFileToUpgradeModulepath(txnOverrideModule.getJarFileRef())
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit."
									+ "TestOverrideUsingUpgradablePlatformModule")
						);

				/*2.7) (Negative test) Override a non-upgradable platform module using a 
				 * custom runtime image*/ 
				intializeOverrideModuleJars(test);
				StfProcess ot27 = test.doRunForegroundProcess("(Negative test) Override a "
						+ "non-upgradable platform module using a custom runtime image"
						+ "where the overriding module is in a modularized jar", "OT27", 
						ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
							test.createJavaProcessDefinition()
							.addRunImage(runtimeImage)  
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addFileToUpgradeModulepath(loggingOverrideModule.getJarFileRef())
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
						    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit."
									+ "TestOverrideUsingNonUpgradablePlatformModule")
						);
				
				/*Note: This behavior is slightly different in OpenJDK in that, we get a 
				 * java.lang.module.FindException in stdout in OpenJDK, 
				 * whereas in OpenJ9, we get a java/lang/module/FindException in stderr.
				 * So, to make the test compatible with both OpenJDK and OpenJ9
				 * we must combine both stdout and stderr and look for a common error message string that 
				 * indicates the expected failure*/			
				String combinedFileOT27 = test.env().getResultsDir().getSpec() + System.getProperty("file.separator") + "combinedOT27.txt";
				test.doRunForegroundProcess("Combine stderr and stdout files of process OT27", "CO", 
						ECHO_OFF, ExpectedOutcome.exitValue(0).within("30s"), 
						test.createJavaProcessDefinition()
							.addJvmOption("-Dfile1=" + ot27.getStdoutFileRef())
							.addJvmOption("-Dfile2=" + ot27.getStderrFileRef())
							.addJvmOption("-Dfinal.file=" + combinedFileOT27)
							.addProjectToClasspath("stf.core")
							.addProjectToClasspath("openjdk.test.modularity")
							.runClass(TestUtil.class));
				
				test.doCountFileMatches("Check output", 
						test.env().getResultsDir().childFile("combinedOT27.txt"), 1, "FindException: Hash of java.logging");
				
				break;
		}
	}
		
	public void tearDown(StfCoreExtension test) throws StfException {
	}
	
	/**
	 * This helper method is used by the jar version of the override tests
	 * as we can not create these modular jars up front since that will 
	 * lead to duplicate generated modules. 
	 */
	private void intializeOverrideModuleJars(StfCoreExtension test) throws StfException {
		if (helloOverrideModule == null) {
			helloOverrideModule = test.doCreateModularJar("Create com.hello override jar", 
					"openjdk.test.modularity/bin/common-override/com.hello");
			}

		if (txnOverrideModule == null) {
			txnOverrideModule = test.doCreateModularJar("Create java.transaction override jar", 
					"openjdk.test.modularity/bin/common-override/java.transaction");
		}
				
		if (loggingOverrideModule == null) {	
			loggingOverrideModule = test.doCreateModularJar("Create com.hello override jar", 
				"openjdk.test.modularity/bin/common-override/java.logging");
		}
	}
}
