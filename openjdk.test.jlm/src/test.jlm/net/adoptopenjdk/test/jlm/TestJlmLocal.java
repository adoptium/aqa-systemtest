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

package net.adoptopenjdk.test.jlm;

import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/**
 * STF automation to drive a java.lang.management system test scenario 
 * where a JVM monitors itself via its platform MBeans using a local connection.
 */
public class TestJlmLocal implements StfPluginInterface {
	
	public void help(HelpTextGenerator help) {
		help.outputSection("JLM Local test");
		help.outputText("These tests exercise java.lang.management APIs "
				+ "with MBeans for the local JVM");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		JavaProcessDefinition localTestProcessDef = test.createJavaProcessDefinition()
			.addProjectToClasspath("openjdk.test.jlm")
			.addPrereqJarToClasspath(JarId.JUNIT)
			.runClass("net.adoptopenjdk.test.jlm.local.VMLogger")
			.addArg("jlmtestlocal.log");
		
		// Start a synchronous JVM process to drive the local JLM test 
		test.doRunForegroundProcess("Run JLM Local test", "TST", 
				ECHO_ON, ExpectedOutcome.cleanRun().within("5m"),
				localTestProcessDef);
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
