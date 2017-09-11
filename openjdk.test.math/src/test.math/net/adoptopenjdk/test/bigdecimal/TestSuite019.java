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
package net.adoptopenjdk.test.bigdecimal;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import org.junit.Assert;
import junit.framework.TestCase;
public class TestSuite019 extends TestCase
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
  
  public TestSuite019() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("4E+1"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("4E+1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1E+1"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0013()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0014()
  {
    rc_byte = (new BigDecimal("-10")).byteValueExact();
    Assert.assertEquals(-10, rc_byte);
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("3E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
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
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0018()
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
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
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
  public void testItem_0031()
  {
    rc_BigInteger = (new BigDecimal("4E+1")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).add(new BigDecimal("4E+1"));
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
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
  public void testItem_0034()
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
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("8E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0043()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0047()
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
  public void testItem_0048()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0050()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '8', '8', '\234', '\234', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\1', '8', '\234', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\234', '\234', '\1', '\234', '\1', '\0', '8', '\234', '\uFFFF', '8', '\0', '\234', '\uFFFF', '8', '8', '8', '\234', '\0', '\234', '\1', '\1', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\234', '\1', '\1', '\234', '\1', '8', '\0', '\1', '\0', '8', '\0', '\1', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\0', '\234', '\1', '\1', '8', '8', '\0', '\1', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\0', '\234', '\1', '8', '\uFFFF', '8', '8', '\1', '8', '\1', '\1', '\0', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0061()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\234', '\234', '\234', '\1', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '8', '\234', '\1', '\234', '\1', '8', '8', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0069()
  {
    rc_BigInteger = (new BigDecimal("8")).unscaledValue();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0072()
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
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("0"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("8"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0078()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0079()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0083()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("8")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("8.0", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
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
  public void testItem_0092()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0093()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\uFFFF', '\0', '8', '8', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\0', '8', '8', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\1', '8', '\0', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\0', '\234', '\1', '8', '8', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '8', '\0', '8', '\0', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\1', '8', '\1', '\uFFFF', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2E+2"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("320"));
    Assert.assertEquals("321", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigIntegerExact();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0107()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0108()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_String = (new BigDecimal("321")).toPlainString();
    Assert.assertEquals("321", rc_String);
  }
  public void testItem_0112()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("321")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("321"));
    Assert.assertEquals("321", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("4E+2"), -1, 1);
    Assert.assertEquals("-5.36870E+6", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_String = (new BigDecimal("-2147483647")).toString();
    Assert.assertEquals("-2147483647", rc_String);
  }
  public void testItem_0121()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("4E+2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).min(new BigDecimal("1"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+2")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0125()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483648"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("4E+2")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0132()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2147483647"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
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
  public void testItem_0136()
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
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("4E+2")).add(new BigDecimal("4E+2"));
    Assert.assertEquals("8E+2", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigInteger = (new BigDecimal("4E+2")).toBigIntegerExact();
    Assert.assertEquals("400", rc_BigInteger.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).subtract(new BigDecimal("-2147483648"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-4294967295", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("-4294967295")).compareTo(new BigDecimal("4E+2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0143()
  {
    rc_BigInteger = (new BigDecimal("-4294967295")).toBigIntegerExact();
    Assert.assertEquals("-4294967295", rc_BigInteger.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("-4294967295")).add(new BigDecimal("-4294967295"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-9E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0145()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4294967295")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0151()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\0', '\234', '\1', '\0', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\0', '\1', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '8', '8', '\234', '\234', '\1', '\234', '8', '8', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\0', '8', '8', '8', '\0', '\1', '8', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\1', '8'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VH;6AIUOSBM<Y65A=;F1L?8EA4EJLP1FDU4Y84A@IG8DISL?0Q7<R@?56J>WEDCAK;KU@5A7ER243:=9?Q:;WOS3ED1O0O=M6YT1", new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0157()
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
  public void testItem_0158()
  {
    rc_long = (new BigDecimal("-4E+1")).longValueExact();
    Assert.assertEquals(-40L, rc_long);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).movePointRight(0);
    Assert.assertEquals("-40", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_byte = (new BigDecimal("-40")).byteValueExact();
    Assert.assertEquals(-40, rc_byte);
  }
  public void testItem_0161()
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
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).max(new BigDecimal("-4294967295"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("5E+2147483323", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("5E+2147483323")).ulp();
    Assert.assertEquals("1E+2147483323", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal_array = (new BigDecimal("-4294967295")).divideAndRemainder(new BigDecimal("5E+2147483323"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0166()
  {
    rc_int = (new BigDecimal("5E+2147483323")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0167()
  {
    rc_double = (new BigDecimal("5E-324")).doubleValue();
    Assert.assertEquals(4.9E-324, rc_double, 0);
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YX;;Q8S@CA2M7H>W68C?AXW<JIX56FE>Y;:K2SFDP94N>GW2S=;O<92");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_String = (new BigDecimal("-4E+1")).toString();
    Assert.assertEquals("-4E+1", rc_String);
  }
//  public void testItem_0171()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("5E+2147483323")).toPlainString();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, -1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\1', '8', '\1', '\234', '8', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\1'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).stripTrailingZeros();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0184()
  {
    rc_float = (new BigDecimal("320")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\0', '\234', '\1', '\1', '\234', '\0', '\234', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\234', '8', '\234', '\234', '\234', '8', '\1', '\1', '8', '\uFFFF', '8', '\1', '8', '8', '\1', '8', '\1', '8', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '8', '\1', '8', '8', '\uFFFF', '\0', '8', '8', '\0', '\0', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\0', '8', '8', '\1', '8', '\0', '\1', '\0', '\1'}, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).setScale(1, 0);
    Assert.assertEquals("3000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("7E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0188()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("7E+1")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0189()
  {
    rc_int = (new BigDecimal("3000000000.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("7E+1")).abs();
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320")).divide(new BigDecimal("3000000000.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("7E+1")).max(new BigDecimal("32"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9.375E+7", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '8', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\234', '\1', '\0', '\1', '8', '\1', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\0', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '8', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).add(new BigDecimal("9.375E+7"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.09375E+9", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_int = (new BigDecimal("7E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("7E+1")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0198()
  {
    rc_int = (new BigDecimal("3000000000.0")).precision();
    Assert.assertEquals(11, rc_int);
  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0200()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '\0'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("3000000000.0")).subtract(new BigDecimal("3.09375E+9"));
    Assert.assertEquals("-93750000.0", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("9.375E+7")).subtract(new BigDecimal("9.375E+7"));
    Assert.assertEquals("0E+4", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_String = (new BigDecimal("0E+4")).toString();
    Assert.assertEquals("0E+4", rc_String);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("0E+4")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).abs();
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("9.375E+7")).remainder(new BigDecimal("1E+19"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("9.375E+7", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("9.375E+7")).stripTrailingZeros();
    Assert.assertEquals("9.375E+7", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_double = (new BigDecimal("-93750000.0")).doubleValue();
    Assert.assertEquals(-9.375E7, rc_double, 0);
  }
  public void testItem_0210()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-93750000.0")).pow(-1, new MathContext("precision=0 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).multiply(new BigDecimal("-1E+19"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("9.375E+7")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9.375E+7", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0215()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).min(new BigDecimal("-1E+19"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("-4E+20")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).pow(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-4E+20")).abs();
    Assert.assertEquals("4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_float = (new BigDecimal("4E+20")).floatValue();
    Assert.assertEquals(4.0000000801635094E20F, rc_float, 0);
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_String = (new BigDecimal("-4E+20")).toPlainString();
    Assert.assertEquals("-400000000000000000000", rc_String);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("-4E+20")).negate();
    Assert.assertEquals("4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0227()
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
  public void testItem_0228()
  {
    rc_int = (new BigDecimal("4E+20")).scale();
    Assert.assertEquals(-20, rc_int);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("-93750000.0")).negate();
    Assert.assertEquals("93750000.0", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0231()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-4E+20")).hashCode();
//    Assert.assertEquals(-144, rc_int);
//  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-93750000.0"));
    Assert.assertEquals("-22", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("-22")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("4E+20"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("400000000002147483647", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+20")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("400000000002147483647")).negate();
    Assert.assertEquals("-400000000002147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0238()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("-93750000.0")).divideToIntegralValue(new BigDecimal("-93750000.0"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0243()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4E+20")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("4E+20"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("4E+20")).multiply(new BigDecimal("5E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2.0E-303", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0249()
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
  public void testItem_0250()
  {
    rc_String = (new BigDecimal("4E+20")).toPlainString();
    Assert.assertEquals("400000000000000000000", rc_String);
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("4E+20")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0256()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0257()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QTTU2RE92V36Q<LHWBIR6BOORFH>H4C2QIB18N<509F2E4A4?=:APRC?VF6N<<OQ9V=PF2HT=K:6J2UC77RY?5M2:D<SWNQ?G19>", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("-4E+20")).min(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals("-4E+20", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("1"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0262()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L=YWX68EFVNJN22WS=:=A;3E68WS4HH=IMSM:LANKT;@3TVESLORRA0O37AV1X>MSLBPFN;0=FCCVUPP5=MPP<73F=L@@FG9G07N");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0271()
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
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("-4E+20")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0275()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\0', '\234', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '8', '8', '\1', '\1', '\1', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\1', '\1', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\1', '\0', '8', '\1', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '8', '\1', '8', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0278()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
//  public void testItem_0279()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0280()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0281()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1.0"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("1.0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\1', '\0', '\0', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\1', '\0', '\1', '\1', '\0', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '8', '8', '\0', '8', '8', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '8', '\0', '8', '8', '\1', '\0', '8', '\0', '8', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\234', '\1', '\0', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("9E+18"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":0K4PXN;VFEQ57=;?DUUPYV@J;V29X1E");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9E+18")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0296()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("9E+18"));
    Assert.assertEquals("0E-17", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).unscaledValue();
    Assert.assertEquals("9", rc_BigInteger.toString());
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AW56TE==5@BGE?>W5KGSK??OT:71XYOM@;SIPB1MPWJ5:AHTS>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0300()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9E+18")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0303()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("9E+18"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\1', '\0', '\0'}, 2147483647, 1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0305()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0309()
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
  public void testItem_0310()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+21", rc_BigDecimal.toString());
  }
//  public void testItem_0318()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0319()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).remainder(new BigDecimal("2147483647"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0323()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal_array = (new BigDecimal("3E-2147483647")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).movePointLeft(-2147483648);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
//  public void testItem_0327()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("7E-2147483638")).divide(new BigDecimal("2147483648"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("2147483648"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";EQARQP@0VR:@?DSDINXVR:=:K8C9JGM2D=14O8B@:MOFLRJ3GOINQPLC7@HGFKEAVI=UVWK", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("7E-2147483638")).scaleByPowerOfTen(0);
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("7E-2147483638")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=1 roundingMode=UP"));
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
      rc_MathContext = new MathContext("D=H;<5=5LJWAJCN<51F?A6WTW6:97L?OF1C8018WB9WEHHVNOS39<GPFW8YAWK0F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).divide(new BigDecimal("1"));
    Assert.assertEquals("-7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).divide(new BigDecimal("7E-2147483638"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0344()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-7E-2147483638")).divideAndRemainder(new BigDecimal("-7E-2147483638"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0345()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-7E-2147483638"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).movePointLeft(1);
    Assert.assertEquals("-7E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-7E-2147483638")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).stripTrailingZeros();
    Assert.assertEquals("-7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CWP0EP8O=N?<0GKH0CA1O9OSHC;", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).ulp();
    Assert.assertEquals("1E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '\0', '8', '8', '\234', '8', '\0', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\234', '\234', '\1', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\0', '8', '\0', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '8', '8', '8', '\0', '8', '\234', '\0', '8', '8', '\uFFFF'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0357()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("7E-2147483638")).plus();
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("5E-324"));
    Assert.assertEquals("-0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).divide(new BigDecimal("-0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_double = (new BigDecimal("-0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_int = (new BigDecimal("5E-324")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0369()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0370()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_int = (new BigDecimal("-5E-324")).scale();
    Assert.assertEquals(324, rc_int);
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0373()
  {
    rc_boolean = (new BigDecimal("-320.0E+2147483647")).equals(";:TNVB=?8P;D;0NX5FRF:C0XS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0374()
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
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0376()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-7E-2147483638")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0377()
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
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '\234', '\0', '\1', '\234', '\234', '\0', '\234', '8', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '\uFFFF', '\1', '\234', '\234', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '\0', '8'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0379()
  {
    rc_int = (new BigDecimal("-5E-324")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-7E-2147483638")).add(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0381()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0382()
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
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-5E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '8', '\234', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0385()
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
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("-7E-2147483638")).abs();
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5E-324")).divide(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("7E-2147483638")).divide(new BigDecimal("-5E-324"));
    Assert.assertEquals("-1.4E-2147483314", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.4E-2147483314")).divideAndRemainder(new BigDecimal("-1.4E-2147483314"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("7E-2147483638")).max(new BigDecimal("7E-2147483638"));
    Assert.assertEquals("7E-2147483638", rc_BigDecimal.toString());
  }
//  public void testItem_0394()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).max(new BigDecimal("-1.4E-2147483314"));
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RVTK>TH6RHE35VRQBCQ?PHO6Y1@37O35PLBDM@?F;TN?DLT0OY:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0397()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_String = (new BigDecimal("8")).toPlainString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).stripTrailingZeros();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scaleByPowerOfTen(-1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
//  public void testItem_0402()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).divide(new BigDecimal("-1.4E-2147483314"), 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.4E-2147483314")).subtract(new BigDecimal("-320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0404()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '8', '\1', '8', '8', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\0', '8', '\1', '\0', '\1', '\uFFFF', '8', '\0', '\234', '8', '\0', '\1', '\0', '\1', '\234', '\0', '\234', '\1', '\0', '8', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '8', '8', '\234', '8', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\234', '\1', '\0', '\234', '\0', '\1', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\0', '\0'}, 0, 0, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0405()
  {
    rc_boolean = (new BigDecimal("-1.4E-2147483314")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.4E-2147483314")).pow(2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0407()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0408()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
//  public void testItem_0409()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1.4E-2147483314")).divideAndRemainder(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0410()
  {
    rc_float = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
//  public void testItem_0411()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("-320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\234', '\0', '8', '\1', '\234', '\234', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\1', '8', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\1', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0413()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, -1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0416()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0417()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1.4E-2147483314")).hashCode();
//    Assert.assertEquals(2147482881, rc_int);
//  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("-2E+9"));
    Assert.assertEquals("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0421()
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
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).divideToIntegralValue(new BigDecimal("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+8", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";W?OXQCUDEAVUE:U1Q2ITKT9@5:1TC32GFEJ?W397;44GVP1??8WUVT=Y>BBBJF75WPVI<R2RW1@U8IUV;Q:IGMSL54==14Q9HM4", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0425()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigInteger();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0426()
  {
    rc_int = (new BigDecimal("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000")).intValue();
    Assert.assertEquals(-256828324, rc_int);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000")).divideToIntegralValue(new BigDecimal("2147483647"));
    Assert.assertEquals("-41855804987704190609496041422406313857734947288715022424316853669423369718453678814111490794687964897816159936866420865516914766729644899309556313167011864325048783613985602116262701880865435280326460271400412191894233138461524905890426219234470228372080783114839878258858326286691229896301.000000000", rc_BigDecimal.toString());
  }
  public void testItem_0428()
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
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\1', '\0', '\1', '\0', '\1', '\1', '8', '\234', '8', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\234', '\1', '\234', '8', '\1', '\0', '\1', '\234', '\0', '8', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '8', '\234', '\234', '\uFFFF', '8', '8', '\0', '\0', '\234', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\0', '\0', '\0', '\234', '8', '\1', '\234', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-89884656743115785407263711865852178399035283762922498299458738401578630390014269380294779316383439085770229476757191232117160663444732091384233773351768758493024955288275641038122745045194664472037934254227566971152291618451611474082904279666061674137398913102072361584369088590459649940625202013092.000000000"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.4E-2147483314")).divide(new BigDecimal("-1.4E-2147483314"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0437()
  {
    rc_float = (new BigDecimal("-1.4E-2147483314")).floatValue();
    Assert.assertEquals(-0.0F, rc_float, 0);
  }
  public void testItem_0438()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\1', '\1', '\0', '8', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\1', '\0', '8', '\234', '\1', '\0', '\0', '\1', '\1', '8', '\0', '\1', '\uFFFF', '\0', '8', '\1', '\0', '8', '8', '8', '8', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\1', '8', '8', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\0', '8', '\1', '8', '8'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0439()
  {
    rc_String = (new BigDecimal("0E+9")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-1.4E-2147483314")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0441()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+9"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0442()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("-1.4E-2147483314"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
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
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0450()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_int = (new BigDecimal("3E-2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0460()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483647")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0462()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).remainder(new BigDecimal("3E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0463()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0464()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\1', '8', '8', '\1', '8', '\1', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '\0', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '8', '\1', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '8', '\0'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0468()
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
  public void testItem_0469()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0472()
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
  public void testItem_0473()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-2147483648"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-2147483616", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0478()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigInteger = (new BigDecimal("-2147483616")).unscaledValue();
    Assert.assertEquals("-2147483616", rc_BigInteger.toString());
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("0"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WURF@BLI774G29HHBOGT?:K5>OHSY324LDEETCOC0L:KA97BJ?T;TD<QEO=2UEJSS5:MI=BGJT8?896M6006YOJ>B");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0492()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=0 roundingMode=CEILING"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0493()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-2147483616")).multiply(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-4611685947560427552", rc_BigDecimal.toString());
  }
  public void testItem_0497()
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
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0499()
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
//  public void testItem_0500()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4611685947560427552")).add(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("320")).movePointRight(0);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("-4611685947560427552")).pow(1);
    Assert.assertEquals("-4611685947560427552", rc_BigDecimal.toString());
  }
  public void testItem_0503()
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
  public void testItem_0504()
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
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("-4611685947560427552")).toBigInteger();
    Assert.assertEquals("-4611685947560427552", rc_BigInteger.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("320")).multiply(new BigDecimal("-4611685947560427552"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1475739503219336816640", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_float = (new BigDecimal("320")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_int = (new BigDecimal("-9E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-4611685947560427552")).min(new BigDecimal("-9E+18"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
//  public void testItem_0515()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0516()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValueExact();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0517()
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
  public void testItem_0518()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("-9E+18"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0520()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("-4611685947560427552")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-4611685947560427552")).multiply(new BigDecimal("-4611685947560427552"));
    Assert.assertEquals("21267647278926318541054102529040712704", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_int = (new BigDecimal("4E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0525()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\1', '8', '\234', '8', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF'}, -2147483648, 1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0526()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0529()
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
  public void testItem_0530()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0531()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0534()
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
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, -2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0537()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0541()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("31")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0542()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=CEILING"));
  }
  public void testItem_0545()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GRE@8C8X3JRE6V1CA=R0Q<71C8W7X7HUVPI:C6N9R0L1MM40<@H?H<6<CV@DB1;YO4QQ0:SU;=J95M=0B2;58J?7EBPH?31QHH>O", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0551()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\1', '8', '\1', '\234', '\1', '\1', '8', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\0', '\1', '\1', '\0', '\0', '\1', '\1', '\1', '\0', '8', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\1', '8', '\0', '8', '\uFFFF', '\0', '\0', '\1', '8', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0557()
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
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("-1"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("-3")).subtract(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-6", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0564()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0565()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("-3")).min(new BigDecimal("-3.2"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_String = (new BigDecimal("-3")).toString();
    Assert.assertEquals("-3", rc_String);
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0569()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0570()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3.2"), java.math.RoundingMode.UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("-3")).pow(0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal_array = (new BigDecimal("-3")).divideAndRemainder(new BigDecimal("-3"));
  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0579()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0583()
  {
    rc_boolean = (new BigDecimal("-1")).equals("6QOJR5CHI4:JVQX6DU:?AA0JC<GX:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("-3")).plus();
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0587()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-4E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-3"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
//  public void testItem_0590()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-3"), new MathContext("precision=1 roundingMode=CEILING"));
//    }
//  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0593()
  {
    rc_boolean = (new BigDecimal("-3")).equals("@5PQ<430IKN@X<QUXJ:IYXY>IAE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0594()
  {
    rc_int = (new BigDecimal("-3")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0595()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0596()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-10")).hashCode();
//    Assert.assertEquals(-310, rc_int);
//  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("-3")).divide(new BigDecimal("-10"));
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-10"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_float = (new BigDecimal("-3")).floatValue();
    Assert.assertEquals(-3.0F, rc_float, 0);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10")).divide(new BigDecimal("1"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0605()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0606()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0612()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.3")).hashCode();
//    Assert.assertEquals(94, rc_int);
//  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("0.3"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("-3")).negate(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_int = (new BigDecimal("0.3")).scale();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0617()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.3")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0618()
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
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("9223372036854775807"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0621()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0624()
  {
    rc_boolean = (new BigDecimal("-9223372036854775808")).equals("W;9=WU3E?JUO>CO8GVXD6?5IWCDIJWX2HG:>5RGIP1D=AN5P7LB9JM62XLO;Q2CE4=NNIX=2KQ<R7U;HTDN1WW4TRJ;DH0@F>D51");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0627()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0628()
  {
    rc_BigDecimal_array = (new BigDecimal("1E-2147483647")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=1 roundingMode=CEILING"));
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0633()
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
  public void testItem_0634()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0638()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0639()
  {
    rc_boolean = (new BigDecimal("1E-2147483647")).equals("6CGXXR4C:SW8MPK>T:G:VBT1R:CLT9KO6JTJR76<QSCLMSFHM<SMG68TIO?L0WL9EULW1T=YPBRU:6RWNHGG:20IR=?04FKMI=4G");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0641()
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
  public void testItem_0642()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).stripTrailingZeros();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("2147483647"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
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
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_long = (new BigDecimal("-2147483648")).longValueExact();
    Assert.assertEquals(-2147483648L, rc_long);
  }
//  public void testItem_0650()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0651()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("-1E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0652()
  {
    rc_float = (new BigDecimal("2147483647")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(-1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_int = (new BigDecimal("2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0659()
  {
    rc_int = (new BigDecimal("2147483648")).compareTo(new BigDecimal("1E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0660()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.147483647E-2147483638", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("2.147483647E-2147483638")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0663()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2147483648")).divideAndRemainder(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).plus();
    Assert.assertEquals("2.147483647E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0665()
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
//  public void testItem_0666()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("1E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0669()
  {
    rc_String = (new BigDecimal("2147483647")).toEngineeringString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0670()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2147483648")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0672()
  {
    rc_float = (new BigDecimal("1E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).add(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2.147483648E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).divideToIntegralValue(new BigDecimal("2.147483648E-2147483638"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483648")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0677()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '\0', '\234', '\234', '8', '\uFFFF', '8'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0678()
  {
    rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("-1"));
  }
//  public void testItem_0679()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).subtract(new BigDecimal("2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0680()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0681()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("2.147483647E-2147483638")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0682()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0683()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0684()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UTD9Y9D5?8CEN;H7FGQPT1?V7LBA:7;6FC?QQK6DK60XNBWC3KB20MSW69<A8A", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0685()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\1', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '8', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '\234', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\234', '8', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\234', '8', '8', '\234', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '\234', '8', '8', '\234', '\uFFFF', '8', '\234', '\1', '\1'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0687()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("2.147483647E-2147483638")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E-2147483638")).negate();
    Assert.assertEquals("-2.147483647E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0690()
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
  public void testItem_0691()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
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
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0698()
  {
    rc_int = (new BigDecimal("2.147483647E-2147483638")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0699()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
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
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0708()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483648")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '8', '\234', '\1', '8', '\0', '\1', '\234', '8', '\1', '\0', '\234', '8', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\1', '8', '\uFFFF', '\1', '\234', '\0', '8', '\0', '8', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\234', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '8', '8', '\0', '8', '\0', '\uFFFF', '\0', '8', '\234', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0719()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0720()
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
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigIntegerExact();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0723()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointRight(1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("A8;H6=H8BJ<OSJDLQXUQMO2V8O@TNE07HYF4J;W0E1<30U7F>1LHA>OEF2EM7SOXGYRRNLN42A4B;H;@4SG7;37J7VT79?LY4G?Q");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0729()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("92233720368547758070")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("92233720368547758070"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
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
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0739()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0740()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0741()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("92233720368547758070")).movePointLeft(1);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@NL1BVP:K4HIHHKET1P4KW9Y1F?VNH@V8NXM=U=FASU0XR:<BTKWGM8C=E0ES4GBOCJSHLS=>HU23<3XXDRG9SUIH?=NOFM@=XG;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0744()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("10")).min(new BigDecimal("9223372036854775807.0"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("10"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("9223372036854775807.0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).movePointLeft(0);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\234', '\0', '8', '\0', '\234', '8', '\234', '\0', '8', '\uFFFF', '8', '\1', '\234', '8', '\234', '8', '8', '\1', '\0', '\0', '8', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '8', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).divideToIntegralValue(new BigDecimal("9223372036854775807.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775806.0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("10"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0765()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("D3XOS>102XU11C@<=8GQ0GXOG8UD7G:I22>DUGLL?MBJ?WKYYF?SHVF9R?OUGH>8F;W>BUJTALH:BT<LY573OG9M>NWEY>9HB7V7");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0766()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\1', '8', '8', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\1', '\0', '8', '8', '\234', '\0', '8', '\1', '\1', '\1', '\0', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\1', '8', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0769()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3.2E+2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0770()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0773()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).round(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("-3E+9")).plus();
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0778()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\1', '8', '\1', '\uFFFF', '8', '\1', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\234', '\234', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '\1', '8', '8', '8', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\0', '\0', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0783()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0789()
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
  public void testItem_0790()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0791()
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
  public void testItem_0792()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
//  public void testItem_0795()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("3.2E+2")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0799()
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
  public void testItem_0800()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2")).subtract(new BigDecimal("32"));
    Assert.assertEquals("68", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1.0E+2"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0806()
  {
    rc_double = (new BigDecimal("68")).doubleValue();
    Assert.assertEquals(68.0, rc_double, 0);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("68")).plus();
    Assert.assertEquals("68", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("68")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("68", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_String = (new BigDecimal("68")).toEngineeringString();
    Assert.assertEquals("68", rc_String);
  }
  public void testItem_0811()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("68")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0813()
  {
    rc_short = (new BigDecimal("68")).shortValueExact();
    Assert.assertEquals(68, rc_short);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0816()
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
  public void testItem_0817()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0823()
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
  public void testItem_0824()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0829()
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
  public void testItem_0830()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0835()
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
  public void testItem_0836()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0838()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("SG@>N>RUF?7Q2LPY7C?HP>9<LX1A>U?AK23MRJEN=KJ497GM51C<0MXL1R?J4CH43IH0Q<O5L8@2U;YA90@1WFL2AN");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0845()
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
  public void testItem_0846()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0849()
  {
    rc_boolean = (new BigDecimal("1")).equals("E@IGV@1NTBD<S4<>4434<>;091M:8LMFAE>Y252KVK?55DG8RXFNI687VFP?MIO@MIP<IPCTX5CP");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0850()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0851()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0853()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("Y03IK71X<35LM9AY<JJYU252TA3D48M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0855()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-6.4", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CFOH:FD24A728?CC7ENUO:JE24:@GPRSTEK0R93HTY4Y;40JLOXR>DR;H5JQA0K6:V2LT2?FUWH;?;;BI?NB1>;3UCYLG00");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-6.4"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-6.4", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigInteger = (new BigDecimal("-6.4")).toBigInteger();
    Assert.assertEquals("-6", rc_BigInteger.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_int = (new BigDecimal("-3.2")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0865()
  {
    rc_int = (new BigDecimal("-3.2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0870()
  {
    rc_long = (new BigDecimal("-3.2")).longValue();
    Assert.assertEquals(-3L, rc_long);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0873()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).toBigInteger();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0874()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775804.8", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).divide(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2882303761517117439", rc_BigDecimal.toString());
  }
//  public void testItem_0877()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-9223372036854775804.8"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775804.8")).add(new BigDecimal("1"));
    Assert.assertEquals("-9223372036854775803.8", rc_BigDecimal.toString());
  }
  public void testItem_0879()
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
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).multiply(new BigDecimal("-2882303761517117439"));
    Assert.assertEquals("8307674973655724199884186603717918721", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).round(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2882303761517117439", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_String = (new BigDecimal("-9223372036854775803.8")).toPlainString();
    Assert.assertEquals("-9223372036854775803.8", rc_String);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("8307674973655724199884186603717918721")).min(new BigDecimal("-9223372036854775803.8"));
    Assert.assertEquals("-9223372036854775803.8", rc_BigDecimal.toString());
  }
  public void testItem_0884()
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
  public void testItem_0885()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).remainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2882303761517117439", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-2882303761517117439"));
    Assert.assertEquals("26584559915698317448852769168752115712", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_int = (new BigDecimal("8307674973655724199884186603717918721")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).remainder(new BigDecimal("-9223372036854775803.8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2882303761517117439", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_String = (new BigDecimal("-9223372036854775803.8")).toEngineeringString();
    Assert.assertEquals("-9223372036854775803.8", rc_String);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775803.8")).divide(new BigDecimal("-9223372036854775803.8"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).max(new BigDecimal("-9223372036854775803.8"));
    Assert.assertEquals("-2882303761517117439", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_int = (new BigDecimal("-2882303761517117439")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0897()
  {
    rc_long = (new BigDecimal("-2882303761517117439")).longValue();
    Assert.assertEquals(-2882303761517117439L, rc_long);
  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775803.8")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2882303761517117439")).divide(new BigDecimal("-9223372036854775803.8"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0900()
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
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.2", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775803.8")).toBigInteger();
    Assert.assertEquals("-9223372036854775803", rc_BigInteger.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-9223372036854775803.8"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\234', '\1', '8', '\234', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '8', '\0', '\0', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '\234', '8', '\uFFFF', '8', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\0', '8', '\0', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\1', '\1', '\uFFFF', '\234', '8', '\234', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '8', '\0', '8', '\234', '8', '\234', '\1', '\234', '\0', '\234', '8', '\0', '\0', '\234', '\1', '\1', '\234', '\1', '\1', '\234', '\1', '\1', '\0'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '8', '\1'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0910()
  {
    rc_int = (new BigDecimal("-2882303761517117439")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).stripTrailingZeros();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0912()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("-2882303761517117439")).movePointLeft(1);
    Assert.assertEquals("-288230376151711743.9", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0916()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0917()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("25;@KA;IAP8K5CFF0WY2RVQHYUYL;JGAJ9@SHNKANR3;69G9J2NYUR??A<M<Y>Q8AV?ILAJ@J73NN8QIVLJ2NRA6<7VB@WXYLLXK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-288230376151711743.9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-288230376151711711.9", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_int = (new BigDecimal("-288230376151711711.9")).intValue();
    Assert.assertEquals(33, rc_int);
  }
  public void testItem_0921()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-288230376151711743.9"), 1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0923()
  {
    rc_boolean = (new BigDecimal("-288230376151711711.9")).equals(":PQN?M9U=7G:AA57PNEUBA<R");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-9.223372036854775808E+2147483665", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).add(new BigDecimal("32.0"));
    Assert.assertEquals("-288230376151711711.9", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-288230376151711711.9")).divide(new BigDecimal("-288230376151711743.9"), 2147483647, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0928()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("-288230376151711743.9", rc_BigDecimal.toString());
  }
//  public void testItem_0929()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32.0")).hashCode();
//    Assert.assertEquals(9921, rc_int);
//  }
  public void testItem_0930()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).divideToIntegralValue(new BigDecimal("-288230376151711743.9"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-9223372036854775808.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-288230376151711743.9"));
    Assert.assertEquals("-288230376151711743.9", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).multiply(new BigDecimal("-288230376151711743.9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("83076749736557241998841866037179187.21", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\uFFFF', '8', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\1', '\0', '\234', '8', '\234', '\1', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\1', '8', '8', '\1', '\1', '\0'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\0', '8', '\0', '\234', '\234', '\0', '\1', '\1', '\234', '8', '8', '\234', '8', '8', '\0', '\0', '\234', '8', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\234', '\1'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("83076749736557241998841866037179187.21")).max(new BigDecimal("83076749736557241998841866037179187.21"));
    Assert.assertEquals("83076749736557241998841866037179187.21", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\uFFFF', '8', '\0', '8', '\234', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '8', '8', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\0', '8', '\234', '\1', '\234', '8', '\0', '\0', '\234', '\1', '\1', '\0', '8', '\234', '\234', '8', '\234', '8', '\1', '\0', '8', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\1', '8', '\1', '\1', '8', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\234', '8', '\1', '\0', '\0', '\uFFFF', '8', '8', '\1', '\234', '\0', '8', '8', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711711.9")).subtract(new BigDecimal("-288230376151711743.9"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_int = (new BigDecimal("32.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("-288230376151711743.9")).abs();
    Assert.assertEquals("288230376151711743.9", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).add(new BigDecimal("32.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("64.0", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("64.0")).max(new BigDecimal("288230376151711743.9"));
    Assert.assertEquals("288230376151711743.9", rc_BigDecimal.toString());
  }
  public void testItem_0946()
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
  public void testItem_0947()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0948()
  {
    rc_int = (new BigDecimal("288230376151711743.9")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0949()
  {
    rc_long = (new BigDecimal("64.0")).longValue();
    Assert.assertEquals(64L, rc_long);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("64.0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("67.2", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0953()
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
  public void testItem_0954()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0955()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("6HT<NNGN6:XGBH>7:EN@YEIQ;@9E");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0956()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0957()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("-9223372036854775808.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
//  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("288230376151711743.9")).pow(-1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0960()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-9223372036854775808.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0962()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0963()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("3.2"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '8', '8', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\1', '\0', '\1', '8', '\1', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\234', '\1'}, 0, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
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
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0970()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0973()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0974()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("0E+2147483647")).scale();
    Assert.assertEquals(-2147483647, rc_int);
  }
  public void testItem_0976()
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
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0978()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("3.2"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0979()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("0E+1"), 0, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0981()
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
  public void testItem_0982()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648, -2147483648);
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
      rc_long = (new BigDecimal("320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0988()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("3.2"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_String = (new BigDecimal("6.4")).toString();
    Assert.assertEquals("6.4", rc_String);
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0992()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\234', '\0', '\0', '\0', '\1', '8', '\0', '\uFFFF', '\0', '8', '\0', '\1', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '8', '\234', '8', '8', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\1', '\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0993()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).subtract(new BigDecimal("6.4"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-6.4", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E+2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0996()
  {
    rc_long = (new BigDecimal("0E+2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).remainder(new BigDecimal("6.4"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0998()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+2147483647")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0999()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("AT1:PM05:F<LUK>QSGPS7;FSVMKRQP57;?53J;M6KI=7=58BENE<I?JGY4:=GMD44POB;TVQ?7PGK2");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
}
