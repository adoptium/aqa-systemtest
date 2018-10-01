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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import net.adoptopenjdk.test.lambda.support.Motorbike;
import net.adoptopenjdk.test.lambda.support.Person;
import net.adoptopenjdk.test.lambda.support.Person.Title;

/**
 * Lambda tests that implement user defined interfaces
 * 
 * The testcases consist of very simple lambda expressions with interfaces
 * defined above each test. The interfaces have been kept near the test in order
 * to improve readability. The areas under test are divided up as follows; 
 * - Testing different return types of lambdas.Testcases here include tests 
 * with no return value, intrinsic return types, object return types, arrays
 * as return types and autoboxing return types.
 * - Testing different parameter types
 */

public class TestLambdasUserDefinedInterface extends TestCase {
	
	// Testing return types
	// 
	// Test with no return value. No parameters have been input into the lambda and 
	// nothing is returned, but a parameter has been changed in order to check that the
	// lambda has done something.
	public interface Empty {
		void isLambdaEmpty();
	}

	private boolean lambdaRan;

	@Test public void noReturn() {
		Empty lamTestInt = () -> lambdaRan = true;
		lambdaRan = false;
		lamTestInt.isLambdaEmpty();
		assertTrue(lambdaRan);
	}

	// Intrinsic return types
	// 
	// No parameters are input into the lambda and an int is returned
	public interface OutputInt {
		int returnInt();
	}

	@Test public void testOutputInt() {
		OutputInt lamTestInt = () -> 7;
		assertEquals(7, lamTestInt.returnInt());
	}

	// No parameters are input into the lambda and a byte is returned
	public interface OutputByte {
		byte returnByte();
	}

	@Test public void testOutputByte() {
		OutputByte lamTestByte = () -> -50;
		assertEquals(-50, lamTestByte.returnByte());
	}

	// No parameters are input into the lambda and a short is returned
	public interface OutputShort {
		short returnShort();
	}

	@Test public void testOutputShort() {
		OutputShort lamTestShort = () -> 32000;
		assertEquals(32000, lamTestShort.returnShort());
	}

	// No parameters are input into the lambda and a long is returned
	public interface OutputLong {
		long returnLong();
	}

	@Test public void testOutputLong() {
		OutputLong lamTestLong = () -> 99000000;
		assertEquals(99000000, lamTestLong.returnLong());
	}

	// No parameters are input into the lambda and a char is returned
	public interface OutputChar {
		char returnChar();
	}

	@Test public void testOutputChar() {
		OutputChar lamTestChar = () -> 'f';
		assertEquals('f', lamTestChar.returnChar());
	}

	// No parameters are input into the lambda and a Boolean is returned
	public interface OutputBoolean {
		boolean returnBoolean();
	}

	@Test public void testOutputBoolean() {
		OutputBoolean lamTestBoolean = () -> true;
		assertEquals(true, lamTestBoolean.returnBoolean());
	}

	// No parameters are input into the lambda and a float is returned
	public interface OutputFloat {
		float returnFloat();
	}

	@Test public void testOutputFloat() {
		OutputFloat lamTestFloat = () -> 9.7f;
		assertEquals(9.7f, lamTestFloat.returnFloat(), 0.0);
	}

	// No parameters are input into the lambda and a double is returned
	public interface OutputDouble {
		double returnFLoat();
	}

	@Test public void testOutputDouble() {
		OutputDouble lamTestDouble = () -> 9.7d;
		assertEquals(9.7d, lamTestDouble.returnFLoat(), 0.0);
	}

	// Object return types
	// 
	// No parameters are input into the lambda and a string is returned
	public interface OutputString {
		String returnString();
	}

	@Test public void testOutputString() {
		OutputString lamTestString = () -> "potato";
		assertEquals("potato", lamTestString.returnString());
	}

	// No parameters are input into the lambda and a BigDecimal object is returned
	public interface OutputBigDecimal {
		java.math.BigDecimal returnBigDecimal();
	}

	@Test public void testOutputBigDecimal() {
		OutputBigDecimal lamTestBigDecimal = () -> new java.math.BigDecimal(
				"1.02481274854157451321023");
		assertEquals((new java.math.BigDecimal("1.02481274854157451321023")),
				lamTestBigDecimal.returnBigDecimal());
	}

	//  Return an object from a class written by a user
	// 
	//  No parameters are input and a Person object is created within the lambda.
	//  The first name of the Person is then returned.
	public interface OutputPerson {
		String returnFirstName();
	}
	
	@Test public void testOutputPerson() {
		OutputPerson lamTestOutputPerson = () -> {
			Person employee = new Person(Title.MR, "Bob", "Williams", 89);
			return employee.getFirstName();
		};
		assertEquals("Bob", lamTestOutputPerson.returnFirstName());
	}
	
