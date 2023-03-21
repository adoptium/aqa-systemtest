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
public class TestSuite041 extends TestCase
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
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\234', '8', '\0', '\1', '\0', '8', '8', '\1', '8', '\1', '8', '\234', '8', '8', '\uFFFF', '\234', '\234'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0002()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0003()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\234', '8', '8', '8', '\uFFFF', '\234', '8', '8', '\0', '8', '\1', '\0', '\234', '\0', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '8', '\1', '\0', '8', '\0', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\1', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0007()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0009()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0012()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
  }
//  public void testItem_0015()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0022()
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
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0027()
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
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0031()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0035()
  {
    rc_boolean = (new BigDecimal("32")).equals("0NC8?MVV2:PL8<?>O4NR7GI96;:W4U;>FHR=ESD;S5XL??IB<O<>T:;2RL;P>2G?1;L9LDN>WE:8DRFB?V9AIN4UIW?7VF8F@VW2");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NU5A0<>KO=TE9FK1NAT;IXIMM60JPHALHX?674VHV1<=G6RHB1?YNI10H0@9?3M?K8T5173W=FSRDIT8HJ;?9TO82II2DYO2PNE6", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("M;;0<H4@TMJ>=AUD<N=TFU@GL?M27Y>@YUKYGVJCWGLPARBJF4NKVOL8=FPCV;:P;5JEFEVP3P345X2R<L3G35?=LN7GK6;WG@9M");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0045()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0046()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<Y@OTE0I0<IXR7;:?U2WQ7@HMDQUF6R7I>BFDMMV2VCT3L:7;O@L8HRNEAD>KF52QBQJ:>SL>KV:H;9DB0V5V");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
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
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(2147483647);
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32.0"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0061()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0063()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0064()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0069()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0070()
  {
    rc_float = (new BigDecimal("0.03125")).floatValue();
    Assert.assertEquals(0.03125F, rc_float, 0);
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_int = (new BigDecimal("4E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '8', '\234', '8', '8', '\uFFFF', '8', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '8', '8', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\0', '\0', '\234', '\0', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\0', '\0'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\1'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0081()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0082()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0084()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0086()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=CEILING"));
//    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("4E-2147483647"));
    Assert.assertEquals("-3.6893488147419103232E-2147483628", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0094()
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
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483647")).plus();
    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483647")).add(new BigDecimal("4E-2147483647"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("8E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).abs();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0100()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("9223372036854775808")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0101()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775808")).toBigInteger();
    Assert.assertEquals("9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0102()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8E-2147483647")).divide(new BigDecimal("9223372036854775808"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0104()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0109()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '8', '\234', '\0', '\0', '8', '\1', '\234', '\1', '\1', '8', '\234', '\0', '\234', '\0', '8', '\234', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '8', '\1', '\0', '\234', '\0', '\0', '\234', '8', '\uFFFF'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).setScale(1);
    Assert.assertEquals("9223372036854775808.0", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("9223372036854775808.0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("8E-2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MBB>4FKO<MAE2C5Y=5@LCX1TYD<<XOX>QW9O30QVE8CKJHLJ>BXG9PO36P0=TETV>F<EOF;8RAJS05A7@UT<;D@7WMI;G<0UVER4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0118()
  {
    rc_String = (new BigDecimal("8E-2147483647")).toString();
    Assert.assertEquals("8E-2147483647", rc_String);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0120()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("8E-2147483647"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(0, 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0126()
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
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0129()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0130()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0133()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0139()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0140()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0143()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0144()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0145()
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
  public void testItem_0146()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0150()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0151()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0152()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3E+9"));
    Assert.assertEquals("-2999999968", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+8", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '\1', '\234', '\1', '\1', '8', '\234', '8', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '8', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '8'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    rc_int = (new BigDecimal("0E-2147483646")).compareTo(new BigDecimal("8"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("T8AN=5<46AQJAKDHW335AYH==AITTEOMUIF3TG87QI0DPWD77644I4X8YFAVGYE3EGNTQD6E:2=WO>TI0B72YDNQX4R04JE58WLW", new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_long = (new BigDecimal("8")).longValueExact();
    Assert.assertEquals(8L, rc_long);
  }
  public void testItem_0173()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("8")).movePointRight(1);
    Assert.assertEquals("80", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1135879015891.0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0180()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0181()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("8"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("80")).negate();
    Assert.assertEquals("-80", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("80")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_short = (new BigDecimal("-80")).shortValueExact();
    Assert.assertEquals(-80, rc_short);
  }
  public void testItem_0185()
  {
    rc_byte = (new BigDecimal("80")).byteValueExact();
    Assert.assertEquals(80, rc_byte);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-80")).pow(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("1"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("8"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_int = (new BigDecimal("80")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-1"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0196()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0197()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("80")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("81", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0201()
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
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0204()
  {
    rc_byte = (new BigDecimal("80")).byteValueExact();
    Assert.assertEquals(80, rc_byte);
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_float = (new BigDecimal("80")).floatValue();
    Assert.assertEquals(80.0F, rc_float, 0);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-9.6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_int = (new BigDecimal("-9.6E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0210()
  {
    rc_BigInteger = (new BigDecimal("81")).toBigInteger();
    Assert.assertEquals("81", rc_BigInteger.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-9.6E+2"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-928", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0222()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\0', '\234', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '8', '\uFFFF', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '8', '\234', '8', '\uFFFF', '\0', '\1', '8', '\1', '\1', '\0', '8', '\0', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '8'}, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F=L91J5QNC4ARUM1<Q<=FTQNE1?54:@Q8MNAF3@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0224()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-928")).hashCode();
//    Assert.assertEquals(-28768, rc_int);
//  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-928"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0229()
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
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-928"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("3.2E-2147483646"), 2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0237()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3.2E-2147483646")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(-1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0253()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0254()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_int = (new BigDecimal("0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).setScale(-2147483648, 1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0258()
  {
    rc_int = (new BigDecimal("0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_long = (new BigDecimal("0E+2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0262()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0263()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0264()
  {
    rc_long = (new BigDecimal("0E+2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0266()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0269()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigInteger = (new BigDecimal("-0.1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_float = (new BigDecimal("-0.1")).floatValue();
    Assert.assertEquals(-0.10000000149011612F, rc_float, 0);
  }
//  public void testItem_0276()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0277()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0278()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).movePointLeft(-1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0279()
  {
    rc_int = (new BigDecimal("-0.1")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).movePointRight(-1);
    Assert.assertEquals("-0.01", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_int = (new BigDecimal("-0.1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_int = (new BigDecimal("-0.1")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0285()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\0', '\uFFFF', '8', '\0', '8', '\0', '\1', '8', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\0', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\1', '\234', '\0', '\234', '\234', '8', '\1', '8', '\1', '8', '\0', '8', '\uFFFF', '8', '\1', '\1', '\0', '\234', '\234', '8', '\1', '\1', '8', '\234', '8', '8', '\234', '\234'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0287()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0291()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValueExact();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0292()
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
  public void testItem_0293()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0294()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\234', '8', '\1', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '8', '\234', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '8', '\1', '\1', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '8', '8', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\0', '8', '8', '\1', '\0', '\uFFFF', '8', '\234', '8', '\0', '\234', '8', '\1', '\234', '\0', '\234', '\1'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(1, 1);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_int = (new BigDecimal("-0.1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '8', '8', '\0', '\1', '\1', '\0', '\234', '\1', '8', '\0', '8', '\234', '\uFFFF', '8', '\234', '\1', '\234', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).stripTrailingZeros();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0299()
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
  public void testItem_0300()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807.0")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("2147483647"));
    Assert.assertEquals("4294967298", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0303()
  {
    rc_int = (new BigDecimal("9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).negate();
    Assert.assertEquals("-9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("4294967298")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
//  public void testItem_0309()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0310()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0311()
  {
    rc_long = (new BigDecimal("2")).longValue();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).min(new BigDecimal("-1"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("2"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1073741824", rc_BigDecimal.toString());
  }
  public void testItem_0316()
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
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\1', '\0', '8', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\0', '8', '\1', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\1', '\1', '\1', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '8'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("2"));
    Assert.assertEquals("-18446744073709551616", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0320()
  {
    rc_boolean = (new BigDecimal("-18446744073709551616")).equals("R@G1JMA@1@7QFFG=6433A0>SQ0RHCT4V:KIW5LR;IL<9UTB8JAAMR7JQEJJ1R3E89WN@S?NLCOB@BKEID@WD5KTJ1MD9;<95=UTV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigInteger = (new BigDecimal("-1073741824")).toBigInteger();
    Assert.assertEquals("-1073741824", rc_BigInteger.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_long = (new BigDecimal("2147483647")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
//  public void testItem_0326()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2147483679", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0329()
  {
    rc_float = (new BigDecimal("2147483679")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0330()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\1', '\234', '\1', '8', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '\0', '\234', '\0', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '8', '8', '\1', '\0', '\uFFFF', '\234', '8', '\234', '\1', '8', '8', '8', '\uFFFF', '8', '8', '8', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0332()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0333()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0334()
  {
    rc_double = (new BigDecimal("2147483679")).doubleValue();
    Assert.assertEquals(2.147483679E9, rc_double, 0);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("2147483679")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigInteger = (new BigDecimal("2147483679")).toBigInteger();
    Assert.assertEquals("2147483679", rc_BigInteger.toString());
  }
  public void testItem_0337()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0338()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0339()
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
  public void testItem_0340()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0341()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483679")).divide(new BigDecimal("2147483679"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0345()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2147483679"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483648"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\1', '\0', '\1', '\1', '\1', '\1', '8', '8', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\0', '\234', '\0', '\0', '\234', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '\1', '8', '8', '\1', '8', '8', '\1', '\0', '8', '8', '\uFFFF', '\234', '\234', '8', '\1', '8', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\1'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("32"));
    Assert.assertEquals("-68719476736", rc_BigDecimal.toString());
  }
  public void testItem_0353()
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
  public void testItem_0354()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0355()
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
  public void testItem_0356()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0359()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-68719476736"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal_array = (new BigDecimal("-68719476736")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("10"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("10"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("11", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("32"), 0, 0);
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";YFKFDL2ALYI?KNC0T9R1RY84@1TWM7SDQ49>TQ1:7>V3Q70IWS<UCTGXWJN9=7YSM6AU?EP3>KXYS<1CI4L79ID2RJ:D8564;TM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).divide(new BigDecimal("1"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("174151522439786834226573441740088595648130862290662340455201305653058596380652646924321134925492913228679819611217058012226998785424168427056952935869051969580235850871034054511362818525064662414573497617565911006607565010749997231035627041852994493641210394135265200569715109144015571759961328900365870956544", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("H64EMSM8YT2DYOJDHF1PQ1BM55:AJ67CATCS2S7S77UYDD9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0381()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0385()
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
  public void testItem_0386()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).stripTrailingZeros();
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).movePointLeft(2147483647);
    Assert.assertEquals("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E-2147483341", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E-2147483341"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E-2147483341")).movePointLeft(1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0395()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0396()
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
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("5.617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824E-2147483341")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0398()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YA>LA6FF00YCPEWUQ7G6GDEKT7A9X8FW>?V:LBBYRL<X6OUSVPW6H6;F;BEK2?3@O61N9LD31OQC9<80DR79SQYIEK;3>XBDR:HX", new MathContext("precision=1 roundingMode=UNNECESSARY"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '8', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\0', '8', '\1', '\1', '\0', '\1', '\1', '\1', '\1', '\234', '\0', '\0', '8', '8', '\0', '\0', '\1', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\234', '8', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0400()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).setScale(1, 0);
    Assert.assertEquals("10.0", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("1E+1", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("10", rc_BigDecimal.toString());
    }
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\234', '8', '\1', '8', '\1', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\1', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0416()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(-2147483648);
//    Assert.assertEquals("32", rc_BigDecimal.toString());
//  }
  public void testItem_0417()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0419()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0420()
  {
    rc_boolean = (new BigDecimal("0")).equals("JJIPNH1:@B>01VO7CTOS399HSEMIJ@BW6HLD832=RE2CJX??KJPTABM6NLHX9=458B3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("10.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("10.0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("1.00", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\234', '8', '\0', '\1', '\0', '\234', '8', '8', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '8', '8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '8', '8', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '8', '8', '8', '8', '8', '\1', '\1', '8', '8', '\1', '\234', '8', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '8', '\1', '8', '\1', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0431()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0432()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0433()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.00")).hashCode();
//    Assert.assertEquals(3102, rc_int);
//  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '8', '\234', '\234', '\0', '\0', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\0', '\0', '\0', '8', '\1', '8', '\uFFFF', '\0', '8', '\0', '\1', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\234', '\234', '\0', '8', '\uFFFF', '\0', '\1', '\0', '8', '8', '\0', '8', '\1', '\234', '\234', '\0', '8', '8', '\0', '\0', '\0', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '\1', '\0', '\234', '8', '\0', '\0', '\234', '8', '\0', '\234', '\234'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CAS<;D50?IB34M916H8LS8G8F9TRY0XF;>T??4NKE", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0437()
  {
    rc_String = (new BigDecimal("1.00")).toPlainString();
    Assert.assertEquals("1.00", rc_String);
  }
  public void testItem_0438()
  {
    rc_BigInteger = (new BigDecimal("8")).unscaledValue();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigInteger = (new BigDecimal("1.00")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0444()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0445()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.00")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0446()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("645QL4UEKLXRFI@RT33209SBDXSOSO<XLFK6GO3>;GLME>7:N;TI9SN?:8X70?8:S2=2MWLQ@KLHGCV");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0447()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("1.00"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(0);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0452()
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
  public void testItem_0453()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0456()
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
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0460()
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
  public void testItem_0461()
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
  public void testItem_0462()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 1, 0);
    Assert.assertEquals("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0467()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0468()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0470()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0471()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0474()
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
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0478()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0479()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0481()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0484()
  {
    rc_int = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-3.2"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EC4M5T;X5", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigInteger = (new BigDecimal("-3.2")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).movePointLeft(0);
    Assert.assertEquals("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_double = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).max(new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0"));
    Assert.assertEquals("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-3.2"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).negate();
    Assert.assertEquals("-6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigIntegerExact();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0506()
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
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).min(new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0"));
    Assert.assertEquals("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).negate();
    Assert.assertEquals("-6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0510()
  {
    rc_boolean = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0511()
  {
    rc_String = (new BigDecimal("1135879015891")).toEngineeringString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '8', '8', '\0', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '\0', '\0', '8', '8', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\1', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '8', '8', '8', '\uFFFF', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\1', '8', '8'}, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).divide(new BigDecimal("8"), -2147483648, java.math.RoundingMode.HALF_EVEN);
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
      rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0515()
  {
    rc_int = (new BigDecimal("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088.0")).compareTo(new BigDecimal("8"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0518()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_long = (new BigDecimal("1135879015891")).longValue();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0524()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0525()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).pow(-1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("1135879015891"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0528()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0531()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0532()
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
  public void testItem_0533()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).toBigIntegerExact();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-33")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal_array = (new BigDecimal("33")).divideAndRemainder(new BigDecimal("1135879015891"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0539()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '8', '\uFFFF', '\0', '\1', '\1', '\234', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '8', '8', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '8', '8', '\234', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '8', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("33"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("37484007524403", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).toBigIntegerExact();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0543()
  {
    rc_int = (new BigDecimal("33")).intValueExact();
    Assert.assertEquals(33, rc_int);
  }
//  public void testItem_0544()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-33"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0545()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0546()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0547()
  {
    rc_int = (new BigDecimal("33")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0548()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\0', '\1', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\234', '\234', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '8', '8', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\0', '8', '\234', '\1', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0549()
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
  public void testItem_0550()
  {
    rc_String = (new BigDecimal("37484007524403")).toString();
    Assert.assertEquals("37484007524403", rc_String);
  }
  public void testItem_0551()
  {
    rc_long = (new BigDecimal("37484007524403")).longValue();
    Assert.assertEquals(37484007524403L, rc_long);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("33"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(1);
    Assert.assertEquals("1.135879015891E+13", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("37484007524403")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("33")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.3", rc_BigDecimal.toString());
  }
//  public void testItem_0556()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("37484007524403")).hashCode();
//    Assert.assertEquals(839710340, rc_int);
//  }
  public void testItem_0557()
  {
    rc_long = (new BigDecimal("1.135879015891E+13")).longValue();
    Assert.assertEquals(11358790158910L, rc_long);
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_int = (new BigDecimal("1.135879015891E+13")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0560()
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
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("37484007524403")).plus();
    Assert.assertEquals("37484007524403", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_float = (new BigDecimal("37484007524403")).floatValue();
    Assert.assertEquals(3.7484008308736E13F, rc_float, 0);
  }
  public void testItem_0565()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0569()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("37484007524403")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3.3"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0571()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3.3"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("3.3"));
    Assert.assertEquals("3.3", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\uFFFF', '\0', '\234', '8', '8', '8', '\234', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '\0', '\0', '8', '\0', '\234', '\0', '\1', '8', '8', '\1', '\1', '\0', '\0', '\234', '\0', '\0', '\1', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal_array = (new BigDecimal("320")).divideAndRemainder(new BigDecimal("3.3"));
  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.3")).subtract(new BigDecimal("320"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("37484007524403")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("37484007524403", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_int = (new BigDecimal("37484007524403")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0584()
  {
    rc_int = (new BigDecimal("320")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0585()
  {
    rc_int = (new BigDecimal("320")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0586()
  {
    rc_long = (new BigDecimal("320")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '8', '\234', '\1', '\234', '8', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\1', '\0', '8', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '8', '8', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\1', '\0', '\1', '\0', '8', '\1', '\0', '8', '8', '8', '\0', '\234', '\1', '\uFFFF', '8', '\1', '\0', '\234', '\0', '8', '\1', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\0', '\234', '\1', '\234', '\234'}, 0, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0PYGFTV12B;393XIC@B>9D9ST9U89<NLVHKUA8E:PR>CIKX7RKIE97POKEO7;>FMWRYN:133Y6GH;93XX", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I;P5SFG=6CWRGSMI;:Q@5OX;AIJIKVE7BLO5TW822BEF3D>TPG336VSR<G?4PS8?5UCY0LRAN2U=SP8GF16D0L=5J6U4:3T7>VM=", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("3.3")).divide(new BigDecimal("3.3"), 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_String = (new BigDecimal("1.0")).toString();
    Assert.assertEquals("1.0", rc_String);
  }
  public void testItem_0592()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\0', '\uFFFF', '\0', '\234', '\0', '\1', '\0', '8', '8', '\1', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\1', '\1', '\1', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\0', '8', '\0', '8', '\0', '\uFFFF', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0594()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("37484007524403")).divide(new BigDecimal("1"));
    Assert.assertEquals("37484007524403", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("37484007524403"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_double = (new BigDecimal("37484007524403")).doubleValue();
    Assert.assertEquals(3.7484007524403E13, rc_double, 0);
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\0', '\uFFFF', '\234', '\0', '8', '8', '\234', '8', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '8', '\234', '8', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\0', '8', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '8', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0599()
  {
    rc_BigDecimal_array = (new BigDecimal("3.3")).divideAndRemainder(new BigDecimal("37484007524403"));
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("37484007524403")).negate();
    Assert.assertEquals("-37484007524403", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("00G2MJ33;JF@1L6RU9<=HA4;WMK>D4U6PTCYI?<BLO9BH7KMV;@IQ4H5POEJ=@QNM8QAJ7IEHUD=UJCOP0BIFMB4J?;RO;1:>23?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("3.3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("3.3")).stripTrailingZeros();
    Assert.assertEquals("3.3", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).min(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigInteger = (new BigDecimal("1.0")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("3.3"));
    Assert.assertEquals("3.30", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("3.30"));
    Assert.assertEquals("105.60", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("3.30")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.30", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.30")).intValueExact();
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
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1.0"), 2147483647, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("3.30")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_String = (new BigDecimal("3.30")).toPlainString();
    Assert.assertEquals("3.30", rc_String);
  }
  public void testItem_0614()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("1.0"));
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.3")).divide(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0618()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("3.3")).min(new BigDecimal("32"));
    Assert.assertEquals("3.3", rc_BigDecimal.toString());
  }
//  public void testItem_0620()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0621()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("3.3"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0622()
  {
    rc_int = (new BigDecimal("1.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0623()
  {
    rc_long = (new BigDecimal("1.0")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.3")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("UP9?SAAHP>82QVHRSW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0628()
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
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2241<5;WO7CEFY:2K2NQL?0LTLNQ8J5I7BH5K9O0OBBJBCI12LX3SQ>2::UW25");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("2.14748365E+9", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("2.14748365E+9")).divide(new BigDecimal("1.0"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("2.14748365E+9", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("1.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0636()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2.14748365E+9")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0637()
  {
    rc_int = (new BigDecimal("2.14748365E+9")).intValue();
    Assert.assertEquals(-2147483646, rc_int);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("2.14748365E+9")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2.14748365E+9", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_String = (new BigDecimal("3.2")).toPlainString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0641()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("3.2"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\1', '8', '\234', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '8', '\0', '\1', '8', '\234', '\1', '\1', '\uFFFF', '8', '\0', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\1', '8', '8', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0656()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3.2"));
    Assert.assertEquals("28.8", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\234', '\0', '\1', '8', '\234', '\uFFFF', '8', '\234', '\234', '8', '\0', '\234', '8', '8', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '8', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '8', '\0', '8', '\0', '\0', '\0', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("28.8")).divide(new BigDecimal("32"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0663()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0666()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '8', '\234', '\234', '\234', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\0', '\234', '\234', '\0', '\234', '\0', '\0', '\0', '8', '\0', '8', '\1'}, -2147483648, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0671()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0672()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0675()
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
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0678()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0679()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0680()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0686()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0687()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0690()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0691()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0692()
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
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0694()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0695()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0696()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0697()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '\1', '8', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '8', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF'}, 1, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0700()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0701()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0704()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0705()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0706()
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
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0709()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0710()
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
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0713()
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
  public void testItem_0714()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\234', '\0', '\1', '\234', '\0', '8', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '8', '\0', '8', '\234', '8', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '8', '\1', '\1', '\234', '\uFFFF', '8', '\234', '8', '\0', '\0', '\0', '\234', '\1', '\0', '\234', '\1', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\0', '8', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '8', '\234', '\1', '8', '\0', '\1', '8'}, -1, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0720()
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
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0723()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '8', '8', '\0', '\1', '\234', '\1', '\234', '8', '\1', '\1', '\1', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '8', '8', '\234', '\1', '\1', '\0', '\1', '\234', '\234', '\234', '8', '\0', '\0', '\0', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0'}, -2147483648, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3DEIPWV5GJLQVLBMMM8YC<0R3;3U9AL@<AGUCP1I;=VJ;57QL8TPXOR4TRH48T=DJ0T?E?FKE>N6KNFEPJ2<YE0?2CY2XBYXLKG=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0730()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0731()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0735()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0736()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0741()
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
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\1', '8', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '8', '\0', '\0', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '\234', '\234', '\1', '8', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '8', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\0'}, -2147483648, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toEngineeringString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0752()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("64")).divide(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0753()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("64")).min(new BigDecimal("64"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("64")).setScale(1, 1);
    Assert.assertEquals("64.0", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775775", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigInteger = (new BigDecimal("64")).toBigIntegerExact();
    Assert.assertEquals("64", rc_BigInteger.toString());
  }
//  public void testItem_0760()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0761()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0762()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0763()
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
  public void testItem_0764()
  {
    rc_float = (new BigDecimal("64")).floatValue();
    Assert.assertEquals(64.0F, rc_float, 0);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("32"));
    Assert.assertEquals("35.2", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toEngineeringString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("35.2")).multiply(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("324662695697288108406.4", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("35.2"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\234', '\1', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\1', '8', '\0', '\1', '\0', '\1', '\1', '\0', '8', '8', '8', '\0', '8', '\234', '8', '\1', '\1', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '\234', '\1', '8', '8', '\1', '8', '\1', '\234', '\0', '8', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\0', '\234', '8', '\uFFFF', '\uFFFF'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("35.2")).add(new BigDecimal("1"));
    Assert.assertEquals("36.2", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("36.2"));
    Assert.assertEquals("37.2", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0778()
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
  public void testItem_0779()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0780()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0781()
  {
    rc_boolean = (new BigDecimal("32")).equals("UF<VJPCHNQPL5=BO0O82T<?RVEE=SHP@6XKV9GHP;Y<3BBDO58IR<>EH=9N27:1?62AML>=LC1N4G:@SN<T:67E8A2V88VB?TTIO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0782()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0783()
  {
    rc_int = (new BigDecimal("37.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0784()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0785()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("37.2")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("37.2")).divide(new BigDecimal("-32"));
    Assert.assertEquals("-1.1625", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("36.2")).min(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("36.2", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(0, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("36.2"));
    Assert.assertEquals("36.2", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0795()
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
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0798()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("321", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(2147483647);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
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
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).stripTrailingZeros();
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_int = (new BigDecimal("1E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0809()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).remainder(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0810()
  {
    rc_byte = (new BigDecimal("1E+1")).byteValueExact();
    Assert.assertEquals(10, rc_byte);
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0812()
  {
    rc_double = (new BigDecimal("1E+1")).doubleValue();
    Assert.assertEquals(10.0, rc_double, 0);
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0817()
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
  public void testItem_0818()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0822()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483338", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_String = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483338")).toEngineeringString();
    Assert.assertEquals("-179.769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483340", rc_String);
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0827()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("D>1JN8?0P725:3@F;DQH;;C>3A2BJBU>:LYSTTSPA0QWF;2N?77QR3K<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("28<=2S86C>0UA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0830()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0831()
  {
    rc_boolean = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).equals("ME8WVPAGXE7M6>K3>B41TA05GID9C?GJM=9S8>PAK1CU;LWVK?RP7>6LC2TILBJVJREB16F");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0832()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0833()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0835()
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
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '\234', '\0', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '8', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '\1', '8', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '8', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '\1', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\234', '\0'}, -1, 1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).plus();
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0845()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '8', '8', '\1', '\234', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\234', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0847()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0848()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0850()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0851()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '8', '\1', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '8', '8', '\234', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '8', '\234', '\1', '\1', '\uFFFF', '\234', '8', '\1', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '8', '\234', '8', '\0', '\234', '\1', '8', '\uFFFF', '8', '\234'}, -1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0852()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0853()
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
  public void testItem_0854()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_double = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).doubleValue();
    Assert.assertEquals(-0.0, rc_double, 0);
  }
//  public void testItem_0857()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), -1, java.math.RoundingMode.UP);
//    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
//  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F449<K5A?>VD5F5V7YND@R2LKS>3UFUD:", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0859()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0864()
  {
    rc_boolean = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0867()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0869()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).plus(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0872()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0873()
  {
    rc_int = (new BigDecimal("-2147483648")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0874()
  {
    rc_float = (new BigDecimal("-2147483648")).floatValue();
    Assert.assertEquals(-2.147483648E9F, rc_float, 0);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0E+1"), 0, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0877()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0878()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0879()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0883()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337")).divide(new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337"), 1);
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
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0887()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337")).divide(new BigDecimal("-2147483648"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\1', '\1', '\0', '\234', '\1', '\1', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\1', '\1', '8', '8', '\0', '\uFFFF', '8', '8', '\1', '8', '\234', '\234', '8', '8', '\1', '\0', '\234', '\234', '8', '8', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\1', '8', '8', '8', '\0', '\0', '\234', '8', '\0', '\0', '\234', '\234', '\1', '\234', '8', '\0', '8', '\1', '\1', '8', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '8', '\234', '8'}, 1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0889()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0890()
  {
    rc_int = (new BigDecimal("-5.752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776E-2147483337")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0897()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=UNNECESSARY"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_long = (new BigDecimal("0E-2147483646")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0901()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("0.0E+2147483649", rc_String);
//  }
  public void testItem_0902()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0904()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0906()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0907()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, 0);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal_array = (new BigDecimal("4E+1")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0910()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\0', '\234', '8', '\0', '8', '\0', '\0', '\0', '8', '\1', '\234', '8', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\234', '\234', '\1', '\1', '8', '8', '\1', '\234', '8', '8', '8', '\uFFFF', '8', '\1', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '8', '\234', '8', '8', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '8', '8', '\uFFFF', '\234', '8', '\1', '\1', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0912()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).movePointLeft(-1);
    Assert.assertEquals("0E-2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0914()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-9223372036854775808"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0915()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0916()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0917()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).min(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0922()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0926()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0927()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("00.0E+2147483647"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0932()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0933()
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
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '8', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\1', '\1', '\0', '\234', '\1', '8', '8', '\1', '\1', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\1', '\0', '\234', '8', '\uFFFF', '\0', '8', '\234', '\234', '\1', '\234', '\0', '8', '\1', '\0', '\1', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0936()
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
  public void testItem_0937()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0938()
  {
    rc_int = (new BigDecimal("3.2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("2147483647"));
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("2147483647"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("214748364.7"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_int = (new BigDecimal("3.2")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("214748364.7")).divide(new BigDecimal("3.2"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).pow(1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).divide(new BigDecimal("214748364.7"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_String = (new BigDecimal("1.0")).toString();
    Assert.assertEquals("1.0", rc_String);
  }
//  public void testItem_0953()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1.0")).hashCode();
//    Assert.assertEquals(311, rc_int);
//  }
  public void testItem_0954()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0955()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0957()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).scaleByPowerOfTen(1);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("214748364.7"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0964()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0967()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("214748364.7")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0971()
  {
    rc_BigInteger = (new BigDecimal("1.0")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\1', '8', '\234', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\0', '8', '\0', '\234', '8', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '8', '\1', '\234', '\uFFFF', '8', '8', '\234', '\234', '8', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0974()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0975()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("214748364.7")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0976()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DK6LU2O5V?JF9K5L>I?W@5M2>NYO1PRBOHRYT:=4U4<DJ8R8TX6N8=F2TYKR1CE49A:72OGYSTXGPE>DF6UG<U<USMOK<KX1QE:9");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("214748364.7")).subtract(new BigDecimal("1"));
    Assert.assertEquals("214748363.7", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_long = (new BigDecimal("214748363.7")).longValue();
    Assert.assertEquals(214748363L, rc_long);
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigInteger = (new BigDecimal("0.03125")).unscaledValue();
    Assert.assertEquals("3125", rc_BigInteger.toString());
  }
  public void testItem_0988()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0989()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\234', '8', '\0', '\0', '\uFFFF', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0990()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.03125")).divide(new BigDecimal("0.03125"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0991()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).movePointLeft(-1);
    Assert.assertEquals("0.3125", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0995()
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
  public void testItem_0996()
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
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U<KLOG>M63GD=CQCRF5OO@L98;DCT@0AI3QP4@2CSVRB>@36B5C<3J5L<BJ5PV79FP=YR70KPYNVJNHJ1@8X<PUOA?QXA:X17:XO", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0999()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("214748363.7")).hashCode();
//    Assert.assertEquals(2147483308, rc_int);
//  }
}
