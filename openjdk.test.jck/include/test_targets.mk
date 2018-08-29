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

# This file is included by openjdk.build/makefile
# It includes the test targets to execute the JCK.
# The JCK is not included in this repository, it is only available to JCK licensees.
# The tests will fail if you do not have a copy of the JCK.

# Some JCK tests require properties files for Kerberos and http server settings.
# They need to be placed in <JCK_ROOT>/jck/<jck-version>/config/<settings-dir>
# settings-dir is set by passing -test-args="config=<settings-dir>" to the STF Jck test.
# The JCK_CONFIG macro allows the user to override this value on the command line.
# The default is to look for a directory called 'default'.
JCK_CONFIG=default

# JCKVERSION cannot be mandated otherwise make build for the openjdk-systemtest repository
# would fail if JCKVERSION were not specified. So default it to something meaningless.
JCKVERSION?=not_specified
ifneq (notspecified,$(JCKVERSION))
  ifneq (jck8b,$(JCKVERSION))
    ifneq (jck9,$(JCKVERSION))
      ifneq (jck10,$(JCKVERSION))
        ifneq (jck11,$(JCKVERSION))
          $(error JCKVERSION $(JCKVERSION) not supported.  Specify one of jck8b, jck9, jck10 or jck11)
        endif
      endif
    endif
  endif
endif

# Some JCK tests are safe to run in parallel, others are not.
# These settings are used to set the default JCK execution behaviour to run tests in parallel
# where it is safe to do so, while allowing the user to override this behaviour via a 
# JCKCONCURRENCY=xxx macro.
# In particular, users running the test.custom targets are likely to want to set their own
# JCKCONCURRENCY=xxx value.

JCKCONCURRENCY?=
JCKCONCURRENCY_ARG:=
JCKCONCURRENCY_CPUS:=cpus
JCKCONCURRENCY_1:=1
ifneq (,$(JCKCONCURRENCY))
  JCKCONCURRENCY_CPUS:=$(JCKCONCURRENCY)
  JCKCONCURRENCY_1:=$(JCKCONCURRENCY)
  JCKCONCURRENCY_ARG:=,concurrency=$(JCKCONCURRENCY)
endif
JCKCONCURRENCY_CPUS_ARG:=,concurrency=$(JCKCONCURRENCY_CPUS)
JCKCONCURRENCY_1_ARG:=,concurrency=$(JCKCONCURRENCY_1)

# Target to run tests from any JCK test directory for any JCK version
.PHONY: test.jck.custom
test.jck.custom:
	echo Running target $@ with custom jck test $(JCKTEST), jckversion $(JCKVERSION), testsuite=$(JCKTESTSUITE)$(JCKCONCURRENCY_ARG)
	$(STF_COMMAND) -test=Jck -test-args="tests=$(JCKTEST),jckversion=$(JCKVERSION),testsuite=$(JCKTESTSUITE)$(JCKCONCURRENCY_ARG)" $(LOG)
	echo Target $@ completed