	// No parameters are input and a Motorbike object is returned from the lambda.
	public interface OutputMotorbike {
		int returnMotorbike();
	}
	
	@Test public void testOutputMotorbike() {
		OutputMotorbike lamTestOutputMotorbike = () -> {
			Motorbike spider = new Motorbike(1, 5, 1);
			return spider.gear;
		};
		Motorbike harley = new Motorbike(1, 5, 1);
		assertEquals(harley.gear, lamTestOutputMotorbike.returnMotorbike());
	}
	
	//  No parameters are input into the lambda and null is returned from the lambda.
	public interface OutputNull {
		String returnNull();
	}

	@Test public void testOutputNull() {
		OutputNull lamTestNull = () -> { return null; };
		assertNull(lamTestNull.returnNull());
	}

	// Array return type
	// 
	//  No parameters are input into the lambda and an int array is returned
	public interface OutputArray {
		int[] returnArray();
	}

	int[] expectedArray = {1, 2, 3, 4};

	@Test public void testOutputArray() {

		OutputArray lamTestArray1 = () -> new int[] {1, 2, 3, 4};
		assertArraysEqual(expectedArray, lamTestArray1.returnArray());
	}

	private void assertArraysEqual(int[] expectedInts, int[] actualInts) {
		assertEquals(expectedInts.length, actualInts.length);

		for (int i = 0; i < expectedInts.length; i++) {
			assertEquals(expectedInts[i], actualInts[i]);
		}
	}

	// Array input as a parameter into the lambda and and the same array is then returned
	public interface OutputParameterArray {
		int[] returnArrayInput(int[] i);
	}

	@Test public void testOutputParameterArray() {
		OutputParameterArray lamTestArray2 = (int[] a) -> a;

		int[] numbers = {1, 2, 3, 4};
		int[] actualArray = lamTestArray2.returnArrayInput(numbers);

		int[] expectedArray = {1, 2, 3, 4};
		assertArraysEqual(expectedArray, actualArray);
	}

	private static String SampleString = "abc...xyz";

	public interface StringSupplier {
		String getString();
	}

	// No parameters are input into the lambda and a static string is returned
	@Test public void testReturnStatic() {
		StringSupplier supplier = () -> TestLambdasUserDefinedInterface.SampleString;
		String generatedString = supplier.getString();
		assertEquals("abc...xyz", generatedString);
	}
	
	// Autoboxing of a return value
	// 
	// Return type is specified in the interface and not in the lambda. The
	// return value is then checked against a known type.
	// 
	// Testcase where an Integer is given to the lambda but is autoboxed to an
	// int
	public interface AutoboxingReturnInt {
		Integer returnAutoboxInt();
	}

	@Test public void testAutoboxingReturnInt() {
		AutoboxingReturnInt lamTestAutoboxingReturnInt = () -> 5985;
		Integer expected = new Integer(5985);
		assertEquals(expected, lamTestAutoboxingReturnInt.returnAutoboxInt());
	}

	// Testcase where a Double is given to the lambda but is autoboxed to a double
	public interface AutoboxingReturnDouble {
		double returnAutoboxDouble();
	}

	@Test public void testAutoboxingReturnDouble() {
		AutoboxingReturnDouble lamTestAutoboxingReturnDouble = () -> 5.291;
		Double expectedDouble = new Double(5.291);
		assertEquals(expectedDouble, lamTestAutoboxingReturnDouble.returnAutoboxDouble());
	}

	// Testing parameter types
	// 
	// Tests that take no parameters input into the lambda Nothing is input and
	// an int is returned
	public interface RetInt {
		int returnInt();
	}

	@Test public void testRetInt() {
		RetInt lamTestRetInt = () -> 8;
		int intparameter = 8;
		assertEquals(intparameter, lamTestRetInt.returnInt());
	}

	// Intrinsic parameters types
	// 
	// An Int i is taken as a parameter to the lambda and i*4 is returned
	public interface MultiplyInt {
		int returnIntMultiply(int i);
	}

	@Test public void testMultiplyInt() {
		MultiplyInt lamTestMultiplyInt = (int i) -> i*4;
		int intparameter = 4;
		assertEquals(16, lamTestMultiplyInt.returnIntMultiply(intparameter));
	}

	// A short i is taken as a parameter to the lambda and a short (i/2) is returned
	public interface DivideShort {
		short returnShortDiv(short i);
	}

	@Test public void testDivideShort() {
		DivideShort lamTestDivideShort = (short i) -> (short) (i/2);
		short shortParameter = 4;
		assertEquals(2, lamTestDivideShort.returnShortDiv(shortParameter));
	}

