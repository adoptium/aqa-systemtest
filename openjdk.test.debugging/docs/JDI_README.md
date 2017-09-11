Java Debugging Interface (JDI) Tests
=============

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)
  * [How do I manually run the test suite?](#how-do-i-manually-run-the-test-suite)
  * [How property files are defined?](#how-property-files-are-defined)
  * [Example command line](#example-command-line)
  * [How do I know whether it worked?](#how-do-i-know-whether-it-worked)


## <a name="overview">Overview</a>

Java Debugging Interface (JDI) is an api which allows connection via a debugger to low level debugging tools, such as breakpoints and field watching. The debugger creates a connection to the target VM allowing user created trace and debugging to be set and trigger user code. JDB is an official implementation of JDI to produce a debugging tool.

One of the aims of the test suite is test JDWP (Java Debugging Wire Protocol), this is the connection between the debugger and the target VM to be debugged. The target vm is either started by the debugger or started on it's own waiting for debugger.

There are several different connection types:
* Debugger launches the target VM
* Debugger attaches to the target VM
* Debugger listens for target VM, i.e. the target VM attaches to the debugger
* target VM launches the debugger


These different ways can be used to connect to and from the debugger and the target VM with each other. It is possible to have multiple connections of a debugger to different target VM's at once however multiple connections from a target VM to debuggers are not possible.

Once the debugger connects to the target VM, a mirror of the target VM is also created which is accessible by the debugger. Using this it is possible to request information about the vm such as notification of events occurring, this is done using the EventRequestManager.
Events that can be listened for include:
* Class prepared and unloaded
* Method entry and exit
* Thread start and death
* Watchpoints access and modification
* Breakpoints


When writing the test case there are several different areas that can be varied and need to be considered so that a sufficient number of permutations are covered.
These include:

* Running with each type of connection
* Running with multiple of different/same connections
* Setting different event listeners, focus on certain areas/themes
* Verification of events occurring
* Check multiple watches on the same field work
* Delete then recreate breakpoints


Changing the java code being debugged will also provide us with further coverage. The intention is to increase the complexity of the debug code we are testing with, the different classes / programs to be debugged are below:

* A basic HelloWorld class
* A slightly more complex class containing instance methods called Simple.class
* A class which creates lots of instances / objects. This class provides targeted testing for the new instance functions added in Java 60 to provide access to the objects on the heap.
* Future work - A High work load running lots of threads
* Future work - A class which consumes the heap and produces an OutOfMemoryError


The tests work by setting certain options, the debugger takes a properties file containing information about the Target VM and event listeners that need to be set. Using this it is possible to set multiple target VM's and multiple breakpoints/watchpoints. The property file can also be used to verify that all the expected events actually occurred.
The JDI file structure has several different areas, the connection set up and event running, i.e. debugger files. The actual programs to debug these being of varying intensity work load levels, i.e. the target VM and the property files creating scenarios for connecting and debugging specific Target VM's. 


## <a name="how-is-it-implemented">How is it implemented?</a>

The test suite is driven by a STF test plugin written in Java and is divided into two areas. The connection and debugging classes, and target classes to be used for debugging, these target classes are set using .prop files which set the debugging level(events) as well at which target vm's to load.

The debugger package contains 2 files, Connectors which connects to the target vm's in 3 possible ways, EventT which creates the event requests for the debugger to listen for and actions that occur upon receiving an event.
The properties folder contains the different target vm's on which breakpoints, watchpoint etc are set. These cover a variety of different situations, ranging from HelloWorld to a intensive memory and thread program.
The properties folder also contains different property files which load up different numbers of target classes using one of the 3 connection methods, then set breakpoints, watchpoints, method entry and exit, etc events. These tests profile different aspects of the JDWP connection between the debugger class and the target vm class.

Since the debugger has the option to either launch a java class, listen for a class on a port (which involves starting a java class listening on a particular port), or attaching to a class on a port (which requires a java class to already be listening on the port), the test plugin reads in the properties file and uses it to works out what the java is expecting then starts up the appropriate java classes in respect to the main JDI test classes. i.e. if the attach connection is used then the framework starts a java class listening before the debugger is run, then the Connector class within the debugger will attach to this class and listen for other classes. The test plugin then monitors the processes to ensure that the expected events listed in the property file have occurred successfully. 


## <a name="test-automation">Test Automation</a>

Automation of the tests is done using a STF test plugin, JdiTest.java. 

By default, the test plugin runs all the JDI tests but it is possible to run a specific test:

To run the full JDI test suite:

	perl $HOME/git/stf/scripts/stf.pl -test=JdiTest

To run a specific JDI test:

	perl $HOME/git/stf/scripts/stf.pl -test=JdiTest -test-args=test=single_launch

-testX is dependent on the tests parameters encoded in the test plugin, for full list, please see the Enum table in JdiTest.java, some examples below:

* basic_launch  - a simple test that just launches 2 connections then runs HelloWorld and Simple with a small set of events
* basic_attach  - a simple test that just attaches 2 connections to listening processes with a small set of events
* basic_listen  - a simple test that just creates 2 listening connections waiting for attaching processes with a small set of events
* simple_launch - a test that launches 2 connections and has a list of events
* both_simple 	- a test that both listening and attaching connection types, both with a list of events
* all_simple	- all 3 connection types are used with varying levels of events
* many_objects	- launches 2 connections running with lots of objects


## <a name="how-do-i-manually-run-the-test-suite">How do I manually run the test suite?</a>

It is also possible to run these tests without automation and STF aid, however due to the fact that 2/3 of the connection types need to attach to or listen for a separate java process the tests are hard to run in a batch mode.

The way to manually run the tests is using the property file such as:

	$JAVA_HOME/bin/java -Djava.net.preferIPv4Stack=true -classpath $HOME/git/openjdk-systemtest/openjdk.test.debugging/bin:$JAVA_HOME/lib/tools.jar net.adoptopenjdk.test.jdi.debugger.Connectors $HOME/git/openjdk-systemtest/openjdk.test.debugging/src/test.debugging/com/ibm/runtimes/jdi/properties/basic_launch.prop dt_socket $HOME/git/openjdk-systemtest/openjdk.test.debugging/bin

The simplest way of connecting is using the launch type of connection which does not require any other process to be started.
Remember if the properties file contains a connection type of listening or attach these will need to be started in a separate process. The listening connection should be started before the debugger is run, the attaching should be run afterwards.

To start a vm listening, use:

	$JAVA_HOME/bin/java -Xrunjdwp:transport=dt_socket,address=800,server=y -Xdebug -Xnoagent -Djava.compiler=NONE -classpath $HOME/git/openjdk-systemtest/openjdk.test.debugging/bin net.adoptopenjdk.test.jdi.targetvm.HellowWorld

To get a vm to attach to the debugger, use:

	$JAVA_HOME/bin/java -Xrunjdwp:transport=dt_socket,address=800 -classpath $HOME/git/openjdk-systemtest/openjdk.test.debugging/bin net.adoptopenjdk.test.jdi.targetvm.HellowWorld

Port doesn't have to be 800, just needs to be the same on listener and attacher! Note: to work on linux the port must be higher than 1024.

## <a name="how-property-files-are-defined">How property files are defined?</a>

The properties file is used by the connections class to work out how many and what type of connections are to be started. Then when and what types of events are to be listened for, such as breakpoints and method entry.

The layout of a simple property file:

	numOfConnections=2
	
	connection0=attach
	mainClass0=Simple
	port0=1040
	vm0.numOfEvents=10
	vm0.event0=methodEntry
	vm0.event1=methodExit
	vm0.event2=countInstances
	vm0.event3=breakpoint:setName
	vm0.event4=modificationWatchpoint:name
	vm0.event5=breakpoint:getName
	vm0.event6=accessWatchpoint:name
	vm0.event7=deleteBreakpoints
	vm0.event8=breakpoint:getName
	vm0.event9=breakpoint:setName
	
	connection1=listen
	mainClass1=Simple
	port1=1041
	vm1.numOfEvents=10
	vm1.event0=methodEntry
	vm1.event1=methodExit
	vm1.event2=vmName
	vm1.event3=breakpoint:setName
	vm1.event4=modificationWatchpoint:name
	vm1.event5=accessWatchpoint:name
	vm1.event6=breakpoint:getName:step
	vm1.event7=deleteBreakpoints
	vm1.event8=breakpoint:getName
	vm1.event9=breakpoint:setName

The numOfConnections specifies the number of different connections the debugger is to make, depending on the connection type different options are required. If the connectionX=launch then a equivalent mainClassX is required.

The numOfConnections and the relevent connectionX, mainClassX and if connecting with either attach or listen then a portX is also necessary. The numOfEvents for that vm must also be specified, i.e. vmX.numOfEvents=Y. If there are more connections or events than specified these with be ignored.

The different events/options are:

* methodEntry - triggers on method entry, prints out the name of the method and class
* methodExit - triggers on method exit, does nothing
* vmName - prints out the vmName
* countInstances - counts the instances of the main class
* breakpoint:X - sets a breakpoint at method X
* breakpoint:X:step - sets a breakpoint at method X and steps once at that point, this should only be used once otherwise it causes errors
* modificationWatchpoint:X - triggers on modification of X but not access i.e. set methods
* accessWatchpoint:X - triggers on access of X but not modification i.e. get methods
* deleteBreakpoints - removes all the currently set breakpoints, any breakpoints set after this point will still occur


How do I know whether it worked or failed?

As previously mentioned the STF test plugin reports if the tests have passed or not. No further checking is required. If the test is run manually you should check the following:

* The test should complete without crashing, hanging, looping or raising unhandled exceptions
* The properties file has been read in correctly
* Check that a message similar to the following was written to stdout:

```
progress...VirtualMachine obtained.
No errors in attaching on port X
```
    
* For each connection.Check that the events to be traces have been loaded into the debugger, such as the following: 

```
LoadedEvents true
Setting setupEventRequestManager
Setting MethodEntryRequest
Setting MethodExitRequest
```
	
* Make sure that the target vm has actually been run, with something similar to:

```
main - Simple
- Simple
setName - Simple
---- BreakpointEvent hit ----
---- ModificationWatchpointEvent hit ----
getName - Simple
---- BreakpointEvent hit ----
---- AccessWatchpointEvent hit ----
(Of course the output here depends on the target vm run and the events that are set on it.)
```

* Finally, check that no error messages exist in the log file


If all these conditions are satisfied then the test has worked. 


## <a name="example-command-line">Example command line</a>

A minimal command to run a test would typically look like:


	perl $HOME/git/stf/scripts/stf.pl -test=JdiTest
	...
	SIL1 stderr 15:55:00.349  PROG: [AgentManager.cpp:124] Clean: clean agent modules
	SIL1 stderr 15:55:00.349  PROG: [PacketDispatcher.cpp:235] Clean: clean internal data
	SILC VM died.
	SILC ***** Finished trace for vmcom.sun.tools.jdi.VirtualMachineImpl@ed81bc8d ******
	SILC 
	SILC Connectors closing @02-May-2017 15:55:00
	STF 15:55:00.396 - Monitoring Report Summary:
	STF 15:55:00.396 -   o Process SIL1 ended with the expected exit code (0)
	STF 15:55:00.396 -   o Process SILC ended with the expected exit code (0)
	STF 15:55:00.396 - EXECUTE stage completed
	STF 15:55:00.656 - 
	STF 15:55:00.656 - ====================   T E A R D O W N   ====================
	STF 15:55:00.656 - Running teardown: perl /tmp/stf/20170502-155121-JdiTest/tearDown.pl
	STF 15:55:00.714 - TEARDOWN stage completed
	STF 15:55:00.721 - 
	STF 15:55:00.721 - =====================   R E S U L T S   =====================
	STF 15:55:00.721 - Stage results:
	STF 15:55:00.721 -   setUp:     pass
	STF 15:55:00.721 -   execute:   pass
	STF 15:55:00.721 -   teardown:  pass
	STF 15:55:00.721 - 
	STF 15:55:00.721 - Overall result: PASSED


## <a name="how-do-i-know-whether-it-worked">How do I know whether it worked?</a>

The STF test plugin will check the exit codes of all processes and fail if any of them is not '0' and report 
at the end that the overall result is PASSED, as shown below:

	STF 16:48:05.438 - ====================   T E A R D O W N   ====================
	STF 16:48:05.438 - Running teardown: perl /tmp/stf/20170503-164737-JdiTest/tearDown.pl
	STF 16:48:05.492 - TEARDOWN stage completed
	STF 16:48:05.499 - 
	STF 16:48:05.499 - =====================   R E S U L T S   =====================
	STF 16:48:05.499 - Stage results:
	STF 16:48:05.499 -   setUp:     pass
	STF 16:48:05.499 -   execute:   pass
	STF 16:48:05.499 -   teardown:  pass
	STF 16:48:05.499 - 
	STF 16:48:05.499 - Overall result: PASSED


