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
public class TestSuite042 extends TestCase
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
  
  public TestSuite042() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("214748363.7")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("11.7", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("214748363.7"));
    Assert.assertEquals("214748395.7", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("214748363.7")).plus();
    Assert.assertEquals("214748363.7", rc_BigDecimal.toString());
  }
//  public void testItem_0007()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("214748395.7"));
    Assert.assertEquals("214748395.7", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0010()
  {
    rc_String = (new BigDecimal("214748363.7")).toPlainString();
    Assert.assertEquals("214748363.7", rc_String);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("214748395.7")).plus();
    Assert.assertEquals("214748395.7", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("214748363.7"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0")).divide(new BigDecimal("214748395.7"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0015()
  {
    rc_String = (new BigDecimal("214748363.7")).toPlainString();
    Assert.assertEquals("214748363.7", rc_String);
  }
//  public void testItem_0016()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("214748395.7")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0019()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0020()
  {
    rc_int = (new BigDecimal("214748395.7")).compareTo(new BigDecimal("214748395.7"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0021()
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
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).divide(new BigDecimal("32.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0023()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_long = (new BigDecimal("32.0")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).divideToIntegralValue(new BigDecimal("32.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0029()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\0', '\0', '\234', '8', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\0', '\234', '8', '\0', '\0', '\234', '\0', '\0', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '8', '8', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\0', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\1', '\234', '\1', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '8', '\uFFFF', '8', '8', '\0', '\1', '8', '\234', '\0', '\234', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\1', '\234', '8', '\0', '\234', '8', '\234', '\234'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0030()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0031()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3.2E-2147483646"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0032()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("32"), java.math.RoundingMode.CEILING);
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\1', '8', '\1', '\1', '\0', '\234', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '8', '8', '8', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\1', '\234', '\234', '\234', '\0', '\234', '\0', '8', '\234', '\0', '\1', '8', '8', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0037()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).plus();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0038()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1"), 0);
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0039()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("1"));
//    Assert.assertEquals("1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0042()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0045()
  {
    rc_boolean = (new BigDecimal("1")).equals("L@N1GI>5>LV0?RPWVF>SLTB2O0U4TI2IIE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0046()
  {
    rc_long = (new BigDecimal("4E+1")).longValueExact();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0051()
  {
    rc_boolean = (new BigDecimal("1E+1")).equals("AP@G;;1HV9WW76INA7QN8B=P?DKC8SEXTBTGN86>JN9DHD6DP147NOUDK=Q11ANET?@8FA5JIKOEI<3SODG59;6FQ1?RSPR;4W09");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '\1', '\1', '8', '\234', '\1', '\0', '\0', '\234', '8', '\0', '8', '8', '8', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '\0', '\234', '\234', '\1', '8', '\0', '\0', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '8', '\1', '\1', '8', '\1', '\1', '8', '\0', '\234', '8', '\1', '8', '\1', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '\234', '\234', '\0', '8', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0054()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0056()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("32"), -2147483648, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0057()
  {
    rc_short = (new BigDecimal("4E+1")).shortValueExact();
    Assert.assertEquals(40, rc_short);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0061()
  {
    rc_BigInteger = (new BigDecimal("4E+2")).toBigInteger();
    Assert.assertEquals("400", rc_BigInteger.toString());
  }
  public void testItem_0062()
  {
    rc_BigInteger = (new BigDecimal("4E+2")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0063()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("4E+2"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0066()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0067()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0068()
  {
    rc_int = (new BigDecimal("4E+2")).intValueExact();
    Assert.assertEquals(400, rc_int);
  }
  public void testItem_0069()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0071()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("4E+2"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("2839697540", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1E-2147483647"), 1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0084()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0085()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E-2147483647")).hashCode();
//    Assert.assertEquals(-2147483618, rc_int);
//  }
  public void testItem_0086()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0087()
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
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(0);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E-2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0102()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0105()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\234', '8', '8', '8', '\1', '\0', '\0', '\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\1', '8', '\1', '8', '8', '\1', '8', '8', '8', '\0', '\234', '\234', '\234', '\1', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '\234', '\234', '8', '8', '\234', '\0', '8', '\1', '8', '\234', '8', '\0', '\0', '\0', '\uFFFF', '8', '8', '8', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1'}, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0113()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0119()
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
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0121()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615865843651857942052864")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0126()
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
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0128()
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
  public void testItem_0129()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0133()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0137()
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
//  public void testItem_0138()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0139()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FOU68HTUG;PV3W21C:UR6IUYY8FB3CCD:6:G=0GARPQHISF;F:TQE05W>:8UVFXLJ26:M?653?X<XP6NLAH<YFM8JE90=G39PM25", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0141()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '8', '8', '\0', '8', '8', '\0', '\234', '\234', '\234', '\0', '\1', '\0', '\0', '\0', '8', '\1'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
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
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0147()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0148()
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
//  public void testItem_0149()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("4E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("85070591730234615865843651857942052864")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0152()
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
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615865843651857942052864")).subtract(new BigDecimal("85070591730234615865843651857942052864"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0156()
  {
    rc_String = (new BigDecimal("85070591730234615865843651857942052864")).toEngineeringString();
    Assert.assertEquals("85070591730234615865843651857942052864", rc_String);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0161()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0163()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0164()
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
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615865843651857942052864")).movePointRight(1);
    Assert.assertEquals("850705917302346158658436518579420528640", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\1', '\1', '8', '\1', '\1', '\0', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\234', '\234', '\0', '8', '\1', '\234', '8', '\1', '\1', '8', '\0', '\1', '8', '\uFFFF', '8', '\234', '\234', '8', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\0', '8', '\1', '8', '\0', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\1', '\234', '\234', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '\234', '8', '\0', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\234', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '8', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\uFFFF', '8', '8', '\234', '\1', '\1', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\234', '\1', '\0', '\234', '\1', '\234', '\234', '\1', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\234', '8', '\234', '\1', '\uFFFF', '\0', '8', '\234', '8', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\0', '\0', '8', '8', '\1', '\234', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615865843651857942052864")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, -1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4>M6P<YP8NV2<4P18?3B78V:P:35HHGL:@?PU2>X8J=0C=P?4SWG@4A:O4PKUDIN:E;UM6E32W4?EF0OLSQOVV4?FH99U15NANXH");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("-85070591730234615865843651857942052864")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0182()
  {
    rc_BigInteger = (new BigDecimal("-85070591730234615865843651857942052864")).toBigInteger();
    Assert.assertEquals("-85070591730234615865843651857942052864", rc_BigInteger.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, 1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
//  public void testItem_0192()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0197()
  {
    rc_boolean = (new BigDecimal("0")).equals(">T:RKKDTUPV4LUY2G9NO:54EVY<X@UD;F>H627G86I>B0KFOXH;2;EGJ<G@HA9TLHALH1WC4?U>7<=OCHR91FD;4LSL8EMI<3F02");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0198()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0202()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0203()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0208()
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
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("-31")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0214()
  {
    rc_boolean = (new BigDecimal("-1")).equals("EDSFR286N5660WF1CCWW4Q4@2A6@0Y4KEVHBG324HP;S;AFY@;TH2V8:S;VK>24F85");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0215()
  {
    rc_long = (new BigDecimal("-4E+1")).longValue();
    Assert.assertEquals(-40L, rc_long);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0219()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@2MW<A6185N741@YO6;J5<1U0YOV4IUIM;YP=2KPRV9WF@EW2RESJS5X5M07O:>SE<X;O?LHSF2NON@MXPD7D?H5@9CS0SBS>B@P");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0222()
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
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("-4")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("-4")).negate();
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("-4")).divide(new BigDecimal("-4"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0230()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4")).divide(new BigDecimal("32"), 2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0231()
  {
    rc_String = (new BigDecimal("-4")).toString();
    Assert.assertEquals("-4", rc_String);
  }
  public void testItem_0232()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0233()
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
  public void testItem_0234()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("FE86HGX;:EP>G;CI8<4SU69Q8QJ9L47CP?MCHAPK8<C<=2JG@CAYU0W>TGR9A3V?YP<YFP0:D;KWE;Y8T4A9N@B::?2JMPK;9K@9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0235()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("-4"));
    Assert.assertEquals("-256", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("-4")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("-4")).stripTrailingZeros();
    Assert.assertEquals("-4", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_int = (new BigDecimal("-4")).intValueExact();
    Assert.assertEquals(-4, rc_int);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("1024")).plus();
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-4"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\234', '8', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\1', '8', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\234', '8', '8', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF'}, -1, 1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1024")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	  Assert.assertEquals("0E+1", rc_BigDecimal.toString());
    } else {
    	  Assert.assertEquals("0", rc_BigDecimal.toString());
    }
  }
  public void testItem_0254()
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
  public void testItem_0255()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0256()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\234', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JPQO6<9");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0266()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\234', '8', '8', '\uFFFF', '8', '\234', '\1', '\0', '\234', '8', '\1', '8', '8', '\0', '\1', '\1', '8', '\234', '\1', '\1', '\234', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("2E+12"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0272()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PG:8CC8JU=FEAJL8J?QVBR;O:V8N6;3GWY;MW1FXLPHN@E<7BJLD1SCWW1NFA91COPM31AM@;9V0DYXX;IPXCU:59MDW;GJ;39SG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("513RUXLPSF22B<0RQY<JQU::VDR4I>O@32");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0280()
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
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0285()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("4E-324"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\234', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '8', '\1', '8', '\234', '\234', '\1', '\0', '\1', '8', '\1', '\1', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\1', '\0', '\234', '8', '8', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\1', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '\0', '\0', '\0', '8', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF'}, 1, -1);
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
      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0290()
  {
    rc_String = (new BigDecimal("4E-324")).toString();
    Assert.assertEquals("4E-324", rc_String);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_int = (new BigDecimal("4E-324")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0296()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0297()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("1"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).divide(new BigDecimal("4E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("4E-324")).pow(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0307()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0311()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0312()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0314()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0315()
  {
    rc_boolean = (new BigDecimal("-1")).equals("JTH16LYCXSQ4XLP;R82GEDD@SFFR=KL>NCW4M6?>42JI");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0317()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0318()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JF;47<LX59H40:CR=L;0XNL4L=4E3<1TJBN4OYGUK5W9LK251RBBEQAWG>F>WIJ;L8RJN>BV1W;GMD5AQ4YU");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0322()
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
  public void testItem_0323()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0329()
  {
    rc_boolean = (new BigDecimal("1")).equals("W75XR53BESW4");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
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
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\uFFFF', '8', '\234', '8', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '8', '8', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0334()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\234', '\0', '\234', '\1', '\234', '8', '\1', '\1', '8', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0340()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0341()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0342()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0343()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0345()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0346()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0347()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0348()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JKNICQ9MI@OR@HFXAMQGIV:@BE208;K@BD>L>9D<IFYDPGO=Y>M96Q?;;N5MXY2R7YKTF0NJ8R4XBRG05F@7?:=XMHR7H@5:FMH>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0349()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@LKHYAN9G8N>8MJR9X;MCF?IT?BDP0LS?:V1DGY90A:;05SP>:>EE8CP;JE6BVXYV;7VBBX35>H0QT6=X");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0351()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0357()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LIC=332A6024VXPEYXT9ADM;KEJ0R2F@1Y>EONSF1GN897@432TSTU;1U8MU2IA54VT64E1XACCT2W;B3T>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0359()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0362()
//  {
//    boolean caught;
//    rc_short = (new BigDecimal("00.0E+2147483647")).shortValueExact();
//    Assert.assertEquals(0, rc_short);
//  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648, java.math.RoundingMode.UP);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0366()
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
  public void testItem_0367()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
//  public void testItem_0368()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0369()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0370()
  {
    rc_float = (new BigDecimal("00.0E+2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0374()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("1E+308"));
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0375()
  {
    rc_float = (new BigDecimal("0.0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1E+308")).pow(-1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E-308", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1E+308")).movePointRight(1);
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1E+308")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0381()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).plus();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0382()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("1E-308"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0383()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\234', '8', '\1', '\0', '8', '8', '\0', '\0', '\0', '\0', '8', '\0', '\1', '\1', '8', '\1', '\234', '\0', '\0', '\234', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '\0', '\1', '\234', '8', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).pow(1);
    Assert.assertEquals("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '\0', '\234', '8', '\1', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\0', '8', '8', '\234', '\234', '8', '\0', '8', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\0', '\0', '8', '\1', '\0', '8', '\1', '8', '\1', '\0', '\0', '8', '\0', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '8', '\234', '\0', '8', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '8', '\234', '\1', '\234', '\uFFFF', '8', '\234', '\0'}, 0, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("0E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_String = (new BigDecimal("0E-1074")).toEngineeringString();
    Assert.assertEquals("0E-1074", rc_String);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\0', '\234', '8', '\0', '8', '\234', '\1', '\0', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0398()
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
  public void testItem_0399()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divideToIntegralValue(new BigDecimal("0E-1074"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0400()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U:B3?3HXN9?OS@@IVFY75@N6:MOI5=;SW:@::2TU", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0402()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0403()
  {
    rc_BigInteger = (new BigDecimal("1E+2147483647")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\1', '8', '\234', '\0', '8', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '8', '\234', '\234', '\1', '\1', '\0', '\1', '\234', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '\0', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '\1', '\1', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '8', '\234', '8', '8', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '8', '\0'});
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
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
//  public void testItem_0412()
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
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0416()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CSS3PGEN8QPW@W6E2VE<U28L@O8607PEG=YDC265OVUTKQJRXWU62A3KD9R>X");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("8")).scaleByPowerOfTen(1);
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0423()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0424()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0429()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '8', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\234', '\0', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0431()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0432()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigIntegerExact();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_float = (new BigDecimal("8")).floatValue();
    Assert.assertEquals(8.0F, rc_float, 0);
  }
  public void testItem_0440()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("8"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\234'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0443()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("-7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).negate();
    Assert.assertEquals("7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_int = (new BigDecimal("-7.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).precision();
    Assert.assertEquals(1075, rc_int);
  }
  public void testItem_0447()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0450()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L@D@LP7ITVF:WH0Q0K0W@B95JRX0;SAECGF9?QU9?3<HC6U4SB5OJ;1D>7Q9;CKN<T3<V1:1L12X;9?X8B=@K@>;C8BV<>6OMIV=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0460()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate();
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0468()
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
  public void testItem_0469()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_int = (new BigDecimal("-2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-4611686018427387903.5", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9223372036854775807")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("-4611686018427387903.5")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-4611686018427387903.5", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("-4611686018427387903.5")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("-4611686018427387902.5", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775807")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("-9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0485()
  {
    rc_BigInteger = (new BigDecimal("-4611686018427387902.5")).unscaledValue();
    Assert.assertEquals("-46116860184273879025", rc_BigInteger.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).scaleByPowerOfTen(1);
    Assert.assertEquals("-9.223372036854775807E+19", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("0E+1", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("0", rc_BigDecimal.toString());
    }
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LR7F?N:JLN:;QAON;R6NG<63NRB@258QY5>69>7L?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("0E+1", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("0", rc_BigDecimal.toString());
    }
  }
  public void testItem_0500()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0502()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0503()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0506()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9223372036854775807")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0507()
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
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0512()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XR1W92OM:RP;E?MQGXPVSAIPYCIH0N@RE6IDC=2OYK85DPM5RJ13APPF0FMN93ISUBA0<XTHFMW=N@2GT3O7@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0514()
  {
    rc_byte = (new BigDecimal("0E+1")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0518()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("V9BB;R?Y78;=BEO67V8JXKI6N00LW4HY79EU6UWOH2NYA:600<7O72@4>255JDM61T?@J8I;7@DK836<AQJ>RDSX=K6SNQ=X4M4?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0519()
  {
    rc_byte = (new BigDecimal("0E+1")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0E+1"), 1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0524()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0525()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0526()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0527()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0528()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '8', '\234', '\uFFFF', '8', '\1', '\1', '\234', '8', '8', '\1', '\0', '8', '\234', '\234', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\234', '8', '8', '8', '\uFFFF', '\1', '8', '8', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '8', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\1', '\uFFFF', '\0'}, 1, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0535()
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
//  public void testItem_0536()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\234', '8', '\0', '\1', '8', '8', '\0', '8', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '8', '\234', '\0', '\0', '\234', '\uFFFF', '8', '\234', '8', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '8', '8', '8', '\0', '\234', '\1', '\1', '\0', '8', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\234', '\1', '\0', '\234', '\234', '\234', '8', '\1', '\0', '\uFFFF', '8', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0539()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6AG:PC81IOU9BQB43EIOP1F77V7QXXH>KFL@W8VX16I20NED3UEB>5DR0YCAYJ332N=FM0V;MCGTG@N9FV8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0541()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
//  public void testItem_0547()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0549()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0552()
  {
    rc_boolean = (new BigDecimal("-1")).equals("<XWL3DSC=XSVNB98FN8:53<>SWW0K8QF2=?34OK>I2E?PXH<1?1TYYI0PBOAXHMVD8U;U8GFIP2DDU<8OL;X7WU<WYF0CG1O8VHM");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0554()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0558()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0563()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0565()
  {
    rc_boolean = (new BigDecimal("-1")).equals("500PL:7<KINS");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0566()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0567()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigInteger = (new BigDecimal("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).toBigIntegerExact();
    Assert.assertEquals("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigInteger.toString());
  }
  public void testItem_0570()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0571()
  {
    rc_int = (new BigDecimal("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).precision();
    Assert.assertEquals(324, rc_int);
  }
//  public void testItem_0572()
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
//  public void testItem_0573()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("320.0E+2147483647"), 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
//  public void testItem_0575()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0576()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0580()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).setScale(0, java.math.RoundingMode.UP);
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
//  public void testItem_0582()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0583()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0584()
  {
    rc_boolean = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).equals("9DK51LIU65NK=?JCBGUMHY3L7AB7QU=QQOQCVGWWHE7MRP:=US:9IM");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("W?8WOQCS4HAK=A>080TV@SVF@<M2VBTA09;G;WKMJS7HM8YG0MN14M;:T;;=Q9UM4SX8NC0QCU10LF7B63CMDT3T1C13>;3UL=@F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0588()
  {
    rc_int = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\0', '\uFFFF', '\0', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '\1', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\234', '\0', '8', '8', '\234', '\0', '8', '\234', '\uFFFF', '\0', '8', '8', '\1', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '8', '\234'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0590()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0592()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0593()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0594()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0597()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0598()
  {
    rc_boolean = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
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
  public void testItem_0604()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0605()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0607()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0610()
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
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\1', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\234', '8', '\234', '\0', '8', '\234', '\1', '\1', '\1', '8', '8', '\234', '\234', '\0', '8', '\uFFFF', '\1', '\234', '\234', '8', '\1', '8', '\0', '8', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\234', '8', '8', '\0', '8', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\0', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0622()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '8', '8', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '8', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\0', '\234', '8', '\0', '\0', '\234', '8', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\1', '\234', '\0', '8', '\0', '\0', '\234', '\1', '\0', '\0', '\234', '8', '\0', '\0', '\1', '\0', '8', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0625()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0629()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '8', '\1', '8', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\0', '\234', '\0', '\234', '\234', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\234', '8', '\0', '\0', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\1', '8', '8', '\234', '\0', '8', '\234'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0631()
  {
    rc_long = (new BigDecimal("1.0")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\1', '\234', '\1', '\1', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '\1', '\234', '8', '8', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '8'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0635()
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
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0647()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
//  public void testItem_0649()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\0', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\0', '\1', '\1', '\0', '\1', '\234', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\234', '\234', '\1', '\234', '\0', '\1', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\234', '\1', '\234', '8', '\0', '8', '\234', '8', '\0', '\234', '\0', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\234', '\0', '\234', '\0', '\1', '\234', '\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("-30")).add(new BigDecimal("1.0"));
    Assert.assertEquals("-29.0", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_int = (new BigDecimal("3E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-29.0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0656()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).subtract(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    rc_int = (new BigDecimal("3E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0661()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0664()
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
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
//  public void testItem_0667()
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
  public void testItem_0668()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("6AHXYCGNC07>VWEMC=BG>APWR=3G9@9BVHVIXAQKNV66?3G4X4J9V5M<1WU121=<J7R::6Q?Q1XRB>:94O?673Y@85ES3O@=5@<V");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0673()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0674()
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
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\1', '8', '\0', '8', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0682()
  {
    rc_byte = (new BigDecimal("0.0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0683()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-9.223372036854775808E+2147483665", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-9.223372036854775808E+2147483665", rc_BigDecimal.toString());
  }
//  public void testItem_0686()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).subtract(new BigDecimal("-9223372036854775808.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0687()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).remainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0691()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).divide(new BigDecimal("3.2E+2"), 0);
//    Assert.assertEquals("-2.8823037615171175E+2147483663", rc_BigDecimal.toString());
//  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    rc_double = (new BigDecimal("-9223372036854775808.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
//  public void testItem_0694()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("9E-2147483631", rc_BigDecimal.toString());
//  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\0', '8', '\234', '\uFFFF', '8', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '8', '8', '\1', '8', '8', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '8', '\234', '8', '\0', '\1', '\234', '8', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\234', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0698()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).setScale(0, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0700()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-9223372036854775808.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0701()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
//  public void testItem_0702()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9223372036854775807")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E-19")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divideToIntegralValue(new BigDecimal("-9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0711()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0712()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0713()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0714()
  {
    rc_boolean = (new BigDecimal("9223372036854775807")).equals("TCNA4T5B=0IMOB8<OA7=QYC05");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0717()
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
  public void testItem_0718()
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
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0H09ANF@2EBOC>X8TP3MD1WN57<EE6?8YB?A>EC0ISV@?68");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0722()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).min(new BigDecimal("3.2E-2147483646"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0723()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0729()
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
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0732()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("32"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0736()
  {
    rc_float = (new BigDecimal("00.0E+2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0737()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\1', '\0', '\234', '8', '8', '\uFFFF', '\234', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '8', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\1', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8', '8', '\0', '\0', '\0', '\1', '\234', '8', '\1', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\1', '\234'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0739()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3E-2147483646")).divideAndRemainder(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0740()
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
  public void testItem_0741()
  {
    rc_byte = (new BigDecimal("0E-2147483646")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I2MF8=YMUO:7IKQBJ4>H=B49?M0E2P;M80S;H7=K;XE2S?8<AF@R3MQ<6BIFJ8A5NLJH2J6V3T29@7::5X4EGXHMJ68=TG81OTN;", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(1);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0751()
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
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, 1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("1E-19")).divide(new BigDecimal("1E-19"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0758()
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
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_int = (new BigDecimal("9223372036854775807")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0761()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775839", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0XF@EMM9E4Q5EF", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("9223372036854775807.0"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).plus();
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9223372036854775807.0"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0770()
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
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0779()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0791()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0795()
  {
    rc_boolean = (new BigDecimal("0")).equals("J3=VLGWCN?;>QYM?O@<V6EVOS54E2C;9=DV00SED?N;3AF244G6V05J=0FX4U9D<EHJEY<WEEE0GJ1;T51BSV3P@4>NU0D8PM?BA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0796()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0797()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0799()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '8', '\uFFFF', '\234', '8', '\1', '\234', '8', '\234', '8', '\uFFFF', '8', '\1', '\234', '\234', '8', '8', '8', '\234', '\0', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0806()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0807()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0815()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0819()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0821()
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
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0824()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).pow(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0831()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("KW;8E>35W>JKW1BWM95DDJ?5>QL?JH9WMLI?26RY3U1N5?M;5E287H5853KE>UR5?T51FE:QG7TEYRS>XO>HBNOJF<S7;O@<9YWB");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0834()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0837()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0838()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0839()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
//  public void testItem_0840()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0841()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0842()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0843()
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
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0852()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0856()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0857()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0858()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0859()
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
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("J?262GQEL;MN4XOFKFG821N3@01OC2OB=JSG64BQ=Y7X<SRT?G9CGSHSLD@I?196VQ7@55AG<WWMT6=EGJBQWI46G0XQ4PAW=RNI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0865()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("99H3<WP;EP4", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(-1);
    Assert.assertEquals("-922337203685477580.8", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_int = (new BigDecimal("-922337203685477580.8")).intValue();
    Assert.assertEquals(858993460, rc_int);
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9.223372036854775808E+19", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0872()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9.223372036854775808E+19")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0873()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9.223372036854775808E+19")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0874()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0875()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-9.223372036854775808E+19"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-9.223372036854775808E+19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+20", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-922337203685477580.8"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\234', '8', '8', '8', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\0', '8', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\0', '8', '\0', '\1', '\1', '8', '8', '\1', '\1', '8', '8', '\1', '\0', '\234', '\1', '\0', '\0', '\234', '8', '\1', '\234', '\0', '\1', '8', '\1', '\0', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\234'}, -2147483648, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
//  public void testItem_0885()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '8', '\234', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\234', '8'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_String = (new BigDecimal("9E+18")).toString();
    Assert.assertEquals("9E+18", rc_String);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("9E+18", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
    }
  }
  public void testItem_0889()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_float = (new BigDecimal("9E+18")).floatValue();
    Assert.assertEquals(9.0000002023581286E18F, rc_float, 0);
  }
  public void testItem_0892()
  {
    rc_int = (new BigDecimal("9000000000000000000")).intValue();
    Assert.assertEquals(-494665728, rc_int);
  }
  public void testItem_0893()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000")).toBigInteger();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
//  public void testItem_0894()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("9E+37"), 0, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("-3.2E-2147483646")).compareTo(new BigDecimal("9E+18"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0896()
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
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '8', '\1', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).multiply(new BigDecimal("9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483627", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-3E-2147483627")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0900()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).remainder(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).stripTrailingZeros();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483627")).remainder(new BigDecimal("9000000000000000000"));
    Assert.assertEquals("-3E-2147483627", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9E+37")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0908()
  {
    rc_int = (new BigDecimal("9000000000000000000")).compareTo(new BigDecimal("9000000000000000000"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0909()
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
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("9000000000000000000"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000")).unscaledValue();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("9.000000000000000000000000000000000000E+37", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0919()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9000000000000000000")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0920()
  {
    rc_long = (new BigDecimal("0E-1074")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).negate();
    Assert.assertEquals("-9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("9.000000000000000000000000000000000000E+37"));
  }
  public void testItem_0923()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).remainder(new BigDecimal("9.000000000000000000000000000000000000E+37"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("51AM8:H?R8PQN>5C?7F7OU>SSBGHL2:>14P7CATEX=2SP==2KAU?1BYREWRYFABJ20>29B32YCPWYII5S=5V3MTO2@S;BASQOQ>U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0927()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).multiply(new BigDecimal("9000000000000000000"));
    Assert.assertEquals("81000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '\1', '8', '8', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\uFFFF'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0930()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\234', '8', '\1', '8', '\234', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '8', '8', '\uFFFF', '8', '8', '\1', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '8', '\uFFFF', '8', '\0', '\0', '8', '\1', '\234', '8', '\1', '8', '8', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\uFFFF', '8', '\234', '8', '\0', '\234', '8', '\uFFFF', '\234', '\1', '8', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\0'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 1, 0);
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784.0", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784.0")).multiply(new BigDecimal("0E-1074"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("0E-1074"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\234', '8', '\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0939()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784.0")).divide(new BigDecimal("0E-1074"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775807"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\234', '8', '\234', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\234', '\0', '\1', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).abs();
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0948()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784.0"));
    Assert.assertEquals("-202402253307310438583181860487346492522132918059785320286333832182433740650518543734699603672898363905628445097438640370930855223003329242545686510476555741453970720739049375314556331190811140095749677289143800992693499028290750394034866452426211390532250724389010494754507210470507333794009146589346125012903681556968636416.0", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\234', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-202402253307310438583181860487346492522132918059785320286333832182433740650518543734699603672898363905628445097438640370930855223003329242545686510476555741453970720739049375314556331190811140095749677289143800992693499028290750394034866452426211390532250724389010494754507210470507333794009146589346125012903681556968636416.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+308", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-202402253307310438583181860487346492522132918059785320286333832182433740650518543734699603672898363905628445097438640370930855223003329242545686510476555741453970720739049375314556331190811140095749677289143800992693499028290750394034866452426211390532250724389010494754507210470507333794009146589346125012903681556968636416.0")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0958()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0959()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("4E+308")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("-202402253307310438583181860487346492522132918059785320286333832182433740650518543734699603672898363905628445097438640370930855223003329242545686510476555741453970720739049375314556331190811140095749677289143800992693499028290750394034866452426211390532250724389010494754507210470507333794009146589346125012903681556968636416.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).compareTo(new BigDecimal("4E+308"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toEngineeringString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("4E+308")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+308", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E+308")).divide(new BigDecimal("0E+1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("-4E+308")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-309", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("4E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+317", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("9E+317")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-9E+317", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("9E+317"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\0', '8', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\0', '\0', '\0', '\0', '\1', '\0', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\234', '\0', '8', '\234', '8', '8', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\234', '8', '\0', '\234', '8', '\234', '8', '\234', '8', '8', '8', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4E+308")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("9E+317")).movePointLeft(2147483647);
    Assert.assertEquals("9E-2147483330", rc_BigDecimal.toString());
  }
//  public void testItem_0986()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).add(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-147483647", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\0', '\234', '\1', '\234', '\0', '8', '8', '\234', '\0', '\234', '\1', '8', '\234', '\234', '\uFFFF', '8', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\0', '8', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0993()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("UUHCU7FO?6S467IBD0S3R=6R:PD7JO;HLPSWWMX?4KB6P2@@T=TS0:?VFHB;:SQAV6U0:WHWNQS47OJ6?K7>?J4X150Y6C5GVWXW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("15FVE9IKYW959YM:KAY?7QYI0PX6<H;6OTOJN<ABWIESCK>:A9YMXXJV93N1?Q7CMPA70E;IMWKSOY4RWJQQNH4M9B>:XK0=Q3F>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
}
