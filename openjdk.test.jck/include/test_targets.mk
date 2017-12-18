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
# The default is to look fro a directory called 'default'.
JCK_CONFIG=default

# Targets to run jck8b

# Targets for the jck8b runtime test suite
JCK8B_RUNTIME_TESTS:= \
test.jck8b.runtime.api.java_math \
test.jck8b.runtime.api.java_security \
test.jck8b.runtime.api.java_sql \
test.jck8b.runtime.api.java_text \
test.jck8b.runtime.api.javax_activation \
test.jck8b.runtime.api.javax_activity \
test.jck8b.runtime.api.javax_annotation \
test.jck8b.runtime.api.javax_crypto \
test.jck8b.runtime.api.javax_imageio \
test.jck8b.runtime.api.javax_lang \
test.jck8b.runtime.api.javax_net \
test.jck8b.runtime.api.javax_script \
test.jck8b.runtime.api.javax_security \
test.jck8b.runtime.api.javax_sql \
test.jck8b.runtime.api.javax_tools \
test.jck8b.runtime.api.javax_transaction \
test.jck8b.runtime.api.org_w3c \
test.jck8b.runtime.api.org_xml \
test.jck8b.runtime.api.signaturetest \
test.jck8b.runtime.api.xinclude \
test.jck8b.runtime.api.xsl \
test.jck8b.runtime.api.java_applet \
test.jck8b.runtime.api.java_awt \
test.jck8b.runtime.api.java_beans \
test.jck8b.runtime.api.java_io \
test.jck8b.runtime.api.java_util \
test.jck8b.runtime.api.javax_accessibility \
test.jck8b.runtime.api.javax_naming \
test.jck8b.runtime.api.javax_print \
test.jck8b.runtime.api.javax_sound \
test.jck8b.runtime.api.javax_swing \
test.jck8b.runtime.api.java_lang \
test.jck8b.runtime.api.java_net \
test.jck8b.runtime.api.java_nio \
test.jck8b.runtime.api.java_rmi \
test.jck8b.runtime.api.javax_management \
test.jck8b.runtime.api.javax_rmi \
test.jck8b.runtime.api.javax_xml \
test.jck8b.runtime.api.org_omg \
test.jck8b.runtime.api.org_ietf \
test.jck8b.runtime.api.java_time \
test.jck8b.runtime.vm.cldc \
test.jck8b.runtime.vm.concepts \
test.jck8b.runtime.vm.constantpool \
test.jck8b.runtime.vm.fp \
test.jck8b.runtime.vm.jvmti \
test.jck8b.runtime.vm.overview \
test.jck8b.runtime.vm.typechecker \
test.jck8b.runtime.vm.classfmt \
test.jck8b.runtime.vm.instr \
test.jck8b.runtime.vm.jni \
test.jck8b.runtime.vm.jdwp \
test.jck8b.runtime.xopts.vm.cldc \
test.jck8b.runtime.xopts.vm.concepts \
test.jck8b.runtime.xopts.vm.constantpool \
test.jck8b.runtime.xopts.vm.fp \
test.jck8b.runtime.xopts.vm.jvmti \
test.jck8b.runtime.xopts.vm.overview \
test.jck8b.runtime.xopts.vm.typechecker \
test.jck8b.runtime.xopts.vm.classfmt \
test.jck8b.runtime.xopts.vm.instr \
test.jck8b.runtime.xopts.vm.jni \
test.jck8b.runtime.xopts.vm.jdwp \
test.jck8b.runtime.lang.ANNOT \
test.jck8b.runtime.lang.ARR \
test.jck8b.runtime.lang.BINC \
test.jck8b.runtime.lang.CLSS \
test.jck8b.runtime.lang.CONV \
test.jck8b.runtime.lang.DASG \
test.jck8b.runtime.lang.EXCP \
test.jck8b.runtime.lang.EXEC \
test.jck8b.runtime.lang.EXPR \
test.jck8b.runtime.lang.FP \
test.jck8b.runtime.lang.ICLS \
test.jck8b.runtime.lang.INTF \
test.jck8b.runtime.lang.LEX \
test.jck8b.runtime.lang.NAME \
test.jck8b.runtime.lang.PKGS \
test.jck8b.runtime.lang.STMT \
test.jck8b.runtime.lang.THRD \
test.jck8b.runtime.lang.TYPE \
test.jck8b.runtime.lang.INFR \
test.jck8b.runtime.lang.LMBD \
test.jck8b.runtime.xml_schema.msdata.additional \
test.jck8b.runtime.xml_schema.msdata.annotations \
test.jck8b.runtime.xml_schema.msdata.attribute \
test.jck8b.runtime.xml_schema.msdata.attributeGroup \
test.jck8b.runtime.xml_schema.msdata.complexType \
test.jck8b.runtime.xml_schema.msdata.datatypes \
test.jck8b.runtime.xml_schema.msdata.element \
test.jck8b.runtime.xml_schema.msdata.errata10 \
test.jck8b.runtime.xml_schema.msdata.group \
test.jck8b.runtime.xml_schema.msdata.identityConstraint \
test.jck8b.runtime.xml_schema.msdata.modelGroups \
test.jck8b.runtime.xml_schema.msdata.notations \
test.jck8b.runtime.xml_schema.msdata.particles \
test.jck8b.runtime.xml_schema.msdata.regex \
test.jck8b.runtime.xml_schema.msdata.schema \
test.jck8b.runtime.xml_schema.msdata.simpleType \
test.jck8b.runtime.xml_schema.msdata.wildcards \
test.jck8b.runtime.xml_schema.nistdata.atomic \
test.jck8b.runtime.xml_schema.nistdata.list \
test.jck8b.runtime.xml_schema.nistdata.union \
test.jck8b.runtime.xml_schema.sundata \
test.jck8b.runtime.xml_schema.boeingData
# Allow the user to exclude tests from the command line
JCK8B_RUNTIME_TESTS:=$(filter-out $(EXCLUDE),$(JCK8B_RUNTIME_TESTS))

JCK8B_TESTS_REQUIRING_CONFIG:=\
test.jck8b.runtime.api.java_net \
test.jck8b.runtime.api.java_nio \
test.jck8b.runtime.api.org_ietf \
test.jck8b.runtime.api.javax_security
# Allow the user to exclude tests from the command line
JCK8B_TESTS_REQUIRING_CONFIG:=$(filter-out $(EXCLUDE),$(JCK8B_TESTS_REQUIRING_CONFIG))

JCK8B_RUNTIME_TESTS_NO_CONFIG:=$(filter-out $(JCK8B_TESTS_REQUIRING_CONFIG),$(JCK8B_RUNTIME_TESTS))

