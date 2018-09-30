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
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.processes.definitions.JlinkDefinition;
import net.adoptopenjdk.test.modularity.PatchModuleTest.Variant;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_OFF;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.*;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/*
 * User Story
 * ----------
 * As a developer I can run my application from any JRE by replacing/adding 
 * some of the classes to the existing modules using patch-module option with a
 * custom runtime image.
 * 
 * Use Cases 
 * ---------
 * 1) Verify if we can Patch System modules using different file types (exploded dir or modular jar).
 * 2) Verify if we can Patch an Application module  using different file types (exploded dir or modular jar).
 * 
 * 3) (Negative test) Include a new package that is not exported and check if the public type can not be accessed.
 * 4) Include a new package that is not exported and check if the public type can be accessed by adding --add-exports.
 * 

 * 5) Verify if we can specify multiple file paths to a single --patch-module. 
 * 6) Verify if we can specify different file types (Files - can be existing class files, new 
 *    class files, new packages containing classes or resources, existing resource files) to --patch-module.  
 * 7) Verify if a module can be specified only once on --patch-module
 * 8) Verify if it doesn't allow to replace module-info.class
 * 
 */

/**
 * This STF automation plugin drives the Override tests using --patch-module
 * option in a custom runtime image, for Java 9 Modularity
 */
public class PatchModuleImageTest implements StfPluginInterface {

