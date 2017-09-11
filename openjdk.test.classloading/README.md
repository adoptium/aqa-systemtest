Java Classloading Tests
=======================

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The Classloading suite contains tests which are designed to exercise different aspects of Java classloading. There are three sets of tests, these do not have the same origins as they were created for different purposes. These test suites are only driven within the load testing framework.

## How is it implemented?

##### ClassHog

This testcase reads a list of java classes out of the supplied class.dict file, each class is then loaded using Class.forName and the declared methods and fields for that class are listed. Once all of the classes specified within class.dict file have been loaded this is then repeated and then the test ends.

##### ClassMapHog

This testcase is based on the behaviour of the ClassHog test but here we store all the Class/Field/Method objects that the classloader provides into a hierarchically arranged HashMap tree. This allows us to populate quite a large nested HashMap of real objects, from a simply derived source. The idea being to stress the ClassLoader, the Garbage Collector (as it has to garbage collect class types and all of the objects put into the hashmaps) and the HashMap implementation.

##### DeadlockTest

This testcase verifies the correct behaviour of the ClassLoader.registerAsParallelCapable() API function which was added into SDK 7.0. The API call allows a ClassLoader to flag itself as being capable of parallel delegation which causes the VM to use a different locking mechanism for the selected ClassLoader. This feature aimed to eliminate a longstanding Java bug where classloaders that delegate to one another can create a situation where ClassLoader A takes a lock to load Class 1 and 
delegates the loading of Class 2 to ClassLoader B while class B is loading Class 3 itself holding a lock and attempting to delegate the loading of Class 4 to ClassLoader A. Under the old locking scheme this results in deadlock. With registerAsParallelCapable() the deadlock should be avoided.

In order for this test to work, the classes to be loaded should not be present on the classpath. They must instead be located using a URLClassLoader and the locations of the test classes should be passed in as arguments. The deadlock does not occur if the test classes are on the classpath. To facilitate this, these classes are built into their own 'bin_notonclasspath' directory when the testcases are built (see the openjdk.test.classloading/.classpath and build.xml files).

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. You can find the load tests which are defined to use these tests, such as ClassloadingLoadTest.java, within the openjdk.test.load package.
