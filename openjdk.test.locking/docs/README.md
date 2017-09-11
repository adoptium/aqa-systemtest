Locking Tests
=============

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The Locker test was created to exercise lock contention against String and array objects, it was added specifically to test the optimization of this type of code by the IBM JIT.

## How is it implemented?

The Locking package includes the Locker test class and Reader and Writer 
thread classes. The Locker test spawns reader and writer threads, waits for a period of 
time and applies a lock if required.

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. You can find the load test which is defined to use this test, LockingLoadTest.java, within the openjdk.test.load package.




