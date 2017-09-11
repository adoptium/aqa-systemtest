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

import org.junit.Test;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.support.Animal;
import net.adoptopenjdk.test.lambda.support.Person;
import net.adoptopenjdk.test.lambda.support.Person.Title;

/**
 * This test case covers the inferring of lambda parameters.
 * 
 * The lambda expression parameters are frequently specified, as in these examples:
 *   (int x, int y) -> x + y;
 *   (String s) -> s.length();
 *   
 * If the type of lambda parameters are not specified then the complier will infer them.
 * This allows expressions such as the following examples:
 *   (x, y) -> x + y;
 *   (s) -> s.length();
 *   x -> x + 1;
 *   Predicate<StockItem> inStock = (si) -> si.quantityAvailable() > 0;+
 */
public class TestLambdaInferredTyping extends TestCase 
{
	interface SingleAccounter { 
		int size(StringBuffer sb);
	}
	 
	//Target typing.
	// 
	// Infer the type of a single lambda parameter - so no need for enclosing '()' brackets,
	// or for the type of the parameter.
	@Test public void testInferredSingleParameter() {
		// Let target typing work out the type of 'sbuff'. Note no () around parameter.
		SingleAccounter a = sbuff -> sbuff.length();
		
		int result = a.size(new StringBuffer("ABC"));
		
		assertEquals(3, result);
	}
	
	interface Manipulator<T> {
		T munge(T t1);
	}
	
	// Target typing.
	// 
	// Infer the type of a single lambda generic parameter.
	@Test public void testInferredSingleGenericParameter() {
		// Let target typing work out the type of s.
		Manipulator<String> uppify = s -> s.toUpperCase();
		
		String result = uppify.munge("Alexander123");

		assertEquals("ALEXANDER123", result);
	}
	
	// Target typing.
	// 
	// Infer the type of a single generic lambda parameter, and run the lambda
	// with against a subtype of the declared parameter type.
	//
	@Test public void testInferredSingleGenericParameterUsingSubtype() {
		// Let target typing work out the type of s.
		Manipulator<Animal> manipulator = a -> new Animal(a.getId() + ".child");
		
		Person person = new Person(Title.MR, "David", "Napier", 31);
		Animal result = manipulator.munge(person);

		String expectedId = person.getId() + ".child";
		String actualId = result.getId();
		assertEquals(expectedId, actualId);
	}
	
	// Target typing.
	// 
	// Infer the type of a single lambda generic parameter. 
	// The type of the parameter is a Long so use autoboxing of long values.
	@Test public void testInferredSingleGenericParameterBoxing() {
		// Let target typing work out the type of s.
		Manipulator<Long> invert = l -> l * -1;

		long result = invert.munge(65535l);

		assertEquals(-65535, result);
	}

	interface ManipulateInt {
		int action(int x);
	}
	 
	// Target typing.
	// 
	// Infer the type of a single lambda parameter.  
	// The functional interface uses an intrinsic, and it is executed using Integer 
	// objects, so actual argument will need to be unboxed for lamda execution.
	@Test public void testInferredSingleGenericParameterUnboxing() {
		// Let target typing work out the type of i.
		ManipulateInt intCubed = i -> i*i*i;

		Integer expected = new Integer(27);
		Integer actual = intCubed.action(new Integer(3));

		assertEquals(expected, actual);
	}

	interface Accounter { 
		int size(Appendable sb, String s1);
	}
	 
	// Target typing.
	// 
	// Parameter types not specified in the formal parameter list.
	// Multiple parameters used so need the () notation.
	@Test public void testTargetTyping() {
		// Let target typing work out the type of 'buff' and 'str'
		Accounter a = (buff, str) -> { return buff.toString().length() > 0 ? buff.toString().length() : str.length(); };
		
		int result = a.size(new StringBuffer("ABC"), "-----");
		
		assertEquals(3, result);
	}
	
	interface AppendableAccounter { 
		String size(Appendable sb, Object o);
	}

	// Target typing.
	// 
	// Supply a subtype of the lamba parameter object. 
	@Test public void testSubtypeTargetTyping() {
		
		Accounter a = (buff, o) -> { return buff.toString().length() > 0 ? buff.toString().length() : o.hashCode(); };
		
		// Invoke the lambda using objects which are subtypes of its declared parameters.
		int result = a.size(new StringBuffer("ABC"), "-----");
		
		assertEquals(3, result);
	}
	
	interface Counter { 
		double sum(boolean bool, byte b, short s, int i, long l, float f, double d);
	}
	
	// Target typing.
	// 
	// Define the lambda without parameter types, and invoke Simplest case. Call a method on a known object.
	// Method syntax tested is: InstanceRef::MethodName 
	@Test public void testTargetTypingWithBoxing() {
		Counter counter = (vbool, vb, vs, vi, vl, vf, vd) -> new Double(vb + vs + vi + vl + vf + vd);

		double expectedTotal = 21.75;
		double actualTotal = counter.sum(
								Boolean.TRUE, 
								new Byte((byte) 1),    // total = 1
								new Short((short) 2),  // total now 3
								new Integer(3),        // now 6
								new Long(4),           // 10
								new Float(5.25),       // 15.25
								new Double(6.5));      // 21.75
		assertEquals(expectedTotal, actualTotal, 0.0001);
	}
}
