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
public class TestSuite008 extends TestCase
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
  
  public TestSuite008() {
	
  }
//  public void testItem_0000()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
//  public void testItem_0001()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("-3")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0004()
  {
    rc_double = (new BigDecimal("-3")).doubleValue();
    Assert.assertEquals(-3.0, rc_double, 0);
  }
  public void testItem_0005()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0006()
  {
    rc_BigInteger = (new BigDecimal("-2")).toBigInteger();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0009()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("N0M1F2?@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0011()
  {
    rc_String = (new BigDecimal("-2")).toEngineeringString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0012()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0018()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E+1")).hashCode();
//    Assert.assertEquals(-1, rc_int);
//  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("876TSLEPFI1TDM3GAH27@KYE2>O:GJ8X?328XXBXGKJYBLJ>MH=R3M7WL892<2@RO57MGRS=YEE>95H3EE@SF0KIH<U<74POF4J<", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0020()
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
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0021()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0024()
  {
    rc_boolean = (new BigDecimal("1")).equals("<O93C405SOUU:TH3WB9@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0025()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0026()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("1"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0029()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("7EAUKXX<KHE1?F1J30>VN<<4WHSFPF;L;2RTKNMN=F6LVWUBS;C3;L:O4C10IF5V4501>@7UL");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0030()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '8', '\1', '8', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '8', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\1', '\1', '8', '8', '\234', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '8', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0031()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0036()
  {
    rc_int = (new BigDecimal("3.2E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2147483647")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0041()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\234', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '\0', '8', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '8', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '\234', '\1', '\1', '\1'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0050()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0051()
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
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\234', '\234', '8', '\234', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '8', '\1', '\uFFFF', '\1', '8', '\0', '8', '8', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '8', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\1', '\0', '\1', '\0', '8', '\234', '\1', '8', '\1', '\uFFFF', '\234', '8', '\1', '\1', '\234', '\uFFFF', '\234', '8', '\1', '\0', '8', '\uFFFF', '\0', '\234', '\234', '\0', '\234', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\234', '\uFFFF', '\uFFFF'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0055()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=MNVN0XKE?4WECGG>X04HU4K:AXB");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0058()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PR?TKVD=3KP2KT?5RTEPDKBD09R5U>M:>RD;MGY=XF@4>9;H>7OJ54G28T4HE3K60OTXK0QH143ID3R@=WFKX=T9LPMXSFITNWG:", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_float = (new BigDecimal("0.0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0065()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0066()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0067()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0071()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0073()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KEL6G<LPS9PU4?M8I8EAC>CDVTD@1BUVYGT7E6=T1U3WRS657I94IPO>VG0G4MGL8V:DJOQ9V36@5B8=TDD:N<?LW8=473KN=8LI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0075()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0080()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0082()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0083()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("0"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\0', '\1', '8', '\0', '8', '\uFFFF', '\234', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\234', '8', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\1', '8', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\1', '8', '\234', '\0', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF'}, -1, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0100()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0101()
  {
    rc_boolean = (new BigDecimal("1E-2147483647")).equals("05>MKF1=:;=04DD;>VER");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0102()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0103()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I2FE2M:Y2GU0LK6QNLBUFP0CWJ?G4P1:DE@S67R63:DE85NC3:O5015J?MR775?=ILCW0");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0108()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0109()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0110()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("1135879015891"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("0.0"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\0', '\0', '8', '\1', '\234', '\1', '8', '\1', '\0', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\234', '\234', '8', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\234', '\0', '8', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '8', '8', '8', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0116()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0117()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0119()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1135879015891"));
  }
  public void testItem_0120()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("6.4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_int = (new BigDecimal("6.4E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("6.4E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0132()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_int = (new BigDecimal("-1.0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0134()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1.0"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_double = (new BigDecimal("-1.0")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0145()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.03125")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("-0.03125"));
    Assert.assertEquals("0.06875", rc_BigDecimal.toString());
  }
//  public void testItem_0147()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.06875")).hashCode();
//    Assert.assertEquals(213130, rc_int);
//  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).pow(1);
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_int = (new BigDecimal("-0.03125")).precision();
    Assert.assertEquals(4, rc_int);
  }
  public void testItem_0151()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0153()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("79;BMTL:F;43C5@RHV;3<0R52JNIT84:0CM>QDXHN@B3FQSM4JUW0;4D01:WUVEXNDJ7:;VM;2PFNY8KFX><B6MRDO7LCX?2X516", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GEH9B9V@TPF3V0UX68=:=V>4CN9LN<2@KX3U7L=K1>?GS;AP;@O1Q0;W2OO1EGHW12U8TI1A:PNSP6Q7;FS2:MQ5=41");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.06875")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0159()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0163()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0164()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0165()
  {
    rc_boolean = (new BigDecimal("8")).equals("623USPS9KD=:0FIL2GEY6V1;D90I0WW=<51P=AM2V92BYBXP2?LA54R4G8TGXB;N@M7OC4XSY=24I4LO4JO07U<<1VRAVHP0SAB@");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0166()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("0.06875")).stripTrailingZeros();
    Assert.assertEquals("0.06875", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("0.06875")).add(new BigDecimal("0.06875"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("0.03")).divide(new BigDecimal("-0.03125"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-0.96", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).divide(new BigDecimal("0.03"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigInteger = (new BigDecimal("0.06875")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("-0.96")).multiply(new BigDecimal("0.03"));
    Assert.assertEquals("-0.0288", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("7OX49U2Y651=@DGX0I5P>MUQYC>@PY:UA1HM1GVVV::<@6UGNFD:0R@>GMJ1L;7N=6=;T9;TCQI6CY11?XO8:MDMX33SWQK?5F6W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0175()
  {
    rc_BigDecimal_array = (new BigDecimal("0.06875")).divideAndRemainder(new BigDecimal("-0.03125"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("0.06875")).add(new BigDecimal("-1"));
    Assert.assertEquals("-0.93125", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("-0.93125")).divideToIntegralValue(new BigDecimal("-0.0288"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-0.96")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0180()
  {
    rc_int = (new BigDecimal("-0.96")).scale();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0189()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("-0.96")).divide(new BigDecimal("1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("-0.96", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("-0.96")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-0.96"), new MathContext("precision=1 roundingMode=DOWN"));
  }
  public void testItem_0195()
  {
    rc_BigInteger = (new BigDecimal("-0.96")).unscaledValue();
    Assert.assertEquals("-96", rc_BigInteger.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0199()
  {
    rc_boolean = (new BigDecimal("-1")).equals("3L;ODIHV9=KWLAQ>OTVBTK4@3G?N:<>JXC;S18<PB=A0:8X:X2V4OS3AK6J1R44>K9Q2K307=6U:M=F?022JFV>64I6>LTFDBJ0Y");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0200()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\234', '\234', '\0', '\1', '\1', '\234', '\1', '\0', '\234', '\0', '\0', '8', '8', '8', '8', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\1', '\234', '\234', '\1', '\1', '\234', '\0', '\0', '\1', '8', '\0', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\0', '8', '\0', '\0', '\234', '8', '8', '\0', '\uFFFF', '8', '8', '\1', '\1', '8', '\uFFFF', '\234', '\0', '\0', '8', '\0', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("-0.96")).divide(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.3", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '8', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\1', '\1', '8', '\0', '\0', '\0', '\0', '\1', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0204()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 0, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0205()
  {
    rc_int = (new BigDecimal("3")).compareTo(new BigDecimal("3"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0208()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0213()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0217()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_int = (new BigDecimal("-2")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("ILV24:3OW484Q18VYYCLA1275ALF31V?TT8A9FJ<;4R>1K4IS<<:8MXUPQ7F;VC59EDHO<=XVOM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0221()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0222()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("DF83:;?QG6?0AH1Y0PMN5:EC<X<MGJAGFXEHQCCWI?KXB>10WJ@3X:E?G@2:N3C38KR?NQ6>;3A:PY=@>:C914DBGJH<OGC:GN0V");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0229()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0230()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0231()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0232()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(-2147483648, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0233()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0237()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0245()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0246()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0251()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0253()
  {
    rc_boolean = (new BigDecimal("1")).equals(";<P");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0254()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0255()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0261()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0262()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0263()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QT5<V6S<;AYDE@O9YA6RM9>E");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0269()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0270()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("32"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("31")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0281()
  {
    rc_boolean = (new BigDecimal("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CW4K6;IJ4?8GH9<P9IM>@S4FOBYKSYCADG3V961>Q2P5=922S");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0285()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0296()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).pow(1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("0.03")).divide(new BigDecimal("3E+1"), 1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_int = (new BigDecimal("-3E+1")).intValueExact();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("2000000000", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_String = (new BigDecimal("2E+9")).toString();
    Assert.assertEquals("2E+9", rc_String);
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\234', '\0', '\1', '\1', '\234', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\1', '8', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '\0', '\234', '\1', '8', '\uFFFF', '\1', '\234', '\0', '\1', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WDKKGHGT3F03QU<2:F7O>0Q9BV;FCWJ2E2HS0?FM:CWAG<S97J", new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0332()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0333()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?C2Y0<2W2@;U;>MYCDMTMHVV1DY@=WM?=E392NPLYMX2T55O>?W5N1JE0DS09HPWFO@GWN8XPLYCJHBHX:1QG3<4;B9UL4>0V46O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0340()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\0', '\1', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\1', '8', '\1', '8', '\0', '\234', '\1', '8', '\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '8', '\1', '8', '8', '\0', '\234', '\0', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\1', '\0', '8', '\0', '\0', '8', '\0', '\234', '\1', '8', '\0', '8', '\1', '\0', '8'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).pow(2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-3E+1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).toBigIntegerExact();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("2000000000.0")).add(new BigDecimal("2E+9"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("4000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("4000000000.0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3E+9")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0352()
  {
    rc_boolean = (new BigDecimal("4000000000.0")).equals("C7B>I03T:G4C?JDUI8FU6VT;EYPKOIFIQAYOIRQ@D?:CW14HAQIO>K4BQ5OVQN=WFL8=PSY>N0=GL4059=R=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0353()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("3E+9")).divide(new BigDecimal("3E+9"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4000000000.0")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0356()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0357()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3.2"));
    Assert.assertEquals("4.2", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0361()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1135879015891"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("4.2")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 0, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("4.2"));
    Assert.assertEquals("4.2", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("4.2")).divide(new BigDecimal("4.2"), 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("3.2"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_String = (new BigDecimal("3.2")).toEngineeringString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3.2"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_int = (new BigDecimal("1.0")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0374()
  {
    rc_BigInteger = (new BigDecimal("1.0")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0376()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483646")).multiply(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483647"), 2147483647, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0379()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divideToIntegralValue(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 0);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).movePointRight(-1);
    Assert.assertEquals("0.10", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0387()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=FLOOR"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0388()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0389()
  {
    rc_BigInteger = (new BigDecimal("0.10")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0390()
  {
    rc_int = (new BigDecimal("0.10")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0391()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.10")).divideToIntegralValue(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0393()
  {
    rc_int = (new BigDecimal("1.0")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\1', '\234', '8', '\1', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '\234', '\0', '\0', '8', '8', '\1', '8', '\234', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\1', '8', '8', '8', '\0', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\234', '\0', '8', '\1', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\uFFFF', '\234', '\0', '\0'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0395()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("0.10")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y67>Y5C9A:29CG0FRK?6>SCRCNX8<D?FI?CC40SBP60N4J2RXOUWG@WKWLS6CVJOG1X9<5=9M8@;>G9BFX2U6QI@45QWCR4D<0DT", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("0.003")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("0.003")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0405()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("U>:8QE75W<MFAY2R1HK1F>Q6UBAL5;>FVK0K5BAR??D:0L1;8H6S8YST0JBH8VI;0JA4J0JE3?PYPSMIB2F8SI0<7R><T6>9R8;D");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0406()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.003")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0408()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_int = (new BigDecimal("0E-2147483646")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0414()
  {
    rc_double = (new BigDecimal("0.003")).doubleValue();
    Assert.assertEquals(0.003, rc_double, 0);
  }
  public void testItem_0415()
  {
    rc_float = (new BigDecimal("0.003")).floatValue();
    Assert.assertEquals(0.003000000026077032F, rc_float, 0);
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("0.003")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YX<Y7R17THVKSYMFI;RN4DH?AE9KB8BWHWVC5SD2=RAWN2OM;7>@LX:J?7C=LD8O;P6KQUDA35CYGQ6DM7MV<YV:@XL;5C0J0I60");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\234', '\1', '\1', '\0', '\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '\1', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\0', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\0', '\1', '\1', '\234', '8', '8', '8'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0425()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0434()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '8', '\0', '\uFFFF', '\1', '\1', '8', '\234', '\234', '8', '\234', '\234', '\234', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\0', '\234', '8', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\0', '8', '\0', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '\234', '8', '8', '\1', '\234', '\uFFFF', '\0', '\234', '8', '\234', '\0', '\234', '\234', '\234', '\1'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("0.003")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0439()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.003")).add(new BigDecimal("0E-2147483646"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).max(new BigDecimal("0"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?:MH=JHS1?BIP@2OXRBIEEIW=X5<>S215YE@K;MHFRJ6L?DSOE4C<T7QEAOGJ:R9W9S6DA1K?5H0=81DGVL:K5TCT7P6086GX1L6");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0443()
  {
    rc_double = (new BigDecimal("3.2")).doubleValue();
    Assert.assertEquals(3.2, rc_double, 0);
  }
  public void testItem_0444()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0446()
  {
    rc_int = (new BigDecimal("3.2")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0447()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E-2147483646"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0449()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("0E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0452()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E-2147483646")).divide(new BigDecimal("32"), 1, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0454()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E-2147483646")).divide(new BigDecimal("3.2"), -1, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0459()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("7E-2147483338", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\234', '8'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0463()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0464()
  {
    rc_BigDecimal_array = (new BigDecimal("4E-2147483646")).divideAndRemainder(new BigDecimal("7E-2147483338"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0465()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0467()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("7E-2147483338"), 0, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0471()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E+1")).remainder(new BigDecimal("4E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).pow(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("8"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).pow(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0477()
  {
    rc_float = (new BigDecimal("3E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0478()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0479()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("2E+2147483645")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("2E+2147483645")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+2147483645")).divide(new BigDecimal("4E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("2E+2147483645")).abs();
    Assert.assertEquals("2E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '\0', '\1', '\0', '\uFFFF', '8', '8', '\0', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '8', '8', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\1', '\234', '8', '8', '\234', '\1', '\1', '\234', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\1'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("4E-2147483646"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+2147483645")).pow(2147483647, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '8', '\234', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '\234', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '\234', '\234', '8', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\1', '\234', '\1', '\1', '\234', '8', '\0', '8', '\0', '\1', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '8'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("2E+2147483645")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+2147483645")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0495()
  {
    rc_String = (new BigDecimal("2E+2147483645")).toEngineeringString();
    Assert.assertEquals("200E+2147483643", rc_String);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0499()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("4E-2147483646"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0503()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0507()
  {
    rc_double = (new BigDecimal("-9E+18")).doubleValue();
    Assert.assertEquals(-9.0E18, rc_double, 0);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).remainder(new BigDecimal("-9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).pow(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0510()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E-2147483646")).setScale(1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-2147483646")).divide(new BigDecimal("3.2E+2"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("-9E+18"));
    Assert.assertEquals("-8.99999999999999968E+18", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8.99999999999999968E+18")).setScale(2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0516()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).unscaledValue();
    Assert.assertEquals("-9", rc_BigInteger.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
//  public void testItem_0519()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9E+18")).hashCode();
//    Assert.assertEquals(-297, rc_int);
//  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigInteger = (new BigDecimal("4E-2147483646")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0524()
  {
    rc_BigDecimal_array = (new BigDecimal("-8.99999999999999968E+18")).divideAndRemainder(new BigDecimal("-8.99999999999999968E+18"));
  }
  public void testItem_0525()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0528()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0529()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E-2147483646")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).abs(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_byte = (new BigDecimal("-3E+1")).byteValueExact();
    Assert.assertEquals(-30, rc_byte);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("32.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-3E-2147483630", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-3E-2147483630")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0543()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).setScale(0, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("-9E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0545()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";E2K9RSCE74=TN");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).plus();
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).add(new BigDecimal("-3E-2147483630"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0550()
  {
    rc_int = (new BigDecimal("9E+18")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9E+18")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0552()
  {
    rc_BigDecimal_array = (new BigDecimal("9E+18")).divideAndRemainder(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=DOWN"));
  }
  public void testItem_0553()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0556()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0557()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3E-2147483630")).hashCode();
//    Assert.assertEquals(2147483537, rc_int);
//  }
  public void testItem_0558()
  {
    rc_String = (new BigDecimal("9E+18")).toPlainString();
    Assert.assertEquals("9000000000000000000", rc_String);
  }
  public void testItem_0559()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("0"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0560()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).stripTrailingZeros();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("B1KDR<KNF9X7O1Y1=5QMP4", new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).ulp();
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).subtract(new BigDecimal("1E+18"));
    Assert.assertEquals("8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("8E+18")).min(new BigDecimal("1E+18"));
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("8E+18"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("1E+18")).subtract(new BigDecimal("32"));
    Assert.assertEquals("999999999999999968", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_int = (new BigDecimal("999999999999999968")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0576()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<MRMO0O70L1B5?W9PMOG6@80VO@U51>5PAXWE@W", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_BigInteger = (new BigDecimal("4E+1")).toBigIntegerExact();
    Assert.assertEquals("40", rc_BigInteger.toString());
  }
  public void testItem_0582()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0583()
  {
    rc_int = (new BigDecimal("2")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("999999999999999968"));
    Assert.assertEquals("999999999999999968", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).stripTrailingZeros();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("2")).setScale(1);
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).add(new BigDecimal("2"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("42", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).min(new BigDecimal("4E+1"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    rc_int = (new BigDecimal("2")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("999999999999999968")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("4E+1")).intValue();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_int = (new BigDecimal("2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0594()
  {
    rc_float = (new BigDecimal("2.0")).floatValue();
    Assert.assertEquals(2.0F, rc_float, 0);
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("2.0")).divideToIntegralValue(new BigDecimal("2.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("2")).max(new BigDecimal("2"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("2.0")).remainder(new BigDecimal("2.0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0602()
  {
    rc_BigDecimal_array = (new BigDecimal("-2")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("-2")).multiply(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-8E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0608()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0609()
  {
    rc_long = (new BigDecimal("4E+1")).longValueExact();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("-8E+1")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("-8E+1")).abs();
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RJS;VUELG6WOA368EKU:5I7?3WM?<7>Y1M6OM0TLOXE?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).stripTrailingZeros();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RM@S@CN62>RA0WEQNI2G1Q;?6MF1KEGC:BO9SCM=7O02<XR6CG1=25CAWPS1DXYC>A=TV4UVYUMQ;1HG<IKO53II3473>>CS=L6K", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("-8E+1")).abs();
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(-1);
    Assert.assertEquals("214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("-8E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("1E+19")).movePointRight(1);
    Assert.assertEquals("100000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8E+1")).divide(new BigDecimal("-1E+19"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0626()
  {
    rc_boolean = (new BigDecimal("-1E+19")).equals(":<C:JJ7SRT9I>N77HS?WG:AMBHBS5N;4A8=RMT7M4L2J@NAYXJ5;2V45:PXXTB26L>3DYE5T0GVVTAWQH<WQ=8ULNN59N?0US<Q8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("-8E+1")).movePointLeft(1);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("-8")).setScale(0);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("P0:1OH2L8D<40Q7BSGNTU>EA6=YV=W?DH7VRMHT8M8>10NR0IXSBJ8WUEYUEA@9P0PE:YC0EKWUO2VXWEXIP8FBEI4I;9O7U=MSI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+19")).divideToIntegralValue(new BigDecimal("-8E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0632()
  {
    rc_long = (new BigDecimal("-8E+1")).longValue();
    Assert.assertEquals(-80L, rc_long);
  }
  public void testItem_0633()
  {
    rc_int = (new BigDecimal("-8")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0634()
  {
    rc_String = (new BigDecimal("-8")).toString();
    Assert.assertEquals("-8", rc_String);
  }
  public void testItem_0635()
  {
    rc_long = (new BigDecimal("1E+19")).longValue();
    Assert.assertEquals(-8446744073709551616L, rc_long);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("1E+19")).movePointRight(1);
    Assert.assertEquals("100000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigInteger = (new BigDecimal("-8")).toBigInteger();
    Assert.assertEquals("-8", rc_BigInteger.toString());
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-9.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).remainder(new BigDecimal("-9.00000000000000000E+18"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("-8")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("-9.00000000000000000E+18")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_String = (new BigDecimal("100000000000000000000")).toPlainString();
    Assert.assertEquals("100000000000000000000", rc_String);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0646()
  {
    rc_int = (new BigDecimal("100000000000000000000")).precision();
    Assert.assertEquals(21, rc_int);
  }
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+19")).divideToIntegralValue(new BigDecimal("-8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9.00000000000000000E+18")).divide(new BigDecimal("-9223372036854775808"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-9.22337203685477581E+18", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0653()
  {
    rc_BigDecimal_array = (new BigDecimal("-9.22337203685477581E+18")).divideAndRemainder(new BigDecimal("-9.22337203685477581E+18"));
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).remainder(new BigDecimal("100000000000000000000"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-8")).subtract(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-8")).remainder(new BigDecimal("-8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0659()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0660()
  {
    rc_String = (new BigDecimal("3E-2147483646")).toEngineeringString();
    Assert.assertEquals("3E-2147483646", rc_String);
  }
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0662()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775808"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0664()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("IAPWXG1V>9R1OF9SPJOYRB:8DRJE88P>MQD5YC6ME2OOJJXFWOEF1N8ST?SJU0JCM2AHE39JFME:XNY9CYU2F7EBKLP5J1@1H<HI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0667()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0668()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WM8L?EYYE4N6SNN8C7W;?O", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).add(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("6E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0670()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
//  public void testItem_0671()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).setScale(0, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0673()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483646")).multiply(new BigDecimal("0E-2147483646"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0674()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_float = (new BigDecimal("-32")).floatValue();
    Assert.assertEquals(-32.0F, rc_float, 0);
  }
  public void testItem_0683()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0684()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '8', '8', '\234', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '8', '\0', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\0', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0685()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("0E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0686()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0689()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).min(new BigDecimal("1"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0692()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0693()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0696()
  {
    rc_boolean = (new BigDecimal("32")).equals("QT93DA;WLV2O2J:YSH40LDD87=AYT=5N87L?8OG6VSI?5JQD=7WB4J3MC>:=?UMKHG7CF1LXLNKCUNK=H3YLKCV:5;DCM:9D?VTW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0697()
  {
    rc_int = (new BigDecimal("-9E+18")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("8E+1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_long = (new BigDecimal("4E+1")).longValue();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).negate();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\234', '\1', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '8', '8', '\0', '\0', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '\0', '\1', '8', '\234', '8', '\uFFFF', '\234', '\1', '\1', '8', '8', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\0', '\234', '\0', '\1', '8', '\1', '8', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\0', '\uFFFF', '8', '8', '\1', '\0', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\1', '\1', '\234', '8', '\0', '\234', '\0', '\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_long = (new BigDecimal("4E+1")).longValueExact();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0705()
  {
    rc_byte = (new BigDecimal("-4E+1")).byteValueExact();
    Assert.assertEquals(-40, rc_byte);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0708()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-214748364.8", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0716()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0717()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("-67108864", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("IEW3EN=4W8HL>177HBE1W=Q>35GTIU;M3W>7L1@A?JAQNTX=NC;JKJ:03OX1YXH5<DRLMCI", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("4E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).negate();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0735()
  {
    rc_long = (new BigDecimal("3.2")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0736()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divideToIntegralValue(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("4E+1"));
  }
  public void testItem_0739()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0740()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0', '\0', '\0', '\0', '\234', '\234', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\0', '\1', '\uFFFF', '8', '8', '8', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '8', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\0', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\1', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\1', '8', '8', '\1', '\0', '\234', '\1', '\234', '\1', '\234', '\234', '8', '8', '\0', '\0', '\uFFFF', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3AIXHFXM;AT6176VQ=R>;R<@Q2E8>Q70@8I?0V4:PA6GR8LQ=JDS3JRI0<<CD3=LNU;N3T=@2H9VK?02>5S3;MYFEPJ@Q@;XRA7:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0749()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0750()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0751()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0755()
  {
    rc_BigInteger = (new BigDecimal("3.2")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0757()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0758()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OHVL7MKDHT2SNY79R9<CQT=NDYAK7YPDNM5I<F@CQR=YUV37KIO1>EV;U4K6K0?X2X=9<XSI6=MNYO;?EL416WKK:=A6DWGS7EA7", new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0759()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("4E-2147483646")).multiply(new BigDecimal("-2147483648"));
    Assert.assertEquals("-8.589934592E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\234', '\234', '\234', '\0', '\1', '\1', '\234', '8', '\0', '\0', '\1', '8', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\1', '\1', '\0', '8', '\0', '\0', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '8', '\0', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '8', '\uFFFF', '8', '8', '\1', '\234', '\1', '\0', '\0', '8', '\1', '\0', '\1', '\234', '\1', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '\1', '8', '\0', '\0'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_int = (new BigDecimal("-8.589934592E-2147483637")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("-8.589934592E-2147483637")).subtract(new BigDecimal("-8.589934592E-2147483637"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0769()
  {
    rc_double = (new BigDecimal("-8.589934592E-2147483637")).doubleValue();
    Assert.assertEquals(-0.0, rc_double, 0);
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("3E+2"));
    Assert.assertEquals("-248", rc_BigDecimal.toString());
  }
//  public void testItem_0771()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+2")).hashCode();
//    Assert.assertEquals(91, rc_int);
//  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigInteger = (new BigDecimal("-248")).unscaledValue();
    Assert.assertEquals("-248", rc_BigInteger.toString());
  }
  public void testItem_0777()
  {
    rc_String = (new BigDecimal("-248")).toPlainString();
    Assert.assertEquals("-248", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0778()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0E+1"), 1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("-248")).divide(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E-7", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).min(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3W0XYXWE3IIBWFFY??;2MM?:0G>QYPI@X6LE<<4G761=A6@XTJ74IA?2YDISPAYER;VVY<;0<NL8N2;81B3O1XSW3E?>NKMO>6OI", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).stripTrailingZeros();
    Assert.assertEquals("2E-7", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SDA>DBJUDVFURL1E019IAB?OTIHA5GOOUBES>3P3SD9FQUIE0;401O:C");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0793()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).divide(new BigDecimal("2E-7"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.0000000", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E-7")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0796()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E-7")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E-7")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000")).abs();
    Assert.assertEquals("1.0000000", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_float = (new BigDecimal("1.0000000")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("2E-7")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).remainder(new BigDecimal("1"));
    Assert.assertEquals("2E-7", rc_BigDecimal.toString());
  }
//  public void testItem_0803()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2E-7")).hashCode();
//    Assert.assertEquals(69, rc_int);
//  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E-7")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).add(new BigDecimal("2E-7"));
    Assert.assertEquals("4E-7", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("4E-7")).movePointRight(-1);
    Assert.assertEquals("4E-8", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("4E-7")).divide(new BigDecimal("2E-7"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\1', '\0', '\234', '\uFFFF', '8', '8', '\234', '\1', '8', '8', '\0', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\1', '\0', '\0', '8', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '8', '\0', '8', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0809()
  {
    rc_BigInteger = (new BigDecimal("2")).toBigIntegerExact();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("4E-7")).divideToIntegralValue(new BigDecimal("1.0000000"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0812()
  {
    rc_boolean = (new BigDecimal("2E-7")).equals("YP><>FQ;D8<AGFW76UYMW52RRY;U382@S?B45P9RVHGVB4?QE7BM4FJC1V<QHPW0EG71UPE<Y?15KKDQY2HW>76;>VL0UUR9Q<6K");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("2E-7")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-7", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0821()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("2")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("2")).setScale(1);
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\0', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\234', '\0', '8', '\234', '\234', '\1', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '\0', '8', '\0', '\1', '8', '8', '\234', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\234', '8', '8', '\234', '\234', '\0', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '\234'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0833()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0838()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.003")).divide(new BigDecimal("0E+1"), -1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '\234', '\1', '\234', '8', '8', '\uFFFF', '\0', '\1', '8', '\0', '\0', '8', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\1', '\0', '8', '\0', '\0', '8', '\1', '\1', '\uFFFF', '8', '8', '\234', '\234', '8', '\uFFFF', '8', '8', '\234', '8', '\0', '\234', '8', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\234', '\0', '8'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_String = (new BigDecimal("0.003")).toEngineeringString();
    Assert.assertEquals("0.003", rc_String);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("-4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_int = (new BigDecimal("0E+1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0852()
  {
    rc_int = (new BigDecimal("0E+1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0853()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0856()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("0E+1"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\1', '\0', '\0', '\1', '8', '\1', '8', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '8', '\1', '\234', '\0', '8', '\0', '\0', '\0', '8', '\234', '8', '\234', '\0', '\uFFFF', '\234'}, -2147483648, 1, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0861()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals("9B88BO2NQ92BMH=L=6U4A7=BUVWP;0D71FUQWPHYL5Y<<4?Y5=MINR>:L6F;ABB39HOG34QU30HRXASGI6F3G:6XAVUB6BUHG>1E");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0864()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("3.2E+3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_int = (new BigDecimal("3.2E+3")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0869()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0871()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0872()
  {
    rc_String = (new BigDecimal("1E+4")).toEngineeringString();
    Assert.assertEquals("10E+3", rc_String);
  }
  public void testItem_0873()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+3")).setScale(0);
    Assert.assertEquals("3200", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+3")).divide(new BigDecimal("1E+4"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+3")).plus();
    Assert.assertEquals("3.2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3200"));
    Assert.assertEquals("3201", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_double = (new BigDecimal("3200")).doubleValue();
    Assert.assertEquals(3200.0, rc_double, 0);
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.3")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\234', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\234', '8', '8', '\uFFFF', '8', '\234', '\0', '\234', '8', '8', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\1', '8', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\0', '8', '8', '\234', '8', '\uFFFF', '8', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\1', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\234', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.3"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("0.3")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("0.3")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.3"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("3")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0892()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3201")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//    }
//  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("3")).multiply(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("3")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0898()
  {
    rc_byte = (new BigDecimal("3")).byteValueExact();
    Assert.assertEquals(3, rc_byte);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0902()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\0', '8', '\1', '\0', '\0', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\0', '8', '8', '\0', '\234', '\234', '\234', '\0', '\0', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '8', '8', '\234', '\234', '\234', '\0', '8', '\0', '\1', '8', '8', '8', '\0', '\1', '\uFFFF', '\0', '8', '\0', '\1', '\1', '\1', '\1', '\0', '8', '8', '\234', '\0', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\1'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0906()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("9")).add(new BigDecimal("9"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("18", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("3")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("18")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigInteger = (new BigDecimal("18")).toBigIntegerExact();
    Assert.assertEquals("18", rc_BigInteger.toString());
  }
  public void testItem_0916()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).toBigInteger();
    Assert.assertEquals("1000000000000", rc_BigInteger.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), 2147483647, 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0921()
  {
    rc_String = (new BigDecimal("18")).toPlainString();
    Assert.assertEquals("18", rc_String);
  }
  public void testItem_0922()
  {
    rc_float = (new BigDecimal("18")).floatValue();
    Assert.assertEquals(18.0F, rc_float, 0);
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1E+12"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0927()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).toBigInteger();
    Assert.assertEquals("1000000000000", rc_BigInteger.toString());
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '8', '8', '8', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0929()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0932()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).stripTrailingZeros();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\234', '8', '\1', '8', '\1', '\0', '\1', '\1', '8', '\uFFFF', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("-9E+18"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1.8E+19", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-9E+18"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).abs();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-5E-290", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0951()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("-5E-290")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("-5E-290")).stripTrailingZeros();
    Assert.assertEquals("-5E-290", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5E-290")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0961()
  {
    rc_int = (new BigDecimal("-5E-290")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0962()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("993SOIB0ESQ?6G=HX6RRU=7B");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0964()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '\234', '8', '\234', '\0', '\0', '\1', '\234', '8', '\1', '\0', '\0', '\1', '8', '8', '8', '\234', '8', '8', '8', '\234', '8', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\234', '8', '\234', '\uFFFF', '\1', '8', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\1', '\234', '8', '8', '8', '8', '\1', '\0', '\0', '\1', '\0'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0968()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0969()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
//  public void testItem_0972()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0973()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0975()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("A0EN:Q6R:B7?NTB9K;IFU3F38GEOG5E7<XF2O2PBT");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0976()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-5E-290")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0978()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("-5E-290")).plus();
    Assert.assertEquals("-5E-290", rc_BigDecimal.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-5E-290")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.2751677852349%", true, caught);
//  }
  public void testItem_0981()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0982()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0984()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '8', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\uFFFF', '8', '\0', '\1', '\0', '8', '\0', '\234', '\0', '\0', '8', '8', '\0', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '8', '\234', '8', '8', '\uFFFF', '\234', '\0', '8', '8', '\234', '\0', '\234', '\0', '\234', '8', '\0', '\234', '8', '\0', '8', '\1', '\234', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0988()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0989()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_String = (new BigDecimal("-3E+1")).toEngineeringString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_double = (new BigDecimal("3E+1")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("BWQG8@H3:BORPF4I8<NG2PPIN2S;K5H1XM:XU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.2751677852349%", true, caught);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
}
