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

import java.math.BigDecimal;
import java.util.function.DoubleUnaryOperator;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * This testcase runs recursive lambdas.
 */
public class TestLambdaRecursive extends TestCase 
{
	// Define functional interface which also takes itself as an argument
	public interface DoubleUnaryOperator2 {
	    double applyAsDouble(double operand, DoubleUnaryOperator2 self);
	}

	// Define similar functional interface, but for big decimals
	public interface BigDecimalUnaryOperator {
		BigDecimal applyAsBigDecimal(BigDecimal operand, BigDecimalUnaryOperator self);
	}

	// Run a lambda which recursively calls itself. 
	// 
	// Before a language change it used to be possible to write a lambda which directly 
	// referenced itself, but you will now find you get a compilation error saying 'you 
	// cannot reference a field before it is defined'. 
	// For example the following used to work:
	//   static DoubleUnaryOperator factorial = x -> x == 0 ? 1 : x// factorial.applyAsDouble(x - 1);
	//
	// So for this test the lambda is supplied a reference to itself at run time instead of 
	// compile time, hence the need for a functional interface which takes itself as a parameter.
	@Test public void testRecursiveLambda() {
		DoubleUnaryOperator2 factorial = (x, self) -> x == 0 ? 1 : x * self.applyAsDouble(x-1, self);
		
		// Invoke the lambda expression, and pass in itself to allow recursive calls.
		double result = factorial.applyAsDouble(10, factorial);
		assertEquals(3628800.0, result, 0.0);
	}
	
	// Test that lambda recursion works fine with a significantly deep stack.
	@Test public void testDeepRecursiveLambda() {
		int n = 2000;

		// Calculate expected factorial result using a loop
		BigDecimal expected = new BigDecimal("1");
		for (int i=1; i<=n; i++) {
			expected = expected.multiply(new BigDecimal(i));
		}
		
		// Calculate the factorial using a lambda expression.
		// The lambda expression is passed to itself, to allow recursive calls.
		BigDecimalUnaryOperator factorial = (x, self) -> x.equals(BigDecimal.ZERO) ? BigDecimal.ONE : x.multiply(self.applyAsBigDecimal(x.subtract(BigDecimal.ONE), self));
		BigDecimal actual = factorial.applyAsBigDecimal(new BigDecimal(n), factorial);
		
		assertEquals(expected.toPlainString(), actual.toPlainString());
	}

	// The lambda can't reference itself directly so go through a static method 
	static final DoubleUnaryOperator factorialIndirect = x -> x == 0 ? 1 : x * callFactorial(x - 1);

	// This method which runs the factorial lambda.
	// It is called from the 'factorial' lambda
	private static double callFactorial(double x) { 
		return factorialIndirect.applyAsDouble(x);
	}
	
	// Run a lambda which is indirectly recursive. 
	@Test public void testIndirectlyRecursive() {
		double result = factorialIndirect.applyAsDouble(10);
		assertEquals(3628800.0, result, 0.0);
	}
}
