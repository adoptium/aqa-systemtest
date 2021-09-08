# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
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
# Set our own macro to indicate we're running under cygwin.
# Also Windows commands will need to be prefixed with cmd /c to run them in a Windows shell.ifndef CYGWIN
ifndef CYGWIN
  OSTYPE?=$(shell echo $$OSTYPE)
  ifeq ($(OSTYPE),cygwin)
    CYGWIN:=1
    CMD_PREFIX:=cmd /c
  else
    CYGWIN:=0
  endif
endif
#$(warning CYGWIN is $(CYGWIN))

# Use a macro to say whether we are running under Windows.
# Don't set it under cygwin yet, first we need to resolve any unix style paths.
# If we're on Windows, set the shell for started processes to be cmd.exe, otherwise
# if the Windows environment has a unix style shell on the path, make will invoke
# that, and then Windows commands may not work as expected.
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
# git repository is checked out to <testing_root>$(D)git$(D)aqa-systemtest
# So
# <testing_root>$(D)git$(D)aqa-systemtest$(D)test_project1
# <testing_root>$(D)git$(D)aqa-systemtest$(D)test_project2
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
    OPENJDK_SYSTEMTEST_ROOT:=$(strip $(subst Directory of,,$(shell $(CMD_PREFIX) dir "$(subst $(D),\,$(MAKEFILE_ROOT_DIR))" | findstr $(D)C:"Directory of")))
  endif
  # If we are running under cygwin, turn a /cygdrive/c style path into the real Windows path and then set the shell to cmd.exe.
  # The tests all expect to be running under real Windows.
  ifeq ($(CYGWIN),1)
    #$(warning Running under cygwin)
    #$(warning Before cygpath OPENJDK_SYSTEMTEST_ROOT set to $(OPENJDK_SYSTEMTEST_ROOT))
    OPENJDK_SYSTEMTEST_ROOT:=$(shell $(CMD_PREFIX) cygpath -m '$(OPENJDK_SYSTEMTEST_ROOT)')
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
  JAVA_HOME:=$(shell $(CMD_PREFIX) cygpath -m '$(JAVA_HOME)')
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
  TEST_STF_ROOT:=$(shell $(CMD_PREFIX) cygpath -m '$(TEST_STF_ROOT)')
  #$(warning TEST_STF_ROOT is $(TEST_STF_ROOT))
else
  ifneq ($(WINDOWS),1)
    #$(warning Running cd "$(TEST_STF_ROOT)"; pwd)
    TEST_STF_ROOT:=$(shell cd "$(TEST_STF_ROOT)"; pwd)
  else
    # On Windows 'dir' won't work with double back slashes
    TEST_STF_ROOT:=$(subst $(D),\,$(TEST_STF_ROOT))
    #$(warning Running $(CMD_PREFIX) dir "$(TEST_STF_ROOT)")
    TEST_STF_ROOT:=$(subst \,$(D),$(strip $(subst Directory of,,$(shell $(CMD_PREFIX) dir "$(subst $(D),\,$(TEST_STF_ROOT))" | findstr $(D)C:"Directory of"))))
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
  ABSOLUTE_PREREQS_ROOT_LIST:=$(foreach PREREQS_ROOT,$(ABSOLUTE_PREREQS_ROOT_LIST),$(shell $(CMD_PREFIX) cygpath -m '$(PREREQS_ROOT)'))
endif

# If make configure is being run, only one prereq directory can be supplied (or none when the default location will be used).
# Otherwise check that the directories exists (make configure will create the directory if necessary).
ifneq (,$(findstring configure,$(MAKECMDGOALS)))
  ifneq (1,$(words $(ABSOLUTE_PREREQS_ROOT_LIST)))
    $(error ERROR: Only one PREREQS_ROOT directory can be specified for make configure)
  endif
