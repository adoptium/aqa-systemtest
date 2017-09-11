Java Math Tests
===============

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The Math suite contains simple tests which are designed to exercise the Math apis. There are three sets of tests, these do not have the same origins as they were created for different purposes. This set of tests has proved to be effective at uncovering Just-in-time Compiler bugs when running within our load testing framework. These test suites are only driven within the load testing framework.

The tests are grouped by package name as follows: Autosimd, BigDecimal and Math.

## How is it implemented?

##### Autosimd

These tests were created to test the exploitation of SIMD (Single Instruction Multiple Data) vector hardware instructions when using certain Java libraries and functions.  There are four test classes which perform a variety of different mathematical operations and check expected results. The only difference between the test classes is the type of the array under test - these are Double, Float, Integer and Long.

##### BigDecimal

These tests were created to exercise BigDecimal and its methods.  The 64 tests within this test bucket were all created by a model generator and use JUnit assertions to check expected behaviour.

##### Math

This package contains both a test class (MathAPITest.java) and a generator class (MathAPITestGenerator.java). The generator code is included for reference only. The MathAPITest class contains a simple collection of JUnit assertions covering the java.lang.Math API.

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. You can find the load tests which are defined to use these Math API tests, such as MathLoadTest.java, within the openjdk.test.load package.
