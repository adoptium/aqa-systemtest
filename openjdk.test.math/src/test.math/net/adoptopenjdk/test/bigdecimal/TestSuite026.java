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
public class TestSuite026 extends TestCase
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
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\0', '\234', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\0', '\0', '\1', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '8', '\1', '8', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\234', '\0', '8', '8', '\1', '\1', '\234', '\0', '\0', '8', '\1', '\1', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
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
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("1.290221138741506630523881E-2147483623")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("1.290221138741506630523881E-2147483623", rc_BigDecimal.toString());
  }
//  public void testItem_0003()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.290221138741506630523881E-2147483623")).subtract(new BigDecimal("1135879015891"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0004()
  {
    rc_String = (new BigDecimal("1290221138741506630523881")).toPlainString();
    Assert.assertEquals("1290221138741506630523881", rc_String);
  }
  public void testItem_0005()
  {
    rc_int = (new BigDecimal("161277642342688328815485.125")).scale();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OT19;=QQ3TD8QU4F>N108:NJX=FNFNMHEVJDXYTC2JPMEWNMF?@GIFUAW;YXB9DW22>D5BIQQ5TUJB3H@47JLAVL<3811RF@WA6;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_int = (new BigDecimal("1.290221138741506630523881E-2147483623")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0009()
  {
    rc_float = (new BigDecimal("1290221138741506630523881")).floatValue();
    Assert.assertEquals(1.2902211972082195E24F, rc_float, 0);
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).max(new BigDecimal("2147483647"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("1290221138741506630523881")).stripTrailingZeros();
    Assert.assertEquals("1290221138741506630523881", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\234', '8', '8', '8', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("2147483647"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0014()
  {
    rc_int = (new BigDecimal("2147483647")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_long = (new BigDecimal("1290221138741506630523881")).longValue();
    Assert.assertEquals(517994039461845993L, rc_long);
  }
  public void testItem_0018()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0019()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0021()
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
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointLeft(-1);
    Assert.assertEquals("3200", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0028()
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
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0030()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0031()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I0K:Y5A<A");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0035()
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
  public void testItem_0036()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0.1"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0038()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=4SI0HC98=36NLMKAWEHW3IVW4@=RB<VD6UDHFDUR7EN?BE:6U19SATB51N3AWBRR?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0040()
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
//  public void testItem_0041()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("3.2E-2147483646")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\234', '\234', '\1', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\0', '\1', '8', '8', '\234', '\uFFFF', '8', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\0', '\234', '8', '\0', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '8', '\234', '\1', '8', '8', '\0', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '\1', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '\234'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigInteger();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0046()
  {
    rc_boolean = (new BigDecimal("32")).equals("QL?LB5M?VE>=OS2G7>>PYKT2<ABP48OFNVHVAX?F0CGYQVY6KV<935V7HI=>IGC@27<NXDQFFAVV<J2=OXIHV@=864CA952SI8XU");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.147483647E+2147483656", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0050()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0053()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483647, rc_int);
//  }
  public void testItem_0054()
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
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372039002259454", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0058()
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
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\0', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '8', '8', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '8', '\234', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\0', '\234', '\0', '\234', '8', '\0', '\234', '\0', '\234', '\0', '\1', '8', '\1', '\0', '\1', '\234', '\1', '\1', '\0', '8', '\1', '8', '\uFFFF', '\0', '\0', '8', '8', '\0', '\234', '\1', '8', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\uFFFF', '\1', '8', '\0', '8', '\234', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0061()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647.0E+2147483647")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0062()
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
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '8', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0064()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0069()
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
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\234', '8', '\0', '\1', '8', '8', '8', '\0', '\1', '\uFFFF', '8', '8', '8', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\0', '8', '\234', '\0', '\234', '\uFFFF', '8', '\0', '\1', '\0', '\0', '8', '\0', '\234', '\0', '\0', '\234', '\234', '\0', '\234', '\234', '\1', '\0', '\1', '\234', '\0', '\1', '\234', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0', '8', '\0', '8', '\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '8', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0071()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J510@962QYPS?8>C7H75N37>W:UC03I;GRNP59S1PN9A6?95FNJDC:9ED4F=7U;35;AYBRHTGM95=7M3CD2G3C6DER<1M0:F39QT", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigInteger = (new BigDecimal("-2147483647")).toBigInteger();
    Assert.assertEquals("-2147483647", rc_BigInteger.toString());
  }
  public void testItem_0076()
  {
    rc_String = (new BigDecimal("-2147483646")).toEngineeringString();
    Assert.assertEquals("-2147483646", rc_String);
  }
//  public void testItem_0077()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483647")).hashCode();
//    Assert.assertEquals(-2147483617, rc_int);
//  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("-2147483646")).add(new BigDecimal("-2147483646"));
    Assert.assertEquals("-4294967292", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_int = (new BigDecimal("-2147483646")).scale();
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0080()
  {
    rc_boolean = (new BigDecimal("-4294967292")).equals("72RHHGJ=54X?34RRN8R<?WX31DV5R?P4Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).subtract(new BigDecimal("-4294967292"));
    Assert.assertEquals("2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divideToIntegralValue(new BigDecimal("-2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2147483645")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=COQPV8P4TROQRXTCV;IDR:VS:XRS7NLQ9U@317MI?2T@8YBUP85KVAIAAVA0WCDYOSW=CTP;L7T65H<;MA9W:>FB>7NHED<EI2K", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1.0609978949885705117144445632550356231298636402913102795510726015675347183162029049070121453383892718022297358702472142033429414418721962620828783652689149189601777821806309400611506485053075432332671816493165493341275063746802067039789157235638508997666661403705017238515006667713911332277766673294515374571829472931091372817029586417037121435614677969705506719408696628686764380421773878776873568700216950700237625651794289820868998112187026624138685271707758982904094132557202196209188604809998941344964388684384772795893506049836847950409851073237758981680115344917689272539447810238141808009965510497366640491315341686473773141147356140881921781408044814178605913644069525350835948013163888157296150336506844976173190298052162461317493580281734466552734375E-314", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4294967294", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("2147483647"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_int = (new BigDecimal("4294967294")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0100()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2E+9")).hashCode();
//    Assert.assertEquals(53, rc_int);
//  }
  public void testItem_0101()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).setScale(1);
    Assert.assertEquals("2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0106()
  {
    rc_BigInteger = (new BigDecimal("4294967294")).toBigIntegerExact();
    Assert.assertEquals("4294967294", rc_BigInteger.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).movePointRight(-1);
    Assert.assertEquals("200000000", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4294967294")).divide(new BigDecimal("4294967294"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2000000000.0"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0112()
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
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\uFFFF', '8', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\234', '\1', '\0', '\0', '8', '\1', '\0', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\0', '8', '\1', '\234', '\234', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\234', '\0', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0120()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).hashCode();
//    Assert.assertEquals(1240908815, rc_int);
//  }
  public void testItem_0121()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0122()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0123()
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
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0129()
  {
    rc_double = (new BigDecimal("2E+9")).doubleValue();
    Assert.assertEquals(2.0E9, rc_double, 0);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
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
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 1, 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\0', '\1', '\1', '8', '8', '\234', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\234', '\1', '\234', '\1', '\0', '\234', '\0', '\1', '\1', '\1', '\0', '\0', '8', '\1', '8', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\1', '\0', '\1', '\1', '\234', '\234', '8', '\0', '8', '\uFFFF', '\234', '\234', '8', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '\0'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_int = (new BigDecimal("1.0")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '8', '\1', '\0', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\1', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0138()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\234', '\1', '\0', '\234', '8', '8', '\234', '8', '8', '\1', '\1', '8', '\234', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\234', '\0', '8', '8', '8', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\0', '8', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\1', '\0', '\1', '\0', '\1', '8', '\uFFFF', '\0', '\1', '\0', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0142()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("9223372036854775807"), -2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate();
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("1.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(0, 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("<26356W6G94>8VH3@6L5YT<7E:0:98V24OBGPT095EK;FK5IJHK1KF6:0RDYV9YR>K9L:HJELUUO1UU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0154()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0155()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\0', '\0', '\234', '\0', '8', '8', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '\1', '\1', '\234', '8', '\1', '8', '\0', '\0', '\234', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '8', '\0', '8', '\1', '\234', '\0', '8', '\234', '\0', '\234', '\234', '\1', '8', '\234', '8', '\234', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '8', '\1', '\0', '\234', '8', '\234', '\0', '8', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '8', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\0'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("0.1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("1.0"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("0.0"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0170()
  {
    rc_int = (new BigDecimal("0.1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("-2E+9"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0172()
  {
    rc_long = (new BigDecimal("-3E+1")).longValueExact();
    Assert.assertEquals(-30L, rc_long);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0.1"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigInteger = (new BigDecimal("0.00")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.0"), -1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("-2E+9"));
    Assert.assertEquals("2.00000003E+9", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0183()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0184()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0185()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).movePointLeft(2147483647);
    Assert.assertEquals("-2E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483638")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("-2E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_String = (new BigDecimal("-2E-2147483638")).toEngineeringString();
    Assert.assertEquals("-200E-2147483640", rc_String);
  }
//  public void testItem_0192()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-2E-2147483638")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0193()
  {
    rc_String = (new BigDecimal("-2E-2147483638")).toString();
    Assert.assertEquals("-2E-2147483638", rc_String);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483638")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?02OO4UU6FK1Q@@R12SK@B6VQN8C96E<;3=K2K3RAOJEX2TDG1YDH>5FA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E-2147483638")).divide(new BigDecimal("-2E-2147483638"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("-2E-2147483638")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("-2E-2147483638", rc_BigDecimal.toString());
  }
//  public void testItem_0200()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("-2E-2147483638"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0201()
  {
    rc_BigDecimal_array = (new BigDecimal("-2E-2147483638")).divideAndRemainder(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2E-2147483638")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0206()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2E-2147483638")).hashCode();
//    Assert.assertEquals(2147483576, rc_int);
//  }
  public void testItem_0207()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("D=THIHV=:IC:72SGUQ939K5A449V>J:JM79W?@VUVG5<WKY58PQ8N06JC=9H?26P0AJSQCXXAKNYNS74Q:4VY2LP<44X5AX1:Y<P");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0210()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-2E-2147483638"));
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0217()
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
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\1', '8', '8', '\0', '8', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\uFFFF', '8', '\0', '8', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '8', '8', '8', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\234', '8', '\0', '\uFFFF', '\0', '\1', '\234', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\0'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0220()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).negate(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0225()
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
  public void testItem_0226()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).plus();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("HFPXWLJHCXR@C9U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0242()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0247()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0250()
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
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '8', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\0', '8', '\234', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\0', '8', '\234', '8', '\1', '\0', '\1', '8', '\234', '\234', '8', '\234', '\0', '\1', '\234', '\0', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0252()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0255()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0256()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scaleByPowerOfTen(1);
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E+309", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("32"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '8', '\0', '\234', '\234', '\234', '\234', '\1', '\234', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '8', '8', '\234', '\1', '8', '8', '\1', '8', '\0', '8', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\1', '8', '8', '\0', '8', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '8', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0264()
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
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0266()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0267()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E+309")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0280()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432", rc_String);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0288()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432")).setScale(1);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0293()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0294()
  {
    rc_boolean = (new BigDecimal("1")).equals("=1OE8?9YSW>H=8TYAKF1P?4N?8S5;=3OVME1RH22D7TR4D>WB0OCYP8YKV3?;AI9F7NDGHOCDU>VCH4=EATSTP1NXD0OV=Q0CKSE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0303()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0304()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0307()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0308()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0309()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0311()
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
  public void testItem_0312()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0313()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).longValue();
    Assert.assertEquals(64L, rc_long);
  }
  public void testItem_0316()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0317()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0318()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0319()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0320()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
//  public void testItem_0321()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0322()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0323()
  {
    rc_boolean = (new BigDecimal("1")).equals("IH4:=4191I9AMK6W:0;;LT2PJ<8?7FO2Y9T");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0"), 2147483647, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0325()
  {
    rc_float = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0326()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858432.0")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0331()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0332()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0337()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '8', '8', '\0', '\uFFFF', '8', '\234', '\1', '\234', '8', '\0', '\0', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\1', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\1', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '8', '8', '\0', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\234', '8', '\234', '8', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\1', '8', '8', '8', '\1', '\1', '\0', '\1', '8', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0348()
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
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0351()
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
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0364()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("33"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0382()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0383()
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
  public void testItem_0384()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_int = (new BigDecimal("1E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0390()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0393()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0394()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0396()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0401()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0404()
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
//  public void testItem_0405()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).remainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0414()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).pow(1, new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '8', '\1', '\234', '\234', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\234', '\1', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\0', '\1', '8', '\234', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0416()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\0', '8', '\234', '\234', '8', '8', '\1', '8', '\1', '8', '\234', '\234', '\0', '\1', '8', '\0', '\1', '8', '8', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '\234', '\0', '8', '\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0418()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0419()
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
  public void testItem_0420()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0421()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0422()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0423()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0424()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0433()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0434()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0.0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0437()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0444()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0445()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JB7C4VGGJ5J5F3C7O=CSII5KA7U7>;9G:EC@7T15AFBBAGG1:L;YF76N=EX76K7H<K4A:J40FSGTD", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0449()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0455()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0456()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1, 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0467()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0468()
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
  public void testItem_0469()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\0', '8', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '8', '\1', '\1', '8', '8', '\1', '\234', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\234', '\0', '\0', '\1', '\0', '8', '8', '8', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0470()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0471()
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
  public void testItem_0472()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0473()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0474()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_int = (new BigDecimal("2E+308")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).divide(new BigDecimal("1.0"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).max(new BigDecimal("2E+308"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("1.0"));
    Assert.assertEquals("1.00", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    rc_String = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858370", rc_String);
  }
  public void testItem_0483()
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
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\1', '\0', '8', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\234', '\234', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '\1', '8', '\1', '\1', '8', '\1', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '8'}, 1, 0, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).remainder(new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0488()
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
  public void testItem_0489()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0491()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0496()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0497()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).unscaledValue();
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigInteger.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).scaleByPowerOfTen(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_byte = (new BigDecimal("0.0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0501()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("18446744073709551614", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0504()
  {
    rc_boolean = (new BigDecimal("0.0")).equals(";<8;X?0X@NSG7NP@KD>B8T?65F?0NLM7V8XVH=Y2<8?@BRE3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0505()
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
  public void testItem_0506()
  {
    rc_long = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).longValue();
    Assert.assertEquals(2L, rc_long);
  }
//  public void testItem_0507()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).divide(new BigDecimal("9223372036854775807"), -2147483648, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0509()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368.0")).hashCode();
//    Assert.assertEquals(-1806665449, rc_int);
//  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).negate();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DSN2:KDYM@I2MXI3X4:@;6N6GDEBV6HQ84MKTUF33AHPHQPI1X1RR:B@PQ6=KTK40=Q7J=0XK61RCC=:;1=JOF0?SK>9V29JI12H");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("18446744073709551614")).multiply(new BigDecimal("-9223372036854775807"));
    Assert.assertEquals("-170141183460469231694793815568465002498", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("18446744073709551614")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '\234', '\0', '\0', '\1', '\234', '\234', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\234', '\1', '8', '\uFFFF', '\1', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '8', '\0', '\234', '\0', '\0', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '8', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0520()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("320")).max(new BigDecimal("1"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("320"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("320")).subtract(new BigDecimal("0.0"));
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("320")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("352", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0528()
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
  public void testItem_0529()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_long = (new BigDecimal("-170141183460469231694793815568465002498")).longValue();
    Assert.assertEquals(-2L, rc_long);
  }
  public void testItem_0532()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0533()
  {
    rc_int = (new BigDecimal("3")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0534()
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
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1, 0);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485837E+308", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
//  public void testItem_0539()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0540()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\234', '\uFFFF', '\234', '8', '\234', '8', '8', '\234', '8', '\1', '8', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '8', '\1', '\0', '\234', '8', '\0', '8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '\0', '8', '\1', '\1', '8', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\234', '8', '8', '8', '\234', '\234', '\uFFFF', '8', '8', '\234', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\1', '\0', '\1', '8', '8', '\0', '\uFFFF', '8', '\1', '\1', '\234', '\234', '8', '8', '8', '8', '\1', '\0', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\234', '\0', '8', '\1', '\1', '\234', '\1', '\0'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0551()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("9223372036854775808"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigInteger();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0567()
  {
    rc_boolean = (new BigDecimal("0")).equals("XTL6L9OXASPDH=NK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0568()
  {
    rc_int = (new BigDecimal("-32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0572()
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
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KKL3GX@5?T<UUSDS0Q3W2<N?IQ5FKQ9R6=2SA=3A>UGCWV>TA@7F=;B81N=>KY>XC>>EA0@GJY<Q0B>Q>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2C<WE9P7:HWWPDKW<EADTCQ3GGST652<T;M97M9PLX6DOPKNL=X<@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_int = (new BigDecimal("9223372036854775808")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0583()
  {
    rc_long = (new BigDecimal("9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '8', '\1', '8', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\234', '\0', '\uFFFF', '8', '\0', '\1', '\1', '8', '\0', '\234', '\1', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '8', '\1', '8', '\234', '\1', '\0', '\1', '8', '\1', '\234', '\uFFFF', '\234', '\1', '8', '8', '\1', '\234', '8', '\1', '\uFFFF', '8', '\234', '8', '\0', '\1', '8'}, -2147483648, 1, new MathContext("precision=0 roundingMode=FLOOR"));
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
      rc_BigDecimal = new BigDecimal("W8<9WCBCTTSG@SW1MUKOF2SFV13SCAS43", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GP3JER81M<5SOF0P=IYMH?:CXRW@JEC?0184L;7D>8>RALT2F8110HG@L2X1WS@:SV6L:KQSAUSYBWTXS7S=;F:;M5:EGJF>TMFC", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0610()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0612()
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
  public void testItem_0613()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0614()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0617()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?TX>UY0L9NGEAMY");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0621()
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
//  public void testItem_0622()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\1', '8', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\234', '8', '\1', '8', '\1', '\0', '\0', '\234', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\0', '8', '8', '\234', '8', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\234'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '8', '\234', '8', '\0', '\0', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '\1', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\0', '\0', '\234', '\234', '\1', '8', '8', '\uFFFF', '\0', '8', '\0', '\234', '8', '8', '\1', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\0', '\234', '\1', '\0', '8', '\1', '\1', '\0', '\1', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QHX4W96=5YV9A=7FVXIULQ<65P7OCL@7K?WLDGRF<62P3IK9IT4X=X<KJI0", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0628()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MWF@RS8AU3UO;Q;I>LSS:IGV@BG63?MGI9IH>E8WBOGNR;>TK<8CWH?S:L4WXLP72=TYHYCAXKT@WCSYONMA071CX3?9DSGG1;JF");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0633()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0634()
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
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E+2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0643()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0644()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0E+1"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
  {
    rc_double = (new BigDecimal("2147483647")).doubleValue();
    Assert.assertEquals(2.147483647E9, rc_double, 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\0', '\234', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '\1', '\1', '8', '\234', '\234', '\234', '\234', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '\1', '8', '\0', '8', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0654()
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
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7WQUJ=YC4<N5;8CJVX<X9E9T9Y80UV9JEJ<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2O2EN07FS>VO1CSL<TCNVSGJ6I?;KES@E4HNBK=TYB40WJ<WJRBHF:YNGM5?QYH6SR;55J>HQB>TX4:JH?90>28AP9RJNH", new MathContext("precision=2147483647 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0659()
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
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0662()
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
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0665()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0666()
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
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0669()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0670()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0671()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0672()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0673()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0675()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0676()
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
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0679()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0681()
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
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\uFFFF', '\0', '\1', '8', '8', '\0', '\234', '8', '8', '8', '\uFFFF', '8', '8', '\1', '\1', '\1', '\1', '8', '\0', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '8', '8', '8', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\0', '\234', '8', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\uFFFF'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0687()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("3E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0692()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("GPANX=K1B7J>=AM>9WO>EW13J=W5EI?NV95VQ9CYI;CDI?Y1AEYF4T9YF2>Q3QY1CTXM9BW8HVGWB0@BI<LF:E3YCA>KNI47C3ED");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("30"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0698()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_int = (new BigDecimal("30")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0701()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("KG;GO4Q3>I47WGFQY<51S>C:UGLHFBBUQ66XIGGG=72JK5EAWM:DLOUWAJI;CIBS486VR9NQ:Q:Q:CB7T@Q75ANVN;EU@GJ927XF");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("30")).divide(new BigDecimal("30"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("11", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("11")).stripTrailingZeros();
    Assert.assertEquals("11", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("11")).setScale(-1, 1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_String = (new BigDecimal("11")).toString();
    Assert.assertEquals("11", rc_String);
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("11"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("11")).negate();
    Assert.assertEquals("-11", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("11")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0722()
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
  public void testItem_0723()
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
  public void testItem_0724()
  {
    rc_int = (new BigDecimal("-11")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("-11")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("-11")).plus();
    Assert.assertEquals("-11", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-11")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("1E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("-11")).divide(new BigDecimal("1E+1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-2"));
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0742()
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
  public void testItem_0743()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\0', '\234', '8', '\1', '8', '\234', '8', '\0', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '\1', '\0', '\1', '8', '8', '\0', '\0', '\0', '\234', '8', '\0', '8', '\0', '\1', '\234', '\234', '8', '\234', '8', '\0', '\uFFFF', '8', '\0', '8', '\uFFFF', '8', '\1', '\1', '\1', '8', '\0', '\0', '\1', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\234', '\1', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0746()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0747()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("-11")).add(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0755()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":M1MVG@08QO622A=WV1W4WGC2UFTH7F>9052PI9J@RKPK8VN0M4RMXEJBWIOP10XOEY8N:7:0EU378A389:<39IVHQ8<75N?DP:G");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\1', '\234', '8', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '8', '8', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\1', '8', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '8', '\234', '\234', '\0', '\234'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0760()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\0', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\0', '\1', '\1', '\234', '\0', '\0', '\1', '\1', '\234', '\234', '\234', '\0', '\0', '\234', '\234', '\1', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\1', '\234', '\0', '\0', '8', '8', '\234', '\uFFFF', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0767()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0772()
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
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '8', '\0', '\234', '\0', '8', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\0', '\1'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0776()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("0"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0780()
  {
    rc_int = (new BigDecimal("3E+1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0786()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0787()
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
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0789()
  {
    rc_boolean = (new BigDecimal("0")).equals("3807WR;7?3PRSEVF7>7HE7EX@=QS?J0UXX@25TFH4851T<N6U7TBK:FOAK@N@TJD:JFU?K9432L?P=H?RSXK7AO@HH8MA598J6L7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">AG=YYX0O:0CX8TMYP:F2BV4:WC@R8H6J29L1=CQ8RLI5>BA7<O>U@4@L?JA=;DR0T7WI9?O:G2L91>AP0S", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0792()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0796()
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
  public void testItem_0797()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_String = (new BigDecimal("-3E+1")).toEngineeringString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0803()
  {
    rc_long = (new BigDecimal("-3E+1")).longValueExact();
    Assert.assertEquals(-30L, rc_long);
  }
  public void testItem_0804()
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
  public void testItem_0805()
  {
    rc_byte = (new BigDecimal("8")).byteValueExact();
    Assert.assertEquals(8, rc_byte);
  }
  public void testItem_0806()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0811()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y5RTX5P8VQQUPO@2=H37RVQFNQPBBA5E3=PYEC=9>4:H?@D8SW8IGVCLCVHH@<FKX;9LQ2=<Q9UBQ0IRA5NAGLI;>@8EAX5LS655");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0816()
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
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000.0")).max(new BigDecimal("1000000000000.0"));
    Assert.assertEquals("1000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).remainder(new BigDecimal("1000000000000.0"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).negate();
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("6E+1")).divide(new BigDecimal("3E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":1UBEQ>:;MO3G;FTMSXM24DDC2KN1EK<RUQERG4S;7EF6KA51BA6<8@IFGK:4HAQMEQ5");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("-6E+1")).intValue();
    Assert.assertEquals(-60, rc_int);
  }
  public void testItem_0826()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0827()
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
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).divide(new BigDecimal("-6E+1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).plus();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("6E+1"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).plus();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("1000000000000.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1000000000000.0")).divideToIntegralValue(new BigDecimal("6E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0839()
  {
    rc_String = (new BigDecimal("6E+1")).toString();
    Assert.assertEquals("6E+1", rc_String);
  }
  public void testItem_0840()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).negate();
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).subtract(new BigDecimal("5E-324"));
    Assert.assertEquals("-60.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1000000000000.0")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-60.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005"));
    Assert.assertEquals("0E+324", rc_BigDecimal.toString());
  }
//  public void testItem_0845()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-60.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("-5E-324", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0846()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0847()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-60.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("2147483647"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("5E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("5E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0853()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0855()
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
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).multiply(new BigDecimal("-0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2")).remainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal_array = (new BigDecimal("-0.1")).divideAndRemainder(new BigDecimal("0.32"));
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.32")).remainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("0.32"));
    Assert.assertEquals("-3.52", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).subtract(new BigDecimal("0.32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0865()
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
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_float = (new BigDecimal("-3.52")).floatValue();
    Assert.assertEquals(-3.5199999809265137F, rc_float, 0);
  }
  public void testItem_0868()
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
  public void testItem_0869()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J6@IM39K4V4DGB>F@PX>FFT8T");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '8', '8', '\234', '\234', '\234', '\234', '\1', '\234', '\234', '\1', '\234'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).multiply(new BigDecimal("-3.2"));
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\1', '\1', '\1', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\1', '\0', '\1', '\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).movePointRight(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0876()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0.32"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.3", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0881()
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
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0883()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-0.3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0.32"));
    Assert.assertEquals("-0.68", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0886()
  {
    rc_boolean = (new BigDecimal("-0.68")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0887()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("-0.3")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).plus();
    Assert.assertEquals("-0.68", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_long = (new BigDecimal("-0.3")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_long = (new BigDecimal("0.1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0893()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-0.68")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0894()
  {
    rc_int = (new BigDecimal("-0.68")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0895()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '8', '\234', '\1', '8', '\1', '\1', '\0', '8', '\1', '\1', '\234', '8', '8', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '\0', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\0', '\234', '8', '8', '\1', '\234', '\234', '\1', '\234', '\uFFFF', '8', '8', '8', '8', '8', '\0', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '\0', '8', '\uFFFF', '\1', '8', '\1', '\0', '\uFFFF', '\234', '8', '\234', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0896()
  {
    rc_String = (new BigDecimal("-0.3")).toString();
    Assert.assertEquals("-0.3", rc_String);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0899()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.68")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0900()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0901()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0902()
  {
    rc_boolean = (new BigDecimal("-0.68")).equals(":H3BQ14;917XLI568NCBL09;:EX88I8BKT?COE4UJR=QR>R");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-310", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1.7976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836E+308", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0907()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("ABO2O1875TR651FHVT>8WN;;VSGJ;F9I6<V;S@2Y2914WPHHHWUNQ2Q5G?8;X244?@A>PJP27Y0QQ:AHRJOROHOS<2Q:ETOJ8UH@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0908()
  {
    rc_int = (new BigDecimal("6E-310")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0909()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).min(new BigDecimal("-0.68"));
    Assert.assertEquals("-0.68", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":DE75YI2GQL7X3U0UE:T9HBEUD7VU:WYRM4P7KTCMYFQLLFAS9K6RPVGJTQC5NJ=47NAQW3");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).abs();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0917()
  {
    rc_int = (new BigDecimal("9223372036854775808")).compareTo(new BigDecimal("-0.68"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0918()
  {
    rc_BigDecimal_array = (new BigDecimal("-0.68")).divideAndRemainder(new BigDecimal("9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0919()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toPlainString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigInteger = (new BigDecimal("-0.68")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.7", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("-0.7")).plus();
    Assert.assertEquals("-0.7", rc_BigDecimal.toString());
  }
  public void testItem_0925()
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
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0928()
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
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).stripTrailingZeros();
    Assert.assertEquals("-0.68", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.68")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0932()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.68")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0933()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-0.7"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0934()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0935()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\234', '\234', '8', '8', '\uFFFF', '\234', '8', '\1', '\234', '\0', '\1', '\1', '8', '\0', '\0', '\1', '\1', '\1', '8', '8', '\uFFFF', '8', '8', '\234', '\1', '\234', '\234', '\0', '\0', '\234', '\1', '8', '\1', '\0', '8', '8', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '8', '\1', '\0', '8', '\0', '8', '\234', '\234', '\0', '\234', '\234', '\234', '\234', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).divide(new BigDecimal("-0.68"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-0.68"));
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-0.68")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).stripTrailingZeros();
    Assert.assertEquals("-0.68", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.68")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0942()
  {
    rc_String = (new BigDecimal("-0.68")).toEngineeringString();
    Assert.assertEquals("-0.68", rc_String);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("-0.7")).add(new BigDecimal("-0.68"));
    Assert.assertEquals("-1.38", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-0.7")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("-1.38"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_float = (new BigDecimal("-0.7")).floatValue();
    Assert.assertEquals(-0.699999988079071F, rc_float, 0);
  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-0.7")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-1.38")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0950()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8O47UHDFVL00Q=CNA>C17T83C4EFVV80M5<AU<84@JEX:LP7AXTWXQ6P;N6O654TQLDWAY29N996EY0=E53SH1R2QF", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).multiply(new BigDecimal("-1.38"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.9384", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("-0.7")).negate();
    Assert.assertEquals("0.7", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_String = (new BigDecimal("0.7")).toEngineeringString();
    Assert.assertEquals("0.7", rc_String);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S>>6S<D3VG;MM048?P7U<7IYE>YVBSF>0W2JL>09JO2VM0TID3KVCNM;8XLH4:>=3>9IPU2@;?AU5M:4MTB82CUYDN7STI>M7>G7", new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0955()
  {
    rc_boolean = (new BigDecimal("0.7")).equals("I6H7QI<0PAXNU8I3HW:G7NY285B8LED03OHPK1YHVFT8>6RHF;T@K2W>TY=Q1FFLB5LCLT4YUK9C2?IVH3MPRKFW14K4ST2STN0:");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0956()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("0.9384")).divideAndRemainder(new BigDecimal("0.9384"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0957()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0958()
  {
    rc_BigInteger = (new BigDecimal("0.9384")).unscaledValue();
    Assert.assertEquals("9384", rc_BigInteger.toString());
  }
  public void testItem_0959()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.68")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0960()
  {
    rc_double = (new BigDecimal("-0.7")).doubleValue();
    Assert.assertEquals(-0.7, rc_double, 0);
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0962()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.7")).divide(new BigDecimal("0E+1"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0963()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).divide(new BigDecimal("-0.68"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KWV;39I:IXDWRB>C7<J;XJ;;N3Q0SPS<NUN9UM2FO:DMD<L8YTSUH8QRHX;JVT49>QL5CMHVO5F<F5", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("-0.68")).subtract(new BigDecimal("-0.68"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0968()
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
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";8PAA3>S9M:LP0FY3RI=DQ259R3C9VF>F2XGV?0J?TNJK4Q9;<0WL0H8O6>CCNSCTXR;HJ35<2BC3<:JVLKD<7M<A:AX5O??B4>N", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("0.7")).abs();
    Assert.assertEquals("0.7", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("0.7")).multiply(new BigDecimal("0.7"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.49", rc_BigDecimal.toString());
  }
//  public void testItem_0974()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9E+18")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0975()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("0.49")).remainder(new BigDecimal("0.49"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0977()
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
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1E+1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	 Assert.assertEquals("1E+1", rc_BigDecimal.toString());
    } else {
    	 Assert.assertEquals("10", rc_BigDecimal.toString());
    }
  }
  public void testItem_0981()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\1', '8', '8', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\0', '8', '\234', '\234', '\234', '8', '\234', '\234', '\0', '\234', '8', '\1', '8', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), 1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("0.00"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0985()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.00")).hashCode();
//    Assert.assertEquals(2, rc_int);
//  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_String = (new BigDecimal("0.00")).toEngineeringString();
    Assert.assertEquals("0.00", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0990()
  {
    rc_boolean = (new BigDecimal("5E-324")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0.00"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";G5>K82K6I@A?DE:4M:VQ;8M40<<N5OL6E4ES><ELORMN:9C<FRUE46HXV6ADT6LML80OQ5LMH6ENDJ4SK@9?GS61T5WJEMKGKM=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+2")).divideAndRemainder(new BigDecimal("0E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0995()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0997()
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
  public void testItem_0998()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0999()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
}