else
  # Use wildcard and filter-out to find any directories which don't exist
  # If substr <drive> has been used for paths on Windows, wildcard seems to not work properly
  # if backslashes are used in the paths, so change to forward slashes before checking.
  CHECK_PREREQS_ROOT_LIST:=$(subst \,/,$(ABSOLUTE_PREREQS_ROOT_LIST))
  CHECK_PREREQS_ROOT_LIST:=$(subst //,/,$(CHECK_PREREQS_ROOT_LIST))
  EXISTING_PREREQS_ROOT_LIST:=$(wildcard $(CHECK_PREREQS_ROOT_LIST))
  #$(warning EXISTING_PREREQS_ROOT_LIST is $(EXISTING_PREREQS_ROOT_LIST))
  ERROR_PREREQS_ROOT_LIST:=$(filter-out $(EXISTING_PREREQS_ROOT_LIST),$(CHECK_PREREQS_ROOT_LIST))
  $(foreach ERROR_PREREQS_ROOT,$(ERROR_PREREQS_ROOT_LIST),$(warning ERROR: PREREQS_ROOT directory $(ERROR_PREREQS_ROOT) does not exist. Either setup the directory $(ERROR_PREREQS_ROOT) or use PREREQS_ROOT=xxxx on the make command line to point to a different location.  Running make configure will get most of the prereqs.  See openjdk.build/docs/build.md for more details.))
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
  WHICH:=where
  NULL=nul
  EXPORT:=set
  OS_DATE_WITH_SLASHES = $(strip $(shell cmd.exe /C DATE /T))
  OS_DATE_WITHOUT_SLASHES = $(subst /,-,$(OS_DATE_WITH_SLASHES))
  OS_DATE = $(subst $(space),,$(OS_DATE_WITHOUT_SLASHES))
  OS_TIME_WITH_COLONS = $(strip $(shell cmd.exe /C TIME /T))
  OS_TIME_WITHOUT_COLONS = $(subst :,-,$(OS_TIME_WITH_COLONS))
  OS_TIME = $(subst $(space),,$(OS_TIME_WITHOUT_COLONS))
  ifeq ($(CYGWIN),1)
    EXPORT:=export
    # If we are running under cygwin, the tests need to run with a Windows perl port (e.g. Strawberry perl) rather
    # than the cygwin perl port. This assumes that version will be in a directory ending /perl/bin directory
    # and the cygwin version will not. Once found, that version of perl is added ahead of cygwin perl in the PATH.
    $(warning Running under cygwin, looking for Windows perl on path)
    PERL:=$(shell which -a perl.exe | grep /perl/bin | sort | uniq)
    ifeq (,$(PERL))
      $(error Unable to find Windows perl e.g. Strawberry perl in a /perl/bin subdirectory on PATH.  Install perl or add to PATH and retry)
    else
      $(warning Found perl in $(PERL))
    endif
    PERL:=$(dir $(PERL))
    export PATH:=$(PERL):$(PATH)
  endif
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

# See if there is a apache-ant directory present in one of the $(PREREQS_ROOT) directories.
ANT_SUBDIR:=apache-ant
ANT_DIRS:=$(foreach PREREQS_ROOT,$(ABSOLUTE_PREREQS_ROOT_LIST),$(wildcard $(PREREQS_ROOT)$(D)$(ANT_SUBDIR)))
ANT_DIR:=$(firstword $(ANT_DIRS))
#$(warning ANT_DIRS is $(ANT_DIRS))
#$(warning ANT_DIR is $(ANT_DIR))
ifeq (,$(ANT_DIR))
  $(warning No ant dir found in $(PREREQS_ROOT))
endif

ifndef ANT_HOME
  # If we haven't been told which ant to use via ANT_HOME, see if there is an ant present in one of the $(PREREQS_ROOT) directories?
  # If not, try to find ant on the path and use that one.
  ifndef ANT_DIR
    $(warning ANT_HOME not set, and apache-ant was not found in $(PREREQS_ROOT), looking for ant on the PATH)
    ANT_NOT_FOUND:=1
  else
    ANT_HOME:=$(ANT_DIR)
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
      ANT_BINDIR:=$(dir $(firstword $(shell $(CMD_PREFIX) $(WHICH) ant$(BAT) 2>$(NULL))))
      $(warning $(CMD_PREFIX) $(WHICH) ant$(BAT) 2>$(NULL) returned)
      $(warning $(ANT_BINDIR))
      ifneq (,$(ANT_BINDIR))
        ANT_HOME:=$(ANT_BINDIR)$(D)..
        $(warning ANT_HOME set to $(ANT_HOME))
        $(warning Found $(ANT_BINDIR), will start build with $(ANT_LAUNCHER).  Run make configure to install the required ant version or follow the prereq install instructions in build$(D)build.md)
      else
        $(error Unable to locate ant to start the build. Either add ant to PATH, set ANT_HOME or follow the prereq install instructions in openjdk.build$(D)docs$(D)build$(D)build.md)
      endif
    else # Unix
      ANT_BINDIR:=$(dir $(firstword $(shell $(WHICH) ant$(BAT) 2>$(NULL))))
      $(warning $(WHICH) ant$(BAT) 2>$(NULL) returned)
      $(warning $(ANT_BINDIR))
      ifneq (,$(ANT_BINDIR))
        ANT_BINDIR:=$(realpath $(ANT_BINDIR)$(D)ant$(BAT))
        ANT_HOME:=$(abspath $(ANT_BINDIR)$(D)..$(D)..)
        $(warning ANT_HOME set to $(ANT_HOME))
        $(warning Found $(ANT_BINDIR), will start build with $(ANT_LAUNCHER).  Run make configure to install the required ant version or follow the prereq install instructions in build$(D)build.md)
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
JAVAC:=$(JAVA_HOME)$(D)bin$(D)javac$(EXE)
JAVA_OUTPUT:=$(shell $(CMD_PREFIX) $(JAVA) -fullversion 2>&1)
$(warning $(JAVA) -fullversion returned)
$(warning $(JAVA_OUTPUT))

BUILD_COMMAND:=$(CMD_PREFIX) $(ANT_JAVA_HOME)$(D)bin$(D)java$(EXE) -classpath $(ANT_LAUNCHER) org.apache.tools.ant.launch.Launcher -buildfile $(OPENJDK_SYSTEMTEST_TARGET_ROOT)$(D)openjdk.build$(D)build.xml -Dprereqs_root="$(RESOLVED_PREREQS_ROOT)" -Dstf_root=$(STF_ROOT)
BUILD_COMMAND:=$(BUILD_COMMAND) -Djava_home=$(JAVA_HOME)

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

ifeq ($(RM_PASS),1)
  RM_PASS_ARG:=-rm-pass
endif

ifneq (,$(REPEAT_ARG))
  REPEAT_ARG_ARG:=-repeat=$(REPEAT_ARG)
endif

# enable the user to override results-root from make command line
ifneq (,$(RESULTS_ROOT))
  RESULTS_ROOT_ARG:=-results-root="$(RESULTS_ROOT)"
endif

# enable the user to override results-root from make command line
ifneq (,$(RETAIN))
  RETAIN_ARG:=-retain="$(RETAIN)"
endif

# enable the user to override results-root from make command line
ifneq (,$(RETAIN_LIMIT))
  RETAIN_LIMIT_ARG:=-retain-limit="$(RETAIN_LIMIT)"
endif

STF_COMMAND:=$(CMD_PREFIX) perl $(STF_ROOT)$(D)stf.core$(D)scripts$(D)stf.pl $(JAVA_ARGS_ARG) -test-root="$(STF_ROOT);$(OPENJDK_SYSTEMTEST_TARGET_ROOT)" -systemtest-prereqs="$(RESOLVED_PREREQS_ROOT)" $(REPEAT_ARG_ARG) $(RESULTS_ROOT_ARG) $(RETAIN_ARG) $(RETAIN_LIMIT_ARG) $(RM_PASS_ARG)

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
test.LambdaLoadTest \
test.CpMpTest_CpMp \
test.CpMpTest_MP \
test.CpMpTest2 \
test.CpMpTest3 \
test.CpMpModularJarTest \
test.CpMpModularJarTest2 \
test.CpMpModularJarTest3 \
test.JDKInternalAPIsTest \
test.AutomaticModulesTest1 \
test.AutomaticModulesTest2 \
test.AutomaticModulesTest_ImpliedReadabilityTest1 \
test.AutomaticModulesTest_ImpliedReadabilityTest2 \
test.AutomaticModulesTest_ImpliedReadabilityTest3 \
test.ExplicitModulesTest \
test.JDKInternalAPIsTest \
test.ServiceLoadersTest \
test.PatchModuleTest_PlatformModPatchModule \
test.PatchModuleTest_AppModPatchModule \
test.PatchModuleTest_UnexportedTypePatchModule \
test.PatchModuleTest_AdvancedPatchModule \
test.PatchModuleImageTest_PlatformModPatchModule \
test.PatchModuleImageTest_AppModPatchModule \
test.PatchModuleImageTest_UnexportedTypePatchModule \
test.PatchModuleImageTest_AdvancedPatchModule \
test.UpgradeModPathTest_ExpDirModUpgrade \
test.UpgradeModPathTest_ExpDirModUpgradeCRImage \
test.UpgradeModPathTest_JarredModUpgrade \
test.UpgradeModPathTest_JarredModUpgradeCRImage \
test.JlinkTest_RequiredMod \
test.JlinkTest_AddModLimitMod \
test.CpMpJlinkTest \
test.JlinkPluginOptionsTest_GeneralOptionsTest \
test.LayersTest \
test.CLTest \
test.CLTestImage \
test.CLLoadTest \
test.CLStressWithLayers \
test.CLStressWithLayersCRI \
test.TestJlmLocal \
test.TestJlmRemoteClassAuth \
test.TestJlmRemoteClassNoAuth \
test.TestJlmRemoteMemoryAuth \
test.TestJlmRemoteMemoryNoAuth \
test.TestJlmRemoteNotifierProxyAuth \
test.TestJlmRemoteThreadNoAuth \
test.MixedLoadTest \
test.OAuthTest

# Tests which won't run on Java 8
NOT_JAVA8_TESTS:=\
test.CpMpTest_CpMp \
test.CpMpTest_MP \
test.CpMpTest2 \
test.CpMpTest3 \
test.CpMpModularJarTest \
test.CpMpModularJarTest2 \
test.CpMpModularJarTest3 \
test.JDKInternalAPIsTest \
test.AutomaticModulesTest1 \
test.AutomaticModulesTest2 \
test.AutomaticModulesTest_ImpliedReadabilityTest1 \
test.AutomaticModulesTest_ImpliedReadabilityTest2 \
test.AutomaticModulesTest_ImpliedReadabilityTest3 \
test.ExplicitModulesTest \
test.JDKInternalAPIsTest \
test.ServiceLoadersTest \
test.PatchModuleTest_PlatformModPatchModule \
test.PatchModuleTest_AppModPatchModule \
test.PatchModuleTest_UnexportedTypePatchModule \
test.PatchModuleTest_AdvancedPatchModule \
test.PatchModuleImageTest_PlatformModPatchModule \
test.PatchModuleImageTest_AppModPatchModule \
test.PatchModuleImageTest_UnexportedTypePatchModule \
test.PatchModuleImageTest_AdvancedPatchModule \
test.UpgradeModPathTest_ExpDirModUpgrade \
test.UpgradeModPathTest_ExpDirModUpgradeCRImage \
test.UpgradeModPathTest_JarredModUpgrade \
test.UpgradeModPathTest_JarredModUpgradeCRImage \
test.JlinkTest_RequiredMod \
test.JlinkTest_AddModLimitMod \
test.CpMpJlinkTest \
test.JlinkPluginOptionsTest_GeneralOptionsTest \
test.LayersTest \
test.CLTest \
test.CLTestImage \
test.CLLoadTest \
test.CLStressWithLayers \
test.CLStressWithLayersCRI

# Time-based load test targets
LOAD_TESTS_5m:= test.ClassloadingLoadTest_5m \
test.ConcurrentLoadTest_5m \
test.DirectByteBufferLoadTest_5m \
test.LangLoadTest_5m \
test.MathLoadTest_autosimd_5m \
test.MathLoadTest_bigdecimal_5m \
test.MathLoadTest_all_5m \
test.MauveSingleInvocationLoadTest_5m \
test.MauveSingleThreadLoadTest_5m \
test.MauveMultiThreadLoadTest_5m \
test.NioLoadTest_5m \
test.SerializationLoadTest_5m \
test.UtilLoadTest_5m \
test.LambdaLoadTest_5m \
test.MixedLoadTest_5m

TEST_TARGETS:=\
$(LOAD_TESTS) \
$(LOAD_TESTS_5m)

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
	$(CMD_PREFIX) xcopy /D /E /Y /I $(OPENJDK_SYSTEMTEST_ROOT) $(OPENJDK_SYSTEMTEST_TARGET_ROOT)
endif
endif

test: $(TEST_TARGETS)
test.load: $(LOAD_TESTS)
test.load.5m: $(LOAD_TESTS_5m)
test.java8: $(filter-out $(NOT_JAVA8_TESTS),$(TEST_TARGETS))

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
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=math" $(LOG)
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
	$(STF_COMMAND) -test=MauveSingleThrdLoad $(LOG)
	echo Target $@ completed
test.MauveSingleInvocationLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MauveSingleInvocLoad $(LOG)
	echo Target $@ completed
test.MauveMultiThreadLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MauveMultiThrdLoad $(LOG)
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
test.CpMpTest_CpMp:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpTest -test-args="variant=CpMp" $(LOG)
	echo Target $@ completed
test.CpMpTest_MP:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpTest -test-args="variant=Mp" $(LOG)
	echo Target $@ completed
test.CpMpTest2:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpTest2 $(LOG)
	echo Target $@ completed
test.CpMpTest3:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpTest3 $(LOG)
	echo Target $@ completed
test.CpMpModularJarTest:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpModularJarTest $(LOG)
	echo Target $@ completed
test.CpMpModularJarTest2:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpModularJarTest2 $(LOG)
	echo Target $@ completed
test.CpMpModularJarTest3:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpModularJarTest3 $(LOG)
	echo Target $@ completed
test.JDKInternalAPIsTest:
	echo Running target $@
	$(STF_COMMAND) -test=JDKInternalAPIsTest $(LOG)
	echo Target $@ completed
test.AutomaticModulesTest1:
	echo Running target $@
	$(STF_COMMAND) -test=AutomaticModulesTest -test-args="variant=AutomaticModulesTest1" $(LOG)
	echo Target $@ completed
test.AutomaticModulesTest2:
	echo Running target $@
	$(STF_COMMAND) -test=AutomaticModulesTest -test-args="variant=AutomaticModulesTest2" $(LOG)
	echo Target $@ completed
test.AutomaticModulesTest_ImpliedReadabilityTest1:
	echo Running target $@
	$(STF_COMMAND) -test=AutomaticModulesTest -test-args="variant=ImpliedReadabilityTest1" $(LOG)
	echo Target $@ completed
test.AutomaticModulesTest_ImpliedReadabilityTest2:
	echo Running target $@
	$(STF_COMMAND) -test=AutomaticModulesTest -test-args="variant=ImpliedReadabilityTest2" $(LOG)
	echo Target $@ completed
test.AutomaticModulesTest_ImpliedReadabilityTest3:
	echo Running target $@
	$(STF_COMMAND) -test=AutomaticModulesTest -test-args="variant=ImpliedReadabilityTest3" $(LOG)
	echo Target $@ completed
test.ExplicitModulesTest:
	echo Running target $@
	$(STF_COMMAND) -test=ExplicitModulesTest $(LOG)
	echo Target $@ completed
test.JDKInternalAPIsTest:
	echo Running target $@
	$(STF_COMMAND) -test=JDKInternalAPIsTest $(LOG)
	echo Target $@ completed
test.ServiceLoadersTest:
	echo Running target $@
	$(STF_COMMAND) -test=ServiceLoadersTest $(LOG)
	echo Target $@ completed
test.PatchModuleTest_PlatformModPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleTest -test-args="variant=PlatformModPatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleTest_AppModPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleTest -test-args="variant=AppModPatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleTest_UnexportedTypePatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleTest -test-args="variant=UnexportedTypePatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleTest_AdvancedPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleTest -test-args="variant=AdvancedPatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleImageTest_PlatformModPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleImageTest -test-args="variant=PlatformModPatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleImageTest_AppModPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleImageTest -test-args="variant=AppModPatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleImageTest_UnexportedTypePatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleImageTest -test-args="variant=UnexportedTypePatchModule" $(LOG)
	echo Target $@ completed
test.PatchModuleImageTest_AdvancedPatchModule:
	echo Running target $@
	$(STF_COMMAND) -test=PatchModuleImageTest -test-args="variant=AdvancedPatchModule" $(LOG)
	echo Target $@ completed
test.UpgradeModPathTest_ExpDirModUpgrade:
	echo Running target $@
	$(STF_COMMAND) -test=UpgradeModPathTest -test-args="variant=ExpDirModUpgrade" $(LOG)
	echo Target $@ completed
test.UpgradeModPathTest_ExpDirModUpgradeCRImage:
	echo Running target $@
	$(STF_COMMAND) -test=UpgradeModPathTest -test-args="variant=ExpDirModUpgradeCRImage" $(LOG)
	echo Target $@ completed
test.UpgradeModPathTest_JarredModUpgrade:
	echo Running target $@
	$(STF_COMMAND) -test=UpgradeModPathTest -test-args="variant=JarredModUpgrade" $(LOG)
	echo Target $@ completed
test.UpgradeModPathTest_JarredModUpgradeCRImage:
	echo Running target $@
	$(STF_COMMAND) -test=UpgradeModPathTest -test-args="variant=JarredModUpgradeCRImage" $(LOG)
	echo Target $@ completed
test.JlinkTest_RequiredMod:
	echo Running target $@
	$(STF_COMMAND) -test=JlinkTest -test-args="variant=RequiredMod" $(LOG)
	echo Target $@ completed
test.JlinkTest_AddModLimitMod:
	echo Running target $@
	$(STF_COMMAND) -test=JlinkTest -test-args="variant=AddModLimitMod" $(LOG)
	echo Target $@ completed
test.CpMpJlinkTest:
	echo Running target $@
	$(STF_COMMAND) -test=CpMpJlinkTest $(LOG)
	echo Target $@ completed
test.JlinkPluginOptionsTest_GeneralOptionsTest:
	echo Running target $@
	$(STF_COMMAND) -test=JlinkPluginOptionsTest -test-args="variant=GeneralOptionsTest" $(LOG)
	echo Target $@ completed
test.LayersTest:
	echo Running target $@
	$(STF_COMMAND) -test=LayersTest $(LOG)
	echo Target $@ completed
test.CLTest:
	echo Running target $@
	$(STF_COMMAND) -test=CLTest $(LOG)
	echo Target $@ completed
test.CLTestImage:
	echo Running target $@
	$(STF_COMMAND) -test=CLTestImage test-args="variant=CLTest" $(LOG)
	echo Target $@ completed
test.CLLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=CLLoadTest $(LOG)
	echo Target $@ completed
test.CLStressWithLayers:
	echo Running target $@
	$(STF_COMMAND) -test=CLStressWithLayers $(LOG)
	echo Target $@ completed
test.CLStressWithLayersCRI:
	echo Running target $@
	$(STF_COMMAND) -test=CLStressWithLayersCRI $(LOG)
	echo Target $@ completed
test.TestJlmLocal:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmLocal $(LOG)
	echo Target $@ completed
test.TestJlmRemoteClassAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteClassAuth $(LOG)
	echo Target $@ completed
test.TestJlmRemoteClassNoAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteClassNoAuth $(LOG)
	echo Target $@ completed
test.TestJlmRemoteMemoryAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteMemoryAuth $(LOG)
	echo Target $@ completed
test.TestJlmRemoteMemoryNoAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteMemoryNoAuth $(LOG)
	echo Target $@ completed
test.TestJlmRemoteNotifierProxyAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteNotifierProxyAuth $(LOG)
	echo Target $@ completed
test.TestJlmRemoteThreadNoAuth:
	echo Running target $@
	$(STF_COMMAND) -test=TestJlmRemoteThreadNoAuth $(LOG)
	echo Target $@ completed
test.MixedLoadTest:
	echo Running target $@
	$(STF_COMMAND) -test=MixedLoadTest -test-args="timeLimit=1m" $(LOG)
	echo Target $@ completed
test.ClassloadingLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=ClassloadingLoadTest -test-args=“timeLimit=5m” $(LOG)
	echo Target $@ completed
test.ConcurrentLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=ConcurrentLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.DirectByteBufferLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=DirectByteBufferLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.LangLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=LangLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MathLoadTest_all_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=math,timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MathLoadTest_autosimd_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=autoSimd,timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MathLoadTest_bigdecimal_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MathLoadTest -test-args="workload=bigDecimal,timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MauveSingleThreadLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MauveSingleThrdLoad -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MauveSingleInvocationLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MauveSingleInvocLoad -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MauveMultiThreadLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MauveMultiThrdLoad -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.NioLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=NioLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.UtilLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=UtilLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.SerializationLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=SerializationLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.LambdaLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=LambdaLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.MixedLoadTest_5m:
	echo Running target $@
	$(STF_COMMAND) -test=MixedLoadTest -test-args="timeLimit=5m" $(LOG)
	echo Target $@ completed
test.OAuthTest:
	echo Running target $@
	$(STF_COMMAND) -test=OAuthTest $(LOG)
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
	@echo make or make build: Builds aqa-systemtest projects
	@echo -------------------------------------------------------------------------------
	@echo make test: Runs all non-JCK aqa-systemtest tests
	@echo make $(TEST_TARGETS): Runs all aqa-systemtest tests
	@echo make test.xxxx: Runs individual test xxxx
	@echo make test EXCLUDE=$(ESC)"test.xxxx test.yyyy$(ESC)": Runs all tests except test.xxxx and test.yyyy
	@echo -------------------------------------------------------------------------------
	@echo make help.jck: Shows help for JCK test targets.

include $(subst $(SPACE),\$(SPACE),$(OPENJDK_SYSTEMTEST_ROOT)/openjdk.test.jck/include/test_targets.mk)