# Targets for the jck8b compiler test suite
JCK8B_COMPILER_TESTS:= \
test.jck8b.compiler.api.java_rmi \
test.jck8b.compiler.api.javax_annotation \
test.jck8b.compiler.api.javax_lang \
test.jck8b.compiler.api.javax_tools \
test.jck8b.compiler.api.signaturetest \
test.jck8b.compiler.lang.ANNOT \
test.jck8b.compiler.lang.ARR  \
test.jck8b.compiler.lang.BINC  \
test.jck8b.compiler.lang.CLSS  \
test.jck8b.compiler.lang.CONV  \
test.jck8b.compiler.lang.DASG  \
test.jck8b.compiler.lang.EXCP  \
test.jck8b.compiler.lang.EXEC  \
test.jck8b.compiler.lang.EXPR  \
test.jck8b.compiler.lang.FP  \
test.jck8b.compiler.lang.ICLS  \
test.jck8b.compiler.lang.INTF  \
test.jck8b.compiler.lang.LEX  \
test.jck8b.compiler.lang.NAME  \
test.jck8b.compiler.lang.PKGS  \
test.jck8b.compiler.lang.STMT  \
test.jck8b.compiler.lang.THRD  \
test.jck8b.compiler.lang.TYPE \
test.jck8b.compiler.lang.INFR \
test.jck8b.compiler.lang.LMBD
# Allow the user to exclude tests from the command line
JCK8B_COMPILER_TESTS:=$(filter-out $(EXCLUDE),$(JCK8B_COMPILER_TESTS))

# Targets for the jck8b devtools test suite
JCK8B_DEVTOOLS_TESTS:= \
test.jck8b.devtools.java2schema \
test.jck8b.devtools.xml_schema.msData.additional \
test.jck8b.devtools.xml_schema.msData.annotations \
test.jck8b.devtools.xml_schema.msData.attribute  \
test.jck8b.devtools.xml_schema.msData.attributeGroup \
test.jck8b.devtools.xml_schema.msData.complexType  \
test.jck8b.devtools.xml_schema.msData.datatypes  \
test.jck8b.devtools.xml_schema.msData.element  \
test.jck8b.devtools.xml_schema.msData.errata10  \
test.jck8b.devtools.xml_schema.msData.group  \
test.jck8b.devtools.xml_schema.msData.identityConstraint  \
test.jck8b.devtools.xml_schema.msData.modelGroups  \
test.jck8b.devtools.xml_schema.msData.notations  \
test.jck8b.devtools.xml_schema.msData.particles  \
test.jck8b.devtools.xml_schema.msData.regex  \
test.jck8b.devtools.xml_schema.msData.schema \
test.jck8b.devtools.xml_schema.msData.simpleType  \
test.jck8b.devtools.xml_schema.msData.wildcards \
test.jck8b.devtools.xml_schema.nistData.atomic.anyURI \
test.jck8b.devtools.xml_schema.nistData.atomic.base64Binary   \
test.jck8b.devtools.xml_schema.nistData.atomic.boolean \
test.jck8b.devtools.xml_schema.nistData.atomic.byte \
test.jck8b.devtools.xml_schema.nistData.atomic.date \
test.jck8b.devtools.xml_schema.nistData.atomic.dateTime   \
test.jck8b.devtools.xml_schema.nistData.atomic.decimal   \
test.jck8b.devtools.xml_schema.nistData.atomic.double \
test.jck8b.devtools.xml_schema.nistData.atomic.duration   \
test.jck8b.devtools.xml_schema.nistData.atomic.float \
test.jck8b.devtools.xml_schema.nistData.atomic.gDay \
test.jck8b.devtools.xml_schema.nistData.atomic.gMonth   \
test.jck8b.devtools.xml_schema.nistData.atomic.gMonthDay \
test.jck8b.devtools.xml_schema.nistData.atomic.gYear \
test.jck8b.devtools.xml_schema.nistData.atomic.gYearMonth \
test.jck8b.devtools.xml_schema.nistData.atomic.hexBinary \
test.jck8b.devtools.xml_schema.nistData.atomic.ID \
test.jck8b.devtools.xml_schema.nistData.atomic.int \
test.jck8b.devtools.xml_schema.nistData.atomic.integer \
test.jck8b.devtools.xml_schema.nistData.atomic.language \
test.jck8b.devtools.xml_schema.nistData.atomic.long \
test.jck8b.devtools.xml_schema.nistData.atomic.Name \
test.jck8b.devtools.xml_schema.nistData.atomic.NCName \
test.jck8b.devtools.xml_schema.nistData.atomic.negativeInteger \
test.jck8b.devtools.xml_schema.nistData.atomic.NMTOKEN   \
test.jck8b.devtools.xml_schema.nistData.atomic.nonNegativeInteger \
test.jck8b.devtools.xml_schema.nistData.atomic.nonPositiveInteger   \
test.jck8b.devtools.xml_schema.nistData.atomic.normalizedString \
test.jck8b.devtools.xml_schema.nistData.atomic.positiveInteger   \
test.jck8b.devtools.xml_schema.nistData.atomic.QName \
test.jck8b.devtools.xml_schema.nistData.atomic.short \
test.jck8b.devtools.xml_schema.nistData.atomic.string \
test.jck8b.devtools.xml_schema.nistData.atomic.time \
test.jck8b.devtools.xml_schema.nistData.atomic.token \
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedByte \
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedInt  \
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedLong \
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedShort \
test.jck8b.devtools.xml_schema.nistData.list.anyURI \
test.jck8b.devtools.xml_schema.nistData.list.base64Binary \
test.jck8b.devtools.xml_schema.nistData.list.boolean \
test.jck8b.devtools.xml_schema.nistData.list.byte \
test.jck8b.devtools.xml_schema.nistData.list.date \
test.jck8b.devtools.xml_schema.nistData.list.dateTime \
test.jck8b.devtools.xml_schema.nistData.list.decimal \
test.jck8b.devtools.xml_schema.nistData.list.double \
test.jck8b.devtools.xml_schema.nistData.list.duration \
test.jck8b.devtools.xml_schema.nistData.list.float \
test.jck8b.devtools.xml_schema.nistData.list.gDay   \
test.jck8b.devtools.xml_schema.nistData.list.gMonth   \
test.jck8b.devtools.xml_schema.nistData.list.gMonthDay   \
test.jck8b.devtools.xml_schema.nistData.list.gYear \
test.jck8b.devtools.xml_schema.nistData.list.gYearMonth \
test.jck8b.devtools.xml_schema.nistData.list.hexBinary  \
test.jck8b.devtools.xml_schema.nistData.list.ID  \
test.jck8b.devtools.xml_schema.nistData.list.int \
test.jck8b.devtools.xml_schema.nistData.list.integer   \
test.jck8b.devtools.xml_schema.nistData.list.language   \
test.jck8b.devtools.xml_schema.nistData.list.long \
test.jck8b.devtools.xml_schema.nistData.list.Name      \
test.jck8b.devtools.xml_schema.nistData.list.NCName \
test.jck8b.devtools.xml_schema.nistData.list.negativeInteger  \
test.jck8b.devtools.xml_schema.nistData.list.NMTOKEN \
test.jck8b.devtools.xml_schema.nistData.list.NMTOKENS \
test.jck8b.devtools.xml_schema.nistData.list.nonNegativeInteger  \
test.jck8b.devtools.xml_schema.nistData.list.nonPositiveInteger  \
test.jck8b.devtools.xml_schema.nistData.list.normalizedString \
test.jck8b.devtools.xml_schema.nistData.list.positiveInteger \
test.jck8b.devtools.xml_schema.nistData.list.QName   \
test.jck8b.devtools.xml_schema.nistData.list.short \
test.jck8b.devtools.xml_schema.nistData.list.string \
test.jck8b.devtools.xml_schema.nistData.list.time \
test.jck8b.devtools.xml_schema.nistData.list.token \
test.jck8b.devtools.xml_schema.nistData.list.unsignedByte \
test.jck8b.devtools.xml_schema.nistData.list.unsignedInt \
test.jck8b.devtools.xml_schema.nistData.list.unsignedLong \
test.jck8b.devtools.xml_schema.nistData.list.unsignedShort \
test.jck8b.devtools.xml_schema.nistData.union \
test.jck8b.devtools.xml_schema.sunData \
test.jck8b.devtools.xml_schema.boeingData \
test.jck8b.devtools.jaxws \
test.jck8b.devtools.schema2java.nisttest \
test.jck8b.devtools.schema2java.structures \
test.jck8b.devtools.schema_bind.bind_class   \
test.jck8b.devtools.schema_bind.bind_dom \
test.jck8b.devtools.schema_bind.bind_globalBindings \
test.jck8b.devtools.schema_bind.bind_property \
test.jck8b.devtools.schema_bind.bind_factoryMethod \
test.jck8b.devtools.schema_bind.bind_inlineBinaryData \
test.jck8b.devtools.schema_bind.bind_javaType \
test.jck8b.devtools.schema_bind.bind_schemaBindings
# Allow the user to exclude tests from the command line
JCK8B_DEVTOOLS_TESTS:=$(filter-out $(EXCLUDE),$(JCK8B_DEVTOOLS_TESTS))