# Targets for the JCK runtime test suite
JCK_RUNTIME_TESTS:= \
test.jck.runtime.api.java_math \
test.jck.runtime.api.java_security \
test.jck.runtime.api.java_sql \
test.jck.runtime.api.java_text \
test.jck.runtime.api.javax_activation \
test.jck.runtime.api.javax_activity \
test.jck.runtime.api.javax_annotation \
test.jck.runtime.api.javax_crypto \
test.jck.runtime.api.javax_imageio \
test.jck.runtime.api.javax_lang \
test.jck.runtime.api.javax_net \
test.jck.runtime.api.javax_script \
test.jck.runtime.api.javax_security \
test.jck.runtime.api.javax_sql \
test.jck.runtime.api.javax_tools \
test.jck.runtime.api.javax_transaction \
test.jck.runtime.api.org_w3c \
test.jck.runtime.api.org_xml \
test.jck.runtime.api.signaturetest \
test.jck.runtime.api.xinclude \
test.jck.runtime.api.xsl \
test.jck.runtime.api.java_applet \
test.jck.runtime.api.java_awt \
test.jck.runtime.api.java_beans \
test.jck.runtime.api.java_io \
test.jck.runtime.api.java_util \
test.jck.runtime.api.javax_accessibility \
test.jck.runtime.api.javax_naming \
test.jck.runtime.api.javax_print \
test.jck.runtime.api.javax_sound \
test.jck.runtime.api.javax_swing \
test.jck.runtime.api.java_lang \
test.jck.runtime.api.java_net \
test.jck.runtime.api.java_nio \
test.jck.runtime.api.java_rmi \
test.jck.runtime.api.javax_management \
test.jck.runtime.api.javax_rmi \
test.jck.runtime.api.javax_xml \
test.jck.runtime.api.org_omg \
test.jck.runtime.api.org_ietf \
test.jck.runtime.api.java_time \
test.jck.runtime.vm.cldc \
test.jck.runtime.vm.concepts \
test.jck.runtime.vm.constantpool \
test.jck.runtime.vm.fp \
test.jck.runtime.vm.jvmti \
test.jck.runtime.vm.overview \
test.jck.runtime.vm.typechecker \
test.jck.runtime.vm.classfmt \
test.jck.runtime.vm.instr \
test.jck.runtime.vm.jni \
test.jck.runtime.vm.jdwp \
test.jck.runtime.xopts.vm.cldc \
test.jck.runtime.xopts.vm.concepts \
test.jck.runtime.xopts.vm.constantpool \
test.jck.runtime.xopts.vm.fp \
test.jck.runtime.xopts.vm.jvmti \
test.jck.runtime.xopts.vm.overview \
test.jck.runtime.xopts.vm.typechecker \
test.jck.runtime.xopts.vm.classfmt \
test.jck.runtime.xopts.vm.instr \
test.jck.runtime.xopts.vm.jni \
test.jck.runtime.xopts.vm.jdwp \
test.jck.runtime.lang.ANNOT \
test.jck.runtime.lang.ARR \
test.jck.runtime.lang.BINC \
test.jck.runtime.lang.CLSS \
test.jck.runtime.lang.CONV \
test.jck.runtime.lang.DASG \
test.jck.runtime.lang.EXCP \
test.jck.runtime.lang.EXEC \
test.jck.runtime.lang.EXPR \
test.jck.runtime.lang.FP \
test.jck.runtime.lang.ICLS \
test.jck.runtime.lang.INTF \
test.jck.runtime.lang.LEX \
test.jck.runtime.lang.NAME \
test.jck.runtime.lang.PKGS \
test.jck.runtime.lang.STMT \
test.jck.runtime.lang.THRD \
test.jck.runtime.lang.TYPE \
test.jck.runtime.lang.INFR \
test.jck.runtime.lang.LMBD \
test.jck.runtime.xml_schema.msdata.additional \
test.jck.runtime.xml_schema.msdata.annotations \
test.jck.runtime.xml_schema.msdata.attribute \
test.jck.runtime.xml_schema.msdata.attributeGroup \
test.jck.runtime.xml_schema.msdata.complexType \
test.jck.runtime.xml_schema.msdata.datatypes \
test.jck.runtime.xml_schema.msdata.element \
test.jck.runtime.xml_schema.msdata.errata10 \
test.jck.runtime.xml_schema.msdata.group \
test.jck.runtime.xml_schema.msdata.identityConstraint \
test.jck.runtime.xml_schema.msdata.modelGroups \
test.jck.runtime.xml_schema.msdata.notations \
test.jck.runtime.xml_schema.msdata.particles \
test.jck.runtime.xml_schema.msdata.regex \
test.jck.runtime.xml_schema.msdata.schema \
test.jck.runtime.xml_schema.msdata.simpleType \
test.jck.runtime.xml_schema.msdata.wildcards \
test.jck.runtime.xml_schema.nistdata.atomic \
test.jck.runtime.xml_schema.nistdata.list \
test.jck.runtime.xml_schema.nistdata.union \
test.jck.runtime.xml_schema.sundata \
test.jck.runtime.xml_schema.boeingData

# Set the runtime targets as PHONY targets
PHONY: $(JCK_RUNTIME_TESTS)

