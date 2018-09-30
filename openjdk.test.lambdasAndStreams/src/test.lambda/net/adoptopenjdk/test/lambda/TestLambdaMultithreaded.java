/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * This test aims to use lambdas in a threaded environment. 
 * The lambdas are created in the main thread and used by multiple worker threads.
 * 
 * The features of the lambdas are:
 *   o Some lambdas use other lambdas.
 *   o Some lambdas contain internal state.
 *   
 * And the key points about the worker threads are:
 *   o The immutable Lambdas are concurrently used by multiple threads. No synchronization is used.
 *   o Each worker uses its own stack object. The test would fail if a lambda operated 
 *     on another threads stack.
 *   o Some of the lambdas have captured immutable objects, so these are used by multiple threads.
 *     The test would fail if a worker thread did not see the latest version of the object.
 * 
 * The test runs a micky mouse subset of the JVM opcodes.
 * Several threads run different sequences of 'bytecode' for approximately the same 
 * amount of time. (so that they really are multi-threaded for the majority of the test duration)
 */
public class TestLambdaMultithreaded extends TestCase {
	private int NUM_THREADS = 25;
	private int MAX_NUM_THREADS = 150;
	private int NUM_LOOPS = 200;
	
	// Track how many worker threads are running. Used to prevent too many running in a load test.
	private static AtomicInteger currentNumThreads = new AtomicInteger();
	
	// Define some interfaces for the opcode lambdas
	
	// Opcode which takes a value
	interface OpcodeV {  
		void execute(Stack<Integer> stack, int value);
	}
	
	// Opcode which takes a String value
	interface OpcodeS {  
		void execute(Stack<Integer> stack, String value);
	}
	
	// Opcode which only operates on the stack
	interface Opcode {   
		void execute(Stack<Integer> stack);
	}
	
	// Opcode which produces a result
	interface OpcodeR {  
		int execute(Stack<Integer> stack);
	}
	
	// Declare JVM opcodes
	private OpcodeV bipush;
	private Opcode  bipush_Zero;
	private Opcode  bipush_One;
	private Opcode  dup;
	private Opcode  dup2;
	private Opcode  iadd;
	private Opcode  iand;
	private Opcode  idiv;
	private Opcode  imul;
	private Opcode  isub;
	private OpcodeS ldc;
	private OpcodeR pop;
	private Opcode  pop2;
	private Opcode  swap;
	
	private final Integer Zero;
	private final Integer One;
	
	// Force constants into a hash map so that lambda object capture is a bit more complex
	private final ArrayList<String> constants = new ArrayList<String>();
	private final LinkedHashMap<String, Integer> constantsIndex= new LinkedHashMap<String, Integer>();
	
	public TestLambdaMultithreaded() {
		// Try to prevent compiler/jit optimization from making use of compile time constants.
		Zero = (int) Math.min(System.currentTimeMillis()/100000, 0);
		One  = (int) Math.min(System.currentTimeMillis()-88/123456, 1);
		
		// Create some constants for the lambdas to capture
		constantsIndex.put("FinalAnswer", 0);  // Passes in name and index
		constants.add("42");  // And now the actual value is added to the constants
		constantsIndex.put("TempBoilingPoint", 1);
		constants.add("212");
		constantsIndex.put("TempBody", 2);
		constants.add("98");
		constantsIndex.put("TempHotDay", 3);
		constants.add("86");
		constantsIndex.put("TempFreezingPoint", 4);
		constants.add("32");
		constantsIndex.put("TempCold", 5);
		constants.add("0");
		constantsIndex.put("TempReallyCold", 6);
		constants.add("-40");
		constantsIndex.put("Nine", 7);
		constants.add("9");
		constantsIndex.put("Four", 8);
		constants.add("4");
		constantsIndex.put("Three", 9);
		constants.add("3");
		constantsIndex.put("Two", 10);
		constants.add("2");

		// Create a lambda for each VM instructions
		bipush = (stack, value) -> {
			stack.push(value);
		};

		// Artificial instruction to force use of an object capture
		bipush_Zero = (stack) -> {
			stack.push(Zero);
		};

		// Another instruction to force object capture
		bipush_One = (stack) -> {
			stack.push(One);
		};

		dup = (stack) -> {
			if (stack.isEmpty()) {
				throw new IllegalStateException("Stack is empty");
			}
			stack.push(stack.peek());
		};

		dup2 = (stack) -> {
			int value1 = pop.execute(stack);
			int value2 = pop.execute(stack);
			bipush.execute(stack, value2);
			bipush.execute(stack, value1);
			bipush.execute(stack, value2);
			bipush.execute(stack, value1);
		};

		iadd = (stack) -> {
			stack.push(pop.execute(stack) + pop.execute(stack));
		};

		iand = (stack) -> {
			stack.push(pop.execute(stack) & pop.execute(stack));
		};

		idiv = (stack) -> {
			int value1 = pop.execute(stack);
			int value2 = pop.execute(stack);
			stack.push(value2 / value1);
		};

		imul = (stack) -> {
			stack.push(pop.execute(stack) * pop.execute(stack));
		};

		isub = (stack) -> {
			int value1 = pop.execute(stack);
			int value2 = pop.execute(stack);
			stack.push(value2 - value1);
		};

		ldc = (stack, constantName) -> {
			// Use the captured constant data structures to lookup the actual value
			int constantIndex = constantsIndex.get(constantName);
			String constantString = constants.get(constantIndex);
			int constantValue = Integer.parseInt(constantString);
			stack.push(constantValue);
		};
		
		pop = (stack) -> {
			if (stack.isEmpty()) {
				throw new IllegalStateException("Can't pop from an empty stack");
			}
			return stack.pop();
		};

		pop2 = (stack) -> {
			pop.execute(stack);
			pop.execute(stack);
		};

		swap = (stack) -> {
			int value1 = pop.execute(stack);
			int value2 = pop.execute(stack);
			bipush.execute(stack, value1);
			bipush.execute(stack, value2);
		};
	}
	
