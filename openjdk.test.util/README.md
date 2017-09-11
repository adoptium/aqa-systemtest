Java util Tests
===============

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The test.util package contains simple tests which are designed to exercise the java collection APIs within java.util. This set of tests has proved to be effective at uncovering Just-in-time Compiler bugs when running within our load testing framework.  These test suites are only driven within the load testing framework and have historically uncovered various JIT issues

The tests are grouped by package name as follows: hashmap, calendars, hashtable, solver, lilac, treemap.

## How is it implemented?

##### hashmap

Run a scenario "Hog" that uses a recursive set of HashMap objects

##### calendars

Validate that instances of the Calendar object are returning values that seem correct

##### hashtable

Tests the Hashtable class:
* Uses both local and long-running pool objects
* Exercises specific Hashtable API functions
* Tests serialization of Hashtables and their keys and values
* Stress tests adding and removing elements

##### solver

The game this code was initially designed to solve consists of 36 square cards, which each have 4 symbols on (Symbols are denoted by letters below).  The cards must be arranged in a 6x6 grid such the symbols on the edges of adjacent cards match up. This test has historically caused the JIT to crash or give incorrect results from time to time

##### lilac

Compare Vector and ArrayBlockingQueue objects to ensure they get the same values

##### treemap

Two sets of tests in here
* TreeMapAPITest verifies various parts of the TreeMap API calls and methods
* TreeMapTest performs more stressful testing of the TreeMap object

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. You can find the load tests which are defined to use these test.util API tests, such as UtilLoadTest.java, within the openjdk.test.load package.