# Allow the user to exclude tests from the command line
JCK_RUNTIME_TESTS:=$(filter-out $(EXCLUDE),$(JCK_RUNTIME_TESTS))

JCK_TESTS_REQUIRING_CONFIG:=\
test.jck.runtime.api.java_net \
test.jck.runtime.api.java_nio \
test.jck.runtime.api.org_ietf \
test.jck.runtime.api.javax_security
# Allow the user to exclude tests from the command line
JCK_TESTS_REQUIRING_CONFIG:=$(filter-out $(EXCLUDE),$(JCK_TESTS_REQUIRING_CONFIG))

JCK_RUNTIME_TESTS_NO_CONFIG:=$(filter-out $(JCK_TESTS_REQUIRING_CONFIG),$(JCK_RUNTIME_TESTS))

# Targets for the jck compiler test suite
JCK_COMPILER_TESTS:= \
test.jck.compiler.api.java_rmi \
test.jck.compiler.api.javax_annotation \
test.jck.compiler.api.javax_lang \
test.jck.compiler.api.javax_tools \
test.jck.compiler.api.signaturetest \
test.jck.compiler.lang.ANNOT \
test.jck.compiler.lang.ARR  \
test.jck.compiler.lang.BINC  \
test.jck.compiler.lang.CLSS  \
test.jck.compiler.lang.CONV  \
test.jck.compiler.lang.DASG  \
test.jck.compiler.lang.EXCP  \
test.jck.compiler.lang.EXEC  \
test.jck.compiler.lang.EXPR  \
test.jck.compiler.lang.FP  \
test.jck.compiler.lang.ICLS  \
test.jck.compiler.lang.INTF  \
test.jck.compiler.lang.LEX  \
test.jck.compiler.lang.NAME  \
test.jck.compiler.lang.PKGS  \
test.jck.compiler.lang.STMT  \
test.jck.compiler.lang.THRD  \
test.jck.compiler.lang.TYPE \
test.jck.compiler.lang.INFR \
test.jck.compiler.lang.LMBD

# Set the compiler targets as PHONY targets
PHONY: $(JCK_COMPILER_TESTS)

# Allow the user to exclude tests from the command line
JCK_COMPILER_TESTS:=$(filter-out $(EXCLUDE),$(JCK_COMPILER_TESTS))

