/*******************************************************************************

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.stf.jdi;

import static net.adoptopenjdk.stf.extensions.core.StfCoreExtension.Echo.ECHO_ON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.adoptopenjdk.test.jdi.debugger.Connectors;
import net.adoptopenjdk.test.jdi.targetvm.Simple;
import net.adoptopenjdk.stf.plugin.interfaces.StfPluginInterface;
import net.adoptopenjdk.stf.StfError;
import net.adoptopenjdk.stf.StfException;
import net.adoptopenjdk.stf.extensions.interfaces.StfExtension;
import net.adoptopenjdk.stf.environment.DirectoryRef;
import net.adoptopenjdk.stf.environment.FileRef;
import net.adoptopenjdk.stf.environment.JavaVersion;
import net.adoptopenjdk.stf.environment.StfTestArguments;
import net.adoptopenjdk.stf.extensions.core.StfCoreExtension;
import net.adoptopenjdk.stf.processes.ExpectedOutcome;
import net.adoptopenjdk.stf.processes.StfProcess;
import net.adoptopenjdk.stf.processes.definitions.JavaProcessDefinition.JarId;
import net.adoptopenjdk.stf.runner.modes.HelpTextGenerator;

/*
 * This test plugin is aimed at testing the Java Debugging Implementation API. 
 * 
 * It runs and checks the running of JDI tests. 
 * These tests involve creating a debugger and a target VM which can connect in several different ways,
 * this plugin automates the tests by starting and monitoring the relevant attaching or listening processes.
 * To do this it must process the appropriate information in each of the test specific property files and 
 * then spawn the appropriate processes.
 */
public class JdiTest implements StfPluginInterface {
	private enum Tests {
		// Tests			Mnemonic	Property File
		all_simple(			"ASI",		"all_simple.prop"), 
		basic_attach(		"BAT",		"basic_attach.prop"), 
		basic_launch(		"BLA",		"basic_launch.prop"), 
		basic_listen(		"BLI",		"basic_listen.prop"), 
		both_simple(		"BSI",		"both_simple.prop"), 
		many_objects(		"MOB",		"many_objects.prop"),
		many_threads(		"ATH",		"many_threads.prop"),
		simple_lau_att(		"SAT",		"simple_lau_att.prop"), 
		simple_lau_lis(		"SLL",		"simple_lau_lis.prop"), 
		simple_att_lau(		"SAT",		"simple_att_lau.prop"), 
		simple_launch(		"SLA",		"simple_launch.prop"),
		simple_lis_lau(		"SLL",		"simple_lis_lau.prop"), 
		single_attach(		"SIA",		"single_attach.prop"), 
		single_launch(		"SIN",		"single_launch.prop"), 
		single_listen(		"SIL",		"single_listen.prop");
		
		String mnemonic;
		String property;
		
		private Tests(String mnemonic, String property) {
			this.mnemonic = mnemonic;
			this.property = property;
		}
	}
	
	private enum Transport { 
		// Method of transport		Transport Option
		SHARED_MEM(					"dt_shmem"), 
		SOCKET(						"dt_socket");
		
		String option;
		
		Transport(String option){
			this.option = option;
		}
	};
	
	private static final int PROCESS_TIMEOUT = 300000;
	private DirectoryRef propertiesDir;
	private Properties props;
	
	public void help(HelpTextGenerator help) {
		help.outputSection("JdiTest");
		help.outputText("This test plugin runs a set of tests aimed at testing the Java Debugging Implementation API which facilitates debugging.\n");
	}

	public void pluginInit(StfCoreExtension test) throws StfException {
		// Define the location for the property files
		propertiesDir = test.env().getResultsDir().childDirectory("properties");
	}
	
	
	public void setUp(StfCoreExtension test) throws StfException {
		test.doMkdir("Create the properties directory", propertiesDir);
	}


