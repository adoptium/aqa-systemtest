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
public class TestSuite060 extends TestCase
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
  
  public TestSuite060() {
	
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@BB1I9R0YF@6LUN8:F3J0LWQ4?4:TEF<4HI9DKABJ:Q13S>M;V06V50NYUA?NXR0:245QHXW;>J>WXG8<Q;7V");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("-3E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0008()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-3.2E-2147483646")).divideAndRemainder(new BigDecimal("-3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0009()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E-2147483646")).divide(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\0', '\1', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '\234', '8', '\1', '8', '\234', '\0', '\1', '\0', '\1', '8', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '8', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\0', '\1', '\234', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\1', '\234', '\234', '\1', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '8', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3E-2147483646")).byteValueExact();
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
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '8', '\234', '\234', '8', '\0', '8', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\234', '\1', '\0', '\1', '\0', '\0', '8', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '\1', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate();
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("2")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0018()
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
  public void testItem_0019()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";VHN0EXPP43LC?6?ODNO1=CY1IKNHCYGS:K7YTKTSR>1R2LN2DLTW0LM4;I?1WO>6X@BBKF5BKRJS4ST3JF1SK=5ECS;6?U>PTPG");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0023()
  {
    rc_BigDecimal_array = (new BigDecimal("6E+1")).divideAndRemainder(new BigDecimal("6E+1"));
  }
  public void testItem_0024()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("<7R652J=L=TA8F53GU=4M5LQC14:6T@>@G04RPNND@BW=EBEH16IGV9R2Q;<O214@AWQPGEXHQVQGG0@ENGBFFARH:LL0YO;ER3S");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0025()
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
  public void testItem_0026()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0028()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6E+1")).hashCode();
