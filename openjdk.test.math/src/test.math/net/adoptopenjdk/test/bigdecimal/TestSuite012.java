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
public class TestSuite012 extends TestCase
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
    rc_BigDecimal = (new BigDecimal("-64")).negate();
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointRight(0);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0007()
  {
    rc_boolean = (new BigDecimal("1")).equals("59QA9<U3L952SW6LWP2W1W2;U6LUC8E:>YD46VYU@DYK9DDWQKDFUSHR<=P=EP145B:M>1SDF:4VQVKV@=6K>3DEJ9L10>O=HO?8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2JLA13D7;WIPARX0MX9K?=Q4<P6WSPC85I2:DP;R51RYQFJ>1O:1UXQME2AE");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("-32")).setScale(1, 1);
    Assert.assertEquals("-32.0", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("-32.0")).stripTrailingZeros();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("-32.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_long = (new BigDecimal("-32")).longValue();
    Assert.assertEquals(-32L, rc_long);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("-32")).stripTrailingZeros();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("-32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("-32"));
    Assert.assertEquals("-1.024E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("-32")).plus();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-32"), -1, 0);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("-32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("3E+1"), 1, 0);
    Assert.assertEquals("34.2", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_int = (new BigDecimal("1024")).intValueExact();
    Assert.assertEquals(1024, rc_int);
  }
  public void testItem_0031()
  {
    rc_double = (new BigDecimal("1024")).doubleValue();
    Assert.assertEquals(1024.0, rc_double, 0);
  }
  public void testItem_0032()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0033()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0035()
  {
    rc_int = (new BigDecimal("-32")).intValue();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0036()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0037()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\uFFFF', '\234', '8', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0039()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0040()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0041()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0042()
  {
    rc_int = (new BigDecimal("-32")).intValue();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0043()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0044()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\0'}, 1, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("1024")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("-1E+3")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1000.0", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).stripTrailingZeros();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("-1E+3")).multiply(new BigDecimal("1024"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1.024E+6", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("-32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("W>UIMJI>0GXI8FMY9ESEHX<D95=0KFFDFC9YCBHJTO0;BVY24K307NQ>8U6T>5<R4QHI1:<S9Q7LPAL@MWCJ>6CX=LBFY9O97H4X", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("-1E+1"));
    Assert.assertEquals("3.0", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-32"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("3.0")).remainder(new BigDecimal("-1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.0", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("3.0")).plus();
    Assert.assertEquals("3.0", rc_BigDecimal.toString());
  }
  public void testItem_0057()
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
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("3.0")).movePointRight(-1);
    Assert.assertEquals("0.30", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("0.30")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigInteger = (new BigDecimal("3.0")).unscaledValue();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("3.0")).plus();
    Assert.assertEquals("3.0", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\0', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\234'}, 0, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divideToIntegralValue(new BigDecimal("-1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0068()
  {
    rc_boolean = (new BigDecimal("-1E+1")).equals("DY?55?X91UL;D4MIF058?DXMOYCONYL9E>F<0?5EVXFIKDYAOS6PWBDEY1V8E095WSWW=MP1@@H<>?MYC:V8RK@W1OAVPIO?;OOL");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\0', '\234', '\234', '\234', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '8', '8', '\1', '\1', '8', '\234', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\1', '8', '\1', '\1', '8', '8', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\0', '\1', '\234', '\234', '8', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\234', '\1', '8'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0070()
  {
    rc_boolean = (new BigDecimal("1")).equals("?AEOYPQRK>CWHA>1B1FBS2DI=W29L0;JTTDHFO08DY8MN9HDTO>:HCDW7N96<3J6::R3B427HIKGYI4B50DRBW9THR?FVJ6X=92K");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0071()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XL", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("5E-324")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0075()
  {
    rc_int = (new BigDecimal("5E-324")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0076()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.01")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0077()
  {
    rc_BigDecimal_array = (new BigDecimal("5E-324")).divideAndRemainder(new BigDecimal("3.0"));
  }
  public void testItem_0078()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0080()
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
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0082()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-2147483648")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0087()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).unscaledValue();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0088()
  {
    rc_int = (new BigDecimal("2147483647")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("IWI0LJ9CS2?88HUD1", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0092()
  {
    rc_BigDecimal_array = (new BigDecimal("5E-324")).divideAndRemainder(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0093()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("5E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E-314", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2147483647"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0096()
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
  public void testItem_0097()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E-314")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1E-314"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2147483648")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("-1E-314")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1E-314", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).stripTrailingZeros();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0104()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).multiply(new BigDecimal("-1E-314"));
    Assert.assertEquals("-9.9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999E-315", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).min(new BigDecimal("1"));
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_long = (new BigDecimal("-2147483648")).longValueExact();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).stripTrailingZeros();
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    Assert.assertEquals("1E-314", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-314")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).stripTrailingZeros();
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).divide(new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0115()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '8', '8', '\1', '8', '\0', '\uFFFF', '8', '8', '8', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '8', '8', '8', '\234', '\1', '\1', '\234', '\234', '\234', '\1', '\234', '\1', '8', '\0', '\0', '8', '\1', '\234', '\1', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("-1E-314")).add(new BigDecimal("-1E-314"));
    Assert.assertEquals("-2E-314", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).add(new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0121()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    rc_float = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0124()
  {
    rc_float = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0125()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).add(new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("1.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0130()
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
  public void testItem_0131()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0132()
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
  public void testItem_0133()
  {
    rc_BigDecimal = (new BigDecimal("1.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998")).setScale(-1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0134()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigInteger = (new BigDecimal("2.0")).unscaledValue();
    Assert.assertEquals("20", rc_BigInteger.toString());
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("1.99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999998"));
    Assert.assertEquals("0E-313", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0142()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("2.0"));
    Assert.assertEquals("2.0", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\234', '\0', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '\234', '\0', '8', '8', '\234', '\234', '\0', '8', '\uFFFF', '8', '\1', '\1', '\0', '\1', '\234', '\234', '\234', '8', '\uFFFF', '8', '\0', '\1', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '8', '\uFFFF', '\234', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '8', '\1', '\0', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\1', '8', '8', '\1'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0145()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\0', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0148()
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
  public void testItem_0149()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_int = (new BigDecimal("2.0")).compareTo(new BigDecimal("2.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0151()
  {
    rc_BigDecimal_array = (new BigDecimal("2.0")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
  }
  public void testItem_0152()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0153()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("2.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2.0"), -1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("9223372036854775807"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0160()
  {
    rc_int = (new BigDecimal("2.0")).intValue();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0161()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\234', '\1', '\0', '\1', '8', '\0', '8', '\0', '\1', '8', '\0', '8', '\uFFFF', '8', '\0', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\0', '8', '\0', '8', '\1', '\0', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\1', '\0', '\234', '8', '8', '\234', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\0', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\234', '\1', '8', '\0', '8', '\234', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("2.0"), -1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<X3MA9CAOY?A5F6HPX1SA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0165()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("2.0"));
    Assert.assertEquals("5", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2.0")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0169()
  {
    rc_int = (new BigDecimal("2.0")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0171()
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
  public void testItem_0172()
  {
    rc_BigInteger = (new BigDecimal("2.0")).toBigInteger();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0173()
  {
    rc_BigInteger = (new BigDecimal("2.0")).unscaledValue();
    Assert.assertEquals("20", rc_BigInteger.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("5"));
    Assert.assertEquals("6.4", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("6.4")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0178()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigInteger();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("5"));
    Assert.assertEquals("5", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("6.4")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("6.4")).negate();
    Assert.assertEquals("-6.4", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-6.4"));
    Assert.assertEquals("-6.4", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0187()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-6.4")).divide(new BigDecimal("0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("-6.4")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_double = (new BigDecimal("-6.4")).doubleValue();
    Assert.assertEquals(-6.4, rc_double, 0);
  }
  public void testItem_0191()
  {
    rc_BigDecimal = (new BigDecimal("5")).multiply(new BigDecimal("-6.4"));
    Assert.assertEquals("-32.0", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal_array = (new BigDecimal("-6.4")).divideAndRemainder(new BigDecimal("-32.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0193()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '8', '8', '\0', '\uFFFF', '\1', '\234', '\0', '8', '\234', '\1', '\234', '\0', '\0', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '8', '\234', '\0', '\0', '\1', '\0', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '8', '\1', '8', '8', '\0', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\0', '8', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("-32.0")).divideToIntegralValue(new BigDecimal("-32.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0195()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-6.4")).remainder(new BigDecimal("-6.4"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '\0', '\234', '8', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\0', '\0', '\234', '8', '\234', '\234', '\0', '\0', '\1', '8', '8', '\0', '8', '8', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\234', '8', '\1', '\0', '\234', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0198()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0199()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-6.4"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0200()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-6.4"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0202()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.0")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0203()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0204()
  {
    rc_BigInteger = (new BigDecimal("-6.4")).toBigInteger();
    Assert.assertEquals("-6", rc_BigInteger.toString());
  }
  public void testItem_0205()
  {
    rc_String = (new BigDecimal("-6.4")).toEngineeringString();
    Assert.assertEquals("-6.4", rc_String);
  }
  public void testItem_0206()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigInteger = (new BigDecimal("0.00")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0209()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0212()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0213()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0.01"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).scaleByPowerOfTen(0);
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).movePointRight(0);
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0220()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.01")).divideToIntegralValue(new BigDecimal("0.01"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("8"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_int = (new BigDecimal("0.01")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0229()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_byte = (new BigDecimal("0.00")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("0.00")).divide(new BigDecimal("0.01"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0233()
  {
    rc_boolean = (new BigDecimal("0.01")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0234()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\0', '\1', '\234', '\234', '8', '\1', '8', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\0', '\0', '\0', '\0', '8', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\0', '8', '\1', '\0', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0'}, -1, 1, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\1', '\1', '\1', '\0', '\234', '\234', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\234', '8', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\234', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\234', '8', '8', '\uFFFF', '\1', '\0', '8', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '\1', '8', '\0', '\234', '8', '8', '\1', '\1', '\234', '\234', '\0', '8', '\1', '\0', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\0'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775808")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0239()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0.01"));
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0244()
  {
    rc_int = (new BigDecimal("0.00")).scale();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).add(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.21", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0248()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\234', '8', '\234', '\0', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '8', '8', '\1', '\234', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\1', '\1', '\1', '8', '\0', '\0', '8', '\1', '\0', '\uFFFF', '\0', '\0', '8', '8', '\0', '\1', '\234', '\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0249()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0250()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0251()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.01")).setScale(2147483647, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0252()
  {
    rc_int = (new BigDecimal("3.21")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0.01"));
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0255()
  {
    rc_String = (new BigDecimal("0.32")).toEngineeringString();
    Assert.assertEquals("0.32", rc_String);
  }
  public void testItem_0256()
  {
    rc_int = (new BigDecimal("0.32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0257()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C@X5SCEU:<D=L;55;<KMI3B914QX6H=QY;0:G");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0258()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0260()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0261()
  {
    rc_int = (new BigDecimal("3.21")).scale();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0262()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).divide(new BigDecimal("3.21"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.10", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0265()
  {
    rc_int = (new BigDecimal("2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0266()
  {
    rc_BigDecimal = (new BigDecimal("0.10")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.10", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0267()
  {
    rc_boolean = (new BigDecimal("-1")).equals("@9P80M6<TG39P8S@B9HFLBPLA8?9K95GO@@TWXMN2BSG>E8G1:N4@9EBN<WVNVJ9O@AQTWIJG77>H<G7<F4RWKGGCIKS289@>O2E");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0268()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.10")).divide(new BigDecimal("-1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("0.32"));
    Assert.assertEquals("0.28", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_String = (new BigDecimal("-0.10")).toString();
    Assert.assertEquals("-0.10", rc_String);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("-0.10")).divideToIntegralValue(new BigDecimal("-0.10"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0273()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.21")).divideAndRemainder(new BigDecimal("-0.10"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0274()
  {
    rc_float = (new BigDecimal("3.21")).floatValue();
    Assert.assertEquals(3.2100000381469727F, rc_float, 0);
  }
  public void testItem_0275()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0276()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).negate();
    Assert.assertEquals("-0.32", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("-0.10"), 2147483647, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("3.21")).compareTo(new BigDecimal("3.21"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0280()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.32")).setScale(2147483647, 0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).ulp();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.01")).divide(new BigDecimal("-1"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("-0.10")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0.10", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).abs();
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0292()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0295()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\0', '\234', '\0', '8', '\1', '\0', '\0', '\1', '\234', '8', '\1', '\1', '8', '8', '\uFFFF', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0296()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\234', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\1', '\0', '\234', '\1', '8', '\0', '8', '8', '\uFFFF', '\0', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\234', '8', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\1', '8', '\0', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\1', '8', '8', '\1', '8', '\0', '\234', '\1', '8', '8', '\1'}, 1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\uFFFF', '\0', '\1', '8', '\234', '8', '\uFFFF', '\0', '\234', '\234', '\0', '8', '\1', '8', '\234', '\1', '\0'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0303()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).add(new BigDecimal("0.01"));
    Assert.assertEquals("0.02", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("-2")).divideToIntegralValue(new BigDecimal("-2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0.02")).plus();
    Assert.assertEquals("0.02", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("-2")).movePointRight(1);
    Assert.assertEquals("-20", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_long = (new BigDecimal("-20")).longValueExact();
    Assert.assertEquals(-20L, rc_long);
  }
//  public void testItem_0310()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.02")).hashCode();
//    Assert.assertEquals(64, rc_int);
//  }
  public void testItem_0311()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";XJ43HV24316C99H::T2B1E;DH?GCQS8VCY34>K6MKMKFYIELQN9CMFE1ESK@WA0>NJ4APWY:Y=JKM4H1Q7=5BJ=L?K=OF5?EBPS", new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0313()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).unscaledValue();
    Assert.assertEquals("4940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("-20")).stripTrailingZeros();
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("0.02")).abs();
    Assert.assertEquals("0.02", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '8', '8', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '8', '\1', '8', '\uFFFF', '\1', '\0', '\1', '\234', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\234', '8', '\234', '\234', '\234', '8', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("-2")).add(new BigDecimal("0.02"));
    Assert.assertEquals("-1.98", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigInteger = (new BigDecimal("0.02")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("-1.98")).divideToIntegralValue(new BigDecimal("-1.98"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-20")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0321()
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
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).remainder(new BigDecimal("-1.98"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0326()
  {
    rc_BigDecimal_array = (new BigDecimal("-0.2")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0328()
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
  public void testItem_0329()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_int = (new BigDecimal("-0.2")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\0', '\234', '\234', '8', '\1', '\234', '\234', '\1', '\234', '\0', '\1', '\uFFFF', '8', '\234', '8', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0332()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).plus();
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.02")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0335()
  {
    rc_double = (new BigDecimal("-0.2")).doubleValue();
    Assert.assertEquals(-0.2, rc_double, 0);
  }
  public void testItem_0336()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).round(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0341()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-0.2"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0342()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigInteger = (new BigDecimal("-0.2")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0344()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0345()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_long = (new BigDecimal("-2E+308")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0347()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0348()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0349()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\0', '\234', '\1', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0350()
  {
    rc_String = (new BigDecimal("-0.2")).toString();
    Assert.assertEquals("-0.2", rc_String);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-4E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0352()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.2")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).divide(new BigDecimal("-2E+308"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0356()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("34X:WWFH5Q1VE=@<:RPUY7RE>TCTSMQT?FC51ITD3PEM@NP50OSYW1G?XG:OTI=8O4YD9IS72?XI1=LG=<8K?ASVRPB8QND?P<MB");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).max(new BigDecimal("3.2"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("-2E+308")).min(new BigDecimal("1E+1"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0364()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0366()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0367()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400", rc_BigDecimal.toString());
  }
//  public void testItem_0371()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0372()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0373()
  {
    rc_boolean = (new BigDecimal("3.2")).equals("Q>10B?XP:SBFD<?H?AYDDU6YLO:VO55MV00VH>:LGL9S:7??5KTB115FQEE:67<I5U3?=CFR<SAO=TUAH8K7IP1TK0URL85@:PC3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0374()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0375()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0376()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0378()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("UN55PM9H3<?061OQ=1TR7YG@4TW5P=7XDFW3KK<1BJ@LI;6RD9K><75G2?WP1@XHNGW0YANX>301:K<4E@OYAM42S;JUK=E7QRWX");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).stripTrailingZeros();
    Assert.assertEquals("1.797693134862315708145274237317043567980705675258449965989174768031572607800285387605895586327668781715404589535143824642343213268894641827684675467035375169860499105765512820762454900903893289440758685084551339423045832369032229481658085593321233482747978262041447231687381771809192998812504040261841248584E+308", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0384()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0385()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0388()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0389()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).unscaledValue();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400", rc_BigInteger.toString());
  }
  public void testItem_0390()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0391()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0393()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).add(new BigDecimal("0.1"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400.1", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0397()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400.1")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
//  public void testItem_0398()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400.1")).divideAndRemainder(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0401()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0403()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858364.8", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858364.8")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400.1"));
    Assert.assertEquals("-32.1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0407()
  {
    rc_boolean = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).equals("12TVW?:0>3FYW4O@1TI878B5J6SBOPHIYK2>R8=J6;4CCNW2OXFK=EF42A4QGHNJFTR=AF8PFQSQ3KLWWCWEPC6E5MUSUQNLT36;");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("-32.1"));
    Assert.assertEquals("-3.21", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("-3.21")).movePointLeft(1);
    Assert.assertEquals("-0.321", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigInteger = (new BigDecimal("-3.21")).unscaledValue();
    Assert.assertEquals("-321", rc_BigInteger.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("-3.21")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.21", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_long = (new BigDecimal("-2E+308")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0418()
  {
    rc_int = (new BigDecimal("-2E+308")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.01", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2E+308")).divideAndRemainder(new BigDecimal("-0.321"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("-0.321")).plus();
    Assert.assertEquals("-0.321", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("0.01")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-0.321"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).remainder(new BigDecimal("-0.321"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0428()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0429()
  {
    rc_boolean = (new BigDecimal("0.1")).equals("RUY4Y;<@6R;BFVXNJ?GG=:?NRDYKD9F;D@8:W5PR8SAB<<UNL:7SR:U4DCKM06A9IJGDF@FT=QI025TCGC3R2HKFW7WJS7UL97BO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0430()
  {
    rc_int = (new BigDecimal("0.1")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_double = (new BigDecimal("0.1")).doubleValue();
    Assert.assertEquals(0.1, rc_double, 0);
  }
  public void testItem_0433()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367.9", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("-179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858367.9"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0436()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("1.79769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368E+309", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0.1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0443()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=1 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0444()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("5QLBQ2L5UO=21<FPX5A");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=1 roundingMode=CEILING"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0449()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.1")).hashCode();
//    Assert.assertEquals(32, rc_int);
//  }
  public void testItem_0450()
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
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0454()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).subtract(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).movePointRight(1);
    Assert.assertEquals("92233720368547758070", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000E+308")).divide(new BigDecimal("2E+308"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0464()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\234', '8', '8', '8', '8', '\uFFFF', '\234', '\234', '\1', '\0', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '8', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\1', '\1', '\0', '8', '\234', '\234', '\234', '\uFFFF', '\0', '\1', '\1', '\234', '\0', '8', '\0', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\1', '8', '8', '\0', '\0', '\1', '\234', '8', '\0', '\0', '\uFFFF', '8', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("2E+308"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_long = (new BigDecimal("9223372036854775807")).longValue();
    Assert.assertEquals(9223372036854775807L, rc_long);
  }
  public void testItem_0474()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0475()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0476()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigIntegerExact();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0482()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9223372036854775807")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9223372036854775807"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0495()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).max(new BigDecimal("1"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0498()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0499()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?4NLJ0HXI4FS");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0503()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0504()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0505()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0507()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("9223372036854775807.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).setScale(1);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '8', '8', '\234', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\234', '\234', '8', '\1', '8', '\234', '\1', '\1', '8', '\0', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '8', '\uFFFF', '8', '\0', '8', '\234', '8', '\1', '\1', '8', '\1', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\0', '\0'}, -1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_int = (new BigDecimal("9223372036854775807")).precision();
    Assert.assertEquals(19, rc_int);
  }
  public void testItem_0515()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0519()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("9223372036854775807")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0522()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).divide(new BigDecimal("9223372036854775807.0"), 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_int = (new BigDecimal("9223372036854775807.0")).compareTo(new BigDecimal("1.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0534()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0535()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0538()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0539()
  {
    rc_BigInteger = (new BigDecimal("0.1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("0.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_String = (new BigDecimal("-9223372036854775807.0")).toString();
    Assert.assertEquals("-9223372036854775807.0", rc_String);
  }
  public void testItem_0547()
  {
    rc_float = (new BigDecimal("-9223372036854775807.0")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0550()
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
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("9223372036854775807.0")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807.0")).abs();
    Assert.assertEquals("9223372036854775807.0", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.1")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '\0', '\0', '8', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '8', '\0', '8', '\0', '\0', '\uFFFF', '\0', '8', '\0', '\1', '\234', '\0', '8', '\234', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\1', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0559()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0560()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("-2147483646.9", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_int = (new BigDecimal("2147483647")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0562()
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
  public void testItem_0563()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, 0);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).stripTrailingZeros();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\1', '\0', '\1', '\1', '\0', '8', '\234', '\0', '\uFFFF', '8', '8', '\0', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '8', '\0', '\234', '\1', '\0', '\234', '\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0570()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0571()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-2147483647.0", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0575()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2147483647")).hashCode();
//    Assert.assertEquals(2147483617, rc_int);
//  }
  public void testItem_0576()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '8', '8', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '8', '8', '8', '\1', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '8', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '8', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\234', '\1', '\1', '8', '\234', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\234', '8', '\234', '\0', '8', '\0', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\1', '\1', '\1', '8', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\0', '\234', '8', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).negate();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647.0")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("-67108863.9", rc_BigDecimal.toString());
  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("32"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0588()
  {
    rc_int = (new BigDecimal("2147483647")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0595()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647.0")).divide(new BigDecimal("3.2"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-671088639.7", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).max(new BigDecimal("-671088639.7"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0598()
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
  public void testItem_0599()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0601()
  {
    rc_long = (new BigDecimal("-671088639.7")).longValue();
    Assert.assertEquals(-671088639L, rc_long);
  }
  public void testItem_0602()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("3.2"));
    Assert.assertEquals("10.24", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_int = (new BigDecimal("3.2")).intValue();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0611()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0614()
  {
    rc_long = (new BigDecimal("1E+1")).longValueExact();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1E+1"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigInteger = (new BigDecimal("-1E+1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("-1E+1"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigInteger = (new BigDecimal("-1E+1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0624()
  {
    rc_long = (new BigDecimal("-1E+1")).longValueExact();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0625()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0626()
  {
    rc_short = (new BigDecimal("-1E+1")).shortValueExact();
    Assert.assertEquals(-10, rc_short);
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '8', '\1', '\0', '\1', '\1', '\0', '\234', '\234', '\0', '\234', '8', '8', '8', '\0', '\uFFFF', '8', '8', '\0', '8', '\0', '8', '8', '\234', '\0', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\0', '\234', '\234', '\1', '8', '\uFFFF', '8', '8', '\0', '\234', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '8', '\1', '\1', '\1', '\0', '8', '8', '\uFFFF', '\234', '\234', '\0', '8', '8', '\1', '\1', '\0', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\234', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0632()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VK8V");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("31"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("31")).movePointLeft(1);
    Assert.assertEquals("3.1", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("31")).divideToIntegralValue(new BigDecimal("3.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0643()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.1")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0646()
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
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\1', '8', '\0', '\1', '\0', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\0', '8', '\234', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\1', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("31")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_int = (new BigDecimal("31")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0653()
  {
    rc_short = (new BigDecimal("8")).shortValueExact();
    Assert.assertEquals(8, rc_short);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("31")).add(new BigDecimal("8"));
    Assert.assertEquals("39", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0659()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0660()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '\uFFFF', '\234', '\0', '\1', '\0', '8', '8', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\1', '\1', '\1', '8', '\234', '\0', '8', '\1', '\uFFFF', '8', '\234', '\234', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '8', '\1', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\234', '8', '\1', '\1', '\1', '\234', '8', '\0', '\234', '8', '8', '\1', '\1', '\234', '\1', '\234', '8', '8', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\0', '\0', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\0', '8', '\uFFFF', '\uFFFF'}, 1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0661()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+17", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("9E+17"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointRight(-1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0667()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("9E+17")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("9E+17", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("9E+17")).negate();
    Assert.assertEquals("-9E+17", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0675()
  {
    rc_int = (new BigDecimal("10")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0676()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0677()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\234', '\1', '\1', '8', '\0', '\0', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\234', '\0', '8', '\1', '\uFFFF', '8', '\234', '\0', '\1', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '8', '\uFFFF', '8', '\0', '\234', '\234', '\1', '\0', '\234', '\234', '\0', '\234', '\234', '\234', '\1', '\234', '\1', '\1', '\234', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("10")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).max(new BigDecimal("1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0686()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0692()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.1")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0695()
  {
    rc_int = (new BigDecimal("2E+9")).scale();
    Assert.assertEquals(-9, rc_int);
  }
  public void testItem_0696()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_int = (new BigDecimal("2E+9")).compareTo(new BigDecimal("2E+9"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).subtract(new BigDecimal("0.1"));
    Assert.assertEquals("1999999999.9", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigInteger = (new BigDecimal("2E+9")).toBigIntegerExact();
    Assert.assertEquals("2000000000", rc_BigInteger.toString());
  }
  public void testItem_0701()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_int = (new BigDecimal("0.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0703()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\234', '\234', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\0', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\uFFFF', '\1', '8', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\234', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\0', '8', '\0', '\0', '8', '\0'}, 1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0706()
  {
    rc_boolean = (new BigDecimal("32")).equals("512DSD87:W?QV:RN2V7TXONABP9@7GVG=9TCNJL;7Y;??DC5?LPKH;E?83QCE9U=S678Y084QA8E1H@O<5;BBMF>MC7;BFAOKF?B");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0707()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2E+9")).hashCode();
//    Assert.assertEquals(53, rc_int);
//  }
  public void testItem_0708()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0710()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("1999999999.9")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0713()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("32"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("0.1")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0721()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
//  public void testItem_0725()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0726()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\234', '\1', '\0', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\uFFFF', '\0', '\234', '\0', '8', '8', '\234', '\1', '\234', '\234', '8', '\uFFFF', '8', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\234', '\0', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '8', '\0', '8', '\1', '8', '\1', '\1', '8', '\0'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0730()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
//  public void testItem_0731()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0732()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("Y96WY:8CAE@T<E8K3E6DVEVX7HY=13BG<00;9LDCD7?9@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0734()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0738()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0739()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '8', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\234', '8', '8', '\234'}, 2147483647, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("3.2E-2147483645"));
    Assert.assertEquals("3.125E+2147483643", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.125E+2147483643"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\uFFFF', '8', '\0', '\0', '\0', '\234', '\1', '\1', '\0', '\1', '8', '8', '\1', '8', '\1', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\0', '\234', '\0', '\234', '\0', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\234', '\0', '\1', '8', '8', '\uFFFF', '\1', '\0', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '8', '8', '\1', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '8', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0745()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("3E-2147483644"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483644")).movePointLeft(1);
    Assert.assertEquals("3E-2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0748()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483645")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '8', '8', '\234', '\0', '8', '\1', '\1', '\234', '\234', '8', '8', '\0', '\0', '\234', '\234', '\0', '8', '\1', '\1', '\234', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '\1', '\0', '\uFFFF', '\0', '8', '\0', '\234', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\uFFFF', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\234', '8', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '8'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0750()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483645")).ulp();
    Assert.assertEquals("1E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_double = (new BigDecimal("3E-2147483645")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0754()
  {
    rc_String = (new BigDecimal("3E-2147483644")).toString();
    Assert.assertEquals("3E-2147483644", rc_String);
  }
  public void testItem_0755()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0756()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
//  public void testItem_0760()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3E-2147483645")).longValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0761()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\1', '\1', '\234', '\234', '\0', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '\234', '\1', '\0', '\1', '\234', '8', '8', '8', '\1', '\0', '\1', '8', '\0', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\234', '8', '8', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\uFFFF', '\1', '8', '\0', '\0', '8', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0764()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3E-2147483645")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2E+308"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
//  public void testItem_0770()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3E-2147483645"), 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0771()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0772()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0773()
  {
    rc_int = (new BigDecimal("3E-2147483645")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0775()
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
//  public void testItem_0776()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3E-2147483645"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0777()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0778()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0779()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0781()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0785()
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
//  public void testItem_0786()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//    }
//  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0788()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0791()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0792()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
//  public void testItem_0793()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("5E-324")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("26J@5D@", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0800()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("320.0E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\0', '\0', '\1', '8', '8', '\1', '\0', '\1', '\uFFFF', '\1', '8', '8', '\234', '8', '8', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\1', '\234', '\0', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\1', '\1', '\1', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '8', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\234', '\0', '\uFFFF', '\1', '8', '\234', '\1', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0804()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("320.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0807()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=0 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
//  public void testItem_0812()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0813()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0814()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
//  public void testItem_0816()
//  {
//    boolean caught;
//    rc_byte = (new BigDecimal("00.0E+2147483647")).byteValueExact();
//    Assert.assertEquals(0, rc_byte);
//  }
  public void testItem_0817()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("8"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"), 0);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("-32")).pow(1);
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_String = (new BigDecimal("8")).toString();
    Assert.assertEquals("8", rc_String);
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1024")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1.00E+3", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0829()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0830()
  {
    rc_boolean = (new BigDecimal("8")).equals("2MBVD?J4WJRWXSQ10U8O749KAUR4TXVG0XJ4W=P@KN0LFWGYWCPLQD@@@D?IQ");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0831()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("8")).movePointRight(-1);
    Assert.assertEquals("0.8", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("0.8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\234', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0.8"));
    Assert.assertEquals("-0.8", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).subtract(new BigDecimal("-0.8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1024"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0842()
  {
    rc_boolean = (new BigDecimal("-1")).equals("EK9IOHLE@MY7JFYIXX6032XAC<JL7XOM0G050OVO@D@RHVK5TDFTP=@Y3LG2LBGYLI=7GG<?4:REDIX=9X1:37IPDX972HAV<CUN");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("-0.8")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.8", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("8")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-0.8")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@JFAGYUK3;;WNAU3K5VENAUD;AL8445RY==O8NASCPM?X43L@LPVW@P41KQPB?LCG=?E0QDY<YXBS:BKI2RPPMG51A<A3:MDB?EM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0849()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0850()
  {
    rc_float = (new BigDecimal("8")).floatValue();
    Assert.assertEquals(8.0F, rc_float, 0);
  }
  public void testItem_0851()
  {
    rc_double = (new BigDecimal("8")).doubleValue();
    Assert.assertEquals(8.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0852()
  {
    rc_boolean = (new BigDecimal("-0.8")).equals(";YPB=GKRWI44P@K=D9PFLBDPNL4?0@F4>?E2ON:446QUK3NQI23W0;D81VFN>TBTER=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0853()
  {
    rc_BigInteger = (new BigDecimal("-0.8")).unscaledValue();
    Assert.assertEquals("-8", rc_BigInteger.toString());
  }
  public void testItem_0854()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0855()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0856()
  {
    rc_int = (new BigDecimal("8")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0857()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0859()
  {
    rc_boolean = (new BigDecimal("0")).equals("74PL7QB5BCX=2UR:WFBWM;BS@>MG<:=Y1U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("-0.8")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-0.8", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '8', '\uFFFF', '8', '\0', '\1', '8', '\1', '\uFFFF', '\1', '8', '\0', '\0', '\234', '8', '\234', '\234', '\0', '\0', '8', '\uFFFF', '\0', '8', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\234', '8', '\0', '\1', '\1'}, 1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("-0.8")).add(new BigDecimal("0"));
    Assert.assertEquals("-0.8", rc_BigDecimal.toString());
  }
  public void testItem_0863()
  {
    rc_short = (new BigDecimal("8")).shortValueExact();
    Assert.assertEquals(8, rc_short);
  }
  public void testItem_0864()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0865()
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
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("-0.8")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1.8", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("-1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("-1.8")).max(new BigDecimal("-0.8"));
    Assert.assertEquals("-0.8", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-0.8")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0878()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0886()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0887()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '\234', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '8', '\1', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\1', '\0', '\1', '\0', '8', '\1', '\1', '\1', '8', '\1', '8', '\234', '8', '\234', '\1', '\234', '\1', '8', '\0', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '8', '\234', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '8', '\1', '8', '\1', '\uFFFF', '\234', '\0', '\1', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("-0.8")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1.8", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '8', '8', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '8', '8', '\1', '8', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '8', '8', '8', '\1', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\234', '8', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\234', '\0', '\234', '\0', '\0', '\234', '8', '8', '8', '\0', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\234', '8', '8', '\0', '8', '\234', '\uFFFF', '\0', '\0', '8', '\234', '8', '\0', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("-1.8")).negate();
    Assert.assertEquals("1.8", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("1.8")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("-1.8")).multiply(new BigDecimal("1"));
    Assert.assertEquals("-1.8", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("1.8")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_String = (new BigDecimal("1.8")).toPlainString();
    Assert.assertEquals("1.8", rc_String);
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("1.8")).add(new BigDecimal("-1.8"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1.8")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0900()
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
  public void testItem_0901()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    rc_int = (new BigDecimal("0.1")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0910()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483647")).divide(new BigDecimal("0E-2147483647"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("3E-2147483647"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0917()
  {
    rc_boolean = (new BigDecimal("32")).equals(">73>6J1F9FGA:OIG79P1==YGRJHH;JYL<CSI3Q4Q0IGGDCYPPYLA=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\1', '8', '8', '\0', '\1', '\0', '8', '\0', '\1', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '8', '8', '\0', '\234', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\0', '8', '\0', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '\0', '8', '8', '\1', '8', '\234', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\0', '8', '8', '\1', '\0', '\1', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\234', '8', '8', '\234', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\234', '8', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
//  public void testItem_0921()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0922()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).subtract(new BigDecimal("00.0E+2147483647"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0923()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0924()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0925()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\0', '\uFFFF', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\0', '\1', '\1', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '\0', '8', '8', '\1', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '8', '8', '\234', '\0', '8', '\234', '8', '\234', '8', '\uFFFF', '\1', '\234', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0932()
  {
    rc_double = (new BigDecimal("00.0E+2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0933()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0936()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0943()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0944()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0945()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0946()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '8', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '8', '\234', '\1', '8', '\234', '\0', '\234', '\uFFFF', '\234', '8', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\1', '\234', '\234', '\1', '\1', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\1', '\0', '\0', '\1', '\234', '\234', '\234', '\0', '\234', '\1', '\0', '\234', '\1', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '8', '\234', '8', '\1', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF'}, -2147483648, -2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0949()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0950()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0954()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(-1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775806", rc_BigDecimal.toString());
  }
//  public void testItem_0960()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775806")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.61073825503355%", true, caught);
//  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775806")).divide(new BigDecimal("1E+1"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-922337203685477580.6", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("9223372036854775807"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0966()
  {
    rc_boolean = (new BigDecimal("1E+1")).equals("IK9H7>FRD2CO8CR2<RHEKDIYBF90;00:Q8OTB?735MN46<;P>9SB?0YFPVX5L7D<PG<RX@AVOA@A1M8B");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775806")).movePointRight(0);
    Assert.assertEquals("-9223372036854775806", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_int = (new BigDecimal("9223372036854775807")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775806")).add(new BigDecimal("-9223372036854775806"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-18446744073709551612", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0971()
  {
    rc_BigInteger = (new BigDecimal("-18446744073709551612")).toBigInteger();
    Assert.assertEquals("-18446744073709551612", rc_BigInteger.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("Q:JNHKC86BGDL1IVKTDY<@D@Y57@>D@LBV:GK9G>6RVM05AN;K?N;VM8PURE8DU:GDC1A0CDV?K4@>BPW0RVQ>A<48W3;DC@D6CC");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '8', '\1', '8', '8', '\1', '8', '\0', '\234', '\234', '\234', '\1', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '8', '\0', '8', '\234', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '8', '\234', '\1', '8', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\0', '\uFFFF', '\1', '\234', '\1', '\1', '8', '\0', '\1', '\1', '8', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("3.2E+2"));
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("1.135879015891E+13", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_int = (new BigDecimal("1.135879015891E+13")).compareTo(new BigDecimal("1.135879015891E+13"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.61073825503355%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("320.0")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("320.0", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_float = (new BigDecimal("320.0")).floatValue();
    Assert.assertEquals(320.0F, rc_float, 0);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(1);
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).max(new BigDecimal("1"));
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_int = (new BigDecimal("11358790158910")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_int = (new BigDecimal("1E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0993()
  {
    rc_float = (new BigDecimal("1E+1")).floatValue();
    Assert.assertEquals(10.0F, rc_float, 0);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).subtract(new BigDecimal("1"));
    Assert.assertEquals("11358790158909", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_long = (new BigDecimal("11358790158910")).longValueExact();
    Assert.assertEquals(11358790158910L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0997()
  {
    rc_boolean = (new BigDecimal("11358790158910")).equals("L982IL34QFY1?UE=BX;::7Y;V5OW?8<K:BBY2GECATO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0998()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("11358790158910"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
}