	public void help(HelpTextGenerator help) {
		help.outputSection("Override test with --patch-module");
		help.outputText("This test verifies various module overriding "
				+ "behaviors using --patch-module option in a custom runtime image");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		DirectoryRef jmodsDir = test.env().getJavaHome().childDirectory("jmods");

		ModuleRef helloModule = test.doCreateModularJar("Create com.hello jar",
				"openjdk.test.modularity/bin/common-mods/com.hello");
		ModuleRef holaModule = test.doCreateModularJar("Create com.hola jar",
				"openjdk.test.modularity/bin/common-mods/com.hola");
		ModuleRef helperModule = test.doCreateModularJar("Create com.helper jar",
				"openjdk.test.modularity/bin/common-mods/com.helper");
		ModuleRef discreetModule = test.doCreateModularJar("Create com.discreet jar",
				"openjdk.test.modularity/bin/common-mods/com.discreet");
		ModuleRef testModule = test.doCreateModularJar("Create tests jar", "openjdk.test.modularity/bin/tests/com.test");

		DirectoryRef overridingAppModuleExpDir_HelloNewModule = test.env()
				.findTestDirectory("openjdk.test.modularity/bin/common-override-new/com.hello");

		DirectoryRef runtimeImage = test
				.doRunJlink("Create runtime image for PatchModule test",
						new JlinkDefinition().addDirectoryToModulePath(jmodsDir)
								.addModuleToModulePath(helloModule, holaModule, testModule, helperModule,
										discreetModule)
								.addModuleToAddmods(helloModule, holaModule, testModule, helperModule, discreetModule)
								.setOutput("XpJVM"));

		ModuleRef overridingAppModuleJar_HelloModule = test.doCreateModularJar("Create com.hello jar",
				"openjdk.test.modularity/bin/common-override/com.hello");

		DirectoryRef overridingAppModuleExpDir_HelloModule = test.env()
				.findTestDirectory("openjdk.test.modularity/bin/common-override/com.hello");

		DirectoryRef overridingPlatformModuleExpDir_JavaTransaction = test.env()
				.findTestDirectory("openjdk.test.modularity/bin/common-override/java.transaction");

		ModuleRef overridingPlatformModuleJar_JavaTransaction = test.doCreateModularJar("create java.transaction.jar",
				"openjdk.test.modularity/bin/common-override/java.transaction");

		StfTestArguments testArgs = test.env().getTestProperties("variant");
		Variant variant = testArgs.decodeEnum("variant", Variant.class);

		switch (variant) {
		case PlatformModPatchModule:
			/**
			 * Test case 1.1) Verify if we can patch an upgradable platform
			 * module using exploded directory
			 */
			test.doRunForegroundProcess(
					"Verify if we can patch an upgradable platform " + "module using exploded directory", "OT11",
					ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("java.transaction", overridingPlatformModuleExpDir_JavaTransaction)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingUpgradablePlatformModule"));

			/**
			 * Test case 1.2) Verify if we can patch an upgradable platform
			 * module using modular jar
			 */
			test.doRunForegroundProcess("Verify if we can patch an upgradable " + "platform module using modular jar",
					"OT12", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("java.transaction", overridingPlatformModuleJar_JavaTransaction)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingUpgradablePlatformModule"));

			break;

		case AppModPatchModule:

			/**
			 * Test case 2.1) Verify if we can patch an Application module using
			 * exploded directory
			 */
			test.doRunForegroundProcess("Verify if we can patch an Application module " + "using exploded directory",
					"OT21", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleExpDir_HelloModule)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule"));

			/**
			 * Test case 2.2) Verify if we can patch an Application module using
			 * modular jar
			 */
			test.doRunForegroundProcess("Verify if we can patch an Application " + "module using modular jar", "OT22",
					ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleJar_HelloModule)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule"));
			break;

		case UnexportedTypePatchModule:

			/**
			 * Test case 3) (Negative test) Include a new package that is not
			 * exported and check if the public type cannot be accessed
			 */
			StfProcess ot3 = test.doRunForegroundProcess(
					"(Negative test) Include a new package that is not exported "
							+ "and check if the public type cannot be accessed",
					"OT3", ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleJar_HelloModule)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModuleAndNewPackage"));

			test.doCountFileMatches("Check output", ot3.getStdoutFileRef(), 1, "java.lang.IllegalAccessException");

			/**
			 * Test case 4) Include a new package that is not exported and check
			 * if the public type can be accessed by adding --add-exports
			 */
			test.doRunForegroundProcess(
					"Include a new package that is not exported "
							+ "and check if the public type can be accessed by adding --add-exports",
					"OT4", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleJar_HelloModule)
							.addAddExports("com.hello", "adoptopenjdk.test.modularity.hellonew", "com.test")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModuleAndNewPackage"));

			break;

		case AdvancedPatchModule:

			/**
			 * Test case (1) and (2) are implemented here, please see
			 * TestOverrideUsingMultipleFilePaths.java for details.
			 */
			test.doRunForegroundProcess(
					"Run application class override test "
							+ "where we specify two exploded module paths in a single --patch-module option",
					"OT1", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleExpDir_HelloModule,
									overridingAppModuleExpDir_HelloNewModule)
							.addAddExports("com.hello", "adoptopenjdk.test.modularity.newpkg", "com.test")
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingMultipleFilePaths"));

			/**
			 * Test case 7) Verify if a module can be specified only once on
			 * --patch-module
			 */
			StfProcess ot7 = test
					.doRunForegroundProcess("Verify if a module can be " + "specified only once on --patch-module",
							"OT7", ECHO_ON,
							ExpectedOutcome
									.exitValue(1).within(
											"1m"),
							test.createJavaProcessDefinition().addRunImage(runtimeImage)
									.addModuleAddReads("com.test=ALL-UNNAMED").disablePatchModuleAmalgamation()
									.addPatchModule("com.hello", overridingAppModuleExpDir_HelloNewModule)
									.addPatchModule("com.hello", overridingAppModuleExpDir_HelloModule)
									.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
									.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
									.runClass(org.junit.runner.JUnitCore.class)
									.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingAppModule"));
			
			/*Note: This behavior is slightly different in OpenJDK in that, we get a 
			 * java.lang.ExceptionInInitializerError in stdout in OpenJDK, 
			 * whereas in OpenJ9, we get a java.lang.ExceptionInInitializerError in stderr.
			 * So, to make the test compatible with both OpenJDK and OpenJ9
			 * we must combine both stdout and stderr and look for a common error message string that 
			 * indicates the expected failure*/			
			String combinedFileOT7 = test.env().getResultsDir().getSpec() + System.getProperty("file.separator") + "combinedOT7.txt";
			test.doRunForegroundProcess("Combine stderr and stdout files of process OT7", "CO", 
					ECHO_OFF, ExpectedOutcome.exitValue(0).within("30s"), 
					test.createJavaProcessDefinition()
						.addJvmOption("-Dfile1=" + ot7.getStdoutFileRef())
						.addJvmOption("-Dfile2=" + ot7.getStderrFileRef())
						.addJvmOption("-Dfinal.file=" + combinedFileOT7)
						.addProjectToClasspath("stf.core")
						.addProjectToClasspath("openjdk.test.modularity")
						.runClass(TestUtil.class));
			test.doCountFileMatches("Check output", 
					test.env().getResultsDir().childFile("combinedOT7.txt"), 1, "java.lang.ExceptionInInitializerError");
			
			/**
			 * Test case 8) (Negative test) Verify if --patch-module doesn't
			 * allow replacing of module-info.class.
			 * 
			 * This is verified by attempting to access a public type exported
			 * by the overriding module which is not exported by the original
			 * (overridden) module. Since module-info.java should not be allowed
			 * to be overridden, We expect to see an IllegalAccessError being
			 * generated.
			 */
			StfProcess ot8 = test.doRunForegroundProcess(
					"(Negative test) Verify if --patch-module " + "allows replacing of module-info.class", "OT8",
					ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"),
					test.createJavaProcessDefinition().addRunImage(runtimeImage)
							.addModuleAddReads("com.test=ALL-UNNAMED")
							.addPatchModule("com.hello", overridingAppModuleExpDir_HelloNewModule)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
							.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
							.runClass(org.junit.runner.JUnitCore.class)
							.addArg("net.adoptopenjdk.test.modularity.junit.TestOverrideUsingUnexportedPublicType"));

			test.doCountFileMatches("Check output", ot8.getStdoutFileRef(), 1, "java.lang.IllegalAccessException");

			break;
		}
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
