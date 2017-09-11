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

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.junit.Test;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.support.Animal;
import net.adoptopenjdk.test.lambda.support.Motorbike;
import net.adoptopenjdk.test.lambda.support.Person;
import net.adoptopenjdk.test.lambda.support.Person.Title;

/**
 * These tests have been designed to test lambdas and the functional interfaces
 * provided in class library. The tests cover a range of functional interfaces
 * such as
 * 
 * Comparator: 
 * ~~~~~~~~~~~
 * A comparison function, which imposes a total ordering on some collection of objects. 
 * Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) 
 * to allow precise control over the sort order. Comparators can also be used to control 
 * the order of certain data structures (such as sorted sets or sorted maps), or to 
 * provide an ordering for collections of objects that don't have a natural ordering.
 *  
 * Predicate:
 * ~~~~~~~~~~
 * Represents a predicate (boolean-valued function) of one argument.
 *  
 * Consumer
 * ~~~~~~~~ 
 * Represents an operation that accepts a single input argument and returns no result. 
 * Unlike most other functional interfaces, Consumer is expected to operate via side-effects. 
 * 
 * Supplier
 * ~~~~~~~~ 
 * Represents a supplier of results. There * is no requirement that a new or distinct 
 * result be returned each time the supplier is invoked. 
 * 
 * Unary operator
 * ~~~~~~~~~~~~~~ 
 * Represents an operation on a single operand that produces a result of the same type as 
 * its operand. This is a specialization of Function for the case where the operand and 
 * result are of the same type. 
 * 
 * Binary operator
 * ~~~~~~~~~~~~~~~
 * Represents an operation upon two operands of the same type, producing a result of the 
 * same type as the operands. This is a specialization of BiFunction for the case where 
 * the operands and the result are all of the same type. 
 * 
 * Function
 * ~~~~~~~~
 * Represents a function that accepts one argument and produces a result.
 */
public class TestLambdaJavaInterfaces extends TestCase {

	// Comparator- A comparison function, which imposes a total ordering on some
	// collection of objects. Comparators can be passed to a sort method (such
	// as Collections.sort or Arrays.sort) to allow precise control over the
	// sort order. Comparators can also be used to control the order of certain
	// data structures (such as sorted sets or sorted maps), or to provide an
	// ordering for collections of objects that don't have a natural ordering.

	// The Comparator interface below is used with a lambda expression to
	// determine if of the two int values it is given the first value is greater
	// than, less than or equal to the second int value. The abstract method for
	// this functional interface is .compare().
	@Test public void testComparatorString() {
		Comparator<Integer> compareInteger = (i, j) -> {
			if (i > j) {
				return 1;
			} else if (i < j) {
				return -1;
			}
			;
			return 0;
		};
		int expected = -1;
		assertEquals(expected, compareInteger.compare(7, 12));
	}

	// Predicate- Represents a predicate (boolean-valued function) of one
	// argument.
	//
	// The BiPredicate interface is given a String s and a Long l, and asked to
	// return whether the length of s is greater than the length of l. It is then tested
	// twice-- one result is true (s is longer than l), the other is false (s is
	// not longer than l). BiPredicate takes two parameters, which are to be determined
	// when the interface is specified. In this example, the first parameter is
	// to be a String and the second a Long. The abstract method for this
	// functional interface is .test().
	@Test public void testBiPredicate() {
		BiPredicate<String, Long> isLonger = (s, l) -> {
			return s.length() > l;
		};

		assertTrue(isLonger.test("abcdefgh", 3L));
		assertFalse(isLonger.test("abcdefgh", 3434L));
	}

	// DoublePredicate is given a double and asked using a boolean function if
	// the double value is the same as the expected double value. Additionally
	// it is tested against two false expected values, a double and a long.The
	// abstract method for this functional interface is .test().
	@Test public void testDoublePredicate() {
		DoublePredicate isCorrect = (d) -> {
			return d > 2894d;
		};

		assertTrue(isCorrect.test(2898d));
		assertFalse(isCorrect.test(2751d));
		assertFalse(isCorrect.test(38L));
	}

	// Consumer- Represents an operation that accepts a single input argument
	// and returns no result. Unlike most other functional interfaces, Consumer
	// is expected to operate via side-effects.
	// 
	// The Consumer interface is specified below to accept a String as input
	// into the lambda. This String is added on to the consumedStrings variable
	// in the body of the lambda. The increased String in consumedString is then
	// checked. The abstract method for this functional interface is .accept().
	private String consumedStrings = "";

