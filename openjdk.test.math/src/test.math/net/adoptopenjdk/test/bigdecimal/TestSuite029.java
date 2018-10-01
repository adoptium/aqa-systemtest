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
public class TestSuite029 extends TestCase
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
  
  public TestSuite029() {
	
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9223372036854775807"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AJ3?@I71M@G<M9O5CVQ:TJPJ2J5IYLM:;;DQTBMMH@@S6DX:XOHYF6E0:BLK972:J:<F07M1L1QM7RC3QN88T<9GE2<XE8REWW<0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0005()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9223372036854775807"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\234', '8', '8', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\234', '8', '\234', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '8', '\uFFFF', '\234', '8', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).unscaledValue();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0017()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0020()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@RNXFOH=B28M<11:AKE4==E9OI7S3NCJRURQS>IL09QTFC>X;<SB6I5QT8YEO3KC4RLK21<OWIH=?JD>PL9C6UDE7FY;67;KLYDN", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0027()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0028()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1290221138741506630523881", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0038()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0")).remainder(new BigDecimal("-1.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0039()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\0', '8', '\234', '8', '\0', '\0', '\0', '8', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\uFFFF', '\1', '\234', '8', '8', '\0', '\1', '\234', '\1', '8', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '8', '\0', '8', '8', '\234', '\234', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\0', '\1', '8', '\1', '8', '8', '\uFFFF', '\234', '\1', '8', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0041()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_String = (new BigDecimal("-32")).toString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0053()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0054()
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
  public void testItem_0055()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0056()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0060()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).negate();
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("-32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0084()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-32")).hashCode();
//    Assert.assertEquals(-992, rc_int);
//  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '8', '\0', '\1', '\uFFFF', '8', '\0', '\234', '8', '\234', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '8', '8', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '8', '\0', '\0', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0090()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
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
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0093()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0094()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-2147483648"), 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1M0I<H1Y7@M");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).movePointLeft(1);
    Assert.assertEquals("-214748364.8", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.8")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-214748364.8", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-214748364.8"), java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-214748364.8")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0112()
  {
    rc_int = (new BigDecimal("1.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0113()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-214748364.8"), 2147483647, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.8")).multiply(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("461168601842738790.4", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.8")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-214748364.8", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.8")).subtract(new BigDecimal("-2147483648"));
    Assert.assertEquals("1932735283.2", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("461168601842738790.4")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate();
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0123()
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
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("1932735283.2")).divide(new BigDecimal("-1.0"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1932735283.2", rc_BigDecimal.toString());
  }
//  public void testItem_0126()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1932735283.2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("461168601842738790.4")).add(new BigDecimal("-1932735283.2"));
    Assert.assertEquals("461168599910003507.2", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("-1932735283.2")).subtract(new BigDecimal("-1932735283.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("-1932735283.2")).stripTrailingZeros();
    Assert.assertEquals("-1932735283.2", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("-1932735283.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1932735283.2", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0133()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1932735283.2")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1932735283.2")).divide(new BigDecimal("0.0"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1932735283.2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("0.0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0139()
  {
    rc_BigInteger = (new BigDecimal("-1.0")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1932735283.2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '8', '\1', '8', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '8', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '\234', '8', '\0', '8', '\1', '8', '\1', '\1', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\uFFFF', '8', '8', '8', '\1', '\234', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\234', '\uFFFF', '\234'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("1932735283.2")).divideToIntegralValue(new BigDecimal("-1932735283.2"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("-1932735283.2")).plus();
    Assert.assertEquals("-1932735283.2", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigInteger = (new BigDecimal("-1.0")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1932735283.2"));
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0153()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.0")).hashCode();
//    Assert.assertEquals(311, rc_int);
//  }
//  public void testItem_0154()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate();
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_String = (new BigDecimal("-1.0")).toString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).abs();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).subtract(new BigDecimal("-1.0"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_byte = (new BigDecimal("-1.0")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0162()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0164()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KHXSW:FC8KQVEPL6RT;8YGKRM?BI8MXXVKO=8OVEX=1XYF65TKA2>XM4D<DJ", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0168()
  {
    rc_String = (new BigDecimal("-1.0")).toPlainString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0169()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).movePointLeft(-1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0174()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-10")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0175()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0177()
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
  public void testItem_0178()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0180()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0181()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0182()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0183()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0186()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0187()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '8', '\1', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\234', '\1', '\0', '8', '8', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\0', '\0', '8', '\0', '8', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '8', '8', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '8'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0189()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0190()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-10")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
//    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0191()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TKXI88:JI1G;DFJL=;OR7>7S:3WBAJJ99AXW7:DV>QB;NTP9@?UE?6OO>;3XWEQ3H25K>LQT6S8LGC6:WYGDO62D66Y;0RAT<52L");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0194()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("-1E+1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0196()
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
  public void testItem_0197()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0202()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '8', '\1', '\1', '\uFFFF', '\234', '8', '8', '\0', '\234', '\1', '8', '\1', '8', '\0', '8', '8', '8', '\1', '\uFFFF'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0203()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-1"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("3.2"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0219()
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
  public void testItem_0220()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2.2", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.2")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2.2"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1.2", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("2.2"));
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("2"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0229()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("2"), 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("2")).max(new BigDecimal("0.0"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
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
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("2")).max(new BigDecimal("0.0"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0242()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0243()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0244()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0249()
  {
    rc_boolean = (new BigDecimal("0.0")).equals(">MBPEU:6GQ27C2T4CBWV<FNHK?0D:JJVIY8P9<0UPYT<@IIT@?HAX=10EPLX082?9V87TND;L>Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("0"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0255()
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
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0257()
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
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(1);
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0261()
  {
    rc_boolean = (new BigDecimal("3.2")).equals(":B>8F@<J12VLV1F8D5=N3QN9JK?OG41=;4T7GRXAUB;;JNRHBXH97AH9>?J");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0262()
  {
    rc_String = (new BigDecimal("3.2")).toEngineeringString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0266()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).negate();
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.00"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0269()
  {
    rc_long = (new BigDecimal("0.00")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0270()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0271()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("0.00")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_String = (new BigDecimal("0.00")).toString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0275()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0278()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0.00"), new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0282()
  {
    rc_BigInteger = (new BigDecimal("0.00")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0283()
  {
    rc_int = (new BigDecimal("0.00")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).min(new BigDecimal("0.00"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
//  public void testItem_0287()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.00"), -2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WNJE286N2Y>YHN?I3E1GEMOD:ONFR3LVI", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0291()
  {
    rc_String = (new BigDecimal("0.00")).toString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0.00"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0293()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.00"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0.00"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0296()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0297()
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
  public void testItem_0298()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0299()
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
  public void testItem_0300()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0301()
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
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UN91NH>UDE6::1M9NIYSSRT6JSWSDP<YLJPV?:N51GQY0DY;VPDEHX?GSXNIY@E><;@;5QL0OJVAWJV2O7:P4CW=;E:2ML@LQ?R1", new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0305()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.00"), 0, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
//  public void testItem_0314()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2E-2147483646"), -1, java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
//  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).setScale(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0319()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0320()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9223372036854775807")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0326()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0327()
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
//  public void testItem_0328()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0329()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0333()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("9223372036854775807"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0337()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0338()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("0E-2147483647"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0346()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0347()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0348()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2;GHB3CO3=7E2M");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("28SHTXVYW9<85VC4>G5LE@22JYO69OA36?TM=<5FAW2OMNP??3FT2;G68;CU8B?0FUL=JUI?1XY=@4Y<RXN7OKTH6F7Y=6;TS14V", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0359()
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
//  public void testItem_0360()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0361()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0362()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0366()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-9223372036854775807"));
  }
  public void testItem_0369()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0370()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("2.8823037615171174E+17", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0376()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\234', '\234', '\234', '8', '\1', '\1', '\0', '\1', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\234', '\1', '\1', '8', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\1', '8', '\0', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\1', '8', '\0', '\0', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '8', '8', '8', '8', '\uFFFF', '\0', '8', '8', '\1', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
//  public void testItem_0379()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
//  public void testItem_0380()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0381()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toString();
    Assert.assertEquals("3E-2147483647", rc_String);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C>=>DD54O08Q8P:3D:UWMUR1WYE6MLC67T28@KK=T=DV:ON89FS2C:;PR<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("WYNQ6U@0@LDYR@XT:U5>G257R73D@C;HYTUOC6HJGJ7=CQ4>SYL=0GMDVEC:OHAG;PE6MH:CGVXB?JX542WVRN7J=A");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0387()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).abs(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(-1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("7E+10", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0396()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0399()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0403()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0405()
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
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    rc_String = (new BigDecimal("2147483647")).toString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0410()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0412()
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
  public void testItem_0413()
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
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
//  public void testItem_0418()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0422()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0427()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0428()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("-33")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0432()
  {
    rc_boolean = (new BigDecimal("-33")).equals(";RAA>FMBC78AOSYT:@9XUMPG675;JCW;E9<@N>2ET:EM0;F@XCCUH=UN91Q8I6PQG7GVEAJW@0GPC5YQOF52F67SMXN<X:?@S2E7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0435()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0437()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("-33")).divideToIntegralValue(new BigDecimal("-33"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0441()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\234', '\1', '8', '\0', '\0', '\1', '8', '\1', '\0', '8', '\234', '\0', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\1', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("-33"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0449()
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
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0452()
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
  public void testItem_0453()
  {
    rc_int = (new BigDecimal("1E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E+1"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0460()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("1.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\1', '8'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0468()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0469()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0475()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\1', '\uFFFF', '\0', '8', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\0', '8', '8', '8', '\0', '8', '\1', '\1', '\234', '\234', '\1', '\0', '8', '\uFFFF', '\1', '8'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0476()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S4K?0P?6:K?Y=VRXVHLY0JSF=QRS9M5;XR7QASNUQMRIBQN?4PMXM?", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0480()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).plus();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";6>KT;8HT5:?F?J49WG2K1H1ENMO>23795982=9JSEKL8TI;7H<XH=3490<J7N:P;A?E8=BD0GOBRSRX1J5U5FK9=;15FY3Y:A=1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).stripTrailingZeros();
	Assert.assertEquals(0.00, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).abs();
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.00"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0493()
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
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).movePointRight(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0497()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0498()
  {
    rc_BigDecimal_array = (new BigDecimal("0.01")).divideAndRemainder(new BigDecimal("0.01"));
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).negate();
    Assert.assertEquals("-0.01", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal_array = (new BigDecimal("-0.01")).divideAndRemainder(new BigDecimal("-0.01"));
  }
  public void testItem_0501()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0503()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("9?G1WW?N??UB=:04VVGTSQO7PU5FOT1B6X@D7F9M1F6GQ7QO?8T645FKDEK;CE;VQIX0;4RJDCUP42CPVL<P9?757O0BOFAWTOKE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '8', '\0', '8', '8', '\1', '\uFFFF', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0508()
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
  public void testItem_0509()
  {
    rc_BigInteger = (new BigDecimal("-0.01")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0510()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0511()
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
  public void testItem_0512()
  {
    rc_float = (new BigDecimal("0.0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.01")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0514()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3E-2147483646")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0515()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0516()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.01")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.01")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0518()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("-0.01")).movePointRight(0);
    Assert.assertEquals("-0.01", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0521()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0522()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0523()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-0.01")).hashCode();
//    Assert.assertEquals(-29, rc_int);
//  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).max(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.01")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0528()
  {
    rc_long = (new BigDecimal("8")).longValue();
    Assert.assertEquals(8L, rc_long);
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-0.01")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("-0.01")).subtract(new BigDecimal("8"));
    Assert.assertEquals("-8.01", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G4S:1QAA2C@1WL1I6KHL6YQ5;?6?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("-0.01")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\1', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\234', '\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_int = (new BigDecimal("8")).intValueExact();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '8', '8', '\0'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0541()
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
  public void testItem_0542()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-8.01"));
    Assert.assertEquals("-2.6810033E+8", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0545()
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
  public void testItem_0546()
  {
    rc_float = (new BigDecimal("-2.6810033E+8")).floatValue();
    Assert.assertEquals(-2.68100336E8F, rc_float, 0);
  }
  public void testItem_0547()
  {
    rc_int = (new BigDecimal("1E+2147483647")).compareTo(new BigDecimal("1E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0548()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("38PUI1QBCS<3:J3F8R99KKLGHRO:9YX=P;=YB6SP?>;2L7DRVPGEBC2PKN?SX7414KFN<CF2E4@6U=2B=E0YR6W8A@OH:E6VLOLD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("-2.6810033E+8")).subtract(new BigDecimal("-2.6810033E+8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigInteger = (new BigDecimal("-2.6810033E+8")).unscaledValue();
    Assert.assertEquals("-26810033", rc_BigInteger.toString());
  }
//  public void testItem_0552()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2.6810033E+8")).hashCode();
//    Assert.assertEquals(-831111024, rc_int);
//  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("8"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0554()
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
//  public void testItem_0555()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2.6810033E+8")).divideAndRemainder(new BigDecimal("1E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0556()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-2.6810033E+8"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-2.6810033E+8"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0559()
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
  public void testItem_0560()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-2.6810033E+8"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0561()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_String = (new BigDecimal("1E+2147483647")).toString();
    Assert.assertEquals("1E+2147483647", rc_String);
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0570()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0573()
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
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0577()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).min(new BigDecimal("1"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\1', '\234', '\0', '\1', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\1', '8', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '\234', '8', '8', '\uFFFF', '8'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0584()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0592()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0596()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0600()
  {
    rc_boolean = (new BigDecimal("-1")).equals("<2CE<;RORS1C3U8I9KW>9UFHSO;S:H<M=TOG82BYF569XOIW;SBN:YU8T6NKEM9FRN76YGTY05R7YFNQ6I2GDE?FOXYOHOCQ1YG=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0605()
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
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0608()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0609()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1, 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0621()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0623()
  {
    rc_boolean = (new BigDecimal("1")).equals("2B5;7K6ESG0ACFKGV20Y9SVKO<1<5843C7FQ>W7?C<SUT7P@PJRP?LX4OCWB@AR?O98@Y8V3V>A5J;:2::RWFS:D7XSPSDYAOA;<");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.0")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0627()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0633()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0635()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RATV0Y@BAQ3=XO7D1W=3S6=N5LU5R;:XKDB96=DC@<", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_int = (new BigDecimal("-3E+1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\234', '8', '\0', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '8', '8', '\234', '\1', '\0', '\1', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '8', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\234', '\234', '8', '\234', '\234', '\234', '\234', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0643()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0644()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("1E-2147483647"), 0, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0645()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0646()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1E-2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("1E-2147483647"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0649()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("-1.0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0650()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_short = (new BigDecimal("-1.0")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0660()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0662()
  {
    rc_float = (new BigDecimal("1E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0663()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1.0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).add(new BigDecimal("-1.0"));
    Assert.assertEquals("-2.0", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0")).divide(new BigDecimal("1E-2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0666()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-2.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0671()
  {
    rc_String = (new BigDecimal("-1.0")).toEngineeringString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\1', '8', '8', '8', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '8', '\234', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\1', '\234', '\1', '\234', '\1', '\0', '\uFFFF', '\1', '8', '8', '\0', '\1', '\0', '\1', '\0', '8', '\234', '8', '\1', '8', '\1', '8', '8', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).add(new BigDecimal("-1.0"));
    Assert.assertEquals("-2.0", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("-2.0")).add(new BigDecimal("-2.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-4.0", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0677()
  {
    rc_double = (new BigDecimal("-2.0")).doubleValue();
    Assert.assertEquals(-2.0, rc_double, 0);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("-2.0")).multiply(new BigDecimal("-4.0"));
    Assert.assertEquals("8.00", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-4.0"));
    Assert.assertEquals("5.0", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("8.00"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigInteger = (new BigDecimal("5.0")).unscaledValue();
    Assert.assertEquals("50", rc_BigInteger.toString());
  }
//  public void testItem_0683()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("5.0")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("-2.0")).negate();
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">:;L3W5VSBYC5>;<UYSDFOV1TMNGP4=1SN2HGJSRQ3P?NMPG7C2DCB6<RFIO", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '8', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '\0', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '\234', '8', '\1', '8', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\234', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\234', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("8.00")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0692()
  {
    rc_byte = (new BigDecimal("8.00")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("8.00")).movePointLeft(0);
    Assert.assertEquals("8.00", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("8.00"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("40.00", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("-32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EI4A2MN0TJE07F>0T?R5U@HASJN0=UA>MVH08VUE?CSPOI=3GTFH133CTUB<?TSHB8O<3A:NEQ3C8HD;KMP9MV>344C2?@YSJKB=", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0699()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("-32.0E+2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0700()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0703()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0705()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("32"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0708()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("-32.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("-32", rc_BigInteger.toString());
//  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0712()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0713()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0715()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).subtract(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0716()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).divide(new BigDecimal("-32.0E+2147483647"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0718()
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
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).max(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1.0"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0724()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0725()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0727()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).movePointRight(-1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0728()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-32.0E+2147483647")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0729()
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
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0731()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_byte = (new BigDecimal("0E+2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0734()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+2147483647")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0737()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FN>QEUX2U7KYFBI?NQE@YX9", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0741()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E+2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0744()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0746()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0747()
  {
    rc_byte = (new BigDecimal("0E+2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0748()
  {
    rc_long = (new BigDecimal("1.0")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).max(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1.0"), -1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0754()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0755()
  {
    rc_boolean = (new BigDecimal("0E+2147483647")).equals(":A;C5FG53VBCI998OLDS@J2S75MDHU1R=8WV6O7XM2LVE>7H25HA1TN@WUDMB6CC67T0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0759()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2=MRR2UBDFE=I2;4IX<S02G8KA06RCLFEEIXN>M2GTQ<>V?565K5A3X5R;C@UJUC3OY605FJ0OOLCYDU821J0>50Y37D2VLAUW;Y");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).remainder(new BigDecimal("-3.2"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).multiply(new BigDecimal("-3.2"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0766()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).add(new BigDecimal("0E+2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).subtract(new BigDecimal("0E+2147483646"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0770()
  {
    rc_boolean = (new BigDecimal("-4")).equals("O<V6JG3SM?RJ>G63>F64DCW=;94OMMHSWJ5<02YR3XFLMIJNJAP=7ISS:4;2HP3KXI1B==9K@5X?26;FC;HP5JTE54DQXFRE2C;X");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0E+2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0775()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+2147483646")).divideAndRemainder(new BigDecimal("0E+2147483646"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0776()
  {
    rc_int = (new BigDecimal("0E+2147483646")).compareTo(new BigDecimal("0E+2147483646"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0780()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_byte = (new BigDecimal("0E+2147483646")).byteValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("1135879015891"));
    Assert.assertEquals("-1135879015861", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("1135879015891"), 0);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0786()
  {
    rc_boolean = (new BigDecimal("32")).equals("S?8PYM");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0787()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0788()
  {
    rc_boolean = (new BigDecimal("320.0E+2147483647")).equals("W4IR3S9U2DERGITI?XL7@>3AJ5L0KD<39L23J@D3LR51S?WSXADFMBW6>AO3189;6U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1135879015861"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(-1);
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
//  public void testItem_0794()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).stripTrailingZeros();
    Assert.assertEquals("-1135879015861", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0797()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("11358790158910")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\0', '\234', '\234', '\1', '\0', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '8', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '8', '8', '\0', '\234', '\0', '\1', '\234', '8', '\1', '\234', '\1', '8', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\234', '\uFFFF', '\1', '\1', '8', '\0', '\234', '\1', '\1', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '8', '\0', '\uFFFF', '8', '8', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_BigInteger = (new BigDecimal("-2E+308")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
//  public void testItem_0801()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("-1135879015861"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0803()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0805()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0806()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015861")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0807()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\1', '8', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\1', '8', '\0', '\234', '\uFFFF', '8', '\1', '8', '8', '\uFFFF', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\1', '\0', '8', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '8', '\234', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0808()
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
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigInteger = (new BigDecimal("-1135879015861")).toBigInteger();
    Assert.assertEquals("-1135879015861", rc_BigInteger.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0813()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1135879015861")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KQ<HS6WOW;QF3;FVGQ841Q6GS3P80N1U4B2JW97N?BD>=2M6SNYI3IKDI<?4R=;>SH7U1FB>V@HTTJ@EON0RX?O?O?96H9AAB07J", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1135879015861"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1135879015860", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigInteger = (new BigDecimal("-1135879015861")).toBigIntegerExact();
    Assert.assertEquals("-1135879015861", rc_BigInteger.toString());
  }
  public void testItem_0824()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_double = (new BigDecimal("-1135879015861")).doubleValue();
    Assert.assertEquals(-1.135879015861E12, rc_double, 0);
  }
  public void testItem_0827()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).multiply(new BigDecimal("-1135879015861"));
    Assert.assertEquals("1290221138673353889571321", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).stripTrailingZeros();
    Assert.assertEquals("1290221138673353889571321", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1290221138673353889571321")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0831()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("-1E+24", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\uFFFF', '\0', '\1', '\1', '\1', '\0', '8', '\0', '\1', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '8', '8', '\234', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\0', '\234', '\0', '\1', '\234', '\0', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\234', '8', '8', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0833()
  {
    rc_int = (new BigDecimal("1290221138673353889571321")).compareTo(new BigDecimal("-1135879015860"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0834()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).subtract(new BigDecimal("1290221138673353889571321"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).plus();
    Assert.assertEquals("-1135879015861", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015860")).plus();
    Assert.assertEquals("-1135879015860", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\uFFFF', '8', '\0', '\1', '\1', '\234', '8', '8', '\uFFFF', '8', '\234', '\234', '\1', '\1', '\1', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF'}, 0, 0, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015860")).divide(new BigDecimal("-1135879015861"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_int = (new BigDecimal("1290221138673353889571321")).intValue();
    Assert.assertEquals(-1845861895, rc_int);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).add(new BigDecimal("-1135879015861"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+24", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_int = (new BigDecimal("1E+24")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0845()
  {
    rc_int = (new BigDecimal("-1135879015860")).intValue();
    Assert.assertEquals(-2007649716, rc_int);
  }
//  public void testItem_0846()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1290221138673353889571321")).hashCode();
//    Assert.assertEquals(618456361, rc_int);
//  }
  public void testItem_0847()
  {
    rc_int = (new BigDecimal("1290221138673353889571321")).intValue();
    Assert.assertEquals(-1845861895, rc_int);
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).negate();
    Assert.assertEquals("1135879015861", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("1135879015861")).multiply(new BigDecimal("1E+24"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1.135879015861E+36", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).subtract(new BigDecimal("-1135879015861"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1290221138674489768587182", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("1290221138674489768587182")).abs();
    Assert.assertEquals("1290221138674489768587182", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).plus();
    Assert.assertEquals("1290221138673353889571321", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015861")).divide(new BigDecimal("1290221138673353889571321"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("1E+24")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1E+24", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015861E+36")).stripTrailingZeros();
    Assert.assertEquals("1.135879015861E+36", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).plus();
    Assert.assertEquals("1290221138673353889571321", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\234', '\0', '\1', '\1', '\0', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\0', '\1', '\1', '\1', '\0', '8', '8', '\0', '\234', '\234', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '\1', '\0', '\0', '\1', '8', '\0', '8', '\1', '\0', '8', '8', '\234', '8', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\1', '\234', '8', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\0'}, -1, -1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0862()
  {
    rc_boolean = (new BigDecimal("1290221138674489768587182")).equals(";N;=O");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0863()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015861E+36")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1.135879015861E+36", rc_BigDecimal.toString());
  }
//  public void testItem_0865()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1290221138674489768587182")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015861E+36")).multiply(new BigDecimal("1.135879015861E+36"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1.290221138673353889571321E+72", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8AXBGAFH=95TM3LMDRRXP21TE0G805PXGUYQL003YR7QMM@IM4YF;CPXKE8MJ=0RH5T00EKRI=OAOXKEXSYLAY?9@C;=SSE:2K>D", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0870()
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
  public void testItem_0871()
  {
    rc_String = (new BigDecimal("1290221138673353889571321")).toEngineeringString();
    Assert.assertEquals("1290221138673353889571321", rc_String);
  }
  public void testItem_0872()
  {
    rc_String = (new BigDecimal("1290221138674489768587182")).toEngineeringString();
    Assert.assertEquals("1290221138674489768587182", rc_String);
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("1290221138674489768587182")).subtract(new BigDecimal("1290221138673353889571321"));
    Assert.assertEquals("1135879015861", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigInteger = (new BigDecimal("1.290221138673353889571321E+72")).toBigIntegerExact();
    Assert.assertEquals("1290221138673353889571321000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1290221138673353889571321"), 2147483647, 0);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0878()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0879()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1290221138673353889571321")).hashCode();
//    Assert.assertEquals(618456361, rc_int);
//  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("1.290221138673353889571321E+72")).divide(new BigDecimal("1.290221138673353889571321E+72"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1290221138673353889571321"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("3O?M<1<C549:BBCIEMP=VW@0M??W5QI4?5OP0JT3K0RUO3?005<LLH4SX?M<@1ITFA2;ET165DNW9T?>KK;@BT?AQINXKE2G=G:4");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JO3<2?FKJ>HBRU0HSDB1CP5X3LY9=;IICFRHUW4A:0X6XXU>MBKWG7SX<4UG2:BSOHSXBPLT<<I5YO<WA654OEK;P0=V1XFW9IRU");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0890()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q@VR2KJ7BR<3GW1JWQYCGJ@=CYJ6J2GM3<UL3>GTU;>OLDD744BHB1SIFUR=GTL7A53EMM>KVCRX85NSG<N473SRW<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0892()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0893()
  {
    rc_double = (new BigDecimal("1290221138673353889571321")).doubleValue();
    Assert.assertEquals(1.2902211386733539E24, rc_double, 0);
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0896()
  {
    rc_int = (new BigDecimal("1290221138673353889571321")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0897()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0898()
  {
    rc_BigInteger = (new BigDecimal("1290221138673353889571321")).toBigInteger();
    Assert.assertEquals("1290221138673353889571321", rc_BigInteger.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0901()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).setScale(2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("1290221138673353889571321"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0904()
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
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).negate();
    Assert.assertEquals("-1290221138673353889571321", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).divide(new BigDecimal("-1290221138673353889571321"), -1, java.math.RoundingMode.UP);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_long = (new BigDecimal("-1E+1")).longValue();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0916()
  {
    rc_float = (new BigDecimal("1290221138673353889571321")).floatValue();
    Assert.assertEquals(1.2902211972082195E24F, rc_float, 0);
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("1290221138673353889571321")).subtract(new BigDecimal("-1290221138673353889571321"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2580442277346707779142642", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0920()
  {
    rc_boolean = (new BigDecimal("1")).equals("AM8O:73:MP:Y8XBL=9>2SH4:K1XBW4PAHOD85F>1<JB9?G1KF<LE48JTNWJ<IPFG8VTQHG1R8F1D0SN51B=MFI1@PJ709VYTYJ19");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0921()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7A:?=Q<AGNE;2=F5DOXG0YM>P576FAQEGR1SHU4VDP627O<6JDFIEJ5UDFNM?UBN8RD@?228R5DOJ:XPN<8XJ2T>;IC6:R9C=PU:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0928()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0929()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0930()
  {
    rc_boolean = (new BigDecimal("1")).equals("@40KUCSDDE8Q18>HS=EW>;FHCF?3XQX:?BTI=V:7UASUXT31MXTG:8UAHKSDWD0PI<@21R2OYL168X>6CB7AWEV2<JU0>6X=2QX0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("2580442277346707779142642")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0933()
  {
    rc_String = (new BigDecimal("-1E+1")).toPlainString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0934()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toPlainString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0935()
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
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2580442277346707779142642")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1E+1"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("-10")).multiply(new BigDecimal("-10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("2580442277346707779142642"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\0', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\0', '8', '8', '\0', '\0', '8', '8', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\234', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\1', '\234', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\0', '\234', '8', '8', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\1', '8', '8', '\0', '\234', '\1', '\234', '\0', '\234', '8'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0946()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0947()
  {
    rc_long = (new BigDecimal("1E+2")).longValueExact();
    Assert.assertEquals(100L, rc_long);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).add(new BigDecimal("32"));
    Assert.assertEquals("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).stripTrailingZeros();
    Assert.assertEquals("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_int = (new BigDecimal("1E+2")).intValueExact();
    Assert.assertEquals(100, rc_int);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).divide(new BigDecimal("1E+2"), 0);
    Assert.assertEquals("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).divide(new BigDecimal("1E+2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657")).divideToIntegralValue(new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_double = (new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657")).multiply(new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_String = (new BigDecimal("1E+1")).toString();
    Assert.assertEquals("1E+1", rc_String);
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0.320000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000049406564584124654417656879286822137236505980261432476442558568250067550727020875186529983636163599237979656469544571773092665671035593979639877479601078187812630071319031140452784581716784898210368871863605699873072305000638740915356498438731247339727316961514003171538539807412623856559117102665855668676818703956031062493194527159149245532930545654440112748012970999954193198940908041656332452475714786901472678015935523861155013480352649347201937902681071074917033322268447533357208324319360923828934583680601060115061698097530783422773183292479049825247307763759272478746560847782037344696995336470179726777175851256605511991315048911014510378627381672509558373897335989936648099411642057026370902792427675445652290875386825064197182655334472657"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("0.3"));
    Assert.assertEquals("-30.3", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0.3"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("-30.3")).add(new BigDecimal("-30.3"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0971()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.3")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0972()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("0"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0973()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0976()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0977()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0978()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0979()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\0', '8', '8', '8', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '8', '\234', '8', '\0', '8', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\1', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0980()
  {
    rc_int = (new BigDecimal("-3E+1")).intValueExact();
    Assert.assertEquals(-30, rc_int);
  }
//  public void testItem_0981()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-30.3"), 1, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\0', '\0', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '\0', '\1', '\0', '\0', '\0', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\234', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\0'}, 0, 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\0', '8', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\1', '\1', '\1', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\0', '8', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0984()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0987()
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
//  public void testItem_0988()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).pow(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0990()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0991()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4Q>3J:=CSD?;NDUTLIEKL6TV>5J4FJ@GS:J81");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0994()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0995()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
}
