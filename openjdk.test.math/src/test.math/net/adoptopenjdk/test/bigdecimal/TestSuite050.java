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
public class TestSuite050 extends TestCase
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
    rc_BigDecimal = (new BigDecimal("0.0")).divide(new BigDecimal("-1"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0001()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0002()
  {
    rc_boolean = (new BigDecimal("-1")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0003()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0004()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0005()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0006()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).setScale(0, java.math.RoundingMode.DOWN);
    Assert.assertEquals("10", rc_BigDecimal.toString());
  }
  public void testItem_0007()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("10"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0008()
  {
    rc_long = (new BigDecimal("1E+1")).longValue();
    Assert.assertEquals(10L, rc_long);
  }
  public void testItem_0009()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0010()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1E+1"));
    Assert.assertEquals("-10", rc_BigDecimal.toString());
  }
  public void testItem_0011()
  {
    rc_long = (new BigDecimal("-10")).longValueExact();
    Assert.assertEquals(-10L, rc_long);
  }
  public void testItem_0012()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("B71XEED4:ROK=VC5U6LNKBM8><=G1:=U;XD9HKGIGMYH:?U7WHQQ8N=1XB76=RS:2TQ4R6@F1KEWYW@<D>5HX9V@FUWT9<U0?D>F");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0013()
  {
    rc_short = (new BigDecimal("1E+1")).shortValueExact();
    Assert.assertEquals(10, rc_short);
  }
  public void testItem_0014()
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
  public void testItem_0015()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("0.0"), -2147483648, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0016()
  {
    rc_String = (new BigDecimal("10")).toEngineeringString();
    Assert.assertEquals("10", rc_String);
  }
  public void testItem_0017()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0018()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0019()
  {
    rc_BigDecimal = (new BigDecimal("10")).pow(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0020()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("10"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0021()
  {
    rc_BigDecimal = (new BigDecimal("-10")).multiply(new BigDecimal("-10"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("100", rc_BigDecimal.toString());
  }
  public void testItem_0022()
  {
    rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0023()
  {
    rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("10"), java.math.RoundingMode.HALF_UP);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0024()
  {
    rc_int = (new BigDecimal("10")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0025()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\0', '\uFFFF', '\234', '\0', '\234', '\1', '\uFFFF', '8', '\0', '\234', '\1', '\1', '8', '8', '\1', '\1', '\1', '8', '8', '\234', '\234', '8', '\1', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '\234', '\0', '\234', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\0', '8', '\1', '\0', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\1', '8', '\uFFFF', '\1', '\1', '8', '\1', '\0', '\0', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\1', '\0', '8', '\234', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\234'}, 1, -1, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0026()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0027()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\0', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\0', '8', '\0', '\0', '\0', '\0', '\0', '\0', '\234', '\234', '8', '\1', '\0', '\234', '\234', '\1', '\234', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\0', '\1', '\1', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\234', '\uFFFF', '\1', '\0', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\0', '\1', '\0', '8', '\1', '\0', '\1', '\234', '\uFFFF', '\0', '\1', '\234', '\234', '\234', '\1', '\uFFFF', '8', '8', '\1', '\234', '\234', '\uFFFF', '8', '\0', '\1', '\1', '\0', '\234', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\uFFFF'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0028()
  {
    rc_BigDecimal = (new BigDecimal("32")).max(new BigDecimal("1E+1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0029()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0030()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0031()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("1E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+3", rc_BigDecimal.toString());
  }
  public void testItem_0032()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0033()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("D@?1Q<1W1YA93:GTGBQR7H<M46KRGM5K5FAU6WYH=V;:HUQGP86PGUNYT1QDBTFB@<=CYGU3PCVQQ@>WN?9729K6M5X2X4:WF@MO");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0034()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("10"), 0, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0035()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("3.2E+2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0036()
  {
    rc_BigInteger = (new BigDecimal("3.2E+3")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0037()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0038()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+3")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3201", rc_BigDecimal.toString());
  }
  public void testItem_0039()
  {
    rc_BigInteger = (new BigDecimal("10")).unscaledValue();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0040()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0041()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '8', '\1', '8', '8', '\1', '8', '\234', '8', '\0', '\1', '\0', '8', '8', '\1', '\234', '\0', '\1', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\1', '\0', '8', '\1', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\1', '\0', '\0', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\1', '\uFFFF', '\1', '\1', '\234', '\0', '\1', '\0', '\0', '\1', '\234', '\234', '\1', '\uFFFF', '\0', '\uFFFF', '8', '8', '\234', '\uFFFF', '\1', '\1', '\0', '\1', '\234', '\0', '8', '8', '\0', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\0', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '8', '\234'}, -2147483648, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0042()
  {
    rc_BigDecimal = (new BigDecimal("10")).add(new BigDecimal("3201"));
    Assert.assertEquals("3211", rc_BigDecimal.toString());
  }
  public void testItem_0043()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("10")).divide(new BigDecimal("3211"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0044()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '8', '8', '\0', '\234', '\1', '\0', '\0', '\uFFFF', '\0', '\234', '\1', '\1', '8', '8', '8', '\uFFFF', '\234', '\234', '\0', '\1', '\1', '\234', '8', '\234', '\1', '8', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\234', '8', '\1', '8', '\234', '\1', '\1', '\1', '\uFFFF', '\0', '\1', '\0', '8', '\234', '\234', '\0', '\234', '\1', '\234', '\0', '8', '\1', '\1', '8', '\0', '\uFFFF', '\234', '\1', '\234', '8', '\234', '\234', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\0', '\234', '8', '\0', '8', '\234', '\uFFFF', '\uFFFF', '8'}, -2147483648, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0045()
  {
    rc_BigDecimal = (new BigDecimal("3201")).subtract(new BigDecimal("1"));
    Assert.assertEquals("3200", rc_BigDecimal.toString());
  }
  public void testItem_0046()
  {
    rc_BigInteger = (new BigDecimal("3211")).unscaledValue();
    Assert.assertEquals("3211", rc_BigInteger.toString());
  }
  public void testItem_0047()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0048()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("1"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0049()
  {
    rc_int = (new BigDecimal("3200")).intValue();
    Assert.assertEquals(3200, rc_int);
  }
  public void testItem_0050()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).remainder(new BigDecimal("3201"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0051()
  {
    rc_String = (new BigDecimal("3.2E+2")).toString();
    Assert.assertEquals("3.2E+2", rc_String);
  }
  public void testItem_0052()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3201"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0053()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E+2")).divide(new BigDecimal("3.2E+2"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0054()
  {
    rc_int = (new BigDecimal("3.2E+2")).scale();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0055()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0056()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0057()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\0', '8', '8', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\234', '\0', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\234', '\0', '8', '\234', '\1', '\234', '\1', '\0', '8', '\1', '\0', '\234', '\234', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\uFFFF', '8', '\1', '\1', '\0', '\0', '8', '\uFFFF', '8', '\0', '\234', '\uFFFF', '\234', '\0', '\1', '\234', '\234', '\1', '\1', '\1', '\uFFFF', '8', '\234', '8', '\1', '\234'}, -2147483648, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0058()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).subtract(new BigDecimal("3201"));
    Assert.assertEquals("-3197.8", rc_BigDecimal.toString());
  }
  public void testItem_0059()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).add(new BigDecimal("3.2"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0060()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("3201")).divideAndRemainder(new BigDecimal("-3197.8"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0061()
  {
    rc_BigDecimal = (new BigDecimal("-3197.8")).multiply(new BigDecimal("3E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-9.5934E+5", rc_BigDecimal.toString());
  }
  public void testItem_0062()
  {
    rc_BigDecimal = new BigDecimal(0.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0063()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0064()
  {
    rc_int = (new BigDecimal("3E+2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0065()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0066()
  {
    rc_BigDecimal = (new BigDecimal("3201")).negate();
    Assert.assertEquals("-3201", rc_BigDecimal.toString());
  }
  public void testItem_0067()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0068()
  {
    rc_int = (new BigDecimal("3201")).intValue();
    Assert.assertEquals(3201, rc_int);
  }
  public void testItem_0069()
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
  public void testItem_0070()
  {
    rc_BigDecimal = (new BigDecimal("-3201")).divide(new BigDecimal("-9.5934E+5"), 0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0071()
  {
    rc_BigDecimal = (new BigDecimal("-3201")).movePointLeft(0);
    Assert.assertEquals("-3201", rc_BigDecimal.toString());
  }
  public void testItem_0072()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0073()
  {
    rc_int = (new BigDecimal("3E+2")).scale();
    Assert.assertEquals(-2, rc_int);
  }
  public void testItem_0074()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).setScale(2147483647, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0075()
  {
    rc_BigDecimal = (new BigDecimal("-3201")).divide(new BigDecimal("-1"), java.math.RoundingMode.FLOOR);
    Assert.assertEquals("3201", rc_BigDecimal.toString());
  }
  public void testItem_0076()
  {
    rc_BigInteger = (new BigDecimal("3E+2")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
  public void testItem_0077()
  {
    rc_BigDecimal = (new BigDecimal("3E+2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0078()
  {
    rc_BigDecimal = (new BigDecimal("3201")).multiply(new BigDecimal("3201"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+7", rc_BigDecimal.toString());
  }
  public void testItem_0079()
  {
    rc_BigDecimal = (new BigDecimal("3201")).multiply(new BigDecimal("-3201"));
    Assert.assertEquals("-10246401", rc_BigDecimal.toString());
  }
  public void testItem_0080()
  {
    rc_short = (new BigDecimal("3E+2")).shortValueExact();
    Assert.assertEquals(300, rc_short);
  }
  public void testItem_0081()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2")).setScale(-1, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0082()
  {
    rc_BigDecimal_array = (new BigDecimal("3E+2")).divideAndRemainder(new BigDecimal("-3201"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0083()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0084()
  {
    rc_BigDecimal = (new BigDecimal("-10246401")).subtract(new BigDecimal("-10246401"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0085()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-3201")).divide(new BigDecimal("-10246401"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0086()
  {
    rc_long = (new BigDecimal("3201")).longValue();
    Assert.assertEquals(3201L, rc_long);
  }
  public void testItem_0087()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0088()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0089()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("-3201"));
    Assert.assertEquals("3233", rc_BigDecimal.toString());
  }
  public void testItem_0090()
  {
    rc_BigDecimal = (new BigDecimal("-3201")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3201", rc_BigDecimal.toString());
  }
  public void testItem_0091()
  {
    rc_float = (new BigDecimal("-10246401")).floatValue();
    Assert.assertEquals(-1.0246401E7F, rc_float, 0);
  }
  public void testItem_0092()
  {
    rc_BigDecimal = (new BigDecimal("3233")).add(new BigDecimal("3201"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("6434", rc_BigDecimal.toString());
  }
  public void testItem_0093()
  {
    rc_BigDecimal = (new BigDecimal("3201")).min(new BigDecimal("3201"));
    Assert.assertEquals("3201", rc_BigDecimal.toString());
  }
  public void testItem_0094()
  {
    rc_BigDecimal = (new BigDecimal("-10246401")).setScale(1, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("-10246401.0", rc_BigDecimal.toString());
  }
  public void testItem_0095()
  {
    rc_BigDecimal = (new BigDecimal("3201")).divide(new BigDecimal("-10246401.0"), 1, java.math.RoundingMode.CEILING);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0096()
  {
    rc_BigDecimal = (new BigDecimal("-10246401")).multiply(new BigDecimal("-10246401"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+14", rc_BigDecimal.toString());
  }
  public void testItem_0097()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0098()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0099()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3201")).setScale(-2147483648, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0100()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("-10246401.0"));
    Assert.assertEquals("-5985839.0", rc_BigDecimal.toString());
  }
  public void testItem_0101()
  {
    rc_int = (new BigDecimal("-10246401.0")).compareTo(new BigDecimal("3201"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0102()
  {
    rc_BigDecimal = (new BigDecimal("-10246401.0")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1E+7", rc_BigDecimal.toString());
  }
  public void testItem_0103()
  {
    rc_long = (new BigDecimal("-10246401")).longValue();
    Assert.assertEquals(-10246401L, rc_long);
  }
  public void testItem_0104()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\234', '\1', '8', '8', '\1', '\uFFFF', '8', '\1', '\1', '8', '8', '\uFFFF', '\0', '\1', '\0', '\1', '8', '\234', '\1', '\234', '\234', '8', '\uFFFF', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '8', '8', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '\234', '\0', '8', '8', '\0', '\uFFFF', '\1', '\1', '8', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\234', '\1', '\1', '\0', '8', '\0', '\0', '\1', '\0', '\uFFFF', '\uFFFF', '8', '8', '8', '8', '\1', '\234', '\uFFFF', '8', '\234', '\234', '\234', '\234', '\234', '\1', '\uFFFF', '\0', '8', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\0', '\uFFFF', '8', '\1'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0105()
  {
    rc_int = (new BigDecimal("-10246401")).compareTo(new BigDecimal("-1E+7"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0106()
  {
    rc_float = (new BigDecimal("-1E+7")).floatValue();
    Assert.assertEquals(-1.0E7F, rc_float, 0);
  }
  public void testItem_0107()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0108()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).remainder(new BigDecimal("3201"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3170", rc_BigDecimal.toString());
  }
  public void testItem_0109()
  {
    rc_BigInteger = (new BigDecimal("-1E+7")).toBigInteger();
    Assert.assertEquals("-10000000", rc_BigInteger.toString());
  }
  public void testItem_0110()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\0', '\234', '\0', '\1', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '8', '\234', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\uFFFF', '\234', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0111()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("3201"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0112()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3201")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0113()
  {
    rc_boolean = (new BigDecimal("-1E+7")).equals("4VF5<TOXUM<TDG<QXA67HDNOLX@XRH63L;;96BLGIXC@NB8C@1DXU0>:15;6AYBN;44C0:E0ER:FBK6JWQ;S4>U9RKCORW5B;XCS");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0114()
  {
    rc_double = (new BigDecimal("-3170")).doubleValue();
    Assert.assertEquals(-3170.0, rc_double, 0);
  }
  public void testItem_0115()
  {
    rc_BigDecimal = (new BigDecimal("-1E+7")).plus();
    Assert.assertEquals("-1E+7", rc_BigDecimal.toString());
  }
  public void testItem_0116()
  {
    rc_int = (new BigDecimal("-3170")).intValueExact();
    Assert.assertEquals(-3170, rc_int);
  }
  public void testItem_0117()
  {
    rc_int = (new BigDecimal("-2147483648")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0118()
  {
    rc_BigDecimal = (new BigDecimal("-1E+7")).divideToIntegralValue(new BigDecimal("-1E+7"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0119()
  {
    rc_BigDecimal = (new BigDecimal("3201")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+3", rc_BigDecimal.toString());
  }
  public void testItem_0120()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("precision=2147483647 roundingMode=UNNECESSARY", rc_MathContext.toString());
  }
  public void testItem_0121()
  {
    rc_String = (new BigDecimal("3E+3")).toEngineeringString();
    Assert.assertEquals("3E+3", rc_String);
  }
  public void testItem_0122()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0123()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0124()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0125()
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
  public void testItem_0126()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1E+7")).divide(new BigDecimal("1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0127()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0128()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0129()
  {
    rc_BigDecimal = (new BigDecimal("3201")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("1.5815041323378301879091967059711766129405564281684535709262997696846622987719382147208247761935968116077288035901217424566962281298493632882724781220305127918822885829221868058936344607542845917139075883540184529370444830704460967005615150237872273446714159380632415209486592352780896484573384563340399543449667136325543104071568143643673495091067663986280090638952017085337242980984664134192018037476303287161404232900961187955719815060883056039340322648210851080942366458130055427642384614627431717641960236160399342831249561019603773629695971922543849061663215179343120446774127375030154037508207204104530541373989987239424388419947156415744772198624873370309635484537250378721056621666622454141325983856098910153298309211322703049518167972564697265625E-320", rc_BigDecimal.toString());
  }
  public void testItem_0130()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0131()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1.5815041323378301879091967059711766129405564281684535709262997696846622987719382147208247761935968116077288035901217424566962281298493632882724781220305127918822885829221868058936344607542845917139075883540184529370444830704460967005615150237872273446714159380632415209486592352780896484573384563340399543449667136325543104071568143643673495091067663986280090638952017085337242980984664134192018037476303287161404232900961187955719815060883056039340322648210851080942366458130055427642384614627431717641960236160399342831249561019603773629695971922543849061663215179343120446774127375030154037508207204104530541373989987239424388419947156415744772198624873370309635484537250378721056621666622454141325983856098910153298309211322703049518167972564697265625E-320"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E-320", rc_BigDecimal.toString());
  }
  public void testItem_0132()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0133()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("C1JOYL8L4C:R<>HE?4XH3", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0134()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).add(new BigDecimal("9223372036854775807"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0135()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0136()
  {
    rc_BigDecimal = (new BigDecimal("2E+19")).divide(new BigDecimal("1"), java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("2E+19", rc_BigDecimal.toString());
  }
  public void testItem_0137()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0138()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0139()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.5815041323378301879091967059711766129405564281684535709262997696846622987719382147208247761935968116077288035901217424566962281298493632882724781220305127918822885829221868058936344607542845917139075883540184529370444830704460967005615150237872273446714159380632415209486592352780896484573384563340399543449667136325543104071568143643673495091067663986280090638952017085337242980984664134192018037476303287161404232900961187955719815060883056039340322648210851080942366458130055427642384614627431717641960236160399342831249561019603773629695971922543849061663215179343120446774127375030154037508207204104530541373989987239424388419947156415744772198624873370309635484537250378721056621666622454141325983856098910153298309211322703049518167972564697265625E-320")).divide(new BigDecimal("0"), -1, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0140()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1.5815041323378301879091967059711766129405564281684535709262997696846622987719382147208247761935968116077288035901217424566962281298493632882724781220305127918822885829221868058936344607542845917139075883540184529370444830704460967005615150237872273446714159380632415209486592352780896484573384563340399543449667136325543104071568143643673495091067663986280090638952017085337242980984664134192018037476303287161404232900961187955719815060883056039340322648210851080942366458130055427642384614627431717641960236160399342831249561019603773629695971922543849061663215179343120446774127375030154037508207204104530541373989987239424388419947156415744772198624873370309635484537250378721056621666622454141325983856098910153298309211322703049518167972564697265625E-320"));
  }
  public void testItem_0141()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0142()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.5815041323378301879091967059711766129405564281684535709262997696846622987719382147208247761935968116077288035901217424566962281298493632882724781220305127918822885829221868058936344607542845917139075883540184529370444830704460967005615150237872273446714159380632415209486592352780896484573384563340399543449667136325543104071568143643673495091067663986280090638952017085337242980984664134192018037476303287161404232900961187955719815060883056039340322648210851080942366458130055427642384614627431717641960236160399342831249561019603773629695971922543849061663215179343120446774127375030154037508207204104530541373989987239424388419947156415744772198624873370309635484537250378721056621666622454141325983856098910153298309211322703049518167972564697265625E-320")).remainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0143()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '8', '8', '\234', '\1', '8', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '8', '\uFFFF', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\1', '\1', '\234', '\0', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\uFFFF', '\234', '\1', '\1', '\1', '8', '\234', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\234', '\1', '\1'}, 2147483647, 1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0144()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0145()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0146()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0147()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0148()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0149()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0150()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0151()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0152()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0153()
  {
    rc_BigDecimal = (new BigDecimal("1")).plus();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0154()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0155()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0156()
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
  public void testItem_0157()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0158()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0159()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\1', '\1', '\uFFFF', '\234', '8', '\0', '\1', '\234', '\1', '\234', '\1', '\uFFFF', '8', '8', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\234', '\234', '\uFFFF', '\234', '\0', '\0', '\234', '\1', '\234', '\1', '\0', '\234', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\234', '\234', '\234', '\1', '\234', '\234', '8', '8', '\234', '8', '\0', '\uFFFF', '\0', '\234', '\1', '8', '\234', '\uFFFF', '\0', '\234', '\1', '\0', '\0', '\234', '\uFFFF', '\1', '\0', '\234', '8', '\234', '\uFFFF', '\1', '\0', '\234', '\234', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '8'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0160()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0161()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0162()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0163()
  {
    rc_int = (new BigDecimal("-2147483648")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0164()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).scaleByPowerOfTen(0);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0165()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0166()
  {
    rc_boolean = (new BigDecimal("1")).equals("WOTJ93@4<?<S=5G2091V>P>9JTE7MHLQ>?4F7T:3@RX?DK6YJI>T3K2@;V=6<U2>2SX4BI89YG3<V@JE37KT0EXP:5=SF=OAJOIX");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0167()
  {
    rc_int = (new BigDecimal("-2147483648")).intValue();
    Assert.assertEquals(-2147483648, rc_int);
  }
  public void testItem_0168()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0169()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0170()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
  public void testItem_0171()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0172()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0173()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0174()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0175()
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
  public void testItem_0176()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0177()
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
//  public void testItem_0178()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0179()
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
  public void testItem_0180()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0181()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), 1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0182()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0183()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 0, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0184()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0185()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0186()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).setScale(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0187()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0188()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0189()
  {
    rc_int = (new BigDecimal("0.0")).precision();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0190()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("0E-2147483647")).multiply(new BigDecimal("0E-2147483647"));
//    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0191()
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
  public void testItem_0192()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\1', '8', '\0', '8', '\0', '\1', '\234', '\0', '\uFFFF', '8', '\234', '\uFFFF', '\234', '\1', '\234', '\1', '\1', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '8', '\uFFFF', '\0', '\234', '\1', '8', '8', '\uFFFF', '\1', '\1', '\234', '\uFFFF', '\1', '\0', '\uFFFF', '\1', '\1', '8', '\234', '\uFFFF', '\234', '\0', '\1', '\1', '\234', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '\1', '\0', '\uFFFF', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '8', '\234', '\1', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '8', '\0', '\uFFFF', '\1', '\1', '\uFFFF', '\0', '\0', '8', '\uFFFF', '\1', '\1', '8', '\uFFFF', '\1', '\234', '\1', '8', '\uFFFF', '\1', '\uFFFF'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0193()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0194()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0195()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0196()
  {
    rc_boolean = (new BigDecimal("0.0")).equals("0VK<WU3D4TL?EUBSHYU::YVO>W4=7LV3B256WDYPAYDEI9I=BGMT>OIENIB>60CA?FT2PLGA72Y:TWMA7:XA86P?@");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0197()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divide(new BigDecimal("0"), 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0198()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0199()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0200()
  {
    rc_BigInteger = (new BigDecimal("0.0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0201()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0202()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0203()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(0, java.math.RoundingMode.HALF_EVEN);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0204()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0205()
  {
    rc_double = (new BigDecimal("0")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0206()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
//  public void testItem_0207()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E-2147483647")).pow(-1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.IllegalArgumentException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0208()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0209()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0210()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("0E-2147483647")).divideAndRemainder(new BigDecimal("0.0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0211()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0.0"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0212()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("JF6?J8FE=8HH?J22TX1BBVG97FL:JQS;8L3QHEK1O5UWG>EQNYA=CRBJ=P42;C8F9TXEA0NOPU3S528RJ2G2LXQ=H083<");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0213()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2W=4>QMUMMKDSO8R@LO<68G1HDLAMNMNBW;E>YOJ86VG:@WN9X;T;QO1E83QPC;HN:VBLOP6TL@4>>O;85R?0CKV:9FW?LAGCJNW");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0214()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0215()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0216()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.0")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0217()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0218()
  {
    rc_int = (new BigDecimal("0.0")).scale();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0219()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0220()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).max(new BigDecimal("0.0"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0221()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("2147483647"), 0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0222()
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
  public void testItem_0223()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0224()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0225()
  {
    rc_String = (new BigDecimal("9223372036854775807")).toEngineeringString();
    Assert.assertEquals("9223372036854775807", rc_String);
  }
  public void testItem_0226()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("9223372036854775807")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0227()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0228()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigInteger();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0229()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2147483647")).setScale(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0230()
  {
    rc_int = (new BigDecimal("2147483647")).intValue();
    Assert.assertEquals(2147483647, rc_int);
  }
  public void testItem_0231()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0232()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0233()
  {
    rc_String = (new BigDecimal("-32")).toString();
    Assert.assertEquals("-32", rc_String);
  }
  public void testItem_0234()
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
  public void testItem_0235()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0236()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '8', '\234', '8', '\1', '\234', '8', '\1', '\1', '\234', '\uFFFF', '8', '8', '\1', '\234', '\234', '\234', '\0', '\1', '\0', '\0', '\234', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\1', '8', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\234', '\uFFFF', '8', '8', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '8', '\234', '\0', '\0', '\uFFFF', '8', '\0', '8', '\1', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\234', '8', '\234', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\0', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\0', '\1', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '8', '\0', '\0', '\1'}, -1, -2147483648);
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
      rc_BigDecimal = (new BigDecimal("3.2")).divide(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0238()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0239()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, -2147483648, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0240()
  {
    rc_BigDecimal = (new BigDecimal("-32")).movePointLeft(1);
    Assert.assertEquals("-3.2", rc_BigDecimal.toString());
  }
  public void testItem_0241()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\1', '\0', '\234', '\1', '\1', '\234', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\1', '\234', '\uFFFF', '\1', '\1', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\uFFFF', '\1', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\234', '\234', '8', '\1', '\234', '\1', '\0', '\234', '8', '8', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0242()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0243()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0244()
  {
    rc_BigDecimal = (new BigDecimal("-3.2")).subtract(new BigDecimal("-3.2"));
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0245()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0246()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0247()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
//  public void testItem_0248()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal_array = (new BigDecimal("32")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0249()
  {
    rc_BigDecimal = (new BigDecimal("-1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0250()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(-1, java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0251()
  {
    rc_long = (new BigDecimal("0E+1")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0252()
  {
    rc_long = (new BigDecimal("32")).longValueExact();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0253()
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
  public void testItem_0254()
  {
    rc_int = (new BigDecimal("-1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0255()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'}, 2147483647, 0);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0256()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0257()
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
  public void testItem_0258()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0259()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0260()
  {
    rc_String = (new BigDecimal("0E+1")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0261()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0262()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0263()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0264()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0265()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0266()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.UP);
    Assert.assertEquals("precision=2147483647 roundingMode=UP", rc_MathContext.toString());
  }
  public void testItem_0267()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0268()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigInteger();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0269()
  {
    rc_BigInteger = (new BigDecimal("0E+1")).toBigInteger();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
//  public void testItem_0270()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0271()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("7U07T?@XHNBM<LUW2ABP@3K6JIABBSED7S");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0272()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0273()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0274()
  {
    rc_BigDecimal = new BigDecimal(new char[]{'8'});
    Assert.assertEquals("8", rc_BigDecimal.toString());
  }
  public void testItem_0275()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0276()
  {
    rc_BigDecimal = new BigDecimal(0.0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0277()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0278()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0279()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0280()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0281()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0282()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0283()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0284()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0285()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(1, java.math.RoundingMode.FLOOR);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0286()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0287()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0288()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0289()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0290()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0291()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0292()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0293()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0294()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0295()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0296()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("ROE707JBSF<GW>MI5IIK?4=DUUW?RT:><>P52T<N0HNKWND5EU559EMI396CX134IU=B64=4XG8MOWN:E?SS243H9W1XSFR>GJ34", new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0297()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0298()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0299()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0300()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0301()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0302()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
//  public void testItem_0303()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0304()
  {
    rc_BigDecimal = (new BigDecimal("-32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0305()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0306()
  {
    rc_BigDecimal_array = (new BigDecimal("0")).divideAndRemainder(new BigDecimal("1"));
  }
  public void testItem_0307()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2", rc_BigDecimal.toString());
  }
//  public void testItem_0308()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648, java.math.RoundingMode.HALF_UP);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0309()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0310()
  {
    rc_int = (new BigDecimal("-1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0311()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2")).divideAndRemainder(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0312()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("5G=HHI25L19G2BPNIA2L62JS91=XP=W");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0313()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0314()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0315()
  {
    rc_int = (new BigDecimal("3.2")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0316()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0317()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0318()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0319()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0320()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1"), java.math.RoundingMode.UP);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0321()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-2147483648, java.math.RoundingMode.HALF_UP);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0322()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0323()
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
  public void testItem_0324()
  {
    rc_BigDecimal = (new BigDecimal("0")).subtract(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0325()
  {
    rc_BigDecimal = (new BigDecimal("1")).scaleByPowerOfTen(1);
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0326()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, 1, 1, new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0327()
  {
    rc_BigDecimal = (new BigDecimal("1")).subtract(new BigDecimal("0"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0328()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).pow(2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0329()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0330()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0331()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0332()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\234', '\234', '\1', '\uFFFF', '\1', '\uFFFF', '\1', '\234', '8', '\1', '8', '8', '\0', '\1', '\234', '8', '\uFFFF', '\1', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\0', '\234', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0333()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("1E+1"));
    Assert.assertEquals("9", rc_BigDecimal.toString());
  }
  public void testItem_0334()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus(new MathContext("precision=2147483647 roundingMode=UNNECESSARY"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0335()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0336()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).ulp();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0337()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0338()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0339()
  {
    rc_int = (new BigDecimal("-1")).compareTo(new BigDecimal("9"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0340()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).plus();
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0341()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0342()
  {
    rc_BigDecimal = (new BigDecimal("0")).setScale(-1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0343()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0"), 1, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0344()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("9"));
    Assert.assertEquals("9E+1", rc_BigDecimal.toString());
  }
  public void testItem_0345()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0346()
  {
    rc_int = (new BigDecimal("0")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0347()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0348()
  {
    rc_BigDecimal = (new BigDecimal("9E+1")).abs();
    Assert.assertEquals("9E+1", rc_BigDecimal.toString());
  }
  public void testItem_0349()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0350()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).pow(1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0351()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1")).hashCode();
//    Assert.assertEquals(31, rc_int);
//  }
  public void testItem_0352()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0353()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).subtract(new BigDecimal("2E+308"));
    Assert.assertEquals("0E+308", rc_BigDecimal.toString());
  }
  public void testItem_0354()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0355()
  {
    rc_int = (new BigDecimal("-1E+1")).intValue();
    Assert.assertEquals(-10, rc_int);
  }
  public void testItem_0356()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\234', '\1'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0357()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  public void testItem_0358()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).multiply(new BigDecimal("2E+308"));
    Assert.assertEquals("2E+309", rc_BigDecimal.toString());
  }
  public void testItem_0359()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("2E+309")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0360()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0361()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).divide(new BigDecimal("-1"));
    Assert.assertEquals("-2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0362()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0363()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0364()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0365()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0366()
  {
    rc_long = (new BigDecimal("3E+1")).longValueExact();
    Assert.assertEquals(30L, rc_long);
  }
  public void testItem_0367()
  {
    rc_String = (new BigDecimal("32")).toEngineeringString();
    Assert.assertEquals("32", rc_String);
  }
//  public void testItem_0368()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).setScale(-2147483648, 1);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0369()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("-1E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-11", rc_BigDecimal.toString());
  }
  public void testItem_0370()
  {
    rc_int = (new BigDecimal("1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0371()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("O");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0372()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0373()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0374()
  {
    rc_int = (new BigDecimal("-11")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0375()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0376()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0377()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("1"), -1, 0);
    Assert.assertEquals("-1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0378()
  {
    rc_BigDecimal = (new BigDecimal("-1E+1")).add(new BigDecimal("3E+1"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0379()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1E+1")).divide(new BigDecimal("3E+1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0380()
  {
    rc_BigDecimal = (new BigDecimal("3E+1")).plus();
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0381()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0382()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+1")).divide(new BigDecimal("-1E+1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0383()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0384()
  {
    rc_long = (new BigDecimal("1")).longValue();
    Assert.assertEquals(1L, rc_long);
  }
  public void testItem_0385()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+1")).pow(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0386()
  {
    rc_BigDecimal = (new BigDecimal("2E+1")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0387()
  {
    rc_BigDecimal = new BigDecimal(1L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0388()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).divideToIntegralValue(new BigDecimal("2E+1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0389()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\1', '\0', '8', '\0', '8', '\234', '\234', '8', '\0', '\uFFFF', '8', '\234', '\1', '\uFFFF', '8', '\uFFFF', '\0', '\1', '8', '\234', '\234', '8', '8', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '\234', '\uFFFF', '8', '\1', '\0', '8', '\uFFFF', '\1', '\1', '8', '\0', '\1', '\uFFFF', '\0', '\0', '8', '8', '\1', '\0', '\1', '\234', '8', '\uFFFF', '\234', '\0', '\234', '8', '\1', '\234', '\1', '8', '\0', '\1'}, 1, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0390()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).add(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0391()
  {
    rc_String = (new BigDecimal("-2E+1")).toString();
    Assert.assertEquals("-2E+1", rc_String);
  }
  public void testItem_0392()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0393()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '8', '\234', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\0', '\uFFFF', '\uFFFF', '\1', '\234', '\1', '\0', '\1', '\234', '\0', '\1', '\1', '\234', '\0', '8', '\uFFFF', '\1', '\234', '\0', '8', '8', '\234', '\234', '\uFFFF', '8', '8', '\1', '8', '\0'}, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
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
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0395()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0396()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0397()
  {
    rc_String = (new BigDecimal("-2E+1")).toString();
    Assert.assertEquals("-2E+1", rc_String);
  }
  public void testItem_0398()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0399()
  {
    rc_int = (new BigDecimal("1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0400()
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
  public void testItem_0401()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).divide(new BigDecimal("1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-2E+1", rc_BigDecimal.toString());
  }
  public void testItem_0402()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0403()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).remainder(new BigDecimal("-2E+1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0404()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\0', '8', '\0', '\234', '\uFFFF', '\1', '\uFFFF', '\1', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '8', '8', '\1', '8', '\0', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\234', '\234', '\1', '\234', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '\234', '\1', '\234', '\234', '8', '\0', '8', '8', '\uFFFF', '\1', '8', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\234', '\0', '\1', '\0', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\1', '\1', '8', '\234', '\234', '\1', '\0', '\0', '\234', '8', '\uFFFF', '\234', '\0', '\0', '\0', '\0', '\0', '8', '\uFFFF', '8', '\1', '\234', '\234'}, -1, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0405()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).subtract(new BigDecimal("-2E+1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0406()
  {
    rc_BigDecimal = (new BigDecimal("-2E+1")).multiply(new BigDecimal("0E+1"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0E+2", rc_BigDecimal.toString());
  }
  public void testItem_0407()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '\0', '\234', '\1', '\1', '8', '\0', '\0', '\234', '\234', '\1', '\uFFFF', '\1', '\234', '\0', '\uFFFF', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '8', '\0', '8', '\uFFFF', '\1', '\1', '\uFFFF', '\uFFFF', '\1', '\0', '\234', '8', '\1', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\1', '8', '\uFFFF', '8', '8', '\1', '8', '8', '\uFFFF', '\uFFFF', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '\0', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '8', '8', '8', '\uFFFF', '\234', '\0', '\1', '8', '\1', '8', '\1', '8', '\1', '\0', '8', '\uFFFF', '\1', '8', '8', '\234', '\1', '\uFFFF', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '8', '\1', '8', '\0', '\0', '\uFFFF', '8'}, 2147483647, -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0408()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0409()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("0E+1"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0410()
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
  public void testItem_0411()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0412()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).min(new BigDecimal("0"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0413()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0414()
  {
    rc_BigDecimal = new BigDecimal(1L);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0415()
  {
    rc_int = (new BigDecimal("0E+1")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0416()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).divide(new BigDecimal("9E+18"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-17", rc_BigDecimal.toString());
  }
  public void testItem_0417()
  {
    rc_BigDecimal = (new BigDecimal("9E+18")).movePointLeft(2147483647);
    Assert.assertEquals("9E-2147483629", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0418()
  {
    rc_boolean = (new BigDecimal("9E-2147483629")).equals("?7ROFGS2@VE<TN1YJ7J?M54A5IP2JTPF:GL9VC@>KB5;R=OO56GHU1");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0419()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("9E-2147483629"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0420()
  {
    rc_BigInteger = (new BigDecimal("0")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0421()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0422()
  {
    rc_BigDecimal = (new BigDecimal("9E-2147483629")).divide(new BigDecimal("9E+18"), 2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0423()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("1E-2147483647"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0424()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0425()
  {
    rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("32"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0426()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointLeft(2147483647);
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0427()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0428()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("1E-2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0429()
  {
    rc_short = (new BigDecimal("32")).shortValueExact();
    Assert.assertEquals(32, rc_short);
  }
  public void testItem_0430()
  {
    rc_BigDecimal = (new BigDecimal("1")).setScale(1, 0);
    Assert.assertEquals("1.0", rc_BigDecimal.toString());
  }
//  public void testItem_0431()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0432()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0")).divide(new BigDecimal("32"), -2147483648, 1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0433()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0434()
  {
    rc_float = (new BigDecimal("1.0")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0435()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0436()
  {
    rc_BigDecimal = new BigDecimal(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0437()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0438()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0439()
  {
    rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("3"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0440()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).ulp();
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0441()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1E-2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0442()
  {
    rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("32"));
    Assert.assertEquals("0.09375", rc_BigDecimal.toString());
  }
  public void testItem_0443()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).negate(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0444()
  {
    rc_BigDecimal = (new BigDecimal("1.0")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0445()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\234', '\1', '\uFFFF', '\234', '\uFFFF', '\234', '\uFFFF', '\1', '\uFFFF', '\234', '8', '8', '\234', '\234', '\0', '8', '\234', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\1', '\1', '\1', '8', '\0', '\0', '\1', '\234', '\234', '\234', '\1', '\0', '\234', '\0', '\uFFFF', '8', '8', '\234', '\1', '\0', '8', '8', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '8', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '\uFFFF', '8', '8', '\234', '\1', '8', '\uFFFF', '8', '\234', '\0', '\1', '\uFFFF', '\234', '\0', '\234', '\234', '\0', '8', '8', '\uFFFF', '\1', '8', '8', '\1', '\0', '\0', '\1', '\1', '\1', '\234', '\uFFFF', '\uFFFF', '8', '8', '\0'}, 2147483647, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0446()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).setScale(-1, java.math.RoundingMode.HALF_EVEN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0447()
  {
    rc_double = (new BigDecimal("1E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0448()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0449()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0450()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0451()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("3"), -2147483648, java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0452()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3")).divide(new BigDecimal("1.0E+2147483647"), java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0453()
  {
    rc_int = (new BigDecimal("0")).signum();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0454()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E-2147483647")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0455()
  {
    rc_BigDecimal_array = (new BigDecimal("1E-2147483647")).divideAndRemainder(new BigDecimal("-1.0"));
  }
  public void testItem_0456()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=:AG6QT@7I<5:BFIC<>UU>XK?L94XW?V2BM4CA@<3G0AR=06S=L?=68L@X8R?A8:W9TNV5IANMYML@INYQ@Q7=<90EP@F?;J6TU9");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0457()
  {
    rc_BigDecimal = new BigDecimal(0, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0458()
  {
    rc_BigDecimal = (new BigDecimal("1E-2147483647")).max(new BigDecimal("0"));
    Assert.assertEquals("1E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0459()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).ulp();
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0460()
  {
    rc_String = (new BigDecimal("0")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0461()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0462()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("6M4H=C2I>B2WT2DQD@B:D1J=UVDJ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0463()
  {
    rc_int = (new BigDecimal("0")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0464()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483646")).divide(new BigDecimal("1E-2147483647"), 1, java.math.RoundingMode.HALF_DOWN);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0465()
  {
    rc_BigDecimal = new BigDecimal(1, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0466()
  {
    rc_BigDecimal = new BigDecimal(-9223372036854775808L, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0467()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0468()
  {
    rc_BigDecimal = (new BigDecimal("1")).abs();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0469()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0470()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0471()
  {
    rc_BigDecimal = (new BigDecimal("-1")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0472()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0473()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("1E+2147483646"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0474()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0475()
  {
    rc_BigDecimal = (new BigDecimal("0")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.0", rc_BigDecimal.toString());
  }
  public void testItem_0476()
  {
    rc_BigDecimal = (new BigDecimal("0.0")).ulp();
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0477()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.1"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0478()
  {
    rc_String = (new BigDecimal("0.0")).toString();
    Assert.assertEquals("0.0", rc_String);
  }
  public void testItem_0479()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).multiply(new BigDecimal("1E+2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0480()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.DOWN);
    Assert.assertEquals("precision=2147483647 roundingMode=DOWN", rc_MathContext.toString());
  }
  public void testItem_0481()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0.1"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0482()
  {
    rc_String = (new BigDecimal("0.1")).toPlainString();
    Assert.assertEquals("0.1", rc_String);
  }
  public void testItem_0483()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1.0E+2147483647"));
    Assert.assertEquals("1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0484()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0485()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).max(new BigDecimal("1E+2147483646"));
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0486()
  {
    rc_BigDecimal_array = (new BigDecimal("0E+1")).divideAndRemainder(new BigDecimal("1.0E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
//  public void testItem_0487()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1E+2147483646")).hashCode();
//    Assert.assertEquals(-2147483615, rc_int);
//  }
  public void testItem_0488()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0489()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).setScale(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0490()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0491()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0492()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0493()
  {
    rc_int = (new BigDecimal("1.0E+2147483647")).precision();
    Assert.assertEquals(2, rc_int);
  }
  public void testItem_0494()
  {
    rc_int = (new BigDecimal("1.0E+2147483647")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0495()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0496()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).subtract(new BigDecimal("0E+1"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0497()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483646")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0498()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1E+2147483646")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0499()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483646")).abs(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0500()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).divide(new BigDecimal("0E+1"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0501()
  {
    rc_int = (new BigDecimal("1.0E+2147483647")).scale();
    Assert.assertEquals(-2147483646, rc_int);
  }
//  public void testItem_0502()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).add(new BigDecimal("0"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0503()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
//  public void testItem_0504()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0E+1")).subtract(new BigDecimal("1E+2147483646"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0505()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointRight(1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0506()
  {
    rc_BigDecimal = (new BigDecimal("1E+2147483646")).ulp();
    Assert.assertEquals("1E+2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0507()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("1.0E+2147483647")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0508()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0509()
  {
    rc_BigDecimal = (new BigDecimal("0E+1")).round(new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
//  public void testItem_0510()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E+2147483646")).setScale(0);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0511()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0512()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\0', '8', '\234', '\uFFFF', '8', '8', '\1', '8', '\0', '\1', '\uFFFF', '8', '8', '8', '\1', '\uFFFF', '\0', '\0', '8', '\0', '\1', '\uFFFF', '\1', '8', '\234', '\0', '\1', '8', '\uFFFF', '8', '\0', '\uFFFF', '\uFFFF', '8', '\uFFFF', '\0', '\1', '\234', '\234', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\1', '\1', '\0', '\0', '\234', '8', '8', '\234', '\uFFFF', '8', '\1', '\1', '\234', '\234', '\1', '\234', '\1', '\234', '\uFFFF', '\1', '\0', '8', '\0', '\0', '\uFFFF', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\uFFFF', '8', '\234', '8', '8', '8', '8', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\0', '\0', '\234', '\1', '\234', '\0', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\1'}, 2147483647, -1, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0513()
  {
    rc_BigDecimal = (new BigDecimal("-1")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0514()
  {
    rc_String = (new BigDecimal("-1")).toString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0515()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("0")).hashCode();
//    Assert.assertEquals(0, rc_int);
//  }
  public void testItem_0516()
  {
    rc_BigDecimal = (new BigDecimal("1.0E+2147483647")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0517()
  {
    rc_String = (new BigDecimal("-1")).toEngineeringString();
    Assert.assertEquals("-1", rc_String);
  }
  public void testItem_0518()
  {
    rc_BigDecimal = (new BigDecimal("0")).plus();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0519()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0520()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).round(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3", rc_BigDecimal.toString());
  }
  public void testItem_0521()
  {
    rc_BigDecimal = (new BigDecimal("3")).multiply(new BigDecimal("1E+2147483646"));
    Assert.assertEquals("3E+2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0522()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).subtract(new BigDecimal("3.2"));
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0523()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3E+2147483646")).divide(new BigDecimal("-1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0524()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0525()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0526()
  {
    rc_short = (new BigDecimal("-1")).shortValueExact();
    Assert.assertEquals(-1, rc_short);
  }
  public void testItem_0527()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0<3?IV7N2HRVO54LYDTR6>42N>8>QY3KJQXD9P?H9IYE?VMR<VCV?>6U;50:TQ8X?MDI0F92GRTM3>O5SKI5HMOXE0LV7VCVS3B1");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0528()
  {
    rc_BigInteger = (new BigDecimal("3")).unscaledValue();
    Assert.assertEquals("3", rc_BigInteger.toString());
  }
//  public void testItem_0529()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).divide(new BigDecimal("-1"), 1, 0);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0530()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0531()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=5FAL>I<Q=KKW6MS37Q?0Q9=N?8G62;SHTHDBWJ63?=H:E:HV825");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0532()
  {
    rc_String = (new BigDecimal("-1")).toPlainString();
    Assert.assertEquals("-1", rc_String);
  }
//  public void testItem_0533()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1.0E+2147483647"), 1);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0534()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).remainder(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
//    Assert.assertEquals("-1.0E+2147483647", rc_BigDecimal.toString());
//    }
//  }
  public void testItem_0535()
  {
    rc_BigDecimal = (new BigDecimal("-1")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0536()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).remainder(new BigDecimal("-1"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    Assert.assertEquals("-1.0E+2147483647", rc_BigDecimal.toString());
//  }
  public void testItem_0537()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).negate(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0538()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).multiply(new BigDecimal("-1E+2147483647"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0539()
  {
    rc_boolean = (new BigDecimal("-1.0E+2147483647")).equals("0DGNM0UYX7QSHOPCQ5YQHIHISYF<ADBM0M@N2U");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0540()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0541()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0542()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0543()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).abs();
    Assert.assertEquals("1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0544()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).divide(new BigDecimal("-1.0E+2147483647"), java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0545()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).setScale(-2147483648, 1);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0546()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("-1.0E+2147483647")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0547()
  {
    rc_int = (new BigDecimal("-1.0E+2147483647")).precision();
    Assert.assertEquals(2, rc_int);
  }
//  public void testItem_0548()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).setScale(-1, java.math.RoundingMode.UP);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0549()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("-1.0E+2147483647"), 0, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0550()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0551()
  {
    rc_BigDecimal = (new BigDecimal("-1E+2147483647")).subtract(new BigDecimal("-1.0E+2147483647"));
    Assert.assertEquals("0E+2147483646", rc_BigDecimal.toString());
  }
//  public void testItem_0552()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
//  public void testItem_0553()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).divideToIntegralValue(new BigDecimal("-1.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0554()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).divide(new BigDecimal("00.0E+2147483647"), new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0555()
  {
    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0556()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).movePointLeft(-2147483648);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0557()
  {
    rc_int = (new BigDecimal("00.0E+2147483647")).precision();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0558()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("00.0E+2147483647"), -2147483648, java.math.RoundingMode.FLOOR);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0559()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0560()
  {
    rc_BigInteger = (new BigDecimal("0")).toBigIntegerExact();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0561()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("00.0E+2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0562()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0563()
  {
    rc_int = (new BigDecimal("-1E+2147483647")).signum();
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0564()
  {
    rc_BigDecimal = (new BigDecimal("0")).min(new BigDecimal("-1E+2147483647"));
    Assert.assertEquals("-1E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0565()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0566()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0567()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1.0E+2147483647")).toBigInteger();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0568()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0569()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).max(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0570()
  {
    rc_double = (new BigDecimal("-1.0E+2147483647")).doubleValue();
    Assert.assertEquals(java.lang.Double.NEGATIVE_INFINITY, rc_double, 0);
  }
  public void testItem_0571()
  {
    rc_int = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).precision();
    Assert.assertEquals(309, rc_int);
  }
  public void testItem_0572()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0573()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).multiply(new BigDecimal("00.0E+2147483647"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0574()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("2VH7Q;9FTKW<I0<AG91R<<8;?HQQP;EI4EJT09HE8FPTG;>1@PFJ6LRAW8X74KRDB6I:CGW3><W419RUE60@FAQJII0S:VA2WM<K");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0575()
  {
    rc_boolean = (new BigDecimal("0E+2147483646")).equals("I67>V193MX8JB1BY?LXNB4");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0576()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '\uFFFF', '\1', '\1', '\uFFFF', '\234', '\1', '\1', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\0', '\0', '8', '\1', '\1', '\234', '\0', '8', '\234', '\uFFFF', '\234', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\1', '\0', '8', '\0', '\uFFFF', '8', '\234', '\234', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0577()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).abs();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
//  public void testItem_0578()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("00.0E+2147483647")).plus();
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0579()
  {
    rc_MathContext = new MathContext(1);
    Assert.assertEquals("precision=1 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0580()
  {
    rc_String = (new BigDecimal("00.0E+2147483647")).toPlainString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0581()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("BF7", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0582()
  {
    rc_BigDecimal = (new BigDecimal("-1.0E+2147483647")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1.0E+2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0583()
  {
    rc_BigDecimal = new BigDecimal(1.0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0584()
  {
    rc_int = (new BigDecimal("1")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0585()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0586()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0587()
  {
    rc_BigInteger = (new BigDecimal("0E+2147483646")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0588()
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
  public void testItem_0589()
  {
    rc_BigInteger = (new BigDecimal("32")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0590()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).round(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0591()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).movePointLeft(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0592()
  {
    rc_BigInteger = (new BigDecimal("32")).toBigIntegerExact();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0593()
  {
    rc_BigDecimal = (new BigDecimal("32")).pow(0, new MathContext("precision=2147483647 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0594()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("-1.0E+2147483647"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0595()
  {
    rc_MathContext = new MathContext(0);
    Assert.assertEquals("precision=0 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0596()
  {
    rc_BigDecimal = (new BigDecimal("0E+2147483646")).divide(new BigDecimal("-1.0E+2147483647"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0597()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("1")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0598()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("-1.0E+2147483647")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0599()
  {
    rc_BigDecimal = (new BigDecimal("32")).movePointLeft(2147483647);
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0600()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("=41V?K2GCVB>MHYS:5C4588IJ90F:90HIKP4FC=:>PD=TFB1P;6X;8V6V9G5L1XWGSS=P3:GF3Y4YP6>OWXT@OFD<", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0601()
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
//  public void testItem_0602()
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
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0603()
  {
    rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0604()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\uFFFF', '\0', '\uFFFF', '\1', '\234', '\0', '8', '\1', '8', '\0', '\0', '\234', '\0', '\uFFFF', '\0', '\234', '8', '\0', '\uFFFF', '8', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\234', '\0', '\234', '\uFFFF', '8', '\1', '\1', '\234', '\1', '\234', '\234', '\0', '8', '\234', '8', '\uFFFF', '\0', '\1', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '\uFFFF', '\0', '\234', '8', '\uFFFF', '\0', '8', '\1', '8', '\1', '\uFFFF', '\0', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\uFFFF', '8', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\0', '\234', '\1', '8', '8', '\uFFFF', '\0', '8', '\1', '\0', '\uFFFF', '8', '8', '\1', '\uFFFF', '\234', '\234', '\uFFFF', '\0', '\234', '\1', '\1', '\1'}, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0605()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0606()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("2U7=DUCB=98?N37QF>:BJ0;0V4WJ<0:JOE3;HVHIJ1MH>BWU8SB=4=0V5121TM0P?L392>HLUSXP1WJ");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0607()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0608()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0609()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0610()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).setScale(-1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0611()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308);
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0612()
  {
    rc_double = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).doubleValue();
    Assert.assertEquals(1.7976931348623157E308, rc_double, 0);
  }
  public void testItem_0613()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).pow(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("6E-309", rc_BigDecimal.toString());
  }
  public void testItem_0614()
  {
    rc_int = (new BigDecimal("0")).intValueExact();
    Assert.assertEquals(0, rc_int);
  }
//  public void testItem_0615()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0616()
  {
    rc_BigDecimal = (new BigDecimal("0")).movePointLeft(2147483647);
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0617()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
//  public void testItem_0618()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("6E-309"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0619()
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
  public void testItem_0620()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0621()
  {
    rc_BigDecimal = (new BigDecimal("6E-309")).divideToIntegralValue(new BigDecimal("-1"));
    Assert.assertEquals("0E-309", rc_BigDecimal.toString());
  }
  public void testItem_0622()
  {
    rc_BigDecimal = (new BigDecimal("1")).multiply(new BigDecimal("0E-2147483647"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0623()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0624()
  {
    rc_double = (new BigDecimal("-1")).doubleValue();
    Assert.assertEquals(-1.0, rc_double, 0);
  }
  public void testItem_0625()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0626()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).plus(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
//  public void testItem_0627()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("32")).hashCode();
//    Assert.assertEquals(992, rc_int);
//  }
  public void testItem_0628()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0E-2147483647")).divideToIntegralValue(new BigDecimal("0E-309"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0629()
  {
    rc_BigDecimal = (new BigDecimal("0E-309")).movePointRight(1);
    Assert.assertEquals("0E-308", rc_BigDecimal.toString());
  }
  public void testItem_0630()
  {
    rc_BigDecimal = (new BigDecimal("-1")).add(new BigDecimal("0E-309"));
    Assert.assertEquals("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0631()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0632()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0633()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0634()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0635()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0636()
  {
    rc_String = (new BigDecimal("0")).toEngineeringString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0637()
  {
    rc_double = (new BigDecimal("0E-2147483647")).doubleValue();
    Assert.assertEquals(0.0, rc_double, 0);
  }
  public void testItem_0638()
  {
    rc_BigDecimal = (new BigDecimal("0E-309")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-309", rc_BigDecimal.toString());
  }
  public void testItem_0639()
  {
    rc_BigInteger = (new BigDecimal("0E-2147483647")).unscaledValue();
    Assert.assertEquals("0", rc_BigInteger.toString());
  }
  public void testItem_0640()
  {
    rc_BigDecimal = (new BigDecimal("0E-2147483647")).remainder(new BigDecimal("1"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0641()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0642()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0643()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("-1"), java.math.RoundingMode.CEILING);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0644()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0645()
  {
    rc_BigDecimal = (new BigDecimal("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).scaleByPowerOfTen(0);
    Assert.assertEquals("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0646()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0647()
  {
    rc_BigDecimal = (new BigDecimal("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).ulp();
    Assert.assertEquals("1E-309", rc_BigDecimal.toString());
  }
  public void testItem_0648()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1E-309")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0649()
  {
    rc_BigInteger = (new BigDecimal("-1")).toBigIntegerExact();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0650()
  {
    rc_BigDecimal = new BigDecimal(1.0, new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0651()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0652()
  {
    rc_boolean = (new BigDecimal("1E-309")).equals("NGJ;V5YB:00A=JR<0>:?=:IY=0CT4XKV63M1VTATW7IY7?:3WDXXUO3W1SG28I6OMQ5QV2NA?T=4PP8LM2O6:Q52FMJ9ROTXIQ3H");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0653()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF', '8'}, 1, -2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0654()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("-32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0655()
  {
    rc_BigDecimal_array = (new BigDecimal("-1.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).divideAndRemainder(new BigDecimal("1E-309"), new MathContext("precision=0 roundingMode=HALF_UP"));
  }
  public void testItem_0656()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0657()
  {
    rc_BigDecimal = new BigDecimal(-1.0);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0658()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("-1"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0659()
  {
    rc_byte = (new BigDecimal("1")).byteValueExact();
    Assert.assertEquals(1, rc_byte);
  }
  public void testItem_0660()
  {
    rc_String = (new BigDecimal("1E-309")).toEngineeringString();
    Assert.assertEquals("1E-309", rc_String);
  }
  public void testItem_0661()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0662()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1E-309")).setScale(2147483647, java.math.RoundingMode.HALF_DOWN);
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0663()
  {
    rc_BigDecimal = (new BigDecimal("32")).negate(new MathContext("precision=2147483647 roundingMode=DOWN"));
    Assert.assertEquals("-32", rc_BigDecimal.toString());
  }
  public void testItem_0664()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).pow(-1, new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0665()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-32")).divideToIntegralValue(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=DOWN"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0666()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("-32.000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0667()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0668()
  {
    rc_BigDecimal = (new BigDecimal("1")).min(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0669()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\0', '\234', '8', '\uFFFF', '8', '\1', '8', '8', '\0', '\0', '\uFFFF', '\234', '\234', '\234', '\1', '8', '\uFFFF', '8', '\0', '\1', '\0', '8', '\0', '8', '\uFFFF', '\234', '\uFFFF', '8', '\uFFFF', '\234', '\uFFFF', '\0', '\1', '\0', '\234', '8', '\0'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0670()
  {
    rc_boolean = (new BigDecimal("1")).equals("YWBMX??F1LRF>I>0S55>E<FMC85DJF5PCT@F@CK6?RAA>6CA3VHP=K6");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0671()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0672()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("32"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0673()
  {
    rc_float = (new BigDecimal("1")).floatValue();
    Assert.assertEquals(1.0F, rc_float, 0);
  }
  public void testItem_0674()
  {
    rc_BigDecimal = new BigDecimal(-2147483648, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0675()
  {
    rc_BigDecimal = (new BigDecimal("-2147483648")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0676()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0677()
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
  public void testItem_0678()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0679()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("5K3XWW63=CS;E7C@HIP9VYUFJ4BVMPL<WDVOJ7N<QCH49E:F;J>X<@I>03IEBGA8LBVBIFEBT7LI464:", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0680()
  {
    rc_MathContext = new MathContext(2147483647, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=2147483647 roundingMode=CEILING", rc_MathContext.toString());
  }
//  public void testItem_0681()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).movePointRight(2147483647);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0682()
  {
    rc_BigDecimal = (new BigDecimal("32")).remainder(new BigDecimal("32"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0683()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("H6BQSEY08XLAXA=WSQK5K0>EH6W4JAYHL;KQMWL=L<9DF?47T@3JIF943WD2S:VIW3S?846M1");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0684()
  {
    rc_float = (new BigDecimal("32")).floatValue();
    Assert.assertEquals(32.0F, rc_float, 0);
  }
  public void testItem_0685()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400", rc_BigDecimal.toString());
  }
  public void testItem_0686()
  {
    rc_BigDecimal = (new BigDecimal("0")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0687()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858400"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0688()
  {
    rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0689()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0690()
  {
    rc_MathContext = new MathContext(0, java.math.RoundingMode.CEILING);
    Assert.assertEquals("precision=0 roundingMode=CEILING", rc_MathContext.toString());
  }
  public void testItem_0691()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0692()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).remainder(new BigDecimal("2E+308"));
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0693()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0694()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).stripTrailingZeros();
    Assert.assertEquals("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368", rc_BigDecimal.toString());
  }
  public void testItem_0695()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\234', '8', '\0', '\234', '\234', '\234', '\1', '\uFFFF', '8', '\1', '\0', '8', '8', '\uFFFF', '\uFFFF', '8', '\0', '8', '\234', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\234', '\1', '\0', '\uFFFF', '8', '\0', '\234', '\0', '\234', '\uFFFF', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '\234', '\uFFFF', '8', '\0', '\1', '8', '\0', '\0', '\1', '\234', '\0', '\234', '8', '\uFFFF', '\uFFFF', '\1', '\234', '8', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\0', '\234', '\234', '\uFFFF', '\0', '\0', '\0', '\1', '8', '\uFFFF', '\234', '\uFFFF', '\0', '8', '\234', '\uFFFF', '\1', '8', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '8', '\1', '\0', '\uFFFF', '8', '8', '\0', '\0', '\0', '\0', '\0'}, -1, -2147483648, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0696()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divideToIntegralValue(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0697()
  {
    rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).divide(new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0698()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("179769313486231570814527423731704356798070567525844996598917476803157260780028538760589558632766878171540458953514382464234321326889464182768467546703537516986049910576551282076245490090389328944075868508455133942304583236903222948165808559332123348274797826204144723168738177180919299881250404026184124858368")).setScale(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0699()
  {
    rc_BigDecimal = (new BigDecimal("1")).movePointRight(-1);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0700()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\uFFFF'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0701()
  {
    rc_String = (new BigDecimal("1")).toEngineeringString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0702()
  {
    rc_short = (new BigDecimal("1")).shortValueExact();
    Assert.assertEquals(1, rc_short);
  }
//  public void testItem_0703()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0704()
  {
    rc_BigDecimal = (new BigDecimal("1")).pow(1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0705()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("0.1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0706()
  {
    rc_BigDecimal = (new BigDecimal("1")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0707()
  {
    rc_BigDecimal = new BigDecimal(1.7976931348623157E308, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+308", rc_BigDecimal.toString());
  }
  public void testItem_0708()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("0.1"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
//  public void testItem_0709()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("2E+308")).remainder(new BigDecimal("1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0710()
  {
    rc_BigDecimal = (new BigDecimal("1.1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0711()
  {
    rc_BigDecimal = (new BigDecimal("2E+308")).movePointRight(-1);
    Assert.assertEquals("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", rc_BigDecimal.toString());
  }
  public void testItem_0712()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0713()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0714()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0715()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("", new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0716()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0717()
  {
    rc_BigDecimal = (new BigDecimal("20000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")).stripTrailingZeros();
    Assert.assertEquals("2E+307", rc_BigDecimal.toString());
  }
  public void testItem_0718()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0719()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 2147483647, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E-2147483646", rc_BigDecimal.toString());
  }
  public void testItem_0720()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("3.2E-2147483646"));
    Assert.assertEquals("3.125E+2147483644", rc_BigDecimal.toString());
  }
  public void testItem_0721()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).multiply(new BigDecimal("3.2E-2147483646"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0722()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).divide(new BigDecimal("0.1"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0723()
  {
    rc_BigDecimal = (new BigDecimal("3.125E+2147483644")).scaleByPowerOfTen(-1);
    Assert.assertEquals("3.125E+2147483643", rc_BigDecimal.toString());
  }
//  public void testItem_0724()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigInteger = (new BigDecimal("3.125E+2147483644")).toBigIntegerExact();
//    }
//    catch (java.lang.OutOfMemoryError e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0725()
  {
    rc_BigDecimal = (new BigDecimal("3.2E-2147483646")).remainder(new BigDecimal("3.2E-2147483646"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2147483647", rc_BigDecimal.toString());
  }
  public void testItem_0726()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0727()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("0"), -1, java.math.RoundingMode.UP);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0728()
  {
    rc_BigDecimal = (new BigDecimal("3.125E+2147483644")).divideToIntegralValue(new BigDecimal("3.125E+2147483644"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0729()
  {
    rc_long = (new BigDecimal("0")).longValueExact();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0730()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0731()
  {
    rc_BigDecimal = (new BigDecimal("1")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0732()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).movePointLeft(0);
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0733()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0734()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0735()
  {
    rc_int = (new BigDecimal("0.1")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0736()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648);
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0737()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).setScale(2147483647, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0738()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '8', '\0', '\0', '\234', '\uFFFF', '\0', '\0', '8', '\1', '\uFFFF', '8', '\1', '8', '8', '8', '\uFFFF', '\1', '\1', '8', '\234', '\234', '\1', '\1', '\1', '\1', '\uFFFF', '8', '\1', '\uFFFF', '\0', '\234', '\1', '8', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\0', '\0', '\1', '\uFFFF', '\0', '\234', '8', '\1', '\0', '\uFFFF', '8', '\234', '8', '\uFFFF', '\234', '\234', '\uFFFF', '\1', '8', '\1', '\uFFFF', '8', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\234', '\1', '8', '\uFFFF', '\1', '\234', '\0', '8', '\uFFFF', '\1', '\234', '8', '\1', '\1', '\uFFFF', '\234', '\0', '\uFFFF', '\234', '\1', '\0', '\1', '\uFFFF', '\uFFFF', '\0', '8', '\234', '8', '\uFFFF', '\1', '\234'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0739()
//  {
//    boolean caught;
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).movePointRight(-1);
//    }
//    catch (java.lang.NegativeArraySizeException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//  }
  public void testItem_0740()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0741()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0.1")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0742()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("1.1"), java.math.RoundingMode.UNNECESSARY);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0743()
  {
    rc_BigDecimal = (new BigDecimal("0.1")).add(new BigDecimal("0"));
    Assert.assertEquals("0.1", rc_BigDecimal.toString());
  }
  public void testItem_0744()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0745()
  {
    rc_BigDecimal = (new BigDecimal("32")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0746()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("0.1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0747()
  {
    rc_String = (new BigDecimal("1")).toString();
    Assert.assertEquals("1", rc_String);
  }
  public void testItem_0748()
  {
    rc_BigDecimal = new BigDecimal(-1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0749()
  {
    rc_BigDecimal = (new BigDecimal("32")).multiply(new BigDecimal("1.1"));
    Assert.assertEquals("35.2", rc_BigDecimal.toString());
  }
  public void testItem_0750()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0751()
  {
    rc_BigDecimal = new BigDecimal(0L, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0752()
  {
    rc_BigDecimal = (new BigDecimal("1.1")).max(new BigDecimal("35.2"));
    Assert.assertEquals("35.2", rc_BigDecimal.toString());
  }
  public void testItem_0753()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0754()
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
  public void testItem_0755()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(-2147483648);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0756()
  {
    rc_BigDecimal = (new BigDecimal("1.1")).max(new BigDecimal("0.1"));
    Assert.assertEquals("1.1", rc_BigDecimal.toString());
  }
  public void testItem_0757()
  {
    boolean caught;
    caught = false;
    try {
      rc_byte = (new BigDecimal("1.1")).byteValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0758()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0759()
  {
    rc_BigInteger = (new BigDecimal("1.1")).unscaledValue();
    Assert.assertEquals("11", rc_BigInteger.toString());
  }
  public void testItem_0760()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '8', '\0', '8', '\234', '\uFFFF', '8', '8', '\1', '\1', '\uFFFF', '\1', '\1', '8', '\1', '8', '\1', '\0', '\0', '\uFFFF', '8', '\0', '\uFFFF', '\0', '\uFFFF', '8', '\uFFFF', '\uFFFF', '8', '8', '\0', '\1', '\uFFFF', '\uFFFF', '8', '\234', '\234', '\0', '\1', '\uFFFF', '\1', '\234', '\1', '\0', '\234', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '\uFFFF', '8', '\1', '\1', '\234', '\1', '\0', '8', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\1', '8', '\0', '\234', '\0', '\234', '\1', '\234', '\uFFFF', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '8', '\1', '\1', '\uFFFF', '\0', '\0', '\0', '8', '\1', '\234', '\0', '\234', '\0', '\uFFFF', '\1', '8', '8', '\1'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0761()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).scaleByPowerOfTen(-1);
    Assert.assertEquals("0.32", rc_BigDecimal.toString());
  }
  public void testItem_0762()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0763()
  {
    rc_double = (new BigDecimal("0.1")).doubleValue();
    Assert.assertEquals(0.1, rc_double, 0);
  }
  public void testItem_0764()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\1', '\1', '8', '8', '\234', '8', '\234', '\uFFFF', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\1', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '8', '\234', '\1', '8', '\234', '\0', '\234', '\1', '8', '8', '8', '\234', '8', '8', '8', '\234', '\1', '8', '8', '8', '\1', '\1', '\uFFFF', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\1', '8', '\0', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '8', '\uFFFF', '\1', '\1', '\0', '\234', '\234', '\0', '\uFFFF', '\0', '8', '\234', '\1', '8', '8', '\uFFFF', '8', '\uFFFF', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '\0', '\1', '\1', '\0', '\uFFFF', '\234', '\uFFFF', '\uFFFF', '\234', '\uFFFF', '\234', '\1', '\uFFFF', '\1', '\0', '\234', '\0', '\1', '8', '\0', '\0'}, 1, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0765()
  {
    rc_BigDecimal_array = (new BigDecimal("0.32")).divideAndRemainder(new BigDecimal("1.1"));
  }
//  public void testItem_0766()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("32")).divideToIntegralValue(new BigDecimal("0.32"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0767()
  {
    rc_BigDecimal = (new BigDecimal("0.32")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0768()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("0.32")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0769()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("CO7?WP15ASFCVO0CJQK5L8JEIGD;6W:=CH2V<1Y=@@HC?2E<H48G:I>0>FI7FWXYK3J4TGR=<XTQ>BK4JULV9K4IOYDT;", new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0770()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1.1"), 1);
    Assert.assertEquals("0E+1", rc_BigDecimal.toString());
  }
  public void testItem_0771()
  {
    rc_float = (new BigDecimal("0E+1")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0772()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).min(new BigDecimal("32"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0773()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0774()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("P3HIC7PU4R3WKPXUIIY>YFF9;L");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0775()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).subtract(new BigDecimal("0E+1"));
    Assert.assertEquals("1E+1", rc_BigDecimal.toString());
  }
  public void testItem_0776()
  {
    rc_BigDecimal = new BigDecimal(-1);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0777()
  {
    rc_int = (new BigDecimal("32")).intValue();
    Assert.assertEquals(32, rc_int);
  }
  public void testItem_0778()
  {
    rc_BigInteger = (new BigDecimal("1.1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0779()
  {
    rc_int = (new BigDecimal("32")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0780()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0781()
  {
    rc_BigDecimal_array = (new BigDecimal("1E+1")).divideAndRemainder(new BigDecimal("32"));
  }
  public void testItem_0782()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("EQK7:RUJ?JT<HWIABJ:YBJ><;4VC8IY4EMI3Q8");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0783()
  {
    rc_BigDecimal = new BigDecimal(1135879015891L);
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0784()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+1")).divide(new BigDecimal("1E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0785()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("1135879015891", rc_BigDecimal.toString());
  }
  public void testItem_0786()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891")).add(new BigDecimal("0.32"));
    Assert.assertEquals("1135879015891.32", rc_BigDecimal.toString());
  }
  public void testItem_0787()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.32")).multiply(new BigDecimal("32"));
    Assert.assertEquals("36348128508522.24", rc_BigDecimal.toString());
  }
  public void testItem_0788()
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
  public void testItem_0789()
  {
    rc_BigDecimal_array = (new BigDecimal("36348128508522.24")).divideAndRemainder(new BigDecimal("36348128508522.24"));
  }
  public void testItem_0790()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1135879015891.32")).divide(new BigDecimal("1E+1"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0791()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\1', '\uFFFF', '\0', '\234', '\1', '\uFFFF', '\uFFFF', '\234'}, 0, 1, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0792()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("1135879015891")).hashCode();
//    Assert.assertEquals(2107853717, rc_int);
//  }
  public void testItem_0793()
  {
    rc_BigDecimal = (new BigDecimal("1E+1")).add(new BigDecimal("32"));
    Assert.assertEquals("42", rc_BigDecimal.toString());
  }
  public void testItem_0794()
  {
    rc_BigInteger = (new BigDecimal("1E+1")).toBigIntegerExact();
    Assert.assertEquals("10", rc_BigInteger.toString());
  }
  public void testItem_0795()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.32")).divide(new BigDecimal("36348128508522.24"), 0);
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0796()
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
  public void testItem_0797()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0798()
  {
    rc_BigDecimal = (new BigDecimal("1135879015891.32")).pow(0);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0799()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).setScale(0, 1);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0800()
  {
    rc_long = (new BigDecimal("42")).longValue();
    Assert.assertEquals(42L, rc_long);
  }
  public void testItem_0801()
  {
    rc_String = (new BigDecimal("0.04")).toEngineeringString();
    Assert.assertEquals("0.04", rc_String);
  }
  public void testItem_0802()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 0);
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0803()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("1135879015891.32")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0804()
  {
    rc_boolean = (new BigDecimal("32")).equals("");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0805()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -2147483648, new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
  public void testItem_0806()
  {
    rc_BigDecimal_array = (new BigDecimal("0.04")).divideAndRemainder(new BigDecimal("32"));
  }
//  public void testItem_0807()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("0.04")).setScale(-2147483648, java.math.RoundingMode.DOWN);
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0808()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0809()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("0.04")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0810()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).plus();
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
//  public void testItem_0811()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).divideToIntegralValue(new BigDecimal("0.04"));
//    Assert.assertEquals("0E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0812()
  {
    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).stripTrailingZeros();
    Assert.assertEquals("3.2E+2147483649", rc_BigDecimal.toString());
  }
//  public void testItem_0813()
//  {
//    boolean caught;
//    rc_String = (new BigDecimal("320.0E+2147483647")).toString();
//    Assert.assertEquals("3.2E+2147483649", rc_String);
//  }
  public void testItem_0814()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).multiply(new BigDecimal("32"));
    Assert.assertEquals("1.28", rc_BigDecimal.toString());
  }
  public void testItem_0815()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).round(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0816()
  {
    rc_int = (new BigDecimal("0.04")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0817()
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
  public void testItem_0818()
  {
    rc_String = (new BigDecimal("1.28")).toPlainString();
    Assert.assertEquals("1.28", rc_String);
  }
  public void testItem_0819()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508522.24")).setScale(-1);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0820()
  {
    rc_String = (new BigDecimal("36348128508522.24")).toPlainString();
    Assert.assertEquals("36348128508522.24", rc_String);
  }
  public void testItem_0821()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0822()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("320.0E+2147483647")).ulp();
//    Assert.assertEquals("1E+2147483648", rc_BigDecimal.toString());
//  }
  public void testItem_0823()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("36348128508522.24")).divide(new BigDecimal("36348128508522.24"), -1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
//  public void testItem_0824()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).max(new BigDecimal("36348128508522.24"));
//    Assert.assertEquals("36348128508522.24", rc_BigDecimal.toString());
//    }
//  }
//  public void testItem_0825()
//  {
//    boolean caught;
//    rc_BigDecimal = (new BigDecimal("1E+2147483647")).movePointRight(-2147483648);
//    Assert.assertEquals("1", rc_BigDecimal.toString());
//  }
  public void testItem_0826()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1E+2147483647")).multiply(new BigDecimal("1E+2147483647"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0827()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).multiply(new BigDecimal("36348128508522.24"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1453925140340.8896", rc_BigDecimal.toString());
  }
  public void testItem_0828()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0829()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("0.04")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0830()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1453925140340.8896")).remainder(new BigDecimal("0.04"), new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0831()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0832()
  {
    rc_double = (new BigDecimal("0.04")).doubleValue();
    Assert.assertEquals(0.04, rc_double, 0);
  }
  public void testItem_0833()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0834()
  {
    rc_double = (new BigDecimal("1")).doubleValue();
    Assert.assertEquals(1.0, rc_double, 0);
  }
  public void testItem_0835()
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
  public void testItem_0836()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+2", rc_BigDecimal.toString());
  }
  public void testItem_0837()
  {
    rc_BigDecimal = (new BigDecimal("0.04")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0.04", rc_BigDecimal.toString());
  }
  public void testItem_0838()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("3E+2"), -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0839()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0840()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0841()
  {
    rc_BigDecimal = new BigDecimal(-1.0, new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0842()
  {
    rc_long = (new BigDecimal("3E+2")).longValue();
    Assert.assertEquals(300L, rc_long);
  }
  public void testItem_0843()
  {
    rc_byte = (new BigDecimal("-1")).byteValueExact();
    Assert.assertEquals(-1, rc_byte);
  }
  @SuppressWarnings("unlikely-arg-type")
  public void testItem_0844()
  {
    rc_boolean = (new BigDecimal("-1")).equals("<P8JM@S7F554XR2X;EG:LU=OM9X<D63OFRW;R8WRYTVLD7M6XNTGCL@ME5F2MA:;H8QJ@107>1K<8EB=K;RKWKPD9=;R<@SNX4PA");
    Assert.assertEquals(false, rc_boolean);
  }
  public void testItem_0845()
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
  public void testItem_0846()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("32"), -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0847()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0848()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0849()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("32")).divide(new BigDecimal("32"), 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0850()
  {
    rc_BigDecimal = (new BigDecimal("32")).abs(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0851()
  {
    rc_BigDecimal = (new BigDecimal("32")).min(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0852()
  {
    rc_BigDecimal = (new BigDecimal("32")).add(new BigDecimal("32"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0853()
  {
    rc_BigDecimal = (new BigDecimal("64")).min(new BigDecimal("64"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0854()
  {
    rc_BigDecimal = (new BigDecimal("64")).abs(new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0855()
  {
    rc_int = (new BigDecimal("32")).scale();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0856()
  {
    rc_BigDecimal = (new BigDecimal("32")).scaleByPowerOfTen(1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
//  public void testItem_0857()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("64")).hashCode();
//    Assert.assertEquals(1984, rc_int);
//  }
  public void testItem_0858()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext(":4@BC8RCDJAS;@T>98S;XIRA3XJMKYR@E?CF4OA:GLCLQ=D891E7>T=K1HUITQN<;HNOWL38YPCU:;6@OW6>KO::HKVNYYR<DC7F");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0859()
  {
    rc_long = (new BigDecimal("-1")).longValueExact();
    Assert.assertEquals(-1L, rc_long);
  }
  public void testItem_0860()
  {
    rc_long = (new BigDecimal("32")).longValue();
    Assert.assertEquals(32L, rc_long);
  }
  public void testItem_0861()
  {
    rc_String = (new BigDecimal("32")).toPlainString();
    Assert.assertEquals("32", rc_String);
  }
  public void testItem_0862()
  {
    rc_BigDecimal = (new BigDecimal("64")).subtract(new BigDecimal("32"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
//  public void testItem_0863()
//  {
//    boolean caught;
//    rc_int = (new BigDecimal("64")).hashCode();
//    Assert.assertEquals(1984, rc_int);
//  }
  public void testItem_0864()
  {
    rc_BigDecimal = (new BigDecimal("32")).plus();
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0865()
  {
    rc_int = (new BigDecimal("32")).compareTo(new BigDecimal("32"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0866()
  {
    rc_BigDecimal = new BigDecimal(-2147483648);
    Assert.assertEquals("-2147483648", rc_BigDecimal.toString());
  }
  public void testItem_0867()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0868()
  {
    rc_BigDecimal = (new BigDecimal("32")).setScale(-1, java.math.RoundingMode.UP);
    Assert.assertEquals("4E+1", rc_BigDecimal.toString());
  }
  public void testItem_0869()
  {
    rc_BigInteger = (new BigDecimal("3.2E+2")).unscaledValue();
    Assert.assertEquals("32", rc_BigInteger.toString());
  }
  public void testItem_0870()
  {
    rc_short = (new BigDecimal("64")).shortValueExact();
    Assert.assertEquals(64, rc_short);
  }
  public void testItem_0871()
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
  public void testItem_0872()
  {
    rc_BigDecimal = (new BigDecimal("-1")).plus(new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0873()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).multiply(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("1E+4", rc_BigDecimal.toString());
  }
  public void testItem_0874()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).remainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0875()
  {
    rc_double = (new BigDecimal("1E+4")).doubleValue();
    Assert.assertEquals(10000.0, rc_double, 0);
  }
  public void testItem_0876()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("1E+4"));
    Assert.assertEquals("10000", rc_BigDecimal.toString());
  }
  public void testItem_0877()
  {
    rc_BigDecimal = (new BigDecimal("3.2E+2")).negate(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("-3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0878()
  {
    rc_BigDecimal = (new BigDecimal("1E+4")).divideToIntegralValue(new BigDecimal("1E+4"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0879()
  {
    rc_BigDecimal = (new BigDecimal("64")).divide(new BigDecimal("3.2E+2"), java.math.RoundingMode.HALF_DOWN);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0880()
  {
    rc_long = (new BigDecimal("0")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0881()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0882()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\0', '\0', '\0', '\1', '\uFFFF', '\234', '\1', '\0', '8', '\1', '\234', '\uFFFF', '\0', '\0', '\1', '\0', '\0', '\1', '\uFFFF', '\1', '\uFFFF', '8', '\234', '8', '\234', '\uFFFF', '8', '8', '8', '\0', '8', '8', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\234', '\1', '\1', '\uFFFF', '8', '\uFFFF', '\234', '\234', '8'}, 0, 2147483647, new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0883()
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
  public void testItem_0884()
  {
    rc_String = (new BigDecimal("0")).toString();
    Assert.assertEquals("0", rc_String);
  }
  public void testItem_0885()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("CEU");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0886()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("3.2E+2"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("320", rc_BigDecimal.toString());
  }
  public void testItem_0887()
  {
    rc_BigDecimal = (new BigDecimal("64")).add(new BigDecimal("1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("65", rc_BigDecimal.toString());
  }
  public void testItem_0888()
  {
    rc_BigDecimal = (new BigDecimal("1")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0889()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("<J8L11MWQ;:5>XV=@ML<H<EE7BIWE>P=OFUITHOLHT=40HK2B@Q0G6V5X8AAU9C1JBCP;X4RL1Q", new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0890()
  {
    rc_String = (new BigDecimal("65")).toString();
    Assert.assertEquals("65", rc_String);
  }
  public void testItem_0891()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("64")).divideAndRemainder(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0892()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("R0JLN3<@9@>:W;B6Q=2;35YH9Y1TA2LXJ;=06KQ;JQI;NK6ELBY7D:BPII=AQFPEFJOIFIERKX4I1PS7MK3A>O2GLW1U3Y2?Y91M");
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0893()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("65")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0894()
  {
    rc_BigDecimal = (new BigDecimal("1")).stripTrailingZeros();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0895()
  {
    rc_short = (new BigDecimal("0")).shortValueExact();
    Assert.assertEquals(0, rc_short);
  }
  public void testItem_0896()
  {
    rc_BigDecimal = (new BigDecimal("1")).remainder(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0897()
  {
    rc_int = (new BigDecimal("0")).intValue();
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0898()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -2147483648, -1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0899()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("0"), 2147483647, 2147483647);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0900()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("1")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=2147483647 roundingMode=UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0901()
  {
    rc_BigDecimal = (new BigDecimal("65")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("7E+1", rc_BigDecimal.toString());
  }
  public void testItem_0902()
  {
    rc_String = (new BigDecimal("65")).toString();
    Assert.assertEquals("65", rc_String);
  }
  public void testItem_0903()
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
  public void testItem_0904()
  {
    rc_BigDecimal = (new BigDecimal("64")).stripTrailingZeros();
    Assert.assertEquals("64", rc_BigDecimal.toString());
  }
  public void testItem_0905()
  {
    rc_BigDecimal = new BigDecimal(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("2E+9", rc_BigDecimal.toString());
  }
  public void testItem_0906()
  {
    rc_String = (new BigDecimal("64")).toEngineeringString();
    Assert.assertEquals("64", rc_String);
  }
  public void testItem_0907()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("2E+9")).pow(2147483647);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0908()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0909()
  {
    rc_BigDecimal = (new BigDecimal("0")).multiply(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0910()
  {
    rc_BigDecimal = (new BigDecimal("1")).divide(new BigDecimal("1"), 1);
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0911()
  {
    rc_BigDecimal = (new BigDecimal("1")).ulp();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0912()
  {
    rc_String = (new BigDecimal("2E+9")).toPlainString();
    Assert.assertEquals("2000000000", rc_String);
  }
  public void testItem_0913()
  {
    rc_BigDecimal = new BigDecimal(4.9E-324, new MathContext("precision=2147483647 roundingMode=UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0914()
  {
    rc_BigDecimal = (new BigDecimal("0")).abs(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0915()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0916()
  {
    rc_String = (new BigDecimal("64")).toEngineeringString();
    Assert.assertEquals("64", rc_String);
  }
  public void testItem_0917()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal_array = (new BigDecimal("2E+9")).divideAndRemainder(new BigDecimal("0"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0918()
  {
    rc_short = (new BigDecimal("64")).shortValueExact();
    Assert.assertEquals(64, rc_short);
  }
  public void testItem_0919()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("0"));
    Assert.assertEquals(0, rc_int);
  }
  public void testItem_0920()
  {
    rc_BigDecimal = (new BigDecimal("0")).negate();
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0921()
  {
    rc_BigInteger = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).unscaledValue();
    Assert.assertEquals("4940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
  public void testItem_0922()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal("0T?TGU9E=S019S4C7GXOA4U=?LXNA5IGKIKLLEERRSJTAW4CAQMU8CD9=@LDNK79B0GEGE;OMAWKX;U1T>89?<@;ESYJ=T<=1KX3", new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0923()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).abs();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0924()
  {
    rc_BigDecimal = (new BigDecimal("0")).add(new BigDecimal("0"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0925()
  {
    rc_BigDecimal = new BigDecimal(-1L);
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0926()
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
  public void testItem_0927()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("64"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0928()
  {
    rc_BigDecimal_array = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divideAndRemainder(new BigDecimal("64"), new MathContext("precision=2147483647 roundingMode=UP"));
  }
  public void testItem_0929()
  {
    rc_String = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).toString();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_String);
  }
  public void testItem_0930()
  {
    rc_BigDecimal = (new BigDecimal("0")).divide(new BigDecimal("-1"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0931()
  {
    rc_BigDecimal = new BigDecimal(9223372036854775807L);
    Assert.assertEquals("9223372036854775807", rc_BigDecimal.toString());
  }
  public void testItem_0932()
  {
    rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("9223372036854775807"));
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0933()
  {
    rc_int = (new BigDecimal("0")).compareTo(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals(-1, rc_int);
  }
  public void testItem_0934()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("-1")).divide(new BigDecimal("9223372036854775807"), -2147483648, -1);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0935()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).signum();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0936()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).divideToIntegralValue(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0937()
  {
    boolean caught;
    caught = false;
    try {
      rc_short = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).shortValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0938()
  {
    rc_BigDecimal = (new BigDecimal("-1")).negate();
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0939()
  {
    rc_BigDecimal = (new BigDecimal("9223372036854775807")).plus(new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("9E+18", rc_BigDecimal.toString());
  }
  public void testItem_0940()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("0"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0941()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(1);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323", rc_BigDecimal.toString());
  }
  public void testItem_0942()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\1', '\234', '\234', '\234', '\234', '8', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\0', '8', '\uFFFF', '\uFFFF', '\uFFFF', '\1', '\uFFFF', '\0', '\0', '\1', '8', '\1', '\0', '\1', '\uFFFF', '8', '8', '\234', '\1', '\0', '\234', '\0', '8', '\uFFFF', '\0', '\1', '8', '8', '\1', '\0', '\0', '\0', '8', '8', '8', '\234', '8', '\234', '\uFFFF', '8', '\0', '8', '8', '\uFFFF', '\234', '\234', '\0', '\0', '\uFFFF', '\1', '\0', '\234', '\uFFFF', '\234', '8', '8', '\0', '8', '\1', '8', '\234', '\0', '\1', '\234', '\234', '\1', '\1', '\0', '\0', '\0', '\0', '\1', '\uFFFF', '\0', '8', '\0', '\1', '\uFFFF', '\uFFFF', '\234', '8', '\0', '\uFFFF', '\234', '\uFFFF', '\0', '\234', '\0'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0943()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234', '\0', '\1', '\uFFFF', '8', '\234', '8', '\0', '8', '\uFFFF', '\0', '\uFFFF', '\1', '\0', '\1', '\234', '8', '\0', '\234', '\1', '\uFFFF', '\234', '\234', '8', '\uFFFF', '\234', '8', '\0', '\234', '\0', '\uFFFF', '8', '\1', '\234', '\0', '\1', '\234', '\uFFFF', '\234', '\0', '\uFFFF', '\uFFFF', '\1', '\1'});
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0944()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\1', '8', '\0', '\234', '8', '8', '\1', '\uFFFF', '8', '\1', '8', '\1', '\1', '\1', '\uFFFF', '\1', '\234', '8', '\1', '\234', '8', '\234', '\0', '\uFFFF', '\234', '8', '8', '\234', '\1', '\0', '\0', '8', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '\uFFFF', '\0', '\1', '\uFFFF', '\0', '8', '\234', '\0', '\0', '\1', '\234', '\1', '\0', '\1', '\uFFFF', '8', '\0', '8', '8', '8', '\1', '\1', '8', '8', '8', '\234', '\0', '\0', '\uFFFF', '\0', '\uFFFF', '\1', '8', '8', '\1', '\uFFFF', '\0', '8', '8', '\1', '\0', '\234', '\1', '\0', '\uFFFF', '\uFFFF', '\234', '\0', '8', '\uFFFF', '\1', '8', '\uFFFF', '\234', '\1', '\uFFFF', '8', '\234', '\uFFFF', '\uFFFF', '\1', '8'}, 2147483647, 1);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0945()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).setScale(-1, java.math.RoundingMode.UNNECESSARY);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0946()
  {
    rc_float = (new BigDecimal("0")).floatValue();
    Assert.assertEquals(0.0F, rc_float, 0);
  }
  public void testItem_0947()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("0")).setScale(1, -2147483648);
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0948()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).divide(new BigDecimal("0"), java.math.RoundingMode.CEILING);
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0949()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), 1);
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0950()
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
  public void testItem_0951()
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
  public void testItem_0952()
  {
    rc_double = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).doubleValue();
    Assert.assertEquals(4.9E-323, rc_double, 0);
  }
  public void testItem_0953()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\234'}, -1, 2147483647);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0954()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).pow(2147483647, new MathContext("precision=1 roundingMode=HALF_UP"));
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0955()
  {
    boolean caught;
    caught = false;
    try {
      rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).intValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0956()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).plus();
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323", rc_BigDecimal.toString());
  }
  public void testItem_0957()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
    Assert.assertEquals("0E-1074", rc_BigDecimal.toString());
  }
  public void testItem_0958()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).round(new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324", rc_BigDecimal.toString());
  }
  public void testItem_0959()
  {
    rc_int = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scale();
    Assert.assertEquals(1074, rc_int);
  }
  public void testItem_0960()
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
  public void testItem_0961()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).scaleByPowerOfTen(2147483647);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E+2147483323", rc_BigDecimal.toString());
  }
  public void testItem_0962()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).abs();
    Assert.assertEquals("3.2", rc_BigDecimal.toString());
  }
  public void testItem_0963()
  {
    rc_BigDecimal = (new BigDecimal("3.2")).multiply(new BigDecimal("0E-1074"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0964()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'8', '\0', '\0', '\1', '\234', '\0', '8', '\0', '\0', '8', '8', '\234', '\1', '8', '\0', '8', '\1', '\234', '\234', '\uFFFF', '\234', '\234', '\0', '\234', '\1', '\1', '\1', '\1', '\0', '\1', '\1', '8', '\0', '\1', '\234', '\1', '\1', '\1', '\0', '\234', '\1', '\1', '\1', '\0', '\uFFFF', '8', '\uFFFF', '\1', '\234', '\0', '8', '8', '\234', '\0', '\234', '8', '\uFFFF', '8', '\1', '8', '\0', '\0', '\234', '\0', '8', '\uFFFF', '8', '8', '\uFFFF', '\0', '\0', '\1', '\234', '\1', '\uFFFF', '\0', '\0', '\0', '\uFFFF', '\uFFFF', '\0', '\1', '8', '\0', '\uFFFF', '\1', '\1', '8', '8', '\234', '8', '\1', '\1', '8', '8', '\1', '\1', '\1', '\1', '\uFFFF'}, new MathContext("precision=0 roundingMode=CEILING"));
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0965()
  {
    rc_BigDecimal_array = (new BigDecimal("-1")).divideAndRemainder(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"));
  }
  public void testItem_0966()
  {
    rc_long = (new BigDecimal("0E-1075")).longValue();
    Assert.assertEquals(0L, rc_long);
  }
  public void testItem_0967()
  {
    rc_BigDecimal = (new BigDecimal("-1")).setScale(1, java.math.RoundingMode.UP);
    Assert.assertEquals("-1.0", rc_BigDecimal.toString());
  }
  public void testItem_0968()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324")).movePointRight(1);
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323", rc_BigDecimal.toString());
  }
  public void testItem_0969()
  {
    rc_float = (new BigDecimal("-1")).floatValue();
    Assert.assertEquals(-1.0F, rc_float, 0);
  }
  public void testItem_0970()
  {
    rc_BigDecimal = new BigDecimal(0L);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0971()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).multiply(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-324"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E-2149", rc_BigDecimal.toString());
  }
  public void testItem_0972()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0973()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).add(new BigDecimal("0"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323", rc_BigDecimal.toString());
  }
  public void testItem_0974()
  {
    boolean caught;
    caught = false;
    try {
      rc_long = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).longValueExact();
    }
    catch (java.lang.ArithmeticException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0975()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).negate();
    Assert.assertEquals("0E-1075", rc_BigDecimal.toString());
  }
  public void testItem_0976()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).subtract(new BigDecimal("0E-1075"));
    Assert.assertEquals("4.94065645841246544176568792868221372365059802614324764425585682500675507270208751865299836361635992379796564695445717730926656710355939796398774796010781878126300713190311404527845817167848982103688718636056998730723050006387409153564984387312473397273169615140031715385398074126238565591171026658556686768187039560310624931945271591492455329305456544401127480129709999541931989409080416563324524757147869014726780159355238611550134803526493472019379026810710749170333222684475333572083243193609238289345836806010601150616980975307834227731832924790498252473077637592724787465608477820373446969953364701797267771758512566055119913150489110145103786273816725095583738973359899366480994116420570263709027924276754456522908753868250641971826553344726562500E-323", rc_BigDecimal.toString());
  }
  public void testItem_0977()
  {
    rc_BigDecimal = (new BigDecimal("0E-1075")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"), new MathContext("precision=0 roundingMode=HALF_UP"));
    Assert.assertEquals("4.94065645841246544176568792868221372365059802614324764425585682500675507270208751865299836361635992379796564695445717730926656710355939796398774796010781878126300713190311404527845817167848982103688718636056998730723050006387409153564984387312473397273169615140031715385398074126238565591171026658556686768187039560310624931945271591492455329305456544401127480129709999541931989409080416563324524757147869014726780159355238611550134803526493472019379026810710749170333222684475333572083243193609238289345836806010601150616980975307834227731832924790498252473077637592724787465608477820373446969953364701797267771758512566055119913150489110145103786273816725095583738973359899366480994116420570263709027924276754456522908753868250641971826553344726562500E-323", rc_BigDecimal.toString());
  }
  public void testItem_0978()
  {
    rc_BigDecimal = (new BigDecimal("4.94065645841246544176568792868221372365059802614324764425585682500675507270208751865299836361635992379796564695445717730926656710355939796398774796010781878126300713190311404527845817167848982103688718636056998730723050006387409153564984387312473397273169615140031715385398074126238565591171026658556686768187039560310624931945271591492455329305456544401127480129709999541931989409080416563324524757147869014726780159355238611550134803526493472019379026810710749170333222684475333572083243193609238289345836806010601150616980975307834227731832924790498252473077637592724787465608477820373446969953364701797267771758512566055119913150489110145103786273816725095583738973359899366480994116420570263709027924276754456522908753868250641971826553344726562500E-323")).min(new BigDecimal("4.94065645841246544176568792868221372365059802614324764425585682500675507270208751865299836361635992379796564695445717730926656710355939796398774796010781878126300713190311404527845817167848982103688718636056998730723050006387409153564984387312473397273169615140031715385398074126238565591171026658556686768187039560310624931945271591492455329305456544401127480129709999541931989409080416563324524757147869014726780159355238611550134803526493472019379026810710749170333222684475333572083243193609238289345836806010601150616980975307834227731832924790498252473077637592724787465608477820373446969953364701797267771758512566055119913150489110145103786273816725095583738973359899366480994116420570263709027924276754456522908753868250641971826553344726562500E-323"));
    Assert.assertEquals("4.94065645841246544176568792868221372365059802614324764425585682500675507270208751865299836361635992379796564695445717730926656710355939796398774796010781878126300713190311404527845817167848982103688718636056998730723050006387409153564984387312473397273169615140031715385398074126238565591171026658556686768187039560310624931945271591492455329305456544401127480129709999541931989409080416563324524757147869014726780159355238611550134803526493472019379026810710749170333222684475333572083243193609238289345836806010601150616980975307834227731832924790498252473077637592724787465608477820373446969953364701797267771758512566055119913150489110145103786273816725095583738973359899366480994116420570263709027924276754456522908753868250641971826553344726562500E-323", rc_BigDecimal.toString());
  }
//  public void testItem_0979()
//  {
//    boolean caught;
//    if (!Boolean.getBoolean("notanerror"))
//    {
//    caught = false;
//    try {
//      rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"), new MathContext("precision=2147483647 roundingMode=UP"));
//    }
//    catch (java.lang.ArithmeticException e) {
//      caught = true;
//    }
//    Assert.assertEquals("91.94630872483222%", true, caught);
//    }
//  }
  public void testItem_0980()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("32", rc_BigDecimal.toString());
  }
  public void testItem_0981()
  {
    rc_BigDecimal = (new BigDecimal("32")).subtract(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("3E+1", rc_BigDecimal.toString());
  }
  public void testItem_0982()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"), new MathContext("precision=0 roundingMode=CEILING"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0983()
  {
    rc_BigDecimal = new BigDecimal(new java.math.BigInteger("32"), -1);
    Assert.assertEquals("3.2E+2", rc_BigDecimal.toString());
  }
  public void testItem_0984()
  {
    rc_BigDecimal_array = (new BigDecimal("3.2E+2")).divideAndRemainder(new BigDecimal("32"), new MathContext("precision=1 roundingMode=HALF_UP"));
  }
  public void testItem_0985()
  {
    rc_int = (new BigDecimal("1")).intValueExact();
    Assert.assertEquals(1, rc_int);
  }
  public void testItem_0986()
  {
    rc_BigDecimal = new BigDecimal(0);
    Assert.assertEquals("0", rc_BigDecimal.toString());
  }
  public void testItem_0987()
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
  public void testItem_0988()
  {
    rc_BigDecimal = (new BigDecimal("1")).add(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"));
    Assert.assertEquals("1.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigDecimal.toString());
  }
  public void testItem_0989()
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
  public void testItem_0990()
  {
    rc_BigInteger = (new BigDecimal("-1")).unscaledValue();
    Assert.assertEquals("-1", rc_BigInteger.toString());
  }
  public void testItem_0991()
  {
    rc_BigInteger = (new BigDecimal("1")).toBigInteger();
    Assert.assertEquals("1", rc_BigInteger.toString());
  }
  public void testItem_0992()
  {
    rc_BigDecimal = (new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323")).divideToIntegralValue(new BigDecimal("4.940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625E-323"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0993()
  {
    boolean caught;
    caught = false;
    try {
      rc_MathContext = new MathContext("JUJ=HD=TP91MDFWLBSKVC1;NO?RTN72RC>V?O:RC3RA7OIY=?GEE:M6SHP8?M8>X0;?V4=NOVQ8I<4NTNJ@7EP;;M");
    }
    catch (java.lang.IllegalArgumentException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0994()
  {
    rc_BigDecimal = (new BigDecimal("0")).max(new BigDecimal("1"));
    Assert.assertEquals("1", rc_BigDecimal.toString());
  }
  public void testItem_0995()
  {
    rc_BigDecimal = (new BigDecimal("-1")).stripTrailingZeros();
    Assert.assertEquals("-1", rc_BigDecimal.toString());
  }
  public void testItem_0996()
  {
    boolean caught;
    caught = false;
    try {
      rc_BigDecimal = new BigDecimal(new char[]{'\1', '\uFFFF', '\234', '\1', '\1', '\0', '8', '8', '8', '\0', '\1', '\0', '\1', '\1', '\0', '\uFFFF', '8', '8', '\234', '\0', '\234', '\0', '\1', '8', '8', '\234', '\1', '\234', '\234', '\uFFFF', '\1', '\234', '\234', '\1', '\1', '\234', '8', '\0', '\234', '\uFFFF', '\0', '\1', '\0', '\0', '\uFFFF', '8', '\1', '8', '\uFFFF', '8', '\234', '\uFFFF', '\1', '\uFFFF', '8', '\1', '\0'}, 0, -2147483648);
    }
    catch (java.lang.NumberFormatException e) {
      caught = true;
    }
    Assert.assertEquals("91.94630872483222%", true, caught);
  }
  public void testItem_0997()
  {
    rc_MathContext = new MathContext(2147483647);
    Assert.assertEquals("precision=2147483647 roundingMode=HALF_UP", rc_MathContext.toString());
  }
  public void testItem_0998()
  {
    rc_BigDecimal = (new BigDecimal("-1")).divideToIntegralValue(new BigDecimal("1.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625"), new MathContext("precision=1 roundingMode=HALF_UP"));
    Assert.assertEquals("0E+1073", rc_BigDecimal.toString());
  }
  public void testItem_0999()
  {
    rc_BigInteger = (new BigDecimal("1.00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625")).unscaledValue();
    Assert.assertEquals("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004940656458412465441765687928682213723650598026143247644255856825006755072702087518652998363616359923797965646954457177309266567103559397963987747960107818781263007131903114045278458171678489821036887186360569987307230500063874091535649843873124733972731696151400317153853980741262385655911710266585566867681870395603106249319452715914924553293054565444011274801297099995419319894090804165633245247571478690147267801593552386115501348035264934720193790268107107491703332226844753335720832431936092382893458368060106011506169809753078342277318329247904982524730776375927247874656084778203734469699533647017972677717585125660551199131504891101451037862738167250955837389733598993664809941164205702637090279242767544565229087538682506419718265533447265625", rc_BigInteger.toString());
  }
}
