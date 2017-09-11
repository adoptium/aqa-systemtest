# openjdk-systemtest

This repository contains the test cases which can be run against an Oracle based (e.g. OpenJDK) or IBM based java implementation.

The tests all run under the [STF System Test Framework](https://github.com/AdoptOpenJDK/stf).

[Quick start (Unix)](#unix)  
[Quick start (Windows)](#windows)  
[More documentation](openjdk.build/docs/build.md)

<a name="unix"></a>
## Quick start (Unix)

This quick start is for people who want to clone and build the project.  To set up a development environment for creating new test cases, refer to [this document](openjdk.build/docs/build.md).

Before running the build for the first time make sure GNU make, ant, cvs and wget are on your PATH.

cvs and wget are only required for the make configure step, which only needs to be done once.

Either copy, paste and execute [this script](openjdk.build/scripts/openjdk-systemtest-clone-make.sh) which runs the command below, or run the commands yourself.


```shell
# 1. Create a directory for the git clone
mkdir -p $HOME/git

# 2. Clone the STF repository
cd $HOME/git
git clone git@github.com:AdoptOpenJDK/stf.git stf

# 3. Clone the openjdk-systemtest repository
cd $HOME/git
git clone git@github.com:AdoptOpenJDK/openjdk-systemtest.git openjdk-systemtest

# 4. Set JAVA_HOME to a Java 8 or later Java

export JAVA_HOME=<java-home>

# 5.Install the prereqs
# This requires wget and cvs to be on the PATH
cd $HOME/git/openjdk-systemtest/openjdk.build
make configure

# 6. Build
cd $HOME/git/openjdk-systemtest/openjdk.build
make

# 7. Run the tests (takes about an hour, depending on the test machine)
cd $HOME/git/openjdk-systemtest/openjdk.build
make test
echo See /tmp/stf to view the test results
```

<a name="windows"></a>
## Quick Start (Windows)

This quick start is for people who want to clone and build the project.  To set up a development environment for creating new test cases, refer to [this document](openjdk.build/docs/build.md).

Before running the build for the first time make sure GNU make, ant, cvs and wget are on your PATH.

cvs and wget are only required for the make configure step, which only needs to be done once.

Either copy, paste and execute [this script](openjdk.build/scripts/openjdk-systemtest-clone-make.bat) which runs the command below, or run the commands yourself.

```dos
REM 1. Create a directory for the git clones
mkdir c:\%USERPROFILE%\git

REM 2. Clone the STF repository
cd c:\%USERPROFILE%\git
git clone git@github.com:AdoptOpenJDK/stf.git stf

REM 3. Clone the test cases repository
cd c:\%USERPROFILE%\git
git clone git@github.com:AdoptOpenJDK/openjdk-systemtest.git openjdk-systemtest

REM 4. Set JAVA_HOME to a Java 8 or later Java
SET JAVA_HOME=<java-home>

REM 5. Get the test case prereqs
cd C:\%USERPROFILE%\git\openjdk-systemtest\openjdk.build
make configure

REM 6. Build
cd C:\%USERPROFILE%\git\openjdk-systemtest\openjdk.build
make

REM 7. Run the tests (takes about an hour, depending on the test machine)
cd C:\%USERPROFILE%\git\openjdk-systemtest\openjdk.build
make test
echo See c:\stf_temp to view the test results
```


