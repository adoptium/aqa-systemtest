# openjdk-systemtest Repository Build

Basic process is:
1. Install prereqs
1. clone the System Test Framework (stf) git repository
1. clone this (openjdk-systemtest) git repository
1. make configure (installs some other prereqs)
1. make (or make build - builds the stf and openjdk-systemtest repositories)
1. make test (runs a basic set of tests (all the tests in default (no -Xoptions) mode))

## Prereqs which cannot be installed by the openjdk-systemtest build scripts
These prereqs must be installed before attempting to build openjdk-systemtest
1. ant version 1.8.4 or later
1. Java 8 or later (any implementation)
1. GNU make 3.79 or later
1. wget (optional - required to install other prereqs automatically)

## Prereqs which can be installed by the openjdk-systemtest build scripts
### Installing the prereqs using the build scripts
1. An internet connection is required
1. Review the list of prereqs listed under ' Installing prereqs manually' and confirm that you accept their license terms.
1. git clone https://github.com/AdoptOpenJDK/openjdk-systemtest.git openjdk-systemtest
1. cd &lt;git-root&gt;openjdk.build
1. make configure

### Installing prereqs manually
1. Create a systemtest_prereqs directory alongside the git repository directory - e.g. /home/user/systemtest_prereqs (alongside /home/user/git)
1. Download and install the prereqs as described in the table below.
1. Some of these prereqs are shared with the stf project.  If you have already installed a prereq you don't need to do it again.

| Dependency            | License                                                       | Used by                  | Steps to obtain                                                                                                                                                                                                                                            |Install instructions                                                                                                                                                                                                                                                   |Installed via make / ant configure? |
|-----------------------|---------------------------------------------------------------|--------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------|
| apache-ant-1.10.1     | https://ant.apache.org/license.html                           | stf.build, openjdk.build | Download from https://archive.apache.org/dist/ant/binaries/apache-ant-1.10.1-bin.zip                                                                                                                                                                       | Unzip to PREREQS_ROOT/apache-ant-1.10.1                                                                                                                                                                                                                               | Yes                                |
| log4j-1.2.8           | https://logging.apache.org/log4j/1.2/license.html             | openjdk.test.jvmti       | Download from https://archive.apache.org/dist/logging/log4j/1.2.8/jakarta-log4j-1.2.8.zip                                                                                                                                                                  | Copy to PREREQS_ROOT/log4j-1.2.8/log4j.jar                                                                                                                                                                                                                            | Yes                                |
| log4j-2.3             | https://logging.apache.org/log4j/2.0/license.html             | stf.*                    | Download from https://archive.apache.org/dist/logging/log4j/2.3/apache-log4j-2.3-bin.zip                                                                                                                                                                   | Copy to PREREQS_ROOT/log4j-2.3/log4j-api-2.3.jar and PREREQS_ROOT/log4j-2.3/log4j-core-2.3.jar                                                                                                                                                                        | Yes                                |
| GNU make 3.79 or later| https://www.gnu.org/licenses/gpl.html                         | stf.build, openjdk.build | Windows - Download from http://gnuwin32.sourceforge.net/packages/make.htm<br>Unix: may already be installed on the test machine, a prebuilt version may already be available, otherwise build from source - see https://www.gnu.org/software/software.html | Add GNU make to PATH (ahead of any native platform make) before executing make or make test, or copy make to PREREQS_ROOT/gmake/<platform> where platform is linux_x86-32, linux_x86-64, linux_ppc-32, linux_390-31, linux_arm-32, win_x86-32, aix_ppc-64, zos_390-64 | No                                 |
| perl 5.6.1 or later   | http://perldoc.perl.org/index-licence.html                    | stf.core                 | Windows - tests can be executed using Strawberry perl.  Other perl implementations may be OK too.                                                                                                                                                          | Add to PATH                                                                                                                                                                                                                                                           | No                                 |
| Windows Sysinternals  | https://technet.microsoft.com/en-us/sysinternals/bb469936.aspx| stf.core                 | Download from https://download.sysinternals.com/files/SysinternalsSuite.zip                                                                                                                                                                                | Unzip to PREREQS_ROOT/windows_sysinternals                                                                                                                                                                                                                            | Yes                                |
| CVS client            | https://netbeans.org/cddl-gplv2.html                          | openjdk.test.mauve       | Download from https://netbeans.org/projects/versioncontrol/downloads/download/org-netbeans-lib-cvsclient.jar                                                                                                                                               | Place in PREREQS_ROOT/cvsclient                                                                                                                                                                                                                                       | Yes                                |
| wget                  | https://www.gnu.org/copyleft/gpl.html                         | stf.build, openjdk.build | Windows - download from https://sourceforge.net/projects/gnuwin32/files/wget/1.11.4-1/wget-1.11.4-1-bin.zip<br>This needs below dependency so download it from <br>https://sourceforge.net/projects/gnuwin32/files/wget/1.11.4-1/wget-1.11.4-1-dep.zip                                                                                                                                                | Add both downloads to PATH                                                                                                                                                                                                                                                           | No                                 |

