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

package net.adoptopenjdk.stf;

import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition;
import net.adoptopenjdk.stf.processes.definitions.LoadTestProcessDefinition;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;
/**
 * This is a test plugin that runs the Locker test alongside a mini-mix workload.
 * 
 * The Locker test was created to exercise lock contention against String and array objects. 
 */
public class LockingLoadTest implements StfPluginInterface {
	public void help(HelpTextGenerator help) throws StfException {
		help.outputSection("LockingLoadTest tests lock contention against String and array objects"
				+ "on a multithreaded environment.");
		help.outputText("");
	}

	public void pluginInit(StfCoreExtension stf) throws StfException {
	}

	public void setUp(StfCoreExtension test) throws StfException {
	}

	public void execute(StfCoreExtension test) throws StfException {
		String miniMixInventory = "/openjdk.test.load/config/inventories/mix/mini-mix.xml";
		String lockingInventory = "/openjdk.test.load/config/inventories/locking/locking.xml";
			
		LoadTestProcessDefinition loadTestInvocation = test.createLoadTestSpecification()
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.JUNIT)
				.addPrereqJarToClasspath(JavaProcessDefinition.JarId.HAMCREST)
				.addProjectToClasspath("openjdk.test.locking")
				.addProjectToClasspath("openjdk.test.lang")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.util")  // For mini-mix inventory
				.addProjectToClasspath("openjdk.test.math")  // For mini-mix inventory
				.setTimeLimit("30s")
				.addSuite("mini-mix")
				.setSuiteThreadCount(2)
				.setSuiteInventory(miniMixInventory)
				.setSuiteRandomSelection()
				.addSuite("locking")
				.setSuiteThreadCount(2)
				.setSuiteInventory(lockingInventory)
				.setSuiteRandomSelection();
		
		test.doRunForegroundProcess("Run locking load test", "LLT", Echo.ECHO_ON,
				ExpectedOutcome.cleanRun().within("35m"), 
				loadTestInvocation);
	}

	public void tearDown(StfCoreExtension stf) throws StfException {
	}
}