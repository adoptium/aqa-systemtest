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
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.ModuleRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.StfProcess;

import java.io.File;
import org.junit.*;
import org.junit.runner.*;

/**
 * User story: As a developer, I can convert a non-modularized third party library into 
 * an explicit modular jar by generating the module descriptor (using jdeps -genmodinfo) 
 * and editing it if required (to correct the dependencies and exports) and archiving it 
 * again into a modular jar (place the module descriptor - module-info.class at the root dir)
 */

public class ExplMod implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Explicit Modules test");
		help.outputText("This test verifies if non-modular jar can be used to run the apps by converting into explicit modules");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
		
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		FileRef junitPath = test.env().getJarLocation(JavaProcessDefinition.JarId.JUNIT);
		FileRef hamcrestPath = test.env().getJarLocation(JavaProcessDefinition.JarId.HAMCREST);
		
		String explicitModule_JunitJarName = "junit.jar";
		String explicitModule_HamcrestJarName = "hamcrest-core.jar";
		DirectoryRef testsDir = test.env().findTestDirectory("openjdk.test.modularity/bin/tests");
		
		// Create necessary modular jars 
		ModuleRef helloModularJar    = test.doCreateModularJar("Create com.hello jar",  "openjdk.test.modularity/bin/common-mods/com.hello");
	    ModuleRef helperModularJar   = test.doCreateModularJar("Create com.helper jar", "openjdk.test.modularity/bin/common-mods/com.helper");
	    ModuleRef holaModularJar     = test.doCreateModularJar("Create com.hola jar",   "openjdk.test.modularity/bin/common-mods/com.hola");
	    ModuleRef discreetModularJar = test.doCreateModularJar("Create com.discreet jar",   "openjdk.test.modularity/bin/common-mods/com.discreet");
		
	    // Create necessary automatic jars 
	    FileRef holaAutomaticJar   = test.doCreateProjectJar("create automatic jar for com.hola", "openjdk.test.modularity/bin/common-mods/com.hola", null, null, "module-info.class"); 
	    FileRef helperAutomaticJar   = test.doCreateProjectJar("create automatic jar for com.helper", "openjdk.test.modularity/bin/common-mods/com.helper", null, null, "module-info.class");
		
		// Copy the junit jar and hamcrest jar into temp folder, so that we can convert them into explicit modules.
		DirectoryRef junitCopy = test.env().getResultsDir().childDirectory("thirdpartyjar");
		test.doMkdir("Creating dir to copy junit jars", junitCopy);
		test.doCp("Copying junit jar", junitPath, junitCopy);
		test.doCp("Copying hamcrest jar", hamcrestPath, junitCopy);
		
		// Generate the module info for junit .jar and hamcrest jar by running jdeps command.
		// Running jdeps create one folder for each of the jar. So, we have junit and hamcrest.core created inside temp.
		String junitCopyDir = junitCopy.getSpec();
		test.doRunForegroundProcess("Running jdeps to generate module info", "JDEP", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("jdeps")	
						.addArg("--generate-module-info " + junitCopyDir + "  "  + junitCopyDir + "/*.jar"));
				
		// Change into the hamcrest.core directory inside temp and extract the  hamcrest jar as compiling module-info.java 
		// looks for the existence of packages. 
		test.doCd("Changing directory to thirdpartyjar/hamcrest.core", junitCopy.childDirectory("hamcrest.core") );
		test.doRunForegroundProcess("Extracting hamcrest jar", "JAR", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("jar")	
						.addArg("-xf " + junitCopy.childFile(explicitModule_HamcrestJarName).getSpec() ));
		
		// Compile the module-info.java generated for hamcrest jar and update the module-info.class in the jar file.
		test.doRunForegroundProcess("Compiling the module info", "JAVC", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("javac")
						.addArg("-d .")
						.addArg( junitCopy.childDirectory("hamcrest.core/module-info.java").getSpec() + "  "));
		
		// Update the module info in hamcrest jar with module info file
		test.doRunForegroundProcess("Updating the module info in hamcrest jar with generated module-info.class", "JAR", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("jar")	
						.addArg("-uf " + junitCopy.childFile(explicitModule_HamcrestJarName).getSpec()  + " module-info.class" ));
						
		// Change into the junit directory inside temp and extract the junit jar as compiling module-info.java looks for the existence of packages.
		test.doCd("Changing directory to thirdpartyjar/junit", junitCopy.childDirectory("junit") );
		test.doRunForegroundProcess("Extracting junit jar", "JAR", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("jar")	
						.addArg("-xf " + junitCopy.childFile(explicitModule_JunitJarName).getSpec() ));
		
		// Compile the module-info.java generated for junit.jar and update the module-info.class in the jar file.
		test.doRunForegroundProcess("Compiling the module info", "JAVC", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("javac")	
						.addArg("-d .")
						.addArg("--module-path " + junitCopy.childDirectory("hamcrest.core").getSpec() )
						.addArg( junitCopy.childDirectory("junit/module-info.java").getSpec() ));
		
		// Update the junit jar with generated module-info.java 
		test.doRunForegroundProcess("Updating the junit jar with generated module-info.class", "JAR", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
					test.createJDKToolProcessDefinition()
						.setJDKToolOrUtility("jar")	
						.addArg("-uf " + junitCopy.childFile(explicitModule_JunitJarName).getSpec() + " module-info.class" ));

		// Usecase: 1.1
		// Convert a non-modularized third party jar into an explicit module and verify if the application that uses it works fine.
		// Here, the test App is an explicit module. Junit jar, when converted to explicit module, provides implicit readability to 
		// hamcrest jar. The test App uses a type from hamcrest. The test App should not be able to read hamcrest via implicit readability, 
		// as both junit and hamcrest jars are non-standard modules.
		String moduleName = "com.test";
		String testName = "TestImpliedReadability";
		String testClass = "net.adoptopenjdk.test.modularity.junit." + testName;
		String comment = "Run " + testName;

		// Running com.test.TestImpliedReadaibility with junit jar and hamcrest jar as explicit modules.
		StfProcess process = test.doRunForegroundProcess(comment, "T1", ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
				test.createJavaProcessDefinition()
					 .addModuleAddReads("com.test=junit")
					 .addDirectoryToModulepath(testsDir)
					 .addJarToModulepath(helloModularJar.getJarFileRef())
					 .addJarToModulepath(discreetModularJar.getJarFileRef())
					 .addJarToModulepath(holaAutomaticJar)
					 .addJarToModulepath(helperAutomaticJar)
					 .addJarToModulepath(junitCopy.childFile(explicitModule_JunitJarName))
					 .addJarToModulepath(junitCopy.childFile(explicitModule_HamcrestJarName))
					 .addRootModule("com.test")
					 .addRootModule("com.hola")
					 .addRootModule("junit")
					 .addProjectToClasspath("openjdk.test.modularity")
					 .runClass(org.junit.runner.JUnitCore.class)
					 .addArg(testClass));
		// Look for IllegalAccessError in the stdout produced the expected output
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "java.lang.IllegalAccessError");
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "module com.test does not read module hamcrest.core");
		
		// Usecase: 1.2
		// Convert one of the non-modularized third party jar into an explicit module, another non-modularized 
		// third party jar into an automatic module and verify if the application that uses both these works fine.
		
		// Running com.test.TestImpliedReadaibility with junit jar as explicit module and hamcrest jar as automatic module.
		test.doRunForegroundProcess(comment, "T21", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
				test.createJavaProcessDefinition()
					 .addModuleAddReads("com.test=junit,hamcrest.core")
					 .addDirectoryToModulepath(testsDir)
					 .addJarToModulepath(helloModularJar.getJarFileRef())
					 .addJarToModulepath(discreetModularJar.getJarFileRef())
					 .addJarToModulepath(holaAutomaticJar)
					 .addJarToModulepath(helperAutomaticJar)
					 .addJarToModulepath(junitCopy.childFile(explicitModule_JunitJarName))
					 .addPrereqJarToModulePath(JarId.HAMCREST)
					 .addRootModule("com.test")
					 .addRootModule("com.hola")
					 .addRootModule("junit")
					 .addProjectToClasspath("openjdk.test.modularity")
					 .runClass(org.junit.runner.JUnitCore.class)
					 .addArg(testClass));
					 
		// Running com.test.TestImpliedReadaibility with junit jar as automatic modules and hamcrest jar as explicit modules.
		process = test.doRunForegroundProcess(comment, "T22", ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
				test.createJavaProcessDefinition()
					 .addModuleAddReads("com.test=junit")
					 .addDirectoryToModulepath(testsDir)
					 .addJarToModulepath(helloModularJar.getJarFileRef())
					 .addJarToModulepath(discreetModularJar.getJarFileRef())
					 .addJarToModulepath(holaAutomaticJar)
					 .addJarToModulepath(helperAutomaticJar)
					 .addPrereqJarToModulePath(JarId.JUNIT)
					 .addJarToModulepath(junitCopy.childFile(explicitModule_HamcrestJarName))
					 .addRootModule("com.test")
					 .addRootModule("com.hola")
					 .addRootModule("junit")
					 .addRootModule("hamcrest.core")
					 .addProjectToClasspath("openjdk.test.modularity")
					 .runClass(org.junit.runner.JUnitCore.class)
					 .addArg(testClass));
		
		// Look for IllegalAccessError in the stdout produced the expected output
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "java.lang.IllegalAccessError");
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "module com.test does not read module hamcrest.core");
					 
		// Usecase: 1.3
		// Convert one of the non-modularized third party jar into an explicit module, another 
		// non-modularized third party jar into an automatic module and place another one on classpath. 
		// Verify if the application that uses all these jars works fine.
		// The test App is an explicit module. Junit jar is on cp (junit jar depends on hamcrest jar). 
		// In the test App, a type from hamcrest is used. The test App should not be able to read hamcrest 
		process = test.doRunForegroundProcess(comment, "T3", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), 
				test.createJavaProcessDefinition()
					 .addModuleAddReads("com.test=ALL-UNNAMED")
					 .addDirectoryToModulepath(testsDir)
					 .addJarToModulepath(helloModularJar.getJarFileRef())
					 .addJarToModulepath(discreetModularJar.getJarFileRef())
					 .addJarToModulepath(holaAutomaticJar)
					 .addJarToModulepath(helperAutomaticJar)
					 .addPrereqJarToModulePath(JarId.HAMCREST)
					 .addRootModule("com.test")
					 .addRootModule("com.hola")
					 .addRootModule("hamcrest.core")
					 .addJarToClasspath(junitCopy.childFile(explicitModule_JunitJarName))
					 .addProjectToClasspath("openjdk.test.modularity")
					 .runClass(org.junit.runner.JUnitCore.class)
					 .addArg(testClass));
			 
		// Usecase: 1.4
		// The test app is an explicit module. junit jar is on cp (junit jar depends on hamcrest jar). 
		// The test app uses a type from hamcrest. The test app shouldn't be able to read hamcrest and hence throw an IllegalAccessError.
		// Running com.test.TestImpliedReadaibility with junit jar as unnamed module and hamcrest jar as explicit module.
		// Currently, the behavior is we are getting IllegalAccessError and is the expected one.
		process = test.doRunForegroundProcess(comment, "T4", ECHO_ON, ExpectedOutcome.exitValue(1).within("1m"), 
				test.createJavaProcessDefinition()
					 .addModuleAddReads("com.test=ALL-UNNAMED")
					 .addDirectoryToModulepath(testsDir)
					 .addJarToModulepath(helloModularJar.getJarFileRef())
					 .addJarToModulepath(discreetModularJar.getJarFileRef())
					 .addJarToModulepath(holaAutomaticJar)
					 .addJarToModulepath(helperAutomaticJar)
					 // Placing the explicit hamcrest jar in the mp makes it remain an 'explicit module' 
					 .addJarToModulepath(junitCopy.childFile(explicitModule_HamcrestJarName))
					 .addRootModule("com.test")
					 .addRootModule("com.hola")
					 .addRootModule("hamcrest.core")
					 // Placing the explicit junit jar in cp makes it an 'unnamed module' 
					 .addJarToClasspath(junitCopy.childFile(explicitModule_JunitJarName))
					 .addProjectToClasspath("openjdk.test.modularity")
					 .runClass(org.junit.runner.JUnitCore.class)
					 .addArg(testClass));
					 
		// Look for IllegalAccessError in the stdout produced the expected output
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "java.lang.IllegalAccessError");
		test.doCountFileMatches("Check output", process.getStdoutFileRef(), 1, "module com.test does not read module hamcrest.core");				 
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