# All the JCK8B tests
JCK8B_TESTS:=$(JCK8B_RUNTIME_TESTS) \
$(JCK8B_COMPILER_TESTS) \
$(JCK8B_DEVTOOLS_TESTS)

# The tests which do not require http or kerberos setup
JCK8B_TESTS_NO_CONFIG:=$(filter-out $(JCK8B_TESTS_REQUIRING_CONFIG),$(JCK8B_TESTS))

.PHONY: \
test.jck.custom

.PHONY: \
test.jck8b \
test.jck8b.noconfig \
test.jck8b.compiler.custom \
test.jck8b.compiler.api \
test.jck8b.compiler.lang \
test.jck8b.devtools.custom \
test.jck8b.devtools.java2schema \
test.jck8b.devtools.jaxws \
test.jck8b.devtools.schema2java \
test.jck8b.devtools.schema_bindtest \
test.jck8b.devtools.xml_schema \
test.jck8b.runtime.custom \
test.jck8b.runtime.api \
test.jck8b.runtime.lang \
test.jck8b.runtime.vm \
test.jck8b.runtime.xml_schema \
test.jck8b.runtime.api.in.parts \
test.jck8b.runtime.api.noconfig

# Target to run Java 8 Runtime JCK tests in one run but in smaller parts.
test.jck8b.runtime.api.in.parts: $(JCK8B_RUNTIME_TESTS)
# Target to run Java 8 Runtime JCK tests excluding the parts which require Kerberos and Http server setup
test.jck8b.runtime.api.noconfig: $(JCK8B_RUNTIME_TESTS_NO_CONFIG)

# Target to run tests from any JCK test directory
test.jck.custom:
	echo Running target $@ with custom jck test $(JCKTEST), jckversion $(JCKVERSION), testsuite $(JCKTESTSUITE)
	$(STF_COMMAND) -test=Jck -test-args="tests=$(JCKTEST),jckversion=$(JCKVERSION),testsuite=$(JCKTESTSUITE)" $(LOG)
	echo Target $@ completed

# jck8b targets
# Targets to run all Java 8 JCK in small parts
test.jck8b: $(JCK8B_TESTS)
# Target to run Java 8 JCK tests excluding the parts which require Kerberos and Http server setup
test.jck8b.noconfig: $(JCK8B_TESTS_NO_CONFIG)

# Targets to run tests from any jck8b runtime, compiler or devtools test directory
test.jck8b.runtime.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed

# Targets to run Java 8 JCK in very large pieces
test.jck8b.runtime.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck8b.runtime.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck8b.runtime.vm:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck8b.runtime.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.java2schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.jaxws:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema2java:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed


# Target to run Java 8 Runtime JCK tests in one run but in smaller parts.
test.jck8b.runtime.api.in.parts: $(JCK8B_RUNTIME_TESTS)
# Target to run Java 8 Runtime JCK tests excluding the parts which require Kerberos and Http server setup
test.jck8b.runtime.api.noconfig: $(JCK8B_RUNTIME_TESTS_NO_CONFIG)

# Target to run the interactive tests
test.jck8b.runtime.api.interactive:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck8b,testsuite=RUNTIME,interactive=yes" $(LOG)
	@echo Target $@ completed

# Targets to run runtime test suites individually
test.jck8b.runtime.api.java_math:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_math,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_security,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_sql,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_text:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_text,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_activation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activation,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_activity:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activity,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_annotation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_crypto:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_crypto,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_imageio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_imageio,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_net,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_script:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_script,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_security,jckversion=jck8b,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sql,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_tools:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_transaction:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_transaction,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.org_w3c:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_w3c,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.org_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_xml,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.signaturetest:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.xinclude:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xinclude,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.xsl:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xsl,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_applet:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_applet,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_awt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_awt,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_beans:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_beans,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_io:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_io,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_util:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_util,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_accessibility:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_accessibility,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_naming:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_naming,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_print:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_print,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_sound:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sound,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_swing:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_swing,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_lang,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_net,jckversion=jck8b,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_nio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_nio,jckversion=jck8b,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_management:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_management,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_rmi,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.javax_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_xml,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.org_omg:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_omg,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.org_ietf:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_ietf,jckversion=jck8b,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.api.java_time:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_time,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xopts.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.ANNOT:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.ARR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.BINC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.CLSS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.CONV :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.DASG :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.EXCP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.EXEC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.EXPR :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.FP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.ICLS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.INTF :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.LEX :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.NAME :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.PKGS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.STMT :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.THRD :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.TYPE:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.INFR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.lang.LMBD:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.additional:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.annotations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.attribute:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.attributeGroup:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.complexType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.datatypes:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.element:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.errata10:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.group:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.identityConstraint:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.modelGroups:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.notations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.particles:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.regex:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.schema:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.simpleType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.msdata.wildcards:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.nistdata.atomic:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.nistdata.list:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.nistdata.union:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.sundata:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck8b.runtime.xml_schema.boeingData:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=jck8b,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed

