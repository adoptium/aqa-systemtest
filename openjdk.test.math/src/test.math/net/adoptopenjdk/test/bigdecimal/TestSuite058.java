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
public class TestSuite058 extends TestCase
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
  
  public TestSuite058() {
	
  }
  public void testItem_0000()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("L;EA<QGXCW:WSFIH4S?S29@8");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0001()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate();
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0002()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("-32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(1);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0012()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0013()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0014()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).pow(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0015()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0016()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0017()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0018()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=0 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0019()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0020()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+1")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0021()
  {
    rc_long = (new BigDecimal("3E+1")).longValue();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0022()
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
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DOWP7TFM2X;W@BHDB50<:G2>X91D?H?P;IRR87G>K55XMFKK8:KY6A?IGI@KKQUA2LBG2P=:Y1IX6E;QMKP0QFQKAL?D<05K9VQL", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).add(new BigDecimal("-1E+1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0028()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0033()
  {
    rc_BigInteger = (new BigDecimal("-2E+1")).toBigIntegerExact();
    Assert.assertEquals("-20", rc_BigInteger.toString());
  }
  public void testItem_0034()
  {
    rc_BigDecimal = (new BigDecimal("-1")).max(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
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
  public void testItem_0037()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0038()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("G8H?SMQJ@NWT6P=78712@S:JT1M4O0HVSBC8I1DV<IL4Y2F8FSNPOR<M6KP");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0039()
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
  public void testItem_0040()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0042()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0043()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0044()
  {
    rc_BigInteger = (new BigDecimal("-2E+1")).toBigInteger();
    Assert.assertEquals("-20", rc_BigInteger.toString());
  }
  public void testItem_0045()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"));
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0046()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=QBCE5<E424UR01;7FOT5M11:I461=>TWW@J=:0T<6ST73=<BQ2<MRAM<EA5B?E3GFFC9HHG1TNYDQ?:S=OXI8G>>UUP1228NX3B");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0049()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0050()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0051()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\0', '\0', '\0', '8', '\1', '8', '\0', '\uFFFF', '\0', '\1', '8', '\0', '8', '8', '\234', '\0', '\0', '\0', '8', '8', '\234', '8', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '8', '8', '8', '\1', '\1', '8', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '8', '\234', '\0', '8', '\234', '\1', '\0', '\234', '\0', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\1', '\234', '8', '\uFFFF', '\0', '\234', '\1', '8', '\0', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\0', '\1', '\uFFFF'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0052()
  {
    rc_int = (new BigDecimal("2")).intValueExact();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0053()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0054()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0055()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0056()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0057()
  {
    rc_BigDecimal = (new BigDecimal("2")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0058()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0060()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1")).hashCode();
//    Assert.assertEquals(-31, rc_int);
//  }
  public void testItem_0061()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0062()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0064()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = (new BigDecimal("2")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("2"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0069()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0070()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), 1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0071()
  {
    rc_long = (new BigDecimal("-1")).longValue();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0072()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0073()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0074()
  {
    rc_boolean = (new BigDecimal("0")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("2"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigDecimal = (new BigDecimal("2")).add(new BigDecimal("2"));
    Assert.assertEquals("4", rc_BigDecimal.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\0', '8', '\0', '\234', '\0', '\1', '\0', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '8', '8', '\234', '\uFFFF', '\0', '\0', '\234', '8', '8', '\234', '8', '\0', '\uFFFF', '\0', '\0', '\0', '\0', '\0', '\uFFFF', '\0', '\234', '\0', '8', '\uFFFF', '\234'}, 2147483647, 2147483647, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0079()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0080()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("4"));
  }
  public void testItem_0081()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0082()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0083()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0086()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0087()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0088()
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
  public void testItem_0089()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
//  public void testItem_0090()
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
  public void testItem_0091()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0092()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3.2E-2147483646")).divideAndRemainder(new BigDecimal("3.2E-2147483646"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0093()
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
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0094()
  {
    rc_boolean = (new BigDecimal("-1")).equals("W=JS9SR5G:XESA9I8MWEQIUDE9IC;MBJ0::EWKW08LQNJQAI5IEPYVLP>A3:TMJ3?W@N=:9IBQIP1?TT80BJ8OH;=A8M=BOCBCL<");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0095()
  {
    rc_boolean = (new BigDecimal("3.2E-2147483646")).equals("MU>M<8ANRI<MGPIAUO1<N30=WV52?0G?DK<>Y9FFOLH=N>I?8O:3SFBRS:6;EW:PLQ1");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0096()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("I2CNR?BIFA9?3UMJ9K5FUEXLMQ09HCLGUEMFJKRSD@BC>9WT4@F6<HJC0M6S:ST0Q4Q;TBXA<R6ABP51VSX<7E71NF3EGDYKVGVR");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
//  public void testItem_0099()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E-2147483646")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0100()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideToIntegralValue(new BigDecimal("3E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0101()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0104()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0105()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0106()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0107()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("YH59N6<FWOQ4UNX:YLL2545D7<N>CO5GDQ56<<G;L5TTNCM=@8F4CA7:HTKGY?T");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0108()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0109()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("1"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
//  public void testItem_0112()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0113()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0114()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).scale();
    Assert.assertEquals(2147483647, rc_int);
  }
//  public void testItem_0115()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0116()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus();
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0117()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("3.2E-2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0118()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("3.2E-2147483646")).intValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0119()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0120()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0121()
  {
    rc_BigDecimal = (new BigDecimal("-1")).multiply(new BigDecimal("-9223372036854775808"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("10")).movePointLeft(0);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0124()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0125()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("9E+18")).hashCode();
//    Assert.assertEquals(261, rc_int);
//  }
  public void testItem_0126()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-9223372036854775808"));
  }
  public void testItem_0127()
  {
    rc_byte = (new BigDecimal("10")).byteValueExact();
    Assert.assertEquals(10, rc_byte);
  }
  public void testItem_0128()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0129()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\234', '\234', '8', '\1', '8', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\0', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '\0', '\234', '\0', '\uFFFF', '\1', '\1', '\234', '\1', '\234', '\234', '\uFFFF', '\0', '\1', '8', '\0', '\uFFFF', '\0', '\1', '\1', '8', '\0', '8', '\1', '\234', '\0', '\1', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '8', '\0', '\1', '\234', '\0', '\1', '\234', '\234', '\234', '8', '\234', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '\234', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0130()
  {
    rc_boolean = (new BigDecimal("9E+18")).equals("?2R;L;2B85P867DNCOXF?K6FM977?3RKLV4AI7S@6<R?N5EVE>PKV86WKASU3US9UPA31>RA<I9DS>8BPI7QL<G:0F3MRI9GIPB4");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0131()
  {
    rc_short = (new BigDecimal("10")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0132()
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
  public void testItem_0133()
  {
    rc_BigDecimal_array = (new BigDecimal("9E+18")).divideAndRemainder(new BigDecimal("10"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0134()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("10"));
  }
  public void testItem_0135()
  {
    rc_float = (new BigDecimal("9E+18")).floatValue();
    Assert.assertEquals(9.0000002023581286E18F, rc_float, 0);
  }
  public void testItem_0136()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=;ILQNJKDTS7?03<;0>L6>AN:RYA2NJN:89?T06VP4UT:3KX30YN59=@:WGN55IQ5G0:GLUJ@5@B5Y>Q3UR@ENWG>7QB;N3=OGL1", new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0137()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("10")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).toBigIntegerExact();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0140()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0141()
  {
    rc_double = (new BigDecimal("9E+18")).doubleValue();
    Assert.assertEquals(9.0E18, rc_double, 0);
  }
  public void testItem_0142()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).plus(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("9E+18")).divideAndRemainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("3.2E-2147483646"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("2.88E-2147483627", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=FU80>?TWSTCX>4");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_BigDecimal = (new BigDecimal("2.88E-2147483627")).plus();
    Assert.assertEquals("2.88E-2147483627", rc_BigDecimal.toString());
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0152()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("WL?H9EDD7UGIS1DNLMTJ>=A>GS>>CG2;D<F20ESJX9R@@:TOTFW:HD273W6NJG9M?8A:?E5@TWD<E@G3IL7?D7FKH?IT?WNIV7XL");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0153()
  {
    rc_long = (new BigDecimal("3.2E+2")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0154()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).multiply(new BigDecimal("9E+18"));
    Assert.assertEquals("8.1E+37", rc_BigDecimal.toString());
  }
  public void testItem_0155()
  {
    rc_BigInteger = (new BigDecimal("2.88E-2147483627")).unscaledValue();
    Assert.assertEquals("288", rc_BigInteger.toString());
  }
  public void testItem_0156()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+37")).negate();
    Assert.assertEquals("-8.1E+37", rc_BigDecimal.toString());
  }
  public void testItem_0157()
  {
    rc_BigDecimal = (new BigDecimal("-8.1E+37")).multiply(new BigDecimal("2.88E-2147483627"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-2.3328E-2147483589", rc_BigDecimal.toString());
  }
  public void testItem_0158()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("8.1E+37"), 0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("8.1E+37")).divide(new BigDecimal("3.2E+2"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0160()
  {
    rc_BigDecimal = (new BigDecimal("8.1E+37")).ulp();
    Assert.assertEquals("1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0162()
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
  public void testItem_0163()
  {
    rc_BigDecimal_array = (new BigDecimal("8.1E+37")).divideAndRemainder(new BigDecimal("3.2E+2"));
  }
//  public void testItem_0164()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-2.3328E-2147483589"), java.math.RoundingMode.CEILING);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\uFFFF', '\1', '8', '8', '\234', '\1', '\uFFFF', '8', '\234', '8', '\uFFFF', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '8', '\234', '\1', '8', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\0', '\234', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '8', '\1', '\234', '\234', '\0', '\uFFFF', '\234', '\0', '8', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0166()
  {
    rc_BigDecimal = (new BigDecimal("1E+36")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+36", rc_BigDecimal.toString());
  }
//  public void testItem_0167()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-2.3328E-2147483589")).hashCode();
//    Assert.assertEquals(2146760425, rc_int);
//  }
  public void testItem_0168()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).pow(0, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_int = (new BigDecimal("-2.3328E-2147483589")).compareTo(new BigDecimal("-1E+36"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0170()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).stripTrailingZeros();
    Assert.assertEquals("-1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0171()
  {
    rc_BigDecimal = (new BigDecimal("-2.3328E-2147483589")).divideToIntegralValue(new BigDecimal("-1E+36"));
    Assert.assertEquals("0E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0174()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).movePointRight(0);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0175()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).min(new BigDecimal("0E-2147483629"));
    Assert.assertEquals("-1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0176()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0177()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0178()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("-1E+36"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0179()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1E+36")).hashCode();
//    Assert.assertEquals(-67, rc_int);
//  }
  public void testItem_0180()
  {
    rc_BigInteger = (new BigDecimal("320")).toBigInteger();
    Assert.assertEquals("320", rc_BigInteger.toString());
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).divide(new BigDecimal("320"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+36", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).subtract(new BigDecimal("3.2E+2"));
    Assert.assertEquals("-1.00000000000000000000000000000000032E+36", rc_BigDecimal.toString());
  }
  public void testItem_0184()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0185()
  {
    rc_String = (new BigDecimal("320")).toEngineeringString();
    Assert.assertEquals("320", rc_String);
  }
  public void testItem_0186()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\234', '\234', '\1', '\234', '\1', '\234', '8', '\0', '\234', '\1', '\0', '8', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\234', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '8', '8', '8', '8', '8', '\uFFFF', '8', '\0', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '8', '\1', '\1', '\0', '\0', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\234', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\234', '\0', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0187()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("-1E+36")).hashCode();
//    Assert.assertEquals(-67, rc_int);
//  }
  public void testItem_0188()
  {
    rc_BigDecimal_array = (new BigDecimal("320")).divideAndRemainder(new BigDecimal("-1E+36"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0189()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("3.2E-2147483646")).hashCode();
//    Assert.assertEquals(-2147482657, rc_int);
//  }
  public void testItem_0190()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("-1E+36")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0191()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0192()
  {
    rc_long = (new BigDecimal("320")).longValue();
    Assert.assertEquals(320L, rc_long);
  }
  public void testItem_0193()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0194()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("1I3IJ>5V53@6O3UCC=KYTH?VTM<IQKN?Y7;J8:N>P392CF9=;68M3BMGAAG8T?B2V=Q=XTAT8CJ0ULD7E?5=WP<JE=KPHV7:X1YQ", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0195()
  {
    rc_BigDecimal = (new BigDecimal("320")).divideToIntegralValue(new BigDecimal("320"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0196()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0197()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).min(new BigDecimal("1"));
    Assert.assertEquals("-1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0198()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '\0', '\1', '8', '8', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '8', '8', '\234', '\1', '8', '\uFFFF', '\234', '\0', '8', '\1', '8', '\234', '\0', '\0', '\1', '\0', '\1', '\234', '\234', '8', '\0', '\1', '\1', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '8', '8', '\1', '8', '8', '\uFFFF'}, -1, 0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0199()
  {
    rc_BigInteger = (new BigDecimal("-1E+36")).toBigIntegerExact();
    Assert.assertEquals("-1000000000000000000000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0200()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).min(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).round(new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-1E+36", rc_BigDecimal.toString());
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_BigDecimal = (new BigDecimal("-1E+36")).divide(new BigDecimal("-1E+36"), -1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0206()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).subtract(new BigDecimal("-1E+36"));
    Assert.assertEquals("1000000000000000000000001135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0207()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0208()
  {
    rc_String = (new BigDecimal("0.0")).toEngineeringString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1"), 1, 1);
    Assert.assertEquals("1135879015891.0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891.0")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0211()
  {
    rc_int = (new BigDecimal("1135879015891.0")).intValue();
    Assert.assertEquals(2007649747, rc_int);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\234', '\0', '\0', '\1', '8', '\0', '\0', '\234', '\uFFFF', '\uFFFF', '8', '8', '8', '\uFFFF', '\234', '\1', '8', '\234', '\0', '\uFFFF', '\0', '\0', '8', '\234', '8', '\uFFFF', '\1', '\1', '\234', '\234', '\0', '\0', '\234', '8', '\234', '\234', '\234', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '8', '\234', '\1', '\0', '\234', '\0', '8', '\234', '\uFFFF', '8', '\234', '8', '8'}, 1, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0214()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("1135879015891.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0215()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\234', '\234', '\234', '8', '8', '\1', '\234', '\234', '\1', '\0', '\234', '\234', '\234', '\0', '\1', '\uFFFF', '8', '\1', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\1', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '\0', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\1', '8', '\1', '\1', '\0', '\1', '\0', '8', '8', '8', '\0', '\uFFFF', '\1', '\234', '8', '8', '\uFFFF', '\234', '8', '8', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\234', '\234', '8', '8', '\uFFFF'}, -1, -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0216()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0217()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1135879015891.0"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0219()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0220()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0221()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0222()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0223()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0224()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0225()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("R=R1@0");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0226()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0229()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0230()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0231()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0232()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0233()
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
  public void testItem_0234()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).stripTrailingZeros();
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.0")).movePointLeft(1);
    Assert.assertEquals("113587901589.10", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0237()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("9E+18"));
    Assert.assertEquals("-8999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).setScale(1);
    Assert.assertEquals("9000000000000000000.0", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0240()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '8', '\0', '\1', '\uFFFF', '\1', '8', '8', '\1', '\0', '\1', '8', '\uFFFF', '\1', '\uFFFF', '8', '\234', '\234', '\0', '\0', '\234', '8', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\0', '\1', '8', '8', '\1', '8', '8', '8', '8', '\uFFFF', '\0', '8', '\234', '\1', '8', '\uFFFF', '\0', '8', '\1', '\1', '\0', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\1', '\0', '\0', '8', '\234', '\uFFFF', '8', '\0', '\234', '\234', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\1', '\1', '\1', '\1', '\0', '\234', '8', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0241()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).subtract(new BigDecimal("9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0242()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\uFFFF', '\1', '8', '\1', '\234', '8'}, 0, 1);
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("L0=GB=?MUKJXYN3T<FGA44A4>18VQMFER:GV=FVGC?RG8GI:E>8KJGE1JL<6L6R>7U320B;WGX5I;T0?GS80OMUA>@;Q1>2XFKE=", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0245()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3E+2")).divide(new BigDecimal("9E+18"), 2147483647, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0246()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0247()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0248()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).remainder(new BigDecimal("9E+18"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0249()
  {
    rc_BigInteger = (new BigDecimal("9E+18")).unscaledValue();
    Assert.assertEquals("9", rc_BigInteger.toString());
  }
//  public void testItem_0250()
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
  public void testItem_0251()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0252()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0253()
  {
    rc_boolean = (new BigDecimal("3E+2")).equals(":YBIFX=0:Y?=1F5IN221T9XG:V7J8PD89S7419>SH2PD0AM8CRG4?X?497PXKKO@M?J6TDMUVAB:=");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0254()
  {
    rc_int = (new BigDecimal("3E+2")).intValueExact();
    Assert.assertEquals(300, rc_int);
  }
  public void testItem_0255()
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
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).subtract(new BigDecimal("9E+18"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0257()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).subtract(new BigDecimal("1"));
    Assert.assertEquals("8999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0258()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("TO1Q9H;RG9CQG<>TMI2>64;8;Y1N4=;90S=0MGJKH=6B8KK@7?M980O7M6RN3KTEQR83:KPV4@SR;;SAVRXNJK35I2TMLH>CH09?");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0259()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '\0', '8', '\0', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\1', '8', '8', '\0', '\234', '8', '\234', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '8', '\1', '\0', '\0', '8', '\234', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '8', '\uFFFF', '8', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\1', '8', '8', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\234', '\0', '\234', '\uFFFF', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).remainder(new BigDecimal("8999999999999999999"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).ulp();
    Assert.assertEquals("1E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0263()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).max(new BigDecimal("9E+18"));
//    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).remainder(new BigDecimal("9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+18", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0266()
  {
    rc_BigInteger = (new BigDecimal("1E+2")).toBigIntegerExact();
    Assert.assertEquals("100", rc_BigInteger.toString());
  }
  public void testItem_0267()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0268()
  {
    rc_int = (new BigDecimal("3.2E+2")).compareTo(new BigDecimal("3.2E+2"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0269()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\234', '\0', '\1', '\1', '\uFFFF', '\uFFFF', '\234', '\1', '\1', '8', '\234', '8', '\uFFFF', '8', '\uFFFF', '8', '\1', '\234', '\uFFFF', '\1', '8', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '8', '\234', '\0', '\1', '\234', '\234', '\1', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\0', '\uFFFF', '8', '\0', '\234', '\234', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0270()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0271()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0272()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("8999999999999999999")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = (new BigDecimal("8999999999999999999")).movePointLeft(0);
    Assert.assertEquals("8999999999999999999", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0278()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0279()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("8999999999999999999"));
    Assert.assertEquals("9000000000000000319", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0280()
  {
    rc_boolean = (new BigDecimal("1")).equals("V1AL:=DVU1:=10N6@FB7A0=0S3=K8;F5PAKRUGUR");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0281()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0282()
  {
    rc_long = (new BigDecimal("8999999999999999999")).longValueExact();
    Assert.assertEquals(8999999999999999999L, rc_long);
  }
  public void testItem_0283()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("8999999999999999999"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8999999999999999998", rc_BigDecimal.toString());
  }
  public void testItem_0284()
  {
    rc_BigDecimal = (new BigDecimal("-8999999999999999998")).add(new BigDecimal("8999999999999999999"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0285()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\234', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '8', '8', '\0', '\1', '8', '\0', '\uFFFF', '\234'}, -2147483648, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0286()
  {
    rc_BigDecimal = (new BigDecimal("8999999999999999999")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("9000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0288()
  {
    rc_BigDecimal = (new BigDecimal("-8999999999999999998")).divideToIntegralValue(new BigDecimal("8999999999999999999"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0289()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8999999999999999998")).setScale(2147483647, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0290()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("C@O=?J=D@I@KY8J<6QDA7V3>QB=H>6");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0291()
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
  public void testItem_0292()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("320.0E+2147483647"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0293()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\234', '\0', '\234', '\uFFFF', '8', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '8', '\1', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\1', '8', '\1', '\1', '\0', '\234', '\0', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\0', '\1', '\234', '\234', '\234', '8'}, 2147483647, 2147483647, new MathContext("precision=0 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0294()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigInteger = (new BigDecimal("9000000000000000000")).toBigIntegerExact();
    Assert.assertEquals("9000000000000000000", rc_BigInteger.toString());
  }
  public void testItem_0296()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0297()
  {
    rc_int = (new BigDecimal("9000000000000000000")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0298()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_EVEN", rc_MathContext.toString());
  }
  public void testItem_0299()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).multiply(new BigDecimal("-8999999999999999998"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-80999999999999999982000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0300()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("-80999999999999999982000000000000000000"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("-8999999999999999998")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0302()
  {
    rc_BigDecimal = (new BigDecimal("-80999999999999999982000000000000000000")).round(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-80999999999999999982000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0303()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("-8999999999999999998")).movePointLeft(2147483647);
    Assert.assertEquals("-8.999999999999999998E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0306()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).multiply(new BigDecimal("-8.999999999999999998E-2147483629"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0307()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8999999999999999998")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0308()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8999999999999999998")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0309()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_long = (new BigDecimal("-8.999999999999999998E-2147483629")).longValue();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0310()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0311()
  {
    rc_int = (new BigDecimal("9000000000000000000")).precision();
    Assert.assertEquals(19, rc_int);
  }
//  public void testItem_0312()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-8.999999999999999998E-2147483629")).toBigInteger();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0313()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0314()
  {
    rc_int = (new BigDecimal("-80999999999999999982000000000000000000")).precision();
    Assert.assertEquals(38, rc_int);
  }
  public void testItem_0315()
  {
    rc_BigDecimal = (new BigDecimal("-8999999999999999998")).setScale(1);
    Assert.assertEquals("-8999999999999999998.0", rc_BigDecimal.toString());
  }
  public void testItem_0316()
  {
    rc_BigDecimal_array = (new BigDecimal("-8999999999999999998")).divideAndRemainder(new BigDecimal("-8999999999999999998.0"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0317()
  {
    rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).stripTrailingZeros();
    Assert.assertEquals("-8.999999999999999998E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).remainder(new BigDecimal("-8999999999999999998"));
    Assert.assertEquals("-8.999999999999999998E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0320()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("N69DY0LMQEP7J=8;;;GHQ0C33=D6=JY6P6=0TULRUF76GMWAK188DR<251:SJF5=1?C0J7RRIHO3HUOK6@5;C1KUQ>;=3PQ9>>J6", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0323()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigIntegerExact();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
//  public void testItem_0324()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).add(new BigDecimal("-8.999999999999999998E-2147483629"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0325()
  {
    rc_BigInteger = (new BigDecimal("-9223372036854775808")).toBigInteger();
    Assert.assertEquals("-9223372036854775808", rc_BigInteger.toString());
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '\234', '\0', '\1', '\1', '\234', '\0', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '\0', '\234', '\0', '\0', '\1', '\0', '\1', '\1', '8', '8', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\0', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\uFFFF', '8', '\234', '8', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\234', '8', '\234', '\uFFFF', '\0', '\234', '\234', '8', '\1', '8', '\1', '\0', '\uFFFF', '8', '8', '\1', '8', '8', '\234', '8', '\234', '\234', '8', '\1', '\0', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\234', '\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0328()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).pow(1);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0329()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9000000000000000000")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0330()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_int = (new BigDecimal("-9223372036854775808")).signum();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0332()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("-9223372036854775808"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal_array = (new BigDecimal("-9223372036854775808")).divideAndRemainder(new BigDecimal("-9223372036854775808"));
  }
  public void testItem_0335()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).movePointLeft(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0336()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -1, 1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0337()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).remainder(new BigDecimal("-8.999999999999999998E-2147483629"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0338()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0339()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0340()
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
  public void testItem_0341()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0342()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("70UR;DJ=9;", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0343()
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
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("-8.999999999999999998E-2147483629")).abs();
    Assert.assertEquals("8.999999999999999998E-2147483629", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("9000000000000000000")).subtract(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("18223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("18223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0347()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0348()
  {
    rc_String = (new BigDecimal("9000000000000000000")).toPlainString();
    Assert.assertEquals("9000000000000000000", rc_String);
  }
  public void testItem_0349()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483647")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0350()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0351()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\1', '\0', '8', '8', '8', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '8', '8', '\1', '\0', '\0', '\234', '\0', '\234', '\234', '\1', '\1', '\0', '\234', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\234', '\234', '\1', '\234', '8', '\0', '\0', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\234', '\1', '\1', '\234', '\0', '8', '\uFFFF', '\234', '8', '8', '\234', '\234', '\234', '\uFFFF', '\0'}, -1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0355()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E-2147483646"), java.math.RoundingMode.HALF_DOWN);
//    Assert.assertEquals("0", rc_BigDecimal.toString());
//  }
  public void testItem_0356()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0357()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).divide(new BigDecimal("1E-2147483647"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("18223372036854775808")).subtract(new BigDecimal("18223372036854775808"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0359()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("18223372036854775808")).setScale(-2147483648, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0360()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("1E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2UIJK2RJ1G6PJ?=IUTHB:;KSIERTST::01N41RHN;8@OF96W2:1BC::4BE@=P>DFE7Y8SO>8P4BMKI6I3TP3B4S;UFN<X1RTK4PS");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0365()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(":QQAE270OPHGMK21:L3LGMOA2??T>R7?YYWHOE>;H<27W>8LKX<>JQ4XXMIFMKF:6<G7;", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0366()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\234', '\1', '8', '\0', '\uFFFF', '\1', '\uFFFF', '\0', '\1', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '\1', '\1', '\234', '8', '\234', '\234', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '\1', '\234', '\0', '\234', '\0', '8', '\0', '\1', '\1', '8', '\234', '\uFFFF', '\234', '8', '8', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\234', '\1', '\234', '\1', '\1', '\234', '\uFFFF', '8', '\0', '\234', '\0', '\1', '8', '\0', '8', '\1', '\0', '\1', '8', '8', '\0', '8', '\0', '8', '\uFFFF', '\1', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\1'}, 2147483647, 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0367()
  {
    rc_BigDecimal = (new BigDecimal("18223372036854775808")).negate(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("-18223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0368()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0371()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).max(new BigDecimal("0"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\0', '8', '\234', '\1', '\0', '\0', '\234', '\0', '\1', '\1', '8', '\0', '8', '\234', '\1'}, 2147483647, -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0375()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0376()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0377()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0379()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0380()
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
  public void testItem_0381()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0382()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0383()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0384()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -1, 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0388()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '\1', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\234', '\0', '\234', '\0', '\0', '\234', '\uFFFF', '\234', '\1', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '8', '\0', '\234', '\0', '8', '\1', '\234', '8', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '\1', '\0', '\1', '\1', '\0', '8', '8', '\1', '8', '\1', '\0', '\234', '8', '8', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\1', '8', '\0', '8', '\0', '\0', '8'}, 2147483647, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0391()
//  {
//    boolean caught;
//    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("3E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0392()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("@42CVI8F0>NWFUTRUNQP>PE?L;R:>E?XE61XO88Q>97VMCPN<X;<GY?NNED>Q9YC3P72UW>1Y?PT3VJSBLN:ML=TOT>P8;3P5>HR", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0394()
  {
    rc_int = (new BigDecimal("1")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0395()
  {
    rc_int = (new BigDecimal("32")).intValueExact();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0396()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0397()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0400()
  {
    rc_BigInteger = (new BigDecimal("1")).unscaledValue();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0408()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("E<XY9HGUHH2G3X2D71");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0409()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("XRRN599B53OTPWU4HH@R98:XI96S50?4QE5>3ER68IH>N4U0>9J=D9G>9CLAU<OX66M>X");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0410()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0411()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0412()
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
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).negate();
    Assert.assertEquals("-0.1", rc_BigDecimal.toString());
  }
  public void testItem_0416()
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
  public void testItem_0417()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0418()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0419()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0420()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0421()
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
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("0")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(-1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1135879015891"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0429()
  {
    rc_String = (new BigDecimal("10")).toPlainString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0430()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\1', '\0', '\1', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\0', '\0', '8', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\1', '8', '\234', '\0', '8', '\234', '8', '\uFFFF', '8', '8', '8'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0431()
  {
    rc_BigDecimal = (new BigDecimal("10")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0432()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0433()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0434()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0435()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0436()
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
  public void testItem_0437()
  {
    rc_BigDecimal = (new BigDecimal("10")).plus(new MathContext("precision=0 roundingMode=HALF_EVEN"));
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).remainder(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0442()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0443()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0446()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).toBigInteger();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0447()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0448()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0449()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0450()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0451()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0452()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1.135879015891E+2147483659", rc_BigDecimal.toString());
  }
  public void testItem_0453()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0455()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0456()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891.0E+2147483647")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0457()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("JCF8");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0458()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1135879015891"), 1, 2147483647);
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
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0460()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideAndRemainder(new BigDecimal("1135879015891.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).setScale(0, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0462()
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
  public void testItem_0463()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).plus();
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0464()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -1, new MathContext("precision=0 roundingMode=HALF_EVEN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0465()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0466()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("864;B;PY:K>2V2HUX28B5M6J=CNS@06I7BG48;OAJUHG03EY>JRS?JT9LJ5MOROXVG==QA0KUKC1VX8YSG1?<A9Y=BF:?B9@J>W5", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0472()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0473()
  {
    rc_BigInteger = (new BigDecimal("1135879015891")).unscaledValue();
    Assert.assertEquals("1135879015891", rc_BigInteger.toString());
  }
  public void testItem_0474()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).subtract(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0475()
  {
    rc_int = (new BigDecimal("1135879015891")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divideToIntegralValue(new BigDecimal("1135879015891"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    rc_int = (new BigDecimal("2E+308")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0478()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0479()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0480()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toEngineeringString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0481()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0482()
  {
    rc_BigDecimal = (new BigDecimal("10")).scaleByPowerOfTen(0);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0483()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1135879015891")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0485()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\234', '\234', '\234', '8', '\234', '8', '8', '\1', '\1', '\234', '\uFFFF', '\0', '\234', '8', '\uFFFF', '8', '8', '\0', '\uFFFF', '\234', '8', '\uFFFF', '\1', '8', '8', '\234', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '8', '8', '\0', '\234', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '8', '\234', '\0', '8', '8', '\1', '\1', '\234', '\234', '\1'}, 2147483647, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0486()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0487()
  {
    rc_BigDecimal = (new BigDecimal("3")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0488()
  {
    rc_int = (new BigDecimal("1135879015891")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0489()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("3"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0493()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0494()
  {
    rc_float = (new BigDecimal("2E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0496()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).subtract(new BigDecimal("2E+308"));
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483648", rc_BigDecimal.toString());
  }
  public void testItem_0497()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("-9223372036854775808"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0498()
  {
    rc_BigDecimal = (new BigDecimal("-9223372036854775808")).remainder(new BigDecimal("-9223372036854775808"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483648")).min(new BigDecimal("1135879015891"));
    Assert.assertEquals("-200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002147483648", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0500()
  {
    rc_boolean = (new BigDecimal("-2147483648")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0501()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).multiply(new BigDecimal("1135879015891"));
    Assert.assertEquals("1290221138741506630523881", rc_BigDecimal.toString());
  }
  public void testItem_0502()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1290221138741506630523881")).divideToIntegralValue(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0503()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1135879015891")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0504()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0505()
  {
    rc_boolean = (new BigDecimal("1290221138741506630523881")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0506()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigIntegerExact();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0507()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0508()
  {
    rc_double = (new BigDecimal("1135879015891")).doubleValue();
    Assert.assertEquals(1.135879015891E12, rc_double, 0);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0510()
  {
    rc_float = (new BigDecimal("1135879015891")).floatValue();
    Assert.assertEquals(1.135878995968E12F, rc_float, 0);
  }
//  public void testItem_0511()
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
//  public void testItem_0512()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("320.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_BigDecimal = (new BigDecimal("1290221138741506630523881")).divideToIntegralValue(new BigDecimal("1290221138741506630523881"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0515()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).divide(new BigDecimal("1135879015891"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_BigDecimal = (new BigDecimal("0")).stripTrailingZeros();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).setScale(-2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divide(new BigDecimal("-2147483648"), 2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0522()
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
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("320.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0524()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-2147483648")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0525()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0526()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\uFFFF', '\1', '\234', '\0', '\234', '8'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0527()
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
  public void testItem_0528()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0529()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0530()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0533()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0534()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).unscaledValue();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0535()
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
//  public void testItem_0536()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("320.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("32"));
    Assert.assertEquals("-31", rc_BigDecimal.toString());
  }
  public void testItem_0539()
  {
    rc_BigDecimal = (new BigDecimal("32")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(1);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    rc_BigDecimal = (new BigDecimal("10")).movePointRight(0);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0542()
  {
    rc_int = (new BigDecimal("10")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0543()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0544()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-1"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0547()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("32"), 1, 1);
    Assert.assertEquals("0.3", rc_BigDecimal.toString());
  }
  public void testItem_0548()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0549()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0550()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("32"));
    Assert.assertEquals("31", rc_BigDecimal.toString());
  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("-1")).movePointLeft(2147483647);
    Assert.assertEquals("-1E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0552()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E-2147483647")).setScale(-2147483648, 0);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0553()
  {
    rc_BigDecimal = (new BigDecimal("-1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0554()
  {
    rc_int = (new BigDecimal("-1E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0557()
  {
    rc_BigDecimal = (new BigDecimal("32")).stripTrailingZeros();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0558()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0559()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0560()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E-2147483646"), -2147483648, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0561()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0562()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-1);
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0563()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0564()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = (new BigDecimal("3E-2147483646")).multiply(new BigDecimal("32"));
    Assert.assertEquals("9.6E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0567()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("9.6E-2147483645")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0571()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483644")).remainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0572()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483644")).abs();
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0573()
  {
    rc_boolean = (new BigDecimal("1E-2147483644")).equals("XMK<2S5VT3TMA;NM>GKO=RX:<L:QEHX>W96<9?01929Q0TW<7O<9KLP0ESDL42BHO:HAUCJI1WAF>@3RK4WCWNIBBRJ<0W9WET14");
    Assert.assertEquals(false, rc_boolean);
  }
//  public void testItem_0574()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483644")).divide(new BigDecimal("1E-2147483644"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0575()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_int = (new BigDecimal("9.6E-2147483645")).intValue();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\uFFFF', '\234', '\0', '\0', '\1', '8', '\234', '\1', '\234', '8', '\uFFFF', '\0', '8', '\1', '\1', '\1', '\234', '8', '8', '\234', '8', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '8', '\0', '\1', '\0', '\1', '\1', '\0', '\0', '\1', '\234', '\0', '8', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\uFFFF', '8', '8', '\uFFFF', '\234', '\0', '\0', '\234', '\uFFFF', '\0', '\0', '\0', '\0', '\234', '\1', '\uFFFF', '\234', '8', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '\234', '\1', '8', '\0', '\1', '\uFFFF', '8'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).subtract(new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0578()
  {
    rc_BigDecimal_array = (new BigDecimal("1E-2147483644")).divideAndRemainder(new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"));
  }
  public void testItem_0579()
  {
    rc_BigDecimal = (new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).divide(new BigDecimal("32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0580()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("1E-2147483644"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0581()
  {
    rc_double = (new BigDecimal("9.6E-2147483645")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0582()
  {
    rc_int = (new BigDecimal("-3E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0583()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-3E+1"), 0);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0584()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("9.6E-2147483645"), 0, java.math.RoundingMode.UNNECESSARY);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0585()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).stripTrailingZeros();
    Assert.assertEquals("9.6E-2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0588()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '\uFFFF', '8', '8', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0589()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("1E-2147483644"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-3E+2147483645", rc_BigDecimal.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("9.6E-2147483645")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375", rc_BigDecimal.toString());
  }
  public void testItem_0592()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483644")).add(new BigDecimal("1E-2147483644"));
    Assert.assertEquals("2E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0593()
  {
    rc_short = (new BigDecimal("-3E+1")).shortValueExact();
    Assert.assertEquals(-30, rc_short);
  }
  public void testItem_0594()
  {
    rc_int = (new BigDecimal("1E-2147483644")).compareTo(new BigDecimal("-3E+1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0595()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("precision=1 roundingMode=FLOOR", rc_MathContext.toString());
  }
  public void testItem_0596()
  {
    rc_String = (new BigDecimal("-3E+1")).toPlainString();
    Assert.assertEquals("-30", rc_String);
  }
  public void testItem_0597()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483644")).stripTrailingZeros();
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0598()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0599()
  {
    rc_int = (new BigDecimal("1E-2147483644")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0600()
  {
    rc_BigInteger = (new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).toBigInteger();
    Assert.assertEquals("-29", rc_BigInteger.toString());
  }
  public void testItem_0601()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483644")).abs();
    Assert.assertEquals("1E-2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0602()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E-2147483644")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0603()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483644")).divide(new BigDecimal("1E-2147483644"), java.math.RoundingMode.HALF_EVEN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0604()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0605()
  {
    rc_BigDecimal = (new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).add(new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375"));
    Assert.assertEquals("-59.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999990118687083175069116468624142635572552698803947713504711488286349986489854595824962694003272767280152404068706091085645381466865792881204072024504079784362437473985736193771909443083656643020357926225627278860025385538999872251816928700312253750532054536607697199365692292038517475228688176579466828866264636259208793787501361094568170150893413890869111977450397405800009161360211818391668733509504857042619705464396812895227768997303929470130559612419463785785016593335546310493328558335136127815234213083263879787976987660380493843315445363341504190034950538447248145504250687830443592531060600932705964054644564829748678897601736990217797097924274523665498088325220532802012670380117671588594725819441514464910869541824922634987160563468933105468750", rc_BigDecimal.toString());
  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("VS0W7YLRG7TH66HEL8?J@S9UH1R>Y@?;1XMD:<GBS1UBDDF@X0PKB4X00V1R6F2BNLYO9UVYEU114=PBSBHKRFPUQGPVA2@M59P@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0607()
  {
    rc_int = (new BigDecimal("-3E+1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("-3E+1")).divide(new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L);
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_BigInteger = (new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).toBigInteger();
    Assert.assertEquals("-29", rc_BigInteger.toString());
  }
  public void testItem_0615()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointLeft(-1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0616()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-9223372036854775808")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0617()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0.0")).divideAndRemainder(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0618()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0619()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-29.999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999995059343541587534558234312071317786276349401973856752355744143174993244927297912481347001636383640076202034353045542822690733432896440602036012252039892181218736992868096885954721541828321510178963112813639430012692769499936125908464350156126875266027268303848599682846146019258737614344088289733414433132318129604396893750680547284085075446706945434555988725198702900004580680105909195834366754752428521309852732198406447613884498651964735065279806209731892892508296667773155246664279167568063907617106541631939893988493830190246921657722681670752095017475269223624072752125343915221796265530300466352982027322282414874339448800868495108898548962137261832749044162610266401006335190058835794297362909720757232455434770912461317493580281734466552734375")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_long = (new BigDecimal("-9223372036854775808")).longValueExact();
    Assert.assertEquals(-9223372036854775808L, rc_long);
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_float = (new BigDecimal("-9223372036854775808")).floatValue();
    Assert.assertEquals(-9.223372036854776E18F, rc_float, 0);
  }
  public void testItem_0625()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0626()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0627()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0629()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0630()
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
  public void testItem_0631()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0632()
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
  public void testItem_0633()
  {
    rc_byte = (new BigDecimal("0")).byteValueExact();
    Assert.assertEquals(0, rc_byte);
  }
  public void testItem_0634()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0635()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0636()
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
  public void testItem_0637()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0638()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0639()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).stripTrailingZeros();
	Assert.assertEquals(0.0, rc_BigDecimal.doubleValue(), 0);
  }
  public void testItem_0640()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\1', '\234', '\234', '\uFFFF', '\234', '8', '\234', '\234', '\1', '\234', '8', '\uFFFF', '\0', '8', '8', '\0', '\0', '\234', '\1', '\0', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\0', '\0', '\0', '\0', '8', '8', '\234', '\1', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\0', '8', '\0', '8', '\uFFFF', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\1', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\234', '8', '8', '8', '\0', '\uFFFF', '\1', '8', '\1', '8', '8', '\1', '8', '\uFFFF', '\0', '\0', '\1', '\1', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0641()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-9223372036854775808"), -1, 0);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0644()
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
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).divideToIntegralValue(new BigDecimal("2E+308"));
    Assert.assertEquals("0E-309", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("0"), 0, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("0E-309"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0649()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\0', '\1', '\1', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\0', '\234', '\0', '8', '\1', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\234'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0650()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0652()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\234', '8', '\234', '\234', '\uFFFF', '\234', '\234', '\uFFFF', '\uFFFF', '\0', '\0', '\1', '\uFFFF', '\1', '8', '\0', '8', '\1', '\1', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '8', '\uFFFF', '\1', '8', '\234', '\234', '8', '\0', '8', '\234', '\0', '\234', '\0', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '\234', '\234', '\0', '\0', '\0', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\234', '\0', '\234', '\1', '\uFFFF', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\234', '\1', '\0', '\234', '\1', '\1', '\234', '\uFFFF', '8', '\234', '\0', '\234', '\uFFFF', '\1', '\1', '\234', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '8', '\uFFFF', '8', '\1', '\234', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\234', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '8', '\234', '\1', '\0', '\1', '\1', '\234', '\1', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\234', '\234'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_String = (new BigDecimal("32")).toString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0656()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0657()
  {
    rc_int = (new BigDecimal("0E-309")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0658()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0659()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0660()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("32"), java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0662()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0663()
  {
    rc_BigDecimal_array = (new BigDecimal("2E+308")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0664()
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
  public void testItem_0665()
  {
    rc_BigDecimal = (new BigDecimal("0E-309")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-309", rc_BigDecimal.toString());
  }
  public void testItem_0666()
  {
    rc_float = (new BigDecimal("2E+308")).floatValue();
    Assert.assertEquals(java.lang.Float.POSITIVE_INFINITY, rc_float, 0);
  }
  public void testItem_0667()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-309")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0668()
  {
    rc_int = (new BigDecimal("3.2E-2147483646")).compareTo(new BigDecimal("2E+308"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0670()
  {
    rc_BigDecimal = new BigDecimal(2147483647);
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0671()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0672()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("MH9R@4;O;4771NB=RKGIW?KUW0TR;O:SSB;=SUN:UG:>T=0C<;0::?Q=NUTT2:0D>8TRKQ7G@PNU70U><QFLD8JAOOWP@QH>HLDT");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0673()
  {
    rc_BigInteger = (new BigDecimal("2147483647")).toBigIntegerExact();
    Assert.assertEquals("2147483647", rc_BigInteger.toString());
  }
  public void testItem_0674()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("0E-309"), 0);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).min(new BigDecimal("2E+308"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("2E+308"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0677()
  {
    rc_long = (new BigDecimal("2E+308")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0678()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("UGXEF<9>SL0602A;NV6GOSGJUH38T3NDVHISUERIC;=CU6U32?MTJ8D9XB10G<@J=IOP4>W=NYTEO4Y;>HEMT0MST9QR20@7MQ0M", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0679()
  {
    rc_BigDecimal = (new BigDecimal("0E-309")).max(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0680()
  {
    rc_BigDecimal = (new BigDecimal("0E-309")).add(new BigDecimal("1"));
    Assert.assertEquals("1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0681()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("2147483647"));
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0682()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0684()
  {
    rc_BigDecimal = (new BigDecimal("2")).scaleByPowerOfTen(1);
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0685()
  {
    rc_int = (new BigDecimal("2E+308")).compareTo(new BigDecimal("2147483648"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).scaleByPowerOfTen(1);
    Assert.assertEquals("2.147483647E+10", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("2")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("=:N03WVPRCM5TC5L@7X4T<;=178773U0;=C?VM@3M3JUF3Q0CB3KM752G5H>KPF5IJ3H5P1P?GYXFPNNN5TTX7");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).plus();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0691()
  {
    rc_long = (new BigDecimal("2147483648")).longValue();
    Assert.assertEquals(2147483648L, rc_long);
  }
  public void testItem_0692()
  {
    rc_String = (new BigDecimal("2147483647")).toPlainString();
    Assert.assertEquals("2147483647", rc_String);
  }
  public void testItem_0693()
  {
    rc_String = (new BigDecimal("2E+1")).toPlainString();
    Assert.assertEquals("20", rc_String);
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("8")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0696()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("43K8QDS<?>ROG5UQRW:=038FY0=P8NI5T3FD9;HPB=TF5N1BH;PXBN04QQD:SKR@@0C=9WJ9J6Y9JFEKA2L2IQ39D3LWN=RHD5VC");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("-8")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    rc_BigDecimal = (new BigDecimal("8")).multiply(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("256", rc_BigDecimal.toString());
  }
  public void testItem_0701()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0702()
  {
    rc_BigDecimal = (new BigDecimal("2147483647")).min(new BigDecimal("-8"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0703()
  {
    rc_boolean = (new BigDecimal("-8")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0704()
  {
    rc_int = (new BigDecimal("8")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0705()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\0', '\0', '8'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("-8")).scaleByPowerOfTen(0);
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = (new BigDecimal("8")).min(new BigDecimal("8"));
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0709()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("2")).divideToIntegralValue(new BigDecimal("8"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-9223372036854775808", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal_array = (new BigDecimal("2")).divideAndRemainder(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0714()
  {
    rc_double = (new BigDecimal("-9223372036854775808")).doubleValue();
    Assert.assertEquals(-9.223372036854776E18, rc_double, 0);
  }
  public void testItem_0715()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0716()
  {
    rc_BigDecimal = (new BigDecimal("2")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0717()
  {
    rc_boolean = (new BigDecimal("0")).equals("?7JS?ENK<SSCVX<:QG=GF@;DTHPO=VB4Y");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0718()
  {
    rc_BigDecimal = (new BigDecimal("-8")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-8", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0721()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0722()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0724()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0725()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("8?517WF>WJR7QK1VKP>>OBOPRN3E>>J17Q6QV<QD7N@47E64P>V:GYACUIBYJ@ML7I<F:161K85E4V6RU@");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0726()
  {
    rc_int = (new BigDecimal("320.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("KX?EXHI5R=0T7Q9DGLRKWNCCIWK<=9O7LUG?DJ>1VD::W6O1XLLYLOYF@1D9;G@KRYX6S5MG?@B00;86:EHUWJ6=VCO@LPRMU7E5");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0728()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).multiply(new BigDecimal("2"));
//    Assert.assertEquals("6.4E+2147483649", rc_BigDecimal.toString());
//  }
  public void testItem_0729()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("2"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
  public void testItem_0730()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_float = (new BigDecimal("2")).floatValue();
    Assert.assertEquals(2.0F, rc_float, 0);
  }
  public void testItem_0732()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
//  public void testItem_0734()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).subtract(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0735()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '\1', '\1', '8', '\uFFFF', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0736()
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
//  public void testItem_0737()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("640.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0738()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0739()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0740()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("5E-324", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    rc_String = (new BigDecimal("2")).toString();
    Assert.assertEquals("2", rc_String);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
//  public void testItem_0743()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0744()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("Q7A=5CMOY;YHI6<DHK5<HF4=D=TORR2ND8;G77?WEIELELL6GHBSA2YEPU9CK6?R=;NLAK6;L2H4Y;54HR:13?CLO=VRS50;:6HM", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0745()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("640.0E+2147483647")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0746()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0747()
  {
    rc_int = (new BigDecimal("2")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0748()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("W@G5<5BXVDVV9IAW24DT7JGYPG4F8QI:E3WM8>NM<N9YLD7ANFWI9FGR5TS=FOJ:G7X=3PJ?2?");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0751()
  {
    rc_BigDecimal = (new BigDecimal("3")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("-3", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0753()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
//  public void testItem_0754()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).setScale(1, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0755()
  {
    rc_boolean = (new BigDecimal("2")).equals("6DP=Y09RRN0>@WA<DBQ1UFEHKR9RYRG<82XS4R");
    Assert.assertEquals(false, rc_boolean);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0756()
  {
    rc_boolean = (new BigDecimal("-1")).equals("W=33VRSI49?H4YK@6CVDP1T3T::XLQ3M");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0757()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0758()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("3"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0760()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0761()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("640.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0762()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
//  public void testItem_0763()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("640.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0764()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0765()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("640.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0766()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("640.0E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0767()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0768()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("640.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0769()
  {
    rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).min(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0770()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0771()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0772()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0773()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("640.0E+2147483647")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0774()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0775()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("12<PF8", new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0776()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).negate();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_BigInteger = (new BigDecimal("-2147483648")).toBigInteger();
    Assert.assertEquals("-2147483648", rc_BigInteger.toString());
  }
  public void testItem_0778()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0779()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2147483648")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0782()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0783()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("640.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
//  }
  public void testItem_0784()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("2147483648"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0785()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0786()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0788()
  {
    rc_BigDecimal = (new BigDecimal("2147483648")).stripTrailingZeros();
    Assert.assertEquals("2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0789()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).setScale(-2147483648, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0790()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0791()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0792()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0793()
  {
    rc_String = (new BigDecimal("2147483648")).toEngineeringString();
    Assert.assertEquals("2147483648", rc_String);
  }
  public void testItem_0794()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0795()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
//  public void testItem_0796()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0797()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0798()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigIntegerExact();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0799()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0800()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '8', '\234', '\234', '8', '\0', '8', '\0', '\0', '\234', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\234', '8', '\1', '\0', '8', '\234', '\uFFFF', '\0', '8', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '8', '\1', '\234', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\0', '\234', '8', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\234', '\1', '\234', '\1', '\0', '\234', '\0', '\1', '\234', '\0', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '8', '\234', '\234', '\1', '8', '\1', '\234', '8', '\0', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\uFFFF', '\234', '\234', '8', '\0', '\1', '\0', '\1', '\uFFFF', '\0', '\uFFFF', '8'}, 1, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0801()
  {
    rc_BigInteger = (new BigDecimal("2147483648")).unscaledValue();
    Assert.assertEquals("2147483648", rc_BigInteger.toString());
  }
  public void testItem_0802()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0804()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2147483648")).divide(new BigDecimal("1135879015891"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0805()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0806()
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
  public void testItem_0807()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0808()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("1135879015891"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0809()
  {
    rc_String = (new BigDecimal("2147483648")).toString();
    Assert.assertEquals("2147483648", rc_String);
  }
  public void testItem_0810()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divideToIntegralValue(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0811()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0812()
  {
    rc_double = (new BigDecimal("0E+1")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0813()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0814()
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
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).add(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0817()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0818()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("0E+1"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0819()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
//  public void testItem_0820()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("-1"), -2147483648, 1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0821()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0822()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0824()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0825()
  {
    rc_int = (new BigDecimal("0E+1")).intValueExact();
    Assert.assertEquals(0, rc_int);
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0827()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0830()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0831()
  {
    rc_boolean = (new BigDecimal("0")).equals("W4?OMCHT?M?T>GRRXQBX2@6EC");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0832()
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
  public void testItem_0833()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0"), 2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0834()
  {
    rc_int = (new BigDecimal("0E-2147483647")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0835()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0836()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\1', '\1', '\0', '8', '\1', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '8', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\234', '\0', '\0', '8', '\234', '8', '8', '\1', '\0', '\234', '8', '\1', '\1', '\1', '\1', '\234', '\0', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\1', '8', '\234', '\1', '\0', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\234', '\uFFFF'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0839()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0840()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+1")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
  }
  public void testItem_0842()
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
  public void testItem_0843()
  {
    rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("3E+1"), 0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0844()
  {
    rc_byte = (new BigDecimal("3E+1")).byteValueExact();
    Assert.assertEquals(30, rc_byte);
  }
  public void testItem_0845()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1', '\1', '\1', '\1', '\234', '\1', '8', '\0', '8', '\234', '8', '8', '\0', '8', '\uFFFF', '\uFFFF', '\1', '\234', '\234', '8', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '\234', '\1', '\1', '\uFFFF', '\uFFFF', '\1'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("TDPO:FP8HFJP?JLA57U>FQQFEQ9N71;X:VJ;4EW=C20VJ1QNA5W19SO6R5<8EX@@QIMJQIHPF?FUG5;RXHTRDG0A@2TN1NL=GT70");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = (new BigDecimal("0")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0850()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0851()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0853()
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
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_int = (new BigDecimal("3E+1")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0857()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).subtract(new BigDecimal("3E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0858()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0859()
  {
    rc_BigDecimal = (new BigDecimal("6E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("6E+1", rc_BigDecimal.toString());
  }
  public void testItem_0860()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0861()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("0E-2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0862()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\1', '\234', '\234', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\0', '\1', '\1', '8', '8', '\234', '\uFFFF', '\0', '\234', '8', '\1', '\234', '\1', '8', '\1', '\0', '8', '8', '\uFFFF', '8', '\234', '8', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '8', '8', '8', '8', '\1', '\234', '\234', '\1', '\1', '8', '8', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\234', '8', '8', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\0', '\0', '\1', '\0', '\234', '8', '8', '8', '\0', '8', '\1', '\1', '\0', '\234', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '8', '8', '\1', '\uFFFF', '\1', '8', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0863()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).divideToIntegralValue(new BigDecimal("3E+1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigInteger = (new BigDecimal("3E+1")).toBigInteger();
    Assert.assertEquals("30", rc_BigInteger.toString());
  }
  public void testItem_0868()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=DOWN"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0869()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0870()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0871()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0872()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0875()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0876()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\234', '\234', '8', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\0', '\1', '\1', '8', '\234', '8', '\1', '\1', '8', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\0', '\1', '\uFFFF', '8', '8', '\uFFFF', '\1', '\0', '8', '8', '\234', '\0', '8', '8', '\uFFFF', '8', '8', '\uFFFF', '\1', '8', '\234', '8', '\234', '\uFFFF', '\1', '\234', '\234', '\uFFFF', '\234', '\234', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\1', '\234', '\1', '8', '\1', '\1', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\1', '\uFFFF', '\0', '\0', '\1', '8', '8', '\uFFFF', '\0', '\1', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0881()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0882()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0883()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0884()
  {
    rc_short = (new BigDecimal("3E+1")).shortValueExact();
    Assert.assertEquals(30, rc_short);
  }
  public void testItem_0885()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0886()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0888()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0889()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+1"), java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0890()
  {
    rc_int = (new BigDecimal("3")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0891()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0892()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0893()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0894()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("DV>?LUC><N45LEG3W;<R4=L3OP4B2RX6;VBYNJ8=4TX8:0YK31IU01BAO9WFBGN519:1?NRP>KLXF06MB648TN;7A@9;Q6E<BHPS", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-2147483648);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0897()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0898()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0899()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0900()
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
  public void testItem_0901()
  {
    rc_byte = (new BigDecimal("3")).byteValueExact();
    Assert.assertEquals(3, rc_byte);
  }
  public void testItem_0902()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0903()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0904()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = (new BigDecimal("-1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("SN1UEAQQ2802F0P8CIANFPBOEXQY0UUGB=1CFUVMBYCV9<6YY;SFH;:HDC8=KW193X5C1CU;VN@>X<EKG61@;:6XM;6G64CFQ9E=");
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
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0909()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8', '\0', '\1', '\0', '\234', '\1', '\234', '\0', '8', '8', '\0', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '8', '\234', '\0', '\1', '8', '\1', '\0', '8', '\234'}, 0, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0910()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0911()
  {
    rc_int = (new BigDecimal("0E-2147483647")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0912()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0913()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("R:2TTUQ4@XNNFIY?632LL9;7E232<<ARO2BI;GBA?5RI?LNGUCUNU@<94@ULT>;=;PL3EWFQBYMUP?4BV6V;363DL8FRFFC6C<88");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0914()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0915()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '8', '\234', '\0', '\1', '8', '\1', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\1', '\1', '8', '\1', '8', '\234', '\0', '\1', '\0', '\1', '\0', '8', '\0', '8', '8', '8', '\1', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\0', '8', '\234', '8', '\uFFFF', '\1', '\234', '\1', '\234', '8', '\0', '8', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\1', '\0', '\234', '8', '\234', '8', '\1', '\uFFFF', '8', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '8', '8', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\uFFFF', '\0', '8', '\1', '\uFFFF', '8'}, -2147483648, 2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0916()
  {
    rc_MathContext = new MathContext(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=1 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0918()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0919()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0922()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), 0, 1);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0923()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0926()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0927()
  {
    rc_BigDecimal = new BigDecimal(-1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0928()
  {
    rc_String = (new BigDecimal("2E+308")).toEngineeringString();
    Assert.assertEquals("200E+306", rc_String);
  }
  public void testItem_0929()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\234'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("2E+308"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
//  public void testItem_0931()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\0', '\234', '\234', '8', '\1', '\234', '\0', '\1', '8', '\uFFFF', '\234', '8', '\1', '\1', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '\1', '\234', '\1', '\uFFFF', '\uFFFF', '8', '8', '8', '8', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\1', '\0', '8', '\uFFFF', '8', '\0', '\0', '\1', '\234', '8', '8', '8', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\1', '\1', '8', '8', '\1', '8', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\234', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\uFFFF', '\1', '8', '8', '8', '8', '\1', '\0', '\0', '\0', '\234', '\uFFFF', '\0', '\0', '\234', '\1', '8'}, 1, 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
//    }
//    catch (java.lang.NumberFormatException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0932()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+308")).pow(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0933()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("-1"));
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0934()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divideToIntegralValue(new BigDecimal("2E+308"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0936()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0937()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(1);
    Assert.assertEquals("0E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0938()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483646")).divide(new BigDecimal("0E-2147483646"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_String = (new BigDecimal("0E-2147483647")).toEngineeringString();
    Assert.assertEquals("0.0E-2147483646", rc_String);
  }
  public void testItem_0941()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0942()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigIntegerExact();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0943()
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
  public void testItem_0944()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0946()
  {
    rc_long = (new BigDecimal("1")).longValueExact();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0947()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0948()
  {
    rc_String = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toPlainString();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_String);
  }
  public void testItem_0949()
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
  public void testItem_0950()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).movePointRight(-1);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0951()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0952()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0953()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0954()
  {
    rc_String = (new BigDecimal("3.2E-2147483646")).toEngineeringString();
    Assert.assertEquals("3.2E-2147483646", rc_String);
  }
  public void testItem_0955()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).min(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(0);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0957()
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
  public void testItem_0958()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0959()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0960()
  {
    rc_BigInteger = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).toBigInteger();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigInteger.toString());
  }
  public void testItem_0961()
  {
    rc_short = (new BigDecimal("0E-2147483647")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0962()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C4VAIL2RGUBM3E=4>>ON0THFY<12M@YDJEXNO7KTJB@L@HN8I1KJ@AU7I1EC@?U7@F2GUA8S6GD2W1Q9B>X=PBAI3WUG3WU06D5U");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).plus();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0964()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.2E-2147483646")).toBigIntegerExact();
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0965()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0966()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).subtract(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0967()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0968()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 1, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0970()
  {
    rc_int = (new BigDecimal("0E-2147483647")).compareTo(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0971()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0972()
  {
    rc_long = (new BigDecimal("0E-2147483647")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0973()
  {
    rc_boolean = (new BigDecimal("-1")).equals("5X6<1OX2@Y5??GDJW6KW@3BGCLRBYV>K3EYAE>QSNVNCN0<RBE0>13L@O?GJ0VKT>;;D:=QT29OO@JH9BDI8AS?X<95BK=>;IPEV");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("0E-2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0E-2147483647"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0976()
  {
    rc_int = (new BigDecimal("-1")).intValue();
    Assert.assertEquals(-1, rc_int);
  }
//  public void testItem_0977()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0E-2147483647"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0978()
  {
    rc_int = (new BigDecimal("0E-2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0979()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
//  public void testItem_0980()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).setScale(2147483647, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0981()
  {
    rc_int = (new BigDecimal("-1")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0982()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("0E-2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0983()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0984()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0E-2147483647")).hashCode();
//    Assert.assertEquals(2147483647, rc_int);
//  }
  public void testItem_0985()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0987()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).negate();
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0989()
  {
    rc_String = (new BigDecimal("1")).toPlainString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0990()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("-1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0991()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\0', '\234', '\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0992()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0993()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).subtract(new BigDecimal("3E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0996()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0997()
  {
    rc_String = (new BigDecimal("3E+1")).toPlainString();
    Assert.assertEquals("30", rc_String);
  }
  public void testItem_0998()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).add(new BigDecimal("0E-2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
}
