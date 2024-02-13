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
public class TestSuite030 extends TestCase
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
  
  public TestSuite030() {
	
  }
//  public void testItem_0000()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0002()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("1135879015891"));
//    Assert.assertEquals("3.6348128508512E+2147483661", rc_BigDecimal.toString());
//  }
//  public void testItem_0003()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0004()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0005()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0006()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0009()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0010()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0014()
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
  public void testItem_0015()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0016()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toString();
//    Assert.assertEquals("0E+2147483648", rc_String);
//  }
//  public void testItem_0017()
//  {
//    boolean caught;
//    rc_byte = (new BigDecimal("00.0E+2147483647")).byteValueExact();
//    Assert.assertEquals(0, rc_byte);
//  }
//  public void testItem_0018()
//  {
//    boolean caught;
//    rc_long = (new BigDecimal("00.0E+2147483647")).longValueExact();
//    Assert.assertEquals(0L, rc_long);
//  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1135879015891"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0020()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@?CSJ8Y4NDBDK4JDGG22?@4FHVPWUDYGYMME<SS=O");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0025()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '8', '\234', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '8', '\1', '8', '8', '8', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\1', '\1', '\0', '\234', '\234', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0030()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toString();
//    Assert.assertEquals("0E+2147483648", rc_String);
//  }
  public void testItem_0031()
  {
    rc_double = (new BigDecimal("00.0E+2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0032()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\1', '8', '\0', '\0', '\1', '\234', '\0', '8', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\0', '\0', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\0', '\234', '8', '\0', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\0', '8', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '\1', '\0', '\1', '8', '\uFFFF', '8', '8', '8', '\0', '\234', '8', '\234', '\uFFFF', '\234', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0034()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0035()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0036()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0041()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0042()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0043()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("3.2"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0050()
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
  public void testItem_0051()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("3.2"));
    Assert.assertEquals("1135879015894.2", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("1135879015894.2"));
    Assert.assertEquals("1135879015894.2", rc_BigDecimal.toString());
  }
  public void testItem_0055()
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
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0064()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0065()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0066()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0070()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0075()
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
  public void testItem_0076()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '\234', '8', '8', '\234', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '8', '8', '\234', '8', '\234', '\234', '\234', '\0', '\uFFFF', '8', '8', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("P@5GY6;@2M@0K::=33TSP49QKKUV5?N8>=1UEM:>X@HIVC4JDCH:::R0?PDS5U28F4OTAL83O1J=EUS6@KRPDA:HKSY85;G>AN5E");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0.03125"));
    Assert.assertEquals("-1.03125", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\234', '\1', '\1', '\0', '8', '\0', '\1', '\0', '8', '\234', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '8', '\234', '8', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\0', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\234', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\234', '8', '8', '8', '\0', '8', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0.03125"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_long = (new BigDecimal("0.03125")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0086()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("EAXB;SVV?<?YSN8:W;PQJR;::P;UFKXL71=@VJ6@7VIY;L6F7VRQ5CD=N1MAO@6;=O2806VGE0KQFLG<5NK0YW:11QGXAC6XS>K7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HWHY2M39T98L<DIIHRF52@=>XW7M4XJYPO0Q5S4ESLE2SF2QH3>I65RR4@X1C05SFAQMU:P?V9CUY9YYCY@T0H:I0G8<9SXS:9:@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0088()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0092()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0094()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<<PGJ6@:JYEY51HKI<45R<TA5HIDQA1MNH;3XYV9HD34F0NX7:U?VQ;7WJBYTC=R@T1K84Q4S=;FD?KA6LCF;M3<15@R8J0CI30V", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E-2147483647"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0102()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0109()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("UX><<>YJT=?H:HL?V:UO<;0F93PUM52OB9<T<C5VCBEK40NJOCC0X1=N");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("Y4IIQF>I>O;EB=@:JLU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0115()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0116()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
  }
  public void testItem_0125()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("4E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("FD?6GAJGEHULAIPKQ:HM3UL8H1V61;K9;J7INODREHPNB66XDM49LFVUFFIPWPFYHS1SO67NDMJ?O1JV1BD?86B212:8R@:IE;E@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("4E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0139()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0142()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0145()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0156()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0158()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?M=6H:2P162<9HGSBP;<<EHVPGQ=3U>2X:MS1?G:CX2HGWRSC809G@3<?WVFCI75>M3SG2I58?=@HAQ423<L6G<NYT", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).divideToIntegralValue(new BigDecimal("3E+9"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("4.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("4.0E-2147483646")).subtract(new BigDecimal("4E-2147483646"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("4.0E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("4E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0171()
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
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-2147483646")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0174()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("-4E-2147483646", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).setScale(2147483647, 0);
    Assert.assertEquals("4.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.0E-2147483646")).movePointRight(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0177()
  {
    rc_float = (new BigDecimal("4E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0179()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0180()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("-4E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("-4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("-4E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("-4E-2147483646"), new MathContext("precision=2147483647 roundingMode=DOWN"));
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("-4E-2147483646")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-8E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-2147483646")).pow(2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).max(new BigDecimal("-8E-2147483647"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-4E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-8E-2147483647"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0190()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.0E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0192()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("4.0E-2147483646")).toPlainString();
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
//  public void testItem_0193()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8E-2147483647")).divideToIntegralValue(new BigDecimal("-8E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("4.0E-2147483646")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3E+1"), 0, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("4.0E-2147483646"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("4.0E-2147483646"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0201()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\1', '\0', '\1', '8', '\0', '8', '\0', '8', '\0', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '\1', '8', '\1', '8', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\0', '\0', '\1', '\1', '\234', '8', '8', '8', '8', '8', '\1', '\0', '\0', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0206()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("320.0E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0210()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0211()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0212()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0213()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\0', '8', '8', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\234', '8', '8', '\1', '\0', '\0', '\1', '\234', '\234', '\234', '8', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\234', '\234', '8', '8', '\0', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '8', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '\0'}, -1, -1, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0215()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
  }
//  public void testItem_0216()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("320.0E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0221()
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
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0224()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0226()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\234', '8', '\0', '8', '\1', '\1', '\234', '\1', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\1', '8', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '8', '8', '\234', '\uFFFF', '\0', '8', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\1', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '8', '8', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\234'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0228()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0229()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '8', '\0', '\1', '8', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\0', '\0', '\0', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '8', '\0', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '\234', '8', '\234', '8', '8', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\1', '\1', '8', '8', '\234', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\1', '\0', '8', '8', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\0', '8', '\234', '\0', '\1', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0232()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0235()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-2147483648"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).max(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1', '8', '\0', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '8', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\0', '\1', '\1', '\1'}, -2147483648, -1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0249()
  {
    rc_String = (new BigDecimal("-10")).toPlainString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_long = (new BigDecimal("-2147483649")).longValueExact();
    Assert.assertEquals(-2147483649L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0252()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0253()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0254()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0256()
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
  public void testItem_0257()
  {
    rc_double = (new BigDecimal("-10")).doubleValue();
    Assert.assertEquals(-10.0, rc_double, 0);
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("-2147483649")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0260()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3E+9")).divideAndRemainder(new BigDecimal("-10"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0261()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+9")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0263()
  {
    rc_BigDecimal_array = (new BigDecimal("-10")).divideAndRemainder(new BigDecimal("-10"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0265()
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
  public void testItem_0266()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_double = (new BigDecimal("-2147483649")).doubleValue();
    Assert.assertEquals(-2.147483649E9, rc_double, 0);
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("-2147483649")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("3E9SC9SB=E:4>8>;TG:MENPHW2;HY=NN>OIH4G>SK13CVMPVP5;JOUU:FF?DBFCX1XQKOEPRRGVPWGQFVH7I8T@FFWD>FCHKF1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_int = (new BigDecimal("3.2")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0279()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0281()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0282()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0286()
  {
    rc_boolean = (new BigDecimal("33")).equals("558:J");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0287()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\0', '8', '\1', '\234', '8', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '8', '8', '\1', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0290()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0291()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0292()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("33")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("1.056E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0297()
  {
    rc_boolean = (new BigDecimal("33")).equals("FT4B:VW4E23O88S>4BKR12GNP9GRFEKA7NUQ:4H7LTUDIJRDW>IT=<?X0FSRQWR1HEWVFS12@OMGGAK1O>KB@?NJN@UP>FLU<RNU");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("33")).divideToIntegralValue(new BigDecimal("33"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("33")).intValueExact();
    Assert.assertEquals(33, rc_int);
  }
  public void testItem_0300()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '8', '\234', '\0', '8', '8', '\0', '\234', '\234', '\234', '\234', '\234', '8', '8', '\1', '\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '8', '8', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8', '8', '\uFFFF', '8', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '8', '\1', '\234', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '8', '8', '\1', '\234', '8', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\234', '\234', '\1', '\234', '8', '8', '\1', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0301()
  {
    rc_long = (new BigDecimal("33")).longValueExact();
    Assert.assertEquals(33L, rc_long);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).abs();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).setScale(2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\uFFFF', '\234', '\1', '8', '8', '\0', '\uFFFF', '8', '\1', '\234', '\1', '\0', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\234', '\234', '8', '8', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '\1', '8', '\0', '8', '\1', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\0', '8', '\1', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\1', '8', '\1', '\234', '8', '\0', '\234', '\0', '\0', '\0', '\234', '\1', '\0', '8', '8', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\0', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).movePointLeft(1);
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0313()
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
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("4"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0316()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("4")).subtract(new BigDecimal("4"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("T6Q>28PIC3MQ=2DK=@PQOTC2WH?753LK;3X:WNACW@14WLD:M;5S1A1BYRKA81TF1T8I9V?6L1MOUOQFAI0VNJ=VG51PXW1V1;0H");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '8', '\1', '\0', '\0', '\234', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0329()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2E+308")).hashCode();
//    Assert.assertEquals(-246, rc_int);
//  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-3E+308", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0340()
  {
    rc_double = (new BigDecimal("2E+308")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0341()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '8', '8', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0344()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0345()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+308")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0352()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QJ42>?Q46E2T=:?RSWDY@@RKWO4@;E>HF>P0IH31");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0355()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0356()
  {
    rc_String = (new BigDecimal("2147483647")).toEngineeringString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0359()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\uFFFF', '\1', '\0', '8', '\234', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\234', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\0', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '8', '8', '\234', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0360()
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
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0370()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0371()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\234', '8', '\1', '\0', '8', '8', '\234', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6<8Q@3DRLG7H>1?9BQY1A013:K<O26C@Y0>1G7B303=VBPQ@@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\0', '8', '\1', '\0', '\234', '8', '\1', '8', '\1', '\1', '8', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '8', '\1', '\0', '\234'}, 2147483647, -1, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0385()
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
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '8', '8', '\0', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '8', '\0', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '\1', '8', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\0', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\1', '\uFFFF', '8', '\1', '8', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\234', '8', '\1', '\1', '8', '\234', '\234', '8', '\0', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0391()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\0', '8', '\1', '\0', '\1', '8', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '8', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\234', '\0', '\234', '8', '8', '8', '\0', '\1', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\234', '8', '\234', '8', '\234', '\234', '\234', '\1', '8', '\1', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\0', '\1', '\234', '8', '\234', '\234', '8', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\1', '\1', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0392()
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
  public void testItem_0393()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(1);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("58OA=X55UT47Y@4C?QQW4;:AVUO>6Y3FMOU7KTTB?7HOADEK1FJ3=WQT9Q?<0TWWS=12:T2OH1H7QLPDU>8CHH=E");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0397()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0399()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\234', '\0', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\234', '8', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '8', '8', '8', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\234', '\1', '\0', '\1', '\1', '\0', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\0', '8', '8', '\0', '8', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '\0', '\234', '\0', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0403()
  {
    rc_String = (new BigDecimal("-92233720368547758080")).toEngineeringString();
    Assert.assertEquals("-92233720368547758080", rc_String);
  }
//  public void testItem_0404()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0405()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, 2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0407()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0408()
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
  public void testItem_0409()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
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
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-2E+17", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0420()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 2147483647, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+17")).divide(new BigDecimal("3.2"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0423()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("4E+2")).divide(new BigDecimal("-2E+17"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-2E-15", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("4E+2")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("4E+2", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("400", rc_BigDecimal.toString());
    }
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigInteger = (new BigDecimal("2E+3")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("1024")).max(new BigDecimal("1024"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0437()
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
  public void testItem_0438()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
//  public void testItem_0439()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1024")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigInteger = (new BigDecimal("1024")).toBigInteger();
    Assert.assertEquals("1024", rc_BigInteger.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0445()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("1024")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0452()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_short = (new BigDecimal("1024")).shortValueExact();
    Assert.assertEquals(1024, rc_short);
  }
  public void testItem_0454()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0455()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0456()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0457()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("1024")).pow(-1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0.001", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\1', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\1', '\1', '\234', '8', '8', '8', '8', '8', '\234', '8', '\1', '\uFFFF', '\1', '\1'}, 0, 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0464()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0465()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0468()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0472()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigInteger();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0473()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0474()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.0")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("5E-324"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+308")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0483()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("5E-324"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).add(new BigDecimal("2E+308"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("4E+308", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999968", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_String = (new BigDecimal("2E+308")).toPlainString();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("2E+308"));
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+616", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).movePointLeft(0);
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+308", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\1', '\234', '\1', '8', '\uFFFF', '\1', '8', '\0', '\0', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '8', '8', '\1', '\234', '\1', '\234', '\0', '8', '8', '\234', '\uFFFF', '\234', '8', '\0', '8', '\0', '8', '\uFFFF', '\234', '\234', '8', '\234', '8', '\0', '\1', '\234', '\234', '\0', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\0', '8', '8', '\1', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '\234', '\0', '8', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\234', '\0', '\234', '\1', '\234', '\1', '\234', '8'}, -2147483648, -2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0499()
  {
    rc_BigDecimal_array = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).divideAndRemainder(new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032"));
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("3E+308")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3E+308", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("4E+308")).max(new BigDecimal("3E+308"));
    Assert.assertEquals("4E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0502()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+308"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("4E+308"));
    Assert.assertEquals("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '8', '8', '\1', '\1', '\234', '\1', '\234', '\1', '8', '8', '8', '\234', '8', '\0', '\0', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '8', '\1', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '8', '8', '\234', '\0', '\1', '\0', '\1', '\234', '8', '\234', '\0', '8', '\uFFFF', '\0', '\1', '\0', '8', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\1'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0505()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0506()
  {
    rc_BigInteger = (new BigDecimal("4E+308")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("3E+308")).add(new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    Assert.assertEquals("699999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\0', '\1', '\0', '8', '\1', '\0', '\0', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '8', '8', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\1', '8', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\234', '8', '\1', '\234', '\234', '\0', '\0', '\0', '\0', '\234'}, 1, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_String = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).toString();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032", rc_String);
  }
  public void testItem_0512()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0513()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).divide(new BigDecimal("3E+308"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).negate();
    Assert.assertEquals("-399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0516()
  {
    rc_int = (new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).stripTrailingZeros();
    Assert.assertEquals("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).multiply(new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("9E+616", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).negate();
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("9E+616")).remainder(new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2304", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("2304")).abs();
    Assert.assertEquals("2304", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    Assert.assertEquals("399999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998", rc_BigDecimal.toString());
  }
  public void testItem_0525()
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
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000032")).subtract(new BigDecimal("2304"));
    Assert.assertEquals("199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997728", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_float = (new BigDecimal("199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997728")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("2304")).setScale(1);
    Assert.assertEquals("2304.0", rc_BigDecimal.toString());
  }
  public void testItem_0532()
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
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("2304")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-2304", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PMMI2PQTQU:JFT5A9Q1ECIUO8X722??T9I2<F:PQUVA8<2NJC>1C3N:P@AQ:0");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0539()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":9@7:Y<?B9P;LQF3TW07@NH5:K6ESV;;NM1H7UTDJ0N<O<FF1C;I>073QH9OOQXW6O2=R2PU19UO7VNGY?CPB??EUWVBS=I@PH8R", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0545()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F3C<Q@Q1KE1TUIHX33YKQ96LEXKB:@VYH88FH<V?CH=S>?512G:XFMUCC9M;OIIUSA>0IPI388HEDP287?4AU=UHPTBWEU99");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0546()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0547()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0550()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0551()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigInteger = (new BigDecimal("4")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, -1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0559()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0560()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0561()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0562()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0564()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\1', '\234', '8', '\234', '\0', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '8', '\234', '\234', '8', '\0', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '8', '8', '\1', '\uFFFF', '\0', '8', '\234', '\1', '\234', '\0', '\0', '\234', '\234', '8', '\1', '\1', '\234', '8', '\234', '\0', '8', '\234', '8', '\1', '\1', '\1', '8', '\0', '\234', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0572()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0574()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2147483647"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0578()
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
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '\234', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\0', '\1', '\234', '\1', '\0', '\234', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\234', '\1', '\234', '\0', '8', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\234', '\1', '\234', '\234', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\234', '\234', '8', '8', '\uFFFF', '\234', '8', '\1', '\1', '8', '\234', '\1'}, 0, -2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0584()
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
//  public void testItem_0585()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4E+1"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0586()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0587()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).stripTrailingZeros();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).pow(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0592()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0593()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0594()
  {
    rc_boolean = (new BigDecimal("1")).equals("M?=RRH5UVOO=4YNJ?3QC2Y2JLG@9U=;V;H2X1;H?WH0@AT426?ET1@LVSNN5V<@PS;S19TGY8YN>Y3:E<AVPYDSL<8;O23I:DBSN");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0595()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).negate();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_long = (new BigDecimal("4E+1")).longValueExact();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_long = (new BigDecimal("-0.1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-0.1"), -1, 1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("4E+1"));
  }
  public void testItem_0610()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("4E+1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '8', '\1', '\234', '8', '\1', '\234', '\0', '8', '\0', '8', '\234', '8', '\1', '\1', '\1', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\1', '8', '\uFFFF'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigInteger = (new BigDecimal("4")).toBigIntegerExact();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0618()
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
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).negate();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(-1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("A8IEY=1@<C6W4S?<?IEPU954L>:EYK9OPMY=O4R3IY@H5:T7N3U9QMRLD0");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0634()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).subtract(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0642()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0643()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    rc_BigInteger = (new BigDecimal("2")).toBigIntegerExact();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0647()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '\234', '\234', '\234', '\0', '\0', '\234', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '8', '\0', '\234', '\1', '\1', '8', '\234', '8', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0649()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0650()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_int = (new BigDecimal("-0.1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '\0', '\0', '8', '\0', '\1', '8', '8', '\234', '8', '8'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0655()
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
  public void testItem_0656()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0659()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0660()
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
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_String = (new BigDecimal("4E+1")).toString();
    Assert.assertEquals("4E+1", rc_String);
  }
  public void testItem_0669()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
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
    rc_BigDecimal = (new BigDecimal("1E+19")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigInteger = (new BigDecimal("-1E+19")).toBigIntegerExact();
    Assert.assertEquals("-10000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1E+19"), new MathContext("precision=1 roundingMode=CEILING"));
  }
  public void testItem_0682()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).plus();
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).min(new BigDecimal("-1E+19"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0688()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0689()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0690()
  {
    rc_int = (new BigDecimal("-1E+19")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("-10000000000000000000", rc_BigDecimal.toString());
    }
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1TOQV?KBAFD5FC6YUJ5M1XYF?F9A=>7F>B69VI1CPUM=;@4=YJ2@6UE;9LONVX0EIHVNN>:?CI;CXK6QX78HI>M;LE?:8S5PPB7U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("-1E+19"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1E+19")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0696()
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
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("-1E+19"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+20", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0701()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\234', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '8', '8', '\234', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), -1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0705()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-1E+19"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0707()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0708()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\0', '\uFFFF', '8', '\234', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\1', '\1', '\234', '\234', '8', '\0', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\1', '\0', '\234'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0713()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0721()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0723()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0727()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\0', '\0', '8', '8', '\1', '\0', '8', '\uFFFF', '\234', '\0', '\1', '\234', '\234', '\234', '8', '\1', '\234', '\0', '\1', '\0', '\234', '8', '\234', '\0', '\0', '\0', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\234', '8', '\0', '8', '\uFFFF', '\1', '8', '\1', '\0', '\1', '8', '\1', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("-2147483648"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).min(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0745()
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
  public void testItem_0746()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0751()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8HK5OEI<XM:D77AUY<UH94;G6MK=OS@6CX44X8S3F6VFQN><9Y;TGNYETH19;ETBDF<TYXP9JJ3KAQDR:CKME4E?JD2:33H1MAK6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0752()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";>RS:4@<8U7YR0X1JMJQSGKXOBXFS0X84FLSC6TWXQEJ;P8I;YWOMBLBSTXI9T09?5BTX0M4:;P5YFLNICXX6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0755()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0756()
  {
    rc_int = (new BigDecimal("0E+1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0757()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KALMRHK;7:Q5II?R@5TWQI@UWSP=9IBV=<HBURH=OGQLQ3HRMKJ=4IQUX<2S<<21PA1GDOB4QWHQ5?344;7CR5VW5<28Y<@?0A@O", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E-2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '8', '8', '8', '\234', '8', '8', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\1', '\1', '\1', '\1', '\1', '8', '\1', '8', '8', '\0', '8', '8', '\1', '8', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '8', '8', '\1', '\1', '\1', '\uFFFF', '\0', '8', '\1', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '8', '\0', '\234', '\0', '\0', '8', '\234'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+1"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0787()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0788()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0789()
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
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0798()
  {
    rc_double = (new BigDecimal("-3E+1")).doubleValue();
    Assert.assertEquals(-30.0, rc_double, 0);
  }
  public void testItem_0799()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).pow(1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigIntegerExact();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
//  public void testItem_0808()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3E+1")).hashCode();
//    Assert.assertEquals(-94, rc_int);
//  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("-3E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("0E-2147483647"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0815()
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
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0817()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0818()
  {
    rc_boolean = (new BigDecimal("32")).equals("I<A8?KIHMPQY6Q4RC5RU9NMTP7K9G8<CE@?BXX7?LE3RBLA5DLA2OQ>A:<KHR0MXSLNR7F;4YCH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).min(new BigDecimal("-3E+1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0822()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\uFFFF', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\234', '\1', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\234', '8', '\1', '\234', '\234', '\0', '\1', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '8', '\0', '\1', '\234', '\0', '8', '\1', '\234', '8', '\uFFFF', '\0', '\1', '8', '\1', '\1', '\0', '\0', '\234', '\1', '8'}, 2147483647, -1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divideToIntegralValue(new BigDecimal("-3E+1"));
    Assert.assertEquals("-6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("LG8XEGO2");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0831()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_String = (new BigDecimal("2E+308")).toString();
    Assert.assertEquals("2E+308", rc_String);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_int = (new BigDecimal("-6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0836()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@B1?F?R1VD4K0RO0@GACYPCWDR;@?:DV=AYG<P=BD2W8Y75HFYB:T25WY9I0E?B@:35DJ1KWE9S45SU0OD6Q1KSLQQ1HQH;5YSHL", new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0837()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("-6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666")).add(new BigDecimal("-6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1E+307", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_int = (new BigDecimal("-2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("-6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("2E+308"));
    Assert.assertEquals("-199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999968", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).movePointLeft(-1);
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0852()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).remainder(new BigDecimal("2147483647"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_float = (new BigDecimal("-10")).floatValue();
    Assert.assertEquals(-10.0F, rc_float, 0);
  }
  public void testItem_0856()
  {
    rc_int = (new BigDecimal("-21474836480")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).divideToIntegralValue(new BigDecimal("-10"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483648"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VX7BX9WTOQXLKXBOO?WW>6ORE7268H?>@A0GOA6B0EJH5X5V3M6H=PS2BGEL;7IR4>SCR7;=DJXCK0N4AO;F6Q>MQY:J=SO?LR=R");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0862()
  {
    rc_long = (new BigDecimal("-21474836480")).longValueExact();
    Assert.assertEquals(-21474836480L, rc_long);
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-21474836480"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0867()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-21474836480"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\uFFFF', '8', '\1', '\1', '8', '\1', '\234', '\1', '\0', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\1', '\0', '\1', '\0', '8', '8', '\0', '\1', '8', '\1', '\0', '8', '8', '8', '8', '\234', '\0', '\1', '8', '8', '\uFFFF', '\234', '\234', '\234', '8', '\0', '\234', '\234', '\1', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\0', '8', '\234', '8', '\0', '8', '\1', '\uFFFF', '\1', '8', '8', '\234', '\234', '8', '\1', '8', '\1', '8', '\234', '\1'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0870()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-21474836480"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0871()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
  }
  public void testItem_0872()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0873()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0875()
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
  public void testItem_0876()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-21474836480"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-687194767360", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0879()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).min(new BigDecimal("-21474836480"));
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).plus();
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-687194767360")).divide(new BigDecimal("0.0"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0883()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0885()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0886()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-687194767360")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0887()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-21474836480"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("-21474836480")).negate();
    Assert.assertEquals("21474836480", rc_BigDecimal.toString());
  }
//  public void testItem_0890()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("21474836480")).divide(new BigDecimal("320.0E+2147483647"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0891()
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
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '8', '8', '8', '8', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0898()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0899()
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
//  public void testItem_0900()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0901()
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
  public void testItem_0902()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("21474836480")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0903()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("21474836480"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0905()
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
  public void testItem_0906()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0907()
  {
    rc_boolean = (new BigDecimal("21474836480")).equals("VU:WN?9DS;6>8LJ:TQ?0D4U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("21474836480")).stripTrailingZeros();
    Assert.assertEquals("2.147483648E+10", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0910()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0911()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.147483648E+10")).divide(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0915()
  {
    rc_int = (new BigDecimal("2.147483648E+10")).scale();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0916()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("21474836480")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.1474836480E+2147483657", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0921()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0922()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '8', '8', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '8', '8', '\0', '\234', '\uFFFF', '8', '\0', '\234', '8', '\0', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\0', '8', '\1', '\1', '\uFFFF', '8', '\234', '\0', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '8', '8', '\234', '\0', '\234', '\0', '8', '\uFFFF', '\234', '8', '8', '8', '\234', '8', '\1', '\uFFFF', '8', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '\1', '8'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0923()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0924()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).scaleByPowerOfTen(1);
//    Assert.assertEquals("2.1474836480E+2147483658", rc_BigDecimal.toString());
//  }
//  public void testItem_0925()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0926()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
//  public void testItem_0927()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("214748364800.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0928()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).subtract(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("2.1474836480E+2147483657", rc_BigDecimal.toString());
//  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0930()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("H2KC1J@K30O>>JOKJ<?FFY4RMKG5DQA?K49PRQI8;:KMUR9AP4E0@<57WIKY88RP", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0931()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("21474836480.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0933()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).divideToIntegralValue(new BigDecimal("1"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0934()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).setScale(-1, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).compareTo(new BigDecimal("21474836480.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0937()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0939()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).max(new BigDecimal("21474836480.0E+2147483647"));
//    Assert.assertEquals("2.1474836480E+2147483657", rc_BigDecimal.toString());
//  }
  public void testItem_0940()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).compareTo(new BigDecimal("21474836480.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0941()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
//    Assert.assertEquals("2.1474836480E+2147483657", rc_BigDecimal.toString());
//  }
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).divide(new BigDecimal("21474836480.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0946()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).subtract(new BigDecimal("21474836480.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\1', '8'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PTVUVFETI<SN");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@>5X:2HUF1G>5<YXM@TN88D;GW2JG>SY76BQ0EUAC70LVTE4IV=IA50O9QD8KOQ54=JM74RLB:5AD9>>EMKQ9991P20PBN841T:X");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0952()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).max(new BigDecimal("32"));
//    Assert.assertEquals("32", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("0E+2147483647")).scale();
    Assert.assertEquals(-2147483647, rc_int);
  }
//  public void testItem_0956()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("21474836480.0E+2147483647")).negate();
//    Assert.assertEquals("-2.1474836480E+2147483657", rc_BigDecimal.toString());
//  }
//  public void testItem_0957()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("21474836480.0E+2147483647"), 0);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0958()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0959()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0961()
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
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0963()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("21474836480.0E+2147483647"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0965()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0966()
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
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0968()
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
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("21474836480.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0970()
//  {
//    boolean caught;
//    rc_long = (new BigDecimal("00.0E+2147483647")).longValueExact();
//    Assert.assertEquals(0L, rc_long);
//  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("21474836480.0E+2147483647"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0974()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0975()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0981()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\1', '\uFFFF', '8', '\234', '8', '8', '\0', '\1', '\234', '\234', '\234', '\0', '\1', '\0', '8', '\1', '8', '\234', '8', '\uFFFF', '\0', '\0', '\0', '8', '\0', '8', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\1', '\1', '\234', '\0', '\234', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '8', '\0', '\uFFFF', '8', '\234', '\234', '\1', '8', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\234', '\234', '8', '\234'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0986()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0987()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\234', '\0', '8', '8', '\1', '\0', '8', '\0', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\0', '\1', '\1', '\1', '8', '\0', '\234', '8', '8', '\234', '\234', '\1', '\234', '8', '\1', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\1', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '\0', '8', '\0', '8', '\uFFFF', '8', '\1', '\1', '8', '\uFFFF', '\0'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0989()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
//  public void testItem_0990()
//  {
//    boolean caught;
//    rc_short = (new BigDecimal("00.0E+2147483647")).shortValueExact();
//    Assert.assertEquals(0, rc_short);
//  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-2147483680", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0994()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483680")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0997()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_float = (new BigDecimal("-2147483680")).floatValue();
    Assert.assertEquals(-2.147483648E9F, rc_float, 0);
  }
}