# Targets to run compiler test suites individually
test.jck8b.compiler.api.java_rmi:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.api.javax_annotation:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.api.javax_lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.api.javax_tools:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.api.signaturetest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.ANNOT:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.ARR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.BINC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.CLSS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.CONV :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.DASG :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.EXCP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.EXEC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.EXPR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.FP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.ICLS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.INTF :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.LEX :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.NAME :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.PKGS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.STMT :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.THRD :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.TYPE:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.INFR:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck8b.compiler.lang.LMBD:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=jck8b,testsuite=COMPILER" $(LOG)
	echo Target $@ completed

# Targets to run devtools test suites individually
# java2schema already defined above, not broken down further
#test.jck8b.devtools.java2schema:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
#	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.additional:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.annotations:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.attribute :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.attributeGroup:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.complexType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.datatypes :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.element :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.errata10 :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.group :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.identityConstraint :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.modelGroups :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.notations :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.particles :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.regex :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.simpleType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.msData.wildcards:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/anyURI,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.base64Binary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/base64Binary,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/boolean,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/byte,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/date,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.dateTime :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/dateTime,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.decimal :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/decimal,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/double,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.duration :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/duration,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/float,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.gDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gDay,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonth,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.gMonthDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonthDay,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYear,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYearMonth,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.hexBinary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/hexBinary,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.ID:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/ID,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/int,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.integer:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/integer,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.language:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/language,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/long,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.Name:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/Name,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NCName,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.negativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/negativeInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.NMTOKEN :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NMTOKEN,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.nonNegativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonNegativeInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonPositiveInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/normalizedString,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.positiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/positiveInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.QName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/QName,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/short,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/string,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/time,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/token,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedByte,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedInt :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedInt,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedLong,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.atomic.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedShort,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/anyURI,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.base64Binary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/base64Binary,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/boolean,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/byte,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/date,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.dateTime:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/dateTime,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.decimal:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/decimal,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/double,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.duration:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/duration,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/float,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.gDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gDay,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonth,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.gMonthDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonthDay,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYear,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYearMonth,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.hexBinary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/hexBinary,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.ID :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/ID,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/int,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.integer :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/integer,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.language :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/language,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/long,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.Name   :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/Name,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NCName,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.negativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/negativeInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.NMTOKEN:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKEN,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.NMTOKENS:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKENS,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.nonNegativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonNegativeInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonPositiveInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/normalizedString,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.positiveInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/positiveInteger,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.QName :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/QName,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/short,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/string,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/time,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/token,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedByte,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.unsignedInt:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedInt,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedLong,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.list.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedShort,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.nistData.union:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.sunData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.xml_schema.boeingData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
# jaxws already defined above, not broken down further
#test.jck8b.devtools.jaxws:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
#	echo Target $@ completed
test.jck8b.devtools.schema2java.nisttest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/nisttest,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema2java.structures:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/structures,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_class :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_class,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_dom:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_dom,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_globalBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_globalBindings,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_property:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_property,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_factoryMethod:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_factoryMethod,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_inlineBinaryData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_inlineBinaryData,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_javaType:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_javaType,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck8b.devtools.schema_bind.bind_schemaBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_schemaBindings,jckversion=jck8b,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed

# Targets to run jck9

# Targets for the jck9 runtime test suite
JCK9_RUNTIME_TESTS:= \
test.jck9.runtime.api.java_math \
test.jck9.runtime.api.java_security \
test.jck9.runtime.api.java_sql \
test.jck9.runtime.api.java_text \
test.jck9.runtime.api.javax_activation \
test.jck9.runtime.api.javax_activity \
test.jck9.runtime.api.javax_annotation \
test.jck9.runtime.api.javax_crypto \
test.jck9.runtime.api.javax_imageio \
test.jck9.runtime.api.javax_lang \
test.jck9.runtime.api.javax_net \
test.jck9.runtime.api.javax_script \
test.jck9.runtime.api.javax_security \
test.jck9.runtime.api.javax_sql \
test.jck9.runtime.api.javax_tools \
test.jck9.runtime.api.javax_transaction \
test.jck9.runtime.api.org_w3c \
test.jck9.runtime.api.org_xml \
test.jck9.runtime.api.serializabletypes \
test.jck9.runtime.api.signaturetest \
test.jck9.runtime.api.xinclude \
test.jck9.runtime.api.xsl \
test.jck9.runtime.api.java_applet \
test.jck9.runtime.api.java_awt \
test.jck9.runtime.api.java_beans \
test.jck9.runtime.api.java_io \
test.jck9.runtime.api.java_util \
test.jck9.runtime.api.javax_accessibility \
test.jck9.runtime.api.javax_naming \
test.jck9.runtime.api.javax_print \
test.jck9.runtime.api.javax_sound \
test.jck9.runtime.api.javax_swing \
test.jck9.runtime.api.java_lang \
test.jck9.runtime.api.java_net \
test.jck9.runtime.api.java_nio \
test.jck9.runtime.api.java_rmi \
test.jck9.runtime.api.javax_management \
test.jck9.runtime.api.javax_rmi \
test.jck9.runtime.api.javax_xml \
test.jck9.runtime.api.modulegraph \
test.jck9.runtime.api.org_omg \
test.jck9.runtime.api.org_ietf \
test.jck9.runtime.api.java_time \
test.jck9.runtime.vm.cldc \
test.jck9.runtime.vm.concepts \
test.jck9.runtime.vm.constantpool \
test.jck9.runtime.vm.fp \
test.jck9.runtime.vm.jvmti \
test.jck9.runtime.vm.module \
test.jck9.runtime.vm.overview \
test.jck9.runtime.vm.typechecker \
test.jck9.runtime.vm.classfmt \
test.jck9.runtime.vm.instr \
test.jck9.runtime.vm.jni \
test.jck9.runtime.vm.jdwp \
test.jck9.runtime.xopts.vm.cldc \
test.jck9.runtime.xopts.vm.concepts \
test.jck9.runtime.xopts.vm.constantpool \
test.jck9.runtime.xopts.vm.fp \
test.jck9.runtime.xopts.vm.jvmti \
test.jck9.runtime.xopts.vm.overview \
test.jck9.runtime.xopts.vm.typechecker \
test.jck9.runtime.xopts.vm.classfmt \
test.jck9.runtime.xopts.vm.instr \
test.jck9.runtime.xopts.vm.jni \
test.jck9.runtime.xopts.vm.jdwp \
test.jck9.runtime.lang.ANNOT \
test.jck9.runtime.lang.ARR \
test.jck9.runtime.lang.BINC \
test.jck9.runtime.lang.CLSS \
test.jck9.runtime.lang.CONV \
test.jck9.runtime.lang.DASG \
test.jck9.runtime.lang.EXCP \
test.jck9.runtime.lang.EXEC \
test.jck9.runtime.lang.EXPR \
test.jck9.runtime.lang.FP \
test.jck9.runtime.lang.ICLS \
test.jck9.runtime.lang.INTF \
test.jck9.runtime.lang.LEX \
test.jck9.runtime.lang.NAME \
test.jck9.runtime.lang.PKGS \
test.jck9.runtime.lang.STMT \
test.jck9.runtime.lang.THRD \
test.jck9.runtime.lang.TYPE \
test.jck9.runtime.lang.INFR \
test.jck9.runtime.lang.LMBD \
test.jck9.runtime.xml_schema.msdata.additional \
test.jck9.runtime.xml_schema.msdata.annotations \
test.jck9.runtime.xml_schema.msdata.attribute \
test.jck9.runtime.xml_schema.msdata.attributeGroup \
test.jck9.runtime.xml_schema.msdata.complexType \
test.jck9.runtime.xml_schema.msdata.datatypes \
test.jck9.runtime.xml_schema.msdata.element \
test.jck9.runtime.xml_schema.msdata.errata10 \
test.jck9.runtime.xml_schema.msdata.group \
test.jck9.runtime.xml_schema.msdata.identityConstraint \
test.jck9.runtime.xml_schema.msdata.modelGroups \
test.jck9.runtime.xml_schema.msdata.notations \
test.jck9.runtime.xml_schema.msdata.particles \
test.jck9.runtime.xml_schema.msdata.regex \
test.jck9.runtime.xml_schema.msdata.schema \
test.jck9.runtime.xml_schema.msdata.simpleType \
test.jck9.runtime.xml_schema.msdata.wildcards \
test.jck9.runtime.xml_schema.nistdata.atomic \
test.jck9.runtime.xml_schema.nistdata.list \
test.jck9.runtime.xml_schema.nistdata.union \
test.jck9.runtime.xml_schema.sundata \
test.jck9.runtime.xml_schema.boeingData
# Allow the user to exclude tests from the command line
JCK9_RUNTIME_TESTS:=$(filter-out $(EXCLUDE),$(JCK9_RUNTIME_TESTS))

