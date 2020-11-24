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
package net.adoptopenjdk.test.math;

/**
 * MathAPITestGenerator
 * ======================
 * 
 * This class generates JUnit checked assertions to cover the API functions defined in the java.lang.StrictMath and java.lang.Math classes. The output from this
 * class is a JUnit class which can be executed to verify that the values returned from the API function calls match across different Java implementations
 * e.g. if TestGenerator is run against an openjdk JDK, the output produced saved and compiled, the resulting class can be run against the JDK under test
 * to verify that the results of the function calls when called from the JDK under test match the openjdk reference implementation.
 *  
 * The tests are generated from the data arrays at the top of the class. Each value in the array is passed into each of the function calls and a checked
 * assertion is produced.
 * 
 * For calls to java.lang.StrictMath methods the assertion is of the format 
 * 		assertEquals("<testcase name ::", <result of StrictMath function call on reference implementation>, <string representing equivalent StrictMath function call to be run on test JDK>);
 *
 *e.g. for the function StrictMath.acos(long) :
 *
 * 		assertEquals("acos(long)["+testCount+++"] ::\", " + 	StrictMath.acos(longTestValues[i]) + ", 	StrictMath.acos("+longTestStrings[i]+"));");
 *
 *   which becomes
 *
 *   	assertEquals("acos(long)[13] ::", 						3.141592653589793, 					StrictMath.acos(-1L));
 *
 *
 * For java.lang.Math methods the result of an operation which returns a float or double may be allowed to be less precise.  In this case the degree of tolerance
 * in the result is determined by executing StrictMat.ulp(expectedResult) and allowing for a tolerance of +/- the value returned.
 *
 *  The assertion in these cases is of the format:
 *
 * 		assertTrue("<testcase name ::", (<result of function call on reference java.lang.StrictMath implementation minus the allowable tolerance <= <string representing equivalent java.lang.Math function call to be run on test JDK>) && (<result of function call on reference java.lang.StrictMath implementation plus the allowable tolerance >= <string representing equivalent java.lang.Math function call to be run on test JDK>));
 *
 * e.g. for the function StrictMath.acos(double) :
 *
		assertTrue(\"acos(double)["+testCount+++"] ::\", " + (StrictMath.acos(doubleTestValues[i]) - StrictMath.ulp(StrictMath.acos(doubleTestValues[i]))) + " <= Math.acos("+doubleTestStrings[i]+") && " + (StrictMath.acos(doubleTestValues[i]) + StrictMath.ulp(StrictMath.acos(doubleTestValues[i]))) + " >= Math.acos("+doubleTestStrings[i]+"));
 *
 *   which becomes
 *
 * *   	assertTrue("acos(double)[1] ::", 1.5707963267948963 <= Math.acos((-Double.MIN_VALUE * 2000)) && 1.5707963267948968 >= Math.acos((-Double.MIN_VALUE * 2000)));
 *
 *
 * For java.lang.Math where a precision tolerance is not applicable (e.g. because they do not return a float or double),
 * the result of the java.lang.Math operation is validated against the result of the java.lang.StrictMath operation of
 * the reference implementation - i.e. the assertion is of the format:
 *
 * 		assertEquals("<testcase name ::", <result of StrictMath function call on reference implementation>, <string representing equivalent Math function call to be run on test JDK>);
 *
 *e.g. for the function StrictMath.acos(long) :
 *
 * 		assertEquals("acos(long)["+testCount+++"] ::\", " + 	StrictMath.acos(longTestValues[i]) + ", 	Math.acos("+longTestStrings[i]+"));");
 *
 *   which becomes
 *
 *   	assertEquals("acos(long)[13] ::", 						3.141592653589793, 					Math.acos(-1L));
 */

public class MathAPITestGenerator 
{

	private String[] doubleTestStrings = { 	
			"-Double.MAX_VALUE", "(-Double.MAX_VALUE / 200)", "(-Double.MAX_VALUE / 500)", "(-Double.MIN_VALUE * 2000)", "(-Double.MIN_VALUE * 1000)",
			"-2929112212.129231481346", "-2372.228212D", "-1.2232D", "0D", "2.43223D", "18232155.3323566D",
			"Double.MIN_VALUE", "(Double.MIN_VALUE * 200)", "(Double.MAX_VALUE / 500)", "(Double.MAX_VALUE / 200)", "Double.MAX_VALUE", "Double.MAX_VALUE + 1"
	};

	private double[] doubleTestValues = { 	
			-Double.MAX_VALUE, -Double.MAX_VALUE / 200, -Double.MAX_VALUE / 500, -Double.MIN_VALUE * 2000, -Double.MIN_VALUE * 1000, 
			-2929112212.129231481346, -2372.228212D, -1.2232D, 0D, 2.43223D, 18232155.3323566D,
			Double.MIN_VALUE, Double.MIN_VALUE * 200, Double.MAX_VALUE / 500, Double.MAX_VALUE / 200, Double.MAX_VALUE, Double.MAX_VALUE + 1
	};


	private String[] floatTestStrings = {	
			"-Float.MAX_VALUE", "(-Float.MAX_VALUE / 200)", "(-Float.MAX_VALUE / 500)", "(-Float.MIN_VALUE * 2000)", "(-Float.MIN_VALUE * 1000)", 
			"-32948748.958324F", "-0.000000009F", "-0.0000002F", "0F", "0.456232334F", "1224257.312321263F", "9999832342.12365F",
			"Float.MIN_VALUE", "(Float.MIN_VALUE * 200)", "(Float.MAX_VALUE / 500)", "(Float.MAX_VALUE / 200)", "Float.MAX_VALUE", "(Float.MAX_VALUE + 1)"
	};

	private float[] floatTestValues = 	{	
			-Float.MAX_VALUE, -Float.MAX_VALUE / 200, -Float.MAX_VALUE / 500, -Float.MIN_VALUE * 2000, -Float.MIN_VALUE * 1000, 
			-32948748.958324F, -0.000000009F, -0.0000002F, 0F, 0.456232334F, 1224257.312321263F, 9999832342.12365F,
			Float.MIN_VALUE, Float.MIN_VALUE * 200, Float.MAX_VALUE / 500, Float.MAX_VALUE / 200, Float.MAX_VALUE, Float.MAX_VALUE + 1
	};

	private String[] longTestStrings =	{
			"Long.MIN_VALUE", "(Long.MIN_VALUE + 1)", "(Long.MIN_VALUE + 2)", "-332342L", "-2L", "-1L",
			"0L",
			"1L", "2L", "348238234234L", "(Long.MAX_VALUE - 2)", "(Long.MAX_VALUE - 1)", "Long.MAX_VALUE"
	};	

	private long[] longTestValues	=	{
			Long.MIN_VALUE, Long.MIN_VALUE + 1, Long.MIN_VALUE + 2, -332342L, -2L, -1L,
			0L,
			1L, 2L, 348238234234L, Long.MAX_VALUE - 2, Long.MAX_VALUE - 1, Long.MAX_VALUE
	};

	private String[] intTestStrings =	{
			"Integer.MIN_VALUE", "(Integer.MIN_VALUE + 1)", "(Integer.MIN_VALUE + 2)", "-42218", "-2", "-1",
			"0",
			"1", "2", "892389", "(Integer.MAX_VALUE - 2)", "(Integer.MAX_VALUE - 1)", "Integer.MAX_VALUE"
	};

	private int[] intTestValues =		{
			Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2, -42218, -2, -1,
			0,
			1, 2, 892389, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
	};
	
	private float fTolerance = 0f;
	private double dTolerance = 0d;

	public static void main(String[] args)
	{
		MathAPITestGenerator ag = new MathAPITestGenerator();
		ag.generate();
	}
	