	public void execute(StfCoreExtension core) throws StfException, IOException {
		// The trace options are IBM specific and not supported from IBM Java 9 onwards.
		String traceOptions = "";
		JavaVersion jvm = core.env().primaryJvm();
		
		if (jvm.isIBMJvm() && jvm.isJava8()) {
			traceOptions = ",trace=PROG+CMD+PACK+DATA";
		}

		// Run all tests by default but give the option to run a specific test, this is particularly useful for 
		// debugging/ development, also default the transport method to socket as shared memory is only valid for Windows
		StfTestArguments testArgs = core.env().getTestProperties("test=[All]", "transport=[SOCKET]");
		
		Tests[] tests = null;
		if (testArgs.get("test").equals("All")) {
			tests = Tests.values();
		} else {
			tests = new Tests[]{testArgs.decodeEnum("test", Tests.class)};
		}
		
		Transport transport = testArgs.decodeEnum("transport", Transport.class);
		if (transport == Transport.SHARED_MEM && !core.env().getPlatform().contains("win")) {
			throw new StfError("The shared memory transport method is only valid for Windows.");
		}

		FileRef toolsJar = core.env().getJavaHome().childFile("/lib/tools.jar"); 
		DirectoryRef projectBin = core.env().findTestDirectory("openjdk.test.debugging/bin");
		DirectoryRef projectProperties = core.env().findTestDirectory("openjdk.test.debugging/src/test.debugging/net/adoptopenjdk/test/jdi/properties");
		
		for (Tests test : tests) {
			// Define the local test property file
			FileRef propertyFile = projectProperties.childFile(test.property);

			// Copy the property file to results
			core.doCp("Copy " + test.property + " to results", propertyFile, propertiesDir);

			// Load the properties from the property file
			loadProperties(propertyFile);
			
			// Start the connector process which creates a connection between a target VM and a debugger
			StfProcess connector = core.doRunBackgroundProcess("Starting " + test.name() + " Connectors process", 
					test.mnemonic + "C", 
					ECHO_ON, 
					ExpectedOutcome.cleanRun().within("30m"),
					core.createJavaProcessDefinition()
					.addJvmOption("-Djava.net.preferIPv4Stack=true")
					.addProjectToClasspath("openjdk.test.debugging")
					.addJarToClasspath(toolsJar)
					.runClass(Connectors.class)
					.addArg(propertyFile)
					.addArg(transport.option)
					.addArg(projectBin.toString()));
			
			// Work out the number of extra connections/processes required
			int numOfConnections = new Integer(props.getProperty("numOfConnections"));
			List<StfProcess> testProcesses = new ArrayList<StfProcess>();

			for (int i = 0; i < numOfConnections; i++) {
				String server = "";
				String port = props.getProperty("port" + i);
				String testClass = props.getProperty("mainClass" + i);
				String connectionType = props.getProperty("connection" + i);
				String sharedMemoryLoc = props.getProperty("sharedmemory" + i);
				
				if (connectionType.equals("launch")) {
					// Do nothing as the connector process will launch the connection
					continue;
					
				} else if (connectionType.equals("listen")) {
					core.doSleep("Sleep for 5 seconds to allow the connector process to start to listen", "5");
					
				} else if (connectionType.equals("attach")) {
					server = ",server=y";
					
				} else {
					throw new IllegalStateException("Connection type " + connectionType + " not recognised");
				}
				
				// Set transport jvm address option
				String transportAddress = null;
				if (transport == Transport.SOCKET) {
					transportAddress =  port;
					
				} else {
					transportAddress = sharedMemoryLoc;
				}
				
				// Kick off the extra processes required by the test
				testProcesses.add(core.doRunBackgroundProcess("Starting " + testClass + " on port " + port, 
						test.mnemonic + (i + 1), 
						ECHO_ON, 
						ExpectedOutcome.cleanRun().within("30m"),
						core.createJavaProcessDefinition()
						.addJvmOption("-Xrunjdwp:transport=" + transport.option + ",address="  + transportAddress + server + ",timeout=" + PROCESS_TIMEOUT + traceOptions)
						.addProjectToClasspath("openjdk.test.debugging")
						.addJarToClasspath(toolsJar)
						.runClass(testClass)));
			}
			
			// Now monitor all processes to completion
			core.doMonitorProcesses("Monitoring " + test.name() + " processes", testProcesses.toArray(new StfProcess[testProcesses.size()]), connector);
		}
	}
	
	private void loadProperties(FileRef propertiesFile) throws StfException, IOException {
		// System.out.println("Trying to load property file....");
		props = new Properties();
		
		FileInputStream PropertiesFile = new FileInputStream(propertiesFile.toString());
		props.load(PropertiesFile);
		
		PropertiesFile.close();	
	}
	
	public void tearDown(StfCoreExtension test) throws StfException {
	}
}