JCK9_TESTS_REQUIRING_CONFIG:=\
test.jck9.runtime.api.java_net \
test.jck9.runtime.api.java_nio \
test.jck9.runtime.api.org_ietf \
test.jck9.runtime.api.javax_security
# Allow the user to exclude tests from the command line
JCK9_TESTS_REQUIRING_CONFIG:=$(filter-out $(EXCLUDE),$(JCK9_TESTS_REQUIRING_CONFIG))

JCK9_RUNTIME_TESTS_NO_CONFIG:=$(filter-out $(JCK9_TESTS_REQUIRING_CONFIG),$(JCK9_RUNTIME_TESTS))

# Targets for the jck9 compiler test suite
JCK9_COMPILER_TESTS:= \
test.jck9.compiler.api.java_rmi \
test.jck9.compiler.api.javax_annotation \
test.jck9.compiler.api.javax_lang \
test.jck9.compiler.api.javax_tools \
test.jck9.compiler.api.signaturetest \
test.jck9.compiler.lang.ANNOT \
test.jck9.compiler.lang.ARR  \
test.jck9.compiler.lang.BINC  \
test.jck9.compiler.lang.CLSS  \
test.jck9.compiler.lang.CONV  \
test.jck9.compiler.lang.DASG  \
test.jck9.compiler.lang.EXCP  \
test.jck9.compiler.lang.EXEC  \
test.jck9.compiler.lang.EXPR  \
test.jck9.compiler.lang.FP  \
test.jck9.compiler.lang.ICLS  \
test.jck9.compiler.lang.INTF  \
test.jck9.compiler.lang.LEX  \
test.jck9.compiler.lang.NAME  \
test.jck9.compiler.lang.PKGS  \
test.jck9.compiler.lang.STMT  \
test.jck9.compiler.lang.THRD  \
test.jck9.compiler.lang.TYPE \
test.jck9.compiler.lang.INFR \
test.jck9.compiler.lang.LMBD \
test.jck9.compiler.lang.MOD
# Allow the user to exclude tests from the command line
JCK9_COMPILER_TESTS:=$(filter-out $(EXCLUDE),$(JCK9_COMPILER_TESTS))

