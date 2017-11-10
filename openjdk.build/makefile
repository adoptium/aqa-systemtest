# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

EMPTY=
SPACE=$(EMPTY) $(EMPTY)

define NEWLINE


endef

# Environment variable OSTYPE is set to cygwin if running under cygwin.
# When the shell is switched to cmd.exe OSTYPE is no longer set, so set a make
# macro if running under cygwin.
ifndef CYGWIN
  OSTYPE?=$(shell echo $$OSTYPE)
  ifeq ($(OSTYPE),cygwin)
    CYGWIN:=1
  else
    CYGWIN:=0
  endif
endif
#$(warning CYGWIN is $(CYGWIN))

# Use a macro to say whether we are running under Windows.
# Don't set it under cygwin yet, first we need to resolve any unix style paths.
ifeq ($(OS),Windows_NT)
  ifneq ($(CYGWIN),1)
    WINDOWS:=1
  endif
else
  UNIX:=1
endif

# Set a macro for the directory delimiter.
ifeq ($(WINDOWS),1)
  D:=\\
else
  D:=/
endif

# Work out the root directory name of the repository from the current makefile.

# Assumes directory structure is
#
# git repository is checked out to <testing_root>$(D)git$(D)openjdk-systemtest
# So
# <testing_root>$(D)git$(D)openjdk-systemtest$(D)test_project1
# <testing_root>$(D)git$(D)openjdk-systemtest$(D)test_project2
#
# STF repository is built into <testing_root>$(D)git$(D)stf
#
# prereqs are installed to <testing_root>$(D)systemtest_prereqs
# So
# <testing_root>$(D)systemtest_prereqs$(D)prereq1
# <testing_root>$(D)systemtest_prereqs$(D)prereq2
#
# To change override OPENJDK_SYSTEMTEST_ROOT, STF_ROOT and / or PREREQS_ROOT on the make command line
# make OPENJDK_SYSTEMTEST_ROOT=<my_OPENJDK_SYSTEMTEST_ROOT> STF_ROOT=<my_STF_ROOT> PREREQS_ROOT=<my_prereqs_root>

# The current makefile is the last makefile in MAKEFILE_LIST

#$(warning MAKEFILE_LIST is $(MAKEFILE_LIST))
ifeq ($(MAKEFILE_LIST),)
  $(warning The MAKEFILE_LIST variable is not supported, this inbuilt variable is available on gnu make 3.80+)
  $(warning Expecting the OPENJDK_SYSTEMTEST_ROOT variable set instead) 
  ifeq ($(OPENJDK_SYSTEMTEST_ROOT),)
    $(error The OPENJDK_SYSTEMTEST_ROOT variable is not set)
  endif
else
  CURRENT_MAKEFILE:=$(word $(words $(MAKEFILE_LIST)),$(MAKEFILE_LIST))
  #$(warning CURRENT_MAKEFILE is $(CURRENT_MAKEFILE))
  MAKEFILE_ROOT_DIR:=$(dir $(CURRENT_MAKEFILE))$(D)..
  #$(warning MAKEFILE_ROOT_DIR is $(MAKEFILE_ROOT_DIR))
  # Running pwd or dir will resolve any relative path (./ or ../) references.
  ifneq ($(WINDOWS),1)
    OPENJDK_SYSTEMTEST_ROOT:=$(shell cd "$(MAKEFILE_ROOT_DIR)"; pwd)
  else
    OPENJDK_SYSTEMTEST_ROOT:=$(strip $(subst Directory of,,$(shell dir "$(subst $(D),\,$(MAKEFILE_ROOT_DIR))" | findstr $(D)C:"Directory of")))
  endif
  # If we are running under cygwin, turn a /cygdrive/c style path into the real Windows path and then set the shell to cmd.exe.
  # The tests all expect to be running under real Windows.
  ifeq ($(CYGWIN),1)
    #$(warning Running under cygwin)
    #$(warning Before cygpath OPENJDK_SYSTEMTEST_ROOT set to $(OPENJDK_SYSTEMTEST_ROOT))
    OPENJDK_SYSTEMTEST_ROOT:=$(shell cygpath -m '$(OPENJDK_SYSTEMTEST_ROOT)')
  endif