# Targets for the jck devtools test suite
JCK_DEVTOOLS_TESTS:= \
test.jck.devtools.java2schema \
test.jck.devtools.xml_schema.msData.additional \
test.jck.devtools.xml_schema.msData.annotations \
test.jck.devtools.xml_schema.msData.attribute  \
test.jck.devtools.xml_schema.msData.attributeGroup \
test.jck.devtools.xml_schema.msData.complexType  \
test.jck.devtools.xml_schema.msData.datatypes  \
test.jck.devtools.xml_schema.msData.element  \
test.jck.devtools.xml_schema.msData.errata10  \
test.jck.devtools.xml_schema.msData.group  \
test.jck.devtools.xml_schema.msData.identityConstraint  \
test.jck.devtools.xml_schema.msData.modelGroups  \
test.jck.devtools.xml_schema.msData.notations  \
test.jck.devtools.xml_schema.msData.particles  \
test.jck.devtools.xml_schema.msData.regex  \
test.jck.devtools.xml_schema.msData.schema \
test.jck.devtools.xml_schema.msData.simpleType  \
test.jck.devtools.xml_schema.msData.wildcards \
test.jck.devtools.xml_schema.nistData.atomic.anyURI \
test.jck.devtools.xml_schema.nistData.atomic.base64Binary   \
test.jck.devtools.xml_schema.nistData.atomic.boolean \
test.jck.devtools.xml_schema.nistData.atomic.byte \
test.jck.devtools.xml_schema.nistData.atomic.date \
test.jck.devtools.xml_schema.nistData.atomic.dateTime   \
test.jck.devtools.xml_schema.nistData.atomic.decimal   \
test.jck.devtools.xml_schema.nistData.atomic.double \
test.jck.devtools.xml_schema.nistData.atomic.duration   \
test.jck.devtools.xml_schema.nistData.atomic.float \
test.jck.devtools.xml_schema.nistData.atomic.gDay \
test.jck.devtools.xml_schema.nistData.atomic.gMonth   \
test.jck.devtools.xml_schema.nistData.atomic.gMonthDay \
test.jck.devtools.xml_schema.nistData.atomic.gYear \
test.jck.devtools.xml_schema.nistData.atomic.gYearMonth \
test.jck.devtools.xml_schema.nistData.atomic.hexBinary \
test.jck.devtools.xml_schema.nistData.atomic.ID \
test.jck.devtools.xml_schema.nistData.atomic.int \
test.jck.devtools.xml_schema.nistData.atomic.integer \
test.jck.devtools.xml_schema.nistData.atomic.language \
test.jck.devtools.xml_schema.nistData.atomic.long \
test.jck.devtools.xml_schema.nistData.atomic.Name \
test.jck.devtools.xml_schema.nistData.atomic.NCName \
test.jck.devtools.xml_schema.nistData.atomic.negativeInteger \
test.jck.devtools.xml_schema.nistData.atomic.NMTOKEN   \
test.jck.devtools.xml_schema.nistData.atomic.nonNegativeInteger \
test.jck.devtools.xml_schema.nistData.atomic.nonPositiveInteger   \
test.jck.devtools.xml_schema.nistData.atomic.normalizedString \
test.jck.devtools.xml_schema.nistData.atomic.positiveInteger   \
test.jck.devtools.xml_schema.nistData.atomic.QName \
test.jck.devtools.xml_schema.nistData.atomic.short \
test.jck.devtools.xml_schema.nistData.atomic.string \
test.jck.devtools.xml_schema.nistData.atomic.time \
test.jck.devtools.xml_schema.nistData.atomic.token \
test.jck.devtools.xml_schema.nistData.atomic.unsignedByte \
test.jck.devtools.xml_schema.nistData.atomic.unsignedInt  \
test.jck.devtools.xml_schema.nistData.atomic.unsignedLong \
test.jck.devtools.xml_schema.nistData.atomic.unsignedShort \
test.jck.devtools.xml_schema.nistData.list.anyURI \
test.jck.devtools.xml_schema.nistData.list.base64Binary \
test.jck.devtools.xml_schema.nistData.list.boolean \
test.jck.devtools.xml_schema.nistData.list.byte \
test.jck.devtools.xml_schema.nistData.list.date \
test.jck.devtools.xml_schema.nistData.list.dateTime \
test.jck.devtools.xml_schema.nistData.list.decimal \
test.jck.devtools.xml_schema.nistData.list.double \
test.jck.devtools.xml_schema.nistData.list.duration \
test.jck.devtools.xml_schema.nistData.list.float \
test.jck.devtools.xml_schema.nistData.list.gDay   \
test.jck.devtools.xml_schema.nistData.list.gMonth   \
test.jck.devtools.xml_schema.nistData.list.gMonthDay   \
test.jck.devtools.xml_schema.nistData.list.gYear \
test.jck.devtools.xml_schema.nistData.list.gYearMonth \
test.jck.devtools.xml_schema.nistData.list.hexBinary  \
test.jck.devtools.xml_schema.nistData.list.ID  \
test.jck.devtools.xml_schema.nistData.list.int \
test.jck.devtools.xml_schema.nistData.list.integer   \
test.jck.devtools.xml_schema.nistData.list.language   \
test.jck.devtools.xml_schema.nistData.list.long \
test.jck.devtools.xml_schema.nistData.list.Name      \
test.jck.devtools.xml_schema.nistData.list.NCName \
test.jck.devtools.xml_schema.nistData.list.negativeInteger  \
test.jck.devtools.xml_schema.nistData.list.NMTOKEN \
test.jck.devtools.xml_schema.nistData.list.NMTOKENS \
test.jck.devtools.xml_schema.nistData.list.nonNegativeInteger  \
test.jck.devtools.xml_schema.nistData.list.nonPositiveInteger  \
test.jck.devtools.xml_schema.nistData.list.normalizedString \
test.jck.devtools.xml_schema.nistData.list.positiveInteger \
test.jck.devtools.xml_schema.nistData.list.QName   \
test.jck.devtools.xml_schema.nistData.list.short \
test.jck.devtools.xml_schema.nistData.list.string \
test.jck.devtools.xml_schema.nistData.list.time \
test.jck.devtools.xml_schema.nistData.list.token \
test.jck.devtools.xml_schema.nistData.list.unsignedByte \
test.jck.devtools.xml_schema.nistData.list.unsignedInt \
test.jck.devtools.xml_schema.nistData.list.unsignedLong \
test.jck.devtools.xml_schema.nistData.list.unsignedShort \
test.jck.devtools.xml_schema.nistData.union \
test.jck.devtools.xml_schema.sunData \
test.jck.devtools.xml_schema.boeingData \
test.jck.devtools.jaxws \
test.jck.devtools.schema2java.nisttest \
test.jck.devtools.schema2java.structures \
test.jck.devtools.schema_bind.bind_class   \
test.jck.devtools.schema_bind.bind_dom \
test.jck.devtools.schema_bind.bind_globalBindings \
test.jck.devtools.schema_bind.bind_property \
test.jck.devtools.schema_bind.bind_factoryMethod \
test.jck.devtools.schema_bind.bind_inlineBinaryData \
test.jck.devtools.schema_bind.bind_javaType \
test.jck.devtools.schema_bind.bind_schemaBindings