	@Test public void testStringConsumer() {
		Consumer<String> consumer = (s) -> {
			consumedStrings += s;
		};

		assertEquals("", consumedStrings);
		consumer.accept("TheCat");
		consumer.accept("Sat");
		consumer.accept("OnTheMat");
		assertEquals("TheCatSatOnTheMat", consumedStrings);
	}

	// BiConsumer represents an operation that accepts two input arguments and
	// returns no result. This is the two-arity specialization of Consumer. The
	// below example multiplies the two Integers and adds them to the
	// consumedTotal variable. The new consumed total variable is then
	// checked.The abstract method for this functional interface is .accept().
	private Integer consumedTotal = 51;

	@Test public void testBiConsumer() {
		BiConsumer<Integer, Integer> intConsumer = (i, j) -> {
			consumedTotal += i * j;
		};
		Integer expected1 = new Integer(51);
		assertEquals(expected1, consumedTotal);
		intConsumer.accept(15, 4);
		Integer exected2 = new Integer(111);
		assertEquals(exected2, consumedTotal);
	}

	// Supplier- Represents a supplier of results. There is no requirement that
	// a new or distinct result be returned each time the supplier is invoked.
	// This is a functional interface whose functional method is get().
	// 
	// The Supplier interface is used below to create a lambda that returns a new Animal 
	// object. The ID of the new animal is then checked using the .getId() method.
	@Test public void testSupplierString() {
		Supplier<Animal> stringSupplier = () -> {
			return new Animal("37");
		};
		Animal fox = stringSupplier.get();
		assertEquals("37", fox.getId());
	}

	// The Supplier interface is used below to create a lambda that returns a new Motorbike 
	// object. This cadence, speed and gear of the new Motorbike are then checked. 
	@Test public void testSupplierMotorbike() {
		Supplier<Motorbike> motorbikeSupplier = () -> {
			return new Motorbike(7, 5, 1);
		};
		Motorbike bike = motorbikeSupplier.get();
		assertEquals(7, bike.cadence);
		assertEquals(5, bike.speed);
		assertEquals(1, bike.gear);
		
	}

	// IntSupplier- Represents a supplier of int-valued results. This is a
	// functional interface whose functional method is getAsInt(). An example of the
	// IntSupplier interface is used here to create a new person object and the age is 
	// returned as an int.
	Person manager1 = new Person(Title.MR, "James", "Wilks", 55);

	@Test public void testSupplierPerson() {
		IntSupplier supplier = () -> {
			 Person manager1 = new Person(Title.MR, "James", "Wilks", 55);
			 return manager1.getAge();
		};
		assertEquals(55, supplier.getAsInt());
	};

	// Unary operator - Represents an operation on a single operand that
	// produces a result of the same type as its operand. This is a
	// specialization of Function for the case where the operand and result are
	// of the same type.
	// 
	// The abstract method for this functional interface is .apply(Object).
	@Test public void testUnaryOP() {
		UnaryOperator<Integer> intOperant = (i) -> {
			return i * i;
		};
		Integer expected = 16;
		assertEquals(expected, intOperant.apply(4));
	}

	// The LongUnaryOperator interface is used below to add 1 to a long value.
	// The abstract method for this functional interface is .applyAsLong().
	@Test public void testLongUnaryOp() {
		LongUnaryOperator longOperand = (l) -> {
			return l + 1;
		};
		long expected = 33L;
		assertEquals(expected, longOperand.applyAsLong(32L));
	}

	// Binary operator- Represents an operation upon two operands of the same
	// type, producing a result of the same type as the operands. This is a
	// specialization of BiFunction for the case where the operands and the
	// result are all of the same type.
	// 
	// The abstract method for this functional interface is .apply(Object).
	@Test public void testBinaryOp() {
		BinaryOperator<Float> floatBiOperand = (f, g) -> {
			return f * g;
		};
		float expectedFloat = 84F;
		assertEquals(expectedFloat, floatBiOperand.apply(7F, 12F), 0.1);
	}

	// Function- Represents a function that accepts one argument and produces a
	// result.
	// 
	// The abstract method for this functional interface is .apply(Object).
	@Test public void testFunction() {
		Function<Double, Double> functionDouble = (d) -> {
			return d * d * d / 2;
		};
		double expectedDouble = 864;
		assertEquals(expectedDouble, functionDouble.apply(12D), 0.1);
	}

	// Function interface is used to increase the speed of a Motorbike object
	Motorbike water = new Motorbike(8, 4, 2);

	@Test public void testFunctionMotorbike() {
		Function<Integer, Integer> functionIntMotorbike = (i) -> {
			water.speedUp(i);
			return water.speed;
		};
		Integer expectedSpeed = 8;
		assertEquals(expectedSpeed, functionIntMotorbike.apply(4));
	}
} 