	@Test public void testLambdasWithMultipleThreads() throws Throwable {
		// To protect the system from being overloaded in a load test run, don't start too many threads.
		// If there are ready more worker threads running than the limit then don't
		// start any more, and return after a few seconds. 
		if (currentNumThreads.get() > MAX_NUM_THREADS) {
			System.out.println(Thread.currentThread().getName() + " Sleeping for 5 seconds (" + currentNumThreads.get() + " threads)");
			Thread.sleep(5 * 1000);
			return;
		}

		currentNumThreads.addAndGet(NUM_THREADS);
		System.out.println(Thread.currentThread().getName() + " MT running with " + currentNumThreads.get() + " threads");
		
		List<Throwable> failures = Collections.synchronizedList(new ArrayList<Throwable>());
		
		// Start multiple threads, each of which use the lambdas created in the main thread
		ArrayList<Thread> workerThreads = new ArrayList<Thread>();
		for (int i=0; i<NUM_THREADS; i++) {
			// Create a lambda for each thread
			int threadNum = i;
			Runnable testRunnable = () -> {
				Thread.currentThread().setName("Worker-" + threadNum);
				try {
					for (int x=0; x<NUM_LOOPS; x++) {
						runAllOpcodes();
						runNumberCounter();
						runSimpleMaths();
						runFibonacciSequence();
						runConvertFahrenheitToCelsius();
					}
				} catch (Throwable e) {
					failures.add(e);
				}
			};

			// Start a new thread
			Thread thread = new Thread(testRunnable);
			workerThreads.add(thread);
			thread.start();
		}
		
		// Wait for all threads to finish
		for (Thread thread:workerThreads) { 
			thread.join();
			currentNumThreads.decrementAndGet();
		}

		// Report first failure found by a worker thread
		if (!failures.isEmpty()) { 
			throw failures.get(0);
		}
	}

	private void runAllOpcodes() {
		Stack<Integer> stack = new Stack<Integer>();
		
		bipush.execute(stack, 30);
		bipush.execute(stack, 134);
		bipush.execute(stack, 22);
		bipush.execute(stack, 9);
		assertStack(stack, 9, 22, 134, 30);

		// dup: Duplicate topmost value and cleanup
		dup.execute(stack);
		assertStack(stack, 9, 9, 22, 134, 30);
		pop.execute(stack);
		assertStack(stack, 9, 22, 134, 30);
		
		// dup2: Duplicate topmost 2 values, and then cleanup
		dup2.execute(stack);
		assertStack(stack, 9, 22, 9, 22, 134, 30);
		pop.execute(stack);
		pop.execute(stack);
		assertStack(stack, 9, 22, 134, 30);
		
		// iadd: 9 + 22
		iadd.execute(stack);
		assertStack(stack, 31, 134, 30);

		// iand: 31 & 134, which is 11111 & 10000110
		iand.execute(stack);
		assertStack(stack, 6, 30);

		// idiv: 30 / 6
		idiv.execute(stack);
		assertStack(stack, 5);

		// imul: 5 * 12
		bipush.execute(stack, 12);
		imul.execute(stack);
		assertStack(stack, 60);

		// isub: 60 - 25
		bipush.execute(stack, 25);
		isub.execute(stack);
		assertStack(stack, 35);

		// ldc: load a fixed constant
		ldc.execute(stack, "FinalAnswer");
		assertStack(stack, 42, 35);
		pop.execute(stack);
		assertStack(stack, 35);
		
		// pop: Pop only value on the stack
		pop.execute(stack);
		assertStackEmpty(stack);

		// pop2: Build up the stack and pop the top 2 elements
		bipush.execute(stack, 9);
		bipush.execute(stack, 133);
		bipush.execute(stack, 4353);
		bipush.execute(stack, 98111);
		assertStack(stack, 98111, 4353, 133, 9);
		pop2.execute(stack);
		assertStack(stack, 133, 9);

		// swap: Swap top 2 elements
		swap.execute(stack);
		assertStack(stack, 9, 133);
	}
	
