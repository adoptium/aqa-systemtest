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
public class TestSuite036 extends TestCase
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
  public void testItem_0000()
  {
    rc_float = (new BigDecimal("-3.2")).floatValue();
    Assert.assertEquals(-3.200000047683716F, rc_float, 0);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483339")).abs();
    Assert.assertEquals("6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483339")).remainder(new BigDecimal("1"));
    Assert.assertEquals("6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("FW>O>RTIBDRSM8LW4EB2FXBMBM0LA5N3F<R>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0005()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E-2147483339")).divide(new BigDecimal("-6E-2147483339"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_int = (new BigDecimal("6E-2147483339")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483339")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483339")).remainder(new BigDecimal("6E-2147483339"));
    Assert.assertEquals("0E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E-2147483339")).divideToIntegralValue(new BigDecimal("0E-2147483339"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("6E-2147483339")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483339")).abs();
    Assert.assertEquals("6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483339")).min(new BigDecimal("6E-2147483339"));
    Assert.assertEquals("6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483339")).setScale(0, 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-6E-2147483339"));
    Assert.assertEquals("-6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0024()
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
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483339")).add(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-6E-2147483339")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0027()
  {
    rc_long = (new BigDecimal("2E+9")).longValueExact();
    Assert.assertEquals(2000000000L, rc_long);
  }
  public void testItem_0028()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483339")).setScale(-2147483648, -2147483648);
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
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0030()
  {
    rc_String = (new BigDecimal("2E+9")).toString();
    Assert.assertEquals("2E+9", rc_String);
  }
  public void testItem_0031()
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
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483339")).movePointLeft(0);
    Assert.assertEquals("-6E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-6E-2147483339")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-6E-2147483339"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0035()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("0E-2147483339"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0036()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483339")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).stripTrailingZeros();
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0040()
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
//  public void testItem_0041()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0042()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0043()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("2E+9"));
  }
  public void testItem_0044()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483339")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigInteger = (new BigDecimal("3E-2147483647")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointLeft(-2147483648);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("30"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("7E+7", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_int = (new BigDecimal("30")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0052()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483339")).add(new BigDecimal("7E+7"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0053()
  {
    rc_String = (new BigDecimal("3E-2147483647")).toString();
    Assert.assertEquals("3E-2147483647", rc_String);
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).abs();
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("30")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483339")).multiply(new BigDecimal("7E+7"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483332", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("7E+7"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("7E+7"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2.1E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("7E+7")).multiply(new BigDecimal("0E-2147483332"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483325", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("7E+7")).divideToIntegralValue(new BigDecimal("0E-2147483332"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483325")).movePointRight(0);
    Assert.assertEquals("0E-2147483325", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483325")).divide(new BigDecimal("0E-2147483325"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483325")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483332")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483332")).abs();
    Assert.assertEquals("0E-2147483332", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483325")).plus();
    Assert.assertEquals("0E-2147483325", rc_BigDecimal.toString());
  }
  public void testItem_0069()
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
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483332")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483332", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_double = (new BigDecimal("0E-2147483332")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0072()
  {
    rc_BigDecimal_array = (new BigDecimal("7E+7")).divideAndRemainder(new BigDecimal("30"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2.1E-2147483639")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("2.1E-2147483639")).max(new BigDecimal("7E+7"));
    Assert.assertEquals("7E+7", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("2.1E-2147483639")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("30")).multiply(new BigDecimal("2.1E-2147483639"));
    Assert.assertEquals("6.30E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("30")).min(new BigDecimal("7E+7"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_int = (new BigDecimal("30")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
//  public void testItem_0083()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0084()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-2E-2147483639")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0087()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
  public void testItem_0088()
  {
    rc_BigInteger = (new BigDecimal("6.30E-2147483638")).unscaledValue();
    Assert.assertEquals("630", rc_BigInteger.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("6.30E-2147483638")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0090()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0091()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0093()
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
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("30")).negate();
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("-30")).movePointLeft(2147483647);
    Assert.assertEquals("-3.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q?U7KTJSFA3FTRBAJ73T:H?4CYBKD?Y6H5<>LR=@1OT3XM4>OKQW?XWUS7HAV6BQHA:@5J8DVY:6@J>K:CJF5HMI<1BGV<<S6R5H", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_int = (new BigDecimal("-30")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_int = (new BigDecimal("6.30E-2147483638")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1024"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0105()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1024")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("-30")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0107()
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
  public void testItem_0108()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("1024")).pow(1);
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0112()
  {
    rc_long = (new BigDecimal("1024")).longValue();
    Assert.assertEquals(1024L, rc_long);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DQMSTJ1NUMC:JDKKUO4", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("-30")).setScale(-1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0117()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0118()
  {
    rc_double = (new BigDecimal("-30")).doubleValue();
    Assert.assertEquals(-30.0, rc_double, 0);
  }
  public void testItem_0119()
  {
    rc_int = (new BigDecimal("1024")).intValue();
    Assert.assertEquals(1024, rc_int);
  }
  public void testItem_0120()
  {
    rc_String = (new BigDecimal("-3E+1")).toString();
    Assert.assertEquals("-3E+1", rc_String);
  }
  public void testItem_0121()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("-30")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_short = (new BigDecimal("-3E+1")).shortValueExact();
    Assert.assertEquals(-30, rc_short);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7;8O8:T=N2J5>N1C?TV>:HU8O3<YU:V?K:H@M0<I5WWIDGE=9YVWNM>O>2Y");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0130()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-30")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0131()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0134()
  {
    rc_boolean = (new BigDecimal("8")).equals("GWQ2JKY8T=ETVH8NXA01=V;AQACR;LGV5A3KJWEXRA>4YB6X37JWHBV3N>UL?5LP09A6LNDUED31:K8K<;V7JD;N@;OGMYX>XB1X");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-30"), new MathContext("precision=0 roundingMode=DOWN"));
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
      rc_MathContext = new MathContext("AG3HWKQWF@>AV@H6T:LOP@S0?6<=8E3OQ?>@CR781H847SAIRVQ02RELCH?:P;8L2N3BWMKHCNKAB6HWJKQAYEILQG>@O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
//  public void testItem_0141()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0142()
  {
    rc_BigInteger = (new BigDecimal("-30")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0144()
  {
    rc_boolean = (new BigDecimal("1")).equals("1P6Q;BR<:=G186K@JA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("-30")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0147()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0148()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-30"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-30"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("31")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("-30")).multiply(new BigDecimal("-9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30")).divide(new BigDecimal("-9E+18"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0156()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).toBigInteger();
    Assert.assertEquals("-9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0157()
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
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\uFFFF', '\0', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '8', '\1', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\1', '\0', '\234', '\0', '\0', '\0', '8', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\0', '\1', '\uFFFF', '8', '8', '\0', '8', '\1', '\0', '\0', '8', '8', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '\234', '\1', '8', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\1'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0162()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).unscaledValue();
    Assert.assertEquals("-9", rc_BigInteger.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+20")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0165()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+20")).hashCode();
//    Assert.assertEquals(73, rc_int);
//  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).plus();
    Assert.assertEquals("3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30")).divide(new BigDecimal("3E+20"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigInteger = (new BigDecimal("-30")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigInteger = (new BigDecimal("-30")).unscaledValue();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-9E+18"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("3E+20")).movePointRight(1);
    Assert.assertEquals("3000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0183()
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
  public void testItem_0184()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0192()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MT;1205TETE6@8?:2:A;GQWJI93;7GOJ;28B9HE6U3FND1BN5W>QTKHO<749S5A4GM2ULF223?6DW9A4RXW8N@HK6EY=6576V6FR");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1.00000", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0206()
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
  public void testItem_0207()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
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
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0212()
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
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0214()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0215()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0216()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0220()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MK2OD0>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0226()
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
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("3.2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0234()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0235()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0236()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0243()
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
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0246()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\1', '8', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\0', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0251()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("3.2")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0253()
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
  public void testItem_0254()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0257()
  {
    rc_int = (new BigDecimal("3.2")).scale();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0258()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0259()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0261()
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
//  public void testItem_0262()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("-320.0E+2147483647"), java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("10")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0264()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0265()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).divideToIntegralValue(new BigDecimal("3.2"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0267()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("1"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).movePointRight(-1);
    Assert.assertEquals("-200000000", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_long = (new BigDecimal("-200000000")).longValue();
    Assert.assertEquals(-200000000L, rc_long);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0273()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\234', '8', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\234', '8', '8', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2E+9"), 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0282()
//  {
//    boolean caught;
//    rc_byte = (new BigDecimal("00.0E+2147483647")).byteValueExact();
//    Assert.assertEquals(0, rc_byte);
//  }
  public void testItem_0283()
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
  public void testItem_0284()
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
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<J@OGFTQS?>:XYUQC62:T;L6OIY>1XQD0ST9CQ0QW:AUS>I", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0291()
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
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
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
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0296()
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
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("GU9>:");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0301()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
//  public void testItem_0305()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3E+2"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).subtract(new BigDecimal("1"));
    Assert.assertEquals("299", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0314()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigInteger = (new BigDecimal("-3E+2")).toBigInteger();
    Assert.assertEquals("-300", rc_BigInteger.toString());
  }
//  public void testItem_0317()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+2")).hashCode();
//    Assert.assertEquals(91, rc_int);
//  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0319()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0327()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).subtract(new BigDecimal("-1"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_long = (new BigDecimal("3E+2")).longValueExact();
    Assert.assertEquals(300L, rc_long);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0331()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.0")).hashCode();
//    Assert.assertEquals(311, rc_int);
//  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).remainder(new BigDecimal("3E+2"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0333()
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
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<L9JX75KXGB6<1D34O=D>9RRAFCS<=A9", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).movePointLeft(-1);
    Assert.assertEquals("-3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_String = (new BigDecimal("1.0")).toPlainString();
    Assert.assertEquals("1.0", rc_String);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("-3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).abs();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483645")).stripTrailingZeros();
    Assert.assertEquals("-3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483645")).pow(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0347()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S7=W9@PLMDD1O99MA9TJNRI@;;QHY58XFC9:DFB9;D4;UT8G07@JA95YJX?Q37=NI3;WH;=H=N<3YHCXLJFQ32=XS78EDVGAVSMN");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0348()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0350()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).setScale(1, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0351()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("3E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0353()
  {
    rc_double = (new BigDecimal("3E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0354()
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
  public void testItem_0355()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).negate();
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("85070591730234615865843651857942052864", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
//  public void testItem_0367()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483646"), -1, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\1', '\234', '\0', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0369()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0370()
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
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1ETSFOB;>Y=6IMTXGGPT>GR12OI0X>CQ4ANIYH0MR5PPX1=RVHL15D:AENDSD:I<A5Q<3;?:?UFCM9R:4:?IFNTB2UV1S;RYR@XR", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0372()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\234', '\234', '8', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\1', '8', '8', '\234', '\234', '\0', '\234', '\0', '8', '\234', '\234', '\uFFFF', '8', '\1', '8', '\1', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\234', '8', '\0', '\0', '\0', '\234', '8', '\1', '\1', '\1', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '\0', '\1', '\0', '\uFFFF', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\1', '\234', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '8', '8', '\0', '8', '\0', '8', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\1', '8', '\234', '8', '8', '\uFFFF', '\234', '8', '\0', '8', '8', '\0', '\234', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\uFFFF'}, 0, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-2"), 0, 1);
    Assert.assertEquals("4611686018427387904", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387904")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-4611686018427387904", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_int = (new BigDecimal("4611686018427387904")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0389()
  {
    rc_long = (new BigDecimal("-2")).longValueExact();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("-2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divideToIntegralValue(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_String = (new BigDecimal("3")).toEngineeringString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("-2")).pow(1);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0399()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4611686018427387904")).divideToIntegralValue(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0400()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0401()
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
  public void testItem_0402()
  {
    rc_long = (new BigDecimal("4611686018427387904")).longValue();
    Assert.assertEquals(4611686018427387904L, rc_long);
  }
  public void testItem_0403()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0406()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0407()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0408()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0409()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0410()
  {
    rc_BigInteger = (new BigDecimal("-2")).toBigInteger();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0411()
  {
    rc_String = (new BigDecimal("4611686018427387904")).toPlainString();
    Assert.assertEquals("4611686018427387904", rc_String);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("3")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("3")).movePointLeft(-1);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointLeft(2147483647);
    Assert.assertEquals("-2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).pow(-1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0416()
  {
    rc_String = (new BigDecimal("30")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0417()
  {
    rc_boolean = (new BigDecimal("4611686018427387904")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0419()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0420()
  {
    rc_int = (new BigDecimal("4611686018427387904")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0422()
  {
    rc_String = (new BigDecimal("-2E-2147483647")).toEngineeringString();
    Assert.assertEquals("-200E-2147483649", rc_String);
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-2E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).negate();
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal_array = (new BigDecimal("-2E-2147483647")).divideAndRemainder(new BigDecimal("4611686018427387904"));
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).add(new BigDecimal("-2E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("30")).movePointLeft(0);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_double = (new BigDecimal("3")).doubleValue();
    Assert.assertEquals(3.0, rc_double, 0);
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("3")).add(new BigDecimal("4611686018427387904"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E+18", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_int = (new BigDecimal("-2E-2147483647")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0431()
  {
    rc_long = (new BigDecimal("4611686018427387904")).longValueExact();
    Assert.assertEquals(4611686018427387904L, rc_long);
  }
  public void testItem_0432()
  {
    rc_BigInteger = (new BigDecimal("30")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal_array = (new BigDecimal("3")).divideAndRemainder(new BigDecimal("30"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387904")).add(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("4611686018427387934", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_int = (new BigDecimal("4611686018427387934")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0437()
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
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387934")).subtract(new BigDecimal("4611686018427387904"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("30")).divideToIntegralValue(new BigDecimal("3"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '\234', '\0', '8', '8', '\234', '\234', '8', '\1', '\uFFFF', '\0', '8', '\1', '\234', '8', '\234', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '8', '\234', '\234', '8', '8', '\234', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '8', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '8', '\234', '\234', '\0', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("4611686018427387904"));
    Assert.assertEquals("6.5052130349130266040447168052196502685546875E-18", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0442()
  {
    rc_boolean = (new BigDecimal("6.5052130349130266040447168052196502685546875E-18")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0443()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E-2147483647")).hashCode();
//    Assert.assertEquals(2147483585, rc_int);
//  }
  public void testItem_0444()
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
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VJMH@GYY6X@S63<CQ3V8GWQP:9IF?F2<5PF>3:EBYJR5I<62CG>OO>U@X=YQTX56?G?5E4PIU;G=1>P>4@=HC0UHBW:>QXF2RP;W", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("6.5052130349130266040447168052196502685546875E-18")).abs();
    Assert.assertEquals("6.5052130349130266040447168052196502685546875E-18", rc_BigDecimal.toString());
  }
//  public void testItem_0447()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2E-2147483647")).divideAndRemainder(new BigDecimal("-2E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("-2E-2147483647"), 2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("30")).min(new BigDecimal("-2E-2147483647"));
    Assert.assertEquals("-2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("30")).multiply(new BigDecimal("30"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_double = (new BigDecimal("30")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
  public void testItem_0452()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6.5052130349130266040447168052196502685546875E-18")).setScale(1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0453()
  {
    rc_BigInteger = (new BigDecimal("9E+2")).toBigInteger();
    Assert.assertEquals("900", rc_BigInteger.toString());
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WTH<2BW3>J38HAY8XR;93S=?O<NR41Q2NG5L2GOYKTYL<AKSDJYUFM@8SPBI4J:G6CKW3T0NGASN?=GQ9GWLYAMSCK;YF3<CPH4D");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("9E+2")).subtract(new BigDecimal("30"));
    Assert.assertEquals("870", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigInteger = (new BigDecimal("30")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("30"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("30")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("3")).negate();
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("FRN54655KT4LX4=6C87GN??N3QTC:4CX?=<80J9P0PV>ED6?V5N<GXKDH0P?XTU;;KF4REH>YYUI3GLQK?M78X<F2RR9D3E<>:SY");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("-3")).movePointLeft(0);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
//  public void testItem_0464()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("-2E-2147483647"), java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0465()
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
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0467()
  {
    rc_int = (new BigDecimal("9E+2")).intValueExact();
    Assert.assertEquals(900, rc_int);
  }
  public void testItem_0468()
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
  public void testItem_0469()
  {
    rc_double = (new BigDecimal("-3")).doubleValue();
    Assert.assertEquals(-3.0, rc_double, 0);
  }
  public void testItem_0470()
  {
    rc_int = (new BigDecimal("9E+2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0471()
  {
    rc_int = (new BigDecimal("9E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0472()
  {
    rc_boolean = (new BigDecimal("-2E-2147483647")).equals(">>SN>=N265HEWXN><Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("2E-2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("9E+2")).multiply(new BigDecimal("2E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("2E-2147483647")).divideToIntegralValue(new BigDecimal("2E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0478()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-2E-2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0479()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0481()
  {
    rc_int = (new BigDecimal("2E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("-3")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0485()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
//  public void testItem_0486()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E-2147483646")).setScale(1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0487()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E-2147483647")).hashCode();
//    Assert.assertEquals(2147483585, rc_int);
//  }
  public void testItem_0488()
  {
    rc_int = (new BigDecimal("-3")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2E-2147483646"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0493()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-3")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0494()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0495()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-3"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
//    Assert.assertEquals("2", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0496()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0497()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_int = (new BigDecimal("-2E-2147483647")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).abs();
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '8', '\0', '\1', '\1', '\1', '\0', '\1', '\0', '\0', '\1', '\0', '8', '8', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\1', '\234', '8', '\0', '\1', '\0', '\1', '8', '\0', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\0', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '\234', '\1', '\234', '8', '\234', '\1', '8', '\0', '\234', '\0', '\0', '8', '\0', '8', '\0', '\0', '\0', '\1'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0501()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).multiply(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("-6.4E+2", rc_BigDecimal.toString());
//  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("-6.4E+2")).movePointRight(-2147483648);
    Assert.assertEquals("-6.4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0506()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-6.4E-2147483646")).divide(new BigDecimal("1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0507()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).divide(new BigDecimal("1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0508()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0509()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0510()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0511()
  {
    rc_BigInteger = (new BigDecimal("-2E-2147483647")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
//  public void testItem_0512()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-2E-2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).divide(new BigDecimal("-2E-2147483647"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0514()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CETU477@IQVYPT09LX<YI26V9F;Q1?0L6MC;F7B00OGL5<NB7OG>H>IIGNVVG1Y7<L8?QM6>PUHMMF18A<30NGGJOW<RIDLU1D66");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0515()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-6.4E-2147483646")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0517()
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
  public void testItem_0518()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0519()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-6.4E-2147483646")).divide(new BigDecimal("1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0520()
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
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0522()
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
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).negate();
    Assert.assertEquals("2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0526()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0527()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-6.4E-2147483646")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0528()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E-2147483647")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0529()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E-2147483647")).hashCode();
//    Assert.assertEquals(2147483585, rc_int);
//  }
  public void testItem_0530()
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
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483647")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-2E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_float = (new BigDecimal("-6.4E-2147483646")).floatValue();
    Assert.assertEquals(-0.0F, rc_float, 0);
  }
  public void testItem_0533()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-6.4E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).stripTrailingZeros();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0540()
  {
    rc_String = (new BigDecimal("1135879015891")).toString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0541()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\0', '8', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\1', '8', '8', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\0', '\234', '\1', '8', '\1', '\234', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '\234', '8'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0549()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("1"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1E+12")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0556()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("892K;1W>855F0UPJGEAE:@JILN?YL73G73?LI8FX5?J53VQ<@X=J3HQL@YS1C?>B<95<0<HYWY43A?4S::IIF?0KWPF8PEQ3=BWE");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0559()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '\0', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '8', '\234', '\1', '\1', '\0', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0560()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\uFFFF', '\234', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '8', '\0', '\0', '\0', '\1', '\0', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0562()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+12")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0572()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1E+2147483647"), 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0573()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0574()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '8', '\1', '\234', '\uFFFF', '8', '\0', '\234', '\1', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\234', '8', '\0', '8', '\234', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("1E+2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0576()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0577()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("1E+2147483647")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0579()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0580()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("32"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_int = (new BigDecimal("1.0")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0586()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\234'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0594()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5=YQLBRQ?UP=5TWX26XHNPIY4A4?XRP?YK;=LO8GI>HXY5AUH;UAH144K1BU161AS8:EOOTJYO4W0@2@HP6590K3SEY2>5I?0S14", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AO:AA487KTC;2CEL2VW06H;LGUNHT8=3DLUP");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0600()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0601()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_String = (new BigDecimal("1E+2147483647")).toEngineeringString();
    Assert.assertEquals("10E+2147483646", rc_String);
  }
  public void testItem_0604()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0605()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '\1', '8', '8', '\0', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\uFFFF', '8', '\0', '8', '\234', '\234', '\uFFFF', '8', '\234', '8'}, -1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("99<?4;2BIJEDP@UKVYNU5?PKPQ62B;=;T=NTYL4RDBRJDL5G3U18>KECXPBV:TBGRTQENWU1;K757K>:W=H8SATN:2S2E;;CC1>4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0608()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0614()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0619()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), 0, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0632()
  {
    rc_String = (new BigDecimal("1.0")).toString();
    Assert.assertEquals("1.0", rc_String);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).plus();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0637()
  {
    rc_boolean = (new BigDecimal("1")).equals("Q?6I2=A2J6T0W9Q42@1TT8S52UE>32I<;2SB28Y@UWA;9CF<XIEBTBC3PAHDWQKA;BSG2DO6?7X3B3EA>R?;S>63CA3039:;>KQA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0638()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0639()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0643()
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
  public void testItem_0644()
  {
    rc_byte = (new BigDecimal("30.0")).byteValueExact();
    Assert.assertEquals(30, rc_byte);
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("G:E;XPT:7C19::@S79GF=7K:S;GL@K7LFI>X73O9<H09DFCATQHUA2GX@TRMETADI0S;TU32FF2D>@;XPGK8DFK>E?N<76Y");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("3E+1"), 0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0651()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_int = (new BigDecimal("0.1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0655()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0656()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0657()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("GCL>5>1XNNQINVJ2G>8M3WC8>?YW7QD43WV34JS;8SW5I9HJ27C1Q5D?G=94N:EVHW=>63OQ;6T6FD@UAT>?>0EB1?>5=");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0658()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0659()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0660()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("3.2"), 0);
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0664()
  {
    rc_int = (new BigDecimal("1E+308")).scale();
    Assert.assertEquals(-308, rc_int);
  }
  public void testItem_0665()
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
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0669()
  {
    rc_boolean = (new BigDecimal("1E+308")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0670()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '8', '\0', '\1', '\1', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '8', '\234', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '\234', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\1', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '8', '\234', '8', '\234', '\1', '\0', '\0', '\234', '\234', '8', '\1', '\234', '\0', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\234', '8', '\1', '\234', '\1', '\0', '\0', '\1', '8', '8', '\234', '\0'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+308"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0E-308", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-308")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("2")).movePointRight(1);
    Assert.assertEquals("20", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("2")).min(new BigDecimal("20"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0682()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("0E-308")).abs();
    Assert.assertEquals("0E-308", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0685()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("2")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("20"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("0E-308")).add(new BigDecimal("20"));
    Assert.assertEquals("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\0', '\1', '8', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\234', '\0', '\234', '\1', '8', '\234', '\234', '\234', '\0', '\0', '\234', '\1', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '\1', '\234', '\0', '\1', '\234', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '8', '\uFFFF', '8', '\234', '8', '8', '\0', '\1', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '\0', '\234', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\1', '8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0692()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("20")).abs();
    Assert.assertEquals("20", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).multiply(new BigDecimal("2"));
    Assert.assertEquals("40.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0695()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("20")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).subtract(new BigDecimal("3E+2"));
    Assert.assertEquals("-280.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).add(new BigDecimal("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0700()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    rc_String = (new BigDecimal("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toPlainString();
    Assert.assertEquals("20.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0704()
  {
    rc_short = (new BigDecimal("3E+2")).shortValueExact();
    Assert.assertEquals(300, rc_short);
  }
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).movePointLeft(2147483647);
    Assert.assertEquals("3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("40.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_int = (new BigDecimal("3E+2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0710()
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
  public void testItem_0711()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\1', '\uFFFF', '8', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\1', '8', '8', '8', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\0', '8', '\1', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0717()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CDIPQ:TFL74AS8WK:S0CKDEE09N22E;2YSUMDGGIWI=M9OI4JXKLYQK9?>G<=3T@9D@DYEOJ7V9PSE7GF3<DW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    rc_String = (new BigDecimal("3E-2147483645")).toEngineeringString();
    Assert.assertEquals("30E-2147483646", rc_String);
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("K6G852;T2<:Y<H0@16S6X3CCJHI947?3:J3?E4QC8?0U87SST5G826VWFS@M;ATF<4CFP:A593IC>L3@AW8>2J8B36I<12WJYO>H");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0723()
  {
    rc_boolean = (new BigDecimal("3E+2")).equals("@J<?5MJT?OP;>P@V35I9CO575>NKJREMWQPXA=>CID>U4>RB;YH7J<B:8KXKMQ7<E=NW4E0MNR>O>UEQQ157FBHYSJO00:>S?KLI");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\1', '\1', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '\234', '\1', '8', '8', '8', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\0', '\0'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-32")).max(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_double = (new BigDecimal("-3E-2147483626")).doubleValue();
    Assert.assertEquals(-0.0, rc_double, 0);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_int = (new BigDecimal("-32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483626")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0742()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-3E-2147483626"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("1"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-3E-2147483626"));
    Assert.assertEquals("0E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_String = (new BigDecimal("-3E-2147483626")).toEngineeringString();
    Assert.assertEquals("-300E-2147483628", rc_String);
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483626")).multiply(new BigDecimal("-3E-2147483626"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0749()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0750()
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
  public void testItem_0751()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3M>?V9GX9KCF7<:W", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0752()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483626")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0753()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0754()
  {
    rc_String = (new BigDecimal("-3E-2147483626")).toString();
    Assert.assertEquals("-3E-2147483626", rc_String);
  }
  public void testItem_0755()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E-2147483626")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '\0', '\1', '8', '\234', '\1', '\1', '8', '\234', '\234', '8', '8', '\1', '8', '\1', '\234', '\234', '8', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0758()
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
  public void testItem_0759()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483626")).divideToIntegralValue(new BigDecimal("0E-2147483626"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_int = (new BigDecimal("0E-2147483626")).compareTo(new BigDecimal("-2E+9"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483626")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483626")).ulp();
    Assert.assertEquals("1E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0766()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E-2147483626")).divideAndRemainder(new BigDecimal("1E-2147483626"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483626")).abs();
    Assert.assertEquals("3E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0770()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("3E-2147483626")).toPlainString();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483626")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483626")).negate();
    Assert.assertEquals("3E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0774()
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
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0776()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("3E-2147483626"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483626")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-2147483626"));
    Assert.assertEquals("0E-2147483626", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("K;;=LUT5Y<A:>:3057>JGVBISK;Q5J");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\1', '\234', '8', '8', '8', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '\0', '\0', '\234', '8', '\234', '\1', '\1', '8', '\1', '8', '\234', '\0', '\234', '\1', '\0', '\234', '\1', '\0', '\234', '8', '8', '\234', '\0', '\uFFFF', '8', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0787()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\uFFFF', '8', '8', '\0', '8', '\0', '\0', '\1', '8', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\1', '8', '\234', '\234', '\0', '8', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '8', '\0', '\234', '8', '\234', '\234', '\1', '8', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\0', '8', '8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0788()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0789()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0791()
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
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("6E+1"));
    Assert.assertEquals("60", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C7@H1G6Q8;UYAN71;>>7R3EXG>Y@H4XG9WP204SHAB>R4QHK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":7IRH0L;Y6LG25EXBLH6NELTS8X9W4A=BE>:CABDG:E17APBT2G74DHE0EC<3BM79>?94F289856PB>2YY@YWDT1L7K:7M009?M1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).subtract(new BigDecimal("6E+1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0799()
  {
    rc_double = (new BigDecimal("6E+1")).doubleValue();
    Assert.assertEquals(60.0, rc_double, 0);
  }
  public void testItem_0800()
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
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("60")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).add(new BigDecimal("60"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_String = (new BigDecimal("60")).toEngineeringString();
    Assert.assertEquals("60", rc_String);
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("60")).divide(new BigDecimal("32"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("60")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_int = (new BigDecimal("1E+2")).intValueExact();
    Assert.assertEquals(100, rc_int);
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0810()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '8', '8', '8', '\1', '\1', '\0', '\0', '8', '8', '\0', '\0', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '8', '\234', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '8', '\1', '8', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\1', '8', '\1', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\0', '8', '8', '\1', '\1', '8', '\1', '\0', '\234', '\1', '\1'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">22@S8K7NHUK=PJY5=CVP=QDXK143U5VA<?DG:IDFV<0YR?N5QX");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_short = (new BigDecimal("1E+2")).shortValueExact();
    Assert.assertEquals(100, rc_short);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).pow(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).stripTrailingZeros();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0821()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0822()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3.2E+2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775808")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).toBigInteger();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("2")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0836()
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
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1E+12"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).subtract(new BigDecimal("1E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0844()
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
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0847()
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
  public void testItem_0848()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0849()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_float = (new BigDecimal("3.2E+2")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0852()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0853()
  {
    rc_short = (new BigDecimal("0E+12")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0854()
  {
    rc_long = (new BigDecimal("1E+12")).longValue();
    Assert.assertEquals(1000000000000L, rc_long);
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_int = (new BigDecimal("0E+12")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0858()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate();
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).subtract(new BigDecimal("1"));
    Assert.assertEquals("999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S8:?UJGLG7MF73;65C;HS4Q=HUS>TN>3VJ2JMF<6B;@05LK56;=X:POAM<EHB1;YW@<OVVL:BVL@?HUNSHQSGVME>>6UCJ9KLNU<", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0868()
  {
    rc_int = (new BigDecimal("999999999999")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0869()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("9.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("9.00000000000000000E+18")).divide(new BigDecimal("-3.2E+2"));
    Assert.assertEquals("-28125000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0872()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E+2")).divide(new BigDecimal("9E+18"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("999999999999")).movePointLeft(0);
    Assert.assertEquals("999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0876()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3.2E+2")).hashCode();
//    Assert.assertEquals(-993, rc_int);
//  }
  public void testItem_0877()
  {
    rc_BigInteger = (new BigDecimal("-28125000000000000")).toBigInteger();
    Assert.assertEquals("-28125000000000000", rc_BigInteger.toString());
  }
  public void testItem_0878()
  {
    rc_String = (new BigDecimal("999999999999")).toString();
    Assert.assertEquals("999999999999", rc_String);
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-28125000000000000"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+16", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0881()
  {
    rc_BigDecimal_array = (new BigDecimal("999999999999")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0882()
  {
    rc_int = (new BigDecimal("999999999999")).intValue();
    Assert.assertEquals(-727379969, rc_int);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("999999999999")).setScale(0);
    Assert.assertEquals("999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("999999999999")).stripTrailingZeros();
    Assert.assertEquals("999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_float = (new BigDecimal("-3.2E+2")).floatValue();
    Assert.assertEquals(-320.0F, rc_float, 0);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).divide(new BigDecimal("999999999999"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-10", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("3E+16")).divideToIntegralValue(new BigDecimal("3E+16"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0889()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0890()
  {
    rc_boolean = (new BigDecimal("-3E-10")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-3E-10"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0892()
  {
    rc_long = (new BigDecimal("-3E-10")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0893()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U0E6J@ESR?47HBHD;F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0896()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0897()
  {
    rc_int = (new BigDecimal("-3.2E+2")).intValueExact();
    Assert.assertEquals(-320, rc_int);
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-3E-10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0901()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0902()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0903()
  {
    rc_int = (new BigDecimal("-3E-10")).compareTo(new BigDecimal("-3.2E+2"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0904()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-10")).setScale(2147483647, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).min(new BigDecimal("-3E-10"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("-3E-10")).divideToIntegralValue(new BigDecimal("4E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7?@MCK6379OCC06KU7U?SXP7LB?<37HO4XJU6SDJ6I?0VARY5U@1E2CRDMWQGQXGN<S>C<K:W;146:CQ0D1P<K?O=O0N:DX2UT12");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-12")).divide(new BigDecimal("-3E-10"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0911()
  {
    rc_float = (new BigDecimal("-3E-10")).floatValue();
    Assert.assertEquals(-2.999999970665357E-10F, rc_float, 0);
  }
  public void testItem_0912()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-12")).divide(new BigDecimal("0E-12"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0919()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0920()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0921()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-12")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322", rc_BigDecimal.toString());
  }
//  public void testItem_0923()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0924()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0925()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ON:@>E;G71:R62@S4Q:JC");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_String = (new BigDecimal("0E-12")).toEngineeringString();
    Assert.assertEquals("0E-12", rc_String);
  }
//  public void testItem_0929()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0931()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E-12")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.UP);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0933()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0935()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0936()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0940()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0943()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0944()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).setScale(0, java.math.RoundingMode.UP);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0957()
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
  public void testItem_0958()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0962()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0964()
  {
    rc_boolean = (new BigDecimal("0")).equals("D@WPQI4P2;SXIC79F9DLB4HEVPF>8141MJNC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0965()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0968()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0969()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0970()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("3E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0974()
  {
    rc_byte = (new BigDecimal("0E+1")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0979()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_int = (new BigDecimal("3E+2")).intValueExact();
    Assert.assertEquals(300, rc_int);
  }
  public void testItem_0987()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '\1', '8', '\234', '\234', '8', '8', '\1', '8', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '8', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '8', '8', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\1', '8', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0991()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0992()
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
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_float = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0995()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0996()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
}
