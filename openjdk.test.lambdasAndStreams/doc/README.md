# Lambda and Stream Tests

## Contents
  * Overview
  * How is it implemented?
  * Test Automation
  
## Overview 
#### Lambda Tests 
Lambda expressions were introduced in Java 8. They basically allow small blocks of java code to be embedded within a program in a much more concise form than traditional anonymous inner classes.

Here is a small section of code showing how a lambda is used to confirm that a button has been pushed. The lambda 
is passed into the addActionListen which is free to subsequently invoke the code as frequently as it sees fit: 
> JButton testButton = new JButton("Test Button");
   testButton.addActionListener(e -> System.out.println("Button has been pushed"));

The SVT lambda tests are a series of JUnit tests which verify that lambda expressions are working as expected.
Here is a table listing the lambda tests, in approximate order of complexity: 
1. TestLambdasUserDefinedInterface - Covers basic parameters and return types of lambdas including primitives, objects and exceptions.  
2. TestLambdaJavaInterfaces - Lambdas that implement interfaces supplied in the JCL such as Predicate or BinaryOperator.  
3. TestLambdaContexts - Tests locations in which a lambda expression can be used. Assignment, return statement, etc.
4. TestLambdaInferredTyping - Lambda argument types not specified, so compiler needs to infer their types.
5. TestLambdaLexicalScoping - Verifies that 'this' references address the correct object.
6. TestLambdaMethodReferences - Uses the different variations to address methods. eg, File::exists.
7. TestLambdaNested - Lambdas which contain and execute other lambdas.
8. TestLambdaRecursive  -  Lambdas which call themselves.
9. TestLambdaMultipleDefaults - Using interfaces with default methods and multiple implementors.
10. TestLambdaDefaultsAndStatics - Use interfaces which also use defaults and statics at some point in the hierarchy.
11. TestLambdaMultithreaded - Shares lambdas between multiple threads.
12. TestLambdaSerialization - Serializes and deserializes lambdas.
13. ClassLibraryLambdaTests -  Tests the changes made to the Java Class Library to support Lambdas.

#### Stream Tests
Streams were introduced in Java8. They basically switch the typical external iteration of java collections into internal iteration, with lambda expressions being used to filter, sort and collate the data.

Providing that the reader understands streams and lambdas this has the benefit of allowing a typical program to
be smaller and clearer than the conventional java solution. It is probably best to learn about lambda expression before streams as the typical stream test makes extensive use of lambdas.

Streams also make it easy to allow multiple threads to concurrently process the same dataset, with the java8 stream code handling the thread management and thread safe memory access.

The SVT stream tests are a series of JUnit tests which verify that streams are working as expected.
Here is a table listing the Streams tests, in approximate order of complexity: 
1. TestStreamOperations - Contains a number of test cases covering stream operations such as filter, map, reduce, collect, count, skip, etc.
2. TestParallelStreamOperations - More complex tests which use parallel streams.
  
## How is it implemented?
Both Lambda and Streams tests are implemented as self contained JUnit tests. These tests are invoked via the STF load test framework. 
 
## Test Automation
These tests are only run as part of the STF load testing framework stf.load. You can find the load tests which are defined to use these test.lambda API tests, such as LambdaLoadTest.java, within the openjdk.test.load package.