## Building from a command line
1. git clone https://github.com/AdoptOpenJDK/stf.git stf
1. git clone https://github.com/AdoptOpenJDK/openjdk-systemtest.git openjdk-systemtest
1. cd &lt;git-root&gt;openjdk.build
1. make

## Working in Eclipse - developing STF and STF test cases
1. STF and STF test case development must be done in an Eclipse environment. STF uses the Eclipse metadata
in the project .classpath files to work out the test dependencies and are translated into -classpath command
line arguments when the tests execute.
1. Create a new Eclipse workspace.  Once configured the workspace will reference multiple git repositories and a local directory containing the test prereqs.
1. Install the prereqs following the instructions in 'Installing prereqs' (e.g. clone the stf and openjdk-systemtest repositories and run make configure for the openjdk-systemtest repo).
1. Create a 'General Project' in your Eclipse workspace called systemtest_prereqs.
1. Import the prereqs into the Eclipse workspace
- Create a General Project in Eclipse called systemtest_prereqs
- File --> Import --> File System
- Select the directory containing the prereqs. Select import into the new systemtest_prereqs folder.  Do not tick
the 'Create top level folder' check box (otherwise you get an extra 'systemtest_prereqs' folder which you do not
want).
1. Import the prereqs into the systemtest_prereqs project in the Eclipse workspace - Import --> File System and then locate the systemtest_prereqs directory.  Do not select the 'Create top level directory' (otherwise you will get an extra systemtest_prereqs directory which you don't want).
1. Import the STF projects into Eclipse (Find and import Eclipse projects from the STF git repo)
1. Eclipse should now build the stf projects without error (check the 'Problems' view).
1. Import the openjdk-systemtest projects into Eclipse (Find and import Eclipse projects)
1. Eclipse should now build the openjdk-systemtest (openjdk.xxxx) projects without error (check the 'Problems' view).

## Running tests
### Running via make
A basic test run can be executed by running make test from the openjdk.build directory. Tests can also be run individually by running 'make test.testname'. Running 'make help' prints the list of valid test names.
Other options are
1. You can also pass jvm arguments to the JVM under tests using the JAVA_ARGS=xxxx macro e.g.
```
make test JAVA_ARGS="-Xint"
```
2. The default behaviour is to stop the run on the first test failures (just using the built in make
behaviour of exiting when a command exits with a non-zero return code, which is what an STF test does).
To continue to run tests even after a failure use the make -k (or --keep-going) option.
```
make -k test
```
3. If a LOGDIR is specified, then a line is added to the file LOGDIR/openjdk.results.log for each
test executed. This is provided so that there is a record
kept of failed tests even though the stdout for the test may no longer be visible from the terminal
being used to execute the tests. e.g.
```
make test LOGDIR=$HOME
```
LOGDIR must exist prior to invoking the test.

The commands which write to the log file always succeed whether or not the preceding test passed or failed.
This means that all the tests will be run if LOGDIR= is used even if the make -k (keep going) option is not used. 

### Executing a test plan
Individual projects also contain testplan.xml files which define more elaborate plans combining the test cases
with different java options.  These files need to be processed by the test execution tools in the openjdk-test
repository to generate makefiles to run the tests.

### Running stf.pl directly
For debugging test failures and developing new tests you are likely to want to STF directly on the command line yourself.
```
perl $HOME/git/stf/stf.pl -test-root="$HOME/git/openjdk-systemtest" -list
```
will list all the tests in the stf and openjdk-systemtest repositories (the stf repository contains sample tests).
```
perl $HOME/git/stf/stf.pl -test-root="$HOME/git/openjdk-systemtest" -test=xxxx
```
will execute the test xxxx.  
Some tests require test specific arguments:
```
perl $HOME/git/stf/stf.pl -test-root="$HOME/git/openjdk-systemtest" -test=xxxx
```
JVM arguments can be passed to the Java command run during the test via:
```
perl $HOME/git/stf/stf.pl -test-root="$HOME/git/openjdk-systemtest" -java-args="-Xint" -test=xxxx
```
For a full list of ways to direct stf behaviour refer to the stf documentation in the stf repository https://github.com/AdoptOpenJDK/stf.

