Modularity System Test Suite for Java 9.0 and up
================================================

Contents
---------- 
1. [What does it test?](#what-does-it-test)
2. [How are the tests implemented?](#how-are-the-tests-implemented)
3. [What setup is required?](#what-setup-is-required)
4. [Use cases](#use-cases)
5. [How do I manually run the testsuite?](#how-do-i-manually-run-the-testsuite)
6. [Are there any references?](#are-there-any-references)

###What does it test?

Modularity SVT test suite provides system verification for [Modular JDK](https://openjdk.java.net/jeps/200), new from Java 9.0. 
It breaks down testing into various user scenarios and provides implementation for each one of them.

Testing areas covered in Modularity test suite at a very high level:
- Migration of existing libraries or applications to Java 9
- Service providers
- Class loading
- Module override using --upgrade-module-path option
- Module override using --patch-module option
- Custom runtime image
- Layers

###How are the tests implemented? 

The test cases are all written in Java, using the [STF test framework](https://github.com/adoptium/stf/blob/master/stf.core/docs/STF-Manual.md).

At the top level, we have 'STF test' classes (e.g. under /openjdk.test.modularity/src/com.stf/net/adoptopenjdk/test/modularity.* package) that manage execution of one or more Java processes. These Java processes in turn drive the actual test classes (e.g. classes under /openjdk.test.modularity/src/tests/com.test/net/adoptopenjdk/test/modularity/junit.* package). Each test class contains one or more Junit test methods. Test validations typically take place both in these Junit test methods, as well as in the STF test classes.
      
openjdk.test.modularity project makes use of a number of test modules (found under common, common-mods, common-override, etc. folders) that 
are used for various testing purposes including patching, upgrading module paths, class loading, etc.
    
###What setup is required? 
openjdk.test.modularity can be built as part of aqa-systemtest on your local machine. Please follow instructions in the 
[aqa-systemtest wiki at Adopt](https://github.com/adoptium/aqa-systemtest/) for instructions on how to install systemtest prereqs. 
    
###Use cases 
    
Modularity test suite contains test cases that implement the following user scenarios. Please note that, these are higher level descriptions 
of each of the user scenarios listed below. For lower level descriptions, please see test source.
    
####Migrating existing libraries or applications to Java 9 
- As a tester I can run my modularized tests specified on --module-path using the non-modularized test harness on the classpath.
- As a developer I can use a non-modularized third party library with the a modularized application by converting it into an automatic module (to convert the library jar into an automatic module, place it on the module path). 
- As a developer I can convert a non-modularized third party library into an explicit modular jar by generating the module descriptor (using jdeps -genmodinfo) and editing it if required (to correct the dependencies and exports) and archiving it again into a modular jar (place the module descriptor module-info.class at the root directory). 
- As a customer I can migrate my Java application using encapsulated JDK internal APIs to Java 9 by using the work around option provided in modularity. 
- As a developer I can migrate my framework library to Java 9 by just exporting the non-exported packages that contain the public types which are accessed through reflection and by without reading the modules that provide these public types, as this will be taken care of by the platform module system. 

####Service providers
- As a developer I can enable my application to make use of different service implementations/providers using the same service interface APIs. 
- As a developer, I can use the service interface in my application module to resolve to the correct service provider when there are multiple service provider jars specified on the module path (service provider jars should be converted to automatic modules when specified on module path). 
- As a developer, I can use the service interface in my application module to resolve to the correct service provider when there are multiple service provider jars specified on the module path (provider1 - as exploded modules, provider2 - as modular jar, provider3 - regular jar with META_INF/services on module path) and classpath (provider 4 - regular jar with META_INF/services). 

####Class loading
- As a developer, I can use ClassLoader.getSystemResource() or Class.getResource() api's to read the resource files like security files, policy files or even class files and verify if the 'URL' supports 'jrt'. 
- As a user, I can use ClassLoader.getSystemResourceAsStream() on a class file (from classpath) or java.lang.reflect.Module#getResourceAsStream on a class file (from modules) to analyze the class byte code to check if any forbidden api's are used. The same can be extended to check what happens when a class file froman  unexported package is given.
- As a developer, I can locate and load the required classes or resources from both platform and application modules using the application classloader or custom class loader. 
- As a developer, I can locate and load the required classes from both platform and application modules in a custom runtime image using the application class loader or custom class loader. 
- As a developer, I can locate and load the required classes on the -Xbootclasspath by using -Xbootclasspath/a in my application. 
- As a developer, I can perform all the above using a custom runtime image. 
- As a developer, I can perform all the above in a multi-threaded stress test scenario. 
				
####Module override using --upgrade-module-path 
- As a developer I can run my application from any JRE by overriding a module using --upgrade-module-path (modules - in either modular jar format or exploded directory) 
	- Override an application module. 
	- Override an upgradable platform module.  
	- Override a non-upgradable platform module(Negative test). 
	- Override an application module using a custom runtime image. 
	- Override an upgradable platform module using a custom runtime image. 
	- Override a non-upgradable platform module using a custom runtime image(Negative test). 
	- Override a module using an automatic module on upgrademodulepath. 

####Module override using --patch-module 
- As a developer I can run my application from any JRE by replacing/adding some of the classes to the existing modules using --patch-module option 
	- Verify if we can specify multiple file paths to --patch-module. 
	- Verify if we can specify different file types (Files - can be existing class files, new class files, new packages containing classes or resources, existing resource files) to --patch-module. 
	- Verify if we can Patch System modules using different file types (exploded dir or modular jar). 
	- Verify if we can Patch an Application module  using different file types (exploded dir or modular jar). 
	- Include a new package that is not exported and check if the public type cannot be accessed. 
	- Include a new package that is not exported and check if the public type can be accessed by adding -XaddExports. 
	- Include a new package that is not exported and check if the public type can be accessed by adding -XaddExports. 
	- Verify if a module can be specified only once on --patch-module. 
	- Verify if it doesn't allow to replace module-info.class. 
	- Verify all above with a customer JRE. 
	
####Custom runtime image 
- As a product developer I can create a custom java runtime image with the required modules (modules - in either .jmod or modular jar format), resources and libraries. 
- As a product developer I can create a custom java runtime image with application module on module path, some of the system modules from the JRE using -limitmods or -addmods (modules - in either .jmod or modular jar format). 
- As a Product developer I can create a custom java runtime image (using jlink tool) using modules from another platform. 
- As a Product developer I can create a custom java runtime image using various jlink plugin options. 
- As a Product developer I can create a custom java runtime image using modules from Multi-Release jars. 

####Layers
- As an application developer, I can create a series of non-bootstrap Layers and load modules in those layers and make sure that the classes pertaining to those loaded modules get unloaded when no longer referenced.  

###How do I manually run the testsuite?
    
Once you have set up STF and compiled the test source in your workstation, you can run any test locally from the command line by using the following command: 

	stf.pl -test=<test_class_name> -test-args=<test_arguments>
  
Note:  
- test_class_name: Class name of any STF test plugin under openjdk.test.modularity/src/com.stf/net/adoptopenjdk/test/modularity.* package. 
- test_arguments: Any argument that a test might take (should be in [name]=[value] format). 

###Are there any references?
- [Modularity JEP 200](https://openjdk.java.net/jeps/200)
- [Modularity JEP 201](https://openjdk.java.net/jeps/201) 
- [Modularity JEP 260](https://openjdk.java.net/jeps/260)
- [Modularity JEP 261](https://openjdk.java.net/jeps/261) 
- [Jigsaw Quick Start](https://openjdk.java.net/projects/jigsaw/quick-start)
- [Jigsaw Talks](https://openjdk.java.net/projects/jigsaw/talks) 