endif
ifeq (,$(wildcard $(OPENJDK_SYSTEMTEST_ROOT)))
  $(error ERROR: OPENJDK_SYSTEMTEST_ROOT $(OPENJDK_SYSTEMTEST_ROOT) does not exist)
endif
$(warning OPENJDK_SYSTEMTEST_ROOT is $(OPENJDK_SYSTEMTEST_ROOT))

ifeq (,$(JAVA_HOME))
  $(error ERROR: JAVA_HOME not set)
endif
ifeq ($(CYGWIN),1)
  #$(warning Running cygpath -m '$(JAVA_HOME)')
  JAVA_HOME:=$(shell cygpath -m '$(JAVA_HOME)')
  #$(warning JAVA_HOME is $(JAVA_HOME))
endif
ifeq (,$(wildcard $(JAVA_HOME)))
  $(error ERROR: JAVA_HOME $(JAVA_HOME) does not exist)
endif

STF_ROOT:=$(OPENJDK_SYSTEMTEST_ROOT)$(D)..$(D)stf
TEST_STF_ROOT:=$(STF_ROOT)
#$(warning TEST_STF_ROOT is $(TEST_STF_ROOT))
ifeq ($(CYGWIN),1)
  #$(warning Running cygpath -m '$(TEST_STF_ROOT)')
  TEST_STF_ROOT:=$(shell cygpath -m '$(TEST_STF_ROOT)')
  #$(warning TEST_STF_ROOT is $(TEST_STF_ROOT))
else
  ifneq ($(WINDOWS),1)
    #$(warning Running cd "$(TEST_STF_ROOT)"; pwd)
    TEST_STF_ROOT:=$(shell cd "$(TEST_STF_ROOT)"; pwd)
  else
    # On Windows 'dir' won't work with double back slashes
    TEST_STF_ROOT:=$(subst $(D),\,$(TEST_STF_ROOT))
    #$(warning Running dir "$(TEST_STF_ROOT)")
    TEST_STF_ROOT:=$(subst \,$(D),$(strip $(subst Directory of,,$(shell dir "$(subst $(D),\,$(TEST_STF_ROOT))" | findstr $(D)C:"Directory of"))))
    #$(warning TEST_STF_ROOT is $(TEST_STF_ROOT))
  endif
endif
ifeq (,$(wildcard $(STF_ROOT)))
  $(error ERROR: STF directory $(STF_ROOT) does not exist.  Either setup the directory $(STF_ROOT) or use STF_ROOT=xxxx on the make command line to point to a different location.)
else
  STF_ROOT:=$(TEST_STF_ROOT)
endif
$(warning STF_ROOT is $(STF_ROOT))

# Check any directories supplied via PREREQS_ROOT are valid
# Note that on Windows 'dir' doesn't work with double back slashes
# Macro assignments within a foreach loop need to be eval'ed to execute as intended

# Set a default PREREQS_ROOT if not provided on the command line
PREREQS_ROOT=$(OPENJDK_SYSTEMTEST_ROOT)$(D)..$(D)..$(D)systemtest_prereqs
$(warning PREREQS_ROOT is $(PREREQS_ROOT))

# Add JCK_ROOT to the PREREQS_ROOT directories if one has been provided on the command line
ifneq (,$(JCK_ROOT))
  $(warning Adding JCK_ROOT $(JCK_ROOT) to PREREQS_ROOT $(PREREQS_ROOT))
  PREREQS_ROOT:=$(PREREQS_ROOT);$(JCK_ROOT)
  $(warning PREREQS_ROOT is now $(PREREQS_ROOT))
endif

# Change the semi-colon separated list of directories into a whitespace separated list
ABSOLUTE_PREREQS_ROOT_LIST:=$(subst ;, ,$(PREREQS_ROOT))
#$(warning ABSOLUTE_PREREQS_ROOT_LIST is $(ABSOLUTE_PREREQS_ROOT_LIST))

