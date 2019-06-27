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
public class TestSuite045 extends TestCase
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
  
  public TestSuite045() {
	
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("64")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0004()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0005()
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
  public void testItem_0006()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0007()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0008()
  {
    rc_double = (new BigDecimal("3E+1")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
  public void testItem_0009()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\0', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '8', '\1', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\0', '8', '\1', '\0', '\1', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '8', '\0', '\1', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '8', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\0', '\0', '\0', '\0', '8', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '\0', '8', '\uFFFF', '\1', '\0', '8'}, 0, 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0010()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0011()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0013()
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
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("30")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_byte = (new BigDecimal("1.0")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).max(new BigDecimal("-1"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0025()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0026()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0027()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0031()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0032()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("STBUXV8LJ2O9@P6>H8WB?=9MXSVGRQB7XO6GVHQ4D@E6QBGEHXI2F4E5;B6IC;Y69W:U>TYV3L4>BKA", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0042()
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
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0045()
  {
    rc_boolean = (new BigDecimal("1.0")).equals("T9YN1CG4@O9D74K;D=9J<U5RX@YV2VD;2;KK@510@Q<5QW>A;H1MJCKWMM29T3B@4XV6JFGTE7E2>5R6BQS2IKOP4DX1XI=Y28FC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0052()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0053()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).pow(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0055()
  {
    rc_boolean = (new BigDecimal("1.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0059()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.0")).hashCode();
//    Assert.assertEquals(311, rc_int);
//  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_byte = (new BigDecimal("1.0")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0063()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1E+1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RJ3E<H82CU>KUUT=IJDOLAKHF9;5=L7C85TC73829SAQ<O3;9G=<1PKSYLR316XK9D9A1=WSB@S8;6@R4XBT>4@ODO>P9PVC=6FN", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0070()
  {
    rc_byte = (new BigDecimal("1E+1")).byteValueExact();
    Assert.assertEquals(10, rc_byte);
  }
  public void testItem_0071()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0072()
  {
    rc_int = (new BigDecimal("1.0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("4E+1"));
    Assert.assertEquals("0.025", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0076()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0077()
  {
    rc_int = (new BigDecimal("1.0")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0E+1"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0086()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0092()
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
  public void testItem_0093()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S<U@L<SS0C93HSOM;453;9T1D8=F=8TKJ0;3TR@S9EN?FXXHBS9@6EHNUHMN2AEQRF>=U5J6>J06I<U4MG", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0095()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-9E+18"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("-32")).min(new BigDecimal("0"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0098()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9E+18")).divideAndRemainder(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-8999999999999999968", rc_BigDecimal.toString());
  }
//  public void testItem_0102()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0103()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0106()
  {
    rc_int = (new BigDecimal("-8999999999999999968")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-8999999999999999968"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
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
  public void testItem_0112()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\234', '8', '\1', '\1', '\uFFFF', '8', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\1', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\0', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
  }
//  public void testItem_0120()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OV7OHP2H9I2PAX3IJ4LY33?A>4:QOY5A2?GQ@5T6C5O2RFJL:3:UWUC?:9;RHL?HJB8:LXET1S4UFE=US3GK?2J18@XEL7;TJW<H", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0125()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_int = (new BigDecimal("4E+1")).intValueExact();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0128()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0129()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_long = (new BigDecimal("4E+1")).longValueExact();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).max(new BigDecimal("1"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VW<PIRYLH5BR:5BR>6VDK:72GAY;?UTM2?EMCYY2<DNO>E");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0141()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0146()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0147()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0148()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3E+9"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MPJ@MW=8DXD?A9S3OA;?J39ETGLPN45O0ARC8J0I3PVPN8C<A33YYFLAAOXFRC;;YD?HB:1URI=61H>=B:<5NWUMLKP4V?QSWTRR");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).negate();
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0153()
  {
    rc_BigInteger = (new BigDecimal("3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("-3E+9")).movePointRight(-2147483648);
    Assert.assertEquals("-3E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("-3E+9"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E-2147483639")).divideAndRemainder(new BigDecimal("-3E-2147483639"));
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).remainder(new BigDecimal("-3E+9"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E+9"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("-3E+9")).subtract(new BigDecimal("-3E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-3E-2147483639")).divideAndRemainder(new BigDecimal("0E+9"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0166()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\0', '8', '8', '\234', '\0', '\0', '\1', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\1', '8', '\0', '8', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\0', '8', '\234', '\234', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '8', '\0', '\0', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\1'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("5E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+9")).divideToIntegralValue(new BigDecimal("0E+9"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_String = (new BigDecimal("5E-324")).toEngineeringString();
    Assert.assertEquals("5E-324", rc_String);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).divide(new BigDecimal("5E-324"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483639")).plus();
    Assert.assertEquals("-3E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigInteger = (new BigDecimal("0E+9")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483639")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483639")).multiply(new BigDecimal("3E-2147483639"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483639")).divideToIntegralValue(new BigDecimal("0E+9"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0178()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\1', '\0', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\234', '\0', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '8', '\1', '\234', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '8', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\1', '\0', '8', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\1'}, 2147483647, 1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483638")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483639")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483638")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483638, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0184()
  {
    rc_int = (new BigDecimal("0E-2147483638")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WGTPN0UBAM5N:G9<24IE3XL;HSC6C5UWMWI;L6", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
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
    rc_BigDecimal = (new BigDecimal("0E-2147483638")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0188()
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
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483637")).subtract(new BigDecimal("0E-2147483637"));
    Assert.assertEquals("0E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).divide(new BigDecimal("3E-2147483639"), 2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483637")).min(new BigDecimal("0E-2147483637"));
    Assert.assertEquals("0E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483637")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0194()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483637")).divide(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0198()
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
  public void testItem_0199()
  {
    rc_double = (new BigDecimal("1E+12")).doubleValue();
    Assert.assertEquals(1.0E12, rc_double, 0);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1E+12"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0203()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0207()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0208()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0214()
  {
    rc_boolean = (new BigDecimal("-1")).equals("S42WCPY@4AETD9W2Y;WLEBE01IV<2EE<T3PXFKLHGSXSM7OI<H::3:47K81MK?>NAATI3HLLJQPIABR>6AY3CUSFXM3S?5M5>6NB");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0215()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@N>P=<W?ND@ING??T42SQBQ=A;QXW5GYYQJY7PJ365BHB4:NG=X=7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '8', '\uFFFF', '\1', '8', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '\1', '\0', '\1', '\0', '\1', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0224()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0225()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0226()
  {
    rc_boolean = (new BigDecimal("1")).equals("<P:@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("X5QWXWXXQJDGGLO@CW;BR;YOBU>272LU0;GQOU@VAXC31KMQL@@D2BJGA0LHG1VP:AJKG;>MBV8Y:<4DNNQ356TB@O?>EDUFSY<W");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0232()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y6YCY=N86G4P8962:RU<U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("POK7EAD0U;L2JUP>WV;QOX36YP?SWS@CSL71@OH2MAGJI>MH@XL8A4?W<GP3G905JY2IDJIVG4F3A@Q4:TQ?FK8<BM216OW7@76:");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0234()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0235()
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
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PHDLEN<RWXATPRHY;EJM7K1C9:8K<P;=8W:4IYKYS2XS=D2>FPL826D3PX:AV6NNID0=NXV<", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0238()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
//  public void testItem_0239()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\1', '\234', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\1', '8', '\234', '\234', '8', '\0', '8', '\1', '\0', '\0', '\0', '\0', '8', '8', '8', '\0', '\234', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\234'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0246()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0247()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0248()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0250()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
//  public void testItem_0251()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
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
//  public void testItem_0255()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0261()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0262()
  {
    rc_int = (new BigDecimal("9223372036854775807")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0264()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0265()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0266()
  {
    rc_boolean = (new BigDecimal("1")).equals("X@VU83<VWNW7>U=A=46DI0K6;MUSNCH0<PUNC3B@?>K?I>>HB<88QQ1HF6S@14>XNM=6FOKL:>0NH;BC?QR<?>:XFN6AOM2:WP?7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '8', '\1', '\1', '\0', '\0', '\234', '\0', '\1', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '8', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\0', '8', '8', '\234', '\1', '\0', '\0', '8', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\234', '8', '\234', '\0', '\234', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\0', '\0', '8', '8', '\0', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0268()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0269()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0270()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0278()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0281()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("Q8VY84VFWJ>B5<AR>K@EWDXKBB25>JMO89RBF?6LH@?0F0EFU9?<IJ2:?ABWXB25W5L9MC0=@Y:YE1WE:09C>0D4MS5I:V>8MU=0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0283()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0284()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0285()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0287()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0290()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0291()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">AS8PJ6IQTS1Y8<D66VIJ<JW4GUA;H6J3EI3OHSAG2?LM4BFF<KKPLDHHY2PM86@<XJAW3K>PMYVSOFBB<LF", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0292()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0E-2147483629"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("3E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0300()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("0E-2147483629"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483629")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0303()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0307()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(1);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0312()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("6E+309", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("3E+1"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0325()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0326()
  {
    rc_int = (new BigDecimal("6E+309")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("X7E;;JMIY9339BJ07VHR?=XWCK;B7CR082LBSVDS:MLXBB?DL85H>CFQF1A?BCVN8UU>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0330()
  {
    rc_String = (new BigDecimal("6E+309")).toPlainString();
    Assert.assertEquals("6000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).remainder(new BigDecimal("6E+309"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E+309")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\uFFFF', '8', '\0', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0337()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("6E+309"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("6QXVXVN2V7A5C<RRQJ7AP2N@CMBCD?D6?4VKUIBU7:C8G6V4AUNU3ISN@>I01N36CIM57XNATNHPAG<K2KLOGRWQWWN:5C3L=>HQ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("6E+309")).stripTrailingZeros();
    Assert.assertEquals("6E+309", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-31"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0345()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("-31")).movePointLeft(0);
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("-31")).setScale(-1, 1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_int = (new BigDecimal("-31")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0350()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigInteger = (new BigDecimal("-3E+2")).toBigInteger();
    Assert.assertEquals("-300", rc_BigInteger.toString());
  }
  public void testItem_0355()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-31"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("-31"));
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).multiply(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).setScale(0, 0);
    Assert.assertEquals("-300", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("-300")).multiply(new BigDecimal("-3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9.00E+4", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0364()
  {
    rc_BigDecimal_array = (new BigDecimal("9.00E+4")).divideAndRemainder(new BigDecimal("-31"));
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("-31")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0367()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-31"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("-2.7E+2", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_long = (new BigDecimal("-3E+2")).longValueExact();
    Assert.assertEquals(-300L, rc_long);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("9.00E+4")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("2.9E+3", rc_BigDecimal.toString());
  }
//  public void testItem_0373()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("9.00E+4"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("-32"));
    Assert.assertEquals("-62", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_String = (new BigDecimal("-3E+2")).toEngineeringString();
    Assert.assertEquals("-300", rc_String);
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("-62")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-62", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-32")).max(new BigDecimal("-32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0383()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0384()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0385()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6IP;AW<YUR5XENX91<<PFKBC>6IBB?GU=89H<TT=;3<0NBPQ7HDXN3S0>35=Q;TNB;D9>;><HRMK;348KRD6>L2BXWT61JDT;1GN", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_double = (new BigDecimal("-32")).doubleValue();
    Assert.assertEquals(-32.0, rc_double, 0);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0391()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-32"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("-62")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_long = (new BigDecimal("-3E+2")).longValueExact();
    Assert.assertEquals(-300L, rc_long);
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0397()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+2")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).multiply(new BigDecimal("-6E+1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.6E+3", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).abs();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("-62")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-62", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("-62")).multiply(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).multiply(new BigDecimal("-6E+1"));
    Assert.assertEquals("3.6E+3", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigInteger = (new BigDecimal("-2E+3")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("-2E+3")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("-2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":DLA8@ONYKH0@XYA@UVH=:?36TGJK8UKA:;E2TTJD7QOX@A:0HC2<32F6T9<?BRA?E?I9?BHN7AX98PI8H?Q0XWRTBEXBS2PF=AL");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("-62")).setScale(1);
    Assert.assertEquals("-62.0", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("3.6E+3")).plus();
    Assert.assertEquals("3.6E+3", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-62.0")).divide(new BigDecimal("-62"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0415()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0416()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_String = (new BigDecimal("-6E+1")).toString();
    Assert.assertEquals("-6E+1", rc_String);
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-62")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0421()
  {
    rc_int = (new BigDecimal("-6E+1")).intValue();
    Assert.assertEquals(-60, rc_int);
  }
  public void testItem_0422()
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
  public void testItem_0423()
  {
    rc_int = (new BigDecimal("-6E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0426()
  {
    rc_BigInteger = (new BigDecimal("-6E+1")).toBigIntegerExact();
    Assert.assertEquals("-60", rc_BigInteger.toString());
  }
  public void testItem_0427()
  {
    rc_int = (new BigDecimal("-62")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0429()
  {
    rc_BigDecimal_array = (new BigDecimal("-62")).divideAndRemainder(new BigDecimal("-6E+1"));
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
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
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-62.0"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MK;=4=E@08RU;EAG9O>=:B?@UE=2>5<YBOHOW3@=CFDS:H038Q8<JH>Q?220Q0;P9131A:IWP=HB=B48K:WAH94?@L2C=ICL>68>", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0440()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0441()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("-62.0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-62.0", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_int = (new BigDecimal("0.1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("-62.0")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0450()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("-62.0"));
    Assert.assertEquals("-62.0", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0457()
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
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-62.0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_long = (new BigDecimal("2E+308")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("-62.0")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-62.0", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("-62.0")).negate();
    Assert.assertEquals("62.0", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '8'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\234', '\0', '8', '\1', '\234', '8', '\0', '\1', '8', '\0', '\1', '\234', '\1', '\uFFFF', '8', '\0', '\234', '8', '\234', '\234', '\234', '\1', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0468()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0470()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-62.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("-62.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divideToIntegralValue(new BigDecimal("2E+308"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigInteger = (new BigDecimal("-62.0")).toBigIntegerExact();
    Assert.assertEquals("-62", rc_BigInteger.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_String = (new BigDecimal("2E+308")).toString();
    Assert.assertEquals("2E+308", rc_String);
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\0', '8', '8', '\1', '\0', '\1', '\1', '\0', '\1', '\0', '\uFFFF', '8', '8', '\1', '\0', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '\234', '\1', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-62.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0485()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0487()
  {
    rc_String = (new BigDecimal("-2147483648")).toString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0491()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";N2F30TTE@MB?<=X2URLN12:CT@A6FYRMK9KTKTSD3N@OO2IPACH5QY7WMK0HVS", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0495()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308")).multiply(new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308"));
    Assert.assertEquals("4.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000120000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000009E+616", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_int = (new BigDecimal("-8")).intValue();
    Assert.assertEquals(-8, rc_int);
  }
  public void testItem_0499()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("4.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000120000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000009E+616"));
    Assert.assertEquals("4.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000093E+616", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308")).plus();
    Assert.assertEquals("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308", rc_BigDecimal.toString());
  }
  public void testItem_0502()
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
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("4.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000093E+616")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000093E+616", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigDecimal_array = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308")).divideAndRemainder(new BigDecimal("-8"));
  }
  public void testItem_0506()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("4.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000120000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000009E+616"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0507()
  {
    rc_short = (new BigDecimal("-8")).shortValueExact();
    Assert.assertEquals(-8, rc_short);
  }
  public void testItem_0508()
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
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("4.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000093E+616")).multiply(new BigDecimal("-8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+617", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("4.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000093E+616")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("-8")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_String = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308")).toString();
    Assert.assertEquals("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308", rc_String);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_int = (new BigDecimal("-3E+617")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-3E+617"));
    Assert.assertEquals("-1E-616", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("-8")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308")).subtract(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0519()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("?@;D<NIWFSNH;O?LI0L<TB5716CV3TJ0CHV74P7KAY3ISTQ0R4R:RSBVQH4NLVB0KU");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0520()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0521()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("3E-2147483647"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0523()
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
  public void testItem_0524()
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
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("-1E-616")).remainder(new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003E+308"));
    Assert.assertEquals("-1E-616", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("-1E-616"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-3E-615", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("-8")).remainder(new BigDecimal("-3E-615"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("-3E-615")).ulp();
    Assert.assertEquals("1E-615", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0531()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E-615")).divide(new BigDecimal("-2E-615"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).remainder(new BigDecimal("-2E-615"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-615", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AHC:1QMT7EP<APC>B@QQ:AVAVA:4B67S66IE2FYDLVU=L8VAY7HXYUQF<R4VBQ7FLS;W;;C9?724L2H=SMN4E5<X?4N36V1YS5;7");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("-8")).multiply(new BigDecimal("-8"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("-3E-615")).multiply(new BigDecimal("-2E-615"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-1230", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-2E-615")).remainder(new BigDecimal("64"));
    Assert.assertEquals("-2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("-2E-615")).movePointRight(1);
    Assert.assertEquals("-2E-614", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\0', '\234', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\1', '8', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\1', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("1E-615"));
    Assert.assertEquals("8E+615", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E8<COH2:00U@8XSXJ?H3XY<UMS4G;MITN;J=5@Q;7GVCG?6MFEN:06IPW3DEVWT41RWTB3N:N4QG<HOQS5ELXOT>CYA?LH@3310O", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("-2E-615")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).min(new BigDecimal("-2E-614"));
    Assert.assertEquals("-2E-614", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\1', '\234', '\1', '\1', '\1', '\234', '\234', '8', '\uFFFF', '\234', '8', '\1', '\0', '\234', '8', '8', '\1', '\1', '\234', '8', '\234', '8', '\0', '\1', '\0', '\1', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("-2E-615")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("2E-615")).setScale(0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("2E-615")).divide(new BigDecimal("1"));
    Assert.assertEquals("2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("-2E-615")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E-615"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_String = (new BigDecimal("1E-615")).toString();
    Assert.assertEquals("1E-615", rc_String);
  }
  public void testItem_0557()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).movePointRight(0);
    Assert.assertEquals("1E-615", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).divideToIntegralValue(new BigDecimal("2E-615"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).remainder(new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0"));
    Assert.assertEquals("1E-615", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("2E-615")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-615", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("1E-615")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-615", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0564()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E-615")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0565()
  {
    rc_long = (new BigDecimal("2E-615")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).stripTrailingZeros();
    Assert.assertEquals("1E+615", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("1E+615")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1E+615", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("1E+615")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+615", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0571()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+615")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("0E+615")).pow(1);
    Assert.assertEquals("0E+615", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("1E+615")).setScale(0);
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0577()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0581()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0583()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0584()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0585()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_String = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toString();
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0592()
  {
    rc_String = (new BigDecimal("32.0")).toEngineeringString();
    Assert.assertEquals("32.0", rc_String);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigInteger = (new BigDecimal("32.0")).unscaledValue();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0595()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0596()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0598()
  {
    rc_String = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toEngineeringString();
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0599()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";0N0M;ASGGK;OL7:XJ?6DNHFRD572YW6RD>2EMLBA5:MYGK?=RDAA2CAGWPOY=OU1>=2O@FIYMN2G5QKVHNFCHB<=;WEUQ7D4RR4", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":3;9A445MP74MF7Y=XN2CYJY:<VF;4R;0D:DR1P>8OE=P3JLI;;@>1I:DXU<;OO9J5");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\0', '8', '\234', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\0', '8', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\0', '8', '\234', '8', '\0', '\0', '\1', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_String = (new BigDecimal("-2E+9")).toEngineeringString();
    Assert.assertEquals("-2E+9", rc_String);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).plus();
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).stripTrailingZeros();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0623()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0628()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0629()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0630()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).unscaledValue();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
//  public void testItem_0631()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_String = (new BigDecimal("8")).toString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("8")).scaleByPowerOfTen(1);
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0641()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("8E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0644()
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
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0649()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0650()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-9223372036854775808"));
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UR91:B?S@BFS251B;I;?TRH6OSP;484V78U9B<VTFFU2GEX@XX1BF058NWFT93=@;@15F2UGDS6OR2M@1V");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).unscaledValue();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0655()
  {
    rc_String = (new BigDecimal("8E+1")).toPlainString();
    Assert.assertEquals("80", rc_String);
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0QX8DS4QJ0Q1>CUVHH?EHFIP=PKA2WLRCD67Q8A<QY4PLN5YJ2@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0657()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toPlainString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0658()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_long = (new BigDecimal("8E+1")).longValue();
    Assert.assertEquals(80L, rc_long);
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).round(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-2E+19"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.8446744073709551616E+38", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("8E+1"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0667()
  {
    rc_boolean = (new BigDecimal("8E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal_array = (new BigDecimal("-2E+19")).divideAndRemainder(new BigDecimal("8E+1"));
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-2E+19"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.8446744073709551616E+38", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_int = (new BigDecimal("-2E+19")).intValue();
    Assert.assertEquals(-332398592, rc_int);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\1', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\1', '\1', '\0', '\1', '\1', '\234', '\0', '8', '\0', '8', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\234', '8', '\1', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '8', '8', '8', '\0', '\1', '8', '\234', '\234', '\0', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\1', '\1', '8', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0677()
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
  public void testItem_0678()
  {
    rc_String = (new BigDecimal("-2E+9")).toEngineeringString();
    Assert.assertEquals("-2E+9", rc_String);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).movePointLeft(2147483647);
    Assert.assertEquals("-2E-2147483628", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("1.8446744073709551616E+38")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("1.8446744073709551616E+38", rc_BigDecimal.toString());	
    } else {
    	Assert.assertEquals("184467440737095516160000000000000000000", rc_BigDecimal.toString());        	
    }
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("184467440737095516160000000000000000000")).divideToIntegralValue(new BigDecimal("-2E+19"));
    Assert.assertEquals("-9223372036854775808.0000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_float = (new BigDecimal("-9223372036854775808.0000000000000000000")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("1.8446744073709551616E+38")).setScale(0);
    Assert.assertEquals("184467440737095516160000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	 Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
    } else {
    	 Assert.assertEquals("-2000000000", rc_BigDecimal.toString());
    }
  }
  public void testItem_0687()
  {
    rc_int = (new BigDecimal("-2E+19")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("-2E+19")).add(new BigDecimal("-2E+19"));
    Assert.assertEquals("-4E+19", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000")).subtract(new BigDecimal("-2000000000"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000")).subtract(new BigDecimal("-2E+9"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_double = (new BigDecimal("184467440737095516160000000000000000000")).doubleValue();
    Assert.assertEquals(1.844674407370955E38, rc_double, 0);
  }
  public void testItem_0692()
  {
    rc_BigInteger = (new BigDecimal("-2E+19")).toBigInteger();
    Assert.assertEquals("-20000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0694()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2000000000")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0695()
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
  public void testItem_0696()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\234', '\234', '8', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\1', '\0', '8', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\1', '\234', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '\1', '\234', '8', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\1', '\1', '\0', '\1', '\234', '8', '\234', '\0', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\uFFFF', '\234', '\1', '8', '\234', '8', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\0', '8', '8', '\0', '8', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0699()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-2000000000"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0700()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000")).min(new BigDecimal("0"));
    Assert.assertEquals("-2000000000", rc_BigDecimal.toString());
  }
  public void testItem_0704()
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
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("184467440737095516160000000000000000000")).add(new BigDecimal("-2000000000"));
    Assert.assertEquals("184467440737095516159999999998000000000", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("184467440737095516159999999998000000000"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2E+38", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal_array = (new BigDecimal("184467440737095516159999999998000000000")).divideAndRemainder(new BigDecimal("-2000000000"));
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("-2E+38")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-6250000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UFX:E3L@X8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+38")).divide(new BigDecimal("184467440737095516159999999998000000000"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0717()
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
  public void testItem_0718()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0723()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_String = (new BigDecimal("-2")).toEngineeringString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).negate();
    Assert.assertEquals("-32.0", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("-32.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("-2")).pow(1);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-2"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    rc_long = (new BigDecimal("2")).longValueExact();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    rc_int = (new BigDecimal("2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("-2"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32.0"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_int = (new BigDecimal("2")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0743()
  {
    rc_boolean = (new BigDecimal("-2")).equals("J;RH8=KPE9TDU52<>17D@VH6V48NFTC2ICD6E>8RYO4<:J8VHD4L;XTYAKS?U4IYIM0C;LA?W:3NGOAW5N64HPF;3GDX9BMP4OH2");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0744()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("-2")).scaleByPowerOfTen(0);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
//  public void testItem_0747()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32.0")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0748()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0754()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("-2")).scaleByPowerOfTen(1);
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0761()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals(";PYXIOR4D=5MNMU:E@KIYWT>>SWPY2@WNPH0U@QVO3F>VJJYO<JYOMPORN>X6S88TDDW<SKW08:=Q2RV641QTQRPBCE4L?B39J8M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0762()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0764()
  {
    rc_boolean = (new BigDecimal("0")).equals("EO75TCRIXK454:??X=;U;;1CJQT@M9:>:R8W7J>>6AVKC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("-2"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0773()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("-2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0777()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0778()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\1', '\0'}, 0, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_String = (new BigDecimal("-2")).toPlainString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0786()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_float = (new BigDecimal("0.0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0789()
  {
    rc_boolean = (new BigDecimal("32")).equals("14HG0J9S50BM1F:>4OHX?QJ9?4<NPK1A0W264?82Q;KQ4<RI:;8TAQUEV:OEHE84CD>BY0C=EVYLRKN?HL?T?D5I9J6WT6JD6EXD");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0790()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0791()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0794()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
//  public void testItem_0795()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0796()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
//  public void testItem_0797()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0799()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0800()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("-2"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("-2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0805()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointLeft(-1);
    Assert.assertEquals("-20", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\0', '\0', '8', '\234', '8', '\1', '8', '\1', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\0', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '8', '\0', '\1', '\1', '8', '8', '\1', '8', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0809()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0810()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0811()
  {
    rc_int = (new BigDecimal("0.1")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0812()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0813()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal_array = (new BigDecimal("-2")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_int = (new BigDecimal("0.1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0825()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
//  public void testItem_0826()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '8', '8', '8', '8', '\1', '\234', '\uFFFF', '8', '8', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\1', '\0', '8', '8', '\234', '8', '8', '\uFFFF', '\234', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\0', '8', '8', '\1', '\uFFFF', '8', '\0', '8', '\0', '\1', '\234', '\0', '8', '8', '\0', '\uFFFF', '8', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\234', '\1', '\0', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.1")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0833()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0834()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\0', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '8', '8', '\234', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '\234', '\0', '\1', '8', '\234', '\234', '\0', '\0', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0843()
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
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("32"), 1, 1);
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_long = (new BigDecimal("0.2")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0848()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0.2"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("8")).pow(1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_int = (new BigDecimal("8")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).subtract(new BigDecimal("8"));
    Assert.assertEquals("-7.8", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.2")).divide(new BigDecimal("8"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '\uFFFF', '\234', '\234', '\0', '8', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\1', '8', '8', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\uFFFF', '8', '8', '\0', '\234', '\0', '8', '\0', '\0', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '8', '\1', '\0', '\0', '\0', '8', '8', '\0', '\0', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1FQSI1WU25SR5?:B73HPV=8<44>NVJA;GUKG<S3Y9BWLGA@>UN:X;C5@>@LYL8=;5IO<CXUT2NF?W4XMJE7<=S;U751KXY:LA2O<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0862()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("8"));
  }
  public void testItem_0863()
  {
    rc_String = (new BigDecimal("8")).toEngineeringString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0864()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0865()
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
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("8")).max(new BigDecimal("8"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0867()
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
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).ulp();
    Assert.assertEquals("1E+9", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '8', '\234', '\234', '\234', '\1', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\0', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '8'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0872()
  {
    rc_long = (new BigDecimal("-8")).longValueExact();
    Assert.assertEquals(-8L, rc_long);
  }
  public void testItem_0873()
  {
    rc_BigInteger = (new BigDecimal("8")).unscaledValue();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9A:VOR;O02>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0875()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8")).remainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0876()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate();
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal_array = (new BigDecimal("-8")).divideAndRemainder(new BigDecimal("8"));
  }
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0889()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0892()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0894()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 1, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0895()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0898()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0899()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0900()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0901()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9RAJ8R?:5T@T:5XR0L8=CP4WCC<V@IDH428P4UNWIKABMR3DMUEJMFC@5=@D@V?5>QF8VD?YJ4?YQP@CPVO3:0?1YLA38W:RGDFC", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-7", rc_BigDecimal.toString());
  }
//  public void testItem_0903()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-7"), 2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0904()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0905()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0909()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0910()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0914()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0915()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0917()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '\0', '8', '\1', '\1', '\234', '\1', '8', '8', '\1', '\1', '\0', '\1', '\0', '8', '8', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '8', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0918()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0919()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0920()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0921()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0922()
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
//  public void testItem_0923()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0925()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0926()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0928()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_String = (new BigDecimal("320")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0934()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-9223372036854775808"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("320")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-320", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("320")).max(new BigDecimal("320"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0944()
  {
    rc_boolean = (new BigDecimal("-320")).equals("W2KWP<WMLM1A1RJTKOVKD0=CJL>8=E3T=?GCJ=G<3VHOU@B=C9RPX2QDCJW28=NXSG0TOSB:029Q:CAPNTW7@LHKY63<NJ6W5?80");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_String = (new BigDecimal("320")).toString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("-320")).abs();
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0951()
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
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("320")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("321", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-320"));
  }
  public void testItem_0954()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("-320")).abs();
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("321")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0958()
  {
    rc_boolean = (new BigDecimal("0")).equals("H51BV8F5;T=<KF6>BPCV?W@@CO:6RS5AF:T5WM=DWKR9EJ39I9A88PH=Q?5<AUT242T=L8NIT>VI?OAMSH@K4@=7FE8565QYW;@W");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("321")).add(new BigDecimal("321"));
    Assert.assertEquals("642", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("642")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("642", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("3E+2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("-2")).add(new BigDecimal("-2"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-4"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).min(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0970()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("642")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).movePointRight(1);
    Assert.assertEquals("3000", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal_array = (new BigDecimal("642")).divideAndRemainder(new BigDecimal("3000"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
//  public void testItem_0977()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+2")).hashCode();
//    Assert.assertEquals(91, rc_int);
//  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("642")).intValueExact();
    Assert.assertEquals(642, rc_int);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("3000")).movePointLeft(1);
    Assert.assertEquals("300.0", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_byte = (new BigDecimal("-4")).byteValueExact();
    Assert.assertEquals(-4, rc_byte);
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("3000")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).add(new BigDecimal("3000"));
    Assert.assertEquals("3300", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_int = (new BigDecimal("3E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0984()
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
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3300")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigInteger = (new BigDecimal("3300")).unscaledValue();
    Assert.assertEquals("3300", rc_BigInteger.toString());
  }
  public void testItem_0987()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0990()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8O;;MFHOGHX9GI3?QYUV7MJ5:FEMDOPD1J?L8X@=8FMGB>815>K9D=7NPMFOPNE26TX8G@S1<@969=8LTLRI8SDI95LL86;6SKYY");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0992()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("642")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0994()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3300")).hashCode();
//    Assert.assertEquals(102300, rc_int);
//  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\0', '8', '\234', '\234', '\0', '\0', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\234', '\0', '8', '\0', '\0'}, 1, -2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
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
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\1', '\1', '8', '\uFFFF', '8', '\0', '\234', '8', '\0', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\0', '8', '\234', '\1', '\0', '8', '\1', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '8', '\234', '\0', '\1', '\0', '\1', '\0', '\234', '\0', '\0', '\0', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '8', '\1', '\0', '\234', '8', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\0', '8', '\0', '\234', '8', '\0', '\0', '\uFFFF', '\234', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7:L1XM5LA1SWIOFS:R8ET063515?HFA9D<I3EOYG4<F>XUN66KV:=QDE?QWIBFTS>QL<LGDLE4IK>TAOH33PL", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_BigInteger = (new BigDecimal("642")).toBigInteger();
    Assert.assertEquals("642", rc_BigInteger.toString());
  }
}
