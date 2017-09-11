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
public class TestSuite018 extends TestCase
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
  
  public TestSuite018() {
	
  }
  public void testItem_0000()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404027184124858368")).remainder(new BigDecimal("1E+12"));
    Assert.assertEquals("184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\234', '\1', '\234', '\0', '\0', '8', '\uFFFF', '\234', '8', '8', '\1', '\234', '\1', '8', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '\234', '\0', '8', '\0', '8', '8', '\234', '\234', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\0', '8', '\0', '\234', '\0', '\234', '8', '8', '\1', '8', '\234', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '8', '8', '\1', '\234', '8', '\234', '\uFFFF', '\234', '\1', '8', '\1', '\234', '\234', '\0', '\234', '\0', '8', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\1', '\0', '\1', '8', '\uFFFF', '8', '\0', '\1', '\1', '\uFFFF'}, 0, -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0002()
  {
    rc_int = (new BigDecimal("184124858368")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0003()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("1.00000000000E+12"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000E+12")).negate();
    Assert.assertEquals("-1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0007()
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
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-1.00000000000E+12"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '8', '\1', '\0', '8', '\1', '8', '\1', '\0', '8', '\1', '\234', '\0', '\1', '\uFFFF', '\1', '\1', '8', '\234', '\234', '\234', '\1', '\1', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\1', '\1', '\1', '\0', '8', '\0', '\0', '8', '\uFFFF', '\1', '8', '\1', '\234', '\uFFFF', '\1', '\234', '8'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404027184124858368")).remainder(new BigDecimal("-1.00000000000E+12"));
    Assert.assertEquals("184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_double = (new BigDecimal("1E+12")).doubleValue();
    Assert.assertEquals(1.0E12, rc_double, 0);
  }
  public void testItem_0012()
  {
    rc_int = (new BigDecimal("1E+12")).compareTo(new BigDecimal("1E+12"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0013()
  {
    rc_double = (new BigDecimal("-1.00000000000E+12")).doubleValue();
    Assert.assertEquals(-1.0E12, rc_double, 0);
  }
  public void testItem_0014()
  {
    rc_BigDecimal_array = (new BigDecimal("184124858368")).divideAndRemainder(new BigDecimal("1E+12"));
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("184124858368")).divideToIntegralValue(new BigDecimal("184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0016()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+12")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0017()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0018()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("184124858368")).hashCode();
//    Assert.assertEquals(-140886614, rc_int);
//  }
  public void testItem_0019()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0020()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("1E+12"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000E+12")).multiply(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0024()
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
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000E+12")).negate();
    Assert.assertEquals("1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("?0EMTE6V70VB5<>G<7A@2M9MMJKHDX23U7J8LHYYP9QUG7SCMV8=5>9FUDGP<4Y7XAIFOR0WXBTWEMSYP7ULF33=@B05NHE<<BQC");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("92?XH9W16UACDFC");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_String = (new BigDecimal("-1.00000000000E+12")).toEngineeringString();
    Assert.assertEquals("-1.00000000000E+12", rc_String);
  }
  public void testItem_0032()
  {
    rc_int = (new BigDecimal("1.00000000000E+12")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-1.00000000000E+12"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_String = (new BigDecimal("1E+12")).toPlainString();
    Assert.assertEquals("1000000000000", rc_String);
  }
  public void testItem_0036()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '\0'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
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
      rc_MathContext = new MathContext("<ITJ283GACHS0=FL3S<86O4V4FYCWFFADL?JHCT1M4?4DSN=T");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0041()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.00000000000E+12")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0042()
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
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1.00000000000E+12")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("1.00000000000E+12"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-999999999996.8", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigDecimal = (new BigDecimal("-1.00000000000E+12")).setScale(0, 1);
    Assert.assertEquals("-1000000000000", rc_BigDecimal.toString());
  }
//  public void testItem_0047()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1000000000000")).divideToIntegralValue(new BigDecimal("-999999999996.8"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000000E+12")).max(new BigDecimal("-1000000000000"));
    Assert.assertEquals("1.00000000000E+12", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0050()
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
  public void testItem_0051()
  {
    rc_BigDecimal = (new BigDecimal("-1000000000000")).movePointRight(-1);
    Assert.assertEquals("-100000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SW6R08Q=6R<@W=79P3V67@QSUS:;K64R<<KK9X?4BSG:JAFF?2RNVAYWH<UKHXI7>;62F6>WW6MH:1DBQ@?M5H25L6WO1RL<VU;B");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("-999999999996.8")).remainder(new BigDecimal("-999999999996.8"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0054()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("-999999999996.8")).scaleByPowerOfTen(0);
    Assert.assertEquals("-999999999996.8", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0059()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("UWTY3M<DD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("-999999999996.8"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).negate();
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0065()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).multiply(new BigDecimal("0.0"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
//  public void testItem_0071()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).add(new BigDecimal("-999999999996.8"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("-999999999996.8")).multiply(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("999999999996.8", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("999999999996.8")).divide(new BigDecimal("-999999999996.8"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_int = (new BigDecimal("999999999996.8")).compareTo(new BigDecimal("999999999996.8"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0076()
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
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0078()
  {
    rc_String = (new BigDecimal("-1.0")).toString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal = (new BigDecimal("999999999996.8")).divideToIntegralValue(new BigDecimal("999999999996.8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("-999999999996.8")).max(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("-3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("-999999999996.8"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";T8W340SFH;MR4;?Q8RK<XGEY@LYPX83RFL>:2D2AL4QJ6CSS>1HS;VH4KFVE:=H0V7USR>XCSR=A6W7XTB0@9R=4MUI=61U?028");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0086()
  {
    rc_float = (new BigDecimal("-1.0")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_String = (new BigDecimal("-1.0")).toEngineeringString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0089()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2E-2147483646")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0092()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0093()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0096()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0097()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=0 roundingMode=UP", rc_MathContext.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0098()
  {
    rc_boolean = (new BigDecimal("-999999999996.8")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0102()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0103()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0105()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0106()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-999999999996.8")).pow(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("-999999999996.8")).divideToIntegralValue(new BigDecimal("-999999999996.8"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_int = (new BigDecimal("-999999999996.8")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CHR?6=KR<3:<U5H7E@>G4RJIJ4SY5AJS:SINJTJALI@8276RE?2E>I2E?YU1SC10GJ@>V@IFMK;@U>VFG4JJ8MFE9LIQN398@43W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("D1Q9LEOSJUDU0J98NV6CY=LNTX<41NSBHQFX<C4R:=A>0P12MAD17VE70;WQ:HP83?XRN?XKX7N44WG@?DH6?F8S;BANK>W=F>4A");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0117()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
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
  public void testItem_0124()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
//  public void testItem_0126()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0127()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -2147483648, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0131()
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
  public void testItem_0132()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\234'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775808")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate();
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(1);
    Assert.assertEquals("-92233720368547758080", rc_BigDecimal.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("9223372036854775807"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775808")).divide(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0144()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-92233720368547758080")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0145()
  {
    rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("9223372036854775808"), new MathContext("precision=0 roundingMode=UP"));
  }
  public void testItem_0146()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_double = (new BigDecimal("-92233720368547758080")).doubleValue();
    Assert.assertEquals(-9.223372036854776E19, rc_double, 0);
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-92233720368547758080"), -1, 0);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-1E+1"), 0);
    Assert.assertEquals("-922337203685477581", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0151()
  {
    rc_boolean = (new BigDecimal("-92233720368547758080")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0152()
  {
    rc_boolean = (new BigDecimal("-922337203685477581")).equals("I;G490A;<@6N85YK<WF@H=PXNKAYQ51UV>HD9>77:V:W3OKPTAU2:77ALVO<KNAHYN=WJLO94=<810=NP3GXWFJ>F<FKH3DOYT8>");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigInteger = (new BigDecimal("-922337203685477581")).unscaledValue();
    Assert.assertEquals("-922337203685477581", rc_BigInteger.toString());
  }
  public void testItem_0155()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointLeft(0);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).movePointRight(-1);
    Assert.assertEquals("-922337203685477580.8", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-922337203685477580.8")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0162()
  {
    rc_boolean = (new BigDecimal("-9223372036854775808")).equals(":0P9@IVYDUW220");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-922337203685477580.8")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    rc_String = (new BigDecimal("-922337203685477580.8")).toString();
    Assert.assertEquals("-922337203685477580.8", rc_String);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    rc_int = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0168()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0169()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0170()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0171()
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
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\0', '\1', '8', '8', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\0', '8', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '8', '\0', '8', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '8', '\1', '8', '8', '8', '\0', '\1', '\1', '\0', '\234', '8', '8', '\0', '8', '\1', '\234', '\1', '\0', '\234', '\1', '8', '8', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_String = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).toEngineeringString();
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_String);
  }
  public void testItem_0177()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775808.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).toBigInteger();
    Assert.assertEquals("9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385440", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0182()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":JFUHC477<6UX@7P;UC;RQ<<J26X>M;E:=P@9L<UOUSRQ9X5NACO7;E5F6@GLP65TU2W47EA8=N26;6;;U3C><>C@JSH?KAY;79<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0186()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
//  public void testItem_0187()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).add(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).max(new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0191()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0192()
  {
    rc_String = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).toPlainString();
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_String);
  }
  public void testItem_0193()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0194()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("YB:MH43M6GW85@SX@DFX4B4H09=LW8D1VXFB=HETK?=M5", new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
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
      rc_MathContext = new MathContext(-1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0197()
  {
    rc_BigInteger = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).toBigInteger();
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigInteger.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("-288230376151711744", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigInteger = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).toBigIntegerExact();
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigInteger.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).plus(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).divide(new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_int = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0211()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\234', '8', '\234', '\1', '8', '\1', '\234', '8', '\234', '\0', '8', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '8', '8', '\1', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
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
  public void testItem_0214()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\uFFFF', '\1', '\0', '\0', '\234', '8', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\0', '8', '\1', '\0', '\uFFFF', '\0', '8', '8', '\0', '\234', '\0', '\1', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\1', '8', '\uFFFF', '8', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '\1', '8', '\1', '\0', '\0', '8', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '8', '\1', '8', '\1', '\234', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '\1', '\234', '8', '8', '8', '\0'}, -2147483648, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0215()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0216()
  {
    rc_String = (new BigDecimal("9223372036854775808")).toString();
    Assert.assertEquals("9223372036854775808", rc_String);
  }
  public void testItem_0217()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0218()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '\1', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '\234', '\uFFFF', '\1', '8', '8', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\1', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '8'}, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("9223372036854775808"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385471", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385471")).divide(new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).divide(new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385471"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0226()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_short = (new BigDecimal("0E+2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0229()
  {
    rc_String = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).toPlainString();
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_String);
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).negate();
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).movePointLeft(0);
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0236()
  {
    rc_BigInteger = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).toBigInteger();
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472", rc_BigInteger.toString());
  }
  public void testItem_0237()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161312", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_BigDecimal_array = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472")).divideAndRemainder(new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374489278507031537385472"));
  }
  public void testItem_0241()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0245()
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
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0247()
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
  public void testItem_0248()
  {
    rc_int = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0249()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_float = (new BigDecimal("3.2")).floatValue();
    Assert.assertEquals(3.200000047683716F, rc_float, 0);
  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280")).abs();
    Assert.assertEquals("1866831283351045821290051077856620080845209159650903291326763841885977105593626657769374509831481072763545059413864411820814789073334843464670825710760822317079604277694110780429375707916746655261598291386164182192630547426600149493073978642465210658108515685115807002918237384140492309512727224992978736494828681432154374498501879068392161280", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\1', '8', '\0', '\1', '\uFFFF', '8', '8', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1', '\1', '8', '\234', '\234', '\0', '8', '8', '\234', '\234', '\1', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '8', '\0', '8', '8', '\1', '\uFFFF', '\0', '\0', '\1', '\234', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\0', '8', '\1', '8', '\234', '8', '\uFFFF', '\0', '\1', '\234', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0255()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\234', '\0', '8', '\0', '\234', '\234', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\234', '\0', '\1', '\234', '8', '\234', '\1', '\234', '\0', '\1', '\1', '\0', '\234', '\0', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\1', '\0', '\1', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\234', '\0', '8', '\1', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\1', '8', '8', '\1', '\1', '\234', '\234', '\234', '\234', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '\1', '\234', '\0'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0256()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0257()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0258()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0260()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("320.0E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("320.0E+2147483647")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0263()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0264()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(2147483647);
//    Assert.assertEquals("320", rc_BigDecimal.toString());
//  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '\1', '\234', '\1', '\uFFFF', '8', '\0', '\234', '\234', '\1', '8', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '8', '8', '\1', '\uFFFF', '\234', '\234', '8', '\0', '8', '\0', '8', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '8', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '\0', '\0', '\1', '\1', '\234', '8', '\234', '8', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '8', '8', '\234', '8', '\1', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\uFFFF'}, -2147483648, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("2")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0275()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0276()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0278()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), -1, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0280()
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
  public void testItem_0281()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0282()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
//  public void testItem_0284()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("36348128508512")).divide(new BigDecimal("1135879015891"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0285()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0287()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=0 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0290()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0291()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(-1);
    Assert.assertEquals("11358790158910", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("36348128508512")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0295()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).min(new BigDecimal("-36348128508512"));
    Assert.assertEquals("-36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    rc_long = (new BigDecimal("36348128508512")).longValue();
    Assert.assertEquals(36348128508512L, rc_long);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0298()
  {
    rc_boolean = (new BigDecimal("9223372036854775807")).equals("8FX4>UP=FJR9O@<BFC3B9YMPN3CL22QJ61R88J2=O<6AHA?R5:9B310S163?UPY<DA8RLSYO71000Q>SS@NHD>5QUA3UF>@C4BFJ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0299()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("-36348128508512"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("36348128508512"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("36348128508512", rc_BigDecimal.toString());
  }
  public void testItem_0304()
  {
    rc_BigInteger = (new BigDecimal("36348128508512")).toBigIntegerExact();
    Assert.assertEquals("36348128508512", rc_BigInteger.toString());
  }
  public void testItem_0305()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508512")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0', '\234', '8', '\uFFFF', '\1', '\0', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0308()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).toBigInteger();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0318()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0319()
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
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0323()
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
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0326()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\234', '\uFFFF', '\234', '\1', '8', '\1', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\0', '\234', '\234', '\0', '8', '\234', '8', '8', '\0', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '8', '8', '\1', '\234', '\234', '\0', '\0', '\234', '8', '\234', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\234', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\1', '8', '\234', '\1', '\1', '\0', '\uFFFF', '8', '8', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\234', '\1', '\0', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0332()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0333()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
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
  public void testItem_0336()
  {
    rc_short = (new BigDecimal("320")).shortValueExact();
    Assert.assertEquals(320, rc_short);
  }
//  public void testItem_0337()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0338()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0339()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XF=LTXX>Q:;NO;40A;XU>AJDQ6K8R:1I@;WCFCTSR9TB=;MB=P<A=R9AUO6I:>YX;X2", new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\uFFFF', '8', '8', '\234', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\0', '\234', '\234', '\1', '\0', '\0', '8', '\1', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\uFFFF', '\234', '\0', '8', '\0', '\0', '\0', '\234', '8', '\234', '\234', '\uFFFF', '\1', '\234', '\0', '\1', '\1', '\0', '\uFFFF', '\1', '\0', '\234', '8', '8', '\0', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '8', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\0', '8', '\234'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("320")).divideToIntegralValue(new BigDecimal("320"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
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
  public void testItem_0345()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0346()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0347()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0348()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0349()
  {
    rc_boolean = (new BigDecimal("-1")).equals("IT1RNAH<5@?KS7BQ?;6:VO6?1JIRM0B1@ATP=TU;?LR>LJ5:EILN0C<6Q5A<EH1BR6WRAQUTYW;WMCCH;Q@04TTCU4REIEL36B8;");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0355()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("RU0>G:Q;JNQ15X?SA0R4Q6RUFOD=M92M<?DD9D9=KY7KK<AVAL4=QUET;EJVW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
//  public void testItem_0358()
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
  public void testItem_0359()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toPlainString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0361()
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
  public void testItem_0362()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0364()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0365()
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
  public void testItem_0366()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0367()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0368()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775809", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_int = (new BigDecimal("-9223372036854775809")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0375()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">STO4PD@E@ORTP6");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775809")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0379()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).remainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-1074")).setScale(-2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0388()
  {
    rc_boolean = (new BigDecimal("0")).equals("MT6933N=:HYF:IPME@Q0H@=8Q:<UKCLJ2=H;47H7P=7Q3?RE4;5DM7<");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0392()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-128", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0399()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toEngineeringString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0400()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1.08420217248550443400745280086994171142578125E-19", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal_array = (new BigDecimal("-128")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0403()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_String = (new BigDecimal("-9223372036854775808")).toString();
    Assert.assertEquals("-9223372036854775808", rc_String);
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("-1.08420217248550443400745280086994171142578125E-19"));
    Assert.assertEquals("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).movePointLeft(1);
    Assert.assertEquals("-922337203685477580.7999999999999999999891579782751449556599254719913005828857421875", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).divideToIntegralValue(new BigDecimal("-128"));
    Assert.assertEquals("72057594037927935.000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-128"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("72057594037927936", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0412()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("72057594037927936")).multiply(new BigDecimal("72057594037927936"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("5192296858534827628530496329220096", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-128")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0415()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("5192296858534827628530496329220096")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-128"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("72057594037927936")).subtract(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"));
    Assert.assertEquals("9295429630892703743.999999999999999999891579782751449556599254719913005828857421875", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\1', '8', '\1', '8', '8', '\234', '\0', '8', '\uFFFF', '\1', '\0', '\0', '\0', '8', '\0', '\0', '\1', '\0', '\234', '\1', '\0', '\1', '\0', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\1', '8', '8', '8', '\234', '8', '\0', '8', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\0', '8', '\1', '8', '8', '\uFFFF', '\0', '\234', '\0', '\234', '\0', '8', '8', '\0', '\0', '\1', '8', '\0', '\234', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '8', '\1', '\1', '\0', '\234', '\0', '\234', '8', '\uFFFF', '\0', '8', '8', '\234', '\uFFFF', '8', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("72057594037927936"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("72057594037927936")).multiply(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"));
    Assert.assertEquals("-664613997892457936451903530140172287.992187500000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9295429630892703743.999999999999999999891579782751449556599254719913005828857421875")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0424()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0425()
  {
    rc_double = (new BigDecimal("9295429630892703743.999999999999999999891579782751449556599254719913005828857421875")).doubleValue();
    Assert.assertEquals(9.295429630892704E18, rc_double, 0);
  }
  public void testItem_0426()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0427()
  {
    rc_BigDecimal_array = (new BigDecimal("-664613997892457936451903530140172287.992187500000000000000000000000000000000000000000000000000000000")).divideAndRemainder(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
//  public void testItem_0428()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9295429630892703743.999999999999999999891579782751449556599254719913005828857421875")).hashCode();
//    Assert.assertEquals(-920571533, rc_int);
//  }
  public void testItem_0429()
  {
    rc_int = (new BigDecimal("-664613997892457936451903530140172287.992187500000000000000000000000000000000000000000000000000000000")).scale();
    Assert.assertEquals(63, rc_int);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0433()
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
  public void testItem_0434()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.992187500000000000000000000000000000000000000000000000000000000")).remainder(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-63", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0438()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875")).add(new BigDecimal("-9223372036854775807.999999999999999999891579782751449556599254719913005828857421875"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-18446744073709551615.999999999999999999783159565502899113198509439826011657714843750", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.992187500000000000000000000000000000000000000000000000000000000")).stripTrailingZeros();
    Assert.assertEquals("-664613997892457936451903530140172287.9921875", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\1', '\0', '8', '\0', '\0', '\1', '8', '\1', '\1', '\234', '\0', '\234', '\234', '\0', '\0', '\0', '8', '\1', '\1', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '\0', '\1', '\0', '8', '8', '\234', '\0', '\0', '\0', '\1', '\234', '\234', '8', '\1', '8', '\uFFFF', '\234', '8', '\1', '\0', '\0', '\0', '\1', '\1', '\0', '8', '\234', '8', '\234', '\1', '\234', '\1', '\0', '\1', '8', '\1', '8', '\1', '\234', '\0', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '8', '\0', '8', '\234', '8', '\0', '\1', '\0', '\234', '\uFFFF'}, -2147483648, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("-18446744073709551615.999999999999999999783159565502899113198509439826011657714843750"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.9921875")).remainder(new BigDecimal("-664613997892457936451903530140172287.9921875"));
    Assert.assertEquals("0E-7", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_long = (new BigDecimal("0E-7")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0450()
  {
    rc_String = (new BigDecimal("0E-7")).toEngineeringString();
    Assert.assertEquals("0.0E-6", rc_String);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    rc_BigDecimal = (new BigDecimal("0E-7")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-7", rc_BigDecimal.toString());
  }
  public void testItem_0455()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=O@08@@LC>V>G<YUU>6W@<>>:Y8?L9BMH@O4;G@?PAYSBT8RO=31OMNTC;=0U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.9921875")).add(new BigDecimal("1"));
    Assert.assertEquals("-664613997892457936451903530140172286.9921875", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-664613997892457936451903530140172286.9921875"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0459()
  {
    rc_BigInteger = (new BigDecimal("-664613997892457936451903530140172286.9921875")).toBigInteger();
    Assert.assertEquals("-664613997892457936451903530140172286", rc_BigInteger.toString());
  }
  public void testItem_0460()
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
  public void testItem_0461()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0462()
  {
    rc_int = (new BigDecimal("-664613997892457936451903530140172287.9921875")).scale();
    Assert.assertEquals(7, rc_int);
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_long = (new BigDecimal("-664613997892457936451903530140172287.9921875")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_float = (new BigDecimal("-664613997892457936451903530140172287.9921875")).floatValue();
    Assert.assertEquals(-6.646139978924579E35F, rc_float, 0);
  }
  public void testItem_0468()
  {
    rc_int = (new BigDecimal("-664613997892457936451903530140172287.9921875")).precision();
    Assert.assertEquals(43, rc_int);
  }
  public void testItem_0469()
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
  public void testItem_0470()
  {
    rc_BigInteger = (new BigDecimal("-664613997892457936451903530140172287.9921875")).toBigInteger();
    Assert.assertEquals("-664613997892457936451903530140172287", rc_BigInteger.toString());
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("889W?D?P@FX;<C9:F:A1DVR0X1;?F:?IF1K2JV28A96?QESU6C34:QP6HHTL>UP:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0472()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0473()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0476()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\234', '8', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\1', '\0', '\234', '\0', '\0', '\uFFFF', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\234', '\uFFFF', '\234', '8', '\0', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3.2"));
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("-664613997892457936451903530140172287.9921875"));
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_float = (new BigDecimal("-664613997892457936451903530140172287.9921875")).floatValue();
    Assert.assertEquals(-6.646139978924579E35F, rc_float, 0);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.9921875")).pow(1);
    Assert.assertEquals("-664613997892457936451903530140172287.9921875", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_int = (new BigDecimal("-664613997892457936451903530140172287.9921875")).scale();
    Assert.assertEquals(7, rc_int);
  }
//  public void testItem_0488()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-664613997892457936451903530140172287.9921875")).hashCode();
//    Assert.assertEquals(-1880565370, rc_int);
//  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).stripTrailingZeros();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).movePointLeft(0);
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("664613997892457936451903530140172291.1921875")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0492()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("-664613997892457936451903530140172287.9921875")).movePointRight(1);
    Assert.assertEquals("-6646139978924579364519035301401722879.921875", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("W0:9TQ<S6M;Y0;TVY99KJU5S0M@20<W:QD7ML@SAH>UASTM6O<FAYBT<<K0G=F59PN9?QHKRXVA9XKR5@?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigInteger = (new BigDecimal("-6646139978924579364519035301401722879.921875")).unscaledValue();
    Assert.assertEquals("-6646139978924579364519035301401722879921875", rc_BigInteger.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_String = (new BigDecimal("664613997892457936451903530140172291.1921875")).toPlainString();
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_String);
  }
  public void testItem_0500()
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
  public void testItem_0501()
  {
    rc_float = (new BigDecimal("664613997892457936451903530140172291.1921875")).floatValue();
    Assert.assertEquals(6.646139978924579E35F, rc_float, 0);
  }
  public void testItem_0502()
  {
    rc_int = (new BigDecimal("-6646139978924579364519035301401722879.921875")).precision();
    Assert.assertEquals(43, rc_int);
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-6646139978924579364519035301401722879.921875")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0505()
  {
    rc_int = (new BigDecimal("3.2E+2")).precision();
    Assert.assertEquals(2, rc_int);
  }
//  public void testItem_0506()
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
  public void testItem_0507()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("3.2E+2"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("664613997892457936451903530140172291.1921875"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("21267647932558653966460912964485513318.1500000", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("21267647932558653966460912964485513318.1500000")).divide(new BigDecimal("664613997892457936451903530140172291.1921875"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("32.0000000", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).multiply(new BigDecimal("3.2E+2"));
    Assert.assertEquals("212676479325586539664609129644855133181.500000", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0512()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).pow(1);
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_String = (new BigDecimal("3.2E+2")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).add(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("664613997892457936451903530140172611.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0521()
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
  public void testItem_0522()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0523()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).min(new BigDecimal("3.2"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigInteger = (new BigDecimal("664613997892457936451903530140172611.1921875")).unscaledValue();
    Assert.assertEquals("6646139978924579364519035301401726111921875", rc_BigInteger.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).subtract(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("664613997892457936451903530140172287.9921875", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\uFFFF', '8', '8', '\234', '\234', '8', '\1', '\234', '\0', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '8', '8', '\234', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '\234', '8', '8', '\234', '\234', '\0', '8', '\uFFFF', '8', '\1', '8', '\0', '\234', '\0', '\1', '\uFFFF', '\0', '\0', '\1', '8', '8', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).max(new BigDecimal("664613997892457936451903530140172291.1921875"));
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
//  public void testItem_0531()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).subtract(new BigDecimal("3.2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0532()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=1 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).stripTrailingZeros();
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("664613997892457936451903530140172291.1921875"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0, 1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).abs();
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).subtract(new BigDecimal("320"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("664613997892457936451903530140171971.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).round(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("664613997892457936451903530140172291.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140171971.1921875")).stripTrailingZeros();
    Assert.assertEquals("664613997892457936451903530140171971.1921875", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0543()
  {
    rc_boolean = (new BigDecimal("-1")).equals("H87KT:AGM=<C<9NS>G<C6MTBSSQE@P1CE@SVC043K3;POOEAJL5OLM7NJ>FARGX6R3MT0J1W7;DTJD<?T==EA2N>5@E5C6V0F;H0");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140171971.1921875")).round(new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("664613997892457936451903530140171971.1921875", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("664613997892457936451903530140171971.1921875")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_long = (new BigDecimal("320")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0549()
  {
    rc_BigDecimal = (new BigDecimal("320")).divideToIntegralValue(new BigDecimal("664613997892457936451903530140171971.1921875"));
    Assert.assertEquals("0E+7", rc_BigDecimal.toString());
  }
//  public void testItem_0550()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0551()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+2147483647")).divide(new BigDecimal("0E+7"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0552()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("W3<5DAHL9F4:=F;V;8@5O5:>B6WE@?CB7>7;02H7H<:PP69:5>@HBW22?IMKCC:4=?5D2@EP0O219L6HJR?U00=SJE:V=:BYW3OK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0553()
  {
    rc_String = (new BigDecimal("0E+7")).toString();
    Assert.assertEquals("0E+7", rc_String);
  }
//  public void testItem_0554()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\234', '\234', '\234', '\234', '8', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '\234', '8', '\0', '\uFFFF', '8', '\1', '\234', '\234', '\234', '8', '\234', '\1', '\234', '8', '\0', '8', '8', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\uFFFF', '\234', '\234', '8', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '\0', '8', '8', '\234', '\1', '\234', '\uFFFF', '\0', '\1', '\0', '\1', '\1', '\0', '\1', '\234', '\1', '\uFFFF', '\0'}, 1, 2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("320")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).plus();
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0560()
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
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("320"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0565()
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
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\0', '8', '\uFFFF', '\234', '\1', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\234', '8', '\1', '8', '8', '8', '\1', '\0', '\0', '\234', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\234', '8', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '8', '\234', '\1'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("664613997892457936451903530140172291.1921875")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0568()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0569()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\234', '8', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\1', '\0', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\0', '\234', '\0', '\234', '\234', '\1', '\1', '\234', '\1', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\1', '\234', '\0', '8', '\0', '\0', '\uFFFF', '\0', '\1', '\0', '8', '\1', '8', '\0', '\1', '\1'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).divide(new BigDecimal("664613997892457936451903530140172291.1921875"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.0000000", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("664613997892457936451903530140172291.1921875")).divide(new BigDecimal("664613997892457936451903530140172291.1921875"), java.math.RoundingMode.UP);
    Assert.assertEquals("1.0000000", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320")).divide(new BigDecimal("1.0000000"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0577()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("1.0000000")).divideAndRemainder(new BigDecimal("1.0000000"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0579()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_short = (new BigDecimal("1.0000000")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0584()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("64")).hashCode();
//    Assert.assertEquals(1984, rc_int);
//  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0000000")).divide(new BigDecimal("64"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0587()
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
  public void testItem_0588()
  {
    rc_int = (new BigDecimal("64")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000")).setScale(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("1.0000000")).movePointLeft(1);
    Assert.assertEquals("0.10000000", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_int = (new BigDecimal("1.0")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0593()
  {
    rc_BigDecimal_array = (new BigDecimal("1.0")).divideAndRemainder(new BigDecimal("1.0"));
  }
  public void testItem_0594()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = (new BigDecimal("0.10000000")).negate();
    Assert.assertEquals("-0.10000000", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.10000000")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_String = (new BigDecimal("0.10000000")).toPlainString();
    Assert.assertEquals("0.10000000", rc_String);
  }
//  public void testItem_0600()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.10000000")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0601()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("-0.10000000"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0602()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0.10000000")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0.10000000", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9223372036854775807")).divideAndRemainder(new BigDecimal("0.10000000"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0607()
  {
    rc_BigDecimal = (new BigDecimal("-0.10000000")).movePointLeft(1);
    Assert.assertEquals("-0.010000000", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("-0.10000000")).remainder(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-0.10000000", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigInteger = (new BigDecimal("9223372036854775807")).unscaledValue();
    Assert.assertEquals("9223372036854775807", rc_BigInteger.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("0.10000000")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0E-8", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).abs();
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_float = (new BigDecimal("0.10000000")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0613()
  {
    rc_double = (new BigDecimal("9223372036854775807")).doubleValue();
    Assert.assertEquals(9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0614()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.10000000")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0615()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("295147905179352825824", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0620()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0621()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
//  public void testItem_0623()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0624()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("9223372036854775807"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal_array = (new BigDecimal("295147905179352825824")).divideAndRemainder(new BigDecimal("295147905179352825824"));
  }
  public void testItem_0627()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0628()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0631()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0633()
  {
    rc_BigDecimal = (new BigDecimal("295147905179352825824")).setScale(1, 0);
    Assert.assertEquals("295147905179352825824.0", rc_BigDecimal.toString());
  }
  public void testItem_0634()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0635()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\1', '\1', '\1', '8', '\0', '8', '8', '8', '8', '\1', '\0', '8', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\1', '8', '\1', '\1', '8', '8', '8', '8', '\234', '\234', '8', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0636()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0637()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0638()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0639()
  {
    rc_float = (new BigDecimal("2147483647")).floatValue();
    Assert.assertEquals(2.147483648E9F, rc_float, 0);
  }
  public void testItem_0640()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2147483647")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0641()
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
  public void testItem_0642()
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
  public void testItem_0643()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0646()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0647()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0648()
  {
    rc_int = (new BigDecimal("2147483647")).intValueExact();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("-1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0655()
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
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("2147483647"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("0"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0660()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0661()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '8', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\0', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\0', '\1', '\234'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).divide(new BigDecimal("2147483648"), 1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_long = (new BigDecimal("1.0")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '8', '\1', '8', '\234', '\0', '8', '8', '\1', '\234', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\1', '8', '\0', '8', '\1', '8', '\234', '8', '\1', '8', '\234', '\0', '\1', '\uFFFF', '8', '8', '\234', '\1', '\0', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\0', '\0', '\0', '\234', '\1', '\1', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\234', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0667()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("2147483648"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divideToIntegralValue(new BigDecimal("2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y1WW3=7>WY860U4OSDX0T@1U2CKR8RO8WS8=99N4@NRS<X3=P>D2AR?:S2<1MJ0B8V1A?41W0CHSMN;2KTLF62PTI>:N;YE1168N", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0671()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).divideToIntegralValue(new BigDecimal("2E+12"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("0E-12")).divide(new BigDecimal("2147483647"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E-12", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.147483647E+2147483656", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\uFFFF', '8', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\1', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '8', '\1', '8', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '8', '8', '\1', '\0', '8', '\1', '8', '8', '\234', '\1', '\234', '\234', '8', '\234', '\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    rc_long = (new BigDecimal("2E+12")).longValueExact();
    Assert.assertEquals(2000000000000L, rc_long);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).stripTrailingZeros();
    Assert.assertEquals("2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0E-12")).subtract(new BigDecimal("2E+12"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-2E+12", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0682()
  {
    rc_String = (new BigDecimal("0E-12")).toEngineeringString();
    Assert.assertEquals("0E-12", rc_String);
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("2E+12")).ulp();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("2E+12"));
    Assert.assertEquals("-2000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I<RPIB77P7;J?=U@08;8HF4BTU@=UY;E9XEP5DL=9Y7LDNCH?=B=4:SJTWJ6282<;7");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000000")).add(new BigDecimal("1E+12"));
    Assert.assertEquals("-1000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate();
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2000000000000")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0689()
  {
    rc_boolean = (new BigDecimal("1E+12")).equals("2KH1XYXOWA<I7@15Q<RRBH<:EAE<;KW7Y>PQM84G6S63=7@:2KBV:W=GENO2X?=2UIMD5SYXI<TKTDV=43?UXK0@UA3@>29DKGHM");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0690()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).negate(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_int = (new BigDecimal("-1E+12")).scale();
    Assert.assertEquals(-12, rc_int);
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000000")).multiply(new BigDecimal("-1E+12"));
    Assert.assertEquals("2.000000000000E+24", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("2.000000000000E+24")).subtract(new BigDecimal("1E+12"));
    Assert.assertEquals("1.999999999999E+24", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("2.000000000000E+24")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("2.000000000000E+24")).subtract(new BigDecimal("2.000000000000E+24"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).stripTrailingZeros();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000000")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-2.000000000000E+2147483659", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigInteger = (new BigDecimal("1E+12")).toBigInteger();
    Assert.assertEquals("1000000000000", rc_BigInteger.toString());
  }
  public void testItem_0700()
  {
    rc_float = (new BigDecimal("-2000000000000.0E+2147483647")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0701()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+12")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0702()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-2000000000000.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0703()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '8', '\1', '\1', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\234', '\1', '8', '8', '\234', '8', '\1', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '8', '\1', '\1', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '\0', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '8', '8', '8', '\1', '\1', '8', '\1', '\1', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0704()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigInteger = (new BigDecimal("-2000000000000")).toBigInteger();
    Assert.assertEquals("-2000000000000", rc_BigInteger.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-2000000000000")).negate();
    Assert.assertEquals("2000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_String = (new BigDecimal("0E+12")).toString();
    Assert.assertEquals("0E+12", rc_String);
  }
  public void testItem_0709()
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
  public void testItem_0710()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
//  public void testItem_0711()
//  {
//    boolean caught;
//    rc_BigDecimal_array = (new BigDecimal("-2000000000000.0E+2147483647")).divideAndRemainder(new BigDecimal("1E+12"));
//  }
  public void testItem_0712()
  {
    rc_float = (new BigDecimal("1E+12")).floatValue();
    Assert.assertEquals(9.99999995904E11F, rc_float, 0);
  }
//  public void testItem_0713()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-2000000000000.0E+2147483647")).min(new BigDecimal("1E+12"));
//    Assert.assertEquals("-2.000000000000E+2147483659", rc_BigDecimal.toString());
//  }
//  public void testItem_0714()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0717()
  {
    rc_boolean = (new BigDecimal("0")).equals("9PD;N<>U95SD3MCOJJ:=;OTVVC7PLDWS=I7SN8I>H1H?4CNF@J9TPRUY=LIQ:ULR2DM244");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0718()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2000000000000")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0721()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).divideToIntegralValue(new BigDecimal("-2000000000000"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
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
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0724()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0725()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+12")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0726()
  {
    rc_long = (new BigDecimal("1E+12")).longValueExact();
    Assert.assertEquals(1000000000000L, rc_long);
  }
  public void testItem_0727()
  {
    rc_BigInteger = (new BigDecimal("0E+12")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).max(new BigDecimal("0E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).subtract(new BigDecimal("0E+12"));
    Assert.assertEquals("0E+12", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("0E+12"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0734()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("1E+12"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0735()
  {
    rc_BigDecimal = (new BigDecimal("0E+12")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0736()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0737()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\234', '\uFFFF', '8', '8', '\1', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '8', '\234', '8', '8', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '8', '8', '8', '\0', '\1', '\1', '8', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\234'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0738()
  {
    rc_int = (new BigDecimal("0E+12")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).subtract(new BigDecimal("0E+12"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigInteger = (new BigDecimal("0E+12")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigInteger = (new BigDecimal("0E+12")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0747()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=1 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0748()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).pow(-2147483648, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0749()
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
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).movePointLeft(1);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("30"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0753()
  {
    rc_BigDecimal = (new BigDecimal("30")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("29", rc_BigDecimal.toString());
  }
  public void testItem_0754()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0755()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("30")).add(new BigDecimal("-32"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\1', '8', '8', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '8', '\234', '\0', '\234', '8', '\1', '\0', '\1', '8', '8', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\234', '\1', '\0', '8', '8', '\234'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("32"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("30")).movePointRight(1);
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0765()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).pow(0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).divideToIntegralValue(new BigDecimal("3E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775839", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_int = (new BigDecimal("-32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0774()
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
  public void testItem_0775()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("0"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0779()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0780()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":PDRM:JNIBWHY@T?;U7RHL506U:OEVKBXMGTXUB160D<D0M59KHTEDM02GB0QH;C1:1WJMPXL9NF7<15G9>CWPGT>MLH3C:NUGI7");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0781()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0785()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0786()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0787()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0791()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0792()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7PY71GS:5FI5??OFY7WG:3CXTXFVEK5VEVTS5D<<8RN@=34=97YMYJJ3E2BL>1=5:<:>TANK3QXXPV1@=J6FQ02=Y:7Y=PW;UGMK");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0795()
  {
    rc_int = (new BigDecimal("0E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0796()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).max(new BigDecimal("1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("-29", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0E+1"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0808()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).stripTrailingZeros();
	Assert.assertEquals(0E+1, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0810()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0811()
  {
    rc_short = (new BigDecimal("0E+1")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("3.2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\0', '8', '8', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\234', '8', '\0', '\234', '8', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '\234', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\1', '\234', '\1', '8', '\0', '\0', '\234', '\234', '8', '\1', '\uFFFF', '\234', '\0', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0821()
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
  public void testItem_0822()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0823()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("LQQ2O0JK:");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0825()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  public void testItem_0826()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0827()
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
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_byte = (new BigDecimal("-29")).byteValueExact();
    Assert.assertEquals(-29, rc_byte);
  }
  public void testItem_0830()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_long = (new BigDecimal("0E+1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0834()
  {
    rc_String = (new BigDecimal("-32")).toString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0835()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_int = (new BigDecimal("-29")).intValueExact();
    Assert.assertEquals(-29, rc_int);
  }
  public void testItem_0838()
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
  public void testItem_0839()
  {
    rc_byte = (new BigDecimal("0E+1")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("-6E+1")).divideToIntegralValue(new BigDecimal("-6E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
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
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("-32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=DOWN"));
    Assert.assertEquals("-1E+308", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_float = (new BigDecimal("-1E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.NEGATIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0848()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '\234', '\1', '\1', '8', '\1', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '8', '8', '\1', '\0', '\0', '\234', '\234', '\234', '8', '\1', '\1', '\1', '\234', '\0', '8', '\234', '\0', '\1', '\0', '\1', '\uFFFF', '8', '8', '\0', '8', '\234', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2E+308"), 0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0851()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("precision=1 roundingMode=HALF_DOWN", rc_MathContext.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("-1E+308"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0855()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0856()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("-3.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?2;9OO46V<XH3C4WCV3OEGG=SRU0CJU9?G5:R1<WJW=A2@F?R;>C;Q<4DN>VFA3XRIR2WTJ3");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("1135879015891"));
    Assert.assertEquals("-1135879015894.2", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigInteger = (new BigDecimal("-3.2")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0862()
  {
    rc_BigInteger = (new BigDecimal("2E+308")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus();
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_int = (new BigDecimal("-3.2")).intValue();
    Assert.assertEquals(-3, rc_int);
  }
  public void testItem_0865()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\1', '8', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '\234', '\1', '\1', '\234', '\0', '8', '8'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0866()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0869()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).toBigInteger();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0871()
  {
    rc_int = (new BigDecimal("9E+18")).scale();
    Assert.assertEquals(-18, rc_int);
  }
  public void testItem_0872()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0873()
  {
    rc_boolean = (new BigDecimal("3")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0874()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0881()
  {
    rc_BigDecimal = (new BigDecimal("3")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0882()
  {
    rc_boolean = (new BigDecimal("-1E+12")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0883()
  {
    rc_int = (new BigDecimal("3")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal = (new BigDecimal("-1E+12")).plus();
    Assert.assertEquals("-1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).stripTrailingZeros();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("3")).max(new BigDecimal("0"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("9E+18"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("1"), -2147483648, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0894()
  {
    rc_float = (new BigDecimal("3")).floatValue();
    Assert.assertEquals(3.0F, rc_float, 0);
  }
  public void testItem_0895()
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
  public void testItem_0896()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0897()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '8', '\1', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\1', '\1', '\0', '\0', '\0', '\234', '8', '\1', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '8', '\234', '8', '\234', '\0', '\0', '8', '\0', '\1', '8', '\1', '\234', '8', '\0', '\234', '8', '\uFFFF', '8', '\234', '\1', '8', '\234', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '8', '\234', '8', '\0', '8', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\1', '\1', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\0', '8', '\234'}, new MathContext("precision=1 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0898()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+18")).divideAndRemainder(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=UP"));
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E-13", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).setScale(-1, 0);
    Assert.assertEquals("9.00000000000000000E+18", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    rc_BigDecimal = (new BigDecimal("9.00000000000000000E+18")).movePointLeft(0);
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).round(new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '8', '\0', '\0', '8', '8', '\1', '8', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\234', '\234', '8', '8', '\uFFFF', '8', '8', '\1', '\234', '\1', '\234', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\0', '8', '\1', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '8', '\1', '\0', '\234', '\1', '\234', '\234', '8', '\0', '\234', '8', '\234', '\1', '\0', '\uFFFF', '8', '\234', '8', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\1'}, -1, -2147483648, new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).divide(new BigDecimal("9E+18"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+18", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_long = (new BigDecimal("3")).longValueExact();
    Assert.assertEquals(3L, rc_long);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).min(new BigDecimal("3"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("XQMKUV6MWTR5V6AG3WD=3<DKLW<?K5>5V9PU>V>IVWHTSRP6<<HRCJC8X7A7R?VKE2>E8E?MEROYFL5E1<N<J@Y9KJO0T0TMN;S@");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0910()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3")).divideAndRemainder(new BigDecimal("1E+2147483647"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0911()
  {
    rc_int = (new BigDecimal("9000000000000000000")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0912()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0914()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).subtract(new BigDecimal("3"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+2", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigInteger = (new BigDecimal("3")).toBigIntegerExact();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0917()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("9000000000000000000"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-19", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(0);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).max(new BigDecimal("3.2E+2"));
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_int = (new BigDecimal("3.2E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0923()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).toBigInteger();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0924()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.003", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0927()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.003")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0928()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0930()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), 2147483647, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0931()
  {
    rc_BigDecimal = (new BigDecimal("0.003")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0003", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValueExact();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0933()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3E+2"), -2147483648, java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("9000000000000000000")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";GTF<2TYSL>KG;CWRM<@75AU8B>T?PI3FTG3QW4?L8?N5>BCVO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    rc_float = (new BigDecimal("9000000000000000000")).floatValue();
    Assert.assertEquals(9.0000002023581286E18F, rc_float, 0);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0.03", rc_BigDecimal.toString());
  }
//  public void testItem_0939()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E+2"), 2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0940()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).setScale(-1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0941()
  {
    rc_long = (new BigDecimal("9000000000000000000")).longValue();
    Assert.assertEquals(9000000000000000000L, rc_long);
  }
  public void testItem_0942()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0943()
  {
    rc_int = (new BigDecimal("3.2E+2")).intValue();
    Assert.assertEquals(320, rc_int);
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("0.03125")).round(new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("6N5V6;J=AIOMSEJT83A9LI0C1AWN");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0948()
  {
    rc_String = (new BigDecimal("3.2E+2")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("3E+2"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).plus();
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0951()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.03125")).divideToIntegralValue(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0952()
  {
    rc_long = (new BigDecimal("3E+2")).longValue();
    Assert.assertEquals(300L, rc_long);
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).remainder(new BigDecimal("3E+2"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0954()
  {
    rc_boolean = (new BigDecimal("3.2E+2")).equals("IBHFHHGH35JIKJ=SWQ5Y8F<XB@>S4<G8FV4UUMGPRU5MAPI:V:X56R8X0G");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate();
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3E+2")).divideAndRemainder(new BigDecimal("0E+2"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0957()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0958()
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
  public void testItem_0959()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0962()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+1")).hashCode();
//    Assert.assertEquals(30, rc_int);
//  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).ulp();
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_BigDecimal = (new BigDecimal("1E-1074")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0965()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-1074")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0966()
  {
    rc_BigInteger = (new BigDecimal("1E-1074")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0967()
  {
    rc_int = (new BigDecimal("4E+1")).intValueExact();
    Assert.assertEquals(40, rc_int);
  }
  public void testItem_0968()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E-1074"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0969()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).subtract(new BigDecimal("1E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_float = (new BigDecimal("-3.2E+2")).floatValue();
    Assert.assertEquals(-320.0F, rc_float, 0);
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("1E-1074")).round(new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("-3.2E+2")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("1E-1074")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("-1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0978()
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
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("-1E-1074")).min(new BigDecimal("1E-1074"));
    Assert.assertEquals("-1E-1074", rc_BigDecimal.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-1074")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0981()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigIntegerExact();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("1E-1074")).setScale(1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("SPNNWAMN:GW@==0NJLCMSE8Y?6@1QCJRK4=V;O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("-1E-1074")).divideToIntegralValue(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_DOWN"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_double = (new BigDecimal("1E-1074")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0990()
  {
    rc_int = (new BigDecimal("-1E-1074")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigInteger = (new BigDecimal("-1E-1074")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).max(new BigDecimal("-1E-1074"));
    Assert.assertEquals("-1E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_float = (new BigDecimal("-1E-1074")).floatValue();
    Assert.assertEquals(-0.0F, rc_float, 0);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).pow(1, new MathContext("precision=1 roundingMode=UP"));
    Assert.assertEquals("-3E+9", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-2147483648"), new MathContext("precision=2147483647 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
}