# Set the devtools targets as PHONY targets
PHONY: $(JCK_DEVTOOLS_TESTS)

# Allow the user to exclude tests from the command line
JCK_DEVTOOLS_TESTS:=$(filter-out $(EXCLUDE),$(JCK_DEVTOOLS_TESTS))

# Targets to run the JCK in large chunks using the top level test nodes
.PHONY: \
test.jck.compiler.api \
test.jck.compiler.lang \
test.jck.devtools.java2schema \
test.jck.devtools.jaxws \
test.jck.devtools.schema2java \
test.jck.devtools.schema_bind \
test.jck.devtools.xml_schema \
test.jck.runtime.api \
test.jck.runtime.lang \
test.jck.runtime.vm \
test.jck.runtime.xml_schema

# Targets to run the JCK in large chunks using lower level JCK test nodes
.PHONY: \
test.jck \
test.jck.noconfig \
test.jck.runtime \
test.jck.runtime.noconfig \
test.jck.compiler \
test.jck.devtools

# Tests applicable to jck8b
# Chunks of tests
jck8b_RUNTIME_TESTS:=$(JCK_RUNTIME_TESTS)
jck8b_RUNTIME_TESTS_NO_CONFIG:=$(JCK_RUNTIME_TESTS_NO_CONFIG)
jck8b_COMPILER_TESTS:=$(JCK_COMPILER_TESTS)
jck8b_DEVTOOLS_TESTS:=$(JCK_DEVTOOLS_TESTS)
# All the jck8b tests
jck8b_TESTS:=$(jck8b_RUNTIME_TESTS) $(jck8b_COMPILER_TESTS) $(jck8b_DEVTOOLS_TESTS)
# The tests which do not require http or kerberos setup
jck8b_TESTS_NO_CONFIG:=$(filter-out $(JCK_TESTS_REQUIRING_CONFIG),$(jck8b_TESTS))

# Tests applicable to jck9
# Chunks of tests
jck9_RUNTIME_TESTS:=$(JCK_RUNTIME_TESTS)
jck9_RUNTIME_TESTS_NO_CONFIG:=$(JCK_RUNTIME_TESTS_NO_CONFIG)
jck9_COMPILER_TESTS:=$(JCK_COMPILER_TESTS)
jck9_DEVTOOLS_TESTS:=$(JCK_DEVTOOLS_TESTS)
# All the jck9 tests
jck9_TESTS:=$(jck9_RUNTIME_TESTS) $(jck9_COMPILER_TESTS) $(jck9_DEVTOOLS_TESTS)
# The tests which do not require http or kerberos setup
jck9_TESTS_NO_CONFIG:=$(filter-out $(JCK_TESTS_REQUIRING_CONFIG),$(jck9_TESTS))

