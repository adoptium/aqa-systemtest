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
public class TestSuite017 extends TestCase
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
  
  public TestSuite017() {

  }
  public void testItem_0000()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0003()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0004()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0005()
  {
    rc_boolean = (new BigDecimal("0")).equals("C68L1?R4PUP0BDK6AK4G7XAS7@BYR3HS?UCE=;2N0XRETX1H");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).negate(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\0', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '8', '\uFFFF', '\234', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\0', '8', '\234', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\0', '\1', '8', '\234', '8', '\234', '8', '8', '\234', '\0', '\1', '\uFFFF', '\234', '8', '\1', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0013()
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
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\0', '8', '\uFFFF', '\0', '\1', '\234', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\1', '8', '8', '\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
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
  public void testItem_0017()
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
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '8', '8', '\234', '\1', '\1', '8', '8', '\0', '\1', '8', '\0', '\uFFFF', '8', '8', '8', '\1', '\0', '\234', '\1', '\234', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\0', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\234', '8', '8', '\0', '\0', '8', '\234', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).negate(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0020()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0021()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\0', '8'}, 0, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0022()
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
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0025()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0026()
  {
    rc_int = (new BigDecimal("1E+1")).intValueExact();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("71WY?CTA5OS;<4E@D9W7R<LUBUHP0L@FMW:<2YHRNOY4T136F8?XX9TQ2X;73AQ>RG9?KKAPOBUIJWL8YVISOO;E>HC<AKQY0UBO");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0035()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TN3D4MH@M9SO46YRHYT>DA=ATY0H;DP5MEKIGPW2:PQJUFL>RJMUDQROSXI;FU7D?4?82?F0A62?L>014X:U5JK5=X<F4TA5Q;IP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointLeft(0);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0.1"));
    Assert.assertEquals("0.9", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_long = (new BigDecimal("0.1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-9.223372036854775807E+2147483665", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_int = (new BigDecimal("-9E+18")).intValue();
    Assert.assertEquals(494665728, rc_int);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775808"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0051()
  {
    rc_int = (new BigDecimal("-9E+18")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0052()
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
  public void testItem_0053()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0054()
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
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0056()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0057()
  {
    rc_String = (new BigDecimal("0.1")).toString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_int = (new BigDecimal("0.1")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9223372036854775808")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0061()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0063()
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
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\1', '\1', '8', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\0', '\0', '\0', '8', '8', '\234', '8', '\234', '8', '\0', '\1', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\1', '8', '8', '8', '\1', '\1', '\234', '\0', '\0', '8', '\234', '8', '\234', '\234', '8', '\1', '\234', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\234', '8', '8', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointLeft(2147483647);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0069()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("1E+2147483647")).compareTo(new BigDecimal("1"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AL2AGWLM");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0072()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0073()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0074()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0075()
  {
    rc_boolean = (new BigDecimal("0.1")).equals("UEHLUDM0AGIB>XLE>L90JUN=E0FWE92Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0076()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0077()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1E+2147483647"));
//    Assert.assertEquals("1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0078()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0085()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0088()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0091()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("0E-1074"), -1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0096()
  {
    rc_String = (new BigDecimal("1135879015891")).toString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+31", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_String = (new BigDecimal("1135879015891")).toPlainString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0100()
  {
    rc_long = (new BigDecimal("0E-1074")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AG23S3D<:Y;:1Q:A850GY0;PW82J8X74S;@Y@PM204N1Q4EUPHUFL?8C3T5<W8N3CBS472LAT@CFPE6RL6A:F:E6XB2U<T071LE?", new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_long = (new BigDecimal("0E-1074")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_float = (new BigDecimal("9223372036854775807")).floatValue();
    Assert.assertEquals(9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0107()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0113()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("31")).stripTrailingZeros();
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("31")).movePointLeft(2147483647);
    Assert.assertEquals("3.1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("31"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0117()
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
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0120()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("31"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("31")).add(new BigDecimal("31"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_int = (new BigDecimal("62")).intValue();
    Assert.assertEquals(62, rc_int);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_int = (new BigDecimal("1135879015891")).precision();
    Assert.assertEquals(13, rc_int);
  }
  public void testItem_0129()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0130()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("31"));
  }
  public void testItem_0131()
  {
    rc_int = (new BigDecimal("31")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0132()
  {
    rc_long = (new BigDecimal("1135879015891")).longValue();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
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
  public void testItem_0135()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0136()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("31"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0137()
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
  public void testItem_0138()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("31")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("31.0", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0142()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0146()
  {
    rc_short = (new BigDecimal("31")).shortValueExact();
    Assert.assertEquals(31, rc_short);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("31")).setScale(0, 0);
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0149()
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
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0154()
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
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '\234', '8', '\uFFFF', '8', '\0', '8', '\234', '\1', '\1', '8', '\0', '8', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '8', '8', '\0', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\1', '8', '\1', '\1', '\234', '\234', '\1', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0165()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0166()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1E+1"));
  }
  public void testItem_0171()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0172()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0173()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0175()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0177()
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
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0181()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0182()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XR7IBGK@S1@L?S5EI:6MP6@5N181=EURPFPHKXJ5ORPD3HJS04SOO@OIXMSSVDCJJH8YSAPUT3CH391IQI", new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0188()
  {
    rc_boolean = (new BigDecimal("32.0E+2147483647")).equals("V;QWVSWEP46XXVAFKWV3Y:XJS9=297L7QWLYM3LBV9P04YQGLQ?Y5:S=BQH40CPPW21A37@:Y6W065X8XGIA2IFU32CSGKH1XK4H");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0189()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("32.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483648", rc_String);
//  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0194()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0195()
  {
    rc_double = (new BigDecimal("-32")).doubleValue();
    Assert.assertEquals(-32.0, rc_double, 0);
  }
  public void testItem_0196()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0197()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0198()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-32")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0199()
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
  public void testItem_0200()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0201()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0204()
  {
    rc_byte = (new BigDecimal("-32")).byteValueExact();
    Assert.assertEquals(-32, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0205()
  {
    rc_boolean = (new BigDecimal("-32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0206()
  {
    rc_boolean = (new BigDecimal("-32")).equals(">T998FW4JR@488=PU;IY3P?5=IJMF6X6;D;WNH:SUFQ?Q45A4I=;2WQ3A=AO<X8VC6A4B4IHDTO6@RV47:X5;=K3=5E;=QEH7IEA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("-32")).stripTrailingZeros();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("2E+3")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E+4", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0218()
  {
    rc_float = (new BigDecimal("2E+3")).floatValue();
    Assert.assertEquals(2000.0F, rc_float, 0);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("2E+3"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(1);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-3E+1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_float = (new BigDecimal("2E+3")).floatValue();
    Assert.assertEquals(2000.0F, rc_float, 0);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("-2")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0230()
  {
    rc_long = (new BigDecimal("2E+3")).longValueExact();
    Assert.assertEquals(2000L, rc_long);
  }
  public void testItem_0231()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
//  public void testItem_0232()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1);
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
      rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("2E+3"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("2E+3"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0236()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("2E+3"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\1', '8', '\234', '\234', '8', '8', '\0', '\1', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\0', '\0', '8', '8', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0243()
  {
    rc_boolean = (new BigDecimal("32.0E+2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0250()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("32.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483648", rc_String);
//  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0252()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":>?JD83ICNOGNWGQY;MM0WTTCPI2PG1ISTGF0JCEBB3AIO;CQA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WPX9<ELSC17FP71WQHX9Y2PPUH7D50>DW@@86ALO<6?T7DQ60F6A1T9OB6R;M:SFG=HWX96>:L0W8J:3QFOV0U@;?TV9M=M;OWD>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0255()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).subtract(new BigDecimal("32.0E+2147483647"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0258()
  {
    rc_String = (new BigDecimal("64")).toPlainString();
    Assert.assertEquals("64", rc_String);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0260()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).divide(new BigDecimal("32.0E+2147483647"), -1, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).min(new BigDecimal("1"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0265()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("4E+2147483647")).toString();
//    Assert.assertEquals("4E+2147483648", rc_String);
//  }
  public void testItem_0266()
  {
    rc_float = (new BigDecimal("32.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0267()
  {
    rc_short = (new BigDecimal("0E+2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0268()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0269()
  {
    rc_boolean = (new BigDecimal("0E+2147483647")).equals("PKEDINH?G0BSLAPN1SQ7:NYV<AYMXI");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0270()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("64")).intValueExact();
    Assert.assertEquals(64, rc_int);
  }
  public void testItem_0272()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0273()
  {
    rc_boolean = (new BigDecimal("4E+2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0275()
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
  public void testItem_0276()
  {
    rc_long = (new BigDecimal("0E+2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).multiply(new BigDecimal("4E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0278()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("4E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).setScale(2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).divide(new BigDecimal("1135879015891"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).unscaledValue();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0285()
  {
    rc_long = (new BigDecimal("64")).longValue();
    Assert.assertEquals(64L, rc_long);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+2147483647")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0289()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0291()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).min(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0293()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("4E+2147483647")).plus();
//    Assert.assertEquals("4E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0294()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("64"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_String = (new BigDecimal("64")).toEngineeringString();
    Assert.assertEquals("64", rc_String);
  }
  public void testItem_0298()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0299()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("4E+2147483647")).min(new BigDecimal("1"));
//    Assert.assertEquals("4E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0300()
  {
    rc_float = (new BigDecimal("00.0E+2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("64"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("64"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0306()
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
  public void testItem_0307()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).negate();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0317()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).plus();
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\0', '\234', '\0', '\234', '8', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\1', '\0', '\0', '\234', '\1', '\1', '8', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\1', '8', '\0', '\0', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0330()
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
  public void testItem_0331()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("60", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0338()
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
  public void testItem_0339()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0340()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0341()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\1', '\0', '\1', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '8', '\234', '\0', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '8', '\234', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\1', '8', '\0', '8', '\0', '\1', '\0', '\234', '\0', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\1', '8', '\0', '8', '\0', '8', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '8', '8', '\234', '\234', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\1', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\234', '\1'}, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0345()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0346()
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
  public void testItem_0347()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0348()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0352()
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
  public void testItem_0353()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).movePointLeft(1);
    Assert.assertEquals("200000000000", rc_BigDecimal.toString());
  }
  public void testItem_0358()
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
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("200000000000"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-5E-12", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\234', '8', '\234', '\234', '8', '\1', '\234', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\234', '8', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '8', '\1', '8', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF'}, 1, 1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("-5E-12")).negate(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("5E-12", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("1135879015891"));
  }
  public void testItem_0367()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("200000000000"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("200000000000")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("200000000000", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_int = (new BigDecimal("200000000000")).intValue();
    Assert.assertEquals(-1863462912, rc_int);
  }
  public void testItem_0371()
  {
    rc_int = (new BigDecimal("200000000000")).precision();
    Assert.assertEquals(12, rc_int);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '8', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\1', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '8', '\1', '8', '\1', '\234', '\234', '8', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("200000000000")).movePointRight(-1);
    Assert.assertEquals("20000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("200000000000")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("200000000000")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("200000000000", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_double = (new BigDecimal("200000000000")).doubleValue();
    Assert.assertEquals(2.0E11, rc_double, 0);
  }
  public void testItem_0383()
  {
    rc_String = (new BigDecimal("200000000000")).toEngineeringString();
    Assert.assertEquals("200000000000", rc_String);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("20000000000.0")).divide(new BigDecimal("200000000000"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@E0S50MKTSFLUW45LTYH==1NQ;KBB4:=S7:E6KYBB=FEX4ICQFGL5;OYDI5K9LFSX9U0IOII0TSF>C46?7P81UH5MSOXQD2I:1T<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0393()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("-1E+308", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0394()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1E+308")).longValueExact();
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
      rc_MathContext = new MathContext(">14VU;0WD97G6RE0NL>1EG:PX0K>MC@?E3END@?Q:@JFU?Q?LU>3QST?E");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0397()
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
//  public void testItem_0398()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("4E+1")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0401()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("-4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0402()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0403()
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
  public void testItem_0404()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_int = (new BigDecimal("4E+1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0408()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0409()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("320.0E+2147483647"), 1, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\234', '\0', '\1', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF'}, 2147483647, -2147483648);
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
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0413()
  {
    rc_byte = (new BigDecimal("4E+1")).byteValueExact();
    Assert.assertEquals(40, rc_byte);
  }
  public void testItem_0414()
  {
    rc_int = (new BigDecimal("4E+1")).intValue();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '8', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\234', '8', '\0', '8', '\0', '\1', '8', '\0', '\uFFFF', '8', '\234', '\0', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\1', '8', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '8', '\234', '\0', '\1', '\0', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0416()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0417()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0421()
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
  public void testItem_0422()
  {
    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
  public void testItem_0423()
  {
    rc_int = (new BigDecimal("8")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0424()
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
  public void testItem_0425()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '\1', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\0', '8', '\234', '\1', '\uFFFF', '8', '\0', '8', '\0', '8', '8', '\234', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '\1', '\1', '8', '\1', '\234', '\uFFFF', '8', '\1', '\0', '\1', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\1', '\0', '\0', '\1', '8', '\234', '8', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\1'}, -1, 2147483647, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("8"), -1, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-2147483648, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate();
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
//  public void testItem_0430()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0431()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8")).remainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0432()
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
  public void testItem_0433()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\0', '8', '\0', '8', '\1', '\234', '\1', '8', '8', '8', '\1', '\1', '\1', '8', '\0', '\1', '\1', '\234', '\1', '\0', '\234', '\0', '\1', '8', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\234', '\234', '8', '8', '\234', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("320.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0435()
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
  public void testItem_0436()
  {
    rc_int = (new BigDecimal("-8")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0437()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0440()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0441()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("1"));
//    Assert.assertEquals("1", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0442()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0443()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0445()
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
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0447()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0448()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XAWWBGUL83UH<FJ4518RH;4B1LI<I:<;N3C@M9>RB6>2:QDPB8928EB2O;D@LH01L23I7MJI547X", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("0.03")).movePointRight(-1);
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("0.003")).movePointRight(-1);
    Assert.assertEquals("0.0003", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775776")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775776")).remainder(new BigDecimal("-9223372036854775776"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).divideToIntegralValue(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0466()
  {
    rc_int = (new BigDecimal("-9223372036854775776")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0467()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-9223372036854775776"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775777", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775777")).negate();
    Assert.assertEquals("-9223372036854775777", rc_BigDecimal.toString());
  }
//  public void testItem_0471()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9223372036854775776")).hashCode();
//    Assert.assertEquals(-2147481695, rc_int);
//  }
  public void testItem_0472()
  {
    rc_String = (new BigDecimal("-9223372036854775776")).toEngineeringString();
    Assert.assertEquals("-9223372036854775776", rc_String);
  }
  public void testItem_0473()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-9223372036854775777")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775776")).add(new BigDecimal("0"));
    Assert.assertEquals("-9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775776")).negate();
    Assert.assertEquals("9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0481()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0482()
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
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '8', '8', '\234', '8', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\0', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '8', '\1', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '8', '\uFFFF', '\1', '\234', '\234', '\0', '\234'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
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
  public void testItem_0485()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0486()
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
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).add(new BigDecimal("32"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775776")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0489()
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
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\0', '\234', '\0', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '8', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\uFFFF', '8', '\234', '\234', '\234', '8', '\0', '\1', '\234', '\234', '\1', '\0', '\1', '\uFFFF'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).subtract(new BigDecimal("32"));
    Assert.assertEquals("9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9223372036854775776")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0493()
  {
    rc_int = (new BigDecimal("9223372036854775776")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0494()
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
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).subtract(new BigDecimal("9223372036854775776"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775776")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("9223372036854775776"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775776", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).divide(new BigDecimal("9223372036854775776"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("75;NN<N?3NK5XGI4IXRU623@Y92U7AI5PM7K1M");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0509()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9223372036854775776")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0510()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\1', '8', '\0', '\234', '\uFFFF', '\0', '\234', '\0', '8', '8', '\1', '\1', '\0', '\0', '\1', '\0', '\1', '\0', '8', '\1', '\234', '8', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\1', '\0', '8', '\234', '\1', '\234', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '\0', '\0', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0512()
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
  public void testItem_0513()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0514()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0516()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0517()
  {
    rc_String = (new BigDecimal("9223372036854775776")).toPlainString();
    Assert.assertEquals("9223372036854775776", rc_String);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775776")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775776")).toBigIntegerExact();
    Assert.assertEquals("9223372036854775776", rc_BigInteger.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775776")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0527()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("1"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0528()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0529()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9E+18"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).movePointLeft(2147483647);
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
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
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2OCS:<EJ=TFK?BBSGS;0KW=>UC", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\1', '8', '\0', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\0', '8', '\234', '\uFFFF', '8', '\0', '\0', '\1', '\1', '8', '\234', '8', '8', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0541()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("9E-2147483629"), java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9E-2147483629")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0551()
  {
    rc_int = (new BigDecimal("9E-2147483629")).scale();
    Assert.assertEquals(2147483629, rc_int);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '8', '\1', '\uFFFF', '\0', '8', '\234'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0554()
  {
    rc_BigDecimal_array = (new BigDecimal("9E-2147483629")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("9E-2147483629"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0557()
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
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0559()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("9E-2147483629")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0560()
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
  public void testItem_0561()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("9E-2147483629"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0566()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\234', '8', '\0', '\0', '8', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("3E-2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0571()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).max(new BigDecimal("9E-2147483629"));
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
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
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
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
  public void testItem_0582()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9E-2147483629"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0583()
  {
    rc_BigDecimal_array = (new BigDecimal("9E-2147483629")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0584()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).stripTrailingZeros();
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '8', '\0', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0591()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).stripTrailingZeros();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0595()
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
  public void testItem_0596()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0597()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("9E-2147483629"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).subtract(new BigDecimal("3E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).divideToIntegralValue(new BigDecimal("3E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2E+9")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("2E+9"));
    Assert.assertEquals("2000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0604()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0605()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("84;3N6UW9AX8HIX@JH4<9LGJLXBHLMVLNRT<BNN5V8R>IGPW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0608()
  {
    rc_BigInteger = (new BigDecimal("0E+2")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\1', '\1'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0611()
  {
    rc_BigInteger = (new BigDecimal("9E-2147483629")).unscaledValue();
    Assert.assertEquals("9", rc_BigInteger.toString());
  }
  public void testItem_0612()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0613()
  {
    rc_BigInteger = (new BigDecimal("2000000000")).toBigIntegerExact();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  public void testItem_0614()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_String = (new BigDecimal("9E-2147483629")).toEngineeringString();
    Assert.assertEquals("900E-2147483631", rc_String);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("2000000000")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2000000000", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_String = (new BigDecimal("-2000000000")).toPlainString();
    Assert.assertEquals("-2000000000", rc_String);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).stripTrailingZeros();
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).add(new BigDecimal("3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).min(new BigDecimal("-2000000000"));
    Assert.assertEquals("-2000000000", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("6E+2")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("600.0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("6E+2")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("600", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("600.0")).divideToIntegralValue(new BigDecimal("600.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E-2147483629")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).setScale(0, 1);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).round(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0628()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("9E-2147483629")).toPlainString();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("600.0")).divide(new BigDecimal("3E+2"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\0', '\1', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\234', '\1', '8', '\234', '\uFFFF', '8', '\1', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\234', '8', '\0'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0632()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("9E-2147483629")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0633()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0634()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E-2147483629")).add(new BigDecimal("3E+2"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0635()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6E+2")).hashCode();
//    Assert.assertEquals(184, rc_int);
//  }
  public void testItem_0636()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0637()
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
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9E-2147483629"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+2147483628", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483628")).scaleByPowerOfTen(-1);
    Assert.assertEquals("1E+2147483627", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).ulp();
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
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
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0645()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0646()
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
  public void testItem_0647()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("1E+2147483628")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483628")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+2147483628", rc_BigDecimal.toString());
  }
//  public void testItem_0650()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("1E-2147483629")).toPlainString();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0651()
  {
    rc_String = (new BigDecimal("1E-2147483629")).toEngineeringString();
    Assert.assertEquals("100E-2147483631", rc_String);
  }
//  public void testItem_0652()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+2147483628")).divide(new BigDecimal("1E+2147483627"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).scaleByPowerOfTen(0);
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\uFFFF', '\234', '\0', '8', '\234', '\0', '\234', '\1', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\0', '8', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '8', '\234', '\0', '8', '\234', '\0', '8', '8', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\0', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1E+2147483628")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0657()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1E-2147483629")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0658()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_float = (new BigDecimal("1E+2147483627")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).max(new BigDecimal("1E+2147483627"));
    Assert.assertEquals("1E+2147483627", rc_BigDecimal.toString());
  }
//  public void testItem_0663()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1E+2147483627")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
//  public void testItem_0665()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E-2147483629")).hashCode();
//    Assert.assertEquals(-2147483636, rc_int);
//  }
  public void testItem_0666()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0667()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1E-2147483629"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0668()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0670()
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
  public void testItem_0671()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).movePointLeft(1);
    Assert.assertEquals("1E-2147483630", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).subtract(new BigDecimal("1E-2147483629"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("1E-2147483630")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483630")).movePointLeft(-1);
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483629")).add(new BigDecimal("0E-2147483629"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483629")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0681()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483629")).add(new BigDecimal("-1"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0683()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\0', '\234', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF'}, 1, 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0687()
  {
    rc_boolean = (new BigDecimal("1E-2147483629")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483629")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0692()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("0SM:MAE2KK@@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).add(new BigDecimal("0E-2147483629"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).stripTrailingZeros();
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).remainder(new BigDecimal("1E-2147483629"), new MathContext("precision=0 roundingMode=DOWN"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).remainder(new BigDecimal("1"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0700()
  {
    rc_boolean = (new BigDecimal("0E-2147483629")).equals("ICHKU5VMVKCMN>BW<EXBCOXJ9QY0XC99AHLDUBG366Q;R4XMAM3GA?3?04Y9VUIA=LRW6>?T9ANTNSE?<:=:?5EDDNF<AX;JQBAO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0701()
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
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0704()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483629")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483629")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483629")).ulp();
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\234', '8', '\0', '\0', '\1', '8', '\234', '\uFFFF', '8', '\0', '8', '\234', '\1', '\234', '\0', '\0', '\234', '8', '\uFFFF', '8', '\234', '8', '\0', '\0', '\0', '\0', '\1', '\1', '\234', '8', '\1', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '8', '8', '\0', '\234', '\1', '\1', '\1', '8', '8', '8', '\234', '\0', '\0', '8', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '8', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\234', '\1', '\1', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '8', '8'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0714()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).unscaledValue();
    Assert.assertEquals("4940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
//  public void testItem_0715()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E-2147483629"), -2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
//  public void testItem_0717()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("1E-2147483629")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).negate();
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483629")).multiply(new BigDecimal("-1E-2147483629"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).add(new BigDecimal("-1E-2147483629"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).stripTrailingZeros();
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483629")).negate();
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
//  public void testItem_0730()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1E-2147483629")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_String = (new BigDecimal("-1E-2147483629")).toString();
    Assert.assertEquals("-1E-2147483629", rc_String);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
//  public void testItem_0734()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).add(new BigDecimal("1E-2147483629"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0737()
  {
    rc_int = (new BigDecimal("0E-2147483629")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0738()
  {
    rc_String = (new BigDecimal("-1E-2147483629")).toString();
    Assert.assertEquals("-1E-2147483629", rc_String);
  }
//  public void testItem_0739()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("1E-2147483629")).toPlainString();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0740()
  {
    rc_long = (new BigDecimal("0E-2147483629")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0741()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483646")).setScale(2147483647, 1);
    Assert.assertEquals("1.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_float = (new BigDecimal("-0.1")).floatValue();
    Assert.assertEquals(-0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1E-2147483629"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("-1E-2147483629")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483629")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483629")).remainder(new BigDecimal("-0.1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_int = (new BigDecimal("-0.1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0759()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_byte = (new BigDecimal("0E+2147483629")).byteValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0760()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
//  public void testItem_0761()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483629")).divide(new BigDecimal("-0.1"), 1, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483629")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1E+2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483629")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_int = (new BigDecimal("0E+2147483629")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).subtract(new BigDecimal("-0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0770()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0E+2147483629"), 2147483647, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0773()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+2147483629")).divideAndRemainder(new BigDecimal("8"), new MathContext("precision=0 roundingMode=DOWN"));
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_String = (new BigDecimal("8")).toString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0777()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0778()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toPlainString();
    Assert.assertEquals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_String);
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("D32PSGX:G>H444=6:LANKWURBA5RCNW6YJCRPP;7BPUN?VG17J9?<98@C4U41IH3M>91O5OKKVBWR02L=XN4JSVU97T6T@8<0:FO");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0786()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).unscaledValue();
    Assert.assertEquals("4940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
  public void testItem_0787()
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
  public void testItem_0788()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_int = (new BigDecimal("8")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0790()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("8"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-8"), java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0797()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-8")).hashCode();
//    Assert.assertEquals(-248, rc_int);
//  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("-8")).divide(new BigDecimal("3E+1"), 0, 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_long = (new BigDecimal("-8")).longValue();
    Assert.assertEquals(-8L, rc_long);
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0802()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0803()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0808()
  {
    rc_float = (new BigDecimal("0.0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0815()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\1', '8', '8', '\1', '8', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '8', '8', '\1', '\0', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '8', '\1', '\0', '\1', '8', '\0', '\234', '\0', '\1', '8', '\234', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\0', '\0', '\0'}, 0, 0, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0817()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6?1X4M=AK11YCNADDN0I1><G5WAX6PIQX<9", new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0821()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0822()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, 1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0827()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0832()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("32"), 0, 0);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '\0', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\234', '\0', '\234', '\234', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\0', '8', '\0', '\234', '\0', '8', '\1', '8', '8', '8', '\0', '\uFFFF', '\234', '\234', '8', '\234', '\234', '8', '8', '8', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\234', '8', '\0', '8', '8', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\0', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\0', '\0', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0834()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0836()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '\1', '\0', '\234', '\234', '\234', '\1', '\234', '\0', '8', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '8', '\1', '8', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '8', '\0', '\0', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\0'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0838()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toString();
//    Assert.assertEquals("0E+2147483648", rc_String);
//  }
  public void testItem_0839()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0840()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0844()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0845()
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
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0850()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("-32"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0851()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0852()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\1', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\0', '8', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\0'}, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0853()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("-32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0855()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("32"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0856()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0858()
  {
    rc_boolean = (new BigDecimal("00.0E+2147483647")).equals("PEVWH8GTB98UHFR");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0859()
  {
    rc_BigInteger = (new BigDecimal("-32")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0860()
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
  public void testItem_0861()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0862()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
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
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
//  public void testItem_0866()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+3")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0870()
  {
    rc_int = (new BigDecimal("1E+3")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0872()
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
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\0', '\0', '\0', '8', '8', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\1', '8', '\0', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\0', '\1', '\0'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0875()
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
  public void testItem_0876()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E-2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0881()
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
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).min(new BigDecimal("1"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0886()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
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
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_int = (new BigDecimal("2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0894()
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
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0897()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0898()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_long = (new BigDecimal("2")).longValueExact();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0902()
  {
    rc_float = (new BigDecimal("-2147483648")).floatValue();
    Assert.assertEquals(-2.147483648E9F, rc_float, 0);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0906()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0907()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0908()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0909()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-2"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_short = (new BigDecimal("-2")).shortValueExact();
    Assert.assertEquals(-2, rc_short);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_int = (new BigDecimal("-2")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0916()
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
  public void testItem_0917()
  {
    rc_byte = (new BigDecimal("-2")).byteValueExact();
    Assert.assertEquals(-2, rc_byte);
  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\234', '\0', '8', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\0', '\234', '\234', '8', '\234', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '\0', '\0', '\1', '\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0919()
  {
    rc_String = (new BigDecimal("-2")).toString();
    Assert.assertEquals("-2", rc_String);
  }
//  public void testItem_0920()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2")).hashCode();
//    Assert.assertEquals(-62, rc_int);
//  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_long = (new BigDecimal("-2")).longValue();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0923()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BK76N:GAT@RG2HA9COULAF=5D538L19Y65MA80W0>J?UM71<@::U=2><U=:LF@X220K2S5SH2FLUYG<35Y4O?5S6J54RNBR?2?E1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0924()
  {
    rc_float = (new BigDecimal("-2")).floatValue();
    Assert.assertEquals(-2.0F, rc_float, 0);
  }
  public void testItem_0925()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("-2")).remainder(new BigDecimal("-2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0933()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
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
  public void testItem_0938()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-2")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F40?B>GAGNH2RY=V7Y?;M4FWXVO?A3UO;A9HI9OT6FPFTJ;FDYKNK53I>;T5LQAF>T8S4=PAJ73:33H2M0C7BJ7E@XE9EHE>VL2O", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).min(new BigDecimal("-2"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0947()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0952()
  {
    rc_boolean = (new BigDecimal("-2")).equals("61BJQY@0>II@1LTJWH6SRKN8K:7B;TOE>R:E9TYFO8G<CDACUFMO<LY6QMQ;PMWJJI");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0953()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\0', '8', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '\0', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\0', '8', '8', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0957()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("2E+9"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("4E-324", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).toBigInteger();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  public void testItem_0965()
  {
    rc_String = (new BigDecimal("-1E+12")).toPlainString();
    Assert.assertEquals("-1000000000000", rc_String);
  }
  public void testItem_0966()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\uFFFF', '\1', '8', '8', '\234', '8', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\234', '8', '8', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\234', '8', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '\uFFFF'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).movePointRight(0);  
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	Assert.assertEquals("0E+12", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("0", rc_BigDecimal.toString());
    }
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\234', '\234', '\234', '\234', '8', '\234', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\234', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0979()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).ulp();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0985()
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
  public void testItem_0986()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0987()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("1E+12"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404027184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0992()
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
  public void testItem_0993()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0994()
  {
    rc_float = (new BigDecimal("3.2E+2")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QU<XK9S>?AMFISCQR9WWH9X@JV:OX6;@>:>17F7<E1<>?7EMBQ@3T?<D?K>DVD@ALF:D22X:9XCXCHV<;U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404027184124858368"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_String = (new BigDecimal("1E+12")).toEngineeringString();
    Assert.assertEquals("1E+12", rc_String);
  }
}