# Targets for the jck9 devtools test suite
JCK9_DEVTOOLS_TESTS:= \
test.jck9.devtools.java2schema \
test.jck9.devtools.xml_schema.msData.additional \
test.jck9.devtools.xml_schema.msData.annotations \
test.jck9.devtools.xml_schema.msData.attribute  \
test.jck9.devtools.xml_schema.msData.attributeGroup \
test.jck9.devtools.xml_schema.msData.complexType  \
test.jck9.devtools.xml_schema.msData.datatypes  \
test.jck9.devtools.xml_schema.msData.element  \
test.jck9.devtools.xml_schema.msData.errata10  \
test.jck9.devtools.xml_schema.msData.group  \
test.jck9.devtools.xml_schema.msData.identityConstraint  \
test.jck9.devtools.xml_schema.msData.modelGroups  \
test.jck9.devtools.xml_schema.msData.notations  \
test.jck9.devtools.xml_schema.msData.particles  \
test.jck9.devtools.xml_schema.msData.regex  \
test.jck9.devtools.xml_schema.msData.schema \
test.jck9.devtools.xml_schema.msData.simpleType  \
test.jck9.devtools.xml_schema.msData.wildcards \
test.jck9.devtools.xml_schema.nistData.atomic.anyURI \
test.jck9.devtools.xml_schema.nistData.atomic.base64Binary   \
test.jck9.devtools.xml_schema.nistData.atomic.boolean \
test.jck9.devtools.xml_schema.nistData.atomic.byte \
test.jck9.devtools.xml_schema.nistData.atomic.date \
test.jck9.devtools.xml_schema.nistData.atomic.dateTime   \
test.jck9.devtools.xml_schema.nistData.atomic.decimal   \
test.jck9.devtools.xml_schema.nistData.atomic.double \
test.jck9.devtools.xml_schema.nistData.atomic.duration   \
test.jck9.devtools.xml_schema.nistData.atomic.float \
test.jck9.devtools.xml_schema.nistData.atomic.gDay \
test.jck9.devtools.xml_schema.nistData.atomic.gMonth   \
test.jck9.devtools.xml_schema.nistData.atomic.gMonthDay \
test.jck9.devtools.xml_schema.nistData.atomic.gYear \
test.jck9.devtools.xml_schema.nistData.atomic.gYearMonth \
test.jck9.devtools.xml_schema.nistData.atomic.hexBinary \
test.jck9.devtools.xml_schema.nistData.atomic.ID \
test.jck9.devtools.xml_schema.nistData.atomic.int \
test.jck9.devtools.xml_schema.nistData.atomic.integer \
test.jck9.devtools.xml_schema.nistData.atomic.language \
test.jck9.devtools.xml_schema.nistData.atomic.long \
test.jck9.devtools.xml_schema.nistData.atomic.Name \
test.jck9.devtools.xml_schema.nistData.atomic.NCName \
test.jck9.devtools.xml_schema.nistData.atomic.negativeInteger \
test.jck9.devtools.xml_schema.nistData.atomic.NMTOKEN   \
test.jck9.devtools.xml_schema.nistData.atomic.nonNegativeInteger \
test.jck9.devtools.xml_schema.nistData.atomic.nonPositiveInteger   \
test.jck9.devtools.xml_schema.nistData.atomic.normalizedString \
test.jck9.devtools.xml_schema.nistData.atomic.positiveInteger   \
test.jck9.devtools.xml_schema.nistData.atomic.QName \
test.jck9.devtools.xml_schema.nistData.atomic.short \
test.jck9.devtools.xml_schema.nistData.atomic.string \
test.jck9.devtools.xml_schema.nistData.atomic.time \
test.jck9.devtools.xml_schema.nistData.atomic.token \
test.jck9.devtools.xml_schema.nistData.atomic.unsignedByte \
test.jck9.devtools.xml_schema.nistData.atomic.unsignedInt  \
test.jck9.devtools.xml_schema.nistData.atomic.unsignedLong \
test.jck9.devtools.xml_schema.nistData.atomic.unsignedShort \
test.jck9.devtools.xml_schema.nistData.list.anyURI \
test.jck9.devtools.xml_schema.nistData.list.base64Binary \
test.jck9.devtools.xml_schema.nistData.list.boolean \
test.jck9.devtools.xml_schema.nistData.list.byte \
test.jck9.devtools.xml_schema.nistData.list.date \
test.jck9.devtools.xml_schema.nistData.list.dateTime \
test.jck9.devtools.xml_schema.nistData.list.decimal \
test.jck9.devtools.xml_schema.nistData.list.double \
test.jck9.devtools.xml_schema.nistData.list.duration \
test.jck9.devtools.xml_schema.nistData.list.float \
test.jck9.devtools.xml_schema.nistData.list.gDay   \
test.jck9.devtools.xml_schema.nistData.list.gMonth   \
test.jck9.devtools.xml_schema.nistData.list.gMonthDay   \
test.jck9.devtools.xml_schema.nistData.list.gYear \
test.jck9.devtools.xml_schema.nistData.list.gYearMonth \
test.jck9.devtools.xml_schema.nistData.list.hexBinary  \
test.jck9.devtools.xml_schema.nistData.list.ID  \
test.jck9.devtools.xml_schema.nistData.list.int \
test.jck9.devtools.xml_schema.nistData.list.integer   \
test.jck9.devtools.xml_schema.nistData.list.language   \
test.jck9.devtools.xml_schema.nistData.list.long \
test.jck9.devtools.xml_schema.nistData.list.Name      \
test.jck9.devtools.xml_schema.nistData.list.NCName \
test.jck9.devtools.xml_schema.nistData.list.negativeInteger  \
test.jck9.devtools.xml_schema.nistData.list.NMTOKEN \
test.jck9.devtools.xml_schema.nistData.list.NMTOKENS \
test.jck9.devtools.xml_schema.nistData.list.nonNegativeInteger  \
test.jck9.devtools.xml_schema.nistData.list.nonPositiveInteger  \
test.jck9.devtools.xml_schema.nistData.list.normalizedString \
test.jck9.devtools.xml_schema.nistData.list.positiveInteger \
test.jck9.devtools.xml_schema.nistData.list.QName   \
test.jck9.devtools.xml_schema.nistData.list.short \
test.jck9.devtools.xml_schema.nistData.list.string \
test.jck9.devtools.xml_schema.nistData.list.time \
test.jck9.devtools.xml_schema.nistData.list.token \
test.jck9.devtools.xml_schema.nistData.list.unsignedByte \
test.jck9.devtools.xml_schema.nistData.list.unsignedInt \
test.jck9.devtools.xml_schema.nistData.list.unsignedLong \
test.jck9.devtools.xml_schema.nistData.list.unsignedShort \
test.jck9.devtools.xml_schema.nistData.union \
test.jck9.devtools.xml_schema.sunData \
test.jck9.devtools.xml_schema.boeingData \
test.jck9.devtools.jaxws \
test.jck9.devtools.schema2java.nisttest \
test.jck9.devtools.schema2java.structures \
test.jck9.devtools.schema_bind.bind_class   \
test.jck9.devtools.schema_bind.bind_dom \
test.jck9.devtools.schema_bind.bind_globalBindings \
test.jck9.devtools.schema_bind.bind_property \
test.jck9.devtools.schema_bind.bind_factoryMethod \
test.jck9.devtools.schema_bind.bind_inlineBinaryData \
test.jck9.devtools.schema_bind.bind_javaType \
test.jck9.devtools.schema_bind.bind_schemaBindings
# Allow the user to exclude tests from the command line
JCK9_DEVTOOLS_TESTS:=$(filter-out $(EXCLUDE),$(JCK9_DEVTOOLS_TESTS))

# All the JCK9 tests
JCK9_TESTS:=$(JCK9_RUNTIME_TESTS) \
$(JCK9_COMPILER_TESTS) \
$(JCK9_DEVTOOLS_TESTS)

# The tests which do not require http or kerberos setup
JCK9_TESTS_NO_CONFIG:=$(filter-out $(JCK9_TESTS_REQUIRING_CONFIG),$(JCK9_TESTS))

.PHONY: \
test.jck.custom

.PHONY: \
test.jck9 \
test.jck9.noconfig \
test.jck9.compiler.custom \
test.jck9.compiler.api \
test.jck9.compiler.lang \
test.jck9.devtools.custom \
test.jck9.devtools.java2schema \
test.jck9.devtools.jaxws \
test.jck9.devtools.schema2java \
test.jck9.devtools.schema_bindtest \
test.jck9.devtools.xml_schema \
test.jck9.runtime.custom \
test.jck9.runtime.api \
test.jck9.runtime.lang \
test.jck9.runtime.vm \
test.jck9.runtime.xml_schema \
test.jck9.runtime.api.in.parts \
test.jck9.runtime.api.noconfig

