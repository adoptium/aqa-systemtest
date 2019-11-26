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

package net.adoptopenjdk.test.hcrAgent.agent;

import java.lang.instrument.Instrumentation;
import java.lang.RuntimeException;
import java.util.Random;

/*
 * This class is a java agent, designed to create and execute multiple threads,
 * and to replace dead threads with new ones for the duration of the test.
 * Each thread inserts a transformer into the JVM. These transformers modify
 * the class "String" in harmless ways, to ensure we can do so without breaking Java.
 * The threads add their transformer, trigger a retransformation of String, remove
 * their transformer, and die.
 */
public class StringModifierAgent {

	/**
	 * This method does everything in the class description.
	 * @param args The arguments passed to this agent. Used for tweaking, debugging, etc.
	 * @param inst The object that allows us access to the host JVM. We use it for retransformation.
	 */
	public static void agentmain(String args, Instrumentation inst) {
		AgentLogger.setDebugLevel(1);
		System.out.println("The agent's agentmain method was called.");
		int percentage = 50;
		int threadsLimit = 10;
		int duration = 240; //in seconds.
		Random randomNumberGenerator = new Random();
		long seed = randomNumberGenerator.nextLong();
		long threadsTimeout = 60*1000;
		String debugOption = "";
		
		//Concatenate any command-line options with any env var options. 
		//The former come last, as they take priority, and will override the latter.
		String commandLineOptions = args;
		String envVarOptions = System.getenv("net.adoptopenjdk.test.hcrAgent.agent.StringModifierAgent.options");
		if (commandLineOptions == null) {
			commandLineOptions = "";
		}
		if (envVarOptions == null) {
			envVarOptions = "";
		}
		
		String[] argsArray = new String[0];
		argsArray = (envVarOptions.replaceAll("^\"|\"$", "") + "," + commandLineOptions.replaceAll("^\"|\"$", "")).split(",");

		// To parse the options passed to us.
		for (String oneArg : argsArray) {
			if (oneArg.startsWith("nodebug")) {
				AgentLogger.setDebugLevel(0);
				debugOption = "nodebug,";
				AgentLogger.printThis("Option \"nodebug\" has disabled agent logging. The agent will produce no further output until it ends.",0);
			}
			if (oneArg.startsWith("debug")) {
				AgentLogger.setDebugLevel(2);
				debugOption = "debug,";
				System.out.println("The \"debug\" option has enabled verbose logging.");
			}
			if (oneArg.startsWith("percentage=")) {
				percentage = Integer.parseInt(oneArg.substring(11));
			}
			if (oneArg.startsWith("threads=")) {
				threadsLimit = Integer.parseInt(oneArg.substring(8));
			}
			if (oneArg.startsWith("threadsTimeout=") || oneArg.startsWith("threadstimeout=")) {
				threadsTimeout = Integer.parseInt(oneArg.substring(15));
			}
			if (oneArg.startsWith("duration=")) {
				duration = Integer.parseInt(oneArg.substring(9));
			}
			if (oneArg.startsWith("duration=")) {
				duration = Integer.parseInt(oneArg.substring(9));
			}
			if (oneArg.startsWith("seed=")) {
				seed = Long.parseLong(oneArg.substring(5));
			}
		}
	
		//Some logging to show the results of the for loop.
		AgentLogger.printThis("The agent will alter an average of " + percentage + "% of the public methods in the String class per thread.",2);
		AgentLogger.printThis("The agent will launch " + threadsLimit + " threads for the purpose of adding+removing transformers to modify String.",2);
		AgentLogger.printThis("The agent will wait " + threadsTimeout + " milliseconds for the transformer thread/s to finish after reaching the duration.",2);
		AgentLogger.printThis("The agent will run for a duration of " + duration + " seconds, plus up to twenty for the last threads to finish.",2);
		AgentLogger.printThis("This agent will use the seed " + seed + " for generating random numbers.",2);

		randomNumberGenerator = new Random(seed);

		AgentLogger.printThis("To re-run this agent with these options, pass this option to the agent on the command line: \"" + debugOption + "percentage=" + percentage + ",threads=" + threadsLimit + ",threadsTimeout=" + threadsTimeout + ",duration=" + duration + ",seed=" + seed + "\"",1);

		TransformerMakerThread[] threadArray = new TransformerMakerThread[threadsLimit];
		AgentLogger.printThis("Initialising all of the threads.",2);
		//Initialise each thread.
		for (int i = 0;i < threadsLimit;++i) {
			//Make new threads.
			threadArray[i] = new TransformerMakerThread(inst, i, percentage, randomNumberGenerator.nextLong());
			AgentLogger.printThis("Starting thread " + i,2);
			threadArray[i].start();
		}
		AgentLogger.printThis("Threads are all initialised.",2);

		//And now loop until we hit the duration limit.
		long end = System.currentTimeMillis() + (duration*1000);

		AgentLogger.printThis("Entering the loop that will replace dead threads with live ones until we run out of time.",2);
		while (end > System.currentTimeMillis()){
			sleepNow(2 * 1000); //Wait for 2 seconds so we're not drowning out the attachee.
			for (int i = 0;i < threadsLimit;++i) {
				if (!threadArray[i].isAlive()){
					threadArray[i] = new TransformerMakerThread(inst, i, percentage, randomNumberGenerator.nextLong());
					AgentLogger.printThis("Replacing thread " + i + " with a new one",2);
					threadArray[i].start();
				}
			}
			//Here we throw any error a transformer has seen in the last few seconds.
			//The transformer cannot throw them itself because Java catches them.
			AgentLogger.throwErrors();
		}

		//Now we wait for a while to make sure every thread finishes.
		//Set the timeout, and override with the user's timeout if they've set one.
		AgentLogger.printThis("We've reached the duration, and will now wait " + threadsTimeout + " milliseconds for the last few agents to finish.",2);
		boolean allFinished = false;
		threadsTimeout = System.currentTimeMillis() + threadsTimeout;
		while ((threadsTimeout > System.currentTimeMillis()) && !allFinished){
			sleepNow(1 * 1000); //Wait for 1 second so we're not drowning out the attachee.
			allFinished = true;
			for (int i = 0;i < threadsLimit;++i) {
				if (threadArray[i].isAlive()){
					allFinished = false;
				}
			}
		}

		//Throw an exception if any thread has not finished by this point.
		if (!allFinished) {
			AgentLogger.printThis("The agent's transformer threads failed to finish in time. The agent will now throw a RuntimeException.",0);
			throw new RuntimeException("At least one agent thread did not end within 20 seconds.");
		}

		AgentLogger.printThis("The agent is leaving the agentmain method and shutting down.",0);
	}

	/**
	 * This method is called by the JVM when it is specified on the command line of the JVM it is meant to be attached to (see -javaagent docs).
	 * @param args Any args passed through the command line (or the attacher class) into the agent.
	 * @param inst 
	 */
	public static void premain(String args, Instrumentation inst) {
		System.out.println("The agent's premain method was called.");
		agentmain(args, inst);
	}

	/**
	 * The main method. Some tell me this method may be called, but we don't need it to do anything.
	 * @param args Never used.
	 */
	public static void main(String[] args){
		//Do nothing.
	}

	/**
	 * A method to allow us to sleep this thread without complicating the code above
	 * with the try-catch block.
	 * @param l The length of time (in milliseconds) that we want to pause this thread.
	 */
	private static void sleepNow(long l) {
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			//Do nothing.
		}
	}
}