# On cygwin convert the PREREQS_ROOT paths to windows style path names
ifeq ($(CYGWIN),1)
  ABSOLUTE_PREREQS_ROOT_LIST:=$(foreach PREREQS_ROOT,$(ABSOLUTE_PREREQS_ROOT_LIST),$(shell cygpath -m '$(PREREQS_ROOT)'))
endif

# If make configure is being run, only one prereq directory can be supplied (or none when the default location will be used).
# Otherwise check that the directories exists (make configure will create the directory if necessary).
ifneq (,$(findstring configure,$(MAKECMDGOALS)))
  ifneq (1,$(words $(ABSOLUTE_PREREQS_ROOT_LIST)))
    $(error ERROR: Only one PREREQS_ROOT directory can be specified for make configure)
  endif
else
  # Use wildcard and filter-out to find any directories which don't exist
  EXISTING_PREREQS_ROOT_LIST:=$(wildcard $(ABSOLUTE_PREREQS_ROOT_LIST))
  #$(warning EXISTING_PREREQS_ROOT_LIST is $(EXISTING_PREREQS_ROOT_LIST))
  ERROR_PREREQS_ROOT_LIST:=$(filter-out $(EXISTING_PREREQS_ROOT_LIST),$(ABSOLUTE_PREREQS_ROOT_LIST))
  $(foreach ERROR_PREREQS_ROOT,$(ERROR_PREREQS_ROOT_LIST),$(warning ERROR: PREREQS_ROOT directory $(ERROR_PREREQS_ROOT) does not exist. Either setup the directory $(ERROR_PREREQS_ROOT) or use PREREQS_ROOT=xxxx on the make command line to point to a different location.   Running make configure will get most of the prereqs.  See openjdk.build/docs/build.md for more details.))
  ifneq (,$(ERROR_PREREQS_ROOT_LIST))
    $(error )
  endif
endif

# Put the semi colons back into the list of prereq directories for passing to ant or stf.
RESOLVED_PREREQS_ROOT:=$(subst $(SPACE),;,$(ABSOLUTE_PREREQS_ROOT_LIST))
$(warning RESOLVED_PREREQS_ROOT is $(RESOLVED_PREREQS_ROOT))

# Now we have finished converting cygwin paths, set the SHELL for any tests to be cmd.exe.
# All the tests expect to be running under real Windows.
ifeq ($(CYGWIN),1)
  UNIX:=0
  WINDOWS:=1
  SHELL:=cmd.exe
endif

