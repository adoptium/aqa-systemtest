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
package net.adoptopenjdk.test.bigdecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import org.junit.Assert;
import junit.framework.TestCase;
public class TestSuite039 extends TestCase
{
  MathContext rc_MathContext;
  int rc_int;
  boolean rc_boolean;
  long rc_long;
  BigDecimal rc_BigDecimal;
  float rc_float;
  byte rc_byte;
  short rc_short;
  double rc_double;
  BigDecimal[] rc_BigDecimal_array;
  String rc_String;
  BigInteger rc_BigInteger;
  
  public TestSuite039() {
	  
  }
  public void testItem_0000()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_int = (new BigDecimal("-1.8E+19")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("-1.8E+19")).divide(new BigDecimal("2E+19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.9", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.9")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0009()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("2E+19")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("-0.9")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("-1.8E+19")).movePointLeft(2147483647);
    Assert.assertEquals("-1.8E-2147483628", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("X<HC3X?KF?QQ<?EYU<4XNIWU@KQB0N?G5S:4PYEKV6:HGQ42YL:3QURXGG67WYJ9L@NW6U?ALY04GYD??UBC1;23BDF9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0017()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\234', '8', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\0', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '\234', '\234', '8', '8', '8', '\234', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(-1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '\1', '8', '8', '\234', '\234', '\234', '\0', '8', '\0', '\234', '8', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\1', '\1', '8', '8', '8', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '8', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\234', '8', '\0', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-0.9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("-1.8E+19")).multiply(new BigDecimal("92233720368547758070"));
    Assert.assertEquals("-1.660206966633859645260E+39", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("-1.8E+19")).multiply(new BigDecimal("-1.8E+19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+38", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("3E+38")).divideToIntegralValue(new BigDecimal("-1.8E+19"));
    Assert.assertEquals("-16666666666666666666", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("2")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("-16666666666666666666")).negate();
    Assert.assertEquals("16666666666666666666", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-16666666666666666666")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0035()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toPlainString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\0', '\1', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_double = (new BigDecimal("2")).doubleValue();
    Assert.assertEquals(2.0, rc_double, 0);
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-16666666666666666666")).abs();
    Assert.assertEquals("16666666666666666666", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0041()
  {
    rc_String = (new BigDecimal("-16666666666666666666")).toString();
    Assert.assertEquals("-16666666666666666666", rc_String);
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-16666666666666666666")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-16666666666666666666")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0045()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '8', '8', '\234', '8', '8', '\234', '\1', '\234', '8', '\0', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '\1', '8', '\234', '8', '\1', '\0', '\0', '\234', '8', '\234', '8', '\1', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '\0', '8', '\234', '\1', '\234', '8', '\234', '8', '\234', '\0', '8', '\uFFFF', '\1', '\234', '\234', '\1', '8', '\0', '\1', '8', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '8', '\0', '8', '\0', '\1', '8'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0046()
  {
    rc_int = (new BigDecimal("2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-16666666666666666666")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0051()
  {
    rc_int = (new BigDecimal("16666666666666666666")).compareTo(new BigDecimal("2E+19"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0052()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0053()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("2E+19"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).movePointLeft(2147483647);
    Assert.assertEquals("-9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("16666666666666666666")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '8', '\1', '\1', '\1', '8', '8', '\1', '\0', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\0', '8', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\234', '8', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '8', '8', '\234', '\0', '\0', '\0', '8', '\0', '\234', '\0', '8', '\234', '8', '\234', '\0', '8', '8', '8', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\234', '\0', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\1', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("16666666666666666666")).abs();
    Assert.assertEquals("16666666666666666666", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("16666666666666666666")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0061()
  {
    rc_int = (new BigDecimal("16666666666666666666")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0062()
  {
    rc_BigInteger = (new BigDecimal("-9E-2147483629")).unscaledValue();
    Assert.assertEquals("-9", rc_BigInteger.toString());
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0064()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '8', '\234', '\234', '\234', '\234', '\234', '8', '\0', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\1', '8', '\0', '8', '\1', '\234'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0066()
  {
    rc_int = (new BigDecimal("16666666666666666666")).precision();
    Assert.assertEquals(20, rc_int);
  }
  public void testItem_0067()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2E+19"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_double = (new BigDecimal("16666666666666666666")).doubleValue();
    Assert.assertEquals(1.6666666666666666E19, rc_double, 0);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("16666666666666666666")).max(new BigDecimal("2E+19"));
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2E+19"));
    Assert.assertEquals("-19999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).plus();
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E-19"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1.0000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0000000000000000000")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    rc_String = (new BigDecimal("-19999999999999999999")).toEngineeringString();
    Assert.assertEquals("-19999999999999999999", rc_String);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0081()
  {
    rc_boolean = (new BigDecimal("-19999999999999999999")).equals("VFT?:80ACXCCXS9LPUX04L2K>7X6V=?M<NL3=UQN@V;1M2<7I7C75192LDF8=FBN=0G32H>20;HPRBXB;J1I1TX32:T3<V1<FOFD");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0082()
  {
    rc_double = (new BigDecimal("1E+1")).doubleValue();
    Assert.assertEquals(10.0, rc_double, 0);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_byte = (new BigDecimal("0E-19")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0085()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("-19999999999999999999")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("-19999999999999999989", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).multiply(new BigDecimal("1E+1"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-19999999999999999999")).divide(new BigDecimal("0E-19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-19999999999999999989")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("-19999999999999999999")).plus();
    Assert.assertEquals("-19999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("-19999999999999999989")).abs();
    Assert.assertEquals("19999999999999999989", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("19999999999999999989")).divide(new BigDecimal("1"));
    Assert.assertEquals("19999999999999999989", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_double = (new BigDecimal("0E-18")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0097()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-19999999999999999989")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    rc_int = (new BigDecimal("-19999999999999999989")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E-18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).ulp();
    Assert.assertEquals("1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("1E-18")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
//  public void testItem_0106()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-18")).divide(new BigDecimal("1E-18"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("BTJQE?0O1NR=P1?FBFLQQ44>83FCB6WMAK@TSLDYAYHGHO;5@XW48WMO0CU?2BW0FU1MC1OOGWJA:P;IUHQBJMI?M09;FRH5>A6P");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("SYNUUD9GL6C>PCC758?;1IK9@4CC:6?X=CF1STD50HXDGTUT0VCVP;HX3@=OQ3IXW?X<<G<:QFX3>:1F<U6UB3IMHGNJBKNC;1JC");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0113()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("L0AAWTVUDKQJR44?3C3:BE7R=M;G>Q96EOQSPXIQC6NWO47GYLRS?DGYR;EPDXS74>4Y>IAWS:Y0G30?U05HC7Q7EP6P;29F880I");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1E-18"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9.223372036854775808E+36", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("1E-18")).max(new BigDecimal("1E-18"));
    Assert.assertEquals("1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-18")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("1E-18"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigIntegerExact();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0130()
  {
    rc_double = (new BigDecimal("-9.223372036854775808E+36")).doubleValue();
    Assert.assertEquals(-9.223372036854776E36, rc_double, 0);
  }
//  public void testItem_0131()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0132()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '8', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '8', '8', '\1', '\1', '8', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\234', '8', '\1', '\0', '\1', '8', '\1', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\1', '8', '8', '8', '8', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '8', '\234', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\234', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\234', '8', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\1', '\0', '8', '\1', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\uFFFF', '8', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0138()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("-9.223372036854775808E+36"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483630", rc_BigDecimal.toString());
//  }
//  public void testItem_0139()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0140()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483630")).plus();
    Assert.assertEquals("0E+2147483630", rc_BigDecimal.toString());
  }
//  public void testItem_0144()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9.223372036854775808E+36")).setScale(-2147483648);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0145()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+2147483630")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '\1', '\1', '8', '\0', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\234', '\0', '8', '\0', '\0', '\0', '\0', '\0', '8', '\0', '\1', '\1', '8', '\234', '\0', '8', '\1', '\0', '\1', '\1', '8'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0150()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0151()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0152()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("-9.223372036854775808E+36")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+36", rc_BigDecimal.toString());
  }
//  public void testItem_0154()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147482656, rc_int);
//  }
  public void testItem_0155()
  {
    rc_String = (new BigDecimal("-9E+36")).toEngineeringString();
    Assert.assertEquals("-9E+36", rc_String);
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("-9E+36")).stripTrailingZeros();
    Assert.assertEquals("-9E+36", rc_BigDecimal.toString());
  }
//  public void testItem_0158()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("320.0E+2147483647")).intValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("9BJ>=E6;<?E5MUISR39197536LOY6<?8B<81?S5JNJDJ<<58L<M60SE>1NTXHO;<L4Y<<3;86?2TP63B4MUY<YE4B@W@?NOWUYRL");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0160()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0161()
//  {
//    boolean caught;
//    rc_short = (new BigDecimal("00.0E+2147483647")).shortValueExact();
//    Assert.assertEquals(0, rc_short);
//  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-9.223372036854775808E+36")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0163()
  {
    rc_float = (new BigDecimal("-9.223372036854775808E+36")).floatValue();
    Assert.assertEquals(-9.223371892110087E36F, rc_float, 0);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("-9E+36")).add(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("-9E+36", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-9E+36"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0169()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("-9E+36")).max(new BigDecimal("-9E+36"));
    Assert.assertEquals("-9E+36", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).add(new BigDecimal("1"));
    Assert.assertEquals("1.00000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0173()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1.00000000000000000000000000000000000"), java.math.RoundingMode.CEILING);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0174()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).divide(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0176()
  {
    rc_byte = (new BigDecimal("3E+1")).byteValueExact();
    Assert.assertEquals(30, rc_byte);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).divide(new BigDecimal("00.0E+2147483647"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).movePointRight(1);
    Assert.assertEquals("10.0000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0183()
  {
    rc_BigInteger = (new BigDecimal("1.00000000000000000000000000000000000")).unscaledValue();
    Assert.assertEquals("100000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).subtract(new BigDecimal("1.00000000000000000000000000000000000"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_double = (new BigDecimal("0E-35")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.00000000000000000000000000000000000")).divide(new BigDecimal("0E-35"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).subtract(new BigDecimal("1.00000000000000000000000000000000000"));
    Assert.assertEquals("-1.00000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_int = (new BigDecimal("-1.00000000000000000000000000000000000")).scale();
    Assert.assertEquals(35, rc_int);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).divide(new BigDecimal("-1.00000000000000000000000000000000000"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000000000000000000000000000")).divide(new BigDecimal("-1.00000000000000000000000000000000000"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.00000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_short = (new BigDecimal("1.00000000000000000000000000000000000")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0201()
  {
    rc_BigInteger = (new BigDecimal("1.00000000000000000000000000000000000")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).divide(new BigDecimal("-1.00000000000000000000000000000000000"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_float = (new BigDecimal("0E-35")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0205()
  {
    rc_BigInteger = (new BigDecimal("0E-35")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0206()
  {
    rc_boolean = (new BigDecimal("0E-35")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0207()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '8', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '8', '8', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '8', '\234', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\1', '\1', '\1', '\234', '\1', '\uFFFF', '8', '\1', '8', '\234', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '8', '8', '\1', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0212()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000000000000000000000000000")).min(new BigDecimal("-1.00000000000000000000000000000000000"));
    Assert.assertEquals("-1.00000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0E-36", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-35")).divideToIntegralValue(new BigDecimal("0E-36"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0217()
  {
    rc_byte = (new BigDecimal("0E-36")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).subtract(new BigDecimal("0E-35"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\0', '8', '8', '\0', '8', '\0', '\234', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000000000000000000000000000")).movePointRight(0);
    Assert.assertEquals("-1.00000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.00000000000000000000000000000000000")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0222()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0223()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E-35"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-35")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0226()
  {
    rc_short = (new BigDecimal("0E-35")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, 1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigInteger = (new BigDecimal("0E-35")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0232()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0233()
  {
    rc_byte = (new BigDecimal("0E-35")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0234()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LR<L;NHP3N8<D1G7YW6?:G1K;T:VSH1T?@TU0HY2Y268J8CJ2<NUX4W7NJF3K2W5PR5JKDW;9WHPI1W346WJ:M7E<;0>?PL<:XXH", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '\0', '8', '8', '8', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\0', '\1', '\234', '\0', '\0', '\234', '\234', '\0', '\234', '8', '8', '\234', '\1', '\234', '\1', '\0', '8', '8', '\234', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '8', '\234', '\234', '\0', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '8', '8', '\1', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '\0', '8', '\234', '\0', '8', '8', '\uFFFF', '8', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).ulp();
    Assert.assertEquals("1E-35", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0242()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0246()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0247()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0251()
  {
    rc_boolean = (new BigDecimal("0")).equals("W6S6L0?O:1O@1AXV=<TW<ATNH@GABGB0:4C3FSSXWCHS1;P<M7HKF;BF?1VC;YY951:;N<S7M4;5O627LR?XFIY8RJQ2;9N<924J");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0257()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0258()
  {
    rc_String = (new BigDecimal("0E-35")).toPlainString();
    Assert.assertEquals("0.00000000000000000000000000000000000", rc_String);
  }
  public void testItem_0259()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0260()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QKUEK=E5KB?=P:C7:A134GSOKSFMUKISYRSRY1AD3C<X>QS4WTO=EKLW=:I;@IPR=8KIG@>NUGUP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0265()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0266()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0270()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("0E-35")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0272()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\234', '8', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8'}, -1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0273()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0274()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-35")).divide(new BigDecimal("0E-35"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-35")).divideAndRemainder(new BigDecimal("0E-35"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0279()
  {
    rc_String = (new BigDecimal("0E-35")).toString();
    Assert.assertEquals("0E-35", rc_String);
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-35")).divide(new BigDecimal("0E-35"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).pow(1);
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).negate();
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_int = (new BigDecimal("0E-35")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0285()
  {
    rc_byte = (new BigDecimal("0E-35")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F5RYXO@UVOJWWSR=5@G5LMIOG9198J>YNJR:U=?A=1CECSU=:C1W8H", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).ulp();
    Assert.assertEquals("1E-35", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).negate();
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).max(new BigDecimal("1E-35"));
    Assert.assertEquals("1E-35", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).plus();
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E-35")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("1E-35")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-35", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I@NINM7TJS83FFAVIMB8E6D84KR>7UI9O@8J;JSU");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-35")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.9406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559141512752095721482679997021747026302621439117764992162442947231593153395676878045123930756772152531361924168711815527476588471171825968557892041574710891293679118183485088968533491225483206875824421359554678952841239154118433348830085486724826180114861002227488028995078997154315340520221718443343609239377342516305107357432587880920333301340471201765233245924723261329768194619167306256454654649878491841886034834899979443627605367289425609946770168012567970654631923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-359", rc_BigDecimal.toString());
  }
//  public void testItem_0299()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-35")).setScale(2147483647, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0300()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("4.9406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559141512752095721482679997021747026302621439117764992162442947231593153395676878045123930756772152531361924168711815527476588471171825968557892041574710891293679118183485088968533491225483206875824421359554678952841239154118433348830085486724826180114861002227488028995078997154315340520221718443343609239377342516305107357432587880920333301340471201765233245924723261329768194619167306256454654649878491841886034834899979443627605367289425609946770168012567970654631923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-359")).setScale(1, 0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0304()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
//  public void testItem_0305()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DDMG=D0X;F=<9JOCY3PSG>XNPO<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0307()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("1E-35")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("-3.19999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E-35")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("1E-35")).multiply(new BigDecimal("-3.19999999999999999999999999999999999"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-3.19999999999999999999999999999999999E-35", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_int = (new BigDecimal("-3.19999999999999999999999999999999999E-35")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("-3.19999999999999999999999999999999999")).remainder(new BigDecimal("-3.19999999999999999999999999999999999E-35"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("0E-35", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-35"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-35")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0E-35"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0322()
  {
    rc_boolean = (new BigDecimal("0E-35")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0323()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '8', '\0', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '8', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '8', '8', '\0', '\0', '8', '8', '\1', '\1', '\234', '\1', '\234', '\1', '8', '8', '\0', '\0', '\1', '\1', '\0', '8', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\1', '8', '\0', '\234', '\234', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigInteger = (new BigDecimal("0E-35")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("M<;E?4R6NF<KQCMHL=<WM<7F6NBGMO2;ISO=LI@8VC@072=OM991<@<;8T", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0330()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '8', '\0', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\0', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\0', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\234', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_String = (new BigDecimal("3.2")).toEngineeringString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0333()
  {
    rc_BigInteger = (new BigDecimal("0E-35")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("780?JIE6Y@DH<HN>3@>8RMEDS2WI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0335()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0337()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).plus();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("0E-35")).multiply(new BigDecimal("0E-35"));
    Assert.assertEquals("0E-70", rc_BigDecimal.toString());
  }
//  public void testItem_0346()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0347()
  {
    rc_byte = (new BigDecimal("0E-35")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("0E-70")).subtract(new BigDecimal("0E-35"));
    Assert.assertEquals("0E-70", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigInteger = (new BigDecimal("0E-70")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_double = (new BigDecimal("0E-70")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0359()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.UP);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0370()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '8', '\234', '\234', '8', '\0', '8', '\1', '\1', '\234', '\1', '8', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\234'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?JQEQ7@3YAQD17WOY7KTHC@UJI4ER@GF;WVON927<6YX@UQMK3I2;A8N5@385YYN5>Y1<M<DN6BGON28CNF>ASVA;WMNC@3JQ7;N", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-1E+1"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).plus(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_long = (new BigDecimal("-1E+1")).longValue();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0382()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0383()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0385()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).movePointLeft(-1);
    Assert.assertEquals("-100", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_byte = (new BigDecimal("-100")).byteValueExact();
    Assert.assertEquals(-100, rc_byte);
  }
  public void testItem_0388()
  {
    rc_short = (new BigDecimal("-100")).shortValueExact();
    Assert.assertEquals(-100, rc_short);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_String = (new BigDecimal("-100")).toPlainString();
    Assert.assertEquals("-100", rc_String);
  }
  public void testItem_0391()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_int = (new BigDecimal("-100")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).negate();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0397()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0398()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TFS;1:N18Q3GIUQ@<1K9K7PK7>GU=PFIAB>7VX5AQ1P0F6SC0750I0:TII>U:S:VJO7FNEV02BV9HQHYDUX<S>VGOX93EKL6GNVM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0401()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0402()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("25E3O;9MX1UCIN<YTF8CVLREJ9WYKGS2UBHLMWL:8Q>S6S>KG:?0<XGKVFLAIFT");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0403()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '8', '8', '\1', '\1', '\1', '\0', '8', '8', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\1', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\234', '\234', '8', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\1', '8', '8', '\234', '8', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0'}, -1, -1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).pow(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0411()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0412()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-100")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0416()
  {
    rc_boolean = (new BigDecimal("0")).equals("4OMLG=U9B=0A87CGUF:HYKDHFK0<B92TWL;:RPF?MOH6O>:0NU0R=X98=5MQASNL1OO1R:VVIF:L090Y1HI:72H2DLM3K<YF2QMR");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0417()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("1000000000000"));
    Assert.assertEquals("135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).stripTrailingZeros();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(1);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000")).scaleByPowerOfTen(-1);
    Assert.assertEquals("100000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\0', '\234', '\0', '\234', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '\uFFFF', '\1', '8', '8', '\uFFFF', '\0', '8', '8', '\234', '\0', '8', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\0', '\234', '\1', '8', '\0', '8', '\234', '\0', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0438()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0439()
  {
    rc_boolean = (new BigDecimal("1135879015891")).equals("5QKLY1XKX>X?0I=S<AG03GSQULR;PFN<0X0H374OFUYVCM66PI3JEG@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0440()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0441()
  {
    rc_BigDecimal_array = (new BigDecimal("1000000000000")).divideAndRemainder(new BigDecimal("1135879015891.0"));
  }
  public void testItem_0442()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0443()
  {
    rc_BigInteger = (new BigDecimal("1135879015891.0")).unscaledValue();
    Assert.assertEquals("11358790158910", rc_BigInteger.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\1', '\1', '\234', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\234', '\234', '\1', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\1', '8', '\0', '\1', '\1', '\234', '\1', '8', '\0', '\234', '\1', '\uFFFF', '8', '\1'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("100000000000.0")).remainder(new BigDecimal("100000000000.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000")).divide(new BigDecimal("100000000000.0"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("100000000000.0")).divideToIntegralValue(new BigDecimal("1000000000000"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("100000000000.0")).divideToIntegralValue(new BigDecimal("100000000000.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0451()
  {
    rc_boolean = (new BigDecimal("1000000000000")).equals("6AHX<T:GK@<J=5UTI;I@=LC:?@@UYUCXNLT<GO;LNTF:C4AI9?V;D9?CDM@ONMYVFJYK=Y4=F73MWA45FY7T=@HWARDM=TO9QLW6");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0452()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\0', '\1', '\0', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '8', '\234', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\234', '\1', '8', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '\234', '8', '\0', '8', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '8', '8', '\0', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234', '8', '8', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0453()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0454()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1000000000000")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0455()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0456()
  {
    rc_int = (new BigDecimal("1000000000000")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '8', '\0', '\234', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\0', '\1', '\1', '\1', '8', '\1', '8', '\234', '\234', '\0', '8', '\uFFFF', '8', '\1', '\234', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\234', '\0', '\0', '\0', '\1', '\234', '\234', '\uFFFF', '8', '\0', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '8', '\0', '\234', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("1000000000000"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("100000000000.0")).scaleByPowerOfTen(0);
    Assert.assertEquals("100000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\1', '\0', '\234'}, 2147483647, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0464()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0465()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("100000000000.0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\1', '8', '\1', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\234', '8', '8', '\0', '8', '\0', '\uFFFF', '\234', '\0', '8', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_long = (new BigDecimal("100000000000.0")).longValueExact();
    Assert.assertEquals(100000000000L, rc_long);
  }
  public void testItem_0472()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I7GVVXX4G3SSRM;GC?=FINET@IPEL48W03Q7UC:AW0?QQPMU7U=:?D3H5E<1HHAD8X:O43M57FXDT42");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0473()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("100000000000.0")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0474()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0475()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0477()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0480()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
//  public void testItem_0485()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0.0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '\uFFFF', '\234', '8', '\0', '8', '8', '\1', '\234', '\234', '\234', '\0', '8', '\1', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\234', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '\1', '8', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '8', '\234', '\0', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\0', '\0', '\234', '\234', '\234', '8', '\1', '\1', '\0', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '8', '\1', '\0', '8', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\0', '8'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0499()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("2V56<AC<FA>:NE9X7BXM@U=:238PB2JF5L:;GB1ST<0QCRSBPGGMYI2BISY7FHC0DL:D=UA83>A@XM<:L;VA7E=;W@:5JICI=3X>");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3.2"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0505()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\1', '8', '8', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '\234', '\0', '8', '\0', '\1', '8', '\1', '\234', '8', '\234', '\234', '8', '\1', '8', '\234', '8', '\0', '\1', '\234', '\1', '\0', '\0', '\234', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\0', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '8', '8', '8', '\0', '\0', '\0', '\0', '8', '\0', '\0', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0512()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0519()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0520()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0524()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("6")).multiply(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("1.92E+2147483650", rc_BigDecimal.toString());
//  }
  public void testItem_0525()
  {
    rc_int = (new BigDecimal("-2147483648")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
//  public void testItem_0528()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("1920.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("1920.0E+2147483647")).divide(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("6", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("6")).min(new BigDecimal("6"));
    Assert.assertEquals("6", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigInteger = (new BigDecimal("10")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
//  public void testItem_0532()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1920.0E+2147483647")).divide(new BigDecimal("6"), java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0533()
  {
    rc_double = (new BigDecimal("320.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0534()
  {
    rc_int = (new BigDecimal("10")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0535()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0537()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1920.0E+2147483647")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("1.92E+2147483650", rc_BigDecimal.toString());
//  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0541()
  {
    rc_int = (new BigDecimal("2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("10"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_int = (new BigDecimal("-21474836480")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).stripTrailingZeros();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0549()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_int = (new BigDecimal("-1E+1")).intValue();
    Assert.assertEquals(-10, rc_int);
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_long = (new BigDecimal("-1E+1")).longValue();
    Assert.assertEquals(-10L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0557()
  {
    rc_boolean = (new BigDecimal("1E+1")).equals("33C:GV?6<WPS@72R");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("320")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0560()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals(";:ABMR8K6WO:9H8KW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0561()
  {
    rc_BigDecimal_array = (new BigDecimal("320")).divideAndRemainder(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("320"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0568()
  {
    rc_int = (new BigDecimal("-1E+1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0569()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).multiply(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("-1E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_String = (new BigDecimal("-1E+1")).toPlainString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0591()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0592()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SG:WHWBSRG7084@73>1K8L9=RQG32KAC45=<6;GO7M:8HJW312UKJ5OS8Y:EEJ;9?=P=:BI3K;>WW4Q1RR4<4LWUKXKQO5=TOYOU", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("55O=D@KLIB?K:S><AV12HSRYG9QQMT4QG<@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0605()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("-3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0606()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483647")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    rc_String = (new BigDecimal("-3E-2147483647")).toString();
    Assert.assertEquals("-3E-2147483647", rc_String);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("3.2E+2"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '8', '\234', '\1', '8', '\0', '\0', '\0', '8', '\uFFFF', '8', '\234', '\0', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3:0BWSO;OH;0UJFJJ:WM92D4VW@B>4?U:YVDHEJ@1I7BL2<XK1@A287ID8", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0617()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0620()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0621()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0622()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(0, 1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_String = (new BigDecimal("3.2E+2")).toString();
    Assert.assertEquals("3.2E+2", rc_String);
  }
//  public void testItem_0626()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0627()
  {
    rc_float = (new BigDecimal("320")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0630()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0631()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0633()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0638()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0644()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '8', '8', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '8', '\1', '\0', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '8', '8', '\0', '\234', '8', '\234', '\234', '8', '8', '\1', '\0', '8', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\1', '\0', '\1', '8', '\1', '\1', '\234', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\1'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":@N0BINPEN7XWF?8H:VYW25A7W19UJVWS>=35XQ1:AD84U7@9N<I?MP3W7T5<V:7CF=W3BNAB5S<2L?RFE=8DF@O9P2DH:PS8CBG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("-8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_byte = (new BigDecimal("-8")).byteValueExact();
    Assert.assertEquals(-8, rc_byte);
  }
  public void testItem_0650()
  {
    rc_String = (new BigDecimal("-8")).toEngineeringString();
    Assert.assertEquals("-8", rc_String);
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0652()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0653()
  {
    rc_BigInteger = (new BigDecimal("-8")).toBigIntegerExact();
    Assert.assertEquals("-8", rc_BigInteger.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0655()
  {
    rc_float = (new BigDecimal("-8")).floatValue();
    Assert.assertEquals(-8.0F, rc_float, 0);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-8")).stripTrailingZeros();
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
//  public void testItem_0658()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0662()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("0E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("-2")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0670()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0671()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\uFFFF', '8', '8', '\1', '\0', '8', '\0', '8', '\234', '\0', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\234', '8', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\1', '8'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("-2")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0681()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0682()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0683()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0686()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0687()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0688()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0689()
  {
    rc_int = (new BigDecimal("-2")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0690()
  {
    rc_boolean = (new BigDecimal("-1")).equals("DNAIV6G1JQ5GQ00@=>XN4?01@VOUDB9M@O156?E@AWW5FHY6JKV7S?;9U3GKQU6ADN42Q<><PHL?Y9?W1KYG3GD@Q0>J5>U31C9A");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0691()
  {
    rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("-2"));
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\uFFFF', '\0', '\0', '8', '\1', '8', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '\1', '\0', '\1', '\234', '\234', '\1', '\0', '\1', '8', '\0', '\1', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\1', '\1', '\0', '8', '\uFFFF', '8', '\234', '\1', '8', '\0', '\0', '\1', '8', '\1', '\234', '\1', '8', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '8', '\0', '8', '8', '\234', '\uFFFF', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_short = (new BigDecimal("2")).shortValueExact();
    Assert.assertEquals(2, rc_short);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("2")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("2"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_double = (new BigDecimal("-0.1")).doubleValue();
    Assert.assertEquals(-0.1, rc_double, 0);
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("2"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("R7B9K43AD>1P?I2P13GLEXQ=I@POGT<Y52G90X@VNOSJ;<5UF2JR33KQIILSK?6MVWCMFU3N22=BCJ0?E:V<M", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0706()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("2")).multiply(new BigDecimal("-0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0709()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0710()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigInteger = (new BigDecimal("-2")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("-2")).abs();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0717()
  {
    rc_boolean = (new BigDecimal("2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-404804506614621236704990693437834614099113299528284236713802716054860679135990693783920767402874248990374155728633623822779617474771586953734026799881477019843034848553132722728933815484186432682479535356945490137124014966849385397236206711298319112681620113024717539104666829230461005064372655017292012526615415482186989568", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("-2")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("-404804506614621236704990693437834614099113299528284236713802716054860679135990693783920767402874248990374155728633623822779617474771586953734026799881477019843034848553132722728933815484186432682479535356945490137124014966849385397236206711298319112681620113024717539104666829230461005064372655017292012526615415482186989568")).min(new BigDecimal("1"));
    Assert.assertEquals("-404804506614621236704990693437834614099113299528284236713802716054860679135990693783920767402874248990374155728633623822779617474771586953734026799881477019843034848553132722728933815484186432682479535356945490137124014966849385397236206711298319112681620113024717539104666829230461005064372655017292012526615415482186989568", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_double = (new BigDecimal("-2")).doubleValue();
    Assert.assertEquals(-2.0, rc_double, 0);
  }
  public void testItem_0729()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.CEILING);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0740()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("1"));
//  }
//  public void testItem_0741()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("1", rc_BigDecimal.toString());
//  }
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0744()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147482656, rc_int);
//  }
  public void testItem_0745()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0749()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
//  public void testItem_0753()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("320.0E+2147483647")).intValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0754()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0756()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("1"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\0', '\uFFFF', '\234', '\0', '\0', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\234', '\1', '8', '8', '8', '8', '\uFFFF', '\1', '\1', '\234', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '8', '\234', '8', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '8', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\0', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '8', '\234', '\234', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("3")).movePointLeft(-1);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("BVJX<OXNGA<OPU><7F@BEG7;4M8C>::9K2BET9Q8T??3Y@KMTCF6ES<9UV3GVMGJC5X?VF<WJ2K7LU;W:0J8S3;4X@OVI6AYQ7@4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    rc_float = (new BigDecimal("3")).floatValue();
    Assert.assertEquals(3.0F, rc_float, 0);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("3")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("3"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_float = (new BigDecimal("3")).floatValue();
    Assert.assertEquals(3.0F, rc_float, 0);
  }
  public void testItem_0776()
  {
    rc_short = (new BigDecimal("30")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("-9223372036854775808"), -1, 0);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7R2;TS=X?CF?R5XY3VE9IQT2F80>EP2:WP6>C:0SCHU:3EV<IX>NUNYTVOK9=UNHDVBR@9?<7RB>ND5@XPXLL5UK217LXX170CKA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("30")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-276701161105643274240", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("30")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("-276701161105643274240")).negate();
    Assert.assertEquals("276701161105643274240", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("-276701161105643274240")).plus();
    Assert.assertEquals("-276701161105643274240", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("30")).remainder(new BigDecimal("276701161105643274240"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("276701161105643274240")).negate();
    Assert.assertEquals("-276701161105643274240", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\1', '8', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '8', '8', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '8', '\1', '\234', '\1', '8', '\1', '\0', '\0', '\0', '8', '\uFFFF', '8', '8', '\0', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\1', '\0', '\234', '8', '\0', '\234', '\234', '8', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '8', '8', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\0', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-276701161105643274240"));
    Assert.assertEquals("-276701161105643274239", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("276701161105643274240")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0796()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("276701161105643274240"));
    Assert.assertEquals("8.30103483316929822720E+21", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0800()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0801()
  {
    rc_int = (new BigDecimal("8.30103483316929822720E+21")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("-276701161105643274239")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("276701161105643274239", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("276701161105643274240"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigInteger = (new BigDecimal("8.30103483316929822720E+21")).toBigInteger();
    Assert.assertEquals("8301034833169298227200", rc_BigInteger.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).add(new BigDecimal("3E+20"));
    Assert.assertEquals("6E+20", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("276701161105643274240")).pow(1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).min(new BigDecimal("276701161105643274240"));
    Assert.assertEquals("276701161105643274240", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("276701161105643274240")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0811()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3.2E-2147483646"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).ulp();
    Assert.assertEquals("1E+20", rc_BigDecimal.toString());
  }
//  public void testItem_0815()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+20")).hashCode();
//    Assert.assertEquals(11, rc_int);
//  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("276701161105643274240")).divide(new BigDecimal("3E+20"));
    Assert.assertEquals("0.92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1E+20")).abs();
    Assert.assertEquals("1E+20", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("300000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+20")).divide(new BigDecimal("3E+20"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).subtract(new BigDecimal("3E+20"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_int = (new BigDecimal("0E+20")).compareTo(new BigDecimal("300000000000000000000"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("300000000000000000000")).min(new BigDecimal("0E+20"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0824()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0825()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+20")).pow(-1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0826()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_int = (new BigDecimal("1E+20")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("300000000000000000000")).divide(new BigDecimal("0E+20"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0831()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0835()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("300000000000000000000")).negate();
    Assert.assertEquals("-300000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G>MVH6UV4703;;4G3WL@?6:?020UYFLLO154LLV;78;O@GXX96P=9H0?6FTJ", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    rc_float = (new BigDecimal("0E+20")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).stripTrailingZeros();
	Assert.assertEquals(0E+20, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0842()
  {
    rc_BigInteger = (new BigDecimal("300000000000000000000")).toBigIntegerExact();
    Assert.assertEquals("300000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("300000000000000000000")).compareTo(new BigDecimal("1E+20"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0844()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+20")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0845()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0846()
  {
    rc_BigDecimal_array = (new BigDecimal("300000000000000000000")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).multiply(new BigDecimal("0E+20"));
    Assert.assertEquals("0E+40", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1E+20")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2E+308")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0852()
  {
    rc_String = (new BigDecimal("0E+20")).toEngineeringString();
    Assert.assertEquals("0.0E+21", rc_String);
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_String = (new BigDecimal("10")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0855()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0856()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '\0', '\234', '8', '\1', '\0', '\234', '\0', '\1', '\0', '\1', '\1', '\0', '\0', '\0', '\1', '8', '\234', '\234', '8', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '\0', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\1', '8', '\234', '8', '\234', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '\1', '\234', '\uFFFF', '\0'}, 2147483647, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).multiply(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+328", rc_BigDecimal.toString());
  }
//  public void testItem_0861()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("0E+20")).intValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).abs();
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("2E+308")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0864()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\0', '\0', '8', '\1', '\0', '\234', '8', '8', '8', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\1', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\1', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\0', '8', '\234', '\1', '\uFFFF', '8', '\0', '8', '\234', '8', '\0', '\234', '\1', '\0', '\1', '\234', '\234', '\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0865()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).subtract(new BigDecimal("0E+20"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+20")).divide(new BigDecimal("0E+20"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+20")).divideToIntegralValue(new BigDecimal("0E+20"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0870()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+20")).hashCode();
//    Assert.assertEquals(-20, rc_int);
//  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+20")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0872()
  {
    rc_boolean = (new BigDecimal("0E+20")).equals("@YLUUMI>VMAAAXH>AI;0JR2IO1<DT7S;=O:7M:=LEA>BK>OLP1QQYEX6;JT5L4XK4U6:LMSKOFTIC048ICI8OGSDLO12QBFWE9VN");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("0E+20")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+19", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigInteger = (new BigDecimal("0E+19")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("0E+19")).abs();
    Assert.assertEquals("0E+19", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E+19"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0880()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+20")).divide(new BigDecimal("0E+19"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("0E+19"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0E+20"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0887()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("3")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("0E+19")).ulp();
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_String = (new BigDecimal("1E+19")).toPlainString();
    Assert.assertEquals("10000000000000000000", rc_String);
  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0898()
  {
    rc_String = (new BigDecimal("1E+19")).toString();
    Assert.assertEquals("1E+19", rc_String);
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+19")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0900()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3")).hashCode();
//    Assert.assertEquals(93, rc_int);
//  }
  public void testItem_0901()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).remainder(new BigDecimal("3"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("3"), 0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0909()
  {
    rc_int = (new BigDecimal("0.1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
//  public void testItem_0913()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("0.1"));
  }
  public void testItem_0919()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.2"));
    Assert.assertEquals("1.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(1);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("300"));
    Assert.assertEquals("-268", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("0.2"));
    Assert.assertEquals("5679395079455", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("-268")).multiply(new BigDecimal("5679395079455"));
    Assert.assertEquals("-1522077881293940", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TY7K9OD=BRS5<L5B6??PKEVR6A<REMVMJ9A9PJ42EO6F7FS69", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("5679395079455")).stripTrailingZeros();
    Assert.assertEquals("5679395079455", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("-1522077881293940")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1522077881293940", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("1522077881293940")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-1522077881293940")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("1522077881293940")).abs();
    Assert.assertEquals("1522077881293940", rc_BigDecimal.toString());
  }
//  public void testItem_0941()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1522077881293940")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0943()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '\1', '\0', '\1', '\1', '8', '\uFFFF', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '8', '\234', '8', '\234', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("1522077881293940")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1522077881293940.0", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigInteger = (new BigDecimal("1522077881293940.0")).toBigIntegerExact();
    Assert.assertEquals("1522077881293940", rc_BigInteger.toString());
  }
  public void testItem_0951()
  {
    rc_long = (new BigDecimal("320")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0952()
  {
    rc_boolean = (new BigDecimal("5679395079455")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0953()
  {
    rc_BigInteger = (new BigDecimal("5679395079455")).toBigInteger();
    Assert.assertEquals("5679395079455", rc_BigInteger.toString());
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\0', '8', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\234', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\1', '\1', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0956()
  {
    rc_String = (new BigDecimal("5679395079455")).toEngineeringString();
    Assert.assertEquals("5679395079455", rc_String);
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("320")).abs();
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("320")).multiply(new BigDecimal("320"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("102400", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0961()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("102400"));
    Assert.assertEquals("102400", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0964()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0965()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("1522077881293940.0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1522077881293940.0", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigInteger = (new BigDecimal("102400")).toBigIntegerExact();
    Assert.assertEquals("102400", rc_BigInteger.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("102400")).stripTrailingZeros();
    Assert.assertEquals("1.024E+5", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("102400")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+5", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_int = (new BigDecimal("1E+5")).compareTo(new BigDecimal("1E+5"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0973()
  {
    rc_BigInteger = (new BigDecimal("102400")).toBigIntegerExact();
    Assert.assertEquals("102400", rc_BigInteger.toString());
  }
  public void testItem_0974()
  {
    rc_int = (new BigDecimal("102400")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("102400")).intValue();
    Assert.assertEquals(102400, rc_int);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0981()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("1.024E+5")).plus();
    Assert.assertEquals("1.024E+5", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_int = (new BigDecimal("1.024E+5")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("102400")).movePointLeft(0);
    Assert.assertEquals("102400", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QFP0LTXMD3UXC8VJ5S:R1=X6:PPC<OU<@RAF2Q@@NNBQQ2UXK6REN2H=1DAQO4;L7Q9QWWACV5?R5P5I8O7RO2SNUN?1GSG6BM;L");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0987()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0988()
  {
    rc_BigInteger = (new BigDecimal("1.024E+5")).toBigInteger();
    Assert.assertEquals("102400", rc_BigInteger.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("102400"));
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1.024E+5"));
    Assert.assertEquals("3.2768E+6", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\0', '\234', '8', '8', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '8', '\234', '\0', '8', '8', '\1', '8', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '8', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\1', '\1', '8', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    rc_int = (new BigDecimal("102400")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0998()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("102400"));
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("2.4410086240052805861293065715963809426911958615746629512401577153040647663907045169737557831244489705591716236100740575115793155890444696737028094358241946477180280804017893616457903214759342467213035235318029012304570437832288715023788627295396692087818935008979169831689390556068041475157595561571894680347179834927630655412029663727789349156152854218735546095879657258636245269970266518006550466849784859663932107551768181953076414038784882572985357233497998381923480461261507382162190210294225439752759738993942429776552020130927198586159165749827169859480547876758698085159624323000327310126839978689357565791291806629825948361441512142181522802968989416804450309814974987270698007644891362209991421324292731477885169845869800984368807950799068248258847134548865529417249185550552915974826750818941525410666311137555920436419209290620844991297140856472178583859472234301646316240617749521335138000530151880107383507214500919601500931086673698600375773190711849759635577346571581448804679459790994838297638769198112687563766055444891772956491213263430371023605025423638641304027212534938086594097548137594934020569568514431434291156763586027647998404493867413310401233709363851143162836244786367658841759310826628065829854071738823260043704509700574098808387668205387494064229457735130200574058515636919488108860837751729840634863919095451062462633664904993059391540663740646895280609474455461009569810765283165799672354184272419052437276931783234580611492182955490903850659378804266452789306640625E-647", rc_BigDecimal.toString());
  }
}
