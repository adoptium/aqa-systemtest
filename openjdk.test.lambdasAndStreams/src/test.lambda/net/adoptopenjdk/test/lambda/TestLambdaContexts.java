/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.test.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Random;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * This test case covers the contexts in which lambda expressions can be used.
 *
 * The locations which a lambda expression can be used are:
 *  - variable declarations
 *  - assignments
 *  - return statements
 *  - array initializers
 *  - constructor parameters 
 *  - method parameters
 *  - lambda expression bodies
 *  - conditional expressions (?:)
 *  - cast expressions
 */
public class TestLambdaContexts
{
	interface SingleAccounter { 
		int size(StringBuffer sb);
	}

	interface DoNothing {
		void run();
	}
	
	// Run an empty Lambda
	@Test public void testEmptyLamda() {
		// Run the empty lambda, even though it's lack of side effects mean its not possible
		// to tell if it has actually been run!
		DoNothing emptyLambda = () -> { };
		emptyLambda.run();
	}

	// Lambda in a variable declaration.
	@Test public void testVariableDeclaration() {
		// Standard case. Lambda expression assigned to a variable.
		SingleAccounter a = sbuff -> sbuff.length();
		
		int result = a.size(new StringBuffer("ABC"));
		
		assertEquals(3, result);
	}

	// Lambda in an assignment.
	@Test public void testVariableAssignment() {
		SingleAccounter a = sbuff -> sbuff.length();
		a = sbuff -> ("*" + sbuff + "*").length();  // assign a new lambda
		
		int result = a.size(new StringBuffer("ABC"));
		
		assertEquals(5, result);
	}

	// Lambda in a return statement.
	@Test public void testReturn() {
		SingleAccounter a = createExampleAccounter(7);
		
		int result = a.size(new StringBuffer(100).append("ABC"));
		
		assertEquals(100 - 3 + 7 + (7*4), result);
	}

	// This is the real test method.
	// Here we are returning a lambda expression.
	private SingleAccounter createExampleAccounter(int i) {
		int j;
		if (i % 2 == 0) {
			return sb -> sb.length();
		} else {
			j = i * 4; // For added interest create a local variable for the lambda to use
			return (StringBuffer sb) -> sb.capacity() - sb.length() + i + j;
		}
	}
	
	// Inner class for testing of lambda parameter to method & constructor calls
	private static class Evaluator {
		SingleAccounter accounter;
		
		// Constructor which takes a lambda expression
		public Evaluator(SingleAccounter accounter) {
			this.accounter = accounter;
		}
		
		// Run the current lambda expression
		public int evaluate(StringBuffer sbuff) {
			return accounter.size(sbuff);
		}

		// Supply a new lambda expression as method parameter
		public void setLambdaExpression(SingleAccounter accounter) {
			this.accounter = accounter;
		}
	}

	// Lambda as a constructor parameter.
	@Test public void testConstructorParameter() {
		// Pass a lambda expression into the constructor
		Evaluator e = new Evaluator(sb -> sb.capacity());
		
		int actual = e.evaluate(new StringBuffer(800).append("ABC"));
		
		int expected = 800;
		assertEquals(expected, actual);
	}

	// Lambda as a method parameter.
	@Test public void testMethodParameter() {
		Evaluator e = new Evaluator(null);
		e.setLambdaExpression(sb -> sb.length()); // Pass lambda in as a method parameter 
		
		int actual = e.evaluate(new StringBuffer(800).append("ABC"));
		
		int expected = 3;
		assertEquals(expected, actual);
	}
	
	interface IntSupplier { 
		int size(StringBuffer sb);
	}
	
	// Lambda in a array initializer.
	@Test public void testArrayInitializer() {
		// Initialize array, with each element containing a different lambda.
		// All invoked methods need a StringBuffer instance and return an int.
		IntSupplier[] accounters = {
				(StringBuffer sb) -> sb.capacity(),	// Full type specification
				(sb) -> sb.charAt(0),  // Inferred StringBuffer type
				sb -> sb.length(),	   // Also inferred, but no brackets needed
				StringBuffer::length   // Instance method of arbitrary object
		};
		
		int capacity = 800;
		StringBuffer sbuff = new StringBuffer(capacity).append("ABC");
		
		assertEquals(800, accounters[0].size(sbuff));
		assertEquals(65, accounters[1].size(sbuff));
		assertEquals(3, accounters[2].size(sbuff));
		assertEquals(3, accounters[3].size(sbuff));
	}
	
	// Interfaces for testing lambdas which return lambdas.
	public interface NestedLambda
	{
		Level2 methodA(int k);
	}

	public interface Level2
	{
		Level3 methodB(StringBuffer sb);
	}
	
	public interface Level3
	{
		String methodC(Long a);
	}
	
	// Testcase for lambdas in lambda expression bodies.
	// 
	// This test case is very artificial.
	@Test public void testLambdaInLambdaExpressionBody(){
		NestedLambda nestedLambda = (k) -> sb -> a -> "hello-" + sb.length() + "-" + (k+a);
		StringBuffer sb = new StringBuffer("abc");
		assertEquals("hello-3-7", nestedLambda.methodA(4).methodB(sb).methodC(3L));
	}

	interface StringProducer<T,R> {
		R generate(T t1);
	}

	// Testcase for conditional expressions which evaluate to a lambda expression.
	@Test public void testLambdaInConditionalExpression() {
		// Prevent possibility of the compiler from optimising away the conditional operation
		boolean before1970 = System.currentTimeMillis() < 10L;  // Should always be false 
		StringProducer<File, String> producer = before1970 ? File::getParent : File::getName;

		// Evaluate the lambda, which should be the getName from the false branch 
		File testFile = new File("/Catalog/A/B.txt");
		String result = producer.generate(testFile);
		assertEquals("B.txt", result);
	}

	interface FileOperation {
		boolean exists(File f);
	}
	
	// Test the use of Lambda expression in conjunction with an explicit cast. 
	// Without the casts the code in this test will not compile.
	@Test public void testCastLamdaExpression() {
		// The created lambda expression requires a cast in order to be able to assign it to an object.
		Object fileOp = (FileOperation) (f) -> f.exists();
		
		// Run lambda expression.
		// Cast the FileOp object, so that it can be evaluated
		File testFile = new File("/Catalog/A/B.txt");
		boolean result = ((FileOperation) fileOp).exists(testFile);
		
		assertFalse(result);
	}

	static Predicate<Long> isEven = x -> x%2 == 0;
	static Predicate<Long> isOdd = x -> x%2 != 0;
	static Predicate<Long> inThePast = t -> t <= System.currentTimeMillis();
	static long startTime = System.currentTimeMillis();
		
	// This test uses static lambdas.
	@Test public void testStaticLambda() {
		long r = new Random().nextLong();
		boolean haveEven = isEven.test(r);
		boolean haveOdd = isOdd.test(r);
		String failureMessage = "Only one conditions must be true: Random=" + r + " haveEven=" + haveEven + " haveOdd=" + haveOdd;

		// XOR - Only one of the conditions can be true
		assertTrue(failureMessage, haveEven ^ haveOdd);  

		assertTrue(inThePast.test(startTime));
	}
}
