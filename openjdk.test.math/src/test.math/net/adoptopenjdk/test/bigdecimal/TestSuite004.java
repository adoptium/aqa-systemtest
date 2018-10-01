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
public class TestSuite004 extends TestCase
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
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6WX;;E=OL0QT5H75GE91KFS<@VYCC83JDTMW<DDVQK6N<IH76WCHO56LSS;3MP>8I@83C3I21MKD5H8FMVKRLB024>?ITJ<;QFSJ", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0005()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).multiply(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("1.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0011()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483646")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '8', '\0', '\0', '\0', '\1', '\uFFFF'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0016()
  {
    rc_int = (new BigDecimal("0E-2147483646")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate();
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).setScale(1);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0023()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1.0"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0029()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0034()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0035()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JHWP@WGBCMRYI318L?SF=G@3OO;N");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0038()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0039()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '\234', '\0', '\234', '\0', '8', '\234', '\1', '\0', '\0', '8', '8', '\234', '\0', '\uFFFF', '\1', '\0', '\234', '8', '\0', '8', '\1', '\uFFFF', '\1', '\234', '8', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '8', '\234', '8', '8', '\1', '\0', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\1', '\0', '\0', '\0'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0041()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).abs();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0048()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0050()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).add(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
//  public void testItem_0051()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).abs();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("1E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0058()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).abs();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0064()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointRight(0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0065()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0066()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0077()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0078()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0079()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0083()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0084()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0085()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TX22<A<1>41HELW0NQTCY@MNJ;>VRID8ISK348LILOES:QN4HA@PS>AASP;3<UU6KTNVX0LR<OCWC1>6:F1758AE3BJFB32H;689", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\uFFFF', '8', '\1', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\1', '8', '8', '\1', '\0', '\0', '\234', '8', '\1', '\1', '\1', '\1', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("2")).subtract(new BigDecimal("2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).multiply(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("85070591730234615847396907784232501249", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\1', '8', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\234', '\1', '8', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '8', '\234', '\0', '8', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\234', '\1', '8', '\234', '\1', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '\1', '8', '8', '\1', '8', '\0', '\1', '8', '8', '\234', '\1', '8', '\uFFFF', '8', '\234', '\234', '\1', '8', '8', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0104()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toEngineeringString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0108()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("85070591730234615847396907784232501249"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\0', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '8', '8', '\0', '\0', '8', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\234', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\uFFFF', '8', '\1', '8', '\1', '\0', '\uFFFF', '\0', '8', '8', '\1', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '8', '\1', '\0', '\234', '\234', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("85070591730234615847396907784232501249")).movePointLeft(1);
    Assert.assertEquals("8507059173023461584739690778423250124.9", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8507059173023461584739690778423250124.9")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0114()
  {
    rc_boolean = (new BigDecimal("2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\0', '\0', '\0', '\234', '8', '8', '\0', '8', '\234', '\0', '\uFFFF', '8', '\1', '8', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0118()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0119()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0120()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("8507059173023461584739690778423250124.9")).divide(new BigDecimal("1"), -1, 1);
    Assert.assertEquals("8.50705917302346158473969077842325012E+36", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).min(new BigDecimal("8507059173023461584739690778423250124.9"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0124()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.03125")).setScale(-2147483648, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
//  public void testItem_0125()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("8507059173023461584739690778423250124.9")).remainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("8507059173023461584739690778423250124.9")).add(new BigDecimal("8507059173023461584739690778423250124.9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("17014118346046923169479381556846500249.8", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).ulp();
    Assert.assertEquals("0.00001", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_int = (new BigDecimal("-0.03125")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0130()
  {
    rc_float = (new BigDecimal("-2147483648")).floatValue();
    Assert.assertEquals(-2.147483648E9F, rc_float, 0);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).stripTrailingZeros();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("8507059173023461584739690778423250124.9"));
    Assert.assertEquals("8507059173023461584739690776275766476.9", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\234', '\0', '\0', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '8', '\1', '\0', '\234', '8', '\234', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '\0', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0135()
  {
    rc_int = (new BigDecimal("8507059173023461584739690776275766476.9")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("8507059173023461584739690778423250124.9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_int = (new BigDecimal("-2147483648")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0140()
  {
    rc_double = (new BigDecimal("-2147483648")).doubleValue();
    Assert.assertEquals(-2.147483648E9, rc_double, 0);
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0142()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0144()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0145()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("8507059173023461584739690778423250124.9"));
    Assert.assertEquals("8507059173023461584739690778423250123.9", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0148()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0149()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0150()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("OJH25X");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0151()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8O=8W?QI8NA:3>:65?TUWQ0D1;>>>00XSR816=1JS=G2D5YTAHK205TR:VE>RQPOT8L?E7B0@9MCWKY;FB>S:>JA?M3P<JOGK@F<", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0155()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0156()
  {
    rc_String = (new BigDecimal("8507059173023461584739690778423250123.9")).toString();
    Assert.assertEquals("8507059173023461584739690778423250123.9", rc_String);
  }
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0158()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0160()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0167()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0168()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0171()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).scaleByPowerOfTen(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).multiply(new BigDecimal("3.2E-2147483645"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483645"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0176()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0177()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).divideToIntegralValue(new BigDecimal("3.2E-2147483645"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0178()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0179()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0180()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0182()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).ulp();
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-1074")).divide(new BigDecimal("3.2E-2147483646"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0191()
  {
    rc_long = (new BigDecimal("-2147483648")).longValueExact();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0192()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigIntegerExact();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
//  public void testItem_0194()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-3.2E-2147483646"), java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0196()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0198()
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
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U3BPP1A:03XCQ54C", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0210()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0211()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PHH8XEUPB?HTY9T=6P6YX2ISQGAKVFXI?NW7:=QC77RENP8GSTX@2L5LPFMGNT;PKEE;LT:MT6;AOV=J48Q;0KU=OINS5G;YJN8K", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0216()
  {
    rc_int = (new BigDecimal("10")).intValue();
    Assert.assertEquals(10, rc_int);
  }
//  public void testItem_0217()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '8', '8', '\1', '\1', '\1', '\0', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\234', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\0', '\234', '\0', '\1', '\1', '8', '\234', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '8'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0218()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("-31")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_long = (new BigDecimal("-31")).longValue();
    Assert.assertEquals(-31L, rc_long);
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\0', '\0', '\0', '\0', '\0', '8', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '8', '\1', '\1', '\234', '\uFFFF', '8', '\0', '8', '8', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\0', '\234', '\1', '\1', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '8', '\234', '8', '\1'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0228()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0229()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0234()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0236()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0239()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0240()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0.1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0244()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).stripTrailingZeros();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0250()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0253()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-0.9", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0260()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigInteger = (new BigDecimal("1.1")).unscaledValue();
    Assert.assertEquals("11", rc_BigInteger.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\uFFFF', '\1', '8', '\1', '\234', '8', '\uFFFF', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\0', '8', '\234', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\234', '\0', '8', '\1', '\uFFFF', '\1', '\1', '\234', '8', '\234', '\1', '\1', '\234', '\1', '\0', '\234', '\234', '\0', '\1', '\1', '\234', '8', '\0', '\1', '\1', '\1', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '8', '\1', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '8'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@X>CWT48IJBGA7BC56KN<UIAUKE3>:3KNT?A8A>5H5GJNG1T6Y2S@M>K2ET9BMO8F3ON9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0267()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1.1")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).pow(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.1")).divide(new BigDecimal("1.1"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OF5Y8SSLO9D;0MQA89XY:YO@6GYXVPWYC=BF8O30MLBJLMXOQ7L25JQ4::6@W3;XYWPMUPKF=O", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0272()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";B;S70IN>8?;PQIOF<53DC?Q:Q5MH4<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("4?N6MGMRTIM9HVX5IPSSI<<7S:Y@@S9TAYN:29YXUHK3B3359SY:GXFK:OXS2NJ?A>93WJG:XSBC?<KINIV6X9NUO;F?1EA993SM", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0276()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("2")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0278()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0279()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0280()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\1', '8', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\0', '\1', '\0', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '8', '\234', '\1', '\1', '\1', '\1', '8', '\234', '\0', '\uFFFF', '\234', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '8', '8', '8', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '8', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234'}, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0282()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0285()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0291()
  {
    rc_int = (new BigDecimal("9223372036854775807")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0292()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValueExact();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0300()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0303()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0304()
  {
    rc_boolean = (new BigDecimal("0")).equals("OCA<8D=GC38GVU1<DCF6IMKA9A=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0306()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0312()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0314()
  {
    rc_float = (new BigDecimal("2147483647")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0317()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("32.0E+2147483647")).max(new BigDecimal("0"));
//    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0323()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0324()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 0, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0327()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0331()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0332()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0336()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0340()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0343()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E-2147483647"), -1, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("-32"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0359()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("-32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-64", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_BigInteger = (new BigDecimal("-64")).toBigInteger();
    Assert.assertEquals("-64", rc_BigInteger.toString());
  }
  public void testItem_0367()
  {
    rc_long = (new BigDecimal("00.0E+2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0368()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("-64")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("-7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_int = (new BigDecimal("0E-2147483646")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0373()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("-64")).divide(new BigDecimal("-64"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal_array = (new BigDecimal("-7E+1")).divideAndRemainder(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-32"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("-32")).pow(1);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).negate();
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\234', '8', '8', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '\0', '\uFFFF'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0382()
  {
    rc_BigInteger = (new BigDecimal("-32")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).multiply(new BigDecimal("-32"));
    Assert.assertEquals("-1.00000", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.03125")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).multiply(new BigDecimal("-32"));
    Assert.assertEquals("-1.00000", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_String = (new BigDecimal("-1.00000")).toPlainString();
    Assert.assertEquals("-1.00000", rc_String);
  }
  public void testItem_0388()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_double = (new BigDecimal("-0.03125")).doubleValue();
    Assert.assertEquals(-0.03125, rc_double, 0);
  }
//  public void testItem_0392()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0393()
  {
    rc_String = (new BigDecimal("-32")).toPlainString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GR=KH;G8WGLNRQHANNP85GG:L1KJ?LJG;63=AJ:FR652CLBGLTPA3LDQ:F6632AI2<D8569O0@MSG9VI9?T3D");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-1.00000"), 0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0399()
  {
    rc_String = (new BigDecimal("-5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000")).toPlainString();
    Assert.assertEquals("-5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000", rc_String);
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).divide(new BigDecimal("-32"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0402()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(-1, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '8', '\234', '8', '8', '\234', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\1', '8', '\234', '\uFFFF', '8', '\234', '\0', '8', '\1', '\0', '\234', '\1', '\234', '8', '8', '\1', '8', '\0', '\0', '\uFFFF', '8', '\1', '\234', '8', '\0', '\0', '8', '\1', '\0', '\0', '8', '8', '\0', '8', '8', '\1', '8', '\234', '\234', '\234', '\0', '8', '8', '\234', '\1', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0404()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0405()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\1', '\0', '\234', '8', '8', '\0', '\uFFFF', '\0', '8', '\0', '8', '8', '\uFFFF', '\234', '\0', '\1', '8', '8', '\0', '\234', '\1', '\0', '\234', '8', '\0', '\234', '\234', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '8', '\1', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\234', '\1', '\234', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\0', '\1', '\0', '\uFFFF', '\234', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0406()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(2147483647);
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.03125")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\0', '\234', '8', '8', '8', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\0', '8', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\234', '8', '8', '\234', '\1', '8', '8', '\uFFFF', '\1', '\234', '\234', '\234', '\1'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\1', '\1', '\0', '\0', '\1', '\1', '\0', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\234', '8', '8', '\0', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '8', '\0', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\0', '\234', '8', '\0', '\1', '\1', '8', '8', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '\234', '\0'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0415()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0416()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.03125")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-0.03125"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("32"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\1', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '8', '8', '8', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\1', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '\234', '8', '\0', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).max(new BigDecimal("-0.03125"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\1', '8', '8', '\0', '\234', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\234', '\1', '\1', '\0', '\234', '8', '8', '\0', '8', '\0', '\1', '\0', '\0', '\0', '\1', '\234', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '\1', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\234', '\0', '\0', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\1'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0429()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointLeft(2147483647);
    Assert.assertEquals("-1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E-2147483339", rc_BigDecimal.toString());
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).abs();
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("11", rc_BigDecimal.toString());
  }
//  public void testItem_0434()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0435()
  {
    rc_int = (new BigDecimal("11")).intValue();
    Assert.assertEquals(11, rc_int);
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("11")).movePointLeft(2147483647);
    Assert.assertEquals("1.1E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '\234', '\1', '\234', '\1', '8', '8', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '8', '\1', '\234', '8', '8', '\uFFFF', '8', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\234', '\1', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\0', '\234', '8', '\0', '\234'}, -2147483648, 1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0440()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0441()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.1E-2147483646")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0442()
  {
    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0443()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(-2706431, rc_int);
//  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("11")).subtract(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858379", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8', '\234', '8', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '8', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0446()
  {
    rc_String = (new BigDecimal("11")).toPlainString();
    Assert.assertEquals("11", rc_String);
  }
  public void testItem_0447()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0448()
  {
    rc_BigDecimal_array = (new BigDecimal("1.1E-2147483646")).divideAndRemainder(new BigDecimal("0.03125"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0449()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824.00000", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("11"), 0);
    Assert.assertEquals("-16342664862384688255866129430154941527097324320531363327174316073014296434548048978235414421160625288321859904864943860384938302444496743888042504245776137907822719143322843825113226371853575358552351682586830358391325748809383904378709869030193031661345256927649520288067107016447209080113673093289465896216", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigInteger = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0454()
  {
    rc_float = (new BigDecimal("0.03125")).floatValue();
    Assert.assertEquals(0.03125F, rc_float, 0);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\1', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\1', '8', '\1', '\234', '\234', '8', '\uFFFF', '\0', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\0', '\0', '8', '\1', '\234', '8', '\234', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '8', '\234', '\1', '\1', '8', '\234', '8', '\1', '\uFFFF', '8', '\0', '8', '\234', '\0', '\234', '\0', '\234', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\234'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0457()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.03125")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0462()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0463()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0464()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0465()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.03125")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0466()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_int = (new BigDecimal("-0.03125")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_long = (new BigDecimal("-0.03125")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0477()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("11")).add(new BigDecimal("0.03125"));
    Assert.assertEquals("11.03125", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_int = (new BigDecimal("9223372036854775807")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0481()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0482()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '\234', '\234', '\0', '\0', '\0', '8', '\0', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '8', '8', '\1', '\0', '\1', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '8', '\uFFFF', '\234', '8', '8', '\234', '\1'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("11")).multiply(new BigDecimal("-0.03125"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.34375", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_String = (new BigDecimal("11")).toPlainString();
    Assert.assertEquals("11", rc_String);
  }
//  public void testItem_0485()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-0.03125")).divideAndRemainder(new BigDecimal("-0.03125"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).subtract(new BigDecimal("-0.34375"));
    Assert.assertEquals("0.31250", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11")).divide(new BigDecimal("11.03125"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0488()
  {
    rc_String = (new BigDecimal("0.31250")).toEngineeringString();
    Assert.assertEquals("0.31250", rc_String);
  }
//  public void testItem_0489()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.31250")).hashCode();
//    Assert.assertEquals(968755, rc_int);
//  }
  public void testItem_0490()
  {
    rc_String = (new BigDecimal("0.31250")).toString();
    Assert.assertEquals("0.31250", rc_String);
  }
  public void testItem_0491()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("11")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("11"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-0.03125")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("11")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_long = (new BigDecimal("-0.03125")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).movePointLeft(-1);
    Assert.assertEquals("-0.3125", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("-0.3125")).subtract(new BigDecimal("-0.03125"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-0.28125", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0.31250"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    rc_float = (new BigDecimal("-0.03125")).floatValue();
    Assert.assertEquals(-0.03125F, rc_float, 0);
  }
  public void testItem_0505()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("-0.28125")).add(new BigDecimal("-3"));
    Assert.assertEquals("-3.28125", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("-3.28125")).divide(new BigDecimal("11"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-0.28125"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0510()
  {
    rc_boolean = (new BigDecimal("-1")).equals("MM2V>N:<71AC5RPWYVGK4WYYK@OGN4:SWWU9>6B2YV2P?A4V0HY6X6?V>:FIL<WM7T5<JBLWXYLI83YRKTJGG");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0511()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0513()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("472CIEP3H9EBNQ2GE");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0517()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\234', '8', '\234', '\0', '\1', '8', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\234', '\234', '\1', '\0', '\1', '8', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\1', '\234', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\uFFFF'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0518()
  {
    rc_long = (new BigDecimal("-0.28125")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0519()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigInteger = (new BigDecimal("11")).unscaledValue();
    Assert.assertEquals("11", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0521()
  {
    rc_boolean = (new BigDecimal("-0.28125")).equals("AYCYY;3YXC;F:7BIKSD<X:;0PRW?;FPI?V?=5CJ>DBFAE91");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("-0.28125")).subtract(new BigDecimal("-0.28125"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.00000"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0527()
  {
    rc_String = (new BigDecimal("-0.28125")).toPlainString();
    Assert.assertEquals("-0.28125", rc_String);
  }
  public void testItem_0528()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8LU>F=<8?1?7>K@:;A>RQTM4<75AVTPK<0R>G9=PU:BFQV=L7MFJJ2F8MBVGFL9K74@JL1<?<3IXBGMHFX@RE8JX8OW;FS@DG=D3");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).multiply(new BigDecimal("1"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0539()
  {
    rc_BigInteger = (new BigDecimal("0.00000")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0548()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0550()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\1', '8', '\1', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '\0', '\1', '\1', '\1', '\0', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\0'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0552()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("V;<GCBS9NF=;EA0KDMUWA?68IV");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0556()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
//  public void testItem_0561()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-32")).hashCode();
//    Assert.assertEquals(-992, rc_int);
//  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"));
  }
//  public void testItem_0565()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("33"), new MathContext("precision=0 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0568()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0569()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0570()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0571()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("0"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0572()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0573()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
//  public void testItem_0574()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0575()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0584()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).precision();
//    Assert.assertEquals(2, rc_int);
//  }
//  public void testItem_0585()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).add(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("6.4E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0588()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0589()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("640.0E+2147483647")).intValue();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0592()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).divide(new BigDecimal("3.2E+2"));
//    Assert.assertEquals("2E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0593()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0594()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+2147483647")).divide(new BigDecimal("2E+2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0595()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2147483647"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0598()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).remainder(new BigDecimal("640.0E+2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0601()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0602()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0603()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0605()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0606()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J96HLRX1;7G8=T3JRLYM26TJT7B:PKSA:SC1;F<YNSS5MALY6VPXCY<YUHQOJS:TIN3KRH:YXQU<H@LQX3DRPR4W?DEBA2U62EIR");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0611()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("4PGEORR?KBB0W5?AHDH80EX:WHO?K=C<@C9N1L?:SO;5QB1LX:4@IA4SQ?G901IM2JD6;BOLN6H@VW1GSJK=P8P2JHP9JKCJ72:G");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0614()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0615()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0616()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0621()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0622()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0629()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divideToIntegralValue(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("U1MK8:SE1QVH27EY7?OIX2WSYIYA2OS=UYOE>DPAELAXX0N:63P3F31:L@TW9DQH:R89BHJ<QH2VJ1XER1R2");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0631()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0634()
  {
    rc_String = (new BigDecimal("-9223372036854775807")).toString();
    Assert.assertEquals("-9223372036854775807", rc_String);
  }
  public void testItem_0635()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).add(new BigDecimal("0"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NWB;0=4JEXU585YGXPEHM7;W847>7OE5<QFI2KTTX>KEI=XA4", new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0647()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toPlainString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-9223372036854775807"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0650()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0653()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0657()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0658()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0659()
  {
    rc_boolean = (new BigDecimal("9223372036854775807")).equals("W>=AJ5S3I?GJRXOQV:YVMO2LU:T5=5M:GDU76K?EKK<TRXX4=VDU2>IEEM;>4L5GXH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0660()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775807")).toBigInteger();
    Assert.assertEquals("-9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("-9223372036854775807"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0663()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0664()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divide(new BigDecimal("9223372036854775807"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("45OWIC4DBRDA9K1RNW", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0675()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).min(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0678()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0679()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0680()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(1);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0696()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0697()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).remainder(new BigDecimal("-2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0701()
  {
    rc_boolean = (new BigDecimal("-2147483647")).equals("=TNMITFY4AQA15F:<29A9:AP:NQUQW=XM14QDQ8N46;5WDS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(0);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_String = (new BigDecimal("-2147483647")).toPlainString();
    Assert.assertEquals("-2147483647", rc_String);
  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0705()
  {
    rc_long = (new BigDecimal("-2147483647")).longValueExact();
    Assert.assertEquals(-2147483647L, rc_long);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\0', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\0', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\1', '\1', '8', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\234', '\1', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '\0', '\0', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0707()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("2.8823037615171174396875E+2147483664", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0711()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\1', '\1', '8', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\234', '\0', '\uFFFF', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\234', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '\234', '8', '\1', '8', '\1', '8', '8', '\0', '\0', '\uFFFF', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0712()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-1);
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483645"), java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483645")).divideToIntegralValue(new BigDecimal("288230376151711743.96875E+2147483647"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("288230376151711743.96875E+2147483647")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("288230376151711743.96875E+2147483647")).ulp();
    Assert.assertEquals("1E+2147483642", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigInteger = (new BigDecimal("288230376151711743.96875E+2147483647")).unscaledValue();
    Assert.assertEquals("28823037615171174396875", rc_BigInteger.toString());
  }
  public void testItem_0722()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0723()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\1', '\0', '8', '\0', '\0', '\0', '8', '\0', '8', '\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\1', '8', '\0', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\234', '8', '\234', '\234', '8', '\0', '8', '\uFFFF', '\1', '\1', '\0', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\1', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\1', '8', '8', '\0', '\0', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '\1', '8', '\234', '\1', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\234', '\234', '8', '\0', '\1', '8', '8', '\234', '\1', '\1', '\1', '\1', '\234', '\1', '8', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\234', '\1', '\0', '\0', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0728()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483642")).movePointLeft(-1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0733()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_String = (new BigDecimal("288230376151711743.96875E+2147483647")).toString();
    Assert.assertEquals("2.8823037615171174396875E+2147483664", rc_String);
  }
//  public void testItem_0736()
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
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0738()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("288230376151711743.96875E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
//  public void testItem_0747()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E-2147483646"), 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0748()
  {
    rc_int = (new BigDecimal("3E-2147483646")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0749()
  {
    rc_String = (new BigDecimal("3E-2147483646")).toString();
    Assert.assertEquals("3E-2147483646", rc_String);
  }
  public void testItem_0750()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '\234', '\0', '\234', '8', '\uFFFF', '\1', '\1', '\1', '8', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '8', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\0', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\234', '\uFFFF', '\234', '8', '8', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0753()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0754()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0755()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), 2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3.2E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0762()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0763()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0764()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0765()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483646")).abs();
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0773()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0774()
  {
    rc_String = (new BigDecimal("3E-2147483646")).toString();
    Assert.assertEquals("3E-2147483646", rc_String);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0777()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0778()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0779()
  {
    rc_int = (new BigDecimal("-3E-2147483646")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\1', '8', '8', '8', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '\1', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\0', '8', '\0', '\0', '\0', '\uFFFF', '8', '\1', '\0', '\0', '8', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '\1', '\1', '\0', '\234', '8', '8', '\0', '8', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0786()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0792()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0793()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '8', '\1', '8', '8', '8', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\234', '8', '\234', '8', '\0', '\0', '\0', '\234', '\1', '\1', '\1', '8', '\1', '\234', '\0', '\0', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\0', '\234', '\0', '8', '\uFFFF', '8', '\234', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8XROJDP8NA7P490AUJOA8<;110XCKFXLV;WUDV<=DKNOY0Q;AYCEEBMUO:00DU8DR2FWN?F2XT4JI8M5TKTTD7<SSWW:689JC1O<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0801()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0803()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0807()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0810()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0811()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0815()
  {
    rc_int = (new BigDecimal("1E+12")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0816()
  {
    rc_float = (new BigDecimal("62")).floatValue();
    Assert.assertEquals(62.0F, rc_float, 0);
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("33")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("65", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("65")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-65", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("65")).remainder(new BigDecimal("-65"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("-65")).min(new BigDecimal("0"));
    Assert.assertEquals("-65", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal_array = (new BigDecimal("65")).divideAndRemainder(new BigDecimal("62"));
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("62"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-65"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0827()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0828()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0829()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0832()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0833()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("62"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0840()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0841()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0842()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0843()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '8', '\1', '\uFFFF', '\0', '8', '8', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\1', '8', '\234', '\uFFFF', '8', '\0', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\1', '8', '8', '\1', '\1', '8', '8', '\uFFFF', '\1', '8', '\234', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '8', '\0', '\0', '\0', '\1', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '8', '\234', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\0', '\1'}, 1, 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0852()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("0.1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_int = (new BigDecimal("0.1")).compareTo(new BigDecimal("0.1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).max(new BigDecimal("-1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0866()
  {
    rc_boolean = (new BigDecimal("1")).equals("4:I=B>E<YI73@Q=R<6<AL74TOWD=4JP3GCF@YK63O5:NUWBPVG?4DP4JQVA@GJJDJ=<M@K2NR7L<I;U92HX=<C<IE31=517K80:P");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0873()
  {
    rc_String = (new BigDecimal("0.1")).toString();
    Assert.assertEquals("0.1", rc_String);
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//  }
  public void testItem_0875()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0876()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0879()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\234', '\234', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '8', '\1', '\0', '\uFFFF', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\0', '\uFFFF', '\234', '\234', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '8', '\0', '8', '\1', '\0', '\uFFFF', '\1', '8', '8', '\0', '8', '8', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\0', '8', '8', '\234', '\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0882()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0883()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0.1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_float = (new BigDecimal("4E+1")).floatValue();
    Assert.assertEquals(40.0F, rc_float, 0);
  }
  public void testItem_0889()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0890()
  {
    rc_double = (new BigDecimal("4E+1")).doubleValue();
    Assert.assertEquals(40.0, rc_double, 0);
  }
//  public void testItem_0891()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("89.93288590604027%", true, caught);
//    }
//  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("4E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0902()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("GMP;?46WYS7KN9TCJ8VGYLRWNCBQS<>0Y4OVUI6>MRRWMJLKHHVFGELP;W5P;=TLOB;9BS5C<084;?GMO3WKD");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0903()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0904()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0905()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).hashCode();
//    Assert.assertEquals(2706431, rc_int);
//  }
  public void testItem_0906()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0914()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).divide(new BigDecimal("0.0"), 0, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0915()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\234', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '8', '\234', '\234', '\1', '8', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '8', '\234', '\234', '\uFFFF', '\1', '\1', '8', '\1', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\234', '\234', '\1', '\0', '\0', '\234', '\1', '\0', '\1', '\234', '\0', '8', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0920()
  {
    rc_long = (new BigDecimal("4E+1")).longValue();
    Assert.assertEquals(40L, rc_long);
  }
  public void testItem_0921()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0922()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("4E+1")).subtract(new BigDecimal("4E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E+2")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0925()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4E+1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-1"), 1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0931()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_long = (new BigDecimal("-3.2E+2")).longValueExact();
    Assert.assertEquals(-320L, rc_long);
  }
  public void testItem_0935()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E+2")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_long = (new BigDecimal("-3.2E+2")).longValueExact();
    Assert.assertEquals(-320L, rc_long);
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '\234', '\234', '\0', '8', '\1', '\0', '\234', '8', '\1', '\234', '8', '\0', '8', '\uFFFF', '8', '8', '\1', '\234', '\1', '\0', '8', '8', '\234', '\234', '\234', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '8', '\234', '8', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\234', '\234', '8', '\234', '\uFFFF', '8', '\1', '\0', '8', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0941()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).unscaledValue();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).multiply(new BigDecimal("-3.2E+2"));
    Assert.assertEquals("1.024E+5", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858369"));
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0949()
  {
    rc_float = (new BigDecimal("1.024E+5")).floatValue();
    Assert.assertEquals(102400.0F, rc_float, 0);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0954()
  {
    rc_BigInteger = (new BigDecimal("-2E+308")).toBigInteger();
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("-3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("89.93288590604027%", true, caught);
  }
  public void testItem_0960()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
//  public void testItem_0961()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0966()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3.2E-2147483646")).hashCode();
//    Assert.assertEquals(2147482655, rc_int);
//  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367", rc_BigInteger.toString());
  }
  public void testItem_0970()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0971()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("-3.2E-2147483646"), 1);
//    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
//  }
//  public void testItem_0972()
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
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0975()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336")).divide(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858336"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).stripTrailingZeros();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0989()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0992()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0993()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-3.2E-2147483646"));
  }
  public void testItem_0994()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1135879015891")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0996()
  {
    rc_int = (new BigDecimal("1135879015891")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">GPN8YY>>KNN27=0F==69G@<EUJ7=FCNK>>UT48;TD3UR6532H@:W9Y<7NUVS?RHXLM69RPOOLCRUSTBQ@JQO0YEP6SBRCBHGB4=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0998()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).divide(new BigDecimal("3.2E-2147483646"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0999()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
}
