Java lang Tests
===============

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The test.lang package contains simple tests which are designed to exercise various features in java.lang, including annotations, method invokation, and Project Coin enhancements. 
This set of tests has proved to be effective at uncovering Just-in-time Compiler bugs when running within the STF load testing framework.  
These test suites are only driven within the load testing framework and have historically uncovered various JIT issues

The tests are grouped by package name as follows: annotations, invoke, and java7 (Project Coin).

## How is it implemented?

##### annotations

The annotation tests are designed to put stress on annotation API and do not attempt to test performance. 

The annotations are cached internally by the JVM and these tests will exercise this caching functionality by making many calls (stressing) to the various annotation methods. 

The annotation tests cover classes, fields, methods, constructors, enums and packages.

AnnotationTests.java runs all of the tests, whose code can be found in the Annotation*Tests.java files.

##### invoke

The "invoke" test package tests several classes inside the java.lang.invoke Java package, including: 

MethodHandle:
 - Testing of the various aspects of the the MethodHandle.asType() method. - AsTypeTest.java
 - Testing of static getters and setters - BasicStaticTest.java

MethodHandles:
 - Testing of argument type transformation for a method handle using MethodHandles.explicitCastArguments. - StaticAsTypeTestExplicit.java
 - Testing of argument type transformation for a method handle using MethodHandles.asType(). - StaticAsTypeTestImplicit.java
 
General java.lang.invoke testing:
 - A basic test of some of the java.lang.invoke api. - BasicTest.java
 - An improved version of BasicTest with a few more methods - BasicTest2.java

##### java7 (Project Coin)

Project Coin is a Java 7+ language feature that includes a large number of small enhancements to Java, including:
 - Improvements to the try-catch block logic (including OR operators and catch-all). - MultiCatchPreciseRethrow.java
 - Switching on Strings. - SwitchOnString.java
 - New support for automatic resource management. - TryWithResources.java
 - SuppressedExceptions. - TryWithResources.java

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. You can find the load tests which are defined to use these test.lang API tests, such as LangLoadTest.java, within the openjdk.test.load package.