# Target to run Java 9 Runtime JCK tests in one run but in smaller parts.
test.jck9.runtime.api.in.parts: $(JCK9_RUNTIME_TESTS)
# Target to run Java 9 Runtime JCK tests excluding the parts which require Kerberos and Http server setup
test.jck9.runtime.api.noconfig: $(JCK9_RUNTIME_TESTS_NO_CONFIG)

# Target to run tests from any JCK test directory
test.jck.custom:
	echo Running target $@ with custom jck test $(JCKTEST), jckversion $(JCKVERSION), testsuite $(JCKTESTSUITE)
	$(STF_COMMAND) -test=Jck -test-args="tests=$(JCKTEST),jckversion=$(JCKVERSION),testsuite=$(JCKTESTSUITE)" $(LOG)
	echo Target $@ completed

# jck9 targets
# Targets to run all Java 9 JCK in small parts
test.jck9: $(JCK9_TESTS)
# Target to run Java 9 JCK tests excluding the parts which require Kerberos and Http server setup
test.jck9.noconfig: $(JCK9_TESTS_NO_CONFIG)

# Targets to run tests from any jck9 runtime, compiler or devtools test directory
test.jck9.runtime.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck9,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck9.compiler.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.devtools.custom:
	echo Running target $@ with custom jck test ${JCKTEST}
	$(STF_COMMAND) -test=Jck -test-args="tests=${JCKTEST},jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed

# Targets to run Java 9 JCK in very large pieces
test.jck9.runtime.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck9.runtime.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck9.runtime.vm:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck9.runtime.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	echo Target $@ completed
test.jck9.compiler.api:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.devtools.java2schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.jaxws:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema2java:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed


# Target to run Java 9 Runtime JCK tests in one run but in smaller parts.
test.jck9.runtime.api.in.parts: $(JCK9_RUNTIME_TESTS)
# Target to run Java 9 Runtime JCK tests excluding the parts which require Kerberos and Http server setup
test.jck9.runtime.api.noconfig: $(JCK9_RUNTIME_TESTS_NO_CONFIG)

# Target to run the interactive tests
test.jck9.runtime.api.interactive:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api,jckversion=jck9,testsuite=RUNTIME,interactive=yes" $(LOG)
	@echo Target $@ completed

# Targets to run runtime test suites individually
test.jck9.runtime.api.java_math:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_math,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_security,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_sql,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_text:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_text,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_activation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activation,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_activity:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_activity,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_annotation:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_crypto:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_crypto,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_imageio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_imageio,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_net,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_script:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_script,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_security:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_security,jckversion=jck9,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_sql:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sql,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_tools:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_transaction:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_transaction,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.org_w3c:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_w3c,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.serializabletypes:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/serializabletypes,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.org_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_xml,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.signaturetest:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.xinclude:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xinclude,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.xsl:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/xsl,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_applet:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_applet,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_awt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_awt,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_beans:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_beans,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_io:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_io,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_util:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_util,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_accessibility:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_accessibility,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_naming:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_naming,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_print:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_print,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_sound:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_sound,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_swing:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_swing,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_lang:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_lang,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_net:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_net,jckversion=jck9,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_nio:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_nio,jckversion=jck9,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_management:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_management,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_rmi:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_rmi,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.javax_xml:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_xml,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.modulegraph:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/modulegraph,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.org_omg:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_omg,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.org_ietf:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/org_ietf,jckversion=jck9,testsuite=RUNTIME,config=$(JCK_CONFIG)" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.api.java_time:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_time,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.module:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/module,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.cldc:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/cldc,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.concepts:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/concepts,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.constantpool:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/constantpool,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.fp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/fp,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.jvmti:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jvmti,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.overview:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/overview,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.typechecker:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/typechecker,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.classfmt:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/classfmt,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.instr:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/instr,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.jni:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jni,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xopts.vm.jdwp:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=vm/jdwp,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.ANNOT:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.ARR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.BINC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.CLSS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.CONV :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.DASG :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.EXCP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.EXEC :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.EXPR :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.FP :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.ICLS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.INTF :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.LEX :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.NAME :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.PKGS :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.STMT :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.THRD :
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.TYPE:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.INFR:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.lang.LMBD:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.additional:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.annotations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.attribute:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.attributeGroup:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.complexType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.datatypes:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.element:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.errata10:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.group:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.identityConstraint:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.modelGroups:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.notations:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.particles:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.regex:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.schema:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.simpleType:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.msdata.wildcards:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.nistdata.atomic:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.nistdata.list:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.nistdata.union:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.sundata:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed
test.jck9.runtime.xml_schema.boeingData:
	@echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=jck9,testsuite=RUNTIME" $(LOG)
	@echo Target $@ completed

# Targets to run compiler test suites individually
test.jck9.compiler.api.java_rmi:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/java_rmi,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.api.javax_annotation:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_annotation,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.api.javax_lang:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_lang,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.api.javax_tools:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/javax_tools,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.api.signaturetest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=api/signaturetest,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.ANNOT:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ANNOT,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.ARR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ARR,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.BINC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/BINC,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.CLSS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CLSS,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.CONV :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/CONV,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.DASG :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/DASG,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.EXCP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXCP,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.EXEC :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXEC,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.EXPR :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/EXPR,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.FP :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/FP,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.ICLS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/ICLS,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.INTF :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INTF,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.LEX :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LEX,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.NAME :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/NAME,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.PKGS :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/PKGS,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.STMT :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/STMT,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.THRD :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/THRD,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.TYPE:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/TYPE,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.INFR:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/INFR,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.LMBD:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/LMBD,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed
test.jck9.compiler.lang.MOD:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=lang/MOD,jckversion=jck9,testsuite=COMPILER" $(LOG)
	echo Target $@ completed

