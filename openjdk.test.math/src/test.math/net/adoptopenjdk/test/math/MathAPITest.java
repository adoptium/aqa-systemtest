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
package net.adoptopenjdk.test.math;

import junit.framework.TestCase;

/**
 * MathAPITest
 * ======================
 *
 * A simple collection of JUnit assertions covering the java.lang.Math API. Automatically generated using TestGenerator.java
 *
 * This version of MathAPITest was generated using the following JDK :
 *
 * java.vendor : Oracle Corporation
 * java.version : 1.7.0-ea
 * os.name : Linux
 * os.arch : i386
 *
 **/

public class MathAPITest extends TestCase
{

	private double Infinity = Double.MAX_VALUE * Double.MAX_VALUE;

	public void testAbs_double()
	{
		assertEquals("abs(double)[0] ::", -Double.MAX_VALUE*-1.0d, Math.abs(-Double.MAX_VALUE));
		assertEquals("abs(double)[1] ::", -Double.MAX_VALUE*-1.0d * 2d, Math.abs(-Double.MAX_VALUE * 2d));
		assertEquals("abs(double)[2] ::", -Double.MAX_VALUE*-1.0d * 2d, Math.abs(-Double.MAX_VALUE * -2d));
		assertEquals("abs(double)[3] ::", (-Double.MAX_VALUE / 200)*-1.0d, Math.abs((-Double.MAX_VALUE / 200)));
		assertEquals("abs(double)[4] ::", (-Double.MAX_VALUE / 200)*-1.0d * 2d, Math.abs((-Double.MAX_VALUE / 200) * 2d));
		assertEquals("abs(double)[5] ::", (-Double.MAX_VALUE / 200)*-1.0d * 2d, Math.abs((-Double.MAX_VALUE / 200) * -2d));
		assertEquals("abs(double)[6] ::", (-Double.MAX_VALUE / 500)*-1.0d, Math.abs((-Double.MAX_VALUE / 500)));
		assertEquals("abs(double)[7] ::", (-Double.MAX_VALUE / 500)*-1.0d * 2d, Math.abs((-Double.MAX_VALUE / 500) * 2d));
		assertEquals("abs(double)[8] ::", (-Double.MAX_VALUE / 500)*-1.0d * 2d, Math.abs((-Double.MAX_VALUE / 500) * -2d));
		assertEquals("abs(double)[9] ::", (-Double.MIN_VALUE * 2000)*-1.0d, Math.abs((-Double.MIN_VALUE * 2000)));
		assertEquals("abs(double)[10] ::", (-Double.MIN_VALUE * 2000)*-1.0d * 2d, Math.abs((-Double.MIN_VALUE * 2000) * 2d));
		assertEquals("abs(double)[11] ::", (-Double.MIN_VALUE * 2000)*-1.0d * 2d, Math.abs((-Double.MIN_VALUE * 2000) * -2d));
		assertEquals("abs(double)[12] ::", (-Double.MIN_VALUE * 1000)*-1.0d, Math.abs((-Double.MIN_VALUE * 1000)));
		assertEquals("abs(double)[13] ::", (-Double.MIN_VALUE * 1000)*-1.0d * 2d, Math.abs((-Double.MIN_VALUE * 1000) * 2d));
		assertEquals("abs(double)[14] ::", (-Double.MIN_VALUE * 1000)*-1.0d * 2d, Math.abs((-Double.MIN_VALUE * 1000) * -2d));
		assertEquals("abs(double)[15] ::", -2929112212.129231481346*-1.0d, Math.abs(-2929112212.129231481346));
		assertEquals("abs(double)[16] ::", -2929112212.129231481346*-1.0d * 2d, Math.abs(-2929112212.129231481346 * 2d));
		assertEquals("abs(double)[17] ::", -2929112212.129231481346*-1.0d * 2d, Math.abs(-2929112212.129231481346 * -2d));
		assertEquals("abs(double)[18] ::", -2372.228212D*-1.0d, Math.abs(-2372.228212D));
		assertEquals("abs(double)[19] ::", -2372.228212D*-1.0d * 2d, Math.abs(-2372.228212D * 2d));
		assertEquals("abs(double)[20] ::", -2372.228212D*-1.0d * 2d, Math.abs(-2372.228212D * -2d));
		assertEquals("abs(double)[21] ::", -1.2232D*-1.0d, Math.abs(-1.2232D));
		assertEquals("abs(double)[22] ::", -1.2232D*-1.0d * 2d, Math.abs(-1.2232D * 2d));
		assertEquals("abs(double)[23] ::", -1.2232D*-1.0d * 2d, Math.abs(-1.2232D * -2d));
		assertEquals("abs(double)[24] ::", 0D*1.0d, Math.abs(0D));
		assertEquals("abs(double)[25] ::", 0D*1.0d * 2d, Math.abs(0D * 2d));
		assertEquals("abs(double)[26] ::", 0D*1.0d * 2d, Math.abs(0D * -2d));
		assertEquals("abs(double)[27] ::", 2.43223D*1.0d, Math.abs(2.43223D));
		assertEquals("abs(double)[28] ::", 2.43223D*1.0d * 2d, Math.abs(2.43223D * 2d));
		assertEquals("abs(double)[29] ::", 2.43223D*1.0d * 2d, Math.abs(2.43223D * -2d));
		assertEquals("abs(double)[30] ::", 18232155.3323566D*1.0d, Math.abs(18232155.3323566D));
		assertEquals("abs(double)[31] ::", 18232155.3323566D*1.0d * 2d, Math.abs(18232155.3323566D * 2d));
		assertEquals("abs(double)[32] ::", 18232155.3323566D*1.0d * 2d, Math.abs(18232155.3323566D * -2d));
		assertEquals("abs(double)[33] ::", Double.MIN_VALUE*1.0d, Math.abs(Double.MIN_VALUE));
		assertEquals("abs(double)[34] ::", Double.MIN_VALUE*1.0d * 2d, Math.abs(Double.MIN_VALUE * 2d));
		assertEquals("abs(double)[35] ::", Double.MIN_VALUE*1.0d * 2d, Math.abs(Double.MIN_VALUE * -2d));
		assertEquals("abs(double)[36] ::", (Double.MIN_VALUE * 200)*1.0d, Math.abs((Double.MIN_VALUE * 200)));
		assertEquals("abs(double)[37] ::", (Double.MIN_VALUE * 200)*1.0d * 2d, Math.abs((Double.MIN_VALUE * 200) * 2d));
		assertEquals("abs(double)[38] ::", (Double.MIN_VALUE * 200)*1.0d * 2d, Math.abs((Double.MIN_VALUE * 200) * -2d));
		assertEquals("abs(double)[39] ::", (Double.MAX_VALUE / 500)*1.0d, Math.abs((Double.MAX_VALUE / 500)));
		assertEquals("abs(double)[40] ::", (Double.MAX_VALUE / 500)*1.0d * 2d, Math.abs((Double.MAX_VALUE / 500) * 2d));
		assertEquals("abs(double)[41] ::", (Double.MAX_VALUE / 500)*1.0d * 2d, Math.abs((Double.MAX_VALUE / 500) * -2d));
		assertEquals("abs(double)[42] ::", (Double.MAX_VALUE / 200)*1.0d, Math.abs((Double.MAX_VALUE / 200)));
		assertEquals("abs(double)[43] ::", (Double.MAX_VALUE / 200)*1.0d * 2d, Math.abs((Double.MAX_VALUE / 200) * 2d));
		assertEquals("abs(double)[44] ::", (Double.MAX_VALUE / 200)*1.0d * 2d, Math.abs((Double.MAX_VALUE / 200) * -2d));
		assertEquals("abs(double)[45] ::", Double.MAX_VALUE*1.0d, Math.abs(Double.MAX_VALUE));
		assertEquals("abs(double)[46] ::", Double.MAX_VALUE*1.0d * 2d, Math.abs(Double.MAX_VALUE * 2d));
		assertEquals("abs(double)[47] ::", Double.MAX_VALUE*1.0d * 2d, Math.abs(Double.MAX_VALUE * -2d));
		assertEquals("abs(double)[48] ::", Double.MAX_VALUE + 1*1.0d, Math.abs(Double.MAX_VALUE + 1));
		assertEquals("abs(double)[49] ::", Double.MAX_VALUE + 1*1.0d * 2d, Math.abs(Double.MAX_VALUE + 1 * 2d));
		assertEquals("abs(double)[50] ::", Double.MAX_VALUE + 1*1.0d * 2d, Math.abs(Double.MAX_VALUE + 1 * -2d));
	}

	public void testAbs_float()
	{
		assertEquals("abs(float)[0] ::", -Float.MAX_VALUE*-1.0f, Math.abs(-Float.MAX_VALUE));
		assertEquals("abs(float)[1] ::", -Float.MAX_VALUE*-1.0f * 2f, Math.abs(-Float.MAX_VALUE * 2f));
		assertEquals("abs(float)[2] ::", -Float.MAX_VALUE*-1.0f * 2f, Math.abs(-Float.MAX_VALUE * -2f));
		assertEquals("abs(float)[3] ::", (-Float.MAX_VALUE / 200)*-1.0f, Math.abs((-Float.MAX_VALUE / 200)));
		assertEquals("abs(float)[4] ::", (-Float.MAX_VALUE / 200)*-1.0f * 2f, Math.abs((-Float.MAX_VALUE / 200) * 2f));
		assertEquals("abs(float)[5] ::", (-Float.MAX_VALUE / 200)*-1.0f * 2f, Math.abs((-Float.MAX_VALUE / 200) * -2f));
		assertEquals("abs(float)[6] ::", (-Float.MAX_VALUE / 500)*-1.0f, Math.abs((-Float.MAX_VALUE / 500)));
		assertEquals("abs(float)[7] ::", (-Float.MAX_VALUE / 500)*-1.0f * 2f, Math.abs((-Float.MAX_VALUE / 500) * 2f));
		assertEquals("abs(float)[8] ::", (-Float.MAX_VALUE / 500)*-1.0f * 2f, Math.abs((-Float.MAX_VALUE / 500) * -2f));
		assertEquals("abs(float)[9] ::", (-Float.MIN_VALUE * 2000)*-1.0f, Math.abs((-Float.MIN_VALUE * 2000)));
		assertEquals("abs(float)[10] ::", (-Float.MIN_VALUE * 2000)*-1.0f * 2f, Math.abs((-Float.MIN_VALUE * 2000) * 2f));
		assertEquals("abs(float)[11] ::", (-Float.MIN_VALUE * 2000)*-1.0f * 2f, Math.abs((-Float.MIN_VALUE * 2000) * -2f));
		assertEquals("abs(float)[12] ::", (-Float.MIN_VALUE * 1000)*-1.0f, Math.abs((-Float.MIN_VALUE * 1000)));
		assertEquals("abs(float)[13] ::", (-Float.MIN_VALUE * 1000)*-1.0f * 2f, Math.abs((-Float.MIN_VALUE * 1000) * 2f));
		assertEquals("abs(float)[14] ::", (-Float.MIN_VALUE * 1000)*-1.0f * 2f, Math.abs((-Float.MIN_VALUE * 1000) * -2f));
		assertEquals("abs(float)[15] ::", -32948748.958324F*-1.0f, Math.abs(-32948748.958324F));
		assertEquals("abs(float)[16] ::", -32948748.958324F*-1.0f * 2f, Math.abs(-32948748.958324F * 2f));
		assertEquals("abs(float)[17] ::", -32948748.958324F*-1.0f * 2f, Math.abs(-32948748.958324F * -2f));
		assertEquals("abs(float)[18] ::", -0.000000009F*-1.0f, Math.abs(-0.000000009F));
		assertEquals("abs(float)[19] ::", -0.000000009F*-1.0f * 2f, Math.abs(-0.000000009F * 2f));
		assertEquals("abs(float)[20] ::", -0.000000009F*-1.0f * 2f, Math.abs(-0.000000009F * -2f));
		assertEquals("abs(float)[21] ::", -0.0000002F*-1.0f, Math.abs(-0.0000002F));
		assertEquals("abs(float)[22] ::", -0.0000002F*-1.0f * 2f, Math.abs(-0.0000002F * 2f));
		assertEquals("abs(float)[23] ::", -0.0000002F*-1.0f * 2f, Math.abs(-0.0000002F * -2f));
		assertEquals("abs(float)[24] ::", 0F*1.0f, Math.abs(0F));
		assertEquals("abs(float)[25] ::", 0F*1.0f * 2f, Math.abs(0F * 2f));
		assertEquals("abs(float)[26] ::", 0F*1.0f * 2f, Math.abs(0F * -2f));
		assertEquals("abs(float)[27] ::", 0.456232334F*1.0f, Math.abs(0.456232334F));
		assertEquals("abs(float)[28] ::", 0.456232334F*1.0f * 2f, Math.abs(0.456232334F * 2f));
		assertEquals("abs(float)[29] ::", 0.456232334F*1.0f * 2f, Math.abs(0.456232334F * -2f));
		assertEquals("abs(float)[30] ::", 1224257.312321263F*1.0f, Math.abs(1224257.312321263F));
		assertEquals("abs(float)[31] ::", 1224257.312321263F*1.0f * 2f, Math.abs(1224257.312321263F * 2f));
		assertEquals("abs(float)[32] ::", 1224257.312321263F*1.0f * 2f, Math.abs(1224257.312321263F * -2f));
		assertEquals("abs(float)[33] ::", 9999832342.12365F*1.0f, Math.abs(9999832342.12365F));
		assertEquals("abs(float)[34] ::", 9999832342.12365F*1.0f * 2f, Math.abs(9999832342.12365F * 2f));
		assertEquals("abs(float)[35] ::", 9999832342.12365F*1.0f * 2f, Math.abs(9999832342.12365F * -2f));
		assertEquals("abs(float)[36] ::", Float.MIN_VALUE*1.0f, Math.abs(Float.MIN_VALUE));
		assertEquals("abs(float)[37] ::", Float.MIN_VALUE*1.0f * 2f, Math.abs(Float.MIN_VALUE * 2f));
		assertEquals("abs(float)[38] ::", Float.MIN_VALUE*1.0f * 2f, Math.abs(Float.MIN_VALUE * -2f));
		assertEquals("abs(float)[39] ::", (Float.MIN_VALUE * 200)*1.0f, Math.abs((Float.MIN_VALUE * 200)));
		assertEquals("abs(float)[40] ::", (Float.MIN_VALUE * 200)*1.0f * 2f, Math.abs((Float.MIN_VALUE * 200) * 2f));
		assertEquals("abs(float)[41] ::", (Float.MIN_VALUE * 200)*1.0f * 2f, Math.abs((Float.MIN_VALUE * 200) * -2f));
		assertEquals("abs(float)[42] ::", (Float.MAX_VALUE / 500)*1.0f, Math.abs((Float.MAX_VALUE / 500)));
		assertEquals("abs(float)[43] ::", (Float.MAX_VALUE / 500)*1.0f * 2f, Math.abs((Float.MAX_VALUE / 500) * 2f));
		assertEquals("abs(float)[44] ::", (Float.MAX_VALUE / 500)*1.0f * 2f, Math.abs((Float.MAX_VALUE / 500) * -2f));
		assertEquals("abs(float)[45] ::", (Float.MAX_VALUE / 200)*1.0f, Math.abs((Float.MAX_VALUE / 200)));
		assertEquals("abs(float)[46] ::", (Float.MAX_VALUE / 200)*1.0f * 2f, Math.abs((Float.MAX_VALUE / 200) * 2f));
		assertEquals("abs(float)[47] ::", (Float.MAX_VALUE / 200)*1.0f * 2f, Math.abs((Float.MAX_VALUE / 200) * -2f));
		assertEquals("abs(float)[48] ::", Float.MAX_VALUE*1.0f, Math.abs(Float.MAX_VALUE));
		assertEquals("abs(float)[49] ::", Float.MAX_VALUE*1.0f * 2f, Math.abs(Float.MAX_VALUE * 2f));
		assertEquals("abs(float)[50] ::", Float.MAX_VALUE*1.0f * 2f, Math.abs(Float.MAX_VALUE * -2f));
		assertEquals("abs(float)[51] ::", (Float.MAX_VALUE + 1)*1.0f, Math.abs((Float.MAX_VALUE + 1)));
		assertEquals("abs(float)[52] ::", (Float.MAX_VALUE + 1)*1.0f * 2f, Math.abs((Float.MAX_VALUE + 1) * 2f));
		assertEquals("abs(float)[53] ::", (Float.MAX_VALUE + 1)*1.0f * 2f, Math.abs((Float.MAX_VALUE + 1) * -2f));
	}

