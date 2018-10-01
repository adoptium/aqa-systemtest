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
public class TestSuite013 extends TestCase
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
//  public void testItem_0000()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0004()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0007()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\1', '\0', '\234', '8', '8', '\234', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '8', '\234', '8', '\0', '8', '\1', '\uFFFF', '8', '8', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '\0', '\234', '\1', '\1', '\1', '8', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0009()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I@USG24XUPNIHB99YDB;XB1TIEIJ<<>EHV=834HPOTUETVCBM?E>NPLVVLA4BG@VN<57AAJUQC2QT9DN=JH>@Q32M?<P8BF5", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("D59OWU:<LWS3N8<@<OINDW;80QH::2YNE8FLHG3C=Q9M:TK4S<CUX8J8M7HCLF@VPJU7DJ<<<4PO8:11BB8QYIK9OOPN23VNNN@7", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_int = (new BigDecimal("3E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0014()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1E+1"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).abs();
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("1E+2")).divide(new BigDecimal("1E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_long = (new BigDecimal("11358790158910")).longValueExact();
    Assert.assertEquals(11358790158910L, rc_long);
  }
  public void testItem_0020()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
//  public void testItem_0023()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_int = (new BigDecimal("9223372036854775807")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\234', '8', '\1', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\1', '\234', '\234', '\234', '\234', '\0', '8', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\234', '\0', '\1', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1E+1"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0035()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0042()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0043()
  {
    rc_int = (new BigDecimal("1E+1")).intValue();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("1E+1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\1', '\1', '8', '\0', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\0', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\1', '\1', '8', '8', '\234', '\0', '\1', '8', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\0', '8', '\1', '\234', '8', '\1', '\0', '\0', '\234', '8', '\uFFFF', '8', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0051()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\234', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\0', '8', '\0', '\0', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\1', '8', '8', '8', '\1', '\0', '\1', '8', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\0'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).movePointRight(0);
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("9000000000000000000"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0059()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).divide(new BigDecimal("9E+18"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\234', '\uFFFF', '8', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\0', '\234', '8', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '\0', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0067()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O:6KWXA>;44OBQSC4@CYOTI9HHWFRCOKNUWR9DUHM7D7E=A>U>GWC2@BC?C:J9FJKQ8N291J<6>5", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\234', '\uFFFF', '\1', '8', '\1', '\0', '8', '\234', '\0', '\1', '\1', '\1', '\234', '\1', '\1', '\234', '8', '\0', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\0', '\234', '\234', '\234', '\1', '8', '\234', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '8', '\234', '\0', '\0', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\234', '8', '8', '\234', '\0', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0073()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0074()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).subtract(new BigDecimal("9E+18"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0078()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("0E+18"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0087()
  {
    rc_boolean = (new BigDecimal("0E+18")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0088()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigInteger();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\0', '\234', '8', '\234', '\0', '\0', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\0', '8', '\1', '\1', '\1', '\1', '\1', '\234', '\234', '\1', '\1', '\234', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\0', '8', '\uFFFF', '8', '8', '8', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\234', '\1', '8', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0092()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L4PPJ8Y9NWG@KEBH2@0MP12HV4YD4I8=M:?72NKAB6G9OAK<GL6WHKX5L6:I05PARM3JVJYEX69<9F;1:V@N?;Y0=V<L;><2:6R<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+18"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).ulp();
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigIntegerExact();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0097()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("2E+308")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).multiply(new BigDecimal("0E+18"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+36", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("9E+18"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_String = (new BigDecimal("0E+36")).toEngineeringString();
    Assert.assertEquals("0E+36", rc_String);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).remainder(new BigDecimal("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal_array = (new BigDecimal("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3")).divideAndRemainder(new BigDecimal("2E+308"));
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).add(new BigDecimal("0E+18"));
    Assert.assertEquals("2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("3KDD2Q:AC8@88AG44MCX241A");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0108()
  {
    rc_int = (new BigDecimal("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222.3"));
    Assert.assertEquals("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).multiply(new BigDecimal("2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+36", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).abs();
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0114()
  {
    rc_int = (new BigDecimal("2E+308")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EBFP4=BJ6EFEUN6VEUUHF:QXPQDD5G@KBHLN707LEA@AP=U<3U3H56KWU8YLX@89ANH9CPGP:M128FSM;ENUGVYDJY2SN9=?CCH<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).subtract(new BigDecimal("2E+308"));
    Assert.assertEquals("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_long = (new BigDecimal("0E+18")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0118()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigInteger();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2E+308")).divideAndRemainder(new BigDecimal("0E+18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308")).max(new BigDecimal("2E+308"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigInteger = (new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308")).toBigInteger();
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).movePointRight(-2147483648);
    Assert.assertEquals("2E-2147483340", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("0E+36"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigInteger = (new BigDecimal("0E+36")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0129()
  {
    rc_short = (new BigDecimal("0E+18")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("0E+36")).max(new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308"));
    Assert.assertEquals("0E+36", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3")).multiply(new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308"));
    Assert.assertEquals("4.4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444442600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+597", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("-2.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308")).setScale(-1);
    Assert.assertEquals("-2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("R;D=32EXEKCRP8SB296KFDJ3JUN1F=4PK:NWL:BKN1B0V7GL7Y=SI2BE4SONEVVJWNFF>DQ<XN?T5;?WF@C1V;GWUMPU>M4UJ6VF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("4.4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444442600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+597")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("0E+36")).divide(new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("0E+36")).add(new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3")).negate();
    Assert.assertEquals("22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222221.3", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("3.2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0151()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\0', '8', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\0', '\0', '\1', '\1', '\0', '\234', '8', '\234', '\1', '\1', '8', '8', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\1', '8', '\1', '\0', '\234', '8', '\234', '\0', '\0', '\1', '\234', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '8', '\0', '\0', '\0', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0152()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0156()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0157()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0158()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0161()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0162()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0163()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0164()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0167()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0168()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0169()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0175()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).stripTrailingZeros();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_float = (new BigDecimal("6E+1")).floatValue();
    Assert.assertEquals(60.0F, rc_float, 0);
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '\0', '\234', '\234', '\1', '\0', '\0', '\1', '\1', '8', '8', '\1', '\1', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '\1', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.8E+3", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TU@JT9;HHRL50SGSPRL6XRBA<MUE9K889LJD<K;N<", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("32"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0197()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '8', '\234', '\0', '\0', '\1', '\234', '8', '\1', '8', '\uFFFF', '\1', '\234', '\0', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\1', '\234', '\234', '\1', '8', '8', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '8', '\1', '\234', '\0', '\234', '\234', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\1', '\1', '\1', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\234', '\1', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '8', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\234', '\1', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).stripTrailingZeros();
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("-1E-19")).negate();
    Assert.assertEquals("1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0210()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
//  public void testItem_0211()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9223372036854775808")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("-1E-19")).remainder(new BigDecimal("1E-19"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0215()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0216()
  {
    rc_int = (new BigDecimal("-2147483648")).intValueExact();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0217()
  {
    rc_BigInteger = (new BigDecimal("1E-19")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("0E-19"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
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
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0225()
  {
    rc_BigInteger = (new BigDecimal("0E-19")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0226()
  {
    rc_int = (new BigDecimal("0E-19")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-19")).remainder(new BigDecimal("0E-19"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).negate();
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_int = (new BigDecimal("0E-19")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("1E-19")).subtract(new BigDecimal("1E-19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0235()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0236()
  {
    rc_int = (new BigDecimal("0E-19")).compareTo(new BigDecimal("1E-19"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0237()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-19")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0238()
  {
    rc_int = (new BigDecimal("0E-19")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("1E-19")).max(new BigDecimal("1E-19"));
    Assert.assertEquals("1E-19", rc_BigDecimal.toString());
  }
//  public void testItem_0241()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-19")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0242()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0243()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1E-19"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("1E-19")).plus();
    Assert.assertEquals("1E-19", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0255()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0258()
  {
    rc_long = (new BigDecimal("1E-19")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1E-19"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0266()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0268()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0273()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0274()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("HCN192<MBJQGQ3OURN66@XD?B1C4=WLB9=UPTB>OON<V07GC36K743VMPHNMHP9VJBOHXJATROA1?GPT?EICC7<57YP>THJIG>0L", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0283()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0284()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0286()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).pow(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0297()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0300()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0309()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0312()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0322()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-32")).pow(1);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("-32")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0325()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-32")).hashCode();
//    Assert.assertEquals(-992, rc_int);
//  }
  public void testItem_0326()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("-32")).max(new BigDecimal("-32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0329()
  {
    rc_int = (new BigDecimal("-32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0330()
  {
    rc_int = (new BigDecimal("-32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0331()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\234', '8', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\0', '\234', '8', '\1', '8', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\234', '\234', '8', '\234', '\0', '\0', '\234', '8', '\234', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\0', '\234', '\1', '\234', '\1', '8', '\0', '\234', '8', '\234', '8', '\234', '8', '\234', '\234', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\234', '8'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WR984DS4H=GS7P;?J;CX<U>L4RKGDVI?313>4XEJ@I:N7561MQU<=MXI7S;O<16?RH3RM1L=9", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0335()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("-32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0338()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0346()
  {
    rc_long = (new BigDecimal("33")).longValue();
    Assert.assertEquals(33L, rc_long);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0349()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0350()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0355()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VOXJOVF>568=OEP5:55QID4:Y?Q3T?2ERY0BTGFORG2RNBJ;T3XFWRFS>PSS3:@580=IEVOOGYT9OO7W<8TJFVI6UK;DP120M>1F", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0361()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("V==9@DLCAPF?7A;F>5VKNL:BCO2K4>CE6@LMNPR73SQQ64=WS0Y0EYI0UHEJCC<?IFS:N9>U1S0;?PNX6CRWNKCU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0362()
  {
    rc_boolean = (new BigDecimal("32")).equals("994=4WF5I9RAOB?7>V16XPVQYS6P@MTF9XN71>MWWL354B:D>30<04MES;9=R70G7R5SQ>PP?5TO;0RMDD>1USH1BUP:<03K<XJK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0365()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-0.1")).hashCode();
//    Assert.assertEquals(-30, rc_int);
//  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_String = (new BigDecimal("-0.1")).toString();
    Assert.assertEquals("-0.1", rc_String);
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("-31")).movePointLeft(1);
    Assert.assertEquals("-3.1", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("-3.1")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
//  public void testItem_0372()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("-31")).divide(new BigDecimal("32"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1B@1MEB0EQSN?RB322DLI@>R7?VGR;:Q=3B91J=X?EP7;?N>?STPG");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PYVSKGKV@IUFCJB:<7WLBXPVE", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0376()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.1")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("4")).multiply(new BigDecimal("-0.1"));
    Assert.assertEquals("-0.4", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1NPT<8:MU?NGHKS6V6R=KJHRKG9NAW@STX>1TNVC5:9OSWY9=FK8LGA6N5TA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-0.4")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("-31"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-31")).divideAndRemainder(new BigDecimal("-0.4"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("-9E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0385()
  {
    rc_int = (new BigDecimal("-9E+2")).intValueExact();
    Assert.assertEquals(-900, rc_int);
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '8', '\1', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '8', '\1', '8', '\234', '\234', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).negate();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).multiply(new BigDecimal("-0.4"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("-9E+2")).abs(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0390()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4E+1")).remainder(new BigDecimal("-0.4"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0391()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\0', '8', '\1', '\1', '\1', '\234', '\1', '\1', '\234', '\1', '\0', '\234', '\1', '\234', '\0', '\1', '\1', '\234', '\0', '\234', '\0', '8', '\0', '8', '8', '8', '\0', '\1', '8', '\1', '\0', '\0', '8', '8', '\0', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\1', '\1', '\234', '\0', '\1', '\0', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\234'}, -2147483648, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("-0.4")).multiply(new BigDecimal("-2E+1"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_int = (new BigDecimal("8")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("8")).movePointRight(-1);
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigInteger = (new BigDecimal("-0.4")).unscaledValue();
    Assert.assertEquals("-4", rc_BigInteger.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal_array = (new BigDecimal("0.8")).divideAndRemainder(new BigDecimal("-9E+2"));
  }
  public void testItem_0398()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.8")).divide(new BigDecimal("-0.4"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("0.8")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0401()
  {
    rc_long = (new BigDecimal("8")).longValueExact();
    Assert.assertEquals(8L, rc_long);
  }
  public void testItem_0402()
  {
    rc_BigInteger = (new BigDecimal("-4E+1")).toBigIntegerExact();
    Assert.assertEquals("-40", rc_BigInteger.toString());
  }
  public void testItem_0403()
  {
    rc_long = (new BigDecimal("8")).longValue();
    Assert.assertEquals(8L, rc_long);
  }
//  public void testItem_0404()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0405()
  {
    rc_short = (new BigDecimal("-4E+1")).shortValueExact();
    Assert.assertEquals(-40, rc_short);
  }
  public void testItem_0406()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_String = (new BigDecimal("0.8")).toEngineeringString();
    Assert.assertEquals("0.8", rc_String);
  }
//  public void testItem_0409()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.8")).hashCode();
//    Assert.assertEquals(249, rc_int);
//  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("T3QMM0BSM7JR76GW22E@WOVDFT:N1:0WF0TS399:<O>;K=G880PNOL3URHSRC6JU2E;NL;5P4NS4<68;2F@1YPPC4<967BP;B<S4");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+2")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LFT1X509KHE=K@@?5P6FETH2S6MQ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0414()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("-9E+2")).abs();
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0418()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("8")).pow(1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+9")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("8")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0423()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '8', '\1', '8', '\1', '\234', '\0', '8', '\234', '\234', '\0', '8', '\0', '8', '8', '\234', '\234', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '8', '8', '8', '\0', '8', '8', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '8', '\1', '8', '\234', '\uFFFF', '\234', '8', '\234', '\1', '\1', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\1', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0425()
  {
    rc_String = (new BigDecimal("3E-2147483646")).toEngineeringString();
    Assert.assertEquals("3E-2147483646", rc_String);
  }
  public void testItem_0426()
  {
    rc_double = (new BigDecimal("3E+9")).doubleValue();
    Assert.assertEquals(3.0E9, rc_double, 0);
  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("8"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0428()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0.8"));
  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0439()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0441()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0446()
  {
    rc_boolean = (new BigDecimal("1")).equals("=41C=DJ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0447()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, 1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0449()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0450()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_int = (new BigDecimal("62")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_int = (new BigDecimal("33")).compareTo(new BigDecimal("62"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("33")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0459()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0460()
  {
    rc_boolean = (new BigDecimal("32")).equals("1Q=RV809S");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0461()
  {
    rc_double = (new BigDecimal("2E+308")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("2E+308"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("62")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).multiply(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).subtract(new BigDecimal("2E+308"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10945697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).divideAndRemainder(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0467()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0468()
  {
    rc_boolean = (new BigDecimal("10945697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).equals("0G62;VTII2MY>F2L9MBOPUQ66Y5E@R00Y6KK8BI?9GD5OW3DPQQT?DOHP?GWJE<YVE3N78EBC=>BU6TU?V6LY@WD7QQ>>QP0;5FJ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0469()
  {
    rc_int = (new BigDecimal("10945697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_long = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0473()
  {
    rc_boolean = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).equals("G=6GP16>RAM>FHC21E=EQ021?IVQ<Y5<W1J<INI:1RIDCE@0N9<VOMCFRIU7X@54EDG;Y@4V?AIP>8Y@YQUCK?<NH4R61P2X");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0475()
  {
    rc_int = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).divide(new BigDecimal("10945697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3.28474845088579031239198807024336750214282401593288081231723261138303924879236616090272676426997132033681596968326015674424191401576299385952478126647206537188945037312971360270847024022559232000339275011755508618929577773844762132411367890133344160530431142549448535839458168651137466424726940609513573689E+306", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("3.28474845088579031239198807024336750214282401593288081231723261138303924879236616090272676426997132033681596968326015674424191401576299385952478126647206537188945037312971360270847024022559232000339275011755508618929577773844762132411367890133344160530431142549448535839458168651137466424726940609513573689E+306")).min(new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816"));
    Assert.assertEquals("3.28474845088579031239198807024336750214282401593288081231723261138303924879236616090272676426997132033681596968326015674424191401576299385952478126647206537188945037312971360270847024022559232000339275011755508618929577773844762132411367890133344160530431142549448535839458168651137466424726940609513573689E+306", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("3.28474845088579031239198807024336750214282401593288081231723261138303924879236616090272676426997132033681596968326015674424191401576299385952478126647206537188945037312971360270847024022559232000339275011755508618929577773844762132411367890133344160530431142549448535839458168651137466424726940609513573689E+306")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.28474845088579031239198807024336750214282401593288081231723261138303924879236616090272676426997132033681596968326015674424191401576299385952478126647206537188945037312971360270847024022559232000339275011755508618929577773844762132411367890133344160530431142549448535839458168651137466424726940609513573689E+306", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0480()
  {
    rc_int = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).precision();
    Assert.assertEquals(311, rc_int);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal_array = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).divideAndRemainder(new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816"));
  }
  public void testItem_0483()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E>D;U2TS6N?B6B?2ATB1XCMK:KX@@SUY6EB8?PYASIJ7R4SFS>UQSM2V75RFVYP8A8R7:ISBT65<6OPA>T@YR=?XSVYBQE7=AO0S");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0485()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).setScale(1);
    Assert.assertEquals("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816.0", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_long = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0488()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0489()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0490()
  {
    rc_int = (new BigDecimal("10945697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11145697436146357390500700271365670121480375186602389789132883561795750168361769403156552635231546446635508455117891712782527922267146779331644987895619326053135094455746179488727220385604138394532703847524218304422884160687999822786280130678591647593037465224656972836461766985216996592637525049623415741218816.0")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0493()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("64"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_int = (new BigDecimal("-8")).intValueExact();
    Assert.assertEquals(-8, rc_int);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("64")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0498()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0499()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RF>SOPPOW>MPOBSQ27J4R7LIA;XTXLSUH86AGWLSR=D9O872:>C2T4SV;?XP60K7=BWS=PMIVNAYSM=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("64")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("64"));
    Assert.assertEquals("128", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_int = (new BigDecimal("128")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0505()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("128"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0507()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-8"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 0);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("-8")).divide(new BigDecimal("32"), 1, 0);
    Assert.assertEquals("-0.3", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = (new BigDecimal("-0.3")).plus();
    Assert.assertEquals("-0.3", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("VTY=HD42QD;13XPV<G:ME@B=6F29DJDMNB?9?W@SQOFVVGXEJG7@9;WTNI5=F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("-8")).setScale(0, 1);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_long = (new BigDecimal("-0.3")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).plus();
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0518()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J1BVB?RVR7C30>:?FD9R4R6Q;D3V0;;PYN<<86DAV");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0519()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-0.3"));
  }
  public void testItem_0520()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.3")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0521()
  {
    rc_long = (new BigDecimal("-0.3")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0522()
  {
    rc_double = (new BigDecimal("-8")).doubleValue();
    Assert.assertEquals(-8.0, rc_double, 0);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9JEGAX=<", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0525()
  {
    rc_String = (new BigDecimal("-8")).toPlainString();
    Assert.assertEquals("-8", rc_String);
  }
  public void testItem_0526()
  {
    rc_int = (new BigDecimal("32.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '8', '\1', '8', '8', '\uFFFF', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '8', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\1', '\234', '8', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '\0', '\234', '\234', '8', '8', '8', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '8', '\1', '\234', '8', '\1', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.3")).divide(new BigDecimal("32"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4H=7;<OA8DDWCYK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0538()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-0.3"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("-0.3")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.3", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0546()
  {
    rc_boolean = (new BigDecimal("-8")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0547()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(0);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0553()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("6476872105833939787279851095005353825585812792452547787420843456877770866175851100542732278445987983845986491658137981164473879596345391259744428798103632317488557576850123563662941047746982922919672565711127842193984239469590166355779307380773105802905921808395480625674669267687376081029962480276672200425846647714991833088", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_double = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).doubleValue();
    Assert.assertEquals(4.9E-324, rc_double, 0);
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0561()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("-31.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_double = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).doubleValue();
    Assert.assertEquals(4.9E-324, rc_double, 0);
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_String = (new BigDecimal("0E-1074")).toString();
    Assert.assertEquals("0E-1074", rc_String);
  }
  public void testItem_0572()
  {
    rc_long = (new BigDecimal("0E-1074")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).min(new BigDecimal("32"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0576()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0578()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0581()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BC90CDNW<9;U@7VS7YDWT<E8<TF3>FM?RK1IVE1IJ6K;9F5BCA?86>DNKI9:@8L?Q031319N<9JUQH9@>KYHNLW61L?SY7@MU?GQ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0591()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0592()
  {
    rc_byte = (new BigDecimal("33")).byteValueExact();
    Assert.assertEquals(33, rc_byte);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("33")).negate();
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0596()
  {
    rc_String = (new BigDecimal("-33")).toEngineeringString();
    Assert.assertEquals("-33", rc_String);
  }
  public void testItem_0597()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("33"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0600()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("33")).divide(new BigDecimal("0.04"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8E+2", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.04"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("8.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0606()
  {
    rc_BigInteger = (new BigDecimal("-33")).toBigIntegerExact();
    Assert.assertEquals("-33", rc_BigInteger.toString());
  }
  public void testItem_0607()
  {
    rc_BigInteger = (new BigDecimal("-33")).unscaledValue();
    Assert.assertEquals("-33", rc_BigInteger.toString());
  }
  public void testItem_0608()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '8', '8', '\0', '8', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\0', '8', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '8', '8', '\1', '\1', '8', '8', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '8', '\234', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0609()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("33")).subtract(new BigDecimal("8.0E+2"));
    Assert.assertEquals("-767", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-33"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_int = (new BigDecimal("-767")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0618()
  {
    rc_short = (new BigDecimal("33")).shortValueExact();
    Assert.assertEquals(33, rc_short);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).subtract(new BigDecimal("33"));
    Assert.assertEquals("287", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\234', '8', '\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\1', '8', '8', '\0', '\0', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\1', '\0', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0621()
  {
    rc_byte = (new BigDecimal("33")).byteValueExact();
    Assert.assertEquals(33, rc_byte);
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("33")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.103125", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("33")).plus();
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("33"));
    Assert.assertEquals("34", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("0.103125")).subtract(new BigDecimal("33"));
    Assert.assertEquals("-32.896875", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("34")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("-32.896875")).scaleByPowerOfTen(1);
    Assert.assertEquals("-328.96875", rc_BigDecimal.toString());
  }
//  public void testItem_0631()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0632()
  {
    rc_String = (new BigDecimal("34")).toPlainString();
    Assert.assertEquals("34", rc_String);
  }
  public void testItem_0633()
  {
    rc_String = (new BigDecimal("-328.96875")).toPlainString();
    Assert.assertEquals("-328.96875", rc_String);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0636()
  {
    rc_int = (new BigDecimal("-328.96875")).intValue();
    Assert.assertEquals(-328, rc_int);
  }
  public void testItem_0637()
  {
    rc_int = (new BigDecimal("-328.96875")).precision();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("33"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-32.896875")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("34")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("34", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_double = (new BigDecimal("-32.896875")).doubleValue();
    Assert.assertEquals(-32.896875, rc_double, 0);
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("-32.896875")).movePointRight(-1);
    Assert.assertEquals("-3.2896875", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32.896875")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0644()
  {
    rc_int = (new BigDecimal("34")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0645()
  {
    rc_String = (new BigDecimal("33")).toString();
    Assert.assertEquals("33", rc_String);
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("33"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_int = (new BigDecimal("-32.896875")).intValue();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0648()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("34"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0649()
  {
    rc_String = (new BigDecimal("-3.2896875")).toEngineeringString();
    Assert.assertEquals("-3.2896875", rc_String);
  }
  public void testItem_0650()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("34")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("34.0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0654()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0656()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0657()
  {
    rc_long = (new BigDecimal("34")).longValue();
    Assert.assertEquals(34L, rc_long);
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("-3.2896875")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.32896875", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).divide(new BigDecimal("-320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0660()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("-1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0661()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0662()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0663()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0664()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.32896875")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0665()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).divide(new BigDecimal("-0.32896875"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0666()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+2147483647")).setScale(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+2147483647")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0668()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0670()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("-0.32896875")).multiply(new BigDecimal("-0.32896875"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0672()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("-1E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0673()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).add(new BigDecimal("-1E+2147483647"), new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("-2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0676()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-2E+2147483647")).negate();
//    Assert.assertEquals("2E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0677()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("-2E+2147483647"));
//    Assert.assertEquals("-2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '8', '\1', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\234', '\0', '\0', '8', '\234', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\0', '\234', '8', '\uFFFF', '\0', '\234', '8', '\234', '8', '8', '\uFFFF', '\1', '\0', '8', '8', '\0', '\234', '\1', '8', '8', '\0', '\0', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0680()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0681()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).setScale(-1, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0682()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0686()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0687()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0691()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0692()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("-320.0E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0693()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0698()
  {
    rc_boolean = (new BigDecimal("-320.0E+2147483647")).equals("WSQ25VLX149S?U38DN?SGP?E:CA68<OSQEHV95INGKIB=4NNPP48TW@R@UFXXI2OIWY<;TR6RLSOD74QDD5AT8311@BMITN9BNJQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SJ8HL=MC1AKA1LMI@WD>>?2UO5?8<?:;:NRA8Q6G9?X3>ME;1F7LY<LHY9OBCNA:>EMD:J2E60W6FSLE797E");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0705()
  {
    rc_boolean = (new BigDecimal("1")).equals("F8RQ2T@3=RP1SPOC4T@2R3<KVGRPS@HE;AC<97@Y627DX7TEDD:NPW;I:6YLRW?V1PIK9XF:6CY1@TDLGNKSMRJ?6");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q<P<KOSUQF5BPMKAYDM44MM:<1QBH", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0711()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0714()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
//  public void testItem_0715()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("0.1"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).add(new BigDecimal("0.2"));
    Assert.assertEquals("0.4", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0720()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.4")).divide(new BigDecimal("-1"), 2147483647, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-0.1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0724()
  {
    rc_boolean = (new BigDecimal("-0.1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0725()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0726()
  {
    rc_int = (new BigDecimal("-0.1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0727()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E-2147483647"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("-10"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigInteger = (new BigDecimal("-10")).toBigInteger();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0734()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("-10")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
//  public void testItem_0738()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-10")).remainder(new BigDecimal("-10"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0739()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '\0', '8', '\1', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\0', '8', '\1', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\1', '\234', '\0', '\1', '\0', '8', '\0', '\234', '\0', '8', '8', '\1', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\0', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0740()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0741()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-10"));
    Assert.assertEquals("-0.32", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_String = (new BigDecimal("-0.32")).toString();
    Assert.assertEquals("-0.32", rc_String);
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0746()
  {
    rc_short = (new BigDecimal("-10")).shortValueExact();
    Assert.assertEquals(-10, rc_short);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("-10")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("-0.32")).divideToIntegralValue(new BigDecimal("-0.32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-10")).abs();
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
//  public void testItem_0753()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("10")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-10"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("0"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\0', '\1', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '8', '\1', '8', '\0', '\234', '8', '\234', '\uFFFF', '8', '8', '\uFFFF', '\1', '\1', '\1', '\1', '8', '\1', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\234', '\1', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\1', '8', '8', '\uFFFF', '8', '\234', '\0', '\0', '8', '\1', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\0', '\234', '8', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("3.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\0', '\0', '8', '\0', '8', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '8', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0781()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0782()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0787()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6X<3G>SV;98<3289W35SCV?4F>RQL5IAOMA39JO5B:Q@9SV9G6S=:7L08T>@UI087L:>PUKLEP4RMUGW?U2HB0IB2N7RSM15NUJ4", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0789()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S<4M=?Q", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\1', '8', '\1', '8', '\uFFFF', '\0', '8', '\234', '8', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '8', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\1', '\234', '\1', '\0', '8', '\1', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\234', '\0', '\234', '\0', '\0', '8', '\1', '\234', '\1', '\1', '\0', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '8', '8', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '8', '\1', '\uFFFF'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0798()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '8', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '8', '8', '\1', '\0', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\1', '8', '8', '\1', '\uFFFF', '8', '\1', '\0', '\0', '\0', '8', '8', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\234', '\234', '8', '8', '8', '\1', '\0', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\1', '\0', '\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0804()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647, 1);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0806()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0810()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0815()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0817()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0821()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(1);
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(2147483647);
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+19")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0832()
  {
    rc_int = (new BigDecimal("1E+19")).intValue();
    Assert.assertEquals(-1981284352, rc_int);
  }
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).abs();
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1.135879015891E-2147483635", rc_BigDecimal.toString());
  }
//  public void testItem_0845()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("1.135879015891E-2147483635")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0846()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1.135879015891E-2147483635")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0849()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483635")).movePointRight(1);
    Assert.assertEquals("1.135879015891E-2147483634", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValueExact();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0853()
  {
    rc_String = (new BigDecimal("1.135879015891E-2147483634")).toEngineeringString();
    Assert.assertEquals("1.135879015891E-2147483634", rc_String);
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0855()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0856()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-0.1"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0859()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\1', '8', '\1', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '8', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '8', '\234', '8', '\0', '\234', '\0', '\0', '8', '\0', '8', '\uFFFF', '\1', '8', '8', '\1', '8', '\uFFFF', '\0', '\1', '\1', '\0', '8', '\0', '\234', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '8', '8', '\0', '8', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0861()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1.135879015891E-2147483634")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0862()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483634")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0867()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483634")).divideToIntegralValue(new BigDecimal("1.135879015891E-2147483634"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483634")).pow(0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E-2147483634")).negate();
    Assert.assertEquals("-1.135879015891E-2147483634", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0871()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.135879015891E-2147483634")).setScale(1, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0872()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0873()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-1.135879015891E-2147483634")).subtract(new BigDecimal("-1.135879015891E-2147483634"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0881()
  {
    rc_boolean = (new BigDecimal("0")).equals(">EQXP>?NGKA:H:VQMXSVGBL?0;8Q3P@RJ47JN6:9<XI<A:HO4=5");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0882()
  {
    rc_boolean = (new BigDecimal("1.135879015891E-2147483634")).equals("KN=;PDO6R3GW26YGA0BCFQ0W?NG1Y;IKUK;2BI?P<USP");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0893()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
//  public void testItem_0894()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0895()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("3.2E+2"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0896()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("3.2E+2"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0899()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
//  public void testItem_0900()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0901()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_String = (new BigDecimal("3.2E+2")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
//  public void testItem_0903()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
//  public void testItem_0904()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
//  public void testItem_0905()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-1"), 1, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0906()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
//  public void testItem_0908()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\1', '\234', '\234', '\234', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\234', '\1', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\234', '\0', '\0', '\234', '8', '\0', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\234', '8', '\1', '8', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0910()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
//  public void testItem_0913()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0914()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
//  public void testItem_0915()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("2147483647"), -1, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1.0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("1.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0926()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("320.0E+2147483647"), 0, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0927()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0928()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '8', '8', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\0', '8', '8', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\1', '8', '\uFFFF', '\234', '\0', '\1', '\0', '\0', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\1', '\234', '8', '\uFFFF', '8', '\1', '\0', '8', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\1', '\0', '\1', '\uFFFF', '\1', '\1', '\uFFFF'}, 1, -2147483648, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0934()
  {
    rc_String = (new BigDecimal("-2")).toEngineeringString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).divide(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\0', '\1', '8', '\234', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '8', '8', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\0', '8', '\1', '\234', '\0', '\0', '\0'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0941()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0943()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0945()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0946()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0948()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0949()
  {
    rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"));
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).subtract(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0952()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0953()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toEngineeringString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I>CVDAA03YFAWGNEG0>89Q6<BXX2@@MAHK1RPH=SH@2R2A@HTRLRWTO@U:NLN07U96=E<>8R>NAKCW64GKARG=J8BGUU3Y>8X9TL");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0957()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0958()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).plus();
    Assert.assertEquals("0.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0962()
  {
    rc_boolean = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).equals("88RU@PNGA6FUV@QV3:SO8134W@LDWDGIRCLKGH=L94>8VGC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784")).divide(new BigDecimal("8"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).divide(new BigDecimal("202402253307310618352495346718917307049556649764142118356901358027430339567995346891960383701437124495187077864316811911389808737385793476867013399940738509921517424276566361364466907742093216341239767678472745068562007483424692698618103355649159556340810056512358769552333414615230502532186327508646006263307707741093494784"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 2147483647, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0967()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("8"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
  public void testItem_0971()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).plus();
    Assert.assertEquals("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).movePointRight(-1);
    Assert.assertEquals("2530028166341382729406191833986466338119458122051776479461266975342879244599941836149504796267964056189838473303960148892372609217322418460837667499259231374018967803457079517055836346776165204265497095980909313357025093542808658732726291945614494454260125706404484619404167682690381281652329093858075078291346346763668684.8", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus(new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_float = (new BigDecimal("7E+1")).floatValue();
    Assert.assertEquals(70.0F, rc_float, 0);
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("7E+1")).add(new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848"));
    Assert.assertEquals("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686918", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0980()
  {
    rc_BigInteger = (new BigDecimal("7E+1")).toBigInteger();
    Assert.assertEquals("70", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0981()
  {
    rc_boolean = (new BigDecimal("7E+1")).equals("SRJAXH296Q2HOHD;G6=OFQBP4PR8CH8Y:H28E5LTY=KMYQ>YIM?=<KFL;90K110E4T6SIG;33IAVL86E2C1L:?E@MADXR62HS9OH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\1', '\234', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '8', '\1', '\234', '\0', '\1', '8', '8', '\1', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\0', '\1', '\234', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\0', '\234', '\0', '\234', '8', '8', '\0', '8', '8', '\234', '\234', '\0', '\234', '\234'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("7E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("X8:QDGVJ6CF2CFPOQGH:ENN;>L@ALWI2QGUB5TKVPAMM<3UD3W>V1U55PDUVR5P6V<7AL<IDSQNHH2@9ND<41AV5D;G;42R;U;;4");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0986()
  {
    rc_float = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686918")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0987()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0988()
  {
    rc_int = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0989()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686848")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686918"));
    Assert.assertEquals("-25300281663413827294061918339864663381194581220517764794612669753428792445999418361495047962679640561898384733039601488923726092173224184608376674992592313740189678034570795170558363467761652042654970959809093133570250935428086587327262919456144944542601257064044846194041676826903812816523290938580750782913463467636686918", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
}