	// An int i is taken as a parameter to the lambda, 2 is added to i and a short (i+2) is returned
	public interface AddIntShort {
		short returnShorAdd(int i);
	}

	@Test public void testAddIntShort() {
		AddIntShort lamTestAddIntShort = (int i) -> (short) (i+2);
		int intParameter = 4;
		assertEquals(6, lamTestAddIntShort.returnShorAdd(intParameter));
	}

	// A double d is taken as a parameter to the lambda 
	// and d is then multiplied by a constant 4 and returned
	public interface multiplyDouble {
		double returnDoubleMultiply(double d);
	}

	@Test public void testMultiplyDouble() {
		multiplyDouble lamTestMultiplyDouble = (double d) -> d*4;
		assertEquals(12.56636, lamTestMultiplyDouble.returnDoubleMultiply(3.14159), 0.0);
	}

	// A float f is taken as a parameter to the lambda. f is 
	// then multiply by a constant and returned a double
	public interface multiplyFloatDouble {
		double returnMultiplyFloatDouble(float f);
	}

	@Test public void testMultiplyFloatDouble() {
		multiplyFloatDouble lamTestMultiplyFloatDouble = f -> (double) (f*4);
		assertEquals(12.56636d, lamTestMultiplyFloatDouble.returnMultiplyFloatDouble(3.14159f), 0.1);
	}
	
	// Input a boolean to the lambda and output the inverse (so false)
	public interface inverseBoolean {
		boolean returnInverseBoolean(boolean i);
	}

	@Test public void testInverseBoolean() {
		inverseBoolean lamTestInverseBoolean = (boolean i) -> !i;
		assertEquals(false, lamTestInverseBoolean.returnInverseBoolean(true));
	}

	// Object parameters
	//
	// Input a string to the lambda and concatenate a constant string to it
	public interface addTwoStrings {
		String returnString(String s);
	}

	@Test public void testAddStrings() {
		addTwoStrings lamTestAddStrings = (String s) -> s+"bbb";
		assertEquals("hatsbbb", lamTestAddStrings.returnString("hats"));
	}

	// Input a string to the lambda and append another string to the front
	public interface appendTwoStrings {
		String returnTwoStrings(java.io.StringWriter i);
	}

	@Test public void testAppendTwoStrings() {
		appendTwoStrings lamTestAppendTwoStrings = (java.io.StringWriter i) -> {
			i.append("appleWedge");
			return i.toString();
		};
		java.io.StringWriter stringParameter = new java.io.StringWriter();
		stringParameter.append("one");
		assertEquals("oneappleWedge",
				lamTestAppendTwoStrings.returnTwoStrings(stringParameter));
	}

	// A BigDecimal number with many decimal figures is input to the lambda 
	// and compared to the same number with a large number of decimal figues
	public interface bigDecimalAccuracy {
		boolean returnBidDec(java.math.BigDecimal i);
	}

	@Test public void testBigfDecimalAccuracy() {
		bigDecimalAccuracy lamTestBigDecimalAccuracy = (java.math.BigDecimal i) -> i
				.equals(new java.math.BigDecimal(
						"1.23167212346345745896957423423654756856833563754856857226"));
		assertEquals(
				true,
				lamTestBigDecimalAccuracy
						.returnBidDec(new java.math.BigDecimal(
								"1.23167212346345745896957423423654756856833563754856857226")));
	}

	//  Lambda that uses a method from a user defined class
	//  
	//  Retrieves a name from a new Person object according to the Person class
	public interface PersonName {
		String getPersonName(Person p);
	}

	@Test
	public void testReturnPersonName() {
		PersonName lamtestReturnPersonName = (p) -> p.getName();
		Person person3 = new Person(Title.HRH, "Bob", "Jones", 34);

		assertEquals("HRH Bob Jones", lamtestReturnPersonName.getPersonName(person3));
	}

	// File object input into the lambda that then returns the parent file's name
	public interface FileToString {
		String returnParentFile(File i);
	}

	@Test public void testFile() {
		FileToString lamTestFileNameAsString = (f) -> f.getParentFile()
				.getName();

		File f = new File("/tmp/stuff/x.txt");

		assertEquals("stuff", lamTestFileNameAsString.returnParentFile(f));
	}

	//  Null object is given as a parameter to the lambda and a string is returned to 
	//  confirm it is null.
	public interface ParameterNull {
		String returnNull(File i);
	}

	@Test public void lambdaParameterNull() {
		ParameterNull lamTestParameterNull = (i) -> {
			if (i == null) {
				return "is null";
			}else{
				return "not null";
			}
		};

		assertEquals("is null", lamTestParameterNull.returnNull(null));
	}