	private void generate()
	{
		int testCount;
		
		Float javaVersion = Float.parseFloat(System.getProperty("java.specification.version"));
		String generatorJdkRange = "";
		if ( javaVersion < 9 ) {
			generatorJdkRange = "preJdk9";
		}
		else {
			generatorJdkRange = "notPreJdk9";
		}
		
		System.out.println("/*******************************************************************************");
		System.out.println("* Licensed under the Apache License, Version 2.0 (the \"License\");");
		System.out.println("* you may not use this file except in compliance with the License.");
		System.out.println("* You may obtain a copy of the License at");
		System.out.println("*");
		System.out.println("*      https://www.apache.org/licenses/LICENSE-2.0");
		System.out.println("*");
		System.out.println("* Unless required by applicable law or agreed to in writing, software");
		System.out.println("* distributed under the License is distributed on an \"AS IS\" BASIS,");
		System.out.println("* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.");
		System.out.println("* See the License for the specific language governing permissions and");
		System.out.println("* limitations under the License.");
	    System.out.println("*******************************************************************************/");
		System.out.println("package net.adoptopenjdk.test.math;");
		System.out.println();
		System.out.println("import junit.framework.TestCase;");
		System.out.println();
		System.out.println("/**");
		System.out.println("* MathAPITest");
		System.out.println("* ======================");
		System.out.println("*"); 
		System.out.println("* A simple collection of JUnit assertions covering the java.lang.Math API. Automatically generated using MathAPITestGenerator.java");
		System.out.println("*"); 
		System.out.println("* Do not modify this file - it will be overwritten whenever MathAPITestGenerator.java is reexecuted.");
		System.out.println("* If test cases require modification make the changes to MathAPITestGenerator.java and regenerate this file.");
		System.out.println("*"); 
		System.out.println("* This version of MathAPITest was generated using the following JDK :");
		System.out.println("*");
		System.out.println("* java.vendor : " + System.getProperty("java.vendor"));
		System.out.println("* java.vendor.url : " + System.getProperty("java.vendor.url"));
		System.out.println("* java.version : " + javaVersion);
		System.out.println("* os.name : " + System.getProperty("os.name"));
		System.out.println("* os.arch : " + System.getProperty("os.arch"));
		System.out.println("*");
		System.out.println("**/");
		System.out.println();
		System.out.println("public class MathAPITest extends TestCase");
		System.out.println("{");
		System.out.println();
		System.out.println("private double Infinity = Double.MAX_VALUE * Double.MAX_VALUE;");
		System.out.println();
		System.out.println("private String generatorJdkRange = \"" + generatorJdkRange + "\";");
		System.out.println("private String runtimeJdkRange = \"\";");
		System.out.println("private Float javaVersion = 0.0f;");
		System.out.println();

		// **************************************************************************************
		
		// setup
		// **************************************************************************************
		System.out.println("public void setUp()");
		System.out.println("{");
		System.out.println("javaVersion = Float.parseFloat(System.getProperty(\"java.specification.version\"));");
		System.out.println("if ( javaVersion < 9 ) {");
		System.out.println("runtimeJdkRange = \"preJdk9\";");
		System.out.println("}");
		System.out.println("else {");
		System.out.println("runtimeJdkRange = \"notPreJdk9\";");
		System.out.println("}");
		System.out.println("}");
		System.out.println();

		// **************************************************************************************
		
		// abs - double, float, long, int
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testAbs_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			double multiplier = 1;
			if(doubleTestValues[i] < 0) {
				multiplier = -1;
			}

			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d, StrictMath.abs(" + doubleTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d, Math.abs(" + doubleTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, StrictMath.abs(" + doubleTestStrings[i] + " * 2d));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, Math.abs(" + doubleTestStrings[i] + " * 2d));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, StrictMath.abs(" + doubleTestStrings[i] + " * -2d));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, Math.abs(" + doubleTestStrings[i] + " * -2d));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			float multiplier = 1;
			if(floatTestValues[i] < 0) {
				multiplier = -1;
			}

			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f, StrictMath.abs(" + floatTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f, Math.abs(" + floatTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, StrictMath.abs(" + floatTestStrings[i] + " * 2f));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, Math.abs(" + floatTestStrings[i] + " * 2f));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, StrictMath.abs(" + floatTestStrings[i] + " * -2f));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, Math.abs(" + floatTestStrings[i] + " * -2f));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_long()");
		System.out.println("{");
	
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE, StrictMath.abs(Long.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE, Math.abs(Long.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, StrictMath.abs(Long.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, StrictMath.abs(Long.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1, StrictMath.abs(Long.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1, Math.abs(Long.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1 * -2, StrictMath.abs((Long.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1 * -2, Math.abs((Long.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * 2, StrictMath.abs((Long.MIN_VALUE + 1) * -2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * 2, Math.abs((Long.MIN_VALUE + 1) * -2));");

		for (int i = 0; i < longTestValues.length; i++)
		{
			if(!longTestStrings[i].contains("MIN_VALUE"))
			{
				int multiplier = 1;
				if(longTestValues[i] < 0) {
					multiplier = -1;
				}

				System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", " + longTestStrings[i] + "*" + multiplier + ", StrictMath.abs(" + longTestStrings[i] + "));");
				System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", " + longTestStrings[i] + "*" + multiplier + ", Math.abs(" + longTestStrings[i] + "));");
			}
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_integer()");
		System.out.println("{");
		
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE, StrictMath.abs(Integer.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, StrictMath.abs(Integer.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, StrictMath.abs(Integer.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1, StrictMath.abs(Integer.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1, Math.abs(Integer.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1 * -2, StrictMath.abs((Integer.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1 * -2, Math.abs((Integer.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * 2, StrictMath.abs((Integer.MIN_VALUE + 1) * -2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * 2, Math.abs((Integer.MIN_VALUE + 1) * -2));");

		for (int i = 0; i < intTestValues.length; i++)
		{
			if(!intTestStrings[i].contains("MIN_VALUE")) {
				int multiplier = 1;
				if(intTestValues[i] < 0) {
					multiplier = -1;
				}

				System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", " + intTestStrings[i] + "*" + multiplier + ", StrictMath.abs(" + intTestStrings[i] + "));");
				System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", " + intTestStrings[i] + "*" + multiplier + ", Math.abs(" + intTestStrings[i] + "));");
			}
		}
		System.out.println("}");
		System.out.println();
		// **************************************************************************************
		
		// acos/asin/atan - double, float, long, int
		// **************************************************************************************
		System.out.println("public void testAcos()");
		System.out.println("{");
		testCount = 0;
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(StrictMath.abs(doubleTestValues[i]) <= 1 && StrictMath.abs(doubleTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(double)["+testCount+++"] ::\", " + StrictMath.acos(doubleTestValues[i]) + ", StrictMath.acos("+doubleTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.acos(doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"acos(double)["+testCount+++"] ::\", " + StrictMath.acos(doubleTestValues[i]) + ", Math.acos("+doubleTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.acos(doubleTestValues[i]));
					System.out.println("assertTrue(\"acos(double)["+testCount+++"] ::\", " + (StrictMath.acos(doubleTestValues[i]) - dTolerance) + " <= Math.acos("+doubleTestStrings[i]+") && " + (StrictMath.acos(doubleTestValues[i]) + dTolerance) + " >= Math.acos("+doubleTestStrings[i]+"));");
					System.out.println("assertTrue(\"acos(double)["+testCount+++"] ::\", " + (StrictMath.acos(doubleTestValues[i]) - StrictMath.ulp(StrictMath.acos(doubleTestValues[i]))) + " <= Math.acos("+doubleTestStrings[i]+") && " + (StrictMath.acos(doubleTestValues[i]) + StrictMath.ulp(StrictMath.acos(doubleTestValues[i]))) + " >= Math.acos("+doubleTestStrings[i]+"));");
				}

			}
		}
		for (int i = 0; i < floatTestValues.length; i++)
		{
			if(StrictMath.abs(floatTestValues[i]) <= 1 && StrictMath.abs(floatTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(float)["+testCount+++"] ::\", " + StrictMath.acos(floatTestValues[i]) + ", StrictMath.acos("+floatTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.acos(floatTestValues[i])) ) {
					System.out.println("assertEquals(\"acos(float)["+testCount+++"] ::\", " + StrictMath.acos(floatTestValues[i]) + ", Math.acos("+floatTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.acos(floatTestValues[i]));
					System.out.println("assertTrue(\"acos(float)["+testCount+++"] ::\", " + (StrictMath.acos(floatTestValues[i]) - dTolerance) + " <= Math.acos("+floatTestStrings[i]+") && " + (StrictMath.acos(floatTestValues[i]) + dTolerance) + " >= Math.acos("+floatTestStrings[i]+"));");
				}
			}
		}
		for (int i = 0; i < longTestValues.length; i++)
		{
			if(StrictMath.abs(longTestValues[i]) <= 1 && StrictMath.abs(longTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(long)["+testCount+++"] ::\", " + StrictMath.acos(longTestValues[i]) + ", StrictMath.acos("+longTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.acos(longTestValues[i])) ) {
					System.out.println("assertEquals(\"acos(long)["+testCount+++"] ::\", " + StrictMath.acos(longTestValues[i]) + ", Math.acos("+longTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.acos(longTestValues[i]));
					System.out.println("assertTrue(\"acos(long)["+testCount+++"] ::\", " + (StrictMath.acos(longTestValues[i]) - dTolerance) + " <= Math.acos("+longTestStrings[i]+") && " + (StrictMath.acos(longTestValues[i]) + dTolerance) + " >= Math.acos("+longTestStrings[i]+"));");
				}
			}
		}
		for (int i = 0; i < intTestValues.length; i++)
		{
			if(StrictMath.abs(intTestValues[i]) <= 1 && StrictMath.abs(intTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(int)["+testCount+++"] ::\", " + StrictMath.acos(intTestValues[i]) + ", StrictMath.acos("+intTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.acos(intTestValues[i])) ) {
					System.out.println("assertEquals(\"acos(int)["+testCount+++"] ::\", " + StrictMath.acos(intTestValues[i]) + ", Math.acos("+intTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.acos(intTestValues[i]));
					System.out.println("assertTrue(\"acos(int)["+testCount+++"] ::\", " + (StrictMath.acos(intTestValues[i]) - dTolerance) + " <= Math.acos("+intTestStrings[i]+") && " + (StrictMath.acos(intTestValues[i]) + dTolerance) + " >= Math.acos("+intTestStrings[i]+"));");
				}
			}
		}
		System.out.println("}");
		System.out.println();
		
		System.out.println("public void testAsin()");
		System.out.println("{");
		testCount = 0;
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(StrictMath.abs(doubleTestValues[i]) <= 1 && StrictMath.abs(doubleTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(double)["+testCount+++"] ::\", " + StrictMath.asin(doubleTestValues[i]) + ", StrictMath.asin("+doubleTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.asin(doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"asin(double)["+testCount+++"] ::\", " + StrictMath.asin(doubleTestValues[i]) + ", Math.asin("+doubleTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.asin(doubleTestValues[i]));
					System.out.println("assertTrue(\"asin(double)["+testCount+++"] ::\", " + (StrictMath.asin(doubleTestValues[i]) - dTolerance) + " <= Math.asin("+doubleTestStrings[i]+") && " + (StrictMath.asin(doubleTestValues[i]) + dTolerance) + " >= Math.asin("+doubleTestStrings[i]+"));");
				}
			}
		}
		for (int i = 0; i < floatTestValues.length; i++)
		{
			if(StrictMath.abs(floatTestValues[i]) <= 1 && StrictMath.abs(floatTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(float)["+testCount+++"] ::\", " + StrictMath.asin(floatTestValues[i]) + ", StrictMath.asin("+floatTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.asin(floatTestValues[i])) ) {
					System.out.println("assertEquals(\"asin(float)["+testCount+++"] ::\", " + StrictMath.asin(floatTestValues[i]) + ", Math.asin("+floatTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.asin(floatTestValues[i]));
					System.out.println("assertTrue(\"asin(float)["+testCount+++"] ::\", " + (StrictMath.asin(floatTestValues[i]) - dTolerance) + " <= Math.asin("+floatTestStrings[i]+") && " + (StrictMath.asin(floatTestValues[i]) + dTolerance) + " >= Math.asin("+floatTestStrings[i]+"));");
				}
			}
		}
		for (int i = 0; i < longTestValues.length; i++)
		{
			if(StrictMath.abs(longTestValues[i]) <= 1 && StrictMath.abs(longTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(long)["+testCount+++"] ::\", " + StrictMath.asin(longTestValues[i]) + ", StrictMath.asin("+longTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.asin(longTestValues[i])) ) {
					System.out.println("assertEquals(\"asin(long)["+testCount+++"] ::\", " + StrictMath.asin(longTestValues[i]) + ", Math.asin("+longTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.asin(longTestValues[i]));
					System.out.println("assertTrue(\"asin(long)["+testCount+++"] ::\", " + (StrictMath.asin(longTestValues[i]) - dTolerance) + " <= Math.asin("+longTestStrings[i]+") && " + (StrictMath.asin(longTestValues[i]) + dTolerance) + " >= Math.asin("+longTestStrings[i]+"));");
				}
			}
		}
		for (int i = 0; i < intTestValues.length; i++)
		{
			if(StrictMath.abs(intTestValues[i]) <= 1 && StrictMath.abs(intTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(int)["+testCount+++"] ::\", " + StrictMath.asin(intTestValues[i]) + ", StrictMath.asin("+intTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.asin(intTestValues[i])) ) {
					System.out.println("assertEquals(\"asin(int)["+testCount+++"] ::\", " + StrictMath.asin(intTestValues[i]) + ", Math.asin("+intTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.asin(intTestValues[i]));
					System.out.println("assertTrue(\"asin(int)["+testCount+++"] ::\", " + (StrictMath.asin(intTestValues[i]) - dTolerance) + " <= Math.asin("+intTestStrings[i]+") && " + (StrictMath.asin(intTestValues[i]) + dTolerance) + " >= Math.asin("+intTestStrings[i]+"));");
				}
			}
		}
		System.out.println("}");
		System.out.println();
		
		System.out.println("public void testAtan()");
		System.out.println("{");
		testCount = 0;
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(double)["+testCount+++"] ::\", " + StrictMath.atan(doubleTestValues[i]) + ", StrictMath.atan("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.atan(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"atan(double)["+testCount+++"] ::\", " + StrictMath.atan(doubleTestValues[i]) + ", Math.atan("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.atan(doubleTestValues[i]));
				System.out.println("assertTrue(\"atan(double)["+testCount+++"] ::\", " + (StrictMath.atan(doubleTestValues[i]) - dTolerance) + " <= Math.atan("+doubleTestStrings[i]+") && " + (StrictMath.atan(doubleTestValues[i]) + dTolerance) + " >= Math.atan("+doubleTestStrings[i]+"));");
			}
		}
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(float)["+testCount+++"] ::\", " + StrictMath.atan(floatTestValues[i]) + ", StrictMath.atan("+floatTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.atan(floatTestValues[i])) ) {
				System.out.println("assertEquals(\"atan(float)["+testCount+++"] ::\", " + StrictMath.atan(floatTestValues[i]) + ", Math.atan("+floatTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.atan(floatTestValues[i]));
				System.out.println("assertTrue(\"atan(float)["+testCount+++"] ::\", " + (StrictMath.atan(floatTestValues[i]) - dTolerance) + " <= Math.atan("+floatTestStrings[i]+") && " + (StrictMath.atan(floatTestValues[i]) + dTolerance) + " >= Math.atan("+floatTestStrings[i]+"));");
			}
		}
		for (int i = 0; i < longTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(long)["+testCount+++"] ::\", " + StrictMath.atan(longTestValues[i]) + ", StrictMath.atan("+longTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.atan(longTestValues[i])) ) {
				System.out.println("assertEquals(\"atan(long)["+testCount+++"] ::\", " + StrictMath.atan(longTestValues[i]) + ", Math.atan("+longTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.atan(longTestValues[i]));
				System.out.println("assertTrue(\"atan(long)["+testCount+++"] ::\", " + (StrictMath.atan(longTestValues[i]) - dTolerance) + " <= Math.atan("+longTestStrings[i]+") && " + (StrictMath.atan(longTestValues[i]) + dTolerance) + " >= Math.atan("+longTestStrings[i]+"));");
			}
		}
		for (int i = 0; i < intTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(int)["+testCount+++"] ::\", " + StrictMath.atan(intTestValues[i]) + ", StrictMath.atan("+intTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.atan(intTestValues[i])) ) {
				System.out.println("assertEquals(\"atan(int)["+testCount+++"] ::\", " + StrictMath.atan(intTestValues[i]) + ", StrictMath.atan("+intTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.atan(intTestValues[i]));
				System.out.println("assertTrue(\"atan(int)["+testCount+++"] ::\", " + (StrictMath.atan(intTestValues[i]) - dTolerance) + " <= Math.atan("+intTestStrings[i]+") && " + (StrictMath.atan(intTestValues[i]) + dTolerance) + " >= Math.atan("+intTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();
		// **************************************************************************************
		
		// atan2 - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testAtan2()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length -1; i++)
		{
			System.out.println("assertEquals(\"atan2(double,double)["+testCount+++"] ::\", " + StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1]) + ", StrictMath.atan2("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			if ( Double.isInfinite(StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1])) ) {
				System.out.println("assertEquals(\"atan2(double,double)["+testCount+++"] ::\", " + StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.atan2("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1]));
				System.out.println("assertTrue(\"atan2(double,double)["+testCount+++"] ::\", " + (StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1]) - dTolerance) + " <= Math.atan2("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + ") && " + (StrictMath.atan2(doubleTestValues[i],doubleTestValues[i+1]) + dTolerance) + " >= Math.atan2("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// cbrt - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCbrt()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"cbrt(double)["+testCount+++"] ::\", " + StrictMath.cbrt(doubleTestValues[i]) + ", StrictMath.cbrt("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.cbrt(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"cbrt(double)["+testCount+++"] ::\", " + StrictMath.cbrt(doubleTestValues[i]) + ", Math.cbrt("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.cbrt(doubleTestValues[i]));
				System.out.println("assertTrue(\"cbrt(double)["+testCount+++"] ::\", " + (StrictMath.cbrt(doubleTestValues[i]) - dTolerance) + " <= Math.cbrt("+doubleTestStrings[i]+") && " + (StrictMath.cbrt(doubleTestValues[i]) + dTolerance) + " >= Math.cbrt("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ceil - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCeil()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"ceil(double)["+testCount+++"] ::\", " + StrictMath.ceil(doubleTestValues[i]) + ", StrictMath.ceil("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.ceil(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"ceil(double)["+testCount+++"] ::\", " + StrictMath.ceil(doubleTestValues[i]) + ", Math.ceil("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.ceil(doubleTestValues[i]));
				System.out.println("assertTrue(\"ceil(double)["+testCount+++"] ::\", " + (StrictMath.ceil(doubleTestValues[i]) - dTolerance) + " <= Math.ceil("+doubleTestStrings[i]+") && " + (StrictMath.ceil(doubleTestValues[i]) + dTolerance) + " >= Math.ceil("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// cos - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCos()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"cos(double)["+testCount+++"] ::\", " + StrictMath.cos(doubleTestValues[i]) + ", StrictMath.cos("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.cos(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"cos(double)["+testCount+++"] ::\", " + StrictMath.cos(doubleTestValues[i]) + ", Math.cos("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.cos(doubleTestValues[i]));
				System.out.println("assertTrue(\"cos(double)["+testCount+++"] ::\", " + (StrictMath.cos(doubleTestValues[i]) - dTolerance) + " <= Math.cos("+doubleTestStrings[i]+") && " + (StrictMath.cos(doubleTestValues[i]) + dTolerance) + " >= Math.cos("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();	
		// **************************************************************************************
		
		// cosh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCosh()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"cosh(double)["+testCount+++"] ::\", " + StrictMath.cosh(doubleTestValues[i]) + ", StrictMath.cosh("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.cosh(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"cosh(double)["+testCount+++"] ::\", " + StrictMath.cosh(doubleTestValues[i]) + ", Math.cosh("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.cosh(doubleTestValues[i]));
				System.out.println("assertTrue(\"cosh(double)["+testCount+++"] ::\", " + (StrictMath.cosh(doubleTestValues[i]) - dTolerance) + " <= Math.cosh("+doubleTestStrings[i]+") && " + (StrictMath.cosh(doubleTestValues[i]) + dTolerance) + " >= Math.cosh("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// copySign - double,double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCopySign_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], 0.0D) + ", StrictMath.copySign("+doubleTestStrings[i]+",0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 0.0D) + ", Math.copySign("+doubleTestStrings[i]+",0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], 1.0D) + ", StrictMath.copySign("+doubleTestStrings[i]+",1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 1.0D) + ", Math.copySign("+doubleTestStrings[i]+",1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], 0.222231D) + ", StrictMath.copySign("+doubleTestStrings[i]+",0.222231D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 0.222231D) + ", Math.copySign("+doubleTestStrings[i]+",0.222231D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], -0.0D) + ", StrictMath.copySign("+doubleTestStrings[i]+",-0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], -0.0D) + ", StrictMath.copySign("+doubleTestStrings[i]+",-0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], -1.0D) + ", StrictMath.copySign("+doubleTestStrings[i]+",-1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], -1.0D) + ", Math.copySign("+doubleTestStrings[i]+",-1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], -0.222231D) + ", StrictMath.copySign("+doubleTestStrings[i]+",-0.222231D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], -0.222231D) + ", Math.copySign("+doubleTestStrings[i]+",-0.222231D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + StrictMath.copySign(doubleTestValues[i], doubleTestValues[i]) + ", StrictMath.copySign("+doubleTestStrings[i]+","+doubleTestStrings[i]+"));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], doubleTestValues[i]) + ", Math.copySign("+doubleTestStrings[i]+","+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// copySign - float,float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCopySign_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], 0.0D) + "F, StrictMath.copySign("+floatTestStrings[i]+",0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 0.0D) + "F, Math.copySign("+floatTestStrings[i]+",0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], 1.0D) + "F, StrictMath.copySign("+floatTestStrings[i]+",1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 1.0D) + "F, Math.copySign("+floatTestStrings[i]+",1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], 0.222231D) + "F, StrictMath.copySign("+floatTestStrings[i]+",0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 0.222231D) + "F, Math.copySign("+floatTestStrings[i]+",0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], -0.0D) + "F, StrictMath.copySign("+floatTestStrings[i]+",-0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -0.0D) + "F, Math.copySign("+floatTestStrings[i]+",-0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], -1.0D) + "F, StrictMath.copySign("+floatTestStrings[i]+",-1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -1.0D) + "F, Math.copySign("+floatTestStrings[i]+",-1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], -0.222231D) + "F, StrictMath.copySign("+floatTestStrings[i]+",-0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -0.222231D) + "F, Math.copySign("+floatTestStrings[i]+",-0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + StrictMath.copySign(floatTestValues[i], floatTestValues[i]) + "F, StrictMath.copySign("+floatTestStrings[i]+","+floatTestStrings[i]+"));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], floatTestValues[i]) + "F, Math.copySign("+floatTestStrings[i]+","+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// exp - double
		// Exclude Math.exp on win_x86-32 hotspot jdk11 or later when the expected result is
		// Infinity pending resolution to issues:
		// https://github.com/AdoptOpenJDK/openjdk-tests/issues/2062
		// https://github.com/AdoptOpenJDK/openjdk-support/issues/182
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testExp()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"exp(double)["+testCount+++"] ::\", " + StrictMath.exp(doubleTestValues[i]) + ", StrictMath.exp("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.exp(doubleTestValues[i])) ) {
				System.out.println("if ( ! ( System.getProperty(\"sun.arch.data.model\").equals(\"32\") && System.getProperty(\"os.name\").toLowerCase().contains(\"win\") && runtimeJdkRange.equals(\"notPreJdk9\") ) ) {assertEquals(\"exp(double)["+testCount+++"] ::\", " + StrictMath.exp(doubleTestValues[i]) + ", Math.exp("+doubleTestStrings[i]+"));}");
				//System.out.println("assertEquals(\"exp(double)["+testCount+++"] ::\", " + StrictMath.exp(doubleTestValues[i]) + ", Math.exp("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.exp(doubleTestValues[i]));
				System.out.println("assertTrue(\"exp(double)["+testCount+++"] ::\", " + (StrictMath.exp(doubleTestValues[i]) - dTolerance) + " <= Math.exp("+doubleTestStrings[i]+") && " + (StrictMath.exp(doubleTestValues[i]) + dTolerance) + " >= Math.exp("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// expm1 - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testExpm1()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"expm1(double)["+testCount+++"] ::\", " + StrictMath.expm1(doubleTestValues[i]) + ", StrictMath.expm1("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.expm1(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"expm1(double)["+testCount+++"] ::\", " + StrictMath.expm1(doubleTestValues[i]) + ", Math.expm1("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.expm1(doubleTestValues[i]));
				System.out.println("assertTrue(\"expm1(double)["+testCount+++"] ::\", " + (StrictMath.expm1(doubleTestValues[i]) - dTolerance) + " <= Math.expm1("+doubleTestStrings[i]+") && " + (StrictMath.expm1(doubleTestValues[i]) + dTolerance) + " >= Math.expm1("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// floor - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testFloor()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"floor(double)["+testCount+++"] ::\", " + StrictMath.floor(doubleTestValues[i]) + ", StrictMath.floor("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.floor(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"floor(double)["+testCount+++"] ::\", " + StrictMath.floor(doubleTestValues[i]) + ", Math.floor("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.floor(doubleTestValues[i]));
				System.out.println("assertTrue(\"floor(double)["+testCount+++"] ::\", " + (StrictMath.floor(doubleTestValues[i]) - dTolerance) + " <= Math.floor("+doubleTestStrings[i]+") && " + (StrictMath.floor(doubleTestValues[i]) + dTolerance) + " >= Math.floor("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// getExponent - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testGetExponent_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"getExponent(double)["+testCount+++"] ::\", " + StrictMath.getExponent(doubleTestValues[i]) + ", StrictMath.getExponent("+doubleTestStrings[i]+"));");
			System.out.println("assertEquals(\"getExponent(double)["+testCount+++"] ::\", " + StrictMath.getExponent(doubleTestValues[i]) + ", Math.getExponent("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// getExponent - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testGetExponent_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"getExponent(float)["+testCount+++"] ::\", " + StrictMath.getExponent(floatTestValues[i]) + ", StrictMath.getExponent("+floatTestStrings[i]+"));");
			System.out.println("assertEquals(\"getExponent(float)["+testCount+++"] ::\", " + StrictMath.getExponent(floatTestValues[i]) + ", Math.getExponent("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// hypot - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testHypot()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length -1; i++)
		{
			System.out.println("assertEquals(\"hypot(double,double)["+testCount+++"] ::\", " + StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1]) + ", StrictMath.hypot("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			if ( Double.isInfinite(StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1])) ) {
				System.out.println("assertEquals(\"hypot(double,double)["+testCount+++"] ::\", " + StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.hypot("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1]));
				System.out.println("assertTrue(\"hypot(double,double)["+testCount+++"] ::\", " + (StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1]) - dTolerance) + " <= Math.hypot("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + ") && " + (StrictMath.hypot(doubleTestValues[i],doubleTestValues[i+1]) + dTolerance) + " >= Math.hypot("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// IEEEremainder - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testIEEEremainder()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length -1; i++)
		{
			if(doubleTestValues[i+1] != 0) // returns NaN
			{
				System.out.println("assertEquals(\"IEEEremainder(double,double)["+testCount+++"] ::\", " + StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]) + ", StrictMath.IEEEremainder("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
				if ( Double.isInfinite(StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1])) ) {
					System.out.println("assertEquals(\"IEEEremainder(double,double)["+testCount+++"] ::\", " + StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.IEEEremainder("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]));
					System.out.println("assertTrue(\"IEEEremainder(double,double)["+testCount+++"] ::\", " + (StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]) - dTolerance) + " <= Math.IEEEremainder("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + ") && " + (StrictMath.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]) + dTolerance) + " >= Math.IEEEremainder("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
				}
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// log - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testLog()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"log(double)["+testCount+++"] ::\", " + StrictMath.log(doubleTestValues[i]) + ", StrictMath.log("+doubleTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.log(doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"log(double)["+testCount+++"] ::\", " + StrictMath.log(doubleTestValues[i]) + ", Math.log("+doubleTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.log(doubleTestValues[i]));
					System.out.println("assertTrue(\"log(double)["+testCount+++"] ::\", " + (StrictMath.log(doubleTestValues[i]) - dTolerance) + " <= Math.log("+doubleTestStrings[i]+") && " + (StrictMath.log(doubleTestValues[i]) + dTolerance) + " >= Math.log("+doubleTestStrings[i]+"));");
				}
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// log10 - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testLog10()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"log10(double)["+testCount+++"] ::\", " + StrictMath.log10(doubleTestValues[i]) + ", StrictMath.log10("+doubleTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.log10(doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"log10(double)["+testCount+++"] ::\", " + StrictMath.log10(doubleTestValues[i]) + ", Math.log10("+doubleTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.log10(doubleTestValues[i]));
					System.out.println("assertTrue(\"log10(double)["+testCount+++"] ::\", " + (StrictMath.log10(doubleTestValues[i]) - dTolerance) + " <= Math.log10("+doubleTestStrings[i]+") && " + (StrictMath.log10(doubleTestValues[i]) + dTolerance) + " >= Math.log10("+doubleTestStrings[i]+"));");
				}
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// log1p - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testLog1p()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(doubleTestValues[i] > -1)
			{
				System.out.println("assertEquals(\"log1p(double)["+testCount+++"] ::\", " + StrictMath.log1p(doubleTestValues[i]) + ", StrictMath.log1p("+doubleTestStrings[i]+"));");
				if ( Double.isInfinite(StrictMath.log1p(doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"log1p(double)["+testCount+++"] ::\", " + StrictMath.log1p(doubleTestValues[i]) + ", Math.log1p("+doubleTestStrings[i]+"));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.log1p(doubleTestValues[i]));
					System.out.println("assertTrue(\"log1p(double)["+testCount+++"] ::\", " + (StrictMath.log1p(doubleTestValues[i]) - dTolerance) + " <= Math.log1p("+doubleTestStrings[i]+") && " + (StrictMath.log1p(doubleTestValues[i]) + dTolerance) + " >= Math.log1p("+doubleTestStrings[i]+"));");
				}
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// max - double, float, long, int
		// **************************************************************************************	
		testCount = 0;
		System.out.println("public void testMax_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length -1; i++)
		{
			double max = doubleTestValues[i];
			if(doubleTestValues[i] < doubleTestValues[i+1]) {
				max = doubleTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, StrictMath.max(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, StrictMath.max(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, StrictMath.max(" + doubleTestValues[i] + "d," + max + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i] + "d," + max + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, StrictMath.max(" + doubleTestValues[i+1] + "d," + max + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i+1] + "d," + max + "d));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length -1; i++)
		{
			float max = floatTestValues[i];
			if(floatTestValues[i] < floatTestValues[i+1]) {
				max = floatTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, StrictMath.max(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, StrictMath.max(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, StrictMath.max(" + floatTestValues[i] + "f," + max + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i] + "f," + max + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, StrictMath.max(" + floatTestValues[i+1] + "f," + max + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i+1] + "f," + max + "f));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_long()");
		System.out.println("{");
		for (int i = 0; i < longTestValues.length -1; i++)
		{
			long max = longTestValues[i];
			if(longTestValues[i] < longTestValues[i+1]) {
				max = longTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, StrictMath.max(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, StrictMath.max(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, StrictMath.max(" + longTestValues[i] + "l," + max + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i] + "l," + max + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, StrictMath.max(" + longTestValues[i+1] + "l," + max + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i+1] + "l," + max + "l));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_int()");
		System.out.println("{");
		for (int i = 0; i < intTestValues.length -1; i++)
		{
			int max = intTestValues[i];
			if(intTestValues[i] < intTestValues[i+1]) {
				max = intTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", StrictMath.max(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", StrictMath.max(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", StrictMath.max(" + intTestValues[i] + "," + max + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i] + "," + max + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", StrictMath.max(" + intTestValues[i+1] + "," + max + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i+1] + "," + max + "));");
		}
		System.out.println("}");
		System.out.println();
		// **************************************************************************************
				
		// min - double, float, long, int
		// **************************************************************************************	
		testCount = 0;
		System.out.println("public void testMin_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length -1; i++)
		{
			double min = doubleTestValues[i];
			if(doubleTestValues[i] > doubleTestValues[i+1]) {
				min = doubleTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, StrictMath.min(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, StrictMath.min(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, StrictMath.min(" + doubleTestValues[i] + "d," + min + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i] + "d," + min + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, StrictMath.min(" + doubleTestValues[i+1] + "d," + min + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i+1] + "d," + min + "d));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length -1; i++)
		{
			float min = floatTestValues[i];
			if(floatTestValues[i] > floatTestValues[i+1]) {
				min = floatTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, StrictMath.min(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, StrictMath.min(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, StrictMath.min(" + floatTestValues[i] + "f," + min + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i] + "f," + min + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, StrictMath.min(" + floatTestValues[i+1] + "f," + min + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i+1] + "f," + min + "f));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_long()");
		System.out.println("{");
		for (int i = 0; i < longTestValues.length -1; i++)
		{
			long min = longTestValues[i];
			if(longTestValues[i] > longTestValues[i+1]) {
				min = longTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, StrictMath.min(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, StrictMath.min(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, StrictMath.min(" + longTestValues[i] + "l," + min + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i] + "l," + min + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, StrictMath.min(" + longTestValues[i+1] + "l," + min + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i+1] + "l," + min + "l));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_int()");
		System.out.println("{");
		for (int i = 0; i < intTestValues.length -1; i++)
		{
			int min = intTestValues[i];
			if(intTestValues[i] > intTestValues[i+1]) {
				min = intTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", StrictMath.min(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", StrictMath.min(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", StrictMath.min(" + intTestValues[i] + "," + min + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i] + "," + min + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", StrictMath.min(" + intTestValues[i+1] + "," + min + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i+1] + "," + min + "));");
		}
		System.out.println("}");
		System.out.println();
		// **************************************************************************************
		
		// nextAfter - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextAfter_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+0.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",+0.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],+0.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+0.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+0.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],+0.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],+0.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",+0.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],+0.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",+0.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+0.0001D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",+0.0001D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],+0.0001D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+0.0001D) + ", Math.nextAfter("+doubleTestStrings[i]+",+0.0001D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],+0.0001D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],+0.0001D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",+0.0001D) && " + (StrictMath.nextAfter(doubleTestValues[i],+0.0001D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",+0.0001D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+1.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",+1.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],+1.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+1.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+1.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],+1.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],+1.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",+1.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],+1.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",+1.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+10.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",+10.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],+10.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+10.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+10.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],+10.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],+10.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",+10.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],+10.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",+10.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+3327.191D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",+3327.191D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],+3327.191D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],+3327.191D) + ", Math.nextAfter("+doubleTestStrings[i]+",+3327.191D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],+3327.191D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],+3327.191D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",+3327.191D) && " + (StrictMath.nextAfter(doubleTestValues[i],+3327.191D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",+3327.191D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-0.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",-0.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],-0.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-0.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-0.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],-0.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],-0.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",-0.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],-0.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",-0.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-0.0001D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",-0.0001D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],-0.0001D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-0.0001D) + ", Math.nextAfter("+doubleTestStrings[i]+",-0.0001D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],-0.0001D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],-0.0001D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",-0.0001D) && " + (StrictMath.nextAfter(doubleTestValues[i],-0.0001D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",-0.0001D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-1.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",-1.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],-1.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-1.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-1.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],-1.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],-1.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",-1.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],-1.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",-1.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-10.0D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",-10.0D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],-10.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-10.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-10.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],-10.0D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],-10.0D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",-10.0D) && " + (StrictMath.nextAfter(doubleTestValues[i],-10.0D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",-10.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-3327.191D) + ", StrictMath.nextAfter("+doubleTestStrings[i]+",-3327.191D));");
			if ( Double.isInfinite(StrictMath.nextAfter(doubleTestValues[i],-3327.191D)) ) {
				System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + StrictMath.nextAfter(doubleTestValues[i],-3327.191D) + ", Math.nextAfter("+doubleTestStrings[i]+",-3327.191D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(doubleTestValues[i],-3327.191D));
				System.out.println("assertTrue(\"nextAfter(double,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(doubleTestValues[i],-3327.191D) - dTolerance) + " <= Math.nextAfter("+doubleTestStrings[i]+",-3327.191D) && " + (StrictMath.nextAfter(doubleTestValues[i],-3327.191D) + dTolerance) + " >= Math.nextAfter("+doubleTestStrings[i]+",-3327.191D));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextAfter - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextAfter_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+0.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",+0.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],+0.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+0.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+0.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],+0.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],+0.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",+0.0D) && " + (StrictMath.nextAfter(floatTestValues[i],+0.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",+0.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+0.0001D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",+0.0001D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],+0.0001D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+0.0001D) + ", Math.nextAfter("+floatTestStrings[i]+",+0.0001D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],+0.0001D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],+0.0001D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",+0.0001D) && " + (StrictMath.nextAfter(floatTestValues[i],+0.0001D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",+0.0001D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+1.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",+1.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],+1.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+1.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+1.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],+1.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],+1.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",+1.0D) && " + (StrictMath.nextAfter(floatTestValues[i],+1.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",+1.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+10.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",+10.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],+10.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+10.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+10.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],+10.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],+10.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",+10.0D) && " + (StrictMath.nextAfter(floatTestValues[i],+10.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",+10.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+3327.191D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",+3327.191D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],+3327.191D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],+3327.191D) + ", Math.nextAfter("+floatTestStrings[i]+",+3327.191D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],+3327.191D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],+3327.191D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",+3327.191D) && " + (StrictMath.nextAfter(floatTestValues[i],+3327.191D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",+3327.191D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-0.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",-0.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],-0.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-0.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-0.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],-0.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],-0.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",-0.0D) && " + (StrictMath.nextAfter(floatTestValues[i],-0.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",-0.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-0.0001D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",-0.0001D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],-0.0001D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-0.0001D) + ", Math.nextAfter("+floatTestStrings[i]+",-0.0001D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],-0.0001D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],-0.0001D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",-0.0001D) && " + (StrictMath.nextAfter(floatTestValues[i],-0.0001D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",-0.0001D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-1.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",-1.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],-1.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-1.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-1.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],-1.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],-1.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",-1.0D) && " + (StrictMath.nextAfter(floatTestValues[i],-1.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",-1.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-10.0D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",-10.0D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],-10.0D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-10.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-10.0D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],-10.0D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],-10.0D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",-10.0D) && " + (StrictMath.nextAfter(floatTestValues[i],-10.0D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",-10.0D));");
			}

			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-3327.191D) + ", StrictMath.nextAfter("+floatTestStrings[i]+",-3327.191D));");
			if ( Float.isInfinite(StrictMath.nextAfter(floatTestValues[i],-3327.191D)) ) {
				System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + StrictMath.nextAfter(floatTestValues[i],-3327.191D) + ", Math.nextAfter("+floatTestStrings[i]+",-3327.191D));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextAfter(floatTestValues[i],-3327.191D));
				System.out.println("assertTrue(\"nextAfter(float,double)["+testCount+++"] ::\", " + (StrictMath.nextAfter(floatTestValues[i],-3327.191D) - dTolerance) + " <= Math.nextAfter("+floatTestStrings[i]+",-3327.191D) && " + (StrictMath.nextAfter(floatTestValues[i],-3327.191D) + dTolerance) + " >= Math.nextAfter("+floatTestStrings[i]+",-3327.191D));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextUp - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextUp_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"nextUp(double)["+testCount+++"] ::\", (double)" + StrictMath.nextUp(doubleTestValues[i]) + ", StrictMath.nextUp("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.nextUp(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"nextUp(double)["+testCount+++"] ::\", (double)" + StrictMath.nextUp(doubleTestValues[i]) + ", Math.nextUp("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextUp(doubleTestValues[i]));
				System.out.println("assertTrue(\"nextUp(double)["+testCount+++"] ::\", " + (StrictMath.nextUp(doubleTestValues[i]) - dTolerance) + " <= Math.nextUp("+doubleTestStrings[i]+") && " + (StrictMath.nextUp(doubleTestValues[i]) + dTolerance) + " >= Math.nextUp("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextUp - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextUp_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"nextUp(float)["+testCount+++"] ::\", (float)" + StrictMath.nextUp(floatTestValues[i]) + ", StrictMath.nextUp("+floatTestStrings[i]+"));");
			if ( Float.isInfinite(StrictMath.nextUp(floatTestValues[i])) ) {
				System.out.println("assertEquals(\"nextUp(float)["+testCount+++"] ::\", (float)" + StrictMath.nextUp(floatTestValues[i]) + ", Math.nextUp("+floatTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.nextUp(floatTestValues[i]));
				System.out.println("assertTrue(\"nextUp(float)["+testCount+++"] ::\", " + (StrictMath.nextUp(floatTestValues[i]) - dTolerance) + " <= Math.nextUp("+floatTestStrings[i]+") && " + (StrictMath.nextUp(floatTestValues[i]) + dTolerance) + " >= Math.nextUp("+floatTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// scalb - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testScalb_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],0) + ", StrictMath.scalb("+doubleTestStrings[i]+",0));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],0)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],0) + ", Math.scalb("+doubleTestStrings[i]+",0));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],0));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],0) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",0) && " + (StrictMath.scalb(doubleTestValues[i],0) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",0));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],1) + ", StrictMath.scalb("+doubleTestStrings[i]+",1));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],1)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],1) + ", Math.scalb("+doubleTestStrings[i]+",1));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],1));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],1) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",1) && " + (StrictMath.scalb(doubleTestValues[i],1) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",1));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],2) + ", StrictMath.scalb("+doubleTestStrings[i]+",2));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],2)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],2) + ", Math.scalb("+doubleTestStrings[i]+",2));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],2));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],2) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",2) && " + (StrictMath.scalb(doubleTestValues[i],2) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",2));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],5) + ", StrictMath.scalb("+doubleTestStrings[i]+",5));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],5)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],5) + ", Math.scalb("+doubleTestStrings[i]+",5));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],5));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],5) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",5) && " + (StrictMath.scalb(doubleTestValues[i],5) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",5));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],2012) + ", StrictMath.scalb("+doubleTestStrings[i]+",2012));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],2012)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],2012) + ", Math.scalb("+doubleTestStrings[i]+",2012));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],2012));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],2012) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",2012) && " + (StrictMath.scalb(doubleTestValues[i],2012) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",2012));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-21287) + ", StrictMath.scalb("+doubleTestStrings[i]+",-21287));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],-21287)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-21287) + ", Math.scalb("+doubleTestStrings[i]+",-21287));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],-21287));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],-21287) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",-21287) && " + (StrictMath.scalb(doubleTestValues[i],-21287) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",-21287));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-1) + ", StrictMath.scalb("+doubleTestStrings[i]+",-1));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],-1)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-1) + ", Math.scalb("+doubleTestStrings[i]+",-1));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],-1));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],-1) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",-1) && " + (StrictMath.scalb(doubleTestValues[i],-1) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",-1));");
			}

			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-0) + ", StrictMath.scalb("+doubleTestStrings[i]+",-0));");
			if ( Double.isInfinite(StrictMath.scalb(doubleTestValues[i],-0)) ) {
				System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + StrictMath.scalb(doubleTestValues[i],-0) + ", Math.scalb("+doubleTestStrings[i]+",-0));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.scalb(doubleTestValues[i],-0));
				System.out.println("assertTrue(\"scaleb(double,int)["+testCount+++"] ::\", " + (StrictMath.scalb(doubleTestValues[i],-0) - dTolerance) + " <= Math.scalb("+doubleTestStrings[i]+",-0) && " + (StrictMath.scalb(doubleTestValues[i],-0) + dTolerance) + " >= Math.scalb("+doubleTestStrings[i]+",-0));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// scalb - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testScalb_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],0) + ", StrictMath.scalb("+floatTestStrings[i]+",0));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],0)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],0) + ", Math.scalb("+floatTestStrings[i]+",0));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],0));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],0) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",0) && " + (StrictMath.scalb(floatTestValues[i],0) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",0));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],1) + ", StrictMath.scalb("+floatTestStrings[i]+",1));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],1)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],1) + ", Math.scalb("+floatTestStrings[i]+",1));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],1));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],1) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",1) && " + (StrictMath.scalb(floatTestValues[i],1) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",1));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],2) + ", StrictMath.scalb("+floatTestStrings[i]+",2));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],2)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],2) + ", Math.scalb("+floatTestStrings[i]+",2));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],2));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],2) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",2) && " + (StrictMath.scalb(floatTestValues[i],2) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",2));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],5) + ", StrictMath.scalb("+floatTestStrings[i]+",5));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],5)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],5) + ", Math.scalb("+floatTestStrings[i]+",5));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],5));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],5) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",5) && " + (StrictMath.scalb(floatTestValues[i],5) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",5));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],2012) + ", StrictMath.scalb("+floatTestStrings[i]+",2012));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],2012)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],2012) + ", Math.scalb("+floatTestStrings[i]+",2012));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],2012));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],2012) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",2012) && " + (StrictMath.scalb(floatTestValues[i],2012) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",2012));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-21287) + ", StrictMath.scalb("+floatTestStrings[i]+",-21287));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],-21287)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-21287) + ", Math.scalb("+floatTestStrings[i]+",-21287));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],-21287));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],-21287) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",-21287) && " + (StrictMath.scalb(floatTestValues[i],-21287) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",-21287));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-1) + ", StrictMath.scalb("+floatTestStrings[i]+",-1));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],-1)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-1) + ", Math.scalb("+floatTestStrings[i]+",-1));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],-1));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],-1) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",-1) && " + (StrictMath.scalb(floatTestValues[i],-1) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",-1));");
			}

			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-0) + ", StrictMath.scalb("+floatTestStrings[i]+",-0));");
			if ( Float.isInfinite(StrictMath.scalb(floatTestValues[i],-0)) ) {
				System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + StrictMath.scalb(floatTestValues[i],-0) + ", Math.scalb("+floatTestStrings[i]+",-0));");
			}
			else {
				fTolerance = StrictMath.ulp(StrictMath.scalb(floatTestValues[i],-0));
				System.out.println("assertTrue(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + (StrictMath.scalb(floatTestValues[i],-0) - fTolerance) + " <= Math.scalb("+floatTestStrings[i]+",-0) && " + (StrictMath.scalb(floatTestValues[i],-0) + fTolerance) + " >= Math.scalb("+floatTestStrings[i]+",-0));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// pow - double,double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testPow()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 0.0D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", 0.0D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+0.0D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 0.0D) + ", Math.pow(" + doubleTestStrings[i] + ", 0.0D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+0.0D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],0.0D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",0.0D) && " + (StrictMath.pow(doubleTestValues[i],0.0D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",0.0D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 1.0D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", 1.0D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+1.0D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 1.0D) + ", Math.pow(" + doubleTestStrings[i] + ", 1.0D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+1.0D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],1.0D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",1.0D) && " + (StrictMath.pow(doubleTestValues[i],1.0D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",1.0D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 336.982D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", 336.982D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+336.982D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], 336.982D) + ", Math.pow(" + doubleTestStrings[i] + ", 336.982D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+336.982D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],336.982D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",336.982D) && " + (StrictMath.pow(doubleTestValues[i],336.982D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",336.982D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -1.0D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", -1.0D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+-1.0D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -1.0D) + ", Math.pow(" + doubleTestStrings[i] + ", -1.0D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+-1.0D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],-1.0D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",-1.0D) && " + (StrictMath.pow(doubleTestValues[i],-1.0D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",-1.0D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -0.0001D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", -0.0001D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+-0.0001D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -0.0001D) + ", Math.pow(" + doubleTestStrings[i] + ", -0.0001D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+-0.0001D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],-0.0001D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",-0.0001D) && " + (StrictMath.pow(doubleTestValues[i],-0.0001D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",-0.0001D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -336.982D) + ", StrictMath.pow(" + doubleTestStrings[i] + ", -336.982D));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+-336.982D)) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], -336.982D) + ", Math.pow(" + doubleTestStrings[i] + ", -336.982D));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+-336.982D));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],-336.982D) - dTolerance) + " <= Math.pow("+doubleTestStrings[i]+",-336.982D) && " + (StrictMath.pow(doubleTestValues[i],-336.982D) + dTolerance) + " >= Math.pow("+doubleTestStrings[i]+",-336.982D));");
				}

				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], doubleTestValues[i]) + ", StrictMath.pow(" + doubleTestStrings[i] + "," + doubleTestValues[i] + "));");
				if ( Double.isInfinite(StrictMath.pow(doubleTestValues[i],+doubleTestValues[i])) ) {
					System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + StrictMath.pow(doubleTestValues[i], doubleTestValues[i]) + ", Math.pow(" + doubleTestStrings[i] + "," + doubleTestValues[i] + "));");
				}
				else {
					dTolerance = StrictMath.ulp(StrictMath.pow(doubleTestValues[i],+doubleTestValues[i]));
					System.out.println("assertTrue(\"pow(double)["+testCount+++"] ::\", " + (StrictMath.pow(doubleTestValues[i],doubleTestValues[i]) - dTolerance) + " <= Math.pow(" + doubleTestStrings[i] + "," + doubleTestStrings[i] + ") && " + (StrictMath.pow(doubleTestValues[i],doubleTestValues[i]) + dTolerance) + " >= Math.pow(" + doubleTestStrings[i] + "," + doubleTestStrings[i] + "));");
				}
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// rint - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testRint()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"rint(double)["+testCount+++"] ::\", " + StrictMath.rint(doubleTestValues[i]) + ", StrictMath.rint("+doubleTestStrings[i]+"));");
			dTolerance = StrictMath.ulp(StrictMath.rint(doubleTestValues[i]));
			System.out.println("assertTrue(\"rint(double)["+testCount+++"] ::\", " + (StrictMath.rint(doubleTestValues[i]) - dTolerance) + " <= Math.rint("+doubleTestStrings[i]+") && " + (StrictMath.rint(doubleTestValues[i]) + dTolerance) + " >= Math.rint("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// round - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testRound_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"round(double)["+testCount+++"] ::\", " + StrictMath.round(doubleTestValues[i]) + "L, StrictMath.round("+doubleTestStrings[i]+"));");
			System.out.println("assertEquals(\"round(double)["+testCount+++"] ::\", " + StrictMath.round(doubleTestValues[i]) + "L, Math.round("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// round - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testRound_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"round(float)["+testCount+++"] ::\", " + StrictMath.round(floatTestValues[i]) + "L, StrictMath.round("+floatTestStrings[i]+"));");
			System.out.println("assertEquals(\"round(float)["+testCount+++"] ::\", " + StrictMath.round(floatTestValues[i]) + "L, Math.round("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// signum - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSignum_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"signum(double)["+testCount+++"] ::\", (double)" + StrictMath.signum(doubleTestValues[i]) + ", StrictMath.signum("+doubleTestStrings[i]+"));");
			dTolerance = StrictMath.ulp(StrictMath.signum(doubleTestValues[i]));
			System.out.println("assertTrue(\"signum(double)["+testCount+++"] ::\", " + (StrictMath.signum(doubleTestValues[i]) - dTolerance) + " <= Math.signum("+doubleTestStrings[i]+") && " + (StrictMath.signum(doubleTestValues[i]) + dTolerance) + " >= Math.signum("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// signum - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSignum_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"signum(float)["+testCount+++"] ::\", (float)" + StrictMath.signum(floatTestValues[i]) + ", StrictMath.signum("+floatTestStrings[i]+"));");
			dTolerance = StrictMath.ulp(StrictMath.signum(floatTestValues[i]));
			System.out.println("assertTrue(\"signum(float)["+testCount+++"] ::\", (float)" + (StrictMath.signum(floatTestValues[i]) - dTolerance) + " <= Math.signum("+floatTestStrings[i]+") && (float) " + (StrictMath.signum(floatTestValues[i]) + dTolerance) + " >= Math.signum("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sin - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSin()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"sin(double)["+testCount+++"] ::\", " + StrictMath.sin(doubleTestValues[i]) + ", StrictMath.sin("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.sin(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"sin(double)["+testCount+++"] ::\", " + StrictMath.sin(doubleTestValues[i]) + ", Math.sin("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.sin(doubleTestValues[i]));
				System.out.println("assertTrue(\"sin(double)["+testCount+++"] ::\", " + (StrictMath.sin(doubleTestValues[i]) - dTolerance) + " <= Math.sin("+doubleTestStrings[i]+") && " + (StrictMath.sin(doubleTestValues[i]) + dTolerance) + " >= Math.sin("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sinh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSinh()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"sinh(double)["+testCount+++"] ::\", " + StrictMath.sinh(doubleTestValues[i]) + ", StrictMath.sinh("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.sinh(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"sinh(double)["+testCount+++"] ::\", " + StrictMath.sinh(doubleTestValues[i]) + ", Math.sinh("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.sinh(doubleTestValues[i]));
				System.out.println("assertTrue(\"sinh(double)["+testCount+++"] ::\", " + (StrictMath.sinh(doubleTestValues[i]) - dTolerance) + " <= Math.sinh("+doubleTestStrings[i]+") && " + (StrictMath.sinh(doubleTestValues[i]) + dTolerance) + " >= Math.sinh("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sqrt - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSqrt()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			if(doubleTestValues[i] >= 0)
			{
				System.out.println("assertEquals(\"sqrt(double)["+testCount+++"] ::\", " + StrictMath.sqrt(doubleTestValues[i]) + ", StrictMath.sqrt("+doubleTestStrings[i]+"));");
				dTolerance = StrictMath.ulp(StrictMath.sqrt(doubleTestValues[i]));
				System.out.println("assertTrue(\"sqrt(double)["+testCount+++"] ::\", " + (StrictMath.sqrt(doubleTestValues[i]) - dTolerance) + " <= Math.sqrt("+doubleTestStrings[i]+") && " + (StrictMath.sqrt(doubleTestValues[i]) + dTolerance) + " >= Math.sqrt("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// tan - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testTan()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"tan(double)["+testCount+++"] ::\", " + StrictMath.tan(doubleTestValues[i]) + ", StrictMath.tan("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.tan(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"tan(double)["+testCount+++"] ::\", " + StrictMath.tan(doubleTestValues[i]) + ", Math.tan("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.tan(doubleTestValues[i]));
				System.out.println("assertTrue(\"tan(double)["+testCount+++"] ::\", " + (StrictMath.tan(doubleTestValues[i]) - dTolerance) + " <= Math.tan("+doubleTestStrings[i]+") && " + (StrictMath.tan(doubleTestValues[i]) + dTolerance) + " >= Math.tan("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// tanh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testTanh()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"tanh(double)["+testCount+++"] ::\", " + StrictMath.tanh(doubleTestValues[i]) + ", StrictMath.tanh("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.tanh(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"tanh(double)["+testCount+++"] ::\", " + StrictMath.tanh(doubleTestValues[i]) + ", Math.tanh("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.tanh(doubleTestValues[i]));
				System.out.println("assertTrue(\"tanh(double)["+testCount+++"] ::\", " + (StrictMath.tanh(doubleTestValues[i]) - dTolerance) + " <= Math.tanh("+doubleTestStrings[i]+") && " + (StrictMath.tanh(doubleTestValues[i]) + dTolerance) + " >= Math.tanh("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// toDegrees - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testToDegrees()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"toDegrees(double)["+testCount+++"] ::\", (double)" + StrictMath.toDegrees(doubleTestValues[i]) + ", StrictMath.toDegrees("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.toDegrees(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"toDegrees(double)["+testCount+++"] ::\", (double)" + StrictMath.toDegrees(doubleTestValues[i]) + ", Math.toDegrees("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.toDegrees(doubleTestValues[i]));
				System.out.println("assertTrue(\"toDegrees(double)["+testCount+++"] ::\", (double)" + (StrictMath.toDegrees(doubleTestValues[i]) - dTolerance) + " <= Math.toDegrees("+doubleTestStrings[i]+") &&  (double)" + (StrictMath.toDegrees(doubleTestValues[i]) + dTolerance) + " >= Math.toDegrees("+doubleTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();		
		// ******************************************************************************************
		// toRadians - double
		// Allow for a 2 ulp precision for both StrictMath and Math - ""
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#toRadians-double-
		// ******************************************************************************************
		testCount = 0;
		System.out.println("public void testToRadians()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			// The precision of some StrictMath toRadians operations changed between jdk8 and jdk9.  To handle that this generator applies
			// a 2 ulp tolerance to both StrictMath and Math if the tests are being generated using a jdk < jdk9 and run on jdk9 or later
			// or vice versa, otherwise apply the usual exact match for StrictMath and 1 ulp tolerance for Math.
			int test1Count = 2 * i;
			int test2Count = test1Count + 1;
			System.out.println("if ( generatorJdkRange.equals(runtimeJdkRange) ) {");
			System.out.println("assertEquals(\"toRadians(double)["+ test1Count +"] ::\", (double)" + StrictMath.toRadians(doubleTestValues[i]) + ", StrictMath.toRadians("+doubleTestStrings[i]+"));");
			if ( Double.isInfinite(StrictMath.toRadians(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"toRadians(double)["+ test2Count +"] ::\", (double)" + StrictMath.toRadians(doubleTestValues[i]) + ", Math.toRadians("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.toRadians(doubleTestValues[i]));
				System.out.println("assertTrue(\"toRadians(double)["+ test2Count +"] ::\", (double)" + (StrictMath.toRadians(doubleTestValues[i]) - dTolerance) + " <= Math.toRadians("+doubleTestStrings[i]+") &&  (double)" + (StrictMath.toRadians(doubleTestValues[i]) + dTolerance) + " >= Math.toRadians("+doubleTestStrings[i]+"));");
			}
			System.out.println("}");
			System.out.println("else {");
			if ( Double.isInfinite(StrictMath.toRadians(doubleTestValues[i])) ) {
				System.out.println("assertEquals(\"toRadians(double)["+ test1Count +"] ::\", (double)" + StrictMath.toRadians(doubleTestValues[i]) + ", StrictMath.toRadians("+doubleTestStrings[i]+"));");
				System.out.println("assertEquals(\"toRadians(double)["+ test2Count +"] ::\", (double)" + StrictMath.toRadians(doubleTestValues[i]) + ", Math.toRadians("+doubleTestStrings[i]+"));");
			}
			else {
				dTolerance = StrictMath.ulp(StrictMath.toRadians(doubleTestValues[i])) * 2.0D;
				System.out.println("assertTrue(\"toRadians(double)["+ test1Count +"] ::\", (double)" + (StrictMath.toRadians(doubleTestValues[i]) - dTolerance) + " <= StrictMath.toRadians("+doubleTestStrings[i]+") &&  (double)" + (StrictMath.toRadians(doubleTestValues[i]) + dTolerance) + " >= StrictMath.toRadians("+doubleTestStrings[i]+"));");
				System.out.println("assertTrue(\"toRadians(double)["+ test2Count +"] ::\", (double)" + (StrictMath.toRadians(doubleTestValues[i]) - dTolerance) + " <= Math.toRadians("+doubleTestStrings[i]+") &&  (double)" + (StrictMath.toRadians(doubleTestValues[i]) + dTolerance) + " >= Math.toRadians("+doubleTestStrings[i]+"));");
			}
			System.out.println("}");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ulp - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testUlp_double()");
		System.out.println("{");
		for (int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"ulp(double)["+testCount+++"] ::\", (double)" + StrictMath.ulp(doubleTestValues[i]) + ", StrictMath.ulp("+doubleTestStrings[i]+"));");
			System.out.println("assertEquals(\"ulp(double)["+testCount+++"] ::\", (double)" + StrictMath.ulp(doubleTestValues[i]) + ", Math.ulp("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ulp - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testUlp_float()");
		System.out.println("{");
		for (int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"ulp(float)["+testCount+++"] ::\", (float)" + StrictMath.ulp(floatTestValues[i]) + ", StrictMath.ulp("+floatTestStrings[i]+"));");
			System.out.println("assertEquals(\"ulp(float)["+testCount+++"] ::\", (float)" + StrictMath.ulp(floatTestValues[i]) + ", Math.ulp("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		System.out.println("}");
	}	
}