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
public class TestSuite002 extends TestCase
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
  
  public TestSuite002() {
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775800")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_int = (new BigDecimal("-9E+18")).compareTo(new BigDecimal("9223372036854775800"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '8', '\234', '\1', '\1', '\0', '\234', '\0', '8', '8', '\234', '\234', '\1', '\234', '\234', '\1', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '8', '8', '\234', '\1', '8', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\1', '\234', '8', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\1', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0005()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775800")).divide(new BigDecimal("-9E+18"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '\0', '\234', '\1', '\1', '\1', '8', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\1', '\1', '\1', '\234', '\0', '\234', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\1', '\1', '8', '\0', '\0', '\1', '\1', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("-9E+18"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).pow(0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0015()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0016()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VG<WXN02ORHVB:UY3<7QJB5:UF<MHU193XCEV:3>BE?00@KRK?I?FFTLBW?W<CR2OTX9D@NM7<K60:QR7QFRN=IILAUFGG;9;EYX", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0017()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0019()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0028()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("86.57718120805369%", true, caught);
//  }
  public void testItem_0029()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\0', '\uFFFF', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0030()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).toBigInteger();
    Assert.assertEquals("-9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\1', '8', '\1', '\0', '\234', '8', '8', '\0', '\234', '\1', '\0', '\0', '\1', '\1', '\0', '8', '\234', '\234', '\234', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '\234', '\0', '\234', '8', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\234', '8', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '\1', '\0', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '\1', '\0', '8', '\234', '8', '\0', '\0', '8', '\uFFFF', '8', '\0', '\0', '8', '\0', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0037()
  {
    rc_String = (new BigDecimal("-9E+18")).toPlainString();
    Assert.assertEquals("-9000000000000000000", rc_String);
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("-9E+18"));
  }
  public void testItem_0040()
  {
    rc_int = (new BigDecimal("3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0041()
  {
    rc_BigInteger = (new BigDecimal("-9E+18")).toBigIntegerExact();
    Assert.assertEquals("-9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0042()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0043()
  {
    rc_int = (new BigDecimal("-9E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\0', '8', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0045()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\1', '\234', '\0', '\1', '8', '\1', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\1', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\234', '8', '8', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '8', '\1', '8', '\1', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\0', '8', '\0', '\234', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("27", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3?TXUKDKQ:Y675I:B;?7>DDNJ@1<<8GNFFJX:J4>V<9P;@M?DF8JW;?5GS77LC1>4Q>V:TGE;7HJ>1RGX9<3747WVY@@75:I<VIM", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0050()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_short = (new BigDecimal("27")).shortValueExact();
    Assert.assertEquals(27, rc_short);
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-9E+18"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("27"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0058()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0064()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0067()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E-2147483646"), 1);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9E+18")).add(new BigDecimal("3E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("-9E+18"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0070()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).stripTrailingZeros();
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("4E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("4E+1"));
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("4"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_double = (new BigDecimal("4E+1")).doubleValue();
    Assert.assertEquals(40.0, rc_double, 0);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("4")).divideToIntegralValue(new BigDecimal("4E+1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '8', '\0', '8', '\1', '\1', '8', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\0', '8', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\1', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '8', '8', '\0', '\0', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\234', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0090()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '8', '\234', '\uFFFF', '8', '\1', '8', '8', '\234', '\234', '\1', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\0', '8', '8', '\234', '\234', '8', '\uFFFF', '\1', '8', '\0', '8', '\0', '\234', '\1', '8', '8', '\234', '8', '\1', '\234', '\0', '\234', '8', '\0', '\0', '8', '\234', '8', '\0', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '8', '\1', '8', '\1', '\uFFFF'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("4E+1"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("BB9UJ=IY7KOVCRTV5X3KCA>GU;>JD0X>WA@N;O?9OD8VWC:TU:@?6;PSLXSAGRJ?U46QHN0D9A2KM3", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.57718120805369%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).negate();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_long = (new BigDecimal("-4E+1")).longValueExact();
    Assert.assertEquals(-40L, rc_long);
  }
  public void testItem_0100()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483646")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).remainder(new BigDecimal("-4E+1"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483646")).negate();
    Assert.assertEquals("-1E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0106()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4E+1")).add(new BigDecimal("1E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("86.91275167785236%", true, caught);
//  }
  public void testItem_0107()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigInteger = (new BigDecimal("4E+1")).unscaledValue();
    Assert.assertEquals("4", rc_BigInteger.toString());
  }
  public void testItem_0109()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483646")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0113()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1E-2147483646")).hashCode();
//    Assert.assertEquals(2147483615, rc_int);
//  }
  public void testItem_0114()
  {
    rc_int = (new BigDecimal("-1E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
//  public void testItem_0115()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E-2147483646")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("86.91275167785236%", true, caught);
//  }
//  public void testItem_0116()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("86.91275167785236%", true, caught);
//  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("8")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0122()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0123()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0126()
  {
    rc_int = (new BigDecimal("4E+1")).compareTo(new BigDecimal("8"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0132()
  {
    rc_BigDecimal = (new BigDecimal("8")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0134()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("1"), 0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	Assert.assertEquals("4E+1", rc_BigDecimal.toString());
    } else {
    	Assert.assertEquals("40", rc_BigDecimal.toString());
    }
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("40"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0145()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("86.91275167785236%", true, caught);
//    }
//  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0WD=WU1TQIVP@5D;87SSOR1Y44G>PXEQ:FN=G:PMAOM?;<XJG8;E7UBTMVW43UXRCEL;N94Y1K;;6");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("40"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_BigInteger = (new BigDecimal("40")).toBigIntegerExact();
    Assert.assertEquals("40", rc_BigInteger.toString());
  }
  public void testItem_0153()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0154()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("40"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0161()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_String = (new BigDecimal("40")).toPlainString();
    Assert.assertEquals("40", rc_String);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("40"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("IW1NHXKEPX@389HYW@=C0OQX8:MP6M89N5S5=WTXPK3M0AMPK2RR8TIG4<KRU4GMX5BOO66A>HH7DDDWWE7PIDPY<S=<PYL1A6L3");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0167()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("40"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("40")).scaleByPowerOfTen(0);
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("40")).min(new BigDecimal("40"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("32"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigInteger = (new BigDecimal("40")).toBigInteger();
    Assert.assertEquals("40", rc_BigInteger.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("40"));
    Assert.assertEquals("1280", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1280"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1281", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("1280")).add(new BigDecimal("3.2"));
    Assert.assertEquals("1283.2", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_String = (new BigDecimal("1283.2")).toPlainString();
    Assert.assertEquals("1283.2", rc_String);
  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\1', '\0', '\0', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\0', '8', '8', '\0', '\uFFFF', '\1', '8', '\234', '8', '\1', '\234', '8', '8', '\0', '8', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\234', '8', '\0', '\uFFFF', '\234', '8', '8', '8', '\1', '\1', '8', '8', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("40")).divideToIntegralValue(new BigDecimal("40"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigInteger = (new BigDecimal("-1281")).toBigIntegerExact();
    Assert.assertEquals("-1281", rc_BigInteger.toString());
  }
  public void testItem_0180()
  {
    rc_BigInteger = (new BigDecimal("1283.2")).unscaledValue();
    Assert.assertEquals("12832", rc_BigInteger.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("27<E<HJA<DKM8UB6IA5D==L0:MCP79GQ3OM30=W59:6NVHUE5C4ON;HC6B:TTTTEK86DYAOJT4RL0<6IFJ5JLSPFV:S>;8<M4?J1");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9AJYDDAPN:JQS;");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("40")).multiply(new BigDecimal("1280"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("51200", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("0>531GCJ;7BGL4R?NOFOYS9LCP9RX59XO9W?O>C@HFSU;>D=@?30OAKY@9E2TTGRG<87WI");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0187()
  {
    rc_String = (new BigDecimal("51200")).toPlainString();
    Assert.assertEquals("51200", rc_String);
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\234', '\234', '8', '\1', '\1'}, 0, 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\uFFFF', '\1', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\234', '\0', '\0', '\234', '\0', '\0', '8', '8', '8', '\234', '\234', '8', '\234', '8', '8', '\234', '\1', '\1', '\234', '\234', '\1', '\0', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0191()
  {
    rc_BigDecimal_array = (new BigDecimal("51200")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1283.2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1281")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("3.2E+2"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("QTL>=MTNB1EXOWTA9N6IS4F1LI;384V=WRV<@@M3@HQL0W3=;>5VSRVCOG1XF8>@BK@F@E4UBJQ0U2RX5EWQ2H5V;AW53XXRWXKU");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigInteger = (new BigDecimal("-1281")).toBigInteger();
    Assert.assertEquals("-1281", rc_BigInteger.toString());
  }
  public void testItem_0204()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0205()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0206()
  {
    rc_String = (new BigDecimal("1283.2")).toEngineeringString();
    Assert.assertEquals("1283.2", rc_String);
  }
  public void testItem_0207()
  {
    rc_BigInteger = (new BigDecimal("-1281")).unscaledValue();
    Assert.assertEquals("-1281", rc_BigInteger.toString());
  }
  public void testItem_0208()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("XSOHP3CB@W?VV9WWAJ:Q<GQAQBB<8MIROS6R3C3K08AWQ0RVRSA@UTEF");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("86.91275167785236%", true, caught);
  }
  public void testItem_0209()
  {
    rc_int = (new BigDecimal("1283.2")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0210()
  {
    rc_String = (new BigDecimal("-1281")).toString();
    Assert.assertEquals("-1281", rc_String);
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0215()
  {
    rc_int = (new BigDecimal("-1281")).intValueExact();
    Assert.assertEquals(-1281, rc_int);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1283.2"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("1283.2")).divide(new BigDecimal("1283.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1283.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("1283.2")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\234', '8', '\0', '\1', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '8', '\uFFFF', '\0', '8', '8', '\1', '8', '8', '\0', '8'}, -1, 2147483647, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_double = (new BigDecimal("2E+3")).doubleValue();
    Assert.assertEquals(2000.0, rc_double, 0);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("1283.2")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_short = (new BigDecimal("2E+3")).shortValueExact();
    Assert.assertEquals(2000, rc_short);
  }
  public void testItem_0229()
  {
    rc_int = (new BigDecimal("2E+3")).scale();
    Assert.assertEquals(-3, rc_int);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("2E+3")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("2.00E+3", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("2.00E+3")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("1283.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1283.2", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("-1283.2")).divide(new BigDecimal("-1283.2"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).divideToIntegralValue(new BigDecimal("-1283.2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("-1283.2")).subtract(new BigDecimal("-1283.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs();
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1283.2")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("-1283.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\1', '\0', '8', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\1', '\1', '\1', '\0', '8', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '8', '\uFFFF', '8', '8', '\234', '\234', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\234', '\1', '8', '\0', '8', '8', '\1', '\234'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_short = (new BigDecimal("1.0")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("-1283.2")).divide(new BigDecimal("-1283.2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1.0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '\1', '8', '\1', '\1', '8', '\234', '8', '\1', '8', '8', '\234', '\234', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '8', '\0', '\0', '8', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\0', '8', '8', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0254()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigInteger = (new BigDecimal("-1283.2")).toBigInteger();
    Assert.assertEquals("-1283", rc_BigInteger.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1283.2")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("-1283.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).subtract(new BigDecimal("4E+1"));
    Assert.assertEquals("-40.0", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-40.0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0263()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0265()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("TB=V9EPOTD9NA4U297E=Q3T2G75B<8MH4RRMK");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-40.0")).divide(new BigDecimal("-1283.2"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1283.2")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0268()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0270()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0271()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("-1283.2")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0273()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\234', '8', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '\234', '\1', '8', '\1', '\0', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '\0', '\234', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '\234', '\1', '\234', '\1', '\1', '\0', '\1', '\234', '8', '8', '\uFFFF', '\0', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '\234', '\234', '\1', '\234', '\1', '\234'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0274()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LATUH<YDLJT79N9BGR8375O2C67;7F>8TN2C@E6IFSRJ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0277()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0.0"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0283()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointRight(-1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_String = (new BigDecimal("0.00")).toPlainString();
    Assert.assertEquals("0.00", rc_String);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0287()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
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
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("0.00")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0295()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(2147483647, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0296()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\0', '\234', '\uFFFF', '\0', '8', '\234', '8', '\0', '\uFFFF', '8', '\0', '8', '\234', '\234', '8', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\234', '8', '8', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\0', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\0', '8', '8', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\1', '\0', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\0', '\1', '\uFFFF', '8', '8', '\234', '\234', '\1', '8', '\1', '8', '\1', '8', '8', '\uFFFF', '\1', '\234', '8'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
//  public void testItem_0298()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.24832214765101%", true, caught);
//  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TD1:R120L647;NUQGW?IQVOSLH43=IEJ@2C411A5:L:BC@B5NLV@EJERNUP490NI99R45<X:M@>R14FKD?7>T5RMWCU2:DQOGCP9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0300()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(1);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_String = (new BigDecimal("-92233720368547758080")).toEngineeringString();
    Assert.assertEquals("-92233720368547758080", rc_String);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("-92233720368547758080"));
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0305()
  {
    rc_boolean = (new BigDecimal("-9223372036854775808")).equals("U?CPR6>U8RO0F5UVX>1F3GQDYY:EYKHKFR5NH5D90=:0IFXG9A2OB0>822?>G5GS<DRFTRUKQDUM<4X8QH7N?V<Q1UH1V7TIAG?Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("EC7T4PTK29VUBOGPDVFK0RCQQKGIYGE9U55C<FW=5T8RUOHK:3=GS=;=U37;6CSP>WKQ1=L9GTY:9B:G436LSFTTUUA8:?L>QO=Y");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0310()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0311()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(1);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointLeft(-1);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-92233720368547758080")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("-92233720368547758080")).movePointRight(0);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0317()
  {
    rc_int = (new BigDecimal("0.00")).compareTo(new BigDecimal("-92233720368547758080"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("-92233720368547758080")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("19807040628566084398385987584", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-92233720368547758080"));
    Assert.assertEquals("-101457092405402533888", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-101457092405402533888", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).divide(new BigDecimal("-101457092405402533888"), -1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LQ1WSE<42NRG4W@;9OOW>CE0MJXFEOF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.24832214765101%", true, caught);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).plus();
    Assert.assertEquals("-101457092405402533888", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_long = (new BigDecimal("-101457092405402533888")).longValue();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-101457092405402533888")).divide(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).add(new BigDecimal("-101457092405402533888"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-3E+20", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U5?U@D@JT=97WVSN8QSGW<T2D9T8OOCB8YV1UACC0@LH61SYKNV:<DL28NUUX6J96<3JR:JMUURQB>KP6R8AL27Q4UA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).abs();
    Assert.assertEquals("101457092405402533888", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V0LW=J?LJ9<RJL5NL>3IV@JLNET<8R:>WPT3@3<5");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("-101457092405402533888")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-101457092405402533888", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0344()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
//  public void testItem_0345()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).min(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0346()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0348()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointRight(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0354()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0355()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).pow(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).max(new BigDecimal("3E-2147483647"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0361()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("3E-2147483647"));
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0363()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3E-2147483647")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//    }
//  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0365()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate();
//    Assert.assertEquals("-3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).add(new BigDecimal("3E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("3E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0369()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0370()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0371()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divideToIntegralValue(new BigDecimal("3E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//    }
//  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).abs();
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_int = (new BigDecimal("-4E+1")).intValueExact();
    Assert.assertEquals(-40, rc_int);
  }
//  public void testItem_0374()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).multiply(new BigDecimal("-4E+1"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0378()
  {
    rc_double = (new BigDecimal("3E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0379()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigInteger = (new BigDecimal("3E-2147483647")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0383()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0384()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("3E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0385()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4E+1")).subtract(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0386()
  {
    rc_int = (new BigDecimal("-4E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0387()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0388()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0389()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UP"));
//    }
//  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).divideToIntegralValue(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-12", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_double = (new BigDecimal("-12")).doubleValue();
    Assert.assertEquals(-12.0, rc_double, 0);
  }
//  public void testItem_0392()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).setScale(-1, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0393()
  {
    rc_BigInteger = (new BigDecimal("-12")).toBigInteger();
    Assert.assertEquals("-12", rc_BigInteger.toString());
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).divide(new BigDecimal("-12"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
//  public void testItem_0396()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-320.0E+2147483647"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
//  public void testItem_0397()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4E+1")).remainder(new BigDecimal("-320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//    }
//  }
//  public void testItem_0398()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("320.0E+2147483647")).longValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
//  public void testItem_0399()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("-320.0E+2147483647"), new MathContext("precision=1 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//    }
//  }
//  public void testItem_0400()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).scaleByPowerOfTen(1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
  public void testItem_0401()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '8', '8', '\1', '8', '\1', '\234', '\234', '\0', '\0', '\0', '8', '\0', '\234', '\1', '\1', '\0', '\234', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\0'}, 0, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).plus();
    Assert.assertEquals("-4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("-4E+1")).divide(new BigDecimal("-12"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal_array = (new BigDecimal("-3")).divideAndRemainder(new BigDecimal("-3"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0407()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-320.0E+2147483647")).multiply(new BigDecimal("-3"));
//    Assert.assertEquals("9.6E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0408()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
//  public void testItem_0409()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("3.2"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
//  public void testItem_0410()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("3.2"), -1, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.58389261744966%", true, caught);
//  }
//  public void testItem_0411()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@T;DLLESD2ID6M<@2LXNLJQEKM@0CIRJ5QG14R5NE5877T=UN>B6BD=6;KF?G;B7@@OL<HXRU9WAU<TCL");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("87.58389261744966%", true, caught);
  }
  public void testItem_0413()
  {
    rc_float = (new BigDecimal("-320.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0414()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
//  public void testItem_0416()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.91946308724832%", true, caught);
//  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("960.0E+2147483647")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
//  public void testItem_0418()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("320.0E+2147483647"), 1, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("87.91946308724832%", true, caught);
//  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), -1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("960.0E+2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0422()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("960.0E+2147483647"), 2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("0A=2FK3AX9HHFDXAYKSTRRR2HH0TA3HF5FIOCOJ1<BCU5G8;H:L>20BMD@UDGA0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0425()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3.2"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0429()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("1135879015891"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0436()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("4LAK;?GDD>N7:L9G<TH8Y?NLOU7M7HR4UP<0<B:EA38T@<9E5AP7H:S8KCJG>;96=:FDY3:BW5QJ7WKE0PUURM810?1L2HYXGA@=");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0438()
  {
    rc_String = (new BigDecimal("0E+1")).toString();
    Assert.assertEquals("0E+1", rc_String);
  }
  public void testItem_0439()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1135879015891")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("0E+1"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("87.91946308724832%", true, caught);
  }
  public void testItem_0441()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-1135879015891"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("4E+1"));
    Assert.assertEquals("-39", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("-39")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("39", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = (new BigDecimal("39")).min(new BigDecimal("-39"));
    Assert.assertEquals("-39", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    rc_String = (new BigDecimal("39")).toEngineeringString();
    Assert.assertEquals("39", rc_String);
  }
  public void testItem_0456()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '\234', '8', '\uFFFF', '\234', '\1', '\234', '\234', '8', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\0', '\234', '\0', '\234', '\234', '\0', '\0', '\1', '\234', '8', '\1', '\234', '8', '8', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\1', '\0', '\1', '\234', '\0', '\234', '8', '\234'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+12")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0464()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("NM5L6RM4=FK=MS=F88X=2L?:CIIEH8W8W<M6Q8C7T6AIIAT=L28ROX0B:7=<TRTEW2VFW:HX?EMO5N386BRKR?XF<<B55O=DDR2O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("-39")).remainder(new BigDecimal("4E+1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-39", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("-39"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).subtract(new BigDecimal("2E+12"));
    Assert.assertEquals("-1.99999999996E+12", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0473()
  {
    rc_boolean = (new BigDecimal("1E+1")).equals("2?:192DFIT2RE89Q9O=8<><>91B?B==PI@5W=:9SI4:FVX3JS=FYU852G41U71<@EXHRA7@;19W96G@;XCD<4FEGC7OEIX8RM>");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).divide(new BigDecimal("1E+1"));
    Assert.assertEquals("-199999999996", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\0', '\1', '8', '\0', '\234', '\0', '8', '\1', '8', '\uFFFF', '\0', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\1', '8', '8', '8', '8', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0476()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("2E+12"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E-11", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).setScale(0);
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).divideToIntegralValue(new BigDecimal("-2E+12"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("-2E+12")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	 Assert.assertEquals("-2E+12", rc_BigDecimal.toString());
    } else {
    	 Assert.assertEquals("-2000000000000", rc_BigDecimal.toString());
    }
  }
//  public void testItem_0482()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4E+1")).hashCode();
//    Assert.assertEquals(123, rc_int);
//  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("-2E+12")).remainder(new BigDecimal("2E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).subtract(new BigDecimal("40"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1999999999960", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.25503355704699%", true, caught);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1.99999999996E+12", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_double = (new BigDecimal("40")).doubleValue();
    Assert.assertEquals(40.0, rc_double, 0);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).remainder(new BigDecimal("4E+1"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("40")).remainder(new BigDecimal("-1.99999999996E+12"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("40")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_int = (new BigDecimal("1999999999960")).intValue();
    Assert.assertEquals(-1454759976, rc_int);
  }
  public void testItem_0495()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0496()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("1999999999960")).scaleByPowerOfTen(-1);
    Assert.assertEquals("199999999996.0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).stripTrailingZeros();
    Assert.assertEquals("-1.99999999996E+12", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("40")).stripTrailingZeros();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0504()
  {
    rc_int = (new BigDecimal("-1.99999999996E+12")).compareTo(new BigDecimal("-1.99999999996E+12"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.99999999996E+12", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).stripTrailingZeros();
    Assert.assertEquals("-1.99999999996E+12", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_int = (new BigDecimal("-1.99999999996E+12")).compareTo(new BigDecimal("4E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0508()
  {
    rc_long = (new BigDecimal("0E+12")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).add(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_int = (new BigDecimal("4E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0511()
  {
    rc_int = (new BigDecimal("-1.99999999996E+12")).intValue();
    Assert.assertEquals(1454759976, rc_int);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\0', '8', '\1', '\234', '\0', '\234', '\0', '\234', '\1', '\234', '\234', '\234', '\0', '\0', '\1', '\uFFFF', '8', '8', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_float = (new BigDecimal("-1.99999999996E+12")).floatValue();
    Assert.assertEquals(-1.999999991808E12F, rc_float, 0);
  }
  public void testItem_0516()
  {
    rc_String = (new BigDecimal("-1.99999999996E+12")).toEngineeringString();
    Assert.assertEquals("-1.99999999996E+12", rc_String);
  }
  public void testItem_0517()
  {
    rc_float = (new BigDecimal("0E+12")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0518()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+12")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0519()
  {
    rc_int = (new BigDecimal("-1.99999999996E+12")).compareTo(new BigDecimal("0E+12"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0520()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+12")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0521()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_long = (new BigDecimal("-1.99999999996E+12")).longValueExact();
    Assert.assertEquals(-1999999999960L, rc_long);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).abs();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).max(new BigDecimal("-1.99999999996E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("-1.99999999996E+12")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320", rc_BigDecimal.toString());
  }
//  public void testItem_0526()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320")).divideAndRemainder(new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320"), new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.59060402684564%", true, caught);
//    }
//  }
  public void testItem_0527()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_int = (new BigDecimal("0E+12")).compareTo(new BigDecimal("4E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0531()
  {
    rc_long = (new BigDecimal("-1.99999999996E+12")).longValueExact();
    Assert.assertEquals(-1999999999960L, rc_long);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320")).add(new BigDecimal("4E+1"));
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).add(new BigDecimal("32"));
    Assert.assertEquals("-359538626965272369089605584630827616646872960779767170496801153742357822487930787089977975715110173997770242780167146570328067355209555512461356526096336332103958320473660567729428928897728838284536163859147233144270961116114262566855488200737614354176310718477297533289310565435089072675264036057118233555688635005665208", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).divide(new BigDecimal("0E+12"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0535()
  {
    rc_BigInteger = (new BigDecimal("0E+12")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0536()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0537()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320")).add(new BigDecimal("4E+1"));
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_int = (new BigDecimal("-359538626965272369089605584630827616646872960779767170496801153742357822487930787089977975715110173997770242780167146570328067355209555512461356526096336332103958320473660567729428928897728838284536163859147233144270961116114262566855488200737614354176310718477297533289310565435089072675264036057118233555688635005665208")).precision();
    Assert.assertEquals(321, rc_int);
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("-359538626965272369089605584630827616646872960779767170496801153742357822487930787089977975715110173997770242780167146570328067355209555512461356526096336332103958320473660567729428928897728838284536163859147233144270961116114262566855488200737614354176310718477297533289310565435089072675264036057118233555688635005665208")).add(new BigDecimal("0E+12"));
    Assert.assertEquals("-359538626965272369089605584630827616646872960779767170496801153742357822487930787089977975715110173997770242780167146570328067355209555512461356526096336332103958320473660567729428928897728838284536163859147233144270961116114262566855488200737614354176310718477297533289310565435089072675264036057118233555688635005665208", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("MS4AHD7K3JBJVEMH0MCETQ=:2HIE5JDI<3=9@XEXHGOG:MX=CJY?VV2F5>EQKVPSGL>Q8J0OQM31FE:9;VWH=MJJV=2XD@;2C<KI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320")).plus();
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566528E+320", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).intValue();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).divide(new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).scaleByPowerOfTen(0);
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigInteger = (new BigDecimal("-1E+1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0550()
  {
    rc_short = (new BigDecimal("-1E+1")).shortValueExact();
    Assert.assertEquals(-10, rc_short);
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).movePointLeft(2147483647);
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E-2147483327", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).subtract(new BigDecimal("0E+12"));
    Assert.assertEquals("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).negate();
    Assert.assertEquals("3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0556()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).subtract(new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0559()
  {
    rc_BigInteger = (new BigDecimal("-1E+1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0560()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).subtract(new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0569()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0570()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
  }
  public void testItem_0571()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0572()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0573()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":YWD=0QY?<4B=K?LFRS>XW7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0574()
  {
    rc_boolean = (new BigDecimal("0E+1")).equals("?P9BAYA<7<RU6U704EOPC8AGP<RB5>IK;;1J:S6GR2QL2CIU1SLR5OQOCWX3F3T:I;98K?8DHPVJYBC3:LSHR9S=QQ6KGEH?0Y;W");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
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
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
//  public void testItem_0577()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("-4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0578()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\0', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\0', '\234', '\234', '8', '\1', '\1', '\234', '\234', '\234', '8', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '\234', '8', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '8', '8', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\0', '\234', '8', '\1', '\234', '\0', '\234', '\0', '\234', '\1', '\1', '8', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '8'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0581()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0582()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0'}, -2147483648, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0586()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    rc_BigDecimal = (new BigDecimal("-3.5953862696527236908960558463082761664687296077976717049680115374235782248793078708997797571511017399777024278016714657032806735520955551246135652609633633210395832047366056772942892889772883828453616385914723314427096111611426256685548820073761435417631071847729753328931056543508907267526403605711823355568863500566524E+320")).multiply(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\1', '8', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\uFFFF', '8', '8', '8', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '\0', '\1', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\234', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\0', '\1', '\1', '\234', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\0', '8', '\uFFFF', '8', '\234'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0595()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0596()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\234', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '8', '\0', '\0', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0609()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_int = (new BigDecimal("0E-2147483647")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TS040S1=GXHFSML25=P?UHQJV0V9=?4K8E8B;MEDVU0OEMY0HDVYXB=8ES:@Y5WCJD:97BX>=18UG<==2M59WECR");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
//  public void testItem_0615()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.59060402684564%", true, caught);
//  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-8"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("-8")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-5", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("-8")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@I=LQSU=R3B>PA9:MR67FGRTEHDVQ;BFBD48N=Y1M<:3<6QRBJ54IU;LB59:56T63QLNI:9LR9RDEK5PUQY<GR0W31G>?4OGAYFL", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("-8")).stripTrailingZeros();
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("-5")).divide(new BigDecimal("-5"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0626()
  {
    rc_byte = (new BigDecimal("-8")).byteValueExact();
    Assert.assertEquals(-8, rc_byte);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("-5")).remainder(new BigDecimal("-5"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0630()
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
//    Assert.assertEquals("88.59060402684564%", true, caught);
//    }
//  }
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("-5")).divide(new BigDecimal("-8"));
    Assert.assertEquals("0.625", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\0', '\0', '\0', '8', '\234', '8', '\234', '\234', '\0', '8', '\1', '\uFFFF', '8', '\1', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\234'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0637()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.625")).divide(new BigDecimal("0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-5"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '8', '8', '\0', '8', '8', '8', '\0', '\uFFFF', '8', '\1', '8', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\234', '\0', '8', '\234', '\234', '8', '\1', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '8', '\1', '\234', '8', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '8', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\uFFFF'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0643()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("3.2")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
//  public void testItem_0644()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-5")).subtract(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.59060402684564%", true, caught);
//  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\1', '\234', '8', '8', '\uFFFF', '8', '8', '8', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '8', '8', '\0', '8', '8', '\234', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
//  public void testItem_0646()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-5")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.59060402684564%", true, caught);
//  }
  public void testItem_0647()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5")).divide(new BigDecimal("0"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0.625"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_int = (new BigDecimal("0.625")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0651()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate();
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '8', '\234', '8', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0655()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.625")).divide(new BigDecimal("0.0"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("-3.2"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.625")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.59060402684564%", true, caught);
  }
  public void testItem_0659()
  {
    rc_int = (new BigDecimal("-5")).intValueExact();
    Assert.assertEquals(-5, rc_int);
  }
  public void testItem_0660()
  {
    rc_short = (new BigDecimal("-5")).shortValueExact();
    Assert.assertEquals(-5, rc_short);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("-5")).multiply(new BigDecimal("-3.2"));
    Assert.assertEquals("16.0", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).scaleByPowerOfTen(0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("16.0")).setScale(1);
    Assert.assertEquals("16.0", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("-3.2"));
    Assert.assertEquals("6.7108864E+8", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).divide(new BigDecimal("-3.2"), java.math.RoundingMode.UP);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_int = (new BigDecimal("16.0")).compareTo(new BigDecimal("0.625"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).multiply(new BigDecimal("-3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("16.0"));
    Assert.assertEquals("160", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigInteger = (new BigDecimal("16.0")).unscaledValue();
    Assert.assertEquals("160", rc_BigInteger.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("160"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("160")).divide(new BigDecimal("160"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("160"));
    Assert.assertEquals("-160", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_BigDecimal = (new BigDecimal("-160")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1.60E+3", rc_BigDecimal.toString());
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("-160")).remainder(new BigDecimal("16.0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("16.0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigInteger = (new BigDecimal("16.0")).unscaledValue();
    Assert.assertEquals("160", rc_BigInteger.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("16.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-16.0", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigInteger = (new BigDecimal("-16.0")).unscaledValue();
    Assert.assertEquals("-160", rc_BigInteger.toString());
  }
  public void testItem_0684()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0685()
  {
    rc_String = (new BigDecimal("-160")).toString();
    Assert.assertEquals("-160", rc_String);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("-160")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigInteger = (new BigDecimal("-16.0")).toBigInteger();
    Assert.assertEquals("-16", rc_BigInteger.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0690()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2E+2"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("-160")).add(new BigDecimal("0"));
    Assert.assertEquals("-160", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("2E+2")).divide(new BigDecimal("-160"));
    Assert.assertEquals("-1.25", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_long = (new BigDecimal("-16.0")).longValue();
    Assert.assertEquals(-16L, rc_long);
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("2E+2")).add(new BigDecimal("-160"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigInteger = (new BigDecimal("40")).toBigIntegerExact();
    Assert.assertEquals("40", rc_BigInteger.toString());
  }
//  public void testItem_0697()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2E+2")).divideAndRemainder(new BigDecimal("-1.25"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.9261744966443%", true, caught);
//    }
//  }
  public void testItem_0698()
  {
    rc_BigInteger = (new BigDecimal("-160")).toBigIntegerExact();
    Assert.assertEquals("-160", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0699()
  {
    rc_boolean = (new BigDecimal("40")).equals("<O>8H>35DVVRJFFC9S");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-160")).add(new BigDecimal("2E+2"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("40", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("2E+2")).divide(new BigDecimal("40"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_short = (new BigDecimal("40")).shortValueExact();
    Assert.assertEquals(40, rc_short);
  }
  public void testItem_0704()
  {
    rc_String = (new BigDecimal("0E+2")).toString();
    Assert.assertEquals("0E+2", rc_String);
  }
  public void testItem_0705()
  {
    rc_long = (new BigDecimal("-160")).longValue();
    Assert.assertEquals(-160L, rc_long);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).remainder(new BigDecimal("40"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_float = (new BigDecimal("40")).floatValue();
    Assert.assertEquals(40.0F, rc_float, 0);
  }
  public void testItem_0708()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0709()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).subtract(new BigDecimal("0E+2"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0712()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.9261744966443%", true, caught);
//    }
//  }
  public void testItem_0713()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0714()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).abs();
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0717()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0718()
  {
    rc_int = (new BigDecimal("-160")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0719()
  {
    rc_String = (new BigDecimal("-160")).toString();
    Assert.assertEquals("-160", rc_String);
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\234', '\1', '\234', '\234', '\0', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\1', '\0', '\1', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '8', '\1', '\234', '\0', '\1', '\uFFFF', '8', '8', '8', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0721()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0722()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0723()
  {
    rc_long = (new BigDecimal("0E+2")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("7E+309", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).scaleByPowerOfTen(-1);
    Assert.assertEquals("2E+307", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).max(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).abs(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '8', '\234', '\1', '\0', '8', '\0', '\1', '\1', '\0', '8', '8', '\0', '8', '8', '8', '\1', '\uFFFF', '8', '8', '\0', '\1', '8', '8', '\uFFFF', '\0', '\0', '\0', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '8', '\1', '8', '\1', '\1', '8', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\0'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\0', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\0', '\234', '8', '\0', '\0', '\1', '\0', '\1', '8', '\234', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\1', '\1', '\1', '8', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\1', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0734()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0736()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(-1, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0739()
  {
    rc_int = (new BigDecimal("0.04")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0740()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.04")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\1', '\234', '\234', '\0', '\0', '\234', '8', '\1', '8', '8', '\0', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '\0', '\0', '8', '\234', '8', '\234', '\0', '\1', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\0', '8', '\0', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\1', '8', '\234', '\0', '\0', '8', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E-307", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0746()
  {
    rc_long = (new BigDecimal("0.04")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0747()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).min(new BigDecimal("1135879015891"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-11", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("3E-11")).divide(new BigDecimal("0.04"));
    Assert.assertEquals("7.5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("3E-11")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-11", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0756()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).remainder(new BigDecimal("0.04"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.00")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).toBigIntegerExact();
    Assert.assertEquals("200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0763()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("2E+308"));
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).multiply(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0E+306", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0768()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.04")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.9261744966443%", true, caught);
//  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divideToIntegralValue(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("0E+306"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("0E+306")).multiply(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+614", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_int = (new BigDecimal("2E+308")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("2E+308"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1382")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E-1382"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0E-1383", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("0E-1383")).ulp();
    Assert.assertEquals("1E-1383", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '8', '\234', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\234', '\234', '\0', '\0', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '\0'}, -2147483648, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0787()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).precision();
    Assert.assertEquals(751, rc_int);
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+614")).remainder(new BigDecimal("0E-1382"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).multiply(new BigDecimal("0E-1383"));
    Assert.assertEquals("0E-2765", rc_BigDecimal.toString());
  }
//  public void testItem_0790()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-1382")).hashCode();
//    Assert.assertEquals(1382, rc_int);
//  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0E-1383")).multiply(new BigDecimal("0E-1382"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2765", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_long = (new BigDecimal("0E-1382")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_short = (new BigDecimal("0E-1382")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0795()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_byte = (new BigDecimal("0E+614")).byteValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.9261744966443%", true, caught);
//    }
//  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("0E+614")).min(new BigDecimal("0E-1383"));
    Assert.assertEquals("0E+614", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1382")).divide(new BigDecimal("0E-1383"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("0E+614")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("0E+614", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '8', '\1', '\1', '\1', '\234', '8', '8', '\0', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '\0', '\0', '8', '8', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '8', '\1', '8', '8', '\1', '8', '8', '8', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '8', '\uFFFF', '8', '\1', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("88.9261744966443%", true, caught);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_String = (new BigDecimal("0E-1383")).toString();
    Assert.assertEquals("0E-1383", rc_String);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0804()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("88.9261744966443%", true, caught);
//  }
  public void testItem_0805()
  {
    rc_BigInteger = (new BigDecimal("0E-1382")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0806()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E+614"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0812()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5B=Q98SI?CNPB<97;X6A06:ENPAHFSK:L48O;TFHMNF>PP", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
//  public void testItem_0814()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.26174496644295%", true, caught);
//    }
//  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XUN838C>Y>RQ25SQ=H=>UWUUJD<JY3>A6>@X<DDE6CP45EY9B1M4DDY=J4XYSJG7G@?<=X=0R3VFY<7DBU", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0817()
  {
    rc_String = (new BigDecimal("-2")).toPlainString();
    Assert.assertEquals("-2", rc_String);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_short = (new BigDecimal("0E-1382")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divide(new BigDecimal("-2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0826()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1"), 1);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0827()
  {
    rc_String = (new BigDecimal("0E-1382")).toEngineeringString();
    Assert.assertEquals("0.00E-1380", rc_String);
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\1', '\234', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '8', '8', '8', '\0', '\0', '\1', '8', '8', '8', '\uFFFF', '\0', '8', '8', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\1', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8', '\1', '\uFFFF', '\1', '8', '\234', '\1', '\234', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '\234', '\1', '\0', '\234', '\234', '8', '\0', '\1', '\1', '\0', '8', '\uFFFF', '8', '\1', '\234', '\1', '8'}, 0, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
//  public void testItem_0831()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).abs(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-1382", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_int = (new BigDecimal("0E-1382")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0834()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0835()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
//  public void testItem_0836()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.26174496644295%", true, caught);
//  }
  public void testItem_0837()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0842()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-1382"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0843()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointRight(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0846()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0847()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("96@MBABM6DG172IVI7:JR?:RWTHBAIA>81OUG=LFNS4YT>II73;SW<W4AD45>>P?L79PXSIXHFA@E>5L2LKI3KC0@23HBC6FUNXP", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("3.2E-2147483646"), 1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("0E-1382")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0E-1383", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0855()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=UP"));
//    Assert.assertEquals("4E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("0E-1383")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-1383", rc_BigDecimal.toString());
  }
//  public void testItem_0857()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("4E-2147483647")).hashCode();
//    Assert.assertEquals(-2147483525, rc_int);
//  }
  public void testItem_0858()
  {
    rc_int = (new BigDecimal("0E-1383")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_int = (new BigDecimal("0E-1383")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0861()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-1383")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0863()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E-2147483647")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
//  public void testItem_0866()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("4E-2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.26174496644295%", true, caught);
//    }
//  }
  public void testItem_0867()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1135879015891"));
  }
  public void testItem_0873()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1QA?56A=<SYMA;EC5=FJ1RAMRQI4>?FBJYOV5XC345D?KVKMNQSAS2H93;2X;A19>FXD6V@H?;J0G3F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0874()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("-32")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1135879015891"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YPRTCIQ?:QT4=BD08G0593NXQI:DMA>M8V9?DHXUD0YE<4;UP@9E2H@<S1YC1OD01D<P79NI:KNQW5>:X4G4PD:F0KCQ2B8G78GQ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0881()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0882()
  {
    rc_long = (new BigDecimal("1135879015891")).longValueExact();
    Assert.assertEquals(1135879015891L, rc_long);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0888()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '8', '8', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\1', '\1', '\1', '8', '\234', '\234', '\0', '\1', '\1', '8', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\0', '\0', '\234', '\1', '\0', '8', '8', '\234', '8', '\uFFFF', '\234', '8', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '8', '\234', '\0', '\234', '\0', '\uFFFF', '\234', '8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0890()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\1', '8', '\uFFFF', '\0', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\0', '\1', '\1', '\0', '\1', '8', '\1', '8', '\0', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("-1135879015891"));
    Assert.assertEquals("-1135879015921", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015921")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015921", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).stripTrailingZeros();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_String = (new BigDecimal("-3E+1")).toString();
    Assert.assertEquals("-3E+1", rc_String);
  }
  public void testItem_0895()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("-1135879015891"));
  }
  public void testItem_0897()
  {
    rc_String = (new BigDecimal("-1135879015891")).toString();
    Assert.assertEquals("-1135879015891", rc_String);
  }
  public void testItem_0898()
  {
    rc_String = (new BigDecimal("1135879015891")).toEngineeringString();
    Assert.assertEquals("1135879015891", rc_String);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("0"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_float = (new BigDecimal("-1135879015891")).floatValue();
    Assert.assertEquals(-1.135878995968E12F, rc_float, 0);
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?3L1Y<>1:RULR;ACCPTAE<CW:NG49YBHGSG1TJ7MHQ3W8IJ20HPT1876CRL5GW6EWCCYP7Y?:9IJWNIDF?4:2UJWP0LQVL?9QKFR");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0906()
  {
    rc_boolean = (new BigDecimal("1135879015891")).equals("KHNT2MGSC>W5L2P<Q7HF>PG74M07@HTPTMFW?PAL@JJ@G38OW=8XVK=VC5F8QYAWHACPY60UKUOMIY8NBCR5BA4BJYGTLOKT?CNS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0908()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015921")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.407637047763E+13", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).plus();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015921")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015921")).remainder(new BigDecimal("3.407637047763E+13"));
    Assert.assertEquals("-1135879015921", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0916()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_String = (new BigDecimal("3.407637047763E+13")).toEngineeringString();
    Assert.assertEquals("34.07637047763E+12", rc_String);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3.407637047763E+13"));
    Assert.assertEquals("3.407637047763E+13", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).stripTrailingZeros();
    Assert.assertEquals("3.407637047763E+13", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).divide(new BigDecimal("3.407637047763E+13"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3.407637047763E+13", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).setScale(-1);
    Assert.assertEquals("3.407637047763E+13", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("61>YONK7M0FLXD=1?LD:GQEV", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0926()
  {
    rc_float = (new BigDecimal("3.407637047763E+13")).floatValue();
    Assert.assertEquals(3.407637118976E13F, rc_float, 0);
  }
  public void testItem_0927()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0928()
  {
    rc_BigInteger = (new BigDecimal("3.407637047763E+13")).unscaledValue();
    Assert.assertEquals("3407637047763", rc_BigInteger.toString());
  }
  public void testItem_0929()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).divide(new BigDecimal("3.407637047763E+13"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.407637047763E+13")).divide(new BigDecimal("3.407637047763E+13"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L8XF8=NC?I9WPHL@HA5JBUI7U>91;BFPGD:N;K=O8JSJEQAJ4QF>>P;N0<BQFO1<KVRT5HABVXK8RT<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?02@PIWJGE52>YHBELS1S8ES?2C;BSD<>8Q77QI3682;2B6=P=I:1A3JDUR5UG0DRTXK580PNU7=<6@:<G=4EY0L9LOOEHS6TR==", new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.26174496644295%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0938()
  {
    rc_boolean = (new BigDecimal("0")).equals("MC42H>A6XBLL36IE9Q2B3?>F9VT:WEG?8VT71JSG7OAY;7830=W@4ORWK6BRDRV64LPW6VFU:NKPE9U0@SU38DWNQ62BKMV2PS@M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0945()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0946()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0949()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("1E+19")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0958()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0960()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1PSK3S44AGA9J3YDIJ<4UN;TY6AW<NQB4:@Y7YA0IVB8ETXH540HM9LR35G13FMMA<NA13@VD<@C@?6A:5D<IEHQU6YBR>3>V7CV", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus();
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).plus(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0968()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//    }
//  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), 0, 0);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0972()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("5E-324")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0973()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).compareTo(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0974()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("5E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+324", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0976()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("0E+324")).intValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.59731543624162%", true, caught);
//    }
//  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigInteger = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0979()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("5E-324")).compareTo(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("5E-324"), 2147483647, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0986()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("0E+324"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0987()
  {
    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0988()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("0E+324"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0989()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("5E-324")).divide(new BigDecimal("0E+324"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.59731543624162%", true, caught);
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).scaleByPowerOfTen(-1);
    Assert.assertEquals("5E-325", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_int = (new BigDecimal("0E+324")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0993()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigInteger();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0994()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("5E-324")).divideToIntegralValue(new BigDecimal("5E-324"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("5E-324"));
    Assert.assertEquals("2E+323", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("5E-324"), 1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
}
