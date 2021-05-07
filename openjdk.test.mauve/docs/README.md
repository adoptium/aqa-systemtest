# openjdk.test.mauve

The openjdk.test.mauve project contains files which enable part of the Mauve project test cases (see https://sourceware.org/mauve/) to be executed as a load test.

Only a subset of the Mauve tests (about 7000 tests) are executed in this way because
- some tests have external dependencies which would complicate the test setup
- not all tests can can be executed multiple times within the same java virtual machine (the stf.load tool executes test cases repeatedly)
- some tests are relatively long running and do not lend themselves to execution in a load test environment.

The Mauve test cases themselves are not part of the openjdk.test.mauve project.
The openjdk.test.mauve project only contains the files required to download, select and build the tests.
Those files are executed by the 'make configure' step of the aqa-systemtest repository build process, when the mauve source
code is downloaded from the mauve project cvs repository and compiled into a mauve.jar file.

The mauve.jar is placed in $SYSTEMTEST_PREREQS_ROOT/mauve/mauve.jar. The default location for $SYSTEMTEST_PREREQS_ROOT is $HOME/systemtest_prereqs (unix)
 or %USERPROFILE%\systemtest_prereqs (Windows).  It can be overridden via the PREREQS_ROOT=xxxx make macro at build time.

So the easiest way to create the mauve.jar file is to:
```
cd openjdk.build
make configure
```

The tests to be executed as part of a load test are defined in a load test inventory file.
All the inventory files are kept together in the openjdk.test.load/config/inventories folder.

The stf.load tool supports the calling of Mauve test cases via the 'mauve' keyword when referencing a class in an inventory file - e.g.

```xml
<inventory>
  <mauve class="gnu.testlet.java.awt.AlphaComposite.equals"/>
  <mauve class="gnu.testlet.java.awt.AlphaComposite.getInstance"/>
</inventory>
```

The inventories to use and the test parameters such as the number of test iterations and number of threads are set in the openjdk.test.load java classes.
Note that the tests may be included in 'Mix' load tests as well as the obvious MauveMultiThreadLoadTest.java and MauveSingleThreadLoadTest.java.

The tests are executed in the same way as other stf load tests - i.e.
```
perl stf.pl -test=<LoadTestName> (-java-args=<java-args>)
```
There are several tests which use the mauve load test suite. They differ from each other in the number of concurrent threads, the number of times the tests are executed and whether other tests are run alongside the mauve tests.

The basic tests are:
```
perl stf.pl -test=MauveSingleThreadLoadTest
```
and:
```
perl stf.pl -test=MauveMultiThreadLoadTest
```

STF reports on the success or failure of the run on the final line, and also sets the process exit code to '0' if it passes.

Passing test example:
```
$ perl stf.pl -test=MauveSingleThreadLoadTest
STF 17:57:20.167 - =====================   R E S U L T S   =====================
STF 17:57:20.167 - Stage results:
STF 17:57:20.168 -   setUp:     pass
STF 17:57:20.168 -   execute:   pass
STF 17:57:20.169 -   teardown:  pass
STF 17:57:20.169 -
STF 17:57:20.169 - Overall result: PASSED
$ echo $?
0
```

Failing test example:
```
$ perl stf.pl -test=MauveSingleThreadLoadTest
STF 17:34:30.717 - =====================   R E S U L T S   =====================
STF 17:34:30.717 - Stage results:
STF 17:34:30.717 -   setUp:     pass
STF 17:34:30.718 -   execute:  *fail*
STF 17:34:30.718 -   teardown:  pass
STF 17:34:30.718 -
STF 17:34:30.718 - Overall result: **FAILED**
$ echo $?
1
```

When debugging failures you may find running a single mauve test on its own (perhaps with specific java -X options)
is actually all that is needed to recreate a failure.  You can do this by running the Mauve test harness directly:

```
# Get Mauve to run the ChoiceFormat.parse test:
$ export SYSTEMTEST_PREREQS_ROOT=$HOME/systemtest_prereqs
$ java -classpath $SYSTEMTEST_PREREQS_ROOT/mauve/mauve.jar gnu.testlet.SingleTestHarness gnu.testlet.java.text.ChoiceFormat.parse
```