//    Assert.assertEquals(185, rc_int);
//  }
  public void testItem_0029()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0031()
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
  public void testItem_0032()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0033()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0034()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0035()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-9E+18"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0043()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0044()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).subtract(new BigDecimal("6E+1"));
    Assert.assertEquals("-9.00000000000000006E+18", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0047()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divideToIntegralValue(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0050()
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
  public void testItem_0051()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0052()
  {
    rc_String = (new BigDecimal("-9E+18")).toPlainString();
    Assert.assertEquals("-9000000000000000000", rc_String);
  }
  public void testItem_0053()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9E+18")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0054()
  {
    rc_double = (new BigDecimal("-9E+18")).doubleValue();
    Assert.assertEquals(-9.0E18, rc_double, 0);
  }
  public void testItem_0055()
  {
    rc_String = (new BigDecimal("-9E+18")).toEngineeringString();
    Assert.assertEquals("-9E+18", rc_String);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-9.00000000000000006E+18")).add(new BigDecimal("-9.00000000000000006E+18"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1.800000000000000012E+19", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9.00000000000000006E+18")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("-9.00000000000000006E+18")).subtract(new BigDecimal("-9.00000000000000006E+18"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_int = (new BigDecimal("-9.00000000000000006E+18")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\0', '\0', '\1', '\1', '\234', '\234', '\234', '\0', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '\0', '\1', '\0', '\1', '\234', '\234', '8', '\234', '\1', '8', '\234', '\0', '\0', '\0', '\234', '8', '\234', '\234', '\1', '8', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '8', '\0', '\1', '\1', '\0', '\1', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '8', '\0', '\1', '\uFFFF'}, -1, 1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0065()
  {
    rc_short = (new BigDecimal("-3.2E+2")).shortValueExact();
    Assert.assertEquals(-320, rc_short);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigInteger = (new BigDecimal("-3.2E+2")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0068()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S1:S2T=PAHH3BT<1US3I=548FDRPEUN<59>1MMW46SE88BRF<Q0BJ6SBXH<U7YF0X;L5SV>I;<TFUOMXXNPLYGIO;G:E<X4TNMVQ", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).movePointRight(-2147483648);
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E+2")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\234', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\234', '8', '\1', '\uFFFF', '8', '\0', '\0', '\0', '\234', '\0', '\1', '\1', '8', '8', '\234', '8', '\0', '\1', '8', '8', '\1', '\1', '\0', '8', '\234', '\234', '\uFFFF', '\1', '8'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("-3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0080()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-3.2E-2147483646")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(1);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0083()
  {
    rc_boolean = (new BigDecimal("-3.2E-2147483646")).equals("2UOL6UJ57BMQR9F1M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0084()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0086()
  {
    rc_boolean = (new BigDecimal("320.0")).equals("R94A=O2EH@M:LHQE6I9:Q=98YIEP2375SG8Q9X7=586=0X=I2H7=S7YWQWBWU<:2OQXP:?;2>@JIIYFVIJ43R:056MTQR524BNW4");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("-3.2E-2147483646"), 1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("320.0")).abs();
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0090()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0091()
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
  public void testItem_0092()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0094()
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
  public void testItem_0095()
  {
    rc_long = (new BigDecimal("320.0")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
//  public void testItem_0096()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("320.0")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0097()
  {
    rc_int = (new BigDecimal("320.0")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).pow(1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_int = (new BigDecimal("320.0")).intValueExact();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1E+12")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0101()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("320.0"));
  }
  public void testItem_0102()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0103()
  {
    rc_double = (new BigDecimal("320.0")).doubleValue();
    Assert.assertEquals(320.0, rc_double, 0);
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0105()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("320.0"));
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0110()
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
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).multiply(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E-2147483634", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3<UU7P@SHN86O9A@DYRK0L38X32XO<L7I2JNA2PL0?PVKSUHB>D?5U@P213XVVPA@P6I@WUCY1;<:OE9DR4IYA?PUVP@6LSSCU9O", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\0', '\234', '\1', '\234', '\234', '\1', '\0', '\234', '\1', '\234', '\0', '\1', '\0', '\0', '\0', '\234', '8', '\234', '\0', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '\1', '\0', '\234', '\1', '\1', '\1', '8', '\1', '\234', '\1', '8', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0119()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+12")).divideAndRemainder(new BigDecimal("9223372036854775807"));
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0121()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483634")).movePointLeft(-1);
    Assert.assertEquals("3E-2147483633", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483633")).plus();
    Assert.assertEquals("3E-2147483633", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483633")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0127()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+12")).remainder(new BigDecimal("3E-2147483633"), new MathContext("precision=0 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0128()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483633")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483634")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("-1E+12"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-1E+12")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483634")).abs();
    Assert.assertEquals("3E-2147483634", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3E-2147483634"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '8', '\0', '8', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\0', '8', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\234', '\1', '\1', '\234', '\0', '\0', '8', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\1', '\1', '\0', '8', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '8', '8', '\1', '\0', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\234', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0137()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0138()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483634")).divide(new BigDecimal("2E+9"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483634", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("-1E+12"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0F<J6P;>GCHS@AK0L=GMRFOPU8S4", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_int = (new BigDecimal("2E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0145()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1E+12")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0146()
  {
    rc_int = (new BigDecimal("2E+9")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0147()
  {
    rc_float = (new BigDecimal("3E-2147483634")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0148()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0149()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).movePointLeft(-1);
    Assert.assertEquals("-10000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).ulp();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-1E+12"));
    Assert.assertEquals("0E-13", rc_BigDecimal.toString());
  }
  public void testItem_0153()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0154()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0155()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-10000000000000")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0156()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10000000000000")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).plus();
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("2E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0163()
  {
    rc_boolean = (new BigDecimal("0")).equals("W27DVIPW:Y8ETIM057UJ2:WJ4CWE?11:8JDWFM>DMEW?PRC<N7VNX9UF:DHC=P>K;L387O;SHY2NM2T;?8OR6XSREY2QLM;51<VP");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("-10000000000000")).negate();
    Assert.assertEquals("10000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigInteger = (new BigDecimal("-10000000000000")).toBigInteger();
    Assert.assertEquals("-10000000000000", rc_BigInteger.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_String = (new BigDecimal("10000000000000")).toString();
    Assert.assertEquals("10000000000000", rc_String);
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("-10000000000000")).movePointLeft(0);
    Assert.assertEquals("-10000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("-10000000000000"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-2036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("-10000000000000")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+13", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0179()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).toBigInteger();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0180()
  {
    rc_boolean = (new BigDecimal("2E+9")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10000000000000")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0182()
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
  public void testItem_0183()
  {
    rc_int = (new BigDecimal("-2036854775808")).compareTo(new BigDecimal("-10000000000000"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-10000000000000"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0185()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-10000000000000")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0186()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("T7RE21@BU:P1<B668YM5F5C9YN::9<Y68CDNYA4>932A==>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("-2036854775808")).min(new BigDecimal("2E+9"));
    Assert.assertEquals("-2036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).pow(0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("-10000000000000")).movePointRight(0);
    Assert.assertEquals("-10000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal_array = (new BigDecimal("-10000000000000")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0195()
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
  public void testItem_0196()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\0', '8', '\0', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\0', '8', '\234', '8', '\234', '\234', '8', '8', '8', '\0', '8', '\0', '\234', '\0', '\234', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '8', '8', '\234', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).remainder(new BigDecimal("-10000000000000"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal_array = (new BigDecimal("-10000000000000")).divideAndRemainder(new BigDecimal("2E+9"));
  }
  public void testItem_0199()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("-2036854775808")).divideToIntegralValue(new BigDecimal("2E+9"));
    Assert.assertEquals("-1018.000000000", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_String = (new BigDecimal("2E+9")).toString();
    Assert.assertEquals("2E+9", rc_String);
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("-1018.000000000")).divide(new BigDecimal("-10000000000000"), -1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).ulp();
    Assert.assertEquals("1E+9", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_double = (new BigDecimal("-2E+9")).doubleValue();
    Assert.assertEquals(-2.0E9, rc_double, 0);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).movePointLeft(1);
    Assert.assertEquals("200000000", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).subtract(new BigDecimal("2E+9"));
    Assert.assertEquals("-4E+9", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("200000000")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-200000000", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\0', '\234', '\1', '\0', '\1', '\0', '\1', '\0', '\1', '\1', '\1', '\0', '8', '\234', '8', '8', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\0', '\1', '\1', '\0', '\0', '\0', '\234', '\1', '\234', '\0', '\234', '\1', '\0', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\1', '8', '8', '\0', '\0', '\234', '\1', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '\0', '8', '8', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\uFFFF', '8', '\234', '\1', '8', '8', '8', '\0', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\0', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("200000000")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.00000000E+2147483655", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal_array = (new BigDecimal("200000000.0E+2147483647")).divideAndRemainder(new BigDecimal("200000000.0E+2147483647"));
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("200000000.0E+2147483647"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
  {
    rc_int = (new BigDecimal("-4E+9")).intValue();
    Assert.assertEquals(294967296, rc_int);
  }
  public void testItem_0214()
  {
    rc_float = (new BigDecimal("200000000")).floatValue();
    Assert.assertEquals(2.0E8F, rc_float, 0);
  }
//  public void testItem_0215()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("200000000.0E+2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0216()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("200000000.0E+2147483647")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("-200000000")).multiply(new BigDecimal("200000000"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+16", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("-200000000")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("200000000", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigInteger = (new BigDecimal("-4E+9")).toBigInteger();
    Assert.assertEquals("-4000000000", rc_BigInteger.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("200000000")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("2E+8", rc_BigDecimal.toString());
  }
//  public void testItem_0221()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("200000000.0E+2147483647")).precision();
//    Assert.assertEquals(9, rc_int);
//  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("-4E+9")).negate();
    Assert.assertEquals("4E+9", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("200000000.0E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0224()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("200000000.0E+2147483647")).divide(new BigDecimal("2E+8"), java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("-200000000")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+8", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LADRPJAKDNT9PL<4U7Q17NNK;J818I==WWF?HDG3JRGNCKKMTX=9LG>ONRC23=W6X2EO:IO5A:8BH4IC=UDHL=9WP75?3M?X;FRS", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("2E+8")).divide(new BigDecimal("2E+8"), 0);
    Assert.assertEquals("1E+8", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("-4E+16")).abs();
    Assert.assertEquals("4E+16", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0231()
  {
    rc_int = (new BigDecimal("2E+8")).intValue();
    Assert.assertEquals(200000000, rc_int);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\1', '8', '\1', '8', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0234()
  {
    rc_BigDecimal_array = (new BigDecimal("-200000000")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("-200000000")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+8", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E+8")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    rc_BigInteger = (new BigDecimal("2E+8")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+16")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("4E+16")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("1.28E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_String = (new BigDecimal("4E+16")).toEngineeringString();
    Assert.assertEquals("40E+15", rc_String);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("-200000000")).abs();
    Assert.assertEquals("200000000", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("200000000")).subtract(new BigDecimal("2E+8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_int = (new BigDecimal("4E+16")).compareTo(new BigDecimal("4E+16"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0250()
  {
    rc_boolean = (new BigDecimal("1.28E-2147483629")).equals(":OIX9S2F43QCQG5O9BXN1<H<PKVIHCUW>AMC<9SVVDH3RLQ=IAW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("2E+8")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+8", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("KC7P5X96;O5F@;GOP15TGW?LLX@FTNWYD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0255()
  {
    rc_String = (new BigDecimal("1.28E-2147483629")).toEngineeringString();
    Assert.assertEquals("128E-2147483631", rc_String);
  }
  public void testItem_0256()
  {
    rc_double = (new BigDecimal("1.28E-2147483629")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0257()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0258()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("1.28E-2147483629")).max(new BigDecimal("0"));
    Assert.assertEquals("1.28E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("FU:3F8MO1;OSV?<NJ3@LOMQW?GU0WX5EYW>G0U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0265()
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
  public void testItem_0266()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1.28E-2147483629"));
    Assert.assertEquals("1.28E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("1.28E-2147483629")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483631", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0E-2147483631"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483631")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483631", rc_BigDecimal.toString());
  }
  public void testItem_0271()
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
  public void testItem_0272()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1E+12"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("1.28E-2147483629")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("KD3L8H:GC33A2V0T2DV;XL0Y;:0CK5=OX<SDN58@EN:?K<:MH=BI4LER03JA2OQYT7T5GBY@>=0:11U0IB==H2DWIB<9@ONOE:C@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-2147483631"), new MathContext("precision=1 roundingMode=HALF_UP"));
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
//      rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0E-2147483631"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0279()
  {
    rc_BigDecimal_array = (new BigDecimal("1.28E-2147483629")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0280()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483631")).subtract(new BigDecimal("1.28E-2147483629"));
    Assert.assertEquals("-1.28E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0283()
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
  public void testItem_0284()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0E-2147483631"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0288()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0289()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483631")).divide(new BigDecimal("1"), -1, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0291()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0292()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0295()
  {
    rc_int = (new BigDecimal("0E-2147483631")).scale();
    Assert.assertEquals(2147483631, rc_int);
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
//  public void testItem_0298()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0299()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0302()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0305()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E+1"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\1', '8', '8', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\234', '8', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '8', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\1', '\uFFFF', '\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0309()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9E+18"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("9E+18"));
    Assert.assertEquals("-9.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("-9.00000000000000000E+18")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0315()
  {
    rc_int = (new BigDecimal("2E+9")).scale();
    Assert.assertEquals(-9, rc_int);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("-9.00000000000000000E+18")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+18")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0318()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0319()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("9E+18"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0320()
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
  public void testItem_0321()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9.00000000000000000E+18")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("2E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-9", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).toBigIntegerExact();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).pow(1);
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).add(new BigDecimal("2E+9"));
    Assert.assertEquals("4E+9", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("0E-9")).add(new BigDecimal("-1"));
    Assert.assertEquals("-1.000000000", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigInteger = (new BigDecimal("0E-9")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("-1.000000000")).movePointLeft(1);
    Assert.assertEquals("-0.1000000000", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("0E-9")).divideToIntegralValue(new BigDecimal("-2E+9"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-18")).pow(2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0335()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\0', '\uFFFF', '8', '8', '\234', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '8', '\0', '\0', '\234', '\234', '8', '\234', '8', '\1', '8', '8', '\234', '\234', '8', '\234', '8', '\1', '\0', '\234', '\uFFFF', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\234', '\234', '8', '\234', '8', '\234', '\0', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\0', '8', '8', '8', '8', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\234', '8'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0336()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_short = (new BigDecimal("0E-18")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).ulp();
    Assert.assertEquals("1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigInteger = (new BigDecimal("-1.000000000")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0342()
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
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("1E-18")).stripTrailingZeros();
    Assert.assertEquals("1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("1E-18")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1E-18", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("-1E-18")).multiply(new BigDecimal("-2E+9"));
    Assert.assertEquals("2E-9", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).add(new BigDecimal("-1E-18"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).multiply(new BigDecimal("0E-18"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E-36", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_int = (new BigDecimal("0E-18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0350()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).movePointLeft(1);
    Assert.assertEquals("-900000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigInteger = (new BigDecimal("0E-36")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0355()
  {
    rc_int = (new BigDecimal("0E-18")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("8E+18")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("-8E+18")).negate();
    Assert.assertEquals("8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("8E+18")).abs();
    Assert.assertEquals("8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal("0");
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("-8E+18")).min(new BigDecimal("0"));
    Assert.assertEquals("-8E+18", rc_BigDecimal.toString());
  }
  public void testItem_0361()
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
  public void testItem_0362()
  {
    rc_BigInteger = (new BigDecimal("8E+18")).toBigIntegerExact();
    Assert.assertEquals("8000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointLeft(-1);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_String = (new BigDecimal("300")).toEngineeringString();
    Assert.assertEquals("300", rc_String);
  }
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("300")).stripTrailingZeros();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_int = (new BigDecimal("-8E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("-8E+18")).subtract(new BigDecimal("-8E+18"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0369()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("-900000000000000000")).subtract(new BigDecimal("300"));
    Assert.assertEquals("-900000000000000300", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\1', '\1', '\234', '8', '\1', '\1', '\1', '8', '\uFFFF', '\1', '\234', '\234', '\0', '\1', '\0', '8', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\1', '\1', '\0', '8', '8', '8', '\0', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\234', '\0', '\234', '8', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("3E+2"));
    Assert.assertEquals("-268", rc_BigDecimal.toString());
  }
//  public void testItem_0375()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0376()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-268")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0377()
  {
    rc_int = (new BigDecimal("0E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0378()
  {
    rc_int = (new BigDecimal("0E+18")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0379()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-268")).add(new BigDecimal("0E+18"));
    Assert.assertEquals("-268", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-900000000000000300")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-900000000000000300")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("-268")).add(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-3E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0386()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+2")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0392()
  {
    rc_boolean = (new BigDecimal("0")).equals("ACK?0NRJA6CWH0ROJS72KWF13ENF3K7OKX1UNN?1YCT?4=>9DU=OFNF<Q1V;SRO=>R?JXM>7Y@37BY4<44AXK<NYQI16>H>1CN1Y");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0393()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
//  public void testItem_0394()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-900000000000000300")).subtract(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0395()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0396()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-900000000000000300"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0398()
  {
    rc_int = (new BigDecimal("9223372036854775807")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0399()
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
//  public void testItem_0400()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0401()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).negate();
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '8', '\234', '\234', '\0', '\1', '8', '\234', '\uFFFF', '8', '\0', '\0', '8', '\uFFFF', '8', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '8', '\234', '\234', '\234', '\234', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\1', '\234', '8', '\uFFFF', '\0', '8', '\uFFFF', '8', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '8', '\0', '8', '8', '8', '\0', '\234', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\0', '8', '\234', '8', '\0', '\1', '\1', '\234', '\1', '8', '\uFFFF', '8', '8', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\234', '8'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
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
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-3.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0413()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).multiply(new BigDecimal("-3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0414()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divideToIntegralValue(new BigDecimal("-3E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-3.0E+2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("-3.0E+2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0420()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("-3.0E+2")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\1', '8', '8', '\1', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '8', '\1', '8', '\0', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '8', '8', '\0', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\1', '8', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\234', '\1', '\0', '8', '\234', '\0', '\1', '8', '\1', '\1', '\uFFFF', '\0', '8', '\234', '\1', '\0', '\234', '\234', '\1', '\234', '\234', '\0', '8', '\234', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0424()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0427()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0428()
  {
    rc_byte = (new BigDecimal("0E-2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0429()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0430()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-3.2E-2147483646")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0436()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0437()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0439()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-3.2E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0444()
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
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(1);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0451()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0452()
  {
    rc_double = (new BigDecimal("3E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0454()
  {
    rc_int = (new BigDecimal("3E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0455()
  {
    rc_String = (new BigDecimal("-3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("-3.2E-2147483646", rc_String);
  }
  public void testItem_0456()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\0', '8', '\0', '\1', '\1', '\234', '8', '\1', '\234', '\234', '\1', '8', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '8', '\234', '8', '8', '\234', '\1', '8', '\1', '\1', '\1', '\0', '\uFFFF', '8', '\0', '8', '\234', '\0', '\1', '\234', '\1', '8', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\234', '\0', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '\0', '\0'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).add(new BigDecimal("-3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-6E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).multiply(new BigDecimal("3E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0459()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).plus();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0463()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-6E-2147483646"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0466()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).remainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("-6E-2147483646")).abs();
    Assert.assertEquals("6E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0469()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("3E-2147483646"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0470()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("3E-2147483646"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0474()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0475()
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
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\1', '\0', '\0', '8', '\1', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\234', '\1', '8', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '8', '\1', '8', '\uFFFF', '8', '8', '8', '8', '\1', '\1', '8', '\0', '\234', '\1', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0478()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0479()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).multiply(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("-3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
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
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\1', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\1', '8', '\234', '\uFFFF', '\0', '\0', '\0', '8', '\234', '8', '\0', '8', '\0', '\234', '\uFFFF', '\1', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\234', '8', '\1', '8', '\0', '\0', '8', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '\1', '8', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\234', '8', '\1', '8', '\0', '8', '\234', '8', '\uFFFF', '\1', '\0', '\234', '\0', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0483()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-3E-2147483645"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0484()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483645")).add(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("-2.68E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483645")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_float = (new BigDecimal("1E+1")).floatValue();
    Assert.assertEquals(10.0F, rc_float, 0);
  }
  public void testItem_0490()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0491()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0492()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("-3E-2147483645"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).pow(1);
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
//  public void testItem_0496()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("3E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0497()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483645")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483645")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0499()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0500()
  {
    rc_long = (new BigDecimal("0E-2147483646")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0501()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).abs();
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?5FOOWU63QNAUJHVLL<VS4X??N?8S>SWEP04D4>3IK834QAGG59NC;IIA>7AXGNGVVBK0SAMDOM?1D05C6PUT<H7T0MG?X2TP62?", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">6XYC?4K0251WK3K8TSE0;Q6<D=:L=L39EMS40ANBDGYQEY6VXK1D92FC;UQTV8Q4?:?RGCF0BC;?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0505()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E-2147483645")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).add(new BigDecimal("-3E-2147483645"));
    Assert.assertEquals("-2.7E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).max(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("-2.7E-2147483645")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).ulp();
    Assert.assertEquals("1E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_byte = (new BigDecimal("0E-2147483646")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
//  public void testItem_0513()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("-2.7E-2147483645"), -2147483648, java.math.RoundingMode.HALF_EVEN);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0514()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\0', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8', '\0', '\1', '8', '8', '\uFFFF', '8', '\234', '\1', '8', '\0', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '8', '\0', '\1', '\0', '\0', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '8', '\1', '\0', '\234', '\uFFFF', '8', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '8', '8', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\0', '8', '\1', '\1', '8', '\234', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\0'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).max(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).negate();
    Assert.assertEquals("-3E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0523()
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
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("3E-2147483646"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JCFJK4294;DVL0I70Y2AJUT8>FAT6:C;HI3DUVOW9C?WM8SQ0I?A1;3<<>", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0533()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E-2147483646"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0536()
  {
    rc_int = (new BigDecimal("3E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
//  public void testItem_0537()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E-2147483646")).hashCode();
//    Assert.assertEquals(-2147483557, rc_int);
//  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate();
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
//  public void testItem_0543()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("10")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E-2147483647"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divide(new BigDecimal("2E+9"), 1);
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0550()
  {
    rc_boolean = (new BigDecimal("1E+1")).equals("V72Y30RLKKTRNM;SJGRA31NJ:XI>M2X:0ODF");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).remainder(new BigDecimal("1E+1"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0553()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0556()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0557()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0558()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigInteger = (new BigDecimal("0E+9")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E-2147483646"), 1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("0E+9"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
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
      rc_BigDecimal = new BigDecimal("33RL1POKRC9W>V9EB=2E2T5LJR1F<DY5X8F0J;>HO@;H9PSF2W=HV1UXH;JMV1EDUJJJVFFIUGN1FK8Y1Q5=C5GNE=EGD<6R8JFW");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_int = (new BigDecimal("1E+1")).intValueExact();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+9")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).min(new BigDecimal("1E+1"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus();
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0576()
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
  public void testItem_0577()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("0E+9"), 1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0579()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\1'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0580()
  {
    rc_int = (new BigDecimal("0E+9")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).pow(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YJKVCIA3HCLSC7QP975RW4E3X@PQ>WR5>5DU6=:ES?LWXIV=G6C8=W3XIQKSYI?Q<4=V7LCMWE9Y94UAJS63RX07X8YT@=VHV6?P", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0587()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0589()
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
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0592()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).max(new BigDecimal("-1"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\234', '\0', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '8', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '\0', '\0', '8', '\1', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\1', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\1', '\234'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0599()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0600()
  {
    rc_String = (new BigDecimal("0E+9")).toEngineeringString();
    Assert.assertEquals("0E+9", rc_String);
  }
  public void testItem_0601()
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
  public void testItem_0602()
  {
    rc_int = (new BigDecimal("1E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).multiply(new BigDecimal("0E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_int = (new BigDecimal("-1E+1")).intValueExact();
    Assert.assertEquals(-10, rc_int);
  }
  public void testItem_0609()
  {
    rc_BigInteger = (new BigDecimal("0E+9")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0610()
  {
    rc_long = (new BigDecimal("-1E+1")).longValue();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+18")).divide(new BigDecimal("0E+9"), 1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("320.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0E+9"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    rc_int = (new BigDecimal("0E+18")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).subtract(new BigDecimal("0E+18"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+18")).divide(new BigDecimal("0E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0620()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("0E+9"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0621()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("9223372036854775807")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0622()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+18")).divide(new BigDecimal("0E+18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0623()
  {
    rc_long = (new BigDecimal("0E+9")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+9")).remainder(new BigDecimal("0E+9"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0625()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+9")).divideAndRemainder(new BigDecimal("0E+9"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483639", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0E-2147483639"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).abs();
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_long = (new BigDecimal("0E+9")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0632()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0634()
  {
    rc_int = (new BigDecimal("9223372036854775807")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("0E-2147483639"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0636()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("320.0E+2147483647"), 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NEVE2AEIV@@E13W1G1YDI?;E;T?WPD74RB0LPK:7RUO>NCHKHO>@QJB?LN2B8>=A@PT3=VUJ3=20Y8TSHX0XXOIDBS805ONUERR:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(1);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0645()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("0E+9"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0646()
  {
    rc_BigDecimal_array = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0647()
  {
    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("0E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_int = (new BigDecimal("0E+9")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3E+1"));
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).multiply(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+10", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0658()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+9")).remainder(new BigDecimal("0E+10"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(-1);
    Assert.assertEquals("17976931348623157081452742373170435679807056752584499659891747680315726078002853876058955863276687817154045895351438246423432132688946418276846754670353751698604991057655128207624549009038932894407586850845513394230458323690322294816580855933212334827479782620414472316873817718091929988125040402618412485836.8", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("5.39307940458694712443582271195113070394211702577534989796752430409471782340085616281768675898300634514621376860543147392702963980668392548305402640110612550958149731729653846228736470271167986832227605525365401826913749710709668844497425677996370044824393478612434169506214531542757899643751212078552374575104E+309", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("0E+10")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GDKBXOQMQP=6M:DK;QNBKWSMDWMKYKSMAUP3D54O>L>29E9O4K@F8UAKQL9YX549EWVGOTDK5:45460677?P=6FKB@=SNO26<2Q1", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0E+9"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0678()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0679()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0682()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0683()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("5752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_long = (new BigDecimal("5752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).multiply(new BigDecimal("2E+308"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("5752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776")).movePointLeft(1);
    Assert.assertEquals("575261803155941026606487755941453941753825816082703989116535925770103234496091324033886587624854010148929468651246023885549828246046285384859096149451320054355359713844964102643985568289245852621042779227056428615374666358090313434130587389862794714479353043853263114139962166978941759620001292883789199546777.6", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_String = (new BigDecimal("2E+308")).toEngineeringString();
    Assert.assertEquals("200E+306", rc_String);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_int = (new BigDecimal("5752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0696()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0698()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("575261803155941026606487755941453941753825816082703989116535925770103234496091324033886587624854010148929468651246023885549828246046285384859096149451320054355359713844964102643985568289245852621042779227056428615374666358090313434130587389862794714479353043853263114139962166978941759620001292883789199546777.6")).hashCode();
//    Assert.assertEquals(-1457388607, rc_int);
//  }
  public void testItem_0699()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).divideToIntegralValue(new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+617", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0708()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\1', '8', '\0', '\1', '\1', '8', '\uFFFF', '\0', '8', '\234', '8', '\234', '\0', '\1', '8', '8', '\1', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\234', '\234', '\234', '\uFFFF', '8', '8', '\234', '\0', '\0', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '8', '8', '8', '\1', '\1', '\1', '8', '\1', '\1', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
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
      rc_BigDecimal = (new BigDecimal("5752618031559410266064877559414539417538258160827039891165359257701032344960913240338865876248540101489294686512460238855498282460462853848590961494513200543553597138449641026439855682892458526210427792270564286153746663580903134341305873898627947144793530438532631141399621669789417596200012928837891995467776")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0710()
  {
    rc_int = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).precision();
    Assert.assertEquals(309, rc_int);
  }
//  public void testItem_0711()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0714()
  {
    rc_BigInteger = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+617")).unscaledValue();
    Assert.assertEquals("359538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736", rc_BigInteger.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\1', '8', '8', '\uFFFF', '\0', '8', '8', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '\1', '8', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '8', '\234', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\1', '\0', '\1', '\1', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0719()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0722()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0725()
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
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0728()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0729()
  {
    rc_float = (new BigDecimal("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
//  public void testItem_0730()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=0 roundingMode=UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0731()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0732()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).add(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0736()
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
  public void testItem_0737()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\234', '\234', '\234', '8', '\234', '\uFFFF', '8', '8', '\1', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\1', '8', '\1', '\0', '\234', '8', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\0', '\1', '\1', '\234', '\1', '\0', '\1', '\0', '\0', '\0', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '\234', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
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
      rc_BigDecimal = new BigDecimal("@DXAD1T@;;2CQ5IEF4LVBHDDEKLQJSXP7A@6TA>H84DR5W6TJTNJHTXE@8A7PB9PVA@SN8LI8Q6N?J3KAY8KBIA4TK", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).movePointRight(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616", rc_BigDecimal.toString());	
    } else {
    	Assert.assertEquals("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
    }
  }
  public void testItem_0741()
  {
    rc_int = (new BigDecimal("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0742()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("3.59538626972463141629054847463408713596141135051689993197834953606314521560057077521179117265533756343080917907028764928468642653778928365536935093407075033972099821153102564152490980180778657888151737016910267884609166473806445896331617118664246696549595652408289446337476354361838599762500808052368249716736E+616")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+616", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\0', '\1', '\1', '8', '\1', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs();
    Assert.assertEquals("35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0747()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0748()
  {
    rc_boolean = (new BigDecimal("-1")).equals("UA2KV62>9ORXTWS@?0CR8PS1?K<X6HAGA@V");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divide(new BigDecimal("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0750()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).add(new BigDecimal("35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_String = (new BigDecimal("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).toString();
    Assert.assertEquals("-35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_String);
  }
  public void testItem_0758()
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
  public void testItem_0759()
  {
    rc_String = (new BigDecimal("-1.0")).toPlainString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '8', '\1', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '8', '\234', '\234', '\234', '\1', '\0', '\1', '\234', '\1', '\234', '\234', '\0', '\1', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\1', '\0', '\1', '\0', '\uFFFF', '\0', '8', '8', '\1', '\1', '\234', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '\234', '\0', '\234', '\0', '\uFFFF', '8', '\0', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\234', '8', '\uFFFF'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).multiply(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-0.10", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_int = (new BigDecimal("-0.10")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.0")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("35953862697246314162905484746340871359614113505168999319783495360631452156005707752117911726553375634308091790702876492846864265377892836553693509340707503397209982115310256415249098018077865788815173701691026788460916647380644589633161711866424669654959565240828944633747635436183859976250080805236824971673600000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    rc_String = (new BigDecimal("-0.10")).toEngineeringString();
    Assert.assertEquals("-0.10", rc_String);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("-1"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).add(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+308", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '\1', '\234', '\1', '8', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\1', '8', '\1', '8', '8', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\1', '8', '8', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\1', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\1', '\1', '8', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\0', '8', '\234', '\1', '\0', '\234', '8', '\234', '\0', '\234', '8', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).plus();
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NYESBTIML>:=PVK>VU44AT4", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0785()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("-1"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0786()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0790()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("-2")).multiply(new BigDecimal("-2"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0793()
  {
    rc_int = (new BigDecimal("-2")).intValue();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("S:31EI0JSF>T60Y:=0GDX@T7B6X?;L<=<U>N0WK5X@VF66MMMN5N<B4QSF8423FDOANMC=10XDK9NWM:VYQVU0WSHD>7EK<:42:T", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0795()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0796()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("4")).stripTrailingZeros();
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_double = (new BigDecimal("4")).doubleValue();
    Assert.assertEquals(4.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0799()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("WCO;;PCSY:L1QUD4>FH;2KVL<H1=LOSN:S@EMQ0NH;<:>=W");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_String = (new BigDecimal("3")).toString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("4")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0806()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0808()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4")).hashCode();
//    Assert.assertEquals(124, rc_int);
//  }
  public void testItem_0809()
  {
    rc_BigDecimal_array = (new BigDecimal("4")).divideAndRemainder(new BigDecimal("4"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0810()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_String = (new BigDecimal("4")).toString();
    Assert.assertEquals("4", rc_String);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("4"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("4")).plus();
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '\1', '8', '\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\1', '\0', '\0', '8', '\1', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '\0', '8', '8', '8', '\234', '\1', '\234', '\234', '\234', '\1', '\1', '8', '\1', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '\234', '8', '8', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\234', '8', '\234', '8', '8', '8', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\234'}, -1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0815()
  {
    rc_int = (new BigDecimal("4")).intValueExact();
    Assert.assertEquals(4, rc_int);
  }
  public void testItem_0816()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\1', '8', '\1', '\1', '\0', '\234', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\1', '8', '\0', '\0', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '8', '\1', '\234', '8', '8', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\1', '\234', '\0', '\1'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigInteger = (new BigDecimal("8")).toBigInteger();
    Assert.assertEquals("8", rc_BigInteger.toString());
  }
  public void testItem_0822()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("3E+2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\234', '\234', '\1', '\1', '\0', '\1', '\0', '\1', '8', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\234', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '8', '8', '\234', '\234', '8', '\0', '\uFFFF', '\0', '8', '8', '8', '\234', '8', '\0', '8', '\1', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0825()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, 1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0827()
  {
    rc_boolean = (new BigDecimal("-1")).equals("WGIE6FS>I2:T9:1PKO3U1=691GSA?P1=XHBASSSDB;G85R4I6X0AFDFDSU:L95EK;SO6TPINPH<1BWG15?F9LNGEQ?V=X?SS?KKF");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1.0"), 2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0830()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0832()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0834()
  {
    rc_boolean = (new BigDecimal("0")).equals("Y5Y4D9O3UY7CGO<IC0FDL<V5PM2=TB9IAFIC654:;M4YQKCG01OEV1<YRR382521X12T00RAIF0<Q3S:?5QJ2FS=F;AJWK1YNL1O");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0835()
  {
    rc_BigInteger = (new BigDecimal("-1.0")).unscaledValue();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0837()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0838()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '8', '8', '\234', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '8', '8', '\0', '8', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '\0', '\uFFFF', '8', '\1', '\1', '\0', '\1', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '\0', '\234', '8', '\uFFFF', '8', '8', '8', '8', '\0', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("F2=DB2DR<EF9KM::;E2FSP8OXWSQWW;:NGL8:N96HVML8TO4ESCMV?0EYU<T6LWWSHOSW9:LUH=:BL<MP5W7SU@=1;LUNGUP=KPN");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0841()
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
  public void testItem_0842()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\234', '\234', '8', '8', '\0', '\0', '8', '\0', '\234', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\1', '8', '\234', '\0', '\0', '\234', '\0', '\234', '\0', '\234', '8', '\0', '\1', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\0', '\234', '\1', '\1', '\1', '8', '\0', '\uFFFF', '8', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\0', '\0', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '8', '8', '8', '\1', '\uFFFF', '8', '\234', '\0', '8', '\1', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\234', '\234', '8', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\234', '\234', '8', '8', '\uFFFF', '\1', '8', '8', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\0', '8', '\0', '8', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '8', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\1', '8', '8', '\234', '\234', '\1', '8', '\0', '\0', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0844()
  {
    rc_BigInteger = (new BigDecimal("-1.0")).unscaledValue();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0845()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("UH92=75P>E7GDJ@<:G57C84<RCUCNU@KW1N8HKO607Y:AG<LYS1>0H=B9X6;N:@>L@35KA7MD15;R@E");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0848()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\0', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\0', '8', '\0', '8', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '8', '\0', '\234', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\1', '\234', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\1', '\234', '\1', '\1', '\0', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_int = (new BigDecimal("-1.0")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0854()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0857()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0858()
  {
    rc_int = (new BigDecimal("3")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0859()
  {
    rc_short = (new BigDecimal("3")).shortValueExact();
    Assert.assertEquals(3, rc_short);
  }
  public void testItem_0860()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\1', '\1', '\uFFFF', '\1', '8', '\1', '8', '\0', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\234', '\1', '\0', '\234', '\234', '\0', '\0', '\234', '8', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\1', '8', '\uFFFF', '\0'}, 0, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
//  public void testItem_0866()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\0', '8', '\234', '\234', '\0', '\0', '8', '\0', '8', '8', '\1', '\1', '\1', '\0', '\1', '\1', '\234', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\0', '8', '\uFFFF', '\0', '8', '8', '\1', '\1', '\0', '\uFFFF', '8', '8', '\1', '8', '8', '8', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '8', '\234', '\234', '8', '\0', '8', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '8', '\uFFFF', '\234', '\0', '8', '\234', '\234', '\1', '\uFFFF', '8', '\234', '\1', '8', '\234'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-2147483648, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '8', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\234', '\234', '\234', '8', '\0', '8', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\0', '\1', '\0', '\234', '\234', '\1', '\234', '\0', '\0', '8', '\uFFFF', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '8', '\0', '8', '\uFFFF', '\234', '\234', '8', '\0', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '8', '\234', '8', '8', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\234', '\0', '8', '8', '\1', '\234', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0871()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).max(new BigDecimal("9E+37"));
    Assert.assertEquals("9E+37", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '8', '8', '\0', '\0', '\234', '\0', '\234', '8', '\0', '\0', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\1', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\1', '8', '\0', '\uFFFF', '8', '\0', '\234', '\1', '\0', '8', '8', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '8', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("9E+37"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1, 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0877()
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
  public void testItem_0878()
  {
    rc_int = (new BigDecimal("1E-2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0879()
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
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9E+37")).subtract(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).movePointRight(-1);
    Assert.assertEquals("9000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigInteger = (new BigDecimal("9E+37")).toBigInteger();
    Assert.assertEquals("90000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("??B7027@FUWUT1HR;PXOMKR3EQ8LV6ULB6=D6HE?", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9E+37")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_String = (new BigDecimal("0.0")).toPlainString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("9000000000000000000000000000000000000"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0892()
  {
    rc_int = (new BigDecimal("9E+37")).compareTo(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("9E+37")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9000000000000000000000000000000000000")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0895()
  {
    rc_float = (new BigDecimal("9000000000000000000000000000000000000")).floatValue();
    Assert.assertEquals(8.999999813669171E36F, rc_float, 0);
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000000000000000000000")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).min(new BigDecimal("1"));
    Assert.assertEquals("0E+37", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0900()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0901()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("1:EBYM02<Q37=Y?AADI=ABJB61P@P?W9K>2WH2CK71JEH7S=X9>>W@T75;1QJ?OJ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+37")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0904()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\uFFFF', '\234', '\234', '\1', '\234', '8', '\0', '\234', '\1', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '8', '\0', '\1', '8', '\1', '\uFFFF', '\234', '8', '\234', '\1', '8', '\0', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '\0', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '8', '\0', '\234', '\0', '\1', '\0', '8', '8', '\1', '8', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\0', '8', '\1', '\0', '\1', '8', '\0', '\234', '\1', '8', '\1', '\0', '8', '8', '\234', '8', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\1', '8', '\234', '\1', '\0', '\234'}, 1, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9000000000000000000000000000000000000"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9000000000000000000000000000000000000")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0911()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0913()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0914()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9000000000000000000000000000000000000")).divide(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).setScale(2147483647, 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000000000000000000000")).min(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0918()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("0E+37")).longValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0922()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0E+37")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_float = (new BigDecimal("0E-2147483647")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0933()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("1E+2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0934()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("XIARHO1IR>:S4H1OEXMN5H48?TDJ>D@4VSHRBGCY2:FME8HGJ04AOCHE<Y=>8GW0QF2;;7NRKV08AAPO8>@T2S3X=U6Q1HE:0F<D");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("1"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  // Excluded temporarily because performance of remainder with large exponents is very slow (many minutes).
  // At MAXINT exponent IBM Java returns 1E+2147483647.
  //public void testItem_0938()
  //{
    //rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    //Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  //}
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).abs();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0943()
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
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">TY>M4PV1LU7>4B79OC5>9CU?D=AR:B6:2XW8DH30OR67VKU?CS2GWFKWIFGQ1J;0WCXIBLSGN4PS7<XL>TJQ5XS7UUX>VKSW3?=");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0950()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0952()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0956()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1E+2147483647"), 0, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0957()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0959()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("0"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0960()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).min(new BigDecimal("0"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0966()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0968()
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
  public void testItem_0969()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0970()
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
  public void testItem_0971()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0975()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0976()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=0 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus();
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).plus();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("1E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0984()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("HPKO>2O<??VAWAVBHJ3ULR3KAU;OV8PAG>LVM6YDQ6M8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_int = (new BigDecimal("1E+2147483647")).compareTo(new BigDecimal("1E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6DA;6=L>=<4W>ULMBRKGIY3OQRH0FJ?DBWOY1=TCKQ7EJ?L8<U602BSFE492YJ9DO6RLM?ED;ESBI9DLWS9FC>1:2LRDDGC@I09D");
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
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("0"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0997()
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
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\0', '\234', '8', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\1', '\0', '\1', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\1', '8', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '8', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0999()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
}