# Tests applicable to jck10
# Chunks of tests
jck10_RUNTIME_TESTS:=$(JCK_RUNTIME_TESTS)
jck10_RUNTIME_TESTS_NO_CONFIG:=$(JCK_RUNTIME_TESTS_NO_CONFIG)
jck10_COMPILER_TESTS:=$(JCK_COMPILER_TESTS)
jck10_DEVTOOLS_TESTS:=$(JCK_DEVTOOLS_TESTS)
# All the jck10 tests
jck10_TESTS:=$(jck10_RUNTIME_TESTS) $(jck10_COMPILER_TESTS) $(jck10_DEVTOOLS_TESTS)
# The tests which do not require http or kerberos setup
jck10_TESTS_NO_CONFIG:=$(filter-out $(JCK_TESTS_REQUIRING_CONFIG),$(jck10_TESTS))

# Tests applicable to jck11
# Note no devtools tests in jck11
# Chunks of tests
jck11_RUNTIME_TESTS:=$(JCK_RUNTIME_TESTS)
jck11_RUNTIME_TESTS_NO_CONFIG:=$(JCK_RUNTIME_TESTS_NO_CONFIG)
jck11_COMPILER_TESTS:=$(JCK_COMPILER_TESTS)
jck11_DEVTOOLS_TESTS:=
# All the jck11 tests
jck11_TESTS:=$(jck11_RUNTIME_TESTS) $(jck11_COMPILER_TESTS) $(jck11_DEVTOOLS_TESTS)
# The tests which do not require http or kerberos setup
jck11_TESTS_NO_CONFIG:=$(filter-out $(JCK_TESTS_REQUIRING_CONFIG),$(jck11_TESTS))

# The targets.......

# Targets for running the JCK in large pieces from the top level test nodes.
test.jck.runtime.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	echo Target $@ completed
test.jck.runtime.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.runtime.vm:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.runtime.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.java2schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.jaxws:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema2java:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed

# Targets to run the JCK in large chunks by running lower level test nodes in sequence

# Run all the JCK
test.jck: $($(JCKVERSION)_TESTS)
# Run all the JCK except the tests which require Kerberos and Http server setup
test.jck.noconfig: $($(JCKVERSION)_TESTS_NO_CONFIG)
# Run all the runtime JCK tests
test.jck.runtime: $($(JCKVERSION)_RUNTIME_TESTS)
# Run all the runtime JCK tests except the tests which require Kerberos and Http server setup
test.jck.runtime.noconfig: $($(JCKVERSION)_RUNTIME_TESTS_NO_CONFIG)
# Run all the runtime compiler tests
test.jck.compiler: $($(JCKVERSION)_COMPILER_TESTS)
# Run all the runtime devtools tests
test.jck.devtools: $($(JCKVERSION)_DEVTOOLS_TESTS)

# Target to run the interactive tests
test.jck.runtime.api.interactive:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=$(JCKVERSION),testsuite=RUNTIME,interactive=yes" $(LOG)
	@echo Target $@ completed

# Targets which run the lower level test nodes
# Targets to run runtime test suites individually
test.jck.runtime.api.java_math:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_math,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_security,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_sql,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_text:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_text,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_activation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activation,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_activity:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activity,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_annotation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_crypto:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_crypto,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_imageio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_imageio,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_net,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_script:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_script,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_security,jckversion=$(JCKVERSION),testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sql,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_tools:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_transaction:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_transaction,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.org_w3c:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_w3c,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.org_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_xml,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.signaturetest:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.xinclude:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xinclude,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.xsl:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xsl,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_applet:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_applet,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_awt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_awt,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_beans:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_beans,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_io:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_io,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_util:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_util,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_accessibility:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_accessibility,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_naming:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_naming,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_print:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_print,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_sound:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sound,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_swing:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_swing,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_lang,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_net,jckversion=$(JCKVERSION),testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_nio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_nio,jckversion=$(JCKVERSION),testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_management:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_management,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_rmi,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.javax_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_xml,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.org_omg:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_omg,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.org_ietf:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_ietf,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG),config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.api.java_time:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_time,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xopts.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_1_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.ANNOT:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.ARR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.BINC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.CLSS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.CONV :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.DASG :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.EXCP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.EXEC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.EXPR :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.FP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.ICLS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.INTF :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.LEX :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.NAME :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.PKGS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.STMT :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.THRD :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.TYPE:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.INFR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.lang.LMBD:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.additional:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.annotations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.attribute:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.attributeGroup:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.complexType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.datatypes:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.element:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.errata10:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.group:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.identityConstraint:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.modelGroups:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.notations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.particles:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.regex:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.schema:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.simpleType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.msdata.wildcards:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.nistdata.atomic:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.nistdata.list:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.nistdata.union:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.sundata:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed
test.jck.runtime.xml_schema.boeingData:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=$(JCKVERSION),testsuite=RUNTIME$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	@echo Target $@ completed