	//  Array parameters. Input an array to the lambda and then return it as an
	//  array list
	public interface ArrayToList {
		List<Integer> returnArrayToList(Integer[] i);
	}

	@Test public void testlambdaArrayToList() {
		ArrayToList lamTestArrayToList = (arrayInputParameter) -> Arrays
				.asList(arrayInputParameter);

		Integer[] arrayInputParameter = { 1, 2, 3, 4, 5 };
		List<Integer> actual = lamTestArrayToList.returnArrayToList(arrayInputParameter);

		Integer[] intoList = { 1, 2, 3, 4, 5 };
		List<Integer> expected = Arrays.asList(intoList);
		assertEquals(expected, actual);
	}
	
	// Lambda tests that use varargs as parameters
	public interface Varargslambda {
		String method1(String... args);
	}

	//  String with varargs is input as a parameter to the lambda.  
	@Test
	public void testVarargs() {
		Varargslambda lamTestVarArgs = (String... args) -> {
			StringBuilder sb = new StringBuilder();
			int position = 1;
			for (String s : args) {
				sb.append(position);
				sb.append(":");
				sb.append(s);
				sb.append(" ");
				position++;
			}
			return sb.toString().trim();
		};

		String Result = lamTestVarArgs.method1("Hello", "I'm Steph");
		assertEquals("1:Hello 2:I'm Steph", Result);
	}

	//  Auto-boxing of the parameters given to a lambda
	//  
	// An Integer is input to a lambda and as the interface stipulates an int as input
	// the Integer is converted to an int. The int is then multiplied by two and returned.
	public interface AutoboxingParameterInt {
		int returnAutoboxInt(int i);
	}

	@Test public void testAutoboxingParameterInt() {
		AutoboxingParameterInt lamTestAutoboxingParameterInt = (i) -> i*2;
		int expected = 58;
		Integer input = new Integer(29);
		assertEquals(expected, lamTestAutoboxingParameterInt.returnAutoboxInt(input));
	}

	// An Double is input to a lambda and as the interface stipulates a double as input
	// the Double is converted to a double. The double is then divided by eight and returned.
	public interface AutoboxingParameterDouble {
		double returnAutoboxDouble(double i);
	}

	@Test public void testAutoboxingParameterDouble() {
		AutoboxingParameterDouble lamTestAutoboxingParameterDouble = (i) -> i/8;
		double expectedParam = 100d;
		Double input = new Double(800d);
		assertEquals(expectedParam,
				lamTestAutoboxingParameterDouble.returnAutoboxDouble(input), 0.1);
	}

	// Lambda exceptions testing
	// 
	// Two ints are input into the lambda which divides the first int by the second int.
	// The second int is 0 and hence an ArithmeticException should be thrown as specified 
	// in the test. 
	public interface ArithmeticOperation {
		int calculate(int i, int j);
	}
	
	@Test
	public void testArithmeticException() {
		ArithmeticOperation lamTestArithmeticException = (i, j) -> i / j;
		boolean exceptionCaught = false;
		try {
			lamTestArithmeticException.calculate(2, 0);
			fail("Expected exception");
		} catch (ArithmeticException expect) {
			// success
			exceptionCaught = true;
		}
		assertTrue(exceptionCaught);
	}

	// The lambda body creates a new FileInputStream for a file that does not exist. It is 
	// defined in both the interface and test that a FileNotFoundException may be thrown. 
	public interface CheckedExcpetion {
		int retriveFile(int f) throws FileNotFoundException;
	}

	@Test 
	public void testCheckedException() throws FileNotFoundException {
		CheckedExcpetion lamTestFNFException = (f) -> {
			new FileInputStream("dfdsfdsf/dsfsdf/");
			return 4;
		};
		boolean exceptionThrown = false;
		try {
			lamTestFNFException.retriveFile(17);
			fail("Expected excpetion");
		} catch (FileNotFoundException expect) {
			// success
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);
	}
	
	// A try catch block is defined within the lambda body designed to catch a 
	// NullPointerException. A null string is then input into the lambda and so the catch block 
	// catches the exception and handles it. The test is not told to handle the exception as this
	// is dealt with by the catch block.
	public interface StringConcatenation {
		String concatenate(String s);
	}
	
	@Test public void testLambdaExceptionHandling() throws NullPointerException {
		StringConcatenation lamTestNPException = (s) -> { 
			try {
				return s.concat("renkio"); 
			} catch (NullPointerException expected){
				return "Concatenation failed"; 
			}
		};
		String example = null;
		assertEquals("Concatenation failed", lamTestNPException.concatenate(example));
	}
}
