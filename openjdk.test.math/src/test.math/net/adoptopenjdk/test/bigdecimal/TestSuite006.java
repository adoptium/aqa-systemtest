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
public class TestSuite006 extends TestCase
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
  
  public TestSuite006() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\0', '8', '\234', '8', '8', '\0', '\234', '\0', '\234', '\1', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\0', '8', '8', '8', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0005()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ADUMWBCWJQI?1NRSR8DG@G8YA3Y62HB;M5S7Y6T7>X8367J;0EI=QMIVYKSBKYUPMJLFLXCI9860UY2X@B1078I3PV9>@Y");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-2"));
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\0', '8', '8', '\1', '\1', '8', '\1', '\0', '\234', '\0', '8', '\0', '\1', '\234', '\1', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\1', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\1', '\234', '\1', '8', '\1', '8', '\0', '\1', '\234', '\1', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\1', '\0', '8', '\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0028()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
//  public void testItem_0029()
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
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0033()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '8', '8', '\234', '8', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '8', '\0', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\0', '\0', '\234', '8', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\0', '\0', '\0', '8', '8', '\uFFFF', '8', '\0', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0041()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TP4WCF?M5TYIDEX8J@HPX;NU9;TBNT?09E1I:AKHT;?<@8;4X@DPSV;F@5S7BVNN9WGST<20>P;04BL>XSV=8<;NS9756FAFBR2<", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '8', '\0', '\1', '\0', '\1', '\0', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\0', '\234', '\1', '\234', '\234', '\234', '8', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '8', '8', '8', '\1', '8', '\0', '\0', '8', '\1', '8', '\0', '\0', '8', '8', '\uFFFF', '8', '\1', '8', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '\0', '8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_int = (new BigDecimal("-3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0049()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3.2E-2147483646")).hashCode();
//    Assert.assertEquals(2147482655, rc_int);
//  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0054()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0056()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0057()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0058()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
//  public void testItem_0064()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("31")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("30"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_float = (new BigDecimal("30")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0075()
  {
    rc_float = (new BigDecimal("30")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L5SCSYMKX0@8@61?83J87V@5G2@KYUF?I2KS@?097TRC>?RX<E>2MI2UT>US<D6LO=M=1M6>W:UT<P0HT4A8Y;B5=AIMXIL>P148", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0080()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("30")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("30")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0085()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0086()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\234', '8', '\1', '\234', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '8', '\0', '\1', '\0', '\234', '\234', '\234', '8', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\1', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\234', '8', '8', '8', '\1', '\1', '\1', '\0', '\1', '\0', '\0', '8', '8', '8', '\234', '\uFFFF', '\1', '\234', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\0', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(1);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-30.0")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("-30.0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_int = (new BigDecimal("-30.0")).intValue();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).remainder(new BigDecimal("-30.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_int = (new BigDecimal("30")).compareTo(new BigDecimal("-3E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("30.0")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).add(new BigDecimal("0"));
    Assert.assertEquals("30.0", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).divide(new BigDecimal("30.0"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0107()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0108()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0109()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0110()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(2147483647);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).setScale(-1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("30.0"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("30.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0122()
  {
    rc_boolean = (new BigDecimal("0E-2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0123()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("0"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0126()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3E+1"), -2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//    }
//  }
  public void testItem_0127()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0133()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("GLRAM3O>0@@610IEG0LU5RJSMMQX?0KTXYJVOQUAIOCLFFV>0SFB1<A=;B@XT5XMHSI2V6QSF=:YQY<AIOEQVFST5CUEBQ0TXPJV");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).unscaledValue();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0143()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("2147483646")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0146()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483646")).divide(new BigDecimal("2147483646"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0150()
  {
    rc_BigInteger = (new BigDecimal("2147483646")).toBigInteger();
    Assert.assertEquals("2147483646", rc_BigInteger.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0153()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483646")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0154()
  {
    rc_BigInteger = (new BigDecimal("2147483646")).toBigInteger();
    Assert.assertEquals("2147483646", rc_BigInteger.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_int = (new BigDecimal("2147483646")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_int = (new BigDecimal("2147483646")).intValue();
    Assert.assertEquals(2147483646, rc_int);
  }
//  public void testItem_0159()
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
//    Assert.assertEquals("90.60402684563758%", true, caught);
//    }
//  }
  public void testItem_0160()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_int = (new BigDecimal("-2E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("-2E+9")).compareTo(new BigDecimal("2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0164()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("320.0E+2147483647"), -1, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("-2E+9"));
    Assert.assertEquals("-4.294967294E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("6.4E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("F@F;F7U@@NVQVVJDK99PF9U>7PR<<4HFRD;6QCXILRJ0YK>RN=UMO03G5VJ6:EUCSGQ5OCI4;BMT1MRY4SBOI1WPIOA4OUB:X9EI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0170()
  {
    rc_boolean = (new BigDecimal("640.0E+2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0171()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("640.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '8', '\234', '8', '\1', '8', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\1', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\1', '8', '\234', '\1', '8', '\234', '\234', '\1', '\0', '\1', '\234', '\234', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '8', '\1', '\1', '\234', '\0', '8', '\0', '\234', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '\0', '\234', '\0', '8', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
//  public void testItem_0174()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("640.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//    }
//  }
//  public void testItem_0175()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
//  public void testItem_0176()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("640.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//  }
//  public void testItem_0177()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).subtract(new BigDecimal("32"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//  }
  public void testItem_0178()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_long = (new BigDecimal("2147483647")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("32"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("-4.294967294E+18")).add(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-4294967293999999992", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("-4294967293999999992"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-34359738351999999936", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("-4294967293999999992"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0191()
  {
    rc_long = (new BigDecimal("2147483647")).longValue();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0192()
  {
    rc_int = (new BigDecimal("8")).intValue();
    Assert.assertEquals(8, rc_int);
  }
  public void testItem_0193()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValueExact();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).add(new BigDecimal("32"));
    Assert.assertEquals("2147483679", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("-4294967293999999992")).max(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("8"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3.2E+2"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_int = (new BigDecimal("8")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("8")).movePointRight(-1);
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
//  public void testItem_0200()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0201()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
//  public void testItem_0202()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//  }
//  public void testItem_0203()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).divideToIntegralValue(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.60402684563758%", true, caught);
//    }
//  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("0.8")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("0.8")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31.2", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '8', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
//  public void testItem_0209()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-31.2")).hashCode();
//    Assert.assertEquals(-9671, rc_int);
//  }
  public void testItem_0210()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0211()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '8', '8', '\uFFFF', '\1', '\234', '\0', '\234', '8', '\1', '\234', '\uFFFF', '\1', '\1', '\1', '8', '8', '\0', '\1', '8', '\0', '8', '\0', '\1', '\234', '\234', '\0', '8', '\0', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\1', '8', '\234', '\1', '8', '\0', '8', '\0', '\uFFFF', '8', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\1', '\1', '\234', '\0', '8', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '8', '\1', '8', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\234', '\1', '8', '8', '\0', '8', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\234', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '8', '\0', '\0', '\234', '\1', '\0', '\234', '\234', '\234', '8', '\1', '\1', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("0.8")).remainder(new BigDecimal("-31.2"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-31.2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0215()
  {
    rc_BigInteger = (new BigDecimal("0.8")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0.8")).subtract(new BigDecimal("-31.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0219()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.8")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-31.2")).divideToIntegralValue(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0223()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.0"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0225()
  {
    rc_String = (new BigDecimal("32.0")).toEngineeringString();
    Assert.assertEquals("32.0", rc_String);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0228()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_long = (new BigDecimal("32.0")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_short = (new BigDecimal("1.0")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0236()
  {
    rc_BigInteger = (new BigDecimal("32.0")).unscaledValue();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("1.0"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@@X?XYEHA?U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("32.0"));
    Assert.assertEquals("-33.0", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0250()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0251()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0252()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.60402684563758%", true, caught);
  }
  public void testItem_0254()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValueExact();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32.0"));
    Assert.assertEquals("64.0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0261()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3.2E-2147483646"), 1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\0', '\234', '8', '\0', '8', '\1', '\1', '8', '8', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\0', '8', '\234', '\uFFFF', '\1', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0268()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E+2")).hashCode();
//    Assert.assertEquals(991, rc_int);
//  }
  public void testItem_0269()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0270()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0272()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0273()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0274()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals(">PW6ESCQ9M81HPP>DCO:>P0HRJ;>6=1B48Y@AXEBKJ0VE5GYXALSE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0277()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0278()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0283()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\0', '8', '\1', '\1', '\234', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '8', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\1', '8', '\0', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.125E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0296()
  {
    rc_int = (new BigDecimal("-32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_String = (new BigDecimal("33")).toPlainString();
    Assert.assertEquals("33", rc_String);
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("33")).divide(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0302()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0303()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0304()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("33")).add(new BigDecimal("32"));
    Assert.assertEquals("65", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("65"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("33")).add(new BigDecimal("65"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("98", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_String = (new BigDecimal("98")).toEngineeringString();
    Assert.assertEquals("98", rc_String);
  }
  public void testItem_0312()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("33"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0314()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0315()
  {
    rc_int = (new BigDecimal("65")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("65")).divide(new BigDecimal("32"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0317()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("65")).hashCode();
//    Assert.assertEquals(2015, rc_int);
//  }
  public void testItem_0318()
  {
    rc_int = (new BigDecimal("98")).compareTo(new BigDecimal("33"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("98")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0320()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("65")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("65")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("65")).divide(new BigDecimal("65"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0337()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@D?>X4QSNYD4S");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0340()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0341()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0342()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0343()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0352()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("8"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0356()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
//  public void testItem_0357()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0363()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0364()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigInteger = (new BigDecimal("-32")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
//  public void testItem_0373()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0374()
  {
    rc_BigInteger = (new BigDecimal("2")).toBigInteger();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0380()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0381()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-32"));
  }
  public void testItem_0382()
  {
    rc_BigInteger = (new BigDecimal("-32")).toBigIntegerExact();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("XD6;G@JQSQ;6J9TRSW253E5Q;OG2JG881B1XTKA0V3UW4>RJR46TB<R98DMDI>==AM>YIQQEF6UX<9:TPSX5M311L2BVI=Q5@5CD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointLeft(2147483647);
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0392()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0394()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("-32")).min(new BigDecimal("1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0398()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("62")).divide(new BigDecimal("-32"), 2147483647, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("62"));
    Assert.assertEquals("63", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0401()
  {
    rc_boolean = (new BigDecimal("1")).equals("PO2HQXEN2WF=J<<5>52MI0QE64MOGP@XOHIB3GNR5XGJ;YQQ><?XA7EB2U>>NPF;MH4BDN>3U3KNL:FAL15L1@O06WYK9N05>@M:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("-3.2E-2147483646")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("63")).multiply(new BigDecimal("-0.03125"));
    Assert.assertEquals("-1.96875", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("63"));
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("-1.96875")).add(new BigDecimal("-32"));
    Assert.assertEquals("-33.96875", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("63")).multiply(new BigDecimal("1"));
    Assert.assertEquals("63", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("63")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0414()
  {
    rc_int = (new BigDecimal("63")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("63")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("63", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("63")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("64")).movePointRight(1);
    Assert.assertEquals("640", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_byte = (new BigDecimal("64")).byteValueExact();
    Assert.assertEquals(64, rc_byte);
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("63")).min(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("640")).multiply(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("640.0", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_float = (new BigDecimal("63")).floatValue();
    Assert.assertEquals(63.0F, rc_float, 0);
  }
  public void testItem_0427()
  {
    rc_String = (new BigDecimal("640")).toEngineeringString();
    Assert.assertEquals("640", rc_String);
  }
  public void testItem_0428()
  {
    rc_int = (new BigDecimal("63")).intValueExact();
    Assert.assertEquals(63, rc_int);
  }
  public void testItem_0429()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_long = (new BigDecimal("640")).longValue();
    Assert.assertEquals(640L, rc_long);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("63")).add(new BigDecimal("640"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("703", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0437()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("703")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("640"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("640")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("640", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("640")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("640", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_int = (new BigDecimal("9223372036854775808")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0445()
  {
    rc_int = (new BigDecimal("640")).compareTo(new BigDecimal("703"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0446()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0447()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0448()
  {
    rc_String = (new BigDecimal("640")).toPlainString();
    Assert.assertEquals("640", rc_String);
  }
  public void testItem_0449()
  {
    rc_int = (new BigDecimal("9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0450()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).divide(new BigDecimal("9223372036854775808"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("640")).subtract(new BigDecimal("9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).max(new BigDecimal("-9E+18"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("640")).stripTrailingZeros();
    Assert.assertEquals("6.4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0457()
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
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0460()
  {
    rc_boolean = (new BigDecimal("9223372036854775808")).equals("GD?=T1<IE5SM1FI1RPG@HDTENFXFD>SJ69J");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0461()
  {
    rc_int = (new BigDecimal("9223372036854775808")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).negate();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).scaleByPowerOfTen(1);
    Assert.assertEquals("-9E+19", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).toBigIntegerExact();
    Assert.assertEquals("-9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).min(new BigDecimal("9223372036854775808"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("-9E+19")).negate();
    Assert.assertEquals("9E+19", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_String = (new BigDecimal("-9E+18")).toPlainString();
    Assert.assertEquals("-9000000000000000000", rc_String);
  }
  public void testItem_0470()
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
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("640")).divide(new BigDecimal("-1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).remainder(new BigDecimal("-9E+18"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+18")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("640")).divide(new BigDecimal("0E+18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0477()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\1', '8', '\234', '\0', '\234', '\1', '\234', '\1', '\1', '8', '8', '8', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '8', '\234', '\1', '8', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '8', '\1', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\234', '\1', '\0', '\0', '8', '8', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\234'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("9E+19")).setScale(1);
    Assert.assertEquals("90000000000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_String = (new BigDecimal("2147483647")).toString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0481()
  {
    rc_int = (new BigDecimal("90000000000000000000.0")).precision();
    Assert.assertEquals(21, rc_int);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("2147483647"), -1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-4.19095159E+9", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("90000000000000000000.0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0484()
  {
    rc_boolean = (new BigDecimal("90000000000000000000.0")).equals("XU>4A;LHK7UJNS4C5KWQNU47YI46MLPTADKR@72QD2MHB9ECLPF9DH1?;T0U70UILK>XO@G;;JK7WB=C1?HQD:??0DJTC5=?AT;Y");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("90000000000000000000.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("9.00000000000000000000E+2147483666", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).ulp();
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+19")).multiply(new BigDecimal("90000000000000000000.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal_array = (new BigDecimal("9E+19")).divideAndRemainder(new BigDecimal("-9E+18"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0491()
  {
    rc_long = (new BigDecimal("1E+18")).longValue();
    Assert.assertEquals(1000000000000000000L, rc_long);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0493()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0494()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).add(new BigDecimal("-9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0495()
  {
    rc_long = (new BigDecimal("9E+18")).longValueExact();
    Assert.assertEquals(9000000000000000000L, rc_long);
  }
//  public void testItem_0496()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("90000000000000000000.0E+2147483647")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).abs();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_int = (new BigDecimal("90000000000000000000.0E+2147483647")).precision();
    Assert.assertEquals(21, rc_int);
  }
  public void testItem_0499()
  {
    rc_double = (new BigDecimal("9E+18")).doubleValue();
    Assert.assertEquals(9.0E18, rc_double, 0);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("1E+18"));
    Assert.assertEquals("9E+36", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9E+18"));
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_String = (new BigDecimal("90000000000000000000.0E+2147483647")).toString();
    Assert.assertEquals("9.00000000000000000000E+2147483666", rc_String);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).toBigIntegerExact();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).pow(-2147483648, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2:KDL51FGSEC81OGT5MTB:4E8I2VUH8JN3VU982WH=I8<RGNA3ONUL8C6O4Q3CDXW2>L3>KUN>VM?U3L5D8NC<W43P5AU?;JCL5U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0516()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).stripTrailingZeros();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).setScale(2147483647, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0518()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).divide(new BigDecimal("2E+9"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
//  public void testItem_0519()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("90000000000000000000.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0520()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '\1', '\uFFFF', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\1', '\234', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '8', '\1', '\0', '\uFFFF', '\1', '\234', '\0', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '\234', '\234', '\0'}, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0525()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("90000000000000000000.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0526()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@A<CS?XQUDI@OSUTAQ>H3AD9H8LJHDA5;OY<9<YU1WD>OVDMXU188OV@88:A;UJMFL6YHD435U3I=@0HL@AMOL0P=2216LX?:O2E");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0529()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0530()
  {
    rc_int = (new BigDecimal("2E+9")).intValueExact();
    Assert.assertEquals(2000000000, rc_int);
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E-10", rc_BigDecimal.toString());
  }
//  public void testItem_0533()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0534()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0537()
  {
    rc_int = (new BigDecimal("2E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2000000001", rc_BigDecimal.toString());
  }
//  public void testItem_0539()
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
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0540()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\1', '\1', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\234', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\0', '8', '\1', '\1', '\1', '\1', '\0', '\uFFFF', '8', '8', '\0', '8'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0541()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("90000000000000000000.0E+2147483647")).max(new BigDecimal("90000000000000000000.0E+2147483647"));
    Assert.assertEquals("9.00000000000000000000E+2147483666", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0544()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '8', '\1', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\234', '\234', '\0', '\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '8', '\234', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\1', '8', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '8', '8', '8', '\0', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '\234', '8', '\0', '\0', '\uFFFF', '\234', '\0', '8', '8', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0547()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("2000000001")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("2000000001"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0550()
  {
    rc_boolean = (new BigDecimal("8")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0551()
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
  public void testItem_0552()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0556()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0557()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2000000001")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0559()
  {
    rc_int = (new BigDecimal("8")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_float = (new BigDecimal("320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0562()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2000000001")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0563()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0564()
  {
    rc_boolean = (new BigDecimal("-1")).equals(">J<0??VY0T9N69OSN8DVD2V0V900YUK0<LHT3O4D@RV4M1WGW>25;FQ46@8963U>C5DSSTSJ3F89LV<3D74PS9:N3M?>J3SKW>3H");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = (new BigDecimal("8")).max(new BigDecimal("1"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0568()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0571()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0572()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0573()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0574()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '\234', '\0', '\234', '\0', '\1', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '8', '\234', '\234', '8', '8', '\1', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\234', '\1', '\234', '\234', '\234', '\1', '\1', '8', '\234', '8', '\0', '\234', '8', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\234', '8', '8', '8', '\0', '\uFFFF', '\234', '\1', '\0', '\1', '\0', '\1', '\0', '\234', '\234', '8', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0579()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("8"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("8"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0588()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointRight(-1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0589()
  {
    rc_String = (new BigDecimal("9")).toEngineeringString();
    Assert.assertEquals("9", rc_String);
  }
//  public void testItem_0590()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0591()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("9")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0593()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("1"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("9")).stripTrailingZeros();
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("9"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0603()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0604()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
//  public void testItem_0609()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
  public void testItem_0610()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("33")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).pow(0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0615()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0616()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("33")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0630()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("I6ES6BABM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0636()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0637()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(-1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("3")).stripTrailingZeros();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigInteger = (new BigDecimal("3")).toBigInteger();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\1', '8', '\234', '8', '8', '\0', '8', '8', '\uFFFF', '\0', '\0', '\0', '\0', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '8', '\234', '\0'}, 1, 1, new MathContext("precision=1 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0643()
  {
    rc_long = (new BigDecimal("3")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0644()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
//  public void testItem_0645()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3")).hashCode();
//    Assert.assertEquals(93, rc_int);
//  }
  public void testItem_0646()
  {
    rc_BigInteger = (new BigDecimal("3")).toBigIntegerExact();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '8', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\uFFFF', '\0', '\1', '8', '8', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\234', '\234', '\234', '\uFFFF', '\0', '8', '8', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '8', '8', '\1', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '\0', '\234', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("1.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0649()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).max(new BigDecimal("1"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("3")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0654()
  {
    rc_BigDecimal_array = (new BigDecimal("3")).divideAndRemainder(new BigDecimal("2"));
  }
  public void testItem_0655()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_double = (new BigDecimal("3")).doubleValue();
    Assert.assertEquals(3.0, rc_double, 0);
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0660()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0661()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_short = (new BigDecimal("2")).shortValueExact();
    Assert.assertEquals(2, rc_short);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_int = (new BigDecimal("3")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("3")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("2")).stripTrailingZeros();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("2")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0673()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0674()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0677()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0681()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("C?TLDK6OI3B93GYRF57H@X3R8QKH?XY");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0683()
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
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0684()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\234', '8', '8', '\1', '\234', '8', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '8', '\0', '\0', '\0', '8', '\0', '\234', '8', '\234', '\1', '\234', '8', '\1', '\234', '8', '\0', '\234', '\234', '8', '8', '\0', '\0', '\0', '\1', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '\1', '8', '\234', '8', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '8', '8', '\234', '8', '\1', '\1'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0695()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234', '8', '\1', '\0', '\uFFFF', '8', '\1', '8', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '\234', '8', '\234', '\234', '\234', '\0', '8', '\0', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0696()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0699()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("BO8<?IJUETGOOFK8MAKIHRY03972V4KJRAQF4WN6WATMFBAGV<A3<9ML3Q8MJ?02DSGBM>X:GE3DMG705K3J?BHVPD92J4OA;J09");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U8K5RJ7>GE;?IW<8NS@JXAQ7VT9QD5?IJ6U0HLR:FOQ@AWCM<B=>=C?;CDWMPCG:8<<J07TWQIV4=2P689=@YV>NOKBLHAUV<3X;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0705()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0706()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0707()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0714()
  {
    rc_boolean = (new BigDecimal("1")).equals("EO0C1J4KF1VB9237WTT97E3YRRN=1R>C710D8<=2B82CJ9>ASP6S;P051CUJ1HD0H<A035::=HYVN6CCGVXQ;NVXN9U3V:5N4N9V");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-22", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("3.0", rc_BigDecimal.toString());
  }
  public void testItem_0719()
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
  public void testItem_0720()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
//  public void testItem_0723()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(-1);
    Assert.assertEquals("1797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248583680", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024.0", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("-22")).min(new BigDecimal("32.0"));
    Assert.assertEquals("-22", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32.0")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("1024.0")).add(new BigDecimal("32"));
    Assert.assertEquals("1056.0", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("XUQ6N77U90BNE6X@EUC9IGIER;?TGUA:RBG54G>3E98Q0NR9:G6A:H5?DIMJS<<S?9UFS0AA4>FJVXS>QHDT1TBC7?KHQ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_int = (new BigDecimal("1056.0")).precision();
    Assert.assertEquals(5, rc_int);
  }
  public void testItem_0735()
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
  public void testItem_0736()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0737()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("L@PSG3T9IVQ=S4D;S2ANX:J8UAE06BQP?ESETEO886DP87>G<B6?Q3?:U26XB3WO?3FF5:KF>MBO7JHKV<8L?QA3DQ6EJKW83EO;");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0738()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("-22"), -1, 1);
    Assert.assertEquals("-4.0909090909090909E+17", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("1056.0")).remainder(new BigDecimal("-4.0909090909090909E+17"));
    Assert.assertEquals("1056.0", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_String = (new BigDecimal("-22")).toEngineeringString();
    Assert.assertEquals("-22", rc_String);
  }
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("-4.0909090909090909E+17")).divide(new BigDecimal("-4.0909090909090909E+17"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_String = (new BigDecimal("-22")).toString();
    Assert.assertEquals("-22", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0745()
  {
    rc_boolean = (new BigDecimal("1")).equals("?H@2SR>I1B23B=CVWB6T02OP1>@X58WRODD8YKW@TEE=BV6GYAO8V@WCYTXS=8N7=4QA?3E6JMPJHTDM7H2TAG63;O:NJ;ERIX82");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0746()
  {
    rc_int = (new BigDecimal("1056.0")).compareTo(new BigDecimal("1056.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0747()
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
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1056.0")).divide(new BigDecimal("9E+18"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
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
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0751()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1056.0"));
    Assert.assertEquals("-1055.0", rc_BigDecimal.toString());
  }
//  public void testItem_0753()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("-22"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("-1055.0")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-189656625727974307209326432036948096421964448739766471411857938027330910122930108392421984357569056470975184195957673499767208999868384712820733261772232080420282655658261602590438992045360742036000041276420166309131335314932900210314928030095390132429911706645372682943018776925869861374719176247624251725578240.0", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("-1055.0")).movePointLeft(0);
    Assert.assertEquals("-1055.0", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0762()
  {
    rc_String = (new BigDecimal("-22")).toPlainString();
    Assert.assertEquals("-22", rc_String);
  }
  public void testItem_0763()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("-22")).plus();
    Assert.assertEquals("-22", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("-1055.0")).divide(new BigDecimal("-1055.0"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0767()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0768()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1055.0")).hashCode();
//    Assert.assertEquals(-327049, rc_int);
//  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0770()
  {
    rc_String = (new BigDecimal("-22")).toPlainString();
    Assert.assertEquals("-22", rc_String);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '8', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '8', '\1', '8', '\234', '\0', '8', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\234', '8', '\1', '\234', '\1', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\0', '8', '\234', '\1', '\1', '8', '8', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\234', '8', '\234', '\234', '8', '\234', '\1', '\0', '\234', '\0', '\1', '\0', '\1', '8', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '8', '\234', '\1', '\uFFFF', '\0'}, -2147483648, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("5E-324"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0787()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '\234', '8', '\1', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '\234', '\234', '\0', '\234', '\234', '8', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\1', '\0', '8', '\1', '8', '8', '\234', '8', '8', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '8', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\uFFFF', '8', '8', '\1', '\0', '8', '8', '8', '\1', '\0', '8', '\234', '\0', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0795()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("32"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0800()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0808()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0809()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0812()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0813()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  public void testItem_0814()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0817()
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
  public void testItem_0818()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\1', '\234', '\1', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '8', '\1', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '8', '\234'}, 1, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9223372036854775808")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0824()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0826()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0827()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0828()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0829()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0830()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0837()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0838()
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
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0844()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(0);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0848()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0854()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0859()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0860()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0864()
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
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("-2147483648"));
    Assert.assertEquals("4611686018427387904", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).movePointRight(1);
    Assert.assertEquals("-21474836480", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigInteger = (new BigDecimal("4611686018427387904")).toBigIntegerExact();
    Assert.assertEquals("4611686018427387904", rc_BigInteger.toString());
  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\234', '8', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\234', '\234', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '8', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\0', '\234', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '\234', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4611686018427387904")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\0', '\0', '8', '\0', '\234', '\234', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\234', '\0', '\234', '\0', '8', '8', '8', '\1', '\1', '8', '\0', '\234', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '8', '8', '\0', '8', '\234', '\0', '\0', '\1', '\0', '\0', '8', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0871()
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
  public void testItem_0872()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '8', '8', '\0', '8', '\0', '\234', '\0', '8', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\1', '8', '8', '\234', '8', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\234', '8', '\0', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\234', '\234', '\234', '\1', '8', '\0', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\1', '8', '8', '\uFFFF', '8'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_String = (new BigDecimal("-2147483648")).toString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("4611686018427387904"), 1);
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("9E+18"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0882()
  {
    rc_int = (new BigDecimal("0E+18")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0883()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).add(new BigDecimal("4611686018427387904"));
    Assert.assertEquals("4611686018427387907.2", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal_array = (new BigDecimal("9E+18")).divideAndRemainder(new BigDecimal("4611686018427387907.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0886()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigInteger = (new BigDecimal("0E+18")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0889()
  {
    rc_String = (new BigDecimal("4611686018427387904")).toEngineeringString();
    Assert.assertEquals("4611686018427387904", rc_String);
  }
  public void testItem_0890()
  {
    rc_int = (new BigDecimal("0E+18")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0892()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4611686018427387904")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0893()
  {
    rc_float = (new BigDecimal("0E+18")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387904")).remainder(new BigDecimal("4611686018427387904"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387907.2")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).negate();
    Assert.assertEquals("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).divideToIntegralValue(new BigDecimal("-17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387907.2")).negate();
    Assert.assertEquals("-4611686018427387907.2", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387907.2")).negate();
    Assert.assertEquals("-4611686018427387907.2", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_String = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).toString();
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_String);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4611686018427387907.2")).divide(new BigDecimal("4611686018427387907.2"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387907.2")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4611686018427387907.2", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_BigDecimal_array = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("4611686018427387907.2")).divide(new BigDecimal("-4611686018427387907.2"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).negate();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("-4611686018427387907.2"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("-4611686018427387907.2")).max(new BigDecimal("-1.0"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\0', '\uFFFF'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-4611686018427387907.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).multiply(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.10", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("-4611686018427387907.2")).multiply(new BigDecimal("-4611686018427387907.2"));
    Assert.assertEquals("21267647932558653995975703482420795811.84", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0917()
  {
    rc_boolean = (new BigDecimal("-4611686018427387907.2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0918()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0919()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("-4611686018427387907.2"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0920()
  {
    rc_BigInteger = (new BigDecimal("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8")).toBigInteger();
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836", rc_BigInteger.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("-4611686018427387907.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-20", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).plus(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigInteger = (new BigDecimal("1.0")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
//  public void testItem_0925()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//  }
  public void testItem_0926()
  {
    rc_int = (new BigDecimal("0.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_String = (new BigDecimal("-2E-20")).toString();
    Assert.assertEquals("-2E-20", rc_String);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).subtract(new BigDecimal("-2E-20"));
    Assert.assertEquals("1.00000000000000000002", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("-4611686018427387907.2"));
    Assert.assertEquals("-4611686018427387907.2", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1.00000000000000000002"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-2E-20", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0933()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("-2E-20")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("-2E-20")).divide(new BigDecimal("-0.1"), java.math.RoundingMode.UP);
    Assert.assertEquals("2.0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("2.0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).negate();
    Assert.assertEquals("-2.0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(2147483647);
//    Assert.assertEquals("320", rc_BigDecimal.toString());
//  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("2.0E-19"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2.0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2.0E-19")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0946()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.0E-19")).divide(new BigDecimal("2.0E-19"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0947()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2.0E-19")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).add(new BigDecimal("0.000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.000", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    rc_long = (new BigDecimal("0.000")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("0.000")).add(new BigDecimal("320"));
    Assert.assertEquals("320.000", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).divide(new BigDecimal("320"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-22", rc_BigDecimal.toString());
  }
//  public void testItem_0953()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.0E-19")).remainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0954()
  {
    rc_BigInteger = (new BigDecimal("6E-22")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("320")).pow(0, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_double = (new BigDecimal("2.0E-19")).doubleValue();
    Assert.assertEquals(2.0E-19, rc_double, 0);
  }
//  public void testItem_0957()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).remainder(new BigDecimal("6E-22"));
//    Assert.assertEquals("3.20000000000000000000000E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("2.0E-19"));
    Assert.assertEquals("2.0E-19", rc_BigDecimal.toString());
  }
//  public void testItem_0959()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147482656, rc_int);
//  }
//  public void testItem_0960()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0961()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).stripTrailingZeros();
    Assert.assertEquals("2E-19", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_float = (new BigDecimal("2E-19")).floatValue();
    Assert.assertEquals(1.999999936531045E-19F, rc_float, 0);
  }
//  public void testItem_0964()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals(1, rc_int);
//    }
//  }
  public void testItem_0965()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).abs();
    Assert.assertEquals("2.0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("PQXKL9PXJTQV2F3DRSO7<@NKF3K38;3ILH3V>IS?BVJ=557NLI:IK42A>B=;2PQKCHP:7QM;60N8N37OK;U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0969()
  {
    rc_BigDecimal_array = (new BigDecimal("2.0E-19")).divideAndRemainder(new BigDecimal("2E-19"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("2E-19")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0971()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("2.0E-19")).compareTo(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals(1, rc_int);
//    }
//  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("2.0E-19")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-19", rc_BigDecimal.toString());
  }
//  public void testItem_0974()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0975()
  {
    rc_BigInteger = (new BigDecimal("0.1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0976()
  {
    rc_int = (new BigDecimal("0.1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0977()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("0.1"));
  }
//  public void testItem_0978()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("320.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0981()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E-19")).add(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.93959731543625%", true, caught);
//    }
//  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("0.1"));
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_String = (new BigDecimal("0.1")).toString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2E-19")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0987()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=1 roundingMode=DOWN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("2E-19")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-19", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.93959731543625%", true, caught);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0995()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E-2147483647")).hashCode();
//    Assert.assertEquals(-2147483618, rc_int);
//  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0998()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0999()
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
}
