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
public class TestSuite005 extends TestCase
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
  
  public TestSuite005() {
	
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\234', '\1', '\1', '\234', '\234', '8', '\0', '\234', '\1', '\234', '\234', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\234', '\uFFFF', '\234', '\0', '\234', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\0', '\1', '\234', '8', '\0', '\234', '\1', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\1', '8', '\1', '\1', '\1', '\0', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '8', '\1', '\0', '8', '\1', '\0', '8', '\234', '8', '8', '8'}, 1, 0, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-3.2E-2147483646"), 1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0002()
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
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("32"));
    Assert.assertEquals("35496219246.59375", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_String = (new BigDecimal("35496219246.59375")).toPlainString();
    Assert.assertEquals("35496219246.59375", rc_String);
  }
  public void testItem_0005()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0008()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0009()
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
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-3.2E-2147483646"));
    Assert.assertEquals("-1.024E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0012()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).remainder(new BigDecimal("-3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0013()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
//  public void testItem_0014()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-3.2E-2147483646")).subtract(new BigDecimal("32"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Y00NK5I0F;GF<S851P4LJ7@KE526=1MVGQW28L1N5U:8>BR>@26W8383QI9YNIB3FNCGQ2PT7E", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0016()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("U9UI7N0<=>J6EW2<99:V<V>;H>=UGUEF:LTLC?L;Y0H2F:6L=QU", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0019()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\uFFFF', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\1', '8', '\0', '\234', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0020()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.024E-2147483644")).divide(new BigDecimal("35496219246.59375"), 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
//  public void testItem_0021()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.024E-2147483644")).subtract(new BigDecimal("35496219246.59375"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0022()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("35496219246.59375")).stripTrailingZeros();
    Assert.assertEquals("35496219246.59375", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("35496219246.59375")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0025()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0026()
  {
    rc_String = (new BigDecimal("35496219246.59375")).toPlainString();
    Assert.assertEquals("35496219246.59375", rc_String);
  }
  public void testItem_0027()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("35496219246.59375")).multiply(new BigDecimal("35496219246.59375"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1259981580802252568870.9775390625", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("35496219246.59375")).pow(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("-1.024E-2147483644")).movePointLeft(-2147483648);
    Assert.assertEquals("-10240", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("-1.024E-2147483644")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '8', '\0', '\234', '\uFFFF', '8', '\234', '\234', '\1', '8', '\1', '\uFFFF', '\234', '8', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '8', '8', '\234', '8', '\234', '\1', '\1', '8', '\234', '\1', '\234', '\234', '8', '\0', '\1', '\0', '\0', '\0', '\1', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\0', '\1', '8', '\0', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\234'}, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("-10240")).divideToIntegralValue(new BigDecimal("-10240"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("-1.024E-2147483644"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0039()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).multiply(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+2147483647")).pow(-1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0042()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.024E-2147483644")).divideToIntegralValue(new BigDecimal("-1.024E-2147483644"), new MathContext("precision=0 roundingMode=CEILING"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0043()
  {
    rc_int = (new BigDecimal("-10240")).compareTo(new BigDecimal("-1.024E-2147483644"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0044()
  {
    rc_BigDecimal = (new BigDecimal("-1.024E-2147483644")).subtract(new BigDecimal("-1.024E-2147483644"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
//  public void testItem_0046()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0047()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_long = (new BigDecimal("-10240")).longValue();
    Assert.assertEquals(-10240L, rc_long);
  }
  public void testItem_0050()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '8', '\0', '\0', '\234', '8', '\0', '\1', '8', '\234', '\0', '\0', '\234', '8', '\0', '8', '\1', '\uFFFF', '\0', '8', '8', '8', '\uFFFF', '8', '8', '8', '8', '\234', '\1', '\1', '\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\1', '\0', '\0', '\1', '\uFFFF', '8', '8', '\1', '8', '\1', '\0', '\0', '\1', '\234', '\1', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\uFFFF'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("FV@5J1H4OEW=Y:1>D=KT65FLNK2KPQF9", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0052()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0055()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0056()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("-10240"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0058()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, -2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0059()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\234', '\0', '\1', '\234', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\234', '\1', '8', '\0', '\1', '\0', '8', '\1', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '\1', '\234', '8', '\1', '\1', '\0', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\0', '\0', '8', '\uFFFF', '\234', '8', '8', '\1', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\1', '8', '\1', '\uFFFF', '8', '\0', '\234', '8', '8', '\0', '8', '8'}, 1, 0, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0060()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0061()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-10240"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("-10240"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0064()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("-10240"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("-10240"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-10240")).divide(new BigDecimal("-10240"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0067()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\uFFFF', '8', '8', '\0', '\234', '8', '\uFFFF', '8', '\1', '\234', '\0', '\0', '\234', '\1', '\1', '8', '\234', '\uFFFF', '8', '\0', '8', '\0', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\234', '8', '8', '8', '\uFFFF', '\0', '8', '8', '8', '8', '8', '\1', '\1', '8', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '8', '\uFFFF', '\1', '\uFFFF', '8', '8', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '8', '\uFFFF', '\uFFFF', '8', '\0', '\1', '\234', '\234', '8', '\0', '\0', '\0', '8', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\1', '8', '\1', '8', '\0'}, -1, 0, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("617GJ7AHUQ0IFDSYU6995XY79E<EO25H>N74DW9>PO<B6PFC2CT=0;A>JP==@GVVGI98TM@RHJP>3DAJJ");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0070()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0074()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0075()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0081()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("-10240")).divide(new BigDecimal("-10240"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0084()
  {
    rc_float = (new BigDecimal("-10240")).floatValue();
    Assert.assertEquals(-10240.0F, rc_float, 0);
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("H6UT1LY3AX>");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0086()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3.2")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0090()
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
//  public void testItem_0091()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"), -2147483648, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0092()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0099()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0100()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0101()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("NUJ2;S1DFD5I;=M9YF@;4;T0PNQ28BCRP0P1L5N@NV>N3CE?7W3QM<FLWDAQE0RV;A", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0102()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-10240")).hashCode();
//    Assert.assertEquals(-317440, rc_int);
//  }
//  public void testItem_0103()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-10240")).hashCode();
//    Assert.assertEquals(-317440, rc_int);
//  }
  public void testItem_0104()
  {
    rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0105()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigDecimal = (new BigDecimal("-10240")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1.0240E+5", rc_BigDecimal.toString());
  }
  public void testItem_0110()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0111()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    rc_int = (new BigDecimal("-10240")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0113()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0114()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0115()
  {
    rc_long = (new BigDecimal("2147483647")).longValueExact();
    Assert.assertEquals(2147483647L, rc_long);
  }
  public void testItem_0116()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("16V@H1=8ONV<GQ?@S7==J<R@2N=CHQ9:4MS?37>>1@:;I2:OETH7LCENKO0KH4JQ:7CTH3;@GA>2BO@<?EU4UXGXEH2V5H9LST;G");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0117()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0118()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("-1.0240E+5"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
  }
//  public void testItem_0119()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+1")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0120()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).negate(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0121()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0122()
  {
    rc_String = (new BigDecimal("-1.0240E+5")).toString();
    Assert.assertEquals("-1.0240E+5", rc_String);
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0240E+5")).pow(-2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0124()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0125()
  {
    rc_float = (new BigDecimal("-1.0240E+5")).floatValue();
    Assert.assertEquals(-102400.0F, rc_float, 0);
  }
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0127()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0128()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0131()
  {
    rc_boolean = (new BigDecimal("0")).equals("0R4UI5JQ98ELW;S76FEY20XAE:YJ?5GE4C6;30XG>H=:DH1Q67Q7NCE=C?TN61X7>6T95HFU93AAVQR:OSWE9ES:GP55S8HK0A2O");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0132()
  {
    rc_boolean = (new BigDecimal("2147483647")).equals("50K2JQS2FMTW76Y2E?=9JCOKYX8DHH>80>5H@I=BMDS@7NLXCX7J1HCQPA;BRUL239?4J2@=SJQ>8;AQ:@8<QUNQ4B7PKH<US<01");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0133()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0134()
  {
    rc_String = (new BigDecimal("-1.0240E+5")).toEngineeringString();
    Assert.assertEquals("-102.40E+3", rc_String);
  }
  public void testItem_0135()
  {
    rc_BigDecimal = (new BigDecimal("-1.0240E+5")).plus();
    Assert.assertEquals("-1.0240E+5", rc_BigDecimal.toString());
  }
  public void testItem_0136()
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
  public void testItem_0137()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_long = (new BigDecimal("-1.0240E+5")).longValueExact();
    Assert.assertEquals(-102400L, rc_long);
  }
  public void testItem_0140()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=0 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0141()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0143()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 0, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 1, 1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_BigDecimal = (new BigDecimal("-1.0240E+5")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-102399", rc_BigDecimal.toString());
  }
  public void testItem_0148()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0152()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=1 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0155()
  {
    rc_boolean = (new BigDecimal("-1.0240E+5")).equals("?>5;>:5A69QODBA6VS3SD>@;;KQHF8");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0156()
  {
    rc_int = (new BigDecimal("-1.0240E+5")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0157()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    rc_BigDecimal = (new BigDecimal("-1.0240E+5")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1.0240E+5", rc_BigDecimal.toString());
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("1.0240E+5")).subtract(new BigDecimal("32"));
    Assert.assertEquals("102368", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_BigDecimal = (new BigDecimal("1.0240E+5")).multiply(new BigDecimal("102368"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1.048248320E+10", rc_BigDecimal.toString());
  }
  public void testItem_0162()
  {
    rc_BigDecimal = (new BigDecimal("1.0240E+5")).multiply(new BigDecimal("1.0240E+5"));
    Assert.assertEquals("1.04857600E+10", rc_BigDecimal.toString());
  }
  public void testItem_0163()
  {
    rc_BigDecimal = (new BigDecimal("1.04857600E+10")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1.048576000E+10", rc_BigDecimal.toString());
  }
  public void testItem_0164()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1.04857600E+10")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("102368")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0167()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.048576000E+10")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_long = (new BigDecimal("1.04857600E+10")).longValue();
    Assert.assertEquals(10485760000L, rc_long);
  }
  public void testItem_0170()
  {
    rc_double = (new BigDecimal("1.04857600E+10")).doubleValue();
    Assert.assertEquals(1.048576E10, rc_double, 0);
  }
  public void testItem_0171()
  {
    rc_int = (new BigDecimal("1.04857600E+10")).precision();
    Assert.assertEquals(9, rc_int);
  }
  public void testItem_0172()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).setScale(1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("1.04857600E+10")).abs();
    Assert.assertEquals("1.04857600E+10", rc_BigDecimal.toString());
  }
//  public void testItem_0174()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0175()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("2E+308")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0178()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).abs();
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0179()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("2E+308"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0180()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0186()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0189()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0190()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0191()
  {
    rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0192()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0195()
  {
    rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("-32")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_BigDecimal = (new BigDecimal("31")).plus();
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0200()
  {
    rc_int = (new BigDecimal("-32")).intValueExact();
    Assert.assertEquals(-32, rc_int);
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("-33")).min(new BigDecimal("31"));
    Assert.assertEquals("-33", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("31"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal_array = (new BigDecimal("31")).divideAndRemainder(new BigDecimal("-32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
  }
  public void testItem_0205()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0207()
  {
    rc_int = (new BigDecimal("-32")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0208()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("31")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("-32")).subtract(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0211()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("31")).divide(new BigDecimal("0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'}, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0216()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("6J771VPHIA510P6HJ;6GIGU1Q>FOBS2S3R1O9<=8A229N9YV?K;W0L43MKJCXNAEFCB;1OHU3JOCXTDJSE62UD;28LEL3AIMFTFS");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0220()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("8")).stripTrailingZeros();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0223()
  {
    rc_boolean = (new BigDecimal("8")).equals("4XLID9G@1CBID@SYT6@CRG9?W7FJA9T20DFW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), 0, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0226()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0227()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("RP?EU>F>SOGYF8=AA6D9;1<WD66MYYK936V7?7TSEDX=>PQE@=L62ON9SSX38O5JDW=W7YGHXM9OXXOT?0K=8GGT@G=7RLTGIQ>8", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0228()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0229()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0230()
  {
    rc_BigDecimal_array = (new BigDecimal("8")).divideAndRemainder(new BigDecimal("0.1"));
  }
  public void testItem_0231()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("8"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = (new BigDecimal("8")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0239()
  {
    rc_BigDecimal = (new BigDecimal("8")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    rc_int = (new BigDecimal("8")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("8")).plus();
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0246()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0247()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\1', '8', '\1', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '8'}, -2147483648, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0252()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0253()
  {
    rc_int = (new BigDecimal("0.0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0254()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0255()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0260()
  {
    rc_short = (new BigDecimal("0.0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0261()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0262()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\uFFFF', '\1', '\0', '\0', '8', '\234', '\234', '\234', '\0', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\234', '\1', '\1', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\0', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0265()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0266()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0267()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0269()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0270()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0271()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0273()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0274()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("1"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0276()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\1', '\1', '\0', '\uFFFF', '\0', '\1', '\0', '\0', '\234', '\234', '\1', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '8', '8', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\234', '\1', '\234', '\0', '\234', '\1', '8', '\234', '\234', '\1', '\234', '\0', '8', '\uFFFF', '8', '8', '\1', '\0', '\234', '8', '8', '\234', '\0', '8', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\0', '8', '\1', '\0', '\0', '8', '\0', '\234', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\1', '8', '\0', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\234', '8', '\uFFFF', '8', '8', '\0', '\234', '\1', '8', '\uFFFF'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0277()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-2147483648);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0278()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("00.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0279()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0280()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0283()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("00.0E+2147483647")).toEngineeringString();
//    Assert.assertEquals("0.0E+2147483649", rc_String);
//  }
  public void testItem_0284()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0285()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0286()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(";6IE26?0EANPCU6>Q>TLXUEQBU>PUX0L2BM7NG698BWU<D049C3BI9P=S6YRW>?:7F:QNUN=X:BXLGI6YH3R3?YSSROMMO9", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0287()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0289()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("00.0E+2147483647")).hashCode();
//    Assert.assertEquals(-2147483648, rc_int);
//  }
  public void testItem_0290()
  {
    rc_float = (new BigDecimal("0.1")).floatValue();
    Assert.assertEquals(0.10000000149011612F, rc_float, 0);
  }
  public void testItem_0291()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0292()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0293()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0294()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("OTR3>W9N96X>29EPX56SIN5UGK?RKLGGHKJKK?6AB4AR>KP66A:7?D3=R1O;XYX9NQM8ACRS3>GAR@9H6J4EIJGMA<QN>YV@>FO>");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0295()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1"), java.math.RoundingMode.UNNECESSARY);
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0296()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).stripTrailingZeros();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
//  public void testItem_0297()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
//  public void testItem_0298()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("1"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0301()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.1"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0303()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("0.1")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0304()
  {
    rc_BigDecimal_array = (new BigDecimal("00.0E+2147483647")).divideAndRemainder(new BigDecimal("0.1"));
  }
  public void testItem_0305()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0307()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0308()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0309()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0311()
  {
    rc_String = (new BigDecimal("320")).toPlainString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0312()
  {
    rc_long = (new BigDecimal("0.1")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0313()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0314()
  {
    rc_String = (new BigDecimal("320")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0315()
  {
    rc_boolean = (new BigDecimal("-1")).equals("TPQNN9NMS57@;G0?;:6XMHX<>6B4OQYGBNHMPL9SK9OGI2MXL3Y36ETM<CH@KOCUV<BQC>=;Q1UDMW=>EK2B5OCH=76;=W>89=?6");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0316()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0317()
  {
    rc_String = (new BigDecimal("0.1")).toEngineeringString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("0.1"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0321()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0.1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0327()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).movePointLeft(2147483647);
    Assert.assertEquals("2.147483647E-2147483638", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).divide(new BigDecimal("2147483647"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).negate();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(">XPKV0W5T7>BRG2HOV", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0335()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0336()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0337()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0338()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0339()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
//  public void testItem_0342()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0343()
  {
    rc_BigDecimal = (new BigDecimal("-1")).min(new BigDecimal("-0.1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).subtract(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_int = (new BigDecimal("-1E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0346()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("-32")).min(new BigDecimal("1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0349()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("-32"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).add(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0351()
  {
    rc_short = (new BigDecimal("-1E+1")).shortValueExact();
    Assert.assertEquals(-10, rc_short);
  }
  public void testItem_0352()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0356()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).add(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).plus();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0358()
  {
    rc_long = (new BigDecimal("-32")).longValue();
    Assert.assertEquals(-32L, rc_long);
  }
  public void testItem_0359()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=1 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0360()
  {
    rc_BigInteger = (new BigDecimal("-1E+1")).toBigInteger();
    Assert.assertEquals("-10", rc_BigInteger.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("33", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("J?X0WN>0GQK9F5R:VKOW4GK6090=J3KY3KLS;6Q:S9AY;G98;@56DK@E4QB>RNH8NQ?MKOPB8AFC?:EN:4PH7", new MathContext("precision=1 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0364()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_int = (new BigDecimal("2E+1")).compareTo(new BigDecimal("33"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_BigDecimal = (new BigDecimal("33")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0369()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0370()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0371()
  {
    rc_int = (new BigDecimal("-1E+1")).intValueExact();
    Assert.assertEquals(-10, rc_int);
  }
  public void testItem_0372()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).stripTrailingZeros();
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).negate();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).remainder(new BigDecimal("-1E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("-1E+1"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0379()
  {
    rc_int = (new BigDecimal("-2E+2")).intValueExact();
    Assert.assertEquals(-200, rc_int);
  }
  public void testItem_0380()
  {
    rc_long = (new BigDecimal("-1E+1")).longValueExact();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0381()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0382()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '8', '\234', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '\1', '\234', '8', '\1', '\1', '\234', '8', '\234', '\234', '\0', '\1', '\234', '\0', '8', '8', '8', '\234', '\1', '\0', '\1', '8', '\0', '\0', '\1', '\1', '\234', '\0', '\234', '8', '\uFFFF', '8', '\1', '8', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\0', '\234', '\0', '\1', '\0', '\1', '\234', '\0', '\234', '\234', '\234', '8', '\234', '\1', '\1', '8', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).multiply(new BigDecimal("1E+1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_String = (new BigDecimal("-2E+2")).toPlainString();
    Assert.assertEquals("-200", rc_String);
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("-2E+2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0387()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+1")).setScale(-2147483648);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0388()
  {
    rc_int = (new BigDecimal("-2E+2")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0389()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("-1E+1"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0390()
  {
    rc_String = (new BigDecimal("-1E+1")).toEngineeringString();
    Assert.assertEquals("-10", rc_String);
  }
  public void testItem_0391()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("20", rc_BigDecimal.toString());
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).divide(new BigDecimal("20"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0394()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).movePointLeft(1);
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0395()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0396()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0397()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).subtract(new BigDecimal("20"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0398()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0399()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0400()
  {
    rc_BigDecimal = (new BigDecimal("20")).divideToIntegralValue(new BigDecimal("2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).negate();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).movePointLeft(0);
    if (JavaSpecVersionChecker.isJDKWithin13And19()) {
    	 Assert.assertEquals("1E+1", rc_BigDecimal.toString());
    } else {
    	 Assert.assertEquals("10", rc_BigDecimal.toString());
    }
  }
  public void testItem_0403()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0406()
  {
    rc_double = (new BigDecimal("1E+1")).doubleValue();
    Assert.assertEquals(10.0, rc_double, 0);
  }
  public void testItem_0407()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0408()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("10"));
    Assert.assertEquals("-11", rc_BigDecimal.toString());
  }
  public void testItem_0409()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0410()
  {
    rc_BigDecimal_array = (new BigDecimal("10")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0411()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0'}, 1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0412()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("10")).setScale(-1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("10")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
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
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0418()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0420()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0421()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("-1"));
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("-11")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("-11", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0424()
  {
    rc_boolean = (new BigDecimal("-11")).equals("253FW");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-11")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0428()
  {
    rc_BigInteger = (new BigDecimal("3.2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0429()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("3.2")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).negate(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0431()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("PGLI@RM2A078AMADRKD47ACBU@1LGMYVCGENCK1GRDQTIO>2J", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0432()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-11")).hashCode();
//    Assert.assertEquals(-341, rc_int);
//  }
//  public void testItem_0433()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
//  public void testItem_0434()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-11")).hashCode();
//    Assert.assertEquals(-341, rc_int);
//  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\0', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\1', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\1', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '8', '\234', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\1', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '8', '\1', '\0', '\234', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\0', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '8', '\uFFFF', '\0', '\234', '\0', '\1', '\1', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\1', '\234', '\1'}, -2147483648, -1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0436()
  {
    rc_BigDecimal = (new BigDecimal("-11")).divideToIntegralValue(new BigDecimal("-11"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2")).setScale(0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0438()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0440()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).max(new BigDecimal("1"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0446()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0447()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '8', '8', '\0', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\1', '\1', '\234', '\234', '\234', '\234', '\1', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\1', '\234', '8', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\234', '\234', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\1', '\0', '\234', '\0', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF'}, 0, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0448()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0449()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\uFFFF', '8', '\1', '\234', '8', '\234', '\0', '8', '\0', '\1', '8', '\0', '\234', '\0', '\0', '8', '\234', '\0', '\1', '\234', '\234', '\0', '\1', '8', '\uFFFF', '8', '8', '\1', '8', '8', '\uFFFF', '\1', '8', '8', '\234', '\uFFFF', '\234', '8', '8', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '8', '\1', '8', '8', '\0', '8', '\0', '\0', '\1', '8', '\234', '\uFFFF', '8', '\234', '\1', '8', '\1', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '8', '\0', '8', '8', '\uFFFF', '\234', '\234', '\0', '\234', '8', '8', '8', '\1', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '8', '8', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\0', '\234', '8', '\0', '\1', '\0', '\uFFFF', '8', '8', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '8', '8', '\1', '8', '\0', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\1', '\234', '\234', '\0', '\234', '8', '\0', '\0', '\234', '8', '\234', '\234', '\1', '\234', '\uFFFF', '\1', '\0', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0452()
  {
    rc_int = (new BigDecimal("-3.2")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0453()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<G4L=CKLS2>8@<=S8BHEB6?W?B6J:RPC;AXYVA1C2?I0N3MKFJYK2P<WU463GAP2F4JIIDUDKN0@BO@V3>WYF8NIUH>DDBRQ0HKS");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("3.2")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0455()
  {
    rc_long = (new BigDecimal("-3.2")).longValue();
    Assert.assertEquals(-3L, rc_long);
  }
  public void testItem_0456()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("2.2", rc_BigDecimal.toString());
  }
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("2.2")).negate();
    Assert.assertEquals("-2.2", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toPlainString();
    Assert.assertEquals("0.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_String);
  }
  public void testItem_0461()
  {
    rc_int = (new BigDecimal("2.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0462()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0463()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2P<EHTAP:7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0464()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322", rc_BigDecimal.toString());
  }
  public void testItem_0465()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322")).remainder(new BigDecimal("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0468()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0E-1074"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0E-1074"));
    Assert.assertEquals("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322")).pow(-1, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0472()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0473()
  {
    rc_int = (new BigDecimal("1.58101006669198894136502013717830839156819136836583924616187418400216162326466800596895947635723517561534900702542629673896530147313900734847607934723450201000416228220899649448910661493711674273180389963538239593831376002043970929140795003939991487127414276844810148923327383720396340989174728530738139765819852659299399978222486909277585705377746094208360793641507199853418236610905733300263847922287318084712569650993676355696043137128477911046201288579427439734506631259032106743066637821954956252590667777923392368197433912098506952874186535932959440791384844029671931988994712902519503030385076704575125686962724021137638372208156515246433211607621352030586796471475167797273918117254582484386888935768561426087330801237840205430984497070312500000E-322")).compareTo(new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0474()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("36385714125121573300846800698456749842842774431060269030973563199251835202763131874220510446199752578146168959525535975504123660741259730559491535919078220069839241298744801305292878640835527930863994674357611588999020693594474762898847930291552594690170203187215045688094955660773922576137969830342611860225019935582199601121469249223149872466121371567155862303084330314602566069416432551333006194774477514260351201969859368060220131234488198148976536169638305696900504838830719760875514246216508976803882728582677352177004129288847854463084006372981390756344519549931097743963603971632334891836831978686870043355177324550146752512", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0476()
  {
    rc_boolean = (new BigDecimal("32")).equals("55AHF;BD3LTK");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0477()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0478()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_BigDecimal = (new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).abs();
    Assert.assertEquals("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("0E-1074"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("32"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0484()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0485()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0486()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\uFFFF', '\0', '\0', '8', '\234', '8', '\1', '8', '8', '\uFFFF', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\0', '\1', '8', '\0', '\234', '\234', '\234', '\0', '\234', '8', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '8', '\234', '\234', '\1', '\0', '\uFFFF', '\0', '\0', '8', '8', '\uFFFF', '\1', '8', '8', '8', '\uFFFF', '8', '\1', '\1', '\1', '\uFFFF', '8', '\0', '8', '8', '\234', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '8', '\234', '\234'}, 0, 2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0487()
  {
    rc_int = (new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).compareTo(new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0488()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("-32")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E-322", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
//  public void testItem_0492()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).movePointRight(2147483647);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
//  public void testItem_0493()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-31")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0494()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0495()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0497()
  {
    rc_boolean = (new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0501()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\1', '\234', '\uFFFF', '\234', '\234', '8', '8', '\0', '8', '\1', '\1', '\234', '\uFFFF', '\234', '8', '\234', '\1', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '8', '\234', '\234', '\0', '\234', '\234', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\1', '\234', '8', '\234', '\0', '8', '\uFFFF', '\1', '\234', '8', '\0', '\1', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '8'}, -1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0502()
  {
    rc_int = (new BigDecimal("-31")).intValueExact();
    Assert.assertEquals(-31, rc_int);
  }
  public void testItem_0503()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
//  public void testItem_0504()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("-31")).add(new BigDecimal("-1"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\234', '\234', '\1', '\1', '\0', '8', '\0', '\234', '\1', '\234', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '8', '\0', '\0', '\uFFFF', '\0', '\234', '8', '8', '\0', '\0', '\0', '8', '8', '\0', '8', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\234', '\1', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '8', '\uFFFF', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '8', '\1', '8', '8', '\0', '\uFFFF', '8', '8', '\uFFFF', '\1', '\0', '\234', '\1', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0508()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0509()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("C382N>10EBOMI@MOVD8;OC:4V57K8I:UWF4AAYQ<;O14EWDTECUEVLYHLN37IRB94<=BIR<HK<A1VY5X130FS02=BION:Q=IY3YL");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0510()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0511()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).setScale(0, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).abs();
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0520()
  {
    rc_int = (new BigDecimal("-1")).intValueExact();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0521()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
//  public void testItem_0522()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0523()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0527()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0528()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0532()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0533()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0534()
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
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0536()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\1', '\1', '\uFFFF', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\0', '\234', '\234', '\1', '\0', '\uFFFF', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\0', '\234', '\1', '\234', '\1', '\1', '\1', '8', '8', '\1', '\234', '\234', '8', '\0', '8', '\1', '\1', '\234', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\0', '8', '8', '8', '\234', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '8', '\uFFFF', '8', '8', '8', '\1', '\0', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0537()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("1"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("-3E+1"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-30", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0543()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0544()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0548()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(">Q22@3XUHX68WDE<0I5=CMGLYM>R;LI@TGFDM3BN<AU2XFQ:P5XE4LVF>W9QX=XUC;Y;:7=J>CMRY5EIU1CXILLEW?X0ISUSSF>U");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("0.1"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0552()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\1', '8', '\234', '\0', '\1', '8', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '\1', '\1', '\234', '8', '\uFFFF', '\1', '\1', '\234', '8', '\234', '8', '\234', '\uFFFF', '8', '8', '\1', '\234', '\234', '8', '\uFFFF', '\234', '\1', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '8', '\1', '\1', '\1', '\1', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '8', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '8', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0553()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0554()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0557()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("?EWJU45DXM;R?K26M3MDI0QC0ENJ@R2V3XIO=3C:>4T0TG?RDB5FJBYE>20=5E2?YBXL7RR2QO=@24:N27@H;BQRWD<8IEL<XNRO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0559()
  {
    rc_int = (new BigDecimal("-3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0560()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_String = (new BigDecimal("-2147483648")).toEngineeringString();
    Assert.assertEquals("-2147483648", rc_String);
  }
  public void testItem_0564()
  {
    rc_BigDecimal_array = (new BigDecimal("0.1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0567()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).stripTrailingZeros();
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0569()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-2147483648"), 2147483647, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0570()
  {
    rc_byte = (new BigDecimal("0E+2147483647")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0571()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0572()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0573()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ICY>E8SCS11Q162IK:UT?@9@9@EP7UL;F<;4FAMG8I5TS@B4RF2D?T0S7@=ASN;8?2YYU");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0574()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0575()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("-2147483648"), -2147483648, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0576()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).stripTrailingZeros();
	Assert.assertEquals(0E+2147483647, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0577()
  {
    rc_int = (new BigDecimal("0E+2147483647")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0578()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\1', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '8', '\1', '\234', '8', '\0', '\uFFFF', '\0', '\1', '8', '\234', '8', '\1', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '8', '8', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '8', '\1', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\1', '\1', '\1', '\0', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\0', '8', '\0'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).pow(1);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0580()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0E+2147483647"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0581()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0582()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0583()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0585()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E+2147483647")).divide(new BigDecimal("-2147483648"), 0, 1);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0586()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0E+2147483647"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483647")).plus();
    Assert.assertEquals("0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0592()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).remainder(new BigDecimal("0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("-2147483648"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0594()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0595()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0596()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0599()
  {
    rc_String = (new BigDecimal("2E+9")).toPlainString();
    Assert.assertEquals("2000000000", rc_String);
  }
  public void testItem_0600()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0601()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_String = (new BigDecimal("320.0E+2147483647")).toPlainString();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("O;;SECDV0WUV2AXB9IGPFQ<A6MV>S49X:AMN4V7CF<RF0X5O4?TNBTJMUWFW8VPCD1AD4XKK:80JNKR>DAC>YGN2S53:6S35ORQD");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).remainder(new BigDecimal("-2E+9"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
//  public void testItem_0606()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).abs();
//    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0607()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0608()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("2.147483647E+10", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0611()
  {
    rc_boolean = (new BigDecimal("-2E+9")).equals("LLW<RS8O2GA74P7TJ62M4OSX5GNO7X2D72XUKE<AAXYC1WPI7?3@P7M6>=RTYO");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0612()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E+10")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("2.147483647E+2147483657", rc_BigDecimal.toString());
  }
  public void testItem_0613()
  {
    rc_int = (new BigDecimal("-2E+9")).intValueExact();
    Assert.assertEquals(-2000000000, rc_int);
  }
  public void testItem_0614()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).remainder(new BigDecimal("2.147483647E+10"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0615()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2E+9")).remainder(new BigDecimal("0E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("21474836470.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("-2E+9")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    rc_long = (new BigDecimal("-2E+9")).longValue();
    Assert.assertEquals(-2000000000L, rc_long);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).pow(-2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0622()
//  {
//    boolean caught;
//    rc_BigInteger = (new BigDecimal("21474836470.0E+2147483647")).unscaledValue();
//    Assert.assertEquals("2147483647", rc_BigInteger.toString());
//  }
  public void testItem_0623()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.147483647E+10")).divide(new BigDecimal("3.2E-2147483646"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0624()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0625()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("2.147483647E+10"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).scaleByPowerOfTen(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).plus();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).abs();
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\1', '\234', '\0', '\0', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\1', '\0', '8', '8', '8', '\0', '\234', '\0', '8', '8', '8', '\uFFFF', '\234', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0631()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0632()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0633()
  {
    rc_long = (new BigDecimal("0.0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0634()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"), -2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("-2E+9"));
    Assert.assertEquals("-567.000000000", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E+10")).subtract(new BigDecimal("0"));
    Assert.assertEquals("21474836470", rc_BigDecimal.toString());
  }
  public void testItem_0638()
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
  public void testItem_0639()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0640()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.147483647E+10")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\234', '\1', '\1', '\234', '\uFFFF', '\0', '\234', '\0', '\0', '\0', '\234', '\1', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '8', '8', '8', '\1', '8', '\0', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\1', '\0', '8', '\0', '8', '\1', '\1', '8', '8', '8', '\uFFFF', '\0', '8', '8', '\1', '8', '\1', '\1', '\1', '\1', '\0', '\0', '8', '8', '8', '\1', '\234', '8', '\0', '\0', '\0'}, 0, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("21474836470"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E+1", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = (new BigDecimal("21474836470")).add(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+12", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("1E+12")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    rc_BigDecimal = (new BigDecimal("5E+1")).multiply(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+13", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("2.147483647E+10")).subtract(new BigDecimal("6E+13"));
    Assert.assertEquals("-5.997852516353E+13", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\0', '\234', '\0', '\1', '\234', '\0', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\0', '8', '\234', '\234', '\234', '\1', '\1', '\1', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0649()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).scaleByPowerOfTen(1);
    Assert.assertEquals("1.135879015891E+13", rc_BigDecimal.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1.135879015891E+13"));
    Assert.assertEquals("1.290221138741506630523881E+25", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).movePointLeft(1);
    Assert.assertEquals("113587901589.1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    rc_BigDecimal = (new BigDecimal("-5.997852516353E+13")).plus();
    Assert.assertEquals("-5.997852516353E+13", rc_BigDecimal.toString());
  }
//  public void testItem_0653()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6E+13")).hashCode();
//    Assert.assertEquals(173, rc_int);
//  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1.135879015891E+13"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.290221138741506630523881E+25", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal = (new BigDecimal("5E+1")).stripTrailingZeros();
    Assert.assertEquals("5E+1", rc_BigDecimal.toString());
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("5E+1"));
    Assert.assertEquals("5.679395079455E+13", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_BigInteger = (new BigDecimal("6E+13")).toBigInteger();
    Assert.assertEquals("60000000000000", rc_BigInteger.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("6E+13")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+13", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0659()
  {
    rc_boolean = (new BigDecimal("5.679395079455E+13")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0660()
  {
    rc_BigDecimal_array = (new BigDecimal("5E+1")).divideAndRemainder(new BigDecimal("1135879015891"));
  }
  public void testItem_0661()
  {
    rc_double = (new BigDecimal("1.290221138741506630523881E+25")).doubleValue();
    Assert.assertEquals(1.2902211387415066E25, rc_double, 0);
  }
  public void testItem_0662()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).negate();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("6E+13")).divideToIntegralValue(new BigDecimal("6E+13"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    rc_String = (new BigDecimal("1.290221138741506630523881E+25")).toPlainString();
    Assert.assertEquals("12902211387415066305238810", rc_String);
  }
  public void testItem_0665()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1135879015891")).divide(new BigDecimal("1135879015891"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0667()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("6E+13")).hashCode();
//    Assert.assertEquals(173, rc_int);
//  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("1.290221138741506630523881E+25")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1.290221138741506630523881E+25", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    rc_String = (new BigDecimal("1.290221138741506630523881E+25")).toString();
    Assert.assertEquals("1.290221138741506630523881E+25", rc_String);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).plus();
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_int = (new BigDecimal("6E+13")).scale();
    Assert.assertEquals(-13, rc_int);
  }
//  public void testItem_0672()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0673()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0675()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0677()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0678()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1135879015891")).hashCode();
//    Assert.assertEquals(-2107853717, rc_int);
//  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I3VHFIY8TRO:T36AACY2W50260A;EGFRN4X9:NHP4@16;CN68T0AVT07T8E1LY=8A19ROOP=LGBQMI2J;>JYE9UWBAC8BBQ9N5PS");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0680()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal_array = (new BigDecimal("1135879015891")).divideAndRemainder(new BigDecimal("-1135879015891"));
  }
  public void testItem_0683()
  {
    rc_String = (new BigDecimal("-1135879015891")).toString();
    Assert.assertEquals("-1135879015891", rc_String);
  }
  public void testItem_0684()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 0);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigInteger = (new BigDecimal("-1135879015891")).toBigIntegerExact();
    Assert.assertEquals("-1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("-1135879015891")).min(new BigDecimal("1"));
    Assert.assertEquals("-1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_float = (new BigDecimal("-1135879015891")).floatValue();
    Assert.assertEquals(-1.135878995968E12F, rc_float, 0);
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0695()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0696()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0697()
  {
    rc_double = (new BigDecimal("32")).doubleValue();
    Assert.assertEquals(32.0, rc_double, 0);
  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_float = (new BigDecimal("-1135879015891")).floatValue();
    Assert.assertEquals(-1.135878995968E12F, rc_float, 0);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0701()
  {
    rc_boolean = (new BigDecimal("-1135879015891")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0703()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
//  public void testItem_0705()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0706()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).divide(new BigDecimal("32"));
    Assert.assertEquals("288230376151711743.96875", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("288230376151711743.96875"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-9223372036854775807")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0717()
  {
    rc_int = (new BigDecimal("3E-2147483646")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0718()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0719()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9223372036854775807")).hashCode();
//    Assert.assertEquals(2147482656, rc_int);
//  }
  public void testItem_0720()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0722()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\0', '\1', '\1', '8', '\uFFFF', '\1', '\234', '8', '\234', '\0', '\234', '\234', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '8', '\uFFFF', '8', '\234', '8', '\0', '8', '8', '\1', '\uFFFF', '8', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\0', '\0', '\234', '\1', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '8', '8', '\1', '\234', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\234', '\0', '\234', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\1', '\1', '\234', '\0'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).min(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\0', '\234', '\234'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0725()
  {
    rc_float = (new BigDecimal("288230376151711743.96875")).floatValue();
    Assert.assertEquals(2.8823037615171174E17F, rc_float, 0);
  }
  public void testItem_0726()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).plus();
    Assert.assertEquals("-9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0728()
  {
    rc_BigDecimal_array = (new BigDecimal("0E-2147483646")).divideAndRemainder(new BigDecimal("3E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0729()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).setScale(0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0730()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775807")).divide(new BigDecimal("0E-2147483646"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).max(new BigDecimal("0E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).subtract(new BigDecimal("288230376151711743.96875"));
    Assert.assertEquals("8935141660703064063.03125", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '8', '8', '\1', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\234', '8', '8', '8', '\1', '\uFFFF', '\0', '\0', '8', '\0', '8', '\234', '\1', '8', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\1', '8', '8', '8', '\0', '\1', '\1', '8', '8', '\1', '\uFFFF', '\0', '\1', '\234', '8', '\234', '\0', '\1', '\234', '\0', '8', '\0', '\0', '\1', '\uFFFF', '8', '\1', '\1', '\0', '\uFFFF', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0734()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775807")).add(new BigDecimal("-9223372036854775807"));
    Assert.assertEquals("-18446744073709551614", rc_BigDecimal.toString());
  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("-9223372036854775807"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0736()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("3E-2147483646")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
//  public void testItem_0737()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).subtract(new BigDecimal("9223372036854775807"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("P1=6W0K@FC59E057==CQ?XD>=5=<<;S3<YB6O6O2;1>9Q<X7H:=>8I=9LIQO2911UU8YBX3ASXGISL:;9>I94QNMBF32=7M7ETFA", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0739()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointRight(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("3E-2147483646"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0744()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).setScale(0, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("3E-2147483646"), 1, 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).negate();
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0748()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).remainder(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-127", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).pow(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0754()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0755()
  {
    rc_int = (new BigDecimal("-214748364.7")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointRight(-1);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.7")).multiply(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0763()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("-214748364.7"), 0);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0766()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.7")).scaleByPowerOfTen(-1);
    Assert.assertEquals("-21474836.47", rc_BigDecimal.toString());
  }
  public void testItem_0767()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    rc_BigDecimal_array = (new BigDecimal("-21474836.47")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0769()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-21474836.47")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("-21474836.47"), java.math.RoundingMode.UP);
    Assert.assertEquals("100", rc_BigDecimal.toString());
  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.DOWN);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0776()
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
  public void testItem_0777()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=2147483647 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("100")).scaleByPowerOfTen(0);
    Assert.assertEquals("100", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    rc_BigDecimal = (new BigDecimal("100")).multiply(new BigDecimal("100"));
    Assert.assertEquals("10000", rc_BigDecimal.toString());
  }
  public void testItem_0780()
  {
    rc_BigDecimal = (new BigDecimal("-214748364.7")).movePointLeft(0);
    Assert.assertEquals("-214748364.7", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_int = (new BigDecimal("-2147483647")).precision();
    Assert.assertEquals(10, rc_int);
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("100"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = (new BigDecimal("100")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-100", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_int = (new BigDecimal("-214748364.7")).intValue();
    Assert.assertEquals(-214748364, rc_int);
  }
  public void testItem_0786()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("100")).divide(new BigDecimal("-100"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0787()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0788()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("H<@X5G7FYVX3=AVLU0YEC0IHRPP2<DGVT98W>>P=O>OKOLXK87WDI3Q207PQ:0BM>KUN<:TEGDAI8UU>XVV;5P2NCRSS?@Q90D2K");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0789()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0791()
  {
    rc_int = (new BigDecimal("100")).compareTo(new BigDecimal("-100"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0792()
  {
    rc_String = (new BigDecimal("10000")).toPlainString();
    Assert.assertEquals("10000", rc_String);
  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).divide(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-67108863.96875", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1JASEWENK@LAW98?C4=TBEUP65C7>M>VJ>=VPK0:W66R@@?X739CNL4Y0<IHKBQ7:<RKXGPW?9WGN5A", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("-67108863.96875")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("67108863.96875", rc_BigDecimal.toString());
  }
  public void testItem_0796()
  {
    rc_BigDecimal = (new BigDecimal("-67108863.96875")).divide(new BigDecimal("-67108863.96875"), -1, 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '8', '8', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\0', '\0', '8', '\1', '\0', '\1', '\uFFFF', '\234', '\1', '\1', '\234', '\0', '\1', '\1', '\1', '\uFFFF', '\1', '\1', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\234', '\0', '\0', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\0', '\0', '\1', '8', '\uFFFF', '\1', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\234', '8', '8', '\1', '\1', '\0', '8', '\0', '\uFFFF', '\234', '\0', '\1', '8', '\234', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0798()
  {
    rc_int = (new BigDecimal("10000")).intValue();
    Assert.assertEquals(10000, rc_int);
  }
  public void testItem_0799()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("67108863.96875")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0800()
  {
    rc_byte = (new BigDecimal("1E+1")).byteValueExact();
    Assert.assertEquals(10, rc_byte);
  }
  public void testItem_0801()
  {
    rc_BigDecimal = (new BigDecimal("67108863.96875")).abs();
    Assert.assertEquals("67108863.96875", rc_BigDecimal.toString());
  }
  public void testItem_0802()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10000")).divide(new BigDecimal("67108863.96875"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-67108863.96875")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0804()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0805()
  {
    rc_BigDecimal = (new BigDecimal("-67108863.96875")).subtract(new BigDecimal("-67108863.96875"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483647")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0807()
  {
    rc_long = (new BigDecimal("0.00000")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0808()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0809()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483647")).divideToIntegralValue(new BigDecimal("1E+1"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0810()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0811()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("67108863.96875"), -1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("2.67877151921306819900774665103400408689503662647776143515627863484309566198103544410313541086002975346023423595945093539308254507069727355581160404268875931680312215129507853544081292037538785794089345736962638028123092086153759397698727803100609461581317011934975220856693288234823871336330270497183E+300", rc_BigDecimal.toString());
  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("67108863.96875"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184057749504.03125", rc_BigDecimal.toString());
  }
  public void testItem_0813()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0814()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = (new BigDecimal("67108863.96875")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("67108863.96875", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigInteger = (new BigDecimal("67108863.96875")).toBigIntegerExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0818()
  {
    rc_String = (new BigDecimal("0.00000")).toString();
    Assert.assertEquals("0.00000", rc_String);
  }
  public void testItem_0819()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).multiply(new BigDecimal("-2147483647"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0820()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).divideToIntegralValue(new BigDecimal("-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0821()
  {
    rc_BigDecimal = (new BigDecimal("67108863.96875")).divide(new BigDecimal("-2147483647"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0822()
  {
    rc_short = (new BigDecimal("0.00000")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).ulp();
    Assert.assertEquals("0.00001", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_BigDecimal = (new BigDecimal("-2147483647")).setScale(0);
    Assert.assertEquals("-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("0.00001")).divideToIntegralValue(new BigDecimal("-2147483647"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).add(new BigDecimal("0.00000"));
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).subtract(new BigDecimal("0.00001"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-0.00001", rc_BigDecimal.toString());
  }
  public void testItem_0830()
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
  public void testItem_0831()
  {
    rc_BigDecimal = (new BigDecimal("0.00001")).max(new BigDecimal("-0.00001"));
    Assert.assertEquals("0.00001", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).add(new BigDecimal("-0.00001"));
    Assert.assertEquals("-0.00001", rc_BigDecimal.toString());
  }
  public void testItem_0833()
  {
    rc_String = (new BigDecimal("-0.00001")).toString();
    Assert.assertEquals("-0.00001", rc_String);
  }
//  public void testItem_0834()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-0.03125")).setScale(-2147483648, java.math.RoundingMode.FLOOR);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//    }
//  }
  public void testItem_0835()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).movePointLeft(0);
    Assert.assertEquals("-0.03125", rc_BigDecimal.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("-0.03125")).divide(new BigDecimal("-0.03125"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=A<31KP5D1TKHJC@8:TO=?;=<U;58=VXWMWX>>A1K>I9RVIHSV9H7PRY3I641;:0Y81>20UJJP6QHS4BE?UT=Q4;JL0I1M1H>MYL");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0838()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0839()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0840()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0.00001")).hashCode();
//    Assert.assertEquals(36, rc_int);
//  }
  public void testItem_0841()
  {
    rc_int = (new BigDecimal("32")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0842()
  {
    rc_BigDecimal = (new BigDecimal("0.00001")).divide(new BigDecimal("-0.03125"), 1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0843()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0844()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-0.1")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0845()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("0.00000"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0846()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).abs();
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0847()
  {
    rc_String = (new BigDecimal("-0.1")).toEngineeringString();
    Assert.assertEquals("-0.1", rc_String);
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("0.00000")).round(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("0.00000", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = (new BigDecimal("-0.1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_String = (new BigDecimal("0.00000")).toPlainString();
    Assert.assertEquals("0.00000", rc_String);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.00000"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0853()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0854()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0855()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0856()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.00000"), java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0857()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0858()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0859()
  {
    rc_BigInteger = (new BigDecimal("0.00000")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1L=DIT?SS801BIM2N5EQ;LAANMJUFKQ1U1=KU3GSDJ;7N:VN39:");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0863()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("-32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("-32")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\234', '8', '\234', '\0', '\234', '\1', '\0', '\234', '\1', '\0', '\1', '8', '\234', '\234', '8', '\uFFFF', '\0', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0867()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, 1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0868()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs(new MathContext("precision=2147483647 roundingMode=FLOOR"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0874()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("90.26845637583892%", true, caught);
//  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("2")).scaleByPowerOfTen(1);
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("2E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0879()
  {
    rc_boolean = (new BigDecimal("2")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0880()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0881()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+1")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0882()
  {
    rc_BigInteger = (new BigDecimal("2E+1")).unscaledValue();
    Assert.assertEquals("2", rc_BigInteger.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
  }
  public void testItem_0884()
  {
    rc_BigDecimal = (new BigDecimal("2")).plus();
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0885()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0889()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0890()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=2147483647 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0891()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0892()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0893()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0894()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0895()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0896()
  {
    rc_long = (new BigDecimal("2")).longValueExact();
    Assert.assertEquals(2L, rc_long);
  }
  public void testItem_0897()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("96", rc_BigDecimal.toString());
  }
  public void testItem_0898()
  {
    rc_BigDecimal = (new BigDecimal("64")).abs();
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0899()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0900()
  {
    rc_BigDecimal = (new BigDecimal("-32")).remainder(new BigDecimal("2"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0902()
  {
    rc_boolean = (new BigDecimal("-32")).equals("F@W>@BD0:JV90K;B82A9NJNWOT;W65L;H4R?J123?WS>N=>GJXL271JM9PWNS4DGUUX7DDY=EPSE51F:T@@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0903()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0906()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0907()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("2E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0908()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-32"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0910()
  {
    rc_BigInteger = (new BigDecimal("-32")).unscaledValue();
    Assert.assertEquals("-32", rc_BigInteger.toString());
  }
  public void testItem_0911()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\1', '8', '\0', '\0', '8', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '\234', '8', '\uFFFF', '\0', '\0', '8', '\1', '8', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0912()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0913()
  {
    rc_BigDecimal_array = (new BigDecimal("-32")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0914()
  {
    rc_String = (new BigDecimal("-32")).toEngineeringString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+9", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0917()
  {
    rc_boolean = (new BigDecimal("0")).equals("M2TP=TA2A8NH0MP1=FLVV>G?G:06VV:<O:8?O3LL94526O2R?=YJNMPE?:7D1J2PFVOD:8O5:R5T=5");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("2E+9"));
    Assert.assertEquals("-1999999999", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("0E+9")).ulp();
    Assert.assertEquals("1E+9", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0922()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0923()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("2E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("1E+9")).setScale(-1, java.math.RoundingMode.DOWN);
    Assert.assertEquals("1.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = (new BigDecimal("2E+9")).subtract(new BigDecimal("0"));
    Assert.assertEquals("2000000000", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0928()
  {
    rc_boolean = (new BigDecimal("0")).equals("PS;724PU7U;U628EST2OQU9U8ESEE?H7PNXUQ=JGNPVEE7B<:FQS=?NLTDGUUAV=B21MGXB1BQQMFMB5WDW7BOG<KSYCS3@OIEEF");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0929()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("2E+9"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2000000000", rc_BigDecimal.toString());
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000E+9")).scaleByPowerOfTen(0);
    Assert.assertEquals("1.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_int = (new BigDecimal("1.00000000E+9")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0932()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000E+9")).plus();
    Assert.assertEquals("1.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000E+9")).add(new BigDecimal("1.00000000E+9"));
    Assert.assertEquals("2.00000000E+9", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0936()
  {
    rc_BigDecimal = (new BigDecimal("1.00000000E+9")).setScale(1, 1);
    Assert.assertEquals("1000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1.00000000E+9"));
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2.00000000E+9")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0943()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0944()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0946()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0947()
  {
    rc_BigDecimal = (new BigDecimal("2.00000000E+9")).setScale(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0948()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("2.00000000E+9"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0949()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0950()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0951()
  {
    rc_BigDecimal_array = (new BigDecimal("2000000000.0")).divideAndRemainder(new BigDecimal("2000000000.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0952()
  {
    rc_BigDecimal = (new BigDecimal("2000000000.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = (new BigDecimal("2000000000.0")).movePointRight(0);
    Assert.assertEquals("2000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '8', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\234', '\1', '\234', '\uFFFF', '\234', '\1', '\234', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\0', '8', '\1', '\1', '\0', '\0', '8', '8', '8', '\1', '\0', '\0', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\1', '\234', '\1', '\234', '8', '\234', '\0', '\0', '\1', '8', '\0', '\0', '\1', '\0'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0955()
  {
    rc_String = (new BigDecimal("2.00000000E+9")).toEngineeringString();
    Assert.assertEquals("2.00000000E+9", rc_String);
  }
  public void testItem_0956()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0957()
  {
    rc_String = (new BigDecimal("2000000000.0")).toEngineeringString();
    Assert.assertEquals("2000000000.0", rc_String);
  }
  public void testItem_0958()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0959()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0960()
  {
    rc_BigDecimal = (new BigDecimal("2000000000.0")).remainder(new BigDecimal("2000000000.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("2.00000000E+9"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0965()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_int = (new BigDecimal("2.00000000E+9")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0969()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0971()
  {
    rc_BigInteger = (new BigDecimal("0.0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0975()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).compareTo(new BigDecimal("0.0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0976()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("0.0")).signum();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0979()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal_array = (new BigDecimal("320.0E+2147483647")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=UNNECESSARY"));
//    }
//  }
  public void testItem_0980()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0990()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("E5O12=FBC7QPEGW953BFHBOH;X8T");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  public void testItem_0992()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("90.26845637583892%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0993()
  {
    rc_boolean = (new BigDecimal("-1")).equals("?M:<O<;C0JTB:TS4=6YIE3Y2@A5YJDA0DY7DA8X66WB57<MD42KYMSKL<>3UXR7IL:S?YD?Y4379D26J7VAX7AQXPR@<DJXLJHV9");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647, 1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    rc_int = (new BigDecimal("1")).intValue();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0997()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0.0"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
}
