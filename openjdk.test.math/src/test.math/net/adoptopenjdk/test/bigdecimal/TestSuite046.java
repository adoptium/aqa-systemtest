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
public class TestSuite046 extends TestCase
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
  
  public TestSuite046() {
  
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_String = (new BigDecimal("3300")).toEngineeringString();
    Assert.assertEquals("3300", rc_String);
  }
  public void testItem_0003()
  {
    rc_long = (new BigDecimal("3E+2")).longValueExact();
    Assert.assertEquals(300L, rc_long);
  }
  public void testItem_0004()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0005()
  {
    rc_short = (new BigDecimal("3E+2")).shortValueExact();
    Assert.assertEquals(300, rc_short);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("642"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1.926E+4", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).remainder(new BigDecimal("3E+2"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\234', '\0', '\uFFFF', '\234', '\234', '\1', '\234', '\0', '\234', '\234', '\0', '8', '\0', '\0', '\1', '\0', '\1', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\234', '\234', '\234', '\234', '\0', '\0', '8', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '\0', '\0', '\234', '\1', '\234', '\234', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).min(new BigDecimal("3E+2"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).stripTrailingZeros();
	Assert.assertEquals(0E+2, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\uFFFF', '8', '\0', '\0', '8', '\uFFFF', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\0', '\1', '\0', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '8', '\234', '8', '\234', '\234', '8', '8', '\234', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '8'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0014()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).negate();
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("3300")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("3300", rc_BigDecimal.toString());
  }
//  public void testItem_0016()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3300")).remainder(new BigDecimal("642"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0017()
  {
    rc_int = (new BigDecimal("0E+2")).compareTo(new BigDecimal("642"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0019()
  {
    rc_boolean = (new BigDecimal("642")).equals("3I3TDD@C16TP:0T12<>5C:JRAJ;E:MDS58IY");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_double = (new BigDecimal("3300")).doubleValue();
    Assert.assertEquals(3300.0, rc_double, 0);
  }
  public void testItem_0022()
  {
    rc_BigDecimal = (new BigDecimal("3300")).negate();
    Assert.assertEquals("-3300", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("642"), 1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '\0', '\234', '\0', '\1', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\234', '\0', '8', '8', '8', '\0', '\1', '8', '\0', '\0', '\234', '\234', '8', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '8', '8', '\1', '8', '\1'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("642"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("6E+2")).max(new BigDecimal("1"));
    Assert.assertEquals("6E+2", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0;K8;MF9W7WCPYJYL=GJ1Y1KLFJ=P?40HWEHGLFFA@E0J52<@M1GDNH3SNDNRDB85:>0", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("6E+2")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("6.0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("6.0E+2")).scaleByPowerOfTen(-1);
    Assert.assertEquals("60", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    rc_byte = (new BigDecimal("0.0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0035()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("6.0E+2")).divide(new BigDecimal("60"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0036()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0038()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '8', '\234', '\1', '\1', '\0', '\0', '\234', '\1', '8', '8', '\0', '\0', '\1', '\234', '\234', '\234', '8', '\uFFFF', '\1', '8', '\234', '8', '8', '\uFFFF', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '8', '\234', '8', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\1', '8', '\1', '\0', '\0', '\1'}, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0039()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_int = (new BigDecimal("6.0E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("60")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0045()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0046()
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
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0049()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0050()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6.0E+2")).hashCode();
//    Assert.assertEquals(1859, rc_int);
//  }
  public void testItem_0051()
  {
    rc_BigInteger = (new BigDecimal("6.0E+2")).toBigInteger();
    Assert.assertEquals("600", rc_BigInteger.toString());
  }
  public void testItem_0052()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0055()
  {
    rc_double = (new BigDecimal("0.0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("6.0E+2"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("601", rc_BigDecimal.toString());
  }
//  public void testItem_0057()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.0")).hashCode();
//    Assert.assertEquals(1, rc_int);
//  }
  public void testItem_0058()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0059()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0060()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=FLOOR"));
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_String = (new BigDecimal("-33")).toPlainString();
    Assert.assertEquals("-33", rc_String);
  }
  public void testItem_0064()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0065()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-33")).divide(new BigDecimal("-33"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0066()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0068()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0069()
  {
    rc_int = (new BigDecimal("0.0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0071()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0072()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '8', '8', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\0', '\0', '8', '8', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '8', '8', '\0', '8', '\0', '\uFFFF', '\234', '\0', '8', '\1', '\234', '8', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\234', '8', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\1', '\1', '\234', '8', '\0', '8', '8', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '8'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).min(new BigDecimal("-1E+1"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0079()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '8', '\234', '\1', '\1', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\0', '\1', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0087()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0088()
  {
    rc_boolean = (new BigDecimal("320.0E+2147483647")).equals(";?QE>NWBBV1FJ3VVD3DG<LPBH7W1MFH?4UQRX<YCX7QGT8@V=HGNE?35DP0T815T0URU5QYY41TLKW4DT3KOK7X<8Q;SIA4SEKPX");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0089()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("320.0E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0090()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
//  public void testItem_0091()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0092()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).pow(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0093()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("320.0E+2147483647"));
//    Assert.assertEquals("32", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\1', '\234', '8', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\234', '8', '8', '8', '\234', '8', '\234', '\1', '\1', '\1', '\234', '8', '\1', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\234', '\1', '\234', '\1', '\234', '\234', '\1', '8', '\1', '\1', '8', '8', '\0', '\uFFFF', '\234', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0099()
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
  public void testItem_0100()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_float = (new BigDecimal("2E+9")).floatValue();
    Assert.assertEquals(2.0E9F, rc_float, 0);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0103()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0104()
  {
    rc_double = (new BigDecimal("2E+9")).doubleValue();
    Assert.assertEquals(2.0E9, rc_double, 0);
  }
//  public void testItem_0105()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0106()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("0"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0107()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0108()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointLeft(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">S=NJ5YYWF@X541:69DG6K=>48QQQKY=77L9P<CCW<9A5WW0LKQ=0DY0EWFLXFKIIJVU>OE4<L0U7=LY@O:G5L;6IQ5B1YRH<>0@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2E+9"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("8"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("8")).remainder(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0122()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+9")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0123()
  {
    rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("2E+308"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@4?BNXI");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).multiply(new BigDecimal("8"));
    Assert.assertEquals("1.6E+10", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_short = (new BigDecimal("8")).shortValueExact();
    Assert.assertEquals(8, rc_short);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).plus(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_float = (new BigDecimal("2E+9")).floatValue();
    Assert.assertEquals(2.0E9F, rc_float, 0);
  }
  public void testItem_0129()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("2E+9"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_int = (new BigDecimal("1.6E+10")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0132()
  {
    rc_double = (new BigDecimal("1.6E+10")).doubleValue();
    Assert.assertEquals(1.6E10, rc_double, 0);
  }
  public void testItem_0133()
  {
    rc_int = (new BigDecimal("8")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0134()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";W8TFGRR=XMLQOYM:>=");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divideToIntegralValue(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0136()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("1.6E+10")).divide(new BigDecimal("2E+308"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2E+308")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0142()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("0E+308")).longValueExact();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, java.math.RoundingMode.UP);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0148()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\0', '\234', '\1', '8', '8', '8', '\0', '\0', '\1', '\uFFFF', '8', '8', '8', '\1', '\0', '\0', '\0', '\234', '\234', '\1', '\1', '\234', '\0', '8', '8', '\1', '\1', '\0', '\0', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\1', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '8', '\uFFFF', '8', '\1'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1.6E+10"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1.6E+10"));
    Assert.assertEquals("16000000000", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\0', '\234', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '\234', '\0', '\0', '\0', '\234', '\0', '\0', '8', '\uFFFF', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\234', '\234', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1', '\234', '8', '\uFFFF', '\1', '8', '\0', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\0', '\234', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\0', '8', '\1', '\uFFFF', '\1', '8', '\1', '\0'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("QM4B80VFL35G>J7C8Y14VSVK>=2<VA4@V01M3J1BBSV3NNC>?P8664>F:IW8IAG7FPG<@V@CDK0RO:F;YIUELN64XI0HXU@6FIL@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("0E+308")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0156()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0E+308"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+308"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0158()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0E+308"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0162()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0166()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("0E+308")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("@1Q7R=:8J5BSOGWFT18MLLWF8N6435BIJ8IO?GR3BR>K9VPUA08KGQ84:3DBRW7A=YTMLA=@DVP9SC@U0=JN47LKG=3HCXV2BA4?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0175()
  {
    rc_BigInteger = (new BigDecimal("00.0E+2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("32"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0181()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).scaleByPowerOfTen(0);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0182()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\1', '\234', '\0', '\0', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '8', '\1', '8', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\0', '\0', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\1', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '8', '\0', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '8', '8', '\234', '8', '\1', '\234', '\0', '\0', '\1', '\0'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0191()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0192()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("32"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_int = (new BigDecimal("3E+1")).intValue();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0204()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\1', '8', '\0', '\1', '8', '8', '\1', '\uFFFF', '\234', '\0', '\1', '\0', '\0', '8', '8', '8', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0210()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0212()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0213()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0214()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '8', '\0', '\234', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\234', '\0', '8', '\0', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\234', '\1', '\234', '\1', '\0', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '\1', '8', '8', '\1', '\uFFFF', '\234', '\0', '\0', '\1'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0223()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '8', '8', '8', '\1', '\0', '\1', '\0', '\0', '\234', '\234', '\0', '\0', '\uFFFF', '8', '\1', '\0', '\234', '\1', '\0', '\234', '\0', '\0', '\1', '\234', '\0', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\234', '\234', '8', '\234', '\1', '\234', '\0', '\0', '8', '\1', '\234', '8', '\234', '8', '\uFFFF', '\0', '\1', '\1', '\234', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\234', '\234', '8', '8', '8', '\0', '\0', '\0', '8', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\234', '\0', '\uFFFF', '\1', '\0', '8', '\234', '\uFFFF', '\234', '\234', '\234'}, 0, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("-32")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0227()
  {
    rc_boolean = (new BigDecimal("1")).equals("H>L<PIK>JCX<H0AR3DD:1:TVY3S2QL89;PE:6<<<J<ST=042L;3@5HKNIR7VP5B97S403SJ=2V;YYVU547YBNJE1J7XW1?09QR20");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0228()
  {
    rc_short = (new BigDecimal("-32")).shortValueExact();
    Assert.assertEquals(-32, rc_short);
  }
  public void testItem_0229()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0230()
  {
    rc_int = (new BigDecimal("-3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0231()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\1', '\1', '\0', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\234', '\1', '\0'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).stripTrailingZeros();
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_String = (new BigDecimal("3.2E+2")).toString();
    Assert.assertEquals("3.2E+2", rc_String);
  }
  public void testItem_0235()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=FLOOR"));
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("AY81THBC2WB5B45EEA3;>5SL;839XJT4LXU2J7>I3D5:J4B=12:X8AB>@NGWYD1O>VXQEJJALYICU?N;9VN7G:0MORHFEWBU3ME<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '8', '8', '8', '8', '\234', '\0', '\1', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\0', '\234', '8', '\uFFFF', '8', '8', '8', '\0', '8', '\234', '\uFFFF', '8', '\0', '\1', '8', '\uFFFF', '\234', '8', '8', '\0', '\1', '\1', '\234', '8', '\234', '\0', '\uFFFF', '8', '\1', '8', '\0', '\0', '\0', '8', '8', '8', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0239()
  {
    rc_short = (new BigDecimal("3.2E+2")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("-32"), 0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, java.math.RoundingMode.UP);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_float = (new BigDecimal("-32")).floatValue();
    Assert.assertEquals(-32.0F, rc_float, 0);
  }
  public void testItem_0243()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0247()
  {
    rc_boolean = (new BigDecimal("32")).equals("<QX;Y<M>BEOXNF;FDN2GAHT@WH6NOG0@6G=?>A2L4NI5Y8FO;HEE?QLB7;U>AGJO4ICM77RT4TSU0SF@4F>P:G:FGWQIPC@5R=55");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0250()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0251()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0252()
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
  public void testItem_0253()
  {
    rc_int = (new BigDecimal("-32")).intValueExact();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0254()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0257()
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
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = (new BigDecimal("-32")).negate(new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("-32")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0269()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0270()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(-1);
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
//  public void testItem_0275()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-10")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0276()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0278()
  {
    rc_double = (new BigDecimal("-10")).doubleValue();
    Assert.assertEquals(-10.0, rc_double, 0);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0280()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0282()
  {
    rc_BigDecimal_array = (new BigDecimal("-10")).divideAndRemainder(new BigDecimal("9E+18"));
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("-10")).divideToIntegralValue(new BigDecimal("9E+18"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E-18", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("0E-18")).movePointLeft(1);
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0E-19"));
    Assert.assertEquals("32.0000000000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0287()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32.0000000000000000000")).setScale(2147483647, 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_String = (new BigDecimal("0E-18")).toEngineeringString();
    Assert.assertEquals("0E-18", rc_String);
  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0294()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointRight(-2147483648);
//    Assert.assertEquals("32", rc_BigDecimal.toString());
//  }
//  public void testItem_0295()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0296()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0298()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("320.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("32", rc_BigInteger.toString());
//  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0300()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '8', '\1', '\234', '8', '\uFFFF', '\1', '8', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234'}, 1, 0, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0303()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0304()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0305()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("32"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0306()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0309()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0310()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0311()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).toBigIntegerExact();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0312()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0313()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+18")).divideAndRemainder(new BigDecimal("0E+18"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '8', '8', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '8', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '8', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\0'}, 1, 1, new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">J9WAMK4QIBDQFA>X=15M19:S@40:GTBNE4IM?2YHR636UPC52IDHIWEQ:N65W;1E08FHP;N<SVPDX69XJ6HUK886ET9L;M3XMW9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0319()
  {
    rc_boolean = (new BigDecimal("8")).equals("WG3BKE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-1);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0322()
  {
    rc_boolean = (new BigDecimal("0")).equals("@>RY8;67YY;LP55:IHS;C7<OO35Y:SXI=O=9G58Y8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0323()
  {
    rc_String = (new BigDecimal("9E+18")).toEngineeringString();
    Assert.assertEquals("9E+18", rc_String);
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0E+18")).pow(0, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_int = (new BigDecimal("9E+18")).scale();
    Assert.assertEquals(-18, rc_int);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0333()
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
  public void testItem_0334()
  {
    rc_int = (new BigDecimal("9E+18")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9E+18"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0336()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("9E+18"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0339()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1074", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<RP@2HSN0N7RG6DBKS::KY", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1074", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).movePointRight(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0347()
  {
    rc_BigInteger = (new BigDecimal("0E+1074")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0348()
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
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_int = (new BigDecimal("-2147483648")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).plus(new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).pow(-1, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-5E-10", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\234'}, new MathContext("precision=0 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0361()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("0E+1074")).divide(new BigDecimal("1024"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigInteger = (new BigDecimal("0E+1074")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0364()
  {
    rc_int = (new BigDecimal("0E+1074")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1024"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0E+1074"), 1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_int = (new BigDecimal("1024")).precision();
    Assert.assertEquals(4, rc_int);
  }
  public void testItem_0368()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.0"), 1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("3E+4")).stripTrailingZeros();
    Assert.assertEquals("3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0371()
  {
    rc_long = (new BigDecimal("1024")).longValue();
    Assert.assertEquals(1024L, rc_long);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("3E+4")).ulp();
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0374()
  {
    rc_boolean = (new BigDecimal("32")).equals("BD2F4;XD:W8@SKN021;409CMM?R6J4MPJ52VYUL;B<S@SDA791=C><<U05J0E@S0C<M03TLWTQJBSYBK0EP8N5X5XWD=8BF7XW1M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("32"), java.math.RoundingMode.UP);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8BS?:M1QWUHYVM7Y?9US1?8SWSAJ>>NY4YYRK7K9O9V6T", new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0378()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0379()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1024")).subtract(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0382()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0384()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0385()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0386()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("73=F6A=3D>8L1B99CY@11701S894ACY<4>OTJ62>6@I6FTT0<TSHF5FG0JWB>6E1K4>CY2S5BEQ9>E<A02BV5IVPF>TUAIV18TWM");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0387()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_int = (new BigDecimal("-2147483648")).compareTo(new BigDecimal("1E+3"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0389()
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
  public void testItem_0390()
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
  public void testItem_0391()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0392()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+3")).divide(new BigDecimal("32"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0393()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0394()
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
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("-2147483648"));
    Assert.assertEquals("-4294967296", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+3")).divideAndRemainder(new BigDecimal("1E+3"));
  }
  public void testItem_0397()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0398()
  {
    rc_boolean = (new BigDecimal("32")).equals("4B71=4M@BE9W2>J6PD<OBYMK:OF<B0YG@O<HS9>Q4TK@V0X6:A8SB<KOL4@58NQ4HUGV@2OM4W59H78AVRHE9H?YXT5V7X6X66D0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0399()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("-4294967296")).divide(new BigDecimal("1E+3"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("-4294967", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_long = (new BigDecimal("-2147483648")).longValue();
    Assert.assertEquals(-2147483648L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0402()
  {
    rc_boolean = (new BigDecimal("-4294967")).equals("CS9G3PLF<3:?53>0@UBQEVPH6XH=N<O7IBHOOGR<5AE4JM7?W02RGSRVT2=9XDHH@TO;I@A:AC:T7HV:IX02ILA@7HT0<<K<DGH7");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4294967")).divide(new BigDecimal("-4294967"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).negate();
    Assert.assertEquals("-1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigInteger = (new BigDecimal("1E+3")).toBigIntegerExact();
    Assert.assertEquals("1000", rc_BigInteger.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).plus();
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("-1E+3")).divide(new BigDecimal("2147483648"), 1);
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_short = (new BigDecimal("0E+3")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).multiply(new BigDecimal("1E+3"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+6", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_double = (new BigDecimal("0E+6")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-1E+3")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0E+6")).abs();
    Assert.assertEquals("0E+6", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0415()
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
  public void testItem_0416()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_int = (new BigDecimal("0E+6")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0418()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("P6U5:VX0H32I:NQTQ;1JGHKG7TFJPQ5@<GUY:GAUK:SL3L63H<K2LCCE?82=KP6GD0MU7QO9X1G:2L<ECV6HS75CG:@QXGTHPLGA");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_int = (new BigDecimal("-4294967")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0428()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3.2E-2147483646"), -2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0435()
  {
    rc_double = (new BigDecimal("3.2E-2147483646")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0436()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0437()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0438()
  {
    rc_boolean = (new BigDecimal("5E-324")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0439()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("5E-324")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0446()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0448()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2")).hashCode();
//    Assert.assertEquals(993, rc_int);
//  }
  public void testItem_0449()
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
  public void testItem_0450()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '\1', '\1', '\0', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\234', '\1', '8', '\1', '\1', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '8', '8', '\0', '\0', '8', '\1'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0454()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
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
  public void testItem_0459()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("D?EM>SR2@FDHQHX==D6JCVW<<HMRFBBWM7@0K6PD9=X?6PEFF16KOFNQORK2BA0O1CY0G7F8=R2<ANK3AC4TS:AS<:IG9UREBPY<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0460()
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
  public void testItem_0461()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("3.2")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0462()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0463()
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
  public void testItem_0464()
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
  public void testItem_0465()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0466()
  {
    rc_boolean = (new BigDecimal("0")).equals("H6M=:6NYI7>O3=H=:FD88:E0Q9M0G7>LJJC6XXK247KRVT0T8QNR04:E4V>5M<@O6=DQKPI57DVET>7DMGYL>GMQFR4J5YX?13J:");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0467()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0469()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).stripTrailingZeros();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '8', '\234', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\1', '8', '\uFFFF', '\1', '\1', '\0', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\1', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\234', '\uFFFF', '8', '8', '\0', '\0', '\0', '\234', '\1', '\1', '\234', '8', '\0', '8', '\234', '\0', '\0', '\0', '\1', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\1'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
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
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\1', '8', '\0', '8', '\1', '8', '8', '\1', '\234', '\234', '\234', '\234', '\0', '\1', '\234', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '8', '\1', '8', '\234', '\1', '\1', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\0', '\234', '\1', '8', '\234', '8', '8', '\1', '\0', '\0', '\1', '\0', '\uFFFF', '8', '8', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\234', '8', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("3.2E+2"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0487()
  {
    rc_String = (new BigDecimal("3.2E+2")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0488()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 0, 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0491()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("8"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("3")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0497()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).setScale(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\1', '8', '\0', '8', '\0', '\234', '\0', '\234', '8', '\234', '8', '\0', '\0', '\uFFFF', '\234', '8', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '8', '8', '8', '\1', '\234', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '8', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '\1', '8', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\1', '\uFFFF'}, -1, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("8"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0502()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0503()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0504()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("8R1XGGTRD:GD@H35E6@7X=TMR6J1U4O?8D?8?AE?JY944DG?0=@=7;HX6BWI;C?0KD=W@BEA<5?0ON=1;Y>MMW=3@L=X@7:C7P:P");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0505()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("3")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
//  public void testItem_0508()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0509()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("3")).abs();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = (new BigDecimal("3")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    rc_String = (new BigDecimal("3")).toEngineeringString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0514()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0515()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("3"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0523()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0524()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0525()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("3"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0526()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
//  public void testItem_0527()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3")).hashCode();
//    Assert.assertEquals(93, rc_int);
//  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_int = (new BigDecimal("320")).intValueExact();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0531()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0533()
  {
    rc_boolean = (new BigDecimal("-1")).equals("BOE<DETBH?SQ7SMB<G@EXP56F<C8N4G?BNTE4NW40:<=8IE@9UB@KAFMJ4OTUH76HD9CC7J;ES:S>T39XQFJA<KQ=BOV>5SO4AVQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0534()
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
  public void testItem_0535()
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
//  public void testItem_0536()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3")).hashCode();
//    Assert.assertEquals(93, rc_int);
//  }
  public void testItem_0537()
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
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0540()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_double = (new BigDecimal("3")).doubleValue();
    Assert.assertEquals(3.0, rc_double, 0);
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("3")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("3"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0546()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0547()
  {
    rc_long = (new BigDecimal("3")).longValueExact();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("3E+2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("3E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '8', '\0', '\0', '8', '\0', '\1', '\234', '\234', '\234', '\0', '\1', '8', '8', '8', '8', '\1', '8', '8', '\1', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\1', '8', '\1', '\234', '8', '8', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\1', '8', '\234', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\1', '\1', '\0', '\234', '8', '\0', '\1', '\0', '8', '\0', '8', '\234', '\1', '\1', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\234'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0551()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("3E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '\0', '\0', '\234', '\0', '\234', '\234', '\1', '8', '8', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '8', '\234', '\1', '\0', '\0', '8', '8', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\0', '8', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\0', '8', '\1', '\uFFFF', '\0', '8', '\0', '\0', '8', '8', '\uFFFF', '\0', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\234', '\234', '8', '\234', '\0', '8', '\0', '\234'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0556()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0558()
  {
    rc_boolean = (new BigDecimal("3E+2147483647")).equals("CV13RO@=F>7ELMXI9OU0=LW>3426L:");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0559()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3E+2147483647")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0560()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0561()
  {
    rc_boolean = (new BigDecimal("3E+2147483647")).equals("O028NJGK8A>3SWUGDV<XAM@?P2=U?OEY>3C<X0KHHOPJT69HV:B3H");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0562()
  {
    rc_int = (new BigDecimal("3E+2147483647")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("3E+2147483647")).round(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_String = (new BigDecimal("3E+2147483647")).toString();
    Assert.assertEquals("3E+2147483647", rc_String);
  }
//  public void testItem_0565()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("3E+2147483647"), 2147483647, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2IOE?>@Q5ERP@S65ACCBSF?23XB@MDM7KV>7@92<42:=3N>M80R?XCPKST0177<K9HRV;OKPDGL:YGR0@>JGWJ9?W:MYYNNJNHB:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("3E+2147483647")).movePointLeft(2147483647);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).divide(new BigDecimal("1E-2147483647"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("3")).plus();
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\1', '8', '\234', '\1', '\0', '\1', '8', '\1', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\234', '8', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\0', '8', '8', '\234', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8'}, 2147483647, -1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0572()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("1E-2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0573()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).divideToIntegralValue(new BigDecimal("3"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1, 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
//  public void testItem_0576()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("3E+2147483647")).divideToIntegralValue(new BigDecimal("32.0"), new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).movePointRight(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483554, rc_int);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0579()
  {
    rc_boolean = (new BigDecimal("3E+2147483647")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("3")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("3E+2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    rc_long = (new BigDecimal("3")).longValue();
    Assert.assertEquals(3L, rc_long);
  }
//  public void testItem_0583()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32.0")).divideAndRemainder(new BigDecimal("3E+2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).setScale(1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0585()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483554, rc_int);
//  }
  public void testItem_0586()
  {
    rc_int = (new BigDecimal("-3E+2147483647")).scale();
    Assert.assertEquals(-2147483647, rc_int);
  }
  public void testItem_0587()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483647")).scaleByPowerOfTen(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2147483647")).movePointRight(1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("32.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-29.0", rc_BigDecimal.toString());
  }
//  public void testItem_0590()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("3E+2147483647")).divideToIntegralValue(new BigDecimal("-29.0"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("-3E+2147483647")).divide(new BigDecimal("-3E+2147483647"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-29.0"));
    Assert.assertEquals("-29.0", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '8', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\0', '\0', '8', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '8', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\234', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '\1', '\234', '8', '\234', '\uFFFF'});
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
      rc_BigDecimal = new BigDecimal("R6Q4YW9YEU15=88", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0595()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+2147483647")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("-29.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), 1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).remainder(new BigDecimal("-29.0"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0599()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0600()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+2147483647")).divide(new BigDecimal("0.1"), 0, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(-1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0604()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0605()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0606()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_int = (new BigDecimal("1E+1")).intValueExact();
    Assert.assertEquals(10, rc_int);
  }
//  public void testItem_0611()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), -1, 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0614()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).scaleByPowerOfTen(0);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0615()
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
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).setScale(2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0617()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0619()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_int = (new BigDecimal("1E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\234', '8', '\234', '\1', '\1', '8', '\0', '8', '\1', '\0', '8', '\234', '\0', '8', '8', '\234', '8', '8', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\234', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\0', '\234', '8', '\uFFFF', '\1', '\234', '8', '\1', '\uFFFF', '8', '\234', '8', '\1', '\0', '\1', '8', '\1', '\0', '\1', '\234', '\234', '8', '\234', '8', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\1', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0626()
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
  public void testItem_0627()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1E+1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_int = (new BigDecimal("1E+1")).compareTo(new BigDecimal("1E+1"));
    Assert.assertEquals(0, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0631()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("07;F345WLJRMWYP9@5WIQPO=J?K>LVO>??R4D8GCSE9DQN>O<VT=@;A2OPOB2Q<Y9LK;QMGHWRSVK=KKYK9:Y0QQ6KD7@HQH9EKH");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0632()
  {
    rc_int = (new BigDecimal("1E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0639()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0640()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0641()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("US@C<@91CJGLAFRRUGARK7104JCBGQN>LWUO2F8PXVWECXOHJMAEXYIAWYXO:0SKDQ1>964C43RX16TM8R6229W35YOQP1YCY>YV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0642()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).multiply(new BigDecimal("-3E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-6.442450941E+18", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-6.442450941E+18")).divide(new BigDecimal("0E+2"), 0, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DIWA3NSJFNA43W=NML9R?XDX4VYK@O6YM2L2YHET5OL6IOJPD@M");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).stripTrailingZeros();
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigInteger();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).min(new BigDecimal("2147483647"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2")).divide(new BigDecimal("0E+1"), 0, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '\234', '\1', '8', '8', '\0', '\0', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\0', '8', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\1', '\0', '\234', '8', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234'}, -1, -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0655()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_int = (new BigDecimal("0E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0658()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E=?FPJEKX:PT2YQS;;XT2SUC1>LY9=BJY42ERTK=5B", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0661()
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
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigInteger = (new BigDecimal("0E+2")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0664()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("G=1CHVVIOS5@V42N3U:8QYQ;@A@CJJP3;J3N470BVSKN8AY0H<9TOXK250:T;>90T?TTKA3<QH1VK6CCMLUY=SYIAR9");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '8', '\1', '\1', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\0', '8', '\234', '\234', '\0', '\0', '\0', '8', '\1', '\234', '\1', '\234', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '\0', '8', '\1', '\234', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\0', '\234', '8', '\234', '\234', '\234', '\234', '\0', '\1', '8', '8', '\234', '\uFFFF', '\0', '\234', '\1', '\234', '8', '\234', '\234', '\1', '8', '\234', '8', '\0', '\uFFFF', '\1', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0670()
  {
    rc_int = (new BigDecimal("0E+1")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0671()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0672()
  {
    rc_long = (new BigDecimal("0E+2")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).multiply(new BigDecimal("3E+2"));
    Assert.assertEquals("0E+4", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+4")).divide(new BigDecimal("0E+2"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).scaleByPowerOfTen(0);
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0E+2")).plus();
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("0E+4")).ulp();
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0682()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0683()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_double = (new BigDecimal("0E+4")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointRight(0);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_int = (new BigDecimal("3.2")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0693()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("0E+4"), 0, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_int = (new BigDecimal("3.2")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_String = (new BigDecimal("3")).toEngineeringString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("320.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0701()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("320.0E+2147483647"), 2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0702()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0703()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0704()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0705()
  {
    rc_boolean = (new BigDecimal("3E+1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0706()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=;Y2OUOIPPD41V8O3G247?9CA3YX1N");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0708()
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
  public void testItem_0709()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\1', '\234', '8', '8', '\234', '\1', '\uFFFF', '\0', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\234', '\0', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\234', '\0', '8', '\1', '\234', '8', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\0', '8', '8', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '8', '\0', '\0'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0722()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E-2147483647")).hashCode();
//    Assert.assertEquals(-2147483618, rc_int);
//  }
//  public void testItem_0723()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0724()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).subtract(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0726()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("1E-2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0727()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0730()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0731()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("9THNUE04X<TGLEQ;R1G7IYW39CBSP6WN9HKG8R>MG;42BTC:TTGDL7XC?J:I;RR=O1>5D:3R47IPIMR=", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0733()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("0E-2147483647"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0736()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0737()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2E-2147483646")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_int = (new BigDecimal("320")).compareTo(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0741()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0744()
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
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VFNV", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E-2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0748()
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
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0752()
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
  public void testItem_0753()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0755()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"), -2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0756()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";HI<T<WFOK@V3NEK4LG4YEACKN@43107MPRSDGY256UUSA4HCVRHCTBM=1PIY0HH8FEA:I8G<C0L25=Q?B<M<IJ?L=0I@NLVBSEF");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0762()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0763()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0764()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0765()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_String = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).toEngineeringString();
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_String);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(1);
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("3<?@E8@XDD2QTC9:H?B=<JDQ7BV=E58HM5D48FV?IBVPPR7=3B9NYWRW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0772()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_double = (new BigDecimal("11358790158910")).doubleValue();
    Assert.assertEquals(1.135879015891E13, rc_double, 0);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824")).abs();
    Assert.assertEquals("5617791046444736587953981991615761149939705235182656143716171150098664399375891836268423707273964942860639342297324452007322541465295755711514610834485547405814059705517227564882671565324666529502370890889222935697018226153225717130181517479128854633587432068879522599023068036903728121289075125818253901824", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=REOE;38PVORDUXN7@P;OXP0<731154J5BNFWF42G52H;<<7J");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0778()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).setScale(-1);
    Assert.assertEquals("1.135879015891E+13", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_String = (new BigDecimal("1.135879015891E+13")).toPlainString();
    Assert.assertEquals("11358790158910", rc_String);
  }
  public void testItem_0781()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("354962192465", rc_BigDecimal.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1.1358790158910E+2147483660", rc_BigDecimal.toString());
  }
//  public void testItem_0783()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("354962192465")).hashCode();
//    Assert.assertEquals(121832865, rc_int);
//  }
  public void testItem_0784()
  {
    rc_int = (new BigDecimal("11358790158910")).compareTo(new BigDecimal("354962192465"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).movePointLeft(0);  
    if (JavaSpecVersionChecker.isJDK13OrNewer()) {
    	 Assert.assertEquals("1.135879015891E+13", rc_BigDecimal.toString());
    } else {
    	 Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
    }
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("354962192465")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0787()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C;V3DR4Y;;>MT6PR;>JEWYJLRAKGV4KOQSQX;E;0?FYF8S1FJM<M:HRHPOJE=ET3K1Q5YV31UO=J@86TU4M49X716IV8?IDMS425");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).max(new BigDecimal("11358790158910"));
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("11358790158910")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0791()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("354962192465")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '\0', '8', '8', '\uFFFF', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_long = (new BigDecimal("1.135879015891E+13")).longValueExact();
    Assert.assertEquals(11358790158910L, rc_long);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).setScale(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("11358790158910.0", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("11358790158910.0")).divide(new BigDecimal("354962192465"), 1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("354962192465"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0799()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\1', '8', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\1', '\234', '\0', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\1', '8', '\0', '\uFFFF', '\1', '\0', '8', '\234', '8', '\1', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\0', '8', '\0', '8', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\1', '8', '\234', '\1', '\234', '\0', '8', '\234', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '8', '\0', '\0'}, 1, 2147483647);
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0800()
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
  public void testItem_0801()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("RXJ;33V0E0WA");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\234', '8', '\234', '8', '\0', '8', '8', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0804()
  {
    rc_BigDecimal = (new BigDecimal("354962192465")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("4E+11", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0807()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CIBNIE6N6102ER7I4KH>?HU40YQVW>PGJ2M8NHG<P6Q0YVJX4@2Q<CWC2FPDJS2LYLHK?131C=KUF91@VS19UCWE9RDYMT89N89M");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0808()
  {
    rc_double = (new BigDecimal("1.135879015891E+13")).doubleValue();
    Assert.assertEquals(1.135879015891E13, rc_double, 0);
  }
  public void testItem_0809()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("11358790158910.0"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0810()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("11358790158910.0")).setScale(2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).min(new BigDecimal("354962192465"));
    Assert.assertEquals("354962192465", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0813()
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
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).negate();
    Assert.assertEquals("-1.135879015891E+13", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_int = (new BigDecimal("1.135879015891E+13")).intValue();
    Assert.assertEquals(-1398339010, rc_int);
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("1.135879015891E+13")).divideToIntegralValue(new BigDecimal("-1.135879015891E+13"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("<8;=I:EAM<G1Q7DJT>B6=MGBPYT16");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0819()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("@J2>U7<85L32HU0VF;VTM5BKYT=SLVD0M;3I2:4RN3DISTR1Q;UL78F>==F>L@DN1Q:G<<8PU:?R076Q5YTLKB?=>QG0<PW=@@A4");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E<1MDEG9FTJ0T19L?8U;IX5O@CU<0TCGLU73:3MJXRSB?KTFXHS6@ATI?4H:GTL<?MH2ML=T60QJRF5KNFCL0FIBTEA=5SC?9OS8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2147483647"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
  public void testItem_0824()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0825()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0826()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0827()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0830()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("320.0E+2147483647"), -1, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0831()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1PDVHDT@TVTG2<JD7F7K3EL1R7O65;4QIL<9BIKR");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).plus();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
//  public void testItem_0834()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).scaleByPowerOfTen(1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0839()
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
  public void testItem_0840()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0841()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
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
    rc_BigDecimal = (new BigDecimal("0.1")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0PYMT5PNSSMT8TJ28<TB<>G@@DGX9;MEU;;6B1KGN;5?RH3>FY3W434TU7JTOL9I@FM2I0?T29J1JE1C6B23=@2B=>KMFDYHF");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("2.147483647E+10", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0854()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0855()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).pow(-1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).stripTrailingZeros();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\0', '8', '\1', '\234', '8', '\234', '8', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '\1', '\234', '\1', '\1', '8', '8', '\0', '\1', '\0', '8', '\234', '\234', '\1', '\0', '\234', '\1', '\234', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7IO7@E>@HM9N:F10PMHEIG?MA4;U:GWTA?9QLYE:>0?>5YHBC4KM51", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_String = (new BigDecimal("1E+1")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0862()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("1E+1"));
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '\1', '8', '\234', '\234', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\1', '\0', '\uFFFF', '\0', '8', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\234', '\234', '\234', '8', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '8', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '8', '8', '\234', '\1', '8', '\234', '\234', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0867()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0868()
  {
    rc_String = (new BigDecimal("1E+1")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0869()
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
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("1E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0875()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1.0"));
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0880()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("10"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("10")).movePointLeft(2147483647);
    Assert.assertEquals("1.0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("10")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_String = (new BigDecimal("-10")).toPlainString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0888()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).add(new BigDecimal("-10"));
    Assert.assertEquals("-9.0", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0892()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+308")).divideToIntegralValue(new BigDecimal("10"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0893()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("10"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("-9.0")).divideToIntegralValue(new BigDecimal("10"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("5@NL:QW1X>WSPS");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0897()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("10")).min(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("9E+18"), 1, java.math.RoundingMode.UP);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0901()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("9E+18"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E-19", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("0E-19")).setScale(-2147483648, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("GCF>M09PI6V;IOTCXL?C21B7<N<X8AYLCEIK5CRVJ8PL5:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0906()
  {
    rc_String = (new BigDecimal("9E+18")).toString();
    Assert.assertEquals("9E+18", rc_String);
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("3E+1"), 0);
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
//  public void testItem_0908()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_String = (new BigDecimal("1E+18")).toString();
    Assert.assertEquals("1E+18", rc_String);
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("1E+18")).stripTrailingZeros();
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0912()
  {
    rc_boolean = (new BigDecimal("0.0")).equals(">O5AU>6KMF5DRR@;IF?@3Q4:XLCG?>=E>QXO2NP@NMWA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("1E+18")).negate();
    Assert.assertEquals("-1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+18")).divideToIntegralValue(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("1E+18")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_String = (new BigDecimal("-1E+1")).toPlainString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0919()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+18")).divide(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0920()
  {
    rc_int = (new BigDecimal("-1E+18")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0921()
  {
    rc_int = (new BigDecimal("-1E+1")).intValue();
    Assert.assertEquals(-10, rc_int);
  }
//  public void testItem_0922()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1E+1")).hashCode();
//    Assert.assertEquals(-32, rc_int);
//  }
  public void testItem_0923()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0924()
  {
    rc_BigDecimal_array = (new BigDecimal("-1E+1")).divideAndRemainder(new BigDecimal("-1E+18"), new MathContext("precision=2147483647 roundingMode=UP"));
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1E+18")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("-1E+18"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0927()
//  {
//    boolean caught;
//    rc_short = (new BigDecimal("00.0E+2147483647")).shortValueExact();
//    Assert.assertEquals(0, rc_short);
//  }
  public void testItem_0928()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\1', '8', '\1', '8', '8', '\234', '\1', '\1', '\0', '\0', '8', '\uFFFF', '8', '\0', '\1', '\234'}, 1, 1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0929()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0930()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_String = (new BigDecimal("8")).toEngineeringString();
    Assert.assertEquals("8", rc_String);
  }
//  public void testItem_0932()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0933()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-1E+18"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0934()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).scaleByPowerOfTen(-1);
//    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0935()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+18")).divide(new BigDecimal("0E+2147483647"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0936()
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
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0939()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).intValueExact();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0941()
  {
    rc_int = (new BigDecimal("1E+18")).compareTo(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0942()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0943()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0944()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0945()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0946()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\234', '\0', '\uFFFF', '8', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\0', '\0', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\1', '8', '\0', '\234', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0947()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0949()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).movePointRight(-2147483648);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0950()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).pow(0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0955()
  {
    rc_int = (new BigDecimal("0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0956()
  {
    rc_byte = (new BigDecimal("0E+2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).add(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).multiply(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0959()
  {
    rc_boolean = (new BigDecimal("0E+2147483647")).equals("D54>9Q9X3B>;EP7460=QM7RX8J7694CU=8M@;;HVQCQJ53@PEILTXXTLFRXQ:7K@HH1G5?QP8>9WITHMAYT3Y6Q2G56E;:HO=IYJ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).add(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).ulp();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("1E+2147483647"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("0E+2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\0', '8', '\1', '\0', '8', '8', '8', '\1', '8', '8', '\1', '8', '\1', '\1', '\234', '8', '\1', '\1', '\uFFFF', '8', '8', '\1', '\1'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0967()
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
//  public void testItem_0968()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).min(new BigDecimal("1E+2147483647"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_byte = (new BigDecimal("0E+2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0971()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_int = (new BigDecimal("0E+2147483647")).compareTo(new BigDecimal("1E+2147483647"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0974()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_String = (new BigDecimal("0E+2147483647")).toEngineeringString();
    Assert.assertEquals("0.00E+2147483649", rc_String);
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0980()
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
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(-1);
    Assert.assertEquals("113587901589.1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("113587901589.1"));
    Assert.assertEquals("113587901589.1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508512")).divide(new BigDecimal("0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0984()
  {
    rc_String = (new BigDecimal("0E+2147483647")).toEngineeringString();
    Assert.assertEquals("0.00E+2147483649", rc_String);
  }
  public void testItem_0985()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508512")).remainder(new BigDecimal("0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0E+2147483647"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigInteger = (new BigDecimal("113587901589.1")).toBigInteger();
    Assert.assertEquals("113587901589", rc_BigInteger.toString());
  }
//  public void testItem_0989()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483647")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0990()
  {
    rc_boolean = (new BigDecimal("0E+2147483647")).equals("YGHV65H3ID>8<<NKJ6KH24J>Q55XYOY9JPP1WMM2UL5?");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("113587901589.1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).ulp();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
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
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), 2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
}