# Targets to run devtools test suites individually
# java2schema already defined above, not broken down further
#test.jck9.devtools.java2schema:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=java2schema,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
#	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.additional:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/additional,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.annotations:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/annotations,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.attribute :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attribute,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.attributeGroup:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/attributeGroup,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.complexType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/complexType,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.datatypes :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/datatypes,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.element :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/element,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.errata10 :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/errata10,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.group :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/group,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.identityConstraint :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/identityConstraint,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.modelGroups :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/modelGroups,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.notations :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/notations,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.particles :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/particles,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.regex :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/regex,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.schema:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/schema,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.simpleType :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/simpleType,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.msData.wildcards:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/msData/wildcards,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/anyURI,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.base64Binary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/base64Binary,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/boolean,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/byte,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/date,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.dateTime :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/dateTime,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.decimal :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/decimal,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/double,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.duration :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/duration,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/float,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.gDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gDay,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonth,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.gMonthDay:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gMonthDay,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYear,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/gYearMonth,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.hexBinary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/hexBinary,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.ID:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/ID,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/int,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.integer:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/integer,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.language:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/language,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/long,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.Name:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/Name,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NCName,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.negativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/negativeInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.NMTOKEN :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/NMTOKEN,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.nonNegativeInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonNegativeInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/nonPositiveInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/normalizedString,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.positiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/positiveInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.QName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/QName,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/short,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/string,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/time,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/token,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedByte,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.unsignedInt :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedInt,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedLong,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.atomic.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/atomic/unsignedShort,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.anyURI:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/anyURI,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.base64Binary:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/base64Binary,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.boolean:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/boolean,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.byte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/byte,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.date:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/date,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.dateTime:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/dateTime,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.decimal:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/decimal,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.double:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/double,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.duration:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/duration,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.float:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/float,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.gDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gDay,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.gMonth :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonth,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.gMonthDay :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gMonthDay,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.gYear:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYear,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.gYearMonth:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/gYearMonth,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.hexBinary :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/hexBinary,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.ID :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/ID,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.int:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/int,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.integer :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/integer,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.language :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/language,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.long:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/long,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.Name   :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/Name,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.NCName:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NCName,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.negativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/negativeInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.NMTOKEN:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKEN,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.NMTOKENS:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/NMTOKENS,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.nonNegativeInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonNegativeInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.nonPositiveInteger :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/nonPositiveInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.normalizedString:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/normalizedString,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.positiveInteger:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/positiveInteger,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.QName :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/QName,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.short:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/short,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.string:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/string,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.time:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/time,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.token:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/token,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.unsignedByte:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedByte,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.unsignedInt:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedInt,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.unsignedLong:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedLong,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.list.unsignedShort:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/list/unsignedShort,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.nistData.union:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/nistData/union,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.sunData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/sunData,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.xml_schema.boeingData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=xml_schema/boeingData,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
# jaxws already defined above, not broken down further
#test.jck9.devtools.jaxws:
#	echo Running target $@
#	$(STF_COMMAND) -test=Jck -test-args="tests=jaxws,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
#	echo Target $@ completed
test.jck9.devtools.schema2java.nisttest:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/nisttest,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema2java.structures:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema2java/structures,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_class :
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_class,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_dom:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_dom,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_globalBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_globalBindings,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_property:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_property,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_factoryMethod:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_factoryMethod,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_inlineBinaryData:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_inlineBinaryData,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_javaType:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_javaType,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed
test.jck9.devtools.schema_bind.bind_schemaBindings:
	echo Running target $@
	$(STF_COMMAND) -test=Jck -test-args="tests=schema_bind/bind_schemaBindings,jckversion=jck9,testsuite=DEVTOOLS" $(LOG)
	echo Target $@ completed

help.jck:
	@echo -------------------------------------------------------------------------------
	@echo Help for JCK tests
	@echo -------------------------------------------------------------------------------
	@echo To run any JCK test
	@echo make test.jck.custom JCKVERSION=jckVersion JCKTESTSUITE=testsuite JCKTEST=testDirectory
	@echo JCKVERSION - jck8b or jck9
	@echo JCKTESTSUITE - COMPILER, DEVTOOLS or RUNTIME
	@echo JCKTEST - A JCK directory, e.g. api, api/javax_management, schema_bind, schema_bind/bind_javaType
	@echo Refer to the JCK documentation, directory structure or test output for valid JCKTEST values
	@echo -------------------------------------------------------------------------------
	@echo All other targets are either variants of the test.jck.custom target with preset
	@echo preset JCKVERSION, JCKTESTSUITE or JCKTEST values or represent groups of tests.
	@echo -------------------------------------------------------------------------------
	@echo In the targets which follow a different jck version - e.g. jck9 - can be
	@echo substituted for jck8b
	@echo -------------------------------------------------------------------------------
	@echo Additional custom targets - with preset JCKVERSION and JCKTESTSUITE
	@echo make test.jck8b.compiler.custom JCKTEST=testDirectory
	@echo make test.jck8b.devtools.custom JCKTEST=testDirectory
	@echo make test.jck8b.runtime.custom JCKTEST=testDirectory
	@echo -------------------------------------------------------------------------------
	@echo Targets which run groups of tests:
	@echo -------------------------------------------------------------------------------
	@echo These targets together run all the jck8b tests:
	@echo -------------------------------------------------------------------------------
	@echo make test.jck8b.runtime.api: Runs all non-interactive jck8b runtime api tests
	@echo make test.jck8b.runtime.api.noconfig: Runs all non-interactive jck8b runtime api tests except those which require Kerberos and http server setup
	@echo make test.jck8b.runtime.lang: Runs all non-interactive jck8b runtime lang tests
	@echo make test.jck8b.runtime.vm: Runs all non-interactive jck8b runtime vm tests
	@echo make test.jck8b.runtime.xml_schema: Runs all non-interactive jck8b runtime xml_schema tests
	@echo make test.jck8b.compiler.api: Runs all jck8b compiler api tests
	@echo make test.jck8b.compiler.lang: Runs all jck8b compiler lang tests
	@echo make test.jck8b.devtools.jaxws: Runs all jck8b devtools jaxws tests
	@echo make test.jck8b.devtools.java2schema: Runs all jck8b devtools java2schema tests
	@echo make test.jck8b.devtools.schema_bind: Runs all jck8b devtools schema_bind tests
	@echo make test.jck8b.devtools.schema2java: Runs all jck8b devtools schema2java tests
	@echo make test.jck8b.devtools.xml_schema: Runs all jck8b devtools xml_schema tests
	@echo -------------------------------------------------------------------------------
	@echo This target runs all the jck8b tests:
	@echo -------------------------------------------------------------------------------
	@echo make test.jck8b
	@echo -------------------------------------------------------------------------------
	@echo These targets avoid the tests which require external URLs and / or a Kerberos server.
	@echo -------------------------------------------------------------------------------
	@echo make test.jck8b.noconfig
	@echo make test.jck8b.runtime.api.noconfig
	@echo -------------------------------------------------------------------------------
	@echo When executing a test group, individual test targets can be excluded - e.g.
	@echo make test.jck8b.runtime.api EXCLUDE="api/javax_management api/java_awt"
	@echo -------------------------------------------------------------------------------
	@echo Run make help.jcktests to see a list of the individual test targets.

help.jcktests:
	@echo -------------------------------------------------------------------------------
	@echo Help for executing preset JCK test subsets
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck8b runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK8B_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck8b compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK8B_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck8b devtools tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK8B_DEVTOOLS_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck9 runtime tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK9_RUNTIME_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck9 compiler tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK9_COMPILER_TESTS))
	@echo -------------------------------------------------------------------------------
	@echo The following targets run preset subsets of the jck9 devtools tests
	@echo $(subst $(SPACE),$(NEWLINE)echo ,$(JCK9_DEVTOOLS_TESTS))
	