# Targets to run compiler test suites individually
test.jck.compiler.api.java_rmi:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.api.javax_annotation:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.api.javax_lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.api.javax_tools:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.api.signaturetest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.ANNOT:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.ARR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.BINC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.CLSS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.CONV :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.DASG :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.EXCP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.EXEC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.EXPR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.FP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.ICLS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.INTF :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.LEX :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.NAME :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.PKGS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.STMT :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.THRD :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.TYPE:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.INFR:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.compiler.lang.LMBD:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=$(JCKVERSION),testsuite=COMPILER$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed

# Targets to run devtools test suites individually
# java2schema already defined above, not broken down further
#test.jck.devtools.java2schema:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
#	echo Target $@ completed
test.jck.devtools.xml_schema.msData.additional:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.annotations:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.attribute :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.attributeGroup:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.complexType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.datatypes :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.element :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.errata10 :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.group :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.identityConstraint :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.modelGroups :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.notations :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.particles :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.regex :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.simpleType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.msData.wildcards:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/anyURI,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.base64Binary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/base64Binary,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/boolean,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/byte,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/date,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.dateTime :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/dateTime,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.decimal :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/decimal,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/double,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.duration :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/duration,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/float,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.gDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gDay,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonth,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.gMonthDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonthDay,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYear,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYearMonth,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.hexBinary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/hexBinary,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.ID:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/ID,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/int,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.integer:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/integer,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.language:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/language,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/long,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.Name:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/Name,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NCName,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.negativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/negativeInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.NMTOKEN :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NMTOKEN,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.nonNegativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonNegativeInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonPositiveInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/normalizedString,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.positiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/positiveInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.QName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/QName,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/short,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/string,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/time,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/token,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedByte,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.unsignedInt :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedInt,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedLong,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.atomic.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedShort,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/anyURI,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.base64Binary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/base64Binary,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/boolean,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/byte,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/date,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.dateTime:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/dateTime,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.decimal:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/decimal,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/double,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.duration:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/duration,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/float,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.gDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gDay,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonth,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.gMonthDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonthDay,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYear,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYearMonth,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.hexBinary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/hexBinary,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.ID :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/ID,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/int,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.integer :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/integer,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.language :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/language,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/long,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.Name   :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/Name,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NCName,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.negativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/negativeInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.NMTOKEN:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKEN,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.NMTOKENS:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKENS,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.nonNegativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonNegativeInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonPositiveInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/normalizedString,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.positiveInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/positiveInteger,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.QName :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/QName,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/short,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/string,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/time,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/token,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedByte,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.unsignedInt:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedInt,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedLong,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.list.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedShort,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.nistData.union:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.sunData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.xml_schema.boeingData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
# jaxws already defined above, not broken down further
#test.jck.devtools.jaxws:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
#	echo Target $@ completed
test.jck.devtools.schema2java.nisttest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/nisttest,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema2java.structures:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/structures,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_class :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_class,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_dom:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_dom,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_globalBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_globalBindings,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_property:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_property,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_factoryMethod:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_factoryMethod,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_inlineBinaryData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_inlineBinaryData,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_javaType:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_javaType,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed
test.jck.devtools.schema_bind.bind_schemaBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_schemaBindings,jckversion=$(JCKVERSION),testsuite=DEVTOOLS$(JCKCONCURRENCY_CPUS_ARG)" $(LOG)
	echo Target $@ completed

