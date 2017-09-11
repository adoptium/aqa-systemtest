StringModifierAgent
=============

Contents:
  * [1: The purpose of this Java agent.](#purpose)
  * [2: Requirements.](#requirements)
  * [3: How to build this java agent manually.](#build)
  * [4: How to use this Java agent.](#use)
  * [5: Supporting material.](#material)

## <a name="purpose">1: The purpose of this Java agent.</a>

The purpose of this Java agent is to exercise the late-attach Hot Code Replace functionality in Java by randomly adding method calls to public methods in the java.lang.String class via the ASM tool.

This agent was designed to run concurrently with another Java process. If you late-attach the agent (via the VirtualMachine class in the com.sun.tools.attach package), it will run concurrently with the host process, modifying the String class repeatedly and randomly for the duration assigned to it (default 240 seconds).

If you attach this agent via the -javaagent argument, then this agent will run to completion (making changes, and replacing those changes with new changes, over and over etc) before your main Java process will execute. I strongly advise reducing the agent's duration if you intend to use the agent this way.

## <a name="requirements">2: Requirements.</a>

- Java 8 or later.
- ASM (see section 5).
- Some code to attach this agent to another JVM (e.g. the included Attacher class).

## <a name="build">3: How to build this java agent manually.</a>

Note: This agent is normally built by test.debugging's ant build file (build.xml), which does all these things automatically.

- Step 1: Javac the following classes, in the following order, with the ASM asm-5.x.jar on the classpath.
(Note: see section 5 for where you can get that jar. Should be version 5 or later.)
AgentLogger.java
MyMethodVisitor.java
MyClassVisitor.java
StringTransformer.java
TransformerMakerThread.java
StringModifierAgent.java
Attacher.java

Step 2 (optional): If you don't want to use the included manifest and want to make your own, ensure that the following attributes are inside it: 

Agent-Class: StringModifierAgent
Premain-Class: StringModifierAgent
Can-Redefine-Classes: true
Can-Retransform-Classes: true
Can-Set-Native-Method-Prefix: true
Implementation-Title: StringTransformer
Implementation-Version: 1

Step 3: jar the class files and the manifest together. You can use this command if you want:

jar cmf manifest.txt StringModifierAgent.jar *.class

Step 4: Coffee.

## <a name="use">4: How to use this Java agent.</a>
- Early attach
If you want to start a Java program with this agent included from the start, put this on the command-line:
"-javaagent:<path-to-java-agent-jar>/StringModifierAgent.jar[=<any_java_agent_options>]"

It will run to completion before your main Java class starts running, so I advise setting the duration low, e.g. 5 seconds: 
"-javaagent:<path-to-java-agent-jar>/StringModifierAgent.jar=duration=5"

- Late attach
If you want to attach to a Java process that is already running, then you either:
Use the com.sun.tools.attach package.
OR
Use the included Attacher class.

Note: for this test, the "already-running" process must have asm-5.x.jar on the classpath.


To use the Attacher class, here is the command:

java -classpath <java_home>/lib/tools.jar:<location_of_the_agent_jar>/StringModifierAgent.jar Attacher <process_id_of_the_target_JVM> <location_of_the_agent>/StringModifierAgent.jar [any_options_for_the_agent]

Note that you need to remove the tools.jar bit on Java 9. It doesn't have that jar, and don't need to add it to the classpath.

Also note that you can attach any other Java agent this way. Simply replace the second instance of "<location_of_the_agent>/StringModifierAgent.jar" with that of your agent. The first instance is only required because that's where the Attacher class is.

-- Agent Options

This agent supports the following options, which need to be passed as a single, comma-separated string.

You can use some/none of these as you want, in any order. The only exception is the debug/nodebug options, which should be the first option for best results.

- duration=<seconds>
The number of seconds you want the agent to run for. Mentally increment this by up to 20 seconds to allow running threads to cease.

- debug
This enables debug output. There is a lot of it, so I advise using threads=1 as well to avoid having a mish-mash of output from multiple threads. Must be the first option for best results.

- nodebug
This removes almost all of the minimal, useful debug that happens by default. Must be the first option for best results.

- threads=<number_of_concurrent_threads>
This controls the maximum number of transformations applied to any one String public method at any one time. It also makes the debug output sensible, as only one suite of transformations is happening at any one time.

- threadsTimeout=<milliseconds to wait for last threads to complete>
This controls the number of milliseconds we will wait for the threads to finish after reaching the duration.

- percentage=<0-100>
This controls the average number of String class methods modified per thread. It's good if you want to modify the intensity of the test, or if you want to test the agent itself without worrying about the actual String modification (as 0% allows multiple threads to create multiple transformers that do nothing).

<0 or >100 will not produce errors, but will be treated as either 0 or 100 respectively.

- seed=<seed>
There are various random bits inside the agent to allow random thread overlap, random methods modified per thread, and random method calls added per method. Using the seed from an earlier run allows you to ensure that your run is much closer to that run than a default (random) run would be.

- Example of all of these: percentage=50,threads=10,threadsTimeout=20000,duration=240,seed=452464782927226278

-- Environment Variables

- net.adoptopenjdk.test.hcrAgent.agent.StringModifierAgent.options

This variable can be used to pass any/all of these options into the agent if your setup does not permit easy access to the command line.
Note that options passed into the agent this way will be overridden by any counterparts on the command line.

## <a name="material">5: Supporting material.</a> 

The following resources can be found online, through your preferred search agent:
- Java agent creation guides
- Java class "Instrumentation" API
- ASM home page, several useful guides, and the API
- The Java Attach API (which describes classes like VirtualMachine)