	private void runSimpleMaths() {
		// Calculate the value of (2+3+4) * 4 / (18/9)
		Stack<Integer> stack = new Stack<Integer>();

		// Add 2+3+4
		ldc.execute(stack, "Four");
		ldc.execute(stack, "Three");
		ldc.execute(stack, "Two");
		iadd.execute(stack);
		iadd.execute(stack);
		assertStack(stack, 9);

		// Now multiply by 4
		bipush.execute(stack, 4);
		imul.execute(stack);
		assertStack(stack, 36);

		// Calculate 18 / 9
		bipush.execute(stack, 18);
		bipush.execute(stack, 6);
		idiv.execute(stack);
		assertStack(stack, 3, 36);

		// Do the final division
		idiv.execute(stack);
		assertStack(stack, 12);
	}

	// Calculate the Fibonacci sequence, in which each number is the sum of the 2 previous numbers.
	// 0, 1, 1, 2, 3, 5, 8 ...
	private void runFibonacciSequence() {
		Stack<Integer> stack = new Stack<Integer>();

		// Seed the stack with the first two numbers.
		// This uses the Zero and One objects which are shared between threads.
		bipush_Zero.execute(stack); 
		bipush_One.execute(stack);

		for (int i=0; i<27; i++) {
			dup2.execute(stack);
			iadd.execute(stack);
		}

		// Check the sequence is correct (in reverse order)
		assertStack(stack,
				317811, 196418,	121393, 75025, 46368, 28657, 
				17711, 10946, 6765, 4181, 2584, 1597, 987, 
				610, 377, 233, 144, 89, 
				55, 34, 21, 13, 8, 5, 3, 2, 1, 1, 0);
	}

	// Counts up a bunch of numbers
	// Number range starts at 1 and ends with a randomly selected value.
	private void runNumberCounter() {
		long expected = 0;
		int numToCount = new Random().nextInt(1000)+1;
		
		// First do a count with a conventional loop to get the correct number
		for (int i=1; i<=numToCount; i++) { 
			expected += i;
		}
		
		// Now count them again using 'bytecode'
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=1; i<=numToCount; i++) {
			bipush.execute(stack, i); // Push all numbers onto the stack
		}
		while (stack.size() > 1) { 
			iadd.execute(stack); // Add all numbers together until there is just one left
		}
		
		// Make sure the answer calculated with lambdas matches the expected answer
		assertStack(stack, (int) expected);
	}
	
	private void runConvertFahrenheitToCelsius() {
		assertEquals(100, convertFahrenheitToCelsius("TempBoilingPoint")); 
		assertEquals(36,  convertFahrenheitToCelsius("TempBody"));
		assertEquals(30,  convertFahrenheitToCelsius("TempHotDay"));
		assertEquals(0,   convertFahrenheitToCelsius("TempFreezingPoint"));
		assertEquals(-17, convertFahrenheitToCelsius("TempCold"));
		assertEquals(-40, convertFahrenheitToCelsius("TempReallyCold"));
	}

	private int convertFahrenheitToCelsius(String fahrenheit) {
		Stack<Integer> stack = new Stack<Integer>();

		// Subtract 32 from the temperature
		ldc.execute(stack, fahrenheit);
		bipush.execute(stack, 32);
		isub.execute(stack);
		
		// Multiply by 5
		bipush.execute(stack, 5);
		imul.execute(stack);

		// Divide by 9
		ldc.execute(stack, "Nine");
		idiv.execute(stack);
		
		// Pull the answer from the stack
		Integer celsius = stack.get(0);
		return celsius;
	}

	
	private void assertStackEmpty(Stack<Integer> stack) {
		assertTrue(stack.isEmpty());
	}

	private void assertStack(Stack<Integer> stack, int... expectedValues) {
		assertEquals("Stack size wrong. Contains " + stack + " Sizes:", expectedValues.length, stack.size());
		
		for (int i=0; i<expectedValues.length; i++) {
			int actual = (int) stack.get(expectedValues.length - i -1);
			int expected = expectedValues[i];
			assertEquals("Stack does not contain expected value at index[" + i + "].", expected, actual);
		}
	}
}
