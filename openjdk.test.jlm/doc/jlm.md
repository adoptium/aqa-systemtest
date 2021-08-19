java.lang.management Test Suite
===============================

Contents
--------
1. [What does it test?](#what-does-it-test)
2. [How are the tests implemented?](#how-are-the-tests-implemented)
3. [What setup is required?](#what-setup-is-required)
4. [How do I run the tests?](#how-do-i-run-the-tests)
5. [How do I know whether it worked or failed?](#how-do-i-know-whether-it-worked-or-failed)

### What does it test?

This testsuite tests the java.lang.management API, new from Java 5.0, but including the **LockInfo** and **MonitorInfo** classes introduced with Java 6.0. This API provides functions which can be used to inspect the JVM's state and modify its properties via a set of managed beans, known as Platform MBeans.

Each running JVM has a set of these Platform MBeans. The java.lang.management API can be used with the MBeans for the local JVM, or it can be used with the MBeans of remote JVMs. Therefore a Java application on one machine can use java.lang.management functions to monitor and manage Java applications
running on remote machines, as long as the remote applications have been started with security options which allow them to be remotely monitored.

The API provides a variety of different functions via several different MBeans. These include the
ability to get information about all current threads, about system settings, about the different types of memory and their current usage, about the number of classes that have been loaded and unloaded, and about the behavior of the JIT compiler. Not all the functions are supported by all VMs.

A full list of the java.lang.management functions can be found in the Java 6 API documentation. As mentioned above, the functions are provided by a set of Platform MBeans:
  - ClassLoadingMXBean
  - CompilationMXBean
  - GarbageCollectorMXBean
  - MemoryManagerMXBean
  - MemoryMXBean
  - MemoryPoolMXBean
  - OperatingSystemMXBean
  - RuntimeMXBean
  - ThreadMXBean

These MBeans are accompanied by a **ManagementFactory** class which provides factory methods for getting the MBeans for the local JVM. Various other java.lang.management classes specify data types which are returned by some of the functions (eg. ThreadInfo, MemoryUsage).

The aim of this testsuite is to exercise the functionality provided by the MBeans to find out information about the VM and write it to a file. Where it is possible to modify properties of the VM using the API, this is also done. The functionality is tested both by a testcase which inspects the local VM (i.e. the one associated with the testcase itself) and by testcases which connect to separate VMs on the same machine and inspect those.

### How are the tests implemented?

The test cases are all implemented in Java, using the *STF*. Please see [STF test framework manual](https://github.com/adoptium/stf/blob/master/stf.core/docs/STF-Manual.md).

At the top level, we have 'STF automation plugin' test classes (e.g. classes under /openjdk.test.jlm/src/test.jlm/net.adoptopenjdk.test.jlm.stf.* package) that contain the implementation details of each jlm test.

Each of these stf test plugins manages execution of one or more Java processes. These Java processes in turn drive the actual test classes. Each test class contains one or more Junit test methods. Test validations typically take place both in these Junit test methods, as well as in the STF plugin classes.

There are two main categories of JLM tests - Local and Remote.

*The local JLM test* runs on a single JVM and monitors it using the Platform MBeans. The STF plugin for the local test is net.adoptopenjdk.test.jlm.stf.TestJlmLocal. The **net.adoptopenjdk.test.jlm.local** package contains one testcase which gets the Platform MBeans of the local VM in two different ways, finds out information from them and prints them out. It also tries modifying some of the VM's properties and then finding out the information again.

*The remote JLM tests* run two local JVMs - 'monitored', and 'monitoring'. An STF load is run on the monitored JVM, while the monitoring JVM monitors it. These tests are driven by the STF plugin automation classes for remote JLM tests.

The remote JLM testcases, that connect to separate VMs, can be run in two modes: without security options enabled (i.e. no authentication/encryption required) and with these security options enabled. Running with these security options enabled requires some setup in terms of username/password configuration and SSL, both of which are encapsulated in the STF automation classes corresponding to the remote tests.

The **net.adoptopenjdk.test.jlm.remote** package contains the actual test case classes. Each of these tests connects to a remote VM and uses its Platform MBeans to monitor it. Three of these tests profile different aspects of the VM and the other makes use of the notification functionality provided by java.lang.management to monitor the VM's memory usage.

The testing of the Java 6.0 extensions to **java.lang.management** (LockInfo and MonitorInfo) are integrated into the VMLogger and ThreadProfiler test applications.

### What setup is required?
- STF
- Testcase Material

Since JLM tests are written based on STF, they will require the same set up as STF in general. Please follow the [STF Getting Started Guide](https://github.com/adoptium/stf/blob/master/stf.core/docs/STF-GettingStarted.md) and install everything that is required to run STF tests.

### How do I run the tests?

Once you have set up STF and compiled the test source in your workstation, you can run any test locally from the command line.

#### JLM Local Tests
The JLM Local test case inspects a local VM. It is implemented in *net.adoptopenjdk.test.jlm.local.VMLogger*. It can be automatically run using the following command:</p>
> stf.pl -test=TestJlmLocal

#### JLM Remote Tests
The remote JLM testcases require a separate Java application to be running at the same time as the testcase so that the test has something to monitor.

All the *net.adoptopenjdk.test.jlm.remote* testcases monitor a separate JVM running an STF load test. The process of running the load test in the 'monitored' VM and running the test Java process in a separate, 'monitoring' VM is encapsulated in a set of STF plugin tests (e.g., /openjdk.test.jlm/src/test.jlm/net/adoptopenjdk/test/jlm/stf/TestJlmRemote*). This set of STF plugin tests constitute all the combinations we need to test, i.e., each of proxy and server with anon and auth for each combination of security-enabled and security-disabled remote tests), with two test monitoring application types, namely, profiling and notification.

**Note:** The security settings as well as the server and client settings are all hard-coded in the test STF plugin for remote tests. Please see test Java files for details.

The JVM usually takes one to two minutes to complete the setup needed to allow security-enabled monitoring.
The testcase therefore assumes the JVM is not initialized for the first 30 connection attempts. Any "Unable to Connect" messages can be safely ignored. If the testcase is unable to get a connection after 30 attempts the test assumes there is a problem and fails.

The JLM Remote test cases can be run automatically using the following command:</p>
> stf.pl -test=jlm_remote_test_name

*Where*: jlm_remote_test_name is the STF automation plugin class name of a jlm remote test found under /openjdk.test.jlm/src/test.jlm/net/adoptopenjdk/test/jlm/stf/, e.g., TestJlmRemoteClassAuth, etc.

### How do I know whether it worked or failed?

The STF test plugins report if the tests have passed or not. No further checking is required. However, if the test is run manually, you should check the following:</p>

For the VMLogger testcase, you should check the following:
* Check if the test completed without crashing, hanging, looping or raising unhandled exceptions.
* Check that a message similar to the following was written to stdout:

    1) GC requested via the MemoryMXBean, and JVM invoked one (acceptable behaviour)
    2) GC count before: 0, GC count after: 1.
Note: The numbers of GCs before and after do not matter as long as the GC count after is one greater than the GC count before. It is also acceptable for the JVM not to invoke a GC, as long as the GC count after is equal to the GC count before.
* Do not worry if you see verbosegc output printed to stdout - this is part of the test.
* In the log file that was specified when starting the test (in TestJlmLocal.java), check the data written to that file. Specifically check that there are four main sections in the file:

    1) VM DATA RETRIEVED USING BEANS DIRECTLY
    2) VM DATA RETRIEVED USING THE MBEAN SERVER
    3) VM DATA RETRIEVED USING THE MBEAN SERVER - OPTIONAL FUNCTIONALITY ENABLED
    4) VM DATA RETRIEVED USING THE BEANS DIRECTLY - OPTIONAL FUNCTIONALITY DISABLED
* Finally, check that no error messages exist in the log file.

For the remote testcases, you should check the following:
- The test should be able to connect to the VM of the monitored Java application once the application has successfully started.
- The test should complete without crashing, hanging, looping or raising unhandled exceptions.
- The monitored Java application should complete without crashing, hanging, looping or raising unhandled exceptions.
- In the STF test directory, check the .csv data file that was given to the test process (specified in the STF automation class). Verify that data was written throughout the test and that the data written is reasonable.
- In the STF test directory, check the log file that was given to the test process (specified in the STF automation class). Check the data written to that file (e.g. if the file is empty, or the data seems wrong/unreasonable, this should be investigated). Also check that no error messages exist in the file.