help.jck:
	@echo -------------------------------------------------------------------------------
	@echo Help for JCK tests
	@echo -------------------------------------------------------------------------------
	@echo To run any JCK test
	@echo make test.jck.custom JCKVERSION=jckVersion JCKTESTSUITE=testsuite JCKTEST=testDirectory JCKCONCURRENCY=cpus/nn
	@echo JCKVERSION - jck8b, jck9, jck10, jck11, etc.
	@echo JCKTESTSUITE - COMPILER, DEVTOOLS or RUNTIME
	@echo JCKTEST - A JCK directory, e.g. api, api/javax_management, schema_bind, schema_bind/bind_javaType
	@echo JCKCONCURRENCY - A number or the value cpus
	@echo Refer to the JCK documentation, directory structure or test output for valid JCKTEST values
	@echo -------------------------------------------------------------------------------
	@echo New help text:
	@echo -------------------------------------------------------------------------------
	@echo These targets together run all the non-interactive JCK tests.
	@echo Each target specifies a different top level JCK test node as the testDirectory
	@echo - consequently all the tests are run with a single invocation of the JCK
	@echo javatest harness and the resutls for all tests will be included in a single
	@echo results directory hierarchy.
	@echo -------------------------------------------------------------------------------
	@echo make test.jck.runtime.api: Runs all non-interactive jck runtime api tests
	@echo make test.jck.runtime.lang: Runs all non-interactive jck runtime lang tests
	@echo make test.jck.runtime.vm: Runs all non-interactive jck runtime vm tests
	@echo make test.jck.runtime.xml_schema: Runs all non-interactive jck runtime xml_schema tests
	@echo make test.jck.compiler.api: Runs all jck compiler api tests
	@echo make test.jck.compiler.lang: Runs all jck compiler lang tests
	@echo make test.jck.devtools.jaxws: Runs all jck devtools jaxws tests
	@echo make test.jck.devtools.java2schema: Runs all jck devtools java2schema tests
	@echo make test.jck.devtools.schema_bind: Runs all jck devtools schema_bind tests
	@echo make test.jck.devtools.schema2java: Runs all jck devtools schema2java tests
	@echo make test.jck.devtools.xml_schema: Runs all jck devtools xml_schema tests
	@echo -------------------------------------------------------------------------------
	@echo These targets together also run all the non-interactive JCK tests.
	@echo Each target is dependent on a number of the individual test node targets, so the
	@echo tests are run with multiple invocations of the JCK javatest harness with the results
	@echo for each test node isolated into its own directory.
	@echo When tests are run in this way, individual test targets can be excluded - e.g.
	@echo make test.jck.runtime EXCLUDE="test.jck.runtime.api.javax_management test.jck.runtime.api.java_awt"
	@echo -------------------------------------------------------------------------------
	@echo make test.jck: Runs all non-interactive jck tests
	@echo make test.jck.noconfig: Runs all non-interactive jck tests except those which require Kerberos and http server setup
	@echo make test.jck.runtime: Runs all non-interactive jck runtime tests
	@echo make test.jck.runtime.noconfig: Runs all non-interactive jck runtime tests except those which require Kerberos and http server setup
	@echo make test.jck.compiler: Runs all non-interactive jck compiler tests
	@echo make test.jck.devtools: Runs all non-interactive jck devtools tests
	@echo make test.jck.runtime: Runs all non-interactive jck runtime api tests
	@echo -------------------------------------------------------------------------------
	@echo Run make help.jcktests to see a list of the individual test targets.
	@echo -------------------------------------------------------------------------------

help.jcktests:
	@echo -------------------------------------------------------------------------------
	@echo Help for executing preset JCK test subsets
	@echo -------------------------------------------------------------------------------
	@echo New help text:
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck8b runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck8b_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck8b compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck8b_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck8b devtools tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck8b_DEVTOOLS_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck9 runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck9_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck9 compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck9_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck9 devtools tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck9_DEVTOOLS_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck10 runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck10_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck10 compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck10_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck10 devtools tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck10_DEVTOOLS_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck11 runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck11_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run subsets of the jck11 compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(jck11_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
