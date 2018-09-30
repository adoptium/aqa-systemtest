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
 * This class generates JUnit checked assertions to cover the API functions defined in the java.lang.Math class. The output from this class is a JUnit
 * class which can be executed to verify that the values returned from the API function calls match across different Java implementations e.g. if TestGenerator
 * is run against an Oracle JDK, the output produced saved and compiled, the resulting class can be run against the JDK under test to verify that the results of 
 * the function calls when called from the JDK under test match the Oracle reference implementation.
 *  
 * The tests are generated from the data arrays at the top of the class. Each value in the array is passed into each of the function calls and a checked
 * assertion is produced using the format below :
 * 
 * 		assertEquals("<testcase name ::", <result of function call on reference implementation>, <string representing equivalent function call to be run on test JDK>);
 * 
 * e.g. for the function Math.acos(double) :
 * 
 * 		assertEquals("acos(long)["+testCount+++"] ::\", " + 	Math.acos(longTestValues[i]) + ", 	Math.acos("+longTestStrings[i]+"));");
 * 
 *   which becomes
 *   
 *   	assertEquals("acos(long)[13] ::", 						3.141592653589793, 					Math.acos(-1L));
 *  
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
	
	public static void main(String[] args)
	{
		MathAPITestGenerator ag = new MathAPITestGenerator();
		ag.generate();
	}
	
	private void generate()
	{
		int testCount;
		
		String javaVersion = System.getProperty("java.version");
		
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
		System.out.println("* A simple collection of JUnit assertions covering the java.lang.Math API. Automatically generated using TestGenerator.java");
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
		// **************************************************************************************
		
		// abs - double, float, long, int
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testAbs_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{
			double multiplier = 1;
			if(doubleTestValues[i] < 0)
			{
				multiplier = -1;
			}

			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d, Math.abs(" + doubleTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, Math.abs(" + doubleTestStrings[i] + " * 2d));");
			System.out.println("assertEquals(\"abs(double)[" + testCount++ + "] ::\", " + doubleTestStrings[i] + "*" + multiplier + "d * 2d, Math.abs(" + doubleTestStrings[i] + " * -2d));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{
			float multiplier = 1;
			if(floatTestValues[i] < 0)
			{
				multiplier = -1;
			}

			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f, Math.abs(" + floatTestStrings[i] + "));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, Math.abs(" + floatTestStrings[i] + " * 2f));");
			System.out.println("assertEquals(\"abs(float)[" + testCount++ + "] ::\", " + floatTestStrings[i] + "*" + multiplier + "f * 2f, Math.abs(" + floatTestStrings[i] + " * -2f));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_long()");
		System.out.println("{");
	
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE, Math.abs(Long.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1, Math.abs(Long.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * -1 * -2, Math.abs((Long.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(long)[" + testCount++ + "] ::\", (Long.MIN_VALUE + 1) * 2, Math.abs((Long.MIN_VALUE + 1) * -2));");

		for(int i = 0; i < longTestValues.length; i++)
		{
			if(!longTestStrings[i].contains("MIN_VALUE"))
			{
				int multiplier = 1;
				if(longTestValues[i] < 0)
				{
					multiplier = -1;
				}

				System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", " + longTestStrings[i] + "*" + multiplier + ", Math.abs(" + longTestStrings[i] + "));");
			}
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testAbs_integer()");
		System.out.println("{");
		
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * -2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1, Math.abs(Integer.MIN_VALUE + 1));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * -1 * -2, Math.abs((Integer.MIN_VALUE + 1) * 2));");
		System.out.println("assertEquals(\"abs(int)[" + testCount++ + "] ::\", (Integer.MIN_VALUE + 1) * 2, Math.abs((Integer.MIN_VALUE + 1) * -2));");

		for(int i = 0; i < intTestValues.length; i++)
		{
			if(!intTestStrings[i].contains("MIN_VALUE"))
			{
				int multiplier = 1;
				if(intTestValues[i] < 0)
				{
					multiplier = -1;
				}

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
		for(int i = 0; i < doubleTestValues.length; i++)
		{
			if(Math.abs(doubleTestValues[i]) <= 1 && Math.abs(doubleTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(double)["+testCount+++"] ::\", " + Math.acos(doubleTestValues[i]) + ", Math.acos("+doubleTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < floatTestValues.length; i++)
		{
			if(Math.abs(floatTestValues[i]) <= 1 && Math.abs(floatTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(float)["+testCount+++"] ::\", " + Math.acos(floatTestValues[i]) + ", Math.acos("+floatTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < longTestValues.length; i++)
		{
			if(Math.abs(longTestValues[i]) <= 1 && Math.abs(longTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(long)["+testCount+++"] ::\", " + Math.acos(longTestValues[i]) + ", Math.acos("+longTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < intTestValues.length; i++)
		{
			if(Math.abs(intTestValues[i]) <= 1 && Math.abs(intTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"acos(int)["+testCount+++"] ::\", " + Math.acos(intTestValues[i]) + ", Math.acos("+intTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();
		
		System.out.println("public void testAsin()");
		System.out.println("{");
		testCount = 0;
		for(int i = 0; i < doubleTestValues.length; i++)
		{
			if(Math.abs(doubleTestValues[i]) <= 1 && Math.abs(doubleTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(double)["+testCount+++"] ::\", " + Math.asin(doubleTestValues[i]) + ", Math.asin("+doubleTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < floatTestValues.length; i++)
		{
			if(Math.abs(floatTestValues[i]) <= 1 && Math.abs(floatTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(float)["+testCount+++"] ::\", " + Math.asin(floatTestValues[i]) + ", Math.asin("+floatTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < longTestValues.length; i++)
		{
			if(Math.abs(longTestValues[i]) <= 1 && Math.abs(longTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(long)["+testCount+++"] ::\", " + Math.asin(longTestValues[i]) + ", Math.asin("+longTestStrings[i]+"));");
			}
		}
		for(int i = 0; i < intTestValues.length; i++)
		{
			if(Math.abs(intTestValues[i]) <= 1 && Math.abs(intTestValues[i]) >= 0)
			{
				System.out.println("assertEquals(\"asin(int)["+testCount+++"] ::\", " + Math.asin(intTestValues[i]) + ", Math.asin("+intTestStrings[i]+"));");
			}
		}
		System.out.println("}");
		System.out.println();
		
		System.out.println("public void testAtan()");
		System.out.println("{");
		testCount = 0;
		for(int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(double)["+testCount+++"] ::\", " + Math.atan(doubleTestValues[i]) + ", Math.atan("+doubleTestStrings[i]+"));");
		}
		for(int i = 0; i < floatTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(float)["+testCount+++"] ::\", " + Math.atan(floatTestValues[i]) + ", Math.atan("+floatTestStrings[i]+"));");
		}
		for(int i = 0; i < longTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(long)["+testCount+++"] ::\", " + Math.atan(longTestValues[i]) + ", Math.atan("+longTestStrings[i]+"));");
		}
		for(int i = 0; i < intTestValues.length; i++)
		{
			System.out.println("assertEquals(\"atan(int)["+testCount+++"] ::\", " + Math.atan(intTestValues[i]) + ", Math.atan("+intTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();
		// **************************************************************************************
		
		// atan2 - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testAtan2()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length -1; i++)
		{
			System.out.println("assertEquals(\"atan2(double,double)["+testCount+++"] ::\", " + Math.atan2(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.atan2("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// cbrt - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCbrt()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{
			System.out.println("assertEquals(\"cbrt(double)["+testCount+++"] ::\", " + Math.cbrt(doubleTestValues[i]) + ", Math.cbrt("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ceil - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCeil()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"ceil(double)["+testCount+++"] ::\", " + Math.ceil(doubleTestValues[i]) + ", Math.ceil("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// cos - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCos()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"cos(double)["+testCount+++"] ::\", " + Math.cos(doubleTestValues[i]) + ", Math.cos("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();	
		// **************************************************************************************
		
		// cosh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCosh()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"cosh(double)["+testCount+++"] ::\", " + Math.cosh(doubleTestValues[i]) + ", Math.cosh("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// copySign - double,double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testCopySign_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 0.0D) + ", Math.copySign("+doubleTestStrings[i]+",0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 1.0D) + ", Math.copySign("+doubleTestStrings[i]+",1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], 0.222231D) + ", Math.copySign("+doubleTestStrings[i]+",0.222231D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], -0.0D) + ", Math.copySign("+doubleTestStrings[i]+",-0.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], -1.0D) + ", Math.copySign("+doubleTestStrings[i]+",-1.0D));");
			System.out.println("assertEquals(\"copySign(double,double)["+testCount+++"] ::\", " + Math.copySign(doubleTestValues[i], -0.222231D) + ", Math.copySign("+doubleTestStrings[i]+",-0.222231D));");
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
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 0.0D) + "F, Math.copySign("+floatTestStrings[i]+",0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 1.0D) + "F, Math.copySign("+floatTestStrings[i]+",1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], 0.222231D) + "F, Math.copySign("+floatTestStrings[i]+",0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -0.0D) + "F, Math.copySign("+floatTestStrings[i]+",-0.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -1.0D) + "F, Math.copySign("+floatTestStrings[i]+",-1.0F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], -0.222231D) + "F, Math.copySign("+floatTestStrings[i]+",-0.222231F));");
			System.out.println("assertEquals(\"copySign(float,float)["+testCount+++"] ::\", " + Math.copySign(floatTestValues[i], floatTestValues[i]) + "F, Math.copySign("+floatTestStrings[i]+","+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// exp - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testExp()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"exp(double)["+testCount+++"] ::\", " + Math.exp(doubleTestValues[i]) + ", Math.exp("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// expm1 - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testExpm1()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"expm1(double)["+testCount+++"] ::\", " + Math.expm1(doubleTestValues[i]) + ", Math.expm1("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// floor - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testFloor()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"floor(double)["+testCount+++"] ::\", " + Math.floor(doubleTestValues[i]) + ", Math.floor("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// getExponent - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testGetExponent_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"getExponent(double)["+testCount+++"] ::\", " + Math.getExponent(doubleTestValues[i]) + ", Math.getExponent("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// getExponent - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testGetExponent_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"getExponent(float)["+testCount+++"] ::\", " + Math.getExponent(floatTestValues[i]) + ", Math.getExponent("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// hypot - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testHypot()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length -1; i++)
		{	
			System.out.println("assertEquals(\"hypot(double,double)["+testCount+++"] ::\", " + Math.hypot(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.hypot("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// IEEEremainder - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testIEEEremainder()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length -1; i++)
		{	
			if(doubleTestValues[i+1] != 0) // returns NaN
			{
				System.out.println("assertEquals(\"IEEEremainder(double,double)["+testCount+++"] ::\", " + Math.IEEEremainder(doubleTestValues[i],doubleTestValues[i+1]) + ", Math.IEEEremainder("+doubleTestStrings[i]+"," + doubleTestStrings[i+1] + "));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"log(double)["+testCount+++"] ::\", " + Math.log(doubleTestValues[i]) + ", Math.log("+doubleTestStrings[i]+"));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"log10(double)["+testCount+++"] ::\", " + Math.log10(doubleTestValues[i]) + ", Math.log10("+doubleTestStrings[i]+"));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			if(doubleTestValues[i] > -1)
			{
				System.out.println("assertEquals(\"log1p(double)["+testCount+++"] ::\", " + Math.log1p(doubleTestValues[i]) + ", Math.log1p("+doubleTestStrings[i]+"));");
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
		for(int i = 0; i < doubleTestValues.length -1; i++)
		{	
			double max = doubleTestValues[i];
			if(doubleTestValues[i] < doubleTestValues[i+1])
			{
				max = doubleTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i] + "d," + max + "d));");
			System.out.println("assertEquals(\"max(double)[" + testCount++ + "] ::\", " + max + "d, Math.max(" + doubleTestValues[i+1] + "d," + max + "d));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length -1; i++)
		{	
			float max = floatTestValues[i];
			if(floatTestValues[i] < floatTestValues[i+1])
			{
				max = floatTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i] + "f," + max + "f));");
			System.out.println("assertEquals(\"max(float)[" + testCount++ + "] ::\", " + max + "f, Math.max(" + floatTestValues[i+1] + "f," + max + "f));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_long()");
		System.out.println("{");
		for(int i = 0; i < longTestValues.length -1; i++)
		{	
			long max = longTestValues[i];
			if(longTestValues[i] < longTestValues[i+1])
			{
				max = longTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i] + "l," + max + "l));");
			System.out.println("assertEquals(\"max(long)[" + testCount++ + "] ::\", " + max + "l, Math.max(" + longTestValues[i+1] + "l," + max + "l));");
		}
		System.out.println("}");
		System.out.println();

		testCount = 0;
		System.out.println("public void testMax_int()");
		System.out.println("{");
		for(int i = 0; i < intTestValues.length -1; i++)
		{	
			int max = intTestValues[i];
			if(intTestValues[i] < intTestValues[i+1])
			{
				max = intTestValues[i+1];
			}

			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"max(int)[" + testCount++ + "] ::\", " + max + ", Math.max(" + intTestValues[i] + "," + max + "));");
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
		for(int i = 0; i < doubleTestValues.length -1; i++)
		{	
			double min = doubleTestValues[i];
			if(doubleTestValues[i] > doubleTestValues[i+1])
			{
				min = doubleTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i] + "d," + doubleTestValues[i+1] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i+1] + "d," + doubleTestValues[i] + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i] + "d," + min + "d));");
			System.out.println("assertEquals(\"min(double)[" + testCount++ + "] ::\", " + min + "d, Math.min(" + doubleTestValues[i+1] + "d," + min + "d));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length -1; i++)
		{	
			float min = floatTestValues[i];
			if(floatTestValues[i] > floatTestValues[i+1])
			{
				min = floatTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i] + "f," + floatTestValues[i+1] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i+1] + "f," + floatTestValues[i] + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i] + "f," + min + "f));");
			System.out.println("assertEquals(\"min(float)[" + testCount++ + "] ::\", " + min + "f, Math.min(" + floatTestValues[i+1] + "f," + min + "f));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_long()");
		System.out.println("{");
		for(int i = 0; i < longTestValues.length -1; i++)
		{	
			long min = longTestValues[i];
			if(longTestValues[i] > longTestValues[i+1])
			{
				min = longTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i] + "l," + longTestValues[i+1] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i+1] + "l," + longTestValues[i] + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i] + "l," + min + "l));");
			System.out.println("assertEquals(\"min(long)[" + testCount++ + "] ::\", " + min + "l, Math.min(" + longTestValues[i+1] + "l," + min + "l));");
		}
		System.out.println("}");
		System.out.println();
		
		testCount = 0;
		System.out.println("public void testMin_int()");
		System.out.println("{");
		for(int i = 0; i < intTestValues.length -1; i++)
		{	
			int min = intTestValues[i];
			if(intTestValues[i] > intTestValues[i+1])
			{
				min = intTestValues[i+1];
			}

			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i] + "," + intTestValues[i+1] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i+1] + "," + intTestValues[i] + "));");
			System.out.println("assertEquals(\"min(int)[" + testCount++ + "] ::\", " + min + ", Math.min(" + intTestValues[i] + "," + min + "));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],+0.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+0.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],+0.0001D) + ", Math.nextAfter("+doubleTestStrings[i]+",+0.0001D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],+1.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+1.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],+10.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",+10.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],+3327.191D) + ", Math.nextAfter("+doubleTestStrings[i]+",+3327.191D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],-0.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-0.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],-0.0001D) + ", Math.nextAfter("+doubleTestStrings[i]+",-0.0001D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],-1.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-1.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],-10.0D) + ", Math.nextAfter("+doubleTestStrings[i]+",-10.0D));");
			System.out.println("assertEquals(\"nextAfter(double,double)["+testCount+++"] ::\", (double)" + Math.nextAfter(doubleTestValues[i],-3327.191D) + ", Math.nextAfter("+doubleTestStrings[i]+",-3327.191D));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextUp - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextAfter_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],+0.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+0.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],+0.001D) + ", Math.nextAfter("+floatTestStrings[i]+",+0.001D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],+1.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+1.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],+10.0D) + ", Math.nextAfter("+floatTestStrings[i]+",+10.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],+3327.191D) + ", Math.nextAfter("+floatTestStrings[i]+",+3327.191D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],-0.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-0.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],-0.001D) + ", Math.nextAfter("+floatTestStrings[i]+",-0.001D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],-1.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-1.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],-10.0D) + ", Math.nextAfter("+floatTestStrings[i]+",-10.0D));");
			System.out.println("assertEquals(\"nextAfter(float,double)["+testCount+++"] ::\", (float)" + Math.nextAfter(floatTestValues[i],-3327.191D) + ", Math.nextAfter("+floatTestStrings[i]+",-3327.191D));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextUp - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextUp_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"nextUp(double)["+testCount+++"] ::\", (double)" + Math.nextUp(doubleTestValues[i]) + ", Math.nextUp("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// nextUp - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testNextUp_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"nextUp(float)["+testCount+++"] ::\", (float)" + Math.nextUp(floatTestValues[i]) + ", Math.nextUp("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// scalb - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testScalb_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],0) + ", Math.scalb("+doubleTestStrings[i]+",0));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],1) + ", Math.scalb("+doubleTestStrings[i]+",1));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],2) + ", Math.scalb("+doubleTestStrings[i]+",2));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],5) + ", Math.scalb("+doubleTestStrings[i]+",5));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],2012) + ", Math.scalb("+doubleTestStrings[i]+",2012));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],-21287) + ", Math.scalb("+doubleTestStrings[i]+",-21287));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],-1) + ", Math.scalb("+doubleTestStrings[i]+",-1));");
			System.out.println("assertEquals(\"scaleb(double,int)["+testCount+++"] ::\", " + Math.scalb(doubleTestValues[i],-0) + ", Math.scalb("+doubleTestStrings[i]+",-0));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// scalb - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testScalb_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],0) + ", Math.scalb("+floatTestStrings[i]+",0));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],1) + ", Math.scalb("+floatTestStrings[i]+",1));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],2) + ", Math.scalb("+floatTestStrings[i]+",2));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],5) + ", Math.scalb("+floatTestStrings[i]+",5));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],2012) + ", Math.scalb("+floatTestStrings[i]+",2012));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],-21287) + ", Math.scalb("+floatTestStrings[i]+",-21287));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],-1) + ", Math.scalb("+floatTestStrings[i]+",-1));");
			System.out.println("assertEquals(\"scaleb(float,int)["+testCount+++"] ::\", (float)" + Math.scalb(floatTestValues[i],-0) + ", Math.scalb("+floatTestStrings[i]+",-0));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// pow - double,double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testPow()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			if(doubleTestValues[i] > 0)
			{
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], 0.0D) + ", Math.pow(" + doubleTestStrings[i] + ", 0.0D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], 1.0D) + ", Math.pow(" + doubleTestStrings[i] + ", 1.0D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], 336.982D) + ", Math.pow(" + doubleTestStrings[i] + ", 336.982D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], -1.0D) + ", Math.pow(" + doubleTestStrings[i] + ", -1.0D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], -0.0001D) + ", Math.pow(" + doubleTestStrings[i] + ", -0.0001D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], -336.982D) + ", Math.pow(" + doubleTestStrings[i] + ", -336.982D));");
				System.out.println("assertEquals(\"pow(double)["+testCount+++"] ::\", " + Math.pow(doubleTestValues[i], doubleTestValues[i]) + ", Math.pow(" + doubleTestStrings[i] + "," + doubleTestStrings[i] + "));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"rint(double)["+testCount+++"] ::\", " + Math.rint(doubleTestValues[i]) + ", Math.rint("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// round - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testRound_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"round(double)["+testCount+++"] ::\", " + Math.round(doubleTestValues[i]) + "L, Math.round("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// round - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testRound_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"round(float)["+testCount+++"] ::\", " + Math.round(floatTestValues[i]) + "L, Math.round("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// signum - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSignum_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"signum(double)["+testCount+++"] ::\", (double)" + Math.signum(doubleTestValues[i]) + ", Math.signum("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// signum - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSignum_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"signum(float)["+testCount+++"] ::\", (float)" + Math.signum(floatTestValues[i]) + ", Math.signum("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sin - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSin()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"sin(double)["+testCount+++"] ::\", (double)" + Math.sin(doubleTestValues[i]) + ", Math.sin("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sinh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSinh()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"sinh(double)["+testCount+++"] ::\", (double)" + Math.sinh(doubleTestValues[i]) + ", Math.sinh("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// sqrt - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testSqrt()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			if(doubleTestValues[i] >= 0)
			{
				System.out.println("assertEquals(\"sqrt(double)["+testCount+++"] ::\", (double)" + Math.sqrt(doubleTestValues[i]) + ", Math.sqrt("+doubleTestStrings[i]+"));");
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
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"tan(double)["+testCount+++"] ::\", (double)" + Math.tan(doubleTestValues[i]) + ", Math.tan("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// tanh - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testTanh()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"tanh(double)["+testCount+++"] ::\", (double)" + Math.tanh(doubleTestValues[i]) + ", Math.tanh("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// toDegrees - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testToDegrees()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"toDegrees(double)["+testCount+++"] ::\", (double)" + Math.toDegrees(doubleTestValues[i]) + ", Math.toDegrees("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// toRadians - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testToRadians()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"toRadians(double)["+testCount+++"] ::\", (double)" + Math.toRadians(doubleTestValues[i]) + ", Math.toRadians("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ulp - double
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testUlp_double()");
		System.out.println("{");
		for(int i = 0; i < doubleTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"ulp(double)["+testCount+++"] ::\", (double)" + Math.ulp(doubleTestValues[i]) + ", Math.ulp("+doubleTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		// ulp - float
		// **************************************************************************************
		testCount = 0;
		System.out.println("public void testUlp_float()");
		System.out.println("{");
		for(int i = 0; i < floatTestValues.length; i++)
		{	
			System.out.println("assertEquals(\"ulp(float)["+testCount+++"] ::\", (float)" + Math.ulp(floatTestValues[i]) + ", Math.ulp("+floatTestStrings[i]+"));");
		}
		System.out.println("}");
		System.out.println();		
		// **************************************************************************************
		
		System.out.println("}");
	}	
}