	public void testAbs_long()
	{
		assertEquals("abs(long)[0] ::", Long.MIN_VALUE, Math.abs(Long.MIN_VALUE));
		assertEquals("abs(long)[1] ::", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * 2));
		assertEquals("abs(long)[2] ::", Long.MIN_VALUE * 2, Math.abs(Long.MIN_VALUE * -2));
		assertEquals("abs(long)[3] ::", (Long.MIN_VALUE + 1) * -1, Math.abs(Long.MIN_VALUE + 1));
		assertEquals("abs(long)[4] ::", (Long.MIN_VALUE + 1) * -1 * -2, Math.abs((Long.MIN_VALUE + 1) * 2));
		assertEquals("abs(long)[5] ::", (Long.MIN_VALUE + 1) * 2, Math.abs((Long.MIN_VALUE + 1) * -2));
		assertEquals("abs(int)[6] ::", -332342L*-1, Math.abs(-332342L));
		assertEquals("abs(int)[7] ::", -2L*-1, Math.abs(-2L));
		assertEquals("abs(int)[8] ::", -1L*-1, Math.abs(-1L));
		assertEquals("abs(int)[9] ::", 0L*1, Math.abs(0L));
		assertEquals("abs(int)[10] ::", 1L*1, Math.abs(1L));
		assertEquals("abs(int)[11] ::", 2L*1, Math.abs(2L));
		assertEquals("abs(int)[12] ::", 348238234234L*1, Math.abs(348238234234L));
		assertEquals("abs(int)[13] ::", (Long.MAX_VALUE - 2)*1, Math.abs((Long.MAX_VALUE - 2)));
		assertEquals("abs(int)[14] ::", (Long.MAX_VALUE - 1)*1, Math.abs((Long.MAX_VALUE - 1)));
		assertEquals("abs(int)[15] ::", Long.MAX_VALUE*1, Math.abs(Long.MAX_VALUE));
	}

	public void testAbs_integer()
	{
		assertEquals("abs(int)[0] ::", Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));
		assertEquals("abs(int)[1] ::", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * 2));
		assertEquals("abs(int)[2] ::", Integer.MIN_VALUE * 2, Math.abs(Integer.MIN_VALUE * -2));
		assertEquals("abs(int)[3] ::", (Integer.MIN_VALUE + 1) * -1, Math.abs(Integer.MIN_VALUE + 1));
		assertEquals("abs(int)[4] ::", (Integer.MIN_VALUE + 1) * -1 * -2, Math.abs((Integer.MIN_VALUE + 1) * 2));
		assertEquals("abs(int)[5] ::", (Integer.MIN_VALUE + 1) * 2, Math.abs((Integer.MIN_VALUE + 1) * -2));
		assertEquals("abs(int)[6] ::", -42218*-1, Math.abs(-42218));
		assertEquals("abs(int)[7] ::", -2*-1, Math.abs(-2));
		assertEquals("abs(int)[8] ::", -1*-1, Math.abs(-1));
		assertEquals("abs(int)[9] ::", 0*1, Math.abs(0));
		assertEquals("abs(int)[10] ::", 1*1, Math.abs(1));
		assertEquals("abs(int)[11] ::", 2*1, Math.abs(2));
		assertEquals("abs(int)[12] ::", 892389*1, Math.abs(892389));
		assertEquals("abs(int)[13] ::", (Integer.MAX_VALUE - 2)*1, Math.abs((Integer.MAX_VALUE - 2)));
		assertEquals("abs(int)[14] ::", (Integer.MAX_VALUE - 1)*1, Math.abs((Integer.MAX_VALUE - 1)));
		assertEquals("abs(int)[15] ::", Integer.MAX_VALUE*1, Math.abs(Integer.MAX_VALUE));
	}

	public void testAcos()
	{
		assertEquals("acos(double)[0] ::", 1.5707963267948966, Math.acos((-Double.MIN_VALUE * 2000)));
		assertEquals("acos(double)[1] ::", 1.5707963267948966, Math.acos((-Double.MIN_VALUE * 1000)));
		assertEquals("acos(double)[2] ::", 1.5707963267948966, Math.acos(0D));
		assertEquals("acos(double)[3] ::", 1.5707963267948966, Math.acos(Double.MIN_VALUE));
		assertEquals("acos(double)[4] ::", 1.5707963267948966, Math.acos((Double.MIN_VALUE * 200)));
		assertEquals("acos(float)[5] ::", 1.5707963267948966, Math.acos((-Float.MIN_VALUE * 2000)));
		assertEquals("acos(float)[6] ::", 1.5707963267948966, Math.acos((-Float.MIN_VALUE * 1000)));
		assertEquals("acos(float)[7] ::", 1.5707963357948964, Math.acos(-0.000000009F));
		assertEquals("acos(float)[8] ::", 1.570796526794899, Math.acos(-0.0000002F));
		assertEquals("acos(float)[9] ::", 1.5707963267948966, Math.acos(0F));
		assertEquals("acos(float)[10] ::", 1.0970397360295143, Math.acos(0.456232334F));
		assertEquals("acos(float)[11] ::", 1.5707963267948966, Math.acos(Float.MIN_VALUE));
		assertEquals("acos(float)[12] ::", 1.5707963267948966, Math.acos((Float.MIN_VALUE * 200)));
		assertEquals("acos(long)[13] ::", 3.141592653589793, Math.acos(-1L));
		assertEquals("acos(long)[14] ::", 1.5707963267948966, Math.acos(0L));
		assertEquals("acos(long)[15] ::", 0.0, Math.acos(1L));
		assertEquals("acos(int)[16] ::", 3.141592653589793, Math.acos(-1));
		assertEquals("acos(int)[17] ::", 1.5707963267948966, Math.acos(0));
		assertEquals("acos(int)[18] ::", 0.0, Math.acos(1));
	}

	public void testAsin()
	{
		assertEquals("asin(double)[0] ::", -9.88E-321, Math.asin((-Double.MIN_VALUE * 2000)));
		assertEquals("asin(double)[1] ::", -4.94E-321, Math.asin((-Double.MIN_VALUE * 1000)));
		assertEquals("asin(double)[2] ::", 0.0, Math.asin(0D));
		assertEquals("asin(double)[3] ::", 4.9E-324, Math.asin(Double.MIN_VALUE));
		assertEquals("asin(double)[4] ::", 9.9E-322, Math.asin((Double.MIN_VALUE * 200)));
		assertEquals("asin(float)[5] ::", -2.802596928649634E-42, Math.asin((-Float.MIN_VALUE * 2000)));
		assertEquals("asin(float)[6] ::", -1.401298464324817E-42, Math.asin((-Float.MIN_VALUE * 1000)));
		assertEquals("asin(float)[7] ::", -8.99999985648492E-9, Math.asin(-0.000000009F));
		assertEquals("asin(float)[8] ::", -2.000000023372208E-7, Math.asin(-0.0000002F));
		assertEquals("asin(float)[9] ::", 0.0, Math.asin(0F));
		assertEquals("asin(float)[10] ::", 0.47375659076538235, Math.asin(0.456232334F));
		assertEquals("asin(float)[11] ::", 1.401298464324817E-45, Math.asin(Float.MIN_VALUE));
		assertEquals("asin(float)[12] ::", 2.802596928649634E-43, Math.asin((Float.MIN_VALUE * 200)));
		assertEquals("asin(long)[13] ::", -1.5707963267948966, Math.asin(-1L));
		assertEquals("asin(long)[14] ::", 0.0, Math.asin(0L));
		assertEquals("asin(long)[15] ::", 1.5707963267948966, Math.asin(1L));
		assertEquals("asin(int)[16] ::", -1.5707963267948966, Math.asin(-1));
		assertEquals("asin(int)[17] ::", 0.0, Math.asin(0));
		assertEquals("asin(int)[18] ::", 1.5707963267948966, Math.asin(1));
	}

	public void testAtan()
	{
		assertEquals("atan(double)[0] ::", -1.5707963267948966, Math.atan(-Double.MAX_VALUE));
		assertEquals("atan(double)[1] ::", -1.5707963267948966, Math.atan((-Double.MAX_VALUE / 200)));
		assertEquals("atan(double)[2] ::", -1.5707963267948966, Math.atan((-Double.MAX_VALUE / 500)));
		assertEquals("atan(double)[3] ::", -9.88E-321, Math.atan((-Double.MIN_VALUE * 2000)));
		assertEquals("atan(double)[4] ::", -4.94E-321, Math.atan((-Double.MIN_VALUE * 1000)));
		assertEquals("atan(double)[5] ::", -1.5707963264534963, Math.atan(-2929112212.129231481346));
		assertEquals("atan(double)[6] ::", -1.5703747822168042, Math.atan(-2372.228212D));
		assertEquals("atan(double)[7] ::", -0.8854587072790011, Math.atan(-1.2232D));
		assertEquals("atan(double)[8] ::", 0.0, Math.atan(0D));
		assertEquals("atan(double)[9] ::", 1.1807189853657203, Math.atan(2.43223D));
		assertEquals("atan(double)[10] ::", 1.570796271946746, Math.atan(18232155.3323566D));
		assertEquals("atan(double)[11] ::", 4.9E-324, Math.atan(Double.MIN_VALUE));
		assertEquals("atan(double)[12] ::", 9.9E-322, Math.atan((Double.MIN_VALUE * 200)));
		assertEquals("atan(double)[13] ::", 1.5707963267948966, Math.atan((Double.MAX_VALUE / 500)));
		assertEquals("atan(double)[14] ::", 1.5707963267948966, Math.atan((Double.MAX_VALUE / 200)));
		assertEquals("atan(double)[15] ::", 1.5707963267948966, Math.atan(Double.MAX_VALUE));
		assertEquals("atan(double)[16] ::", 1.5707963267948966, Math.atan(Double.MAX_VALUE + 1));
		assertEquals("atan(float)[17] ::", -1.5707963267948966, Math.atan(-Float.MAX_VALUE));
		assertEquals("atan(float)[18] ::", -1.5707963267948966, Math.atan((-Float.MAX_VALUE / 200)));
		assertEquals("atan(float)[19] ::", -1.5707963267948966, Math.atan((-Float.MAX_VALUE / 500)));
		assertEquals("atan(float)[20] ::", -2.802596928649634E-42, Math.atan((-Float.MIN_VALUE * 2000)));
		assertEquals("atan(float)[21] ::", -1.401298464324817E-42, Math.atan((-Float.MIN_VALUE * 1000)));
		assertEquals("atan(float)[22] ::", -1.5707962964447297, Math.atan(-32948748.958324F));
		assertEquals("atan(float)[23] ::", -8.99999985648492E-9, Math.atan(-0.000000009F));
		assertEquals("atan(float)[24] ::", -2.000000023372168E-7, Math.atan(-0.0000002F));
		assertEquals("atan(float)[25] ::", 0.0, Math.atan(0F));
		assertEquals("atan(float)[26] ::", 0.42802463886854475, Math.atan(0.456232334F));
		assertEquals("atan(float)[27] ::", 1.5707955099731052, Math.atan(1224257.312321263F));
		assertEquals("atan(float)[28] ::", 1.570796326694895, Math.atan(9999832342.12365F));
		assertEquals("atan(float)[29] ::", 1.401298464324817E-45, Math.atan(Float.MIN_VALUE));
		assertEquals("atan(float)[30] ::", 2.802596928649634E-43, Math.atan((Float.MIN_VALUE * 200)));
		assertEquals("atan(float)[31] ::", 1.5707963267948966, Math.atan((Float.MAX_VALUE / 500)));
		assertEquals("atan(float)[32] ::", 1.5707963267948966, Math.atan((Float.MAX_VALUE / 200)));
		assertEquals("atan(float)[33] ::", 1.5707963267948966, Math.atan(Float.MAX_VALUE));
		assertEquals("atan(float)[34] ::", 1.5707963267948966, Math.atan((Float.MAX_VALUE + 1)));
		assertEquals("atan(long)[35] ::", -1.5707963267948966, Math.atan(Long.MIN_VALUE));
		assertEquals("atan(long)[36] ::", -1.5707963267948966, Math.atan((Long.MIN_VALUE + 1)));
		assertEquals("atan(long)[37] ::", -1.5707963267948966, Math.atan((Long.MIN_VALUE + 2)));
		assertEquals("atan(long)[38] ::", -1.5707933178462834, Math.atan(-332342L));
		assertEquals("atan(long)[39] ::", -1.1071487177940904, Math.atan(-2L));
		assertEquals("atan(long)[40] ::", -0.7853981633974483, Math.atan(-1L));
		assertEquals("atan(long)[41] ::", 0.0, Math.atan(0L));
		assertEquals("atan(long)[42] ::", 0.7853981633974483, Math.atan(1L));
		assertEquals("atan(long)[43] ::", 1.1071487177940904, Math.atan(2L));
		assertEquals("atan(long)[44] ::", 1.570796326792025, Math.atan(348238234234L));
		assertEquals("atan(long)[45] ::", 1.5707963267948966, Math.atan((Long.MAX_VALUE - 2)));
		assertEquals("atan(long)[46] ::", 1.5707963267948966, Math.atan((Long.MAX_VALUE - 1)));
		assertEquals("atan(long)[47] ::", 1.5707963267948966, Math.atan(Long.MAX_VALUE));
		assertEquals("atan(int)[48] ::", -1.5707963263292353, Math.atan(Integer.MIN_VALUE));
		assertEquals("atan(int)[49] ::", -1.5707963263292353, Math.atan((Integer.MIN_VALUE + 1)));
		assertEquals("atan(int)[50] ::", -1.5707963263292353, Math.atan((Integer.MIN_VALUE + 2)));
		assertEquals("atan(int)[51] ::", -1.5707726402157167, Math.atan(-42218));
		assertEquals("atan(int)[52] ::", -1.1071487177940904, Math.atan(-2));
		assertEquals("atan(int)[53] ::", -0.7853981633974483, Math.atan(-1));
		assertEquals("atan(int)[54] ::", 0.0, Math.atan(0));
		assertEquals("atan(int)[55] ::", 0.7853981633974483, Math.atan(1));
		assertEquals("atan(int)[56] ::", 1.1071487177940904, Math.atan(2));
		assertEquals("atan(int)[57] ::", 1.5707952062073502, Math.atan(892389));
		assertEquals("atan(int)[58] ::", 1.5707963263292353, Math.atan((Integer.MAX_VALUE - 2)));
		assertEquals("atan(int)[59] ::", 1.5707963263292353, Math.atan((Integer.MAX_VALUE - 1)));
		assertEquals("atan(int)[60] ::", 1.5707963263292353, Math.atan(Integer.MAX_VALUE));
	}

	public void testAtan2()
	{
		assertEquals("atan2(double,double)[0] ::", -1.575796285128855, Math.atan2(-Double.MAX_VALUE,(-Double.MAX_VALUE / 200)));
		assertEquals("atan2(double,double)[1] ::", -1.9513027039072617, Math.atan2((-Double.MAX_VALUE / 200),(-Double.MAX_VALUE / 500)));
		assertEquals("atan2(double,double)[2] ::", -1.5707963267948968, Math.atan2((-Double.MAX_VALUE / 500),(-Double.MIN_VALUE * 2000)));
		assertEquals("atan2(double,double)[3] ::", -2.0344439357957027, Math.atan2((-Double.MIN_VALUE * 2000),(-Double.MIN_VALUE * 1000)));
		assertEquals("atan2(double,double)[4] ::", -3.141592653589793, Math.atan2((-Double.MIN_VALUE * 1000),-2929112212.129231481346));
		assertEquals("atan2(double,double)[5] ::", -1.5707971366744917, Math.atan2(-2929112212.129231481346,-2372.228212D));
		assertEquals("atan2(double,double)[6] ::", -1.5713119601076637, Math.atan2(-2372.228212D,-1.2232D));
		assertEquals("atan2(double,double)[7] ::", -1.5707963267948966, Math.atan2(-1.2232D,0D));
		assertEquals("atan2(double,double)[8] ::", 0.0, Math.atan2(0D,2.43223D));
		assertEquals("atan2(double,double)[9] ::", 1.334033171428453E-7, Math.atan2(2.43223D,18232155.3323566D));
		assertEquals("atan2(double,double)[10] ::", 1.5707963267948966, Math.atan2(18232155.3323566D,Double.MIN_VALUE));
		assertEquals("atan2(double,double)[11] ::", 0.0049999583339583225, Math.atan2(Double.MIN_VALUE,(Double.MIN_VALUE * 200)));
		assertEquals("atan2(double,double)[12] ::", 0.0, Math.atan2((Double.MIN_VALUE * 200),(Double.MAX_VALUE / 500)));
		assertEquals("atan2(double,double)[13] ::", 0.38050637711236485, Math.atan2((Double.MAX_VALUE / 500),(Double.MAX_VALUE / 200)));
		assertEquals("atan2(double,double)[14] ::", 0.0049999583339583225, Math.atan2((Double.MAX_VALUE / 200),Double.MAX_VALUE));
		assertEquals("atan2(double,double)[15] ::", 0.7853981633974483, Math.atan2(Double.MAX_VALUE,Double.MAX_VALUE + 1));
	}

	public void testCbrt()
	{
		assertEquals("cbrt(double)[0] ::", -5.643803094122362E102, Math.cbrt(-Double.MAX_VALUE));
		assertEquals("cbrt(double)[1] ::", -9.650767538728758E101, Math.cbrt((-Double.MAX_VALUE / 200)));
		assertEquals("cbrt(double)[2] ::", -7.11074631974658E101, Math.cbrt((-Double.MAX_VALUE / 500)));
		assertEquals("cbrt(double)[3] ::", -2.1458772928133103E-107, Math.cbrt((-Double.MIN_VALUE * 2000)));
		assertEquals("cbrt(double)[4] ::", -1.7031839360032603E-107, Math.cbrt((-Double.MIN_VALUE * 1000)));
		assertEquals("cbrt(double)[5] ::", -1430.7991380071423, Math.cbrt(-2929112212.129231481346));
		assertEquals("cbrt(double)[6] ::", -13.336815876701571, Math.cbrt(-2372.228212D));
		assertEquals("cbrt(double)[7] ::", -1.069463148164605, Math.cbrt(-1.2232D));
		assertEquals("cbrt(double)[8] ::", 0.0, Math.cbrt(0D));
		assertEquals("cbrt(double)[9] ::", 1.3448325547134823, Math.cbrt(2.43223D));
		assertEquals("cbrt(double)[10] ::", 263.1960319638015, Math.cbrt(18232155.3323566D));
		assertEquals("cbrt(double)[11] ::", 1.7031839360032603E-108, Math.cbrt(Double.MIN_VALUE));
		assertEquals("cbrt(double)[12] ::", 9.96028008062548E-108, Math.cbrt((Double.MIN_VALUE * 200)));
		assertEquals("cbrt(double)[13] ::", 7.11074631974658E101, Math.cbrt((Double.MAX_VALUE / 500)));
		assertEquals("cbrt(double)[14] ::", 9.650767538728758E101, Math.cbrt((Double.MAX_VALUE / 200)));
		assertEquals("cbrt(double)[15] ::", 5.643803094122362E102, Math.cbrt(Double.MAX_VALUE));
		assertEquals("cbrt(double)[16] ::", 5.643803094122362E102, Math.cbrt(Double.MAX_VALUE + 1));
	}

	public void testCeil()
	{
		assertEquals("ceil(double)[0] ::", -1.7976931348623157E308, Math.ceil(-Double.MAX_VALUE));
		assertEquals("ceil(double)[1] ::", -8.988465674311578E305, Math.ceil((-Double.MAX_VALUE / 200)));
		assertEquals("ceil(double)[2] ::", -3.595386269724631E305, Math.ceil((-Double.MAX_VALUE / 500)));
		assertEquals("ceil(double)[3] ::", -0.0, Math.ceil((-Double.MIN_VALUE * 2000)));
		assertEquals("ceil(double)[4] ::", -0.0, Math.ceil((-Double.MIN_VALUE * 1000)));
		assertEquals("ceil(double)[5] ::", -2.929112212E9, Math.ceil(-2929112212.129231481346));
		assertEquals("ceil(double)[6] ::", -2372.0, Math.ceil(-2372.228212D));
		assertEquals("ceil(double)[7] ::", -1.0, Math.ceil(-1.2232D));
		assertEquals("ceil(double)[8] ::", 0.0, Math.ceil(0D));
		assertEquals("ceil(double)[9] ::", 3.0, Math.ceil(2.43223D));
		assertEquals("ceil(double)[10] ::", 1.8232156E7, Math.ceil(18232155.3323566D));
		assertEquals("ceil(double)[11] ::", 1.0, Math.ceil(Double.MIN_VALUE));
		assertEquals("ceil(double)[12] ::", 1.0, Math.ceil((Double.MIN_VALUE * 200)));
		assertEquals("ceil(double)[13] ::", 3.595386269724631E305, Math.ceil((Double.MAX_VALUE / 500)));
		assertEquals("ceil(double)[14] ::", 8.988465674311578E305, Math.ceil((Double.MAX_VALUE / 200)));
		assertEquals("ceil(double)[15] ::", 1.7976931348623157E308, Math.ceil(Double.MAX_VALUE));
		assertEquals("ceil(double)[16] ::", 1.7976931348623157E308, Math.ceil(Double.MAX_VALUE + 1));
	}

	public void testCos()
	{
		assertEquals("cos(double)[0] ::", -0.9999876894265599, Math.cos(-Double.MAX_VALUE));
		assertEquals("cos(double)[1] ::", -0.9733355049132392, Math.cos((-Double.MAX_VALUE / 200)));
		assertEquals("cos(double)[2] ::", 0.9999035374750699, Math.cos((-Double.MAX_VALUE / 500)));
		assertEquals("cos(double)[3] ::", 1.0, Math.cos((-Double.MIN_VALUE * 2000)));
		assertEquals("cos(double)[4] ::", 1.0, Math.cos((-Double.MIN_VALUE * 1000)));
		assertEquals("cos(double)[5] ::", -0.9080207917312976, Math.cos(-2929112212.129231481346));
		assertEquals("cos(double)[6] ::", -0.9474082454146647, Math.cos(-2372.228212D));
		assertEquals("cos(double)[7] ::", 0.3406388740398382, Math.cos(-1.2232D));
		assertEquals("cos(double)[8] ::", 1.0, Math.cos(0D));
		assertEquals("cos(double)[9] ::", -0.7587771658491411, Math.cos(2.43223D));
		assertEquals("cos(double)[10] ::", -0.616060632583357, Math.cos(18232155.3323566D));
		assertEquals("cos(double)[11] ::", 1.0, Math.cos(Double.MIN_VALUE));
		assertEquals("cos(double)[12] ::", 1.0, Math.cos((Double.MIN_VALUE * 200)));
		assertEquals("cos(double)[13] ::", 0.9999035374750699, Math.cos((Double.MAX_VALUE / 500)));
		assertEquals("cos(double)[14] ::", -0.9733355049132392, Math.cos((Double.MAX_VALUE / 200)));
		assertEquals("cos(double)[15] ::", -0.9999876894265599, Math.cos(Double.MAX_VALUE));
		assertEquals("cos(double)[16] ::", -0.9999876894265599, Math.cos(Double.MAX_VALUE + 1));
	}

	public void testCosh()
	{
		assertEquals("cosh(double)[0] ::", Infinity, Math.cosh(-Double.MAX_VALUE));
		assertEquals("cosh(double)[1] ::", Infinity, Math.cosh((-Double.MAX_VALUE / 200)));
		assertEquals("cosh(double)[2] ::", Infinity, Math.cosh((-Double.MAX_VALUE / 500)));
		assertEquals("cosh(double)[3] ::", 1.0, Math.cosh((-Double.MIN_VALUE * 2000)));
		assertEquals("cosh(double)[4] ::", 1.0, Math.cosh((-Double.MIN_VALUE * 1000)));
		assertEquals("cosh(double)[5] ::", Infinity, Math.cosh(-2929112212.129231481346));
		assertEquals("cosh(double)[6] ::", Infinity, Math.cosh(-2372.228212D));
		assertEquals("cosh(double)[7] ::", 1.8461655178203698, Math.cosh(-1.2232D));
		assertEquals("cosh(double)[8] ::", 1.0, Math.cosh(0D));
		assertEquals("cosh(double)[9] ::", 5.736040690260186, Math.cosh(2.43223D));
		assertEquals("cosh(double)[10] ::", Infinity, Math.cosh(18232155.3323566D));
		assertEquals("cosh(double)[11] ::", 1.0, Math.cosh(Double.MIN_VALUE));
		assertEquals("cosh(double)[12] ::", 1.0, Math.cosh((Double.MIN_VALUE * 200)));
		assertEquals("cosh(double)[13] ::", Infinity, Math.cosh((Double.MAX_VALUE / 500)));
		assertEquals("cosh(double)[14] ::", Infinity, Math.cosh((Double.MAX_VALUE / 200)));
		assertEquals("cosh(double)[15] ::", Infinity, Math.cosh(Double.MAX_VALUE));
		assertEquals("cosh(double)[16] ::", Infinity, Math.cosh(Double.MAX_VALUE + 1));
	}

	public void testCopySign_double()
	{
		assertEquals("copySign(double,double)[0] ::", 1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,0.0D));
		assertEquals("copySign(double,double)[1] ::", 1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,1.0D));
		assertEquals("copySign(double,double)[2] ::", 1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,0.222231D));
		assertEquals("copySign(double,double)[3] ::", -1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,-0.0D));
		assertEquals("copySign(double,double)[4] ::", -1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,-1.0D));
		assertEquals("copySign(double,double)[5] ::", -1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,-0.222231D));
		assertEquals("copySign(double,double)[6] ::", -1.7976931348623157E308, Math.copySign(-Double.MAX_VALUE,-Double.MAX_VALUE));
		assertEquals("copySign(double,double)[7] ::", 8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),0.0D));
		assertEquals("copySign(double,double)[8] ::", 8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),1.0D));
		assertEquals("copySign(double,double)[9] ::", 8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),0.222231D));
		assertEquals("copySign(double,double)[10] ::", -8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),-0.0D));
		assertEquals("copySign(double,double)[11] ::", -8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),-1.0D));
		assertEquals("copySign(double,double)[12] ::", -8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),-0.222231D));
		assertEquals("copySign(double,double)[13] ::", -8.988465674311578E305, Math.copySign((-Double.MAX_VALUE / 200),(-Double.MAX_VALUE / 200)));
		assertEquals("copySign(double,double)[14] ::", 3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),0.0D));
		assertEquals("copySign(double,double)[15] ::", 3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),1.0D));
		assertEquals("copySign(double,double)[16] ::", 3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),0.222231D));
		assertEquals("copySign(double,double)[17] ::", -3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),-0.0D));
		assertEquals("copySign(double,double)[18] ::", -3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),-1.0D));
		assertEquals("copySign(double,double)[19] ::", -3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),-0.222231D));
		assertEquals("copySign(double,double)[20] ::", -3.595386269724631E305, Math.copySign((-Double.MAX_VALUE / 500),(-Double.MAX_VALUE / 500)));
		assertEquals("copySign(double,double)[21] ::", 9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),0.0D));
		assertEquals("copySign(double,double)[22] ::", 9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),1.0D));
		assertEquals("copySign(double,double)[23] ::", 9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),0.222231D));
		assertEquals("copySign(double,double)[24] ::", -9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),-0.0D));
		assertEquals("copySign(double,double)[25] ::", -9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),-1.0D));
		assertEquals("copySign(double,double)[26] ::", -9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),-0.222231D));
		assertEquals("copySign(double,double)[27] ::", -9.88E-321, Math.copySign((-Double.MIN_VALUE * 2000),(-Double.MIN_VALUE * 2000)));
		assertEquals("copySign(double,double)[28] ::", 4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),0.0D));
		assertEquals("copySign(double,double)[29] ::", 4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),1.0D));
		assertEquals("copySign(double,double)[30] ::", 4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),0.222231D));
		assertEquals("copySign(double,double)[31] ::", -4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),-0.0D));
		assertEquals("copySign(double,double)[32] ::", -4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),-1.0D));
		assertEquals("copySign(double,double)[33] ::", -4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),-0.222231D));
		assertEquals("copySign(double,double)[34] ::", -4.94E-321, Math.copySign((-Double.MIN_VALUE * 1000),(-Double.MIN_VALUE * 1000)));
		assertEquals("copySign(double,double)[35] ::", 2.9291122121292315E9, Math.copySign(-2929112212.129231481346,0.0D));
		assertEquals("copySign(double,double)[36] ::", 2.9291122121292315E9, Math.copySign(-2929112212.129231481346,1.0D));
		assertEquals("copySign(double,double)[37] ::", 2.9291122121292315E9, Math.copySign(-2929112212.129231481346,0.222231D));
		assertEquals("copySign(double,double)[38] ::", -2.9291122121292315E9, Math.copySign(-2929112212.129231481346,-0.0D));
		assertEquals("copySign(double,double)[39] ::", -2.9291122121292315E9, Math.copySign(-2929112212.129231481346,-1.0D));
		assertEquals("copySign(double,double)[40] ::", -2.9291122121292315E9, Math.copySign(-2929112212.129231481346,-0.222231D));
		assertEquals("copySign(double,double)[41] ::", -2.9291122121292315E9, Math.copySign(-2929112212.129231481346,-2929112212.129231481346));
		assertEquals("copySign(double,double)[42] ::", 2372.228212, Math.copySign(-2372.228212D,0.0D));
		assertEquals("copySign(double,double)[43] ::", 2372.228212, Math.copySign(-2372.228212D,1.0D));
		assertEquals("copySign(double,double)[44] ::", 2372.228212, Math.copySign(-2372.228212D,0.222231D));
		assertEquals("copySign(double,double)[45] ::", -2372.228212, Math.copySign(-2372.228212D,-0.0D));
		assertEquals("copySign(double,double)[46] ::", -2372.228212, Math.copySign(-2372.228212D,-1.0D));
		assertEquals("copySign(double,double)[47] ::", -2372.228212, Math.copySign(-2372.228212D,-0.222231D));
		assertEquals("copySign(double,double)[48] ::", -2372.228212, Math.copySign(-2372.228212D,-2372.228212D));
		assertEquals("copySign(double,double)[49] ::", 1.2232, Math.copySign(-1.2232D,0.0D));
		assertEquals("copySign(double,double)[50] ::", 1.2232, Math.copySign(-1.2232D,1.0D));
		assertEquals("copySign(double,double)[51] ::", 1.2232, Math.copySign(-1.2232D,0.222231D));
		assertEquals("copySign(double,double)[52] ::", -1.2232, Math.copySign(-1.2232D,-0.0D));
		assertEquals("copySign(double,double)[53] ::", -1.2232, Math.copySign(-1.2232D,-1.0D));
		assertEquals("copySign(double,double)[54] ::", -1.2232, Math.copySign(-1.2232D,-0.222231D));
		assertEquals("copySign(double,double)[55] ::", -1.2232, Math.copySign(-1.2232D,-1.2232D));
		assertEquals("copySign(double,double)[56] ::", 0.0, Math.copySign(0D,0.0D));
		assertEquals("copySign(double,double)[57] ::", 0.0, Math.copySign(0D,1.0D));
		assertEquals("copySign(double,double)[58] ::", 0.0, Math.copySign(0D,0.222231D));
		assertEquals("copySign(double,double)[59] ::", -0.0, Math.copySign(0D,-0.0D));
		assertEquals("copySign(double,double)[60] ::", -0.0, Math.copySign(0D,-1.0D));
		assertEquals("copySign(double,double)[61] ::", -0.0, Math.copySign(0D,-0.222231D));
		assertEquals("copySign(double,double)[62] ::", 0.0, Math.copySign(0D,0D));
		assertEquals("copySign(double,double)[63] ::", 2.43223, Math.copySign(2.43223D,0.0D));
		assertEquals("copySign(double,double)[64] ::", 2.43223, Math.copySign(2.43223D,1.0D));
		assertEquals("copySign(double,double)[65] ::", 2.43223, Math.copySign(2.43223D,0.222231D));
		assertEquals("copySign(double,double)[66] ::", -2.43223, Math.copySign(2.43223D,-0.0D));
		assertEquals("copySign(double,double)[67] ::", -2.43223, Math.copySign(2.43223D,-1.0D));
		assertEquals("copySign(double,double)[68] ::", -2.43223, Math.copySign(2.43223D,-0.222231D));
		assertEquals("copySign(double,double)[69] ::", 2.43223, Math.copySign(2.43223D,2.43223D));
		assertEquals("copySign(double,double)[70] ::", 1.82321553323566E7, Math.copySign(18232155.3323566D,0.0D));
		assertEquals("copySign(double,double)[71] ::", 1.82321553323566E7, Math.copySign(18232155.3323566D,1.0D));
		assertEquals("copySign(double,double)[72] ::", 1.82321553323566E7, Math.copySign(18232155.3323566D,0.222231D));
		assertEquals("copySign(double,double)[73] ::", -1.82321553323566E7, Math.copySign(18232155.3323566D,-0.0D));
		assertEquals("copySign(double,double)[74] ::", -1.82321553323566E7, Math.copySign(18232155.3323566D,-1.0D));
		assertEquals("copySign(double,double)[75] ::", -1.82321553323566E7, Math.copySign(18232155.3323566D,-0.222231D));
		assertEquals("copySign(double,double)[76] ::", 1.82321553323566E7, Math.copySign(18232155.3323566D,18232155.3323566D));
		assertEquals("copySign(double,double)[77] ::", 4.9E-324, Math.copySign(Double.MIN_VALUE,0.0D));
		assertEquals("copySign(double,double)[78] ::", 4.9E-324, Math.copySign(Double.MIN_VALUE,1.0D));
		assertEquals("copySign(double,double)[79] ::", 4.9E-324, Math.copySign(Double.MIN_VALUE,0.222231D));
		assertEquals("copySign(double,double)[80] ::", -4.9E-324, Math.copySign(Double.MIN_VALUE,-0.0D));
		assertEquals("copySign(double,double)[81] ::", -4.9E-324, Math.copySign(Double.MIN_VALUE,-1.0D));
		assertEquals("copySign(double,double)[82] ::", -4.9E-324, Math.copySign(Double.MIN_VALUE,-0.222231D));
		assertEquals("copySign(double,double)[83] ::", 4.9E-324, Math.copySign(Double.MIN_VALUE,Double.MIN_VALUE));
		assertEquals("copySign(double,double)[84] ::", 9.9E-322, Math.copySign((Double.MIN_VALUE * 200),0.0D));
		assertEquals("copySign(double,double)[85] ::", 9.9E-322, Math.copySign((Double.MIN_VALUE * 200),1.0D));
		assertEquals("copySign(double,double)[86] ::", 9.9E-322, Math.copySign((Double.MIN_VALUE * 200),0.222231D));
		assertEquals("copySign(double,double)[87] ::", -9.9E-322, Math.copySign((Double.MIN_VALUE * 200),-0.0D));
		assertEquals("copySign(double,double)[88] ::", -9.9E-322, Math.copySign((Double.MIN_VALUE * 200),-1.0D));
		assertEquals("copySign(double,double)[89] ::", -9.9E-322, Math.copySign((Double.MIN_VALUE * 200),-0.222231D));
		assertEquals("copySign(double,double)[90] ::", 9.9E-322, Math.copySign((Double.MIN_VALUE * 200),(Double.MIN_VALUE * 200)));
		assertEquals("copySign(double,double)[91] ::", 3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),0.0D));
		assertEquals("copySign(double,double)[92] ::", 3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),1.0D));
		assertEquals("copySign(double,double)[93] ::", 3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),0.222231D));
		assertEquals("copySign(double,double)[94] ::", -3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),-0.0D));
		assertEquals("copySign(double,double)[95] ::", -3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),-1.0D));
		assertEquals("copySign(double,double)[96] ::", -3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),-0.222231D));
		assertEquals("copySign(double,double)[97] ::", 3.595386269724631E305, Math.copySign((Double.MAX_VALUE / 500),(Double.MAX_VALUE / 500)));
		assertEquals("copySign(double,double)[98] ::", 8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),0.0D));
		assertEquals("copySign(double,double)[99] ::", 8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),1.0D));
		assertEquals("copySign(double,double)[100] ::", 8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),0.222231D));
		assertEquals("copySign(double,double)[101] ::", -8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),-0.0D));
		assertEquals("copySign(double,double)[102] ::", -8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),-1.0D));
		assertEquals("copySign(double,double)[103] ::", -8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),-0.222231D));
		assertEquals("copySign(double,double)[104] ::", 8.988465674311578E305, Math.copySign((Double.MAX_VALUE / 200),(Double.MAX_VALUE / 200)));
		assertEquals("copySign(double,double)[105] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,0.0D));
		assertEquals("copySign(double,double)[106] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,1.0D));
		assertEquals("copySign(double,double)[107] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,0.222231D));
		assertEquals("copySign(double,double)[108] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,-0.0D));
		assertEquals("copySign(double,double)[109] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,-1.0D));
		assertEquals("copySign(double,double)[110] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,-0.222231D));
		assertEquals("copySign(double,double)[111] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE,Double.MAX_VALUE));
		assertEquals("copySign(double,double)[112] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,0.0D));
		assertEquals("copySign(double,double)[113] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,1.0D));
		assertEquals("copySign(double,double)[114] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,0.222231D));
		assertEquals("copySign(double,double)[115] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,-0.0D));
		assertEquals("copySign(double,double)[116] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,-1.0D));
		assertEquals("copySign(double,double)[117] ::", -1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,-0.222231D));
		assertEquals("copySign(double,double)[118] ::", 1.7976931348623157E308, Math.copySign(Double.MAX_VALUE + 1,Double.MAX_VALUE + 1));
	}

	public void testCopySign_float()
	{
		assertEquals("copySign(float,float)[0] ::", 3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,0.0F));
		assertEquals("copySign(float,float)[1] ::", 3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,1.0F));
		assertEquals("copySign(float,float)[2] ::", 3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,0.222231F));
		assertEquals("copySign(float,float)[3] ::", -3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,-0.0F));
		assertEquals("copySign(float,float)[4] ::", -3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,-1.0F));
		assertEquals("copySign(float,float)[5] ::", -3.4028234663852886E38F, Math.copySign(-Float.MAX_VALUE,-0.222231F));
		assertEquals("copySign(float,float)[6] ::", -3.4028235E38F, Math.copySign(-Float.MAX_VALUE,-Float.MAX_VALUE));
		assertEquals("copySign(float,float)[7] ::", 1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),0.0F));
		assertEquals("copySign(float,float)[8] ::", 1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),1.0F));
		assertEquals("copySign(float,float)[9] ::", 1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),0.222231F));
		assertEquals("copySign(float,float)[10] ::", -1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),-0.0F));
		assertEquals("copySign(float,float)[11] ::", -1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),-1.0F));
		assertEquals("copySign(float,float)[12] ::", -1.7014117965751743E36F, Math.copySign((-Float.MAX_VALUE / 200),-0.222231F));
		assertEquals("copySign(float,float)[13] ::", -1.7014118E36F, Math.copySign((-Float.MAX_VALUE / 200),(-Float.MAX_VALUE / 200)));
		assertEquals("copySign(float,float)[14] ::", 6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),0.0F));
		assertEquals("copySign(float,float)[15] ::", 6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),1.0F));
		assertEquals("copySign(float,float)[16] ::", 6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),0.222231F));
		assertEquals("copySign(float,float)[17] ::", -6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),-0.0F));
		assertEquals("copySign(float,float)[18] ::", -6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),-1.0F));
		assertEquals("copySign(float,float)[19] ::", -6.805646869388047E35F, Math.copySign((-Float.MAX_VALUE / 500),-0.222231F));
		assertEquals("copySign(float,float)[20] ::", -6.805647E35F, Math.copySign((-Float.MAX_VALUE / 500),(-Float.MAX_VALUE / 500)));
		assertEquals("copySign(float,float)[21] ::", 2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),0.0F));
		assertEquals("copySign(float,float)[22] ::", 2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),1.0F));
		assertEquals("copySign(float,float)[23] ::", 2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),0.222231F));
		assertEquals("copySign(float,float)[24] ::", -2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),-0.0F));
		assertEquals("copySign(float,float)[25] ::", -2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),-1.0F));
		assertEquals("copySign(float,float)[26] ::", -2.802596928649634E-42F, Math.copySign((-Float.MIN_VALUE * 2000),-0.222231F));
		assertEquals("copySign(float,float)[27] ::", -2.803E-42F, Math.copySign((-Float.MIN_VALUE * 2000),(-Float.MIN_VALUE * 2000)));
		assertEquals("copySign(float,float)[28] ::", 1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),0.0F));
		assertEquals("copySign(float,float)[29] ::", 1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),1.0F));
		assertEquals("copySign(float,float)[30] ::", 1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),0.222231F));
		assertEquals("copySign(float,float)[31] ::", -1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),-0.0F));
		assertEquals("copySign(float,float)[32] ::", -1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),-1.0F));
		assertEquals("copySign(float,float)[33] ::", -1.401298464324817E-42F, Math.copySign((-Float.MIN_VALUE * 1000),-0.222231F));
		assertEquals("copySign(float,float)[34] ::", -1.401E-42F, Math.copySign((-Float.MIN_VALUE * 1000),(-Float.MIN_VALUE * 1000)));
		assertEquals("copySign(float,float)[35] ::", 3.2948748E7F, Math.copySign(-32948748.958324F,0.0F));
		assertEquals("copySign(float,float)[36] ::", 3.2948748E7F, Math.copySign(-32948748.958324F,1.0F));
		assertEquals("copySign(float,float)[37] ::", 3.2948748E7F, Math.copySign(-32948748.958324F,0.222231F));
		assertEquals("copySign(float,float)[38] ::", -3.2948748E7F, Math.copySign(-32948748.958324F,-0.0F));
		assertEquals("copySign(float,float)[39] ::", -3.2948748E7F, Math.copySign(-32948748.958324F,-1.0F));
		assertEquals("copySign(float,float)[40] ::", -3.2948748E7F, Math.copySign(-32948748.958324F,-0.222231F));
		assertEquals("copySign(float,float)[41] ::", -3.2948748E7F, Math.copySign(-32948748.958324F,-32948748.958324F));
		assertEquals("copySign(float,float)[42] ::", 8.99999985648492E-9F, Math.copySign(-0.000000009F,0.0F));
		assertEquals("copySign(float,float)[43] ::", 8.99999985648492E-9F, Math.copySign(-0.000000009F,1.0F));
		assertEquals("copySign(float,float)[44] ::", 8.99999985648492E-9F, Math.copySign(-0.000000009F,0.222231F));
		assertEquals("copySign(float,float)[45] ::", -8.99999985648492E-9F, Math.copySign(-0.000000009F,-0.0F));
		assertEquals("copySign(float,float)[46] ::", -8.99999985648492E-9F, Math.copySign(-0.000000009F,-1.0F));
		assertEquals("copySign(float,float)[47] ::", -8.99999985648492E-9F, Math.copySign(-0.000000009F,-0.222231F));
		assertEquals("copySign(float,float)[48] ::", -9.0E-9F, Math.copySign(-0.000000009F,-0.000000009F));
		assertEquals("copySign(float,float)[49] ::", 2.0000000233721948E-7F, Math.copySign(-0.0000002F,0.0F));
		assertEquals("copySign(float,float)[50] ::", 2.0000000233721948E-7F, Math.copySign(-0.0000002F,1.0F));
		assertEquals("copySign(float,float)[51] ::", 2.0000000233721948E-7F, Math.copySign(-0.0000002F,0.222231F));
		assertEquals("copySign(float,float)[52] ::", -2.0000000233721948E-7F, Math.copySign(-0.0000002F,-0.0F));
		assertEquals("copySign(float,float)[53] ::", -2.0000000233721948E-7F, Math.copySign(-0.0000002F,-1.0F));
		assertEquals("copySign(float,float)[54] ::", -2.0000000233721948E-7F, Math.copySign(-0.0000002F,-0.222231F));
		assertEquals("copySign(float,float)[55] ::", -2.0E-7F, Math.copySign(-0.0000002F,-0.0000002F));
		assertEquals("copySign(float,float)[56] ::", 0.0F, Math.copySign(0F,0.0F));
		assertEquals("copySign(float,float)[57] ::", 0.0F, Math.copySign(0F,1.0F));
		assertEquals("copySign(float,float)[58] ::", 0.0F, Math.copySign(0F,0.222231F));
		assertEquals("copySign(float,float)[59] ::", -0.0F, Math.copySign(0F,-0.0F));
		assertEquals("copySign(float,float)[60] ::", -0.0F, Math.copySign(0F,-1.0F));
		assertEquals("copySign(float,float)[61] ::", -0.0F, Math.copySign(0F,-0.222231F));
		assertEquals("copySign(float,float)[62] ::", 0.0F, Math.copySign(0F,0F));
		assertEquals("copySign(float,float)[63] ::", 0.45623233914375305F, Math.copySign(0.456232334F,0.0F));
		assertEquals("copySign(float,float)[64] ::", 0.45623233914375305F, Math.copySign(0.456232334F,1.0F));
		assertEquals("copySign(float,float)[65] ::", 0.45623233914375305F, Math.copySign(0.456232334F,0.222231F));
		assertEquals("copySign(float,float)[66] ::", -0.45623233914375305F, Math.copySign(0.456232334F,-0.0F));
		assertEquals("copySign(float,float)[67] ::", -0.45623233914375305F, Math.copySign(0.456232334F,-1.0F));
		assertEquals("copySign(float,float)[68] ::", -0.45623233914375305F, Math.copySign(0.456232334F,-0.222231F));
		assertEquals("copySign(float,float)[69] ::", 0.45623234F, Math.copySign(0.456232334F,0.456232334F));
		assertEquals("copySign(float,float)[70] ::", 1224257.25F, Math.copySign(1224257.312321263F,0.0F));
		assertEquals("copySign(float,float)[71] ::", 1224257.25F, Math.copySign(1224257.312321263F,1.0F));
		assertEquals("copySign(float,float)[72] ::", 1224257.25F, Math.copySign(1224257.312321263F,0.222231F));
		assertEquals("copySign(float,float)[73] ::", -1224257.25F, Math.copySign(1224257.312321263F,-0.0F));
		assertEquals("copySign(float,float)[74] ::", -1224257.25F, Math.copySign(1224257.312321263F,-1.0F));
		assertEquals("copySign(float,float)[75] ::", -1224257.25F, Math.copySign(1224257.312321263F,-0.222231F));
		assertEquals("copySign(float,float)[76] ::", 1224257.2F, Math.copySign(1224257.312321263F,1224257.312321263F));
		assertEquals("copySign(float,float)[77] ::", 9.999832064E9F, Math.copySign(9999832342.12365F,0.0F));
		assertEquals("copySign(float,float)[78] ::", 9.999832064E9F, Math.copySign(9999832342.12365F,1.0F));
		assertEquals("copySign(float,float)[79] ::", 9.999832064E9F, Math.copySign(9999832342.12365F,0.222231F));
		assertEquals("copySign(float,float)[80] ::", -9.999832064E9F, Math.copySign(9999832342.12365F,-0.0F));
		assertEquals("copySign(float,float)[81] ::", -9.999832064E9F, Math.copySign(9999832342.12365F,-1.0F));
		assertEquals("copySign(float,float)[82] ::", -9.999832064E9F, Math.copySign(9999832342.12365F,-0.222231F));
		assertEquals("copySign(float,float)[83] ::", 9.9998321E9F, Math.copySign(9999832342.12365F,9999832342.12365F));
		assertEquals("copySign(float,float)[84] ::", 1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,0.0F));
		assertEquals("copySign(float,float)[85] ::", 1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,1.0F));
		assertEquals("copySign(float,float)[86] ::", 1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,0.222231F));
		assertEquals("copySign(float,float)[87] ::", -1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,-0.0F));
		assertEquals("copySign(float,float)[88] ::", -1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,-1.0F));
		assertEquals("copySign(float,float)[89] ::", -1.401298464324817E-45F, Math.copySign(Float.MIN_VALUE,-0.222231F));
		assertEquals("copySign(float,float)[90] ::", 1.4E-45F, Math.copySign(Float.MIN_VALUE,Float.MIN_VALUE));
		assertEquals("copySign(float,float)[91] ::", 2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),0.0F));
		assertEquals("copySign(float,float)[92] ::", 2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),1.0F));
		assertEquals("copySign(float,float)[93] ::", 2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),0.222231F));
		assertEquals("copySign(float,float)[94] ::", -2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),-0.0F));
		assertEquals("copySign(float,float)[95] ::", -2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),-1.0F));
		assertEquals("copySign(float,float)[96] ::", -2.802596928649634E-43F, Math.copySign((Float.MIN_VALUE * 200),-0.222231F));
		assertEquals("copySign(float,float)[97] ::", 2.8E-43F, Math.copySign((Float.MIN_VALUE * 200),(Float.MIN_VALUE * 200)));
		assertEquals("copySign(float,float)[98] ::", 6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),0.0F));
		assertEquals("copySign(float,float)[99] ::", 6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),1.0F));
		assertEquals("copySign(float,float)[100] ::", 6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),0.222231F));
		assertEquals("copySign(float,float)[101] ::", -6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),-0.0F));
		assertEquals("copySign(float,float)[102] ::", -6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),-1.0F));
		assertEquals("copySign(float,float)[103] ::", -6.805646869388047E35F, Math.copySign((Float.MAX_VALUE / 500),-0.222231F));
		assertEquals("copySign(float,float)[104] ::", 6.805647E35F, Math.copySign((Float.MAX_VALUE / 500),(Float.MAX_VALUE / 500)));
		assertEquals("copySign(float,float)[105] ::", 1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),0.0F));
		assertEquals("copySign(float,float)[106] ::", 1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),1.0F));
		assertEquals("copySign(float,float)[107] ::", 1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),0.222231F));
		assertEquals("copySign(float,float)[108] ::", -1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),-0.0F));
		assertEquals("copySign(float,float)[109] ::", -1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),-1.0F));
		assertEquals("copySign(float,float)[110] ::", -1.7014117965751743E36F, Math.copySign((Float.MAX_VALUE / 200),-0.222231F));
		assertEquals("copySign(float,float)[111] ::", 1.7014118E36F, Math.copySign((Float.MAX_VALUE / 200),(Float.MAX_VALUE / 200)));
		assertEquals("copySign(float,float)[112] ::", 3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,0.0F));
		assertEquals("copySign(float,float)[113] ::", 3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,1.0F));
		assertEquals("copySign(float,float)[114] ::", 3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,0.222231F));
		assertEquals("copySign(float,float)[115] ::", -3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,-0.0F));
		assertEquals("copySign(float,float)[116] ::", -3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,-1.0F));
		assertEquals("copySign(float,float)[117] ::", -3.4028234663852886E38F, Math.copySign(Float.MAX_VALUE,-0.222231F));
		assertEquals("copySign(float,float)[118] ::", 3.4028235E38F, Math.copySign(Float.MAX_VALUE,Float.MAX_VALUE));
		assertEquals("copySign(float,float)[119] ::", 3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),0.0F));
		assertEquals("copySign(float,float)[120] ::", 3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),1.0F));
		assertEquals("copySign(float,float)[121] ::", 3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),0.222231F));
		assertEquals("copySign(float,float)[122] ::", -3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),-0.0F));
		assertEquals("copySign(float,float)[123] ::", -3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),-1.0F));
		assertEquals("copySign(float,float)[124] ::", -3.4028234663852886E38F, Math.copySign((Float.MAX_VALUE + 1),-0.222231F));
		assertEquals("copySign(float,float)[125] ::", 3.4028235E38F, Math.copySign((Float.MAX_VALUE + 1),(Float.MAX_VALUE + 1)));
	}

	public void testExp()
	{
		assertEquals("exp(double)[0] ::", 0.0, Math.exp(-Double.MAX_VALUE));
		assertEquals("exp(double)[1] ::", 0.0, Math.exp((-Double.MAX_VALUE / 200)));
		assertEquals("exp(double)[2] ::", 0.0, Math.exp((-Double.MAX_VALUE / 500)));
		assertEquals("exp(double)[3] ::", 1.0, Math.exp((-Double.MIN_VALUE * 2000)));
		assertEquals("exp(double)[4] ::", 1.0, Math.exp((-Double.MIN_VALUE * 1000)));
		assertEquals("exp(double)[5] ::", 0.0, Math.exp(-2929112212.129231481346));
		assertEquals("exp(double)[6] ::", 0.0, Math.exp(-2372.228212D));
		// At 20170906, IBM Java returns 0.29428694035725067, not 0.29428694035725067
		// assertEquals("exp(double)[7] ::", 0.2942869403572507, Math.exp(-1.2232D));
		assertEquals("exp(double)[8] ::", 1.0, Math.exp(0D));
		assertEquals("exp(double)[9] ::", 11.3842406513381, Math.exp(2.43223D));
		assertEquals("exp(double)[10] ::", Infinity, Math.exp(18232155.3323566D));
		assertEquals("exp(double)[11] ::", 1.0, Math.exp(Double.MIN_VALUE));
		assertEquals("exp(double)[12] ::", 1.0, Math.exp((Double.MIN_VALUE * 200)));
		assertEquals("exp(double)[13] ::", Infinity, Math.exp((Double.MAX_VALUE / 500)));
		assertEquals("exp(double)[14] ::", Infinity, Math.exp((Double.MAX_VALUE / 200)));
		assertEquals("exp(double)[15] ::", Infinity, Math.exp(Double.MAX_VALUE));
		assertEquals("exp(double)[16] ::", Infinity, Math.exp(Double.MAX_VALUE + 1));
	}

	public void testExpm1()
	{
		assertEquals("expm1(double)[0] ::", -1.0, Math.expm1(-Double.MAX_VALUE));
		assertEquals("expm1(double)[1] ::", -1.0, Math.expm1((-Double.MAX_VALUE / 200)));
		assertEquals("expm1(double)[2] ::", -1.0, Math.expm1((-Double.MAX_VALUE / 500)));
		assertEquals("expm1(double)[3] ::", -9.88E-321, Math.expm1((-Double.MIN_VALUE * 2000)));
		assertEquals("expm1(double)[4] ::", -4.94E-321, Math.expm1((-Double.MIN_VALUE * 1000)));
		assertEquals("expm1(double)[5] ::", -1.0, Math.expm1(-2929112212.129231481346));
		assertEquals("expm1(double)[6] ::", -1.0, Math.expm1(-2372.228212D));
		assertEquals("expm1(double)[7] ::", -0.7057130596427493, Math.expm1(-1.2232D));
		assertEquals("expm1(double)[8] ::", 0.0, Math.expm1(0D));
		assertEquals("expm1(double)[9] ::", 10.3842406513381, Math.expm1(2.43223D));
		assertEquals("expm1(double)[10] ::", Infinity, Math.expm1(18232155.3323566D));
		assertEquals("expm1(double)[11] ::", 4.9E-324, Math.expm1(Double.MIN_VALUE));
		assertEquals("expm1(double)[12] ::", 9.9E-322, Math.expm1((Double.MIN_VALUE * 200)));
		assertEquals("expm1(double)[13] ::", Infinity, Math.expm1((Double.MAX_VALUE / 500)));
		assertEquals("expm1(double)[14] ::", Infinity, Math.expm1((Double.MAX_VALUE / 200)));
		assertEquals("expm1(double)[15] ::", Infinity, Math.expm1(Double.MAX_VALUE));
		assertEquals("expm1(double)[16] ::", Infinity, Math.expm1(Double.MAX_VALUE + 1));
	}

	public void testFloor()
	{
		assertEquals("floor(double)[0] ::", -1.7976931348623157E308, Math.floor(-Double.MAX_VALUE));
		assertEquals("floor(double)[1] ::", -8.988465674311578E305, Math.floor((-Double.MAX_VALUE / 200)));
		assertEquals("floor(double)[2] ::", -3.595386269724631E305, Math.floor((-Double.MAX_VALUE / 500)));
		assertEquals("floor(double)[3] ::", -1.0, Math.floor((-Double.MIN_VALUE * 2000)));
		assertEquals("floor(double)[4] ::", -1.0, Math.floor((-Double.MIN_VALUE * 1000)));
		assertEquals("floor(double)[5] ::", -2.929112213E9, Math.floor(-2929112212.129231481346));
		assertEquals("floor(double)[6] ::", -2373.0, Math.floor(-2372.228212D));
		assertEquals("floor(double)[7] ::", -2.0, Math.floor(-1.2232D));
		assertEquals("floor(double)[8] ::", 0.0, Math.floor(0D));
		assertEquals("floor(double)[9] ::", 2.0, Math.floor(2.43223D));
		assertEquals("floor(double)[10] ::", 1.8232155E7, Math.floor(18232155.3323566D));
		assertEquals("floor(double)[11] ::", 0.0, Math.floor(Double.MIN_VALUE));
		assertEquals("floor(double)[12] ::", 0.0, Math.floor((Double.MIN_VALUE * 200)));
		assertEquals("floor(double)[13] ::", 3.595386269724631E305, Math.floor((Double.MAX_VALUE / 500)));
		assertEquals("floor(double)[14] ::", 8.988465674311578E305, Math.floor((Double.MAX_VALUE / 200)));
		assertEquals("floor(double)[15] ::", 1.7976931348623157E308, Math.floor(Double.MAX_VALUE));
		assertEquals("floor(double)[16] ::", 1.7976931348623157E308, Math.floor(Double.MAX_VALUE + 1));
	}

	public void testGetExponent_double()
	{
		assertEquals("getExponent(double)[0] ::", 1023, Math.getExponent(-Double.MAX_VALUE));
		assertEquals("getExponent(double)[1] ::", 1016, Math.getExponent((-Double.MAX_VALUE / 200)));
		assertEquals("getExponent(double)[2] ::", 1015, Math.getExponent((-Double.MAX_VALUE / 500)));
		assertEquals("getExponent(double)[3] ::", -1023, Math.getExponent((-Double.MIN_VALUE * 2000)));
		assertEquals("getExponent(double)[4] ::", -1023, Math.getExponent((-Double.MIN_VALUE * 1000)));
		assertEquals("getExponent(double)[5] ::", 31, Math.getExponent(-2929112212.129231481346));
		assertEquals("getExponent(double)[6] ::", 11, Math.getExponent(-2372.228212D));
		assertEquals("getExponent(double)[7] ::", 0, Math.getExponent(-1.2232D));
		assertEquals("getExponent(double)[8] ::", -1023, Math.getExponent(0D));
		assertEquals("getExponent(double)[9] ::", 1, Math.getExponent(2.43223D));
		assertEquals("getExponent(double)[10] ::", 24, Math.getExponent(18232155.3323566D));
		assertEquals("getExponent(double)[11] ::", -1023, Math.getExponent(Double.MIN_VALUE));
		assertEquals("getExponent(double)[12] ::", -1023, Math.getExponent((Double.MIN_VALUE * 200)));
		assertEquals("getExponent(double)[13] ::", 1015, Math.getExponent((Double.MAX_VALUE / 500)));
		assertEquals("getExponent(double)[14] ::", 1016, Math.getExponent((Double.MAX_VALUE / 200)));
		assertEquals("getExponent(double)[15] ::", 1023, Math.getExponent(Double.MAX_VALUE));
		assertEquals("getExponent(double)[16] ::", 1023, Math.getExponent(Double.MAX_VALUE + 1));
	}

	public void testGetExponent_float()
	{
		assertEquals("getExponent(float)[0] ::", 127, Math.getExponent(-Float.MAX_VALUE));
		assertEquals("getExponent(float)[1] ::", 120, Math.getExponent((-Float.MAX_VALUE / 200)));
		assertEquals("getExponent(float)[2] ::", 119, Math.getExponent((-Float.MAX_VALUE / 500)));
		assertEquals("getExponent(float)[3] ::", -127, Math.getExponent((-Float.MIN_VALUE * 2000)));
		assertEquals("getExponent(float)[4] ::", -127, Math.getExponent((-Float.MIN_VALUE * 1000)));
		assertEquals("getExponent(float)[5] ::", 24, Math.getExponent(-32948748.958324F));
		assertEquals("getExponent(float)[6] ::", -27, Math.getExponent(-0.000000009F));
		assertEquals("getExponent(float)[7] ::", -23, Math.getExponent(-0.0000002F));
		assertEquals("getExponent(float)[8] ::", -127, Math.getExponent(0F));
		assertEquals("getExponent(float)[9] ::", -2, Math.getExponent(0.456232334F));
		assertEquals("getExponent(float)[10] ::", 20, Math.getExponent(1224257.312321263F));
		assertEquals("getExponent(float)[11] ::", 33, Math.getExponent(9999832342.12365F));
		assertEquals("getExponent(float)[12] ::", -127, Math.getExponent(Float.MIN_VALUE));
		assertEquals("getExponent(float)[13] ::", -127, Math.getExponent((Float.MIN_VALUE * 200)));
		assertEquals("getExponent(float)[14] ::", 119, Math.getExponent((Float.MAX_VALUE / 500)));
		assertEquals("getExponent(float)[15] ::", 120, Math.getExponent((Float.MAX_VALUE / 200)));
		assertEquals("getExponent(float)[16] ::", 127, Math.getExponent(Float.MAX_VALUE));
		assertEquals("getExponent(float)[17] ::", 127, Math.getExponent((Float.MAX_VALUE + 1)));
	}

	public void testHypot()
	{
		assertEquals("hypot(double,double)[0] ::", Infinity, Math.hypot(-Double.MAX_VALUE,(-Double.MAX_VALUE / 200)));
		assertEquals("hypot(double,double)[1] ::", 9.680873803887843E305, Math.hypot((-Double.MAX_VALUE / 200),(-Double.MAX_VALUE / 500)));
		assertEquals("hypot(double,double)[2] ::", 3.595386269724631E305, Math.hypot((-Double.MAX_VALUE / 500),(-Double.MIN_VALUE * 2000)));
		assertEquals("hypot(double,double)[3] ::", 1.1047E-320, Math.hypot((-Double.MIN_VALUE * 2000),(-Double.MIN_VALUE * 1000)));
		assertEquals("hypot(double,double)[4] ::", 2.9291122121292315E9, Math.hypot((-Double.MIN_VALUE * 1000),-2929112212.129231481346));
		assertEquals("hypot(double,double)[5] ::", 2.9291122121301923E9, Math.hypot(-2929112212.129231481346,-2372.228212D));
		assertEquals("hypot(double,double)[6] ::", 2372.228527361341, Math.hypot(-2372.228212D,-1.2232D));
		assertEquals("hypot(double,double)[7] ::", 1.2232, Math.hypot(-1.2232D,0D));
		assertEquals("hypot(double,double)[8] ::", 2.43223, Math.hypot(0D,2.43223D));
		assertEquals("hypot(double,double)[9] ::", 1.8232155332356762E7, Math.hypot(2.43223D,18232155.3323566D));
		assertEquals("hypot(double,double)[10] ::", 1.82321553323566E7, Math.hypot(18232155.3323566D,Double.MIN_VALUE));
		assertEquals("hypot(double,double)[11] ::", 9.9E-322, Math.hypot(Double.MIN_VALUE,(Double.MIN_VALUE * 200)));
		assertEquals("hypot(double,double)[12] ::", 3.595386269724631E305, Math.hypot((Double.MIN_VALUE * 200),(Double.MAX_VALUE / 500)));
		assertEquals("hypot(double,double)[13] ::", 9.680873803887843E305, Math.hypot((Double.MAX_VALUE / 500),(Double.MAX_VALUE / 200)));
		assertEquals("hypot(double,double)[14] ::", Infinity, Math.hypot((Double.MAX_VALUE / 200),Double.MAX_VALUE));
		assertEquals("hypot(double,double)[15] ::", Infinity, Math.hypot(Double.MAX_VALUE,Double.MAX_VALUE + 1));
	}

	public void testIEEEremainder()
	{
		assertEquals("IEEEremainder(double,double)[0] ::", -7.484401160755199E291, Math.IEEEremainder(-Double.MAX_VALUE,(-Double.MAX_VALUE / 200)));
		assertEquals("IEEEremainder(double,double)[1] ::", 1.797693134862315E305, Math.IEEEremainder((-Double.MAX_VALUE / 200),(-Double.MAX_VALUE / 500)));
		assertEquals("IEEEremainder(double,double)[2] ::", 1.66E-321, Math.IEEEremainder((-Double.MAX_VALUE / 500),(-Double.MIN_VALUE * 2000)));
		assertEquals("IEEEremainder(double,double)[3] ::", -0.0, Math.IEEEremainder((-Double.MIN_VALUE * 2000),(-Double.MIN_VALUE * 1000)));
		assertEquals("IEEEremainder(double,double)[4] ::", -4.94E-321, Math.IEEEremainder((-Double.MIN_VALUE * 1000),-2929112212.129231481346));
		assertEquals("IEEEremainder(double,double)[5] ::", -1055.1340194714849, Math.IEEEremainder(-2929112212.129231481346,-2372.228212D));
		assertEquals("IEEEremainder(double,double)[6] ::", -0.4434119999998589, Math.IEEEremainder(-2372.228212D,-1.2232D));
		assertEquals("IEEEremainder(double,double)[7] ::", 0.0, Math.IEEEremainder(0D,2.43223D));
		assertEquals("IEEEremainder(double,double)[8] ::", 2.43223, Math.IEEEremainder(2.43223D,18232155.3323566D));
		assertEquals("IEEEremainder(double,double)[9] ::", 0.0, Math.IEEEremainder(18232155.3323566D,Double.MIN_VALUE));
		assertEquals("IEEEremainder(double,double)[10] ::", 4.9E-324, Math.IEEEremainder(Double.MIN_VALUE,(Double.MIN_VALUE * 200)));
		assertEquals("IEEEremainder(double,double)[11] ::", 9.9E-322, Math.IEEEremainder((Double.MIN_VALUE * 200),(Double.MAX_VALUE / 500)));
		assertEquals("IEEEremainder(double,double)[12] ::", 3.595386269724631E305, Math.IEEEremainder((Double.MAX_VALUE / 500),(Double.MAX_VALUE / 200)));
		assertEquals("IEEEremainder(double,double)[13] ::", 8.988465674311578E305, Math.IEEEremainder((Double.MAX_VALUE / 200),Double.MAX_VALUE));
		assertEquals("IEEEremainder(double,double)[14] ::", 0.0, Math.IEEEremainder(Double.MAX_VALUE,Double.MAX_VALUE + 1));
	}

	public void testLog()
	{
		assertEquals("log(double)[0] ::", 0.8888085320006571, Math.log(2.43223D));
		assertEquals("log(double)[1] ::", 16.718697369636427, Math.log(18232155.3323566D));
		assertEquals("log(double)[2] ::", -744.4400719213812, Math.log(Double.MIN_VALUE));
		assertEquals("log(double)[3] ::", -739.1417545548333, Math.log((Double.MIN_VALUE * 200)));
		assertEquals("log(double)[4] ::", 703.5681047949618, Math.log((Double.MAX_VALUE / 500)));
		assertEquals("log(double)[5] ::", 704.484395526836, Math.log((Double.MAX_VALUE / 200)));
		assertEquals("log(double)[6] ::", 709.782712893384, Math.log(Double.MAX_VALUE));
		assertEquals("log(double)[7] ::", 709.782712893384, Math.log(Double.MAX_VALUE + 1));
	}

	public void testLog10()
	{
		assertEquals("log10(double)[0] ::", 0.38600464091641523, Math.log10(2.43223D));
		assertEquals("log10(double)[1] ::", 7.260838012243511, Math.log10(18232155.3323566D));
		assertEquals("log10(double)[2] ::", -323.3062153431158, Math.log10(Double.MIN_VALUE));
		assertEquals("log10(double)[3] ::", -321.0051853474518, Math.log10((Double.MIN_VALUE * 200)));
		assertEquals("log10(double)[4] ::", 305.5557455555807, Math.log10((Double.MAX_VALUE / 500)));
		assertEquals("log10(double)[5] ::", 305.95368556425274, Math.log10((Double.MAX_VALUE / 200)));
		assertEquals("log10(double)[6] ::", 308.25471555991675, Math.log10(Double.MAX_VALUE));
		assertEquals("log10(double)[7] ::", 308.25471555991675, Math.log10(Double.MAX_VALUE + 1));
	}

	public void testLog1p()
	{
		assertEquals("log1p(double)[0] ::", -9.88E-321, Math.log1p((-Double.MIN_VALUE * 2000)));
		assertEquals("log1p(double)[1] ::", -4.94E-321, Math.log1p((-Double.MIN_VALUE * 1000)));
		assertEquals("log1p(double)[2] ::", 0.0, Math.log1p(0D));
		assertEquals("log1p(double)[3] ::", 1.2332101956972392, Math.log1p(2.43223D));
		assertEquals("log1p(double)[4] ::", 16.718697424484574, Math.log1p(18232155.3323566D));
		assertEquals("log1p(double)[5] ::", 4.9E-324, Math.log1p(Double.MIN_VALUE));
		assertEquals("log1p(double)[6] ::", 9.9E-322, Math.log1p((Double.MIN_VALUE * 200)));
		assertEquals("log1p(double)[7] ::", 703.5681047949618, Math.log1p((Double.MAX_VALUE / 500)));
		assertEquals("log1p(double)[8] ::", 704.484395526836, Math.log1p((Double.MAX_VALUE / 200)));
		assertEquals("log1p(double)[9] ::", 709.782712893384, Math.log1p(Double.MAX_VALUE));
		assertEquals("log1p(double)[10] ::", 709.782712893384, Math.log1p(Double.MAX_VALUE + 1));
	}

	public void testMax_double()
	{
		assertEquals("max(double)[0] ::", -8.988465674311578E305d, Math.max(-1.7976931348623157E308d,-8.988465674311578E305d));
		assertEquals("max(double)[1] ::", -8.988465674311578E305d, Math.max(-8.988465674311578E305d,-1.7976931348623157E308d));
		assertEquals("max(double)[2] ::", -8.988465674311578E305d, Math.max(-1.7976931348623157E308d,-8.988465674311578E305d));
		assertEquals("max(double)[3] ::", -8.988465674311578E305d, Math.max(-8.988465674311578E305d,-8.988465674311578E305d));
		assertEquals("max(double)[4] ::", -3.595386269724631E305d, Math.max(-8.988465674311578E305d,-3.595386269724631E305d));
		assertEquals("max(double)[5] ::", -3.595386269724631E305d, Math.max(-3.595386269724631E305d,-8.988465674311578E305d));
		assertEquals("max(double)[6] ::", -3.595386269724631E305d, Math.max(-8.988465674311578E305d,-3.595386269724631E305d));
		assertEquals("max(double)[7] ::", -3.595386269724631E305d, Math.max(-3.595386269724631E305d,-3.595386269724631E305d));
		assertEquals("max(double)[8] ::", -9.88E-321d, Math.max(-3.595386269724631E305d,-9.88E-321d));
		assertEquals("max(double)[9] ::", -9.88E-321d, Math.max(-9.88E-321d,-3.595386269724631E305d));
		assertEquals("max(double)[10] ::", -9.88E-321d, Math.max(-3.595386269724631E305d,-9.88E-321d));
		assertEquals("max(double)[11] ::", -9.88E-321d, Math.max(-9.88E-321d,-9.88E-321d));
		assertEquals("max(double)[12] ::", -4.94E-321d, Math.max(-9.88E-321d,-4.94E-321d));
		assertEquals("max(double)[13] ::", -4.94E-321d, Math.max(-4.94E-321d,-9.88E-321d));
		assertEquals("max(double)[14] ::", -4.94E-321d, Math.max(-9.88E-321d,-4.94E-321d));
		assertEquals("max(double)[15] ::", -4.94E-321d, Math.max(-4.94E-321d,-4.94E-321d));
		assertEquals("max(double)[16] ::", -4.94E-321d, Math.max(-4.94E-321d,-2.9291122121292315E9d));
		assertEquals("max(double)[17] ::", -4.94E-321d, Math.max(-2.9291122121292315E9d,-4.94E-321d));
		assertEquals("max(double)[18] ::", -4.94E-321d, Math.max(-4.94E-321d,-4.94E-321d));
		assertEquals("max(double)[19] ::", -4.94E-321d, Math.max(-2.9291122121292315E9d,-4.94E-321d));
		assertEquals("max(double)[20] ::", -2372.228212d, Math.max(-2.9291122121292315E9d,-2372.228212d));
		assertEquals("max(double)[21] ::", -2372.228212d, Math.max(-2372.228212d,-2.9291122121292315E9d));
		assertEquals("max(double)[22] ::", -2372.228212d, Math.max(-2.9291122121292315E9d,-2372.228212d));
		assertEquals("max(double)[23] ::", -2372.228212d, Math.max(-2372.228212d,-2372.228212d));
		assertEquals("max(double)[24] ::", -1.2232d, Math.max(-2372.228212d,-1.2232d));
		assertEquals("max(double)[25] ::", -1.2232d, Math.max(-1.2232d,-2372.228212d));
		assertEquals("max(double)[26] ::", -1.2232d, Math.max(-2372.228212d,-1.2232d));
		assertEquals("max(double)[27] ::", -1.2232d, Math.max(-1.2232d,-1.2232d));
		assertEquals("max(double)[28] ::", 0.0d, Math.max(-1.2232d,0.0d));
		assertEquals("max(double)[29] ::", 0.0d, Math.max(0.0d,-1.2232d));
		assertEquals("max(double)[30] ::", 0.0d, Math.max(-1.2232d,0.0d));
		assertEquals("max(double)[31] ::", 0.0d, Math.max(0.0d,0.0d));
		assertEquals("max(double)[32] ::", 2.43223d, Math.max(0.0d,2.43223d));
		assertEquals("max(double)[33] ::", 2.43223d, Math.max(2.43223d,0.0d));
		assertEquals("max(double)[34] ::", 2.43223d, Math.max(0.0d,2.43223d));
		assertEquals("max(double)[35] ::", 2.43223d, Math.max(2.43223d,2.43223d));
		assertEquals("max(double)[36] ::", 1.82321553323566E7d, Math.max(2.43223d,1.82321553323566E7d));
		assertEquals("max(double)[37] ::", 1.82321553323566E7d, Math.max(1.82321553323566E7d,2.43223d));
		assertEquals("max(double)[38] ::", 1.82321553323566E7d, Math.max(2.43223d,1.82321553323566E7d));
		assertEquals("max(double)[39] ::", 1.82321553323566E7d, Math.max(1.82321553323566E7d,1.82321553323566E7d));
		assertEquals("max(double)[40] ::", 1.82321553323566E7d, Math.max(1.82321553323566E7d,4.9E-324d));
		assertEquals("max(double)[41] ::", 1.82321553323566E7d, Math.max(4.9E-324d,1.82321553323566E7d));
		assertEquals("max(double)[42] ::", 1.82321553323566E7d, Math.max(1.82321553323566E7d,1.82321553323566E7d));
		assertEquals("max(double)[43] ::", 1.82321553323566E7d, Math.max(4.9E-324d,1.82321553323566E7d));
		assertEquals("max(double)[44] ::", 9.9E-322d, Math.max(4.9E-324d,9.9E-322d));
		assertEquals("max(double)[45] ::", 9.9E-322d, Math.max(9.9E-322d,4.9E-324d));
		assertEquals("max(double)[46] ::", 9.9E-322d, Math.max(4.9E-324d,9.9E-322d));
		assertEquals("max(double)[47] ::", 9.9E-322d, Math.max(9.9E-322d,9.9E-322d));
		assertEquals("max(double)[48] ::", 3.595386269724631E305d, Math.max(9.9E-322d,3.595386269724631E305d));
		assertEquals("max(double)[49] ::", 3.595386269724631E305d, Math.max(3.595386269724631E305d,9.9E-322d));
		assertEquals("max(double)[50] ::", 3.595386269724631E305d, Math.max(9.9E-322d,3.595386269724631E305d));
		assertEquals("max(double)[51] ::", 3.595386269724631E305d, Math.max(3.595386269724631E305d,3.595386269724631E305d));
		assertEquals("max(double)[52] ::", 8.988465674311578E305d, Math.max(3.595386269724631E305d,8.988465674311578E305d));
		assertEquals("max(double)[53] ::", 8.988465674311578E305d, Math.max(8.988465674311578E305d,3.595386269724631E305d));
		assertEquals("max(double)[54] ::", 8.988465674311578E305d, Math.max(3.595386269724631E305d,8.988465674311578E305d));
		assertEquals("max(double)[55] ::", 8.988465674311578E305d, Math.max(8.988465674311578E305d,8.988465674311578E305d));
		assertEquals("max(double)[56] ::", 1.7976931348623157E308d, Math.max(8.988465674311578E305d,1.7976931348623157E308d));
		assertEquals("max(double)[57] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,8.988465674311578E305d));
		assertEquals("max(double)[58] ::", 1.7976931348623157E308d, Math.max(8.988465674311578E305d,1.7976931348623157E308d));
		assertEquals("max(double)[59] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("max(double)[60] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("max(double)[61] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("max(double)[62] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("max(double)[63] ::", 1.7976931348623157E308d, Math.max(1.7976931348623157E308d,1.7976931348623157E308d));
	}

	public void testMax_float()
	{
		assertEquals("max(float)[0] ::", -1.7014118E36f, Math.max(-3.4028235E38f,-1.7014118E36f));
		assertEquals("max(float)[1] ::", -1.7014118E36f, Math.max(-1.7014118E36f,-3.4028235E38f));
		assertEquals("max(float)[2] ::", -1.7014118E36f, Math.max(-3.4028235E38f,-1.7014118E36f));
		assertEquals("max(float)[3] ::", -1.7014118E36f, Math.max(-1.7014118E36f,-1.7014118E36f));
		assertEquals("max(float)[4] ::", -6.805647E35f, Math.max(-1.7014118E36f,-6.805647E35f));
		assertEquals("max(float)[5] ::", -6.805647E35f, Math.max(-6.805647E35f,-1.7014118E36f));
		assertEquals("max(float)[6] ::", -6.805647E35f, Math.max(-1.7014118E36f,-6.805647E35f));
		assertEquals("max(float)[7] ::", -6.805647E35f, Math.max(-6.805647E35f,-6.805647E35f));
		assertEquals("max(float)[8] ::", -2.803E-42f, Math.max(-6.805647E35f,-2.803E-42f));
		assertEquals("max(float)[9] ::", -2.803E-42f, Math.max(-2.803E-42f,-6.805647E35f));
		assertEquals("max(float)[10] ::", -2.803E-42f, Math.max(-6.805647E35f,-2.803E-42f));
		assertEquals("max(float)[11] ::", -2.803E-42f, Math.max(-2.803E-42f,-2.803E-42f));
		assertEquals("max(float)[12] ::", -1.401E-42f, Math.max(-2.803E-42f,-1.401E-42f));
		assertEquals("max(float)[13] ::", -1.401E-42f, Math.max(-1.401E-42f,-2.803E-42f));
		assertEquals("max(float)[14] ::", -1.401E-42f, Math.max(-2.803E-42f,-1.401E-42f));
		assertEquals("max(float)[15] ::", -1.401E-42f, Math.max(-1.401E-42f,-1.401E-42f));
		assertEquals("max(float)[16] ::", -1.401E-42f, Math.max(-1.401E-42f,-3.2948748E7f));
		assertEquals("max(float)[17] ::", -1.401E-42f, Math.max(-3.2948748E7f,-1.401E-42f));
		assertEquals("max(float)[18] ::", -1.401E-42f, Math.max(-1.401E-42f,-1.401E-42f));
		assertEquals("max(float)[19] ::", -1.401E-42f, Math.max(-3.2948748E7f,-1.401E-42f));
		assertEquals("max(float)[20] ::", -9.0E-9f, Math.max(-3.2948748E7f,-9.0E-9f));
		assertEquals("max(float)[21] ::", -9.0E-9f, Math.max(-9.0E-9f,-3.2948748E7f));
		assertEquals("max(float)[22] ::", -9.0E-9f, Math.max(-3.2948748E7f,-9.0E-9f));
		assertEquals("max(float)[23] ::", -9.0E-9f, Math.max(-9.0E-9f,-9.0E-9f));
		assertEquals("max(float)[24] ::", -9.0E-9f, Math.max(-9.0E-9f,-2.0E-7f));
		assertEquals("max(float)[25] ::", -9.0E-9f, Math.max(-2.0E-7f,-9.0E-9f));
		assertEquals("max(float)[26] ::", -9.0E-9f, Math.max(-9.0E-9f,-9.0E-9f));
		assertEquals("max(float)[27] ::", -9.0E-9f, Math.max(-2.0E-7f,-9.0E-9f));
		assertEquals("max(float)[28] ::", 0.0f, Math.max(-2.0E-7f,0.0f));
		assertEquals("max(float)[29] ::", 0.0f, Math.max(0.0f,-2.0E-7f));
		assertEquals("max(float)[30] ::", 0.0f, Math.max(-2.0E-7f,0.0f));
		assertEquals("max(float)[31] ::", 0.0f, Math.max(0.0f,0.0f));
		assertEquals("max(float)[32] ::", 0.45623234f, Math.max(0.0f,0.45623234f));
		assertEquals("max(float)[33] ::", 0.45623234f, Math.max(0.45623234f,0.0f));
		assertEquals("max(float)[34] ::", 0.45623234f, Math.max(0.0f,0.45623234f));
		assertEquals("max(float)[35] ::", 0.45623234f, Math.max(0.45623234f,0.45623234f));
		assertEquals("max(float)[36] ::", 1224257.2f, Math.max(0.45623234f,1224257.2f));
		assertEquals("max(float)[37] ::", 1224257.2f, Math.max(1224257.2f,0.45623234f));
		assertEquals("max(float)[38] ::", 1224257.2f, Math.max(0.45623234f,1224257.2f));
		assertEquals("max(float)[39] ::", 1224257.2f, Math.max(1224257.2f,1224257.2f));
		assertEquals("max(float)[40] ::", 9.9998321E9f, Math.max(1224257.2f,9.9998321E9f));
		assertEquals("max(float)[41] ::", 9.9998321E9f, Math.max(9.9998321E9f,1224257.2f));
		assertEquals("max(float)[42] ::", 9.9998321E9f, Math.max(1224257.2f,9.9998321E9f));
		assertEquals("max(float)[43] ::", 9.9998321E9f, Math.max(9.9998321E9f,9.9998321E9f));
		assertEquals("max(float)[44] ::", 9.9998321E9f, Math.max(9.9998321E9f,1.4E-45f));
		assertEquals("max(float)[45] ::", 9.9998321E9f, Math.max(1.4E-45f,9.9998321E9f));
		assertEquals("max(float)[46] ::", 9.9998321E9f, Math.max(9.9998321E9f,9.9998321E9f));
		assertEquals("max(float)[47] ::", 9.9998321E9f, Math.max(1.4E-45f,9.9998321E9f));
		assertEquals("max(float)[48] ::", 2.8E-43f, Math.max(1.4E-45f,2.8E-43f));
		assertEquals("max(float)[49] ::", 2.8E-43f, Math.max(2.8E-43f,1.4E-45f));
		assertEquals("max(float)[50] ::", 2.8E-43f, Math.max(1.4E-45f,2.8E-43f));
		assertEquals("max(float)[51] ::", 2.8E-43f, Math.max(2.8E-43f,2.8E-43f));
		assertEquals("max(float)[52] ::", 6.805647E35f, Math.max(2.8E-43f,6.805647E35f));
		assertEquals("max(float)[53] ::", 6.805647E35f, Math.max(6.805647E35f,2.8E-43f));
		assertEquals("max(float)[54] ::", 6.805647E35f, Math.max(2.8E-43f,6.805647E35f));
		assertEquals("max(float)[55] ::", 6.805647E35f, Math.max(6.805647E35f,6.805647E35f));
		assertEquals("max(float)[56] ::", 1.7014118E36f, Math.max(6.805647E35f,1.7014118E36f));
		assertEquals("max(float)[57] ::", 1.7014118E36f, Math.max(1.7014118E36f,6.805647E35f));
		assertEquals("max(float)[58] ::", 1.7014118E36f, Math.max(6.805647E35f,1.7014118E36f));
		assertEquals("max(float)[59] ::", 1.7014118E36f, Math.max(1.7014118E36f,1.7014118E36f));
		assertEquals("max(float)[60] ::", 3.4028235E38f, Math.max(1.7014118E36f,3.4028235E38f));
		assertEquals("max(float)[61] ::", 3.4028235E38f, Math.max(3.4028235E38f,1.7014118E36f));
		assertEquals("max(float)[62] ::", 3.4028235E38f, Math.max(1.7014118E36f,3.4028235E38f));
		assertEquals("max(float)[63] ::", 3.4028235E38f, Math.max(3.4028235E38f,3.4028235E38f));
		assertEquals("max(float)[64] ::", 3.4028235E38f, Math.max(3.4028235E38f,3.4028235E38f));
		assertEquals("max(float)[65] ::", 3.4028235E38f, Math.max(3.4028235E38f,3.4028235E38f));
		assertEquals("max(float)[66] ::", 3.4028235E38f, Math.max(3.4028235E38f,3.4028235E38f));
		assertEquals("max(float)[67] ::", 3.4028235E38f, Math.max(3.4028235E38f,3.4028235E38f));
	}

	public void testMax_long()
	{
		assertEquals("max(long)[0] ::", -9223372036854775807l, Math.max(-9223372036854775808l,-9223372036854775807l));
		assertEquals("max(long)[1] ::", -9223372036854775807l, Math.max(-9223372036854775807l,-9223372036854775808l));
		assertEquals("max(long)[2] ::", -9223372036854775807l, Math.max(-9223372036854775808l,-9223372036854775807l));
		assertEquals("max(long)[3] ::", -9223372036854775807l, Math.max(-9223372036854775807l,-9223372036854775807l));
		assertEquals("max(long)[4] ::", -9223372036854775806l, Math.max(-9223372036854775807l,-9223372036854775806l));
		assertEquals("max(long)[5] ::", -9223372036854775806l, Math.max(-9223372036854775806l,-9223372036854775807l));
		assertEquals("max(long)[6] ::", -9223372036854775806l, Math.max(-9223372036854775807l,-9223372036854775806l));
		assertEquals("max(long)[7] ::", -9223372036854775806l, Math.max(-9223372036854775806l,-9223372036854775806l));
		assertEquals("max(long)[8] ::", -332342l, Math.max(-9223372036854775806l,-332342l));
		assertEquals("max(long)[9] ::", -332342l, Math.max(-332342l,-9223372036854775806l));
		assertEquals("max(long)[10] ::", -332342l, Math.max(-9223372036854775806l,-332342l));
		assertEquals("max(long)[11] ::", -332342l, Math.max(-332342l,-332342l));
		assertEquals("max(long)[12] ::", -2l, Math.max(-332342l,-2l));
		assertEquals("max(long)[13] ::", -2l, Math.max(-2l,-332342l));
		assertEquals("max(long)[14] ::", -2l, Math.max(-332342l,-2l));
		assertEquals("max(long)[15] ::", -2l, Math.max(-2l,-2l));
		assertEquals("max(long)[16] ::", -1l, Math.max(-2l,-1l));
		assertEquals("max(long)[17] ::", -1l, Math.max(-1l,-2l));
		assertEquals("max(long)[18] ::", -1l, Math.max(-2l,-1l));
		assertEquals("max(long)[19] ::", -1l, Math.max(-1l,-1l));
		assertEquals("max(long)[20] ::", 0l, Math.max(-1l,0l));
		assertEquals("max(long)[21] ::", 0l, Math.max(0l,-1l));
		assertEquals("max(long)[22] ::", 0l, Math.max(-1l,0l));
		assertEquals("max(long)[23] ::", 0l, Math.max(0l,0l));
		assertEquals("max(long)[24] ::", 1l, Math.max(0l,1l));
		assertEquals("max(long)[25] ::", 1l, Math.max(1l,0l));
		assertEquals("max(long)[26] ::", 1l, Math.max(0l,1l));
		assertEquals("max(long)[27] ::", 1l, Math.max(1l,1l));
		assertEquals("max(long)[28] ::", 2l, Math.max(1l,2l));
		assertEquals("max(long)[29] ::", 2l, Math.max(2l,1l));
		assertEquals("max(long)[30] ::", 2l, Math.max(1l,2l));
		assertEquals("max(long)[31] ::", 2l, Math.max(2l,2l));
		assertEquals("max(long)[32] ::", 348238234234l, Math.max(2l,348238234234l));
		assertEquals("max(long)[33] ::", 348238234234l, Math.max(348238234234l,2l));
		assertEquals("max(long)[34] ::", 348238234234l, Math.max(2l,348238234234l));
		assertEquals("max(long)[35] ::", 348238234234l, Math.max(348238234234l,348238234234l));
		assertEquals("max(long)[36] ::", 9223372036854775805l, Math.max(348238234234l,9223372036854775805l));
		assertEquals("max(long)[37] ::", 9223372036854775805l, Math.max(9223372036854775805l,348238234234l));
		assertEquals("max(long)[38] ::", 9223372036854775805l, Math.max(348238234234l,9223372036854775805l));
		assertEquals("max(long)[39] ::", 9223372036854775805l, Math.max(9223372036854775805l,9223372036854775805l));
		assertEquals("max(long)[40] ::", 9223372036854775806l, Math.max(9223372036854775805l,9223372036854775806l));
		assertEquals("max(long)[41] ::", 9223372036854775806l, Math.max(9223372036854775806l,9223372036854775805l));
		assertEquals("max(long)[42] ::", 9223372036854775806l, Math.max(9223372036854775805l,9223372036854775806l));
		assertEquals("max(long)[43] ::", 9223372036854775806l, Math.max(9223372036854775806l,9223372036854775806l));
		assertEquals("max(long)[44] ::", 9223372036854775807l, Math.max(9223372036854775806l,9223372036854775807l));
		assertEquals("max(long)[45] ::", 9223372036854775807l, Math.max(9223372036854775807l,9223372036854775806l));
		assertEquals("max(long)[46] ::", 9223372036854775807l, Math.max(9223372036854775806l,9223372036854775807l));
		assertEquals("max(long)[47] ::", 9223372036854775807l, Math.max(9223372036854775807l,9223372036854775807l));
	}

	public void testMax_int()
	{
		assertEquals("max(int)[0] ::", -2147483647, Math.max(-2147483648,-2147483647));
		assertEquals("max(int)[1] ::", -2147483647, Math.max(-2147483647,-2147483648));
		assertEquals("max(int)[2] ::", -2147483647, Math.max(-2147483648,-2147483647));
		assertEquals("max(int)[3] ::", -2147483647, Math.max(-2147483647,-2147483647));
		assertEquals("max(int)[4] ::", -2147483646, Math.max(-2147483647,-2147483646));
		assertEquals("max(int)[5] ::", -2147483646, Math.max(-2147483646,-2147483647));
		assertEquals("max(int)[6] ::", -2147483646, Math.max(-2147483647,-2147483646));
		assertEquals("max(int)[7] ::", -2147483646, Math.max(-2147483646,-2147483646));
		assertEquals("max(int)[8] ::", -42218, Math.max(-2147483646,-42218));
		assertEquals("max(int)[9] ::", -42218, Math.max(-42218,-2147483646));
		assertEquals("max(int)[10] ::", -42218, Math.max(-2147483646,-42218));
		assertEquals("max(int)[11] ::", -42218, Math.max(-42218,-42218));
		assertEquals("max(int)[12] ::", -2, Math.max(-42218,-2));
		assertEquals("max(int)[13] ::", -2, Math.max(-2,-42218));
		assertEquals("max(int)[14] ::", -2, Math.max(-42218,-2));
		assertEquals("max(int)[15] ::", -2, Math.max(-2,-2));
		assertEquals("max(int)[16] ::", -1, Math.max(-2,-1));
		assertEquals("max(int)[17] ::", -1, Math.max(-1,-2));
		assertEquals("max(int)[18] ::", -1, Math.max(-2,-1));
		assertEquals("max(int)[19] ::", -1, Math.max(-1,-1));
		assertEquals("max(int)[20] ::", 0, Math.max(-1,0));
		assertEquals("max(int)[21] ::", 0, Math.max(0,-1));
		assertEquals("max(int)[22] ::", 0, Math.max(-1,0));
		assertEquals("max(int)[23] ::", 0, Math.max(0,0));
		assertEquals("max(int)[24] ::", 1, Math.max(0,1));
		assertEquals("max(int)[25] ::", 1, Math.max(1,0));
		assertEquals("max(int)[26] ::", 1, Math.max(0,1));
		assertEquals("max(int)[27] ::", 1, Math.max(1,1));
		assertEquals("max(int)[28] ::", 2, Math.max(1,2));
		assertEquals("max(int)[29] ::", 2, Math.max(2,1));
		assertEquals("max(int)[30] ::", 2, Math.max(1,2));
		assertEquals("max(int)[31] ::", 2, Math.max(2,2));
		assertEquals("max(int)[32] ::", 892389, Math.max(2,892389));
		assertEquals("max(int)[33] ::", 892389, Math.max(892389,2));
		assertEquals("max(int)[34] ::", 892389, Math.max(2,892389));
		assertEquals("max(int)[35] ::", 892389, Math.max(892389,892389));
		assertEquals("max(int)[36] ::", 2147483645, Math.max(892389,2147483645));
		assertEquals("max(int)[37] ::", 2147483645, Math.max(2147483645,892389));
		assertEquals("max(int)[38] ::", 2147483645, Math.max(892389,2147483645));
		assertEquals("max(int)[39] ::", 2147483645, Math.max(2147483645,2147483645));
		assertEquals("max(int)[40] ::", 2147483646, Math.max(2147483645,2147483646));
		assertEquals("max(int)[41] ::", 2147483646, Math.max(2147483646,2147483645));
		assertEquals("max(int)[42] ::", 2147483646, Math.max(2147483645,2147483646));
		assertEquals("max(int)[43] ::", 2147483646, Math.max(2147483646,2147483646));
		assertEquals("max(int)[44] ::", 2147483647, Math.max(2147483646,2147483647));
		assertEquals("max(int)[45] ::", 2147483647, Math.max(2147483647,2147483646));
		assertEquals("max(int)[46] ::", 2147483647, Math.max(2147483646,2147483647));
		assertEquals("max(int)[47] ::", 2147483647, Math.max(2147483647,2147483647));
	}

	public void testMin_double()
	{
		assertEquals("min(double)[0] ::", -1.7976931348623157E308d, Math.min(-1.7976931348623157E308d,-8.988465674311578E305d));
		assertEquals("min(double)[1] ::", -1.7976931348623157E308d, Math.min(-8.988465674311578E305d,-1.7976931348623157E308d));
		assertEquals("min(double)[2] ::", -1.7976931348623157E308d, Math.min(-1.7976931348623157E308d,-1.7976931348623157E308d));
		assertEquals("min(double)[3] ::", -1.7976931348623157E308d, Math.min(-8.988465674311578E305d,-1.7976931348623157E308d));
		assertEquals("min(double)[4] ::", -8.988465674311578E305d, Math.min(-8.988465674311578E305d,-3.595386269724631E305d));
		assertEquals("min(double)[5] ::", -8.988465674311578E305d, Math.min(-3.595386269724631E305d,-8.988465674311578E305d));
		assertEquals("min(double)[6] ::", -8.988465674311578E305d, Math.min(-8.988465674311578E305d,-8.988465674311578E305d));
		assertEquals("min(double)[7] ::", -8.988465674311578E305d, Math.min(-3.595386269724631E305d,-8.988465674311578E305d));
		assertEquals("min(double)[8] ::", -3.595386269724631E305d, Math.min(-3.595386269724631E305d,-9.88E-321d));
		assertEquals("min(double)[9] ::", -3.595386269724631E305d, Math.min(-9.88E-321d,-3.595386269724631E305d));
		assertEquals("min(double)[10] ::", -3.595386269724631E305d, Math.min(-3.595386269724631E305d,-3.595386269724631E305d));
		assertEquals("min(double)[11] ::", -3.595386269724631E305d, Math.min(-9.88E-321d,-3.595386269724631E305d));
		assertEquals("min(double)[12] ::", -9.88E-321d, Math.min(-9.88E-321d,-4.94E-321d));
		assertEquals("min(double)[13] ::", -9.88E-321d, Math.min(-4.94E-321d,-9.88E-321d));
		assertEquals("min(double)[14] ::", -9.88E-321d, Math.min(-9.88E-321d,-9.88E-321d));
		assertEquals("min(double)[15] ::", -9.88E-321d, Math.min(-4.94E-321d,-9.88E-321d));
		assertEquals("min(double)[16] ::", -2.9291122121292315E9d, Math.min(-4.94E-321d,-2.9291122121292315E9d));
		assertEquals("min(double)[17] ::", -2.9291122121292315E9d, Math.min(-2.9291122121292315E9d,-4.94E-321d));
		assertEquals("min(double)[18] ::", -2.9291122121292315E9d, Math.min(-4.94E-321d,-2.9291122121292315E9d));
		assertEquals("min(double)[19] ::", -2.9291122121292315E9d, Math.min(-2.9291122121292315E9d,-2.9291122121292315E9d));
		assertEquals("min(double)[20] ::", -2.9291122121292315E9d, Math.min(-2.9291122121292315E9d,-2372.228212d));
		assertEquals("min(double)[21] ::", -2.9291122121292315E9d, Math.min(-2372.228212d,-2.9291122121292315E9d));
		assertEquals("min(double)[22] ::", -2.9291122121292315E9d, Math.min(-2.9291122121292315E9d,-2.9291122121292315E9d));
		assertEquals("min(double)[23] ::", -2.9291122121292315E9d, Math.min(-2372.228212d,-2.9291122121292315E9d));
		assertEquals("min(double)[24] ::", -2372.228212d, Math.min(-2372.228212d,-1.2232d));
		assertEquals("min(double)[25] ::", -2372.228212d, Math.min(-1.2232d,-2372.228212d));
		assertEquals("min(double)[26] ::", -2372.228212d, Math.min(-2372.228212d,-2372.228212d));
		assertEquals("min(double)[27] ::", -2372.228212d, Math.min(-1.2232d,-2372.228212d));
		assertEquals("min(double)[28] ::", -1.2232d, Math.min(-1.2232d,0.0d));
		assertEquals("min(double)[29] ::", -1.2232d, Math.min(0.0d,-1.2232d));
		assertEquals("min(double)[30] ::", -1.2232d, Math.min(-1.2232d,-1.2232d));
		assertEquals("min(double)[31] ::", -1.2232d, Math.min(0.0d,-1.2232d));
		assertEquals("min(double)[32] ::", 0.0d, Math.min(0.0d,2.43223d));
		assertEquals("min(double)[33] ::", 0.0d, Math.min(2.43223d,0.0d));
		assertEquals("min(double)[34] ::", 0.0d, Math.min(0.0d,0.0d));
		assertEquals("min(double)[35] ::", 0.0d, Math.min(2.43223d,0.0d));
		assertEquals("min(double)[36] ::", 2.43223d, Math.min(2.43223d,1.82321553323566E7d));
		assertEquals("min(double)[37] ::", 2.43223d, Math.min(1.82321553323566E7d,2.43223d));
		assertEquals("min(double)[38] ::", 2.43223d, Math.min(2.43223d,2.43223d));
		assertEquals("min(double)[39] ::", 2.43223d, Math.min(1.82321553323566E7d,2.43223d));
		assertEquals("min(double)[40] ::", 4.9E-324d, Math.min(1.82321553323566E7d,4.9E-324d));
		assertEquals("min(double)[41] ::", 4.9E-324d, Math.min(4.9E-324d,1.82321553323566E7d));
		assertEquals("min(double)[42] ::", 4.9E-324d, Math.min(1.82321553323566E7d,4.9E-324d));
		assertEquals("min(double)[43] ::", 4.9E-324d, Math.min(4.9E-324d,4.9E-324d));
		assertEquals("min(double)[44] ::", 4.9E-324d, Math.min(4.9E-324d,9.9E-322d));
		assertEquals("min(double)[45] ::", 4.9E-324d, Math.min(9.9E-322d,4.9E-324d));
		assertEquals("min(double)[46] ::", 4.9E-324d, Math.min(4.9E-324d,4.9E-324d));
		assertEquals("min(double)[47] ::", 4.9E-324d, Math.min(9.9E-322d,4.9E-324d));
		assertEquals("min(double)[48] ::", 9.9E-322d, Math.min(9.9E-322d,3.595386269724631E305d));
		assertEquals("min(double)[49] ::", 9.9E-322d, Math.min(3.595386269724631E305d,9.9E-322d));
		assertEquals("min(double)[50] ::", 9.9E-322d, Math.min(9.9E-322d,9.9E-322d));
		assertEquals("min(double)[51] ::", 9.9E-322d, Math.min(3.595386269724631E305d,9.9E-322d));
		assertEquals("min(double)[52] ::", 3.595386269724631E305d, Math.min(3.595386269724631E305d,8.988465674311578E305d));
		assertEquals("min(double)[53] ::", 3.595386269724631E305d, Math.min(8.988465674311578E305d,3.595386269724631E305d));
		assertEquals("min(double)[54] ::", 3.595386269724631E305d, Math.min(3.595386269724631E305d,3.595386269724631E305d));
		assertEquals("min(double)[55] ::", 3.595386269724631E305d, Math.min(8.988465674311578E305d,3.595386269724631E305d));
		assertEquals("min(double)[56] ::", 8.988465674311578E305d, Math.min(8.988465674311578E305d,1.7976931348623157E308d));
		assertEquals("min(double)[57] ::", 8.988465674311578E305d, Math.min(1.7976931348623157E308d,8.988465674311578E305d));
		assertEquals("min(double)[58] ::", 8.988465674311578E305d, Math.min(8.988465674311578E305d,8.988465674311578E305d));
		assertEquals("min(double)[59] ::", 8.988465674311578E305d, Math.min(1.7976931348623157E308d,8.988465674311578E305d));
		assertEquals("min(double)[60] ::", 1.7976931348623157E308d, Math.min(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("min(double)[61] ::", 1.7976931348623157E308d, Math.min(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("min(double)[62] ::", 1.7976931348623157E308d, Math.min(1.7976931348623157E308d,1.7976931348623157E308d));
		assertEquals("min(double)[63] ::", 1.7976931348623157E308d, Math.min(1.7976931348623157E308d,1.7976931348623157E308d));
	}

	public void testMin_float()
	{
		assertEquals("min(float)[0] ::", -3.4028235E38f, Math.min(-3.4028235E38f,-1.7014118E36f));
		assertEquals("min(float)[1] ::", -3.4028235E38f, Math.min(-1.7014118E36f,-3.4028235E38f));
		assertEquals("min(float)[2] ::", -3.4028235E38f, Math.min(-3.4028235E38f,-3.4028235E38f));
		assertEquals("min(float)[3] ::", -3.4028235E38f, Math.min(-1.7014118E36f,-3.4028235E38f));
		assertEquals("min(float)[4] ::", -1.7014118E36f, Math.min(-1.7014118E36f,-6.805647E35f));
		assertEquals("min(float)[5] ::", -1.7014118E36f, Math.min(-6.805647E35f,-1.7014118E36f));
		assertEquals("min(float)[6] ::", -1.7014118E36f, Math.min(-1.7014118E36f,-1.7014118E36f));
		assertEquals("min(float)[7] ::", -1.7014118E36f, Math.min(-6.805647E35f,-1.7014118E36f));
		assertEquals("min(float)[8] ::", -6.805647E35f, Math.min(-6.805647E35f,-2.803E-42f));
		assertEquals("min(float)[9] ::", -6.805647E35f, Math.min(-2.803E-42f,-6.805647E35f));
		assertEquals("min(float)[10] ::", -6.805647E35f, Math.min(-6.805647E35f,-6.805647E35f));
		assertEquals("min(float)[11] ::", -6.805647E35f, Math.min(-2.803E-42f,-6.805647E35f));
		assertEquals("min(float)[12] ::", -2.803E-42f, Math.min(-2.803E-42f,-1.401E-42f));
		assertEquals("min(float)[13] ::", -2.803E-42f, Math.min(-1.401E-42f,-2.803E-42f));
		assertEquals("min(float)[14] ::", -2.803E-42f, Math.min(-2.803E-42f,-2.803E-42f));
		assertEquals("min(float)[15] ::", -2.803E-42f, Math.min(-1.401E-42f,-2.803E-42f));
		assertEquals("min(float)[16] ::", -3.2948748E7f, Math.min(-1.401E-42f,-3.2948748E7f));
		assertEquals("min(float)[17] ::", -3.2948748E7f, Math.min(-3.2948748E7f,-1.401E-42f));
		assertEquals("min(float)[18] ::", -3.2948748E7f, Math.min(-1.401E-42f,-3.2948748E7f));
		assertEquals("min(float)[19] ::", -3.2948748E7f, Math.min(-3.2948748E7f,-3.2948748E7f));
		assertEquals("min(float)[20] ::", -3.2948748E7f, Math.min(-3.2948748E7f,-9.0E-9f));
		assertEquals("min(float)[21] ::", -3.2948748E7f, Math.min(-9.0E-9f,-3.2948748E7f));
		assertEquals("min(float)[22] ::", -3.2948748E7f, Math.min(-3.2948748E7f,-3.2948748E7f));
		assertEquals("min(float)[23] ::", -3.2948748E7f, Math.min(-9.0E-9f,-3.2948748E7f));
		assertEquals("min(float)[24] ::", -2.0E-7f, Math.min(-9.0E-9f,-2.0E-7f));
		assertEquals("min(float)[25] ::", -2.0E-7f, Math.min(-2.0E-7f,-9.0E-9f));
		assertEquals("min(float)[26] ::", -2.0E-7f, Math.min(-9.0E-9f,-2.0E-7f));
		assertEquals("min(float)[27] ::", -2.0E-7f, Math.min(-2.0E-7f,-2.0E-7f));
		assertEquals("min(float)[28] ::", -2.0E-7f, Math.min(-2.0E-7f,0.0f));
		assertEquals("min(float)[29] ::", -2.0E-7f, Math.min(0.0f,-2.0E-7f));
		assertEquals("min(float)[30] ::", -2.0E-7f, Math.min(-2.0E-7f,-2.0E-7f));
		assertEquals("min(float)[31] ::", -2.0E-7f, Math.min(0.0f,-2.0E-7f));
		assertEquals("min(float)[32] ::", 0.0f, Math.min(0.0f,0.45623234f));
		assertEquals("min(float)[33] ::", 0.0f, Math.min(0.45623234f,0.0f));
		assertEquals("min(float)[34] ::", 0.0f, Math.min(0.0f,0.0f));
		assertEquals("min(float)[35] ::", 0.0f, Math.min(0.45623234f,0.0f));
		assertEquals("min(float)[36] ::", 0.45623234f, Math.min(0.45623234f,1224257.2f));
		assertEquals("min(float)[37] ::", 0.45623234f, Math.min(1224257.2f,0.45623234f));
		assertEquals("min(float)[38] ::", 0.45623234f, Math.min(0.45623234f,0.45623234f));
		assertEquals("min(float)[39] ::", 0.45623234f, Math.min(1224257.2f,0.45623234f));
		assertEquals("min(float)[40] ::", 1224257.2f, Math.min(1224257.2f,9.9998321E9f));
		assertEquals("min(float)[41] ::", 1224257.2f, Math.min(9.9998321E9f,1224257.2f));
		assertEquals("min(float)[42] ::", 1224257.2f, Math.min(1224257.2f,1224257.2f));
		assertEquals("min(float)[43] ::", 1224257.2f, Math.min(9.9998321E9f,1224257.2f));
		assertEquals("min(float)[44] ::", 1.4E-45f, Math.min(9.9998321E9f,1.4E-45f));
		assertEquals("min(float)[45] ::", 1.4E-45f, Math.min(1.4E-45f,9.9998321E9f));
		assertEquals("min(float)[46] ::", 1.4E-45f, Math.min(9.9998321E9f,1.4E-45f));
		assertEquals("min(float)[47] ::", 1.4E-45f, Math.min(1.4E-45f,1.4E-45f));
		assertEquals("min(float)[48] ::", 1.4E-45f, Math.min(1.4E-45f,2.8E-43f));
		assertEquals("min(float)[49] ::", 1.4E-45f, Math.min(2.8E-43f,1.4E-45f));
		assertEquals("min(float)[50] ::", 1.4E-45f, Math.min(1.4E-45f,1.4E-45f));
		assertEquals("min(float)[51] ::", 1.4E-45f, Math.min(2.8E-43f,1.4E-45f));
		assertEquals("min(float)[52] ::", 2.8E-43f, Math.min(2.8E-43f,6.805647E35f));
		assertEquals("min(float)[53] ::", 2.8E-43f, Math.min(6.805647E35f,2.8E-43f));
		assertEquals("min(float)[54] ::", 2.8E-43f, Math.min(2.8E-43f,2.8E-43f));
		assertEquals("min(float)[55] ::", 2.8E-43f, Math.min(6.805647E35f,2.8E-43f));
		assertEquals("min(float)[56] ::", 6.805647E35f, Math.min(6.805647E35f,1.7014118E36f));
		assertEquals("min(float)[57] ::", 6.805647E35f, Math.min(1.7014118E36f,6.805647E35f));
		assertEquals("min(float)[58] ::", 6.805647E35f, Math.min(6.805647E35f,6.805647E35f));
		assertEquals("min(float)[59] ::", 6.805647E35f, Math.min(1.7014118E36f,6.805647E35f));
		assertEquals("min(float)[60] ::", 1.7014118E36f, Math.min(1.7014118E36f,3.4028235E38f));
		assertEquals("min(float)[61] ::", 1.7014118E36f, Math.min(3.4028235E38f,1.7014118E36f));
		assertEquals("min(float)[62] ::", 1.7014118E36f, Math.min(1.7014118E36f,1.7014118E36f));
		assertEquals("min(float)[63] ::", 1.7014118E36f, Math.min(3.4028235E38f,1.7014118E36f));
		assertEquals("min(float)[64] ::", 3.4028235E38f, Math.min(3.4028235E38f,3.4028235E38f));
		assertEquals("min(float)[65] ::", 3.4028235E38f, Math.min(3.4028235E38f,3.4028235E38f));
		assertEquals("min(float)[66] ::", 3.4028235E38f, Math.min(3.4028235E38f,3.4028235E38f));
		assertEquals("min(float)[67] ::", 3.4028235E38f, Math.min(3.4028235E38f,3.4028235E38f));
	}

	public void testMin_long()
	{
		assertEquals("min(long)[0] ::", -9223372036854775808l, Math.min(-9223372036854775808l,-9223372036854775807l));
		assertEquals("min(long)[1] ::", -9223372036854775808l, Math.min(-9223372036854775807l,-9223372036854775808l));
		assertEquals("min(long)[2] ::", -9223372036854775808l, Math.min(-9223372036854775808l,-9223372036854775808l));
		assertEquals("min(long)[3] ::", -9223372036854775808l, Math.min(-9223372036854775807l,-9223372036854775808l));
		assertEquals("min(long)[4] ::", -9223372036854775807l, Math.min(-9223372036854775807l,-9223372036854775806l));
		assertEquals("min(long)[5] ::", -9223372036854775807l, Math.min(-9223372036854775806l,-9223372036854775807l));
		assertEquals("min(long)[6] ::", -9223372036854775807l, Math.min(-9223372036854775807l,-9223372036854775807l));
		assertEquals("min(long)[7] ::", -9223372036854775807l, Math.min(-9223372036854775806l,-9223372036854775807l));
		assertEquals("min(long)[8] ::", -9223372036854775806l, Math.min(-9223372036854775806l,-332342l));
		assertEquals("min(long)[9] ::", -9223372036854775806l, Math.min(-332342l,-9223372036854775806l));
		assertEquals("min(long)[10] ::", -9223372036854775806l, Math.min(-9223372036854775806l,-9223372036854775806l));
		assertEquals("min(long)[11] ::", -9223372036854775806l, Math.min(-332342l,-9223372036854775806l));
		assertEquals("min(long)[12] ::", -332342l, Math.min(-332342l,-2l));
		assertEquals("min(long)[13] ::", -332342l, Math.min(-2l,-332342l));
		assertEquals("min(long)[14] ::", -332342l, Math.min(-332342l,-332342l));
		assertEquals("min(long)[15] ::", -332342l, Math.min(-2l,-332342l));
		assertEquals("min(long)[16] ::", -2l, Math.min(-2l,-1l));
		assertEquals("min(long)[17] ::", -2l, Math.min(-1l,-2l));
		assertEquals("min(long)[18] ::", -2l, Math.min(-2l,-2l));
		assertEquals("min(long)[19] ::", -2l, Math.min(-1l,-2l));
		assertEquals("min(long)[20] ::", -1l, Math.min(-1l,0l));
		assertEquals("min(long)[21] ::", -1l, Math.min(0l,-1l));
		assertEquals("min(long)[22] ::", -1l, Math.min(-1l,-1l));
		assertEquals("min(long)[23] ::", -1l, Math.min(0l,-1l));
		assertEquals("min(long)[24] ::", 0l, Math.min(0l,1l));
		assertEquals("min(long)[25] ::", 0l, Math.min(1l,0l));
		assertEquals("min(long)[26] ::", 0l, Math.min(0l,0l));
		assertEquals("min(long)[27] ::", 0l, Math.min(1l,0l));
		assertEquals("min(long)[28] ::", 1l, Math.min(1l,2l));
		assertEquals("min(long)[29] ::", 1l, Math.min(2l,1l));
		assertEquals("min(long)[30] ::", 1l, Math.min(1l,1l));
		assertEquals("min(long)[31] ::", 1l, Math.min(2l,1l));
		assertEquals("min(long)[32] ::", 2l, Math.min(2l,348238234234l));
		assertEquals("min(long)[33] ::", 2l, Math.min(348238234234l,2l));
		assertEquals("min(long)[34] ::", 2l, Math.min(2l,2l));
		assertEquals("min(long)[35] ::", 2l, Math.min(348238234234l,2l));
		assertEquals("min(long)[36] ::", 348238234234l, Math.min(348238234234l,9223372036854775805l));
		assertEquals("min(long)[37] ::", 348238234234l, Math.min(9223372036854775805l,348238234234l));
		assertEquals("min(long)[38] ::", 348238234234l, Math.min(348238234234l,348238234234l));
		assertEquals("min(long)[39] ::", 348238234234l, Math.min(9223372036854775805l,348238234234l));
		assertEquals("min(long)[40] ::", 9223372036854775805l, Math.min(9223372036854775805l,9223372036854775806l));
		assertEquals("min(long)[41] ::", 9223372036854775805l, Math.min(9223372036854775806l,9223372036854775805l));
		assertEquals("min(long)[42] ::", 9223372036854775805l, Math.min(9223372036854775805l,9223372036854775805l));
		assertEquals("min(long)[43] ::", 9223372036854775805l, Math.min(9223372036854775806l,9223372036854775805l));
		assertEquals("min(long)[44] ::", 9223372036854775806l, Math.min(9223372036854775806l,9223372036854775807l));
		assertEquals("min(long)[45] ::", 9223372036854775806l, Math.min(9223372036854775807l,9223372036854775806l));
		assertEquals("min(long)[46] ::", 9223372036854775806l, Math.min(9223372036854775806l,9223372036854775806l));
		assertEquals("min(long)[47] ::", 9223372036854775806l, Math.min(9223372036854775807l,9223372036854775806l));
	}

	public void testMin_int()
	{
		assertEquals("min(int)[0] ::", -2147483648, Math.min(-2147483648,-2147483647));
		assertEquals("min(int)[1] ::", -2147483648, Math.min(-2147483647,-2147483648));
		assertEquals("min(int)[2] ::", -2147483648, Math.min(-2147483648,-2147483648));
		assertEquals("min(int)[3] ::", -2147483648, Math.min(-2147483647,-2147483648));
		assertEquals("min(int)[4] ::", -2147483647, Math.min(-2147483647,-2147483646));
		assertEquals("min(int)[5] ::", -2147483647, Math.min(-2147483646,-2147483647));
		assertEquals("min(int)[6] ::", -2147483647, Math.min(-2147483647,-2147483647));
		assertEquals("min(int)[7] ::", -2147483647, Math.min(-2147483646,-2147483647));
		assertEquals("min(int)[8] ::", -2147483646, Math.min(-2147483646,-42218));
		assertEquals("min(int)[9] ::", -2147483646, Math.min(-42218,-2147483646));
		assertEquals("min(int)[10] ::", -2147483646, Math.min(-2147483646,-2147483646));
		assertEquals("min(int)[11] ::", -2147483646, Math.min(-42218,-2147483646));
		assertEquals("min(int)[12] ::", -42218, Math.min(-42218,-2));
		assertEquals("min(int)[13] ::", -42218, Math.min(-2,-42218));
		assertEquals("min(int)[14] ::", -42218, Math.min(-42218,-42218));
		assertEquals("min(int)[15] ::", -42218, Math.min(-2,-42218));
		assertEquals("min(int)[16] ::", -2, Math.min(-2,-1));
		assertEquals("min(int)[17] ::", -2, Math.min(-1,-2));
		assertEquals("min(int)[18] ::", -2, Math.min(-2,-2));
		assertEquals("min(int)[19] ::", -2, Math.min(-1,-2));
		assertEquals("min(int)[20] ::", -1, Math.min(-1,0));
		assertEquals("min(int)[21] ::", -1, Math.min(0,-1));
		assertEquals("min(int)[22] ::", -1, Math.min(-1,-1));
		assertEquals("min(int)[23] ::", -1, Math.min(0,-1));
		assertEquals("min(int)[24] ::", 0, Math.min(0,1));
		assertEquals("min(int)[25] ::", 0, Math.min(1,0));
		assertEquals("min(int)[26] ::", 0, Math.min(0,0));
		assertEquals("min(int)[27] ::", 0, Math.min(1,0));
		assertEquals("min(int)[28] ::", 1, Math.min(1,2));
		assertEquals("min(int)[29] ::", 1, Math.min(2,1));
		assertEquals("min(int)[30] ::", 1, Math.min(1,1));
		assertEquals("min(int)[31] ::", 1, Math.min(2,1));
		assertEquals("min(int)[32] ::", 2, Math.min(2,892389));
		assertEquals("min(int)[33] ::", 2, Math.min(892389,2));
		assertEquals("min(int)[34] ::", 2, Math.min(2,2));
		assertEquals("min(int)[35] ::", 2, Math.min(892389,2));
		assertEquals("min(int)[36] ::", 892389, Math.min(892389,2147483645));
		assertEquals("min(int)[37] ::", 892389, Math.min(2147483645,892389));
		assertEquals("min(int)[38] ::", 892389, Math.min(892389,892389));
		assertEquals("min(int)[39] ::", 892389, Math.min(2147483645,892389));
		assertEquals("min(int)[40] ::", 2147483645, Math.min(2147483645,2147483646));
		assertEquals("min(int)[41] ::", 2147483645, Math.min(2147483646,2147483645));
		assertEquals("min(int)[42] ::", 2147483645, Math.min(2147483645,2147483645));
		assertEquals("min(int)[43] ::", 2147483645, Math.min(2147483646,2147483645));
		assertEquals("min(int)[44] ::", 2147483646, Math.min(2147483646,2147483647));
		assertEquals("min(int)[45] ::", 2147483646, Math.min(2147483647,2147483646));
		assertEquals("min(int)[46] ::", 2147483646, Math.min(2147483646,2147483646));
		assertEquals("min(int)[47] ::", 2147483646, Math.min(2147483647,2147483646));
	}

	public void testNextAfter_double()
	{
		assertEquals("nextAfter(double,double)[0] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,+0.0D));
		assertEquals("nextAfter(double,double)[1] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,+0.0001D));
		assertEquals("nextAfter(double,double)[2] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,+1.0D));
		assertEquals("nextAfter(double,double)[3] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,+10.0D));
		assertEquals("nextAfter(double,double)[4] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,+3327.191D));
		assertEquals("nextAfter(double,double)[5] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,-0.0D));
		assertEquals("nextAfter(double,double)[6] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,-0.0001D));
		assertEquals("nextAfter(double,double)[7] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,-1.0D));
		assertEquals("nextAfter(double,double)[8] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,-10.0D));
		assertEquals("nextAfter(double,double)[9] ::", (double)-1.7976931348623155E308, Math.nextAfter(-Double.MAX_VALUE,-3327.191D));
		assertEquals("nextAfter(double,double)[10] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),+0.0D));
		assertEquals("nextAfter(double,double)[11] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),+0.0001D));
		assertEquals("nextAfter(double,double)[12] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),+1.0D));
		assertEquals("nextAfter(double,double)[13] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),+10.0D));
		assertEquals("nextAfter(double,double)[14] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),+3327.191D));
		assertEquals("nextAfter(double,double)[15] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),-0.0D));
		assertEquals("nextAfter(double,double)[16] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),-0.0001D));
		assertEquals("nextAfter(double,double)[17] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),-1.0D));
		assertEquals("nextAfter(double,double)[18] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),-10.0D));
		assertEquals("nextAfter(double,double)[19] ::", (double)-8.988465674311577E305, Math.nextAfter((-Double.MAX_VALUE / 200),-3327.191D));
		assertEquals("nextAfter(double,double)[20] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),+0.0D));
		assertEquals("nextAfter(double,double)[21] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),+0.0001D));
		assertEquals("nextAfter(double,double)[22] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),+1.0D));
		assertEquals("nextAfter(double,double)[23] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),+10.0D));
		assertEquals("nextAfter(double,double)[24] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),+3327.191D));
		assertEquals("nextAfter(double,double)[25] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),-0.0D));
		assertEquals("nextAfter(double,double)[26] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),-0.0001D));
		assertEquals("nextAfter(double,double)[27] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),-1.0D));
		assertEquals("nextAfter(double,double)[28] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),-10.0D));
		assertEquals("nextAfter(double,double)[29] ::", (double)-3.59538626972463E305, Math.nextAfter((-Double.MAX_VALUE / 500),-3327.191D));
		assertEquals("nextAfter(double,double)[30] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),+0.0D));
		assertEquals("nextAfter(double,double)[31] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),+0.0001D));
		assertEquals("nextAfter(double,double)[32] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),+1.0D));
		assertEquals("nextAfter(double,double)[33] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),+10.0D));
		assertEquals("nextAfter(double,double)[34] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),+3327.191D));
		assertEquals("nextAfter(double,double)[35] ::", (double)-9.876E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),-0.0D));
		assertEquals("nextAfter(double,double)[36] ::", (double)-9.886E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),-0.0001D));
		assertEquals("nextAfter(double,double)[37] ::", (double)-9.886E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),-1.0D));
		assertEquals("nextAfter(double,double)[38] ::", (double)-9.886E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),-10.0D));
		assertEquals("nextAfter(double,double)[39] ::", (double)-9.886E-321, Math.nextAfter((-Double.MIN_VALUE * 2000),-3327.191D));
		assertEquals("nextAfter(double,double)[40] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),+0.0D));
		assertEquals("nextAfter(double,double)[41] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),+0.0001D));
		assertEquals("nextAfter(double,double)[42] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),+1.0D));
		assertEquals("nextAfter(double,double)[43] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),+10.0D));
		assertEquals("nextAfter(double,double)[44] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),+3327.191D));
		assertEquals("nextAfter(double,double)[45] ::", (double)-4.936E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),-0.0D));
		assertEquals("nextAfter(double,double)[46] ::", (double)-4.946E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),-0.0001D));
		assertEquals("nextAfter(double,double)[47] ::", (double)-4.946E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),-1.0D));
		assertEquals("nextAfter(double,double)[48] ::", (double)-4.946E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),-10.0D));
		assertEquals("nextAfter(double,double)[49] ::", (double)-4.946E-321, Math.nextAfter((-Double.MIN_VALUE * 1000),-3327.191D));
		assertEquals("nextAfter(double,double)[50] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,+0.0D));
		assertEquals("nextAfter(double,double)[51] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,+0.0001D));
		assertEquals("nextAfter(double,double)[52] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,+1.0D));
		assertEquals("nextAfter(double,double)[53] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,+10.0D));
		assertEquals("nextAfter(double,double)[54] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,+3327.191D));
		assertEquals("nextAfter(double,double)[55] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,-0.0D));
		assertEquals("nextAfter(double,double)[56] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,-0.0001D));
		assertEquals("nextAfter(double,double)[57] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,-1.0D));
		assertEquals("nextAfter(double,double)[58] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,-10.0D));
		assertEquals("nextAfter(double,double)[59] ::", (double)-2.929112212129231E9, Math.nextAfter(-2929112212.129231481346,-3327.191D));
		assertEquals("nextAfter(double,double)[60] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,+0.0D));
		assertEquals("nextAfter(double,double)[61] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,+0.0001D));
		assertEquals("nextAfter(double,double)[62] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,+1.0D));
		assertEquals("nextAfter(double,double)[63] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,+10.0D));
		assertEquals("nextAfter(double,double)[64] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,+3327.191D));
		assertEquals("nextAfter(double,double)[65] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,-0.0D));
		assertEquals("nextAfter(double,double)[66] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,-0.0001D));
		assertEquals("nextAfter(double,double)[67] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,-1.0D));
		assertEquals("nextAfter(double,double)[68] ::", (double)-2372.2282119999995, Math.nextAfter(-2372.228212D,-10.0D));
		assertEquals("nextAfter(double,double)[69] ::", (double)-2372.2282120000004, Math.nextAfter(-2372.228212D,-3327.191D));
		assertEquals("nextAfter(double,double)[70] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,+0.0D));
		assertEquals("nextAfter(double,double)[71] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,+0.0001D));
		assertEquals("nextAfter(double,double)[72] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,+1.0D));
		assertEquals("nextAfter(double,double)[73] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,+10.0D));
		assertEquals("nextAfter(double,double)[74] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,+3327.191D));
		assertEquals("nextAfter(double,double)[75] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,-0.0D));
		assertEquals("nextAfter(double,double)[76] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,-0.0001D));
		assertEquals("nextAfter(double,double)[77] ::", (double)-1.2231999999999998, Math.nextAfter(-1.2232D,-1.0D));
		assertEquals("nextAfter(double,double)[78] ::", (double)-1.2232000000000003, Math.nextAfter(-1.2232D,-10.0D));
		assertEquals("nextAfter(double,double)[79] ::", (double)-1.2232000000000003, Math.nextAfter(-1.2232D,-3327.191D));
		assertEquals("nextAfter(double,double)[80] ::", (double)0.0, Math.nextAfter(0D,+0.0D));
		assertEquals("nextAfter(double,double)[81] ::", (double)4.9E-324, Math.nextAfter(0D,+0.0001D));
		assertEquals("nextAfter(double,double)[82] ::", (double)4.9E-324, Math.nextAfter(0D,+1.0D));
		assertEquals("nextAfter(double,double)[83] ::", (double)4.9E-324, Math.nextAfter(0D,+10.0D));
		assertEquals("nextAfter(double,double)[84] ::", (double)4.9E-324, Math.nextAfter(0D,+3327.191D));
		assertEquals("nextAfter(double,double)[85] ::", (double)-0.0, Math.nextAfter(0D,-0.0D));
		assertEquals("nextAfter(double,double)[86] ::", (double)-4.9E-324, Math.nextAfter(0D,-0.0001D));
		assertEquals("nextAfter(double,double)[87] ::", (double)-4.9E-324, Math.nextAfter(0D,-1.0D));
		assertEquals("nextAfter(double,double)[88] ::", (double)-4.9E-324, Math.nextAfter(0D,-10.0D));
		assertEquals("nextAfter(double,double)[89] ::", (double)-4.9E-324, Math.nextAfter(0D,-3327.191D));
		assertEquals("nextAfter(double,double)[90] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,+0.0D));
		assertEquals("nextAfter(double,double)[91] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,+0.0001D));
		assertEquals("nextAfter(double,double)[92] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,+1.0D));
		assertEquals("nextAfter(double,double)[93] ::", (double)2.4322300000000006, Math.nextAfter(2.43223D,+10.0D));
		assertEquals("nextAfter(double,double)[94] ::", (double)2.4322300000000006, Math.nextAfter(2.43223D,+3327.191D));
		assertEquals("nextAfter(double,double)[95] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,-0.0D));
		assertEquals("nextAfter(double,double)[96] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,-0.0001D));
		assertEquals("nextAfter(double,double)[97] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,-1.0D));
		assertEquals("nextAfter(double,double)[98] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,-10.0D));
		assertEquals("nextAfter(double,double)[99] ::", (double)2.4322299999999997, Math.nextAfter(2.43223D,-3327.191D));
		assertEquals("nextAfter(double,double)[100] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,+0.0D));
		assertEquals("nextAfter(double,double)[101] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,+0.0001D));
		assertEquals("nextAfter(double,double)[102] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,+1.0D));
		assertEquals("nextAfter(double,double)[103] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,+10.0D));
		assertEquals("nextAfter(double,double)[104] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,+3327.191D));
		assertEquals("nextAfter(double,double)[105] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,-0.0D));
		assertEquals("nextAfter(double,double)[106] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,-0.0001D));
		assertEquals("nextAfter(double,double)[107] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,-1.0D));
		assertEquals("nextAfter(double,double)[108] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,-10.0D));
		assertEquals("nextAfter(double,double)[109] ::", (double)1.8232155332356595E7, Math.nextAfter(18232155.3323566D,-3327.191D));
		assertEquals("nextAfter(double,double)[110] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,+0.0D));
		assertEquals("nextAfter(double,double)[111] ::", (double)1.0E-323, Math.nextAfter(Double.MIN_VALUE,+0.0001D));
		assertEquals("nextAfter(double,double)[112] ::", (double)1.0E-323, Math.nextAfter(Double.MIN_VALUE,+1.0D));
		assertEquals("nextAfter(double,double)[113] ::", (double)1.0E-323, Math.nextAfter(Double.MIN_VALUE,+10.0D));
		assertEquals("nextAfter(double,double)[114] ::", (double)1.0E-323, Math.nextAfter(Double.MIN_VALUE,+3327.191D));
		assertEquals("nextAfter(double,double)[115] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,-0.0D));
		assertEquals("nextAfter(double,double)[116] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,-0.0001D));
		assertEquals("nextAfter(double,double)[117] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,-1.0D));
		assertEquals("nextAfter(double,double)[118] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,-10.0D));
		assertEquals("nextAfter(double,double)[119] ::", (double)0.0, Math.nextAfter(Double.MIN_VALUE,-3327.191D));
		assertEquals("nextAfter(double,double)[120] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),+0.0D));
		assertEquals("nextAfter(double,double)[121] ::", (double)9.93E-322, Math.nextAfter((Double.MIN_VALUE * 200),+0.0001D));
		assertEquals("nextAfter(double,double)[122] ::", (double)9.93E-322, Math.nextAfter((Double.MIN_VALUE * 200),+1.0D));
		assertEquals("nextAfter(double,double)[123] ::", (double)9.93E-322, Math.nextAfter((Double.MIN_VALUE * 200),+10.0D));
		assertEquals("nextAfter(double,double)[124] ::", (double)9.93E-322, Math.nextAfter((Double.MIN_VALUE * 200),+3327.191D));
		assertEquals("nextAfter(double,double)[125] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),-0.0D));
		assertEquals("nextAfter(double,double)[126] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),-0.0001D));
		assertEquals("nextAfter(double,double)[127] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),-1.0D));
		assertEquals("nextAfter(double,double)[128] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),-10.0D));
		assertEquals("nextAfter(double,double)[129] ::", (double)9.83E-322, Math.nextAfter((Double.MIN_VALUE * 200),-3327.191D));
		assertEquals("nextAfter(double,double)[130] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),+0.0D));
		assertEquals("nextAfter(double,double)[131] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),+0.0001D));
		assertEquals("nextAfter(double,double)[132] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),+1.0D));
		assertEquals("nextAfter(double,double)[133] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),+10.0D));
		assertEquals("nextAfter(double,double)[134] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),+3327.191D));
		assertEquals("nextAfter(double,double)[135] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),-0.0D));
		assertEquals("nextAfter(double,double)[136] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),-0.0001D));
		assertEquals("nextAfter(double,double)[137] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),-1.0D));
		assertEquals("nextAfter(double,double)[138] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),-10.0D));
		assertEquals("nextAfter(double,double)[139] ::", (double)3.59538626972463E305, Math.nextAfter((Double.MAX_VALUE / 500),-3327.191D));
		assertEquals("nextAfter(double,double)[140] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),+0.0D));
		assertEquals("nextAfter(double,double)[141] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),+0.0001D));
		assertEquals("nextAfter(double,double)[142] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),+1.0D));
		assertEquals("nextAfter(double,double)[143] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),+10.0D));
		assertEquals("nextAfter(double,double)[144] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),+3327.191D));
		assertEquals("nextAfter(double,double)[145] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),-0.0D));
		assertEquals("nextAfter(double,double)[146] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),-0.0001D));
		assertEquals("nextAfter(double,double)[147] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),-1.0D));
		assertEquals("nextAfter(double,double)[148] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),-10.0D));
		assertEquals("nextAfter(double,double)[149] ::", (double)8.988465674311577E305, Math.nextAfter((Double.MAX_VALUE / 200),-3327.191D));
		assertEquals("nextAfter(double,double)[150] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,+0.0D));
		assertEquals("nextAfter(double,double)[151] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,+0.0001D));
		assertEquals("nextAfter(double,double)[152] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,+1.0D));
		assertEquals("nextAfter(double,double)[153] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,+10.0D));
		assertEquals("nextAfter(double,double)[154] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,+3327.191D));
		assertEquals("nextAfter(double,double)[155] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,-0.0D));
		assertEquals("nextAfter(double,double)[156] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,-0.0001D));
		assertEquals("nextAfter(double,double)[157] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,-1.0D));
		assertEquals("nextAfter(double,double)[158] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,-10.0D));
		assertEquals("nextAfter(double,double)[159] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE,-3327.191D));
		assertEquals("nextAfter(double,double)[160] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,+0.0D));
		assertEquals("nextAfter(double,double)[161] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,+0.0001D));
		assertEquals("nextAfter(double,double)[162] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,+1.0D));
		assertEquals("nextAfter(double,double)[163] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,+10.0D));
		assertEquals("nextAfter(double,double)[164] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,+3327.191D));
		assertEquals("nextAfter(double,double)[165] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,-0.0D));
		assertEquals("nextAfter(double,double)[166] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,-0.0001D));
		assertEquals("nextAfter(double,double)[167] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,-1.0D));
		assertEquals("nextAfter(double,double)[168] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,-10.0D));
		assertEquals("nextAfter(double,double)[169] ::", (double)1.7976931348623155E308, Math.nextAfter(Double.MAX_VALUE + 1,-3327.191D));
	}

	public void testNextAfter_float()
	{
		assertEquals("nextAfter(float,double)[0] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,+0.0D));
		assertEquals("nextAfter(float,double)[1] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,+0.001D));
		assertEquals("nextAfter(float,double)[2] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,+1.0D));
		assertEquals("nextAfter(float,double)[3] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,+10.0D));
		assertEquals("nextAfter(float,double)[4] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,+3327.191D));
		assertEquals("nextAfter(float,double)[5] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,-0.0D));
		assertEquals("nextAfter(float,double)[6] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,-0.001D));
		assertEquals("nextAfter(float,double)[7] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,-1.0D));
		assertEquals("nextAfter(float,double)[8] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,-10.0D));
		assertEquals("nextAfter(float,double)[9] ::", (float)-3.4028233E38, Math.nextAfter(-Float.MAX_VALUE,-3327.191D));
		assertEquals("nextAfter(float,double)[10] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),+0.0D));
		assertEquals("nextAfter(float,double)[11] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),+0.001D));
		assertEquals("nextAfter(float,double)[12] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),+1.0D));
		assertEquals("nextAfter(float,double)[13] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),+10.0D));
		assertEquals("nextAfter(float,double)[14] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),+3327.191D));
		assertEquals("nextAfter(float,double)[15] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),-0.0D));
		assertEquals("nextAfter(float,double)[16] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),-0.001D));
		assertEquals("nextAfter(float,double)[17] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),-1.0D));
		assertEquals("nextAfter(float,double)[18] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),-10.0D));
		assertEquals("nextAfter(float,double)[19] ::", (float)-1.7014116E36, Math.nextAfter((-Float.MAX_VALUE / 200),-3327.191D));
		assertEquals("nextAfter(float,double)[20] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),+0.0D));
		assertEquals("nextAfter(float,double)[21] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),+0.001D));
		assertEquals("nextAfter(float,double)[22] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),+1.0D));
		assertEquals("nextAfter(float,double)[23] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),+10.0D));
		assertEquals("nextAfter(float,double)[24] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),+3327.191D));
		assertEquals("nextAfter(float,double)[25] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),-0.0D));
		assertEquals("nextAfter(float,double)[26] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),-0.001D));
		assertEquals("nextAfter(float,double)[27] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),-1.0D));
		assertEquals("nextAfter(float,double)[28] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),-10.0D));
		assertEquals("nextAfter(float,double)[29] ::", (float)-6.805646E35, Math.nextAfter((-Float.MAX_VALUE / 500),-3327.191D));
		assertEquals("nextAfter(float,double)[30] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),+0.0D));
		assertEquals("nextAfter(float,double)[31] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),+0.001D));
		assertEquals("nextAfter(float,double)[32] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),+1.0D));
		assertEquals("nextAfter(float,double)[33] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),+10.0D));
		assertEquals("nextAfter(float,double)[34] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),+3327.191D));
		assertEquals("nextAfter(float,double)[35] ::", (float)-2.801E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),-0.0D));
		assertEquals("nextAfter(float,double)[36] ::", (float)-2.804E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),-0.001D));
		assertEquals("nextAfter(float,double)[37] ::", (float)-2.804E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),-1.0D));
		assertEquals("nextAfter(float,double)[38] ::", (float)-2.804E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),-10.0D));
		assertEquals("nextAfter(float,double)[39] ::", (float)-2.804E-42, Math.nextAfter((-Float.MIN_VALUE * 2000),-3327.191D));
		assertEquals("nextAfter(float,double)[40] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),+0.0D));
		assertEquals("nextAfter(float,double)[41] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),+0.001D));
		assertEquals("nextAfter(float,double)[42] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),+1.0D));
		assertEquals("nextAfter(float,double)[43] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),+10.0D));
		assertEquals("nextAfter(float,double)[44] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),+3327.191D));
		assertEquals("nextAfter(float,double)[45] ::", (float)-1.4E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),-0.0D));
		assertEquals("nextAfter(float,double)[46] ::", (float)-1.403E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),-0.001D));
		assertEquals("nextAfter(float,double)[47] ::", (float)-1.403E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),-1.0D));
		assertEquals("nextAfter(float,double)[48] ::", (float)-1.403E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),-10.0D));
		assertEquals("nextAfter(float,double)[49] ::", (float)-1.403E-42, Math.nextAfter((-Float.MIN_VALUE * 1000),-3327.191D));
		assertEquals("nextAfter(float,double)[50] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,+0.0D));
		assertEquals("nextAfter(float,double)[51] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,+0.001D));
		assertEquals("nextAfter(float,double)[52] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,+1.0D));
		assertEquals("nextAfter(float,double)[53] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,+10.0D));
		assertEquals("nextAfter(float,double)[54] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,+3327.191D));
		assertEquals("nextAfter(float,double)[55] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,-0.0D));
		assertEquals("nextAfter(float,double)[56] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,-0.001D));
		assertEquals("nextAfter(float,double)[57] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,-1.0D));
		assertEquals("nextAfter(float,double)[58] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,-10.0D));
		assertEquals("nextAfter(float,double)[59] ::", (float)-3.2948746E7, Math.nextAfter(-32948748.958324F,-3327.191D));
		assertEquals("nextAfter(float,double)[60] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,+0.0D));
		assertEquals("nextAfter(float,double)[61] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,+0.001D));
		assertEquals("nextAfter(float,double)[62] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,+1.0D));
		assertEquals("nextAfter(float,double)[63] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,+10.0D));
		assertEquals("nextAfter(float,double)[64] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,+3327.191D));
		assertEquals("nextAfter(float,double)[65] ::", (float)-8.999999E-9, Math.nextAfter(-0.000000009F,-0.0D));
		assertEquals("nextAfter(float,double)[66] ::", (float)-9.000001E-9, Math.nextAfter(-0.000000009F,-0.001D));
		assertEquals("nextAfter(float,double)[67] ::", (float)-9.000001E-9, Math.nextAfter(-0.000000009F,-1.0D));
		assertEquals("nextAfter(float,double)[68] ::", (float)-9.000001E-9, Math.nextAfter(-0.000000009F,-10.0D));
		assertEquals("nextAfter(float,double)[69] ::", (float)-9.000001E-9, Math.nextAfter(-0.000000009F,-3327.191D));
		assertEquals("nextAfter(float,double)[70] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,+0.0D));
		assertEquals("nextAfter(float,double)[71] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,+0.001D));
		assertEquals("nextAfter(float,double)[72] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,+1.0D));
		assertEquals("nextAfter(float,double)[73] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,+10.0D));
		assertEquals("nextAfter(float,double)[74] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,+3327.191D));
		assertEquals("nextAfter(float,double)[75] ::", (float)-1.9999999E-7, Math.nextAfter(-0.0000002F,-0.0D));
		assertEquals("nextAfter(float,double)[76] ::", (float)-2.0000002E-7, Math.nextAfter(-0.0000002F,-0.001D));
		assertEquals("nextAfter(float,double)[77] ::", (float)-2.0000002E-7, Math.nextAfter(-0.0000002F,-1.0D));
		assertEquals("nextAfter(float,double)[78] ::", (float)-2.0000002E-7, Math.nextAfter(-0.0000002F,-10.0D));
		assertEquals("nextAfter(float,double)[79] ::", (float)-2.0000002E-7, Math.nextAfter(-0.0000002F,-3327.191D));
		assertEquals("nextAfter(float,double)[80] ::", (float)0.0, Math.nextAfter(0F,+0.0D));
		assertEquals("nextAfter(float,double)[81] ::", (float)1.4E-45, Math.nextAfter(0F,+0.001D));
		assertEquals("nextAfter(float,double)[82] ::", (float)1.4E-45, Math.nextAfter(0F,+1.0D));
		assertEquals("nextAfter(float,double)[83] ::", (float)1.4E-45, Math.nextAfter(0F,+10.0D));
		assertEquals("nextAfter(float,double)[84] ::", (float)1.4E-45, Math.nextAfter(0F,+3327.191D));
		assertEquals("nextAfter(float,double)[85] ::", (float)-0.0, Math.nextAfter(0F,-0.0D));
		assertEquals("nextAfter(float,double)[86] ::", (float)-1.4E-45, Math.nextAfter(0F,-0.001D));
		assertEquals("nextAfter(float,double)[87] ::", (float)-1.4E-45, Math.nextAfter(0F,-1.0D));
		assertEquals("nextAfter(float,double)[88] ::", (float)-1.4E-45, Math.nextAfter(0F,-10.0D));
		assertEquals("nextAfter(float,double)[89] ::", (float)-1.4E-45, Math.nextAfter(0F,-3327.191D));
		assertEquals("nextAfter(float,double)[90] ::", (float)0.4562323, Math.nextAfter(0.456232334F,+0.0D));
		assertEquals("nextAfter(float,double)[91] ::", (float)0.4562323, Math.nextAfter(0.456232334F,+0.001D));
		assertEquals("nextAfter(float,double)[92] ::", (float)0.45623237, Math.nextAfter(0.456232334F,+1.0D));
		assertEquals("nextAfter(float,double)[93] ::", (float)0.45623237, Math.nextAfter(0.456232334F,+10.0D));
		assertEquals("nextAfter(float,double)[94] ::", (float)0.45623237, Math.nextAfter(0.456232334F,+3327.191D));
		assertEquals("nextAfter(float,double)[95] ::", (float)0.4562323, Math.nextAfter(0.456232334F,-0.0D));
		assertEquals("nextAfter(float,double)[96] ::", (float)0.4562323, Math.nextAfter(0.456232334F,-0.001D));
		assertEquals("nextAfter(float,double)[97] ::", (float)0.4562323, Math.nextAfter(0.456232334F,-1.0D));
		assertEquals("nextAfter(float,double)[98] ::", (float)0.4562323, Math.nextAfter(0.456232334F,-10.0D));
		assertEquals("nextAfter(float,double)[99] ::", (float)0.4562323, Math.nextAfter(0.456232334F,-3327.191D));
		assertEquals("nextAfter(float,double)[100] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,+0.0D));
		assertEquals("nextAfter(float,double)[101] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,+0.001D));
		assertEquals("nextAfter(float,double)[102] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,+1.0D));
		assertEquals("nextAfter(float,double)[103] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,+10.0D));
		assertEquals("nextAfter(float,double)[104] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,+3327.191D));
		assertEquals("nextAfter(float,double)[105] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,-0.0D));
		assertEquals("nextAfter(float,double)[106] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,-0.001D));
		assertEquals("nextAfter(float,double)[107] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,-1.0D));
		assertEquals("nextAfter(float,double)[108] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,-10.0D));
		assertEquals("nextAfter(float,double)[109] ::", (float)1224257.1, Math.nextAfter(1224257.312321263F,-3327.191D));
		assertEquals("nextAfter(float,double)[110] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,+0.0D));
		assertEquals("nextAfter(float,double)[111] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,+0.001D));
		assertEquals("nextAfter(float,double)[112] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,+1.0D));
		assertEquals("nextAfter(float,double)[113] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,+10.0D));
		assertEquals("nextAfter(float,double)[114] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,+3327.191D));
		assertEquals("nextAfter(float,double)[115] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,-0.0D));
		assertEquals("nextAfter(float,double)[116] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,-0.001D));
		assertEquals("nextAfter(float,double)[117] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,-1.0D));
		assertEquals("nextAfter(float,double)[118] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,-10.0D));
		assertEquals("nextAfter(float,double)[119] ::", (float)9.999831E9, Math.nextAfter(9999832342.12365F,-3327.191D));
		assertEquals("nextAfter(float,double)[120] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,+0.0D));
		assertEquals("nextAfter(float,double)[121] ::", (float)2.8E-45, Math.nextAfter(Float.MIN_VALUE,+0.001D));
		assertEquals("nextAfter(float,double)[122] ::", (float)2.8E-45, Math.nextAfter(Float.MIN_VALUE,+1.0D));
		assertEquals("nextAfter(float,double)[123] ::", (float)2.8E-45, Math.nextAfter(Float.MIN_VALUE,+10.0D));
		assertEquals("nextAfter(float,double)[124] ::", (float)2.8E-45, Math.nextAfter(Float.MIN_VALUE,+3327.191D));
		assertEquals("nextAfter(float,double)[125] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,-0.0D));
		assertEquals("nextAfter(float,double)[126] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,-0.001D));
		assertEquals("nextAfter(float,double)[127] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,-1.0D));
		assertEquals("nextAfter(float,double)[128] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,-10.0D));
		assertEquals("nextAfter(float,double)[129] ::", (float)0.0, Math.nextAfter(Float.MIN_VALUE,-3327.191D));
		assertEquals("nextAfter(float,double)[130] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),+0.0D));
		assertEquals("nextAfter(float,double)[131] ::", (float)2.82E-43, Math.nextAfter((Float.MIN_VALUE * 200),+0.001D));
		assertEquals("nextAfter(float,double)[132] ::", (float)2.82E-43, Math.nextAfter((Float.MIN_VALUE * 200),+1.0D));
		assertEquals("nextAfter(float,double)[133] ::", (float)2.82E-43, Math.nextAfter((Float.MIN_VALUE * 200),+10.0D));
		assertEquals("nextAfter(float,double)[134] ::", (float)2.82E-43, Math.nextAfter((Float.MIN_VALUE * 200),+3327.191D));
		assertEquals("nextAfter(float,double)[135] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),-0.0D));
		assertEquals("nextAfter(float,double)[136] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),-0.001D));
		assertEquals("nextAfter(float,double)[137] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),-1.0D));
		assertEquals("nextAfter(float,double)[138] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),-10.0D));
		assertEquals("nextAfter(float,double)[139] ::", (float)2.79E-43, Math.nextAfter((Float.MIN_VALUE * 200),-3327.191D));
		assertEquals("nextAfter(float,double)[140] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),+0.0D));
		assertEquals("nextAfter(float,double)[141] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),+0.001D));
		assertEquals("nextAfter(float,double)[142] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),+1.0D));
		assertEquals("nextAfter(float,double)[143] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),+10.0D));
		assertEquals("nextAfter(float,double)[144] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),+3327.191D));
		assertEquals("nextAfter(float,double)[145] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),-0.0D));
		assertEquals("nextAfter(float,double)[146] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),-0.001D));
		assertEquals("nextAfter(float,double)[147] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),-1.0D));
		assertEquals("nextAfter(float,double)[148] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),-10.0D));
		assertEquals("nextAfter(float,double)[149] ::", (float)6.805646E35, Math.nextAfter((Float.MAX_VALUE / 500),-3327.191D));
		assertEquals("nextAfter(float,double)[150] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),+0.0D));
		assertEquals("nextAfter(float,double)[151] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),+0.001D));
		assertEquals("nextAfter(float,double)[152] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),+1.0D));
		assertEquals("nextAfter(float,double)[153] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),+10.0D));
		assertEquals("nextAfter(float,double)[154] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),+3327.191D));
		assertEquals("nextAfter(float,double)[155] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),-0.0D));
		assertEquals("nextAfter(float,double)[156] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),-0.001D));
		assertEquals("nextAfter(float,double)[157] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),-1.0D));
		assertEquals("nextAfter(float,double)[158] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),-10.0D));
		assertEquals("nextAfter(float,double)[159] ::", (float)1.7014116E36, Math.nextAfter((Float.MAX_VALUE / 200),-3327.191D));
		assertEquals("nextAfter(float,double)[160] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,+0.0D));
		assertEquals("nextAfter(float,double)[161] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,+0.001D));
		assertEquals("nextAfter(float,double)[162] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,+1.0D));
		assertEquals("nextAfter(float,double)[163] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,+10.0D));
		assertEquals("nextAfter(float,double)[164] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,+3327.191D));
		assertEquals("nextAfter(float,double)[165] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,-0.0D));
		assertEquals("nextAfter(float,double)[166] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,-0.001D));
		assertEquals("nextAfter(float,double)[167] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,-1.0D));
		assertEquals("nextAfter(float,double)[168] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,-10.0D));
		assertEquals("nextAfter(float,double)[169] ::", (float)3.4028233E38, Math.nextAfter(Float.MAX_VALUE,-3327.191D));
		assertEquals("nextAfter(float,double)[170] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),+0.0D));
		assertEquals("nextAfter(float,double)[171] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),+0.001D));
		assertEquals("nextAfter(float,double)[172] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),+1.0D));
		assertEquals("nextAfter(float,double)[173] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),+10.0D));
		assertEquals("nextAfter(float,double)[174] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),+3327.191D));
		assertEquals("nextAfter(float,double)[175] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),-0.0D));
		assertEquals("nextAfter(float,double)[176] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),-0.001D));
		assertEquals("nextAfter(float,double)[177] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),-1.0D));
		assertEquals("nextAfter(float,double)[178] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),-10.0D));
		assertEquals("nextAfter(float,double)[179] ::", (float)3.4028233E38, Math.nextAfter((Float.MAX_VALUE + 1),-3327.191D));
	}

	public void testNextUp_double()
	{
		assertEquals("nextUp(double)[0] ::", (double)-1.7976931348623155E308, Math.nextUp(-Double.MAX_VALUE));
		assertEquals("nextUp(double)[1] ::", (double)-8.988465674311577E305, Math.nextUp((-Double.MAX_VALUE / 200)));
		assertEquals("nextUp(double)[2] ::", (double)-3.59538626972463E305, Math.nextUp((-Double.MAX_VALUE / 500)));
		assertEquals("nextUp(double)[3] ::", (double)-9.876E-321, Math.nextUp((-Double.MIN_VALUE * 2000)));
		assertEquals("nextUp(double)[4] ::", (double)-4.936E-321, Math.nextUp((-Double.MIN_VALUE * 1000)));
		assertEquals("nextUp(double)[5] ::", (double)-2.929112212129231E9, Math.nextUp(-2929112212.129231481346));
		assertEquals("nextUp(double)[6] ::", (double)-2372.2282119999995, Math.nextUp(-2372.228212D));
		assertEquals("nextUp(double)[7] ::", (double)-1.2231999999999998, Math.nextUp(-1.2232D));
		assertEquals("nextUp(double)[8] ::", (double)4.9E-324, Math.nextUp(0D));
		assertEquals("nextUp(double)[9] ::", (double)2.4322300000000006, Math.nextUp(2.43223D));
		assertEquals("nextUp(double)[10] ::", (double)1.8232155332356602E7, Math.nextUp(18232155.3323566D));
		assertEquals("nextUp(double)[11] ::", (double)1.0E-323, Math.nextUp(Double.MIN_VALUE));
		assertEquals("nextUp(double)[12] ::", (double)9.93E-322, Math.nextUp((Double.MIN_VALUE * 200)));
		assertEquals("nextUp(double)[13] ::", (double)3.595386269724632E305, Math.nextUp((Double.MAX_VALUE / 500)));
		assertEquals("nextUp(double)[14] ::", (double)8.98846567431158E305, Math.nextUp((Double.MAX_VALUE / 200)));
		assertEquals("nextUp(double)[15] ::", (double)Infinity, Math.nextUp(Double.MAX_VALUE));
		assertEquals("nextUp(double)[16] ::", (double)Infinity, Math.nextUp(Double.MAX_VALUE + 1));
	}

	public void testNextUp_float()
	{
		assertEquals("nextUp(float)[0] ::", (float)-3.4028233E38, Math.nextUp(-Float.MAX_VALUE));
		assertEquals("nextUp(float)[1] ::", (float)-1.7014116E36, Math.nextUp((-Float.MAX_VALUE / 200)));
		assertEquals("nextUp(float)[2] ::", (float)-6.805646E35, Math.nextUp((-Float.MAX_VALUE / 500)));
		assertEquals("nextUp(float)[3] ::", (float)-2.801E-42, Math.nextUp((-Float.MIN_VALUE * 2000)));
		assertEquals("nextUp(float)[4] ::", (float)-1.4E-42, Math.nextUp((-Float.MIN_VALUE * 1000)));
		assertEquals("nextUp(float)[5] ::", (float)-3.2948746E7, Math.nextUp(-32948748.958324F));
		assertEquals("nextUp(float)[6] ::", (float)-8.999999E-9, Math.nextUp(-0.000000009F));
		assertEquals("nextUp(float)[7] ::", (float)-1.9999999E-7, Math.nextUp(-0.0000002F));
		assertEquals("nextUp(float)[8] ::", (float)1.4E-45, Math.nextUp(0F));
		assertEquals("nextUp(float)[9] ::", (float)0.45623237, Math.nextUp(0.456232334F));
		assertEquals("nextUp(float)[10] ::", (float)1224257.4, Math.nextUp(1224257.312321263F));
		assertEquals("nextUp(float)[11] ::", (float)9.9998331E9, Math.nextUp(9999832342.12365F));
		assertEquals("nextUp(float)[12] ::", (float)2.8E-45, Math.nextUp(Float.MIN_VALUE));
		assertEquals("nextUp(float)[13] ::", (float)2.82E-43, Math.nextUp((Float.MIN_VALUE * 200)));
		assertEquals("nextUp(float)[14] ::", (float)6.805648E35, Math.nextUp((Float.MAX_VALUE / 500)));
		assertEquals("nextUp(float)[15] ::", (float)1.701412E36, Math.nextUp((Float.MAX_VALUE / 200)));
		assertEquals("nextUp(float)[16] ::", (float)Infinity, Math.nextUp(Float.MAX_VALUE));
		assertEquals("nextUp(float)[17] ::", (float)Infinity, Math.nextUp((Float.MAX_VALUE + 1)));
	}

	public void testScalb_double()
	{
		assertEquals("scaleb(double,int)[0] ::", -1.7976931348623157E308, Math.scalb(-Double.MAX_VALUE,0));
		assertEquals("scaleb(double,int)[1] ::", -Infinity, Math.scalb(-Double.MAX_VALUE,1));
		assertEquals("scaleb(double,int)[2] ::", -Infinity, Math.scalb(-Double.MAX_VALUE,2));
		assertEquals("scaleb(double,int)[3] ::", -Infinity, Math.scalb(-Double.MAX_VALUE,5));
		assertEquals("scaleb(double,int)[4] ::", -Infinity, Math.scalb(-Double.MAX_VALUE,2012));
		assertEquals("scaleb(double,int)[5] ::", -0.0, Math.scalb(-Double.MAX_VALUE,-21287));
		assertEquals("scaleb(double,int)[6] ::", -8.988465674311579E307, Math.scalb(-Double.MAX_VALUE,-1));
		assertEquals("scaleb(double,int)[7] ::", -1.7976931348623157E308, Math.scalb(-Double.MAX_VALUE,-0));
		assertEquals("scaleb(double,int)[8] ::", -8.988465674311578E305, Math.scalb((-Double.MAX_VALUE / 200),0));
		assertEquals("scaleb(double,int)[9] ::", -1.7976931348623156E306, Math.scalb((-Double.MAX_VALUE / 200),1));
		assertEquals("scaleb(double,int)[10] ::", -3.595386269724631E306, Math.scalb((-Double.MAX_VALUE / 200),2));
		assertEquals("scaleb(double,int)[11] ::", -2.876309015779705E307, Math.scalb((-Double.MAX_VALUE / 200),5));
		assertEquals("scaleb(double,int)[12] ::", -Infinity, Math.scalb((-Double.MAX_VALUE / 200),2012));
		assertEquals("scaleb(double,int)[13] ::", -0.0, Math.scalb((-Double.MAX_VALUE / 200),-21287));
		assertEquals("scaleb(double,int)[14] ::", -4.494232837155789E305, Math.scalb((-Double.MAX_VALUE / 200),-1));
		assertEquals("scaleb(double,int)[15] ::", -8.988465674311578E305, Math.scalb((-Double.MAX_VALUE / 200),-0));
		assertEquals("scaleb(double,int)[16] ::", -3.595386269724631E305, Math.scalb((-Double.MAX_VALUE / 500),0));
		assertEquals("scaleb(double,int)[17] ::", -7.190772539449262E305, Math.scalb((-Double.MAX_VALUE / 500),1));
		assertEquals("scaleb(double,int)[18] ::", -1.4381545078898524E306, Math.scalb((-Double.MAX_VALUE / 500),2));
		assertEquals("scaleb(double,int)[19] ::", -1.150523606311882E307, Math.scalb((-Double.MAX_VALUE / 500),5));
		assertEquals("scaleb(double,int)[20] ::", -Infinity, Math.scalb((-Double.MAX_VALUE / 500),2012));
		assertEquals("scaleb(double,int)[21] ::", -0.0, Math.scalb((-Double.MAX_VALUE / 500),-21287));
		assertEquals("scaleb(double,int)[22] ::", -1.7976931348623156E305, Math.scalb((-Double.MAX_VALUE / 500),-1));
		assertEquals("scaleb(double,int)[23] ::", -3.595386269724631E305, Math.scalb((-Double.MAX_VALUE / 500),-0));
		assertEquals("scaleb(double,int)[24] ::", -9.88E-321, Math.scalb((-Double.MIN_VALUE * 2000),0));
		assertEquals("scaleb(double,int)[25] ::", -1.9763E-320, Math.scalb((-Double.MIN_VALUE * 2000),1));
		assertEquals("scaleb(double,int)[26] ::", -3.9525E-320, Math.scalb((-Double.MIN_VALUE * 2000),2));
		assertEquals("scaleb(double,int)[27] ::", -3.162E-319, Math.scalb((-Double.MIN_VALUE * 2000),5));
		assertEquals("scaleb(double,int)[28] ::", -4.646927838993072E285, Math.scalb((-Double.MIN_VALUE * 2000),2012));
		assertEquals("scaleb(double,int)[29] ::", -0.0, Math.scalb((-Double.MIN_VALUE * 2000),-21287));
		assertEquals("scaleb(double,int)[30] ::", -4.94E-321, Math.scalb((-Double.MIN_VALUE * 2000),-1));
		assertEquals("scaleb(double,int)[31] ::", -9.88E-321, Math.scalb((-Double.MIN_VALUE * 2000),-0));
		assertEquals("scaleb(double,int)[32] ::", -4.94E-321, Math.scalb((-Double.MIN_VALUE * 1000),0));
		assertEquals("scaleb(double,int)[33] ::", -9.88E-321, Math.scalb((-Double.MIN_VALUE * 1000),1));
		assertEquals("scaleb(double,int)[34] ::", -1.9763E-320, Math.scalb((-Double.MIN_VALUE * 1000),2));
		assertEquals("scaleb(double,int)[35] ::", -1.581E-319, Math.scalb((-Double.MIN_VALUE * 1000),5));
		assertEquals("scaleb(double,int)[36] ::", -2.323463919496536E285, Math.scalb((-Double.MIN_VALUE * 1000),2012));
		assertEquals("scaleb(double,int)[37] ::", -0.0, Math.scalb((-Double.MIN_VALUE * 1000),-21287));
		assertEquals("scaleb(double,int)[38] ::", -2.47E-321, Math.scalb((-Double.MIN_VALUE * 1000),-1));
		assertEquals("scaleb(double,int)[39] ::", -4.94E-321, Math.scalb((-Double.MIN_VALUE * 1000),-0));
		assertEquals("scaleb(double,int)[40] ::", -2.9291122121292315E9, Math.scalb(-2929112212.129231481346,0));
		assertEquals("scaleb(double,int)[41] ::", -5.858224424258463E9, Math.scalb(-2929112212.129231481346,1));
		assertEquals("scaleb(double,int)[42] ::", -1.1716448848516926E10, Math.scalb(-2929112212.129231481346,2));
		assertEquals("scaleb(double,int)[43] ::", -9.37315907881354E10, Math.scalb(-2929112212.129231481346,5));
		assertEquals("scaleb(double,int)[44] ::", -Infinity, Math.scalb(-2929112212.129231481346,2012));
		assertEquals("scaleb(double,int)[45] ::", -0.0, Math.scalb(-2929112212.129231481346,-21287));
		assertEquals("scaleb(double,int)[46] ::", -1.4645561060646157E9, Math.scalb(-2929112212.129231481346,-1));
		assertEquals("scaleb(double,int)[47] ::", -2.9291122121292315E9, Math.scalb(-2929112212.129231481346,-0));
		assertEquals("scaleb(double,int)[48] ::", -2372.228212, Math.scalb(-2372.228212D,0));
		assertEquals("scaleb(double,int)[49] ::", -4744.456424, Math.scalb(-2372.228212D,1));
		assertEquals("scaleb(double,int)[50] ::", -9488.912848, Math.scalb(-2372.228212D,2));
		assertEquals("scaleb(double,int)[51] ::", -75911.302784, Math.scalb(-2372.228212D,5));
		assertEquals("scaleb(double,int)[52] ::", -Infinity, Math.scalb(-2372.228212D,2012));
		assertEquals("scaleb(double,int)[53] ::", -0.0, Math.scalb(-2372.228212D,-21287));
		assertEquals("scaleb(double,int)[54] ::", -1186.114106, Math.scalb(-2372.228212D,-1));
		assertEquals("scaleb(double,int)[55] ::", -2372.228212, Math.scalb(-2372.228212D,-0));
		assertEquals("scaleb(double,int)[56] ::", -1.2232, Math.scalb(-1.2232D,0));
		assertEquals("scaleb(double,int)[57] ::", -2.4464, Math.scalb(-1.2232D,1));
		assertEquals("scaleb(double,int)[58] ::", -4.8928, Math.scalb(-1.2232D,2));
		assertEquals("scaleb(double,int)[59] ::", -39.1424, Math.scalb(-1.2232D,5));
		assertEquals("scaleb(double,int)[60] ::", -Infinity, Math.scalb(-1.2232D,2012));
		assertEquals("scaleb(double,int)[61] ::", -0.0, Math.scalb(-1.2232D,-21287));
		assertEquals("scaleb(double,int)[62] ::", -0.6116, Math.scalb(-1.2232D,-1));
		assertEquals("scaleb(double,int)[63] ::", -1.2232, Math.scalb(-1.2232D,-0));
		assertEquals("scaleb(double,int)[64] ::", 0.0, Math.scalb(0D,0));
		assertEquals("scaleb(double,int)[65] ::", 0.0, Math.scalb(0D,1));
		assertEquals("scaleb(double,int)[66] ::", 0.0, Math.scalb(0D,2));
		assertEquals("scaleb(double,int)[67] ::", 0.0, Math.scalb(0D,5));
		assertEquals("scaleb(double,int)[68] ::", 0.0, Math.scalb(0D,2012));
		assertEquals("scaleb(double,int)[69] ::", 0.0, Math.scalb(0D,-21287));
		assertEquals("scaleb(double,int)[70] ::", 0.0, Math.scalb(0D,-1));
		assertEquals("scaleb(double,int)[71] ::", 0.0, Math.scalb(0D,-0));
		assertEquals("scaleb(double,int)[72] ::", 2.43223, Math.scalb(2.43223D,0));
		assertEquals("scaleb(double,int)[73] ::", 4.86446, Math.scalb(2.43223D,1));
		assertEquals("scaleb(double,int)[74] ::", 9.72892, Math.scalb(2.43223D,2));
		assertEquals("scaleb(double,int)[75] ::", 77.83136, Math.scalb(2.43223D,5));
		assertEquals("scaleb(double,int)[76] ::", Infinity, Math.scalb(2.43223D,2012));
		assertEquals("scaleb(double,int)[77] ::", 0.0, Math.scalb(2.43223D,-21287));
		assertEquals("scaleb(double,int)[78] ::", 1.216115, Math.scalb(2.43223D,-1));
		assertEquals("scaleb(double,int)[79] ::", 2.43223, Math.scalb(2.43223D,-0));
		assertEquals("scaleb(double,int)[80] ::", 1.82321553323566E7, Math.scalb(18232155.3323566D,0));
		assertEquals("scaleb(double,int)[81] ::", 3.64643106647132E7, Math.scalb(18232155.3323566D,1));
		assertEquals("scaleb(double,int)[82] ::", 7.29286213294264E7, Math.scalb(18232155.3323566D,2));
		assertEquals("scaleb(double,int)[83] ::", 5.834289706354111E8, Math.scalb(18232155.3323566D,5));
		assertEquals("scaleb(double,int)[84] ::", Infinity, Math.scalb(18232155.3323566D,2012));
		assertEquals("scaleb(double,int)[85] ::", 0.0, Math.scalb(18232155.3323566D,-21287));
		assertEquals("scaleb(double,int)[86] ::", 9116077.6661783, Math.scalb(18232155.3323566D,-1));
		assertEquals("scaleb(double,int)[87] ::", 1.82321553323566E7, Math.scalb(18232155.3323566D,-0));
		assertEquals("scaleb(double,int)[88] ::", 4.9E-324, Math.scalb(Double.MIN_VALUE,0));
		assertEquals("scaleb(double,int)[89] ::", 1.0E-323, Math.scalb(Double.MIN_VALUE,1));
		assertEquals("scaleb(double,int)[90] ::", 2.0E-323, Math.scalb(Double.MIN_VALUE,2));
		assertEquals("scaleb(double,int)[91] ::", 1.58E-322, Math.scalb(Double.MIN_VALUE,5));
		assertEquals("scaleb(double,int)[92] ::", 2.323463919496536E282, Math.scalb(Double.MIN_VALUE,2012));
		assertEquals("scaleb(double,int)[93] ::", 0.0, Math.scalb(Double.MIN_VALUE,-21287));
		assertEquals("scaleb(double,int)[94] ::", 0.0, Math.scalb(Double.MIN_VALUE,-1));
		assertEquals("scaleb(double,int)[95] ::", 4.9E-324, Math.scalb(Double.MIN_VALUE,-0));
		assertEquals("scaleb(double,int)[96] ::", 9.9E-322, Math.scalb((Double.MIN_VALUE * 200),0));
		assertEquals("scaleb(double,int)[97] ::", 1.976E-321, Math.scalb((Double.MIN_VALUE * 200),1));
		assertEquals("scaleb(double,int)[98] ::", 3.953E-321, Math.scalb((Double.MIN_VALUE * 200),2));
		assertEquals("scaleb(double,int)[99] ::", 3.162E-320, Math.scalb((Double.MIN_VALUE * 200),5));
		assertEquals("scaleb(double,int)[100] ::", 4.646927838993072E284, Math.scalb((Double.MIN_VALUE * 200),2012));
		assertEquals("scaleb(double,int)[101] ::", 0.0, Math.scalb((Double.MIN_VALUE * 200),-21287));
		assertEquals("scaleb(double,int)[102] ::", 4.94E-322, Math.scalb((Double.MIN_VALUE * 200),-1));
		assertEquals("scaleb(double,int)[103] ::", 9.9E-322, Math.scalb((Double.MIN_VALUE * 200),-0));
		assertEquals("scaleb(double,int)[104] ::", 3.595386269724631E305, Math.scalb((Double.MAX_VALUE / 500),0));
		assertEquals("scaleb(double,int)[105] ::", 7.190772539449262E305, Math.scalb((Double.MAX_VALUE / 500),1));
		assertEquals("scaleb(double,int)[106] ::", 1.4381545078898524E306, Math.scalb((Double.MAX_VALUE / 500),2));
		assertEquals("scaleb(double,int)[107] ::", 1.150523606311882E307, Math.scalb((Double.MAX_VALUE / 500),5));
		assertEquals("scaleb(double,int)[108] ::", Infinity, Math.scalb((Double.MAX_VALUE / 500),2012));
		assertEquals("scaleb(double,int)[109] ::", 0.0, Math.scalb((Double.MAX_VALUE / 500),-21287));
		assertEquals("scaleb(double,int)[110] ::", 1.7976931348623156E305, Math.scalb((Double.MAX_VALUE / 500),-1));
		assertEquals("scaleb(double,int)[111] ::", 3.595386269724631E305, Math.scalb((Double.MAX_VALUE / 500),-0));
		assertEquals("scaleb(double,int)[112] ::", 8.988465674311578E305, Math.scalb((Double.MAX_VALUE / 200),0));
		assertEquals("scaleb(double,int)[113] ::", 1.7976931348623156E306, Math.scalb((Double.MAX_VALUE / 200),1));
		assertEquals("scaleb(double,int)[114] ::", 3.595386269724631E306, Math.scalb((Double.MAX_VALUE / 200),2));
		assertEquals("scaleb(double,int)[115] ::", 2.876309015779705E307, Math.scalb((Double.MAX_VALUE / 200),5));
		assertEquals("scaleb(double,int)[116] ::", Infinity, Math.scalb((Double.MAX_VALUE / 200),2012));
		assertEquals("scaleb(double,int)[117] ::", 0.0, Math.scalb((Double.MAX_VALUE / 200),-21287));
		assertEquals("scaleb(double,int)[118] ::", 4.494232837155789E305, Math.scalb((Double.MAX_VALUE / 200),-1));
		assertEquals("scaleb(double,int)[119] ::", 8.988465674311578E305, Math.scalb((Double.MAX_VALUE / 200),-0));
		assertEquals("scaleb(double,int)[120] ::", 1.7976931348623157E308, Math.scalb(Double.MAX_VALUE,0));
		assertEquals("scaleb(double,int)[121] ::", Infinity, Math.scalb(Double.MAX_VALUE,1));
		assertEquals("scaleb(double,int)[122] ::", Infinity, Math.scalb(Double.MAX_VALUE,2));
		assertEquals("scaleb(double,int)[123] ::", Infinity, Math.scalb(Double.MAX_VALUE,5));
		assertEquals("scaleb(double,int)[124] ::", Infinity, Math.scalb(Double.MAX_VALUE,2012));
		assertEquals("scaleb(double,int)[125] ::", 0.0, Math.scalb(Double.MAX_VALUE,-21287));
		assertEquals("scaleb(double,int)[126] ::", 8.988465674311579E307, Math.scalb(Double.MAX_VALUE,-1));
		assertEquals("scaleb(double,int)[127] ::", 1.7976931348623157E308, Math.scalb(Double.MAX_VALUE,-0));
		assertEquals("scaleb(double,int)[128] ::", 1.7976931348623157E308, Math.scalb(Double.MAX_VALUE + 1,0));
		assertEquals("scaleb(double,int)[129] ::", Infinity, Math.scalb(Double.MAX_VALUE + 1,1));
		assertEquals("scaleb(double,int)[130] ::", Infinity, Math.scalb(Double.MAX_VALUE + 1,2));
		assertEquals("scaleb(double,int)[131] ::", Infinity, Math.scalb(Double.MAX_VALUE + 1,5));
		assertEquals("scaleb(double,int)[132] ::", Infinity, Math.scalb(Double.MAX_VALUE + 1,2012));
		assertEquals("scaleb(double,int)[133] ::", 0.0, Math.scalb(Double.MAX_VALUE + 1,-21287));
		assertEquals("scaleb(double,int)[134] ::", 8.988465674311579E307, Math.scalb(Double.MAX_VALUE + 1,-1));
		assertEquals("scaleb(double,int)[135] ::", 1.7976931348623157E308, Math.scalb(Double.MAX_VALUE + 1,-0));
	}

	public void testScalb_float()
	{
		assertEquals("scaleb(float,int)[0] ::", (float)-3.4028235E38, Math.scalb(-Float.MAX_VALUE,0));
		assertEquals("scaleb(float,int)[1] ::", (float)-Infinity, Math.scalb(-Float.MAX_VALUE,1));
		assertEquals("scaleb(float,int)[2] ::", (float)-Infinity, Math.scalb(-Float.MAX_VALUE,2));
		assertEquals("scaleb(float,int)[3] ::", (float)-Infinity, Math.scalb(-Float.MAX_VALUE,5));
		assertEquals("scaleb(float,int)[4] ::", (float)-Infinity, Math.scalb(-Float.MAX_VALUE,2012));
		assertEquals("scaleb(float,int)[5] ::", (float)-0.0, Math.scalb(-Float.MAX_VALUE,-21287));
		assertEquals("scaleb(float,int)[6] ::", (float)-1.7014117E38, Math.scalb(-Float.MAX_VALUE,-1));
		assertEquals("scaleb(float,int)[7] ::", (float)-3.4028235E38, Math.scalb(-Float.MAX_VALUE,-0));
		assertEquals("scaleb(float,int)[8] ::", (float)-1.7014118E36, Math.scalb((-Float.MAX_VALUE / 200),0));
		assertEquals("scaleb(float,int)[9] ::", (float)-3.4028236E36, Math.scalb((-Float.MAX_VALUE / 200),1));
		assertEquals("scaleb(float,int)[10] ::", (float)-6.805647E36, Math.scalb((-Float.MAX_VALUE / 200),2));
		assertEquals("scaleb(float,int)[11] ::", (float)-5.444518E37, Math.scalb((-Float.MAX_VALUE / 200),5));
		assertEquals("scaleb(float,int)[12] ::", (float)-Infinity, Math.scalb((-Float.MAX_VALUE / 200),2012));
		assertEquals("scaleb(float,int)[13] ::", (float)-0.0, Math.scalb((-Float.MAX_VALUE / 200),-21287));
		assertEquals("scaleb(float,int)[14] ::", (float)-8.507059E35, Math.scalb((-Float.MAX_VALUE / 200),-1));
		assertEquals("scaleb(float,int)[15] ::", (float)-1.7014118E36, Math.scalb((-Float.MAX_VALUE / 200),-0));
		assertEquals("scaleb(float,int)[16] ::", (float)-6.805647E35, Math.scalb((-Float.MAX_VALUE / 500),0));
		assertEquals("scaleb(float,int)[17] ::", (float)-1.3611294E36, Math.scalb((-Float.MAX_VALUE / 500),1));
		assertEquals("scaleb(float,int)[18] ::", (float)-2.7222587E36, Math.scalb((-Float.MAX_VALUE / 500),2));
		assertEquals("scaleb(float,int)[19] ::", (float)-2.177807E37, Math.scalb((-Float.MAX_VALUE / 500),5));
		assertEquals("scaleb(float,int)[20] ::", (float)-Infinity, Math.scalb((-Float.MAX_VALUE / 500),2012));
		assertEquals("scaleb(float,int)[21] ::", (float)-0.0, Math.scalb((-Float.MAX_VALUE / 500),-21287));
		assertEquals("scaleb(float,int)[22] ::", (float)-3.4028234E35, Math.scalb((-Float.MAX_VALUE / 500),-1));
		assertEquals("scaleb(float,int)[23] ::", (float)-6.805647E35, Math.scalb((-Float.MAX_VALUE / 500),-0));
		assertEquals("scaleb(float,int)[24] ::", (float)-2.803E-42, Math.scalb((-Float.MIN_VALUE * 2000),0));
		assertEquals("scaleb(float,int)[25] ::", (float)-5.605E-42, Math.scalb((-Float.MIN_VALUE * 2000),1));
		assertEquals("scaleb(float,int)[26] ::", (float)-1.121E-41, Math.scalb((-Float.MIN_VALUE * 2000),2));
		assertEquals("scaleb(float,int)[27] ::", (float)-8.9683E-41, Math.scalb((-Float.MIN_VALUE * 2000),5));
		assertEquals("scaleb(float,int)[28] ::", (float)-Infinity, Math.scalb((-Float.MIN_VALUE * 2000),2012));
		assertEquals("scaleb(float,int)[29] ::", (float)-0.0, Math.scalb((-Float.MIN_VALUE * 2000),-21287));
		assertEquals("scaleb(float,int)[30] ::", (float)-1.401E-42, Math.scalb((-Float.MIN_VALUE * 2000),-1));
		assertEquals("scaleb(float,int)[31] ::", (float)-2.803E-42, Math.scalb((-Float.MIN_VALUE * 2000),-0));
		assertEquals("scaleb(float,int)[32] ::", (float)-1.401E-42, Math.scalb((-Float.MIN_VALUE * 1000),0));
		assertEquals("scaleb(float,int)[33] ::", (float)-2.803E-42, Math.scalb((-Float.MIN_VALUE * 1000),1));
		assertEquals("scaleb(float,int)[34] ::", (float)-5.605E-42, Math.scalb((-Float.MIN_VALUE * 1000),2));
		assertEquals("scaleb(float,int)[35] ::", (float)-4.4842E-41, Math.scalb((-Float.MIN_VALUE * 1000),5));
		assertEquals("scaleb(float,int)[36] ::", (float)-Infinity, Math.scalb((-Float.MIN_VALUE * 1000),2012));
		assertEquals("scaleb(float,int)[37] ::", (float)-0.0, Math.scalb((-Float.MIN_VALUE * 1000),-21287));
		assertEquals("scaleb(float,int)[38] ::", (float)-7.0E-43, Math.scalb((-Float.MIN_VALUE * 1000),-1));
		assertEquals("scaleb(float,int)[39] ::", (float)-1.401E-42, Math.scalb((-Float.MIN_VALUE * 1000),-0));
		assertEquals("scaleb(float,int)[40] ::", (float)-3.2948748E7, Math.scalb(-32948748.958324F,0));
		assertEquals("scaleb(float,int)[41] ::", (float)-6.5897496E7, Math.scalb(-32948748.958324F,1));
		assertEquals("scaleb(float,int)[42] ::", (float)-1.31794992E8, Math.scalb(-32948748.958324F,2));
		assertEquals("scaleb(float,int)[43] ::", (float)-1.05435994E9, Math.scalb(-32948748.958324F,5));
		assertEquals("scaleb(float,int)[44] ::", (float)-Infinity, Math.scalb(-32948748.958324F,2012));
		assertEquals("scaleb(float,int)[45] ::", (float)-0.0, Math.scalb(-32948748.958324F,-21287));
		assertEquals("scaleb(float,int)[46] ::", (float)-1.6474374E7, Math.scalb(-32948748.958324F,-1));
		assertEquals("scaleb(float,int)[47] ::", (float)-3.2948748E7, Math.scalb(-32948748.958324F,-0));
		assertEquals("scaleb(float,int)[48] ::", (float)-9.0E-9, Math.scalb(-0.000000009F,0));
		assertEquals("scaleb(float,int)[49] ::", (float)-1.8E-8, Math.scalb(-0.000000009F,1));
		assertEquals("scaleb(float,int)[50] ::", (float)-3.6E-8, Math.scalb(-0.000000009F,2));
		assertEquals("scaleb(float,int)[51] ::", (float)-2.88E-7, Math.scalb(-0.000000009F,5));
		assertEquals("scaleb(float,int)[52] ::", (float)-Infinity, Math.scalb(-0.000000009F,2012));
		assertEquals("scaleb(float,int)[53] ::", (float)-0.0, Math.scalb(-0.000000009F,-21287));
		assertEquals("scaleb(float,int)[54] ::", (float)-4.5E-9, Math.scalb(-0.000000009F,-1));
		assertEquals("scaleb(float,int)[55] ::", (float)-9.0E-9, Math.scalb(-0.000000009F,-0));
		assertEquals("scaleb(float,int)[56] ::", (float)-2.0E-7, Math.scalb(-0.0000002F,0));
		assertEquals("scaleb(float,int)[57] ::", (float)-4.0E-7, Math.scalb(-0.0000002F,1));
		assertEquals("scaleb(float,int)[58] ::", (float)-8.0E-7, Math.scalb(-0.0000002F,2));
		assertEquals("scaleb(float,int)[59] ::", (float)-6.4E-6, Math.scalb(-0.0000002F,5));
		assertEquals("scaleb(float,int)[60] ::", (float)-Infinity, Math.scalb(-0.0000002F,2012));
		assertEquals("scaleb(float,int)[61] ::", (float)-0.0, Math.scalb(-0.0000002F,-21287));
		assertEquals("scaleb(float,int)[62] ::", (float)-1.0E-7, Math.scalb(-0.0000002F,-1));
		assertEquals("scaleb(float,int)[63] ::", (float)-2.0E-7, Math.scalb(-0.0000002F,-0));
		assertEquals("scaleb(float,int)[64] ::", (float)0.0, Math.scalb(0F,0));
		assertEquals("scaleb(float,int)[65] ::", (float)0.0, Math.scalb(0F,1));
		assertEquals("scaleb(float,int)[66] ::", (float)0.0, Math.scalb(0F,2));
		assertEquals("scaleb(float,int)[67] ::", (float)0.0, Math.scalb(0F,5));
		assertEquals("scaleb(float,int)[68] ::", (float)0.0, Math.scalb(0F,2012));
		assertEquals("scaleb(float,int)[69] ::", (float)0.0, Math.scalb(0F,-21287));
		assertEquals("scaleb(float,int)[70] ::", (float)0.0, Math.scalb(0F,-1));
		assertEquals("scaleb(float,int)[71] ::", (float)0.0, Math.scalb(0F,-0));
		assertEquals("scaleb(float,int)[72] ::", (float)0.45623234, Math.scalb(0.456232334F,0));
		assertEquals("scaleb(float,int)[73] ::", (float)0.9124647, Math.scalb(0.456232334F,1));
		assertEquals("scaleb(float,int)[74] ::", (float)1.8249294, Math.scalb(0.456232334F,2));
		assertEquals("scaleb(float,int)[75] ::", (float)14.599435, Math.scalb(0.456232334F,5));
		assertEquals("scaleb(float,int)[76] ::", (float)Infinity, Math.scalb(0.456232334F,2012));
		assertEquals("scaleb(float,int)[77] ::", (float)0.0, Math.scalb(0.456232334F,-21287));
		assertEquals("scaleb(float,int)[78] ::", (float)0.22811617, Math.scalb(0.456232334F,-1));
		assertEquals("scaleb(float,int)[79] ::", (float)0.45623234, Math.scalb(0.456232334F,-0));
		assertEquals("scaleb(float,int)[80] ::", (float)1224257.2, Math.scalb(1224257.312321263F,0));
		assertEquals("scaleb(float,int)[81] ::", (float)2448514.5, Math.scalb(1224257.312321263F,1));
		assertEquals("scaleb(float,int)[82] ::", (float)4897029.0, Math.scalb(1224257.312321263F,2));
		assertEquals("scaleb(float,int)[83] ::", (float)3.9176232E7, Math.scalb(1224257.312321263F,5));
		assertEquals("scaleb(float,int)[84] ::", (float)Infinity, Math.scalb(1224257.312321263F,2012));
		assertEquals("scaleb(float,int)[85] ::", (float)0.0, Math.scalb(1224257.312321263F,-21287));
		assertEquals("scaleb(float,int)[86] ::", (float)612128.6, Math.scalb(1224257.312321263F,-1));
		assertEquals("scaleb(float,int)[87] ::", (float)1224257.2, Math.scalb(1224257.312321263F,-0));
		assertEquals("scaleb(float,int)[88] ::", (float)9.9998321E9, Math.scalb(9999832342.12365F,0));
		assertEquals("scaleb(float,int)[89] ::", (float)1.99996641E10, Math.scalb(9999832342.12365F,1));
		assertEquals("scaleb(float,int)[90] ::", (float)3.9999328E10, Math.scalb(9999832342.12365F,2));
		assertEquals("scaleb(float,int)[91] ::", (float)3.19994626E11, Math.scalb(9999832342.12365F,5));
		assertEquals("scaleb(float,int)[92] ::", (float)Infinity, Math.scalb(9999832342.12365F,2012));
		assertEquals("scaleb(float,int)[93] ::", (float)0.0, Math.scalb(9999832342.12365F,-21287));
		assertEquals("scaleb(float,int)[94] ::", (float)4.999916E9, Math.scalb(9999832342.12365F,-1));
		assertEquals("scaleb(float,int)[95] ::", (float)9.9998321E9, Math.scalb(9999832342.12365F,-0));
		assertEquals("scaleb(float,int)[96] ::", (float)1.4E-45, Math.scalb(Float.MIN_VALUE,0));
		assertEquals("scaleb(float,int)[97] ::", (float)2.8E-45, Math.scalb(Float.MIN_VALUE,1));
		assertEquals("scaleb(float,int)[98] ::", (float)5.6E-45, Math.scalb(Float.MIN_VALUE,2));
		assertEquals("scaleb(float,int)[99] ::", (float)4.5E-44, Math.scalb(Float.MIN_VALUE,5));
		assertEquals("scaleb(float,int)[100] ::", (float)Infinity, Math.scalb(Float.MIN_VALUE,2012));
		assertEquals("scaleb(float,int)[101] ::", (float)0.0, Math.scalb(Float.MIN_VALUE,-21287));
		assertEquals("scaleb(float,int)[102] ::", (float)0.0, Math.scalb(Float.MIN_VALUE,-1));
		assertEquals("scaleb(float,int)[103] ::", (float)1.4E-45, Math.scalb(Float.MIN_VALUE,-0));
		assertEquals("scaleb(float,int)[104] ::", (float)2.8E-43, Math.scalb((Float.MIN_VALUE * 200),0));
		assertEquals("scaleb(float,int)[105] ::", (float)5.6E-43, Math.scalb((Float.MIN_VALUE * 200),1));
		assertEquals("scaleb(float,int)[106] ::", (float)1.121E-42, Math.scalb((Float.MIN_VALUE * 200),2));
		assertEquals("scaleb(float,int)[107] ::", (float)8.968E-42, Math.scalb((Float.MIN_VALUE * 200),5));
		assertEquals("scaleb(float,int)[108] ::", (float)Infinity, Math.scalb((Float.MIN_VALUE * 200),2012));
		assertEquals("scaleb(float,int)[109] ::", (float)0.0, Math.scalb((Float.MIN_VALUE * 200),-21287));
		assertEquals("scaleb(float,int)[110] ::", (float)1.4E-43, Math.scalb((Float.MIN_VALUE * 200),-1));
		assertEquals("scaleb(float,int)[111] ::", (float)2.8E-43, Math.scalb((Float.MIN_VALUE * 200),-0));
		assertEquals("scaleb(float,int)[112] ::", (float)6.805647E35, Math.scalb((Float.MAX_VALUE / 500),0));
		assertEquals("scaleb(float,int)[113] ::", (float)1.3611294E36, Math.scalb((Float.MAX_VALUE / 500),1));
		assertEquals("scaleb(float,int)[114] ::", (float)2.7222587E36, Math.scalb((Float.MAX_VALUE / 500),2));
		assertEquals("scaleb(float,int)[115] ::", (float)2.177807E37, Math.scalb((Float.MAX_VALUE / 500),5));
		assertEquals("scaleb(float,int)[116] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE / 500),2012));
		assertEquals("scaleb(float,int)[117] ::", (float)0.0, Math.scalb((Float.MAX_VALUE / 500),-21287));
		assertEquals("scaleb(float,int)[118] ::", (float)3.4028234E35, Math.scalb((Float.MAX_VALUE / 500),-1));
		assertEquals("scaleb(float,int)[119] ::", (float)6.805647E35, Math.scalb((Float.MAX_VALUE / 500),-0));
		assertEquals("scaleb(float,int)[120] ::", (float)1.7014118E36, Math.scalb((Float.MAX_VALUE / 200),0));
		assertEquals("scaleb(float,int)[121] ::", (float)3.4028236E36, Math.scalb((Float.MAX_VALUE / 200),1));
		assertEquals("scaleb(float,int)[122] ::", (float)6.805647E36, Math.scalb((Float.MAX_VALUE / 200),2));
		assertEquals("scaleb(float,int)[123] ::", (float)5.444518E37, Math.scalb((Float.MAX_VALUE / 200),5));
		assertEquals("scaleb(float,int)[124] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE / 200),2012));
		assertEquals("scaleb(float,int)[125] ::", (float)0.0, Math.scalb((Float.MAX_VALUE / 200),-21287));
		assertEquals("scaleb(float,int)[126] ::", (float)8.507059E35, Math.scalb((Float.MAX_VALUE / 200),-1));
		assertEquals("scaleb(float,int)[127] ::", (float)1.7014118E36, Math.scalb((Float.MAX_VALUE / 200),-0));
		assertEquals("scaleb(float,int)[128] ::", (float)3.4028235E38, Math.scalb(Float.MAX_VALUE,0));
		assertEquals("scaleb(float,int)[129] ::", (float)Infinity, Math.scalb(Float.MAX_VALUE,1));
		assertEquals("scaleb(float,int)[130] ::", (float)Infinity, Math.scalb(Float.MAX_VALUE,2));
		assertEquals("scaleb(float,int)[131] ::", (float)Infinity, Math.scalb(Float.MAX_VALUE,5));
		assertEquals("scaleb(float,int)[132] ::", (float)Infinity, Math.scalb(Float.MAX_VALUE,2012));
		assertEquals("scaleb(float,int)[133] ::", (float)0.0, Math.scalb(Float.MAX_VALUE,-21287));
		assertEquals("scaleb(float,int)[134] ::", (float)1.7014117E38, Math.scalb(Float.MAX_VALUE,-1));
		assertEquals("scaleb(float,int)[135] ::", (float)3.4028235E38, Math.scalb(Float.MAX_VALUE,-0));
		assertEquals("scaleb(float,int)[136] ::", (float)3.4028235E38, Math.scalb((Float.MAX_VALUE + 1),0));
		assertEquals("scaleb(float,int)[137] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE + 1),1));
		assertEquals("scaleb(float,int)[138] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE + 1),2));
		assertEquals("scaleb(float,int)[139] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE + 1),5));
		assertEquals("scaleb(float,int)[140] ::", (float)Infinity, Math.scalb((Float.MAX_VALUE + 1),2012));
		assertEquals("scaleb(float,int)[141] ::", (float)0.0, Math.scalb((Float.MAX_VALUE + 1),-21287));
		assertEquals("scaleb(float,int)[142] ::", (float)1.7014117E38, Math.scalb((Float.MAX_VALUE + 1),-1));
		assertEquals("scaleb(float,int)[143] ::", (float)3.4028235E38, Math.scalb((Float.MAX_VALUE + 1),-0));
	}

	public void testPow()
	{
		assertEquals("pow(double)[0] ::", 1.0, Math.pow(2.43223D, 0.0D));
		assertEquals("pow(double)[1] ::", 2.43223, Math.pow(2.43223D, 1.0D));
		assertEquals("pow(double)[2] ::", 1.192932595380642E130, Math.pow(2.43223D, 336.982D));
		assertEquals("pow(double)[3] ::", 0.4111453275389252, Math.pow(2.43223D, -1.0D));
		assertEquals("pow(double)[4] ::", 0.9999111230965859, Math.pow(2.43223D, -0.0001D));
		assertEquals("pow(double)[5] ::", 8.382703296667981E-131, Math.pow(2.43223D, -336.982D));
		assertEquals("pow(double)[6] ::", 8.686644887130356, Math.pow(2.43223D,2.43223D));
		assertEquals("pow(double)[7] ::", 1.0, Math.pow(18232155.3323566D, 0.0D));
		assertEquals("pow(double)[8] ::", 1.82321553323566E7, Math.pow(18232155.3323566D, 1.0D));
		assertEquals("pow(double)[9] ::", Infinity, Math.pow(18232155.3323566D, 336.982D));
		assertEquals("pow(double)[10] ::", 5.4848150521474574E-8, Math.pow(18232155.3323566D, -1.0D));
		assertEquals("pow(double)[11] ::", 0.9983295270587165, Math.pow(18232155.3323566D, -0.0001D));
		assertEquals("pow(double)[12] ::", 0.0, Math.pow(18232155.3323566D, -336.982D));
		assertEquals("pow(double)[13] ::", Infinity, Math.pow(18232155.3323566D,18232155.3323566D));
		assertEquals("pow(double)[14] ::", 1.0, Math.pow(Double.MIN_VALUE, 0.0D));
		assertEquals("pow(double)[15] ::", 4.9E-324, Math.pow(Double.MIN_VALUE, 1.0D));
		assertEquals("pow(double)[16] ::", 0.0, Math.pow(Double.MIN_VALUE, 336.982D));
		assertEquals("pow(double)[17] ::", Infinity, Math.pow(Double.MIN_VALUE, -1.0D));
		assertEquals("pow(double)[18] ::", 1.0772850216202463, Math.pow(Double.MIN_VALUE, -0.0001D));
		assertEquals("pow(double)[19] ::", Infinity, Math.pow(Double.MIN_VALUE, -336.982D));
		assertEquals("pow(double)[20] ::", 1.0, Math.pow(Double.MIN_VALUE,Double.MIN_VALUE));
		assertEquals("pow(double)[21] ::", 1.0, Math.pow((Double.MIN_VALUE * 200), 0.0D));
		assertEquals("pow(double)[22] ::", 9.9E-322, Math.pow((Double.MIN_VALUE * 200), 1.0D));
		assertEquals("pow(double)[23] ::", 0.0, Math.pow((Double.MIN_VALUE * 200), 336.982D));
		assertEquals("pow(double)[24] ::", Infinity, Math.pow((Double.MIN_VALUE * 200), -1.0D));
		assertEquals("pow(double)[25] ::", 1.0767143930082923, Math.pow((Double.MIN_VALUE * 200), -0.0001D));
		assertEquals("pow(double)[26] ::", Infinity, Math.pow((Double.MIN_VALUE * 200), -336.982D));
		assertEquals("pow(double)[27] ::", 1.0, Math.pow((Double.MIN_VALUE * 200),(Double.MIN_VALUE * 200)));
		assertEquals("pow(double)[28] ::", 1.0, Math.pow((Double.MAX_VALUE / 500), 0.0D));
		assertEquals("pow(double)[29] ::", 3.595386269724631E305, Math.pow((Double.MAX_VALUE / 500), 1.0D));
		assertEquals("pow(double)[30] ::", Infinity, Math.pow((Double.MAX_VALUE / 500), 336.982D));
		assertEquals("pow(double)[31] ::", 2.7813423231340024E-306, Math.pow((Double.MAX_VALUE / 500), -1.0D));
		assertEquals("pow(double)[32] ::", 0.9320611913661917, Math.pow((Double.MAX_VALUE / 500), -0.0001D));
		assertEquals("pow(double)[33] ::", 0.0, Math.pow((Double.MAX_VALUE / 500), -336.982D));
		assertEquals("pow(double)[34] ::", Infinity, Math.pow((Double.MAX_VALUE / 500),(Double.MAX_VALUE / 500)));
		assertEquals("pow(double)[35] ::", 1.0, Math.pow((Double.MAX_VALUE / 200), 0.0D));
		assertEquals("pow(double)[36] ::", 8.988465674311578E305, Math.pow((Double.MAX_VALUE / 200), 1.0D));
		assertEquals("pow(double)[37] ::", Infinity, Math.pow((Double.MAX_VALUE / 200), 336.982D));
		assertEquals("pow(double)[38] ::", 1.1125369292536008E-306, Math.pow((Double.MAX_VALUE / 200), -1.0D));
		assertEquals("pow(double)[39] ::", 0.9319757913756936, Math.pow((Double.MAX_VALUE / 200), -0.0001D));
		assertEquals("pow(double)[40] ::", 0.0, Math.pow((Double.MAX_VALUE / 200), -336.982D));
		assertEquals("pow(double)[41] ::", Infinity, Math.pow((Double.MAX_VALUE / 200),(Double.MAX_VALUE / 200)));
		assertEquals("pow(double)[42] ::", 1.0, Math.pow(Double.MAX_VALUE, 0.0D));
		assertEquals("pow(double)[43] ::", 1.7976931348623157E308, Math.pow(Double.MAX_VALUE, 1.0D));
		assertEquals("pow(double)[44] ::", Infinity, Math.pow(Double.MAX_VALUE, 336.982D));
		assertEquals("pow(double)[45] ::", 5.562684646268003E-309, Math.pow(Double.MAX_VALUE, -1.0D));
		assertEquals("pow(double)[46] ::", 0.9314821318134288, Math.pow(Double.MAX_VALUE, -0.0001D));
		assertEquals("pow(double)[47] ::", 0.0, Math.pow(Double.MAX_VALUE, -336.982D));
		assertEquals("pow(double)[48] ::", Infinity, Math.pow(Double.MAX_VALUE,Double.MAX_VALUE));
		assertEquals("pow(double)[49] ::", 1.0, Math.pow(Double.MAX_VALUE + 1, 0.0D));
		assertEquals("pow(double)[50] ::", 1.7976931348623157E308, Math.pow(Double.MAX_VALUE + 1, 1.0D));
		assertEquals("pow(double)[51] ::", Infinity, Math.pow(Double.MAX_VALUE + 1, 336.982D));
		assertEquals("pow(double)[52] ::", 5.562684646268003E-309, Math.pow(Double.MAX_VALUE + 1, -1.0D));
		assertEquals("pow(double)[53] ::", 0.9314821318134288, Math.pow(Double.MAX_VALUE + 1, -0.0001D));
		assertEquals("pow(double)[54] ::", 0.0, Math.pow(Double.MAX_VALUE + 1, -336.982D));
		assertEquals("pow(double)[55] ::", Infinity, Math.pow(Double.MAX_VALUE + 1,Double.MAX_VALUE + 1));
	}

	public void testRint()
	{
		assertEquals("rint(double)[0] ::", -1.7976931348623157E308, Math.rint(-Double.MAX_VALUE));
		assertEquals("rint(double)[1] ::", -8.988465674311578E305, Math.rint((-Double.MAX_VALUE / 200)));
		assertEquals("rint(double)[2] ::", -3.595386269724631E305, Math.rint((-Double.MAX_VALUE / 500)));
		assertEquals("rint(double)[3] ::", -0.0, Math.rint((-Double.MIN_VALUE * 2000)));
		assertEquals("rint(double)[4] ::", -0.0, Math.rint((-Double.MIN_VALUE * 1000)));
		assertEquals("rint(double)[5] ::", -2.929112212E9, Math.rint(-2929112212.129231481346));
		assertEquals("rint(double)[6] ::", -2372.0, Math.rint(-2372.228212D));
		assertEquals("rint(double)[7] ::", -1.0, Math.rint(-1.2232D));
		assertEquals("rint(double)[8] ::", 0.0, Math.rint(0D));
		assertEquals("rint(double)[9] ::", 2.0, Math.rint(2.43223D));
		assertEquals("rint(double)[10] ::", 1.8232155E7, Math.rint(18232155.3323566D));
		assertEquals("rint(double)[11] ::", 0.0, Math.rint(Double.MIN_VALUE));
		assertEquals("rint(double)[12] ::", 0.0, Math.rint((Double.MIN_VALUE * 200)));
		assertEquals("rint(double)[13] ::", 3.595386269724631E305, Math.rint((Double.MAX_VALUE / 500)));
		assertEquals("rint(double)[14] ::", 8.988465674311578E305, Math.rint((Double.MAX_VALUE / 200)));
		assertEquals("rint(double)[15] ::", 1.7976931348623157E308, Math.rint(Double.MAX_VALUE));
		assertEquals("rint(double)[16] ::", 1.7976931348623157E308, Math.rint(Double.MAX_VALUE + 1));
	}

	public void testRound_double()
	{
		assertEquals("round(double)[0] ::", -9223372036854775808L, Math.round(-Double.MAX_VALUE));
		assertEquals("round(double)[1] ::", -9223372036854775808L, Math.round((-Double.MAX_VALUE / 200)));
		assertEquals("round(double)[2] ::", -9223372036854775808L, Math.round((-Double.MAX_VALUE / 500)));
		assertEquals("round(double)[3] ::", 0L, Math.round((-Double.MIN_VALUE * 2000)));
		assertEquals("round(double)[4] ::", 0L, Math.round((-Double.MIN_VALUE * 1000)));
		assertEquals("round(double)[5] ::", -2929112212L, Math.round(-2929112212.129231481346));
		assertEquals("round(double)[6] ::", -2372L, Math.round(-2372.228212D));
		assertEquals("round(double)[7] ::", -1L, Math.round(-1.2232D));
		assertEquals("round(double)[8] ::", 0L, Math.round(0D));
		assertEquals("round(double)[9] ::", 2L, Math.round(2.43223D));
		assertEquals("round(double)[10] ::", 18232155L, Math.round(18232155.3323566D));
		assertEquals("round(double)[11] ::", 0L, Math.round(Double.MIN_VALUE));
		assertEquals("round(double)[12] ::", 0L, Math.round((Double.MIN_VALUE * 200)));
		assertEquals("round(double)[13] ::", 9223372036854775807L, Math.round((Double.MAX_VALUE / 500)));
		assertEquals("round(double)[14] ::", 9223372036854775807L, Math.round((Double.MAX_VALUE / 200)));
		assertEquals("round(double)[15] ::", 9223372036854775807L, Math.round(Double.MAX_VALUE));
		assertEquals("round(double)[16] ::", 9223372036854775807L, Math.round(Double.MAX_VALUE + 1));
	}

	public void testRound_float()
	{
		assertEquals("round(float)[0] ::", -2147483648L, Math.round(-Float.MAX_VALUE));
		assertEquals("round(float)[1] ::", -2147483648L, Math.round((-Float.MAX_VALUE / 200)));
		assertEquals("round(float)[2] ::", -2147483648L, Math.round((-Float.MAX_VALUE / 500)));
		assertEquals("round(float)[3] ::", 0L, Math.round((-Float.MIN_VALUE * 2000)));
		assertEquals("round(float)[4] ::", 0L, Math.round((-Float.MIN_VALUE * 1000)));
		assertEquals("round(float)[5] ::", -32948748L, Math.round(-32948748.958324F));
		assertEquals("round(float)[6] ::", 0L, Math.round(-0.000000009F));
		assertEquals("round(float)[7] ::", 0L, Math.round(-0.0000002F));
		assertEquals("round(float)[8] ::", 0L, Math.round(0F));
		assertEquals("round(float)[9] ::", 0L, Math.round(0.456232334F));
		assertEquals("round(float)[10] ::", 1224257L, Math.round(1224257.312321263F));
		assertEquals("round(float)[11] ::", 2147483647L, Math.round(9999832342.12365F));
		assertEquals("round(float)[12] ::", 0L, Math.round(Float.MIN_VALUE));
		assertEquals("round(float)[13] ::", 0L, Math.round((Float.MIN_VALUE * 200)));
		assertEquals("round(float)[14] ::", 2147483647L, Math.round((Float.MAX_VALUE / 500)));
		assertEquals("round(float)[15] ::", 2147483647L, Math.round((Float.MAX_VALUE / 200)));
		assertEquals("round(float)[16] ::", 2147483647L, Math.round(Float.MAX_VALUE));
		assertEquals("round(float)[17] ::", 2147483647L, Math.round((Float.MAX_VALUE + 1)));
	}

	public void testSignum_double()
	{
		assertEquals("signum(double)[0] ::", (double)-1.0, Math.signum(-Double.MAX_VALUE));
		assertEquals("signum(double)[1] ::", (double)-1.0, Math.signum((-Double.MAX_VALUE / 200)));
		assertEquals("signum(double)[2] ::", (double)-1.0, Math.signum((-Double.MAX_VALUE / 500)));
		assertEquals("signum(double)[3] ::", (double)-1.0, Math.signum((-Double.MIN_VALUE * 2000)));
		assertEquals("signum(double)[4] ::", (double)-1.0, Math.signum((-Double.MIN_VALUE * 1000)));
		assertEquals("signum(double)[5] ::", (double)-1.0, Math.signum(-2929112212.129231481346));
		assertEquals("signum(double)[6] ::", (double)-1.0, Math.signum(-2372.228212D));
		assertEquals("signum(double)[7] ::", (double)-1.0, Math.signum(-1.2232D));
		assertEquals("signum(double)[8] ::", (double)0.0, Math.signum(0D));
		assertEquals("signum(double)[9] ::", (double)1.0, Math.signum(2.43223D));
		assertEquals("signum(double)[10] ::", (double)1.0, Math.signum(18232155.3323566D));
		assertEquals("signum(double)[11] ::", (double)1.0, Math.signum(Double.MIN_VALUE));
		assertEquals("signum(double)[12] ::", (double)1.0, Math.signum((Double.MIN_VALUE * 200)));
		assertEquals("signum(double)[13] ::", (double)1.0, Math.signum((Double.MAX_VALUE / 500)));
		assertEquals("signum(double)[14] ::", (double)1.0, Math.signum((Double.MAX_VALUE / 200)));
		assertEquals("signum(double)[15] ::", (double)1.0, Math.signum(Double.MAX_VALUE));
		assertEquals("signum(double)[16] ::", (double)1.0, Math.signum(Double.MAX_VALUE + 1));
	}

	public void testSignum_float()
	{
		assertEquals("signum(float)[0] ::", (float)-1.0, Math.signum(-Float.MAX_VALUE));
		assertEquals("signum(float)[1] ::", (float)-1.0, Math.signum((-Float.MAX_VALUE / 200)));
		assertEquals("signum(float)[2] ::", (float)-1.0, Math.signum((-Float.MAX_VALUE / 500)));
		assertEquals("signum(float)[3] ::", (float)-1.0, Math.signum((-Float.MIN_VALUE * 2000)));
		assertEquals("signum(float)[4] ::", (float)-1.0, Math.signum((-Float.MIN_VALUE * 1000)));
		assertEquals("signum(float)[5] ::", (float)-1.0, Math.signum(-32948748.958324F));
		assertEquals("signum(float)[6] ::", (float)-1.0, Math.signum(-0.000000009F));
		assertEquals("signum(float)[7] ::", (float)-1.0, Math.signum(-0.0000002F));
		assertEquals("signum(float)[8] ::", (float)0.0, Math.signum(0F));
		assertEquals("signum(float)[9] ::", (float)1.0, Math.signum(0.456232334F));
		assertEquals("signum(float)[10] ::", (float)1.0, Math.signum(1224257.312321263F));
		assertEquals("signum(float)[11] ::", (float)1.0, Math.signum(9999832342.12365F));
		assertEquals("signum(float)[12] ::", (float)1.0, Math.signum(Float.MIN_VALUE));
		assertEquals("signum(float)[13] ::", (float)1.0, Math.signum((Float.MIN_VALUE * 200)));
		assertEquals("signum(float)[14] ::", (float)1.0, Math.signum((Float.MAX_VALUE / 500)));
		assertEquals("signum(float)[15] ::", (float)1.0, Math.signum((Float.MAX_VALUE / 200)));
		assertEquals("signum(float)[16] ::", (float)1.0, Math.signum(Float.MAX_VALUE));
		assertEquals("signum(float)[17] ::", (float)1.0, Math.signum((Float.MAX_VALUE + 1)));
	}

	public void testSin()
	{
		assertEquals("sin(double)[0] ::", (double)-0.004961954789184062, Math.sin(-Double.MAX_VALUE));
		assertEquals("sin(double)[1] ::", (double)-0.22938612616130435, Math.sin((-Double.MAX_VALUE / 200)));
		assertEquals("sin(double)[2] ::", (double)-0.013889411248912811, Math.sin((-Double.MAX_VALUE / 500)));
		assertEquals("sin(double)[3] ::", (double)-9.88E-321, Math.sin((-Double.MIN_VALUE * 2000)));
		assertEquals("sin(double)[4] ::", (double)-4.94E-321, Math.sin((-Double.MIN_VALUE * 1000)));
		assertEquals("sin(double)[5] ::", (double)-0.41892510283303325, Math.sin(-2929112212.129231481346));
		assertEquals("sin(double)[6] ::", (double)0.32002752462922074, Math.sin(-2372.228212D));
		assertEquals("sin(double)[7] ::", (double)-0.9401942126459146, Math.sin(-1.2232D));
		assertEquals("sin(double)[8] ::", (double)0.0, Math.sin(0D));
		assertEquals("sin(double)[9] ::", (double)0.6513502994441202, Math.sin(2.43223D));
		assertEquals("sin(double)[10] ::", (double)-0.7876987349113835, Math.sin(18232155.3323566D));
		assertEquals("sin(double)[11] ::", (double)4.9E-324, Math.sin(Double.MIN_VALUE));
		assertEquals("sin(double)[12] ::", (double)9.9E-322, Math.sin((Double.MIN_VALUE * 200)));
		assertEquals("sin(double)[13] ::", (double)0.013889411248912811, Math.sin((Double.MAX_VALUE / 500)));
		assertEquals("sin(double)[14] ::", (double)0.22938612616130435, Math.sin((Double.MAX_VALUE / 200)));
		assertEquals("sin(double)[15] ::", (double)0.004961954789184062, Math.sin(Double.MAX_VALUE));
		assertEquals("sin(double)[16] ::", (double)0.004961954789184062, Math.sin(Double.MAX_VALUE + 1));
	}

	public void testSinh()
	{
		assertEquals("sinh(double)[0] ::", (double)-Infinity, Math.sinh(-Double.MAX_VALUE));
		assertEquals("sinh(double)[1] ::", (double)-Infinity, Math.sinh((-Double.MAX_VALUE / 200)));
		assertEquals("sinh(double)[2] ::", (double)-Infinity, Math.sinh((-Double.MAX_VALUE / 500)));
		assertEquals("sinh(double)[3] ::", (double)-9.88E-321, Math.sinh((-Double.MIN_VALUE * 2000)));
		assertEquals("sinh(double)[4] ::", (double)-4.94E-321, Math.sinh((-Double.MIN_VALUE * 1000)));
		assertEquals("sinh(double)[5] ::", (double)-Infinity, Math.sinh(-2929112212.129231481346));
		assertEquals("sinh(double)[6] ::", (double)-Infinity, Math.sinh(-2372.228212D));
		assertEquals("sinh(double)[7] ::", (double)-1.551878577463119, Math.sinh(-1.2232D));
		assertEquals("sinh(double)[8] ::", (double)0.0, Math.sinh(0D));
		assertEquals("sinh(double)[9] ::", (double)5.648199961077914, Math.sinh(2.43223D));
		assertEquals("sinh(double)[10] ::", (double)Infinity, Math.sinh(18232155.3323566D));
		assertEquals("sinh(double)[11] ::", (double)4.9E-324, Math.sinh(Double.MIN_VALUE));
		assertEquals("sinh(double)[12] ::", (double)9.9E-322, Math.sinh((Double.MIN_VALUE * 200)));
		assertEquals("sinh(double)[13] ::", (double)Infinity, Math.sinh((Double.MAX_VALUE / 500)));
		assertEquals("sinh(double)[14] ::", (double)Infinity, Math.sinh((Double.MAX_VALUE / 200)));
		assertEquals("sinh(double)[15] ::", (double)Infinity, Math.sinh(Double.MAX_VALUE));
		assertEquals("sinh(double)[16] ::", (double)Infinity, Math.sinh(Double.MAX_VALUE + 1));
	}

	public void testSqrt()
	{
		assertEquals("sqrt(double)[0] ::", (double)0.0, Math.sqrt(0D));
		assertEquals("sqrt(double)[1] ::", (double)1.5595608356200794, Math.sqrt(2.43223D));
		assertEquals("sqrt(double)[2] ::", (double)4269.912801493328, Math.sqrt(18232155.3323566D));
		assertEquals("sqrt(double)[3] ::", (double)2.2227587494850775E-162, Math.sqrt(Double.MIN_VALUE));
		assertEquals("sqrt(double)[4] ::", (double)3.1434555694052575E-161, Math.sqrt((Double.MIN_VALUE * 200)));
		assertEquals("sqrt(double)[5] ::", (double)5.996153992122476E152, Math.sqrt((Double.MAX_VALUE / 500)));
		assertEquals("sqrt(double)[6] ::", (double)9.480751908109177E152, Math.sqrt((Double.MAX_VALUE / 200)));
		assertEquals("sqrt(double)[7] ::", (double)1.3407807929942596E154, Math.sqrt(Double.MAX_VALUE));
		assertEquals("sqrt(double)[8] ::", (double)1.3407807929942596E154, Math.sqrt(Double.MAX_VALUE + 1));
	}

	public void testTan()
	{
		assertEquals("tan(double)[0] ::", (double)0.004962015874444895, Math.tan(-Double.MAX_VALUE));
		assertEquals("tan(double)[1] ::", (double)0.23567015176514217, Math.tan((-Double.MAX_VALUE / 200)));
		assertEquals("tan(double)[2] ::", (double)-0.013890751185845374, Math.tan((-Double.MAX_VALUE / 500)));
		assertEquals("tan(double)[3] ::", (double)-9.88E-321, Math.tan((-Double.MIN_VALUE * 2000)));
		assertEquals("tan(double)[4] ::", (double)-4.94E-321, Math.tan((-Double.MIN_VALUE * 1000)));
		assertEquals("tan(double)[5] ::", (double)0.4613606942130483, Math.tan(-2929112212.129231481346));
		assertEquals("tan(double)[6] ::", (double)-0.33779263182277885, Math.tan(-2372.228212D));
		assertEquals("tan(double)[7] ::", (double)-2.7600907714835787, Math.tan(-1.2232D));
		assertEquals("tan(double)[8] ::", (double)0.0, Math.tan(0D));
		assertEquals("tan(double)[9] ::", (double)-0.858421060569475, Math.tan(2.43223D));
		assertEquals("tan(double)[10] ::", (double)1.2786058599594134, Math.tan(18232155.3323566D));
		assertEquals("tan(double)[11] ::", (double)4.9E-324, Math.tan(Double.MIN_VALUE));
		assertEquals("tan(double)[12] ::", (double)9.9E-322, Math.tan((Double.MIN_VALUE * 200)));
		assertEquals("tan(double)[13] ::", (double)0.013890751185845374, Math.tan((Double.MAX_VALUE / 500)));
		assertEquals("tan(double)[14] ::", (double)-0.23567015176514217, Math.tan((Double.MAX_VALUE / 200)));
		assertEquals("tan(double)[15] ::", (double)-0.004962015874444895, Math.tan(Double.MAX_VALUE));
		assertEquals("tan(double)[16] ::", (double)-0.004962015874444895, Math.tan(Double.MAX_VALUE + 1));
	}

	public void testTanh()
	{
		assertEquals("tanh(double)[0] ::", (double)-1.0, Math.tanh(-Double.MAX_VALUE));
		assertEquals("tanh(double)[1] ::", (double)-1.0, Math.tanh((-Double.MAX_VALUE / 200)));
		assertEquals("tanh(double)[2] ::", (double)-1.0, Math.tanh((-Double.MAX_VALUE / 500)));
		assertEquals("tanh(double)[3] ::", (double)-9.88E-321, Math.tanh((-Double.MIN_VALUE * 2000)));
		assertEquals("tanh(double)[4] ::", (double)-4.94E-321, Math.tanh((-Double.MIN_VALUE * 1000)));
		assertEquals("tanh(double)[5] ::", (double)-1.0, Math.tanh(-2929112212.129231481346));
		assertEquals("tanh(double)[6] ::", (double)-1.0, Math.tanh(-2372.228212D));
		assertEquals("tanh(double)[7] ::", (double)-0.8405955817522291, Math.tanh(-1.2232D));
		assertEquals("tanh(double)[8] ::", (double)0.0, Math.tanh(0D));
		assertEquals("tanh(double)[9] ::", (double)0.9846861739786077, Math.tanh(2.43223D));
		assertEquals("tanh(double)[10] ::", (double)1.0, Math.tanh(18232155.3323566D));
		assertEquals("tanh(double)[11] ::", (double)4.9E-324, Math.tanh(Double.MIN_VALUE));
		assertEquals("tanh(double)[12] ::", (double)9.9E-322, Math.tanh((Double.MIN_VALUE * 200)));
		assertEquals("tanh(double)[13] ::", (double)1.0, Math.tanh((Double.MAX_VALUE / 500)));
		assertEquals("tanh(double)[14] ::", (double)1.0, Math.tanh((Double.MAX_VALUE / 200)));
		assertEquals("tanh(double)[15] ::", (double)1.0, Math.tanh(Double.MAX_VALUE));
		assertEquals("tanh(double)[16] ::", (double)1.0, Math.tanh(Double.MAX_VALUE + 1));
	}

	public void testToDegrees()
	{
		assertEquals("toDegrees(double)[0] ::", (double)-Infinity, Math.toDegrees(-Double.MAX_VALUE));
		assertEquals("toDegrees(double)[1] ::", (double)-5.15001147436265E307, Math.toDegrees((-Double.MAX_VALUE / 200)));
		assertEquals("toDegrees(double)[2] ::", (double)-2.06000458974506E307, Math.toDegrees((-Double.MAX_VALUE / 500)));
		assertEquals("toDegrees(double)[3] ::", (double)-5.6616E-319, Math.toDegrees((-Double.MIN_VALUE * 2000)));
		assertEquals("toDegrees(double)[4] ::", (double)-2.8308E-319, Math.toDegrees((-Double.MIN_VALUE * 1000)));
		assertEquals("toDegrees(double)[5] ::", (double)-1.6782576747523328E11, Math.toDegrees(-2929112212.129231481346));
		assertEquals("toDegrees(double)[6] ::", (double)-135918.6645894655, Math.toDegrees(-2372.228212D));
		assertEquals("toDegrees(double)[7] ::", (double)-70.0841975004023, Math.toDegrees(-1.2232D));
		assertEquals("toDegrees(double)[8] ::", (double)0.0, Math.toDegrees(0D));
		assertEquals("toDegrees(double)[9] ::", (double)139.3565138051042, Math.toDegrees(2.43223D));
		assertEquals("toDegrees(double)[10] ::", (double)1.0446255519709718E9, Math.toDegrees(18232155.3323566D));
		assertEquals("toDegrees(double)[11] ::", (double)2.8E-322, Math.toDegrees(Double.MIN_VALUE));
		assertEquals("toDegrees(double)[12] ::", (double)5.6615E-320, Math.toDegrees((Double.MIN_VALUE * 200)));
		assertEquals("toDegrees(double)[13] ::", (double)2.06000458974506E307, Math.toDegrees((Double.MAX_VALUE / 500)));
		assertEquals("toDegrees(double)[14] ::", (double)5.15001147436265E307, Math.toDegrees((Double.MAX_VALUE / 200)));
		assertEquals("toDegrees(double)[15] ::", (double)Infinity, Math.toDegrees(Double.MAX_VALUE));
		assertEquals("toDegrees(double)[16] ::", (double)Infinity, Math.toDegrees(Double.MAX_VALUE + 1));
	}

	public void testToRadians()
	{	
		if (System.getProperty("java.version").startsWith("9")) {
			assertEquals("toRadians(double)[0] ::", (double)-1.5687832071922935E304, Math.toRadians((-Double.MAX_VALUE / 200)));
			assertEquals("toRadians(double)[1] ::", (double)-6.275132828769174E303, Math.toRadians((-Double.MAX_VALUE / 500)));
			assertEquals("toRadians(double)[2] ::", (double)6.275132828769174E303, Math.toRadians((Double.MAX_VALUE / 500)));
			assertEquals("toRadians(double)[3] ::", (double)1.5687832071922935E304, Math.toRadians((Double.MAX_VALUE / 200)));
			assertEquals("toRadians(double)[4] ::", (double)-8.4E-323, Math.toRadians((-Double.MIN_VALUE * 1000)));
			assertEquals("toRadians(double)[5] ::", (double)318211.1402846637, Math.toRadians(18232155.3323566D));
		} else {
			assertEquals("toRadians(double)[0] ::", (double)-1.5687832071922932E304, Math.toRadians((-Double.MAX_VALUE / 200)));
			assertEquals("toRadians(double)[1] ::", (double)-6.275132828769172E303, Math.toRadians((-Double.MAX_VALUE / 500)));
			assertEquals("toRadians(double)[2] ::", (double)6.275132828769172E303, Math.toRadians((Double.MAX_VALUE / 500)));
			assertEquals("toRadians(double)[3] ::", (double)1.5687832071922932E304, Math.toRadians((Double.MAX_VALUE / 200)));
			assertEquals("toRadians(double)[4] ::", (double)-9.4E-323, Math.toRadians((-Double.MIN_VALUE * 1000)));
			assertEquals("toRadians(double)[5] ::", (double)318211.14028466365, Math.toRadians(18232155.3323566D));
		}
		assertEquals("toRadians(double)[6] ::", (double)-3.1375664143845866E306, Math.toRadians(-Double.MAX_VALUE));
		assertEquals("toRadians(double)[7] ::", (double)-1.73E-322, Math.toRadians((-Double.MIN_VALUE * 2000)));
		assertEquals("toRadians(double)[8] ::", (double)-5.112265226202968E7, Math.toRadians(-2929112212.129231481346));
		assertEquals("toRadians(double)[9] ::", (double)-41.403192908098056, Math.toRadians(-2372.228212D));
		assertEquals("toRadians(double)[10] ::", (double)-0.02134886741039464, Math.toRadians(-1.2232D));
		assertEquals("toRadians(double)[11] ::", (double)0.0, Math.toRadians(0D));
		assertEquals("toRadians(double)[12] ::", (double)0.04245042166578168, Math.toRadians(2.43223D));
		assertEquals("toRadians(double)[13] ::", (double)0.0, Math.toRadians(Double.MIN_VALUE));
		assertEquals("toRadians(double)[14] ::", (double)1.5E-323, Math.toRadians((Double.MIN_VALUE * 200)));
		assertEquals("toRadians(double)[15] ::", (double)3.1375664143845866E306, Math.toRadians(Double.MAX_VALUE));
		assertEquals("toRadians(double)[16] ::", (double)3.1375664143845866E306, Math.toRadians(Double.MAX_VALUE + 1));
	}

	public void testUlp_double()
	{
		assertEquals("ulp(double)[0] ::", (double)1.9958403095347198E292, Math.ulp(-Double.MAX_VALUE));
		assertEquals("ulp(double)[1] ::", (double)1.5592502418239999E290, Math.ulp((-Double.MAX_VALUE / 200)));
		assertEquals("ulp(double)[2] ::", (double)7.796251209119999E289, Math.ulp((-Double.MAX_VALUE / 500)));
		assertEquals("ulp(double)[3] ::", (double)4.9E-324, Math.ulp((-Double.MIN_VALUE * 2000)));
		assertEquals("ulp(double)[4] ::", (double)4.9E-324, Math.ulp((-Double.MIN_VALUE * 1000)));
		assertEquals("ulp(double)[5] ::", (double)4.76837158203125E-7, Math.ulp(-2929112212.129231481346));
		assertEquals("ulp(double)[6] ::", (double)4.547473508864641E-13, Math.ulp(-2372.228212D));
		assertEquals("ulp(double)[7] ::", (double)2.220446049250313E-16, Math.ulp(-1.2232D));
		assertEquals("ulp(double)[8] ::", (double)4.9E-324, Math.ulp(0D));
		assertEquals("ulp(double)[9] ::", (double)4.440892098500626E-16, Math.ulp(2.43223D));
		assertEquals("ulp(double)[10] ::", (double)3.725290298461914E-9, Math.ulp(18232155.3323566D));
		assertEquals("ulp(double)[11] ::", (double)4.9E-324, Math.ulp(Double.MIN_VALUE));
		assertEquals("ulp(double)[12] ::", (double)4.9E-324, Math.ulp((Double.MIN_VALUE * 200)));
		assertEquals("ulp(double)[13] ::", (double)7.796251209119999E289, Math.ulp((Double.MAX_VALUE / 500)));
		assertEquals("ulp(double)[14] ::", (double)1.5592502418239999E290, Math.ulp((Double.MAX_VALUE / 200)));
		assertEquals("ulp(double)[15] ::", (double)1.9958403095347198E292, Math.ulp(Double.MAX_VALUE));
		assertEquals("ulp(double)[16] ::", (double)1.9958403095347198E292, Math.ulp(Double.MAX_VALUE + 1));
	}

	public void testUlp_float()
	{
		assertEquals("ulp(float)[0] ::", (float)2.028241E31, Math.ulp(-Float.MAX_VALUE));
		assertEquals("ulp(float)[1] ::", (float)1.58456325E29, Math.ulp((-Float.MAX_VALUE / 200)));
		assertEquals("ulp(float)[2] ::", (float)7.9228163E28, Math.ulp((-Float.MAX_VALUE / 500)));
		assertEquals("ulp(float)[3] ::", (float)1.4E-45, Math.ulp((-Float.MIN_VALUE * 2000)));
		assertEquals("ulp(float)[4] ::", (float)1.4E-45, Math.ulp((-Float.MIN_VALUE * 1000)));
		assertEquals("ulp(float)[5] ::", (float)2.0, Math.ulp(-32948748.958324F));
		assertEquals("ulp(float)[6] ::", (float)8.881784E-16, Math.ulp(-0.000000009F));
		assertEquals("ulp(float)[7] ::", (float)1.4210855E-14, Math.ulp(-0.0000002F));
		assertEquals("ulp(float)[8] ::", (float)1.4E-45, Math.ulp(0F));
		assertEquals("ulp(float)[9] ::", (float)2.9802322E-8, Math.ulp(0.456232334F));
		assertEquals("ulp(float)[10] ::", (float)0.125, Math.ulp(1224257.312321263F));
		assertEquals("ulp(float)[11] ::", (float)1024.0, Math.ulp(9999832342.12365F));
		assertEquals("ulp(float)[12] ::", (float)1.4E-45, Math.ulp(Float.MIN_VALUE));
		assertEquals("ulp(float)[13] ::", (float)1.4E-45, Math.ulp((Float.MIN_VALUE * 200)));
		assertEquals("ulp(float)[14] ::", (float)7.9228163E28, Math.ulp((Float.MAX_VALUE / 500)));
		assertEquals("ulp(float)[15] ::", (float)1.58456325E29, Math.ulp((Float.MAX_VALUE / 200)));
		assertEquals("ulp(float)[16] ::", (float)2.028241E31, Math.ulp(Float.MAX_VALUE));
		assertEquals("ulp(float)[17] ::", (float)2.028241E31, Math.ulp((Float.MAX_VALUE + 1)));
	}

}
