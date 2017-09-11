Java serialization Tests
========================

## Contents

  * [Overview](#overview)
  * [How is it implemented?](#how-is-it-implemented)
  * [Test Automation](#test-automation)

## Overview

The net.adoptopenjdk.test.serialization package contains simple tests which are designed to exercise the serialization functionality within java

## How is it implemented?

There are currently two tests:

##### "Serialization": Serializes a class which contains a String value and an int value. Only the String is marked as serialPersistent, so it expects the integer to come back as zero.

##### "SerializationBasicHFS": Serializes a class which contains a String value and an int value set to represent a date and makes sure it can come back (No restrictions on what fields are serialized)

## Test Automation

These tests are only run as part of the STF load testing framework stf.load. 