# If we are running under cygwin we have resolved ant unix style paths and set the shell to cmd.exe.
# So now set more macros for Windows / Unix differences.
ifeq ($(WINDOWS),1)
  ESC:=^
  ESC_DQ:="""
  D:=\\
  P:=;
  EXE:=.exe
  BAT:=.bat
  TEMP?=C:\\TEMP
  CAT:=type
  WHICH=where
  NULL=nul
  EXPORT=set
  OS_DATE_WITH_SLASHES = $(strip $(shell cmd.exe /C DATE /T))
  OS_DATE_WITHOUT_SLASHES = $(subst /,-,$(OS_DATE_WITH_SLASHES))
  OS_DATE = $(subst $(space),,$(OS_DATE_WITHOUT_SLASHES))
  OS_TIME_WITH_COLONS = $(strip $(shell cmd.exe /C TIME /T))
  OS_TIME_WITHOUT_COLONS = $(subst :,-,$(OS_TIME_WITH_COLONS))
  OS_TIME = $(subst $(space),,$(OS_TIME_WITHOUT_COLONS))
else
  ESC:=\$(EMPTY)
  ESC_DQ:=\"
  D:=/
  P:=:
  EXE:=
  BAT:=
  TMP?=$(D)tmp
  TEMP?=$(TMP)
  CAT:=cat
  WHICH=which
  NULL=$(D)dev$(D)null
  EXPORT=export
  OS_DATE = $(shell date +%d-%m-%y)
  OS_TIME = $(shell date +%H-%M-%S)
endif

# Make sure that we have the correct directory delimiters for Windows vs Unix.
# On windows set double back slashes in case a shell treats backslash as an escape character.
# First set any double back slashes to a single backslash, then set single backslashes to double backslashes.
# This avoids setting any double backslashes to four backslashes.
ifeq ($(WINDOWS),1)
  RESOLVED_PREREQS_ROOT:=$(subst /,\,$(RESOLVED_PREREQS_ROOT))
  RESOLVED_PREREQS_ROOT:=$(subst \\,\,$(RESOLVED_PREREQS_ROOT))
  RESOLVED_PREREQS_ROOT:=$(subst \,\\,$(RESOLVED_PREREQS_ROOT))
endif

# To build to a different location specify OPENJDK_SYSTEMTEST_TARGET_ROOT_TARGET_ROOT=<a directory> on the make command line
OPENJDK_SYSTEMTEST_TARGET_ROOT:=$(OPENJDK_SYSTEMTEST_ROOT)

ANT_LIB:=lib
ANT_LIB_PATH=$(ANT_HOME)$(D)$(ANT_LIB)
ANT_JAVA_HOME:=$(JAVA_HOME)
ANT_LAUNCHER=$(ANT_LIB_PATH)$(D)ant-launcher.jar

ifeq (,$(ANT_JAVA_HOME))
  $(warning ANT_JAVA_HOME not set, will use $(JAVA_HOME) to run ant)
endif

# See if there is a apache-ant-1.10.1 directory present in one of the $(PREREQS_ROOT) directories.
ANT_SUBDIR:=apache-ant-1.10.1
ANT_1.10.1_DIRS:=$(foreach PREREQS_ROOT,$(ABSOLUTE_PREREQS_ROOT_LIST),$(wildcard $(PREREQS_ROOT)$(D)$(ANT_SUBDIR)))
ANT_1.10.1_DIR:=$(firstword $(ANT_1.10.1_DIRS))
#$(warning ANT_1.10.1_DIRS is $(ANT_1.10.1_DIRS))
#$(warning ANT_1.10.1_DIR is $(ANT_1.10.1_DIR))
ifeq (,$(ANT_1.10.1_DIR))
  $(warning No ant dir found in $(PREREQS_ROOT))
endif

ifndef ANT_HOME
  # If we haven't been told which ant to use via ANT_HOME, see if there is an ant present in one of the $(PREREQS_ROOT) directories?
  # If not, try to find ant on the path and use that one.
  ifndef ANT_1.10.1_DIR
    $(warning ANT_HOME not set, and apache-ant-1.10.1 was not found in $(PREREQS_ROOT), looking for ant on the PATH)
    ANT_NOT_FOUND:=1
  else
    ANT_HOME:=$(ANT_1.10.1_DIR)
    ifneq (,$(wildcard $(ANT_LAUNCHER)))
      $(warning Found $(ANT_LAUNCHER))
    else
      $(warning Cannot find $(ANT_LAUNCHER), looking for ant on the PATH)
      ANT_NOT_FOUND:=1
    endif
  endif
  ifeq (1,$(ANT_NOT_FOUND))
    # On Windows run where ant.bat
    # On Unix run which ant, and use realpath to resolve symlinks (ant is likely to be symlinked e.g. to usr$(D)bin$(D)ant).
    ifeq ($(WINDOWS),1)
      ANT_BINDIR:=$(dir $(firstword $(shell $(WHICH) ant$(BAT) 2>$(NULL))))
      $(warning $(WHICH) ant$(BAT) 2>$(NULL) returned)
      $(warning $(ANT_BINDIR))
      ifneq (,$(ANT_BINDIR))
        ANT_HOME:=$(ANT_BINDIR)$(D)..
        $(warning ANT_HOME set to $(ANT_HOME))
        $(warning Found $(ANT_BINDIR), will start build with $(ANT_LAUNCHER).  Run make configure to install the required ant version 1.10.1 or follow the prereq install instructions in build$(D)build.md)
      else
        $(error Unable to locate ant to start the build. Either add ant to PATH, set ANT_HOME or follow the prereq install instructions in openjdk.build$(D)docs$(D)build$(D)build.md)
      endif
    else  # Unix
      ANT_BINDIR:=$(dir $(firstword $(shell $(WHICH) ant$(BAT) 2>$(NULL))))
      $(warning $(WHICH) ant$(BAT) 2>$(NULL) returned)
      $(warning $(ANT_BINDIR))
      ifneq (,$(ANT_BINDIR))
        ANT_BINDIR:=$(realpath $(ANT_BINDIR)$(D)ant$(BAT))
        ANT_HOME:=$(abspath $(ANT_BINDIR)$(D)..$(D)..)
        $(warning ANT_HOME set to $(ANT_HOME))
        $(warning Found $(ANT_BINDIR), will start build with $(ANT_LAUNCHER).  Run make configure to install the required ant version 1.10.1 or follow the prereq install instructions in build$(D)build.md)
        ifeq (,$(wildcard $(ANT_LIB_PATH)))
        # On OSX if ant has been installed using homebrew cater for the ant-launcher.jar being in libexec/lib rather than lib.
        $(warning WARNING: Cannot find $(ANT_LIB_PATH) directory. Looking in libexec/lib.)
          ANT_LIB:=libexec$(D)lib
          ifeq (,$(wildcard $(ANT_LIB_PATH)))
            $(error ERROR: ANT_LIB_PATH directory $(ANT_LIB_PATH) does not exist.)
          endif
        endif
      else
        $(error Unable to locate ant to start the build. Either add ant to PATH, set ANT_HOME or follow the prereq install instructions in build$(D)build.md)
      endif
    endif
  endif
endif


ifeq (1,$(ERROR))
  $(error Fix above errors and retry)
endif

$(warning JAVA_HOME is $(JAVA_HOME))
JAVA:=$(JAVA_HOME)$(D)bin$(D)java$(EXE)
JAVA_OUTPUT:=$(shell $(JAVA) -fullversion 2>&1)
$(warning $(JAVA) -fullversion returned)
$(warning $(JAVA_OUTPUT))

ifneq (,$(JAVA8_HOME))
  $(warning JAVA8_HOME is $(JAVA8_HOME))
  JAVA8:=$(JAVA8_HOME)$(D)bin$(D)java$(EXE)
  JAVAC8:=$(JAVA8_HOME)$(D)bin$(D)javac$(EXE)
  JAVA8_OUTPUT:=$(shell $(JAVA8) -fullversion 2>&1)
  $(warning $(JAVA8) -fullversion returned)
  $(warning $(JAVA8_OUTPUT))
else
  #$(warning JAVA8_HOME not set, will use $(JAVA_HOME) as java8 compiler)
  JAVA8_HOME:=$(JAVA_HOME)
endif

ifneq (,$(JAVA9_HOME))
  $(warning JAVA9_HOME is $(JAVA9_HOME))
  JAVA9:=$(JAVA9_HOME)$(D)bin$(D)java$(EXE)
  JAVAC9:=$(JAVA9_HOME)$(D)bin$(D)javac$(EXE)
  JAVA9_OUTPUT:=$(shell $(JAVA9) -fullversion 2>&1)
  $(warning $(JAVA9) -fullversion returned)
  $(warning $(JAVA9_OUTPUT))
else
  #$(warning JAVA9_HOME not set, will use $(JAVA_HOME) as java9 compiler)
  JAVA9_HOME:=$(JAVA_HOME)
endif

BUILD_COMMAND:=$(ANT_JAVA_HOME)$(D)bin$(D)java$(EXE) -classpath $(ANT_LAUNCHER) org.apache.tools.ant.launch.Launcher -buildfile $(OPENJDK_SYSTEMTEST_TARGET_ROOT)$(D)openjdk.build$(D)build.xml -Dprereqs_root="$(RESOLVED_PREREQS_ROOT)" -Dstf_root=$(STF_ROOT)
BUILD_COMMAND:=$(BUILD_COMMAND) -Djava8_home=$(JAVA8_HOME)
BUILD_COMMAND:=$(BUILD_COMMAND) -Djava9_home=$(JAVA9_HOME)

# Provide a means for users to pass -java-args to the STF tests
# Java arguments may contain imbedded quotes.  These need to be escaped on the STF command line.
# An IBM (test / debugging) arguments example:
# java -Xjit:counts="- - - - - - 1 1 1 1000 250 250 - - - 10000 100000 10000" -Xgcpolicy:optthruput
# requires on Windows
# stf.pl -java-args="-Xjit:counts="""- - - - - - 1 1 1 1000 250 250 - - - 10000 100000 10000""" -Xgcpolicy:optthruput"
# and on unix
# stf.pl -java-args="-Xjit:counts=\"- - - - - - 1 1 1 1000 250 250 - - - 10000 100000 10000\" -Xgcpolicy:optthruput"

# For the JCK tests the arguments need to be added to the .jtb configuration file which is created
# during the stf setup phase, so the java-args-setup option needs to be used rather than the usual
# -java-args argument
ifneq (,$(JAVA_ARGS))
  ifneq (,$(findstring jck,$(MAKECMDGOALS)))
    JAVA_ARGS_ARG=-java-args-setup="$(subst ",$(ESC_DQ),$(JAVA_ARGS))"
  else
    JAVA_ARGS_ARG=-java-args="$(subst ",$(ESC_DQ),$(JAVA_ARGS))"
  endif
endif

ifneq (,$(REPEAT_ARG))
	REPEAT_ARG_ARG:=-repeat=$(REPEAT_ARG)
endif

ifneq (,$(RESULTS_ROOT))
	RESULTS_ROOT_ARG:=-results-root="$(RESULTS_ROOT)"
endif

STF_COMMAND:=perl $(STF_ROOT)$(D)stf.core$(D)scripts$(D)stf.pl $(JAVA_ARGS_ARG) -test-root="$(STF_ROOT);$(OPENJDK_SYSTEMTEST_TARGET_ROOT)" -systemtest-prereqs="$(RESOLVED_PREREQS_ROOT)" $(REPEAT_ARG_ARG) $(RESULTS_ROOT_ARG)

# Macros to allow the tests to run to completion with a log of what passed and failed.
# To turn on run 
# make test LOGDIR=/home/user/logs
# or similar on the command line.
# To carry on running even after failures use the make -k option
# make -k test LOGDIR=/home/user/logs

ifneq (,$(LOGDIR))
  LOG=&& echo Started $(OS_DATE) $(OS_TIME) $@ Passed >>$(LOGDIR)/openjdk.results.log || echo Started $(OS_DATE) $(OS_TIME) $@ Failed >>$(LOGDIR)/openjdk.results.log
endif

# Some JCK tests require properties files for Kerberos and http server settings.
# They need to be placed in <JCK_ROOT>/jck/<jck-version>/config/<settings-dir>
# settings-dir is set by passing -test-args="config=<settings-dir>" to the STF Jck test.
# The JCK_CONFIG macro allows the user to override this value on the command line.
# The default is to look fro a directory called 'default'.
JCK_CONFIG=default

# Targets to run the non-JCK tests
LOAD_TESTS:= test.ClassloadingLoadTest \
test.ConcurrentLoadTest \
test.DirectByteBufferLoadTest \
test.HCRLateAttachWorkload \
test.JdiTest \
test.LangLoadTest \
test.LockingLoadTest \
test.MathLoadTest_autosimd \
test.MathLoadTest_bigdecimal \
test.MathLoadTest_all \
test.MauveSingleInvocationLoadTest \
test.MauveSingleThreadLoadTest \
test.MauveMultiThreadLoadTest \
test.NioLoadTest \
test.SerializationLoadTest \
test.UtilLoadTest \
test.LambdaLoadTest 

TEST_TARGETS:= \
$(LOAD_TESTS)

# Allow the user to exclude tests from the command line

TEST_TARGETS:=$(filter-out $(EXCLUDE),$(TEST_TARGETS))

.PHONY: build configure clean refresh_source test $(TEST_TARGETS)

# Targets to configure and build
build: refresh_source
	echo Running target $@
	$(BUILD_COMMAND) build
configure:
	echo Running target $@
	$(BUILD_COMMAND) configure
clean:
	echo Running target $@
	$(BUILD_COMMAND) clean
clean-prereqs:
	echo Running target $@
	$(BUILD_COMMAND) clean-prereqs
refresh_source:
ifneq ($(OPENJDK_SYSTEMTEST_ROOT),$(OPENJDK_SYSTEMTEST_TARGET_ROOT))
	echo Running target $@
ifeq ($(WINDOWS),1)
	xcopy /D /E /Y /I $(OPENJDK_SYSTEMTEST_ROOT) $(OPENJDK_SYSTEMTEST_TARGET_ROOT)
endif
endif

test: $(TEST_TARGETS)
test.load: $(LOAD_TESTS)

test.list:
	echo Running target $@
	$(STF_COMMAND) -list $(LOG)
	echo Target $@ completed
test.help:
	echo Running target $@
	$(STF_COMMAND) -test=ConcurrentLoadTest -help $(LOG)
	echo Target $@ completed
test.ClassloadingLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=ClassloadingLoadTest $(LOG)
	echo Target $@ completed
test.ConcurrentLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=ConcurrentLoadTest $(LOG)
	echo Target $@ completed
test.DirectByteBufferLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=DirectByteBufferLoadTest $(LOG)
	echo Target $@ completed
test.HCRLateAttachWorkload:
	echo Running target $@
	$(STF_COMMAND) -test=HCRLateAttachWorkload $(LOG)
	echo Target $@ completed
test.JdiTest:
	echo Running target $@
	$(STF_COMMAND) -test=JdiTest $(LOG)
	echo Target $@ completed
test.LangLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=LangLoadTest $(LOG)
	echo Target $@ completed
test.LockingLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=LockingLoadTest $(LOG)
	echo Target $@ completed
test.MathLoadTest_all:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest $(LOG)
	echo Target $@ completed
test.MathLoadTest_autosimd:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=autoSimd" $(LOG)
	echo Target $@ completed
test.MathLoadTest_bigdecimal:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=bigDecimal" $(LOG)
	echo Target $@ completed
test.MauveSingleThreadLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MauveSingleThreadLoadTest $(LOG)
	echo Target $@ completed
test.MauveSingleInvocationLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MauveSingleInvocationLoadTest $(LOG)
	echo Target $@ completed
test.MauveMultiThreadLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MauveMultiThreadLoadTest $(LOG)
	echo Target $@ completed
test.NioLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=NioLoadTest $(LOG)
	echo Target $@ completed
test.UtilLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=UtilLoadTest $(LOG)
	echo Target $@ completed
test.SerializationLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=SerializationLoadTest $(LOG)
	echo Target $@ completed
test.LambdaLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=LambdaLoadTest $(LOG)
	echo Target $@ completed

# The test.Custom target enables users to execute arbitrary stf.pl command lines if required for investigating failures.
# Example:
# make test.Custom TEST=JdiTest TEST_ARGS="test=basic_launch" 
test.Custom:
	echo Running target $@
	$(STF_COMMAND) -test=$(TEST) -test-args="$(TEST_ARGS)" $(LOG)
	echo Target $@ completed

help:
	@echo -------------------------------------------------------------------------------
	@echo Help for openjdk.build makefile
	@echo -------------------------------------------------------------------------------
	@echo make or make build: Builds openjdk-systemtest projects
	@echo -------------------------------------------------------------------------------
	@echo make test: Runs all non-JCK openjdk-systemtest tests
	@echo make $(TEST_TARGETS): Runs all openjdk-systemtest tests
	@echo make test.xxxx: Runs individual test xxxx
	@echo make test EXCLUDE=$(ESC)"test.xxxx test.yyyy$(ESC)": Runs all tests except test.xxxx and test.yyyy
	@echo -------------------------------------------------------------------------------
	@echo make help.jck: Shows help for JCK test targets.

include $(subst $(SPACE),\$(SPACE),$(OPENJDK_SYSTEMTEST_ROOT)/openjdk.test.jck/include/test_targets.mk)
