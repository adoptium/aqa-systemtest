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
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.util.StfDuration;
import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;

import java.io.File;
import java.util.ArrayList;

import org.junit.*;
import org.junit.runner.*;

/*
User Story : 

1) As a developer I can enable my application to make use of different service implementations/providers 
using the same service interface APIs

2) As a developer, I can use the service interface in my application module to resolve to the correct 
service provider when there are multiple service provider jars specified on the module path 
(service provider jars should be converted to automatic modules when specified on the modulepath)

3) As a developer, I can use the service interface in my application module to resolve to the correct 
service provider when there are multiple service provider jars  specified on the module path (provider1 - 
as exploded modules, provider2 - as modular jar, provider3 - regular jar with META_INF/services on 
modulepath) and classpath (provider 4 - regular jar with META_INF/services)
*/
public class SLTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) {
		help.outputSection("Service Loaders test");
		help.outputText("This test verifies if the ServiceLoader loads the providers specified on the modulepath as explicit modules modular jars, exploded modules, automatic modules and on classpath");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}
		
	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		ModuleRef provider1 = test.doCreateModularJar("Create modular jar displayServiceImpl1.jar", 
					"openjdk.test.modularity/bin/common-mods/displayServiceImpl1");
		String provider2 = "openjdk.test.modularity/bin/common-mods";
		FileRef provider3 = test.doCreateProjectJar("create project jar displayServiceImpl3.jar", 
					"openjdk.test.modularity/bin/common/displayServiceImpl3", null);
		FileRef provider4 = test.doCreateProjectJar("create project jar displayServiceImpl4.jar", 
					"openjdk.test.modularity/bin/common/displayServiceImpl4", null);
		
		JavaProcessDefinition junitProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleAddReads("com.test.serviceloaders=ALL-UNNAMED")
		    .addJarToModulepath(provider1.getJarFileRef())
		    .addModuleToModulepath(provider2)
		    .addModuleToModulepath("openjdk.test.modularity/bin/tests")
		    .addJarToModulepath(provider3)
		    .addRootModule("com.test.serviceloaders,displayService")
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
		    .addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
		    .addJarToClasspath(provider4)
		    .runClass(org.junit.runner.JUnitCore.class)
		    .addArg("adoptopenjdk.test.modularity.serviceloaders.TestServiceLoaders");
		String comment = "Run service loader test by adding the use of display service in module-info.java";
		test.doRunForegroundProcess(comment, "T1", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 		

		/*
		 * Temporarily exclude the failing service loader tests until 
		 * https://github.com/AdoptOpenJDK/openjdk-systemtest/issues/137 
		 * is resolved
		 * */
	    /*junitProcessDefinition = test.createJavaProcessDefinition()
		    .addModuleAddReads("com.test.serviceloaders2=ALL-UNNAMED")
		    .addJarToModulepath(provider1.getJarFileRef())
		    .addModuleToModulepath(provider2)
			.addModuleToModulepath("openjdk.test.modularity/bin/tests")
			.addJarToModulepath(provider3)
			.addRootModule("com.test.serviceloaders2,displayService")
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
			.addJarToClasspath(provider4)
			.runClass(org.junit.runner.JUnitCore.class)
			.addArg("adoptopenjdk.test.modularity.serviceloaders2.TestServiceLoaders2");
		comment = "Run serviceloader test2 with the test as an explicit module. "
				+ "It is same as test1, except that requires and uses"
				+ " are added through addReads() and addUses() through code "
				+ "instead of adding them into module-info.java";
		test.doRunForegroundProcess(comment, "T2", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 

		FileRef serviceTest = test.doCreateProjectJar("create project jar com.test.serviceloaders2.jar", 
				"openjdk.test.modularity/bin/tests/com.test.serviceloaders2", "adoptopenjdk");
		
	    junitProcessDefinition = test.createJavaProcessDefinition()
		    .addJarToModulepath(provider1.getJarFileRef())
		    .addModuleToModulepath(provider2)
			.addJarToModulepath(provider3)
			.addJarToModulepath(serviceTest)
			.addRootModule("com.test.serviceloaders2,displayService")
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
			.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
			.addJarToClasspath(provider4)
			.runClass(org.junit.runner.JUnitCore.class)
			.addArg("adoptopenjdk.test.modularity.serviceloaders2.TestServiceLoaders2");
		comment = "Run serviceloader test3 is same as test2 except that the TestServiceLoaders2 is in an automatic module";
		test.doRunForegroundProcess(comment, "T3", ECHO_ON, ExpectedOutcome.cleanRun().within("1m"), junitProcessDefinition); 	
		*/	
	}

	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
