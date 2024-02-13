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
public class TestSuite000 extends TestCase
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
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '8', '\234', '\0', '8', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '\1', '\1', '8', '\234', '\0', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\0', '8', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '\234', '\234', '\0', '\uFFFF', '\0', '8', '\234', '\234', '\234', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\0', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '\1', '\0', '\uFFFF', '8', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("2.0134228187919465%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("3.0201342281879193%", true, caught);
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("3.6912751677852347%", true, caught);
  }
  public void testItem_0006()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("3.6912751677852347%", true, caught);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.UP);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).movePointLeft(0);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_String = (new BigDecimal("-1.0")).toPlainString();
    Assert.assertEquals("-1.0", rc_String);
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3TH9R<@X");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("6.040268456375839%", true, caught);
  }
  public void testItem_0015()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("-1", rc_BigDecimal.toString()); 
  }
//  public void testItem_0016()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("7.046979865771812%", true, caught);
//  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = (new BigDecimal("-1.0")).add(new BigDecimal("0"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("7.718120805369128%", true, caught);
  }
  public void testItem_0021()
  {
    rc_long = (new BigDecimal("-1.0")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0022()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("8.389261744966444%", true, caught);
  }
  public void testItem_0023()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0024()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("8.724832214765101%", true, caught);
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("434>HM12RGU9NQYHN=OV65JG2G3J7SYFDI9PDO=LEBXAFB3X?IJWBI19XX3RN;E0OFX;BC=?9D7QR8N0OTH3NQM9HCSF968QRPT2");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("9.060402684563758%", true, caught);
  }
  public void testItem_0026()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("9.060402684563758%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("X7?;AY?OBEJ9?XVW4V:JN9FQ?UM@S;O82WWKFO?AR:FUD99T9UO79GO1ET9ST6RNK3W07Y0<PQK5Q0S?FB");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("9.731543624161073%", true, caught);
  }
  public void testItem_0033()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("10.40268456375839%", true, caught);
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("11.74496644295302%", true, caught);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0042()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
//  public void testItem_0044()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0047()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0048()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0050()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("15.100671140939598%", true, caught);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointLeft(-1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\1', '\234', '8', '\234', '\0', '\1', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\0'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("19.798657718120804%", true, caught);
  }
  public void testItem_0060()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("3E+1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0061()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("20.13422818791946%", true, caught);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0068()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("20.80536912751678%", true, caught);
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("21.140939597315437%", true, caught);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("21.812080536912752%", true, caught);
  }
  public void testItem_0072()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '8', '8', '\0', '\1', '\0', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '8', '8', '\uFFFF', '\234', '\1', '\234', '\0', '8', '8', '\234', '8', '\234', '8', '\1', '\1', '\0', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("22.14765100671141%", true, caught);
  }
  public void testItem_0073()
  {
    rc_int = (new BigDecimal("2147483647")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0074()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_String = (new BigDecimal("-2E+9")).toString();
    Assert.assertEquals("-2E+9", rc_String);
  }
  public void testItem_0077()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(";3<SB7:?8@2BJ=HU?2@J7R<Q2?79SM9GU6C6I00YMJ?EY3U:V?9;;QQFUN7;YHFHOUBO4JMJ?T0@78GRCEAMWUP;@FDC>JN71@AF");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("23.154362416107382%", true, caught);
  }
  public void testItem_0078()
  {
    rc_float = (new BigDecimal("-2E+9")).floatValue();
    Assert.assertEquals(-2.0E9F, rc_float, 0);
  }
  public void testItem_0079()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("23.48993288590604%", true, caught);
  }
  public void testItem_0080()
  {
    rc_int = (new BigDecimal("-2E+9")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("23.825503355704697%", true, caught);
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("24.83221476510067%", true, caught);
  }
  public void testItem_0084()
  {
    rc_byte = (new BigDecimal("0.0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0085()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0086()
  {
    rc_long = (new BigDecimal("0.0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=;H85P7F26LADAG22CG;WDPUTCJN<9BRMSTPU=RFD=7=O8PRI9GFMHX3IM4CD5<2YGK?>??B2H@V3@LRE3<@EVIPRF>TT1INSG5F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("25.503355704697988%", true, caught);
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("26.174496644295303%", true, caught);
  }
  public void testItem_0092()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), 1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("27.181208053691275%", true, caught);
  }
  public void testItem_0095()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2E+9")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("27.181208053691275%", true, caught);
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0100()
  {
    rc_boolean = (new BigDecimal("-2E+9")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("0.0"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("28.523489932885905%", true, caught);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0.0"));
    Assert.assertEquals("0.00", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0104()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).add(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
//  public void testItem_0106()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3E-2147483646")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("28.859060402684563%", true, caught);
//  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("28.859060402684563%", true, caught);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_int = (new BigDecimal("0.0")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0110()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0112()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("29.86577181208054%", true, caught);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("29.86577181208054%", true, caught);
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("29.86577181208054%", true, caught);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("30.201342281879196%", true, caught);
  }
  public void testItem_0121()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("0.0"), 0, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("30.87248322147651%", true, caught);
  }
  public void testItem_0122()
  {
    rc_short = (new BigDecimal("3")).shortValueExact();
    Assert.assertEquals(3, rc_short);
  }
  public void testItem_0123()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\234', '8', '8', '\0', '\1', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '8', '8', '\234', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\1', '\0', '\1', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\1', '\1', '\uFFFF', '\1', '8', '\1', '8', '\1', '8', '\1', '\0', '\1', '\1', '\1', '\1', '8', '\uFFFF', '\1', '\234', '8', '\234', '\0', '8', '\234', '\uFFFF', '8', '\1', '8', '\234', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("33.557046979865774%", true, caught);
  }
  public void testItem_0125()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0126()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0127()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointLeft(2147483647);
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("34.56375838926174%", true, caught);
  }
  public void testItem_0130()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("34.56375838926174%", true, caught);
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).remainder(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0132()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("34.56375838926174%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0135()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("34.899328859060404%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("35.23489932885906%", true, caught);
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<@T37;RO4=2");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("35.23489932885906%", true, caught);
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("3E-2147483646")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("35.23489932885906%", true, caught);
  }
  public void testItem_0143()
  {
    rc_int = (new BigDecimal("3E+1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-3E+1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("-30.0", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0147()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("36.577181208053695%", true, caught);
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).stripTrailingZeros();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("36.91275167785235%", true, caught);
  }
  public void testItem_0152()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_BigInteger = (new BigDecimal("-30.0")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0155()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0156()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("37.919463087248324%", true, caught);
//  }
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30.0")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("38.25503355704698%", true, caught);
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("-30.0")).scaleByPowerOfTen(1);
    Assert.assertEquals("-300", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("-30.0")).subtract(new BigDecimal("-300"));
    Assert.assertEquals("270.0", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_int = (new BigDecimal("-300")).precision();
    Assert.assertEquals(3, rc_int);
  }
  public void testItem_0161()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LF6PXR87<2?P?36YRVE");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("38.59060402684564%", true, caught);
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-300")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("38.59060402684564%", true, caught);
  }
  public void testItem_0163()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("39.59731543624161%", true, caught);
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-300")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("39.93288590604027%", true, caught);
  }
  public void testItem_0165()
  {
    rc_int = (new BigDecimal("270.0")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0166()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0167()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("-300")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("-330", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = (new BigDecimal("-300")).abs();
    Assert.assertEquals("300", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("HMYOX395U1:UAD<F?24W:YVYER;:?5EN3Q5SS0>B>KEE5B11X56:M99KWKT2I3>9EYKU=G8SW97HV7@X1L?6YW91<PQ@<RK8VI;H");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("39.93288590604027%", true, caught);
  }
//  public void testItem_0171()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-300")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("40.604026845637584%", true, caught);
//    }
//  }
  public void testItem_0172()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("40.939597315436245%", true, caught);
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("-30.0")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("-300")).subtract(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_String = (new BigDecimal("3")).toEngineeringString();
    Assert.assertEquals("3", rc_String);
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("3")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8")).divide(new BigDecimal("3E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("41.61073825503356%", true, caught);
  }
  public void testItem_0180()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0181()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\1', '8', '8', '\234', '8', '\234', '\234', '\234', '\234', '8', '\0', '\0', '\1', '\0', '\0', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\234'}, -2147483648, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("42.61744966442953%", true, caught);
  }
  public void testItem_0182()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigIntegerExact();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("8")).setScale(1);
    Assert.assertEquals("8.0", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0186()
  {
    rc_double = (new BigDecimal("-3E+1")).doubleValue();
    Assert.assertEquals(-30.0, rc_double, 0);
  }
  public void testItem_0187()
  {
    rc_int = (new BigDecimal("-3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0188()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("8")).hashCode();
//    Assert.assertEquals(248, rc_int);
//  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0190()
  {
    rc_BigDecimal = (new BigDecimal("8")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0191()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate();
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0194()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("-2147483678", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).subtract(new BigDecimal("-2147483648"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+8", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0200()
  {
    rc_long = (new BigDecimal("2E+308")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0201()
  {
    rc_double = (new BigDecimal("2E+308")).doubleValue();
    Assert.assertEquals(java.lang.Double.POSITIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).multiply(new BigDecimal("2E+308"));
    Assert.assertEquals("-4E+317", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(-2147483648);
    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).negate();
    Assert.assertEquals("-3E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_int = (new BigDecimal("-4E+317")).scale();
    Assert.assertEquals(-317, rc_int);
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("1E+8")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+8", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E+317")).divide(new BigDecimal("-3E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("44.966442953020135%", true, caught);
  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("1E+8")).abs();
    Assert.assertEquals("1E+8", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+8")).divideAndRemainder(new BigDecimal("-4E+317"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0210()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_BigDecimal = (new BigDecimal("-3E-2147483647")).movePointLeft(-2147483648);
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).remainder(new BigDecimal("-3E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("45.63758389261745%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E+317")).setScale(2147483647, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("45.63758389261745%", true, caught);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-4E+317")).setScale(0);
    Assert.assertEquals("-400000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_String = (new BigDecimal("2E+308")).toString();
    Assert.assertEquals("2E+308", rc_String);
  }
  public void testItem_0218()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("-4E+317"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\234', '\1', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\1', '\1', '\1', '\234', '\234', '8', '\1', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("45.97315436241611%", true, caught);
  }
  public void testItem_0220()
  {
    rc_float = (new BigDecimal("3E+1")).floatValue();
    Assert.assertEquals(30.0F, rc_float, 0);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).add(new BigDecimal("3E-2147483647"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = (new BigDecimal("-4E+317")).plus();
    Assert.assertEquals("-4E+317", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
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
    Assert.assertEquals("46.97986577181208%", true, caught);
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\1', '8', '\1', '\1', '\234', '8', '\0', '\1', '8', '\234', '\1', '\1', '\234', '\234', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\234', '\0', '\1', '\1', '8', '\0', '\1', '8', '\234', '\1', '\0', '\uFFFF', '\1', '8', '\1', '8', '8', '\234'}, -1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("47.651006711409394%", true, caught);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("-30")).plus();
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("-30"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("320.0E+2147483647"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).stripTrailingZeros();
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("-9E-2147483646")).plus();
    Assert.assertEquals("-9E-2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0231()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147482656, rc_int);
//  }
//  public void testItem_0232()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("6E-2147483647"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("47.986577181208055%", true, caught);
//  }
  public void testItem_0233()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '8', '\uFFFF', '\234', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '8', '8', '\0', '8', '\uFFFF', '8', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("50.0%", true, caught);
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("-30")).multiply(new BigDecimal("-30"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("-30")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_String = (new BigDecimal("6E-2147483647")).toString();
    Assert.assertEquals("6E-2147483647", rc_String);
  }
//  public void testItem_0237()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("-9E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("50.0%", true, caught);
//  }
  public void testItem_0238()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-30")).divide(new BigDecimal("6E-2147483647"), 2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("51.34228187919463%", true, caught);
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 0, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("52.013422818791945%", true, caught);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
//  public void testItem_0244()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("-9E-2147483646")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("52.348993288590606%", true, caught);
//  }
  public void testItem_0245()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).plus();
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    rc_int = (new BigDecimal("-9E-2147483646")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0247()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("V53JWHK1I37HPQCRP5LF6QMTO@D7;9M12KLNB56PGH58JP31?JGCC0J@L24EE47G;CM7U41G8FD;JKTLHF38S88>HQ7S7AEA0<H6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("52.348993288590606%", true, caught);
  }
  public void testItem_0250()
  {
    rc_int = (new BigDecimal("-9E-2147483646")).compareTo(new BigDecimal("-2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0251()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("320.0E+2147483647"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("53.355704697986575%", true, caught);
  }
//  public void testItem_0253()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+12")).hashCode();
//    Assert.assertEquals(19, rc_int);
//  }
  public void testItem_0254()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("W?SKO6V?LB=RCTJD1@W0T");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("53.355704697986575%", true, caught);
  }
  public void testItem_0255()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).min(new BigDecimal("-2147483648"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("-9E-2147483646")).pow(-1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-2E+2147483645", rc_BigDecimal.toString());
  }
//  public void testItem_0257()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E+2147483645")).movePointLeft(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("53.691275167785236%", true, caught);
//  }
  public void testItem_0258()
  {
    rc_double = (new BigDecimal("-2E+2147483645")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("6E-2147483647")).min(new BigDecimal("6E-2147483647"));
    Assert.assertEquals("6E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0261()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\1', '8', '\234', '8', '\1', '8', '8', '8', '\0', '\0', '8', '\234', '\0', '8', '\1', '8', '\1', '\0', '\0', '\0'}, -1, -1, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("54.02684563758389%", true, caught);
  }
  public void testItem_0262()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("320.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("54.02684563758389%", true, caught);
  }
  public void testItem_0263()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+12")).divideAndRemainder(new BigDecimal("-2E+2147483645"));
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divideToIntegralValue(new BigDecimal("-2E+2147483645"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483633", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("-2E+2147483645"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-5E-2147483634", rc_BigDecimal.toString());
  }
//  public void testItem_0266()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).plus();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
//  public void testItem_0267()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("320.0E+2147483647")).scale();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0268()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).multiply(new BigDecimal("1E+12"));
    Assert.assertEquals("-9.223372036854775808E+30", rc_BigDecimal.toString());
  }
  public void testItem_0269()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0270()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+12")).divide(new BigDecimal("320.0E+2147483647"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("55.033557046979865%", true, caught);
  }
  public void testItem_0271()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
//  public void testItem_0272()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("-2E+2147483645"));
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0273()
  {
    rc_BigDecimal_array = (new BigDecimal("-2E+2147483645")).divideAndRemainder(new BigDecimal("-2E+2147483645"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0274()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CUT:FLWE0=G:VUUXATDOSM:PMKNA?IV1J?JH:B07L8EXL5XVJAXS84K05K=?HATL7;@QKEHRV=CG3UERDVPHFL6Q>9@T8DL?9C<D", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("55.369127516778526%", true, caught);
  }
  public void testItem_0275()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0276()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-9223372036854775808")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("55.70469798657718%", true, caught);
  }
  public void testItem_0280()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0283()
//  {
//
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("56.375838926174495%", true, caught);
//  }
  public void testItem_0284()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("56.375838926174495%", true, caught);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -1, -1, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("56.375838926174495%", true, caught);
  }
  public void testItem_0287()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("56.375838926174495%", true, caught);
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
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1', '\234', '\0', '\0', '\234', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("56.375838926174495%", true, caught);
  }
//  public void testItem_0290()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointLeft(0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("56.375838926174495%", true, caught);
//  }
  public void testItem_0291()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0292()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).unscaledValue();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0296()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("9E+18")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("56.711409395973156%", true, caught);
  }
  public void testItem_0298()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-1"), -1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("57.04697986577181%", true, caught);
  }
  public void testItem_0300()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0302()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0303()
  {
    rc_long = (new BigDecimal("9E+18")).longValue();
    Assert.assertEquals(9000000000000000000L, rc_long);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("9E+18"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_String = (new BigDecimal("9E+18")).toPlainString();
    Assert.assertEquals("9000000000000000000", rc_String);
  }
  public void testItem_0307()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0312()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1024"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1024"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("58.053691275167786%", true, caught);
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\0', '\1', '\uFFFF', '8', '\1', '8', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '8', '\234', '\1', '\1', '\234', '\0', '\1', '\0', '8', '\uFFFF', '8', '\uFFFF', '\234', '8', '\1', '8'}, 2147483647, 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("58.053691275167786%", true, caught);
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("1024")).divide(new BigDecimal("1024"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.UP);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).stripTrailingZeros();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0324()
  {
    rc_float = (new BigDecimal("1135879015891")).floatValue();
    Assert.assertEquals(1.135878995968E12F, rc_float, 0);
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0331()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("B<HL3JE1CEF>U3SJ33C", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("59.395973154362416%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("M9PX5>EDITFS29L352;ICAP3Q3=1A=VQD=OAI:?JO5GHD>TV7XUI@E>?H2RC4=Y4B6ALV=U9PNA5<VEBOE@7FI:HK1ETX6W3O7XP");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("59.395973154362416%", true, caught);
  }
  public void testItem_0335()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("60.06711409395973%", true, caught);
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0340()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0341()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_int = (new BigDecimal("3E-2147483646")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0345()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(0, rc_int);
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
    Assert.assertEquals("60.738255033557046%", true, caught);
  }
//  public void testItem_0349()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0350()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("60.738255033557046%", true, caught);
  }
  public void testItem_0351()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0352()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).movePointRight(-1);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).min(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("3")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal_array = (new BigDecimal("3E-2147483646")).divideAndRemainder(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '8', '\1', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\0', '8', '8', '\0', '\1', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '8', '8', '\1', '\0', '8', '\0', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\0', '\1', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("61.40939597315436%", true, caught);
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("62.080536912751676%", true, caught);
  }
  public void testItem_0359()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("62.41610738255034%", true, caught);
  }
  public void testItem_0360()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("62.75167785234899%", true, caught);
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("62")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("63.08724832214765%", true, caught);
  }
//  public void testItem_0366()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 0);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
//  public void testItem_0367()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("64.42953020134229%", true, caught);
//  }
  public void testItem_0368()
  {
    rc_String = (new BigDecimal("62")).toString();
    Assert.assertEquals("62", rc_String);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_String = (new BigDecimal("62")).toPlainString();
    Assert.assertEquals("62", rc_String);
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toString();
    Assert.assertEquals("0E-2147483647", rc_String);
  }
  public void testItem_0374()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("62")).plus();
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0380()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\0', '\234', '8', '\234', '8', '8', '\234', '\234', '\1', '8', '\1', '\1', '\234', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '8', '8', '\1', '8', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\uFFFF', '8', '8', '8', '\uFFFF', '8', '\0', '\234', '8', '\0', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '8', '\234', '\uFFFF', '\0', '8', '\1', '\0', '\1', '\1', '8', '8', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '8', '\0', '\234', '8', '\234', '\1', '\1', '\1', '\234', '8', '\0', '\0', '\0', '\234', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\234', '\234', '\234', '\0', '\1', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("65.77181208053692%", true, caught);
  }
  public void testItem_0384()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0385()
  {
    rc_byte = (new BigDecimal("62")).byteValueExact();
    Assert.assertEquals(62, rc_byte);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '\1', '\1', '\234', '\uFFFF', '8', '8', '8', '\234', '\0', '\234', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\uFFFF', '\234', '\0', '\234', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\0', '8', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\234', '\234', '\uFFFF', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("65.77181208053692%", true, caught);
  }
  public void testItem_0389()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0390()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0391()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("62")).add(new BigDecimal("62"));
    Assert.assertEquals("124", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_int = (new BigDecimal("62")).compareTo(new BigDecimal("3E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0394()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("66.10738255033557%", true, caught);
  }
  public void testItem_0395()
  {
    rc_int = (new BigDecimal("62")).compareTo(new BigDecimal("124"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0396()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_BigDecimal = (new BigDecimal("124")).pow(0, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_long = (new BigDecimal("124")).longValueExact();
    Assert.assertEquals(124L, rc_long);
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).divide(new BigDecimal("-2E+9"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_long = (new BigDecimal("124")).longValueExact();
    Assert.assertEquals(124L, rc_long);
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2E+9"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_int = (new BigDecimal("-2E+9")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\234', '\1', '\234', '\1', '8', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '8', '\234', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\1', '\234', '\0', '\0', '\uFFFF', '8', '8', '\0', '\1', '\0', '8', '8', '\uFFFF', '\234', '\1', '\0', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("67.78523489932886%", true, caught);
  }
  public void testItem_0408()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0409()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_byte = (new BigDecimal("0E+1")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
//  public void testItem_0414()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("68.79194630872483%", true, caught);
//  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("-2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0416()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-2E+9"));
  }
  public void testItem_0417()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\1', '\0', '\0', '\1', '8', '\234', '\234', '8', '\1', '8', '\0', '8', '\1', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\234', '\234', '\uFFFF', '8', '\0', '\0', '\234', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\1', '8', '\1', '8', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\0', '8', '\234', '\1', '\234', '8', '\0', '\0', '\uFFFF', '\0', '\234', '\0', '\234', '\1', '\0', '\0', '\0'}, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("68.79194630872483%", true, caught);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("-2E+9"));
    Assert.assertEquals("-5E+2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).divideToIntegralValue(new BigDecimal("-2000000000.0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("-2E+9"));
    Assert.assertEquals("-5E+2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("69.46308724832215%", true, caught);
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483647")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0426()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_int = (new BigDecimal("1E+2147483647")).compareTo(new BigDecimal("1"));
//    Assert.assertEquals(-1, rc_int);
//    }
//  }
  public void testItem_0427()
  {
    rc_int = (new BigDecimal("-2E+9")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0428()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).remainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("69.46308724832215%", true, caught);
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("70.13422818791946%", true, caught);
  }
  public void testItem_0431()
  {
    rc_int = (new BigDecimal("-5E+2147483637")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0432()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2E+9")).subtract(new BigDecimal("-5E+2147483637"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("70.13422818791946%", true, caught);
//  }
  public void testItem_0433()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-5E+2147483637")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("70.80536912751678%", true, caught);
  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\1', '\0', '8', '\0', '\0', '8', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\0', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '\1', '\234', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '8', '\0', '8', '\0', '\234', '\234', '\234', '\0', '8', '\0', '\234', '\1', '8', '\234', '8', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '\234', '\1', '8', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '8', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("70.80536912751678%", true, caught);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = (new BigDecimal("-5E+2147483637")).stripTrailingZeros();
    Assert.assertEquals("-5E+2147483637", rc_BigDecimal.toString());
  }
//  public void testItem_0436()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).divideToIntegralValue(new BigDecimal("-2E+9"));
//    Assert.assertEquals("0E+2147483638", rc_BigDecimal.toString());
//  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\uFFFF'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("71.47651006711409%", true, caught);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).negate();
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).setScale(1, 0);
    Assert.assertEquals("-2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("3>?IHSD=20LA6QWSV6C6U201J6K3:E<JJDNMU<9H>K4:QHSH56MV3G4:EB3TX7<NP=P@Q?JX0Q443PF@V=FEFNH4@0;HU<LTC17P", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("71.81208053691275%", true, caught);
  }
  public void testItem_0444()
  {
    rc_float = (new BigDecimal("-2E+9")).floatValue();
    Assert.assertEquals(-2.0E9F, rc_float, 0);
  }
  public void testItem_0445()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-2000000000.0"));
    Assert.assertEquals("-2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VR93BXC2WL=B7BCIL1BS@8SX", new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("71.81208053691275%", true, caught);
  }
//  public void testItem_0449()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("3.2E-2147483646")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("71.81208053691275%", true, caught);
//    }
//  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).divideToIntegralValue(new BigDecimal("2E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0451()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("71.81208053691275%", true, caught);
//    }
//  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("71.81208053691275%", true, caught);
  }
//  public void testItem_0455()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3E+1")).hashCode();
//    Assert.assertEquals(-94, rc_int);
//  }
  public void testItem_0456()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0457()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("-3E+1"));
    Assert.assertEquals("9E+2", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigInteger();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0460()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).multiply(new BigDecimal("9E+2"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0461()
  {
    rc_String = (new BigDecimal("-3E+1")).toString();
    Assert.assertEquals("-3E+1", rc_String);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("9E+2")).multiply(new BigDecimal("-3E+1"));
    Assert.assertEquals("-2.7E+4", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0465()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("73.15436241610739%", true, caught);
  }
  public void testItem_0468()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0469()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E+1")).divideAndRemainder(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
  public void testItem_0470()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigIntegerExact();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_long = (new BigDecimal("-2.7E+4")).longValue();
    Assert.assertEquals(-27000L, rc_long);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0, 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-2.7E+4")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("73.48993288590604%", true, caught);
  }
  public void testItem_0477()
  {
    rc_BigDecimal = (new BigDecimal("-2.7E+4")).pow(1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0478()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0479()
  {
    rc_short = (new BigDecimal("-3E+4")).shortValueExact();
    Assert.assertEquals(-30000, rc_short);
  }
  public void testItem_0480()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("-3E+4")).divide(new BigDecimal("-3E+1"));
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E+1")).divideAndRemainder(new BigDecimal("1E+3"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0484()
  {
    rc_boolean = (new BigDecimal("-2.7E+4")).equals("IT6MVDCEJ1K4P94>P=B@SGA0WJNGQ1S1>@G=RT4D6BX?=292OACOGR>L3IM@Y7:@:S7V29IKP5MM57102:LKMQEK:KRXNNVID1>5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.49664429530202%", true, caught);
  }
  public void testItem_0486()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("1E+3")).multiply(new BigDecimal("-3E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_int = (new BigDecimal("-2.7E+4")).intValueExact();
    Assert.assertEquals(-27000, rc_int);
  }
  public void testItem_0489()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0490()
  {
    rc_BigInteger = (new BigDecimal("-2.7E+4")).toBigInteger();
    Assert.assertEquals("-27000", rc_BigInteger.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("-2.7E+4")).ulp();
    Assert.assertEquals("1E+3", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).remainder(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0493()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_BigDecimal = (new BigDecimal("-2.7E+4")).min(new BigDecimal("-3E+2"));
    Assert.assertEquals("-2.7E+4", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).multiply(new BigDecimal("-3E+2"));
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0498()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2.7E+4")).divideToIntegralValue(new BigDecimal("-3E+2"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("74.83221476510067%", true, caught);
//    }
//  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).add(new BigDecimal("-2.7E+4"));
    Assert.assertEquals("-2.7E+4", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigInteger = (new BigDecimal("-2.7E+4")).toBigIntegerExact();
    Assert.assertEquals("-27000", rc_BigInteger.toString());
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("-2.7E+4")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+4", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E=<JXB5Y3BG<I", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0503()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).toBigIntegerExact();
    Assert.assertEquals("-30", rc_BigInteger.toString());
  }
  public void testItem_0504()
  {
    rc_int = (new BigDecimal("-3E+1")).intValue();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0505()
  {
    rc_int = (new BigDecimal("0E+3")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0506()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CIABV5DJMXGU>C@YCL5:DA<2EMDBV4G24?;<IPOTLAF4TNCMQ5CFYACA2LXSUUOABDS?X3?SBV95H54KCR6;:YHL5TNP2OHR0L>G");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0508()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0509()
  {
    rc_int = (new BigDecimal("-3E+1")).intValueExact();
    Assert.assertEquals(-30, rc_int);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("0E+3")).max(new BigDecimal("-2.7E+4"));
    Assert.assertEquals("0E+3", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0512()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    rc_int = (new BigDecimal("0E+3")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0514()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  public void testItem_0515()
  {
    rc_int = (new BigDecimal("-2.7E+4")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0516()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";7CACIKL3689EV67K5YTBIBYU05R", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0517()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775808")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0519()
  {
    rc_String = (new BigDecimal("0E+3")).toEngineeringString();
    Assert.assertEquals("0E+3", rc_String);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).scaleByPowerOfTen(0);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("1024")).movePointRight(1);
    Assert.assertEquals("10240", rc_BigDecimal.toString());
  }
  public void testItem_0522()
  {
    rc_BigInteger = (new BigDecimal("-3E+1")).unscaledValue();
    Assert.assertEquals("-3", rc_BigInteger.toString());
  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("10240"));
    Assert.assertEquals("-10270", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("1024")).scaleByPowerOfTen(1);
    Assert.assertEquals("1.024E+4", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1024")).scaleByPowerOfTen(-1);
    Assert.assertEquals("102.4", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divideToIntegralValue(new BigDecimal("1024"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("1024"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1E+16", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divideToIntegralValue(new BigDecimal("102.4"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).stripTrailingZeros();
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_int = (new BigDecimal("-3E+1")).compareTo(new BigDecimal("-3E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0533()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0534()
  {
    rc_BigDecimal_array = (new BigDecimal("-3E+1")).divideAndRemainder(new BigDecimal("-9223372036854775808"));
  }
  public void testItem_0535()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-3E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0536()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0537()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0539()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_String = (new BigDecimal("1024")).toEngineeringString();
    Assert.assertEquals("1024", rc_String);
  }
  public void testItem_0542()
  {
    rc_BigDecimal_array = (new BigDecimal("1024")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\uFFFF', '\0', '\0', '\1', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '8', '\0', '\0', '8', '\234', '\0', '8', '\1', '\234', '\234', '\234', '\0', '8', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\1', '\1', '\1', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("74.83221476510067%", true, caught);
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("1024")).plus();
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).setScale(-1);
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0549()
  {
    rc_BigInteger = (new BigDecimal("1024")).toBigIntegerExact();
    Assert.assertEquals("1024", rc_BigInteger.toString());
  }
  public void testItem_0550()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).negate(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0553()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0555()
  {
    rc_boolean = (new BigDecimal("-3E+1")).equals("4DU3@><T:@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("75.16778523489933%", true, caught);
  }
  public void testItem_0559()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0560()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).movePointRight(-1);
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.03", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0564()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-3E+1")).hashCode();
//    Assert.assertEquals(-94, rc_int);
//  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-3E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_double = (new BigDecimal("3E+1")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
  public void testItem_0567()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("75.50335570469798%", true, caught);
  }
  public void testItem_0568()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.03")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("75.50335570469798%", true, caught);
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("75.50335570469798%", true, caught);
  }
  public void testItem_0571()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("75.50335570469798%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-3E+1"));
    Assert.assertEquals("62", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigIntegerExact();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0576()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("62")).remainder(new BigDecimal("32"));
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).movePointRight(2147483647);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0582()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0583()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("76.1744966442953%", true, caught);
//    }
//  }
  public void testItem_0584()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).multiply(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("-6.8719476736E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_int = (new BigDecimal("3.2E-2147483645")).scale();
    Assert.assertEquals(2147483646, rc_int);
  }
  public void testItem_0588()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0589()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483645")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0590()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-6.8719476736E-2147483637")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0592()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(0);
    Assert.assertEquals("30", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0594()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("6:HRDI<?4;B00E>D94JG8CXQ1?T1KVQGF@24UP3QQQESIM46B@KUN0;RFQ9EEB=V5<L5F6X:D;DID:2FEQMXIK;>OYO>1<L2WNIE");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0595()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\1', '\uFFFF', '\234', '8', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\234', '8', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\234', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\234', '\234', '8', '\234', '8', '\1', '\0', '\234', '\uFFFF', '\234', '8', '\1', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0596()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0597()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1E+19", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0599()
  {
    rc_float = (new BigDecimal("-6.8719476736E-2147483637")).floatValue();
    Assert.assertEquals(-0.0F, rc_float, 0);
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    rc_BigDecimal = (new BigDecimal("-6.8719476736E-2147483637")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).max(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("-1E+19"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9999999997852516352", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    rc_BigDecimal = (new BigDecimal("9999999997852516352")).subtract(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("19223372034707292160", rc_BigDecimal.toString());
  }
  public void testItem_0607()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("Q4VO<1DBIFGLNQ6PRICJN@>10H?N6QYA5J5TYQGNIV6GUUUAAV24O");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("19223372034707292160")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_String = (new BigDecimal("-6.8719476736E-2147483637")).toPlainString();
    }
    catch (java.lang.NegativeArraySizeException e) {
      caught = true;
    }
    catch (java.lang.OutOfMemoryError e) {
    	if (e.getMessage().contains("too large")) {
    		caught = true;
    	}
    }
    Assert.assertEquals("76.1744966442953%", true, caught);
  }
  public void testItem_0610()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0611()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-6.8719476736E-2147483637")).subtract(new BigDecimal("-1E+19"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.51006711409396%", true, caught);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).multiply(new BigDecimal("-1E+19"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1E+38", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_int = (new BigDecimal("-1E+19")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0614()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("76.51006711409396%", true, caught);
  }
//  public void testItem_0615()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1E+19"), 2147483647, java.math.RoundingMode.HALF_UP);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("76.84563758389261%", true, caught);
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0618()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WT2EUNO19XR=WA7JDB<OL;U9TESY27JCW5JY4K1JY0UT;=9X?VL0Q5Q7GJR?J8GL8Y?DY9SKTGC1E3IQP;LJT?QN@3IRF93:8;P1", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("76.84563758389261%", true, caught);
  }
  public void testItem_0619()
  {
    rc_BigDecimal = (new BigDecimal("1E+38")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("9223372036854775807"));
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("-1E+19")).movePointRight(-2147483648);
    Assert.assertEquals("-1E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_int = (new BigDecimal("0E-1074")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, -2147483648, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("77.51677852348993%", true, caught);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).max(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = (new BigDecimal("0E-1074")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0635()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("77.85234899328859%", true, caught);
//  }
  public void testItem_0636()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0637()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).add(new BigDecimal("1"));
    Assert.assertEquals("2000000001", rc_BigDecimal.toString());
  }
  public void testItem_0640()
  {
    rc_BigInteger = (new BigDecimal("2000000001")).toBigInteger();
    Assert.assertEquals("2000000001", rc_BigInteger.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("2000000001"));
    Assert.assertEquals("2000000001", rc_BigDecimal.toString());
  }
//  public void testItem_0642()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2000000001")).hashCode();
//    Assert.assertEquals(1870457887, rc_int);
//  }
  public void testItem_0643()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("2E+9"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0646()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '8', '\1', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\0', '\0', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0649()
  {
    rc_int = (new BigDecimal("2000000001")).intValue();
    Assert.assertEquals(2000000001, rc_int);
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("2000000001")).negate();
    Assert.assertEquals("-2000000001", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).abs();
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0653()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-2000000001"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0656()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = (new BigDecimal("2000000001")).scaleByPowerOfTen(0);
    Assert.assertEquals("2000000001", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("2000000001")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\234', '\1', '\1', '8', '8', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '8', '\234', '\0', '\0', '\0', '\1', '8', '8', '\0', '\uFFFF', '8', '\0', '\234', '8', '\0', '8', '\0', '\0', '\1', '\0', '8', '\0', '\234', '\0', '\234', '\234', '\234', '8', '\1', '\uFFFF', '\0', '\1', '\0', '\0', '\1', '\1', '\1', '8', '8', '8', '\234', '\1', '8', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '8', '8', '\1', '\0', '8', '\1', '8', '8', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '8', '\1', '\1', '\uFFFF'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("77.85234899328859%", true, caught);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("-2000000001")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("2000000001")).hashCode();
//    Assert.assertEquals(1870457887, rc_int);
//  }
//  public void testItem_0663()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2000000001")).divide(new BigDecimal("-2000000001"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("77.85234899328859%", true, caught);
//  }
  public void testItem_0664()
  {
    rc_String = (new BigDecimal("2000000001")).toPlainString();
    Assert.assertEquals("2000000001", rc_String);
  }
  public void testItem_0665()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0666()
  {
    rc_int = (new BigDecimal("-2000000001")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0667()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("-2000000001")).subtract(new BigDecimal("2000000001"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-4000000002", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_BigDecimal = (new BigDecimal("-2000000001")).add(new BigDecimal("-4000000002"));
    Assert.assertEquals("-6000000003", rc_BigDecimal.toString());
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2000000001"), 0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("-2000000001")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2000000001", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("78.18791946308725%", true, caught);
  }
  public void testItem_0673()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0674()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("3"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0677()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("78.18791946308725%", true, caught);
  }
  public void testItem_0678()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    rc_int = (new BigDecimal("-2000000001")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0680()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("3WV9RE2K0TB23HVF>GKLMD>PDFN8G?@U@KXN8CSVP2M=2=OTK?4E>2MK0EM0@@4MRFFX:2X70MEJ;C6T1EDVF?TSJ3<C5YICOG@0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("78.18791946308725%", true, caught);
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0689()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0690()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("79.19463087248322%", true, caught);
  }
  public void testItem_0691()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("79.19463087248322%", true, caught);
  }
  public void testItem_0692()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0694()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0695()
  {
    rc_BigDecimal = (new BigDecimal("-2000000001")).stripTrailingZeros();
    Assert.assertEquals("-2000000001", rc_BigDecimal.toString());
  }
  public void testItem_0696()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0697()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0698()
  {
    rc_BigInteger = (new BigDecimal("-2000000001")).toBigInteger();
    Assert.assertEquals("-2000000001", rc_BigInteger.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0701()
  {
    rc_boolean = (new BigDecimal("-1")).equals("17TP906MY3KYG;832F00X2UECC8P9EJ;NC;86;862S574?8DWR=M?<@U1B@=DA6J?>BETML11EXFUH9MOC8E=O0E5=93G5GC:I6Q");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\234', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '8', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '\uFFFF', '8', '8', '\1', '\0', '\234', '\234', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.53020134228188%", true, caught);
  }
  public void testItem_0705()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).stripTrailingZeros();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0710()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).movePointLeft(-1);
    Assert.assertEquals("-20000000000", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("-20000000000")).movePointLeft(2147483647);
    Assert.assertEquals("-2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\0', '\234', '\234', '8', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '\0', '\1', '8', '8', '\0', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '8', '8', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '8', '\0', '8', '\234', '\1', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\0', '8'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0714()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000000000E-2147483637")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000000000E-2147483637")).abs();
    Assert.assertEquals("2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("LK>I?6LSYWMEL5002ABO6XG>S7QALRATC>C3G=U4SU0BAC1GH;?N:D6HA@J1U=5W7VF1AI<;XQUK3KS3@03VK3S478E7EWH@>U3<");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0721()
  {
    rc_int = (new BigDecimal("-2.0000000000E-2147483637")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).multiply(new BigDecimal("-2E+9"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("-4E-2147483628", rc_BigDecimal.toString());
  }
//  public void testItem_0723()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//  }
  public void testItem_0724()
  {
    rc_String = (new BigDecimal("2.0000000000E-2147483637")).toEngineeringString();
    Assert.assertEquals("2.0000000000E-2147483637", rc_String);
  }
  public void testItem_0725()
  {
    rc_BigDecimal_array = (new BigDecimal("-2.0000000000E-2147483637")).divideAndRemainder(new BigDecimal("-4E-2147483628"), new MathContext("precision=1 roundingMode=FLOOR"));
  }
//  public void testItem_0726()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).subtract(new BigDecimal("-1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//  }
  public void testItem_0727()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0728()
  {
    rc_int = (new BigDecimal("-2.0000000000E-2147483637")).precision();
    Assert.assertEquals(11, rc_int);
  }
//  public void testItem_0729()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).divide(new BigDecimal("-2E+9"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//    }
//  }
  public void testItem_0730()
  {
    rc_int = (new BigDecimal("-2.0000000000E-2147483637")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("-4E-2147483628")).plus();
    Assert.assertEquals("-4E-2147483628", rc_BigDecimal.toString());
  }
//  public void testItem_0732()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-2.0000000000E-2147483637")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//    }
//  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2.0000000000E-2147483637")).divide(new BigDecimal("2.0000000000E-2147483637"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
//  public void testItem_0734()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '8', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\234', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\1', '\0', '\0', '8', '\1', '8', '\0', '\234', '\1', '\1', '\0', '\uFFFF', '\234', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\234', '\0', '8', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\0', '8', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '8', '\0', '\1', '8', '\uFFFF', '\1', '\234', '\0', '\uFFFF'}, 1, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//  }
//  public void testItem_0735()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2.0000000000E-2147483637"), java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//  }
  public void testItem_0736()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '\0', '8', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\0', '8', '\234', '8', '\234', '\uFFFF', '\0', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '\234', '\1', '\1', '\1', '\0', '\234', '\234', '\234', '\0', '8', '8', '\0', '\uFFFF', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\234', '\0', '\234', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\0', '\0', '\1', '\1', '\1', '8', '\0', '\uFFFF', '\0', '\0', '\234'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0737()
  {
    rc_int = (new BigDecimal("2.0000000000E-2147483637")).compareTo(new BigDecimal("-2E+9"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0738()
  {
    rc_BigInteger = (new BigDecimal("-2E+9")).unscaledValue();
    Assert.assertEquals("-2", rc_BigInteger.toString());
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).max(new BigDecimal("2.0000000000E-2147483637"));
    Assert.assertEquals("2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("-4E-2147483628"), 2147483647, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
//  public void testItem_0742()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("2.0000000000E-2147483637")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//    }
//  }
  public void testItem_0743()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\234', '\1', '\234', '\0', '\234', '\uFFFF', '\1', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '\234', '\234', '8', '\uFFFF', '8', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '8', '8', '\0', '8', '\0', '8', '\1', '\234', '8', '\0', '8', '8', '8', '\234', '\uFFFF', '\0', '8', '\0', '\234', '\234', '\1', '8', '\234', '\0', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\1', '8', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0744()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("2.0000000000E-2147483637"));
    Assert.assertEquals("2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0747()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-4E-2147483628")).remainder(new BigDecimal("2.0000000000E-2147483637"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("79.86577181208054%", true, caught);
//    }
//  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-4E-2147483628")).divide(new BigDecimal("-4E-2147483628"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("79.86577181208054%", true, caught);
  }
  public void testItem_0751()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0752()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0753()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0754()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
//  public void testItem_0755()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("80.53691275167785%", true, caught);
//  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("2.0000000000E-2147483637")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("-2.0000000000E-2147483637")).subtract(new BigDecimal("-2.0000000000E-2147483637"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\0', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\0', '\234', '\0', '8', '\234', '\1', '\0', '\234', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\0', '\234', '\1', '8', '\1', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '8', '\0', '8', '\0', '\234', '8', '\234', '\0', '\uFFFF', '\1', '\234', '\234', '\234', '\1', '\234', '\0', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\0'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("80.53691275167785%", true, caught);
  }
  public void testItem_0760()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0762()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-2.0000000000E-2147483637"));
    Assert.assertEquals("-2.0000000000E-2147483637", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0765()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0E-2147483647"), java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("80.87248322147651%", true, caught);
//    }
//  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).max(new BigDecimal("-2.0000000000E-2147483637"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("GMGLP99IXEE:PXX;TY5Y8@;7CGYIJ9N2VUA>4DQ2R:5YMNGU?QJJPSJB9I9H8Q78T1DK8HC=WF2Y51RQ1FG;K6N8P<M?84JY5C7G");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0770()
  {
    rc_boolean = (new BigDecimal("1")).equals("92;;DA=BG:8XDX5FC90VX>JTG;UJ=:012U4?WI?G;QQ2;CV:IS?A=I@<W27748QMW><=8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  public void testItem_0772()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-2.0000000000E-2147483637")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-2.0000000000E-2147483637")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  public void testItem_0774()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0780()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0781()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0782()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_int = (new BigDecimal("3E+1")).intValueExact();
    Assert.assertEquals(30, rc_int);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  public void testItem_0787()
  {
    rc_double = (new BigDecimal("3E+1")).doubleValue();
    Assert.assertEquals(30.0, rc_double, 0);
  }
//  public void testItem_0788()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3E+1")).hashCode();
//    Assert.assertEquals(92, rc_int);
//  }
  public void testItem_0789()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("80.87248322147651%", true, caught);
  }
  public void testItem_0792()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1024", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1024"));
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).stripTrailingZeros();
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_String = (new BigDecimal("-1024")).toPlainString();
    Assert.assertEquals("-1024", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0799()
  {
    rc_boolean = (new BigDecimal("-1024")).equals("QBRK9G<?EJM0LI9BK3ECJAIV;??4:@GYMWEHWEU1LN?5TMP1SXTMTHV92VYK>9J;;3YVWLP<G;SK5QG8FR18BI38B;D>IL0;V79N");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0800()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).stripTrailingZeros();
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0801()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '\234', '\234', '8', '\0', '\234', '\234', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '\0', '\234', '\1', '\1', '8', '\1', '\uFFFF', '\1', '8', '8', '\1', '\0', '8', '\0', '\234', '8', '8', '8', '\234', '\234', '\0', '\234', '\1', '\234', '\uFFFF', '\1', '\234', '\0', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\234', '8', '8', '\1', '\0', '\1', '\1', '\1', '\0', '\234', '\1', '\1', '\234', '8', '\uFFFF', '\0', '8', '8', '\0', '\234', '\0', '\0'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1024")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("-1024")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0807()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("-9E+18")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9000000000000000001", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("-9E+18"));
  }
//  public void testItem_0814()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-9000000000000000001")).hashCode();
//    Assert.assertEquals(-1257805935, rc_int);
//  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("-9000000000000000001")).movePointRight(1);
    Assert.assertEquals("-90000000000000000010", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_double = (new BigDecimal("-9000000000000000001")).doubleValue();
    Assert.assertEquals(-9.0E18, rc_double, 0);
  }
  public void testItem_0818()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '\1', '\0', '\234', '\1', '\0', '\234', '\1', '8', '\0', '\234', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\234', '\0', '\0', '\1', '\1', '\1', '\234', '\1', '\234', '8', '8', '\1', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\uFFFF', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '8', '8', '\1', '\234', '\234', '8', '8', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\0', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '\0', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '8'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
  public void testItem_0820()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-90000000000000000010")).hashCode();
//    Assert.assertEquals(306715686, rc_int);
//  }
  public void testItem_0822()
  {
    rc_BigDecimal = (new BigDecimal("-9000000000000000001")).divideToIntegralValue(new BigDecimal("-90000000000000000010"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0823()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0824()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\234', '\0', '\0', '\0', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\234', '\234', '\0', '\0', '8', '\uFFFF', '8', '8', '\1', '\234', '\0', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '8', '\1', '\234', '\0', '\234', '\234', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\1', '\234', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '\0', '8', '\1', '\1', '\0', '8', '\234', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\234', '\1'}, 1, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TIA@S4>>:BC>8A=TO025>1?R5QSDHJI4=RL?PN?:7X0RMWDT>1U:@E4NL7DFB35U@RXRVHDX3T:XQSJDL0NYGA?;FQAXHLJCK4?Q");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("81.20805369127517%", true, caught);
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(1);
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("-1024", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).remainder(new BigDecimal("-1024"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0835()
  {
    rc_BigInteger = (new BigDecimal("32.0")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0836()
  {
    rc_long = (new BigDecimal("32.0")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0837()
  {
    rc_boolean = (new BigDecimal("0")).equals(";:NPGK1R8LY9801Y;>VX0QY947XHIWVKVV659?=5OT0TVR<T");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0838()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = (new BigDecimal("32.0")).abs();
    Assert.assertEquals("32.0", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_String = (new BigDecimal("0E+1")).toEngineeringString();
    Assert.assertEquals("0.00E+3", rc_String);
  }
  public void testItem_0843()
  {
    rc_int = (new BigDecimal("-1024")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0844()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0850()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0852()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\1', '\1', '\234', '\1', '\0', '\234', '\uFFFF', '\0', '8', '\1', '\234', '8', '\1', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '\234', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\0', '\0', '\1', '\1', '\1', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\1', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.21476510067114%", true, caught);
  }
  public void testItem_0856()
  {
    rc_byte = (new BigDecimal("32")).byteValueExact();
    Assert.assertEquals(32, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0857()
  {
    rc_boolean = (new BigDecimal("1")).equals("CNF6NCND57E0QCPSSAV3;S5;:ERJ30;R93J?E>FQT18<07X6IMA:M95:HQ=YWPBLFQE;KPULJC=2WBU?X1L57F:VS138A43PB4VO");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0858()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("82.21476510067114%", true, caught);
//  }
  public void testItem_0859()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0863()
  {
    rc_boolean = (new BigDecimal("1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("3E+1"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("82.5503355704698%", true, caught);
  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\0', '8', '\0', '\234', '\1', '8', '\0', '\0', '\234', '\0', '8', '8', '8', '\0', '8', '\1', '\uFFFF', '8', '8', '\1', '\1', '\234', '\234', '\234', '\234', '\234', '8', '8', '8', '\234', '8', '\uFFFF', '\1', '\1', '8', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '8', '\0', '\0', '8', '\234', '\0', '\234', '\uFFFF', '8', '\234', '\1', '\1', '\0', '\uFFFF', '8', '\0', '8', '8', '\0', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '8', '\0', '\0', '\234', '\234', '\1', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\234', '8', '\1', '\234', '\uFFFF'}, -1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.5503355704698%", true, caught);
  }
  public void testItem_0868()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    rc_String = (new BigDecimal("3E+1")).toString();
    Assert.assertEquals("3E+1", rc_String);
  }
  public void testItem_0871()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
//  public void testItem_0875()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("82.88590604026845%", true, caught);
//  }
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
      rc_BigDecimal = new BigDecimal("=REHI=??UINV6Q<TT:<>UD0SJL<CMWY?8P@=OT48OTBYNNOIYOAOXS=", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
//  public void testItem_0878()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("82.88590604026845%", true, caught);
//    }
//  }
  public void testItem_0879()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("T1E<548Y:1VI;0?@X3MP6P3209FDMFRY0=0A@6<G=9CBEGLG>=YU=YVVGJ<S>@VPKGJJV@LFTX:MWN34MP>4EQW?P1<IRI>LN5XB");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0880()
  {
    rc_float = (new BigDecimal("3.2E-2147483646")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0882()
  {
    rc_boolean = (new BigDecimal("1")).equals("E@IIIN0VUH8:H8K<@RS5WDHO28;B6=T??:7H15XLXXU6J98SK9NY<OD36=3298:MYR9B:8MU0GGC4BJOTX");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0883()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0884()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("3E+1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0885()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\234', '\1', '8', '\234', '\uFFFF', '\1', '\0', '\1', '8', '8', '\0', '\0', '8', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '8', '\234', '8', '\0', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '8', '\234', '\0', '\234', '8', '\0', '\uFFFF', '8', '\234', '8', '\1', '8', '\0', '\234', '\uFFFF', '\1', '\0', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '\0', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '\234', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0890()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0892()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), 2147483647, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("82.88590604026845%", true, caught);
//  }
  public void testItem_0893()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_String = (new BigDecimal("3E+1")).toEngineeringString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).min(new BigDecimal("1135879015891"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).setScale(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\1', '\234', '\0', '8', '\234', '\234', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '8', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '8', '\234', '8', '\234', '\234', '\234', '\uFFFF', '\1', '\1', '\1', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\0', '\0', '\234', '\0', '\uFFFF', '\234', '8', '8', '\1', '\234', '\1', '\0', '\234', '\uFFFF', '8', '\0', '\1', '\0', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\0', '8', '8', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\0'}, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).pow(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0902()
  {
    rc_String = (new BigDecimal("3.2")).toString();
    Assert.assertEquals("3.2", rc_String);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">NDQ:3LOQK6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '8', '\uFFFF', '\0', '\0', '\1', '8', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\234', '\0', '\234', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\0', '8', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '8', '\234', '\1', '8', '\1', '8', '8', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '\0', '\0', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\0', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("2")).pow(1);
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("2")).divide(new BigDecimal("-2147483647"), 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0913()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("2")).negate();
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0917()
  {
    rc_boolean = (new BigDecimal("0")).equals("@UG2DTQQ");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("2")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("2")).movePointLeft(1);
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal_array = (new BigDecimal("-2")).divideAndRemainder(new BigDecimal("2"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("-2")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0926()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("82.88590604026845%", true, caught);
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("-2")).negate();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0929()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2147483648")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0930()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.22147651006712%", true, caught);
  }
  public void testItem_0931()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.22147651006712%", true, caught);
  }
  public void testItem_0932()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("2")).movePointRight(-1);
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.22147651006712%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_long = (new BigDecimal("2")).longValueExact();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\234', '\234', '\1', '\0', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\0', '\uFFFF', '\1', '8', '\0', '\234', '\1', '\1', '\1', '\1', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\1', '\0', '\234', '8', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\1', '\0', '\234', '\1', '8', '\1', '\234', '\0', '\234', '8', '\1', '\0', '8', '\1', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '\234', '\234', '\1', '\234', '\1', '\0', '8', '\uFFFF', '8', '8', '8', '\234', '\1', '\1', '\234', '8', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\1', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\234'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=FLOOR"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.22147651006712%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("2")).add(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0946()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).stripTrailingZeros();
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).scaleByPowerOfTen(0);
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.2")).divide(new BigDecimal("0.2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0950()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("-0.2")).min(new BigDecimal("32"));
    Assert.assertEquals("-0.2", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_String = (new BigDecimal("-0.2")).toString();
    Assert.assertEquals("-0.2", rc_String);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.2")).pow(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("0.2")).abs(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0.2", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_double = (new BigDecimal("-0.2")).doubleValue();
    Assert.assertEquals(-0.2, rc_double, 0);
  }
  public void testItem_0957()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-0.2")).divide(new BigDecimal("-0.2"), 2147483647, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0958()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("2147483648")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0959()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0960()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0961()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '8', '\0', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '8', '\234', '\0', '\234', '\234', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '8', '\0', '\1', '\0', '\1', '\234', '8', '\1', '\uFFFF', '\0', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '8', '\1', '\1', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0962()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.2")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 1, 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
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
      rc_int = (new BigDecimal("2147483648")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-295147905179352825856", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=FLOOR"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).multiply(new BigDecimal("3E+2"));
    Assert.assertEquals("9E+4", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, 0);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("9E+4")).multiply(new BigDecimal("32"));
    Assert.assertEquals("2.88E+6", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.55704697986577%", true, caught);
  }
  public void testItem_0975()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("9E+4")).divide(new BigDecimal("2.88E+6"), java.math.RoundingMode.UP);
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0978()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.88E+6")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("83.89261744966443%", true, caught);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = (new BigDecimal("-295147905179352825856")).plus();
    Assert.assertEquals("-295147905179352825856", rc_BigDecimal.toString());
  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("2.88E+6"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("83.89261744966443%", true, caught);
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("9E+4"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2.88E+6", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("83.89261744966443%", true, caught);
  }
  public void testItem_0984()
  {
    rc_BigDecimal = (new BigDecimal("2.88E+6")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0985()
  {
    rc_BigInteger = (new BigDecimal("2.88E+6")).toBigIntegerExact();
    Assert.assertEquals("2880000", rc_BigInteger.toString());
  }
  public void testItem_0986()
  {
    rc_String = (new BigDecimal("9E+4")).toPlainString();
    Assert.assertEquals("90000", rc_String);
  }
  public void testItem_0987()
  {
    rc_int = (new BigDecimal("2.88E+6")).intValue();
    Assert.assertEquals(2880000, rc_int);
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("9E+4")).divide(new BigDecimal("32"), 0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("2812", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("2.88E+6")).subtract(new BigDecimal("2812"));
    Assert.assertEquals("2877188", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0990()
  {
    rc_boolean = (new BigDecimal("32")).equals("O=I:WIXT1AO3R4X6=I??7;0VH:D?<M:?OM0DF1AMX<LGQ?=1?O@?V<PP3F48R2KMQ@4@E;>MR1D5PB0A3");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0991()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    rc_BigDecimal = (new BigDecimal("2877188")).movePointLeft(-1);
    Assert.assertEquals("28771880", rc_BigDecimal.toString());
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("9E+4")).divideToIntegralValue(new BigDecimal("9E+4"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\234', '\234', '\234', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\0', '\1', '8', '\234', '\234', '\0', '\234', '\234', '8', '\234', '8', '8', '8', '\234', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\1', '\0', '\1', '8', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\0', '8', '\uFFFF', '8', '8', '\1', '8', '\234', '\234', '\1', '\uFFFF', '\1', '8', '8', '\1', '\0', '\234', '\1', '\1', '8', '8', '\uFFFF', '\234'}, 1, 0, new MathContext("precision=2147483647 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.89261744966443%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("28771880")).divide(new BigDecimal("32"), 1, 1);
    Assert.assertEquals("899121.2", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\uFFFF', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("83.89261744966443%", true, caught);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
}
